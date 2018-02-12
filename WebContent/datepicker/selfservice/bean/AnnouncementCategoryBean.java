package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "announcement_category_tbl")
public class AnnouncementCategoryBean {
	
	
	
	private int announcement_category_id;
	private RoleCategoryBean roleCategoryBean;
	private AnnouncementBean announcementBean;
	
	public AnnouncementCategoryBean() {
		super();
	}

	public AnnouncementCategoryBean(RoleCategoryBean roleCategoryBean, AnnouncementBean announcementBean) {
		super();
		this.roleCategoryBean = roleCategoryBean;
		this.announcementBean = announcementBean;
	}

	@Id 
    @Column(name="announcement_category_id")
    @GeneratedValue
	public int getAnnouncement_category_id() {
		return announcement_category_id;
	}
	public void setAnnouncement_category_id(int announcement_category_id) {
		this.announcement_category_id = announcement_category_id;
	}
	
	@ManyToOne
	@JoinColumn(name="role_category_id")
	public RoleCategoryBean getRoleCategoryBean() {
		return roleCategoryBean;
	}

	public void setRoleCategoryBean(RoleCategoryBean roleCategoryBean) {
		this.roleCategoryBean = roleCategoryBean;
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
