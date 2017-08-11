package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;

public class CriteriaAdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
	int manager_id =Integer.parseInt(request.getParameter("manager_id"));
	int dept_id =Integer.parseInt(request.getParameter("dept_id"));
	int year =Integer.parseInt(request.getParameter("year"));
	String[] month = request.getParameterValues("chkMonth");
	String[] employee_master_id = request.getParameterValues("chkEmployee");
	int project_id = Integer.parseInt(request.getParameter("rdbProject"));
	int technical_per = Integer.parseInt(request.getParameter("technical_per"));
	int softskill_per = Integer.parseInt(request.getParameter("softskill_per"));
	String[] technical_id = request.getParameterValues("chkTechnical");
	String[] softskill_id = request.getParameterValues("chkSoftskill");
	
	String allTechnical="";
	String allSoftskill="";
	String services="";
	String t1 =null;
	String t2 =null;
	String t3 =null;
	String t4 =null;
	String t5 =null;
	String t6 =null;
	String t7 =null;
	String t8 =null;
	String t9 =null;
	String t10 =null;
	String t11 =null;
	String t12 =null;
	String s1 =null;
	String s2 =null;
	String s3 =null;
	String s4 =null;
	String s5 =null;
	String s6 =null;
	String s7 =null;
	String s8 =null;
	String s9 =null;
	String s10 =null;
	String s11 =null;
	String s12 =null;
	String s13 =null;
	String s14 =null;
	
	EmployeeBean employeeBean = new EmployeeBean();	
	MonthBean monthBean = new MonthBean();
	YearBean yearBean = new YearBean();
	ProjectMasterBean projectMasterBean = new ProjectMasterBean();
	
	System.out.println("Year:"+year);
	System.out.println("project:"+project_id);
	
	yearBean.setYear_id(year);
	projectMasterBean.setProject_master_id(project_id);
	
	for(String chkmonth : month ){
		System.out.println("month:"+chkmonth);
	}
	
	
	
	for(int i=0;i<=technical_id.length;i++){
		
	}
	for(String technical : technical_id ){
		allTechnical += technical + ",";
	}
	
	System.out.println("s:"+allTechnical);
	
	String[] splitValues = allTechnical.split(",");
	
	for(int i=0;i<splitValues.length;i++){
		System.out.println("String :"+splitValues[i]);
		if(splitValues[i].equalsIgnoreCase("1")){
			t1 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("2")){
			t2 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("3")){
			t3 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("4")){
			t4 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("5")){
			t5 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("6")){
			t6 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("7")){
			t7 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("8")){
			t8 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("9")){
			t9 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("10")){
			t10 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("11")){
			t11 = splitValues[i];
		}
		if(splitValues[i].equalsIgnoreCase("12")){
			t12 = splitValues[i];
		}
		
	}
	
	for(String softskill : softskill_id ){
		allSoftskill += softskill + ",";
	}
	
	System.out.println("s:"+allSoftskill);
	
	String[] splitValue = allSoftskill.split(",");
	for(int i=0;i<splitValue.length;i++){
		System.out.println("String :"+splitValue[i]);
		if(splitValue[i].equalsIgnoreCase("1")){
			s1 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("2")){
			s2 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("3")){
			s3 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("4")){
			s4 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("5")){
			s5 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("6")){
			s6 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("7")){
			s7 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("8")){
			s8 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("9")){
			s9 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("10")){
			s10 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("11")){
			s11 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("12")){
			s12 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("13")){
			s13 = splitValue[i];
		}
		if(splitValue[i].equalsIgnoreCase("14")){
			s14 = splitValue[i];
		}
		
		
		
	}
	
	System.out.println(t1);
	System.out.println(t2);
	System.out.println(t3);
	System.out.println(t4);
	System.out.println(t5);
	System.out.println(t6);
	System.out.println(t7);
	System.out.println(t8);
	System.out.println(t9);
	System.out.println(t10);
	System.out.println(t11);
	System.out.println(t12);
	
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	System.out.println(s4);
	System.out.println(s5);
	System.out.println(s6);
	System.out.println(s7);
	System.out.println(s8);
	System.out.println(s9);
	System.out.println(s10);
	System.out.println(s11);
	System.out.println(s12);
	System.out.println(s13);
	System.out.println(s14);
	
	
	
	for(String employee : employee_master_id ){
		System.out.println("employee:"+employee);
		int employee1 = Integer.parseInt(employee);
		employeeBean.setEmployee_master_id(employee1);;
			for(String chkmonth : month ){
		System.out.println("month:"+chkmonth);
			int Month = Integer.parseInt(chkmonth);
			monthBean.setMonth_id(Month);
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		boolean result = allInsertDAO.specificCrieriaInsert(yearBean, projectMasterBean, monthBean, employeeBean,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,manager_id,dept_id,technical_per,softskill_per);
	}

	}
	response.sendRedirect("projAdmin.jsp");
	return;
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
	}

}
