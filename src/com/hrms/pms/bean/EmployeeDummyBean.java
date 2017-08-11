package com.hrms.pms.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrms.pms.controller.employee;
/**
 * @author Administrator
 *
 */
@Entity
@Table(name="employee_dummy_tbl")
public class EmployeeDummyBean implements Serializable {
	 
		@Id
		@GeneratedValue
		private int employee_dummy_id;
		 private String firstname;
	    private String middlename;
	    private String lastname;
	    private String employee_code;
	    private String salutation;
	    private String adress;
	    private String joining_date;
	    private String birth_date;
	    private String marital_status;
	    private String languages;
	    private String department_id;
	    private String sub_department;
	    private String gender;
	    private String gross_salary;
	    private String blood_group;
	    private String height;
	    private String weight;
	    private String identification_marks;
	    private String digital_sign;
	    private String photo;
	    private String password;
	    private String location;
	    private String role_id;
	    private String under_manager_id;
	    private String manager_id;
	    private String email_id;
	    private String resource_cost;
	    private String company_list_id;
	    private String mob_num;
	    private String nationality;
	    private String basic_qualification;
	    private String special_qualification;
	 
	    

	   public EmployeeDummyBean(String firstname,String middlename,String lastname,String employee_code,String salutation,String adress,String joining_date,String birth_date,String marital_status,String languages,String department_id,String sub_department,String gender,String gross_salary,String blood_group,String height,String weight ,String identification_marks,String digital_sign,String photo,String password,String location,String role_id,String under_manager_id,String manager_id,String email_id,String resource_cost,String company_list_id,String mob_num,String nationality,String basic_qualification,String special_qualification) {
		   this.firstname = firstname;
		   this.middlename = middlename;
		   this.lastname = lastname;
		   this.employee_code = employee_code;
		   this.salutation = salutation;
		   this.adress = adress;
		   this.joining_date = joining_date;
		   this.birth_date = birth_date;
		   this.marital_status = marital_status;
		   this.languages = languages;
		   this.department_id = department_id;
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
		   this.role_id = role_id;
		   this.under_manager_id = under_manager_id;
		   this.manager_id = manager_id;
		   this.email_id = email_id;
		   this.resource_cost = resource_cost;
		   this.company_list_id = company_list_id;
		   this.mob_num = mob_num;
		   this.nationality = nationality;
		   this.basic_qualification = basic_qualification;
		   this.special_qualification = special_qualification;
	   }


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getMiddlename() {
		return middlename;
	}


	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmployee_code() {
		return employee_code;
	}


	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}


	public String getSalutation() {
		return salutation;
	}


	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}


	public String getJoining_date() {
		return joining_date;
	}


	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}


	public String getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}


	public String getMarital_status() {
		return marital_status;
	}


	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}


	public String getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}


	public String getSub_department() {
		return sub_department;
	}


	public void setSub_department(String sub_department) {
		this.sub_department = sub_department;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getGross_salary() {
		return gross_salary;
	}


	public void setGross_salary(String gross_salary) {
		this.gross_salary = gross_salary;
	}


	public String getBlood_group() {
		return blood_group;
	}


	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getIdentification_marks() {
		return identification_marks;
	}


	public void setIdentification_marks(String identification_marks) {
		this.identification_marks = identification_marks;
	}


	public String getDigital_sign() {
		return digital_sign;
	}


	public void setDigital_sign(String digital_sign) {
		this.digital_sign = digital_sign;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getRole_id() {
		return role_id;
	}


	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}


	public String getUnder_manager_id() {
		return under_manager_id;
	}


	public void setUnder_manager_id(String under_manager_id) {
		this.under_manager_id = under_manager_id;
	}


	public String getManager_id() {
		return manager_id;
	}


	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getResource_cost() {
		return resource_cost;
	}


	public void setResource_cost(String resource_cost) {
		this.resource_cost = resource_cost;
	}


	public String getCompany_list_id() {
		return company_list_id;
	}


	public void setCompany_list_id(String company_list_id) {
		this.company_list_id = company_list_id;
	}


	public String getMob_num() {
		return mob_num;
	}


	public void setMob_num(String mob_num) {
		this.mob_num = mob_num;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getBasic_qualification() {
		return basic_qualification;
	}


	public void setBasic_qualification(String basic_qualification) {
		this.basic_qualification = basic_qualification;
	}


	public String getSpecial_qualification() {
		return special_qualification;
	}


	public void setSpecial_qualification(String special_qualification) {
		this.special_qualification = special_qualification;
	}


	public int getEmployee_dummy_id() {
		return employee_dummy_id;
	}


	public void setEmployee_dummy_id(int employee_dummy_id) {
		this.employee_dummy_id = employee_dummy_id;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
	
}