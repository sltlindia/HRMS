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

public class ReviewUpdateServlet extends HttpServlet {
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
		String fileName = null;
		File file = null;
		String mail = null;
		int employee_master_id = 0;
		int project_master_id =0;
		int month_id =0;
		int year_id =0;
		int technicalCriteria_id=0;
		int technicalGrade = 0;
		String technicalComment =null;
		int softskill_id =0;
		int sofskillGrade = 0;
		int review_id = 0;
		String softskillComment =null;
		String technicalProof=null;
		String softskillProof=null;
		int review_criteria_id = 0;
		int review_softskill_id =0;
		String achievements=null;
		String area_of_improvement=null;
		
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		MonthBean  monthBean  = new MonthBean();
		YearBean yearBean = new YearBean();
		ReviewBean reviewBean = new ReviewBean();
		TechnicalBean technicalBean = new TechnicalBean();
		GradeMasterBean gradeMasterBean = new GradeMasterBean();
		SoftskillBean softskillBean = new SoftskillBean();
		ManagerBean managerBean = new ManagerBean(); 
		EmployeeBean employeeBean = new EmployeeBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("employee_master_id")) {
						String value = fieldValue;
						employee_master_id = Integer.parseInt(value);
						System.out.println("emp_master_id:"+employee_master_id);
					}
					
					if (fieldName.equalsIgnoreCase("review_id")) {
						String value = fieldValue;
						review_id = Integer.parseInt(value);
						System.out.println("review_id:"+review_id);
					}
					
					
					/*if (fieldName.equalsIgnoreCase("project_master_id")) {
						String value = fieldValue;
						project_master_id = Integer.parseInt(value);
							System.out.println("project_id:"+project_master_id);
						}
					
					
					
					if (fieldName.equalsIgnoreCase("month_id")) {
						String value = fieldValue;
						month_id = Integer.parseInt(value);;
							System.out.println("month:"+month_id);
						}
					
					if (fieldName.equalsIgnoreCase("year_id")) {
						String value = fieldValue;
						year_id = Integer.parseInt(value);;
							System.out.println("year:"+year_id);
				
							projectMasterBean.setProject_master_id(project_master_id);
							monthBean.setMonth_id(month_id);
							yearBean.setYear_id(year_id);
							employeeBean.setEmployee_master_id(employee_master_id);
							String approve_status = "pending";
							
							Date date = new Date();
							String date_submission_employee = date.toString();
							
							if(employee_master_id!=0 && project_master_id!=0 && month_id!=0 && year_id!=0 ){
								reviewBean = new ReviewBean(employeeBean, projectMasterBean, monthBean, yearBean,date_submission_employee,approve_status);
								AllInsertDAO reviewInsert = new AllInsertDAO();
								boolean result = reviewInsert.reviewInsert(reviewBean);
								review_id = reviewBean.getReview_id();
								reviewBean.setReview_id(review_id);
								}
						}
					*/
					if (fieldName.equalsIgnoreCase("review_criteria_id")) {
						String value = fieldValue;
						review_criteria_id = Integer.parseInt(value);
						
							System.out.println("review_criteria_id:"+review_criteria_id);
						}
					
					if (fieldName.equalsIgnoreCase("technicalCriteria_id")) {
						String value = fieldValue;
						technicalCriteria_id = Integer.parseInt(value);
						
							System.out.println("technicalCriteria_id:"+technicalCriteria_id);
						}
					
					if (fieldName.equalsIgnoreCase("technicalGrade")) {
						String value = fieldValue;
						technicalGrade = Integer.parseInt(value);
						
							System.out.println("technicalGrade:"+technicalGrade);
						}
					
					if (fieldName.equalsIgnoreCase("technicalComment")) {
						technicalComment = fieldValue;
							System.out.println("technicalComment:"+technicalComment);
						}
					if (fieldName.equalsIgnoreCase("techUpdate")) {
						technicalProof = fieldValue;
						
							System.out.println("techUpdate:"+technicalProof);
							reviewBean.setReview_id(review_id);
							/*technicalBean.setCriteria_id(technicalCriteria_id);
							gradeMasterBean.setGrade_master_id(technicalGrade);
							ReviewCriteriaBean reviewCriteriaBean = new ReviewCriteriaBean(reviewBean, technicalBean, gradeMasterBean, technicalComment,technicalProof,review_criteria_id);*/
							AllUpdateDAO allUpdateDAO= new AllUpdateDAO();
							boolean result = allUpdateDAO.reviewCriteriaUpdate(technicalCriteria_id,technicalGrade,technicalComment,technicalProof,review_criteria_id);
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
					
					if (fieldName.equalsIgnoreCase("sofskillGrade")) {
						String value = fieldValue;
						sofskillGrade = Integer.parseInt(value);
							System.out.println("sofskillGrade:"+sofskillGrade);
						}
					
					if (fieldName.equalsIgnoreCase("softskillComment")) {
						softskillComment = fieldValue;
							System.out.println("softskillComment:"+softskillComment);
						}
					
					
					if (fieldName.equalsIgnoreCase("softUpdate")) {
						softskillProof = fieldValue;
							System.out.println("softUpdate:"+softskillProof);
							/*softskillBean.setSoftskill_id(softskill_id);
							gradeMasterBean.setGrade_master_id(sofskillGrade);
							reviewBean.setReview_id(review_id);
							ReviewSoftskillBean reviewSoftskillBean = new ReviewSoftskillBean(reviewBean, softskillBean, gradeMasterBean, softskillComment, softskillProof,review_softskill_id);*/
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result = allUpdateDAO.reviewSoftskillUpdate(softskill_id,sofskillGrade,softskillComment,softskillProof,review_softskill_id);
							
						}
					if (fieldName.equalsIgnoreCase("achivements")) {
						achievements = fieldValue;
							System.out.println("achivements:"+achievements);
						}
					
					if (fieldName.equalsIgnoreCase("improvement")) {
						area_of_improvement = fieldValue;
							System.out.println("area_of_improvement:"+area_of_improvement);
						}
					
					if (fieldName.equalsIgnoreCase("statusUpdate")) {
						String value = fieldValue;
							System.out.println("Status:"+value);
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result = allUpdateDAO.reviewAchivementsUpdate(achievements, area_of_improvement, review_id);
							boolean result1 = allUpdateDAO.statusUpdate(review_id);
							session.setAttribute("review_id",review_id);
							request.getRequestDispatcher("reviewUpdateList").forward(request, response);
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
					
					
					String path = "D:\\collegefile\\workspace\\Hibernate Demo\\WebContent\\upload";
					
					
					file = new File(filePath + File.separator
							+ fileName);
					System.out.println("filePath:"+file);

					try {

						if (fileName.isEmpty()) {
							
							technicalProof = "-";
							softskillProof ="-";
							
							reviewBean.setReview_id(review_id);
							
							
							
						
							if(fieldName.equalsIgnoreCase("technicalAttachment")){
								/*technicalBean.setCriteria_id(technicalCriteria_id);
								gradeMasterBean.setGrade_master_id(technicalGrade);*/
								ReviewCriteriaBean reviewCriteriaBean = new ReviewCriteriaBean(reviewBean, technicalBean, gradeMasterBean, technicalComment,technicalProof,review_criteria_id);
								AllUpdateDAO allUpdateDAO= new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewCriteriaUpdate(technicalCriteria_id,technicalGrade,technicalComment,technicalProof,review_criteria_id);
							}
							
							else if(fieldName.equalsIgnoreCase("SoftskillAttachment")){
								softskillBean.setSoftskill_id(softskill_id);
								gradeMasterBean.setGrade_master_id(sofskillGrade);
								ReviewSoftskillBean reviewSoftskillBean = new ReviewSoftskillBean(reviewBean, softskillBean, gradeMasterBean, softskillComment, softskillProof,review_softskill_id);
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewSoftskillUpdate(softskill_id,sofskillGrade,softskillComment,softskillProof,review_softskill_id);
								
								
							}
							
							
							
							
						} else if(fieldName.equalsIgnoreCase("technicalAttachment")){
							System.out.println("MIME : "+context.getMimeType(fileName));
							if (context.getMimeType(fileName).equals(
									"image/gif")
									|| context.getMimeType(fileName)
									.equals("image/jpeg")
							|| context.getMimeType(fileName)
									.equals("image/png")
							|| context.getMimeType(fileName)
									.equals("text/plain")
							|| context.getMimeType(fileName)
									.equals("application/pdf") 
							|| context.getMimeType(fileName)
									.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
							|| context.getMimeType(fileName)
									.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
							|| context.getMimeType(fileName)
									.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation"))
						{
								item.write(file);
								System.out.println("===> "+file.getName());

								technicalProof = file.getName();
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								System.out.println("technical");
								
								/*technicalBean.setCriteria_id(technicalCriteria_id);
								gradeMasterBean.setGrade_master_id(technicalGrade);*/
								reviewBean.setReview_id(review_id);
								/*ReviewCriteriaBean reviewCriteriaBean = new ReviewCriteriaBean(reviewBean, technicalBean, gradeMasterBean, technicalComment,technicalProof,review_criteria_id);*/
								AllUpdateDAO allUpdateDAO= new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewCriteriaUpdate(technicalCriteria_id,technicalGrade,technicalComment,technicalProof,review_criteria_id);
								
							
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .pdf</font>");
							request.getRequestDispatcher("register.jsp").forward(request, response);
							}
						}else if(fieldName.equalsIgnoreCase("softskillAttachment")){
							System.out.println("MIME : "+context.getMimeType(fileName));
							if (context.getMimeType(fileName).equals(
									"image/gif")
									|| context.getMimeType(fileName)
									.equals("image/jpeg")
							|| context.getMimeType(fileName)
									.equals("image/png")
							|| context.getMimeType(fileName)
									.equals("text/plain")
							|| context.getMimeType(fileName)
									.equals("application/pdf") 
							|| context.getMimeType(fileName)
									.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
							|| context.getMimeType(fileName)
									.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
							|| context.getMimeType(fileName)
									.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation"))
						 {
								item.write(file);
								System.out.println("===> "+file.getName());

								softskillProof = file.getName();
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								System.out.println("softskill");
								
								softskillBean.setSoftskill_id(softskill_id);
								gradeMasterBean.setGrade_master_id(sofskillGrade);
								reviewBean.setReview_id(review_id);
								ReviewSoftskillBean reviewSoftskillBean = new ReviewSoftskillBean(reviewBean, softskillBean, gradeMasterBean, softskillComment, softskillProof,review_softskill_id);
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result = allUpdateDAO.reviewSoftskillUpdate(softskill_id,sofskillGrade,softskillComment,softskillProof,review_softskill_id);
								
									
								
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .pdf</font>");
							request.getRequestDispatcher("register.jsp").forward(request, response);
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
