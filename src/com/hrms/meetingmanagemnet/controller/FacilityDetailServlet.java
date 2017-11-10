package com.hrms.meetingmanagemnet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.INTERNAL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.meetingmanagemnet.bean.MeetingRoomDetailBean;
import com.hrms.meetingmanagemnet.dao.AllListMeetingDAO;

/**
 * Servlet implementation class FacilityDetailServlet
 */
public class FacilityDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int facilityId = Integer.parseInt(request.getParameter("facilityId"));
		
		AllListMeetingDAO allListMeetingDAO = new AllListMeetingDAO();
		MeetingRoomDetailBean meetingRoomDetailBean = allListMeetingDAO.getRoomDetail(facilityId);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(meetingRoomDetailBean);
		response.getWriter().print(jsonArray);
	}

}
