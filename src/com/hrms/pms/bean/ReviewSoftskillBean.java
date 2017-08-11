package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review_softskill_tbl")
public class ReviewSoftskillBean implements Serializable
{

	
	private int review_softskill_id;
    private String softskill_attachment;
    private String comment_employee;
    private String comment_manager;
    private String manager_soft_attachment;
    
    private ReviewBean reviewBean;
    private SoftskillBean softskillBean;
    private GradeMasterBean gradeMasterBean;
    private ManagerGradeMasterBean managerGradeMasterBean;
    
    
    public ReviewSoftskillBean() {
		// TODO Auto-generated constructor stub
	}
    
    
    public ReviewSoftskillBean(ReviewBean reviewBean,SoftskillBean softskillBean,GradeMasterBean gradeMasterBean,String comment_employee,String softskill_attachment,ManagerGradeMasterBean managerGradeMasterBean,String manager_soft_attachment,String comment_manager) {
        this.reviewBean  = reviewBean;
        this.softskillBean = softskillBean;
        this.gradeMasterBean = gradeMasterBean;
        this.softskill_attachment = softskill_attachment;
        this.comment_employee = comment_employee; 
        this.manager_soft_attachment = manager_soft_attachment;
        this.comment_manager = comment_manager;
    }
    
    public ReviewSoftskillBean(ReviewBean reviewBean,SoftskillBean softskillBean,GradeMasterBean gradeMasterBean,String comment_employee,String softskill_attachment,int review_softskill_id) {
        this.reviewBean  = reviewBean;
        this.softskillBean = softskillBean;
        this.gradeMasterBean = gradeMasterBean;
        this.softskill_attachment = softskill_attachment;
        this.comment_employee = comment_employee; 
        this.review_softskill_id=review_softskill_id;
    }
    
    @Id 
    @Column(name="review_softskill_id")
    @GeneratedValue
	public int getReview_softskill_id() {
		return review_softskill_id;
	}
	public void setReview_softskill_id(int review_softskill_id) {
		this.review_softskill_id = review_softskill_id;
	}
	
	@Column(name="softskill_attachment")
	public String getSoftskill_attachment() {
		return softskill_attachment;
	}
	public void setSoftskill_attachment(String softskill_attachment) {
		this.softskill_attachment = softskill_attachment;
	}
	
	@Column(name="comment_employee")
	public String getComment_employee() {
		return comment_employee;
	}
	public void setComment_employee(String comment_employee) {
		this.comment_employee = comment_employee;
	}

	@ManyToOne
	@JoinColumn(name="review_id")
	public ReviewBean getReviewBean() {
		return reviewBean;
	}


	public void setReviewBean(ReviewBean reviewBean) {
		this.reviewBean = reviewBean;
	}

	@ManyToOne
	@JoinColumn(name="softskill_id")
	public SoftskillBean getSoftskillBean() {
		return softskillBean;
	}


	public void setSoftskillBean(SoftskillBean softskillBean) {
		this.softskillBean = softskillBean;
	}

	@ManyToOne
	@JoinColumn(name="grade_master_id")
	public GradeMasterBean getGradeMasterBean() {
		return gradeMasterBean;
	}


	public void setGradeMasterBean(GradeMasterBean gradeMasterBean) {
		this.gradeMasterBean = gradeMasterBean;
	}


	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="manager_grade_master_id")
	public ManagerGradeMasterBean getManagerGradeMasterBean() {
		return managerGradeMasterBean;
	}


	public void setManagerGradeMasterBean(ManagerGradeMasterBean managerGradeMasterBean) {
		this.managerGradeMasterBean = managerGradeMasterBean;
	}

	@Column(name="comment_manager")
	public String getComment_manager() {
		return comment_manager;
	}


	
	public void setComment_manager(String comment_manager) {
		this.comment_manager = comment_manager;
	}


	@Column(name="manager_soft_attachment")
	public String getManager_soft_attachment() {
		return manager_soft_attachment;
	}


	public void setManager_soft_attachment(String manager_soft_attachment) {
		this.manager_soft_attachment = manager_soft_attachment;
	}
    
    
    
}
