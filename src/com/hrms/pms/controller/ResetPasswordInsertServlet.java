package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.dao.LoginDAO;

public class ResetPasswordInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
	int emp_code = Integer.parseInt(request.getParameter("emp_code"));
	int password = Integer.parseInt(request.getParameter("old_pass"));
	int company_id = user.getCompanyListBean().getCompany_list_id();
	String email_id = request.getParameter("email");
	String new_pass = request.getParameter("new_pass");
	String re_pass = request.getParameter("re_pass");
	
	LoginDAO loginDAO = new LoginDAO();
	
	EmployeeBean employeeBean = loginDAO.getUserDetails(emp_code, password,company_id);
	
	if(employeeBean == null){
		System.out.println("not valid");
		request.setAttribute("notmatch", "Employee code and old password are not match");
		request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
	}else if(new_pass.equalsIgnoreCase(re_pass)){
		int employee_id = employeeBean.getEmployee_master_id();
		int id = employeeBean.getRoleBean().getRole_id();
		String authority = employeeBean.getRoleBean().getRole_authority();
		boolean result = loginDAO.employeeUpdate(employee_id, new_pass,email_id);
		int manager_id = employeeBean.getManagerBean().getManager_id();
		int under_manager_id = Integer.parseInt(employeeBean.getUnder_manager_id());
		request.setAttribute("success", "password change successfully");
		
		
		
		
		if (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
				|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
				|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")) {

if(manager_id != 99){
if(manager_id == 1 || manager_id == 2 || manager_id == 3){
 session.setAttribute("user", employeeBean);
 request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
 session.setAttribute("user", employeeBean);
 request.getRequestDispatcher("hrHome.jsp").forward(request, response);
}else{
 session.setAttribute("user", employeeBean);
 request.getRequestDispatcher("managerHome.jsp").forward(request, response);
}	
}else{
	if(under_manager_id == 4 || under_manager_id == 117){
		request.getRequestDispatcher("hrHome.jsp").forward(request, response);
	}else{
		request.getRequestDispatcher("empHome.jsp").forward(request, response);
				}
			}
	
}
		
		
	}else{
		request.setAttribute("repass", "password and re-enter password are not matched");
		 request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
	}
		
	
	
		
	}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
