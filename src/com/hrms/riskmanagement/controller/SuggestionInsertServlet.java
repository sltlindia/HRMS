package com.hrms.riskmanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.riskmanagement.bean.SuggestionBean;
import com.hrms.riskmanagement.dao.AllInsertDAO;

public class SuggestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int risk_id = Integer.parseInt(request.getParameter("risk_id"));
	String suggestion = request.getParameter("suggestion");
	String redirect = request.getParameter("redirect");
	RiskRepositoryBean riskRepositoryBean = new RiskRepositoryBean();
	riskRepositoryBean.setRisk_repository_id(risk_id);
	SuggestionBean suggestionBean = new SuggestionBean(riskRepositoryBean, suggestion);
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	
	boolean result = allInsertDAO.suggestionInsert(suggestionBean); 
	if(redirect.equalsIgnoreCase("redirectAll")){
		request.getRequestDispatcher("riskAllList.jsp").forward(request, response);
	}
	else if(redirect.equalsIgnoreCase("redirectMonth")){
		request.getRequestDispatcher("riskAllListMonthWise.jsp").forward(request, response);
	}
	
	}
}