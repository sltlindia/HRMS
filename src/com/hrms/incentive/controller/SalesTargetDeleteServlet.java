package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.dao.AllIncentiveDeleteDAO;

/**
 * Servlet implementation class SalesTargetDeleteServlet
 */
public class SalesTargetDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int sales_target_id = Integer.parseInt(request.getParameter("sales_target_id"));
	
	AllIncentiveDeleteDAO allIncentiveDeleteDAO = new AllIncentiveDeleteDAO();
	boolean result = allIncentiveDeleteDAO.incentiveSalesTargetId(sales_target_id);
	
	return;
	
	}

}
