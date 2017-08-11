package com.hrms.exitformality.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.hrms.exitformality.bean.DetailsOfHandOverFormBean;
import com.hrms.exitformality.bean.DetailsOfMaterialBean;
import com.hrms.exitformality.bean.DetailsOfPendingMattersBean;
import com.hrms.exitformality.bean.DetailsOfResponsibilitiesBean;
import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.bean.HandOverApprovalBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.exitformality.dao.AllListExitFormalityDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.sun.corba.se.spi.orbutil.fsm.State;

public class HandOverFormDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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
				String specificPurpose = null;
				
				int hand_over_form_detail_id = 0;
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
							
							if (fieldName.equalsIgnoreCase("hand_over_form_detail_id")) {
								String value = fieldValue;
								hand_over_form_detail_id = Integer.parseInt(value);
								System.out.println("hand_over_form_detail_id:"+hand_over_form_detail_id);
								detailsOfHandOverFormBean.setDetails_of_hand_over_form_id(hand_over_form_detail_id);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("responsibility")) {
								responsibility = fieldValue;
								System.out.println("responsibility:"+responsibility);
							}
							
							
							if (fieldName.equalsIgnoreCase("responsibilityStatus")) {
								responsibilityStatus = fieldValue;
								System.out.println("responsibilityStatus:"+responsibilityStatus);
							}
							
							if (fieldName.equalsIgnoreCase("responsibilityInsert")) {
							
							DetailsOfResponsibilitiesBean detailsOfResponsibilitiesBean = new DetailsOfResponsibilitiesBean(responsibility, responsibilityStatus, detailsOfHandOverFormBean);
							boolean result = allInsertExitFormalityDAO.responsibilityDetailInsert(detailsOfResponsibilitiesBean);
							System.out.println("inserted............");
							}
						
							
							
							if (fieldName.equalsIgnoreCase("pendingMatters")) {
								pendingMatters = fieldValue;
								System.out.println("pendingMatters:"+pendingMatters);
							}
							
							
							if (fieldName.equalsIgnoreCase("pendingMattersStatus")) {
								pendingMattersStatus = fieldValue;
								System.out.println("pendingMattersStatus:"+pendingMattersStatus);
							}
							
							if (fieldName.equalsIgnoreCase("pendingMattersInsert")) {

								DetailsOfPendingMattersBean detailsOfPendingMattersBean = new DetailsOfPendingMattersBean(pendingMatters, pendingMattersStatus, detailsOfHandOverFormBean);
								boolean result = allInsertExitFormalityDAO.pendingMattersDetailInsert(detailsOfPendingMattersBean);
								System.out.println("inserted............");
							}
							
							
							if (fieldName.equalsIgnoreCase("material")) {
								material = fieldValue;
								System.out.println("material:"+material);
							}
							
							
							if (fieldName.equalsIgnoreCase("materialStatus")) {
								materialStatus = fieldValue;
								System.out.println("materialStatus:"+materialStatus);
							}
							
							if (fieldName.equalsIgnoreCase("materialInsert")) {
								
								DetailsOfMaterialBean detailsOfMaterialBean = new DetailsOfMaterialBean(material, materialStatus, detailsOfHandOverFormBean);
								boolean result = allInsertExitFormalityDAO.materialDetailInsert(detailsOfMaterialBean);
								System.out.println("inserted............");
							}
							
							
							if (fieldName.equalsIgnoreCase("approvalInsert")) {
								
								System.out.println("approvalInsert");
								
								List<Integer> arrayOfEmpID = new ArrayList();
								
								AllListExitFormalityDAO allListExitFormalityDAO = new AllListExitFormalityDAO();
								DetailsOfHandOverFormBean detailsOfHandOverFormBean1 = allListExitFormalityDAO.getDetailOfHandOverById(hand_over_form_detail_id);
								
								int hand_over_from_employee_id = user.getEmployee_master_id();
								int hand_over_to_employee_id = detailsOfHandOverFormBean1.getHand_over_to_name();
								int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
								
								
								LoginDAO loginDAO = new LoginDAO();
								EmployeeBean employeeBean1 = loginDAO.getEmailId(under_manager_id);
								
								int empId = employeeBean1.getEmployee_master_id();
								
								
								arrayOfEmpID.add(hand_over_from_employee_id);
								arrayOfEmpID.add(hand_over_to_employee_id);
								arrayOfEmpID.add(empId);
								
								SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Date date = new Date();
								
								String approvalDateTime = formater.format(date);
								
								EmployeeBean bean = new EmployeeBean();
								
								for(int emp_id : arrayOfEmpID){
									String status = "Pending";
									if(hand_over_from_employee_id == emp_id){
										status = "Approved";
									}
									
									bean.setEmployee_master_id(emp_id);
									HandOverApprovalBean handOverApprovalBean = new HandOverApprovalBean(status, approvalDateTime, bean, detailsOfHandOverFormBean);
								
									boolean result = allInsertExitFormalityDAO.insertHandOverApproval(handOverApprovalBean);
								
								}
								
								
								String authority = user.getRoleBean().getRole_authority();
								int manager_id = user.getManagerBean().getManager_id();
								
								request.setAttribute("success", "Form Submitted Successfully");
								
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

