package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.recruitement.bean.CompanyListBean;

@Entity
@Table(name = "announcement_company_tbl")
public class AnnouncementCompanyBean {
	
	private int announcement_company_id;
	private CompanyListBean companyListBean;
	private AnnouncementBean announcementBean;
	
	
	
	public AnnouncementCompanyBean() {
		super();
	}
	public AnnouncementCompanyBean(CompanyListBean companyListBean, AnnouncementBean announcementBean) {
		super();
		this.companyListBean = companyListBean;
		this.announcementBean = announcementBean;
	}
	
	public AnnouncementCompanyBean(int announcement_company_id, CompanyListBean companyListBean,
			AnnouncementBean announcementBean) {
		super();
		this.announcement_company_id = announcement_company_id;
		this.companyListBean = companyListBean;
		this.announcementBean = announcementBean;
	}
	@Id 
    @Column(name="announcement_company_id")
    @GeneratedValue
	public int getAnnouncement_company_id() {
		return announcement_company_id;
	}
	public void setAnnouncement_company_id(int announcement_company_id) {
		this.announcement_company_id = announcement_company_id;
	}
	@ManyToOne
	@JoinColumn(name="company_list_id")
	public CompanyListBean getCompanyListBean() {
		return companyListBean;
	}
	public void setCompanyListBean(CompanyListBean companyListBean) {
		this.companyListBean = companyListBean;
	}
	@ManyToOne
	@JoinColumn(name="announcement_id")
	public AnnouncementBean getAnnouncementBean() {
		return announcementBean;
	}
	public void setAnnouncementBean(AnnouncementBean announcementBean) {
		this.announcementBean = announcementBean;
	}
	
	
	
}
