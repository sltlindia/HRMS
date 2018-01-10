package com.hrms.tds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.tds.dao.TDSUpdateDAO;

public class UpdatePayrollBasicDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tds_payroll_id = Integer.parseInt(request.getParameter("basicId"));
		System.err.println("ID =====> "+tds_payroll_id);
		double basicSalary = Double.parseDouble(request.getParameter("basicSalary"));
		double conveyance = Double.parseDouble(request.getParameter("conveyance"));
		double medical = Double.parseDouble(request.getParameter("medical"));
		double uniAllw = Double.parseDouble(request.getParameter("uniAllw"));
		double eduAllw = Double.parseDouble(request.getParameter("eduAllw"));
		double hra = Double.parseDouble(request.getParameter("hra"));
		double annualBasicSalary = Double.parseDouble(request.getParameter("annualBasicSalary"));
		double annualConveyance = Double.parseDouble(request.getParameter("annualConveyance"));
		double annualMedical = Double.parseDouble(request.getParameter("annualMedical"));
		double annualUniAllow = Double.parseDouble(request.getParameter("annualUniAllow"));
		double annualEduAllow = Double.parseDouble(request.getParameter("annualEduAllow"));
		double annualHra = Double.parseDouble(request.getParameter("annualHra"));
		
		TDSUpdateDAO tdsUpdateDAO = new TDSUpdateDAO();
		boolean result = tdsUpdateDAO.tdsPayrollBasicUpdate(tds_payroll_id, basicSalary, conveyance, medical, uniAllw, eduAllw, hra, annualBasicSalary, annualConveyance, annualMedical, annualUniAllow, annualEduAllow, annualHra);
		
		response.getWriter().print(result);
	}

}
