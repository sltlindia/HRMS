package com.hrms.lms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveCancelRequestBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class TimerForWeeklyLeaveServlet
 */
public class TimerForWeeklyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int i = 0;
		String imprtantMsg = "If You will not approve this Leave/CO/OD till 4:00 PM on the last Date of this month then it will be automatically cancelled by system.";
		AllLMSListDAO allLMSListDAO  = new AllLMSListDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		LoginDAO loginDAO = new LoginDAO();
		
		List<LeaveBean> listOfLeave = allLMSListDAO.getLeave(i);
		List<LeaveCOBean> listOfCo = allLMSListDAO.getCO(i);
		List<LeaveODBean> listOfOD = allLMSListDAO.getOD(i);
		List<LeaveCancelRequestBean> listOfCancelLeave = allLMSListDAO.getListOfCancelLeave(i);
		
		int mail_view = 1;
		
		for(LeaveBean leaveBean : listOfLeave){
			
			int manager_id =Integer.parseInt(leaveBean.getEmployeeBean().getUnder_manager_id());
			int emp_id = leaveBean.getEmployeeBean().getEmployee_master_id();
			
			EmployeeBean employeeBean = loginDAO.getEmailId(manager_id);
			EmployeeBean employeeBean1 = loginDAO.getInfoById(emp_id);
			String mngEmail = employeeBean.getEmail_id();
			String empEmail = employeeBean1.getEmail_id();
			int leaveId = leaveBean.getLeave_id();
			int emp_code = employeeBean1.getEmployee_code();
			 String name = employeeBean1.getFirstname()+" "+employeeBean1.getLastname();
			
			String lfff = null;
			String tlll = null;
			
			try 
			{
			  
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				Date result1 = formater1.parse(leaveBean.getLeave_From());
				Date result2 = formater1.parse(leaveBean.getLeave_To());
				SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
				lfff = formater2.format(result1);
				tlll = formater2.format(result2);
			
			}
			catch (ParseException e1) 
			{
				e1.printStackTrace();
			}	
			
			
			
			
			if(leaveBean.getStatus().equalsIgnoreCase("pending")){
			
				System.out.println("leave pending");
				
			String lffff = lfff;
			String tllll = tlll;
			System.out.println(leaveBean.getLeave_id()+" "+leaveBean.getEmployeeBean().getFirstname());
			System.out.println(mngEmail);
			
			
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			    	String to = mngEmail;
			    	String sub = "Important : " +name + " Apply for leave.";
			    	String leavefrom = lffff;
			    	String leaveto = tllll;
			    	double days = leaveBean.getDay_count();
			    	String mobileNo = leaveBean.getNumber();
			    	int emp_code = leaveBean.getEmployeeBean().getEmployee_code();
			    	String alert = null;
			    	
			    	Mailer.send(to, sub, leavefrom, leaveto, days, emp_code,mobileNo,alert,leaveId,name,imprtantMsg);
			    	System.out.println("Done : "+leaveBean.getEmployeeBean().getFirstname()+" "+leaveBean.getLeave_From()+" to "+leaveBean.getLeave_To());
			    	boolean result = allUpdateDAO.LeaveMailUpdate(leaveBean.getLeave_id(),mail_view);
			    }
			}).start();
			
			
			
			
		}else if(leaveBean.getStatus().equalsIgnoreCase("rejected")){
			
			System.out.println("leave rejected");
			
			String lffff = lfff;
			String tllll = tlll;
			System.out.println(leaveBean.getLeave_id()+" "+leaveBean.getEmployeeBean().getFirstname());
			System.out.println(empEmail);
			
			 new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	String to = empEmail;
				    	String sub = name+" Your Leave Rejected.";
				    	double days = leaveBean.getDay_count();
				    	String leavefrom = lffff;
				    	String leaveto = tllll ;
				    	String status = "Rejected";
				    	String reason = leaveBean.getReason();
				    	
				    		Mailer.send1(to, sub, leavefrom, leaveto, days,status,reason,emp_code,name);
				    		System.out.println("Done : "+leaveBean.getEmployeeBean().getFirstname()+" "+leaveBean.getLeave_From()+" to "+leaveBean.getLeave_To());
				    		boolean result = allUpdateDAO.LeaveMailUpdate(leaveBean.getLeave_id(),mail_view);
				    }
				}).start();
			
		}else if(leaveBean.getStatus().equalsIgnoreCase("approved")){
			
			System.out.println("leave approved");
			
			String lffff = lfff;
			String tllll = tlll;
			
			System.out.println(leaveBean.getLeave_id()+" "+leaveBean.getEmployeeBean().getFirstname());
			System.out.println(empEmail);
			
			 new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	String to = empEmail;
				    	String sub = name+" Your Leave Approved.";
				    	double days = leaveBean.getDay_count();
				    	String leavefrom = lffff;
				    	String leaveto = tllll ;
				    	String status = "Approved";
				    	String reason = "";
				    	
				    		
				    	Mailer.send1(to, sub, leavefrom, leaveto, days,status,reason,emp_code,name);
				    	System.out.println("Done : "+leaveBean.getEmployeeBean().getFirstname()+" "+leaveBean.getLeave_From()+" to "+leaveBean.getLeave_To());
				    	boolean result = allUpdateDAO.LeaveMailUpdate(leaveBean.getLeave_id(),mail_view);
				    }
				}).start();
			
		}
			
		}
		
		
		for(LeaveCOBean leaveCOBean : listOfCo){
			int manager_id =Integer.parseInt(leaveCOBean.getEmployeeBean().getUnder_manager_id());
			int emp_id = leaveCOBean.getEmployeeBean().getEmployee_master_id();
			
			EmployeeBean employeeBean = loginDAO.getEmailId(manager_id);
			EmployeeBean employeeBean1 = loginDAO.getInfoById(emp_id);
			String mngEmail = employeeBean.getEmail_id();
			String empEmail = employeeBean1.getEmail_id();
			int emp_code = employeeBean1.getEmployee_code();
			String name = employeeBean1.getFirstname()+" "+employeeBean1.getLastname();
			double total_co = 0;
			int co_id = leaveCOBean.getCO_ID();
			String lfff = null;
			
			try 
			{
			  
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				Date result1 = formater1.parse(leaveCOBean.getCO_date());
				SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
				lfff = formater2.format(result1);
			
			}
			catch (ParseException e1) 
			{
				e1.printStackTrace();
			}	
			
			 if(leaveCOBean.getTotal_Hours() > 4) 
				{
				 total_co = 1.0;
				 }
					else if(leaveCOBean.getTotal_Hours()  > 2 && leaveCOBean.getTotal_Hours() <= 4)
					{
						total_co = 0.5 ;
				}
						else if(leaveCOBean.getTotal_Hours() <= 2)
						{
							total_co = 0.0 ;
					} 
			
			
			if(leaveCOBean.getStatus().equalsIgnoreCase("pending")){
				
			System.out.println("CO pending");
				
			String lffff = lfff;
			System.out.println(leaveCOBean.getCO_ID()+" "+leaveCOBean.getEmployeeBean().getFirstname());
			System.out.println(mngEmail);
			
			double total = total_co;
			
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			    	String to = mngEmail;
			    	String sub = "Important : " +name + " Apply for CO.";
			    	String coDate = lffff;
			    	double totalHours = leaveCOBean.getTotal_Hours();
			    	double coCount = total;
			    	String purpose = leaveCOBean.getDecripction();
			    	int emp_code = leaveCOBean.getEmployeeBean().getEmployee_code();
			    	
			    	Mailer.coPendingSend(to, sub, coDate, totalHours, coCount, emp_code, name, purpose,co_id,imprtantMsg);
			    	System.out.println("Done : "+leaveCOBean.getEmployeeBean().getFirstname()+" "+leaveCOBean.getCO_date());
			    	boolean result = allUpdateDAO.CoMailUpdate(leaveCOBean.getCO_ID(),mail_view);
			    }
			}).start();
			
		}else if(leaveCOBean.getStatus().equalsIgnoreCase("approved")){
			
		System.out.println("CO approved");
			
		String lffff = lfff;
		System.out.println(leaveCOBean.getCO_ID()+" "+leaveCOBean.getEmployeeBean().getFirstname());
		System.out.println(empEmail);
		
		double total = total_co;
		
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	
		    	String to = empEmail;
		    	String sub = name + " Your CO Approved.";
		    	String coDate = lffff;
		    	double totalHours = leaveCOBean.getTotal_Hours();
		    	double coCount = total;
		    	String purpose = leaveCOBean.getDecripction();
		    	String status = "Approved";
		    	String reason = "";
		    	int emp_code = leaveCOBean.getEmployeeBean().getEmployee_code();
		    	
		    	Mailer.COAcceptRejectSend(to, sub, coDate, totalHours, coCount, emp_code, name, purpose, status, reason);
		    	System.out.println("Done : "+leaveCOBean.getEmployeeBean().getFirstname()+" "+leaveCOBean.getCO_date());
		    	boolean result = allUpdateDAO.CoMailUpdate(leaveCOBean.getCO_ID(),mail_view);
		    }
		}).start();

	}else if(leaveCOBean.getStatus().equalsIgnoreCase("rejected")){
		
	System.out.println("CO rejected");
		
	String lffff = lfff;
	System.out.println(leaveCOBean.getCO_ID()+" "+leaveCOBean.getEmployeeBean().getFirstname());
	System.out.println(empEmail);
	
	double total = total_co;
	
	new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	
	    	String to = empEmail;
	    	String sub = name + " Your CO Rejected.";
	    	String coDate = lffff;
	    	double totalHours = leaveCOBean.getTotal_Hours();
	    	double coCount = total;
	    	String purpose = leaveCOBean.getDecripction();
	    	String status = "Rejected";
	    	String reason = leaveCOBean.getReason();
	    	int emp_code = leaveCOBean.getEmployeeBean().getEmployee_code();
	    	
	    	Mailer.COAcceptRejectSend(to, sub, coDate, totalHours, coCount, emp_code, name, purpose, status, reason);
	    	System.out.println("Done : "+leaveCOBean.getEmployeeBean().getFirstname()+" "+leaveCOBean.getCO_date());
	    	boolean result = allUpdateDAO.CoMailUpdate(leaveCOBean.getCO_ID(),mail_view);
	    }
	}).start();
	
	}
			
}
		

		for(LeaveODBean leaveODBean : listOfOD){
			int manager_id =Integer.parseInt(leaveODBean.getEmployeeBean().getUnder_manager_id());
			int emp_id = leaveODBean.getEmployeeBean().getEmployee_master_id();
			
			EmployeeBean employeeBean = loginDAO.getEmailId(manager_id);
			EmployeeBean employeeBean1 = loginDAO.getInfoById(emp_id);
			String mngEmail = employeeBean.getEmail_id();
			String empEmail = employeeBean1.getEmail_id();
			int emp_code = employeeBean1.getEmployee_code();
			String name = employeeBean1.getFirstname()+" "+employeeBean1.getLastname();
		
			String lfff = null;
			String lttt = null;
			
			int od_id = leaveODBean.getOD_ID();
			
			try 
			{
			  
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				Date result1 = formater1.parse(leaveODBean.getOD_StartDate());
				Date result2 = formater1.parse(leaveODBean.getOD_EndDate());
				SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
				lfff = formater2.format(result1);
				lttt = formater2.format(result2);
			
			}
			catch (ParseException e1) 
			{
				e1.printStackTrace();
			}	
			
			 
			String OD_start = lfff;
			String OD_end = lttt;
			
			if(leaveODBean.getStatus().equalsIgnoreCase("pending")){
				
			System.out.println("OD pending");
				
			
			System.out.println(leaveODBean.getOD_ID()+" "+leaveODBean.getEmployeeBean().getFirstname());
			System.out.println(mngEmail);
			
			
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			    	String to = mngEmail;
			    	String sub ="Important : " +name + " Apply for OD.";
			    	String OD_start_date = OD_start;
			    	String OD_end_date = OD_end;
			    	double total_OD = leaveODBean.getOD_TotalDay();
			    	String purpose = leaveODBean.getDescription();
			    	int emp_code = leaveODBean.getEmployeeBean().getEmployee_code();
			    	
			    	Mailer.ODPendingSend(to, sub, OD_start_date, OD_end_date, total_OD, emp_code, name, purpose,od_id,imprtantMsg);
			    	System.out.println("Done : "+leaveODBean.getEmployeeBean().getFirstname()+" "+leaveODBean.getOD_StartDate()+" "+leaveODBean.getOD_EndDate());
			    	boolean result = allUpdateDAO.ODMailUpdate(leaveODBean.getOD_ID(),mail_view);
			    }
			}).start();
			
		}else if(leaveODBean.getStatus().equalsIgnoreCase("approved")){
			
		System.out.println("OD approved");
			
		
		System.out.println(leaveODBean.getOD_ID()+" "+leaveODBean.getEmployeeBean().getFirstname());
		System.out.println(empEmail);
		
		
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	
		    	String to = empEmail;
		    	String sub = name + " Your OD Approved.";
		    	String OD_start_date = OD_start;
		    	String OD_end_date = OD_end;
		    	double total_OD = leaveODBean.getOD_TotalDay();
		    	String purpose = leaveODBean.getDescription();
		    	int emp_code = leaveODBean.getEmployeeBean().getEmployee_code();
		    	String status = "Approved";
		    	String reason = "";
		    	
		    	Mailer.ODAcceptRejectSend(to, sub, OD_start_date, OD_end_date, total_OD, status, reason, purpose, emp_code, name);
		    	System.out.println("Done : "+leaveODBean.getEmployeeBean().getFirstname()+" "+leaveODBean.getOD_StartDate()+""+leaveODBean.getOD_EndDate());
		    	boolean result = allUpdateDAO.ODMailUpdate(leaveODBean.getOD_ID(),mail_view);
		    }
		}).start();

	}else if(leaveODBean.getStatus().equalsIgnoreCase("rejected")){
		
	System.out.println("OD rejected");
		
	System.out.println(leaveODBean.getOD_ID()+" "+leaveODBean.getEmployeeBean().getFirstname());
	System.out.println(empEmail);
	
	
	new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	
	    	String to = empEmail;
	    	String sub = name + " Your OD Rejected.";
	    	String OD_start_date = OD_start;
	    	String OD_end_date = OD_end;
	    	double total_OD = leaveODBean.getOD_TotalDay();
	    	String purpose = leaveODBean.getDescription();
	    	int emp_code = leaveODBean.getEmployeeBean().getEmployee_code();
	    	String status = "Rejected";
	    	String reason = leaveODBean.getReason();
	    	
	    	Mailer.ODAcceptRejectSend(to, sub, OD_start_date, OD_end_date, total_OD, status, reason, purpose, emp_code, name);
	    	System.out.println("Done : "+leaveODBean.getEmployeeBean().getFirstname()+" "+leaveODBean.getOD_StartDate()+""+leaveODBean.getOD_EndDate());
	    	boolean result = allUpdateDAO.ODMailUpdate(leaveODBean.getOD_ID(),mail_view);
	    }
	}).start();
	
	}
			
}
		
			
		for(LeaveCancelRequestBean leaveCancelRequestBean : listOfCancelLeave){
			
			int manager_id =Integer.parseInt(leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getUnder_manager_id());
			int emp_id = leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getEmployee_master_id();
			
			EmployeeBean employeeBean = loginDAO.getEmailId(manager_id);
			EmployeeBean employeeBean1 = loginDAO.getInfoById(emp_id);
			String mngEmail = employeeBean.getEmail_id();
			String empEmail = employeeBean1.getEmail_id();
			int emp_code = employeeBean1.getEmployee_code();
			String name = employeeBean1.getFirstname()+" "+employeeBean1.getLastname();
			
			String leaveFromDate = null;
			String leaveToDate = null;
			String updatedLeaveFromDate = null;
			String updatedLeaveToDate = null;
			
			try 
			{
			  
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				Date result1 = formater1.parse(leaveCancelRequestBean.getLeaveBean().getLeave_From());
				Date result2 = formater1.parse(leaveCancelRequestBean.getLeaveBean().getLeave_To());
				SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
				leaveFromDate = formater2.format(result1);
				leaveToDate = formater2.format(result2);
			
			}
			catch (ParseException e1) 
			{
				e1.printStackTrace();
			}	
			
			
			if(leaveCancelRequestBean.getLeave_cancel_type() == 2){
				try 
				{
				  
					SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
					Date result1 = formater1.parse(leaveCancelRequestBean.getUpdated_leave_from());
					Date result2 = formater1.parse(leaveCancelRequestBean.getUpdated_leave_to());
					SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
					updatedLeaveFromDate = formater2.format(result1);
					updatedLeaveToDate = formater2.format(result2);
				
				}
				catch (ParseException e1) 
				{
					e1.printStackTrace();
				}
			}
			
			
			
			String lf = leaveFromDate;
			String lt = leaveToDate;
			String ulf = updatedLeaveFromDate;
			String ult = updatedLeaveToDate;
			
			
			if(leaveCancelRequestBean.getApproved_status().equalsIgnoreCase("pending")){
				
				System.out.println("updated leave pending");
				
				System.out.println(leaveCancelRequestBean.getLeaveBean().getLeave_id()+" "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname());
				System.out.println(mngEmail);
				
				
				new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	String to = mngEmail;
				    	
				    	String leavefrom = lf;
				    	String leaveto = lt;
				    	double days = leaveCancelRequestBean.getLeaveBean().getDay_count();
				    	String mobileNo = leaveCancelRequestBean.getLeaveBean().getNumber(); 
				    	String reasonForCancellation = leaveCancelRequestBean.getReason(); 
				    	int emp_code = leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getEmployee_code();
				    	
				    	
				    	
				    	
				    	if(leaveCancelRequestBean.getLeave_cancel_type() == 1){
				    		String sub = name + " Requested for Leave Cancellation.";
				    		Mailer.pendingCancelLeaveType1(to, sub, leavefrom, leaveto, days, emp_code,mobileNo,name,reasonForCancellation);
				    		System.out.println("Done : "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getLeave_From()+" to "+leaveCancelRequestBean.getLeaveBean().getLeave_To());
					    	boolean result = allUpdateDAO.cancelLeaveMailUpdate(leaveCancelRequestBean.getLeaveBean().getLeave_id());
				    	}else if(leaveCancelRequestBean.getLeave_cancel_type() == 2){
				    		String sub = name + " Requested for Leave Update.";
				    		String update_leave_from = ulf;
					    	String update_leave_to = ult;
					    	double updatedDays =leaveCancelRequestBean.getUpdated_day_count();
				    		Mailer.pendingCancelLeaveType2(to, sub, leavefrom, leaveto, days, emp_code,mobileNo,name,update_leave_from,update_leave_to,updatedDays,reasonForCancellation);
				    		System.out.println("Done : "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getLeave_From()+" to "+leaveCancelRequestBean.getLeaveBean().getLeave_To());
					    	boolean result = allUpdateDAO.cancelLeaveMailUpdate(leaveCancelRequestBean.getLeaveBean().getLeave_id());
				    	}
				    	
				    	
				    }
				}).start();
				
			}else if(leaveCancelRequestBean.getApproved_status().equalsIgnoreCase("rejected") ){
				
				System.out.println("updated leave rejected");
				
				System.out.println(leaveCancelRequestBean.getLeaveBean().getLeave_id()+" "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname());
				System.out.println(empEmail);
				
				
				new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	String to = empEmail;
				    	String leavefrom = lf;
				    	String leaveto = lt;
				    	double days = leaveCancelRequestBean.getLeaveBean().getDay_count();
				    	String mobileNo = leaveCancelRequestBean.getLeaveBean().getNumber(); 
				    	int emp_code = leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getEmployee_code();
				    	String status = "Rejected";
				    	
				    	
				    	
				    	if(leaveCancelRequestBean.getLeave_cancel_type() == 1){
				    		String sub = name + " Your Leave Cancellation Request is Rejected.";
				    		Mailer.approveRejectCancelLeaveType1(to, sub, leavefrom, leaveto, days, emp_code, mobileNo, name, status);
				    		System.out.println("Done : "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getLeave_From()+" to "+leaveCancelRequestBean.getLeaveBean().getLeave_To());
					    	boolean result = allUpdateDAO.cancelLeaveMailUpdate(leaveCancelRequestBean.getLeaveBean().getLeave_id());
				    	}else if(leaveCancelRequestBean.getLeave_cancel_type() == 2){
				    		String sub = name + " Your Leave Update Request is Rejected.";
				    		String update_leave_from = ulf;
					    	String update_leave_to = ult;
					    	double updatedDays =leaveCancelRequestBean.getUpdated_day_count();
				    		Mailer.approveRejectCancelLeaveType2(to, sub, leavefrom, leaveto, days, emp_code, mobileNo, name, update_leave_from, update_leave_to, updatedDays, status);
				    		System.out.println("Done : "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getLeave_From()+" to "+leaveCancelRequestBean.getLeaveBean().getLeave_To());
					    	boolean result = allUpdateDAO.cancelLeaveMailUpdate(leaveCancelRequestBean.getLeaveBean().getLeave_id());
				    	}
				    	
				    }
				}).start();
				
			}else if(leaveCancelRequestBean.getApproved_status().equalsIgnoreCase("approved")){
				
				System.out.println("updated leave approved");
				
				System.out.println(leaveCancelRequestBean.getLeaveBean().getLeave_id()+" "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname());
				System.out.println(empEmail);
				
				
				new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	String to = empEmail;
				    	String leavefrom = lf;
				    	String leaveto = lt;
				    	double days = leaveCancelRequestBean.getLeaveBean().getDay_count();
				    	String mobileNo = leaveCancelRequestBean.getLeaveBean().getNumber(); 
				    	int emp_code = leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getEmployee_code();
				    	String status = "Approved";
				    	
				    	
				    	
				    	if(leaveCancelRequestBean.getLeave_cancel_type() == 1){
				    		String sub = name + " Your Leave Cancellation Request is Approved.";
				    		Mailer.approveRejectCancelLeaveType1(to, sub, leavefrom, leaveto, days, emp_code, mobileNo, name, status);
				    		System.out.println("Done : "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getLeave_From()+" to "+leaveCancelRequestBean.getLeaveBean().getLeave_To());
					    	boolean result = allUpdateDAO.cancelLeaveMailUpdate(leaveCancelRequestBean.getLeaveBean().getLeave_id());
				    	}else if(leaveCancelRequestBean.getLeave_cancel_type() == 2){
				    		String sub = name + " Your Leave Update Request is Approved.";
				    		String update_leave_from = ulf;
					    	String update_leave_to = ult;
					    	double updatedDays =leaveCancelRequestBean.getUpdated_day_count();
				    		Mailer.approveRejectCancelLeaveType2(to, sub, leavefrom, leaveto, days, emp_code, mobileNo, name, update_leave_from, update_leave_to, updatedDays, status);
				    		System.out.println("Done : "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getLeave_From()+" to "+leaveCancelRequestBean.getLeaveBean().getLeave_To());
					    	boolean result = allUpdateDAO.cancelLeaveMailUpdate(leaveCancelRequestBean.getLeaveBean().getLeave_id());
				    	}
				    	
				    }
				}).start();
				
				
			}
		
		}
	
	
	}

}
