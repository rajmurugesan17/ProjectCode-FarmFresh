package com.rajkumar.model;

import javax.validation.constraints.Positive;

public class AccountDetails {
	private String name;
	private int age;
	private String location;
	private String phoneNumber;
	private String emailId;
	private String userName;
	private String password;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AccountDetails [name=" + name + ", age=" + age + ", location=" + location + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", userName=" + userName + ", password=" + password + "]";
	}
	public AccountDetails(String name, int age, String location, String phoneNumber, String emailId, String userName,
			String password) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}
	public AccountDetails() {
		super();
	}
	
}
