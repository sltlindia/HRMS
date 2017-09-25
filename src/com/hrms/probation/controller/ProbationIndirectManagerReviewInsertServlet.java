package com.hrms.probation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.dao.AllInsertProbationDAO;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;


//Author Name :- Ripal Soni
//For Getting Data jsp file and adding it to database
//Servlet for adding reporting manager's review (approved or rejected)
//Servlet for adding manager's review (approved or rejected)
public class ProbationIndirectManagerReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String to_be_terminated = "no";
		String to_be_confirmed = "no";
		String to_be_extended = "no";
		int probation_assessment_manager_id = Integer.parseInt(request.getParameter("probation_assessment_manager_id"));
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		System.out.println("emp_id:"+employee_master_id);
		int reviewing_manager_id = user.getEmployee_master_id();
		String transfer = request.getParameter("transfer");
		System.out.println("transfer:"+transfer);
		String manager_approval = "pending";
		if(request.getParameter("confirmation_top_management_approval") != null){
			if(request.getParameter("confirmation_top_management_approval").equalsIgnoreCase("no")){
				manager_approval = "approved";
			}
		}
		String manager_rejection_remarks = "null";
		String hr_approval = "pending";
		String hr_apporval_rejection_remarks = "null";
		String reporting_manager_approval = "approved";
		String top_management_approval  = "pending";
		String top_management_rejection_remarks = "null";
		String manager_suggestion = "null";
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_master_id);
		AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
		if (transfer.equalsIgnoreCase("manager1")) {
			to_be_terminated = request.getParameter("terminated");
			to_be_confirmed = request.getParameter("confirmed");
			to_be_extended = request.getParameter("extended");
			String period_to_be_extended = null;
			String remarks = request.getParameter("remarks1");
			System.out.println("remarks:"+remarks);
			String average = request.getParameter("average");
			String period_to_be_extended1 = null;
			double average1  = Double.parseDouble(average);
			int to_be_extended_db = 0;
			AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
			List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probation_assessment_manager_id);
			for(ProbationExtendBean p1 : listForExtend){
				String extend_period = p1.getExtended_period();
				to_be_extended_db = to_be_extended_db + Integer.parseInt(extend_period);
				
			}
			
			if(to_be_extended.equalsIgnoreCase("extendedYes")){
				period_to_be_extended = request.getParameter("extended_period");	
				period_to_be_extended1 = request.getParameter("extended_period");
				int ptbe = Integer.parseInt(period_to_be_extended) + to_be_extended_db;
				period_to_be_extended =  Integer.toString(ptbe);
			}
			else{
				period_to_be_extended = "0";
				period_to_be_extended1 = "0";
			}
			ProbationAssessmentManagerBean probationAssessmentManagerBean = new ProbationAssessmentManagerBean(
				reviewing_manager_id, average1, to_be_confirmed, to_be_terminated, to_be_extended, remarks,
				period_to_be_extended, employeeBean,manager_approval,manager_rejection_remarks,hr_approval,hr_apporval_rejection_remarks,top_management_approval,top_management_rejection_remarks,reporting_manager_approval);

			boolean result = allInsertProbationDAO.probationManagerReviewInsert(probationAssessmentManagerBean);
			int probationManager_id = probationAssessmentManagerBean.getProbation_assessment_manager_id();
			ProbationAssessmentManagerBean probationAssessmentManagerBean2 = new ProbationAssessmentManagerBean();
			probationAssessmentManagerBean2.setProbation_assessment_manager_id(probationManager_id);
			String status = "pending";
			ProbationExtendBean probationExtendBean = new ProbationExtendBean(period_to_be_extended, status, probationAssessmentManagerBean2);
			allInsertProbationDAO.probationManagerExtendedInsertIndirect(probationExtendBean);
			
		}
		else{
			System.out.println("pending");
			manager_approval = request.getParameter("action");
			System.out.println("manager_approval:"+transfer);
			manager_rejection_remarks = request.getParameter("remarks");
			System.out.println("manager_rejection_remarks:"+manager_rejection_remarks);
			manager_suggestion = request.getParameter("suggestion");
			System.out.println("manager_suggestion:"+manager_suggestion);
			AllUpdateProbationDAO  allUpdateProbationDAO = new AllUpdateProbationDAO();
			allUpdateProbationDAO.updateManagerApproval(manager_approval,manager_rejection_remarks,employee_master_id,manager_suggestion);
		}
		
		
			request.getRequestDispatcher("probationFormApprovalManager.jsp").forward(request, response);
		
		
	}
	}

}