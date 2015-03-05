package com.wxl.jsonStu.Person;

public class StuHis {
	private String stuDate;
	private String stuLocal;
	
	public StuHis(String date, String local) {
		this.stuDate = date;
		this.stuLocal = local;
	}
	
	public String getStuDate() {
		return stuDate;
	}
	public void setStuDate(String stuDate) {
		this.stuDate = stuDate;
	}
	public String getStuLocal() {
		return stuLocal;
	}
	public void setStuLocal(String stuLocal) {
		this.stuLocal = stuLocal;
	}
	
}
