package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.AppointmentLetterBean;
import com.hrms.recruitement.bean.OfferLetterBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class GenerateAppointmentLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int appointmentletterid = Integer.parseInt(request.getParameter("appointment_letter_id"));
		System.out.println("appointmentletterid:"+appointmentletterid);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<AppointmentLetterBean> listofappointment = AllRecruitmentListDAO.getListOfAppointment(appointmentletterid);
		request.setAttribute("appointmentletterid", appointmentletterid);
		request.setAttribute("listofappointment", listofappointment);
		
		if(request.getParameter("action") != null){
			request.getRequestDispatcher("cp.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("automaticAppointmentLetter.jsp").forward(request, response);
		}
		
		
	}

}
