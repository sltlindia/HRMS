package com.hrms.exitformality.controller;

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

import com.hrms.exitformality.bean.DetailsOfHandOverFormBean;
import com.hrms.exitformality.bean.DetailsOfMaterialBean;
import com.hrms.exitformality.bean.DetailsOfPendingMattersBean;
import com.hrms.exitformality.bean.DetailsOfResponsibilitiesBean;
import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.bean.ExitInterviewScoreBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.exitformality.dao.AllUpdateExitFormalityDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class DetailsOfHandOverInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
			/*
			String handOverFromName = request.getParameter("handOverFromName");
			String handOverFromDesignation = request.getParameter("handOverFromDesignation");
			String handOverFromDepartment = request.getParameter("handOverFromDepartment");
			int handOverToName = Integer.parseInt(request.getParameter("handOverToName"));
			int handOverToDesignation = Integer.parseInt(request.getParameter("handOverToDesignation"));
			int handOverToDepartment = Integer.parseInt(request.getParameter("handOverToDepartment"));
			String purposeOfHandOver = request.getParameter("purpose");
			String specificPurpose = request.getParameter("specificPurpose");
			
			
			AllInsertExitFormalityDAO allInsertExitFormalityDAO = new AllInsertExitFormalityDAO();
			DetailsOfHandOverFormBean detailsOfHandOverFormBean = new DetailsOfHandOverFormBean(handOverFromName, handOverFromDesignation, handOverFromDepartment, handOverToName, handOverToDesignation, handOverToDepartment, purposeOfHandOver, specificPurpose);
			
			boolean result = allInsertExitFormalityDAO.handOverFormDetailInsert(detailsOfHandOverFormBean);
			System.out.println("Inserted");
			*/
			
			
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
				
				
				
				String handOverFromName = null;
				String handOverFromDesignation = null;
				String handOverFromDepartment = null;
				int handOverToName = 0;
				int handOverToDesignation = 0;
				int handOverToDepartment = 0;
				String purposeOfHandOver = null;
				String specificPurpose = "null";
				String responsibility = null;
				String responsibilityStatus = null;
				String pendingMatters= null;
				String pendingMattersStatus = null;
				String material = null;
				String materialStatus = null;
				
				
				AllInsertExitFormalityDAO allInsertExitFormalityDAO = new AllInsertExitFormalityDAO();
				DetailsOfHandOverFormBean detailsOfHandOverFormBean = new DetailsOfHandOverFormBean();
				ExitInterviewEmployeeBean exitInterviewEmployeeBean = new ExitInterviewEmployeeBean();
				EmployeeBean employeeBean = new EmployeeBean();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
							
							if (fieldName.equalsIgnoreCase("handOverFromName")) {
								handOverFromName = fieldValue;
								System.out.println("handOverFromName:"+handOverFromName);
							}
							
							if (fieldName.equalsIgnoreCase("handOverFromDesignation")) {
								handOverFromDesignation = fieldValue;
								System.out.println("handOverFromDesignation:"+handOverFromDesignation);
							}
							
							if (fieldName.equalsIgnoreCase("handOverFromDepartment")) {
								handOverFromDepartment = fieldValue;
								System.out.println("handOverFromDepartment:"+handOverFromDepartment);
							}
							
							
							if (fieldName.equalsIgnoreCase("handOverToName")) {
								String value = fieldValue;
								
								String[] split = value.split(",");
								int emp_code = Integer.parseInt(split[0]);
								String name = split[1];
								int other_manager_id = 0;
								
								String[] splitName = name.split(" ");
								String firstName = splitName[0];
								String lastName = splitName[1];
								
								
								LoginDAO loginDAO = new LoginDAO();
								EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);
								
								 handOverToName = employeeBean1.getEmployee_master_id();
								
								System.out.println("handOverToName:"+handOverToName);
								
							}
							
							if (fieldName.equalsIgnoreCase("handOverToDesignation")) {
								String value = fieldValue;
								handOverToDesignation = Integer.parseInt(value);
								System.out.println("handOverToDesignation:"+handOverToDesignation);
							}
							
							if (fieldName.equalsIgnoreCase("handOverToDepartment")) {
								String value = fieldValue;
								handOverToDepartment = Integer.parseInt(value);
								System.out.println("handOverToDepartment:"+handOverToDepartment);
							}
							
							
							if (fieldName.equalsIgnoreCase("purpose")) {
								purposeOfHandOver = fieldValue;
								System.out.println("purposeOfHandOver:"+purposeOfHandOver);
							}
							
							if (fieldName.equalsIgnoreCase("specificPurpose")) {
								specificPurpose = fieldValue;
								System.out.println("specificPurpose:"+specificPurpose);
							}
							
							
							
							
							if (fieldName.equalsIgnoreCase("handOverDetailInsert")) {

								int emp_id = user.getEmployee_master_id();
								employeeBean.setEmployee_master_id(emp_id);
								
								detailsOfHandOverFormBean = new DetailsOfHandOverFormBean(handOverFromName, handOverFromDesignation, handOverFromDepartment, handOverToName, handOverToDesignation, handOverToDepartment, purposeOfHandOver, specificPurpose,employeeBean);
								boolean result = allInsertExitFormalityDAO.handOverFormDetailInsert(detailsOfHandOverFormBean);
								System.out.println("Inserted");
								int hand_over_form_detail_id = detailsOfHandOverFormBean.getDetails_of_hand_over_form_id();
								detailsOfHandOverFormBean.setDetails_of_hand_over_form_id(hand_over_form_detail_id);
								
								request.setAttribute("hand_over_form_detail_id", hand_over_form_detail_id);
								request.getRequestDispatcher("handOverForm.jsp").forward(request, response);
							
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
