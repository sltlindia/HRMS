package com.hrms.probation.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.probation.bean.ProbationAssessmentTerminationBean;
import com.hrms.probation.bean.ProbationOpenInfopageBean;
import com.hrms.probation.dao.AllInsertProbationDAO;


public class ProbationOpenInfopageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
			int manager_id = user.getManagerBean().getManager_id();
			int month_id = Calendar.getInstance().get(Calendar.MONTH) + 1;;
			int year = Calendar.getInstance().get(Calendar.YEAR);
			AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
			ManagerBean managerBean = new ManagerBean();
			managerBean.setManager_id(manager_id);
			MonthBean monthBean = new MonthBean();
			monthBean.setMonth_id(month_id);
			ProbationOpenInfopageBean probationOpenInfopageBean = new ProbationOpenInfopageBean(managerBean, monthBean, year);
			boolean result = allInsertProbationDAO.probationOpenInfopageInsert(probationOpenInfopageBean);
			if(request.getParameter("employee_master_id") == null){
			request.getRequestDispatcher("probationForm.jsp").forward(request, response);
			}else{
				int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
				request.getRequestDispatcher("probationForm.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
