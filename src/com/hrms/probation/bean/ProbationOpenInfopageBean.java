package com.hrms.probation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

@Entity
@Table(name="probation_open_infopage_tbl")
public class ProbationOpenInfopageBean {
	
	private int probation_open_infopage_id;
	private ManagerBean managerBean;
	private MonthBean monthBean;
	private int year;
	
	public ProbationOpenInfopageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public ProbationOpenInfopageBean(ManagerBean managerBean, MonthBean monthBean, int year) {
		super();
		this.managerBean = managerBean;
		this.monthBean = monthBean;
		this.year = year;
	}



	public ProbationOpenInfopageBean(int probation_open_infopage_id, ManagerBean managerBean, MonthBean monthBean,
			int year) {
		super();
		this.probation_open_infopage_id = probation_open_infopage_id;
		this.managerBean = managerBean;
		this.monthBean = monthBean;
		this.year = year;
	}
	@Id
	@Column(name="probation_open_infopage_id")
	@GeneratedValue
	public int getProbation_open_infopage_id() {
		return probation_open_infopage_id;
	}

	public void setProbation_open_infopage_id(int probation_open_infopage_id) {
		this.probation_open_infopage_id = probation_open_infopage_id;
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
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}

	@Column(name="year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
	
	
	
	
}
