package com.wxl.jxlStu;

import java.awt.print.PrinterException;

import javax.swing.JTable;


public class testJXL {

	public static void main(String[] args) throws PrinterException {
		String[][] content = {
				{"A","B","C"},
				{"D","E","F"}
		};
		
		String[] header = {"col_1","col_2","col_3"};
		
		JTable table = new JTable(content, header);
		
		String tcontent="<table border='1' bgColor='red'><tr><td>发送一个表格</td></tr></table>";
		
		System.out.println(tcontent + "\r\n" + " test");
		
	}

}
