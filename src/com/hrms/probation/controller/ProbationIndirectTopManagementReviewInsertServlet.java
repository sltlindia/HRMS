package com.hrms.probation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;

//Author Name :- Ripal Soni
//For Getting Data jsp file and adding it to database
//Servlet for adding top management's review (approved or rejected)

public class ProbationIndirectTopManagementReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = "approved";
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		String top_management_approval = request.getParameter("action");
		String top_management_rejection_remarks = "null";
		top_management_rejection_remarks = request.getParameter("remarks");
		String top_management_status = "approved";
		AllUpdateProbationDAO  allUpdateProbationDAO = new AllUpdateProbationDAO();
		allUpdateProbationDAO.updateTopApproval(top_management_approval,top_management_rejection_remarks,employee_master_id);
	
		AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
		List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO.getListOfScoreByEmpIdWithHRApproval(employee_master_id);
		for(ProbationAssessmentManagerBean li : listOfExtended){
			int probationmanager_id = li.getProbation_assessment_manager_id();
			allUpdateProbationDAO.updateStatus(probationmanager_id,top_management_approval);
			allUpdateProbationDAO.updateExtendedStatus(top_management_approval,probationmanager_id);
				System.out.println("test");
			}

		request.getRequestDispatcher("probationFormApprovalTM.jsp").forward(request, response);
		
	}

}
