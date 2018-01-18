package com.hrms.lms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.formula.functions.Count;

import com.hrms.lms.bean.NopunchBean;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllListDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

public class test {
	
	
	public static void main(String args[]) throws ParseException
	{
		
		int manager_id = 5;
		
		
		LoginDAO loginDAO = new LoginDAO();
		List<EmployeeBean> listOfEmployee = loginDAO.getListByUnderManagerId(manager_id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy 12:00:00 aa");
		 SimpleDateFormat AppDateFormat12 = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		
		 String unplanstartDate = sdf.format(date1);
		    Calendar cq = Calendar.getInstance();
		    Calendar c = Calendar.getInstance();
			 cq.setTime(sdf.parse(unplanstartDate));
			 cq.add(Calendar.DATE,-4);
			 unplanstartDate = sdf.format(cq.getTime());
		
			
			 System.err.println("GAT DATE  " + unplanstartDate);
			 AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
			 
		for(EmployeeBean e : listOfEmployee) {
			int count = 0;
			 String incDate = unplanstartDate;
			 c.setTime(sdf.parse(incDate));
			System.out.println(e.getFirstname());
				int emp_id = e.getEmployee_master_id();
				 for(int co = 0; co <3; co++)
					{ 
					 	c.add(Calendar.DATE, 1);
				    	incDate = sdf.format(c.getTime());
			  		    Date result4 = sdf.parse(incDate);
			  		    incDate = format1.format(result4);
			  		    System.out.println(incDate);
			  		   incDate = AppDateFormat12.format(result4);
			  		    
			  		  List<NopunchBean> listofnopunch = allLMSListDAO.getLeavefornopunch(incDate, emp_id , manager_id);
			  		    if(listofnopunch.size() != 0) {
			  		    	count++;
			  		    }
			  		    
			  		    System.out.println(count);
			  		     
					}
			
		}
		
		
		
	}
	
	
}
