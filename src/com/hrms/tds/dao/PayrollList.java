package com.hrms.tds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hrms.tds.bean.PayrollBean;
import com.hrms.tds.bean.PerformancePayBean;
import com.hrms.tds.bean.TDSTotalBBean;
import com.hrms.tds.util.COSMOSDBConnection;
import com.hrms.tds.util.PayrollDBConnection;
import com.hrms.tds.util.SENTDBConnection;
import com.hrms.tds.util.SHRDBConnection;
import com.hrms.tds.util.SRIDBConnection;

public class PayrollList {
	
	private static Connection conn = null ;
	
	public List<PayrollBean> listOfPayroll(int emp_code, String company_name){
		List<PayrollBean> listOfPayroll = new ArrayList<PayrollBean>();
		/*if(company_name.equals("SLT"))
		{
			System.err.println("IN SLT");
			conn = PayrollDBConnection.getConnection();
		}
		else if(company_name.equals("SENT"))
		{
			System.err.println("IN SENT");
			conn = SENTDBConnection.getConnection();
		}
		else if(company_name.equals("SHR"))
		{
			System.err.println("IN SHR");
			conn = SHRDBConnection.getConnection();
		}
		else if(company_name.equals("COSMOS"))
		{
			System.err.println("IN COSMOS");
			conn = COSMOSDBConnection.getConnection();
		}
		else if(company_name.equals("SRI"))
		{
			System.err.println("IN SRI");
			conn = SRIDBConnection.getConnection();
		}*/
		conn = PayrollDBConnection.getConnection();
		try
		{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Emp_Test_Mst WHERE EmpCode ='"+ emp_code +"' AND Company ='"+company_name+"'");
			PayrollBean payrollBean = null ;
			while (rs.next()) {
				payrollBean = new PayrollBean();
				payrollBean.setEmpCode(rs.getInt("EmpCode"));
				payrollBean.setCompany(rs.getString("Company"));
				payrollBean.setEmpName(rs.getString("EmpName"));
				payrollBean.setJoiningDate(rs.getString("JoiningDate"));
				payrollBean.setBasicSalary(rs.getDouble("BasicSalary"));
				payrollBean.setMA(rs.getDouble("MA"));
				payrollBean.setConv(rs.getDouble("Conv"));
				payrollBean.setAll1(rs.getDouble("All1"));
				payrollBean.setAll2(rs.getDouble("All2"));
				payrollBean.setAll3(rs.getDouble("All3"));
				payrollBean.setAll4(rs.getDouble("All4"));
				payrollBean.setAll5(rs.getDouble("All5"));
				payrollBean.setAll6(rs.getDouble("All6"));
				payrollBean.setLTC(rs.getDouble("LTC"));
				payrollBean.setPTax(rs.getDouble("PTax"));
				payrollBean.setPrvSalary(rs.getDouble("PrvSalary"));
				payrollBean.setPF(rs.getDouble("PF"));
				payrollBean.setMonth(rs.getString("Month"));
				payrollBean.setYear(rs.getInt("Year"));
				listOfPayroll.add(payrollBean);
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listOfPayroll ;
	}
	
	public List<PerformancePayBean> listOfPerformancePay(int emp_id, String company_name){
		List<PerformancePayBean> listOfPerformancePay = new ArrayList<PerformancePayBean>();
		if(company_name.equals("SLT"))
		{
			System.err.println("IN SLT");
			conn = PayrollDBConnection.getConnection();
		}
		else if(company_name.equals("SENT"))
		{
			System.err.println("IN SENT");
			conn = SENTDBConnection.getConnection();
		}
		else if(company_name.equals("SHR"))
		{
			System.err.println("IN SHR");
			conn = SHRDBConnection.getConnection();
		}
		else if(company_name.equals("COSMOS"))
		{
			System.err.println("IN COSMOS");
			conn = COSMOSDBConnection.getConnection();
		}
		try
		{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELEct * FROM PerformanceAmt WHERE EmpCode ='"+ emp_id +"' AND Company ='"+company_name+"'");
			PerformancePayBean performancePayBean = null ;
			while (rs.next()) {
				performancePayBean = new PerformancePayBean();
				performancePayBean.setEmpCode(rs.getInt("EmpCode"));
				performancePayBean.setPerAmt(rs.getDouble("PerAmt"));
				listOfPerformancePay.add(performancePayBean);
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listOfPerformancePay ;
	}

}
