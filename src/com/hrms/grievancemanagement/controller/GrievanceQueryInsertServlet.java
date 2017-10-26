package com.hrms.grievancemanagement.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.hrms.grievancemanagement.bean.HrmsMailBean;
import com.hrms.grievancemanagement.dao.AllInsertGrievanceDAO;
import com.hrms.grievancemanagement.dao.AllListGrievanceDAO;
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
import com.hrms.pms.dao.AllUpdateDAO;

public class GrievanceQueryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		String filePath = getServletContext().getInitParameter("grievance-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		String query = null;
		String attachment ="-";
		String email = null;
		String status = "pending";
		String date_of_submission = null;
		String date_of_resolve = "null";
		String type = null;
		String reply = null;
		String reply_attachment = null;
		int grievance_id = 0;
		int grievance_queyr_type_id = 0;
		int id = user.getEmployee_master_id();
		String name = user.getFirstname()+" "+user.getLastname();
		int show_view = 0;
		int escalation_id = 0;
		
		List<String> arrayEmail = new ArrayList<>();
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(id);
		
		GrievanceQueryTypeBean grievanceQueryTypeBean = new GrievanceQueryTypeBean();
		
		AllInsertGrievanceDAO allInsertGrievanceDAO = new AllInsertGrievanceDAO();
		
		AllListGrievanceDAO allListGrievanceDAO = new AllListGrievanceDAO();
		List<HrmsMailBean> listOfAllMail = allListGrievanceDAO.getAllMailList();
		
		for(HrmsMailBean h : listOfAllMail){
			
			String mail = h.getHrms_mail();
			arrayEmail.add(mail);
			
		}
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
					if (fieldName.equalsIgnoreCase("query")) {
						query = fieldValue;
						System.out.println("query:"+query);
					}
					
					if (fieldName.equalsIgnoreCase("grievance_query_type_id")) {
						String value = fieldValue;
						
						String[] split = value.split(",");
						
						grievance_queyr_type_id =Integer.parseInt(split[0]);
						type = split[1];
						
						System.out.println("grievance_queyr_type_id:"+grievance_queyr_type_id);
						grievanceQueryTypeBean.setGrievance_query_type_id(grievance_queyr_type_id);
					}
					
					
					if (fieldName.equalsIgnoreCase("email")) {
						email = fieldValue;
						
							System.out.println("email:"+email);
							System.out.println("fileNAmeNAmeNAme:"+fileName);
							
							
							String[] split = email.split(",");
							for(String splitEmail : split){
								
								
								if(!splitEmail.equalsIgnoreCase("")){
								arrayEmail.add(splitEmail);
								String msg1 = query;
								String type1 = type;
								String name1 = fileName;
							GrievanceQueryBean grievanceQueryBean = new GrievanceQueryBean();
							grievanceQueryBean.setGrievance_query_id(grievance_id);
							
							GrievanceEmailBean grievanceEmailBean = new GrievanceEmailBean(splitEmail, grievanceQueryBean);
							boolean result1 = allInsertGrievanceDAO.grievanceEmailInsert(grievanceEmailBean);
							
							}	
							
							}
						}
					if (fieldName.equalsIgnoreCase("redirect")) {
						System.err.println("IN REDIRECT");
						System.out.println(arrayEmail);
						String msg1 = query;
						String type1 = type;
						String name1 = fileName;
						String cc = email;
						
						
						
						new Thread(new Runnable() {
						    @Override
						    public void run() {
						    	System.err.println("IN MAIL");
						    	String sub = name+" Submitted one query";
						    	String type = type1;
						    	String query = msg1;
						    	String candidateName = name;
						    	int code = user.getEmployee_code();
						    	String attachment = name1;
						    	
						    	Mailer.send(sub, type , query,code,attachment,candidateName,arrayEmail);
						    	System.err.println("MAIL DONE");
						    }
						}).start();
						
						request.getRequestDispatcher("allGrievanceList.jsp").forward(request, response);
						
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
					/*String appPath = context.getRealPath("\\")+("WebContent\\upload");
					System.out.println("appPath : "+appPath);*/
					
					
					
					
					file = new File(filePath + File.separator
							+ fileName);
					System.out.println("filePath:"+file);

					try {

						if (fileName.isEmpty()) {
							
							GrievanceQueryBean grievanceQueryBean = new GrievanceQueryBean(query, attachment, employeeBean, status, date_of_submission, date_of_resolve, grievanceQueryTypeBean,reply,reply_attachment, show_view,escalation_id);
							boolean result = allInsertGrievanceDAO.grievanceInsert(grievanceQueryBean);
							
							grievance_id = grievanceQueryBean.getGrievance_query_id();
							
							
							
						} else if(fieldName.equalsIgnoreCase("attachment")){
							System.out.println("MIME : "+context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> "+file.getName());

								attachment = file.getName();
								
								System.out.println("photo uploaded");
								
								GrievanceQueryBean grievanceQueryBean = new GrievanceQueryBean(query, attachment, employeeBean, status, date_of_submission, date_of_resolve, grievanceQueryTypeBean,reply,reply_attachment, show_view,escalation_id);
								boolean result = allInsertGrievanceDAO.grievanceInsert(grievanceQueryBean);
								
								grievance_id = grievanceQueryBean.getGrievance_query_id();
								
								
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

