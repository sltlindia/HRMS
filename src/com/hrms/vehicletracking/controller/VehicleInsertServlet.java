package com.hrms.vehicletracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ComplaintVerifiedByBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;
import com.hrms.vehicletracking.bean.VehicleBean;
import com.hrms.vehicletracking.bean.VehicleTypeBean;
import com.hrms.vehicletracking.dao.AllInsertVtsDAO;

public class VehicleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	
			
			String vehicle_name = request.getParameter("vehicle_name");
			System.out.println("vehicle_name:"+vehicle_name);
			String vehicle_no = request.getParameter("vehicle_no");
			System.out.println("vehicle_no"+vehicle_no);
			int vehicle_type = Integer.parseInt(request.getParameter("vehicle_type"));
			System.out.println("vehicle_type"+vehicle_type);
			
			VehicleTypeBean vehicleTypeBean = new VehicleTypeBean();
			
			vehicleTypeBean.setVehicle_type_id(vehicle_type);
			VehicleBean vehicleBean = new VehicleBean(vehicle_name, vehicle_no, vehicleTypeBean);
			AllInsertVtsDAO allInsertVtsDAO = new AllInsertVtsDAO();
			boolean result = allInsertVtsDAO.vehicleInsert(vehicleBean);
	
			request.getRequestDispatcher("addVehicle.jsp").forward(request, response);
			}
			
			 
		else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
		}	
		
}

