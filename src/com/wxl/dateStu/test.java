package com.wxl.dateStu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {
	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date str1 = sdf.parse("20140703");
//		Date str2 = sdf.parse("20140802");
//		System.out.println(str1.getTime() + 24*60*60*1000);
//		System.out.println("201407031234".substring(0,8));
		
		
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(str1);
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));// 今天的日期
//		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) + 1);// 让日期加1
//		System.out.println(calendar.get(Calendar.DATE));// 加1之后的日期Top
//		Date date = calendar.getTime();
		
//		System.out.println(sdf.format(date));
		
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//		String startDate = "20140703";
//		String endDate = "20140704";
//		
//		List<String> dateList = new ArrayList<String>();
//		
//		do{
//			dateList.add(startDate);
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(format.parse(startDate));
//			calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) + 1);// 让日期加1
//			Date date = calendar.getTime();
//			startDate = format.format(date);
//		}while(!startDate.equalsIgnoreCase(endDate));
//		
////		dateList.add(endDate);
//		
//		for(String i : dateList){
//			System.out.println(i.toString());
//		}
		
		
		long t1 = System.currentTimeMillis();
		long t2 = t1 + 2*60*60*1000;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date1 = new Date(t1);
		String start = format.format(date1);
		Date date2 = new Date(t2);
		String end = format.format(date2);
		
		System.out.println(start + "\r\n" + end);
		
	}
}
