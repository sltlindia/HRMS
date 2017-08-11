package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.GoalAllocationBean;
import com.hrms.pms.bean.SubGoalAllocationBean;
import com.hrms.pms.dao.AllInsertDAO;


public class SubGoalInsertServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int goal_allocation_id = Integer.parseInt(request.getParameter("goal_allocation_id"));
		String sub_goal = request.getParameter("sub_goal");
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		GoalAllocationBean allocationBean = new GoalAllocationBean();
		allocationBean.setGoal_allocation_id(goal_allocation_id);
		
		SubGoalAllocationBean subGoalAllocationBean = new SubGoalAllocationBean(sub_goal, allocationBean);
		boolean result = allInsertDAO.subGoalInsert(subGoalAllocationBean);
		request	.getRequestDispatcher("MyAllocatedGoal.jsp").forward(request, response);
		
 	}

}
