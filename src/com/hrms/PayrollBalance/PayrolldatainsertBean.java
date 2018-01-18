package com.hrms.PayrollBalance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.CompanyListBean;

@Entity
@Table(name="payrollleavecutbalance_tbl")
public class PayrolldatainsertBean 
{

	private int Payroll_ID; 
	private EmployeeBean employeeBean;
	private CompanyListBean companyListBean;
	private double PL;
	private double UPL;
	private double HL;
	private double SL;
	private double CO;
	private double HCO;
	private double LC;
	private int monthID;
	private int yearID;
	
	
	public PayrolldatainsertBean()
	{
		
	}
	
	
	public PayrolldatainsertBean(EmployeeBean employeeBean , CompanyListBean companyListBean , double PL , double UPL , double HL , double SL , double CO , double HCO , double LC , int monthID , int yearID)
	{
		this.employeeBean = employeeBean;
		this.companyListBean = companyListBean;
		this.PL = PL;
		this.UPL = UPL;
		this.HL = HL;
		this.SL = SL;
		this.CO = CO;
		this.HCO = HCO;
		this.LC = LC;
		this.monthID = monthID;
		this.yearID = yearID;
	}

	@Id 
    @Column(name="Payroll_ID")
    @GeneratedValue
	public int getPayroll_ID() {
		return Payroll_ID;
	}


	public void setPayroll_ID(int payroll_ID) {
		Payroll_ID = payroll_ID;
	}

	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@ManyToOne
	@JoinColumn(name="company_list_id")
	public CompanyListBean getCompanyListBean() {
		return companyListBean;
	}


	public void setCompanyListBean(CompanyListBean companyListBean) {
		this.companyListBean = companyListBean;
	}


	public double getPL() {
		return PL;
	}


	public void setPL(double pL) {
		PL = pL;
	}


	public double getUPL() {
		return UPL;
	}


	public void setUPL(double uPL) {
		UPL = uPL;
	}


	public double getHL() {
		return HL;
	}


	public void setHL(double hL) {
		HL = hL;
	}


	public double getSL() {
		return SL;
	}


	public void setSL(double sL) {
		SL = sL;
	}


	public double getCO() {
		return CO;
	}


	public void setCO(double cO) {
		CO = cO;
	}


	public double getHCO() {
		return HCO;
	}


	public void setHCO(double hCO) {
		HCO = hCO;
	}


	public double getLC() {
		return LC;
	}


	public void setLC(double lC) {
		LC = lC;
	}


	public int getMonthID() {
		return monthID;
	}


	public void setMonthID(int monthID) {
		this.monthID = monthID;
	}


	public int getYearID() {
		return yearID;
	}


	public void setYearID(int yearID) {
		this.yearID = yearID;
	}
	
	
	
	
}
