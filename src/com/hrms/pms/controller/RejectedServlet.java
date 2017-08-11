package com.hrms.pms.controller;

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

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllUpdateDAO;

public class RejectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			File file = null;
			String fileName = null;
			int review_softskill_id=0;
			int review_criteria_id=0;
			int review_id=0;
			int technical_id=0;
			int manager_techgrade_id = 0;
			String techgrade_id =null;
			String softgrade_id = null;
			String manager_techcomment=null;
			int softskill_id=0;
			int manager_softgrade_id = 0;
			String manager_softcomment=null;
			int tech_per=0;
			int soft_per=0;
			String technicalProof=null;
			String softskillProof=null;
			String remarks = null;
			


			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						
						if (fieldName.equalsIgnoreCase("action")) {
							String action = fieldValue;
							System.out.println(action);
							
							if(action.equalsIgnoreCase("withoutGrade")){
								if (fieldName.equalsIgnoreCase("remarksReplica")) {
									remarks = fieldValue;
									System.out.println("remarks:"+remarks);
								}
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								technicalProof = "-";
								softskillProof ="-";
								int manager_grade =0;
								int manager_softGrade =0;
								manager_techcomment ="";
								manager_softcomment="";
								boolean result = allUpdateDAO.reviewStatusUpdate(review_id,remarks);
								boolean result1 = allUpdateDAO.reviewManagerTechIDUpdate(manager_grade,review_id,manager_techcomment,technicalProof);
								boolean result3 = allUpdateDAO.reviewManagerSoftIDUpdate(manager_softGrade,manager_softcomment,review_id,softskillProof);
								request.getRequestDispatcher("managerHome.jsp").forward(request, response);
								return;
							}
							
						}
						
						
							
						
						if (fieldName.equalsIgnoreCase("review_criteria_id")) {
							String value = fieldValue;
							review_criteria_id = Integer.parseInt(value);
							System.out.println("review_criteria_id:"+review_criteria_id);
						}
						
						
						if (fieldName.equalsIgnoreCase("technicalCriteria_id")) {
							String value = fieldValue;
							technical_id = Integer.parseInt(value);
								System.out.println("technical_id:"+technical_id);
							}
						
						
						
						if (fieldName.equalsIgnoreCase("managerTechnicalGrade")) {
							techgrade_id = fieldValue;
							
								System.out.println("manager_grade_id:"+manager_techgrade_id);
							}
						
						if (fieldName.equalsIgnoreCase("managerTechnicalComment")) {
							manager_techcomment = fieldValue;
								System.out.println("manager_comment:"+manager_techcomment);
					
								
								
								/*AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewManagerTechUpdate(manager_techgrade_id,review_criteria_id,manager_techcomment);
								System.out.println("success  technical update");*/
								
							}
						
						
						if (fieldName.equalsIgnoreCase("review_softskill_id")) {
							String value = fieldValue;
							review_softskill_id = Integer.parseInt(value);
							System.out.println("review_softskill_id:"+review_softskill_id);
						}
						
						if (fieldName.equalsIgnoreCase("softskill_id")) {
							String value = fieldValue;
							softskill_id = Integer.parseInt(value);
								System.out.println("softskill_id:"+softskill_id);
							}
						
						if (fieldName.equalsIgnoreCase("managerSoftskillGrade")) {
							softgrade_id = fieldValue;
							
							
								System.out.println("technicalGrade:"+manager_softgrade_id);
							}
						
						if (fieldName.equalsIgnoreCase("review_id")) {
							String value = fieldValue;
							review_id = Integer.parseInt(value);
							
								System.out.println("review_id:"+review_id);
							}
						
						if (fieldName.equalsIgnoreCase("managerSoftComment")) {
							manager_softcomment = fieldValue;
								System.out.println("manager_softcomment:"+manager_softcomment);
								
								/*AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewManagerSoftUpdate(manager_softgrade_id,review_softskill_id,manager_softcomment,review_id);
								System.out.println("success  technical update");
								session.setAttribute("review_id",review_id);*/
								
							}
						
						if (fieldName.equalsIgnoreCase("tech_per")) {
							String value  = fieldValue;
							tech_per = Integer.parseInt(value);	
							}
						if (fieldName.equalsIgnoreCase("soft_per")) {
							String value   = fieldValue;
							soft_per = Integer.parseInt(value);		
							}
						
						if (fieldName.equalsIgnoreCase("queryFire")) {
							String value  = fieldValue;
							}
					
						if (fieldName.equalsIgnoreCase("reviewId")) {
							String value = fieldValue;
							review_id = Integer.parseInt(value);
							System.out.println("review_id:"+review_id);
						}
						
						if (fieldName.equalsIgnoreCase("remarks")) {
							remarks = fieldValue;
							System.out.println("remarks:"+remarks);
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result = allUpdateDAO.reviewStatusUpdate(review_id,remarks);
							response.sendRedirect("managerHome.jsp");
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
							
							technicalProof = "-";
							softskillProof ="-";
							
							
						
							if(fieldName.equalsIgnoreCase("managerTechAttach")){
								System.out.println("no tech file");
								manager_techgrade_id = Integer.parseInt(techgrade_id);
								
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewManagerTechUpdate(manager_techgrade_id,review_criteria_id,manager_techcomment,technicalProof);
								System.out.println("success  technical update");
								
							}
							
							else if(fieldName.equalsIgnoreCase("managerSoftAttach")){
								System.out.println("no softfile");
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								manager_softgrade_id =Integer.parseInt(softgrade_id);
								boolean result = allUpdateDAO.reviewManagerSoftUpdate(manager_softgrade_id,review_softskill_id,manager_softcomment,review_id,softskillProof);
								System.out.println("success  technical update");
								
							}
							
							
							
							
						} else if(fieldName.equalsIgnoreCase("managerTechAttach")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());

								technicalProof = file.getName();
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								System.out.println("technical");
								manager_techgrade_id = Integer.parseInt(techgrade_id);
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewManagerTechUpdate(manager_techgrade_id,review_criteria_id,manager_techcomment,technicalProof);
								System.out.println("success  technical update");
							
						}else if(fieldName.equalsIgnoreCase("managerSoftAttach")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());

								softskillProof = file.getName();
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								System.out.println("softskill");
								
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								manager_softgrade_id =Integer.parseInt(softgrade_id);
								boolean result = allUpdateDAO.reviewManagerSoftUpdate(manager_softgrade_id,review_softskill_id,manager_softcomment,review_id,softskillProof);
								System.out.println("success  technical update");
								
								
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
