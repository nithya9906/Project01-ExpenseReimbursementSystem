package com.revature.project1.reimbursementproject;

public class RequestClass {
	private int empId;
	private int requestId;
	public RequestClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestClass(int empId, int requestId) {
		super();
		this.empId = empId;
		this.requestId = requestId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	@Override
	public String toString() {
		return "RequestClass [empId=" + empId + ", requestId=" + requestId + "]";
	}
	
}
