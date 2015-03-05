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
		//junit调度，会在程序没执行完就结束，用 对应包中的test.java
		
		//单例，自动循环时初始化单例
		//ringBuffer初始化，开始执行任务
//		PersonAddEvent.start();
		
		//多线程时，调用方法不断加入事件
		PersonAddEvent test = new PersonAddEvent();
		int i = 0;
		while(i<10){
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//每次调度增加事物
			test.addPersonEvent(i);
			i++;
		}
		System.out.println("---------main is end !!!!");
	}

}
