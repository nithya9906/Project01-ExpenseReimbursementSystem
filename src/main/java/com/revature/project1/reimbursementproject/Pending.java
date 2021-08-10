package com.revature.project1.reimbursementproject;

import java.util.Date;



public class Pending {
	private int requestId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Date requestDate;
	private String startDate;
	private String endDate;
	private double amount;
	private String description;
	private String requestStatus;
	private int empId;
	public Pending() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pending(int requestId, String firstName, String lastName, String emailId, Date requestDate, String startDate,
			String endDate, double amount, String description, String requestStatus, int empId) {
		super();
		this.requestId = requestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.requestDate = requestDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.description = description;
		this.requestStatus = requestStatus;
		this.empId = empId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Pending [requestId=" + requestId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", requestDate=" + requestDate + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", description=" + description + ", requestStatus=" + requestStatus
				+ ", empId=" + empId + "]";
	}

}
