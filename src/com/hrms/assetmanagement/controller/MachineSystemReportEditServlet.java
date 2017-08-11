package com.hrms.assetmanagement.controller;

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

import com.hrms.assetmanagement.bean.MachineCheckPointsBean;
import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.MachineSystemReportBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class MachineSystemReportEditServlet
 */
public class MachineSystemReportEditServlet extends HttpServlet {
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
				String fileName = null;
				File file = null;
				
				
				
				
				
				
				int machine_detail_id = 0;
				int machine_check_points_id = 0;
				int machine_system_report_id = 0;
				String description = null;
				String status = null;
				String remark = null;
				int checked_by_name = 0;
				int authorised_by_name = 0;
				String checked_by_date = null;
				String authorised_by_date = null;
				int recieved_person = 0;
				int recieved_authorised_person = 0;
				String recieved_person_date = null;
				String recieved_authorised_person_date = null;
				
				String company = null;
				String type = null;
				String capacity = null;
				String sr_no = null;
				
				
				AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
				MachineDetailBean machineDetailBean = new MachineDetailBean();
				MachineSystemReportBean machineSystemReportBean = new MachineSystemReportBean();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
							
							if (fieldName.equalsIgnoreCase("machine_detail_id")) {
								String value = fieldValue;
								machine_detail_id = Integer.parseInt(value);
								System.out.println("machine_detail_id:"+machine_detail_id);
								machineDetailBean.setMachine_detail_id(machine_detail_id);
							}
							
							
							// update in machine_check_points_tbl
							
							if (fieldName.equalsIgnoreCase("machine_check_points_id")) {
								String value = fieldValue;
								machine_check_points_id = Integer.parseInt(value);
								System.out.println("machine_check_points_id:"+machine_check_points_id);
							}
							
							if (fieldName.equalsIgnoreCase("description")) {
								description = fieldValue;
								System.out.println("description:"+description);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("status")) {
								status = fieldValue;
								System.out.println("status:"+status);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("remark")) {
								remark = fieldValue;
								System.out.println("remark:"+remark);
							}
							
							
							if (fieldName.equalsIgnoreCase("machine_check_point_update")) {
								
								
								if(!description.equalsIgnoreCase("")){
									MachineCheckPointsBean machineCheckPointsBean = new MachineCheckPointsBean(machine_check_points_id, description, status, remark, machineDetailBean);
									boolean result = allUpdateAssetDAO.updateCheckPoints(machineCheckPointsBean);
								
								}		
								
							}
							
							
							
							//update in machine_detail_tbl
							
							
							if (fieldName.equalsIgnoreCase("checked_by_name")) {
								String value = fieldValue;
								checked_by_name = Integer.parseInt(value);
								System.out.println("checked_by_name:"+checked_by_name);
							}

							
							
							if (fieldName.equalsIgnoreCase("authorised_by_name")) {
								String value = fieldValue;
								authorised_by_name = Integer.parseInt(value);
								System.out.println("authorised_by_name:"+authorised_by_name);
							}
							
							
							if (fieldName.equalsIgnoreCase("checked_by_date")) {
								checked_by_date = fieldValue;
								System.out.println("checked_by_date:"+checked_by_date);
							}
							
							
							if (fieldName.equalsIgnoreCase("authorised_by_date")) {
								authorised_by_date = fieldValue;
								System.out.println("authorised_by_date:"+authorised_by_date);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("recieved_person")) {
								String value = fieldValue;
								recieved_person = Integer.parseInt(value);
								System.out.println("recieved_person:"+recieved_person);
								machineDetailBean.setMachine_detail_id(machine_detail_id);
							}
							
							
							if (fieldName.equalsIgnoreCase("recieved_authorised_person")) {
								String value = fieldValue;
								recieved_authorised_person = Integer.parseInt(value);
								System.out.println("recieved_authorised_person:"+recieved_authorised_person);
							}

							if (fieldName.equalsIgnoreCase("recieved_person_date")) {
								recieved_person_date = fieldValue;
								System.out.println("recieved_person_date:"+recieved_person_date);
							}
							
							if (fieldName.equalsIgnoreCase("recieved_authorised_person_date")) {
								recieved_authorised_person_date = fieldValue;
								System.out.println("recieved_authorised_person_date:"+recieved_authorised_person_date);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("update")) {
								boolean result = allUpdateAssetDAO.machinerDetailUpdate(checked_by_name, authorised_by_name, recieved_person, recieved_authorised_person, checked_by_date, authorised_by_date, recieved_person_date, recieved_authorised_person_date,machine_detail_id);
								System.out.println("update");
							}
							
							
							// Update in machine_system_report_tbl
							
							
							if (fieldName.equalsIgnoreCase("machine_system_report_id")) {
								String value = fieldValue;
								machine_system_report_id = Integer.parseInt(value);
								System.out.println("machine_system_report_id:"+machine_system_report_id);
							}
							
							if (fieldName.equalsIgnoreCase("system_report_description")) {
								description = fieldValue;
								System.out.println("description:"+description);
							}
							
							
							if (fieldName.equalsIgnoreCase("company")) {
								company = fieldValue;
								System.out.println("company:"+company);
							}
							
							if (fieldName.equalsIgnoreCase("type")) {
								type = fieldValue;
								System.out.println("type:"+type);
							}
							
							if (fieldName.equalsIgnoreCase("capacity")) {
								capacity = fieldValue;
								System.out.println("capacity:"+capacity);
							}
							
							
							if (fieldName.equalsIgnoreCase("sr_no")) {
								sr_no = fieldValue;
								System.out.println("sr_no:"+sr_no);
							}
							
							if (fieldName.equalsIgnoreCase("system_report_update")) {
								
								if(!description.equalsIgnoreCase("")){
									machineSystemReportBean = new MachineSystemReportBean(machine_system_report_id, description, company, type, capacity, sr_no, machineDetailBean);
									boolean result1 = allUpdateAssetDAO.updateMachineSystemReportDetail(machineSystemReportBean);
									
								}
								
							}
							
							if (fieldName.equalsIgnoreCase("redirect")) {

								request.getRequestDispatcher("machineDetailList.jsp").forward(request, response);
							
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
