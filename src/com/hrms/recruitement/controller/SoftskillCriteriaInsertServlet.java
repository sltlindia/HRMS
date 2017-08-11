package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.SoftskillCriteriaBean;
import com.hrms.recruitement.bean.TechnicalCriteriaBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class SoftskillCriteriaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String softskill_criteria_name = request.getParameter("softskillCriteria");
		System.out.println("softskill_criteria_name:"+ softskill_criteria_name);
		
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		SoftskillCriteriaBean softskillCriteriaBean = new SoftskillCriteriaBean(softskill_criteria_name);
		
		boolean result = allInsertDAO.softskillCriteriaInsert(softskillCriteriaBean);
		response.sendRedirect("hrHome.jsp");
	
	
	
	
	}

}
