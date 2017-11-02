package com.hrms.kaizen.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenUpdateDAO;

/**
 * Servlet implementation class KaizenDateUpdateServlet
 */
public class KaizenDateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String startDate = request.getParameter("startDate");
		int kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
		
		SimpleDateFormat yyyyMMddsss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			startDate = yyyyMMddsss.format(yyyyMMdd.parse(startDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String endDate = null;
		
		if(request.getParameter("endDate") != null) {
			endDate = request.getParameter("endDate");
			
			
			try {
				endDate = yyyyMMddsss.format(yyyyMMdd.parse(endDate)).toString();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println(startDate);
		System.out.println(endDate);
		
		AllKaizenUpdateDAO allKaizenUpdateDAO = new AllKaizenUpdateDAO();
		boolean result = allKaizenUpdateDAO.kaizenDateUpdate(kaizen_id, startDate, endDate);
		
		request.getRequestDispatcher("kaizenView.jsp").forward(request, response);
		
		
		 
	
	
	}

}
