package com.hrms.kaizen.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kaizen_before_upload_attachment_tbl")
public class KaizenBeforeUploadAttachmentBean implements Serializable {

	private int kaizen_before_upload_attachment_id;
	private String kaizen_before_uploaded_attachment_name;
	private KaizenBean kaizenBean;
	
	
	
	
	
	public KaizenBeforeUploadAttachmentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KaizenBeforeUploadAttachmentBean(String kaizen_before_uploaded_attachment_name, KaizenBean kaizenBean) {
		super();
		this.kaizen_before_uploaded_attachment_name = kaizen_before_uploaded_attachment_name;
		this.kaizenBean = kaizenBean;
	}

	@Id 
    @Column(name="kaizen_before_upload_attachment_id")
    @GeneratedValue
	public int getKaizen_before_upload_attachment_id() {
		return kaizen_before_upload_attachment_id;
	}
	public void setKaizen_before_upload_attachment_id(int kaizen_before_upload_attachment_id) {
		this.kaizen_before_upload_attachment_id = kaizen_before_upload_attachment_id;
	}
	
	
	public String getKaizen_before_uploaded_attachment_name() {
		return kaizen_before_uploaded_attachment_name;
	}
	public void setKaizen_before_uploaded_attachment_name(String kaizen_before_uploaded_attachment_name) {
		this.kaizen_before_uploaded_attachment_name = kaizen_before_uploaded_attachment_name;
	}
	
	@ManyToOne
	@JoinColumn(name="kaizen_id")
	public KaizenBean getKaizenBean() {
		return kaizenBean;
	}


	public void setKaizenBean(KaizenBean kaizenBean) {
		this.kaizenBean = kaizenBean;
	}
	
}
