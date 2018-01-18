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
import com.hrms.recruitement.bean.CityBean;
import com.hrms.recruitement.bean.EducationalQualificationBean;
import com.hrms.lms.dao.AllDeleteDAO;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.StateBean;
import com.hrms.recruitement.bean.VacancyApprovalBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllDeleteRecruitementDAO;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;
import com.hrms.recruitement.dao.VacancyFormDAO;

public class VacancyFinalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			/* EmployeeBean user = session.getAttribute("user"); */
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String person = user.getRoleBean().getRole_authority();
			String title_of_position = null;
			int no_of_vacancy = 0;
			String tentative_joining_date = null;
			int department_id = 0;
			int reporting_manager = 0;
			int manager_id = 0;
			int employee_id = 0;
			int benefits = 0;
			String required_experience = null;
			String salary_range = null;
			int v_id = 0;
			/* String rejected = "Rejected"; */
			String skillAndCompetencies = null;
			String bill_limit = null;
			String company_branch = null;
			/*
			 * String director_status = "pending"; String hod_status =
			 * "pending"; String ceo_status = "pending"; String hr_status =
			 * "pending";
			 */
			String value5 = null;
			String submission_date = null;
			String reason_for_hire = null;
			String replacement_of = null;
			String vacancy_type = null;
			String country = null;
			int state_id = 0;
			int city_id = 0;
			int under_graduate_qualification_id = 0;
			int under_graduate_specification_id = 0;
			int post_graduate_qualification_id = 0;
			int post_graduate_specification_id = 0;
			String role_objective = null;
			String span_of_control = null;
			String role_description = null;
			String internal_operating_network = null;
			String external_operating_network = null;
			String personal_competencies = null;
			String key_performance_indicator = null;
			int vacancy_id = 0;
			String status = "pending";
			
			int manager_id1 = user.getManagerBean().getManager_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
			

			DepartmentBean departmentBean = new DepartmentBean();
			VacancyFormBean vacancyFormBean = new VacancyFormBean();
			ManagerBean managerBean = new ManagerBean();
			

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new Date();
			System.out.println(dateFormat.format(date1));
			/* v_id = Integer.parseInt(request.getParameter("v_id")); */
			/* v_id = 181; */

			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);

					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
		
						if (fieldName.equalsIgnoreCase("vacancy_id")) {
							String value = fieldValue;
							vacancy_id = Integer.parseInt(value);
							System.out.println("vacancy_id :" + vacancy_id);
						}

						
						if (fieldName.equalsIgnoreCase("vacancyType")) {
							vacancy_type = fieldValue;
							System.out.println("vacancyType :" + vacancy_type);
						}

						if (fieldName.equalsIgnoreCase("replacementOf")) {
							replacement_of = fieldValue;
							System.out.println("replacementOf :" + replacement_of);
						}

						if (fieldName.equalsIgnoreCase("titleOfThePosition")) {
							title_of_position = fieldValue;
							System.out.println("title_of_position :" + title_of_position);
						}

						if (fieldName.equalsIgnoreCase("employee_id")) {
							String value = fieldValue;
							employee_id = Integer.parseInt(value);
							System.out.println("employee_id:" + employee_id);
						}

						if (fieldName.equalsIgnoreCase("noOfVacancies")) {
							String value = fieldValue;
							no_of_vacancy = Integer.parseInt(value);
							System.out.println("noOfVacancies:" + no_of_vacancy);
						}

						
						if (fieldName.equalsIgnoreCase("local")) {
							country = fieldValue;
							System.out.println("country :" + country);
						}

						if (fieldName.equalsIgnoreCase("other")) {
							country = fieldValue;
							System.out.println("country :" + country);
						}

						if (fieldName.equalsIgnoreCase("state")) {
							String value = fieldValue;
							state_id = Integer.parseInt(value);
							System.out.println("state :" + state_id);
						}

						if (fieldName.equalsIgnoreCase("city")) {
							String value = fieldValue;
							city_id = Integer.parseInt(value);
							System.out.println("city :" + city_id);
						}

						if (fieldName.equalsIgnoreCase("underGraduateQualification")) {
							String value = fieldValue;
							under_graduate_qualification_id = Integer.parseInt(value);
							System.out.println("under_graduate_qualification_id :" + under_graduate_qualification_id);
						}

						if (fieldName.equalsIgnoreCase("underGraduateSpecification")) {
							String value = fieldValue;
							under_graduate_specification_id = Integer.parseInt(value);
							System.out.println("under_graduate_specification_id :" + under_graduate_specification_id);
						}

						if (fieldName.equalsIgnoreCase("postGraduateQualification")) {
							String value = fieldValue;
							post_graduate_qualification_id = Integer.parseInt(value);
							System.out.println("post_graduate_qualification_id :" + post_graduate_qualification_id);
						}

						if (fieldName.equalsIgnoreCase("postGraduateSpecification")) {
							String value = fieldValue;
							post_graduate_specification_id = Integer.parseInt(value);
							System.out.println("post_graduate_specification_id :" + post_graduate_specification_id);
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

						if (fieldName.equalsIgnoreCase("manager_id")) {
							String value = fieldValue;
							manager_id = Integer.parseInt(value);
							System.out.println("manager_id:" + manager_id);
						}

						if (fieldName.equalsIgnoreCase("reportingManager")) {
							String value = fieldValue;
							reporting_manager = Integer.parseInt(value);
							System.out.println("reportingManqager:" + reporting_manager);
						}

						/*
						 * if (fieldName.equalsIgnoreCase("reqEduQua")) { String
						 * value = fieldValue; educational_qualification_id =
						 * Integer.parseInt(value);
						 * System.out.println("reqEduQua:" +
						 * educational_qualification_id); }
						 */

						if (fieldName.equalsIgnoreCase("reasonForHire")) {
							reason_for_hire = fieldValue;
							System.out.println("reasonForHire:" + reason_for_hire);
						}

						if (fieldName.equalsIgnoreCase("roleObjective")) {
							role_objective = fieldValue;
							System.out.println("role_objective:" + role_objective);

						}

						if (fieldName.equalsIgnoreCase("spanOfControl")) {
							span_of_control = fieldValue;
							System.out.println("span_of_control:" + span_of_control);
						}

						if (fieldName.equalsIgnoreCase("reqExp")) {
							required_experience = fieldValue;
							System.out.println("reqExp:" + required_experience);
						}

						/*
						 * if (fieldName.equalsIgnoreCase("payment")) {
						 * payment_type = fieldValue;
						 * System.out.println("payment:" + payment_type); }
						 */

						if (fieldName.equalsIgnoreCase("salaryRange")) {
							salary_range = fieldValue;
							System.out.println("salaryRange:" + salary_range);
						}

						if (fieldName.equalsIgnoreCase("roleDescription")) {
							role_description = fieldValue;
							System.out.println("role_description:" + role_description);
						}

						if (fieldName.equalsIgnoreCase("internal")) {
							internal_operating_network = fieldValue;
							System.out.println("internal :" + internal_operating_network);
						}

						if (fieldName.equalsIgnoreCase("external")) {
							external_operating_network = fieldValue;
							System.out.println("external :" + external_operating_network);
						}

						if (fieldName.equalsIgnoreCase("personalCompetencies")) {
							personal_competencies = fieldValue;
							System.out.println("personalCompetencies:" + personal_competencies);
						}

						if (fieldName.equalsIgnoreCase("techSkills")) {
							skillAndCompetencies = fieldValue;
							System.out.println("techSkills:" + skillAndCompetencies);
						}

						if (fieldName.equalsIgnoreCase("companyLocation")) {
							company_branch = fieldValue;
							System.out.println("companyLocation :" + company_branch);
						}
						
						
						
						if (fieldName.equalsIgnoreCase("submission_date")) {
							submission_date = fieldValue;
							System.out.println("submission_date:" + submission_date);
						}

						if (fieldName.equalsIgnoreCase("keyPerformanceIndicator")) {
							key_performance_indicator = fieldValue;
							System.out.println("keyPerformanceIndicator :" + key_performance_indicator);
						}

						if (fieldName.equalsIgnoreCase("deleteBenefits")){
						System.out.println("delete");
						System.out.println("v_id"+vacancy_id);
						AllDeleteRecruitementDAO allDeleteRecruitementDAO = new AllDeleteRecruitementDAO();
						allDeleteRecruitementDAO.benefitsDelete(vacancy_id);
						}
						
						if (fieldName.equalsIgnoreCase("interviewerDelete"))
						{
							System.out.println("delete");
							System.out.println("v_id"+vacancy_id);
							AllDeleteRecruitementDAO allDeleteRecruitementDAO = new AllDeleteRecruitementDAO();
							allDeleteRecruitementDAO.interviewerDelete(vacancy_id);
						}
						
						if (fieldName.equalsIgnoreCase("employee_name")) {
							value5 = fieldValue;
							System.out.println("employee_name:" + value5);

							if (!value5.equalsIgnoreCase("")) {

								String[] split = value5.split(",");
								int emp_code = Integer.parseInt(split[0]);
								String name = split[1];

								String[] splitName = name.split(" ");
								String firstName = splitName[0];
								String lastName = splitName[1];

								System.out.println("emp_code:" + emp_code);
								System.out.println("firstName:" + firstName);
								System.out.println("lastName:" + lastName);

								LoginDAO loginDAO = new LoginDAO();
								EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName,
										lastName);

								int emp_id = employeeBean1.getEmployee_master_id();

								System.out.println("emp_id:" + emp_id);

								AllInsertDAO allInsertDAO = new AllInsertDAO();
								boolean result1 = allInsertDAO.interviewedbyInsert(vacancy_id, emp_id);
							}
						}
						
						if (fieldName.equalsIgnoreCase("benefits")) {
								String value1 = fieldValue;
								benefits = Integer.parseInt(value1);
								System.out.println("benefits: " + benefits);
								vacancyFormBean.setVacancy_id(vacancy_id);
								System.out.println("Vacancy Id " + vacancy_id);
								
								BenefitsBean benefitsBean2 = new BenefitsBean();
								benefitsBean2.setBenefit_id(benefits);
								VacancyFormDAO vacancyFormDAO = new VacancyFormDAO();
								VacancyBenefitsBean vacancyBenefitsBean1 = new VacancyBenefitsBean(vacancyFormBean,
										benefitsBean2);
								boolean result1 = vacancyFormDAO.vacancyBenefits(vacancyBenefitsBean1);
						}
						
						if (fieldName.equalsIgnoreCase("billLimit")) {
							bill_limit = fieldValue;
							System.out.println("bill_limit:" + bill_limit);
						}
						
						if (fieldName.equalsIgnoreCase("submission_date")) {
							submission_date = fieldValue;
							System.out.println("submission_date:" + submission_date);
						}
						
						
						if(fieldName.equalsIgnoreCase("updateVacancy"))
						{
						
							departmentBean.setDepartment_id(department_id);
							managerBean.setManager_id(manager_id);
							

							System.out.println("Vacancy Id :" + vacancy_id);
							VacancyFormDAO vacancyFormDAO = new VacancyFormDAO();
							System.out.println("ripal");
							boolean result = vacancyFormDAO.vacancyUpdate(no_of_vacancy, reporting_manager,
									tentative_joining_date, required_experience, salary_range, skillAndCompetencies,
									reason_for_hire, vacancy_type, replacement_of, title_of_position, role_objective,
									span_of_control, internal_operating_network, external_operating_network,
									personal_competencies, key_performance_indicator, department_id, manager_id,
									state_id, city_id, under_graduate_qualification_id, under_graduate_specification_id,
									post_graduate_qualification_id, post_graduate_specification_id, country,
									role_description, vacancy_id, bill_limit, submission_date, employee_id, company_branch, status);
							if (result == true) {
								/*
								 * System.out.println("Successful"); v_id =
								 * vacancyFormBean.getVacancy_id();
								 * vacancyFormBean.setVacancy_id(v_id);
								 */
								
								AllUpdateDAO allUpdateDAO1 = new AllUpdateDAO();
								allUpdateDAO1.vacancyApprovalStatusUpdate(vacancy_id);
								System.out.println(v_id);
								System.out.println("updated "+vacancy_id);
								String role = user.getRoleBean().getRole_type();
								System.out.println(role);
								
								if (manager_id1 != 99) {
									if (manager_id1 == 1 || manager_id1 == 2 || manager_id1 == 3) {
										System.out.println("sltl");
										response.sendRedirect("sltlAdmin.jsp");
									} else if (manager_id1 == 4 || manager_id1 == 117 || under_manager_id == 4 || under_manager_id == 117) {
										response.sendRedirect("hrHome.jsp");
										System.out.println("hr");
									} else {
										System.out.println("manager");
										response.sendRedirect("managerHome.jsp");

									}
								} else {
									if (under_manager_id == 4 || under_manager_id == 117) {
										response.sendRedirect("hrHome.jsp");
										System.out.println("hr");
									} else {
										response.sendRedirect("empHome.jsp");
										System.out.println("emp");
									}
								}

							}

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
