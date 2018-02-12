package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="marquee_tbl")
public class MarqueeBean {
	
	private int marquee_id;
	private String marquee_desc;
	private EmployeeBean employeeBean;

	public MarqueeBean() {
		super();
	}

	public MarqueeBean(String marquee_desc, EmployeeBean employeeBean) {
		this.marquee_desc = marquee_desc;
		this.employeeBean = employeeBean;
	}

	public MarqueeBean(int marquee_id, String marquee_desc, EmployeeBean employeeBean) {
		super();
		this.marquee_id = marquee_id;
		this.marquee_desc = marquee_desc;
		this.employeeBean = employeeBean;
	}

	@Id 
    @Column(name="marquee_id")
    @GeneratedValue
	public int getMarquee_id() {
		return marquee_id;
	}
	
	public void setMarquee_id(int marquee_id) {
		this.marquee_id = marquee_id;
	}
	
	@Column(name="marquee_desc")
	public String getMarquee_desc() {
		return marquee_desc;
	}
	public void setMarquee_desc(String marquee_desc) {
		this.marquee_desc = marquee_desc;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
}
