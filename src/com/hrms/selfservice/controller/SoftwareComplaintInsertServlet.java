package com.hrms.selfservice.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
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

import com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.bean.SelfServiceTypeBean;
import com.hrms.selfservice.bean.SoftwareComplaintBean;
import com.hrms.selfservice.bean.SoftwareNatureBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;

public class SoftwareComplaintInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user =(EmployeeBean)session.getAttribute("user");
		if(user != null){
			
			
			String filePath= request.getServletContext().getInitParameter("Software-upload");
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
			 int extension = 0;
			 String location = null;
			 int software_complaint_id = 0;
			 String attachment ="-";
			 int employee_master_id = user.getEmployee_master_id();
			 int software_nature_id = 0;
			 String date_of_submission = null;
			 SoftwareNatureBean softwareNatureBean = null;
			 EmployeeBean employeeBean  = null;
				String status = "pending";
			 
				System.out.println("INNN IIFFFFFF======================================="+request.getParameter("employee_name"));
				
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			date_of_submission = dateFormat.format(date);

			AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						
						if(fieldName.equalsIgnoreCase("employee_name")){
							System.out.println("INNN IIFFFFFF");
							String value = fieldValue;

							String[] split = value.split(",");
							int emp_code = Integer.parseInt(split[0]);
							String name = split[1];
							int other_manager_id = 0;
							
							String[] splitName = name.split(" ");
							String firstName = splitName[0];
							String lastName = splitName[1];
							
							System.out.println("emp_code:"+emp_code);
							System.out.println("firstName:"+firstName);
							System.out.println("lastName:"+lastName);
							
							LoginDAO loginDAO = new LoginDAO();
							EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);
							
							employee_master_id = employeeBean1.getEmployee_master_id();
						}/*else{
							 employee_master_id = user.getEmployee_master_id();
						}*/
					 employeeBean = new EmployeeBean();
					 employeeBean.setEmployee_master_id(employee_master_id);
						
					 softwareNatureBean = new SoftwareNatureBean();
					 softwareNatureBean.setSoftware_nature_id(software_nature_id);
					 
						if (fieldName.equalsIgnoreCase("software_nature_id")) {
							String value = fieldValue;
							software_nature_id = Integer.parseInt(value);
							System.out.println("selfservice_query_type_id:"+software_nature_id);
							softwareNatureBean.setSoftware_nature_id(software_nature_id);
						}
						if (fieldName.equalsIgnoreCase("extension")) {
							String value = fieldValue;
							extension = Integer.parseInt(value);
							System.out.println("extension:"+extension);
						}
						if (fieldName.equalsIgnoreCase("location")) {
							location = fieldValue;
							System.out.println("location:"+location);
						}
					
						if (fieldName.equalsIgnoreCase("description")) {
							description = fieldValue;
							System.out.println("problem_desc:"+description);
						}
				
						if (fieldName.equalsIgnoreCase("redirect")) {
							
							SoftwareComplaintBean softwareComplaintBean = new SoftwareComplaintBean(location, extension, description, date_of_submission, status, attachment, employeeBean, softwareNatureBean);
							boolean result = allInsertSelfServiceDAO.softwareComplaintInsert(softwareComplaintBean);
							request.getRequestDispatcher("complaintListSoftware.jsp").forward(request, response);
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
								
								
								/*SoftwareComplaintBean softwareComplaintBean = new SoftwareComplaintBean(location, extension, description, date_of_submission, status, attachment, employeeBean, softwareNatureBean);
								boolean result = allInsertSelfServiceDAO.softwareComplaintInsert(softwareComplaintBean);*/
								/*software_complaint_id = softwareNatureBean.getSoftware_nature_id();
								AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
								List<SoftwareComplaintBean> listOfComplaint = allListSelfServiceDAO.getcomplaintSoftwareByComplaintId(software_complaint_id);
								for (SoftwareComplaintBean c : listOfComplaint) {
									String email_id = null;
									if(c.getSoftwareNatureBean().getSoftware_nature_name().equalsIgnoreCase("HRMS")){
										 email_id = "cprajapati1404@gmail.com";  
									}else{
										email_id = "batuk.bhanderi@sahajanandlaser.com";
									}
									String emailid = email_id; 
									int employee_code = user.getEmployee_code();
									String username = user.getFirstname() + " " + user.getLastname();
									String complaintNature = c.getSoftwareNatureBean().getSoftware_nature_name();
									String complaintDescription = c.getDescription();
									String complaintDate = date_of_submission;
									int extension1 = c.getExtension();
									String location1 = c.getLocation();
									String dept = c.getEmployeeBean().getDepartmentBean().getDepartment_name();
									new Thread(new Runnable() {
										@Override
										public void run() {

											String to = emailid;
											String sub = username + " Register a complaint.";
											String userName = username;
											
											String complaint_date = null;
											
											DateFormat appFormater = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
											try {
												
												Date result = dateFormat.parse(complaintDate);
												complaint_date = appFormater.format(result);
												
											} catch (ParseException e) {
												e.printStackTrace();
											}
											
											
											int emp_code = employee_code;
											String complaint_description = complaintDescription;
											String complaintnature = complaintNature;
											int extension = extension1;
											String location = location1;
											String department = dept;
											

											 System.out.println("test"); 

											Mailer.complaintSend(to, sub, complaint_date, emp_code, complaint_description, userName,
													department,complaintnature,extension,location);

										}
									}).start();
								}*/
								
								
							} else if(fieldName.equalsIgnoreCase("attachment")){
								System.out.println("MIME : "+context.getMimeType(fileName));
									item.write(file);
									System.out.println("===> "+file.getName());

									attachment = file.getName();
									
									System.out.println("photo uploaded");
									
								/*	SoftwareComplaintBean softwareComplaintBean = new SoftwareComplaintBean(location, extension, description, date_of_submission, status, attachment, employeeBean, softwareNatureBean);
									boolean result = allInsertSelfServiceDAO.softwareComplaintInsert(softwareComplaintBean);*/
									/*software_complaint_id = softwareNatureBean.getSoftware_nature_id();
									AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
									List<SoftwareComplaintBean> listOfComplaint = allListSelfServiceDAO.getcomplaintSoftwareByComplaintId(software_complaint_id);
									for (SoftwareComplaintBean c : listOfComplaint) {
										String email_id = null;
										if(c.getSoftwareNatureBean().getSoftware_nature_name().equalsIgnoreCase("HRMS")){
											 email_id = "cprajapati1404@gmail.com";  
										}else{
											email_id = "batuk.bhanderi@sahajanandlaser.com";
										}
										String emailid = email_id; 
										int employee_code = user.getEmployee_code();
										String username = user.getFirstname() + " " + user.getLastname();
										String complaintNature = c.getSoftwareNatureBean().getSoftware_nature_name();
										String complaintDescription = c.getDescription();
										String complaintDate = date_of_submission;
										int extension1 = c.getExtension();
										String location1 = c.getLocation();
										String dept = c.getEmployeeBean().getDepartmentBean().getDepartment_name();
										new Thread(new Runnable() {
											@Override
											public void run() {

												String to = emailid;
												String sub = username + " Register a complaint.";
												String userName = username;
												
												String complaint_date = null;
												
												DateFormat appFormater = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
												try {
													
													Date result = dateFormat.parse(complaintDate);
													complaint_date = appFormater.format(result);
													
												} catch (ParseException e) {
													e.printStackTrace();
												}
												
												
												int emp_code = employee_code;
												String complaint_description = complaintDescription;
												String complaintnature = complaintNature;
												int extension = extension1;
												String location = location1;
												String department = dept;
												

												 System.out.println("test"); 

												Mailer.complaintSend(to, sub, complaint_date, emp_code, complaint_description, userName,
														department,complaintnature,extension,location);

											}
										}).start();
									}
*/									
									
									
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

