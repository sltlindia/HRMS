package com.hrms.timesheet.controller;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SundayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String monthCommon = request.getParameter("month");
		String[] splitMonth = monthCommon.split(",");
		int month_id = Integer.parseInt(splitMonth[0]);
		String monthName = splitMonth[1];
		int year = Integer.parseInt(request.getParameter("year"));
		 ArrayList<Integer> sundays = new ArrayList<Integer>();
		if(monthName.equalsIgnoreCase("january")){
			Month month = Month.JANUARY;
			
		        IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
		                 .mapToObj(day -> LocalDate.of(year, month, day))
		                 .filter(date -> 
		                                 date.getDayOfWeek() == DayOfWeek.SUNDAY)
		                 .forEach(date -> sundays.add(date.getDayOfMonth()));
		        
		        
		        for(int day : sundays){
		        	System.out.println(day);
		        }
		        request.setAttribute("sundays", sundays);
		        request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
		}else if(monthName.equalsIgnoreCase("february")){
			Month month = Month.FEBRUARY;
		        IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
		                 .mapToObj(day -> LocalDate.of(year, month, day))
		                 .filter(date -> 
		                                 date.getDayOfWeek() == DayOfWeek.SUNDAY)
		                 .forEach(date -> sundays.add(date.getDayOfMonth()));
		        
		        
		        for(int day : sundays){
		        	System.out.println(day);}
		        request.setAttribute("sundays", sundays);
		        request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("march")){
				Month month = Month.MARCH;
			        IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
			                 .mapToObj(day -> LocalDate.of(year, month, day))
			                 .filter(date -> 
			                                 date.getDayOfWeek() == DayOfWeek.SUNDAY)
			                 .forEach(date -> sundays.add(date.getDayOfMonth()));
			        
			        
			        for(int day : sundays){
			        	System.out.println(day);}
			        request.setAttribute("sundays", sundays);
			        request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("april")){
				Month month = Month.APRIL;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("may")){
				Month month = Month.MAY;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("june")){
				Month month = Month.JUNE;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("july")){
				Month month = Month.JULY;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("august")){
				System.out.println(monthName);
				Month month = Month.AUGUST;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("september")){
				Month month = Month.SEPTEMBER;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("october")){
				Month month = Month.OCTOBER;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("november")){
				Month month = Month.NOVEMBER;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}else if(monthName.equalsIgnoreCase("december")){
				Month month = Month.DECEMBER;
				IntStream.rangeClosed(1,YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> 
                                date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(date -> sundays.add(date.getDayOfMonth()));
       
       
       for(int day : sundays){
       	System.out.println(day);
       }
       request.setAttribute("sundays", sundays);
       request.getRequestDispatcher("defaulterReportDateWise.jsp").forward(request, response);
			}
		
		
	}

}
