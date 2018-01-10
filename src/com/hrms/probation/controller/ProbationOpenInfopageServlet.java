package com.hrms.probation.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.probation.bean.ProbationOpenInfopageBean;
import com.hrms.probation.dao.AllListProbationDAO;

/**
 * Servlet implementation class ProbationOpenInfopageServlet
 */
public class ProbationOpenInfopageServlet extends HttpServlet {
   

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
			int manager_id = user.getManagerBean().getManager_id();
			int month_id = Calendar.getInstance().get(Calendar.MONTH) + 1;;
			int year = Calendar.getInstance().get(Calendar.YEAR);
			AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
			List<ProbationOpenInfopageBean> listOfProbationInfoPage = allListProbationDAO.getProbationOpenInfoPage(manager_id,month_id,year);
			if(listOfProbationInfoPage.size() == 0)
			{
				request.getRequestDispatcher("probationInfo.jsp").forward(request, response);
			}else{
				if(request.getParameter("employee_master_id") == null){
				request.getRequestDispatcher("probationForm.jsp").forward(request, response);
				}else{
					int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
					request.getRequestDispatcher("probationForm.jsp").forward(request, response);
				}
			
			}
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	
}
