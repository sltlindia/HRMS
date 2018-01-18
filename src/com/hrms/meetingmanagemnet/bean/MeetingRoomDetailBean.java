package com.hrms.meetingmanagemnet.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meeting_room_detail_tbl")
public class MeetingRoomDetailBean implements Serializable{

	private int meeting_room_detail_id;
	private String facility;
	private String facility_name;
	private int capacity;
	private String resources;
	private int active;
	
	public MeetingRoomDetailBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id 
    @Column(name="meeting_room_detail_id")
    @GeneratedValue
	public int getMeeting_room_detail_id() {
		return meeting_room_detail_id;
	}
	public void setMeeting_room_detail_id(int meeting_room_detail_id) {
		this.meeting_room_detail_id = meeting_room_detail_id;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	
	
	
	
}
