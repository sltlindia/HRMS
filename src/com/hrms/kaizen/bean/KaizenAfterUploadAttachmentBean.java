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
@Table(name="kaizen_after_upload_attachment_tbl")
public class KaizenAfterUploadAttachmentBean implements Serializable{

	
	private int kaizen_after_upload_attachment_id;
	private String kaizen_after_uploaded_attachment_name;
	private KaizenBean kaizenBean;
	
	
	public KaizenAfterUploadAttachmentBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public KaizenAfterUploadAttachmentBean(String kaizen_after_uploaded_attachment_name) {
		super();
		this.kaizen_after_uploaded_attachment_name = kaizen_after_uploaded_attachment_name;
	}
	
	
	
	public KaizenAfterUploadAttachmentBean(String kaizen_after_uploaded_attachment_name, KaizenBean kaizenBean) {
		super();
		this.kaizen_after_uploaded_attachment_name = kaizen_after_uploaded_attachment_name;
		this.kaizenBean = kaizenBean;
	}


	/*public KaizenAfterUploadAttachmentBean(int kaizen_after_upload_attachment_id,
			String kaizen_after_uploaded_attachment_name) {
		super();
		this.kaizen_after_upload_attachment_id = kaizen_after_upload_attachment_id;
		this.kaizen_after_uploaded_attachment_name = kaizen_after_uploaded_attachment_name;
	}*/
	
	@Id 
    @Column(name="kaizen_after_upload_attachment_id")
    @GeneratedValue
	public int getKaizen_after_upload_attachment_id() {
		return kaizen_after_upload_attachment_id;
	}
	
	
	public void setKaizen_after_upload_attachment_id(int kaizen_after_upload_attachment_id) {
		this.kaizen_after_upload_attachment_id = kaizen_after_upload_attachment_id;
	}
	
	
	
	
	public String getKaizen_after_uploaded_attachment_name() {
		return kaizen_after_uploaded_attachment_name;
	}
	
	
	public void setKaizen_after_uploaded_attachment_name(String kaizen_after_uploaded_attachment_name) {
		this.kaizen_after_uploaded_attachment_name = kaizen_after_uploaded_attachment_name;
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
