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
		int probationmanager_id = 0;
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
				probationmanager_id = li.getProbation_assessment_manager_id();
				
				allUpdateProbationDAO.updateExtendedStatus(status,probationmanager_id);
				}
			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(employee_master_id);
			String email_id = employeeBean.getEmail_id();
			String employee_name = employeeBean.getFirstname() +" "+ employeeBean.getLastname();
			String Salutation = employeeBean.getSalutation();
			String company_name = employeeBean.getCompanyListBean().getCompany_name();
			String role_name = employeeBean.getRoleBean().getRole_type();
			int to_be_extended = 6;
			Date date = new Date();
			int show_view = 0;
			SimpleDateFormat ddMMyyyy= new SimpleDateFormat("dd-MM-yyyy");
			String confirmation_date = ddMMyyyy.format(date);
			System.out.println("probation_id"+probationmanager_id);
			allUpdateProbationDAO.updateShowViewAndDate(confirmation_date,show_view,probationmanager_id);
			List<ProbationAssessmentManagerBean> listOfExtendedd = allListProbationDAO.getListOfScoreByEmpId(employee_master_id);
			for (ProbationAssessmentManagerBean pb : listOfExtendedd) {
				probationmanager_id = pb.getProbation_assessment_manager_id();
				List<ProbationExtendBean> listForExtend = allListProbationDAO
						.getProbationExtend(probationmanager_id);
				for (ProbationExtendBean p : listForExtend) {
					String extend_period = p.getExtended_period();
					to_be_extended = to_be_extended + Integer.parseInt(extend_period);
				}
			}
			int tobeextended = to_be_extended;
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			    	String to = email_id;
			    	String employeename = employee_name;
			    	String salutation = Salutation;
			    	String companyname = company_name;
			    	String rolename = role_name;
			    	String sub = "Probation Confimation";
			    	int to_be_extended1 = tobeextended;
			    	Mailer.sendProbationEmailEmployeeMonth(to, sub, employeename,salutation,companyname,rolename,to_be_extended1);
			    	System.out.println("Done");
			    }
			}).start();
		}
		request.getRequestDispatcher("probationFormApprovalHR.jsp").forward(request, response);
	}

}
