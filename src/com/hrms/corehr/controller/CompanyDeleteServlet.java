package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllDeleteCoreHrDAO;


public class CompanyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int company_list_id = Integer.parseInt(request.getParameter("company_list_id"));
		AllDeleteCoreHrDAO allDeleteCoreHrDAO = new AllDeleteCoreHrDAO();
		boolean result1 = allDeleteCoreHrDAO.companyDelete(company_list_id);
		response.sendRedirect("addCompany.jsp");
	
	}

}
