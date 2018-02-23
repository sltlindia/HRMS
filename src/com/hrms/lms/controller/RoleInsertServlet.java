package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.pms.bean.EmployeeBean;

public class RoleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
		String role_type = request.getParameter("role");
		String role_authority = request.getParameter("role_authority");
		String level = request.getParameter("level");
		String level_name = request.getParameter("level_name");
		/*String date = request.getParameter("date");
		String openStatus = request.getParameter("openStatus");*/
		
		
		AllListDAO allListDAO = new AllListDAO();
	 	List<RoleBean> listOfRoles = allListDAO.getListOfRoleByType(role_type);
	 	
	 	if(listOfRoles.size() == 0){
	 		RoleBean roleBean = new RoleBean();
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			boolean result = allInsertDAO.roleInsert(role_type, role_authority, level, level_name);
			
			if(result == true){
				request.setAttribute("success", "Role added successfully");
				/*request.setAttribute("date", date);
				request.setAttribute("openStatus", openStatus);*/
				/*request.getRequestDispatcher("addDesignation.jsp").forward(request, response);*/
				response.sendRedirect("addDesignation.jsp");
			}
	 	}else{
				request.setAttribute("error", "Role Already Exist");
				/*request.setAttribute("date", date);
				request.setAttribute("openStatus", openStatus);*/
				/*request.getRequestDispatcher("addDesignation.jsp").forward(request, response);*/
				response.sendRedirect("addDesignation.jsp");
		}
		
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				/*request.getRequestDispatcher("login.jsp").forward(request, response);*/
				response.sendRedirect("login.jsp");
		}
	
	}

}
