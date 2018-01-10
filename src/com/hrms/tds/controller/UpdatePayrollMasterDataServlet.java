package com.hrms.tds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.tds.bean.TDSPayrollMasterDataBean;
import com.hrms.tds.dao.TDSUpdateDAO;

public class UpdatePayrollMasterDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tds_payroll_master_data_id = Integer.parseInt(request.getParameter("id"));
		System.err.println("ID =====> "+tds_payroll_master_data_id);
		double annual_salary = Double.parseDouble(request.getParameter("annualSalary"));
		double bonus = Double.parseDouble(request.getParameter("bonus"));
		double leave = Double.parseDouble(request.getParameter("leave"));
		double incentive = Double.parseDouble(request.getParameter("incentive"));
		double previous_salary = Double.parseDouble(request.getParameter("previousSalary"));
		double full_final_leave = Double.parseDouble(request.getParameter("fullFinalLeave"));
		double full_final_bonus = Double.parseDouble(request.getParameter("fullFinalBonus"));
		double performance = Double.parseDouble(request.getParameter("performance"));
		double ltc = Double.parseDouble(request.getParameter("ltc"));
		double ptax = Double.parseDouble(request.getParameter("ptax"));
		double pf = Double.parseDouble(request.getParameter("pf"));
		double mealCard = Double.parseDouble(request.getParameter("mealCard"));
		
		TDSUpdateDAO tdsUpdateDAO = new TDSUpdateDAO();
		boolean result = tdsUpdateDAO.tdsPayrollMasterUpdate(tds_payroll_master_data_id, annual_salary, bonus, leave, incentive, previous_salary, full_final_bonus, full_final_leave, performance, ltc, ptax, pf, mealCard);
		
		response.getWriter().print(result);
	}

}
