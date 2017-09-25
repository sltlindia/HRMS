package com.hrms.vehicletracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.vehicletracking.dao.AllDeleteVtsDAO;

/**
 * Servlet implementation class VehicleServiceRecordDeleteServlet
 */
public class VehicleServiceRecordDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int vehicle_service_record_id = Integer.parseInt(request.getParameter("vehicle_service_id"));
		
		AllDeleteVtsDAO allDeleteVtsDAO = new AllDeleteVtsDAO();
		
		allDeleteVtsDAO.vehicleServiceRecordDelete(vehicle_service_record_id);
		request.getRequestDispatcher("vehicleServiceRecordForm.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
