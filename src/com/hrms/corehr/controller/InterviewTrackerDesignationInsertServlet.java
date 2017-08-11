package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.bean.InterviewTrackerDesignationBean;
import com.hrms.corehr.dao.AllInsertCoreHrDAO;
import com.hrms.pms.bean.RoleBean;

/**
 * Servlet implementation class InterviewTrackerDesignationInsertServlet
 */
public class InterviewTrackerDesignationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
		String interview_role_type = request.getParameter("role");
		String interview_role_authority = request.getParameter("role_authority");
		
		AllInsertCoreHrDAO allInsertCoreHrDAO = new AllInsertCoreHrDAO();
		InterviewTrackerDesignationBean interviewTrackerDesignationBean = new InterviewTrackerDesignationBean();
		
		boolean result = allInsertCoreHrDAO.addInterviewTrackerDesignation(interviewTrackerDesignationBean);
		if(result == true)
		{
			System.out.println("Role successfully Inserted.");
			response.sendRedirect("addInterviewTrackerDesignation.jsp");
		}

		}
	}

