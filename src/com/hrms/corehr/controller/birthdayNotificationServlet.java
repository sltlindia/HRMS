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
 * Servlet implementation class birthdayNotificationServlet
 */
public class birthdayNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AllListDAO allListDAO = new AllListDAO();
		List<EmployeeBean> listOfBirthDays =  allListDAO.getListOfBirthDays();

		for(EmployeeBean bday : listOfBirthDays){
			
			String to = bday.getEmail_id();
			String sub = "Happy Birthday!!!";
			String name = bday.getFirstname()+" "+bday.getLastname();
			
			Mailer.birthdayNotification(to, sub, name);
			
		}
		
	}

}
