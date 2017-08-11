package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllUpdateCoreHrDAO;

public class RoleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String role_type = request.getParameter("role");
		String role_authority = request.getParameter("role_authority");
		int role_id = Integer.parseInt(request.getParameter("role_id"));
		
		AllUpdateCoreHrDAO allUpdateCoreHrDAO = new AllUpdateCoreHrDAO();
		boolean result = allUpdateCoreHrDAO.roleUpdate(role_type, role_authority, role_id);
		if(result == true)
		{
			System.out.println("Role successfully Inserted.");
			response.sendRedirect("addRole.jsp");
		}
	}
}
