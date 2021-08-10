package com.revature.project1.empdao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.project1.reimbursementproject.Employee;
import com.revature.project1.reimbursementproject.HibernateUtil;
import com.revature.project1.reimbursementproject.MyController;
import com.revature.project1.reimbursementproject.PasswordDetail;
import com.revature.project1.reimbursementproject.Pending;
import com.revature.project1.reimbursementproject.ReimbursementAccount;
import com.revature.project1.reimbursementproject.RequestClass;

public class EmployeeDaoImp implements EmployeeDao{
	private static final Logger LOGGER = LogManager.getLogger(EmployeeDaoImp.class.getName());
	@Override
	public int insertEmployee(Employee e) {
		Session session = null;
		Transaction transaction = null;
		LOGGER.entry();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(e);
			transaction.commit();
			LOGGER.info("Manager registered an employee of name"+e.getFirstName());
			LOGGER.exit();
			return 1;

		} catch (Exception ex) {
			ex.getMessage();
		}
		return 0;
	}

	@Override
	public List<Employee> getProfile(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Employee usr=session.get(Employee.class,id);
			List<Employee> list=new ArrayList<Employee>();
			list.add(usr);
			LOGGER.info("Profile of "+id+"is viewed");
			LOGGER.exit();
			return list;

		} catch (Exception ex) {
			ex.getMessage();
		}
		return null;
	}

	@Override
	public void addRequest(ReimbursementAccount r) {
		Session session = null;
		Transaction transaction = null;
			try {
				LOGGER.entry();
				session = HibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				session.save(r);
				transaction.commit();
				LOGGER.info("Reimbursement Requestis added");
				LOGGER.exit();

			} catch (Exception ex) {
				ex.getMessage();
			}
		}

	@Override
	public List<Pending> getAllPending() {
		Session session = null;
		Transaction transaction = null;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			 List<ReimbursementAccount>  req=session.createQuery("from ReimbursementAccount where requestStatus='Pending'",ReimbursementAccount.class).list();
			//List<ReimbursementAccount> req=session.createQuery("select e from ReimbursementAccount e inner join e.Employee").list();
			//List<ReimbursementAccount> list=new ArrayList<ReimbursementAccount>();
			//list.add(req);
			 List<Pending> pend=new ArrayList<Pending>();
             for(ReimbursementAccount e:req) {
             Pending p=new Pending(e.getRequestId(),e.getFirstName(),e.getLastName(),e.getEmailId(),e.getRequestDate(),e.getStartDate(),e.getEndDate(),e.getAmount(),e.getDescription(),e.getRequestStatus(),e.getEmployee().getEmpId());
             pend.add(p);
           }
             LOGGER.info("Manager views all pending request of the employee");
             System.out.println(pend);
             LOGGER.exit();
             return pend;
		}
             catch (Exception ex) {
     			ex.getMessage();
     		}
     		return null;
 }
	public List<Pending> getAllAccepted() {
		Session session = null;
		Transaction transaction = null;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			 List<ReimbursementAccount>  req=session.createQuery("from ReimbursementAccount where requestStatus='Accepted'",ReimbursementAccount.class).list();
			//List<ReimbursementAccount> req=session.createQuery("select e from ReimbursementAccount e inner join e.Employee").list();
			//List<ReimbursementAccount> list=new ArrayList<ReimbursementAccount>();
			//list.add(req);
			 List<Pending> pend=new ArrayList<Pending>();
             for(ReimbursementAccount e:req) {
             Pending p=new Pending(e.getRequestId(),e.getFirstName(),e.getLastName(),e.getEmailId(),e.getRequestDate(),e.getStartDate(),e.getEndDate(),e.getAmount(),e.getDescription(),e.getRequestStatus(),e.getEmployee().getEmpId());
             pend.add(p);
           }
             LOGGER.info("Manager views the all resolved request");
             System.out.println(pend);
             LOGGER.exit();
             return pend;
		}
             catch (Exception ex) {
     			ex.getMessage();
     		}
     		return null;
 }

	@Override
	public List<Pending> getPending(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			 List<ReimbursementAccount>  req=session.createQuery("from ReimbursementAccount where employee.empId=:id and requestStatus='Pending'",ReimbursementAccount.class).setParameter("id", id).list();
			//List<ReimbursementAccount> req=session.createQuery("select e from ReimbursementAccount e inner join e.Employee").list();
			//List<ReimbursementAccount> list=new ArrayList<ReimbursementAccount>();
			//list.add(req);
			 List<Pending> pend=new ArrayList<Pending>();
             for(ReimbursementAccount e:req) {
             Pending p=new Pending(e.getRequestId(),e.getFirstName(),e.getLastName(),e.getEmailId(),e.getRequestDate(),e.getStartDate(),e.getEndDate(),e.getAmount(),e.getDescription(),e.getRequestStatus(),e.getEmployee().getEmpId());
             pend.add(p);
            
           }
             LOGGER.info("Pending details of "+id+" is viewed");
             System.out.println(pend);
             LOGGER.exit();
             return pend;
		}
             catch (Exception ex) {
     			ex.getMessage();
     		}
		return null;
	}

	@Override
	public List<Pending> getAccepted(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			 List<ReimbursementAccount>  req=session.createQuery("from ReimbursementAccount where employee.empId=:id and requestStatus='Accepted'",ReimbursementAccount.class).setParameter("id", id).list();
			//List<ReimbursementAccount> req=session.createQuery("select e from ReimbursementAccount e inner join e.Employee").list();
			//List<ReimbursementAccount> list=new ArrayList<ReimbursementAccount>();
			//list.add(req);
			 List<Pending> pend=new ArrayList<Pending>();
             for(ReimbursementAccount e:req) {
             Pending p=new Pending(e.getRequestId(),e.getFirstName(),e.getLastName(),e.getEmailId(),e.getRequestDate(),e.getStartDate(),e.getEndDate(),e.getAmount(),e.getDescription(),e.getRequestStatus(),e.getEmployee().getEmpId());
             pend.add(p);
           }
             LOGGER.info("Resolved details of "+id+" is viewed");
             System.out.println(pend);
             return pend;
		}
             catch (Exception ex) {
     			ex.getMessage();
     		}
     		return null;
	}

	@Override
	public int acceptRequest(RequestClass r) {
		Session session = null;
		Transaction transaction = null;
		int output=0;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q=session.createQuery("update ReimbursementAccount set requestStatus=:s  where requestId=:id");  
		    q.setParameter("s","Accepted");  
		    q.setParameter("id",r.getRequestId());  
		    int result=q.executeUpdate();     
			transaction.commit();
			if(result==1)
			{
				 LOGGER.info("Request of "+r.getRequestId()+" is  resolved");
				output=1;
			}
			else
			{
				output=0;
			}
		
			LOGGER.exit();
		} catch (Exception ex) {
			ex.getMessage();
		}
		return output;
	}

	@Override
	public int updateProfileData(Employee e) {
		Session session = null;
		Transaction transaction = null;
		int output=0;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q=session.createQuery("update Employee set age=:age,emailid=:emailid,designation=:designation,doornumber=:doornumber,street=:street,district=:district,pincode=:pincode,contactno=:contactno  where empId=:id");   
		    q.setParameter("id",e.getEmpId()); 
		    q.setParameter("age",e.getAge()); 
		    q.setParameter("emailid",e.getEmailid()); 
		    q.setParameter("designation",e.getDesignation()); 
		    q.setParameter("doornumber",e.getDoornumber()); 
		    q.setParameter("street",e.getStreet());
		    q.setParameter("district",e.getDistrict());
		    q.setParameter("pincode",e.getPincode()); 
		    q.setParameter("contactno",e.getContactno()); 
		    
		    
		    int result=q.executeUpdate();     
			transaction.commit();
			if(result==1)
			{
				output=1;
				 LOGGER.info("Profile details of "+e.getEmpId()+" is updated");
			}
			else
			{
				output=0;
			}
		

		} catch (Exception ex) {
			ex.getMessage();
		}
		LOGGER.exit();
		return output;
	}

	@Override
	public int updatePasswordData(PasswordDetail p,int id) {
		Session session = null;
		Transaction transaction = null;
		int output=0;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Employee e = (Employee) session.createQuery("FROM Employee E WHERE E.empId = :userId")
                    .setParameter("userId", id).uniqueResult();
			System.out.println(e);
            if (e != null && e.getPassword().equals(p.getOldpwd())) {
            Query q=session.createQuery("update Employee set password=:n  where empId=:i");  
            q.setParameter("n",p.getNewpwd());  
            q.setParameter("i",id);  
            q.executeUpdate();       
            transaction.commit();
            LOGGER.info("Password  of "+id+" is changed");
            LOGGER.exit();
            return 1;
            }
            else {
                
                return 0;
            }
            } 
            catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
         }
		 return 0;
	}

	@Override
	public List<Employee> getAllProfile() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			List<Employee> list=session.createQuery("from Employee",Employee.class).list();
			 LOGGER.info("All profile is viewed");
			 LOGGER.exit();
			return list;

		} catch (Exception ex) {
			ex.getMessage();
		}
		return null;
	}

	@Override
	public int rejectRequest(RequestClass r) {
		Session session = null;
		Transaction transaction = null;
		int output=0;
		try {
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q=session.createQuery("update ReimbursementAccount set requestStatus=:s  where requestId=:id");  
		    q.setParameter("s","Rejected");  
		    q.setParameter("id",r.getRequestId());  
		    int result=q.executeUpdate();     
			transaction.commit();
			if(result>0)
			{
				output=1;
				 LOGGER.info("Request details of "+r.getRequestId()+" is rejected");
			}
			else
			{
				output=0;
			}
		

		} catch (Exception ex) {
			ex.getMessage();
		}
		LOGGER.exit();
		return output;
	}

	@Override
	public List<Pending> getAllRequest() {
		Session session = null;
		Transaction transaction = null;
		try {
			System.out.println("ALl request.....");
			LOGGER.entry();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			 List<ReimbursementAccount>  req=session.createQuery("from ReimbursementAccount",ReimbursementAccount.class).list();
			 List<Pending> pend=new ArrayList<Pending>();
             for(ReimbursementAccount e:req) {
             Pending p=new Pending(e.getRequestId(),e.getFirstName(),e.getLastName(),e.getEmailId(),e.getRequestDate(),e.getStartDate(),e.getEndDate(),e.getAmount(),e.getDescription(),e.getRequestStatus(),e.getEmployee().getEmpId());
             pend.add(p);
           }
             LOGGER.info("Manager views all request of the employee");
             System.out.println(pend);
             LOGGER.exit();
             return pend;
		}
             catch (Exception ex) {
     			ex.getMessage();
     		}
		return null;
	}
}

