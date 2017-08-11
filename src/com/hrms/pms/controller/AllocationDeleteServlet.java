package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllDeleteDAO;

public class AllocationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
	int specific_id = Integer.parseInt(request.getParameter("specific_id"));
	
	AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
	boolean result = allDeleteDAO.specificCriteriaAlloctionDelete(specific_id);
	boolean result1 = allDeleteDAO.specificCriteriaAlloctionMonthDelete(specific_id);
	boolean result2 = allDeleteDAO.specificCriteriaAlloctionSoftskillDelete(specific_id);
	boolean result3 = allDeleteDAO.specificCriteriaAlloctionTechnicalDelete(specific_id);
	
	response.sendRedirect("criteriaAllocationList.jsp");
	
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
	}

}
