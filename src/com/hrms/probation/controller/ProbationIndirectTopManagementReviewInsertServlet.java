package com.hrms.probation.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.SystemOutLogger;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationExtendBean;
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
		LoginDAO loginDAO = new LoginDAO();
		EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(employee_master_id);
		String email_id = employeeBean.getEmail_id();
		String employee_name = employeeBean.getFirstname() +" "+ employeeBean.getLastname();
		String Salutation = employeeBean.getSalutation();
		String company_name = employeeBean.getCompanyListBean().getCompany_name();
		String role_name = employeeBean.getRoleBean().getRole_type();
		int to_be_extended = 6;
		AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
		int probationmanager_id = 0;
		Date date = new Date();
		int show_view = 0;
		SimpleDateFormat ddMMyyyy= new SimpleDateFormat("dd-MM-yyyy");
		String confirmation_date = ddMMyyyy.format(date);
		
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
		System.out.println("probation_id"+probationmanager_id);
		allUpdateProbationDAO.updateShowViewAndDate(confirmation_date,show_view,probationmanager_id);
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
		List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO.getListOfScoreByEmpIdWithHRApproval(employee_master_id);
		for(ProbationAssessmentManagerBean li : listOfExtended){
			probationmanager_id = li.getProbation_assessment_manager_id();
			allUpdateProbationDAO.updateStatus(probationmanager_id,top_management_approval);
			allUpdateProbationDAO.updateExtendedStatus(top_management_approval,probationmanager_id);
				System.out.println("test");
			}
		
		request.getRequestDispatcher("probationFormApprovalTM.jsp").forward(request, response);
		
	}

}
