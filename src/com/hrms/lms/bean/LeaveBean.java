package com.hrms.lms.bean;

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
@Table(name="leave_tbl")
public class LeaveBean implements Serializable
{
	@Id
	@GeneratedValue
	private int leave_id;
	//private int Employee_master_id; 
	private String Purpose_of_Leave	; 
	private int LeaveType_ID; 
	private String Leave_From; 
	private String from_half;
	private String Leave_To; 
	private String to_half;
	private double Day_count; 
	private double CO;
	private double PL;
	private double SL;
	private double LWP;
	private String Address; 
	private String Number;
	private String approval_rejected_date;
	private int under_manager_id; 
	private String status;
	private String reason;
	private int show_view;
	private String pushMainDate;
	private String popMainDate;
	private int unplan_leave_counter;
	private String HR_Flag_unplan_leave;
	private String HOD_Flag_unplan_leave;
	private String HR_unplan_leave_approval_date;
	private String HOD_unplan_leave_approval_date;
	private String submission_date;
	private String sunday;
	private String holiday;
	private int month_ID;
	private EmployeeBean employeeBean;
	//private LeaveTypeBean leaveTypeBean;
	//private LeaveTypeBean leaveTypeBean2;
	
	public LeaveBean()
	{
		
	}
	
	
	public LeaveBean(int LeaveType_ID, EmployeeBean employeeBean, String Purpose_of_Leave, String Leave_From, String from_half, String Leave_To , String to_half ,
			double Day_count, double CO , double PL , double SL , double LWP, String Address , String Number, int under_manager_id, String status , 
			int show_view , String pushMainDate , String popMainDate , int unplan_leave_counter , String HR_Flag_unplan_leave , String HOD_Flag_unplan_leave,String submission_date,
			String sunday, String holiday , int month_ID)
	{
		this.LeaveType_ID = LeaveType_ID;
		this.employeeBean = employeeBean;
		this.Purpose_of_Leave = Purpose_of_Leave;
		this.Leave_From = Leave_From;
		this.from_half = from_half;
		this.Leave_To = Leave_To;
		this.to_half = to_half;
		this.Day_count = Day_count;
		this.CO = CO;
		this.PL = PL;
		this.SL = SL;
		this.LWP = LWP;
		this.Number = Number;
		this.Address =Address;
		this.under_manager_id =under_manager_id;
		this.status = status;
		this.show_view = show_view;
		this.pushMainDate = pushMainDate;
		this.popMainDate = popMainDate;
		this.unplan_leave_counter = unplan_leave_counter;
		this.HR_Flag_unplan_leave = HR_Flag_unplan_leave;
		this.HOD_Flag_unplan_leave = HR_Flag_unplan_leave;
		this.submission_date = submission_date;
		this.sunday = sunday;
		this.holiday = holiday;
		this.month_ID = month_ID;
		
	}
	
	/*public LeaveBean(EmployeeBean employeeBean, String Purpose_of_Leave,  String Leave_From, String Leave_To , double Day_count,  double adj1 , double adj2 , 
			double adj3 , String Address , String Number, int under_manager_id, String status)
	{
		this.employeeBean = employeeBean;
		this.Purpose_of_Leave = Purpose_of_Leave;
		this.leaveTypeBean = leaveTypeBean;
		this.Leave_From = Leave_From;
		this.Leave_To = Leave_To;
		this.Day_count = Day_count;
		
		this.Number = Number;
		this.Address =Address;
		this.under_manager_id =under_manager_id;
		this.status = status;
	}
*/
	
	
	
	public LeaveBean(String status , String reason, int leave_id)
	{
		this.status = status;
		this.reason = reason;
		this.leave_id = leave_id;
	}

	
	 @Id 
	 @Column(name="leave_id")
	 @GeneratedValue
	public int getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}

	public int getLeaveType_ID() {
		return LeaveType_ID;
	}

	public void setLeaveType_ID(int leaveType_ID) {
		LeaveType_ID = leaveType_ID;
	}


	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	public String getPurpose_of_Leave() {
		return Purpose_of_Leave;
	}

	public void setPurpose_of_Leave(String purpose_of_Leave) {
		Purpose_of_Leave = purpose_of_Leave;
	}

	
	/*@ManyToOne
	@JoinColumn(name="leave_type_id")
	public LeaveTypeBean getLeaveTypeBean() {
		return leaveTypeBean;
	}

	public void setLeaveTypeBean(LeaveTypeBean leaveTypeBean) {
		this.leaveTypeBean = leaveTypeBean;
	}
	*/
	
	@Column(name="Leave_From")
	public String getLeave_From() {
		return Leave_From;
	}

	public void setLeave_From(String leave_From) {
		Leave_From = leave_From;
	}

	public String getFrom_half() {
		return from_half;
	}

	public void setFrom_half(String from_half) {
		this.from_half = from_half;
	}

	
	public String getLeave_To() {
		return Leave_To;
	}

	public void setLeave_To(String leave_To) {
		Leave_To = leave_To;
	}


	public String getTo_half() {
		return to_half;
	}

	public void setTo_half(String to_half) {
		this.to_half = to_half;
	}
	
	public double getDay_count() {
		return Day_count;
	}

	public void setDay_count(double day_count) {
		Day_count = day_count;
	}
	
	
	
	public double getCO() {
		return CO;
	}

	public void setCO(double cO) {
		CO = cO;
	}

	public double getPL() {
		return PL;
	}

	public void setPL(double pL) {
		PL = pL;
	}

	public double getSL() {
		return SL;
	}

	public void setSL(double sL) {
		SL = sL;
	}

	public double getLWP() {
		return LWP;
	}

	public void setLWP(double lWP) {
		LWP = lWP;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	
	public int getUnder_manager_id() {
		return under_manager_id;
	}

	public void setUnder_manager_id(int under_manager_id) {
		this.under_manager_id = under_manager_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	public int getShow_view() {
		return show_view;
	}


	public void setShow_view(int show_view) {
		this.show_view = show_view;
	}


	public String getPushMainDate() {
		return pushMainDate;
	}


	public void setPushMainDate(String pushMainDate) {
		this.pushMainDate = pushMainDate;
	}


	public String getPopMainDate() {
		return popMainDate;
	}


	public void setPopMainDate(String popMainDate) {
		this.popMainDate = popMainDate;
	}


	public int getUnplan_leave_counter() {
		return unplan_leave_counter;
	}


	public void setUnplan_leave_counter(int unplan_leave_counter) {
		this.unplan_leave_counter = unplan_leave_counter;
	}


	public String getHR_Flag_unplan_leave() {
		return HR_Flag_unplan_leave;
	}


	public void setHR_Flag_unplan_leave(String hR_Flag_unplan_leave) {
		HR_Flag_unplan_leave = hR_Flag_unplan_leave;
	}


	public String getHOD_Flag_unplan_leave() {
		return HOD_Flag_unplan_leave;
	}


	public void setHOD_Flag_unplan_leave(String hOD_Flag_unplan_leave) {
		HOD_Flag_unplan_leave = hOD_Flag_unplan_leave;
	}


	public String getHR_unplan_leave_approval_date() {
		return HR_unplan_leave_approval_date;
	}


	public void setHR_unplan_leave_approval_date(String hR_unplan_leave_approval_date) {
		HR_unplan_leave_approval_date = hR_unplan_leave_approval_date;
	}


	public String getHOD_unplan_leave_approval_date() {
		return HOD_unplan_leave_approval_date;
	}


	public void setHOD_unplan_leave_approval_date(String hOD_unplan_leave_approval_date) {
		HOD_unplan_leave_approval_date = hOD_unplan_leave_approval_date;
	}


	public String getSubmission_date() {
		return submission_date;
	}


	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}


	public String getApproval_rejected_date() {
		return approval_rejected_date;
	}


	public void setApproval_rejected_date(String approval_rejected_date) {
		this.approval_rejected_date = approval_rejected_date;
	}


	public String getSunday() {
		return sunday;
	}


	public void setSunday(String sunday) {
		this.sunday = sunday;
	}


	public String getHoliday() {
		return holiday;
	}


	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}


	public int getMonth_ID() {
		return month_ID;
	}


	public void setMonth_ID(int month_ID) {
		this.month_ID = month_ID;
	}


	
}
