package com.hrms.meetingmanagemnet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.lms.dao.AllListDAO;
import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.meetingmanagemnet.bean.MeetingRoomDetailBean;
import com.hrms.meetingmanagemnet.dao.AllListMeetingDAO;

/**
 * Servlet implementation class MeetingDataServlet
 */
public class MeetingDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#destroy()
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		AllListMeetingDAO allListMeetingDAO = new AllListMeetingDAO();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
		
		if(action.equalsIgnoreCase("facility")) {
			int noOfParticipant = Integer.parseInt(request.getParameter("no"));
			List<MeetingRoomDetailBean> listOfRoom = allListMeetingDAO.getRoom(noOfParticipant);
			
			
			String jsonArray = gson.toJson(listOfRoom);
			response.getWriter().print(jsonArray);
			
		}else if(action.equalsIgnoreCase("time")){
			
			String date = request.getParameter("date");
			int facilityId = Integer.parseInt(request.getParameter("facilityId"));
			int counter = 0;
			List<MeetingBookingDetailBean> listOfBooking = allListMeetingDAO.getAllBookings(facilityId, date);
			String output = "";
			
			for(MeetingBookingDetailBean meetingBookingDetailBean : listOfBooking) {
				counter = counter + 1;
				
				SimpleDateFormat HHmmaa = new SimpleDateFormat("hh:mm aa");
				String fromTime = HHmmaa.format(meetingBookingDetailBean.getFrom_time());
				String toTime = HHmmaa.format(meetingBookingDetailBean.getTo_time());
				
				
				if(listOfBooking.size() == counter)
	         	{
					output =  output + "{ \"employee_name\":\"" + meetingBookingDetailBean.getEmployee_name() +"\",\"from_time\":\"" +fromTime+"\" ,\"to_time\":\"" +toTime+"\" ,\"departmentName\":\"" +meetingBookingDetailBean.getDepartmentBean().getDepartment_name()+"\"}";
	         	}
				else
				{
					output = output + "{ \"employee_name\":\"" + meetingBookingDetailBean.getEmployee_name() +"\",\"from_time\":\"" +fromTime+"\" ,\"to_time\":\"" +toTime+"\" ,\"departmentName\":\"" +meetingBookingDetailBean.getDepartmentBean().getDepartment_name()+"\"},";
				}
			}
			
			
			output = "["+""+ output +""+"]";
			
			response.getWriter().print(output);
			
		}
		
		
		
		
	}
}
