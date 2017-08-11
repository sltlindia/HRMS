package com.hrms.recruitement.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.dao.LoginDAO;
import com.hrms.recruitement.dao.VacancyFormDAO;
import java.io.Serializable;

@Entity
@Table(name = "resume_data_tbl")
public class ResumeDataBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private int resume_data_id;
	private String name;
	private String gender;
	private String date_of_birth;
	private String residing_country;
	private String current_location;
	private String current_contact_no;
	private String email;
	private String educational_qualification;
	private String specialization;
	private String experience;
	private String current_company_name;
	private String functional_area_applying_for;
	private String role_as;
	private String current_functional_area;
	private String current_role;
	private String key_skills;
	private String upload_resume;
	private String status;
	private String ex_employee;
	private int employee_code;
	private int expected_salary;
	private String current_salary;
	private String notice_period;
	private String submission_date;
	private String reply_date;
	private String speciality;
	private String graduate_qualification;
	private String post_graduate_qualification;
	private String phd_qualification;

	
	private VacancyFormBean vacancyFormBean;
	private SourceOfResumeBean sourceOfResumeBean;
	private EmployeeBean employeeBean;
	

	public ResumeDataBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ResumeDataBean(String name, String gender, String date_of_birth, String residing_country,
			String current_location, String current_contact_no, String email, String educational_qualification,
			String specialization, String experience, String current_company_name, String functional_area_applying_for,
			String role_as, String current_functional_area, String current_role, String key_skills,String status,
			String upload_resume, VacancyFormBean vacancyFormBean,String ex_employee,int employee_code,
			int expected_salary,String current_salary, String notice_period,String submission_date,
			String speciality,SourceOfResumeBean sourceOfResumeBean,EmployeeBean employeeBean,String graduate_qualification,String post_graduate_qualification,String phd_qualification)
	{
		//super();
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.residing_country = residing_country;
		this.current_location = current_location;
		this.current_contact_no = current_contact_no;
		this.email = email;
		this.educational_qualification = educational_qualification;
		this.specialization = specialization;
		this.experience = experience;
		this.current_company_name = current_company_name;
		this.functional_area_applying_for = functional_area_applying_for;
		this.role_as = role_as;
		this.current_functional_area = current_functional_area;
		this.current_role = current_role;
		this.key_skills = key_skills;
		this.status = status;
		this.upload_resume = upload_resume;
		this.vacancyFormBean = vacancyFormBean;
		this.ex_employee = ex_employee;
		this.employee_code = employee_code;
		this.expected_salary = expected_salary;
		this.current_salary = current_salary;
		this.notice_period = notice_period;
		this.submission_date = submission_date;
		this.speciality = speciality;
		this.sourceOfResumeBean = sourceOfResumeBean;
		this.employeeBean = employeeBean;
		this.graduate_qualification = graduate_qualification;
		this.post_graduate_qualification = post_graduate_qualification;
		this.phd_qualification = phd_qualification;
	}
	
	@Id
	@Column(name = "resume_data_id")
	@GeneratedValue
	public int getResume_data_id() {
		return resume_data_id;
	}
	public void setResume_data_id(int resume_data_id) {
		this.resume_data_id = resume_data_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getResiding_country() {
		return residing_country;
	}
	public void setResiding_country(String residing_country) {
		this.residing_country = residing_country;
	}
	public String getCurrent_location() {
		return current_location;
	}
	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}
	public String getCurrent_contact_no() {
		return current_contact_no;
	}
	public void setCurrent_contact_no(String current_contact_no) {
		this.current_contact_no = current_contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEducational_qualification() {
		return educational_qualification;
	}
	public void setEducational_qualification(String educational_qualification) {
		this.educational_qualification = educational_qualification;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getCurrent_company_name() {
		return current_company_name;
	}
	public void setCurrent_company_name(String current_company_name) {
		this.current_company_name = current_company_name;
	}
	public String getFunctional_area_applying_for() {
		return functional_area_applying_for;
	}
	public void setFunctional_area_applying_for(String functional_area_applying_for) {
		this.functional_area_applying_for = functional_area_applying_for;
	}
	public String getRole_as() {
		return role_as;
	}
	public void setRole_as(String role_as) {
		this.role_as = role_as;
	}
	public String getCurrent_functional_area() {
		return current_functional_area;
	}
	public void setCurrent_functional_area(String current_functional_area) {
		this.current_functional_area = current_functional_area;
	}
	public String getCurrent_role() {
		return current_role;
	}
	public void setCurrent_role(String current_role) {
		this.current_role = current_role;
	}
	
	public String getKey_skills() {
		return key_skills;
	}

	public void setKey_skills(String key_skills) {
		this.key_skills = key_skills;
	}

	public String getStatus() {
		return status;
	}

	public String getEx_employee() {
		return ex_employee;
	}

	public void setEx_employee(String ex_employee) {
		this.ex_employee = ex_employee;
	}

	public int getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(int employee_code) {
		this.employee_code = employee_code;
	}

	public int getExpected_salary() {
		return expected_salary;
	}

	public void setExpected_salary(int expected_salary) {
		this.expected_salary = expected_salary;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpload_resume() {
		return upload_resume;
	}

	public void setUpload_resume(String upload_resume) {
		this.upload_resume = upload_resume;
	}
	
	@ManyToOne
	@JoinColumn(name = "vacancy_id")
	public VacancyFormBean getVacancyFormBean() {
		return vacancyFormBean;
	}

	public void setVacancyFormBean(VacancyFormBean vacancyFormBean) {
		this.vacancyFormBean = vacancyFormBean;
	}

	@ManyToOne
	@JoinColumn(name = "source_of_resume_id")
	public SourceOfResumeBean getSourceOfResumeBean() {
		return sourceOfResumeBean;
	}

	public void setSourceOfResumeBean(SourceOfResumeBean sourceOfResumeBean) {
		this.sourceOfResumeBean = sourceOfResumeBean;
	}

	

	public String getCurrent_salary() {
		return current_salary;
	}

	public void setCurrent_salary(String current_salary) {
		this.current_salary = current_salary;
	}

	public String getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(String notice_period) {
		this.notice_period = notice_period;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	public String getReply_date() {
		return reply_date;
	}

	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	@ManyToOne
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getGraduate_qualification() {
		return graduate_qualification;
	}

	public void setGraduate_qualification(String graduate_qualification) {
		this.graduate_qualification = graduate_qualification;
	}

	public String getPost_graduate_qualification() {
		return post_graduate_qualification;
	}

	public void setPost_graduate_qualification(String post_graduate_qualification) {
		this.post_graduate_qualification = post_graduate_qualification;
	}

	public String getPhd_qualification() {
		return phd_qualification;
	}

	public void setPhd_qualification(String phd_qualification) {
		this.phd_qualification = phd_qualification;
	}
	
	

	
}
