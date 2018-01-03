package com.hrms.meetingmanagemnet.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="meeting_booking_detail_tbl")
public class MeetingBookingDetailBean implements Serializable{

	private int meeting_booking_detail_id;
	private String employee_name;
	private String meeting_name;
	private String meeting_purpose;
	private int participant_no; 
	private Date date;
	private Date from_time;
	private Date to_time;
	
	
	private EmployeeBean employeeBean;
	private DepartmentBean departmentBean;
	private MeetingRoomDetailBean meetingRoomDetailBean;
	
	
	public MeetingBookingDetailBean() {
		// TODO Auto-generated constructor stub
	}



	public MeetingBookingDetailBean(int meeting_booking_detail_id, String employee_name, String meeting_name,
			String meeting_purpose, int participant_no, Date date, Date from_time, Date to_time,
			EmployeeBean employeeBean, DepartmentBean departmentBean, MeetingRoomDetailBean meetingRoomDetailBean) {
		super();
		this.meeting_booking_detail_id = meeting_booking_detail_id;
		this.employee_name = employee_name;
		this.meeting_name = meeting_name;
		this.meeting_purpose = meeting_purpose;
		this.participant_no = participant_no;
		this.date = date;
		this.from_time = from_time;
		this.to_time = to_time;
		this.employeeBean = employeeBean;
		this.departmentBean = departmentBean;
		this.meetingRoomDetailBean = meetingRoomDetailBean;
	}
	
	public MeetingBookingDetailBean(String employee_name, String meeting_name, String meeting_purpose,
			int participant_no, Date date, Date from_time, Date to_time, EmployeeBean employeeBean,
			DepartmentBean departmentBean, MeetingRoomDetailBean meetingRoomDetailBean) {
		super();
		this.employee_name = employee_name;
		this.meeting_name = meeting_name;
		this.meeting_purpose = meeting_purpose;
		this.participant_no = participant_no;
		this.date = date;
		this.from_time = from_time;
		this.to_time = to_time;
		this.employeeBean = employeeBean;
		this.departmentBean = departmentBean;
		this.meetingRoomDetailBean = meetingRoomDetailBean;
	}



	@Id 
    @Column(name="meeting_booking_detail_id")
    @GeneratedValue
	public int getMeeting_booking_detail_id() {
		return meeting_booking_detail_id;
	}
	public void setMeeting_booking_detail_id(int meeting_booking_detail_id) {
		this.meeting_booking_detail_id = meeting_booking_detail_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getMeeting_name() {
		return meeting_name;
	}
	public void setMeeting_name(String meeting_name) {
		this.meeting_name = meeting_name;
	}
	public String getMeeting_purpose() {
		return meeting_purpose;
	}
	public void setMeeting_purpose(String meeting_purpose) {
		this.meeting_purpose = meeting_purpose;
	}
	public int getParticipant_no() {
		return participant_no;
	}
	public void setParticipant_no(int participant_no) {
		this.participant_no = participant_no;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getFrom_time() {
		return from_time;
	}
	public void setFrom_time(Date from_time) {
		this.from_time = from_time;
	}
	public Date getTo_time() {
		return to_time;
	}
	public void setTo_time(Date to_time) {
		this.to_time = to_time;
	}
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
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
	@JoinColumn(name="meeting_room_detail_id")
	public MeetingRoomDetailBean getMeetingRoomDetailBean() {
		return meetingRoomDetailBean;
	}
	public void setMeetingRoomDetailBean(MeetingRoomDetailBean meetingRoomDetailBean) {
		this.meetingRoomDetailBean = meetingRoomDetailBean;
	}
	
}
