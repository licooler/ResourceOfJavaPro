package com.wxl.URLStu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class test {
//	现在所有访问http://40.40.47.192:7777/b2bStdTopupWeb的都会跳到180.168.168.84 10107 再映射进来 10.48.170.101 80
//  中行专线 http://40.40.47.192:7777/b2bStdTopupWeb
//	public static String url="http://10.48.196.230:8180/b2bStdTopupWeb";
//	public static String url="http://10.48.171.162:8080/b2bStdTopupWeb/cmbc";
//	public static String url="http://180.168.168.85:11480/b2bStdTopupWeb";
//	public static String url="http://10.48.170.105/b2bStdTopupWeb";
//	public static String url="http://10.48.172.157/b2bStdTopupWeb";
//	public static String url="http://10.48.172.157:8080/mmsB2bStdTopupWeb";
	public static String url="http://10.48.171.214:8080/icsB2bStdTopupWeb";
	
//	public static String url="http://10.48.193.221:9280/b2bStdTopupWeb";
//  public static String url="http://10.48.196.230:8180/b2bStdTopupWeb";
	public static String key="p9e2qou8ifxrrxmlaqe3kw4e";
//	public static String key="cmbc-bbc-99wuxian";
	
//	public static String url="http://localhost:8080/b2bStdTopupWeb";
//	public static String key="localhost-843884773847";
	
	private void req(String url) {
		URLConnection rulConnection;
		//test
		try {
			URL myUrl = new URL(url);
			rulConnection = myUrl.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
			// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
			// http正文内，因此需要设为true, 默认情况下是false;
			httpUrlConnection.setDoOutput(true);
			// 设置是否从httpUrlConnection读入，默认情况下是true;
			httpUrlConnection.setDoInput(true);
			// Post 请求不能使用缓存
			httpUrlConnection.setUseCaches(false);

			// 设定传送的内容类型是可序列化的java对象
			// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
			httpUrlConnection.setRequestProperty("Content-type","application/x-java-serialized-object");
			// 设定请求的方法为"POST"，默认是GET
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.connect();

//			OutputStream outStrm = httpUrlConnection.getOutputStream();
//			// 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象。
//			ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm);
//			// 向对象输出流写出数据，这些数据将存到内存缓冲区中
//			objOutputStrm.writeObject(new String("我是测试数据"));
//			// 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream）
//			objOutputStrm.flush();
//			// 关闭流对象。此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中,
//			objOutputStrm.close();
			BufferedReader inss = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
			String line = null;
			StringBuffer content = new StringBuffer();
			while ((line = inss.readLine()) != null) {// line为返回值，这就可以判断是否成功、
				content.append(line);
			}
			inss.close();
			url = null;
			
			System.out.println(content.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testMobile() {
	
		
		url = url+"/mobile.do?";
		  String merId="D0062";
		  String mdseCode="Z0211092908a";
		  String departmentId="D9998";
		  String reserveInfo="reserveInfosds";
		  String activityCode = StringUtils.trimToEmpty("10683");
		  String orderId=""+System.currentTimeMillis();
		/**
		 * 格式yyyyMMdd,如果没有记账日采用自然日
		 */
		  String settleDate="20140120";
		/**
		 * 充值手机号
		 */
		  String phone="15606530129";
		/**
		 * 充值面值，单位元，如100,50等
		 */
		  String parValue="100";
		  String  discountAmount="98"+System.currentTimeMillis()%3;
		  String  discountCode="A"+System.currentTimeMillis()%3;
		  
		  MD5Util md5Util = new MD5Util();
		  String sign = md5Util.getMD5ofStr(
				  merId+
				  activityCode+
				  orderId+
				  settleDate+
				  phone+
				  parValue+
				  reserveInfo+
				  departmentId+
				  mdseCode+
				  discountAmount+
				  discountCode+
				  key);
//		  String sign="jjfhdfhdfdjkkjkjkjgh";
		  
		  url=url+"merId="+merId+"&reserveInfo="+reserveInfo+"&departmentId="+departmentId+"&mdseCode="+mdseCode+"&activityCode="+activityCode+"&orderId="+orderId+"&settleDate="+settleDate+"&phone="+phone+"&parValue="+parValue+"&sign="+sign+"&discountAmount="+discountAmount+"&discountCode="+discountCode;
//		  System.out.println(url);
		this.req(url);
	}
	
	
}
