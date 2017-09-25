package com.hrms.selfservice.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;

/**
 * Servlet implementation class DocumentDataListServlet
 */
public class DocumentDataListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		int employee_master_id = user.getEmployee_master_id();
		
		AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
		SelfServiceQuerybean selfServiceQuerybean =  allListSelfServiceDAO.getLastAddedData(employee_master_id);
		
		System.out.println(selfServiceQuerybean.getSelfservice_query_id());
		
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat ddMMyyyy= new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat ddMMMyyyy= new SimpleDateFormat("dd-MMM-yyyy");
		
		try {
			selfServiceQuerybean.setDate_of_submission(ddMMMyyyy.format(yyyyMMdd.parse(selfServiceQuerybean.getDate_of_submission())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(selfServiceQuerybean);

		System.out.println(jsonArray);

		response.getWriter().print(jsonArray);
	}

}
