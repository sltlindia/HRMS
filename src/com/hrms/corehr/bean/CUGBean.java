package com.hrms.corehr.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="and_cug_list")
public class CUGBean implements Serializable {

	public int ID;
	public String Empoloyee_Name;
	public String Designation;
	public String Location;
	public String Email;
	public String mob_num;
	public String Belongto;
	
	
	
	public CUGBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Id
    @Column(name="iD")
    @GeneratedValue
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEmpoloyee_Name() {
		return Empoloyee_Name;
	}
	public void setEmpoloyee_Name(String empoloyee_Name) {
		Empoloyee_Name = empoloyee_Name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getBelongto() {
		return Belongto;
	}
	public void setBelongto(String belongto) {
		Belongto = belongto;
	}



	public String getMob_num() {
		return mob_num;
	}



	public void setMob_num(String mob_num) {
		this.mob_num = mob_num;
	}
	
	
	
	
	
	
	
	
}
