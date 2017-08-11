package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="details_of_pending_matters_tbl")
public class DetailsOfPendingMattersBean {

	private int details_of_pending_matters_id;
	private String details_of_important_matters_pending;
	private String pending_matters_status;
	
	
	private DetailsOfHandOverFormBean detailsOfHandOverFormBean;
	
	
	public DetailsOfPendingMattersBean() {
		// TODO Auto-generated constructor stub
	}

	
	public DetailsOfPendingMattersBean(String details_of_important_matters_pending, String pending_matters_status,
			DetailsOfHandOverFormBean detailsOfHandOverFormBean) {
		super();
		this.details_of_important_matters_pending = details_of_important_matters_pending;
		this.pending_matters_status = pending_matters_status;
		this.detailsOfHandOverFormBean = detailsOfHandOverFormBean;
	}


	@Id 
    @Column(name="details_of_pending_matters_id")
    @GeneratedValue
	public int getDetails_of_pending_matters_id() {
		return details_of_pending_matters_id;
	}

	public void setDetails_of_pending_matters_id(int details_of_pending_matters_id) {
		this.details_of_pending_matters_id = details_of_pending_matters_id;
	}


	@Column(name="details_of_important_matters_pending")
	public String getDetails_of_important_matters_pending() {
		return details_of_important_matters_pending;
	}

	public void setDetails_of_important_matters_pending(String details_of_important_matters_pending) {
		this.details_of_important_matters_pending = details_of_important_matters_pending;
	}


	@Column(name="pending_matters_status")
	public String getPending_matters_status() {
		return pending_matters_status;
	}

	public void setPending_matters_status(String pending_matters_status) {
		this.pending_matters_status = pending_matters_status;
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
