package com.hrms.vehicletracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.vehicletracking.dao.AllDeleteVtsDAO;

/**
 * Servlet implementation class VehicleDocumentPolicyDeleteServlet
 */
public class VehicleDocumentPolicyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int vehicle_policy_document_id = Integer.parseInt(request.getParameter("vehicle_policy_document_id"));

		AllDeleteVtsDAO allDeleteVtsDAO = new AllDeleteVtsDAO();
		
		allDeleteVtsDAO.vehicleDocumentPolicyDelete(vehicle_policy_document_id);

		request.getRequestDispatcher("carDocumentList.jsp").forward(request, response);
		}
	}


