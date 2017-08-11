package com.hrms.recruitement.controller;

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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;

public class ResumeDataInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		int employee_id = user.getEmployee_master_id();
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployee_master_id(employee_id);
		String filePath = getServletContext().getInitParameter("file-upload");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		
		int vacancy_id = 0;
		String name = null;
		String gender = null;
		String date_of_birth = null;
		String residing_country = null;
		String current_location = null;
		String current_contact_no = null;
		String email = null;
		String educational_qualification = null;
		String specialization = null;
		String experience = null;
		String current_company_name = null;
		String functional_area_appying_for = null;
		String role_as = null;
		String current_functional_area = null;
		String current_role = null;
		String key_skills = null;
		String status = "pending";
		String upload_resume = null;
		File file = null;
		String ex_employee = null;
		int employee_code = 0;
		int expected_salary = 0;
		String current_salary = null;
		String notice_period = null;
		String submission_date = null;
		String speciality = null;
		int resource_id = 0;
		String graduate_qualification = null;
		String post_graduate_qualification = null;
		String phd_qualification = null;
		
		
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		ResumeDataBean resumeDataBean1 = new ResumeDataBean();
		SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();
		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);

				
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
			
					if (fieldName.equalsIgnoreCase("titleOfPosition")) {
						String value = fieldValue;
						vacancy_id = Integer.parseInt(value);
						System.out.println("vacancy_id:" + vacancy_id);
					}
					
					if (fieldName.equalsIgnoreCase("name")) {
						name = fieldValue;
						System.out.println("name:" + name);
					}
					
					if (fieldName.equalsIgnoreCase("gender")) {
						gender = fieldValue;
						System.out.println("gender:" + gender);
					}
					
					if (fieldName.equalsIgnoreCase("dateOfBirth")) {
						date_of_birth = fieldValue;
						System.out.println("dateOfBirth:" + date_of_birth);
					}
					
					if (fieldName.equalsIgnoreCase("residingCountry")) {
						residing_country = fieldValue;
						System.out.println("residingCountry:" + residing_country);
					}
					
					if (fieldName.equalsIgnoreCase("currentLocation")) {
						current_location = fieldValue;
						System.out.println("currentLocation:" + current_location);
					}
					
					if (fieldName.equalsIgnoreCase("currentContactNo")) {
						current_contact_no = fieldValue;
						System.out.println("currentContactNo:" + current_contact_no);
					}
					
					if (fieldName.equalsIgnoreCase("email")) {
						email = fieldValue;
						System.out.println("email:" + email);
					}
					
					if (fieldName.equalsIgnoreCase("expectedSalary"))
					{
						String value = fieldValue;
						expected_salary = Integer.parseInt(value);
						System.out.println("expectedSalary:" + expected_salary);
						
					}
					
					if (fieldName.equalsIgnoreCase("currentSalary"))
					{
						current_salary = fieldValue;
						System.out.println("currentSalary:" + current_salary);
						
					}
					
					if (fieldName.equalsIgnoreCase("noticePeriod")) {
						notice_period = fieldValue;
						if(notice_period.equalsIgnoreCase("")){
							notice_period = "-";
						}
						System.out.println("noticePeriod :" + notice_period);
					}
					
					if (fieldName.equalsIgnoreCase("speciality")) {
						speciality = fieldValue;
						System.out.println("speciality :" + speciality);
					}
					
					if (fieldName.equalsIgnoreCase("educationalQualification")) {
						educational_qualification = fieldValue;
						System.out.println("educationalQualification:" + educational_qualification);
					}
					
					if (fieldName.equalsIgnoreCase("specialization")) {
						specialization = fieldValue;
						System.out.println("specialization:" + specialization);
					}
					
					if (fieldName.equalsIgnoreCase("experience")) {
						experience = fieldValue;
						System.out.println("experience:" + experience);
					}
					
					if (fieldName.equalsIgnoreCase("graduatequalification")) {
						graduate_qualification = fieldValue;
						System.out.println("graduatequalification:" + graduate_qualification);
					}
					if (fieldName.equalsIgnoreCase("postgraduate")) {
						post_graduate_qualification = fieldValue;
						System.out.println("postgraduate:" + post_graduate_qualification);
					}
					if (fieldName.equalsIgnoreCase("phd")) {
						phd_qualification = fieldValue;
						System.out.println("phd:" + phd_qualification);
					}
					
					
					if (fieldName.equalsIgnoreCase("currentCompany")) {
						current_company_name = fieldValue;
						if(current_company_name.equalsIgnoreCase("")){
							current_company_name = "-";
						}
						System.out.println("currentCompany:" + current_company_name);
					}
					
					if (fieldName.equalsIgnoreCase("functionalAreaApplyingFor")) {
						functional_area_appying_for = fieldValue;
						System.out.println("functionalAreaApplyingFor:" + functional_area_appying_for);
					}
					
					if (fieldName.equalsIgnoreCase("roleAs")) {
						role_as = fieldValue;
						System.out.println("roleAs:" + role_as);
					}
					
					if (fieldName.equalsIgnoreCase("currentFunctionalArea")) {
						current_functional_area = fieldValue;
						if(current_functional_area.equalsIgnoreCase("")){
							current_functional_area = "-";
						}
						System.out.println("currentFunctionalArea:" + current_functional_area);
					}
					
					if (fieldName.equalsIgnoreCase("currentRole")) {
						current_role = fieldValue;
						if(current_role.equalsIgnoreCase("")){
							current_role = "-";
						}
						System.out.println("currentRole:" + current_role);
					}
					
					if (fieldName.equalsIgnoreCase("keySkills"))
					{
						key_skills = fieldValue;
						System.out.println("keyDetail:" + key_skills);
						
					}
					
					if (fieldName.equalsIgnoreCase("exEmployee"))
					{
						ex_employee = fieldValue;
						System.out.println("exEmployee:" + ex_employee);
						
					}
					
					if (fieldName.equalsIgnoreCase("employeeCode"))
					{
						String value = fieldValue;
						employee_code = Integer.parseInt(value);
						System.out.println("employeeCode:" + employee_code);
						
					}
					
					if (fieldName.equalsIgnoreCase("submission_date")) {
						submission_date = fieldValue;
						System.out.println("submission_date:" + submission_date);
					}
					
					
					if (fieldName.equalsIgnoreCase("resource_id")) {
						String value = fieldValue;
						resource_id = Integer.parseInt(value);
						System.out.println("resource_id:" + resource_id);
					}
					

					
					}
					else{
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

								if (fileName.isEmpty()) {
									fileName = "null";
									
									vacancyFormBean.setVacancy_id(vacancy_id);
									sourceOfResumeBean.setSource_of_resume_id(resource_id);
									AllInsertDAO allInsertDAO = new AllInsertDAO();
									ResumeDataBean resumeDataBean = new ResumeDataBean(name, gender, 
											date_of_birth, residing_country, current_location, current_contact_no,
											email, educational_qualification, specialization, experience, 
											current_company_name, functional_area_appying_for, role_as, 
											current_functional_area, current_role, key_skills, status,
											upload_resume, vacancyFormBean, ex_employee, employee_code, 
											expected_salary, current_salary, notice_period, submission_date,
											speciality, sourceOfResumeBean,employeeBean,graduate_qualification,post_graduate_qualification
											,phd_qualification);
									boolean result = allInsertDAO.resumedataInsert(resumeDataBean);
									if(result == true)
									{
										request.setAttribute("resumeSuccess", "Resume Successfully uploaded");
										request.getRequestDispatcher("myVacancyAllocation.jsp").forward(request, response);
									}
									// Validations....
								} else {
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
										AllInsertDAO allInsertDAO = new AllInsertDAO();
										vacancyFormBean.setVacancy_id(vacancy_id);
										sourceOfResumeBean.setSource_of_resume_id(resource_id);
										ResumeDataBean resumeDataBean = new ResumeDataBean(name, gender, date_of_birth, residing_country, current_location,
												current_contact_no, email, educational_qualification, specialization, 
												experience, current_company_name, functional_area_appying_for, role_as, 
												current_functional_area, current_role, key_skills,status,fileName, vacancyFormBean,
												ex_employee,employee_code,expected_salary,current_salary,notice_period, submission_date,speciality,
												sourceOfResumeBean,employeeBean,graduate_qualification,post_graduate_qualification
												,phd_qualification);
										boolean result = allInsertDAO.resumedataInsert(resumeDataBean);
										if(result == true)
										{
											request.setAttribute("resumeSuccess", "Resume Successfully uploaded");
											request.getRequestDispatcher("myVacancyAllocation.jsp").forward(request, response);
										}
										
										
										/*request.setAttribute("fileName", file.getName());*/
									
									} else {

										request.setAttribute(
												"photo",
												"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
									request.getRequestDispatcher("hrHome.jsp").forward(request, response);
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
					}
				}
				
			
		}catch(Exception e){
			
		}
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
}
}
