package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllDeleteCoreHrDAO;

/**
 * Servlet implementation class RoleDeleteServlet
 */
public class RoleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int role_id = Integer.parseInt(request.getParameter("role_id"));
		AllDeleteCoreHrDAO allDeleteCoreHrDAO = new AllDeleteCoreHrDAO();
		boolean result1 = allDeleteCoreHrDAO.roleDelete(role_id);
		response.sendRedirect("addRole.jsp");
	}

}
