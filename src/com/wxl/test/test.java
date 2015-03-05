package com.wxl.test;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) {
//		int a = 10377;
//		DecimalFormat df = new DecimalFormat("####.###");
//		System.out.println((double)a/100);
		String line = "15915433333";
		String rex = "^1[0-9]/d{9}$";
		Pattern pa = Pattern.compile(rex);
		Matcher m = pa.matcher(line);
		System.out.println(m.find());
	}
}
