package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="details_of_material_tbl")
public class DetailsOfMaterialBean {

	
	private int details_of_material_id;
	private String details_of_material;
	private String material_status;
	
	
	private DetailsOfHandOverFormBean detailsOfHandOverFormBean;
	
	
	public DetailsOfMaterialBean() {
		// TODO Auto-generated constructor stub
	}


	public DetailsOfMaterialBean(String details_of_material, String material_status,
			DetailsOfHandOverFormBean detailsOfHandOverFormBean) {
		super();
		this.details_of_material = details_of_material;
		this.material_status = material_status;
		this.detailsOfHandOverFormBean = detailsOfHandOverFormBean;
	}


	@Id 
    @Column(name="details_of_material_id")
    @GeneratedValue
	public int getDetails_of_material_id() {
		return details_of_material_id;
	}

	public void setDetails_of_material_id(int details_of_material_id) {
		this.details_of_material_id = details_of_material_id;
	}


	@Column(name="details_of_material")
	public String getDetails_of_material() {
		return details_of_material;
	}

	public void setDetails_of_material(String details_of_material) {
		this.details_of_material = details_of_material;
	}


	@Column(name="material_status")
	public String getMaterial_status() {
		return material_status;
	}

	public void setMaterial_status(String material_status) {
		this.material_status = material_status;
	}


	@ManyToOne
	@JoinColumn(name="details_of_hand_over_form_id")
	public DetailsOfHandOverFormBean getDetailsOfHandOverFormBean() {
		return detailsOfHandOverFormBean;
	}

	public void setDetailsOfHandOverFormBean(DetailsOfHandOverFormBean detailsOfHandOverFormBean) {
		this.detailsOfHandOverFormBean = detailsOfHandOverFormBean;
	}
	
	
	
	
	
}
