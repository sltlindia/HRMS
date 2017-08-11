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

import com.hrms.pms.dao.AllListDAO;
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

/**
 * Servlet implementation class DesignInputsInsertServlet
 */
public class ProjectInsertServlet extends HttpServlet {
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

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					
					
					if (fieldName.equalsIgnoreCase("project_code")) {
						projectCode = fieldValue;
						System.out.println("project_code:"+projectCode);
						
					}
					
					if (fieldName.equalsIgnoreCase("keyword")) {
						String value = fieldValue;
						keyword_id = Integer.parseInt(value);
						System.out.println("project_code:"+projectCode);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("project_name")) {
						
						if(keyword_id == 1){keyword = "Cutting";}else
							if(keyword_id == 2){keyword = "Marking";}else
								if(keyword_id == 3){keyword = "Software";}else
									if(keyword_id == 4){keyword = "Electronics";}else
										if(keyword_id == 5){keyword = "Welding";}else
											if(keyword_id == 6){keyword = "Miscellaneous";}
						
						projectName = keyword+"-"+fieldValue;
						System.out.println("projectName:"+projectName);
					}
					
					
					if (fieldName.equalsIgnoreCase("client_name")) {
						client_name = fieldValue;
						System.out.println("client_name:"+client_name);
						
						ClientMasterBean clb = allListDAO.getClientInfoById(client_name);
						if(clb != null){
							client_id = clb.getClient_master_id();
						}else{
							ClientMasterBean clientMasterBean1 = new ClientMasterBean(client_name, client_type);
							boolean result = allInsertDAO.clientInsert(clientMasterBean1);
							client_id = clientMasterBean1.getClient_master_id();
						}
						clientMasterBean.setClient_master_id(client_id);
					}
					
					if (fieldName.equalsIgnoreCase("approver_id")) {
						approver_name = fieldValue;
						System.out.println("approver_name:"+approver_name);
						
						String[] splitName = approver_name.split(",");
						approver_id = Integer.parseInt(splitName[1]);
						
						ProjectMasterBean projectMasterBean1 = new ProjectMasterBean(projectName, projectCode, project_desc, plannedStartDate , plannedEndDate, hold_date, hold_reason, resume_date, project_cost, machine_cost, resources, duration, actual_end, actual_start, misc_Project, billable, billing_type, billingCost, billing_frequency, projectStatusBean, managerBean, priorityBean, clientMasterBean, currencyBean,deliverable,status,approver_id);
						boolean result = allInsertDAO.projectInsert(projectMasterBean1);
						project_id = projectMasterBean1.getProject_master_id();
						System.out.println("project_id:"+project_id);
						projectMasterBean.setProject_master_id(project_id);
						
						
					}
					
					if (fieldName.equalsIgnoreCase("duration")) {
						duration = fieldValue;
						System.out.println("duration:"+duration);
						
					}
					
					if (fieldName.equalsIgnoreCase("resources")) {
						resources = fieldValue;
						System.out.println("resources:"+resources);
					}
					
					if (fieldName.equalsIgnoreCase("plannedStartDate")) {
						plannedStartDate = fieldValue;
						System.out.println("plannedStartDate:"+plannedStartDate);
						
					}
					
					if (fieldName.equalsIgnoreCase("plannedEndDate")) {
						plannedEndDate = fieldValue;
						System.out.println("plannedEndDate:"+plannedEndDate);
						
					}
					
					if (fieldName.equalsIgnoreCase("project_category")) {
						project_category = fieldValue;
						System.out.println("project_category:"+project_category);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("project_desc")) {
						project_desc = fieldValue;
						System.out.println("project_desc:"+project_desc);
						
					}
					
					
					
					if (fieldName.equalsIgnoreCase("deliverable")) {
						deliverable = fieldValue;
						System.out.println("deliverable:"+deliverable);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("project_cost")) {
						String value = fieldValue;
						project_cost = Double.parseDouble(value);
						System.out.println("project_cost:"+project_cost);
						
					}
					
					if (fieldName.equalsIgnoreCase("machine_cost")) {
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
					
					if (fieldName.equalsIgnoreCase("rdbBill")) {
						billable = fieldValue;
						System.out.println("billable:"+billable);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("rdbBillType")) {
						billing_type = fieldValue;
						System.out.println("billing_type:"+billing_type);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("currency_id")) {
						String value = fieldValue;
						currency_id = Integer.parseInt(value);
						System.out.println("currency_id:"+currency_id);
						
						currencyBean.setCurrency_id(currency_id);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("engFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("ENGINEERINGFEASIBILITY")){
					if (fieldName.equalsIgnoreCase("engineeringFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("engineeringFeasibility:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("engineeringremarks")) {
						remarks = fieldValue;
						System.out.println("engineeringremarks:"+remarks);
						
						EngineeringFeasibilityBean engineeringFeasibilityBean = new EngineeringFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
						boolean result1 = allInsertDAO.EngineeringFeasibiltyInsert(engineeringFeasibilityBean);
					}
					
					}
					
					if (fieldName.equalsIgnoreCase("fixFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("FIXTUREFEASIBILITY")){
					if (fieldName.equalsIgnoreCase("fixtureFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("fixtureFeasibility:"+subFeasibilty);
						
					}
					
					if (fieldName.equalsIgnoreCase("fixtureremarks")) {
						remarks = fieldValue;
						System.out.println("fixtureremarks:"+remarks);
						
						FixtureFeasibiltyBean fixtureFeasibiltyBean = new FixtureFeasibiltyBean(subFeasibilty, remarks, projectMasterBean);
						boolean result2 = allInsertDAO.FixtureFeasiblityInsert(fixtureFeasibiltyBean);
					}
					}
					
					if (fieldName.equalsIgnoreCase("manFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("MANUFACTURINGFEASIBILITY")){
					if (fieldName.equalsIgnoreCase("manufacturingFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("manufacturingFeasibility:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("manufacturingremarks")) {
						remarks = fieldValue;
						System.out.println("manufacturingremarks:"+remarks);
						
						ManufacturingFeasibilityBean manufacturingFeasibilityBean = new ManufacturingFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
						boolean result3 = allInsertDAO.ManufactureFeasiblityInsert(manufacturingFeasibilityBean);
					}
					}
					
					if (fieldName.equalsIgnoreCase("qualFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("QUALITYFEASIBILITY")){
					if (fieldName.equalsIgnoreCase("qualityFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("qualityFeasibilty:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("qualityremarks")) {
						remarks = fieldValue;
						System.out.println("qualityremarks:"+remarks);
						
						QualityFeasibilityBean qualityFeasibilityBean = new QualityFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
						boolean result4 = allInsertDAO.QualityFeasiblityInsert(qualityFeasibilityBean);
					}
					}
					
					
					if (fieldName.equalsIgnoreCase("cosFeasibilty")) {
						feasibilty = fieldValue;
						System.out.println("feasibilty:"+feasibilty);
					}
					
					if(feasibilty.toUpperCase().equalsIgnoreCase("COSTFEASIBILITY")){
					if (fieldName.equalsIgnoreCase("costFeasibility")) {
						subFeasibilty = fieldValue;
						System.out.println("costFeasibility:"+subFeasibilty);
					}
					
					if (fieldName.equalsIgnoreCase("costremarks")) {
						remarks = fieldValue;
						System.out.println("costremarks:"+remarks);
						
						CostFeasibilityBean costFeasibilitybean = new CostFeasibilityBean(subFeasibilty, remarks, projectMasterBean);
						boolean result5 = allInsertDAO.CostFeasiblityInsert(costFeasibilitybean);
					}
					}
					
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.setAttribute("project_id", project_id);
						request.getRequestDispatcher("designInputs.jsp").forward(request, response);
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

