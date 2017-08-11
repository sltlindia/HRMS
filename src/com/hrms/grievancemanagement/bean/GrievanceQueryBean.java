package com.hrms.grievancemanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="grievance_query_tbl")
public class GrievanceQueryBean implements Serializable{
	
	private int grievance_query_id;
	private String query;
	private String attachment;
	private String status;
	private String date_of_submission;
	private String date_of_resolve;
	private String reply;
	private String reply_attachment;
	private int show_view;
	private int escalation_id;
	
	
	private EmployeeBean employeeBean;
	private GrievanceQueryTypeBean grievanceQueryTypeBean;
	
	public GrievanceQueryBean() {

	}
	public GrievanceQueryBean(String query, String attachment, EmployeeBean employeeBean, String status, String date_of_submission, String date_of_resolve, GrievanceQueryTypeBean grievanceQueryTypeBean, String reply, String reply_attachment, int show_view,int escalation_id) {
		this.query = query;
		this.attachment = attachment;
		this.employeeBean = employeeBean;
		this.status = status;
		this.date_of_submission = date_of_submission;
		this.date_of_resolve = date_of_resolve;
		this.grievanceQueryTypeBean = grievanceQueryTypeBean;
		this.reply = reply;
		this.reply_attachment = reply_attachment;
		this.show_view = show_view;
		this.escalation_id = escalation_id;

	}

	@Id 
    @Column(name="grievance_query_id")
    @GeneratedValue
	public int getGrievance_query_id() {
		return grievance_query_id;
	}

	public void setGrievance_query_id(int grievance_query_id) {
		this.grievance_query_id = grievance_query_id;
	}

	@Column(name="query")
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	
	@Column(name="attachment")
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="date_of_submission")
	public String getDate_of_submission() {
		return date_of_submission;
	}
	public void setDate_of_submission(String date_of_submission) {
		this.date_of_submission = date_of_submission;
	}
	
	@Column(name="date_of_resolve")
	public String getDate_of_resolve() {
		return date_of_resolve;
	}
	public void setDate_of_resolve(String date_of_resolve) {
		this.date_of_resolve = date_of_resolve;
	}
	
	@ManyToOne
	@JoinColumn(name="grievance_query_type_id")
	public GrievanceQueryTypeBean getGrievanceQueryTypeBean() {
		return grievanceQueryTypeBean;
	}
	public void setGrievanceQueryTypeBean(GrievanceQueryTypeBean grievanceQueryTypeBean) {
		this.grievanceQueryTypeBean = grievanceQueryTypeBean;
	}
	
	@Column(name="reply")
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	@Column(name="reply_attachment")
	public String getReply_attachment() {
		return reply_attachment;
	}
	public void setReply_attachment(String reply_attachment) {
		this.reply_attachment = reply_attachment;
	}
	
	@Column(name="show_view")
	public int getShow_view() {
		return show_view;
	}
	public void setShow_view(int show_view) {
		this.show_view = show_view;
	}
	
	@Column(name="escalation_id")
	public int getEscalation_id() {
		return escalation_id;
	}
	public void setEscalation_id(int escalation_id) {
		this.escalation_id = escalation_id;
	}
	
	
	
	
	
	
	
	
}
