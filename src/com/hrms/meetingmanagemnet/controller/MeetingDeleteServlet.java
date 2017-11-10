package com.hrms.meetingmanagemnet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.query.ParameterParser.Recognizer;

import com.hrms.meetingmanagemnet.dao.AllDeleteMeetingDAO;

/**
 * Servlet implementation class MeetingDeleteServlet
 */
public class MeetingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int bookId = Integer.parseInt(request.getParameter("id"));
		AllDeleteMeetingDAO allDeleteMeetingDAO = new AllDeleteMeetingDAO();
		
		boolean result = allDeleteMeetingDAO.meetingDelete(bookId);
		if(result == true) {
			response.getWriter().print("Meeting Delete Successfully!!!");
		}else {
			response.getWriter().print("Some Error Occured!!!");
		}
		
		
	}

}
