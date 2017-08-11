package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllDeleteCoreHrDAO;

/**
 * Servlet implementation class ManagerDeleteServlet
 */
public class ManagerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		AllDeleteCoreHrDAO allDeleteCoreHrDAO = new AllDeleteCoreHrDAO();
		boolean result1 = allDeleteCoreHrDAO.managerDelete(manager_id);
		response.sendRedirect("addManager.jsp");
	
	}

}
