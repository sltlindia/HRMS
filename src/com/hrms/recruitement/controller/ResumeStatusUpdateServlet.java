package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.dao.AllUpdateDAO;

public class ResumeStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String calling_status = request.getParameter("changeCallingStatus");
		System.out.println(calling_status);
		if(calling_status.equalsIgnoreCase("callingStatusChange"))
		{
		
			int status = Integer.parseInt(request.getParameter("status"));
			System.out.println("Calling Status"+status);
			int resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
			System.out.println("resume_id "+ resume_data_id);
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.dailyCallingStatusUpdate(status, resume_data_id);

			if (result == true) {
				response.sendRedirect("hrHome.jsp");
			}
		
		}
		else{
		String status = request.getParameter("status");
		System.out.println("Status"+status);
		int resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
		System.out.println("resume_id "+ resume_data_id);
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.resumeStatusUpdate(status, resume_data_id);

		if (result == true) {
			response.sendRedirect("hrHome.jsp");
		}
		}
	}
}
