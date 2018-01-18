package com.hrms.meetingmanagemnet.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="meeting_mom_tbl")
public class MeetingMOMBean implements Serializable{

	private int meeting_mom_id;
	private String mom_desc;
	
	private MeetingBookingDetailBean meetingBookingDetailBean;

	public MeetingMOMBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	/**
	 * @param mom_desc
	 * @param meetingBookingDetailBean
	 */
	public MeetingMOMBean(String mom_desc, MeetingBookingDetailBean meetingBookingDetailBean) {
		super();
		this.mom_desc = mom_desc;
		this.meetingBookingDetailBean = meetingBookingDetailBean;
	}







	@Id 
    @Column(name="meeting_mom_id")
    @GeneratedValue
	public int getMeeting_mom_id() {
		return meeting_mom_id;
	}

	public void setMeeting_mom_id(int meeting_mom_id) {
		this.meeting_mom_id = meeting_mom_id;
	}

	
	public String getMom_desc() {
		return mom_desc;
	}

	public void setMom_desc(String mom_desc) {
		this.mom_desc = mom_desc;
	}


	@ManyToOne
	@JoinColumn(name="meeting_booking_detail_id")
	public MeetingBookingDetailBean getMeetingBookingDetailBean() {
		return meetingBookingDetailBean;
	}

	public void setMeetingBookingDetailBean(MeetingBookingDetailBean meetingBookingDetailBean) {
		this.meetingBookingDetailBean = meetingBookingDetailBean;
	}
	
	
	
	
	
}
