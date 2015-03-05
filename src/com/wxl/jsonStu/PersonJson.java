package com.wxl.jsonStu;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wxl.jsonStu.Person.Person;

public class PersonJson {
	private Gson gson;
	private String json;
	public PersonJson() {
		gson = new Gson();
	}
	
	public String toJson(Person p){
		json = gson.toJson(p);
		return json;
	}
	
	public Person fromJson(String json){
		Person p = new Person();
		p = gson.fromJson(json, new TypeToken<Person>() {  
        }.getType());
		return p; 
	}
	
	// jsonObject 解析
	public Person parseByJsonObject(String json){
		try {
			JSONObject p = new JSONObject(json);
			
			JSONObject  dataJson=new JSONObject("");
			JSONObject  response=dataJson.getJSONObject("response");
			JSONArray data=response.getJSONArray("data");
			JSONObject info=data.getJSONObject(0);
			String province=info.getString("province");
			String city=info.getString("city");
			String district=info.getString("district");
			String address=info.getString("address");
			System.out.println(province+city+district+address);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String jsonTest() throws JSONException{  
	    JSONObject json=new JSONObject();  
	    JSONArray jsonMembers = new JSONArray();  
	    JSONObject member1 = new JSONObject();  
	    member1.put("loginname", "zhangfan");  
	    member1.put("password", "userpass");  
	    member1.put("email","10371443@qq.com");  
	    member1.put("sign_date", "2007-06-12");  
	    jsonMembers.put(member1);  
	  
	    JSONObject member2 = new JSONObject();  
	    member2.put("loginname", "zf");  
	    member2.put("password", "userpass");  
	    member2.put("email","8223939@qq.com");  
	    member2.put("sign_date", "2008-07-16");  
	    jsonMembers.put(member2);  
	    json.put("users", jsonMembers);  
	    //直接增加对应数据
	    json.put("aaa", 110);
	    //增加map类型数据
	    Map<String,String> map = new HashMap<String,String>();
	    map.put("s_aaa", "s_1");
	    map.put("s_bbb", "s_2");
	    json.put("mapV", map);
	    return json.toString();  
	} 
	
}
