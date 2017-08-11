package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="details_of_hand_over_form_tbl")
public class DetailsOfHandOverFormBean {
	
	
	
	private int details_of_hand_over_form_id;
	private String hand_over_from_name;
	private String hand_over_from_designation;
	private String hand_over_from_department;
	private int hand_over_to_name;
	private int hand_over_to_designation;
	private int hand_over_to_department;
	private String purpose_of_hand_over;
	private String specific_purpose_of_hand_over;
	
	private EmployeeBean employeeBean;
	
	
	public DetailsOfHandOverFormBean() {
		// TODO Auto-generated constructor stub
	}


	


	public DetailsOfHandOverFormBean(String hand_over_from_name, String hand_over_from_designation,
			String hand_over_from_department, int hand_over_to_name, int hand_over_to_designation,
			int hand_over_to_department, String purpose_of_hand_over, String specific_purpose_of_hand_over,
			EmployeeBean employeeBean) {
		super();
		this.hand_over_from_name = hand_over_from_name;
		this.hand_over_from_designation = hand_over_from_designation;
		this.hand_over_from_department = hand_over_from_department;
		this.hand_over_to_name = hand_over_to_name;
		this.hand_over_to_designation = hand_over_to_designation;
		this.hand_over_to_department = hand_over_to_department;
		this.purpose_of_hand_over = purpose_of_hand_over;
		this.specific_purpose_of_hand_over = specific_purpose_of_hand_over;
		this.employeeBean = employeeBean;
	}





	@Id 
    @Column(name="details_of_hand_over_form_id")
    @GeneratedValue
	public int getDetails_of_hand_over_form_id() {
		return details_of_hand_over_form_id;
	}

	public void setDetails_of_hand_over_form_id(int details_of_hand_over_form_id) {
		this.details_of_hand_over_form_id = details_of_hand_over_form_id;
	}


	@Column(name="hand_over_from_name")
	public String getHand_over_from_name() {
		return hand_over_from_name;
	}

	public void setHand_over_from_name(String hand_over_from_name) {
		this.hand_over_from_name = hand_over_from_name;
	}

	
	@Column(name="hand_over_from_designation")
	public String getHand_over_from_designation() {
		return hand_over_from_designation;
	}

	public void setHand_over_from_designation(String hand_over_from_designation) {
		this.hand_over_from_designation = hand_over_from_designation;
	}

	
	@Column(name="hand_over_from_department")
	public String getHand_over_from_department() {
		return hand_over_from_department;
	}

	public void setHand_over_from_department(String hand_over_from_department) {
		this.hand_over_from_department = hand_over_from_department;
	}

	@Column(name="hand_over_to_name")
	public int getHand_over_to_name() {
		return hand_over_to_name;
	}

	public void setHand_over_to_name(int hand_over_to_name) {
		this.hand_over_to_name = hand_over_to_name;
	}


	@Column(name="hand_over_to_designation")
	public int getHand_over_to_designation() {
		return hand_over_to_designation;
	}

	public void setHand_over_to_designation(int hand_over_to_designation) {
		this.hand_over_to_designation = hand_over_to_designation;
	}


	@Column(name="hand_over_to_department")
	public int getHand_over_to_department() {
		return hand_over_to_department;
	}

	public void setHand_over_to_department(int hand_over_to_department) {
		this.hand_over_to_department = hand_over_to_department;
	}


	@Column(name="purpose_of_hand_over")
	public String getPurpose_of_hand_over() {
		return purpose_of_hand_over;
	}

	public void setPurpose_of_hand_over(String purpose_of_hand_over) {
		this.purpose_of_hand_over = purpose_of_hand_over;
	}

	
	@Column(name="specific_purpose_of_hand_over")
	public String getSpecific_purpose_of_hand_over() {
		return specific_purpose_of_hand_over;
	}

	public void setSpecific_purpose_of_hand_over(String specific_purpose_of_hand_over) {
		this.specific_purpose_of_hand_over = specific_purpose_of_hand_over;
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
