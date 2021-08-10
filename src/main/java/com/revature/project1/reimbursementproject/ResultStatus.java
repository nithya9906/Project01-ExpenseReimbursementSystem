package com.revature.project1.reimbursementproject;

public class ResultStatus {
	private int status;
	private int userId;
	private String role;

	public ResultStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultStatus(int status, int userId, String role) {
		super();
		this.status = status;
		this.userId = userId;
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ResultStatus [status=" + status + ", userId=" + userId + ", role=" + role + "]";
	}

	
	

}
