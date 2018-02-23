package com.hrms.lms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeaveAfterAddBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.dao.AllDeleteDAO;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class EmailLeaveUpdate
 */
public class EmailLeaveUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		String Status  = null;
		int Leave_id = 0;
		int empid = 0;
		String reason = null;
		String typeofleave = null;
		String adjustofleave = null;
		double daycount = 0;
		double temp = 0;
		double leaveday = 0;
		double adjvalue = 0;
		double finaladjvalue1 = 0 , finaladjust2 = 0;
		double plan = 0;
		double unplan = 0;
		double CO = 0 , PL = 0 , SL = 0 , LWP = 0 , oldLWP=0, sum=0;
		double CUTCO = 0, CUTPL = 0, CUTSL = 0 , CUTLWP = 0;
		double MAINCO = 0, MAINPL = 0, MAINSL = 0;
		 double Study =0;
		 int mail_view = 1;
		// double CO =0;
		 
		 int leaveTypeId = 0;
		 int Approval_By = 0;
		Status = request.getParameter("status");
		reason = request.getParameter("remarks");
		typeofleave = request.getParameter("typeofleave");
		adjustofleave = request.getParameter("adjustofleave");
		//adjvalue = Double.parseDouble(request.getParameter("adjvalue"));
		daycount = Double.parseDouble(request.getParameter("numdays"));
		Leave_id = Integer.parseInt(request.getParameter("leaveid"));
		//leaveday = Double.parseDouble(request.getParameter("typeofleavedatabase"));
		empid = Integer.parseInt(request.getParameter("empcode"));
		
		CO = Double.parseDouble(request.getParameter("CO"));
		PL = Double.parseDouble(request.getParameter("plan"));
		SL = Double.parseDouble(request.getParameter("unplan"));
		LWP = Double.parseDouble(request.getParameter("LWP"));
		CUTCO = Double.parseDouble(request.getParameter("CUTCO"));
		CUTPL = Double.parseDouble(request.getParameter("CUTPL"));
		CUTSL = Double.parseDouble(request.getParameter("CUTSL"));
		CUTLWP = Double.parseDouble(request.getParameter("CUTLWP"));
		
		String colunmname1 = "CO";
		String colunmname2 = "Plan_Leave";
		String colunmname3 = "Unplan_Leave";
		String colunmname4 = "Leave_without_pay";
		 plan =  Double.parseDouble(request.getParameter("plan"));
		 unplan =  Double.parseDouble(request.getParameter("unplan"));
		/* Casual =  Double.parseDouble(request.getParameter("Casual"));
		 Maternity = Double.parseDouble(request.getParameter("Maternity"));
		 WithoutPay = Double.parseDouble(request.getParameter("WithoutPay"));
		 Study  =  Double.parseDouble(request.getParameter("Study"));*/
		 //CO =  Double.parseDouble(request.getParameter("CO"));
		
		
		System.out.println("Status " + Status);
		System.out.println("Reason " + reason);
		System.out.println("Leave Id " + Leave_id);
		System.out.println("Emp Code " + empid);
		System.out.println("Leave type " +  typeofleave);
		System.out.println("Leave Day Count " +  leaveday);
		System.out.println("adjust Leave type " +  adjustofleave);
		System.out.println("adjust Leave Day Count " +  adjvalue);
		System.out.println("day Count " + daycount);
		/*System.out.println("Privilage  " + privilege);*/
		
		
		System.out.println("CO " + CO);
		System.out.println("PL " + PL);
		System.out.println("UPL " + SL);
		System.out.println("LWP " + LWP);
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		LeaveBean leaveBean = new LeaveBean();
		
		leaveBean.setLeave_id(Leave_id);
		
		LoginDAO loginDAO = new LoginDAO();
		AllListDAO allListDAO2 = new AllListDAO();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		EmployeeBean employeeBean2 = loginDAO.getEmailIdEmployee(empid);
		String EmailId = employeeBean2.getEmail_id();
		int emp_code = employeeBean2.getEmployee_code();
		String name =employeeBean2.getFirstname()+" "+employeeBean2.getLastname();
		
		 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String approvalDate = sdf.format(date);
		 
		List<LeaveBean> leaveInfo = allListDAO2.getLeaveByLeaveId(Leave_id);
		String to = null;
		String from = null;
		int code = 0;
		for(LeaveBean l : leaveInfo){
			to = l.getLeave_To();
			from =l.getLeave_From();
			Approval_By = l.getUnder_manager_id();
			
			EmployeeBean employeeBean = loginDAO.getEmailId(Approval_By);
			code = employeeBean.getEmployee_code();
		}
		
		
		
		String lfff = null;
		String tlll = null;
		
		try 
		{
		  
			SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
			Date result1 = formater1.parse(from);
			Date result2 = formater1.parse(to);
			SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
			lfff = formater2.format(result1);
			tlll = formater2.format(result2);
		
		}
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}	
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date today = Calendar.getInstance().getTime();  
	
		String date1= dateFormat.format(today);
	
		String Approval_Date = null;
		String currentdate = null;
	
	try {
		  
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		Date result = formater.parse(date1);
		SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		currentdate = AppDateFormat1.format(result);
		Approval_Date = AppDateFormat.format(result);
		System.out.println(AppDateFormat.format(result));
	}
	catch (ParseException e1)
	{
		e1.printStackTrace();
	}
		
	
		if(Status.equals("approved"))
		{
			
			AllListDAO allListDAO = new AllListDAO();
			List<LeaveAfterAddBean> listOfLeave = allListDAO.getLeaveAddAfter(Leave_id);
			if(listOfLeave.size() != 0){
			for(LeaveAfterAddBean l : listOfLeave){
				
				double co = l.getCO();
				double pl = l.getPL();
				double sl = l.getSL();
				double lwp = l.getLWP();
				int emp_id = l.getLeaveBean().getEmployeeBean().getEmployee_master_id();
				
				boolean result11 = allUpdateDAO.LeaveUpdateAfterApproved(emp_id, co, pl, sl, lwp);
				
				CO = co;
				PL = pl;
				SL = sl;
				LWP = lwp;
				
			}
			}
			
			if(daycount == 0.0)
			{
				Status = "Cancelled ";
				sum = LWP + oldLWP;
				boolean result = allUpdateDAO.LeaveUpdateStatus(Status , Leave_id,approvalDate);
				boolean result1 = allUpdateDAO.LeaveUpdate1(colunmname1, CO, colunmname2, PL, colunmname3, SL, colunmname4, sum, empid);
				if(result == true || result1 == true)
				{
					System.out.println("Successfully");
					request.setAttribute("LeaveapprovedSuccessfully", "Leave approved Successfully");
				}	
			}
			else
			{
				
				
				System.out.println("	BALANCE  CO " + CO);
				System.out.println(" 	BALANCE PL " + PL);
				System.out.println(" 	BALANCE UPL " + SL);
				System.out.println("	BALANCE  LWP " + LWP);
				System.out.println("	CUTCO " + CUTCO);
				System.out.println("	CUTPL " + CUTPL);
				System.out.println("	CUTUPL " + CUTSL);
				System.out.println("    CUTLWP " + CUTLWP);
				
				LocalDate leaveStart = LocalDate.parse(from);
				LocalDate leaveEnd = LocalDate.parse(to);
				
				String coStartDate = null;
				String coEndDate = null;
				String plStartDate = null;
				String plEndDate = null;
				String slStartDate = null;
				String slEndDate = null;
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
				if(CO != 0)
				{
					MAINCO = CO - CUTCO;
					if(CUTCO != 0){
					coStartDate = formatter.format(leaveStart);
					leaveStart = leaveStart.plusDays(((int)CUTCO - 1));
					coEndDate = formatter.format(leaveStart);
					leaveStart = leaveStart.plusDays(1);
					}
				}
				else
				{
					MAINCO = CO;
				}
				if(PL != 0)
				{
					MAINPL = PL - CUTPL;
					if(CUTPL != 0){
					plStartDate = formatter.format(leaveStart);
					leaveStart = leaveStart.plusDays(((int)CUTPL - 1));
					plEndDate = formatter.format(leaveStart);
					leaveStart = leaveStart.plusDays(1);
					}
				}
				else
				{
					MAINPL = PL;
				}
				if(SL != 0)
				{
					MAINSL = SL - CUTSL;
					if(CUTSL != 0){
					slStartDate = formatter.format(leaveStart);
					leaveStart = leaveStart.plusDays(((int)CUTSL - 1));
					slEndDate = formatter.format(leaveStart);
					leaveStart = leaveStart.plusDays(1);
					}
				}
				else
				{
					MAINSL = SL;
				}
				
				 System.out.println("coStart:"+coStartDate);
				 System.out.println("coEnd:"+coEndDate);
				 System.out.println("plStart:"+plStartDate);
				 System.out.println("plEnd:"+plEndDate);
				 System.out.println("slStart:"+slStartDate);
				 System.out.println("slEnd:"+slEndDate);
				
				sum = LWP + CUTLWP;
			
				boolean result = allUpdateDAO.LeaveUpdateStatus(Status , Leave_id, approvalDate);
				boolean result1 = allUpdateDAO.LeaveUpdate1(colunmname1, MAINCO, colunmname2, MAINPL, colunmname3, MAINSL, colunmname4, sum, empid);
				
				LeaveHRBean leaveHRBean = new LeaveHRBean();
				EmployeeBean employeeBean = new EmployeeBean();
				AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
				employeeBean.setEmployee_master_id(empid);
				
				
				
				
				if(result == true || result1 == true)
				{
					
					
					if(coStartDate != null)
					{
						System.out.println("co");
						leaveTypeId = 0;
						allDeleteDAO.laveHrDelete(Leave_id);
						leaveHRBean = new LeaveHRBean(leaveTypeId , employeeBean ,coStartDate , coEndDate , Approval_Date, code,leaveBean);
						allInsertDAO.leaveHRInsert(leaveHRBean);
						
					}
					
					if(plStartDate != null)
					{
						System.out.println("pl");
						leaveTypeId = 1;
						allDeleteDAO.laveHrDelete(Leave_id);
						leaveHRBean = new LeaveHRBean(leaveTypeId , employeeBean ,plStartDate , plEndDate , Approval_Date, code,leaveBean);
						allInsertDAO.leaveHRInsert(leaveHRBean);
					}
					
					if(slStartDate != null)
					{
						System.out.println("sl");
						leaveTypeId = 5;
						allDeleteDAO.laveHrDelete(Leave_id);
						leaveHRBean = new LeaveHRBean(leaveTypeId , employeeBean ,slStartDate , slEndDate , Approval_Date, code,leaveBean);
						allInsertDAO.leaveHRInsert(leaveHRBean);
					}
					
					System.out.println("Successfully");
					
					if(request.getAttribute("action") == null){
						
					String to1 = tlll;
					String from1 = lfff;
					double days1 = daycount;
					String reason1 = reason;
					System.out.println("EmailID:"+EmailId);
					int lid = Leave_id; 
					
					
					 new Thread(new Runnable() {
						    @Override
						    public void run() {
						    	
						    	String to = EmailId;
						    	String sub = name+" Your Leave Approved.";
						    	double days = days1;
						    	String leavefrom = from1;
						    	String leaveto = to1 ;
						    	String status = "Approved";
						    		
						    	Mailer.send1(to, sub, leavefrom, leaveto, days,status,reason1,emp_code,name);
						    	boolean result = allUpdateDAO.LeaveMailUpdate(lid,mail_view);
						    	
						    }
						}).start();
					
					
					}
					
						 request.setAttribute("success", "Leave Successfully Approved By You");
						 /*request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);*/
						 response.sendRedirect("emailSuccess.jsp");
					
				}	
			}
			
		}
		else if(Status.equals("rejected"))
		{
			boolean result = allUpdateDAO.LeaveStatusreject(Status, reason, Leave_id,approvalDate);
			if(result == true)
			{
				System.out.println("Successfully");
				

				String to1 = tlll;
				String from1 = lfff;
				double days1 = daycount;
				String reason1 = reason;
				System.out.println("EmailID:"+EmailId);
				
				int lid = Leave_id;
				 new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = EmailId;
					    	String sub = name+" Your Leave Rejected.";
					    	double days = days1;
					    	String leavefrom = from1;
					    	String leaveto = to1 ;
					    	String status = "Rejected";
					    	
					    		Mailer.send1(to, sub, leavefrom, leaveto, days,status,reason1,emp_code,name);
					    		boolean result = allUpdateDAO.LeaveMailUpdate(lid,mail_view);
					    }
					}).start();
					    	

				 		request.setAttribute("error", "Leave Successfully Rejected By You");
						/*request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);*/
				 		response.sendRedirect("emailSuccess.jsp");
				
			}
		}
		
	
		
		
	}


}
