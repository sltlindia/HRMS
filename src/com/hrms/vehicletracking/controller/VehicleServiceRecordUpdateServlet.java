package com.hrms.vehicletracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.vehicletracking.bean.DriverBean;
import com.hrms.vehicletracking.bean.VehicleBean;
import com.hrms.vehicletracking.bean.VehicleServiceRecordBean;
import com.hrms.vehicletracking.bean.VehicleTrackingBean;
import com.hrms.vehicletracking.dao.AllInsertVtsDAO;

/**
 * Servlet implementation class VehicleServiceRecordUpdateServlet
 */
public class VehicleServiceRecordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	

		int vehicle_service_id = Integer.parseInt(request.getParameter("vehicle_service_id"));
		System.out.println("vehicle_service_id"+vehicle_service_id);
		String record_date = request.getParameter("date");
		System.out.println("date"+record_date);
		String free_service = request.getParameter("free_service");
		System.out.println("free_service"+free_service);
		String driver_name = request.getParameter("driver_name");
		System.out.println("driver_name"+driver_name);
		int driver_id = Integer.parseInt(request.getParameter("driver_id"));
		System.out.println("driver_id"+driver_id);
		int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
		System.out.println("vehicle_id"+vehicle_id);
		String items_change = request.getParameter("items");
		System.out.println("items"+items_change);
		double amount = Double.parseDouble(request.getParameter("amount"));
		System.out.println("amount"+amount);
		
	
		VehicleBean vehicleBean = new VehicleBean();
		vehicleBean.setVehicle_master_id(vehicle_id);
		
		DriverBean driverBean = new DriverBean();
		driverBean.setDriver_id(driver_id);
		
		VehicleServiceRecordBean vehicleServiceRecordBean = new VehicleServiceRecordBean(vehicle_service_id,record_date, items_change, amount, free_service, driverBean, vehicleBean);
		AllInsertVtsDAO allInsertVtsDAO = new AllInsertVtsDAO();
		boolean result = allInsertVtsDAO.vehicleServiceRecordInsert(vehicleServiceRecordBean);

		request.getRequestDispatcher("vehicleServiceRecordForm.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
