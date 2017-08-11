package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllInsertDAO;

public class InsertClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String name = request.getParameter("client_name");
		String type = request.getParameter("client_type");
		ClientMasterBean clientMasterBean = new ClientMasterBean();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		boolean result = allInsertDAO.clientInsert(name,type);
		
		if(result == true){
			request.setAttribute("client", "client Succefully added");
			request.getRequestDispatcher("addProject.jsp").forward(request, response);
		}else{
			request.setAttribute("clientError", "client Already Exist");
			request.getRequestDispatcher("addProject.jsp").forward(request, response);
		}
		
		
		
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
	}

}
