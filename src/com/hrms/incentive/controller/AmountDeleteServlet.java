package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.dao.AllIncentiveDeleteDAO;

/**
 * Servlet implementation class AmountDeleteServlet
 */
public class AmountDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		int amount_id = Integer.parseInt(request.getParameter("amount_id"));
		
		AllIncentiveDeleteDAO allIncentiveDeleteDAO = new AllIncentiveDeleteDAO();
		boolean result = allIncentiveDeleteDAO.incentiveAmountDelete(amount_id);
		
		request.getRequestDispatcher("incentiveView.jsp").forward(request, response);
		

	}

}
