package com.hrms.selfservice.controller;

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

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.bean.SelfServiceTypeBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;


public class SelfServiceQueryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession();
	EmployeeBean user =(EmployeeBean)session.getAttribute("user");
	if(user != null){
		
		
		String filePath= request.getServletContext().getInitParameter("SelfService-upload");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		 List<FileItem> items = null;
		 String fieldName = null;
		 String fieldValue = null;
		 String fileName = null;
		 File file = null;
		 String description = null;
		 String attachment ="-";
		 int selfservice_query_id = 0;
		 int id = user.getEmployee_master_id();
		 int selfservice_query_type_id = 0;
		 String date_of_submission = null;
		 
		 EmployeeBean employeeBean = new EmployeeBean();
		 employeeBean.setEmployee_master_id(id);
			
		
		SelfServiceTypeBean selfServiceTypeBean = new SelfServiceTypeBean();
		AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		date_of_submission = dateFormat.format(date);

		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("selfservice_query_type_id")) {
						String value = fieldValue;
						selfservice_query_type_id = Integer.parseInt(value);
						System.out.println("selfservice_query_type_id:"+selfservice_query_type_id);
						selfServiceTypeBean.setSelfservice_type_id(selfservice_query_type_id);
					}
					
					if (fieldName.equalsIgnoreCase("description")) {
						description = fieldValue;
						System.out.println("description:"+description);
					}
			
					if (fieldName.equalsIgnoreCase("redirect")) {
						request.getRequestDispatcher("selfServiceList.jsp").forward(request, response);
					}
					
					
					if (fieldName.equalsIgnoreCase("attachment")) {
						String value = fieldValue;
						System.out.println("file:"+value);
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
							
							SelfServiceQuerybean selfServiceQuerybean = new SelfServiceQuerybean(description, attachment, date_of_submission, employeeBean, selfServiceTypeBean);
							boolean result = allInsertSelfServiceDAO.selfserviceInsert(selfServiceQuerybean);
							
							selfservice_query_id = selfServiceQuerybean.getSelfservice_query_id();
							
							
						} else if(!fileName.isEmpty()){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());

								attachment = file.getName();
								
								System.out.println("photo uploaded");
								
								SelfServiceQuerybean selfServiceQuerybean = new SelfServiceQuerybean(description, attachment, date_of_submission, employeeBean, selfServiceTypeBean);
								boolean result = allInsertSelfServiceDAO.selfserviceInsert(selfServiceQuerybean);
								
								selfservice_query_id = selfServiceQuerybean.getSelfservice_query_id();
								
								
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


