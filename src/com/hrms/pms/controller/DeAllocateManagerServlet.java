package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllDeleteDAO;

/**
 * Servlet implementation class DeAllocateManagerServlet
 */
public class DeAllocateManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int projectManagerId = Integer.parseInt(request.getParameter("projectManagerListId"));
	int project_id = Integer.parseInt(request.getParameter("project_id"));
	int manager_id = Integer.parseInt(request.getParameter("manager_id"));
	
	AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
	boolean result = allDeleteDAO.projectManagerDelete(projectManagerId);
	boolean result1 = allDeleteDAO.departmentDeleteByManagerId(manager_id,project_id);
	
	
	request.setAttribute("project_id", project_id);
	request.setAttribute("creatorView", "creatorView");
	request.setAttribute("activeView", "projectDetail");
	request.getRequestDispatcher("redirection.jsp").forward(request, response);
	
	
	}

}
