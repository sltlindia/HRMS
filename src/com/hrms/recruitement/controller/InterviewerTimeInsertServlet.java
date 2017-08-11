package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class InterviewerTimeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String first = request.getParameter("fdate&time");
	String second = request.getParameter("sdate&time");
	String third = request.getParameter("tdate&time");
	String first_time = request.getParameter("finterviewTime");
	String second_time = request.getParameter("sinterviewTime");
	String third_time = request.getParameter("tinterviewTime");
	
	
	first = first+"T"+first_time;
	second = second+"T"+second_time;
	third = third+"T"+third_time;
	
	System.out.println(first);
	System.out.println(second);
	System.out.println(third);
	
	
	int id = Integer.parseInt(request.getParameter("it_id"));
	String status = "time given";
	int resume_id = Integer.parseInt(request.getParameter("resume_id"));

	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	
 	boolean result = allUpdateDAO.interviewTimeUpdate(id, first, second, third,status);
 	request.setAttribute("SuccessInterviewDateTime" ,"You date and time Successfully updated" );
 	
 	
 	
 	request.getRequestDispatcher("interviewTiming.jsp").forward(request, response);
 	
	}

}
