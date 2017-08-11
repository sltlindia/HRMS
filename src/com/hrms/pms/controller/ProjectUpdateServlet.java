package com.hrms.pms.controller;

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

import com.hrms.lms.dao.AllListDAO;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.CostFeasibilityBean;
import com.hrms.pms.bean.CurrencyBean;
import com.hrms.pms.bean.DesignInputsBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.EngineeringFeasibilityBean;
import com.hrms.pms.bean.FixtureFeasibiltyBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ManufacturingFeasibilityBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectDesignInputsBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ProjectStatusBean;
import com.hrms.pms.bean.QualityFeasibilityBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class DesignInputsInsertServlet
 */
public class ProjectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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
		int manager_id = user.getManagerBean().getManager_id();
		int client_id = 0;
		String client_type = "AMA";
		String status = "pending";
		int approver_id = 0;
		
		String projectCode = null;
		String projectName = null;
		
		String client_name = null;
		String approver_name = null;
		String duration = null;
		String resources = null;
		String plannedStartDate = null;
		String plannedEndDate = null;
		String project_category = null;
		String project_desc = null;
		String deliverable = null;
		String billing_frequency = "Monthly";
		int currency_id = 1; 
		int misc_Project = 0;
		int engFeasibility_id = 0;
		int fixFeasibility_id = 0;
		int manFeasibility_id =0;
		int qualityFeasibility_id = 0;
		int costFeasibility_id = 0;
		
		String billing_type = "-";
		double billingCost = 0;
		
		int projectStatus = 3;
		String hold_date ="-";
		String hold_reason ="-";
		String resume_date="-";
		String actual_start="-";
		String actual_end="-";
		
		double project_cost = 0;
		double machine_cost = 0;
		int priority_id = 0;
		String billable = null;
		String feasibilty = "";
		String subFeasibilty = null;
		String remarks = null;
		int project_id = 0;
		int keyword_id = 0;
		String keyword = null;
		
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		DesignInputsBean designInputsBean = new DesignInputsBean();
		ManagerBean managerBean = new ManagerBean();
		ProjectStatusBean projectStatusBean = new ProjectStatusBean();
		ClientMasterBean clientMasterBean = new ClientMasterBean();
		
		managerBean.setManager_id(manager_id);
		projectStatusBean.setProject_status_id(projectStatus);
		
		PriorityBean priorityBean = new PriorityBean();
		CurrencyBean currencyBean = new CurrencyBean();
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		
		AllListDAO allListDAO = new AllListDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					
					if (fieldName.equalsIgnoreCase("project_id")) {
						String value = fieldValue;
						project_id = Integer.parseInt(value);
						System.out.println("project_id:"+project_id);
						projectMasterBean.setProject_master_id(project_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("project_code")) {
						projectCode = fieldValue;
						System.out.println("project_code:"+projectCode);
						
					}
					
					if (fieldName.equalsIgnoreCase("project_name")) {
						projectName = fieldValue;
						System.out.println("projectName:"+projectName);
					}
					
					
					if (fieldName.equalsIgnoreCase("client_id")) {
						String value = fieldValue;
						client_id = Integer.parseInt(value);
							
					}
					
					
					
					if (fieldName.equalsIgnoreCase("duration")) {
						duration = fieldValue;
						System.out.println("duration:"+duration);
						
					}
					
					if (fieldName.equalsIgnoreCase("plannedResources")) {
						resources = fieldValue;
						System.out.println("resources:"+resources);
					}
					
					if (fieldName.equalsIgnoreCase("start_date")) {
						plannedStartDate = fieldValue;
						System.out.println("plannedStartDate:"+plannedStartDate);
						
					}
					
					if (fieldName.equalsIgnoreCase("end_date")) {
						plannedEndDate = fieldValue;
						System.out.println("plannedEndDate:"+plannedEndDate);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("deliverable")) {
						deliverable = fieldValue;
						System.out.println("deliverable:"+deliverable);
						
						
						boolean result = allUpdateDAO.projectAllUpdate(projectName, project_desc, plannedStartDate, plannedEndDate, project_cost, resources, duration, client_id, priority_id,project_id,projectCode,machine_cost,deliverable);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("cost")) {
						String value = fieldValue;
						project_cost = Double.parseDouble(value);
						System.out.println("project_cost:"+project_cost);
						
					}
					
					if (fieldName.equalsIgnoreCase("machineCost")) {
						String value = fieldValue;
						machine_cost = Double.parseDouble(value);
						System.out.println("machine_cost:"+machine_cost);
						
					}
					
					if (fieldName.equalsIgnoreCase("priority_id")) {
						String value = fieldValue;
						priority_id = Integer.parseInt(value);
						System.out.println("priority_id:"+priority_id);
						priorityBean.setPriority_id(priority_id);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("project_desc")) {
						project_desc = fieldValue;
						System.out.println("project_desc:"+project_desc);
						
					}
					
					
					
					if (fieldName.equalsIgnoreCase("engFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("ENGINEERINGFEASIBILITY")){
					
						if (fieldName.equalsIgnoreCase("engFeasibility_id")) {
							String value = fieldValue;
							engFeasibility_id = Integer.parseInt(value);
							System.out.println("engFeasibility_id:"+engFeasibility_id);
							
						}	
						
					
					if (fieldName.equalsIgnoreCase("engineeringFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("engineeringFeasibility:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("engineeringremarks")) {
						remarks = fieldValue;
						System.out.println("engineeringremarks:"+remarks);
						
						if(engFeasibility_id != 0 ){
							EngineeringFeasibilityBean engineeringFeasibilityBean = new EngineeringFeasibilityBean(engFeasibility_id, subFeasibilty, remarks, projectMasterBean);
							boolean result = allUpdateDAO.engFeasibilityUpdate(engineeringFeasibilityBean);
						}else{
							EngineeringFeasibilityBean engineeringFeasibilityBean = new EngineeringFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
							boolean result1 = allInsertDAO.EngineeringFeasibiltyInsert(engineeringFeasibilityBean);
						}
						
					}
					
					}
					
					if (fieldName.equalsIgnoreCase("fixFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("FIXTUREFEASIBILITY")){
						
						if (fieldName.equalsIgnoreCase("fixFeasibility_id")) {
							String value = fieldValue;
							fixFeasibility_id = Integer.parseInt(value);
							System.out.println("fixFeasibility_id:"+fixFeasibility_id);
							
						}
					
					if (fieldName.equalsIgnoreCase("fixtureFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("fixtureFeasibility:"+subFeasibilty);
						
					}
					
					if (fieldName.equalsIgnoreCase("fixtureremarks")) {
						remarks = fieldValue;
						System.out.println("fixtureremarks:"+remarks);
						
						if(fixFeasibility_id != 0){
							FixtureFeasibiltyBean fixtureFeasibiltyBean = new FixtureFeasibiltyBean(fixFeasibility_id, subFeasibilty, remarks, projectMasterBean);
							boolean result1 = allUpdateDAO.fixFeasibilityUpdate(fixtureFeasibiltyBean);
						}else{
							FixtureFeasibiltyBean fixtureFeasibiltyBean = new FixtureFeasibiltyBean(subFeasibilty, remarks, projectMasterBean);
							boolean result2 = allInsertDAO.FixtureFeasiblityInsert(fixtureFeasibiltyBean);
						}
						
					}
					}
					
					if (fieldName.equalsIgnoreCase("manFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("MANUFACTURINGFEASIBILITY")){
						
						if (fieldName.equalsIgnoreCase("manFeasibility_id")) {
							String value = fieldValue;
							manFeasibility_id = Integer.parseInt(value);
							System.out.println("manFeasibility_id:"+manFeasibility_id);
							
						}
						
					if (fieldName.equalsIgnoreCase("manufacturingFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("manufacturingFeasibility:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("manufacturingremarks")) {
						remarks = fieldValue;
						System.out.println("manufacturingremarks:"+remarks);
						
						if(manFeasibility_id != 0){
							ManufacturingFeasibilityBean manufacturingFeasibilityBean = new ManufacturingFeasibilityBean(manFeasibility_id, subFeasibilty, remarks, projectMasterBean);
							boolean result2 = allUpdateDAO.manFeasibilityUpdate(manufacturingFeasibilityBean);
						}else{
						ManufacturingFeasibilityBean manufacturingFeasibilityBean = new ManufacturingFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
						boolean result3 = allInsertDAO.ManufactureFeasiblityInsert(manufacturingFeasibilityBean);
						}
					}
					}
					
					if (fieldName.equalsIgnoreCase("qualFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("QUALITYFEASIBILITY")){
						
						if (fieldName.equalsIgnoreCase("qualityFeasibility_id")) {
							String value = fieldValue;
							qualityFeasibility_id = Integer.parseInt(value);
							System.out.println("qualityFeasibility_id:"+qualityFeasibility_id);
							
						}
						
					if (fieldName.equalsIgnoreCase("qualityFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("qualityFeasibilty:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("qualityremarks")) {
						remarks = fieldValue;
						System.out.println("qualityremarks:"+remarks);
						
						if(qualityFeasibility_id != 0){
							QualityFeasibilityBean qualityFeasibilityBean = new QualityFeasibilityBean(qualityFeasibility_id, subFeasibilty, remarks,projectMasterBean);
							boolean result3 = allUpdateDAO.qualFeasibilityUpdate(qualityFeasibilityBean);
						}else{
							QualityFeasibilityBean qualityFeasibilityBean = new QualityFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
							boolean result4 = allInsertDAO.QualityFeasiblityInsert(qualityFeasibilityBean);
						}
					}
					}
					
					
					if (fieldName.equalsIgnoreCase("cosFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("COSTFEASIBILITY")){
						
					if (fieldName.equalsIgnoreCase("costFeasibility_id")) {
						String value = fieldValue;
						costFeasibility_id = Integer.parseInt(value);
						System.out.println("costFeasibility_id:"+costFeasibility_id);
						
					}
						
					if (fieldName.equalsIgnoreCase("costFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("costFeasibility:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("costremarks")) {
						remarks = fieldValue;
						System.out.println("costremarks:"+remarks);
						
						if(costFeasibility_id != 0){
							CostFeasibilityBean costFeasibilityBean = new CostFeasibilityBean(costFeasibility_id, subFeasibilty, remarks, projectMasterBean);
							boolean result4 = allUpdateDAO.costFeasibilityUpdate(costFeasibilityBean);
						}else{
							CostFeasibilityBean costFeasibilitybean = new CostFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
							boolean result5 = allInsertDAO.CostFeasiblityInsert(costFeasibilitybean);
						}
					}
					}
					
					if (fieldName.equalsIgnoreCase("activeView")) {
						String value = fieldValue;
						request.setAttribute("activeView", value);
					}
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("project_id", project_id);
						request.getRequestDispatcher("projectView.jsp").forward(request, response);
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

