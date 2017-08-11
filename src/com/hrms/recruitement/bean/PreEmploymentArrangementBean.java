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
import com.hrms.pms.bean.RoleBean;

@Entity
@Table(name="pre_employment_arrangement_tbl")
public class PreEmploymentArrangementBean {

	@Id 
    @GeneratedValue
	private int pre_employment_arrangement_id;
	private String joining_date;
	private String computer_laptop;
	private String cug_connection;
	private String mobile_handset;
	private String internet_data_card;
	private String tickets;
	private String email_id;
	private String sitting_arrangement;
	private String visiting_card;
	private String id_card;
	private String catalog;
	private String authorized_by;
	
	RoleBean roleBean = new RoleBean();
	DepartmentBean departmentBean = new DepartmentBean();
	EmployeeBean employeeBean = new EmployeeBean();
	
	


	public PreEmploymentArrangementBean(){}
	
	
	public PreEmploymentArrangementBean(String joining_date,
			String computer_laptop, String cug_connection, String mobile_handset, String internet_data_card,
			String tickets, String email_id, String sitting_arrangement, String visiting_card, String id_card,
			String catalog, String authorized_by, RoleBean roleBean, DepartmentBean departmentBean,EmployeeBean employeeBean) 
	{
		this.joining_date = joining_date;
		this.computer_laptop = computer_laptop;
		this.cug_connection = cug_connection;
		this.mobile_handset = mobile_handset;
		this.internet_data_card = internet_data_card;
		this.tickets = tickets;
		this.email_id = email_id;
		this.sitting_arrangement = sitting_arrangement;
		this.visiting_card = visiting_card;
		this.id_card = id_card;
		this.catalog = catalog;
		this.authorized_by = authorized_by;
		this.roleBean = roleBean;
		this.departmentBean = departmentBean;
		this.employeeBean = employeeBean;
	}
	
	
	@Id 
	@Column(name = "pre_employment_arrangement_id")
    @GeneratedValue
	public int getPre_employment_arrangement_id() {
		return pre_employment_arrangement_id;
	}
	public void setPre_employment_arrangement_id(int pre_employment_arrangement_id) {
		this.pre_employment_arrangement_id = pre_employment_arrangement_id;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getComputer_laptop() {
		return computer_laptop;
	}
	public void setComputer_laptop(String computer_laptop) {
		this.computer_laptop = computer_laptop;
	}
	public String getCug_connection() {
		return cug_connection;
	}
	public void setCug_connection(String cug_connection) {
		this.cug_connection = cug_connection;
	}
	public String getMobile_handset() {
		return mobile_handset;
	}
	public void setMobile_handset(String mobile_handset) {
		this.mobile_handset = mobile_handset;
	}
	public String getInternet_data_card() {
		return internet_data_card;
	}
	public void setInternet_data_card(String internet_data_card) {
		this.internet_data_card = internet_data_card;
	}
	public String getTickets() {
		return tickets;
	}
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getSitting_arrangement() {
		return sitting_arrangement;
	}
	public void setSitting_arrangement(String sitting_arrangement) {
		this.sitting_arrangement = sitting_arrangement;
	}
	public String getVisiting_card() {
		return visiting_card;
	}
	public void setVisiting_card(String visiting_card) {
		this.visiting_card = visiting_card;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getAuthorized_by() {
		return authorized_by;
	}
	public void setAuthorized_by(String authorized_by) {
		this.authorized_by = authorized_by;
	}
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	public RoleBean getRoleBean() {
		return roleBean;
	}
	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}
	
	@ManyToOne
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
}
