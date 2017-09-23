package com.hrms.probation.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.probation.bean.ProbationAssessmentM1Bean;
import com.hrms.probation.bean.ProbationAssessmentM2Bean;
import com.hrms.probation.dao.AllListProbationDAO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class ProbationScoreCheckServlet
 */
public class ProbationScoreCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	EmployeeBean user = (EmployeeBean)session.getAttribute("user");
	if(user!=null){
	int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
	String mm_id = request.getParameter("month_id");
	int month_id = 0;
	int yearId = 0;
	
	LoginDAO loginDAO = new LoginDAO();
	AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
	EmployeeBean employeeBean = loginDAO.getInfoById(employee_master_id);
	String authority = employeeBean.getRoleBean().getRole_authority();
	String[] split = mm_id.split(",");
	month_id = Integer.parseInt(split[0]);
	yearId = Integer.parseInt(split[1]);
	
	EmployeeBean employeeBean1 = loginDAO.getEmailIdEmployee(employee_master_id);
	
	String joining_date = employeeBean1.getJoining_date();
	Date date1 = null;
	try {
		date1 = new SimpleDateFormat("yyyy-MM-dd").parse(joining_date);
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Calendar cal = Calendar.getInstance();
	cal.setTime(date1);
	int join_month_id = cal.get(Calendar.MONTH) + 1;
	int year_id = cal.get(Calendar.YEAR);
	
	int day = cal.get(Calendar.DAY_OF_MONTH);
	if (day >= 15) {
		join_month_id = join_month_id + 1;
		System.out.println("join_month"+join_month_id);
	}
	
	System.out.println("month_id:"+month_id);
	
	if(join_month_id == month_id && year_id == yearId){
		request.getRequestDispatcher("probationForm.jsp").forward(request, response);
	}else{
	
	month_id = month_id - 1;
	if(month_id == 0){
		month_id = 12;
		yearId = yearId - 1;
	}	
	System.out.println("month"+month_id);
		
		AllListProbationDAO allListProbationDAO1 = new AllListProbationDAO();
		List<ProbationAssessmentM2Bean> listOfEmployeesM2 = allListProbationDAO1
				.getProbationCheckMonthM2YearName(employee_master_id, month_id, yearId);
		
		if(listOfEmployeesM2.size() != 0){
			request.getRequestDispatcher("probationForm.jsp").forward(request, response);
			
		}
		else{
		request.setAttribute("monthCheck", "Previous Month's Score is not submitted yet");
		request.getRequestDispatcher("probationForm.jsp").forward(request, response);
		
		}
		
	}
	
	
		}else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
}