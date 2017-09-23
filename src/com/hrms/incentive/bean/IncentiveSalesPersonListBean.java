package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="incentive_sales_person_list_tbl")
public class IncentiveSalesPersonListBean implements Serializable{
	
	private int incentive_sales_person_list_id;
	private double slab_value;
	private double incentive_amount;
	private String designation;
	private Double eligible_incentive_percentage;
	private String incentive_status;
	private String paid_date;
	private String release_date;
	
	private SalespersonBean salespersonBean;
	private IncentiveBean incentiveBean;

	
	
	public IncentiveSalesPersonListBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param slab_value
	 * @param incentive_value
	 * @param salespersonBean
	 */
	public IncentiveSalesPersonListBean(double slab_value, double incentive_amount, SalespersonBean salespersonBean,String designation,IncentiveBean incentiveBean,
			String incentive_status) {
		super();
		this.slab_value = slab_value;
		this.incentive_amount = incentive_amount;
		this.salespersonBean = salespersonBean;
		this.designation = designation;
		this.incentiveBean = incentiveBean;
		this.incentive_status = incentive_status;
	}
	
	
	
	

	
	
	/**
	 * @param incentive_sales_person_list_id
	 * @param slab_value
	 * @param incentive_amount
	 * @param designation
	 * @param salespersonBean
	 * @param incentiveBean
	 */
	public IncentiveSalesPersonListBean(int incentive_sales_person_list_id, double slab_value, double incentive_amount,
			String designation, SalespersonBean salespersonBean, IncentiveBean incentiveBean,String incentive_status) {
		super();
		this.incentive_sales_person_list_id = incentive_sales_person_list_id;
		this.slab_value = slab_value;
		this.incentive_amount = incentive_amount;
		this.designation = designation;
		this.salespersonBean = salespersonBean;
		this.incentiveBean = incentiveBean;
		this.incentive_status = incentive_status;
	}
	
	
	
	


	@Id 
    @Column(name="incentive_sales_person_list_id")
    @GeneratedValue
	public int getIncentive_sales_person_list_id() {
		return incentive_sales_person_list_id;
	}

	public void setIncentive_sales_person_list_id(int incentive_sales_person_list_id) {
		this.incentive_sales_person_list_id = incentive_sales_person_list_id;
	}

	public double getSlab_value() {
		return slab_value;
	}

	public void setSlab_value(double slab_value) {
		this.slab_value = slab_value;
	}

	
	public double getIncentive_amount() {
		return incentive_amount;
	}



	public void setIncentive_amount(double incentive_amount) {
		this.incentive_amount = incentive_amount;
	}


	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	@ManyToOne
	@JoinColumn(name = "sales_person_id")
	public SalespersonBean getSalespersonBean() {
		return salespersonBean;
	}

	public void setSalespersonBean(SalespersonBean salespersonBean) {
		this.salespersonBean = salespersonBean;
	}


	@ManyToOne
	@JoinColumn(name = "incentive_id")
	public IncentiveBean getIncentiveBean() {
		return incentiveBean;
	}



	public void setIncentiveBean(IncentiveBean incentiveBean) {
		this.incentiveBean = incentiveBean;
	}


	public Double getEligible_incentive_percentage() {
		return eligible_incentive_percentage;
	}


	public void setEligible_incentive_percentage(Double eligible_incentive_percentage) {
		this.eligible_incentive_percentage = eligible_incentive_percentage;
	}


	public String getIncentive_status() {
		return incentive_status;
	}


	public void setIncentive_status(String incentive_status) {
		this.incentive_status = incentive_status;
	}


	public String getPaid_date() {
		return paid_date;
	}


	public void setPaid_date(String paid_date) {
		this.paid_date = paid_date;
	}


	public String getRelease_date() {
		return release_date;
	}


	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	
	
	
	

}
