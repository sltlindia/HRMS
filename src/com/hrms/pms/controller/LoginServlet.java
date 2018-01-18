package com.hrms.pms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;



public class LoginServlet extends HttpServlet {
	
	private List sessions = new ArrayList();
	
	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	
		
     int companyId = Integer.parseInt(request.getParameter("companyId"));
	 int employee_code = Integer.parseInt(request.getParameter("employee_code"));	
	 String password = request.getParameter("password");
	 System.out.println("pass:"+password);
	 System.out.println("companyId :"+companyId);
	 
	 LoginDAO loginDAO = new LoginDAO();
	 boolean result = loginDAO.authenticateUser(companyId,employee_code, password);
	 EmployeeBean employeeBean = loginDAO.getUserByUserId(companyId,employee_code);
	 if(employeeBean != null){
	 if(result == true){
		 int id = employeeBean.getRoleBean().getRole_id();
		 int code = employeeBean.getEmployee_code();
		 String authority = employeeBean.getRoleBean().getRole_authority();
		 String emp_code = String.valueOf(code);
		 String pass =  employeeBean.getPassword();
		 int manager_id = employeeBean.getManagerBean().getManager_id();
		 int under_manager_id = Integer.parseInt(employeeBean.getUnder_manager_id());
		 int role_id = employeeBean.getRoleBean().getRole_id();
		 
		 System.out.println(pass);
		 System.out.println(emp_code);
			
			if (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
					|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
					|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
					|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {

if(manager_id != 99){
	
if(manager_id == 1 || manager_id == 2 || manager_id == 3){
	HttpSession session = request.getSession();
	 session.setAttribute("user", employeeBean);
	 if(pass.equals(emp_code)){
		 response.sendRedirect("resetPassword.jsp");
	 }else{
		 response.sendRedirect("sltlAdmin.jsp");
	 }
}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
	HttpSession session = request.getSession();
	 session.setAttribute("user", employeeBean);
	if(pass.equals(emp_code)){
		 response.sendRedirect("resetPassword.jsp");
	 }else{
		 response.sendRedirect("hrHome.jsp");
	 }
}else{
	HttpSession session = request.getSession();
	 session.setAttribute("user", employeeBean);
	if(pass.equals(emp_code)){
		 response.sendRedirect("resetPassword.jsp");
	 }else{
		 response.sendRedirect("managerHome.jsp");
	 }

}	
}else{ 
	
	if((code == 30 || code == 2 || code == 8 ||code == 15) && companyId == 1){
			 HttpSession session = request.getSession();
			 session.setAttribute("user", employeeBean);
			 response.sendRedirect("gatePassListSecurity.jsp");
	}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
		HttpSession session = request.getSession();
		 session.setAttribute("user", employeeBean);
		if(pass.equals(emp_code)){
			 response.sendRedirect("resetPassword.jsp");
		 }else{
			 response.sendRedirect("hrHome.jsp");
		 }
	}else{
	
	HttpSession session = request.getSession();
	 session.setAttribute("user", employeeBean);
	 
	/* List<EmployeeBean> sessionList = new ArrayList<>();
	 sessionList.add(employeeBean);
	 session.setAttribute("listOfSession", sessionList);*/
	 
	 
	if(pass.equals(emp_code)){
		 response.sendRedirect("resetPassword.jsp");
	 }else{
		 response.sendRedirect("empHome.jsp");
	 }
	}
} 	
		
}
		
	 }
	 else{
		 request.setAttribute("error", "Invalid Id and password Or this Employee Resign...");
		 request.getRequestDispatcher("login.jsp").forward(request, response);
	 }
	 }else{
		 request.setAttribute("error", "Invalid Id and password Or this Employee Resign...");
		 request.getRequestDispatcher("login.jsp").forward(request, response);
	 }
}

}