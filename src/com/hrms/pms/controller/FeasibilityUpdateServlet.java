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

import com.hrms.pms.dao.AllUpdateDAO;
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
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ProjectStatusBean;
import com.hrms.pms.bean.QualityFeasibilityBean;
import com.hrms.pms.dao.AllInsertDAO;

/**
 * Servlet implementation class FeasibilityUpdateServlet
 */
public class FeasibilityUpdateServlet extends HttpServlet {
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
		int project_id = 0;
		int engFeasibility_id = 0;
		String engFeasibility_name = null;
		String engFeasibility_remarks = null;
		int fixFeasibility_id = 0;
		String fixFeasibility_name = null;
		String fixFeasibility_remarks = null;
		int manFeasibility_id = 0;
		String manFeasibility_name = null;
		String manFeasibility_remarks = null;
		int qualityFeasibility_id = 0;
		String qualityFeasibility_name = null;
		String qualityFeasibility_remarks = null;
		int costFeasibility_id = 0;
		String costFeasibility_name = null;
		String costFeasibility_remarks = null;
	
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
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
					
					if (fieldName.equalsIgnoreCase("engFeasibility_id")) {
						String value = fieldValue;
						engFeasibility_id = Integer.parseInt(value);
						System.out.println("engFeasibility_id:"+engFeasibility_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("engFeasibility_name")) {
						engFeasibility_name = fieldValue;
						System.out.println("engFeasibility_name:"+engFeasibility_name);
						
					}
					
					if (fieldName.equalsIgnoreCase("engFeasibility_remarks")) {
						engFeasibility_remarks = fieldValue;
						System.out.println("engFeasibility_remarks:"+engFeasibility_remarks);
						
						EngineeringFeasibilityBean engineeringFeasibilityBean = new EngineeringFeasibilityBean(engFeasibility_id, engFeasibility_name, engFeasibility_remarks, projectMasterBean);
						boolean result = allUpdateDAO.engFeasibilityUpdate(engineeringFeasibilityBean);
					}
					
					if (fieldName.equalsIgnoreCase("fixFeasibility_id")) {
						String value = fieldValue;
						fixFeasibility_id = Integer.parseInt(value);
						System.out.println("fixFeasibility_id:"+fixFeasibility_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("fixFeasibility_name")) {
						fixFeasibility_name = fieldValue;
						System.out.println("fixFeasibility_name:"+fixFeasibility_name);
						
					}
					
					if (fieldName.equalsIgnoreCase("fixFeasibility_remarks")) {
						fixFeasibility_remarks = fieldValue;
						System.out.println("fixFeasibility_remarks:"+fixFeasibility_remarks);
						
						FixtureFeasibiltyBean fixtureFeasibiltyBean = new FixtureFeasibiltyBean(fixFeasibility_id, fixFeasibility_name, fixFeasibility_remarks, projectMasterBean);
						boolean result1 = allUpdateDAO.fixFeasibilityUpdate(fixtureFeasibiltyBean);
					}
					
					
					if (fieldName.equalsIgnoreCase("manFeasibility_id")) {
						String value = fieldValue;
						manFeasibility_id = Integer.parseInt(value);
						System.out.println("manFeasibility_id:"+manFeasibility_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("manFeasibility_name")) {
						manFeasibility_name = fieldValue;
						System.out.println("manFeasibility_name:"+manFeasibility_name);
					}
					
					if (fieldName.equalsIgnoreCase("manFeasibility_remarks")) {
						manFeasibility_remarks = fieldValue;
						System.out.println("manFeasibility_remarks:"+manFeasibility_remarks);
						
						ManufacturingFeasibilityBean manufacturingFeasibilityBean = new ManufacturingFeasibilityBean(manFeasibility_id, manFeasibility_name, manFeasibility_remarks, projectMasterBean);
						boolean result2 = allUpdateDAO.manFeasibilityUpdate(manufacturingFeasibilityBean);
					}
					
					if (fieldName.equalsIgnoreCase("qualityFeasibility_id")) {
						String value = fieldValue;
						qualityFeasibility_id = Integer.parseInt(value);
						System.out.println("qualityFeasibility_id:"+qualityFeasibility_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("qualityFeasibility_name")) {
						qualityFeasibility_name = fieldValue;
						System.out.println("qualityFeasibility_name:"+qualityFeasibility_name);
						
					}
					
					if (fieldName.equalsIgnoreCase("qualityFeasibility_remarks")) {
						qualityFeasibility_remarks = fieldValue;
						System.out.println("qualityFeasibility_remarks:"+qualityFeasibility_remarks);
						
						QualityFeasibilityBean qualityFeasibilityBean = new QualityFeasibilityBean(qualityFeasibility_id, qualityFeasibility_name, qualityFeasibility_remarks,projectMasterBean);
						boolean result3 = allUpdateDAO.qualFeasibilityUpdate(qualityFeasibilityBean);
					}
					
					if (fieldName.equalsIgnoreCase("costFeasibility_id")) {
						String value = fieldValue;
						costFeasibility_id = Integer.parseInt(value);
						System.out.println("costFeasibility_id:"+costFeasibility_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("costFeasibility_name")) {
						costFeasibility_name = fieldValue;
						System.out.println("costFeasibility_name:"+costFeasibility_name);
						
					}
					
					if (fieldName.equalsIgnoreCase("costFeasibility_remarks")) {
						costFeasibility_remarks = fieldValue;
						System.out.println("costFeasibility_remarks:"+costFeasibility_remarks);
						
						CostFeasibilityBean costFeasibilityBean = new CostFeasibilityBean(costFeasibility_id, costFeasibility_name, costFeasibility_remarks, projectMasterBean);
						boolean result4 = allUpdateDAO.costFeasibilityUpdate(costFeasibilityBean);
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

