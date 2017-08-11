package com.hrms.lms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.IntervieweeBean;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

public class IntervieweeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
		if(request.getParameter("outTimeUpdate") != null){
			
			int interviewee_id = Integer.parseInt(request.getParameter("interviewee_id"));
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = new Date();
			String interviewee_out_time = sdf1.format(date1);
			boolean result = allUpdateDAO.intervieweeOutTimeUpdate(interviewee_id, interviewee_out_time);
			request.getRequestDispatcher("addInterviewee.jsp").forward(request, response);
			
		}else{
			String interviewee_name = request.getParameter("name");
			String date_of_birth = request.getParameter("date_of_birth");
			String email_id = request.getParameter("email_id");
			String mobile_number = request.getParameter("mobile_number");
			String designation = request.getParameter("designation");
			String interview_date = request.getParameter("intervieweeDate");
			String interviewee_location = request.getParameter("interviewee_location");
			int hr_concern_person = Integer.parseInt(request.getParameter("hr_concern_person"));
			String interviewer_name =  request.getParameter("interviewer_name");
			String interviewer_feedback = request.getParameter("interviewer_feedback");
			String remark = request.getParameter("remark");
			int interviewee_id = Integer.parseInt(request.getParameter("interviewee_id"));
			String interviewee_in_time = request.getParameter("interviewee_in_time");
			String interviewee_out_time = request.getParameter("interviewee_out_time");
			String location = request.getParameter("location");
			
			try {
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				Date date = formater.parse(interview_date);
				Date date1 = formater.parse(date_of_birth);
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				interview_date = formater1.format(date);
				date_of_birth = formater1.format(date1);
				
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(hr_concern_person); 
			
			IntervieweeBean intervieweeBean = new IntervieweeBean(interviewee_id, interviewee_name, designation, interview_date, interviewee_location, interviewer_name, interviewer_feedback, remark, employeeBean, interviewee_in_time, interviewee_out_time, date_of_birth, email_id, mobile_number, location);
			boolean result = allUpdateDAO.updateIntervieweeInfo(intervieweeBean);
			
			request.getRequestDispatcher("intervieweeList.jsp").forward(request, response);
		}
		
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}	
		
	}

}
