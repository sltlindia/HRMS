package com.hrms.vehicletracking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.vehicletracking.bean.DriverBean;
import com.hrms.vehicletracking.bean.VehicleBean;
import com.hrms.vehicletracking.bean.VehicleTrackingBean;
import com.hrms.vehicletracking.bean.VehicleTypeBean;
import com.hrms.vehicletracking.dao.AllInsertVtsDAO;
import com.hrms.vehicletracking.dao.AllListVtsDAO;
import com.hrms.vehicletracking.dao.AllUpdateVtsDAO;

/**
 * Servlet implementation class TrackingHistoryInsertServlet
 */
public class TrackingHistoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		String date1 = request.getParameter("date");
		System.out.println("date:"+date1);
		
	/*	String driver_name = request.getParameter("driver_name");
		System.out.println("driver_name"+driver_name);*/
		int driver_id = Integer.parseInt(request.getParameter("driver_id"));
		System.out.println("driver_id"+driver_id);
		int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
		System.out.println("vehicle_id"+vehicle_id);
		double start_reading = Double.parseDouble(request.getParameter("start_reading"));
		System.out.println("start_reading"+start_reading);
		double end_reading = Double.parseDouble(request.getParameter("end_reading"));
		System.out.println("end_reading:"+end_reading);
		double kilometer = Double.parseDouble(request.getParameter("kilometer"));
		System.out.println("kilometer:"+kilometer);
		double ltr = Double.parseDouble(request.getParameter("ltr"));
		System.out.println("ltr:"+ltr);
		double amount = Double.parseDouble(request.getParameter("amount"));
		System.out.println("amount:"+amount);
		double average = Double.parseDouble(request.getParameter("average"));
		System.out.println("average:"+average);
		String attachment = "-";

		VehicleBean vehicleBean = new VehicleBean();
		vehicleBean.setVehicle_master_id(vehicle_id);
		
		DriverBean driverBean = new DriverBean();
		driverBean.setDriver_id(driver_id);
		
		AllListVtsDAO allListVtsDAO3 = new AllListVtsDAO();
		VehicleTrackingBean vehicleTrackingBean1  = allListVtsDAO3.getListOfVehiclesTrackingEndReadingZeroById(vehicle_id);
		if(vehicleTrackingBean1 != null){
			AllUpdateVtsDAO allUpdateVtsDAO = new AllUpdateVtsDAO();
			double km = end_reading - vehicleTrackingBean1.getStart_reading();
			double avg = km/vehicleTrackingBean1.getLitre();
			boolean result = allUpdateVtsDAO.endReadingUpdate(vehicleTrackingBean1.getVehicle_tracking_id(),end_reading,km,avg);
		}
		
		VehicleTrackingBean vehicleTrackingBean = new VehicleTrackingBean(end_reading,0, 0, ltr, amount, 0, date1, vehicleBean , driverBean,attachment);
		AllInsertVtsDAO allInsertVtsDAO = new AllInsertVtsDAO();
		boolean result = allInsertVtsDAO.vehicleTrackingInsert(vehicleTrackingBean);

		request.getRequestDispatcher("addVehicle.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}	
	
}
