package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllDeleteDAO;

public class ProjectAdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		boolean result = allDeleteDAO.projectDelete(project_id);
		if(result == true){
			System.out.println("deleted");
			request.getRequestDispatcher("projAdminList.jsp").forward(request, response);
			return;
		}else{
			System.out.println("not deleted");
			request.setAttribute("delete", "<font color=red>*Project Can not been deleted as timesheet or performance review exist..</font>");
			request.getRequestDispatcher("projAdminList.jsp").forward(request, response);
			return;
		}
		
		
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}

}
