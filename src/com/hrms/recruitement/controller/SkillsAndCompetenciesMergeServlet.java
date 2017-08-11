package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkillsAndCompetenciesMergeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] skill = request.getParameterValues("skills");
		String[] jobDescription = request.getParameterValues("jobDescription");
				
	String mergeOfSKill = "";
	String mergeOfJobDescription = "";
	
	for(String s : skill){
		
		mergeOfSKill = mergeOfSKill  + s +",";
	}
		
	for(String j : jobDescription){
		
		mergeOfJobDescription = mergeOfJobDescription + j +",";
		
	}
		System.out.println("skill : " +mergeOfSKill);
		System.out.println("job : " +mergeOfJobDescription);
		request.getRequestDispatcher("vacancyForm").forward(request, response);
	
	}

}
