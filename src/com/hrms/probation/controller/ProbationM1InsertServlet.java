package com.hrms.probation.controller;

import java.io.File;
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
import com.hrms.probation.bean.AttributeBean;
import com.hrms.probation.bean.ProbationAssessmentM1Bean;
import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.dao.AllInsertProbationDAO;
import com.hrms.probation.dao.AllListProbationDAO;
import com.hrms.probation.dao.AllUpdateProbationDAO;

//Author Name :- Ripal Soni
//For Getting Data jsp file and adding it to database
//Servlet for adding employees score by month for direct employees


public class ProbationM1InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			int year_id = 0;
			int employee_master_id = 0;
			int probation_attribute_id = 0;
			double attribute_score = 0;
			EmployeeBean employeeBean = new EmployeeBean();
			AttributeBean attributeBean = new AttributeBean();
			MonthBean monthBean = new MonthBean();
			YearBean yearBean = new YearBean();
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

						if (fieldName.equalsIgnoreCase("attribute_id")) {
							String value = fieldValue;
							probation_attribute_id = Integer.parseInt(value);
							System.out.println("attribute_id:" + probation_attribute_id);
							
							attributeBean.setProbation_attribute_id(probation_attribute_id);
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
						if (fieldName.equalsIgnoreCase("month_score")) {
							String value = fieldValue;
							attribute_score = Double.parseDouble(value);
							System.out.println("attribute_score:" + attribute_score);
							
							
							ProbationAssessmentM1Bean probationAssessmentM1Bean = new ProbationAssessmentM1Bean(attribute_score, monthBean, employeeBean, attributeBean,yearBean);
							if(attribute_score != 0)
							{
							AllInsertProbationDAO allInsertProbationDAO = new AllInsertProbationDAO();
							allInsertProbationDAO.probationm1ScoreInsert(probationAssessmentM1Bean);
							}}
							
						}
						if(fieldName.equalsIgnoreCase("redirect")) {
							request.setAttribute("Score", "Score Submitted Successfully....");
							AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
							long maxValue = allListProbationDAO.getCount(employee_master_id);
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
							if(maxValue == 6+to_be_extended){
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

			 catch (FileUploadException e) {
				e.printStackTrace();
			}}
	else {
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
} 	

