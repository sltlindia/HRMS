package com.hrms.riskmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.riskmanagement.dao.AllDeleteDAO;

public class RiskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int risk_id = Integer.parseInt(request.getParameter("risk_repository_id"));
		RiskRepositoryBean riskRepositoryBean = new RiskRepositoryBean();
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		boolean result1 = allDeleteDAO.riskRepositoyryDelete(risk_id);
	response.sendRedirect("riskList.jsp");
	}

}
