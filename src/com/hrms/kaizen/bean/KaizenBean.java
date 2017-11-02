package com.hrms.kaizen.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;


@Entity
@Table(name="kaizen_tbl")
public class KaizenBean implements Serializable{

	private int kaizen_id;
	private String kaizen_name;
	private String kaizen_desc;
	private String existing_problem;
	private String safety_features;
	private String implementation_cost;
	private int manager_id;
	private String status;
	private String date;
	private String rejection_reason;
	private String before_description;
	private String after_description;
	private String delivery;
	private String cost;
	private String quality;
	private String safety;
	private String productivity;
	private String completion_status;
	private String completion_date;
	private String horizontal_deployment;
	private String category_id;
	
	private EmployeeBean employeeBean;
	private KaizenProblemIdentificationBean kaizenProblemIdentificationBean;

	public KaizenBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public KaizenBean(String kaizen_name, String kaizen_desc, String existing_problem, String safety_features, String implementation_cost,int manager_id,
			String status, String date,String delivery,String cost,String quality,String safety,String productivity, EmployeeBean employeeBean,String completion_status,
			String category_id,KaizenProblemIdentificationBean kaizenProblemIdentificationBean) {
		super();
		this.kaizen_name = kaizen_name;
		this.kaizen_desc = kaizen_desc;
		this.existing_problem = existing_problem;
		this.safety_features = safety_features;
		this.implementation_cost = implementation_cost;
		this.manager_id = manager_id;
		this.status = status;
		this.date = date;
		this.delivery = delivery;
		this.cost = cost;
		this.quality = quality;
		this.safety = safety;
		this.productivity = productivity;
		this.employeeBean = employeeBean;
		this.completion_status = completion_status;
		this.category_id = category_id;
		this.kaizenProblemIdentificationBean = kaizenProblemIdentificationBean;
	}


	
	
	
	

	public KaizenBean(int kaizen_id, String kaizen_name, String kaizen_desc, String existing_problem, String safety_features,
			String implementation_cost, int manager_id, String status, String date, EmployeeBean employeeBean,
			String before_description, String after_description, String rejection_reason,String delivery,String cost,String quality,String safety,String productivity,
			String completion_status,String category_id,KaizenProblemIdentificationBean kaizenProblemIdentificationBean) {
		super();
		this.kaizen_id = kaizen_id;
		this.kaizen_name = kaizen_name;
		this.kaizen_desc = kaizen_desc;
		this.existing_problem = existing_problem;
		this.safety_features = safety_features;
		this.implementation_cost = implementation_cost;
		this.manager_id = manager_id;
		this.status = status;
		this.date = date;
		this.employeeBean = employeeBean;
		this.before_description = before_description;
		this.after_description = after_description;
		this.rejection_reason = rejection_reason;
		this.delivery = delivery;
		this.cost = cost;
		this.quality = quality;
		this.safety = safety;
		this.productivity = productivity;
		this.completion_status = completion_status;
		this.category_id = category_id;
		this.kaizenProblemIdentificationBean = kaizenProblemIdentificationBean;
	}


	/**
	 * @return the kaizen_id
	 */
	@Id 
    @Column(name="kaizen_id")
    @GeneratedValue
	public int getKaizen_id() {
		return kaizen_id;
	}


	/**
	 * @param kaizen_id the kaizen_id to set
	 */
	public void setKaizen_id(int kaizen_id) {
		this.kaizen_id = kaizen_id;
	}


	/**
	 * @return the kaizen_name
	 */
	@Column(name="kaizen_name")
	public String getKaizen_name() {
		return kaizen_name;
	}


	/**
	 * @param kaizen_name the kaizen_name to set
	 */
	public void setKaizen_name(String kaizen_name) {
		this.kaizen_name = kaizen_name;
	}


	/**
	 * @return the kaizen_desc
	 */
	@Column(name="kaizen_desc")
	public String getKaizen_desc() {
		return kaizen_desc;
	}


	/**
	 * @param kaizen_desc the kaizen_desc to set
	 */
	public void setKaizen_desc(String kaizen_desc) {
		this.kaizen_desc = kaizen_desc;
	}


	/**
	 * @return the existing_problem
	 */
	@Column(name="existing_problem")
	public String getExisting_problem() {
		return existing_problem;
	}


	/**
	 * @param existing_problem the existing_problem to set
	 */
	public void setExisting_problem(String existing_problem) {
		this.existing_problem = existing_problem;
	}

	/**
	 * @return the safety_features
	 */
	@Column(name="safety_features")
	public String getSafety_features() {
		return safety_features;
	}


	/**
	 * @param safety_features the safety_features to set
	 */
	public void setSafety_features(String safety_features) {
		this.safety_features = safety_features;
	}


	/**
	 * @return the implementation_cost
	 */
	@Column(name="implementation_cost")
	public String getImplementation_cost() {
		return implementation_cost;
	}


	/**
	 * @param implementation_cost the implementation_cost to set
	 */
	public void setImplementation_cost(String implementation_cost) {
		this.implementation_cost = implementation_cost;
	}


	public int getManager_id() {
		return manager_id;
	}


	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}


	public String getRejection_reason() {
		return rejection_reason;
	}


	public void setRejection_reason(String rejection_reason) {
		this.rejection_reason = rejection_reason;
	}


	public String getBefore_description() {
		return before_description;
	}


	public void setBefore_description(String before_description) {
		this.before_description = before_description;
	}


	public String getAfter_description() {
		return after_description;
	}


	public void setAfter_description(String after_description) {
		this.after_description = after_description;
	}


	public String getDelivery() {
		return delivery;
	}


	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	public String getSafety() {
		return safety;
	}


	public void setSafety(String safety) {
		this.safety = safety;
	}


	public String getProductivity() {
		return productivity;
	}


	public void setProductivity(String productivity) {
		this.productivity = productivity;
	}


	public String getCompletion_status() {
		return completion_status;
	}


	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}


	public String getCompletion_date() {
		return completion_date;
	}


	public void setCompletion_date(String completion_date) {
		this.completion_date = completion_date;
	}


	public String getHorizontal_deployment() {
		return horizontal_deployment;
	}


	public void setHorizontal_deployment(String horizontal_deployment) {
		this.horizontal_deployment = horizontal_deployment;
	}


	public String getCategory_id() {
		return category_id;
	}


	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@ManyToOne
	@JoinColumn(name="kaizen_problem_identification_id")
	public KaizenProblemIdentificationBean getKaizenProblemIdentificationBean() {
		return kaizenProblemIdentificationBean;
	}


	public void setKaizenProblemIdentificationBean(KaizenProblemIdentificationBean kaizenProblemIdentificationBean) {
		this.kaizenProblemIdentificationBean = kaizenProblemIdentificationBean;
	}

	
	
	
	
	
}
