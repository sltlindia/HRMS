package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.dao.AllUpdateDAO;

/**
 * Servlet implementation class HolidayUpdatesHRServlet
 */
public class HolidayUpdatesHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolidayUpdatesHRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int holiday_id = 0;
		String holidayDates = null;
		String HolidayName = null;
		
		holiday_id = Integer.parseInt(request.getParameter("holidayID"));
		holidayDates = request.getParameter("fromDate");
		HolidayName = request.getParameter("holidayname");
		
		System.out.println("ID :" + holiday_id);
		System.out.println("Dates : " + holidayDates);
		System.out.println("Names : "+ HolidayName);
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
		boolean result = allUpdateDAO.HolidaysUpdatesHR(holidayDates, HolidayName, holiday_id);
		if(result == true)
		{
			request.setAttribute("LeaveSuccessfully", "Holiday Updates  Successfully");
			request.getRequestDispatcher("leaveHolidayAddHR.jsp").forward(request, response);
		}
		
		
		
		
	}

}
