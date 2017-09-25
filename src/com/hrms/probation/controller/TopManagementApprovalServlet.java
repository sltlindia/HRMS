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
	//Servlet for adding top management's review which send by hr to particular person  (approved or rejected)

public class TopManagementApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int probation_assessment_manager_id =Integer.parseInt(request.getParameter("probation_assessment_manager_id"));
	int top_management_id =Integer.parseInt(request.getParameter("employee_master_id"));
	String top_management_status = "pending";
	AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
	
	ProbationAssessmentManagerBean probationAssessmentManagerBean = new ProbationAssessmentManagerBean();
	probationAssessmentManagerBean.setProbation_assessment_manager_id(probation_assessment_manager_id);
	
	ProbationTopManagementApprovalBean probationTopManagementApprovalBean = new ProbationTopManagementApprovalBean(top_management_id, probationAssessmentManagerBean,top_management_status);
	allInsertProbationDAO.probationTopManagementInsertIndirect(probationTopManagementApprovalBean);
	
	request.getRequestDispatcher("probationFormApprovalHR.jsp").forward(request, response);
	}

}
