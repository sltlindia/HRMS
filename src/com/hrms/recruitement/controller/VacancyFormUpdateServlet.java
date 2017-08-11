package com.hrms.recruitement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.hrms.recruitement.bean.BenefitsBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllUpdateDAO;
import com.hrms.recruitement.dao.VacancyFormDAO;

public class VacancyFormUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			String filePath = getServletContext().getInitParameter("file-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			/* EmployeeBean user = session.getAttribute("user"); */
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String title_of_position = null;
			int no_of_vacancy = 0;
			int job_location_id = 0;
			String tentative_joining_date = null;
			int department_id = 0;
			int manager_id = 0;
			int employee_id = 0;
			String educational_qualification = null;
			String job_discription = null;
			String required_skill = null;
			String required_experience = null;
			String payment_type = null;
			String salary_range = null;
			String interviewed_by = null;
			int v_id = 0;
			String reason = null;
			String skillAndCompetencies = null;
			String status = null;
			String ceodatetime = null;
			String hrdatetime = null;
			String submission_date = null;
			String reason_for_hire = null;
			String vacancy_type = null;
			String replacement_of = null;
			String authority = null;
			String approval_status = null;

			JobLocationBean jobLocationBean = new JobLocationBean();
			ManagerBean managerBean = new ManagerBean();
			EmployeeBean employeeBean = new EmployeeBean();

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new Date();
			System.out.println(dateFormat.format(date1));
			String date = dateFormat.format(date1);
			int employee_master_id = user.getEmployee_master_id();
			/* v_id = Integer.parseInt(request.getParameter("v_id")); */
			/* v_id = 181; */
			System.out.println("Vid" + v_id);
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);

					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();

						if (fieldName.equalsIgnoreCase("titleOfThePosition")) {
							title_of_position = fieldValue;
							System.out.println("titleOfThePosition:" + title_of_position);
						}
						
						if (fieldName.equalsIgnoreCase("vacancyType")) {
							vacancy_type = fieldValue;
							System.out.println("vacancyType:" + vacancy_type);
						}
						
						

						/*if (fieldName.equalsIgnoreCase("noOfVacancies")) {
							String value = fieldValue;
							no_of_vacancy = Integer.parseInt(value);
							System.out.println("noOfVacancies:" + no_of_vacancy);
						}

						if (fieldName.equalsIgnoreCase("jobLocation")) {
							String value = fieldValue;
							job_location_id = Integer.parseInt(value);
							System.out.println("jobLocation:" + job_location_id);
						}

						if (fieldName.equalsIgnoreCase("tentativeJoiningDate")) {
							tentative_joining_date = fieldValue;
							System.out.println("tentativeJoiningDate:" + tentative_joining_date);
						}

						if (fieldName.equalsIgnoreCase("hiringDepartment")) {
							String value = fieldValue;
							department_id = Integer.parseInt(value);
							System.out.println("hiringDepartment:" + department_id);
						}

						if (fieldName.equalsIgnoreCase("reportingManager")) {
							String value = fieldValue;
							manager_id = Integer.parseInt(value);
							System.out.println("manager_id:" + manager_id);
						}

						if (fieldName.equalsIgnoreCase("reqEduQua")) {
							educational_qualification = fieldValue;
							System.out.println("reqEduQua:" + educational_qualification);
						}

						if (fieldName.equalsIgnoreCase("jobDescription")) {

							job_discription = fieldValue;
							System.out.println("jobDescription:" + job_discription);

						}

						if (fieldName.equalsIgnoreCase("reqSkill")) {
							required_skill = fieldValue;
							System.out.println("reqSkill:" + required_skill);
						}

						if (fieldName.equalsIgnoreCase("reqExp")) {
							required_experience = fieldValue;
							System.out.println("reqExp:" + required_experience);
						}

						if (fieldName.equalsIgnoreCase("payment")) {
							payment_type = fieldValue;
							System.out.println("payment:" + payment_type);
						}

						if (fieldName.equalsIgnoreCase("salaryRange")) {
							salary_range = fieldValue;
							System.out.println("salaryRange:" + salary_range);
						}
						
						if (fieldName.equalsIgnoreCase("authority")) {
							authority = fieldValue;
							System.out.println("authority :" + authority);
						}

						

						if (fieldName.equalsIgnoreCase("skillAndCompetencies")) {
							skillAndCompetencies = fieldValue;
							System.out.println("skillAndCompetencies:" + skillAndCompetencies);
						}
						
						if (fieldName.equalsIgnoreCase("interviewedBy")) {
							interviewed_by = fieldValue;
							System.out.println("interviewedBy:" + interviewed_by);
						}

						

						if (fieldName.equalsIgnoreCase("approve_status")) {
							status = fieldValue;
							System.out.println("status:" + status);

						}
																		
						
						
						if (fieldName.equalsIgnoreCase("reasonForHire")) {
							reason_for_hire = fieldValue;
							System.out.println("reasonForHire:" + reason_for_hire);
						}


						if (fieldName.equalsIgnoreCase("ceo_status_datetime")) {
							ceodatetime = fieldValue;
							System.out.println("ceo_status_datetime:" + ceodatetime);

						}*/

						if (fieldName.equalsIgnoreCase("submission_date")) {
							submission_date = fieldValue;
							System.out.println("submission_date:" + submission_date);

						}
												
						if (fieldName.equalsIgnoreCase("employee_id")) {
							String value = fieldValue;
							employee_id = Integer.parseInt(value);
							System.out.println("employee_id:" + employee_id);
						}
						
						if (fieldName.equalsIgnoreCase("action")) {
							approval_status = fieldValue;
							System.out.println("approved:" + approval_status);
						}

						if (fieldName.equalsIgnoreCase("v_id")) {
							String value = fieldValue;
							v_id = Integer.parseInt(value);
							System.out.println("v_id:" + v_id);
						}

						if (fieldName.equalsIgnoreCase("remarksForReject")) {
							reason = fieldValue;
							System.out.println("remarks:" + reason);

							jobLocationBean.setJob_location_id(job_location_id);
							/*departmentBean.setDepartment_id(department_id);*/
							managerBean.setManager_id(manager_id);
							employeeBean.setEmployee_master_id(employee_id);
							
							System.out.println("Vacancy Id :" + v_id);
							VacancyFormDAO vacancyFormDAO = new VacancyFormDAO();
							boolean result = vacancyFormDAO.vacancyApproveRejectUpdate(reason, v_id, approval_status, employee_master_id, submission_date);
							
							if(result == true)
							{
								if(user.getRoleBean().getRole_authority().equalsIgnoreCase("M6"))
								{
									response.sendRedirect("sltlAdmin.jsp");
								} else if(user.getRoleBean().getRole_authority().equalsIgnoreCase("M5"))
								{
									response.sendRedirect("hrHome.jsp");
								} else
								{
									response.sendRedirect("managerHome.jsp");
								}
								
							}
							/*VacancyFormDAO vacancyFormDAO = new VacancyFormDAO();
							boolean result = vacancyFormDAO.vacancyUpdate1(reason, v_id, hr_approval,
									director_approval, hod_approval, ceo, status, hrstatus, ceostatus, hodstatus,
									directorstatus, directordatetime, hoddatetime, ceodatetime, hrdatetime);*/
							/*if (result == true) {
								
								 * System.out.println("Successful"); v_id =
								 * vacancyFormBean.getVacancy_id();
								 * vacancyFormBean.setVacancy_id(v_id);
								  System.out.println(v_id);
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								String role = user.getRoleBean().getRole_type();
								String authority_type = user.getRoleBean().getRole_authority();
								System.out.println(role);
								if (role.equalsIgnoreCase("MD")) {
									System.out.println("md success");
									boolean result1 = allUpdateDAO.vacancyMdUpdate(date, approved, v_id);
								} else if (authority_type.equalsIgnoreCase("M5")) {
									boolean result2 = allUpdateDAO.vacancyHrUpdate(date, approved, v_id);
								} else if (authority_type.equalsIgnoreCase("M6")) {
									boolean result3 = allUpdateDAO.vacancyCeoUpdate(date, approved, v_id);
								} else if (role.equalsIgnoreCase("HOD")) {
									boolean result4 = allUpdateDAO.vacancyHodUpdate(date, approved, v_id);
								}
								
								if(role_id == 12){
								request.getRequestDispatcher("hrHome.jsp").forward(request, response);
								}
								else{
									request.getRequestDispatcher("sltlAdmin.jsp").forward(request, response);
									}
								}*/

						}

					}

				}

			} catch (Exception E) {

			}
		} else {
			response.sendRedirect("login.jsp");
		}

	}
	
	
	

}
