package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="technical_tbl")
public class TechnicalBean implements Serializable
{
		
	    private int criteria_id;
	    private String criteria_desc;
	    
	    public TechnicalBean()
	    {
	    	
	    }
	    
	    @Id 
	    @Column(name="criteria_id")
	    @GeneratedValue
		public int getCriteria_id() {
			return criteria_id;
		}

		public void setCriteria_id(int criteria_id) {
			this.criteria_id = criteria_id;
		}
		
		@Column(name="criteria_desc")
		public String getCriteria_desc() {
			return criteria_desc;
		}

		public void setCriteria_desc(String criteria_desc) {
			this.criteria_desc = criteria_desc;
		}

	    
}
