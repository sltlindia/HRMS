package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="softskill_tbl")
public class SoftskillBean implements Serializable
{

	@Id @GeneratedValue
    private int softskill_id;
    private String softskill_desc;
    
    
    public SoftskillBean() {
		// TODO Auto-generated constructor stub
    }

    @Id
    @Column(name="softskill_id")
    @GeneratedValue
	public int getSoftskill_id() {
		return softskill_id;
	}


	public void setSoftskill_id(int softskill_id) {
		this.softskill_id = softskill_id;
	}

	@Column(name="softskill_desc")
	public String getSoftskill_desc() {
		return softskill_desc;
	}


	public void setSoftskill_desc(String softskill_desc) {
		this.softskill_desc = softskill_desc;
	}


	


	

	
    
}
