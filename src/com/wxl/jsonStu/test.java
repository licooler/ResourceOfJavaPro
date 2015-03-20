package com.wxl.jsonStu;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import com.wxl.jsonStu.Person.Person;
import com.wxl.jsonStu.Person.StuHis;

public class test {
	 public static void main(String[] args) {
		 
//		String data = "{\"detailId\":\"10000\",\"handleOrderId\":\"12345\"}";
//		try {
//			JSONObject json = new JSONObject(data);
//			System.out.println(json.get("detailId"));
//			String array = json.getString("detailId");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		 
		Person p = new Person();
		System.out.println("test");
//		PersonJson test = new PersonJson();
//		String json = null;
//		for (int i = 0; i < 2; i++) {
//			p = new Person("test_" + i, i);
//			List<StuHis> stuHis = new ArrayList<StuHis>();
//			for(int j = 0 ; j < 5 ; j++){
//				StuHis his = new StuHis("------" + j, "xxxxxxx" + j);
//				stuHis.add(his);
//			}
//			p.setStuHis(stuHis);
//			json = test.toJson(p);
//			System.out.println(json = test.toJson(p));
//		}
//		System.out.println(json);
//		Person newp = test.fromJson(json);
//		System.out.println("name="+newp.getName() + ",age="+newp.getAge()
//				+",stuDate="+newp.getStuHis().get(0).getStuDate()
//				+",stuLocal="+newp.getStuHis().get(0).getStuLocal());
		
//		try {
//			System.out.println(test.jsonTest());
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		 PersonJson t = new PersonJson();
//		 if(t == null){
//			 System.out.println("is null");
//		 }else{
//			 System.out.println("not null");
//		}
		
		p.setAge(1);
		p.setStuHis(null);
		if(p == null){
			System.out.println("p is null");
		}
		if(p.getStuHis().isEmpty()||p.getStuHis().size() == 0){
			System.out.println("no his");
		}
	 }
}
