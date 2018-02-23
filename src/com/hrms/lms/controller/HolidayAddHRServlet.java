package com.hrms.lms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.timesheet.bean.HolidayBean;

/**
 * Servlet implementation class HolidayAddHRServlet
 */
public class HolidayAddHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HolidayAddHRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String holidayDates = null;
		String HolidayName = null;
		
		holidayDates = request.getParameter("fromDate");
		
		
		try {
			  
			SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
			Date result2 = formater1.parse(holidayDates);
			SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			holidayDates = AppDateFormat.format(result2);
			//System.out.println(d1);
			//holiday.add(d1);
			
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		HolidayName = request.getParameter("holidayname");
		String company_name = "Sahajananad Laser Technology";
		String optional = "no";
		
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		
		List<HolidayBean> duplicateHoliday = allListDAO.getHolidayDupicate(holidayDates);
		
		
	
		if(duplicateHoliday.size() == 0)
		{
			
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			HolidayBean holidayBean = new HolidayBean(holidayDates , HolidayName,company_name,optional);
			boolean result = allInsertDAO.HolidayInsert(holidayBean);
			if(result == true)
			{
				request.setAttribute("LeaveSuccessfully", "Holiday Insert Successfully");
				/*request.getRequestDispatcher("leaveHolidayAddHR.jsp").forward(request, response);*/
				response.sendRedirect("leaveHolidayAddHR.jsp");
			}
		}
		else
		{
			request.setAttribute("LeaveExist", "Holiday Already Exists");
			/*request.getRequestDispatcher("leaveHolidayAddHR.jsp").forward(request, response);*/
			response.sendRedirect("leaveHolidayAddHR.jsp");
		}
		
		
		
	}

}
