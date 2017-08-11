package com.hrms.recruitement.bean;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="induction_qa_tbl")
public class InductionQABean {

	public InductionQABean(){}
	
	private EmployeeBean employeeBean;
	
	@Id
	@GeneratedValue
	private int induction_qa_id;
	private String induction_qa1;
	private String induction_qa2;
	private String induction_qa3;
	private String induction_qa4;
	private String induction_qa5;
	private String induction_qa6;
	private String induction_qa7;
	private String induction_qa8;
	private String induction_qa9;
	private String induction_qa10;
	private String induction_qa11;
	private String induction_qa12;
	private String induction_qa13;
	private String induction_qa14;
	
	
	
	
	
	public InductionQABean(EmployeeBean employeeBean, String induction_qa1, String induction_qa2, String induction_qa3,
			String induction_qa4, String induction_qa5, String induction_qa6, String induction_qa7,
			String induction_qa8, String induction_qa9, String induction_qa10, String induction_qa11,
			String induction_qa12, String induction_qa13, String induction_qa14) {

		this.employeeBean = employeeBean;
		this.induction_qa1 = induction_qa1;
		this.induction_qa2 = induction_qa2;
		this.induction_qa3 = induction_qa3;
		this.induction_qa4 = induction_qa4;
		this.induction_qa5 = induction_qa5;
		this.induction_qa6 = induction_qa6;
		this.induction_qa7 = induction_qa7;
		this.induction_qa8 = induction_qa8;
		this.induction_qa9 = induction_qa9;
		this.induction_qa10 = induction_qa10;
		this.induction_qa11 = induction_qa11;
		this.induction_qa12 = induction_qa12;
		this.induction_qa13 = induction_qa13;
		this.induction_qa14 = induction_qa14;
	}
	@ManyToOne
	@JoinColumn (name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	@Id
	@GeneratedValue
	public int getInduction_qa_id() {
		return induction_qa_id;
	}
	public void setInduction_qa_id(int induction_qa_id) {
		this.induction_qa_id = induction_qa_id;
	}
	public String getInduction_qa1() {
		return induction_qa1;
	}
	public void setInduction_qa1(String induction_qa1) {
		this.induction_qa1 = induction_qa1;
	}
	public String getInduction_qa2() {
		return induction_qa2;
	}
	public void setInduction_qa2(String induction_qa2) {
		this.induction_qa2 = induction_qa2;
	}
	public String getInduction_qa3() {
		return induction_qa3;
	}
	public void setInduction_qa3(String induction_qa3) {
		this.induction_qa3 = induction_qa3;
	}
	public String getInduction_qa4() {
		return induction_qa4;
	}
	public void setInduction_qa4(String induction_qa4) {
		this.induction_qa4 = induction_qa4;
	}
	public String getInduction_qa5() {
		return induction_qa5;
	}
	public void setInduction_qa5(String induction_qa5) {
		this.induction_qa5 = induction_qa5;
	}
	public String getInduction_qa6() {
		return induction_qa6;
	}
	public void setInduction_qa6(String induction_qa6) {
		this.induction_qa6 = induction_qa6;
	}
	public String getInduction_qa7() {
		return induction_qa7;
	}
	public void setInduction_qa7(String induction_qa7) {
		this.induction_qa7 = induction_qa7;
	}
	public String getInduction_qa8() {
		return induction_qa8;
	}
	public void setInduction_qa8(String induction_qa8) {
		this.induction_qa8 = induction_qa8;
	}
	public String getInduction_qa9() {
		return induction_qa9;
	}
	public void setInduction_qa9(String induction_qa9) {
		this.induction_qa9 = induction_qa9;
	}
	public String getInduction_qa10() {
		return induction_qa10;
	}
	public void setInduction_qa10(String induction_qa10) {
		this.induction_qa10 = induction_qa10;
	}
	public String getInduction_qa11() {
		return induction_qa11;
	}
	public void setInduction_qa11(String induction_qa11) {
		this.induction_qa11 = induction_qa11;
	}
	public String getInduction_qa12() {
		return induction_qa12;
	}
	public void setInduction_qa12(String induction_qa12) {
		this.induction_qa12 = induction_qa12;
	}
	public String getInduction_qa13() {
		return induction_qa13;
	}
	public void setInduction_qa13(String induction_qa13) {
		this.induction_qa13 = induction_qa13;
	}
	public String getInduction_qa14() {
		return induction_qa14;
	}
	public void setInduction_qa14(String induction_qa14) {
		this.induction_qa14 = induction_qa14;
	}
	
	
	
}
