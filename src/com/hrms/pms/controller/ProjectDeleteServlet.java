package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllDeleteDAO;

public class ProjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	HttpSession session = request.getSession();
	EmployeeBean user = (EmployeeBean)session.getAttribute("user");
	if(user!=null){
		
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		
		System.out.println(project_id);
	
	AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
	
	boolean result1 = allDeleteDAO.taskDeleteByProejctId(project_id);
	boolean result2 = allDeleteDAO.allocationDeleteByProejctId(project_id);
	boolean result3 = allDeleteDAO.allocationPercentageDeleteByProejctId(project_id);
	boolean result4 = allDeleteDAO.projectInputHeadDeleteByProejctId(project_id);
	boolean result5 = allDeleteDAO.projectInputsDeleteByProejctId(project_id);
	boolean result = allDeleteDAO.projectDelete(project_id);
	
	
	
	
	
	if(result == true){
		request.setAttribute("success", "Project successfully Deleted..");
		request.getRequestDispatcher("projectList.jsp").forward(request, response);
		return;
	}else{
		System.out.println("not deleted");
		request.setAttribute("failure", "<font color=red>*Project Can not been deleted as timesheet or performance review exist..</font>");
		request.getRequestDispatcher("projectList.jsp").forward(request, response);
		return;
	}
	
	}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
