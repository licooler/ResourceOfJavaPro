package com.wxl.dateStu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dealYYYYMMDD {
	
	/*
	 * ����YYYYMMDD��������
	 */
	public void dealDate(String startDate, String endDate){
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String start = startDate;
			String end = endDate;
			Date date = null;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(format.parse(start));
			//���µ����ڵ���һ
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
			//Calendar����װ����Date����
			date = calendar.getTime();
			//����ʽ�������
			end = format.format(date);
			
			System.out.println(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * �������ʱ���еĲ�ֵ
	 */
	public long timeDiff(Date a, Date b){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	    long diff = a.getTime() - b.getTime();
		
		return diff;
	}
	
	public static void main(String[] args) {
		dealYYYYMMDD test = new dealYYYYMMDD();
		
		test.dealDate("20150101", "20150105");
	}

}
