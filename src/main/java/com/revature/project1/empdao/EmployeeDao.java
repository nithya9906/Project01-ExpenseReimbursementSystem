package com.revature.project1.empdao;

import java.util.List;

import com.revature.project1.reimbursementproject.Employee;
import com.revature.project1.reimbursementproject.PasswordDetail;
import com.revature.project1.reimbursementproject.Pending;
import com.revature.project1.reimbursementproject.ReimbursementAccount;
import com.revature.project1.reimbursementproject.RequestClass;

public interface EmployeeDao {
	public abstract int insertEmployee(Employee e);
	public abstract List<Employee> getProfile(int id);
	public abstract List<Employee> getAllProfile();
	public abstract void addRequest(ReimbursementAccount r);
	public abstract List<Pending> getAllRequest();
	public abstract List<Pending> getAllPending();
	public abstract List<Pending> getPending(int i);
	public abstract List<Pending> getAllAccepted();
	public abstract List<Pending> getAccepted(int id);
	public abstract int acceptRequest(RequestClass r);
	public abstract int rejectRequest(RequestClass r);
	public abstract int updateProfileData(Employee e);
	public abstract int updatePasswordData(PasswordDetail p,int id);
}
