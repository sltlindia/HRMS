package com.hrms.corehr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllListDAO;

/**
 * Servlet implementation class NewJoineeNotification
 */
public class NewJoineeNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AllListDAO allListDAO = new AllListDAO();
		List<EmployeeBean> listOfNewJoinee = allListDAO.getListOfAllNewEmployee();
		
		for(EmployeeBean e : listOfNewJoinee) {
			
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			String name = e.getFirstname()+" "+e.getLastname();
			int empCode = e.getEmployee_code();
			String companyName = e.getCompanyListBean().getCompany_name();
			String email = e.getPer_emailid();
			String sub = "Your HRMS LogIn is ready!!!";
			
			if(!email.equalsIgnoreCase("manmeet.singh@sahajanandlaser.com")) {
			
			Mailer.newJoineeNotifcation(email, sub, companyName, name, empCode);
			
			}
			    }
			}).start();
			
		}
	
	}

}
