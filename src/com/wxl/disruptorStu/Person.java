package com.wxl.disruptorStu;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5741859476309602787L;
	
	private String name;
    private int age;
    private String gender;
    private String mobile;
    
    public Person(){}
    
    public Person(String name, int age, String gender, String mobile){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
