package com.revature.project1.reimbursementproject;

public class PasswordDetail {
	private String oldpwd;
	private String newpwd;
	private String confirmpwd;
	public PasswordDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PasswordDetail(String oldpwd, String newpwd, String confirmpwd) {
		super();
		this.oldpwd = oldpwd;
		this.newpwd = newpwd;
		this.confirmpwd = confirmpwd;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	@Override
	public String toString() {
		return "PasswordDetail [oldpwd=" + oldpwd + ", newpwd=" + newpwd + ", confirmpwd=" + confirmpwd + "]";
	}
	
	
}
