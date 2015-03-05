package com.wxl.disruptorStu;

import com.lmax.disruptor.WorkHandler;

/**
 * �����¼���������
 */
public class PersonEventHandler  implements WorkHandler<PersonEvent>{
    
    public PersonEventHandler(){
//        DataSendHelper.start();
    }
    
    //�̳���EventHandlerʱ����д���з���
//    public void onEvent(PersonEvent event, long sequence, boolean endOfBatch)
//            throws Exception {
//    	System.out.println("-------------------handler start--------" + sequence);
//    	Thread.sleep(20*1000);
//    	Person person = event.getPerson();
//		System.out.println("name = "+person.getName()+", age = "+ person.getAge()+", gender = "
//				+ person.getGender() +", mobile = "+person.getMobile()
//				+ ", sequence = " + sequence);  
//         
//    }

    // �̳���WorkHandlerʱ����д���з���
	@Override
	public void onEvent(PersonEvent event) throws Exception {
    	System.out.println("-------------------handler start--------"
    						+ event.getPerson().getAge());
    	Thread.sleep(20*1000);
    	Person person = event.getPerson();
		System.out.println("name = "+person.getName()+", age = "+ person.getAge()+", gender = "
				+ person.getGender() +", mobile = "+person.getMobile()
				+ ", sequence = " + event.getPerson().getAge());  
	}

}