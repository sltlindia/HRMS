package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.GoalAllocationBean;
import com.hrms.pms.bean.GoalEmployeeAllocationBean;
import com.hrms.pms.bean.SubGoalAllocationBean;
import com.hrms.pms.dao.AllInsertDAO;

public class GoalEmployeeAllocationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	String[] chkEmployee = request.getParameterValues("chkEmployee");
	int sub_goal_allocation_id = Integer.parseInt(request.getParameter("sub_goal_allocation_id"));
	
	
	SubGoalAllocationBean subGoalAllocationBean = new SubGoalAllocationBean();
	subGoalAllocationBean.setSub_goal_allocation_id(sub_goal_allocation_id);
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	EmployeeBean employeeBean = new EmployeeBean();
	
	for(String employee_id : chkEmployee){
		int id = Integer.parseInt(employee_id);
		employeeBean.setEmployee_master_id(id);
		GoalEmployeeAllocationBean goalEmployeeAllocationBean = new GoalEmployeeAllocationBean(subGoalAllocationBean, employeeBean);
		boolean result = allInsertDAO.GoalEmployeeAllocationInsert(goalEmployeeAllocationBean);
	}
	
	response.sendRedirect("MyAllocatedGoal.jsp");
	
	}

}
