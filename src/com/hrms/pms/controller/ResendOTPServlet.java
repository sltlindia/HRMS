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

public class ResendOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean employeeBean = (EmployeeBean) session.getAttribute("forgotPassword");
		
		int emp_id = employeeBean.getEmployee_master_id();
		String email_id = employeeBean.getEmail_id();
		
		Random random = new Random();
		 int otp = random.nextInt(987654);
		 
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
		 
		 
		 request.setAttribute("success", "OTP Resend successfully to your registerd email id.");
		 request.getRequestDispatcher("otpVerification.jsp").forward(request, response);
		
	}

}
