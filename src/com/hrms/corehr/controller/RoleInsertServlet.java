package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllInsertCoreHrDAO;
import com.hrms.pms.bean.RoleBean;
import com.hrms.riskmanagement.dao.AllInsertDAO;

public class RoleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String role_type = request.getParameter("role");
	String role_authority = request.getParameter("role_authority");
	
	AllInsertCoreHrDAO allInsertCoreHrDAO = new AllInsertCoreHrDAO();
	RoleBean roleBean = new RoleBean(role_type, role_authority);
	
	boolean result = allInsertCoreHrDAO.addRole(roleBean);
	if(result == true)
	{
		System.out.println("Role successfully Inserted.");
		response.sendRedirect("addRole.jsp");
	}

	}
	
	

}
