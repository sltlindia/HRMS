package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="review_criteria_tbl")
public class ReviewCriteriaBean implements Serializable
{

	
	private int review_criteria_id;
    private String criteria_attachment;
    private String comment_employee;
    private String comment_manager;
    private String manager_tech_attachment;
    
    private TechnicalBean technicalBean;
    private ReviewBean reviewBean;
    private GradeMasterBean gradeMasterBean;
    private ManagerGradeMasterBean managerGradeMasterBean;
    
    
    public ReviewCriteriaBean() {
	}
    
    
    
    public ReviewCriteriaBean(ReviewBean reviewBean,TechnicalBean technicalBean,GradeMasterBean gradeMasterBean,String comment_employee,String criteria_attachment,ManagerGradeMasterBean managerGradeMasterBean,String manager_tech_attachment,String comment_manager) {
        this.reviewBean  = reviewBean;
        this.technicalBean = technicalBean;
        this.gradeMasterBean = gradeMasterBean;
        this.criteria_attachment = criteria_attachment;
        this.comment_employee = comment_employee;
        this.manager_tech_attachment = manager_tech_attachment;
        this.comment_manager = comment_manager;
    }
    
    public ReviewCriteriaBean(ReviewBean reviewBean,TechnicalBean technicalBean,GradeMasterBean gradeMasterBean,String comment_employee,String criteria_attachment,int review_criteria_id) {
        this.reviewBean  = reviewBean;
        this.technicalBean = technicalBean;
        this.gradeMasterBean = gradeMasterBean;
        this.criteria_attachment = criteria_attachment;
        this.comment_employee = comment_employee;
        this.review_criteria_id = review_criteria_id;
    }
    
    @Id 
    @Column(name="review_criteria_id")
    @GeneratedValue
	public int getReview_criteria_id() {
		return review_criteria_id;
	}
	public void setReview_criteria_id(int review_criteria_id) {
		this.review_criteria_id = review_criteria_id;
	}
	
	@Column(name="criteria_attachment")
	public String getCriteria_attachment() {
		return criteria_attachment;
	}
	public void setCriteria_attachment(String criteria_attachment) {
		this.criteria_attachment = criteria_attachment;
	}
	
	@Column(name="comment_employee")
	public String getComment_employee() {
		return comment_employee;
	}
	public void setComment_employee(String comment_employee) {
		this.comment_employee = comment_employee;
	}

	@ManyToOne
	@JoinColumn(name="criteria_id")
	public TechnicalBean getTechnicalBean() {
		return technicalBean;
	}

	public void setTechnicalBean(TechnicalBean technicalBean) {
		this.technicalBean = technicalBean;
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


	@Column(name="manager_tech_attachment")
	public String getManager_tech_attachment() {
		return manager_tech_attachment;
	}



	public void setManager_tech_attachment(String manager_tech_attachment) {
		this.manager_tech_attachment = manager_tech_attachment;
	}
    
	
	
    
}
