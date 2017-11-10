package com.hrms.meetingmanagemnet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.meetingmanagemnet.bean.MeetingRoomDetailBean;
import com.hrms.meetingmanagemnet.dao.AllInsertMeetingDAO;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class MeetingUpdateServlet
 */
public class MeetingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		
		AllInsertMeetingDAO allInsertMeetingDAO = new AllInsertMeetingDAO();
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int emp_id = user.getEmployee_master_id();
		String name = user.getFirstname() +" "+user.getLastname();
		int dept_id = user.getDepartmentBean().getDepartment_id();
		
		String meetingName = request.getParameter("name");
		String purpose = request.getParameter("purpose");
		int participant_no = Integer.parseInt(request.getParameter("participant_no"));
		String date = request.getParameter("date");
		int facility = Integer.parseInt(request.getParameter("facility"));
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		
		
		
		SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat HHmmaa = new SimpleDateFormat("hh:mm aa");
		Date parseDate = null;
		Date parseStartTime = null;
		Date parseEndTime = null;
		try {
			 parseDate = yyyymmdd.parse(date);
			 parseStartTime = HHmmaa.parse(starttime);
			 parseEndTime = HHmmaa.parse(endtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println(parseDate);
		System.out.println(parseStartTime);
		System.out.println(parseEndTime);
		
		EmployeeBean employeeBean = new EmployeeBean();
		DepartmentBean departmentBean = new DepartmentBean();
		MeetingRoomDetailBean meetingRoomDetailBean = new MeetingRoomDetailBean();
		
		employeeBean.setEmployee_master_id(emp_id);
		departmentBean.setDepartment_id(dept_id);
		meetingRoomDetailBean.setMeeting_room_detail_id(facility);
		
		MeetingBookingDetailBean meetingBookingDetailBean = new MeetingBookingDetailBean(bookId,name, meetingName, purpose, participant_no, parseDate, parseStartTime, parseEndTime, employeeBean, departmentBean, meetingRoomDetailBean);
		boolean result = allInsertMeetingDAO.bookingInsert(meetingBookingDetailBean);
		
		if(result == true) {
			response.getWriter().print("SUCCESS fully save data!!!");
		}
	}

}
