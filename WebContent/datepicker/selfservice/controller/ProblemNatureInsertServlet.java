package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;

public class ProblemNatureInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String problem_nature_name = request.getParameter("problemNatureName");
		System.out.println("Problem Nature " + problem_nature_name);
		
		ProblemNatureBean problemNatureBean = new ProblemNatureBean(problem_nature_name);
		
		AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
		boolean result = allInsertSelfServiceDAO.problemNatureInsert(problemNatureBean);
		

		if(result == true)
		{
			System.out.println("data inserted sucessfully");
		}
		
	}
}
