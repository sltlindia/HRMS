/*
 * Created by 	: Akash Ramani
	Date 		: 15-06-2017 
*/

package com.hrms.appAuthority.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TBL")
public class UserBean implements Serializable{
	
	private int USER_ID;;
	private String USER_NAME;
	private String CARDENTIAL;
	private String PASSWORD;
	private String MAIN_LOCATION;
	private String SUB_LOCATION;
	private int AUTHENTICATION;
	private String IP;
	private int emp_id;
	private int MANAGER_ID;
	private int UNDER_MANAGER_ID;
	private String EMAIL_ID;
	
	
	
	
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param uSER_NAME
	 * @param cARDENTIAL
	 * @param pASSWORD
	 * @param mAIN_LOCATION
	 * @param sUB_LOCATION
	 * @param aUTHENTICATION
	 * @param iP
	 * @param emp_id
	 * @param mANAGER_ID
	 * @param uNDER_MANAGER_ID
	 * @param eMAIL_ID
	 */
	public UserBean(String uSER_NAME, String cARDENTIAL, String pASSWORD, String mAIN_LOCATION, String sUB_LOCATION,
			int aUTHENTICATION, String iP, int emp_id, int mANAGER_ID, int uNDER_MANAGER_ID, String eMAIL_ID) {
		super();
		USER_NAME = uSER_NAME;
		CARDENTIAL = cARDENTIAL;
		PASSWORD = pASSWORD;
		MAIN_LOCATION = mAIN_LOCATION;
		SUB_LOCATION = sUB_LOCATION;
		AUTHENTICATION = aUTHENTICATION;
		IP = iP;
		this.emp_id = emp_id;
		MANAGER_ID = mANAGER_ID;
		UNDER_MANAGER_ID = uNDER_MANAGER_ID;
		EMAIL_ID = eMAIL_ID;
	}





	@Id
	@Column(name="USER_ID")
    @GeneratedValue
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getCARDENTIAL() {
		return CARDENTIAL;
	}
	public void setCARDENTIAL(String cARDENTIAL) {
		CARDENTIAL = cARDENTIAL;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getMAIN_LOCATION() {
		return MAIN_LOCATION;
	}
	public void setMAIN_LOCATION(String mAIN_LOCATION) {
		MAIN_LOCATION = mAIN_LOCATION;
	}
	public String getSUB_LOCATION() {
		return SUB_LOCATION;
	}
	public void setSUB_LOCATION(String sUB_LOCATION) {
		SUB_LOCATION = sUB_LOCATION;
	}
	public int getAUTHENTICATION() {
		return AUTHENTICATION;
	}
	public void setAUTHENTICATION(int aUTHENTICATION) {
		AUTHENTICATION = aUTHENTICATION;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}

	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}



	public int getMANAGER_ID() {
		return MANAGER_ID;
	}


	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}


	public int getUNDER_MANAGER_ID() {
		return UNDER_MANAGER_ID;
	}


	public void setUNDER_MANAGER_ID(int uNDER_MANAGER_ID) {
		UNDER_MANAGER_ID = uNDER_MANAGER_ID;
	}


	public String getEMAIL_ID() {
		return EMAIL_ID;
	}



	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	






	
	
	
	

}
