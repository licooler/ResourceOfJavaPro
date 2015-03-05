package com.wxl.disruptorStu;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class PersonHelper {
	private static PersonHelper instance;
	private static boolean inited = false;
	/**
	 * ringBuffer��������������2��N�η�
	 */
	private static final int BUFFER_SIZE = 256;
	private RingBuffer<PersonEvent> ringBuffer;
	private SequenceBarrier sequenceBarrier;
	private EventHandler<PersonEvent> handler;
	private BatchEventProcessor<PersonEvent> batchEventProcessor;
	
	private Executor executor = Executors.newCachedThreadPool();

	public PersonHelper() {
		// ����1 �¼�
		// ����2 ���߳�ʹ��
		// ����3 �ȴ�����
		Disruptor<PersonEvent> disruptor = new Disruptor<PersonEvent>( PersonEvent.EVENT_FACTORY, BUFFER_SIZE, this.executor, 
				ProducerType.MULTI, new BlockingWaitStrategy());
		disruptor.start();
		ringBuffer = disruptor.getRingBuffer(); 
		
//		ringBuffer = new RingBuffer<PersonEvent>(PersonEvent.EVENT_FACTORY,
//				new SingleThreadedClaimStrategy(BUFFER_SIZE),
//				new YieldingWaitStrategy());
		
		// ��ȡ�����ߵ�λ����Ϣ
		sequenceBarrier = ringBuffer.newBarrier();
		// ������
//		handler = new PersonEventHandler();
		//ʹ���¼���������������ȵ�handler�Ǽ̳���EventHandler
		handler = (EventHandler<PersonEvent>) new PersonEventHandler();
		// �¼������������ָ��ringBuffer,������ʱָ֪ͨ��handler���д���
		batchEventProcessor = new BatchEventProcessor<PersonEvent>(ringBuffer,sequenceBarrier, handler);
		// ���������������̵߳����
		ringBuffer.addGatingSequences(batchEventProcessor.getSequence());

	}

	/**
	 * �����������̣߳�ʵ���ϵ�����AudioDataEventHandler�е�onEvent�������д���
	 */
	public static void start() {
		instance = new PersonHelper();
		Thread thread = new Thread(instance.batchEventProcessor);
		thread.start();
		inited = true;
	}

	/**
	 * ֹͣ
	 */
	public static void shutdown() {
		if (!inited) {
			throw new RuntimeException("EncodeHelper��û�г�ʼ����");
		} else {
			instance.doHalt();
		}
	}

	private void doHalt() {
		batchEventProcessor.halt();
	}

	private void doProduce(Person person) {
		// ��ȡ��һ�����
		long sequence = ringBuffer.next();
		// д������
		ringBuffer.get(sequence).setPerson(person);
		// ֪ͨ�����߸���Դ����������
		ringBuffer.publish(sequence);
	}

	/**
	 * ������ѹ����������
	 * 
	 * @param data
	 */
	public static void produce(Person person) {
		if (!inited) {
			throw new RuntimeException("EncodeHelper��û�г�ʼ����");
		} else {
			System.out.println("������ѹ����������----- person = " + person.getName());
			instance.doProduce(person);
		}
	}
	
	

}
