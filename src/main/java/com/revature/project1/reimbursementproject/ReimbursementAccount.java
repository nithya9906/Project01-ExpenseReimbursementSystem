package com.revature.project1.reimbursementproject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="reimbursement")
public class ReimbursementAccount implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="requestId")
	private int requestId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="emailId")
	private String emailId;
	@Column(name="requestDate")
	private Date requestDate;
	
	@Column(name="startDate")
	private String startDate;
	@Column(name="endDate")
	private String endDate;
	@Column(name="amount")
	private double amount;
	@Column(name="description")
	private String description;
	@Column(name="requestStatus")
	private String requestStatus;
	private String filePath;
	
	 @Column(name = "img", length = 100000)
	 private byte[] img;
	@ManyToOne
	@JoinColumn(name="empId",referencedColumnName="empId")
	private Employee employee;
	
	public ReimbursementAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getFilePath() {
		return filePath;
	}



	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public ReimbursementAccount(String firstName, String lastName, String emailId, Date requestDate, String startDate,
			String endDate, double amount, String description, String requestStatus, String filePath, byte[] img,
			Employee employee) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.requestDate = requestDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.description = description;
		this.requestStatus = requestStatus;
		this.filePath = filePath;
		this.img = img;
		this.employee = employee;
	}



	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	
	
	@Override
	public String toString() {
		return "ReimbursementAccount [requestId=" + requestId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", requestDate=" + requestDate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", amount=" + amount + ", description=" + description + ", requestStatus=" + requestStatus
				+ ", employee=" + employee + "]";
	}
	
	
}