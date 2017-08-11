package com.hrms.corehr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.corehr.dao.AllInsertCoreHrDAO;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.bean.CompanyListBean;

public class CompanyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String company_name = request.getParameter("company_name");
		String company_code = request.getParameter("company_code");
		
		AllInsertCoreHrDAO allInsertCoreHrDAO = new AllInsertCoreHrDAO();
		CompanyListBean companyListBean = new CompanyListBean(company_name,company_code);
		
		boolean result = allInsertCoreHrDAO.addCompany(companyListBean);
		if(result == true)
		{
			System.out.println("Company successfully Inserted.");
			response.sendRedirect("addCompany.jsp");
		}

	
	
	}

}
