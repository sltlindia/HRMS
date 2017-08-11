package com.hrms.incentive.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;



@Entity
@Table(name="product_master_tbl")
public class ProductMasterBean {

	
	private int product_master_id;
	private String product_name;
	/*private String full_name;*/
	private String machine_category;
	
	
	
	public ProductMasterBean() {
		super();
	}

	public ProductMasterBean(String product_name, String machine_category) {
		super();
		this.product_name = product_name;
		this.machine_category = machine_category;
	}




	public ProductMasterBean(int product_master_id, String product_name, String machine_category) {
		super();
		this.product_master_id = product_master_id;
		this.product_name = product_name;
		this.machine_category = machine_category;
	}
	
	

	@Id 
    @Column(name="product_master_id")
    @GeneratedValue
	public int getProduct_master_id() {
		return product_master_id;
	}

	public void setProduct_master_id(int product_master_id) {
		this.product_master_id = product_master_id;
	}

	@Column(name="product_name")
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	/*@Column(name="full_name")
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}*/

	
	@Column(name="machine_category")
	public String getMachine_category() {
		return machine_category;
	}

	public void setMachine_category(String machine_category) {
		this.machine_category = machine_category;
	}
	
	
	

	
	
}
