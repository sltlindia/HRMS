package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="details_of_responsibilities_tbl")
public class DetailsOfResponsibilitiesBean {

	private int details_of_responsibilities_id;
	private String detail_of_responsibilities;
	private String responibility_status;
	
	
	private DetailsOfHandOverFormBean detailsOfHandOverFormBean;
	
	public DetailsOfResponsibilitiesBean() {
		// TODO Auto-generated constructor stub
	}

	public DetailsOfResponsibilitiesBean(String detail_of_responsibilities, String responibility_status,
			DetailsOfHandOverFormBean detailsOfHandOverFormBean) {
		super();
		this.detail_of_responsibilities = detail_of_responsibilities;
		this.responibility_status = responibility_status;
		this.detailsOfHandOverFormBean = detailsOfHandOverFormBean;
	}

	
	@Id 
    @Column(name="details_of_responsibilities_id")
    @GeneratedValue
	public int getDetails_of_responsibilities_id() {
		return details_of_responsibilities_id;
	}

	public void setDetails_of_responsibilities_id(int details_of_responsibilities_id) {
		this.details_of_responsibilities_id = details_of_responsibilities_id;
	}

	
	@Column(name="detail_of_responsibilities")
	public String getDetail_of_responsibilities() {
		return detail_of_responsibilities;
	}

	public void setDetail_of_responsibilities(String detail_of_responsibilities) {
		this.detail_of_responsibilities = detail_of_responsibilities;
	}

	
	@Column(name="responibility_status")
	public String getResponibility_status() {
		return responibility_status;
	}

	public void setResponibility_status(String responibility_status) {
		this.responibility_status = responibility_status;
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
