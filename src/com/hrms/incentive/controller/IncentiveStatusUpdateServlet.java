package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;

public class IncentiveStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("cppp");
		String value = request.getParameter("value");
		int incentive_id = Integer.parseInt(request.getParameter("id"));
		
		
		AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
		
		boolean result = allIncentiveUpdateDAO.incentiveStatusUpdate(incentive_id,value);
		
	}

}
