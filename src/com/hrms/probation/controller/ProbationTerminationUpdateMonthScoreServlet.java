package com.hrms.probation.controller;

import java.io.File
;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.probation.bean.AttributeM2Bean;
import com.hrms.probation.bean.ProbationAssessmentM2Bean;
import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationAssessmentTerminationBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.dao.AllDeleteProbationDAO;
import com.hrms.probation.dao.AllInsertProbationDAO;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;
public class ProbationTerminationUpdateMonthScoreServlet extends HttpServlet {
private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
	

	HttpSession session = request.getSession();
	EmployeeBean user = (EmployeeBean) session.getAttribute("user");
	if (user != null) {
		
		String filePath = getServletContext().getInitParameter("goal-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		
		
		double attribute_m2_score = 0;
		String continue_for_next_month = null;
		String warning_letter = null;
		String termination_letter  = null;
		String manager_status = null;
		int probation_assessment_m2_id = 0;
		int probation_assessment_termination_id = 0;
		int employee_master_id = 0;
		int reviewing_manager_id = 0;
		int month_id = 0;
		int year_id = 0;
		
		
		int under_manager_Of_reviewing = Integer.parseInt(user.getUnder_manager_id());
		
		LoginDAO loginDAO = new LoginDAO();
		EmployeeBean employeeBean1 = loginDAO.getEmailId(under_manager_Of_reviewing);
		
		/*String role_authority = employeeBean1.getRoleBean().getRole_authority();*/
		int role_id = employeeBean1.getRoleBean().getRole_id();
		
		String termination_remarks = null;
		EmployeeBean employeeBean = new EmployeeBean();
		MonthBean monthBean = new MonthBean();
		YearBean yearBean = new YearBean();
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);

				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("probation_assessment_termination_id")) {
						String value = fieldValue;
						probation_assessment_termination_id = Integer.parseInt(value);
						System.out.println("probation_assessment_termination_id:" + probation_assessment_termination_id);
						AllDeleteProbationDAO allDeleteProbationDAO = new AllDeleteProbationDAO();
						allDeleteProbationDAO.deleteTerminationPeriod(probation_assessment_termination_id);
						
					}
					if (fieldName.equalsIgnoreCase("attribute_id")) {
						String value = fieldValue;
						probation_assessment_m2_id = Integer.parseInt(value);
						System.out.println("probation_assessment_m2_id:" + probation_assessment_m2_id);
						
					}
					if (fieldName.equalsIgnoreCase("employee_master_id")) {
						String value = fieldValue;
						employee_master_id = Integer.parseInt(value);
						System.out.println("employee_master_id:" + employee_master_id);
						employeeBean.setEmployee_master_id(employee_master_id);
					}
					if (fieldName.equalsIgnoreCase("month_id")) {
						String value = fieldValue;
						month_id = Integer.parseInt(value);
						System.out.println("month_id:" + month_id);
						monthBean.setMonth_id(month_id);
					}
					if (fieldName.equalsIgnoreCase("year_id")) {
						String value = fieldValue;
						year_id = Integer.parseInt(value);
						System.out.println("month_id:" + year_id);
						yearBean.setYear_id(year_id);
					}
					if (fieldName.equalsIgnoreCase("reviewing_manager_id")) {
						String value = fieldValue;
						reviewing_manager_id = Integer.parseInt(value);
						System.out.println("revewing_manager_id:" + reviewing_manager_id);
						
					}
					if (fieldName.equalsIgnoreCase("month_score")) {
						String value = fieldValue;
						attribute_m2_score = Double.parseDouble(value);
						System.out.println("attribute_m2_score:" + attribute_m2_score);
						if(attribute_m2_score != 0)
						{
						AllUpdateProbationDAO allUpdateProbationDAO = new AllUpdateProbationDAO();
						allUpdateProbationDAO.probationm2ScoreUpdateMonthWise(attribute_m2_score, probation_assessment_m2_id);
						}
						
					}
					if (fieldName.equalsIgnoreCase("continueMonth")) {
						continue_for_next_month  = fieldValue;
						System.out.println("continue_for_next_month:" + continue_for_next_month);
						
					}
					if (fieldName.equalsIgnoreCase("warningLetter")) {
						warning_letter  = fieldValue;
						System.out.println("warning_letter:" + warning_letter);
						
					}
					
					if (fieldName.equalsIgnoreCase("terminationLetter")) {
						termination_letter  = fieldValue;
						System.out.println("terminationLetter:" + termination_letter);
						AllUpdateProbationDAO allUpdateProbationDAO = new AllUpdateProbationDAO();
						allUpdateProbationDAO.probationm2ScoreUpdateByProbationId(continue_for_next_month,warning_letter,termination_letter,employee_master_id,month_id,year_id);
						manager_status = "pending";
						
						if(role_id == 2 ||role_id == 3  || role_id == 9){
							manager_status = "hrPending";
						}
						
						
						System.out.println("inserted");
						
						
						
						}
					
					if (fieldName.equalsIgnoreCase("termination_remarks")) {
						termination_remarks  = fieldValue;
						System.out.println("termination_remarks:" + termination_remarks);
						if(termination_letter.equalsIgnoreCase("terminationYes")){
							System.out.println("terminedted inside");
							if (termination_remarks != null) {
								termination_remarks  = fieldValue;
								System.out.println("termination_remarks:" + termination_remarks);
								System.out.println("inside");
								AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
								ProbationAssessmentTerminationBean probationAssessmentTerminationBean = new ProbationAssessmentTerminationBean(reviewing_manager_id, employeeBean, manager_status,monthBean,yearBean,termination_remarks);
								allInsertProbationDAO.terminationInsert(probationAssessmentTerminationBean);
							}}else{
								System.out.println("inside");
								termination_remarks = "null";
								AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
								ProbationAssessmentTerminationBean probationAssessmentTerminationBean = new ProbationAssessmentTerminationBean(reviewing_manager_id, employeeBean, manager_status,monthBean,yearBean,termination_remarks);
								allInsertProbationDAO.terminationInsert(probationAssessmentTerminationBean);
							}
						
					}
					
					
					if(fieldName.equalsIgnoreCase("redirect")) {
						request.getRequestDispatcher("probationFormApprovalManager.jsp").forward(request, response);
					}
					
				} 
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	} else {
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
}
