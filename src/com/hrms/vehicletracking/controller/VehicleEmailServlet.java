package com.hrms.vehicletracking.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.mailer.Mailer;
import com.hrms.vehicletracking.bean.VehiclePolicyDocumentBean;
import com.hrms.vehicletracking.dao.AllListVtsDAO;

/**
 * Servlet implementation class VehicleEmailServlet
 */
public class VehicleEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
		List<VehiclePolicyDocumentBean> listOfPolicyNull  = allListVtsDAO.getListOfDocumentsPolicyNull();
		List<VehiclePolicyDocumentBean> listOfPolicy  = allListVtsDAO.getListOfDocuments();
		Date date_today = new Date();
		String email = "frontoffice@sahajanandlaser.com";
		for(VehiclePolicyDocumentBean vehiclePolicyDocumentBean : listOfPolicyNull){
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			    	String to = email;
			    	String sub =  "Vehicle Policy Document Reminder";
			    	
			    	Mailer.sendPolicyDocument(to, sub, vehiclePolicyDocumentBean.getVehicleBean().getVehicle_name(),vehiclePolicyDocumentBean.getRegistration_no(),vehiclePolicyDocumentBean.getPolicy_no(),vehiclePolicyDocumentBean.getPolicy_issued_on(),vehiclePolicyDocumentBean.getPeriod_of_insurance());
			    	System.out.println("Done");
			    }
			}).start();
	}
		for(VehiclePolicyDocumentBean vehiclePolicyDocumentBean : listOfPolicy){
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            String today = dateFormat.format(date_today);
		String end_date_policy =  vehiclePolicyDocumentBean.getPeriod_of_insurance();
		System.out.print("end_date_policy"+end_date_policy);
		System.out.print("today"+today);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date_today);
		cal.add(Calendar.DATE, 31);
		Date dateAfter30Days = cal.getTime();
		String before30day = dateFormat.format(dateAfter30Days);
		System.out.print("before30day"+before30day);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date_today);
		cal1.add(Calendar.DATE, 15);
		Date dateAfter15Days = cal1.getTime();
		  String before15day = dateFormat.format(dateAfter15Days);
		  System.out.print("before15day"+before15day);
		  Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date_today);
			cal2.add(Calendar.DATE, 7);
			Date dateAfter7Days = cal2.getTime();
			 String before7day = dateFormat.format(dateAfter7Days);
			 System.out.print("before7day"+before7day);
if(end_date_policy.equalsIgnoreCase(before30day)){
	new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	
	    	String to = email;
	    	String sub =  "Vehicle Policy Expiration Reminder";
	    	
	    	Mailer.sendPolicyExpired30Day(to, sub, vehiclePolicyDocumentBean.getVehicleBean().getVehicle_name(),vehiclePolicyDocumentBean.getRegistration_no(),vehiclePolicyDocumentBean.getPolicy_no(),vehiclePolicyDocumentBean.getPolicy_issued_on(),vehiclePolicyDocumentBean.getPeriod_of_insurance(),before30day);
	    	System.out.println("Done");
	    }
	}).start();
}if(end_date_policy.equalsIgnoreCase(before15day)){
	new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	
	    	String to = email;
	    	String sub =  "Vehicle Policy Expiration Reminder";
	    	
	    	Mailer.sendPolicyExpired15Day(to, sub, vehiclePolicyDocumentBean.getVehicleBean().getVehicle_name(),vehiclePolicyDocumentBean.getRegistration_no(),vehiclePolicyDocumentBean.getPolicy_no(),vehiclePolicyDocumentBean.getPolicy_issued_on(),vehiclePolicyDocumentBean.getPeriod_of_insurance(),before15day);
	    	System.out.println("Done");
	    }
	}).start();
}
if(end_date_policy.equalsIgnoreCase(before7day)){
	new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	
	    	String to = email;
	    	String sub =  "Vehicle Policy Expiration Reminder";
	    	
	    	Mailer.sendPolicyExpired7Day(to, sub, vehiclePolicyDocumentBean.getVehicleBean().getVehicle_name(),vehiclePolicyDocumentBean.getRegistration_no(),vehiclePolicyDocumentBean.getPolicy_no(),vehiclePolicyDocumentBean.getPolicy_issued_on(),vehiclePolicyDocumentBean.getPeriod_of_insurance(),before7day);
	    	System.out.println("Done");
	    }
	}).start();
	}
if(end_date_policy.equalsIgnoreCase(today)){
	new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	
	    	String to = email;
	    	String sub =  "Vehicle Policy Expiration Reminder";
	    	
	    	Mailer.sendPolicyExpiredToday(to, sub, vehiclePolicyDocumentBean.getVehicleBean().getVehicle_name(),vehiclePolicyDocumentBean.getRegistration_no(),vehiclePolicyDocumentBean.getPolicy_no(),vehiclePolicyDocumentBean.getPolicy_issued_on(),vehiclePolicyDocumentBean.getPeriod_of_insurance(),today);
	    	System.out.println("Done");
	    }
	}).start();
	}
		}

}
}