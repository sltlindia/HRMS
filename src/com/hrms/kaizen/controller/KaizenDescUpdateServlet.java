package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenUpdateDAO;

/**
 * Servlet implementation class KaizenDescUpdateServlet
 */
public class KaizenDescUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
		String firstInsert = null;
		
		if(request.getParameter("firstInsert") !=  null) {
			firstInsert = request.getParameter("firstInsert");
		}
		
		
		AllKaizenUpdateDAO allKaizenUpdateDAO = new AllKaizenUpdateDAO();		
		
		if(request.getParameter("before_description") != null) {
			String before_description = request.getParameter("before_description");
			
			boolean result = allKaizenUpdateDAO.kaizenDescUpdate(kaizen_id, before_description,"before_description");
			
		}else if(request.getParameter("after_description") != null) {
			String after_description = request.getParameter("after_description");
			boolean result = allKaizenUpdateDAO.kaizenDescUpdate(kaizen_id, after_description,"after_description");
		}
		
		if(firstInsert != null) {
			request.getRequestDispatcher("kaizenView.jsp").forward(request, response);	
		}else {
		request.getRequestDispatcher("kaizenPhotoUpload.jsp").forward(request, response);
		}
		
	
	}

}
