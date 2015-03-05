package com.wxl.fileStu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test {
	private static String path = "";
	public static void main(String[] args) {
		
		InputStream in;
		try {
			File file = new File(path);
			in = new FileInputStream(file);
			int temp;
			while((temp=in.read()) != -1){
				System.out.println(temp);
			}
			
			InputStreamReader re = new InputStreamReader(in);
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
