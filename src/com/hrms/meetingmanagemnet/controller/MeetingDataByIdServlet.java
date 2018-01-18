package com.hrms.meetingmanagemnet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.meetingmanagemnet.bean.MeetingMOMBean;
import com.hrms.meetingmanagemnet.dao.AllListMeetingDAO;

/**
 * Servlet implementation class MeetingDataByIdServlet
 */
public class MeetingDataByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		AllListMeetingDAO allListMeetingDAO = new AllListMeetingDAO();
		MeetingBookingDetailBean meetingBookingDetailBean = allListMeetingDAO.getBookinDetail(id);
		MeetingMOMBean meetingMOMBean = allListMeetingDAO.getMeetingMOM(id);
		
		SimpleDateFormat HHmmaa = new SimpleDateFormat("hh:mm aa");
		String fromTime = HHmmaa.format(meetingBookingDetailBean.getFrom_time());
		String toTime = HHmmaa.format(meetingBookingDetailBean.getTo_time());
		
		Date date = new Date();
		Date calenderDate = meetingBookingDetailBean.getDate();
		Date currTime = null;
		try {
			 currTime = HHmmaa.parse(HHmmaa.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(currTime);
		boolean flag = false;
		boolean mom = false;
		
		
		if(date.after(calenderDate)) {
				flag = true;
		}
		
		
		if(meetingMOMBean != null) {
			mom = true;
		}
		
		String	jsonArray =   "{ \"meetingName\":\"" + meetingBookingDetailBean.getMeeting_name() +"\",\"from_time\":\"" +fromTime+"\" ,\"to_time\":\"" +toTime+"\" ,\"departmentName\":\"" +meetingBookingDetailBean.getDepartmentBean().getDepartment_name()+"\" ,\"meetingPurpose\":\"" +meetingBookingDetailBean.getMeeting_purpose()+"\" ,\"facility\":\"" +meetingBookingDetailBean.getMeetingRoomDetailBean().getFacility_name()+"\" ,\"capacity\":\"" +meetingBookingDetailBean.getMeetingRoomDetailBean().getCapacity()+"\" ,\"no\":\"" +meetingBookingDetailBean.getParticipant_no()+"\" ,\"resources\":\"" +meetingBookingDetailBean.getMeetingRoomDetailBean().getResources()+"\" ,\"meeting_booking_detail_id\":\"" +meetingBookingDetailBean.getMeeting_booking_detail_id()+"\" ,\"flag\":\"" +flag+"\" ,\"mom\":\"" +mom+"\"}";
		
		response.getWriter().print(jsonArray);
		
	}

}
