package com.hrms.kaizen.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean;
import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class KaizenAfterUploadAttachmentServlet
 */
public class KaizenAfterUploadAttachmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String filePath= request.getServletContext().getInitParameter("kaizen-upload-after");
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
				 int selfservice_query_id = 0 ;
				 int selfservice_query_type_id = 0;
				 String file1 = null;
				 String date_of_submission = null;
				 String action = null;
				 String location_path = null;
				
				 int kaizen_id = 0;
				 KaizenBean kaizenBean = new KaizenBean();
				
				try {
					items = upload.parseRequest(request);// Parse Request
					for (int i = 0; i < items.size(); i++) {
						FileItem item = items.get(i);
					
						
						if (item.isFormField()) {
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							if (fieldName.equalsIgnoreCase("kaizen_id")) {
								String value = fieldValue;
								kaizen_id = Integer.parseInt(value);
								System.out.println("kaizen_id:"+kaizen_id);
								kaizenBean.setKaizen_id(kaizen_id);
							}
						}else{
							
							
							fieldName = item.getFieldName();
							fieldValue = item.getString();
							
							
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
									
								} else{
									System.out.println("MIME : "+context.getMimeType(fileName));
									item.write(file);
									System.out.println("===> "+file.getName());

									attachment = file.getName();
									
									System.out.println("photo uploaded");
										
										
										AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
										KaizenAfterUploadAttachmentBean  kaizenAfterUploadAttachmentBean = new KaizenAfterUploadAttachmentBean(attachment,kaizenBean);
										boolean result = allKaizenInsertDAO.kaizenPhotoUploadAfterInsert(kaizenAfterUploadAttachmentBean);
										
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
		
	}
	
	
	
	}

}
