package com.hrms.lms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="leave_nopunch_tbl")
public class NopunchBean
{

	@Id
	@GeneratedValue
	private int nopunch_id;
	private EmployeeBean employeeBean;
	private String nopunch_date;
	private int Show_View;
	private int under_manager_id;
	
	
	public NopunchBean()
	{
		
	}
	
	public NopunchBean(EmployeeBean employeeBean , String nopunch_date , int Show_View , int under_manager_id)
	{
		this.employeeBean = employeeBean;
		this.nopunch_date = nopunch_date;
		this.Show_View = Show_View;
		this.under_manager_id = under_manager_id;
	}

	 @Id 
	 @Column(name="nopunch_id")
	 @GeneratedValue
	public int getNopunch_id() {
		return nopunch_id;
	}

	public void setNopunch_id(int nopunch_id) {
		this.nopunch_id = nopunch_id;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getNopunch_date() {
		return nopunch_date;
	}

	public void setNopunch_date(String nopunch_date) {
		this.nopunch_date = nopunch_date;
	}

	public int getShow_View() {
		return Show_View;
	}

	public void setShow_View(int show_View) {
		Show_View = show_View;
	}

	public int getUnder_manager_id() {
		return under_manager_id;
	}

	public void setUnder_manager_id(int under_manager_id) {
		this.under_manager_id = under_manager_id;
	}
	
	
	
}
