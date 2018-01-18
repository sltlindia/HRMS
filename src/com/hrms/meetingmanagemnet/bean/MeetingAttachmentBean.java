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
@Table(name="meeting_attachment_tbl")
public class MeetingAttachmentBean implements Serializable{

	
	private int meeting_attachment_id;
	private String attchment_name;
	
	private MeetingBookingDetailBean meetingBookingDetailBean;

	
	public MeetingAttachmentBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	/**
	 * @param attchment_name
	 * @param meetingBookingDetailBean
	 */
	public MeetingAttachmentBean(String attchment_name, MeetingBookingDetailBean meetingBookingDetailBean) {
		super();
		this.attchment_name = attchment_name;
		this.meetingBookingDetailBean = meetingBookingDetailBean;
	}

	@Id 
    @Column(name="meeting_attachment_id")
    @GeneratedValue
	public int getMeeting_attachment_id() {
		return meeting_attachment_id;
	}

	public void setMeeting_attachment_id(int meeting_attachment_id) {
		this.meeting_attachment_id = meeting_attachment_id;
	}

	public String getAttchment_name() {
		return attchment_name;
	}

	public void setAttchment_name(String attchment_name) {
		this.attchment_name = attchment_name;
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
