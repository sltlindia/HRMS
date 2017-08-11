package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.PhilTestBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class PhilTestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String candidate = request.getParameter("candidate");
		System.out.println("candidate"+ candidate);
		String position = request.getParameter("position");
		System.out.println("position"+ position);
		String submission_date = request.getParameter("submission_date");
		System.out.println("submission_date"+ submission_date);
		String q1 = request.getParameter("1");
		System.out.println("q1"+q1);
		String q2 = request.getParameter("2");
		System.out.println("q2"+q2);
		String q3 = request.getParameter("3");
		System.out.println("q3"+q3);
		String q4 = request.getParameter("4");
		System.out.println("q4"+q4);
		String q5 = request.getParameter("5");
		System.out.println("q5"+q5);
		String q6 = request.getParameter("6");
		System.out.println("q6"+q6);
		String q7 = request.getParameter("7");
		System.out.println("q7"+q7);
		String q8 = request.getParameter("8");
		System.out.println("q8"+q8);
		String q9 = request.getParameter("9");
		System.out.println("q9"+q9);
		String q10 = request.getParameter("10");
		System.out.println("q10"+q10);
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		PhilTestBean philTestBean = new PhilTestBean(candidate, position, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, submission_date);
		boolean result = allInsertDAO.philTestInsert(philTestBean);
		
		if(result == true) 
		{
			response.sendRedirect("hrHome.jsp");
		}
	}

}
