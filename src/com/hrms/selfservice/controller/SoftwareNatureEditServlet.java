package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.bean.SoftwareNatureBean;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;

/**
 * Servlet implementation class SoftwareNatureEditServlet
 */
public class SoftwareNatureEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int software_nature_id = Integer.parseInt(request.getParameter("software_nature_id"));
		String software_nature_name = request.getParameter("software_nature_name");
		System.out.println("software_nature_name" + software_nature_name);
		
		AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
		SoftwareNatureBean softwareNatureBean = new SoftwareNatureBean(software_nature_id, software_nature_name);
		allUpdateSelfServiceDAO.softwareNatureUpdate(softwareNatureBean);
	}

}
