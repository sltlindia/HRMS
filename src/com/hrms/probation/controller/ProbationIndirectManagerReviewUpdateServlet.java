package com.hrms.probation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.dao.AllDeleteProbationDAO;
import com.hrms.probation.dao.AllInsertProbationDAO;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;


//Author Name :- Ripal Soni
//For Getting Data jsp file and adding it to database
//Servlet for Updating reporting manager's review (approved or rejected)
//Servlet for Updating manager's review (approved or rejected)

public class ProbationIndirectManagerReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int probation_assessment_manager_id = Integer.parseInt(request.getParameter("probation_assessment_manager_id"));
		AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
		ProbationAssessmentManagerBean probationAssessmentManagerBean = allListProbationDAO.getListOfProbationById(probation_assessment_manager_id);
		AllDeleteProbationDAO allDeleteProbationDAO = new AllDeleteProbationDAO();
		allDeleteProbationDAO.deleteExtendedPeriod(probation_assessment_manager_id);
		
		
		int to_be_extended_db = 0;
		List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probation_assessment_manager_id);
		for(ProbationExtendBean p1 : listForExtend){
			String extend_period = p1.getExtended_period();
			to_be_extended_db = to_be_extended_db + Integer.parseInt(extend_period);
			
		}
		
		
		String to_be_terminated = request.getParameter("terminated");
		String to_be_confirmed = request.getParameter("confirmed");
		String to_be_extended = request.getParameter("extended");
		String remarks = request.getParameter("remarks1");
		
		String period_to_be_extended = "0";
		String period_to_be_extended1 = null;
		if(to_be_extended.equalsIgnoreCase("extendedYes")){
			period_to_be_extended = request.getParameter("extended_period");
			period_to_be_extended1 = request.getParameter("extended_period");
			int ptbe = Integer.parseInt(period_to_be_extended) + to_be_extended_db;
			period_to_be_extended =  Integer.toString(ptbe);
		}
		else{
			period_to_be_extended = "0";
			period_to_be_extended1 = "0";
			int ptbe = Integer.parseInt(period_to_be_extended) + to_be_extended_db;
			period_to_be_extended =  Integer.toString(ptbe);
		}
		
		String manager_approval = "pending";
		String manager_rejection_remarks = "null";
		String hr_approval = "pending";
		String hr_rejection_remarks = "null";
		String top_management_approval  = "pending";
		String top_management_rejection_remarks = "null";
		String reporting_manager_approval = "approved";
		
		AllUpdateProbationDAO allUpdateProbationDAO = new AllUpdateProbationDAO();
		allUpdateProbationDAO.update(probation_assessment_manager_id, to_be_confirmed, to_be_terminated, to_be_extended, remarks, period_to_be_extended, manager_approval, manager_rejection_remarks, hr_approval, hr_rejection_remarks, top_management_approval, top_management_rejection_remarks,reporting_manager_approval);
		ProbationAssessmentManagerBean probationAssessmentManagerBean2 = new ProbationAssessmentManagerBean();
		probationAssessmentManagerBean2.setProbation_assessment_manager_id(probation_assessment_manager_id);
		String status = "pending";
		AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
		ProbationExtendBean probationExtendBean = new ProbationExtendBean(period_to_be_extended1, status, probationAssessmentManagerBean2);
		allInsertProbationDAO.probationManagerExtendedInsertIndirect(probationExtendBean);
		request.getRequestDispatcher("probationFormApprovalManager.jsp").forward(request, response);
		
	}

}
