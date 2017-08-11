package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllInsertCoreHrDAO;
import com.hrms.corehr.dao.AllUpdateCoreHrDAO;
import com.hrms.grievancemanagement.dao.AllUpdateGrievanceDAO;
import com.hrms.recruitement.dao.CompanyListDAO;

/**
 * Servlet implementation class UpdateCompanyServlet
 */
public class CompanyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int company_list_id = Integer.parseInt(request.getParameter("company_list_id"));
	String company_name = request.getParameter("company_name");
	String company_code = request.getParameter("company_code");
	
	AllUpdateCoreHrDAO allUpdateCoreHrDAO = new AllUpdateCoreHrDAO();
	
	boolean result = allUpdateCoreHrDAO.companyUpdate(company_name, company_code, company_list_id);
	if(result == true)
	{
		System.out.println("Company successfully Inserted.");
		response.sendRedirect("addCompany.jsp");
	}
	
	}


}
