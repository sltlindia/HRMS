package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.TechnicalCriteriaBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.sun.mail.iap.Response;

public class TechnicalCriteriaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String technical_criteria_name = request.getParameter("technicalCriteria");
	System.out.println("technicalCriteria :"+ technical_criteria_name);
	
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	TechnicalCriteriaBean technicalCriteriaBean = new TechnicalCriteriaBean(technical_criteria_name);
	
	boolean result = allInsertDAO.technicalCriteriaInsert(technicalCriteriaBean);
	response.sendRedirect("hrHome.jsp");
	
	
	}

}
