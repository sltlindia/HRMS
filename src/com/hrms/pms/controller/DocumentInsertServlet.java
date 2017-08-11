package com.hrms.pms.controller;

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
import com.hrms.pms.bean.ProjectDocumentBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.bean.SelfServiceTypeBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;

/**
 * Servlet implementation class DocumentInsertServlet
 */
public class DocumentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user =(EmployeeBean)session.getAttribute("user");
		if(user != null){
			
			
			String filePath= request.getServletContext().getInitParameter("project-document-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out = response.getWriter();
			
			 List<FileItem> items = null;
			 String fieldName = null;
			 String fieldValue = null;
			 String fileName = null;
			 File file = null;
			 String document_name = null;
			 String attachment ="-";
			 String creatorView = "";
			 int project_id = 0;
			 
				
			ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("project_id")) {
							String value = fieldValue;
							project_id = Integer.parseInt(value);
							System.out.println("project_id:"+project_id);
							projectMasterBean.setProject_master_id(project_id);
						}
						
						if (fieldName.equalsIgnoreCase("documentName")) {
							document_name = fieldValue;
							System.out.println("description:"+document_name);
						}
						
						if (fieldName.equalsIgnoreCase("creatorView")) {
							creatorView = fieldValue;
							System.out.println("creatorView:"+creatorView);
							request.setAttribute("creatorView", creatorView);
						}
				
						if (fieldName.equalsIgnoreCase("redirect")) {
							request.setAttribute("project_id", project_id);
							request.setAttribute("projectInput", "projectInput");
							request.getRequestDispatcher("redirection.jsp").forward(request, response);
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
								
								attachment = "-";
								ProjectDocumentBean projectDocumentBean = new ProjectDocumentBean(document_name, attachment, projectMasterBean);
								boolean result = allInsertDAO.projectDocumentInsert(projectDocumentBean);
								
								
								
							} else if(fieldName.equalsIgnoreCase("attachment")){
								System.out.println("MIME : "+context.getMimeType(fileName));
									item.write(file);
									System.out.println("===> "+file.getName());

									attachment = file.getName();
									
									
									ProjectDocumentBean projectDocumentBean = new ProjectDocumentBean(document_name, attachment, projectMasterBean);
									boolean result = allInsertDAO.projectDocumentInsert(projectDocumentBean);
									
									
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



