package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="personal_detail_check_tbl")
public class PersonalDetailCheckBean {
	
	@Id
	@Column(name="personal_detail_check_id")
	@GeneratedValue
	private int personal_detail_check_id;
	private String employee_code;
	private String joining_date;
	private String full_name;
	private String birth_date;
	private String gender;
	private String pan_no;
	private String mobile_no;
	private String landline_no;
	private String marital_status;
	private String nationality;
	private String passport_number;
	private String present_address;
	private String present_city;
	private String present_period_of_stay;
	private String present_state;
	private String present_pincode;
	private String email_id;
	private String present_contact_no;
	private String present_landmark;
	private String alternative_contact_no;
	private String permanent_address;
	private String permanent_city;
	private String permanent_pincode;
	private String permanent_period_of_stay;
	private String permanent_state;
	private String permanent_landmark;
	private String permanent_contact_no;
	
	
	
	private InterviewFeedbackBean interviewFeedbackBean;
	
	public PersonalDetailCheckBean()
	{}

	@Id
	@GeneratedValue
	public int getPersonal_detail_check_id() {
		return personal_detail_check_id;
	}

	public void setPersonal_detail_check_id(int personal_detail_check_id) {
		this.personal_detail_check_id = personal_detail_check_id;
	}

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
	
	@ManyToOne
	@JoinColumn(name = "interview_feedback_id")
	public InterviewFeedbackBean getInterviewFeedbackBean() {
		return interviewFeedbackBean;
	}

	public void setInterviewFeedbackBean(InterviewFeedbackBean interviewFeedbackBean) {
		this.interviewFeedbackBean = interviewFeedbackBean;
	}

	public String getPresent_address() {
		return present_address;
	}

	public void setPresent_address(String present_address) {
		this.present_address = present_address;
	}

	public String getPresent_city() {
		return present_city;
	}

	public void setPresent_city(String present_city) {
		this.present_city = present_city;
	}

	public String getPresent_period_of_stay() {
		return present_period_of_stay;
	}

	public void setPresent_period_of_stay(String present_period_of_stay) {
		this.present_period_of_stay = present_period_of_stay;
	}

	public String getPresent_state() {
		return present_state;
	}

	public void setPresent_state(String present_state) {
		this.present_state = present_state;
	}

	public String getPresent_pincode() {
		return present_pincode;
	}

	public void setPresent_pincode(String present_pincode) {
		this.present_pincode = present_pincode;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPresent_contact_no() {
		return present_contact_no;
	}

	public void setPresent_contact_no(String present_contact_no) {
		this.present_contact_no = present_contact_no;
	}

	public String getPresent_landmark() {
		return present_landmark;
	}

	public void setPresent_landmark(String present_landmark) {
		this.present_landmark = present_landmark;
	}

	public String getAlternative_contact_no() {
		return alternative_contact_no;
	}

	public void setAlternative_contact_no(String alternative_contact_no) {
		this.alternative_contact_no = alternative_contact_no;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getPermanent_city() {
		return permanent_city;
	}

	public void setPermanent_city(String permanent_city) {
		this.permanent_city = permanent_city;
	}

	public String getPermanent_pincode() {
		return permanent_pincode;
	}

	public void setPermanent_pincode(String permanent_pincode) {
		this.permanent_pincode = permanent_pincode;
	}

	public String getPermanent_period_of_stay() {
		return permanent_period_of_stay;
	}

	public void setPermanent_period_of_stay(String permanent_period_of_stay) {
		this.permanent_period_of_stay = permanent_period_of_stay;
	}

	public String getPermanent_state() {
		return permanent_state;
	}

	public void setPermanent_state(String permanent_state) {
		this.permanent_state = permanent_state;
	}

	public String getPermanent_landmark() {
		return permanent_landmark;
	}

	public void setPermanent_landmark(String permanent_landmark) {
		this.permanent_landmark = permanent_landmark;
	}

	public String getPermanent_contact_no() {
		return permanent_contact_no;
	}

	public void setPermanent_contact_no(String permanent_contact_no) {
		this.permanent_contact_no = permanent_contact_no;
	}

	
	public String getLandline_no() {
		return landline_no;
	}

	public void setLandline_no(String landline_no) {
		this.landline_no = landline_no;
	}

	
	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public PersonalDetailCheckBean(String employee_code, String joining_date, String full_name, String birth_date,
			String gender, String pan_no, String marital_status, String nationality, String mobile_no, String passport_number,
			String present_address, String present_city, String present_period_of_stay, String present_state,
			String present_pincode, String email_id, String present_contact_no, String present_landmark,
			String alternative_contact_no, String permanent_address, String permanent_city, String permanent_pincode,
			String permanent_period_of_stay, String permanent_state, String permanent_landmark,
			String permanent_contact_no, String landline_no, InterviewFeedbackBean interviewFeedbackBean) {
		super();
		
		this.employee_code = employee_code;
		this.joining_date = joining_date;
		this.full_name = full_name;
		this.birth_date = birth_date;
		this.gender = gender;
		this.pan_no = pan_no;
		this.marital_status = marital_status;
		this.nationality = nationality;
		this.mobile_no = mobile_no;
		this.passport_number = passport_number;
		this.present_address = present_address;
		this.present_city = present_city;
		this.present_period_of_stay = present_period_of_stay;
		this.present_state = present_state;
		this.present_pincode = present_pincode;
		this.email_id = email_id;
		this.present_contact_no = present_contact_no;
		this.present_landmark = present_landmark;
		this.alternative_contact_no = alternative_contact_no;
		this.permanent_address = permanent_address;
		this.permanent_city = permanent_city;
		this.permanent_pincode = permanent_pincode;
		this.permanent_period_of_stay = permanent_period_of_stay;
		this.permanent_state = permanent_state;
		this.permanent_landmark = permanent_landmark;
		this.permanent_contact_no = permanent_contact_no;
		this.landline_no = landline_no;
		this.interviewFeedbackBean = interviewFeedbackBean;
	}
	
	

}
