package com.wxl.URLStu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class test {
//	�������з���http://40.40.47.192:7777/b2bStdTopupWeb�Ķ�������180.168.168.84 10107 ��ӳ����� 10.48.170.101 80
//  ����ר�� http://40.40.47.192:7777/b2bStdTopupWeb
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
			// �����Ƿ���httpUrlConnection�������Ϊ�����post���󣬲���Ҫ����
			// http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false;
			httpUrlConnection.setDoOutput(true);
			// �����Ƿ��httpUrlConnection���룬Ĭ���������true;
			httpUrlConnection.setDoInput(true);
			// Post ������ʹ�û���
			httpUrlConnection.setUseCaches(false);

			// �趨���͵����������ǿ����л���java����
			// (����������,�ڴ������л�����ʱ,��WEB����Ĭ�ϵĲ�����������ʱ������java.io.EOFException)
			httpUrlConnection.setRequestProperty("Content-type","application/x-java-serialized-object");
			// �趨����ķ���Ϊ"POST"��Ĭ����GET
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.connect();

//			OutputStream outStrm = httpUrlConnection.getOutputStream();
//			// ����ͨ����������󹹽����������������ʵ����������л��Ķ���
//			ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm);
//			// ����������д�����ݣ���Щ���ݽ��浽�ڴ滺������
//			objOutputStrm.writeObject(new String("���ǲ�������"));
//			// ˢ�¶�������������κ��ֽڶ�д��Ǳ�ڵ����У�Щ��ΪObjectOutputStream��
//			objOutputStrm.flush();
//			// �ر������󡣴�ʱ������������������д���κ����ݣ���ǰд������ݴ������ڴ滺������,
//			objOutputStrm.close();
			BufferedReader inss = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
			String line = null;
			StringBuffer content = new StringBuffer();
			while ((line = inss.readLine()) != null) {// lineΪ����ֵ����Ϳ����ж��Ƿ�ɹ���
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
		 * ��ʽyyyyMMdd,���û�м����ղ�����Ȼ��
		 */
		  String settleDate="20140120";
		/**
		 * ��ֵ�ֻ���
		 */
		  String phone="15606530129";
		/**
		 * ��ֵ��ֵ����λԪ����100,50��
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
