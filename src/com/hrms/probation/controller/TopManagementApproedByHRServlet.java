package com.hrms.probation.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;

//Author Name :- Ripal Soni
	//For Getting Data jsp file and adding it to database
	//Servlet for adding top management's review by hr (approved or rejected)
public class TopManagementApproedByHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String top_management_approval = "hrapproved";
	String status = "approved";
	int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
	
	
	AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
	AllUpdateProbationDAO allUpdateProbationDAO = new AllUpdateProbationDAO();
	allUpdateProbationDAO.updateTopApprovalByHR(top_management_approval, employee_master_id);
	
	
	List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO.getListOfScoreByEmpIdWithHRApproval(employee_master_id);
	for(ProbationAssessmentManagerBean li : listOfExtended){
		int probationmanager_id = li.getProbation_assessment_manager_id();
		
		allUpdateProbationDAO.updateExtendedStatus(status,probationmanager_id);
			System.out.println("test");
		}
	
	request.getRequestDispatcher("probationFormApprovalHR.jsp").forward(request, response);
	}

}
