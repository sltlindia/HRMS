package com.hrms.vehicletracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.vehicletracking.dao.AllDeleteVtsDAO;

/**
 * Servlet implementation class VehicleTrackingDeleteServlet
 */
public class VehicleTrackingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int vehicle_tracking_id = Integer.parseInt(request.getParameter("vehicle_tracking_id"));
	
	AllDeleteVtsDAO allDeleteVtsDAO = new AllDeleteVtsDAO();
	
	allDeleteVtsDAO.vehicleTrackingDelete(vehicle_tracking_id);
	request.getRequestDispatcher("addVehicle.jsp").forward(request, response);
	
	}

}
