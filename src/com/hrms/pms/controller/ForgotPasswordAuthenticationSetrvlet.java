package com.hrms.pms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.OTPBean;
import com.hrms.pms.dao.AllDeleteDAO;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.LoginDAO;

public class ForgotPasswordAuthenticationSetrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int company_id =Integer.parseInt(request.getParameter("companyId"));
	int emp_code =Integer.parseInt(request.getParameter("employee_code"));
	String email_id = request.getParameter("email_id");
	
	LoginDAO loginDAO = new LoginDAO();
	EmployeeBean employeeBean = loginDAO.getUserInfoForForgotPassWord(company_id, emp_code, email_id);
	
	if(employeeBean != null){
		 HttpSession session = request.getSession();
		 session.setAttribute("user", employeeBean);
		 Random random = new Random();
		 
		 int otp = random.nextInt(987654);
		 System.out.println("OTP"+otp);
		
		 int emp_id = employeeBean.getEmployee_master_id();
		 employeeBean.setEmployee_master_id(emp_id);
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String date1 = sdf.format(date);
			
		 
		 
		 new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	 String subject = "Your OTP";

			    	 Mailer.otpSend(email_id, subject, otp);			    }
			}).start();
		 
		 AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		 boolean result1 = allDeleteDAO.OTPDeleted(emp_id);
		 
		 OTPBean otpBean = new OTPBean(otp, date1, employeeBean);
		 AllInsertDAO allInsertDAO  = new AllInsertDAO();
		 boolean result = allInsertDAO.otpInsert(otpBean);

		 request.setAttribute("success", "Your OTP will be send on your Email.");
		 request.getRequestDispatcher("otpVerification.jsp").forward(request, response);
	}else {
		request.setAttribute("fail", "Email id not match with your Emloyee Code");
		request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
	}
	
	
	}

}
