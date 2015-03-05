package com.wxl.jsonStu.Person;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5741859476309602787L;
	
	private String name;
    private int age;
    private List<StuHis> stuHis;
    
    public Person(){}
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

	public List<StuHis> getStuHis() {
		return stuHis;
	}

	public void setStuHis(List<StuHis> stuHis) {
		this.stuHis = stuHis;
	}

}
