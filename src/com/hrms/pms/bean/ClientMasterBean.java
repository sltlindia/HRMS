package com.hrms.pms.bean;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client_master_tbl")
public class ClientMasterBean implements Serializable{
	
	private int client_master_id;
	private String client_master_name;
    private String client_type;

    
    public ClientMasterBean() {
		// TODO Auto-generated constructor stub
    }
    
    
    public ClientMasterBean(String client_master_name, String client_type) {
		super();
		this.client_master_name = client_master_name;
		this.client_type = client_type;
	}
    
    
	@Id
    @Column(name="client_master_id")
    @GeneratedValue
	public int getClient_master_id() {
		return client_master_id;
	}
	   
	 
	public void setClient_master_id(int client_master_id) {
		this.client_master_id = client_master_id;
	}
	@Column(name="client_master_name")
	public String getClient_master_name() {
		return client_master_name;
	}
	public void setClient_master_name(String client_master_name) {
		this.client_master_name = client_master_name;
	}
	@Column(name="client_type")
	public String getClient_type() {
		return client_type;
	}
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}

}
