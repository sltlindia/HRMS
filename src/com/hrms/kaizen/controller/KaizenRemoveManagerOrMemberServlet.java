package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenDeleteDAO;

/**
 * Servlet implementation class KaizenRemoveManagerOrMemberServlet
 */
public class KaizenRemoveManagerOrMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AllKaizenDeleteDAO allKaizenDeleteDAO = new AllKaizenDeleteDAO();
		
		if(request.getParameter("kaizen_manager_id") != null){
			
			int kaizen_manager_id = Integer.parseInt(request.getParameter("kaizen_manager_id"));
			boolean result = allKaizenDeleteDAO.kaizenManagerDelete(kaizen_manager_id);
			request.getRequestDispatcher("kaizenView.jsp").forward(request, response);
			
			
		}else if(request.getParameter("kaizen_member_id") != null){
			
			int kaizen_member_id = Integer.parseInt(request.getParameter("kaizen_member_id"));
			boolean result = allKaizenDeleteDAO.kaizenMemberDelete(kaizen_member_id);
			request.getRequestDispatcher("kaizenView.jsp").forward(request, response);
			
		}
	
	
	}

}
