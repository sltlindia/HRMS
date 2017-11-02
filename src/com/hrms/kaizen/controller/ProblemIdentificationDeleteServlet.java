package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenDeleteDAO;

/**
 * Servlet implementation class ProblemIdentificationDeleteServlet
 */
public class ProblemIdentificationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int problem_id = Integer.parseInt(request.getParameter("problem_id"));
		
		AllKaizenDeleteDAO allKaizenDeleteDAO = new AllKaizenDeleteDAO();
		boolean result = allKaizenDeleteDAO.kaizenProblemDelete(problem_id);
		
		response.sendRedirect("kaizenProblemIdentification.jsp");
	
	
	}

}
