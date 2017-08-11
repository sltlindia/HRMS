package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;

public class ProblemNatureEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int problem_nature_id = Integer.parseInt(request.getParameter("problem_nature_id"));
		String problem_nature_name = request.getParameter("problem_nature_name");
		System.out.println("Problem Nature " + problem_nature_name);
		
		AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
		ProblemNatureBean problemNatureBean = new ProblemNatureBean(problem_nature_id, problem_nature_name);
		allUpdateSelfServiceDAO.problemNatureUpdate(problemNatureBean);
		
	}

}
