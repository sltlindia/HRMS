package com.hrms.kaizen.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class KaizenUpdateServlet
 */
public class KaizenUpdateServlet extends HttpServlet {
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
				String kaizen_name = "null";
				String description = null;
				String implementation_cost = null;
				String time_saving = "null";
				String money_saving = "null";
				String effort_saving = "null";
				String safety_saving = "null";
				String productivity_saving = "null";
				String existing_problem = "null";
				String safety_features = "null";
				String status = "pending";
				String completion_status = "";
				String before_desc = "-";
				String after_desc = "-";
				String reason = "-";
				String affecting_department = null;
				int memberCount = 0;
				int kaizen_id = 0;
				String date = null;
				
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				
				int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
				
				
				
				EmployeeBean employeeBean = new EmployeeBean();
				
				
				AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
				KaizenBean kaizenBean = new KaizenBean();
				DepartmentBean departmentBean = new DepartmentBean();
				
						
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
							if (fieldName.equalsIgnoreCase("kaizen_id")) {
								kaizen_id = Integer.parseInt(fieldValue);
								System.out.println("kaizen_id:"+kaizen_id);
							}
							
							if (fieldName.equalsIgnoreCase("kaizen_name")) {
								kaizen_name = fieldValue;
								System.out.println("kaizen_name:"+kaizen_name);
							}
							
							if (fieldName.equalsIgnoreCase("status")) {
								status = fieldValue;
								System.out.println("status:"+status);
							}
							
							if (fieldName.equalsIgnoreCase("before_desc")) {
								before_desc = fieldValue;
								System.out.println("before_desc:"+before_desc);
							}
							
							if (fieldName.equalsIgnoreCase("after_desc")) {
								after_desc = fieldValue;
								System.out.println("after_desc:"+after_desc);
							}
							
							if (fieldName.equalsIgnoreCase("reason")) {
								reason = fieldValue;
								System.out.println("reason:"+reason);
							}
							
							if (fieldName.equalsIgnoreCase("description")) {
								description = fieldValue;
								System.out.println("description:"+description);
							}
							
							if (fieldName.equalsIgnoreCase("existing_problem")) {
								existing_problem = fieldValue;
								System.out.println("existing_problem:"+existing_problem);
							}
							
							if (fieldName.equalsIgnoreCase("implementation_cost")) {
								implementation_cost = fieldValue;
								System.out.println("implementation_cost:"+implementation_cost);
							}
							
							if (fieldName.equalsIgnoreCase("safety_features")) {
								safety_features = fieldValue;
								System.out.println("safety_features:"+safety_features);
							}
							
							if (fieldName.equalsIgnoreCase("time_saving")) {
								time_saving = fieldValue;
								System.out.println("time_saving:"+time_saving);
							}
							
							
							if (fieldName.equalsIgnoreCase("money_saving")) {
								money_saving = fieldValue;
								System.out.println("money_saving:"+money_saving);
							}

							
							if (fieldName.equalsIgnoreCase("effort_saving")) {
								effort_saving = fieldValue;
								System.out.println("effort_saving:"+effort_saving);
							}
							
							if (fieldName.equalsIgnoreCase("safety_saving")) {
								safety_saving = fieldValue;
								System.out.println("safety_saving:"+safety_saving);
							}
							
							if (fieldName.equalsIgnoreCase("productivity_saving")) {
								productivity_saving = fieldValue;
								System.out.println("productivity_saving:"+productivity_saving);
							}
							
							if (fieldName.equalsIgnoreCase("memberCount")) {
								memberCount = Integer.parseInt(fieldValue);
								System.out.println("memberCount:"+memberCount);
							}
							
							
							if (fieldName.equalsIgnoreCase("date")) {
								date = fieldValue;
								System.out.println("date:"+date);
							}
							
							
							if (fieldName.equalsIgnoreCase("completion_status")) {
								completion_status = fieldValue;
								System.out.println("completion_status:"+completion_status);
							}
							
							if (fieldName.equalsIgnoreCase("update")) 
							{
								
								EmployeeBean bean = new EmployeeBean();
								bean.setEmployee_master_id(user.getEmployee_master_id());
								
								kaizenBean = new KaizenBean(kaizen_id, kaizen_name, description, existing_problem, safety_features, implementation_cost, under_manager_id, status, date,bean,before_desc,after_desc,reason, time_saving,money_saving, effort_saving,safety_saving,productivity_saving,completion_status);
								boolean result = allKaizenInsertDAO.kaizenInsert(kaizenBean);
							}	
							
							
							
							
							if (fieldName.equalsIgnoreCase("redirection")) {
								request.setAttribute("kaizen_id", kaizen_id);
								request.getRequestDispatcher("kaizenView.jsp").forward(request, response);
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
