package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="specific_criteria_tbl")
public class SpecificCriteriaAllocationBean {

	@Id @GeneratedValue
	private int specific_criteria_id;
	private int under_manager_id;
	private int technical_per;
	private int softskill_per;
	private int under_dept_id;
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	private String t7;
	private String t8;
	private String t9;
	private String t10;
	private String t11;
	private String t12;
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String s5;
	private String s6;
	private String s7;
	private String s8;
	private String s9;
	private String s10;
	private String s11;
	private String s12;
	private String s13;
	private String s14;
	
	private YearBean yearBean;
	private MonthBean monthBean;
	private ProjectMasterBean projectMasterBean;
	private EmployeeBean employeeBean;

	@Id 
	@Column(name="specific_criteria_id")
	@GeneratedValue
	public int getSpecific_criteria_id() {
		return specific_criteria_id;
	}

	public void setSpecific_criteria_id(int specific_criteria_id) {
		this.specific_criteria_id = specific_criteria_id;
	}

	
	@Column(name="t1")
	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	@Column(name="t2")
	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	@Column(name="t3")
	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	@Column(name="t4")
	public String getT4() {
		return t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	@Column(name="t5")
	public String getT5() {
		return t5;
	}

	public void setT5(String t5) {
		this.t5 = t5;
	}

	@Column(name="t6")
	public String getT6() {
		return t6;
	}

	public void setT6(String t6) {
		this.t6 = t6;
	}

	@Column(name="s1")
	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	@Column(name="s2")
	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	@Column(name="s3")
	public String getS3() {
		return s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
	}

	@Column(name="s4")
	public String getS4() {
		return s4;
	}

	public void setS4(String s4) {
		this.s4 = s4;
	}

	@Column(name="s5")
	public String getS5() {
		return s5;
	}

	public void setS5(String s5) {
		this.s5 = s5;
	}
	
	
	@Column(name="under_manager_id")
	public int getUnder_manager_id() {
		return under_manager_id;
	}

	public void setUnder_manager_id(int under_manager_id) {
		this.under_manager_id = under_manager_id;
	}

	@ManyToOne
	@JoinColumn(name="year_id")
	public YearBean getYearBean() {
		return yearBean;
	}

	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}

	@ManyToOne
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}

	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}

	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}

	

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@Column(name="technical_per")
	public int getTechnical_per() {
		return technical_per;
	}

	public void setTechnical_per(int technical_per) {
		this.technical_per = technical_per;
	}
	
	@Column(name="softskill_per")
	public int getSoftskill_per() {
		return softskill_per;
	}

	public void setSoftskill_per(int softskill_per) {
		this.softskill_per = softskill_per;
	}

	@Column(name="under_dept_id")
	public int getUnder_dept_id() {
		return under_dept_id;
	}

	public void setUnder_dept_id(int under_dept_id) {
		this.under_dept_id = under_dept_id;
	}

	@Column(name="t7")
	public String getT7() {
		return t7;
	}

	public void setT7(String t7) {
		this.t7 = t7;
	}

	@Column(name="t8")
	public String getT8() {
		return t8;
	}

	public void setT8(String t8) {
		this.t8 = t8;
	}

	@Column(name="t9")
	public String getT9() {
		return t9;
	}

	public void setT9(String t9) {
		this.t9 = t9;
	}

	@Column(name="t10")
	public String getT10() {
		return t10;
	}

	public void setT10(String t10) {
		this.t10 = t10;
	}

	@Column(name="t11")
	public String getT11() {
		return t11;
	}

	public void setT11(String t11) {
		this.t11 = t11;
	}

	@Column(name="t12")
	public String getT12() {
		return t12;
	}

	public void setT12(String t12) {
		this.t12 = t12;
	}

	@Column(name="s6")
	public String getS6() {
		return s6;
	}

	public void setS6(String s6) {
		this.s6 = s6;
	}

	@Column(name="s7")
	public String getS7() {
		return s7;
	}

	public void setS7(String s7) {
		this.s7 = s7;
	}

	@Column(name="s8")
	public String getS8() {
		return s8;
	}

	public void setS8(String s8) {
		this.s8 = s8;
	}

	@Column(name="s9")
	public String getS9() {
		return s9;
	}

	public void setS9(String s9) {
		this.s9 = s9;
	}

	@Column(name="s10")
	public String getS10() {
		return s10;
	}

	public void setS10(String s10) {
		this.s10 = s10;
	}

	@Column(name="s11")
	public String getS11() {
		return s11;
	}

	public void setS11(String s11) {
		this.s11 = s11;
	}

	@Column(name="s12")
	public String getS12() {
		return s12;
	}

	public void setS12(String s12) {
		this.s12 = s12;
	}

	@Column(name="s13")
	public String getS13() {
		return s13;
	}

	public void setS13(String s13) {
		this.s13 = s13;
	}

	@Column(name="s14")
	public String getS14() {
		return s14;
	}

	public void setS14(String s14) {
		this.s14 = s14;
	}



	


	
	
	
	
}
