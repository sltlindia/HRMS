package com.hrms.recruitement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.hrms.recruitement.bean.BenefitsBean;
import com.hrms.recruitement.bean.CityBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.InterviewedByBean;
import com.hrms.recruitement.bean.InterviewerPanelBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.PostGraduateQualificationBean;
import com.hrms.recruitement.bean.PostGraduateSpecificationBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.StateBean;
import com.hrms.recruitement.bean.UnderGraduateQualificationBean;
import com.hrms.recruitement.bean.UnderGraduateSpecificationBean;
import com.hrms.recruitement.bean.VacancyAllocationBean;
import com.hrms.recruitement.bean.VacancyApprovalBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;
import com.hrms.recruitement.dao.DepartmentDAO;
import com.hrms.recruitement.dao.VacancyFormDAO;

public class VacancyFormInsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {

			String filePath = getServletContext().getInitParameter("file-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String title_of_position = null;
			int no_of_vacancy = 0;
			int job_location_id = 0;
			String tentative_joining_date = null;
			int department_id = 0;
			int manager_id = 0;
			int reportingManager = 0;
			int employee_id = 0;
			String required_experience = null;
			String salary_range = null;
			String skillAndCompetencies = "";
			int v_id = 0;
			String approved_status = "pending";
			String bill_limit = null;
			String submission_date = null;
			String reason_for_hire = null;
			String vacancy_type = null;
			String replacement_of = null;
			String hr = null;
			String approval_status = "pending";
			String approval_datetime = null;
			String role_objective = null;
			String span_of_control = null;
			String role_description = null;
			String internal_operating_network = null;
			String external_operating_network = null;
			String personal_competencies = null;
			String key_performance_indicator = null;
			String value5 = null;
			int hr_id = 8;
			String country = null;
			int state_id = 0;
			int city_id = 0;
			int under_graduate_qualification_id = 0;
			int under_graduate_specification_id = 0;
			int post_graduate_qualification_id = 0;
			int post_graduate_specification_id = 0;
			int show_view = 0;
			String company_branch = null;
			String key_skills = null;

			int benefits = 0;
			JobLocationBean jobLocationBean = new JobLocationBean();
			DepartmentBean departmentBean = new DepartmentBean();
			VacancyFormBean vacancyFormBean = new VacancyFormBean();
			BenefitsBean benefitsBean = new BenefitsBean();
			ManagerBean managerBean = new ManagerBean();
			EmployeeBean employeeBean = new EmployeeBean();

			VacancyFormBean vacancyFormBean2 = new VacancyFormBean();
			EmployeeBean employeeBean2 = new EmployeeBean();
			VacancyFormDAO vacancyFormDAO = new VacancyFormDAO();
			StateBean stateBean = new StateBean();
			CityBean cityBean = new CityBean();
			UnderGraduateQualificationBean underGraduateQualificationBean = new UnderGraduateQualificationBean();
			UnderGraduateSpecificationBean underGraduateSpecificationBean = new UnderGraduateSpecificationBean();
			PostGraduateQualificationBean postGraduateQualificationBean = new PostGraduateQualificationBean();
			PostGraduateSpecificationBean postGraduateSpecificationBean = new PostGraduateSpecificationBean();

			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);

					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();

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
							reportingManager = Integer.parseInt(value);
							System.out.println("reportingManqager:" + reportingManager);
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
						
						
						if (fieldName.equalsIgnoreCase("companyLocation")) {
							company_branch = fieldValue;
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
						
						if (fieldName.equalsIgnoreCase("keySkills")) {
							key_skills = fieldValue;
							System.out.println("key_skills :" + key_skills);
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

						if (fieldName.equalsIgnoreCase("hr")) {
							hr = fieldValue;
							System.out.println("hr :" + hr);
						}

						if (fieldName.equalsIgnoreCase("submission_date")) {
							submission_date = fieldValue;
							System.out.println("submission_date:" + submission_date);
						}

						if (fieldName.equalsIgnoreCase("keyPerformanceIndicator")) {
							key_performance_indicator = fieldValue;
							System.out.println("keyPerformanceIndicator :" + key_performance_indicator);
						}

						if (fieldName.equalsIgnoreCase("insert")) {
							String value = fieldValue;
							System.out.println("insert:" + value);

							jobLocationBean.setJob_location_id(job_location_id);
							departmentBean.setDepartment_id(department_id);
							managerBean.setManager_id(manager_id);
							employeeBean.setEmployee_master_id(employee_id);
							stateBean.setState_id(state_id);
							cityBean.setCity_id(city_id);
							underGraduateQualificationBean
									.setUnder_graduate_qualification_id(under_graduate_qualification_id);
							underGraduateSpecificationBean
									.setUnder_graduate_specification_id(under_graduate_specification_id);
							postGraduateQualificationBean
									.setPost_graduate_qualification_id(post_graduate_qualification_id);
							postGraduateSpecificationBean
									.setPost_graduate_specification_id(post_graduate_specification_id);

							vacancyFormBean = new VacancyFormBean(no_of_vacancy, reportingManager,
									tentative_joining_date, required_experience, salary_range, skillAndCompetencies,
									approved_status, submission_date, reason_for_hire, vacancy_type, replacement_of,
									title_of_position, role_objective, span_of_control, internal_operating_network,
									external_operating_network, personal_competencies, key_performance_indicator,
									bill_limit, departmentBean, managerBean, employeeBean, stateBean, cityBean,
									underGraduateQualificationBean, underGraduateSpecificationBean,
									postGraduateQualificationBean, postGraduateSpecificationBean, country,
									role_description, company_branch, key_skills);

							boolean result = vacancyFormDAO.vacancyInsert(vacancyFormBean);

							if (result == true) {
								System.out.println("Successful");
								v_id = vacancyFormBean.getVacancy_id();
								vacancyFormBean.setVacancy_id(v_id);
								System.out.println(v_id);
							}

						}
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
							EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName,lastName);

							int emp_id = employeeBean1.getEmployee_master_id();

							System.out.println("emp_id:" + emp_id);

							AllInsertDAO allInsertDAO = new AllInsertDAO();
							boolean result1 = allInsertDAO.interviewedbyInsert(v_id, emp_id);
						}
					}

					if (fieldName.equalsIgnoreCase("benefits")) {
						String value1 = fieldValue;
						benefits = Integer.parseInt(value1);
						System.out.println("benefits: " + benefits);
						vacancyFormBean.setVacancy_id(v_id);
						System.out.println("Vacancy Id " + v_id);
						benefitsBean.setBenefit_id(benefits);
						System.out.println("benefits");

						VacancyBenefitsBean vacancyBenefitsBean = new VacancyBenefitsBean(vacancyFormBean,
								benefitsBean);

						boolean result1 = vacancyFormDAO.vacancyBenefits(vacancyBenefitsBean);
					}

					if (fieldName.equalsIgnoreCase("billLimit")) {
						bill_limit = fieldValue;
						System.out.println("billLimit:" + bill_limit);
						boolean result2 = vacancyFormDAO.vacancyUpdateBillLimit(bill_limit, v_id);
					}

					if (fieldName.equalsIgnoreCase("vacancyApproval")) 
					{
						int hr_number = 2;
						int hod = 0;
						
						
						/*int arvind_sir = 5;
						int maulik_sir = 6;
						int mayank_sir = 7;
						int dinesh_sir = 975;
						int top_management =1;*/

						AllInsertDAO allInsertDAO = new AllInsertDAO();
						vacancyFormBean2.setVacancy_id(v_id);
						int manager = Integer.parseInt(user.getUnder_manager_id());
						LoginDAO loginDAO = new LoginDAO();
						EmployeeBean employeeBean5 = loginDAO.getUserByManagerId(manager);
						int e_id = employeeBean5.getEmployee_master_id();
						System.out.println("e_id " + e_id);
						employeeBean5.setEmployee_master_id(e_id);
						
						int UnderID = Integer.parseInt(employeeBean5.getUnder_manager_id());
						EmployeeBean employeeBean6 = loginDAO.getUserByManagerId(UnderID);
						System.out.println(" first name " +employeeBean6.getFirstname());
						//System.out.println("under_manager :"+ manager + employeeBean5.getEmployee_master_id());
						
						VacancyApprovalBean vacancyApprovalBean2 = new VacancyApprovalBean(vacancyFormBean2,
								employeeBean5, approval_datetime, approval_status, hod, show_view);
						boolean result4 = allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean2);
						System.out.println("resul4"+result4);
						
						employeeBean2.setEmployee_master_id(hr_id);
					
						VacancyApprovalBean vacancyApprovalBean = new VacancyApprovalBean(vacancyFormBean2,
								employeeBean2, approval_datetime, approval_status, hr_number, show_view);

						
						boolean result3 = allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean);
						//int maulik_sir = 6;
						//EmployeeBean e = new EmployeeBean();
						/*e.setEmployee_master_id(maulik_sir);
						employeeBean5.setEmployee_master_id(maulik_sir);
						
						VacancyApprovalBean vacancyApprovalBean3 = new VacancyApprovalBean(vacancyFormBean2,
								e, approval_datetime, approval_status, hod, show_view);
						boolean result5 = allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean2);
						*/
						
						
						System.out.println("ID " + manager);
						

						//EmployeeBean employeeBean4 = new EmployeeBean();

						/*if (department_id == 1 || department_id == 6 || department_id == 7 || department_id == 8
								|| department_id == 10 || department_id == 11) {
							employeeBean4.setEmployee_master_id(arvind_sir);
							if(e_id != 5){
							VacancyApprovalBean vacancyApprovalBean3 = new VacancyApprovalBean(vacancyFormBean2,
									employeeBean4, approval_datetime, approval_status, top_management, show_view);
							//boolean result = allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean3);
						}

						} else if (department_id == 9 || department_id == 32) {
							employeeBean4.setEmployee_master_id(mayank_sir);
							if(e_id != 7){
							VacancyApprovalBean vacancyApprovalBean3 = new VacancyApprovalBean(vacancyFormBean2,
									employeeBean4, approval_datetime, approval_status, top_management, show_view);
							//boolean result = allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean3);
							}

						} else if (department_id == 35 || department_id == 36 || department_id == 37
								|| department_id == 19 || department_id == 28) {
							employeeBean4.setEmployee_master_id(dinesh_sir);
							if(e_id != 975){
							VacancyApprovalBean vacancyApprovalBean3 = new VacancyApprovalBean(vacancyFormBean2,
									employeeBean4, approval_datetime, approval_status, top_management, show_view);
							//boolean result = allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean3);
							}

						} else {
							if(e_id != 6){
							employeeBean4.setEmployee_master_id(maulik_sir);
							VacancyApprovalBean vacancyApprovalBean3 = new VacancyApprovalBean(vacancyFormBean2,
									employeeBean4, approval_datetime, approval_status, top_management, show_view);
							//boolean result = allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean3);
							}
						}*/
					}
					/*
					 * if (fieldName.equalsIgnoreCase("approval")) { String
					 * value1 = fieldValue; int sky = Integer.parseInt(value1);
					 * employeeBean2.setEmployee_master_id(Integer.parseInt(
					 * value1)); vacancyFormBean2.setVacancy_id(v_id);
					 * VacancyApprovalBean vacancyApprovalBean = new
					 * VacancyApprovalBean(vacancyFormBean2, employeeBean2,
					 * approval_datetime, approval_status);
					 * AllRecruitmentListDAO allRecruitmentListDAO = new
					 * AllRecruitmentListDAO(); List<VacancyApprovalBean>
					 * uniqueInsert = (ArrayList<VacancyApprovalBean>)
					 * allRecruitmentListDAO .getListForUniqueInsert(); int
					 * vacancy_id = 0, employee_master_id = 0; for
					 * (VacancyApprovalBean vacancyApprovalBean2 : uniqueInsert)
					 * { vacancy_id =
					 * vacancyApprovalBean2.getVacancyFormBean().getVacancy_id()
					 * ; employee_master_id =
					 * vacancyApprovalBean2.getEmployeeBean().
					 * getEmployee_master_id();
					 * System.out.println("vacancy_id :" + vacancy_id +
					 * "employee_id" + employee_master_id); }
					 * 
					 * System.err.println("VC ID" + vacancy_id + " " + v_id +
					 * "EMP " + employee_master_id + " " + sky);
					 * 
					 * 
					 * if((vacancy_id == v_id) && (employee_master_id == sky)) {
					 * System.out.println("nai thay insert");
					 * 
					 * 
					 * }
					 * 
					 * 
					 * AllInsertDAO allInsertDAO = new AllInsertDAO(); boolean
					 * result3 =
					 * allInsertDAO.vacancyApprovalInsert(vacancyApprovalBean);
					 * 
					 * System.out.println("reqSkill:" + value1); }
					 */

					
					
					
					if (fieldName.equalsIgnoreCase("demo"))
					{
						
						int e = 6;
						AllInsertDAO allInsertDAO = new AllInsertDAO();
						boolean result1 = allInsertDAO.interviewedbyInsert(v_id, e);
						
						String arrayEmail[] = {"sachin.patel121995@gmail.com" , "er01021995@gmail.com"};
						String title = title_of_position;
						String department_name = null;
						DepartmentDAO departmentDAO = new DepartmentDAO();
						List<DepartmentBean> listOfDepartment = departmentDAO.getListOfDepartmentById(department_id);
						for(DepartmentBean departmentBean2 : listOfDepartment)
						{
							department_name = departmentBean2.getDepartment_name();
						}
						String dept = department_name;
						
						new Thread(new Runnable() {
						    @Override
						    public void run() {
						    	
						    	
						    	String sub = " Vacancy Notification";
						    	String desc = "Vacancy for the position "+title;
						    	String desc1 = "is created by "+user.getFirstname()+" "+user.getLastname() +" for "+dept+" Department.";
						    	String desc3 = "You can Hold or Suggest changes in vacancy "+title+" for that kindly login to SLTL HRMS.";
						    	Mailer.send2(sub, desc , desc1, desc3 ,arrayEmail);
						    	
						    }
						}).start();
						
						
						AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
						List<ResumeDataBean> searchengine = AllRecruitmentListDAO.getListOfResumeDataSearchEngine(key_skills);
						request.setAttribute("searchengine", searchengine);
						request.setAttribute("skill", key_skills);
						request.setAttribute("vacancy_id", v_id);
						
						request.getRequestDispatcher("resumeDataSearchEngineWithData.jsp").forward(request, response);
						
						/*session.setAttribute("v_id", v_id);
						if (hr.equalsIgnoreCase("12")) {
							request.setAttribute("success", "Your Vacancy Successfully Submitted...");
							request.getRequestDispatcher("vacancylist.jsp").forward(request, response);
						} else {
							request.setAttribute("success", "Your Vacancy Successfully Submitted...");
							request.getRequestDispatcher("vacancyListForManager.jsp").forward(request, response);
						}*/
					}

					
					
				}

			} catch (Exception E) {

			}

		}

	}
}