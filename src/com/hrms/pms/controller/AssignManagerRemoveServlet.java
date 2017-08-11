package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllDeleteDAO;

/**
 * Servlet implementation class AssignManagerRemoveServlet
 */
public class AssignManagerRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int assign_id = Integer.parseInt(request.getParameter("assign_id"));
	
	AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
	boolean result = allDeleteDAO.projectAssignManagerDelete(assign_id);
	
	request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
	
	}

}
