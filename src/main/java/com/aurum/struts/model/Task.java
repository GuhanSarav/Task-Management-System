package com.aurum.struts.model;

public class Task {
	
	private String todo;
/*	private String email;
	private String mobileNumber;*/

/*	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	private String demo;
	*/
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(String todo, String email, String mobileNumber, String demo) {
		this.todo = todo;
		/*this.email = email;
		this.mobileNumber = mobileNumber;
		this.demo = demo;*/
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
/*

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
*/

}
