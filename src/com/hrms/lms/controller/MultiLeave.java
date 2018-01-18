package com.hrms.lms.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.bean.NopunchBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.util.DBConnection;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllListDAO;

public class MultiLeave
{

	public static void main(String args[]) throws ParseException
	{
		AllListDAO allListDAO = new AllListDAO();
		List<EmployeeBean> listofemp = allListDAO.getFullListOfEmployee();
		
		Connection conn = null;
		Statement smt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		
		Date date1 = new Date();
		
		try
		{
			smt = conn.createStatement();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy 12:00:00 aa");
		 SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 SimpleDateFormat AppDateFormat12 = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss aa");
	     String incDate = null , company_code = null , COMPANYCODE = null , NAME = null, DEPARTMENT = null , UNDERMANAGERID = "";
	     int EMP_MASTER_ID = 0 , emp_code = 0;
	   
	    // String unplanstartDate = sdf.format(date1);"11/18/2017"
	    String unplanstartDate = "07/02/2017";
	    /*Calendar cq = Calendar.getInstance();
		 cq.setTime(sdf.parse(unplanstartDate));
		 cq.add(Calendar.DATE,-7);
		 unplanstartDate = sdf.format(cq.getTime());*/
		
		 System.err.println("GAT DATE  " + unplanstartDate);
		 
			String sw = null;		
	     
			AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		for(EmployeeBean e : listofemp)
		{
			EMP_MASTER_ID = e.getEmployee_master_id();
	 		int rowCount = 0;
    
	 		emp_code = e.getEmployee_code();
			UNDERMANAGERID = e.getUnder_manager_id();
			sw = e.getSub_department();
			
			company_code = e.getCompanyListBean().getCompany_code();
			String date = unplanstartDate;
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(date));
			int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
			try
			{
				smt.executeQuery("SELECT * FROM FingerTec_TimeTrack.dbo.Emp_Master e , FingerTec_TimeTrack.dbo.Department_Master d  WHERE EMP_CODE = " + emp_code  + " AND Code = '" + company_code +"' AND e.Dept_Id = d.Dept_Id");
				rs = smt.getResultSet();
				
				if(rs.next())
				{
					COMPANYCODE = rs.getString(1);
					NAME = rs.getString(9);
					DEPARTMENT = rs.getString(22);
				}
				else
				{
					COMPANYCODE = "";
					NAME = "";
			 		DEPARTMENT = "";
				}
				
				System.out.println(maxDay);
				

			    for(int co = 0; co <maxDay; co++)
				{ 
			    	co = co + 1;
			    	String OD = "";
			    	boolean sundayflag = false;
			    	incDate = sdf.format(c.getTime());
		  		    Date result4 = sdf.parse(incDate);
		  		    incDate = format1.format(result4);
		  		    System.out.println(co);
		  		    System.out.println(incDate);
			    	smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where EMP_CODE = '" + emp_code + "' AND Code='"+company_code+"' ");
		      		rs = smt.getResultSet();
		      		int enrollNo = 0;
		      		List<String> listOfAllPunch = new ArrayList<String>();
		      		if(rs.next())
		    		  {
		      			 enrollNo = Integer.parseInt(rs.getString(10));
		    		  }
		      		
		      		
		      		 smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.In_Out_Detail where EnrollNo = "+enrollNo+" AND Date = '" + incDate + "'");
		             rs = smt.getResultSet();
		             
		             c.add(Calendar.DATE, 1); 
		             if(result4.getDay() == 0)
		        		{
		        			System.out.println("SUNDAY" + incDate);
		        		
		        			
		        			sundayflag = true;
		        		}
		             
		             
		             while (rs.next())
		             { 
		            	 
		            	 
		            	 if(rs.getString(9) != null)
		            	 {
		                     listOfAllPunch.add(rs.getString(9));
		                 }
		                    
		            	 if(rs.getString(10) != null)
		            	 {
		                     listOfAllPunch.add(rs.getString(10));
		                 }
		            	 
		            	 String GatePassDate = null;
		 				
		 				GatePassDate = AppDateFormat12.format(result4);
		            	 List<LeaveODBean> listOfOD = allLMSListDAO.getODForHDSL(GatePassDate,GatePassDate,EMP_MASTER_ID);
		 				for(LeaveODBean leaveODBean : listOfOD)
		 				{
		 					
		 					OD = "YES";
		 					//System.out.println("OD Exist");
		 					
		 				}
		 				
		 				System.out.println(listOfAllPunch);
		 				
		 				String a = AppDateFormat12.format(result4);
		 				
		 				List<LeaveBean> listofleave = allLMSListDAO.getLeavefromtodate(a, a, EMP_MASTER_ID);
		 				
		 				
		 				//System.err.println("COafasf " + listofleave.size());
		 				  	int Show_View = 0;
		 				  	int ManagerId = Integer.parseInt(UNDERMANAGERID);
		 				AllInsertDAO allInsertDAO = new AllInsertDAO();
		 					if(listOfAllPunch.size() == 0)
		 			         {
		 					  
		 						 if(!OD.equals("YES") || listofleave.size() == 0)
		 						 {

		 				      		//System.err.println("CO " + co);
		 				      		
		 							 String maindate = AppDateFormat12.format(result4);
		 							 EmployeeBean employeeBean = new EmployeeBean();
		 							 employeeBean.setEmployee_master_id(EMP_MASTER_ID);
		 							 
		 							 List<NopunchBean> listofnopunch = allLMSListDAO.getLeavefornopunch(maindate, EMP_MASTER_ID , ManagerId);
		 							 if(listofnopunch.size() != 0)
		 							 {
		 								 System.out.println("exist");
		 							 }
		 							 else
		 							 {
		 								 if(sundayflag == false)
		 								 {
		 									NopunchBean nopunchBean = new NopunchBean(employeeBean , maindate ,Show_View , ManagerId);
				 							boolean result = allInsertDAO.leaveInsertformultiple(nopunchBean);
				 				        	 System.out.println("Leave " + NAME + " EMP MASTER ID " + EMP_MASTER_ID  +" UNDER MANAGER ID " +  UNDERMANAGERID);
				 				        	 
		 								 }
		 								
		 							 }
		 							 
		 							 
		 				        	 
		 						 }
		 			         } 
		             }	
				}	
			}
			catch (Exception ex) {
				// TODO: handle exception
			}
		}		
	}
}
