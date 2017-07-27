package com.wxl.test;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
//		int a = 10377;
//		DecimalFormat df = new DecimalFormat("####.###");
//		System.out.println((double)a/100);
//		String line = "15915433333";
//		String rex = "^1[0-9]/d{9}$";
//		Pattern pa = Pattern.compile(rex);
//		Matcher m = pa.matcher(line);
//		System.out.println(m.find());
		
		
//		List<String> list = new ArrayList<String>();
		
		long t  = Long.MAX_VALUE;
		long timeStamp1 = Long.valueOf("9223370602204131807");
		String timestamp2 = String.valueOf(Long.MAX_VALUE - timeStamp1); 
		System.out.println("t:" + t);
		System.out.println("timestamp2:" + timestamp2);
	}
}
