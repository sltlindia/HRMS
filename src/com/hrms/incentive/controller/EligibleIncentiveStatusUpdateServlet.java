package com.hrms.incentive.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.incentive.dao.AllIncentiveUpdateDAO;

/**
 * Servlet implementation class EligibleIncentiveStatusUpdateServlet
 */
public class EligibleIncentiveStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String listOfId = request.getParameter("listOfId");
		double incentive = Double.parseDouble(request.getParameter("incentive"));
		
		System.out.println("listOfId:"+listOfId);
		System.out.println("incentive:"+incentive);
		
		
		List<String> myList = new ArrayList<String>(Arrays.asList(listOfId.split(",")));

		
		System.out.println("myList:"+myList);
		
		AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO(); 
		
		for(String i : myList){
			int incentive_id = Integer.parseInt(i);
			System.out.println(incentive_id);
			
			boolean result = allIncentiveUpdateDAO.incentiveEligibleStatusUpdate(incentive_id, incentive);
			
		}
		
		/*String splitValue = split[1];
		
		String[] split1 = splitValue.split("]");
		
		System.out.println("list:"+split1[0]);*/
		
	}

}
