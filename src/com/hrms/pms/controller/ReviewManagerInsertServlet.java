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
import com.hrms.pms.bean.GradeMasterBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ManagerGradeMasterBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.ReviewCriteriaBean;
import com.hrms.pms.bean.ReviewSoftskillBean;
import com.hrms.pms.bean.SoftskillBean;
import com.hrms.pms.bean.TechnicalBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class ReviewManagerInsertServlet extends HttpServlet {
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
			int manager_techgrade_id= 0;
			String manager_techcomment=null;
			int softskill_id=0;
			int manager_softgrade_id=0;
			String manager_softcomment=null;
			int tech_per=0;
			int soft_per=0;
			String technicalProof=null;
			String softskillProof=null;
			String date_finalize_manager = null;
			Date date = new Date();
			


			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
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
							String value = fieldValue;
							manager_techgrade_id = Integer.parseInt(value);
								System.out.println("manager_grade_id:"+manager_techgrade_id);
							}
						
						if (fieldName.equalsIgnoreCase("managerTechnicalComment")) {
							manager_techcomment = fieldValue;
								System.out.println("manager_comment:"+manager_techcomment);
					
								
								
								/*AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewManagerTechUpdate(manager_techgrade_id,review_criteria_id,manager_techcomment);
								System.out.println("success  technical update");*/
								
							}
						
						if (fieldName.equalsIgnoreCase("managerTechUpdate")) {
							technicalProof = fieldValue;
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result = allUpdateDAO.reviewManagerTechUpdate(manager_techgrade_id,review_criteria_id,manager_techcomment,technicalProof);
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
							String value  = fieldValue;
							manager_softgrade_id = Integer.parseInt(value);
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
						
						if (fieldName.equalsIgnoreCase("managerSoftUpdate")) {
							softskillProof = fieldValue;
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result = allUpdateDAO.reviewManagerSoftUpdate(manager_softgrade_id,review_softskill_id,manager_softcomment,review_id,softskillProof);
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
							date_finalize_manager = date.toString();
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result = allUpdateDAO.finalizeDateUpdate(review_id, date_finalize_manager);
								System.out.println("Query:"+value);
								session.setAttribute("review_id",review_id);
								session.setAttribute("tech_per",tech_per);
								session.setAttribute("soft_per",soft_per);
								request.getRequestDispatcher("reviewManagerList").forward(request, response);
								return;
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
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewManagerTechUpdate(manager_techgrade_id,review_criteria_id,manager_techcomment,technicalProof);
								System.out.println("success  technical update");
								
							}
							
							else if(fieldName.equalsIgnoreCase("managerSoftAttach")){
								System.out.println("no softfile");
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
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
