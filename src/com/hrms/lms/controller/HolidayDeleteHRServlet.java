package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.dao.AllDeleteDAO;

/**
 * Servlet implementation class HolidayDeleteHRServlet
 */
public class HolidayDeleteHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolidayDeleteHRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int Holiday_id = 0;
		
		Holiday_id = Integer.parseInt(request.getParameter("holiday_id"));
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		
		
		System.out.println("Holiday Id" + Holiday_id);
		boolean result = allDeleteDAO.holidayDeleted(Holiday_id);
		if(result == true)
		{	
			request.setAttribute("LeaveExist", "Holiday Delete Successfully");
			/*request.getRequestDispatcher("leaveHolidayAddHR.jsp").forward(request, response);*/
			response.sendRedirect("leaveHolidayAddHR.jsp");
		}
		
	}

}
