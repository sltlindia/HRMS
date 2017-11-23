package com.hrms.tds.bean;

import java.lang.Double;
import java.util.Enumeration;

import com.hrms.tds.dao.PayrollList;
import com.hrms.tds.dao.TDSListDAO;

public class test{
	
	    public static void main(String[] args) {
	       
	    	int emp_code = 725;
	    	String company_code = "App";
	    	PayrollList payrollList = new PayrollList();
	    	double count = payrollList.getCount(emp_code,company_code);
	    	System.err.println(count);
	        }
}
	
	
 

