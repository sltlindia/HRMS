package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="designation_template_tbl")
public class DesignationTemplateBean {
	
	@Id
	@GeneratedValue
	private int designation_template_id;
	private String roles_responsibility;
	private String authority;
	private String skills_knowledge;
	
	private DepartmentDesignationBean departmentDesignationBean;
	
	public DesignationTemplateBean() {
	}
	
	
	
	public DesignationTemplateBean(String roles_responsibility, String authority, String skills_knowledge,
			DepartmentDesignationBean departmentDesignationBean) {

		this.roles_responsibility = roles_responsibility;
		this.authority = authority;
		this.skills_knowledge = skills_knowledge;
		this.departmentDesignationBean = departmentDesignationBean;
	}
	
	public DesignationTemplateBean(String roles_responsibility, String authority, String skills_knowledge,
			DepartmentDesignationBean departmentDesignationBean,int designation_template_id) {

		this.roles_responsibility = roles_responsibility;
		this.authority = authority;
		this.skills_knowledge = skills_knowledge;
		this.departmentDesignationBean = departmentDesignationBean;
		this.designation_template_id = designation_template_id;
	}



	@Id 
	@Column(name = "designation_template_id")
    @GeneratedValue
	public int getDesignation_template_id() {
		return designation_template_id;
	}
	public void setDesignation_template_id(int designation_template_id) {
		this.designation_template_id = designation_template_id;
	}
	public String getRoles_responsibility() {
		return roles_responsibility;
	}
	public void setRoles_responsibility(String roles_responsibility) {
		this.roles_responsibility = roles_responsibility;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getSkills_knowledge() {
		return skills_knowledge;
	}
	public void setSkills_knowledge(String skills_knowledge) {
		this.skills_knowledge = skills_knowledge;
	}
	
	@ManyToOne	
	@JoinColumn(name="department_designation_id")
	public DepartmentDesignationBean getDepartmentDesignationBean() {
		return departmentDesignationBean;
	}
	public void setDepartmentDesignationBean(DepartmentDesignationBean departmentDesignationBean) {
		this.departmentDesignationBean = departmentDesignationBean;
	}
	
	
	
	
}
