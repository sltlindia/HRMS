package com.hrms.probation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.dao.AllInsertProbationDAO;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;


//Author Name :- Ripal Soni
//For Getting Data jsp file and adding it to database
//Servlet for adding manager's review after extended any employees

public class ManagerReviewAfterExtendUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int probation_assessment_manager_id = Integer.parseInt(request.getParameter("probation_assessment_manager_id"));
		AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
		ProbationAssessmentManagerBean probationAssessmentManagerBean = allListProbationDAO.getListOfProbationById(probation_assessment_manager_id);
		
		int to_be_extended_db = Integer.parseInt(probationAssessmentManagerBean.getPeriod_to_be_extended());
		
		String to_be_terminated = request.getParameter("terminated");
		String to_be_confirmed = request.getParameter("confirmed");
		String to_be_extended = request.getParameter("extended");
		String remarks = request.getParameter("remarks1");
		String period_to_be_extended = "0";
		String ptbeString = null;
		String period_to_be_extended1 = null;
		if(to_be_extended.equalsIgnoreCase("extendedYes")){
			period_to_be_extended = request.getParameter("extended_period");
			period_to_be_extended1 = request.getParameter("extended_period");
			int ptbe = Integer.parseInt(period_to_be_extended) + to_be_extended_db;
			 ptbeString =  Integer.toString(ptbe);
		}
		else{
			period_to_be_extended = "0";
			period_to_be_extended1 = "0";
			int ptbe = Integer.parseInt(period_to_be_extended) + to_be_extended_db;
			 ptbeString =  Integer.toString(ptbe);
		}
		
		String manager_approval = "pending";
		if(request.getParameter("confirmation_top_management_approval") != null){
			if(request.getParameter("confirmation_top_management_approval").equalsIgnoreCase("no")){
				manager_approval = "approved";
			}
		}
		String manager_rejection_remarks = "null";
		String hr_approval = "pending";
		String hr_rejection_remarks = "null";
		String top_management_approval  = "pending";
		String top_management_rejection_remarks = "null";
		String reporting_manager_approval = "approved"; 
		
		AllUpdateProbationDAO allUpdateProbationDAO = new AllUpdateProbationDAO();
		allUpdateProbationDAO.update(probation_assessment_manager_id, to_be_confirmed, to_be_terminated, to_be_extended, remarks, ptbeString, manager_approval, manager_rejection_remarks, hr_approval, hr_rejection_remarks, top_management_approval, top_management_rejection_remarks,reporting_manager_approval);
		
		ProbationAssessmentManagerBean probationAssessmentManagerBean2 = new ProbationAssessmentManagerBean();
		probationAssessmentManagerBean2.setProbation_assessment_manager_id(probation_assessment_manager_id);
		String status = "pending";
		AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
		ProbationExtendBean probationExtendBean = new ProbationExtendBean(period_to_be_extended1, status, probationAssessmentManagerBean2);
		
		/*if(to_be_extended.equalsIgnoreCase("extendedYes")){*/
		allInsertProbationDAO.probationManagerExtendedInsertIndirect(probationExtendBean);
		
		request.getRequestDispatcher("probationFormApprovalManager.jsp").forward(request, response);
		
	}

}
