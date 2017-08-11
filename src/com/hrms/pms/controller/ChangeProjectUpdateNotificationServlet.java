package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllUpdateDAO;

public class ChangeProjectUpdateNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int id = Integer.parseInt(request.getParameter("id"));
		int role_id = user.getRoleBean().getRole_id();
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	
	boolean result = allUpdateDAO.changeProjectUpdateNotification(id);
	if(role_id==9 || role_id==13 || role_id==14 || role_id==15 || role_id==16 ||role_id==20 || role_id==21 || role_id==22 || role_id==23 || role_id==24 || role_id==25 || role_id==26){
	response.sendRedirect("myProjectAllocations.jsp");
	}else if(role_id == 1 || role_id ==2 || role_id == 3){ 
	response.sendRedirect("projAdminList.jsp");
	}else if(role_id == 6 || role_id == 7 || role_id == 11 || role_id == 17 || role_id == 18 || role_id == 19){
		response.sendRedirect("projectList.jsp");
	}
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
	
	}

}
