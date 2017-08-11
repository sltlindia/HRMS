package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.AppraisalWhiteSection1Bean;
import com.hrms.pms.bean.GoalAllocationBean;
import com.hrms.pms.dao.AllListDAO;

/**
 * Servlet implementation class AppraisalWhitecollarCheckServlet
 */
public class AppraisalWhitecollarCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appraisal_id = Integer.parseInt(request.getParameter("appraisal_id"));
		
		AllListDAO  allListDAO = new AllListDAO();
		
		List<AppraisalWhiteCollarGradeBean> listOfGoal = allListDAO.getListOfAllocatedGoals(appraisal_id);
		
		if(listOfGoal.size() == 0){
		
			/*request.setAttribute("appraisal_id", appraisalBean.getAppraisal_id());*/
			request.setAttribute("appraisal_id", appraisal_id);
			request.getRequestDispatcher("whiteCollarManagerAppraisal1.1.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("whiteCollarEditSection1.1.jsp").forward(request, response);
		}
		
	
	
	}


}
