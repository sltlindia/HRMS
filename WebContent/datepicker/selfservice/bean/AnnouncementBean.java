package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
@Entity
@Table(name = "announcement_tbl")
public class AnnouncementBean {
	
	
	private int announcement_id;
	private String announcement_title;
	private String announcement_description;
	private String announcement_attachment;
	private String announcement_enddate;
	private String announcement_submission_date;
	private String from_time;
	private String to_time;
	private String announcment_date;
	private EmployeeBean employeeBean;
	
	
	
	
	public AnnouncementBean() {
		super();
	}
	
	public AnnouncementBean(String announcement_title, String announcement_description, String announcement_attachment,
			String announcement_enddate, String announcement_submission_date, EmployeeBean employeeBean,String from_time,String to_time,String announcement_date) {
		super();
		this.announcement_title = announcement_title;
		this.announcement_description = announcement_description;
		this.announcement_attachment = announcement_attachment;
		this.announcement_enddate = announcement_enddate;
		this.announcement_submission_date = announcement_submission_date;
		this.employeeBean = employeeBean;
		this.from_time = from_time;
		this.to_time = to_time;
		this.announcment_date = announcement_date;
	}

	@Id 
    @Column(name="announcement_id")
    @GeneratedValue
	public int getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}
	@Column(name="announcement_title")
	public String getAnnouncement_title() {
		return announcement_title;
	}
	public void setAnnouncement_title(String announcement_title) {
		this.announcement_title = announcement_title;
	}
	@Column(name="announcement_description")
	public String getAnnouncement_description() {
		return announcement_description;
	}
	public void setAnnouncement_description(String announcement_description) {
		this.announcement_description = announcement_description;
	}
	@Column(name="announcement_attachment")
	public String getAnnouncement_attachment() {
		return announcement_attachment;
	}
	public void setAnnouncement_attachment(String announcement_attachment) {
		this.announcement_attachment = announcement_attachment;
	}
	@Column(name="announcement_enddate")
	public String getAnnouncement_enddate() {
		return announcement_enddate;
	}
	public void setAnnouncement_enddate(String announcement_enddate) {
		this.announcement_enddate = announcement_enddate;
	}
	@Column(name="announcement_submission_date")
	public String getAnnouncement_submission_date() {
		return announcement_submission_date;
	}
	public void setAnnouncement_submission_date(String announcement_submission_date) {
		this.announcement_submission_date = announcement_submission_date;
	}
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@Column(name="from_time")
	public String getFrom_time() {
		return from_time;
	}

	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}
	@Column(name="to_time")
	public String getTo_time() {
		return to_time;
	}

	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}
	@Column(name="announcement_date")
	public String getAnnouncment_date() {
		return announcment_date;
	}

	public void setAnnouncment_date(String announcment_date) {
		this.announcment_date = announcment_date;
	}
	
	
	

}
