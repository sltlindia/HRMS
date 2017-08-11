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
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;
public class AttachmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AttachmentUpdateServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession();
	EmployeeBean user = (EmployeeBean)session.getAttribute("user");
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
		 int id = user.getEmployee_master_id();
		 int selfservice_query_id = 0 ;
		 int selfservice_query_type_id = 0;
		 String file1 = null;
		 String date_of_submission = null;
		 String action = null;
		 
		 EmployeeBean employeeBean = new EmployeeBean();
		 employeeBean.setEmployee_master_id(id);
			
		
		SelfServiceTypeBean selfServiceTypeBean = new SelfServiceTypeBean();
		AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();		
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
					if (fieldName.equalsIgnoreCase("selfservice_query_id")) {
						String value = fieldValue;
						selfservice_query_id = Integer.parseInt(value);
					}
					if (fieldName.equalsIgnoreCase("selfservice_query_type_id")) {
						String value = fieldValue;
						selfservice_query_type_id = Integer.parseInt(value);
					}
					
					if (fieldName.equalsIgnoreCase("description")) {
						description = fieldValue;
						System.out.println("description:"+description);
					}
					if (fieldName.equalsIgnoreCase("file")) {
						file1 = fieldValue;
					}
					
					if (fieldName.equalsIgnoreCase("action")) {
						action = fieldValue;
					}
			
					if (fieldName.equalsIgnoreCase("redirect")) {
						
						if(action != null){
							request.getRequestDispatcher("selfServiceAllEmployee.jsp").forward(request, response);
						}else{
						request.getRequestDispatcher("selfServiceList.jsp").forward(request, response);
						}
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
							
							SelfServiceQuerybean selfServiceQuerybean = new SelfServiceQuerybean();
							boolean result = allUpdateSelfServiceDAO.selfserviceUpdate(selfservice_query_id, description, file1, date_of_submission, selfservice_query_type_id);
							
							selfservice_query_id = selfServiceQuerybean.getSelfservice_query_id();
							
							
						} else if(fieldName.equalsIgnoreCase("attachment")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());

								attachment = file.getName();
								
								System.out.println("photo uploaded");
								
								SelfServiceQuerybean selfServiceQuerybean = new SelfServiceQuerybean();
								boolean result = allUpdateSelfServiceDAO.selfserviceUpdate(selfservice_query_id, description, attachment, date_of_submission, selfservice_query_type_id);
								
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


