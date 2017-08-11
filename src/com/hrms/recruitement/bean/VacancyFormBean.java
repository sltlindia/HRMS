package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;

import java.io.Serializable;

@Entity
@Table(name = "vacancy_tbl")
public class VacancyFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int vacancy_id;
	private int no_of_vacancy;
	private int reporting_manager;
	private String tentative_joining_date;
	private String required_experience;
	private String payment_type;
	private String salary_range;
	private String vacancy_period;

	/* private String interviewed_by; */

	private String skillandcompetencies;
	private String approved_status;
	private String submission_date;
	private String reason_for_hire;
	private String vacancy_type;
	private String replacement_of;
	private String title_of_position;
	private String role_objective;
	private String role_description;
	private String span_of_control;
	private String internal_operating_network;
	private String external_operating_network;
	private String personal_competencies;
	private String key_performance_indicator;
	private String bill_limit;
	private String country;

	private DepartmentBean departmentBean;
	private ManagerBean managerBean;
	private EmployeeBean employeeBean;
	private StateBean stateBean;
	private CityBean cityBean;
	private UnderGraduateQualificationBean underGraduateQualificationBean;
	private UnderGraduateSpecificationBean underGraduateSpecificationBean;
	private PostGraduateQualificationBean postGraduateQualificationBean;
	private PostGraduateSpecificationBean postGraduateSpecificationBean;

	/*
	 * private InterviewedByBean interviewedByBean; private InterviewerPanelBean
	 * interviewerPanelBean;
	 */

	public VacancyFormBean() {
	}

	public VacancyFormBean(int no_of_vacancy, int reporting_manager, String tentative_joining_date,
			String required_experience, String salary_range, String skillandcompetencies,
			String approved_status, String submission_date, String reason_for_hire, String vacancy_type,
			String replacement_of, String title_of_position, String role_objective, String span_of_control,
			String internal_operating_network, String external_operating_network, String personal_competencies,
			String key_performance_indicator, String bill_limit, DepartmentBean departmentBean, ManagerBean managerBean,
			EmployeeBean employeeBean, StateBean stateBean,
			CityBean cityBean, UnderGraduateQualificationBean underGraduateQualificationBean,
			UnderGraduateSpecificationBean underGraduateSpecificationBean,
			PostGraduateQualificationBean postGraduateQualificationBean,
			PostGraduateSpecificationBean postGraduateSpecificationBean, String country, String role_description) {

		this.no_of_vacancy = no_of_vacancy;
		this.reporting_manager = reporting_manager;
		this.tentative_joining_date = tentative_joining_date;
		this.required_experience = required_experience;
		this.salary_range = salary_range;
		this.skillandcompetencies = skillandcompetencies;
		this.approved_status = approved_status;
		this.submission_date = submission_date;
		this.reason_for_hire = reason_for_hire;
		this.vacancy_type = vacancy_type;
		this.replacement_of = replacement_of;
		this.title_of_position = title_of_position;
		this.role_objective = role_objective;
		this.span_of_control = span_of_control;
		this.internal_operating_network = internal_operating_network;
		this.external_operating_network = external_operating_network;
		this.personal_competencies = personal_competencies;
		this.key_performance_indicator = key_performance_indicator;
		this.bill_limit = bill_limit;
		this.departmentBean = departmentBean;
		this.managerBean = managerBean;
		this.employeeBean = employeeBean;
		this.stateBean = stateBean;
		this.cityBean = cityBean;
		this.underGraduateQualificationBean = underGraduateQualificationBean;
		this.underGraduateSpecificationBean = underGraduateSpecificationBean;
		this.postGraduateQualificationBean = postGraduateQualificationBean;
		this.postGraduateSpecificationBean = postGraduateSpecificationBean;
		this.country = country;
		this.role_description = role_description;
	}

	public VacancyFormBean(int no_of_vacancy, String salary_range, String reason, String approved_status,
			int vacancy_id, EmployeeBean employeeBean) {
		this.no_of_vacancy = no_of_vacancy;
		this.salary_range = salary_range;
		this.approved_status = approved_status;
		this.vacancy_id = vacancy_id;
		this.employeeBean = employeeBean;
	}

	@Id
	@Column(name = "vacancy_id")
	@GeneratedValue
	public int getVacancy_id() {
		return vacancy_id;
	}

	public void setVacancy_id(int vacancy_id) {
		this.vacancy_id = vacancy_id;
	}

	public int getNo_of_vacancy() {
		return no_of_vacancy;
	}

	public void setNo_of_vacancy(int no_of_vacancy) {
		this.no_of_vacancy = no_of_vacancy;
	}


	public String getTentative_joining_date() {
		return tentative_joining_date;
	}

	public void setTentative_joining_date(String tentative_joining_date) {
		this.tentative_joining_date = tentative_joining_date;
	}

	@ManyToOne
	@JoinColumn(name = "department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}

	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}


	public String getRequired_experience() {
		return required_experience;
	}

	public void setRequired_experience(String required_experience) {
		this.required_experience = required_experience;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getSalary_range() {
		return salary_range;
	}

	public void setSalary_range(String salary_range) {
		this.salary_range = salary_range;
	}


	public String getVacancy_period() {
		return vacancy_period;
	}

	public void setVacancy_period(String vacancy_period) {
		this.vacancy_period = vacancy_period;
	}

	public String getApproved_status() {
		return approved_status;
	}

	public void setApproved_status(String approved_status) {
		this.approved_status = approved_status;
	}

	public String getSkillandcompetencies() {
		return skillandcompetencies;
	}

	public void setSkillandcompetencies(String skillandcompetencies) {
		this.skillandcompetencies = skillandcompetencies;
	}

	@ManyToOne
	@JoinColumn(name = "manager_id")
	public ManagerBean getManagerBean() {
		return managerBean;
	}

	public void setManagerBean(ManagerBean managerBean) {
		this.managerBean = managerBean;
	}

	@ManyToOne
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	public int getReporting_manager() {
		return reporting_manager;
	}

	public void setReporting_manager(int reporting_manager) {
		this.reporting_manager = reporting_manager;
	}

	public String getReason_for_hire() {
		return reason_for_hire;
	}

	public void setReason_for_hire(String reason_for_hire) {
		this.reason_for_hire = reason_for_hire;
	}

	public String getVacancy_type() {
		return vacancy_type;
	}

	public void setVacancy_type(String vacancy_type) {
		this.vacancy_type = vacancy_type;
	}

	public String getReplacement_of() {
		return replacement_of;
	}

	public void setReplacement_of(String replacement_of) {
		this.replacement_of = replacement_of;
	}

	public String getTitle_of_position() {
		return title_of_position;
	}

	public void setTitle_of_position(String title_of_position) {
		this.title_of_position = title_of_position;
	}

	public String getRole_objective() {
		return role_objective;
	}

	public void setRole_objective(String role_objective) {
		this.role_objective = role_objective;
	}

	public String getSpan_of_control() {
		return span_of_control;
	}

	public void setSpan_of_control(String span_of_control) {
		this.span_of_control = span_of_control;
	}

	public String getInternal_operating_network() {
		return internal_operating_network;
	}

	public void setInternal_operating_network(String internal_operating_network) {
		this.internal_operating_network = internal_operating_network;
	}

	public String getExternal_operating_network() {
		return external_operating_network;
	}

	public void setExternal_operating_network(String external_operating_network) {
		this.external_operating_network = external_operating_network;
	}

	public String getPersonal_competencies() {
		return personal_competencies;
	}

	public void setPersonal_competencies(String personal_competencies) {
		this.personal_competencies = personal_competencies;
	}

	public String getKey_performance_indicator() {
		return key_performance_indicator;
	}

	public void setKey_performance_indicator(String key_performance_indicator) {
		this.key_performance_indicator = key_performance_indicator;
	}

	public String getBill_limit() {
		return bill_limit;
	}

	public void setBill_limit(String bill_limit) {
		this.bill_limit = bill_limit;
	}

	@ManyToOne
	@JoinColumn(name = "state_id")
	public StateBean getStateBean() {
		return stateBean;
	}

	public void setStateBean(StateBean stateBean) {
		this.stateBean = stateBean;
	}

	@ManyToOne
	@JoinColumn(name = "city_id")
	public CityBean getCityBean() {
		return cityBean;
	}

	public void setCityBean(CityBean cityBean) {
		this.cityBean = cityBean;
	}

	@ManyToOne
	@JoinColumn(name = "under_graduate_qualification_id")
	public UnderGraduateQualificationBean getUnderGraduateQualificationBean() {
		return underGraduateQualificationBean;
	}

	public void setUnderGraduateQualificationBean(UnderGraduateQualificationBean underGraduateQualificationBean) {
		this.underGraduateQualificationBean = underGraduateQualificationBean;
	}

	@ManyToOne
	@JoinColumn(name = "under_graduate_specification_id")
	public UnderGraduateSpecificationBean getUnderGraduateSpecificationBean() {
		return underGraduateSpecificationBean;
	}

	public void setUnderGraduateSpecificationBean(UnderGraduateSpecificationBean underGraduateSpecificationBean) {
		this.underGraduateSpecificationBean = underGraduateSpecificationBean;
	}

	@ManyToOne
	@JoinColumn(name = "post_graduate_qualification_id")
	public PostGraduateQualificationBean getPostGraduateQualificationBean() {
		return postGraduateQualificationBean;
	}

	public void setPostGraduateQualificationBean(PostGraduateQualificationBean postGraduateQualificationBean) {
		this.postGraduateQualificationBean = postGraduateQualificationBean;
	}

	@ManyToOne
	@JoinColumn(name = "post_graduate_specification_id")
	public PostGraduateSpecificationBean getPostGraduateSpecificationBean() {
		return postGraduateSpecificationBean;
	}

	public void setPostGraduateSpecificationBean(PostGraduateSpecificationBean postGraduateSpecificationBean) {
		this.postGraduateSpecificationBean = postGraduateSpecificationBean;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	
	

}