package com.hrms.lms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCancelRequestBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class LeaveUpdateForApprovanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
	int leave_id = Integer.parseInt(request.getParameter("leaveid"));
	
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	String leavefromDate = request.getParameter("leavefromDate");
	String leavetoDate = request.getParameter("leavetoDate");
	String leaveFromPast = request.getParameter("leaveFromPast");
	String leaveToPast = request.getParameter("leaveToPast");
	String purposeOfLeave = request.getParameter("purposeofleave");
	String contactAddress = request.getParameter("contactAddress");
	String contactNumberDuringLeave = request.getParameter("contactNumberDuringLeave");
	String pastFromDate = request.getParameter("pastFromDate");
	String pastToDate = request.getParameter("pastToDate");
	int manager_id =Integer.parseInt(user.getUnder_manager_id());
	int emp_id = Integer.parseInt(request.getParameter("empcode"));
	double day =Double.parseDouble(request.getParameter("daycount"));
	double taotalDays =Double.parseDouble(request.getParameter("totalDays"));
	String reason = request.getParameter("reason");
	int type = 2;
	String approved_status = "pending";
	int mail_view = 0;
	
	LoginDAO loginDAO = new LoginDAO();
	EmployeeBean employeeBean2 = loginDAO.getEmailId(manager_id);
	String EmailId = employeeBean2.getEmail_id();
	String name = user.getFirstname()+" "+user.getLastname();
	
	double daycount = taotalDays - day;
	System.out.println(daycount);
	try {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		Date result = formater.parse(fromDate);
		Date result1 = formater.parse(toDate);
		SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		fromDate = AppDateFormat.format(result);
		toDate = AppDateFormat.format(result1);
	} catch (ParseException e1) {
		e1.printStackTrace();
	}		
		
		
	LeaveBean leaveBean = new LeaveBean();
	leaveBean.setLeave_id(leave_id);
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	boolean result = allUpdateDAO.LeaveApproveupdate(purposeOfLeave, pastFromDate, pastToDate, taotalDays, contactAddress, contactNumberDuringLeave,leave_id,leaveFromPast,leaveToPast);
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();		
	
	if(taotalDays != day){
	LeaveCancelRequestBean leaveCancelRequestBean = new LeaveCancelRequestBean(type, reason, approved_status, fromDate, toDate, day, leavefromDate, leavetoDate, leaveBean,mail_view);
	boolean result1 = allInsertDAO.leaveCancelRequestInsert(leaveCancelRequestBean);
	}
	/*String fd = null;
	String td = null;
	String pfd = null;
	String ptd = null;
	
	
	try 
	{
	  
		SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
		Date result11 = formater1.parse(fromDate);
		Date result22 = formater1.parse(toDate);
		Date result33 = formater1.parse(pastFromDate);
		Date result44 = formater1.parse(pastToDate);
		SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
		fd = formater2.format(result11);
		td = formater2.format(result22);
		pfd = formater2.format(result33);
		ptd = formater2.format(result44);
	
	}
	catch (ParseException e1) 
	{
		e1.printStackTrace();
	}	
	
	String fd1 = fd;
	String td1 = td;
	String pfd1 = pfd;
	String ptd1 = ptd;
	
		    	String to = EmailId;
		    	String sub = name + " updated it's leave";
		    	double days = day;
		    	int emp_code = user.getEmployee_code();
		    
		    	Mailer.approveMail(to, sub, fd1, td1, days, emp_code,pfd1,ptd1);*/
		    	
	
	request.setAttribute("LeaveSuccessfully", "Your leave successfully updated..");
	/*request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);*/
	response.sendRedirect("leavesuccess.jsp");
	
	
	}

}
