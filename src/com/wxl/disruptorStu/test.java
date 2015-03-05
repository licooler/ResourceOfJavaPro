package com.wxl.disruptorStu;

public class test {
	public static void main(String[] args) {
//        PersonHelper.start();
//        for(int i=0 ; i<20; i++){
//            Person p = new Person("test_"+i, i , "男", "1234566"+i);
//
//            //生产者生产数据
//            PersonHelper.produce(p);
//        }
		
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
