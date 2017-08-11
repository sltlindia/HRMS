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
@Table(name="project_design_inputs_tbl")
public class ProjectDesignInputsBean implements Serializable {
	
	private int project_design_inputs_id;
	private String design_inputs_name;
	private String remarks;
	private String remarks1;
	private String remarks2;
	private String remarks3;
	private String remarks4;
	private String remarks5;
	private String remarks6;
	private String remarks7;
	private String remarks8;
	private String remarks9;
	private String remarks10;
	private String remarks11;
	private String remarks12;
	private String remarks13;
	private String remarks14;
	private String remarks15;
	private String remarks16;
	private String remarks17;
	private String remarks18;
	private String remarks19;
	private String remarks20;
	private String submission_date;
	
	private ProjectMasterBean projectMasterBean;
	
	public ProjectDesignInputsBean() {
		// TODO Auto-generated constructor stub
	}
	



	public ProjectDesignInputsBean(String design_inputs_name, String remarks, String remarks1, String remarks2,
			String remarks3, String remarks4, String remarks5, String remarks6, String remarks7, String remarks8,
			String remarks9, String remarks10, String remarks11, String remarks12, String remarks13, String remarks14,
			String remarks15, String remarks16, String remarks17, String remarks18, String remarks19, String remarks20,
			ProjectMasterBean projectMasterBean, String submission_date) {
		super();
		this.design_inputs_name = design_inputs_name;
		this.remarks = remarks;
		this.remarks1 = remarks1;
		this.remarks2 = remarks2;
		this.remarks3 = remarks3;
		this.remarks4 = remarks4;
		this.remarks5 = remarks5;
		this.remarks6 = remarks6;
		this.remarks7 = remarks7;
		this.remarks8 = remarks8;
		this.remarks9 = remarks9;
		this.remarks10 = remarks10;
		this.remarks11 = remarks11;
		this.remarks12 = remarks12;
		this.remarks13 = remarks13;
		this.remarks14 = remarks14;
		this.remarks15 = remarks15;
		this.remarks16 = remarks16;
		this.remarks17 = remarks17;
		this.remarks18 = remarks18;
		this.remarks19 = remarks19;
		this.remarks20 = remarks20;
		this.projectMasterBean = projectMasterBean;
		this.submission_date = submission_date;
	}

	
	



	public ProjectDesignInputsBean(int project_design_inputs_id, String design_inputs_name, String remarks,
			String remarks1, String remarks2, String remarks3, String remarks4, String remarks5, String remarks6,
			String remarks7, String remarks8, String remarks9, String remarks10, String remarks11, String remarks12,
			String remarks13, String remarks14, String remarks15, String remarks16, String remarks17, String remarks18,
			String remarks19, String remarks20, ProjectMasterBean projectMasterBean, String submission_date) {
		super();
		this.project_design_inputs_id = project_design_inputs_id;
		this.design_inputs_name = design_inputs_name;
		this.remarks = remarks;
		this.remarks1 = remarks1;
		this.remarks2 = remarks2;
		this.remarks3 = remarks3;
		this.remarks4 = remarks4;
		this.remarks5 = remarks5;
		this.remarks6 = remarks6;
		this.remarks7 = remarks7;
		this.remarks8 = remarks8;
		this.remarks9 = remarks9;
		this.remarks10 = remarks10;
		this.remarks11 = remarks11;
		this.remarks12 = remarks12;
		this.remarks13 = remarks13;
		this.remarks14 = remarks14;
		this.remarks15 = remarks15;
		this.remarks16 = remarks16;
		this.remarks17 = remarks17;
		this.remarks18 = remarks18;
		this.remarks19 = remarks19;
		this.remarks20 = remarks20;
		this.projectMasterBean = projectMasterBean;
		this.submission_date = submission_date;
	}




	@Id 
    @Column(name="project_design_inputs_id")
    @GeneratedValue
	public int getProject_design_inputs_id() {
		return project_design_inputs_id;
	}
	public void setProject_design_inputs_id(int project_design_inputs_id) {
		this.project_design_inputs_id = project_design_inputs_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}
	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}


	public String getDesign_inputs_name() {
		return design_inputs_name;
	}


	public void setDesign_inputs_name(String design_inputs_name) {
		this.design_inputs_name = design_inputs_name;
	}


	public String getRemarks1() {
		return remarks1;
	}


	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}


	public String getRemarks2() {
		return remarks2;
	}


	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}


	public String getRemarks3() {
		return remarks3;
	}


	public void setRemarks3(String remarks3) {
		this.remarks3 = remarks3;
	}


	public String getRemarks4() {
		return remarks4;
	}


	public void setRemarks4(String remarks4) {
		this.remarks4 = remarks4;
	}


	public String getRemarks5() {
		return remarks5;
	}


	public void setRemarks5(String remarks5) {
		this.remarks5 = remarks5;
	}


	public String getRemarks6() {
		return remarks6;
	}


	public void setRemarks6(String remarks6) {
		this.remarks6 = remarks6;
	}


	public String getRemarks7() {
		return remarks7;
	}


	public void setRemarks7(String remarks7) {
		this.remarks7 = remarks7;
	}


	public String getRemarks8() {
		return remarks8;
	}


	public void setRemarks8(String remarks8) {
		this.remarks8 = remarks8;
	}


	public String getRemarks9() {
		return remarks9;
	}


	public void setRemarks9(String remarks9) {
		this.remarks9 = remarks9;
	}


	public String getRemarks10() {
		return remarks10;
	}


	public void setRemarks10(String remarks10) {
		this.remarks10 = remarks10;
	}


	public String getRemarks11() {
		return remarks11;
	}


	public void setRemarks11(String remarks11) {
		this.remarks11 = remarks11;
	}


	public String getRemarks12() {
		return remarks12;
	}


	public void setRemarks12(String remarks12) {
		this.remarks12 = remarks12;
	}


	public String getRemarks13() {
		return remarks13;
	}


	public void setRemarks13(String remarks13) {
		this.remarks13 = remarks13;
	}


	public String getRemarks14() {
		return remarks14;
	}


	public void setRemarks14(String remarks14) {
		this.remarks14 = remarks14;
	}


	public String getRemarks15() {
		return remarks15;
	}


	public void setRemarks15(String remarks15) {
		this.remarks15 = remarks15;
	}


	public String getRemarks16() {
		return remarks16;
	}


	public void setRemarks16(String remarks16) {
		this.remarks16 = remarks16;
	}


	public String getRemarks17() {
		return remarks17;
	}


	public void setRemarks17(String remarks17) {
		this.remarks17 = remarks17;
	}


	public String getRemarks18() {
		return remarks18;
	}


	public void setRemarks18(String remarks18) {
		this.remarks18 = remarks18;
	}


	public String getRemarks19() {
		return remarks19;
	}


	public void setRemarks19(String remarks19) {
		this.remarks19 = remarks19;
	}


	public String getRemarks20() {
		return remarks20;
	}


	public void setRemarks20(String remarks20) {
		this.remarks20 = remarks20;
	}




	public String getSubmission_date() {
		return submission_date;
	}




	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	
	
	
	
	

}
