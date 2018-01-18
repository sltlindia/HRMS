package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.bean.SoftwareNatureBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;

/**
 * Servlet implementation class SoftwareNatureInsertServlet
 */
public class SoftwareNatureInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String software_nature_name = request.getParameter("softwareNatureName");
		System.out.println("software_nature_name" + software_nature_name);
		
		SoftwareNatureBean softwareNatureBean = new SoftwareNatureBean(software_nature_name);
		
		AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
		boolean result = allInsertSelfServiceDAO.softwareNatureInsert(softwareNatureBean);
		

		if(result == true)
		{
			System.out.println("data inserted sucessfully");
		}
		
	}

}
