package com.wxl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wxl.disruptorStu.PersonAddEvent;

public class stuOfTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDisruptor(){
		//junit���ȣ����ڳ���ûִ����ͽ������� ��Ӧ���е�test.java
		
		//�������Զ�ѭ��ʱ��ʼ������
		//ringBuffer��ʼ������ʼִ������
//		PersonAddEvent.start();
		
		//���߳�ʱ�����÷������ϼ����¼�
		PersonAddEvent test = new PersonAddEvent();
		int i = 0;
		while(i<10){
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//ÿ�ε�����������
			test.addPersonEvent(i);
			i++;
		}
		System.out.println("---------main is end !!!!");
	}

}
