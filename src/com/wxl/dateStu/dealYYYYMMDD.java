package com.wxl.dateStu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dealYYYYMMDD {
	
	/*
	 * 处理YYYYMMDD类型日期
	 */
	public void dealDate(String startDate, String endDate){
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String start = startDate;
			String end = endDate;
			Date date = null;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(format.parse(start));
			//按月的日期递增一
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
			//Calendar类型装换成Date类型
			date = calendar.getTime();
			//按格式输出日期
			end = format.format(date);
			
			System.out.println(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获得两个时间中的差值
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
