package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

@Entity
@Table(name = "sales_target_tbl")
public class TargetBean implements Serializable {

	private int sales_target_id;
	private String target_value;

	private MonthBean monthBean;
	private YearBean yearBean;
	private SalespersonBean salespersonBean;
	private ProductMasterBean productMasterBean;

	public TargetBean(String target_value, MonthBean monthBean, YearBean yearBean, SalespersonBean salespersonBean,
			ProductMasterBean productMasterBean) {
		super();
		this.target_value = target_value;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
		this.salespersonBean = salespersonBean;
		this.productMasterBean = productMasterBean;
	}
	
	

	public TargetBean(int sales_target_id, String target_value, MonthBean monthBean, YearBean yearBean,
			SalespersonBean salespersonBean, ProductMasterBean productMasterBean) {
		super();
		this.sales_target_id = sales_target_id;
		this.target_value = target_value;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
		this.salespersonBean = salespersonBean;
		this.productMasterBean = productMasterBean;
	}



	public TargetBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "sales_target_id")
	@GeneratedValue
	public int getSales_target_id() {
		return sales_target_id;
	}

	public void setSales_target_id(int sales_target_id) {
		this.sales_target_id = sales_target_id;
	}

	@Column(name = "target_value")
	public String getTarget_value() {
		return target_value;
	}

	public void setTarget_value(String target_value) {
		this.target_value = target_value;
	}

	@ManyToOne
	@JoinColumn(name = "month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}

	@ManyToOne
	@JoinColumn(name = "year_id")
	public YearBean getYearBean() {
		return yearBean;
	}

	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
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
	@JoinColumn(name = "product_master_id")
	public ProductMasterBean getProductMasterBean() {
		return productMasterBean;
	}

	public void setProductMasterBean(ProductMasterBean productMasterBean) {
		this.productMasterBean = productMasterBean;
	}
}
