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
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.pms.bean.EmployeeBean;


public class IntervieweeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		
			String interviewee_first_name = request.getParameter("firstName").toUpperCase();
			String interviewee_middle_name = request.getParameter("middleName").toUpperCase();
			String interviewee_last_name = request.getParameter("lastName").toUpperCase();
			String date_of_birth = request.getParameter("date_of_birth");
			String email_id = request.getParameter("email_id");
			String mobile_number = request.getParameter("mobile_number");
			String designation = request.getParameter("designation");
			String interview_date = request.getParameter("intervieweeDate");
			String interviewee_location = request.getParameter("interviewee_location");
			int hr_concern_person = Integer.parseInt(request.getParameter("hr_concern_person"));
			String interviewer_name = "null";
			String interviewer_feedback = "null";
			String remark = "null";
			String interviewee_in_time = null;
			String interviewee_out_time = "null";
			
			String location = user.getLocation();
			
			
			String interviewee_name = interviewee_first_name +" "+ interviewee_middle_name +" "+ interviewee_last_name;
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = new Date();
			interviewee_in_time = sdf1.format(date1);
			
			try {
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				Date date = formater.parse(interview_date);
				Date birthDate = formater.parse(date_of_birth);
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				interview_date = formater1.format(date);
				date_of_birth = formater1.format(birthDate);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(hr_concern_person);
			
			IntervieweeBean intervieweeBean = new IntervieweeBean(interviewee_name, designation, interview_date, interviewee_location, interviewer_name, interviewer_feedback, remark, employeeBean, interviewee_in_time, interviewee_out_time, date_of_birth, email_id, mobile_number, location);
			
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			
			boolean result = allInsertDAO.intervieweeInsert(intervieweeBean);
			
			if(result == true){
				request.setAttribute("openStatus","interviewee");
				request.setAttribute("success","Interviewee detail submitted successfully...");
				/*request.getRequestDispatcher("addInterviewee.jsp").forward(request, response);;*/
				response.sendRedirect("addInterviewee.jsp");
			}else{
				request.setAttribute("error","Interview detail not submitted...");
				/*request.getRequestDispatcher("addInterviewee.jsp").forward(request, response);*/
				response.sendRedirect("addInterviewee.jsp");
			}
		}else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			/*request.getRequestDispatcher("login.jsp").forward(request, response);*/
			response.sendRedirect("login.jsp");
		}	
	}

}
