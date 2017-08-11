package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.GoalAllocationBean;
import com.hrms.pms.bean.YearlyGoalBean;
import com.hrms.pms.dao.AllInsertDAO;

public class GoalAllocationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] chkManager = request.getParameterValues("chkmanager");
		int yearly_goal_id = Integer.parseInt(request.getParameter("yearly_goal_id"));
		
		YearlyGoalBean yearlyGoalBean = new YearlyGoalBean();
		yearlyGoalBean.setYearly_goal_id(yearly_goal_id);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		EmployeeBean employeeBean = new EmployeeBean();
		
		for(String manager_id : chkManager){
			int m_id = Integer.parseInt(manager_id);
			employeeBean.setEmployee_master_id(m_id);
			GoalAllocationBean goalAllocationBean = new GoalAllocationBean(yearlyGoalBean, employeeBean);
			boolean result1 = allInsertDAO.yearlyGoalAllocationInsert(goalAllocationBean); 
		}
		
		request.getRequestDispatcher("myGoalList.jsp").forward(request, response);
	
	}

}
