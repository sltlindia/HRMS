package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.DepartmentBean;

@Entity
@Table(name = "announcement_department_tbl")
public class AnnouncementDepartmentBean {

	
	private int announcement_department_id;
	private DepartmentBean departmentBean;
	private AnnouncementBean announcementBean;
	public AnnouncementDepartmentBean() {
		super();
	}
	public AnnouncementDepartmentBean(DepartmentBean departmentBean, AnnouncementBean announcementBean) {
		super();
		this.departmentBean = departmentBean;
		this.announcementBean = announcementBean;
	}
	
	
	public AnnouncementDepartmentBean(int announcement_department_id, DepartmentBean departmentBean,
			AnnouncementBean announcementBean) {
		super();
		this.announcement_department_id = announcement_department_id;
		this.departmentBean = departmentBean;
		this.announcementBean = announcementBean;
	}
	@Id 
    @Column(name="announcement_department_id")
    @GeneratedValue
	public int getAnnouncement_department_id() {
		return announcement_department_id;
	}
	public void setAnnouncement_department_id(int announcement_department_id) {
		this.announcement_department_id = announcement_department_id;
	}
	@ManyToOne
	@JoinColumn(name="department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
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
