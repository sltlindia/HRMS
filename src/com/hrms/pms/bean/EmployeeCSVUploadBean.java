package com.hrms.pms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.recruitement.bean.CompanyListBean;
@Entity
@Table(name="employee_master_tbl")
public class EmployeeCSVUploadBean {
	
	
	 private int employee_master_id;
	    private String employee_code;
	    private String password;
	    private String firstname;
	    private String lastname;
	    private String middlename;
	    private int under_manager_id;
	    private String email_id;
	    private String resource_cost;
	    private String photo;
	    private String joining_date;
	    private String languages;
		private String sub_department;
		private String gross_salary;
		private String blood_group;
		private String height;
		private String weight;
		private String identification_marks;
		private String digital_sign;
		private String location;
		private String mob_num;
		private String nationality;
		private String basic_qualification;
		private String special_qualification;
	    private String marital_status;
	    private String gender;
	    private String salutation;
	    private String address;
	    private String birth_date;
	    
	    private RoleBean roleBean;
	    private DepartmentBean departmentBean;
	    private ManagerBean managerBean;
	    private CompanyListBean companyListBean;
	    private EmployeeStatusBean employeeStatusBean;

		public EmployeeCSVUploadBean() {
			super();
		}

		public EmployeeCSVUploadBean(String employee_code, String password, String firstname, String lastname,
				String middlename, int under_manager_id, String email_id, String resource_cost, String photo,
				String joining_date, String languages, String sub_department, String gross_salary, String blood_group,
				String height, String weight, String identification_marks, String digital_sign, String location,
				String mob_num, String nationality, String basic_qualification, String special_qualification,
				String marital_status, String gender, String salutation, String address, String birth_date,
				RoleBean roleBean, DepartmentBean departmentBean, ManagerBean managerBean,
				CompanyListBean companyListBean, EmployeeStatusBean employeeStatusBean) {
			super();
			this.employee_code = employee_code;
			this.password = password;
			this.firstname = firstname;
			this.lastname = lastname;
			this.middlename = middlename;
			this.under_manager_id = under_manager_id;
			this.email_id = email_id;
			this.resource_cost = resource_cost;
			this.photo = photo;
			this.joining_date = joining_date;
			this.languages = languages;
			this.sub_department = sub_department;
			this.gross_salary = gross_salary;
			this.blood_group = blood_group;
			this.height = height;
			this.weight = weight;
			this.identification_marks = identification_marks;
			this.digital_sign = digital_sign;
			this.location = location;
			this.mob_num = mob_num;
			this.nationality = nationality;
			this.basic_qualification = basic_qualification;
			this.special_qualification = special_qualification;
			this.marital_status = marital_status;
			this.gender = gender;
			this.salutation = salutation;
			this.address = address;
			this.birth_date = birth_date;
			this.roleBean = roleBean;
			this.departmentBean = departmentBean;
			this.managerBean = managerBean;
			this.companyListBean = companyListBean;
			this.employeeStatusBean = employeeStatusBean;
		}
		 @Id 
		    @Column(name="employee_master_id")
		    @GeneratedValue
		public int getEmployee_master_id() {
			return employee_master_id;
		}

		public void setEmployee_master_id(int employee_master_id) {
			this.employee_master_id = employee_master_id;
		}
		@Column(name="employee_code")
		public String getEmployee_code() {
			return employee_code;
		}

		public void setEmployee_code(String employee_code) {
			this.employee_code = employee_code;
		}

		@Column(name="password")
		public String getPassword() {
			return password;
		}

	
		public void setPassword(String password) {
			this.password = password;
		}
		@Column(name="firstname")
		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		@Column(name="lastname")
		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		@Column(name="middlename")
		public String getMiddlename() {
			return middlename;
		}

		public void setMiddlename(String middlename) {
			this.middlename = middlename;
		}
		@Column(name="under_manager_id")
		public int getUnder_manager_id() {
			return under_manager_id;
		}

		public void setUnder_manager_id(int under_manager_id) {
			this.under_manager_id = under_manager_id;
		}

		@Column(name="email_id")
		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		@Column(name="resource_cost")
		public String getResource_cost() {
			return resource_cost;
		}

		public void setResource_cost(String resource_cost) {
			this.resource_cost = resource_cost;
		}
		@Column(name="photo")
		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}
		@Column(name="joining_date")
		public String getJoining_date() {
			return joining_date;
		}

		public void setJoining_date(String joining_date) {
			this.joining_date = joining_date;
		}
		@Column(name="languages")
		public String getLanguages() {
			return languages;
		}

		public void setLanguages(String languages) {
			this.languages = languages;
		}
		@Column(name="sub_department")
		public String getSub_department() {
			return sub_department;
		}

		public void setSub_department(String sub_department) {
			this.sub_department = sub_department;
		}
		@Column(name="gross_salary")
		public String getGross_salary() {
			return gross_salary;
		}

		public void setGross_salary(String gross_salary) {
			this.gross_salary = gross_salary;
		}
		@Column(name="blood_group")
		public String getBlood_group() {
			return blood_group;
		}

		public void setBlood_group(String blood_group) {
			this.blood_group = blood_group;
		}
		@Column(name="height")
		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}
		@Column(name="weight")
		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}
		@Column(name="identification_marks")
		public String getIdentification_marks() {
			return identification_marks;
		}

		public void setIdentification_marks(String identification_marks) {
			this.identification_marks = identification_marks;
		}
		@Column(name="digital_sign")
		public String getDigital_sign() {
			return digital_sign;
		}

		public void setDigital_sign(String digital_sign) {
			this.digital_sign = digital_sign;
		}
		@Column(name="location")
		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
		@Column(name="mob_num")
		public String getMob_num() {
			return mob_num;
		}

		public void setMob_num(String mob_num) {
			this.mob_num = mob_num;
		}
		@Column(name="nationality")
		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		@Column(name="basic_qualification")
		public String getBasic_qualification() {
			return basic_qualification;
		}

		public void setBasic_qualification(String basic_qualification) {
			this.basic_qualification = basic_qualification;
		}
		@Column(name="special_qualification")
		public String getSpecial_qualification() {
			return special_qualification;
		}

		public void setSpecial_qualification(String special_qualification) {
			this.special_qualification = special_qualification;
		}
		@Column(name="marital_status")
		public String getMarital_status() {
			return marital_status;
		}

		public void setMarital_status(String marital_status) {
			this.marital_status = marital_status;
		}
		@Column(name="gender")
		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		@Column(name="salutation")
		public String getSalutation() {
			return salutation;
		}

		public void setSalutation(String salutation) {
			this.salutation = salutation;
		}
		@Column(name="address")
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		@Column(name="birth_date")
		public String getBirth_date() {
			return birth_date;
		}

		public void setBirth_date(String birth_date) {
			this.birth_date = birth_date;
		}
		@ManyToOne
		@JoinColumn(name="role_id")
		public RoleBean getRoleBean() {
			return roleBean;
		}

		public void setRoleBean(RoleBean roleBean) {
			this.roleBean = roleBean;
		}
		@ManyToOne
		@JoinColumn(name="department_id")
		public DepartmentBean getDepartmentBean() {
			return departmentBean;
		}

		public void setDepartmentBean(DepartmentBean departmentBean) {
			this.departmentBean = departmentBean;
		}
		@ManyToOne
		@JoinColumn(name="manager_id")
		public ManagerBean getManagerBean() {
			return managerBean;
		}

		public void setManagerBean(ManagerBean managerBean) {
			this.managerBean = managerBean;
		}
		@ManyToOne
		@JoinColumn(name="company_list_id")
		public CompanyListBean getCompanyListBean() {
			return companyListBean;
		}

		public void setCompanyListBean(CompanyListBean companyListBean) {
			this.companyListBean = companyListBean;
		}
		@ManyToOne
		@JoinColumn(name="employee_status_id")
		public EmployeeStatusBean getEmployeeStatusBean() {
			return employeeStatusBean;
		}

		public void setEmployeeStatusBean(EmployeeStatusBean employeeStatusBean) {
			this.employeeStatusBean = employeeStatusBean;
		}
	    
	    
}
