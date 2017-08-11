package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_design_head_tbl")
public class ProjectDesignHeadBean implements Serializable{
	
	private int project_design_head_id;
	private String design_input_name;
	private String head;
	private String head1;
	private String head2;
	private String head3;
	private String head4;
	private String head5;
	private String head6;
	private String head7;
	private String head8;
	private String head9;
	private String head10;
	private String head11;
	private String head12;
	private String head13;
	private String head14;
	private String head15;
	private String head16;
	private String head17;
	private String head18;
	private String head19;
	private String head20;
	private String submission_date;
	
	private ProjectMasterBean projectMasterBean;

	
	public ProjectDesignHeadBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProjectDesignHeadBean(String design_input_name, String head, String head1, String head2, String head3,
			String head4, String head5, String head6, String head7, String head8, String head9, String head10,
			String head11, String head12, String head13, String head14, String head15, String head16, String head17,
			String head18, String head19, String head20, ProjectMasterBean projectMasterBean, String submission_date) {
		super();
		this.design_input_name = design_input_name;
		this.head = head;
		this.head1 = head1;
		this.head2 = head2;
		this.head3 = head3;
		this.head4 = head4;
		this.head5 = head5;
		this.head6 = head6;
		this.head7 = head7;
		this.head8 = head8;
		this.head9 = head9;
		this.head10 = head10;
		this.head11 = head11;
		this.head12 = head12;
		this.head13 = head13;
		this.head14 = head14;
		this.head15 = head15;
		this.head16 = head16;
		this.head17 = head17;
		this.head18 = head18;
		this.head19 = head19;
		this.head20 = head20;
		this.projectMasterBean = projectMasterBean;
		this.submission_date = submission_date;
	}
	
	
	

	public ProjectDesignHeadBean(int project_design_head_id, String design_input_name, String head, String head1,
			String head2, String head3, String head4, String head5, String head6, String head7, String head8,
			String head9, String head10, String head11, String head12, String head13, String head14, String head15,
			String head16, String head17, String head18, String head19, String head20,
			ProjectMasterBean projectMasterBean, String submission_date) {
		super();
		this.project_design_head_id = project_design_head_id;
		this.design_input_name = design_input_name;
		this.head = head;
		this.head1 = head1;
		this.head2 = head2;
		this.head3 = head3;
		this.head4 = head4;
		this.head5 = head5;
		this.head6 = head6;
		this.head7 = head7;
		this.head8 = head8;
		this.head9 = head9;
		this.head10 = head10;
		this.head11 = head11;
		this.head12 = head12;
		this.head13 = head13;
		this.head14 = head14;
		this.head15 = head15;
		this.head16 = head16;
		this.head17 = head17;
		this.head18 = head18;
		this.head19 = head19;
		this.head20 = head20;
		this.projectMasterBean = projectMasterBean;
		this.submission_date = submission_date;
	}


	@Id 
    @Column(name="project_design_head_id")
    @GeneratedValue
	public int getProject_design_head_id() {
		return project_design_head_id;
	}

	public void setProject_design_head_id(int project_design_head_id) {
		this.project_design_head_id = project_design_head_id;
	}

	public String getDesign_input_name() {
		return design_input_name;
	}

	public void setDesign_input_name(String design_input_name) {
		this.design_input_name = design_input_name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getHead1() {
		return head1;
	}

	public void setHead1(String head1) {
		this.head1 = head1;
	}

	public String getHead2() {
		return head2;
	}

	public void setHead2(String head2) {
		this.head2 = head2;
	}

	public String getHead3() {
		return head3;
	}

	public void setHead3(String head3) {
		this.head3 = head3;
	}

	public String getHead4() {
		return head4;
	}

	public void setHead4(String head4) {
		this.head4 = head4;
	}

	public String getHead5() {
		return head5;
	}

	public void setHead5(String head5) {
		this.head5 = head5;
	}

	public String getHead6() {
		return head6;
	}

	public void setHead6(String head6) {
		this.head6 = head6;
	}

	public String getHead7() {
		return head7;
	}

	public void setHead7(String head7) {
		this.head7 = head7;
	}

	public String getHead8() {
		return head8;
	}

	public void setHead8(String head8) {
		this.head8 = head8;
	}

	public String getHead9() {
		return head9;
	}

	public void setHead9(String head9) {
		this.head9 = head9;
	}

	public String getHead10() {
		return head10;
	}

	public void setHead10(String head10) {
		this.head10 = head10;
	}

	public String getHead11() {
		return head11;
	}

	public void setHead11(String head11) {
		this.head11 = head11;
	}

	public String getHead12() {
		return head12;
	}

	public void setHead12(String head12) {
		this.head12 = head12;
	}

	public String getHead13() {
		return head13;
	}

	public void setHead13(String head13) {
		this.head13 = head13;
	}

	public String getHead14() {
		return head14;
	}

	public void setHead14(String head14) {
		this.head14 = head14;
	}

	public String getHead15() {
		return head15;
	}

	public void setHead15(String head15) {
		this.head15 = head15;
	}

	public String getHead16() {
		return head16;
	}

	public void setHead16(String head16) {
		this.head16 = head16;
	}

	public String getHead17() {
		return head17;
	}

	public void setHead17(String head17) {
		this.head17 = head17;
	}

	public String getHead18() {
		return head18;
	}

	public void setHead18(String head18) {
		this.head18 = head18;
	}

	public String getHead19() {
		return head19;
	}

	public void setHead19(String head19) {
		this.head19 = head19;
	}

	public String getHead20() {
		return head20;
	}

	public void setHead20(String head20) {
		this.head20 = head20;
	}

	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}

	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}


	public String getSubmission_date() {
		return submission_date;
	}


	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	
	
	
	
	

}
