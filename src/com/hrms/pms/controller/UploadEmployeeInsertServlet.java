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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadEmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UploadEmployeeInsertServlet() {
    	
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = 
	             getServletContext().getInitParameter("csv-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		

			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String uploadAttachment = null;
			File file = null;
			String fileName = null;

			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						
					
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
					String appPath = context.getRealPath("\\")+("\\WebContent\\upload\\CriteriaAttachment");
					System.out.println("appPath : "+appPath);
					
					
					
					
					file = new File(filePath + File.separator
							+ fileName);
					System.out.println("filePath:"+file);

					try {

						if (fileName.isEmpty()) {
							
						} else if(fieldName.equalsIgnoreCase("uploadAttachment")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());

								uploadAttachment = file.getName();
								
								System.out.println("photo uploaded");
								request.setAttribute("uploadAttachment", file.getName());
								
								request.getRequestDispatcher("employeeCSVUpload").forward(request, response);
							}
						}
							
						
					catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
	}

	
	}

