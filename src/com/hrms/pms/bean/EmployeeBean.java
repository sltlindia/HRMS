package com.hrms.pms.bean;

import java.io.Serializable;

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
public class EmployeeBean implements Serializable {
    
    
    private int employee_master_id;
    private int employee_code;
    private String password;
    private String firstname;
    private String lastname;
    private String middlename;
    private String under_manager_id;
    private String email_id;
    private String per_emailid;
    private double resource_cost;
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
	private String cug_num;
	private String nationality;
	private String basic_qualification;
	private String special_qualification;
    private String marital_status;
    private String gender;
    private String salutation;
    private String address;
    private String birth_date;
    private String graduate_degree;
    private String master_degree;
    private String iti_course;
    private String diploma_course;
    private String special_interest;
    private String pan_no;
    private String adhar_no;
    private String pf_uan_no;
    private String pf_no;
    private String esic_no;
    private String bank_acount_no;
    private String bank_name;
    private String ifsc_code;
    private String grade_code;
    private String mealcard;
    
    private RoleBean roleBean;
    private DepartmentBean departmentBean;
    private ManagerBean managerBean;
    private CompanyListBean companyListBean;
    private EmployeeStatusBean employeeStatusBean;
    
    
    public EmployeeBean() {
    }

    public EmployeeBean(String firstname, String middlename, String lastname, int employee_code, String salutation,
			String address, String joining_date, String birth_date, String marital_status, String languages,
			String sub_department, String gender, String gross_salary, String blood_group, String height, String weight,
			String identification_marks, String digital_sign, String photo, String password, String location,
			String email_id, double resource_cost, String mob_num,String nationality, String basic_qualification,
			String special_qualification, RoleBean roleBean, DepartmentBean departmentBean, ManagerBean managerBean,
			CompanyListBean companyListBean,String under_manager_id,EmployeeStatusBean employeeStatusBean) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.employee_code = employee_code;
		this.salutation = salutation;
		this.address = address;
		this.joining_date = joining_date;
		this.birth_date = birth_date;
		this.marital_status = marital_status;
		this.languages = languages;
		this.sub_department = sub_department;
		this.gender = gender;
		this.gross_salary = gross_salary;
		this.blood_group = blood_group;
		this.height = height;
		this.weight = weight;
		this.identification_marks = identification_marks;
		this.digital_sign = digital_sign;
		this.photo = photo;
		this.password = password;
		this.location = location;
		this.email_id = email_id;
		this.resource_cost = resource_cost;
		this.mob_num = mob_num;
		this.nationality = nationality;
		this.basic_qualification = basic_qualification;
		this.special_qualification = special_qualification;
		this.roleBean = roleBean;
		this.departmentBean = departmentBean;
		this.managerBean = managerBean;
		this.companyListBean = companyListBean;
		this.under_manager_id = under_manager_id;
		this.employeeStatusBean = employeeStatusBean;
	}
    
    
    public EmployeeBean(String firstname, String middlename, String lastname, int employee_code, String salutation,
			String address, String joining_date, String birth_date, String marital_status, String languages,
			String sub_department, String gender, String gross_salary, String blood_group, String height, String weight,
			String identification_marks, String digital_sign, String photo, String password, String location,
			String email_id,String pre_emailid, double resource_cost, String mob_num,String cug_num,  String nationality, String basic_qualification,
			String special_qualification, RoleBean roleBean, DepartmentBean departmentBean, ManagerBean managerBean,
			CompanyListBean companyListBean,String under_manager_id,EmployeeStatusBean employeeStatusBean,String graduate_degree,String master_degree, String grade_code, String iti_course, String diploma_course, String special_interest) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.employee_code = employee_code;
		this.salutation = salutation;
		this.address = address;
		this.joining_date = joining_date;
		this.birth_date = birth_date;
		this.marital_status = marital_status;
		this.languages = languages;
		this.sub_department = sub_department;
		this.gender = gender;
		this.gross_salary = gross_salary;
		this.blood_group = blood_group;
		this.height = height;
		this.weight = weight;
		this.identification_marks = identification_marks;
		this.digital_sign = digital_sign;
		this.photo = photo;
		this.password = password;
		this.location = location;
		this.email_id = email_id;
		this.per_emailid = pre_emailid;
		this.resource_cost = resource_cost;
		this.mob_num = mob_num;
		this.nationality = nationality;
		this.basic_qualification = basic_qualification;
		this.special_qualification = special_qualification;
		this.roleBean = roleBean;
		this.departmentBean = departmentBean;
		this.managerBean = managerBean;
		this.companyListBean = companyListBean;
		this.under_manager_id = under_manager_id;
		this.employeeStatusBean = employeeStatusBean;
		this.graduate_degree = graduate_degree;
		this.master_degree = master_degree;
		this.grade_code = grade_code;
		this.cug_num = cug_num;
		this.iti_course = iti_course;
		this.diploma_course = diploma_course;
		this.special_interest = special_interest;
		
		 
		
		
	}

    
    public EmployeeBean(int emp_code, String password) {
        this.employee_code = employee_code;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
       
    }

    
    
  

	@Column(name="graduate_degree")
    public String getGraduate_degree() {
		return graduate_degree;
	}

	public void setGraduate_degree(String graduate_degree) {
		this.graduate_degree = graduate_degree;
	}

	@Column(name="master_degree")
	public String getMaster_degree() {
		return master_degree;
	}

	public void setMaster_degree(String master_degree) {
		this.master_degree = master_degree;
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
	public int getEmployee_code() {
		return employee_code;
	}


	public void setEmployee_code(int employee_code) {
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

	@Column(name="employee_code")
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


	
	
	@Column(name="pan_no")
	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	
	@Column(name="adhar_no")
	public String getAdhar_no() {
		return adhar_no;
	}

	public void setAdhar_no(String adhar_no) {
		this.adhar_no = adhar_no;
	}

	@Column(name="pf_no")
	public String getPf_no() {
		return pf_no;
	}

	public void setPf_no(String pf_no) {
		this.pf_no = pf_no;
	}

	@Column(name="pf_uan_no")
	public String getPf_uan_no() {
		return pf_uan_no;
	}

	public void setPf_uan_no(String pf_uan_no) {
		this.pf_uan_no = pf_uan_no;
	}

	
	@Column(name="esic_no")
	public String getEsic_no() {
		return esic_no;
	}

	public void setEsic_no(String esic_no) {
		this.esic_no = esic_no;
	}

	
	@Column(name="bank_acount_no")
	public String getBank_acount_no() {
		return bank_acount_no;
	}

	public void setBank_acount_no(String bank_acount_no) {
		this.bank_acount_no = bank_acount_no;
	}

	
	@Column(name="bank_name")
	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	
	@Column(name="grade_code")
	public String getGrade_code() {
		return grade_code;
	}

	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
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


	@Column(name="under_manager_id")
	public String getUnder_manager_id() {
		return under_manager_id;
	}


	public void setUnder_manager_id(String under_manager_id) {
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
	public double getResource_cost() {
		return resource_cost;
	}


	public void setResource_cost(double resource_cost) {
		this.resource_cost = resource_cost;
	}

	@Column(name="photo")
	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name="marital_status")
	public String getMarital_status() {
		return marital_status;
	}


	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@ManyToOne
	@JoinColumn(name="company_list_id")
	public CompanyListBean getCompanyListBean() {
		return companyListBean;
	}


	public void setCompanyListBean(CompanyListBean companyListBean) {
		this.companyListBean = companyListBean;
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

	@Column(name="salutation")
	public String getSalutation() {
		return salutation;
	}


	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	@Column(name="address")
	public String getAdress() {
		return address;
	}


	public void setAdress(String address) {
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
	@JoinColumn(name="employee_status_id")
	public EmployeeStatusBean getEmployeeStatusBean() {
		return employeeStatusBean;
	}

	public void setEmployeeStatusBean(EmployeeStatusBean employeeStatusBean) {
		this.employeeStatusBean = employeeStatusBean;
	}

	public String getPer_emailid() {
		return per_emailid;
	}

	public void setPer_emailid(String per_emailid) {
		this.per_emailid = per_emailid;
	}

	public String getCug_num() {
		return cug_num;
	}

	public void setCug_num(String cug_num) {
		this.cug_num = cug_num;
	}
	
	

	public String getIti_course() {
		return iti_course;
	}

	public void setIti_course(String iti_course) {
		this.iti_course = iti_course;
	}
	
	

	public String getDiploma_course() {
		return diploma_course;
	}

	public void setDiploma_course(String diploma_course) {
		this.diploma_course = diploma_course;
	}
	
	

	public String getSpecial_interest() {
		return special_interest;
	}

	public void setSpecial_interest(String special_interest) {
		this.special_interest = special_interest;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getMealcard() {
		return mealcard;
	}

	public void setMealcard(String mealcard) {
		this.mealcard = mealcard;
	}
	 
	
}