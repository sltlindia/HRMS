package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.GoalDefinitionBean;
import com.hrms.pms.bean.ScoreAreaBean;
import com.hrms.pms.dao.AllInsertDAO;


public class GoalInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String name = request.getParameter("goal_name");
		String desc = request.getParameter("description");
		int emp_id = user.getEmployee_master_id();
		int score_id = Integer.parseInt(request.getParameter("score_id"));
		
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		EmployeeBean employeeBean = new EmployeeBean();
		ScoreAreaBean scoreAreaBean = new ScoreAreaBean();
		
		employeeBean.setEmployee_master_id(emp_id);
		scoreAreaBean.setScore_area_id(score_id);
		
		GoalDefinitionBean goalDefinitionBean = new GoalDefinitionBean(name, desc, employeeBean, scoreAreaBean);
		boolean result = allInsertDAO.goalInsert(goalDefinitionBean);
		
		request.setAttribute("create", "Goal Successfully Created");
		request.getRequestDispatcher("goalCreation.jsp").forward(request, response);
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
