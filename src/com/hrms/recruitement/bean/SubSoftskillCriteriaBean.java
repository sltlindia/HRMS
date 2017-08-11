package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_softskill_criteria_tbl")
public class SubSoftskillCriteriaBean {

	private int sub_softskill_criteria_id;
	private String sub_softskill_criteria_name;
	private String description;

	private SoftskillCriteriaBean softskillCriteriaBean;

	public SubSoftskillCriteriaBean() {
	}

	public SubSoftskillCriteriaBean(String sub_softskill_criteria_name, String description,
			SoftskillCriteriaBean softskillCriteriaBean) {
		this.sub_softskill_criteria_name = sub_softskill_criteria_name;
		this.description = description;
		this.softskillCriteriaBean = softskillCriteriaBean;
	}

	@Id
	@Column(name = "sub_softskill_criteria_id")
	@GeneratedValue
	public int getSub_softskill_criteria_id() {
		return sub_softskill_criteria_id;
	}

	public void setSub_softskill_criteria_id(int sub_softskill_criteria_id) {
		this.sub_softskill_criteria_id = sub_softskill_criteria_id;
	}

	public String getSub_softskill_criteria_name() {
		return sub_softskill_criteria_name;
	}

	public void setSub_softskill_criteria_name(String sub_softskill_criteria_name) {
		this.sub_softskill_criteria_name = sub_softskill_criteria_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "softskill_criteria_id")
	public SoftskillCriteriaBean getSoftskillCriteriaBean() {
		return softskillCriteriaBean;
	}

	public void setSoftskillCriteriaBean(SoftskillCriteriaBean softskillCriteriaBean) {
		this.softskillCriteriaBean = softskillCriteriaBean;
	}

}
