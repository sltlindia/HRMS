package com.hrms.kaizen.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import com.hrms.kaizen.bean.KaizenMemberBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class KaizenMemberInsertServlet
 */
public class KaizenMemberInsertServlet extends HttpServlet {
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
				int kaizen_id = 0;
				String name = null;
				String employee_name = "null";
				
				
				AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
				KaizenBean kaizenBean = new KaizenBean();
				EmployeeBean employeeBean = new EmployeeBean();
				
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
								kaizenBean.setKaizen_id(kaizen_id);
							}
							
							if (fieldName.equalsIgnoreCase("employee_name")) {
								name = fieldValue;
								System.out.println("employee_name:"+name);
								
								String[] split = name.split(",");
								int emp_code = Integer.parseInt(split[0]);
								String empName = split[1];
								int other_manager_id = 0;
								String middleName = null;
										
								String[] splitName = empName.split(" ");
								String firstName = splitName[0];
								String lastName = splitName[1];
								
								LoginDAO loginDAO = new LoginDAO();
								EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);
								employeeBean.setEmployee_master_id(employeeBean1.getEmployee_master_id());
								
								KaizenMemberBean kaizenMemberBean = new KaizenMemberBean(employeeBean, kaizenBean);
								boolean result = allKaizenInsertDAO.kaizenMemberInsert(kaizenMemberBean);
								
							}
							
							
							if (fieldName.equalsIgnoreCase("redirection")) {
								
								request.setAttribute("kaizen_id", kaizen_id);
								request.setAttribute("firstInsert", "firstInsert");
								request.getRequestDispatcher("kaizenPhotoUpload.jsp").forward(request, response);
								
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
