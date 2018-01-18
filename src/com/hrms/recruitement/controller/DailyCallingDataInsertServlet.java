package com.hrms.recruitement.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.Catalina;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.DailyCallingDataBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class DailyCallingDataInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		String filePath = getServletContext().getInitParameter("file-upload");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		EmployeeBean employeeBean = new EmployeeBean();
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		DepartmentBean departmentBean = new DepartmentBean();
		SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();
		
		
		
		
		/*int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		int vacancy_id = Integer.parseInt(request.getParameter("vacancy_id"));
		int department_id = Integer.parseInt(request.getParameter("hiringDepartment"));
		int source_of_resume_id = Integer.parseInt(request.getParameter("sourceOfResaume"));*/

		int employee_id = 0;
		int vacancy_id = 0;
		int department_id = 0;
		int source_of_resume_id = 0;
		File file = null;
		/*String submission_date = request.getParameter("submission_date");
		String candidate_name = request.getParameter("candidateName");
		String Gendar = request.getParameter("Gender");
		String current_location = request.getParameter("candidateLocation");
		String mobile_number = request.getParameter("mobileNumber");
		String email_id = request.getParameter("emailId");
		String current_designation = request.getParameter("currentDesignation");
		String total_experience = request.getParameter("totalExperience");
		String highest_qualification = request.getParameter("highestQualification");
		String current_CTC = request.getParameter("currentCTC");
		String expected_CTC = request.getParameter("expectedCTC");
		String notice_period = request.getParameter("noticePeriod");
		String status = request.getParameter("status");
		String remarks = request.getParameter("remarks");
		String offered_gross = request.getParameter("offeredGross");
		String offered_CTC = request.getParameter("offeredCTC");
		String joining_date = request.getParameter("tentativeJoiningDate");
		String fileName = request.getParameter("fileName");*/
		
		String submission_date = null;
		String candidate_name = null;
		String Gendar = null;
		String current_location = null;
		String mobile_number = null;
		String email_id = null;
		String current_designation = null;
		String total_experience = null;
		String highest_qualification = null;
		String current_CTC = null;
		String expected_CTC = null;
		String notice_period = null;
		String status = null;
		String remarks = null;
		String offered_gross = null;
		String offered_CTC = null;
		String joining_date = null;
	
		
		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) 
			{
				FileItem item = items.get(i);

				if (item.isFormField())
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					
					if (fieldName.equalsIgnoreCase("employee_id")) {
						String value = fieldValue;
						employee_id = Integer.parseInt(value);
						System.out.println("employee_id:" + employee_id);
					}
					
					if (fieldName.equalsIgnoreCase("vacancy_id")) {
						String value = fieldValue;
						vacancy_id = Integer.parseInt(value);
						System.out.println("vacancy_id:" + vacancy_id);
					}
					
					if (fieldName.equalsIgnoreCase("hiringDepartment")) {
						String value = fieldValue;
						department_id = Integer.parseInt(value);
						System.out.println("hiringDepartment:" + department_id);
					}
					
					if (fieldName.equalsIgnoreCase("sourceOfResaume")) {
						String value = fieldValue;
						source_of_resume_id = Integer.parseInt(value);
						System.out.println("employee_id:" + source_of_resume_id);
					}
					
					if (fieldName.equalsIgnoreCase("submission_date")) {
						submission_date = fieldValue;
						System.out.println("name:" + submission_date);
					}
					
					if (fieldName.equalsIgnoreCase("candidateName")) {
						candidate_name = fieldValue;
						System.out.println("gender:" + candidate_name);
					}
					
					if (fieldName.equalsIgnoreCase("Gender")) {
						Gendar = fieldValue;
						System.out.println("gender:" + Gendar);
					}
					
					if (fieldName.equalsIgnoreCase("candidateLocation")) {
						current_location = fieldValue;
						System.out.println("gender:" + current_location);
					}
					
					if (fieldName.equalsIgnoreCase("mobileNumber")) {
						mobile_number = fieldValue;
						System.out.println("gender:" + mobile_number);
					}
					
					if (fieldName.equalsIgnoreCase("emailId")) {
						email_id = fieldValue;
						System.out.println("gender:" + email_id);
					}
					
					if (fieldName.equalsIgnoreCase("currentDesignation")) {
						current_designation = fieldValue;
						System.out.println("gender:" + current_designation);
					}
					
					if (fieldName.equalsIgnoreCase("totalExperience")) {
						total_experience = fieldValue;
						System.out.println("gender:" + total_experience);
					}
					
					if (fieldName.equalsIgnoreCase("highestQualification")) {
						highest_qualification = fieldValue;
						System.out.println("gender:" + highest_qualification);
					}
					
					if (fieldName.equalsIgnoreCase("currentCTC")) {
						current_CTC = fieldValue;
						System.out.println("gender:" + current_CTC);
					}
					
					if (fieldName.equalsIgnoreCase("expectedCTC")) {
						expected_CTC = fieldValue;
						System.out.println("gender:" + expected_CTC);
					}
					
					if (fieldName.equalsIgnoreCase("noticePeriod")) {
						notice_period = fieldValue;
						System.out.println("gender:" + notice_period);
					}
					
					if (fieldName.equalsIgnoreCase("status")) {
						status = fieldValue;
						System.out.println("gender:" + status);
					}
					
					if (fieldName.equalsIgnoreCase("remarks")) {
						remarks = fieldValue;
						System.out.println("gender:" + remarks);
					}
					
					if (fieldName.equalsIgnoreCase("offeredGross")) {
						offered_gross = fieldValue;
						System.out.println("gender:" + offered_gross);
					}
					
					if (fieldName.equalsIgnoreCase("offeredCTC")) {
						offered_CTC = fieldValue;
						System.out.println("gender:" + offered_CTC);
					}
					
					if (fieldName.equalsIgnoreCase("tentativeJoiningDate")) {
						joining_date = fieldValue;
						System.out.println("gender:" + joining_date);
					}
				}
				else
				{
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
					System.out.println("File Name : "+fileName);
					
					fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1,
							fileName.length());
					System.out.println("File Name 1 : "+fileName);
					
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("appPath : "+appPath);
					
					
					
					
					file = new File(filePath + File.separator
							+ fileName);
					System.out.println("filePath:"+file);
					
					
					try {

						if (fileName.isEmpty()) 
						{
							fileName = "null";
							employeeBean.setEmployee_master_id(employee_id);
							vacancyFormBean.setVacancy_id(vacancy_id);
							departmentBean.setDepartment_id(department_id);
							sourceOfResumeBean.setSource_of_resume_id(source_of_resume_id);
							DailyCallingDataBean dailyCallingDataBean = new DailyCallingDataBean(fileName , submission_date, candidate_name, Gendar,
									current_location, mobile_number, email_id, current_designation, total_experience, highest_qualification,
									current_CTC, expected_CTC, notice_period, status, remarks, offered_gross, offered_CTC, joining_date,
									departmentBean, vacancyFormBean, sourceOfResumeBean, employeeBean);
							
							AllInsertDAO allInsertDAO = new AllInsertDAO();
							boolean result  = allInsertDAO.dailyCallingDataInsert(dailyCallingDataBean);
							if(result == true)
							{
								//response.sendRedirect("hrHome.jsp");
							}
						}
						else
						{
							System.out.println("MIME : "+context.getMimeType(fileName));
							if (context.getMimeType(fileName).equals(
									"image/gif")
									|| context.getMimeType(fileName)
											.equals("image/jpeg")
											|| context.getMimeType(fileName)
											.equals("application/msword")
											|| context.getMimeType(fileName)
											.equals("application/pdf")
											|| context.getMimeType(fileName)
											.equals("video/msvideo, video/avi, video/x-msvideo")
											|| context.getMimeType(fileName)
											.equals("text/plain")
											|| context.getMimeType(fileName)
											.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
											|| context.getMimeType(fileName)
											.equals("text/html")
											|| context.getMimeType(fileName)
											.equals("image/gif")
											|| context.getMimeType(fileName)
											.equals("application/x-javascript")
											|| context.getMimeType(fileName)
											.equals("text/onenote")
											|| context.getMimeType(fileName)
											.equals("application/x-shockwave-flash")
											|| context.getMimeType(fileName)
											.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.template")
											|| context.getMimeType(fileName)
											.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
									|| context.getMimeType(fileName)
											.equals("image/png")) {
								item.write(file);
								System.out.println("===> "+file.getName());
								employeeBean.setEmployee_master_id(employee_id);
								vacancyFormBean.setVacancy_id(vacancy_id);
								departmentBean.setDepartment_id(department_id);
								sourceOfResumeBean.setSource_of_resume_id(source_of_resume_id);
								DailyCallingDataBean dailyCallingDataBean = new DailyCallingDataBean(fileName ,submission_date, candidate_name, Gendar,
										current_location, mobile_number, email_id, current_designation, total_experience, highest_qualification,
										current_CTC, expected_CTC, notice_period, status, remarks, offered_gross, offered_CTC, joining_date,
										departmentBean, vacancyFormBean, sourceOfResumeBean, employeeBean);
								
								AllInsertDAO allInsertDAO = new AllInsertDAO();
								boolean result  = allInsertDAO.dailyCallingDataInsert(dailyCallingDataBean);
								if(result == true)
								{
									response.sendRedirect("myVacancyAllocation.jsp");
								}
								
							}
						}
					}
					catch (Exception e) {
						// TODO: handle exception
					}

				}

			}
		}
			catch(Exception e){
				
			}
		
		
	}

}
