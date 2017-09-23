package com.hrms.exitformality.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.bean.ExitInterviewScoreBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.exitformality.dao.AllUpdateExitFormalityDAO;
import com.hrms.pms.bean.EmployeeBean;


public class ExitInterviewFormInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
			String filePath = 
		             getServletContext().getInitParameter("file-upload"); 
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			 List<FileItem> items = null;
				String fieldName = null;
				String fieldValue = null;
				String fileName = null;
				File file = null;
				
				
				int employee_id = user.getEmployee_master_id();
				String department = user.getDepartmentBean().getDepartment_name();
				String reporting_manager = user.getUnder_manager_id();
				String designation = user.getRoleBean().getRole_type();
				String date_of_joining = user.getJoining_date();
				int exit_interview_employee_id = 0;
				String additional_comment = null;
				String termination_date = null;
				String exit_attribute_name = null;
				String score = null;
				String comments = "null";
				SimpleDateFormat formater = new SimpleDateFormat("dd MMMM,YYYY");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				
				
				AllInsertExitFormalityDAO allInsertExitFormalityDAO = new AllInsertExitFormalityDAO();
				ExitInterviewEmployeeBean exitInterviewEmployeeBean = new ExitInterviewEmployeeBean();
				EmployeeBean employeeBean = new EmployeeBean();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
							
							if (fieldName.equalsIgnoreCase("termination_date")) {
								termination_date = fieldValue;
								
								try {
									
									Date date = formater.parse(termination_date);
									termination_date = formater1.format(date);
								
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								System.out.println("termination_date:"+termination_date);
							}
							
							if (fieldName.equalsIgnoreCase("terminate")) {
								
								employeeBean.setEmployee_master_id(employee_id);
								exitInterviewEmployeeBean = new ExitInterviewEmployeeBean(department, reporting_manager, designation, date_of_joining, termination_date, employeeBean);
								boolean result = allInsertExitFormalityDAO.exitInterviewEmployeeInsert(exitInterviewEmployeeBean);
								exit_interview_employee_id = exitInterviewEmployeeBean.getExit_interview_employee_id();
								
								System.out.println("MAIN ID " + exit_interview_employee_id);
								
							
							}
							
							if (fieldName.equalsIgnoreCase("exit_attribute_name")) {
								exit_attribute_name = fieldValue;
								System.out.println("exit_attribute_name:"+exit_attribute_name);
							}
							
							if (fieldName.equalsIgnoreCase("score")) {
								score = fieldValue;
								System.out.println("score:"+score);
							}
							
							if (fieldName.equalsIgnoreCase("comments")) {
								comments = fieldValue;
								System.out.println("comments:"+comments);
							}
							
							if (fieldName.equalsIgnoreCase("attributeInsert")) {
								
								
								System.out.println("SKY");
								
								exitInterviewEmployeeBean.setExit_interview_employee_id(exit_interview_employee_id);
								ExitInterviewScoreBean exitInterviewScoreBean = new ExitInterviewScoreBean(exit_attribute_name, score, comments, exitInterviewEmployeeBean);
								allInsertExitFormalityDAO.exitInterviewScoreInsert(exitInterviewScoreBean);
								
								
							}
							
							if (fieldName.equalsIgnoreCase("additional_comment")) {
								additional_comment = fieldValue;
								System.out.println("additional_comment:"+additional_comment);
								
								
								AllUpdateExitFormalityDAO allUpdateExitFormalityDAO = new AllUpdateExitFormalityDAO();
								boolean result = allUpdateExitFormalityDAO.additionalCommentUpdate(exit_interview_employee_id, additional_comment);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("temp")) 
							{
								request.setAttribute("success", "Form Successfully Inserted...");
								
								String authority = user.getRoleBean().getRole_authority();
								int manager_id = user.getManagerBean().getManager_id();
								int under_manager_id = Integer.parseInt(user.getUnder_manager_id());			
								
								
			if (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
					|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
					|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
					|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
		
					if(manager_id != 99){
					
					if(manager_id == 1 || manager_id == 2 || manager_id == 3){ 
						request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
					}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
						request.getRequestDispatcher("hrHome.jsp").forward(request, response);
				
					}else{
						request.getRequestDispatcher("managerHome.jsp").forward(request, response);
					} 
					}else{
						if(under_manager_id == 4 || under_manager_id == 117){ 
							request.getRequestDispatcher("hrHome.jsp").forward(request, response);
					}else{		
							request.getRequestDispatcher("empHome.jsp").forward(request, response);
				}}}
								
								
								
								
								
								
								
							}	
							
							
						}
							
					}
							
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			
				}else{
					request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			
			}

		}
