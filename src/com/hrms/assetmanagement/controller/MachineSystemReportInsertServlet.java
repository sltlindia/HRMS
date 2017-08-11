/*
 * Date : 08-06-2016
 * Name : Bhoomi Patel;
Action : Inseret For System Report*/

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

import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.MachineSystemReportBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.pms.bean.EmployeeBean;

public class MachineSystemReportInsertServlet extends HttpServlet {
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
				
				int machine_detail_id = 0;
				String description = "null";
				String company = "null";
				String type = "null";
				String capacity = "null";
				String sr_no = "null";
				
				MachineDetailBean machineDetailBean = new MachineDetailBean();
				MachineSystemReportBean machineSystemReportBean = null;
				AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
				
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
							
							if (fieldName.equalsIgnoreCase("description")) {
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
							
							if (fieldName.equalsIgnoreCase("insert")) {
								
								if(!description.equalsIgnoreCase("")){
								machineSystemReportBean = new MachineSystemReportBean(description, company, type, capacity, sr_no, machineDetailBean);
								allInsertAssetDAO.machineSystemReportInsert(machineSystemReportBean);
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
