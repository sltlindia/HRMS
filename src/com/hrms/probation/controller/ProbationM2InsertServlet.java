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
import com.hrms.probation.dao.AllInsertProbationDAO;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;
//Author Name :- Ripal Soni
	//For Getting Data jsp file and adding it to database
	//Servlet for adding employees score by month for indirect employees

public class ProbationM2InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
				
				int month_id = 0;
				int employee_master_id = 0;
				int year_id = 0;
				int probation_attribute_M2_id = 0;
				int reviewing_manager_id = user.getEmployee_master_id();
				int under_manager_Of_reviewing = Integer.parseInt(user.getUnder_manager_id());
				
				LoginDAO loginDAO = new LoginDAO();
				EmployeeBean employeeBean1 = loginDAO.getEmailId(under_manager_Of_reviewing);
				
				String role_authority = employeeBean1.getRoleBean().getRole_authority();
				
				double attribute_m2_score = 0;
				String comments_month_wise = null;
				String continue_for_next_month = null;
				String warning_letter = null;
				String termination_letter  = null;
				double average = 0 ;
				EmployeeBean employeeBean = new EmployeeBean();
				AttributeM2Bean attributeM2Bean = new AttributeM2Bean();
				MonthBean monthBean = new MonthBean();
				YearBean yearBean = new YearBean();
				AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);

						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							if (fieldName.equalsIgnoreCase("employee_master_id")) {
								String value = fieldValue;
								employee_master_id = Integer.parseInt(value);
								System.out.println("employee_master_id:" + employee_master_id);
								
								employeeBean.setEmployee_master_id(employee_master_id);
							}
							
							long maxValue = 0;
							EmployeeBean employeeBeanEmployee = loginDAO.getInfoById(employee_master_id);
							String authority = employeeBeanEmployee.getRoleBean().getRole_authority();
							
							if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3")
																										|| authority.equals("T1") || authority.equals("T2") || authority.equals("T3")
																										|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3")
																										|| authority.equals("A4")) {

								maxValue = allListProbationDAO.getCount(employee_master_id);
							}else {
																								
							maxValue = allListProbationDAO.getCountForM2(employee_master_id);

							}
							 
							request.setAttribute("employee_master_id", employee_master_id);
							
							int to_be_extended = 0;
							List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO.getListOfScoreByEmpIdWithHRApproval(employee_master_id);
							for(ProbationAssessmentManagerBean li : listOfExtended1){
								int probationmanager_id = li.getProbation_assessment_manager_id();
								
								List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
								for(ProbationExtendBean p : listForExtend){
									String extend_period = p.getExtended_period();
									to_be_extended = to_be_extended + Integer.parseInt(extend_period);
									
								}
							}

							if (fieldName.equalsIgnoreCase("attribute_id")) {
								String value = fieldValue;
								probation_attribute_M2_id = Integer.parseInt(value);
								System.out.println("attribute_id:" + probation_attribute_M2_id);
								
								attributeM2Bean.setProbation_attribute_M2_id(probation_attribute_M2_id);
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
								System.out.println("year_id:" + year_id);
								
								yearBean.setYear_id(year_id);
							}
							
							if (fieldName.equalsIgnoreCase("month_score")) {
								String value = fieldValue;
								attribute_m2_score = Double.parseDouble(value);
								System.out.println("attribute_m2_score:" + attribute_m2_score);
								ProbationAssessmentM2Bean probationAssessmentM2Bean = new ProbationAssessmentM2Bean(attribute_m2_score, monthBean, employeeBean, attributeM2Bean,yearBean);
								if(attribute_m2_score != 0)
								{
								AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
								allInsertProbationDAO.probationm2ScoreInsert(probationAssessmentM2Bean);
								}
								
							}
							
							if (fieldName.equalsIgnoreCase("comments_month_wise")) {
								comments_month_wise  = fieldValue;
								System.out.println("comments_month_wise:" + comments_month_wise);
								
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
								allUpdateProbationDAO.probationm2ScoreUpdate(continue_for_next_month,warning_letter,termination_letter,month_id,year_id,comments_month_wise);
								allUpdateProbationDAO.probationm2ScoreUpdateComment(employee_master_id,comments_month_wise);
								System.out.println("inserted");
							}
							
								if (fieldName.equalsIgnoreCase("termination_remarks")) {
									System.out.println("inside");
									if(termination_letter.equalsIgnoreCase("terminationYes") && maxValue != (to_be_extended+6)){
										String manager_status = "pending";
										
										if(role_authority.equalsIgnoreCase("D1") || role_authority.equalsIgnoreCase("D2") || role_authority.equalsIgnoreCase("D3") || role_authority.equalsIgnoreCase("D4")){
											manager_status = "hrPending";
										}
										
										String termination_remarks = "null";
										termination_remarks  = fieldValue;
										System.out.println("termination_remarks:" + termination_remarks);
										System.out.println("inside");
										AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
										ProbationAssessmentTerminationBean probationAssessmentTerminationBean = new ProbationAssessmentTerminationBean(reviewing_manager_id, employeeBean, manager_status,monthBean,yearBean,termination_remarks);
										allInsertProbationDAO.terminationInsert(probationAssessmentTerminationBean);
									}
									
								}
								
							if(fieldName.equalsIgnoreCase("redirect")) {
								request.setAttribute("Score", "Score Submitted Successfully....");
								
								
							
								
								System.out.println("maxValue:"+maxValue);
								System.out.println("To Be Extended:"+to_be_extended);
								
								if(maxValue == (6 + to_be_extended)){
									System.out.println("inif");
									String manager_approval = "pending";
									String manager_rejection_remarks = "null";
									String hr_approval = "pending";
									String hr_rejection_remarks = "null";
									String top_management_approval = "pending"; 
									String top_management_rejection_remarks = "null";
									String reporting_manager_approval = "pending";
									AllUpdateProbationDAO allUpdateProbationDAO = new AllUpdateProbationDAO();
									allUpdateProbationDAO.updateAfterExtend(employee_master_id, manager_approval, manager_rejection_remarks, hr_approval, hr_rejection_remarks, top_management_approval, top_management_rejection_remarks,reporting_manager_approval);
									request.getRequestDispatcher("probationFormApprovalManager.jsp").forward(request, response);
								}else{
									System.out.println("inelse");
									request.getRequestDispatcher("probationFormApprovalManager.jsp").forward(request, response);
								}	
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
