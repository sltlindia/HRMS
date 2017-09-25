package com.hrms.probation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationTopManagementApprovalBean;
import com.hrms.probation.dao.AllInsertProbationDAO;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;


//Author Name :- Ripal Soni
//For Getting Data jsp file and adding it to database
//Servlet for adding hr's review (approved or rejected)

public class ProbationIndirectHrReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		String hr_approval = request.getParameter("action");
		String hr_apporval_rejection_remarks = "null";
		hr_apporval_rejection_remarks = request.getParameter("remarks");
		AllUpdateProbationDAO  allUpdateProbationDAO = new AllUpdateProbationDAO();
		allUpdateProbationDAO.updateApproval(hr_approval,hr_apporval_rejection_remarks,employee_master_id);
		
		
		String top_management_approval = request.getParameter("top_management_approval");
		
		if(top_management_approval.equalsIgnoreCase("yes") && hr_approval.equalsIgnoreCase("approved")){
		
		int probation_assessment_manager_id =Integer.parseInt(request.getParameter("probation_assessment_manager_id"));
		int top_management_id =Integer.parseInt(request.getParameter("employee_master_id1"));
		String top_management_status = "pending";
		AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
		
		ProbationAssessmentManagerBean probationAssessmentManagerBean = new ProbationAssessmentManagerBean();
		probationAssessmentManagerBean.setProbation_assessment_manager_id(probation_assessment_manager_id);
		
		ProbationTopManagementApprovalBean probationTopManagementApprovalBean = new ProbationTopManagementApprovalBean(top_management_id, probationAssessmentManagerBean,top_management_status);
		allInsertProbationDAO.probationTopManagementInsertIndirect(probationTopManagementApprovalBean);
		}else{

			if(hr_approval.equalsIgnoreCase("approved")){
				top_management_approval = "hrapproved";	
			}else if(hr_approval.equalsIgnoreCase("rejected")){
				top_management_approval = "pending";
			}else{
				top_management_approval = "pending";
			}
				
			String status = "approved";
			
			
			AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
			allUpdateProbationDAO.updateTopApprovalByHR(top_management_approval, employee_master_id);
			
			List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO.getListOfScoreByEmpIdWithHRApproval(employee_master_id);
			for(ProbationAssessmentManagerBean li : listOfExtended){
				int probationmanager_id = li.getProbation_assessment_manager_id();
				
				allUpdateProbationDAO.updateExtendedStatus(status,probationmanager_id);
				}
		}
		request.getRequestDispatcher("probationFormApprovalHR.jsp").forward(request, response);
	}

}
