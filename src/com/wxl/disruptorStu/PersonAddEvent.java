package com.wxl.disruptorStu;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class PersonAddEvent {
	private static PersonAddEvent instance;
	
	//环RingBuffer的容量，取值为2的N次方
	private static final int BUFFER_SIZE = 256;
	private RingBuffer<PersonEvent> ringBuffer;
//	private SequenceBarrier sequenceBarrier;
//	private PersonEventHandler handler;
//	private BatchEventProcessor<PersonEvent> batchEventProcessor;
	
	private Executor executor = Executors.newCachedThreadPool();
	
	private int worker = 5;
	
	private int i=0;
	
	public PersonAddEvent(){
		System.out.println("---------------- init begin");
		Disruptor<PersonEvent> disruptor = new Disruptor<PersonEvent>(
				PersonEvent.EVENT_FACTORY, BUFFER_SIZE, this.executor,
				ProducerType.MULTI, new BlockingWaitStrategy());
		//单线程处理,handler需要继承EventHandler
//		PersonEventHandler work = new PersonEventHandler();
//		disruptor.handleEventsWith(work);
//		disruptor.start();
//		ringBuffer = disruptor.getRingBuffer();
		
		//多线程处理,handler需要继承WorkHandler
		PersonEventHandler[] work = new PersonEventHandler[this.worker];
		for(int n=0; n < this.worker ; n++){
			work[n] = new PersonEventHandler();
		}
		disruptor.handleEventsWithWorkerPool(work);
		disruptor.start();
		ringBuffer = disruptor.getRingBuffer(); 
		
		//自动线程调用，定时往ring中添加任务
//		System.out.println(" thread start : ");
//		Thread thread = new Thread(){
//			public void run(){
//				boolean flag = true;
//				System.out.println(" ring begin :");
//				while(flag){
//					try {
//						Thread.sleep(5*1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("--------i=" + i);
//					int j = i++;
//					addPersonEvent(i);
//					
//					if(j==10){
//						flag = false;
//					}
//				}
//				
//			}
//		};
//		
//		thread.start();
		
		System.out.println("---------------- init end");
	}
	
	//函数： 负责发布任务到Disruptor中
	public void addPersonEvent(int i){
		System.out.println("--add person event begin!,i=" + i);
		final int j = i;
		boolean bb = this.ringBuffer.tryPublishEvent(new EventTranslator<PersonEvent>() {
			
			@Override
			public void translateTo(PersonEvent event, long sequence) {
				Person p = new Person("test_"+j, j , "男", "----"+j);
				event.setPerson(p);
			}
		});
		
		System.out.println("add person event end !! status = " + bb + "-------- i=" + i);
	}
	
	public static void start(){
		instance = new PersonAddEvent();
	}
}
