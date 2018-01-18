package com.hrms.grievancemanagement.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.hrms.grievancemanagement.bean.GrievanceEmailBean;
import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean;
import com.hrms.grievancemanagement.dao.AllInsertGrievanceDAO;
import com.hrms.grievancemanagement.dao.AllUpdateGrievanceDAO;
import com.hrms.pms.bean.EmployeeBean;

public class QueryReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		String filePath = 
	             getServletContext().getInitParameter("grievance-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		String status = "replied";
		String date_of_resolve = "null";
		String reply = null;
		String reply_attchment = null;
		String query = null;
		int grievance_id = 0;
		int id = user.getEmployee_master_id();
		String name = user.getFirstname()+" "+user.getLastname();
		
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(id);
		
		GrievanceQueryTypeBean grievanceQueryTypeBean = new GrievanceQueryTypeBean();
		
		AllUpdateGrievanceDAO allUpdateGrievanceDAO = new AllUpdateGrievanceDAO();
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		date_of_resolve = dateFormat.format(date);

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("query_id")) {
						String value = fieldValue;
						grievance_id = Integer.parseInt(value);
						System.out.println("grievance_id:"+grievance_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("reply")) {
						reply = fieldValue;
						System.out.println("reply:"+reply);
					}
					
					if (fieldName.equalsIgnoreCase("query")) {
						query = fieldValue;
						System.out.println("query:"+query);
					}
					
					if (fieldName.equalsIgnoreCase("email")) {
						String email = fieldValue;
						String reply1 = reply;
						String name1 = fileName;
						String query1 = query;
						new Thread(new Runnable() {
						    @Override
						    public void run() {
						    	String to = email;
						    	String sub = "HR Reply For your Query";
						    	String attachment = name1;
						    	Mailer.send1(to, sub, reply1, query1, attachment);
						    	
						    }
						}).start();
						}	
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.getRequestDispatcher("allGrievanceHrList.jsp").forward(request, response);
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
						
						reply_attchment ="null";
						boolean result = allUpdateGrievanceDAO.grievanceQueryUpdate(grievance_id, reply, date_of_resolve, reply_attchment,status);
						
						
						
					} else if(fieldName.equalsIgnoreCase("attachment")){
						System.out.println("MIME : "+context.getMimeType(fileName));
							item.write(file);
							System.out.println("===> "+file.getName());

							reply_attchment = file.getName();
							
							System.out.println("photo uploaded");
							
							boolean result = allUpdateGrievanceDAO.grievanceQueryUpdate(grievance_id, reply, date_of_resolve, reply_attchment,status);
							
							
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

