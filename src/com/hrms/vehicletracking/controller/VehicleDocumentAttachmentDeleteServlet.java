package com.hrms.vehicletracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;
import com.hrms.vehicletracking.dao.AllDeleteVtsDAO;


public class VehicleDocumentAttachmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int vehicle_document_attachment_id = Integer.parseInt(request.getParameter("vehicle_document_attachment_id"));

	AllDeleteVtsDAO allDeleteVtsDAO = new AllDeleteVtsDAO();
	
	allDeleteVtsDAO.vehicleDocumentAttachmentDelete(vehicle_document_attachment_id);

	request.getRequestDispatcher("vehicleDocumentListVehicle.jsp").forward(request, response);
	}

}
