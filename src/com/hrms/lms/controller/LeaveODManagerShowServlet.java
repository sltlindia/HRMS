package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.dao.AllLMSListDAO;

/**
 * Servlet implementation class LeaveODManagerShowServlet
 */
public class LeaveODManagerShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveODManagerShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		int OD_ID = 0;
		
		
		
		if(request.getParameter("OD_ID") != null)
		{
			OD_ID = Integer.parseInt(request.getParameter("OD_ID"));
		}
		else
		{
			OD_ID =(Integer) request.getAttribute("OD_ID");
		}	
		
		System.out.println("OD_ID: "+ OD_ID);
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		List<LeaveODBean> listOfOD = allListDAO.getODByODId(OD_ID);
		request.setAttribute("listOfOD", listOfOD);
		if(request.getParameter("OD_ID") != null)
		{
			request.getRequestDispatcher("LeaveODManagerShow.jsp").forward(request, response);
			/*response.sendRedirect("LeaveODManagerShow.jsp");*/
		}
		else
		{
			request.setAttribute("OD_ID", OD_ID);
			request.getRequestDispatcher("LeaveSpecialODPending.jsp").forward(request, response);
			/*response.sendRedirect("LeaveSpecialODPending.jsp");*/
		}
	}
}
