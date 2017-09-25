package com.hrms.incentive.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.dao.AllIncentiveUpdateDAO;

/**
 * Servlet implementation class IncentiveReleasePaidServlet
 */
public class IncentiveReleasePaidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status = request.getParameter("status");
		String[] ids = request.getParameterValues("id");
		
		System.out.println("status:"+status);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String parseDate = simpleDateFormat.format(date);
		
		AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
		
		for(String id : ids) {
			System.out.println("id:"+id);
			int i_id = Integer.parseInt(id);
			if(status.equalsIgnoreCase("realese")) {
				boolean result = allIncentiveUpdateDAO.incentiveReleaseUpdate(i_id, status, parseDate);
			}else if(status.equalsIgnoreCase("paid")) {
				boolean result = allIncentiveUpdateDAO.incentivePaidUpdate(i_id, status, parseDate);
			}
		}
		
		request.getRequestDispatcher("incentiveReleasePaid.jsp").forward(request, response);
	}

}
