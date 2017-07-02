package com.dongzi.bean;

public class User {
	private String userName;
	private String password;
	//private String sex;
	//private String age;
	//private String photo;

	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//public String getSex() {
	//	return sex;
	//}
	//public void setSex(String sex) {
	//	this.sex = sex;
	//}
	//public String getAge() {
	//	return age;
	//}
	//public void setAge(String age) {
	//	this.age = age;
	//}
	//public String getPhoto() {
	//	return photo;
	//}
	//public void setPhoto(String photo) {
	//	this.photo = photo;
	//}
	//public User(String username, String password, String sex,String age, String photo) {
	public User(String userName, String password) {
		super();

		this.userName = userName;
		this.password = password;
		//this.sex = sex;
		//this.age = age;
		//this.photo = photo;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
