package com.hrms.pms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.dao.LoginDAO;


public class ProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		String authority = user.getRoleBean().getRole_authority();
		String filePath = 
	             getServletContext().getInitParameter("profile-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		String profile = null;
		int id = 0;
		int manager_id = user.getManagerBean().getManager_id();
		int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
		
		
		
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		LoginDAO loginDAO = new LoginDAO();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("id")) {
						String value = fieldValue;
						id = Integer.parseInt(value);
						System.out.println("emp_master_id:"+id);
					}
					
				}else {
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
					System.out.println("File Name : "+fileName);
					
					fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1,
							fileName.length());
					System.out.println("File Name 1 : "+fileName);
					
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\")+("WebContent\\upload");
					System.out.println("appPath : "+appPath);
					
					file = new File(filePath + File.separator
							+ fileName);
					System.out.println("filePath:"+file);

					try {

						if (fileName.isEmpty()) {
							
							if(manager_id != 99){
								if(manager_id == 1 || manager_id == 2 || manager_id == 3){
								 request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
								}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
								 request.getRequestDispatcher("hrHome.jsp").forward(request, response);
								}else{
								 request.getRequestDispatcher("managerHome.jsp").forward(request, response);
								}	
								}else{ 
								 request.getRequestDispatcher("empHome.jsp").forward(request, response);
								} 	
							
							
							
						} else if(fieldName.equalsIgnoreCase("profile_pic")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());
								profile = file.getName();
								System.out.println("photo uploaded");
								
								boolean result = allUpdateDAO.employeeProfileUpdate(id, profile);
								request.setAttribute("success", "Profile photo successfully updated please login again...");
								
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
													}
												}	
								
								
						}
					} catch (Exception e) {
						e.printStackTrace();
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

