package com.hrms.tds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.tds.dao.TDSUpdateDAO;

/**
 * Servlet implementation class DocumentStatusUpdateServlet
 */
public class DocumentStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("------------- DONE----------------");
		String name = request.getParameter("name");
		int tds_id = Integer.parseInt(request.getParameter("tds_id"));
		
		System.out.println("Name :"+name);
		System.out.println("Tds Id :"+tds_id);
		
		TDSUpdateDAO tdsUpdateDAO = new TDSUpdateDAO();
		String status = "approved";
		boolean result = tdsUpdateDAO.documentStatusChange(tds_id, name, status);
		response.getWriter().print("Done");
	}

}
