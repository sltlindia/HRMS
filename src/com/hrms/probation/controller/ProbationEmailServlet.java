package com.hrms.probation.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.probation.bean.ProbationAssessmentM2Bean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.dao.AllListProbationDAO;

/**
 * Servlet implementation class ProbationEmailServlet
 */
public class ProbationEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		LoginDAO loginDAO = new LoginDAO();
		String joining_date = null;
		String manager_email_id = null;
		List<EmployeeBean> listOfEmployeesUnderProbation = loginDAO.getListOfEmployeeUnderProbation();
		for(EmployeeBean employeeBean : listOfEmployeesUnderProbation){
			int under_manager_id = Integer.parseInt(employeeBean.getUnder_manager_id());
			if(under_manager_id != 0){
			joining_date = employeeBean.getJoining_date();
			int emp_id = employeeBean.getEmployee_master_id();
			EmployeeBean employeeBean2 = loginDAO.getEmailId(under_manager_id);
			manager_email_id = employeeBean2.getEmail_id();
			String manager_name  = employeeBean2.getFirstname()+" "+employeeBean2.getLastname();
			String name = employeeBean.getFirstname()+" "+employeeBean.getLastname();
			String salutation = employeeBean.getSalutation();
			String mindate = "2017-10-31";
			
			
			
			Date date1 = null;
			Date minDateDate = null;
			
			AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
			List<ProbationExtendBean> listOfExtended = allListProbationDAO
					.getProbationExtendByEmpId(emp_id);
			
			int to_be_extended = 6;
			
			for (ProbationExtendBean p : listOfExtended) {
				String extend_period = p.getExtended_period();
				to_be_extended = to_be_extended + Integer.parseInt(extend_period);
			}
			
			
			
			try {
				 date1 = new SimpleDateFormat("yyyy-MM-dd").parse(joining_date);
				 minDateDate = new SimpleDateFormat("yyyy-MM-dd").parse(mindate);
			} catch (java.text.ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			Calendar cal = Calendar.getInstance();
			Calendar cal1 = Calendar.getInstance();
			cal.setTime(date1);
			cal1.setTime(date1);
			int day = cal.get(Calendar.DAY_OF_MONTH);

			
			if(day>=15){
				cal.add(Calendar.MONTH, 1); 
				cal1.add(Calendar.MONTH, 1);
				joining_date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			}
			
			
			
			
			
			Date date = new Date();
			
			/*System.out.println(employeeBean.getFirstname()+" "+employeeBean.getLastname());*/
			/*System.out.println("join_date:"+joining_date);
			System.out.println("curr_date:"+date);
			*/
			
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			Date join = null;
			try {
				join = s.parse(joining_date);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(join);
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(date);

			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
			
			
			/*System.out.println("monthDiff:"+diffMonth);*/
			
			int loop = to_be_extended;
			
			if(diffMonth<to_be_extended){
				loop =diffMonth;
			}
			
			
			String email = manager_email_id;
			String finalDate = null;
			String monthFinal = null;
			String yearFinal = null;
			
			System.out.println(date1);
			System.out.println(minDateDate);
			
			if(date1.after(minDateDate)){
			for(int i=0;i<=loop;i++){
				cal.add(Calendar.MONTH, 1);
				
				if(date.after(cal.getTime()) || date.equals(cal.getTime())){
					System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal1.getTime()));
			
					int month = cal.get(Calendar.MONTH); 
					int year = cal.get(Calendar.YEAR); 
					
					YearBean yearBean = allListProbationDAO.yearCheck(year);
					
					String finalDate1 = new SimpleDateFormat("yyyy-MM-dd").format(cal1.getTime());
					int month_id_print = cal1.get(Calendar.MONTH) + 1;
					
					MonthBean monthBean = allListProbationDAO.getInfoById(month_id_print);
					String month_name_print = monthBean.getMonth_name();
					String year_print = String.valueOf(cal1.get(Calendar.YEAR));
					if(yearBean != null){
					int year_id = yearBean.getYear_id();
					List<ProbationAssessmentM2Bean> listOfEmployeesM2 = allListProbationDAO
							.getProbationCheckMonthM2(emp_id, month, year_id);
					
					if(listOfEmployeesM2.size() != 0){
						System.out.println("Probation Filled");
					}else{
						
						if (finalDate == null) {
							finalDate = finalDate1 ;
							monthFinal = month_name_print +"-"+ year_print;
						} else {
							finalDate = finalDate + "," + finalDate1;
							monthFinal = monthFinal +","+ month_name_print +"-"+ year_print;
						}
						
					}
					}
						
				}
				
				cal1.add(Calendar.MONTH, 1);
				
			}
			String f = monthFinal;
			if(f != null){
				
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			    	String to = email;
			    	String sub = name + "'s Probation Assessment Form Reminder";
			    	
			    	Mailer.sendProbationEmail(to, sub, name,f,manager_name,salutation);
			    	System.out.println("Done");
			    }
			}).start();
			
			
			}
			}
		
		}
		}
	}
	
}
