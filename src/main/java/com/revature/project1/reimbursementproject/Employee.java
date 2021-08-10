package com.revature.project1.reimbursementproject;


import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="empid")
	private int empId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="dateOfBirth")
	private String dob; 
	@Column(name="age")
	private int age;
	@Column(name="emailid")
	private String emailid;
	@Column(name="designation")
	private String designation;
	@Column(name="doornumber")
	private String doornumber;
	@Column(name="street")
	private String street;
	@Column(name="district")
	private String district;
	@Column(name="pincode")
	private int pincode;
	@Column(name="contactno")
	private String contactno;
	@Column(name="password")
	private String password;
	@Column(name="gender")
	private String gender;
	Employee(){}
public Employee(String firstName, String lastName, String dob, int age, String emailid, String designation,
		String doornumber, String street, String district, int pincode, String contactno, String password,
		String gender) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.age = age;
	this.emailid = emailid;
	this.designation = designation;
	this.doornumber = doornumber;
	this.street = street;
	this.district = district;
	this.pincode = pincode;
	this.contactno = contactno;
	this.password = password;
	this.gender = gender;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
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
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob= dob;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDoornumber() {
	return doornumber;
}
public void setDoornumber(String doornumber) {
	this.doornumber = doornumber;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
			+ ", age=" + age + ", emailid=" + emailid + ", designation=" + designation + ", doornumber=" + doornumber
			+ ", street=" + street + ", district=" + district + ", pincode=" + pincode + ", contactno=" + contactno
			+ ", password=" + password + ", gender=" + gender + "]";
}


}
