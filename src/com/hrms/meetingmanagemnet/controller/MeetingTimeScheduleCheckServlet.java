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

import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.meetingmanagemnet.dao.AllListMeetingDAO;

/**
 * Servlet implementation class MeetingTimeScheduleCheckServlet
 */
public class MeetingTimeScheduleCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String date = request.getParameter("date");
		int facilityId = Integer.parseInt(request.getParameter("facilityId"));
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		 AllListMeetingDAO allListMeetingDAO = new AllListMeetingDAO();
		
		SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat HHmmaa = new SimpleDateFormat("hh:mm aa");
		SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss");
		Date parseDate = null;
		String parseStartTime = null;
		String parseEndTime = null;
		try {
			 parseDate = yyyymmdd.parse(date);
			 parseStartTime = HHmmss.format(HHmmaa.parse(startTime));
			 parseEndTime = HHmmss.format(HHmmaa.parse(endTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(parseStartTime);
			System.out.println(parseEndTime);
		
		List<MeetingBookingDetailBean> listOfBooking = allListMeetingDAO.getAllTimeScheduleCheck(facilityId, date,parseStartTime,parseEndTime);
		if(request.getParameter("bookId") != null) {
			System.out.println("test");
			int book_id = Integer.parseInt(request.getParameter("bookId"));
			listOfBooking = allListMeetingDAO.getAllTimeScheduleCheckByID(facilityId, date,parseStartTime,parseEndTime,book_id);
		}
		
		if(listOfBooking.size() == 0) {
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
		}
		
	}

}
