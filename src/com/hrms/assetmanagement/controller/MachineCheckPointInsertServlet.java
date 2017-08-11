package com.hrms.assetmanagement.controller;


import java.io.File;

/*Date : 08-06-2016
Name : Akash Ramani
Action : For Insert Data in machine_check_points_tbl*/


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

import com.hrms.assetmanagement.bean.AssetConfigurationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.bean.MachineCheckPointsBean;
import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.StockConfigurationBean;
import com.hrms.assetmanagement.bean.StockMasterBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.assetmanagement.dao.AllUpdateAssetDAO;
import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.dao.AllInsertExitFormalityDAO;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class MachineCheckPointInsertServlet
 */
public class MachineCheckPointInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
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
				
				MachineDetailBean machineDetailBean = new MachineDetailBean();
				
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
							
							
							
							if (fieldName.equalsIgnoreCase("status")) {
								status = fieldValue;
								System.out.println("status:"+status);
							}
							
							
							
							if (fieldName.equalsIgnoreCase("remark")) {
								remark = fieldValue;
								System.out.println("remark:"+remark);
							}
							
							
							if (fieldName.equalsIgnoreCase("insert")) {
								
								
								AllInsertAssetDAO allInsertAssetDAO = new AllInsertAssetDAO();
								if(!description.equalsIgnoreCase("")){
								MachineCheckPointsBean machineCheckPointsBean = new MachineCheckPointsBean(description, status, remark, machineDetailBean);
								boolean result = allInsertAssetDAO.machineCheckPointDetailInsert(machineCheckPointsBean);
								}		
								
							}
							
							
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
							
							
							
							if (fieldName.equalsIgnoreCase("redirect")) {
								
								AllUpdateAssetDAO allUpdateAssetDAO = new AllUpdateAssetDAO();
								boolean result = allUpdateAssetDAO.machinerDetailUpdate(checked_by_name, authorised_by_name, recieved_person, recieved_authorised_person, checked_by_date, authorised_by_date, recieved_person_date, recieved_authorised_person_date,machine_detail_id);
								
								System.out.println("redirect");
								request.setAttribute("machine_detail_id", machine_detail_id);
								request.getRequestDispatcher("machineSystemReport.jsp").forward(request, response);
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

		
		
