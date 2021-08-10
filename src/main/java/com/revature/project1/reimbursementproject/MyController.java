package com.revature.project1.reimbursementproject;




import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.empdao.EmployeeDao;
import com.revature.project1.empdao.EmployeeDaoImp;

@Path("/controller")
public class MyController {
	public static int sessionId;
	private static final Logger LOGGER = LogManager.getLogger(MyController.class.getName());
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getHelloParam(String data) throws JsonProcessingException {
		Session session = null;
		Transaction transaction = null;
		ResultStatus s=new ResultStatus();
		ObjectMapper mapper = new ObjectMapper();
		Login l=mapper.readValue(data,Login.class);
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			LOGGER.entry();
			Employee e = (Employee) session.createQuery("FROM Employee E WHERE E.empId = :username")
					.setParameter("username", l.getUserId()).uniqueResult();
			if (e != null && e.getPassword().equals(l.getPasswd())) {
				s.setStatus(1);
				s.setUserId( l.getUserId());
				s.setRole(e.getDesignation());
				sessionId=l.getUserId();
				LOGGER.info(sessionId+"is logged in!!!!");
			}
			else
			{
				s.setStatus(0);	
				s.setUserId( l.getUserId());
				s.setRole(e.getDesignation());
			}
			transaction.commit();
			LOGGER.exit();
			return mapper.writeValueAsString(s);
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public String getSubmit(String data)throws ClassNotFoundException, JsonProcessingException
		{
		System.out.println(data);
	       Session session = null;
	       Transaction transaction = null;
	       ObjectMapper mp=new ObjectMapper();
	       ResultStatus s=new ResultStatus();
	       try {
	           session = HibernateUtil.getSessionFactory().openSession();
	           transaction = session.beginTransaction();
	           Date d=new Date();
	           LOGGER.entry();
	           System.out.println(sessionId);
	           Employee e=session.get(Employee.class,sessionId);
	          // System.out.println(sessionId);
	           ObjectMapper mapper = new ObjectMapper();
	           ReimbursementAccount r=mapper.readValue(data,ReimbursementAccount.class);
	         //  System.out.println(r.toString());
	       /*    File sourceimage = new File(r.getFilePath());
	           byte[] imageData = new byte[(int) sourceimage.length()];
	           System.out.println(imageData);
	           try {
	   		    FileInputStream fileInputStream = new FileInputStream(sourceimage);
	   		    fileInputStream.read(imageData);
	   		    fileInputStream.close();
	   		} catch (Exception ex) {
	   		    ex.printStackTrace();
	   		}*/
	   		 
	           
	           //Image image = ImageIO.read(sourceimage);
	          // byte[] imageData = new byte[image];
	          // BufferedImage bImage = ImageIO.read(new File("sourceimage"));
	          // ByteArrayOutputStream bos = new ByteArrayOutputStream();
	          // ImageIO.write(bImage, "jpg", bos );
	           //byte [] dataimage = bos.toByteArray();
	          // r.setImg(imageData);
	          r.setFirstName(e.getFirstName());
	          r.setLastName(e.getLastName());
	          r.setEmailId(e.getEmailid());
	          r.setRequestDate(d);
	          r.setRequestStatus("Pending");
	          r.setEmployee(e);
	          System.out.println(r);
	           session.save(r);
	           transaction.commit();
	           s.setStatus(1);
	         
	       } catch (Exception ex) {
	           if (transaction != null) {
	               transaction.rollback();
	           }
	           ex.printStackTrace();
	           s.setStatus(0);

	          
	       }
	       LOGGER.info(sessionId+" add a reimbursement request on "+new Date());
	       LOGGER.exit();
	       return mp.writeValueAsString(s);
	       
	   }
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertEmployeeDetail(String data) throws JsonMappingException, JsonProcessingException {
	
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("hi");
		Employee e=mapper.readValue(data,Employee.class);
		EmployeeDaoImp emp=new EmployeeDaoImp();
		int result=emp.insertEmployee(e);
		ResultStatus s=new ResultStatus();
		if(result>0)
		{
			s.setStatus(1);
		}
		else {
			s.setStatus(0);
		}
		return mapper.writeValueAsString(s);	
	}
	
	/*@POST
	@Path("/addition")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertRequest(@FormParam("empId") int empId,@FormParam("emailid") String emailid,@FormParam("startDate") Date startDate,@FormParam("endDate") Date endDate,@FormParam("requestType") String requestType,@FormParam("amount") double amount)
	{
		System.out.println("heloo");
		Date d=new Date();
		ReimbursementAccount r=new ReimbursementAccount(emailid,d,startDate,endDate,amount,requestType,"Pending"); 
		EmployeeDao emp=new EmployeeDaoImp();
		emp.addRequest(r);
		return "true";		
	}*/
	
	@GET
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserDetail()
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		List<Employee> ls=emp.getProfile(sessionId);
		//System.out.println(ls);
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}
	
	@GET
	@Path("/allprofile")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllUserDetail()
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		List<Employee> ls=emp.getAllProfile();
		//System.out.println(ls);
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}
	@POST
	@Path("/searchProfile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeDetail(String data) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		ResultStatus rs=mapper.readValue(data,ResultStatus.class);
		System.out.println(rs);
		List<Employee> ls=emp.getProfile(rs.getUserId());
		System.out.println(ls);
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}
	
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateProfile(String data) throws JsonMappingException, JsonProcessingException
	{
		System.out.println(data);
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		Employee e=mapper.readValue(data,Employee.class);
		System.out.println(e);
		ResultStatus ls=new ResultStatus();
		int res=emp.updateProfileData(e);
		if(res>0)
		{
			ls.setStatus(1);
		}
		else
		{
			ls.setStatus(0);
		}
			return mapper.writeValueAsString(ls);
	}
	@PUT
	@Path("/changePassword")
	@Produces(MediaType.APPLICATION_JSON)
	public String updatePassword(String data) throws JsonMappingException, JsonProcessingException
	{
		System.out.println(data);
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		PasswordDetail p=mapper.readValue(data,PasswordDetail.class);
		//System.out.println(e);
		//e.setEmpId(sessionId);
		ResultStatus ls=new ResultStatus();
		int res=emp.updatePasswordData(p,sessionId);
		if(res>0)
		{
			ls.setStatus(1);
		}
		else
		{
			ls.setStatus(0);
		}
			return mapper.writeValueAsString(ls);
	}
	
	@PUT
	@Path("/acceptRequest")
	@Produces(MediaType.APPLICATION_JSON)
	public String acceptRequested(String data) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		RequestClass r=mapper.readValue(data,RequestClass.class);
		ResultStatus ls=new ResultStatus();
		int res=emp.acceptRequest(r);
		if(res>0)
		{
			ls.setStatus(1);
		}
		else
		{
			ls.setStatus(0);
		}
		//System.out.println(ls);
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@PUT
	@Path("/rejectRequest")
	@Produces(MediaType.APPLICATION_JSON)
	public String rejectRequested(String data) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		RequestClass r=mapper.readValue(data,RequestClass.class);
		ResultStatus ls=new ResultStatus();
		int res=emp.rejectRequest(r);
		if(res>0)
		{
			ls.setStatus(1);
		}
		else
		{
			ls.setStatus(0);
		}
		//System.out.println(ls);
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	

	@GET
	@Path("/allrequest")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllRequestDetails()
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		List<Pending> ls=emp.getAllRequest();
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	
	
	@GET
	@Path("/pending")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPendingDetails()
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		List<Pending> ls=emp.getAllPending();
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	@GET
	@Path("/onepending")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPendingDetails()
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		List<Pending> ls=emp.getPending(sessionId);
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	@POST
	@Path("/searchPending")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchPendings(String data) throws JsonProcessingException
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		ResultStatus s=mapper.readValue(data,ResultStatus.class);
		List<Pending> ls=emp.getPending(s.getUserId());
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	@GET
	@Path("/accepted")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAcceptedDetails()
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		List<Pending> ls=emp.getAllAccepted();
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	@GET
	@Path("/oneaccepted")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAcceptedDetails()
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		List<Pending> ls=emp.getAccepted(sessionId);
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	@POST
	@Path("/searchAccepted")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchAcceptedDetail(String data) throws JsonProcessingException
	{
		ObjectMapper mapper=new ObjectMapper();
		EmployeeDao emp=new EmployeeDaoImp();
		ResultStatus s=mapper.readValue(data,ResultStatus.class);
		List<Pending> ls=emp.getAccepted(s.getUserId());
		try {
			return mapper.writeValueAsString(ls);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	@GET
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	public String logoutSession() throws JsonProcessingException
	{
		ObjectMapper mp=new ObjectMapper();
	    ResultStatus s=new ResultStatus();
	    System.out.println(sessionId);
	    LOGGER.entry();
	    LOGGER.info(sessionId+ " session is cleared.Logout!!!!!");
	    LOGGER.exit();
	    sessionId=0;
	    s.setUserId(0);
	    System.out.println("Session cleared");
	    return mp.writeValueAsString(s);
	}
	/*@GET
	@Path("/onepending")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPendingDetail(@FormParam("empId") int id)
	{
		System.out.println(id);
		String e=String.valueOf(id);
		return e;
		
		
	}*/
	
	

}
