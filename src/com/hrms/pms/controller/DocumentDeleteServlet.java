package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllDeleteDAO;


public class DocumentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int projectDocumentId = Integer.parseInt(request.getParameter("projectDocumentId"));
			int project_id = Integer.parseInt(request.getParameter("project_id"));
			
			AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
			boolean result = allDeleteDAO.documentDelete(projectDocumentId);
			
			request.setAttribute("project_id", project_id);
			if(request.getParameter("creatorView") != null){
			request.setAttribute("creatorView", "creatorView");
			}
			request.setAttribute("projectInput", "projectInput");
			request.getRequestDispatcher("redirection.jsp").forward(request, response);
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}