package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.OTPBean;
import com.hrms.pms.dao.LoginDAO;


public class OtpAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
		 EmployeeBean employeeBean = (EmployeeBean) session.getAttribute("user");
		 
		 String otp = request.getParameter("otp");
		 int emp_id = employeeBean.getEmployee_master_id();
		 
		 
		 LoginDAO loginDAO = new LoginDAO();
		 OTPBean otpBean = loginDAO.otpAuthentication(otp, emp_id);
		 if(otpBean != null){
			 request.setAttribute("success", "OTP verified successfully.");
			 request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		 }else{
			 request.setAttribute("error", "Incorrect OTP. Please enter correct OTP here.");
			 request.getRequestDispatcher("otpVerification.jsp").forward(request, response);
		 }
	
	
	}

}
