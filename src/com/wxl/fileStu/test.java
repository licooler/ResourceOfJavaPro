package com.wxl.fileStu;

import org.apache.commons.lang.StringUtils;


public class test {
	private static String staticPath = "staticFiles";
	private static String fileName = "FileIO.txt";
	public static void main(String[] args) {
		
//		try {
//			File file = new File("");
//			
//			String path = file.getCanonicalPath() + File.separator 
//					+ staticPath + File.separator + fileName;
//			
//			InputStream in = new FileInputStream(new File(path));
//			int temp;
//			System.out.println("input stream!");
//			while((temp=in.read()) != -1){
//				System.out.print((char)temp);
//				System.out.print("(" + temp + ") ");
//			}
//			System.out.print("\n");
//			
//			in = new FileInputStream(new File(path));
//			InputStreamReader re = new InputStreamReader(in);
//			System.out.println("input stream reader!");
//			while((temp = re.read()) != -1){
//				System.out.print((char)temp);
//				System.out.print("(" + temp + ") ");
//			}
//			System.out.println("");
//			
//			in = new FileInputStream(new File(path));
//			re = new InputStreamReader(in);
//			BufferedReader bf = new BufferedReader(re);
//			System.out.println("buffered reader!");
//			String txt = "";
//			while((txt = bf.readLine()) != null){
//				System.out.println(txt);
//			}
//			
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String a = null;
		if(StringUtils.trimToEmpty(a).equals("")){
			System.out.println("null");
		}else{
			System.out.println("not null");
		}
		
	}
}
