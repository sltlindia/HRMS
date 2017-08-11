package com.hrms.timesheet.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="holiday_tbl")
public class HolidayBean {

	private int holiday_id;
	private String holiday_name;
	private String holiday_date;
	private String compnay_name;
	private String holiday_optional;
	
	public HolidayBean(){
	}
	
	
	public HolidayBean(String holiday_date , String holiday_name,String compnay_name,String holiday_optional){
		this.holiday_date = holiday_date;
		this.holiday_name = holiday_name;
		this.compnay_name = compnay_name;
		this.holiday_optional = holiday_optional;
	}
	
	@Id
	@Column(name="holiday_id")
	@GeneratedValue
	public int getHoliday_id() {
		return holiday_id;
	}

	public void setHoliday_id(int holiday_id) {
		this.holiday_id = holiday_id;
	}
	
	@Column(name="holiday_name")
	public String getHoliday_name() {
		return holiday_name;
	}

	public void setHoliday_name(String holiday_name) {
		this.holiday_name = holiday_name;
	}

	@Column(name="holiday_date")
	public String getHoliday_date() {
		return holiday_date;
	}

	public void setHoliday_date(String holiday_date) {
		this.holiday_date = holiday_date;
	}

	@Column(name="compnay_name")
	public String getCompnay_name() {
		return compnay_name;
	}

	public void setCompnay_name(String compnay_name) {
		this.compnay_name = compnay_name;
	}

	@Column(name="holiday_optional")
	public String getHoliday_optional() {
		return holiday_optional;
	}

	public void setHoliday_optional(String holiday_optional) {
		this.holiday_optional = holiday_optional;
	}

}
