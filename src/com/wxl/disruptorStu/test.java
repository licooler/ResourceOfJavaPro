package com.wxl.disruptorStu;

public class test {
	public static void main(String[] args) {
//        PersonHelper.start();
//        for(int i=0 ; i<20; i++){
//            Person p = new Person("test_"+i, i , "��", "1234566"+i);
//
//            //��������������
//            PersonHelper.produce(p);
//        }
		
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
