/*
Name : Bhoomi Patel
Action : Employee's Family Detail Insert  */

package com.hrms.pms.controller;

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

import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.MachineSystemReportBean;
import com.hrms.assetmanagement.dao.AllInsertAssetDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.FamilyDetailBean;
import com.hrms.pms.bean.FamilyRelationBean;
import com.hrms.pms.dao.AllInsertDAO;

/**
 * Servlet implementation class FamilyDetailInsertServlet
 */
public class FamilyDetailInsertServlet extends HttpServlet {
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
				
				int employee_master_id = 0;
				String name = "null";
				int relation = 0;
				String dob = "null";
				String occupation = "null";
				String contact_number = "null";
				String adhaar_number = "null";
				
				
				EmployeeBean employeeBean = new EmployeeBean();
				FamilyRelationBean familyRelationBean = new FamilyRelationBean();
				
				AllInsertDAO allInsertDAO = new AllInsertDAO();
				
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
								System.out.println("employee_master_id:"+employee_master_id);
								employeeBean.setEmployee_master_id(employee_master_id);
							}
							
							if (fieldName.equalsIgnoreCase("name")) {
								name = fieldValue;
								System.out.println("name:"+name);
							}
							
							if (fieldName.equalsIgnoreCase("relation")) {
								String value = fieldValue;
								relation = Integer.parseInt(value);
								familyRelationBean.setFamily_relation_id(relation);
								System.out.println("relation:"+relation);
							}
							
							if (fieldName.equalsIgnoreCase("dob")) {
								dob = fieldValue;
								
								
								try {
									  
									SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
									SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
									Date result = formater.parse(dob);
									dob = AppDateFormat.format(result);
									
									
								} catch (ParseException e1) {
									e1.printStackTrace();
								}	
								
								
								System.out.println("dob:"+dob);
								
							}
							
							if (fieldName.equalsIgnoreCase("occupation")) {
								occupation = fieldValue;
								System.out.println("occupation:"+occupation);
							}
							
							
							if (fieldName.equalsIgnoreCase("contact_number")) {
								contact_number = fieldValue;
								System.out.println("contact_number:"+contact_number);
							}
							
							if (fieldName.equalsIgnoreCase("adhaar_number")) {
								adhaar_number = fieldValue;
								System.out.println("adhaar_number:"+adhaar_number);
							}
							
							
							if (fieldName.equalsIgnoreCase("insert")) {
								if(!name.equalsIgnoreCase("")){
								FamilyDetailBean familyDetailBean = new FamilyDetailBean(name, relation, dob, occupation, contact_number, adhaar_number, employeeBean, familyRelationBean);
								boolean result = allInsertDAO.familyDetailInsert(familyDetailBean);    //Insert Method 
								System.out.println("Inserted....");
								}
							}
							
							
							if (fieldName.equalsIgnoreCase("redirect")) {
								request.getRequestDispatcher("employeeList.jsp").forward(request, response);
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

