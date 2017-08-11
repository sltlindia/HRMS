package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="family_relation_tbl")
public class FamilyRelationBean implements Serializable{

	private int family_relation_id;
	private String relation;
	
	
	public FamilyRelationBean() {
		// TODO Auto-generated constructor stub
	}
	
	public FamilyRelationBean(String relation) {
		super();
		this.relation = relation;
	}

	@Id
	@Column(name="family_relation_id")
    @GeneratedValue
	public int getFamily_relation_id() {
		return family_relation_id;
	}

	public void setFamily_relation_id(int family_relation_id) {
		this.family_relation_id = family_relation_id;
	}

	@Column(name="relation")
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
	
	
	
	
	
}
