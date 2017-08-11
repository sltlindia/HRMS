package com.hrms.pms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.GoalAllocationBean;
import com.hrms.pms.bean.GoalDefinitionBean;
import com.hrms.pms.bean.UnitOfMeasurementBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.bean.YearlyGoalBean;
import com.hrms.pms.dao.AllInsertDAO;

public class YearlyGoalInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		int goal_id = Integer.parseInt(request.getParameter("goal_id"));
		int year_id = Integer.parseInt(request.getParameter("year_id"));
		int unit_id = Integer.parseInt(request.getParameter("unit_id"));
		double goalAmount = Double.parseDouble(request.getParameter("goalAmount"));
		int employee_id = user.getEmployee_master_id();
		
		String[] chkManager = request.getParameterValues("chkmanager");
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		
		GoalDefinitionBean goalDefinitionBean = new GoalDefinitionBean();
		YearBean yearBean = new YearBean();
		UnitOfMeasurementBean unitOfMeasurementBean = new UnitOfMeasurementBean();
		EmployeeBean employeeBean = new EmployeeBean();
		
		goalDefinitionBean.setGoal_definition_id(goal_id);
		yearBean.setYear_id(year_id);
		unitOfMeasurementBean.setUnit_of_measurement_id(unit_id);
		employeeBean.setEmployee_master_id(employee_id);
		
		YearlyGoalBean yearlyGoalBean = new YearlyGoalBean(goalAmount, goalDefinitionBean, yearBean, unitOfMeasurementBean, employeeBean);
		boolean result = allInsertDAO.yearlyGoalInsert(yearlyGoalBean);
		int yearly_goal_id = yearlyGoalBean.getYearly_goal_id();
		yearlyGoalBean.setYearly_goal_id(yearly_goal_id);
		
		for(String manager_id : chkManager){
			int m_id = Integer.parseInt(manager_id);
			employeeBean.setEmployee_master_id(m_id);
			GoalAllocationBean goalAllocationBean = new GoalAllocationBean(yearlyGoalBean, employeeBean);
			boolean result1 = allInsertDAO.yearlyGoalAllocationInsert(goalAllocationBean); 
		}
		
		request.getRequestDispatcher("myGoalList.jsp").forward(request, response);
		
	}else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	}
	

}
