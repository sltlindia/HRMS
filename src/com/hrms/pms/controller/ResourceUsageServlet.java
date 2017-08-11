package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllListDAO;


public class ResourceUsageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String startDate = request.getParameter("plannedStartDate");
		String endDate = request.getParameter("plannedEndDate");
		int projectId =Integer.parseInt(request.getParameter("projectId"));
		
		AllListDAO  allListDAO= new AllListDAO();
		
		List<Object[]> listOfEmployee = allListDAO.getPerOfAllocationByProjectIdUnique(projectId);
		request.setAttribute("listOfEmployee", listOfEmployee);
		request.getRequestDispatcher("resourceUsageReport.jsp").forward(request, response);
	
	
	}

}
