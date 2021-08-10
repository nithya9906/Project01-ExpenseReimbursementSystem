package com.revature.project1.reimbursementproject;

public class Login {
	private int userId;
	private String passwd;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int userId, String passwd) {
		super();
		this.userId = userId;
		this.passwd = passwd;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", passwd=" + passwd + "]";
	}
	

}
