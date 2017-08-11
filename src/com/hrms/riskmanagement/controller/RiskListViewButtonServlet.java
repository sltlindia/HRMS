package com.hrms.riskmanagement.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.riskmanagement.dao.AllUpdateDAO;

public class RiskListViewButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int risk_id = Integer.parseInt(request.getParameter("risk_repository_id"));
		String view_on = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String date1 = dateFormat.format(date);
		view_on = date1;
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result1 = allUpdateDAO.riskViewDate(view_on, risk_id);
		System.out.println("update date");
		request.setAttribute("risk_repository_id", risk_id);
		request.getRequestDispatcher("riskListViewButton.jsp").forward(request, response);
	
	}

}
