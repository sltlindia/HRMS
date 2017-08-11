package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.dao.AllLMSListDAO;

/**
 * Servlet implementation class LeaveCOManagerShowServlet
 */
public class LeaveCOManagerShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveCOManagerShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		
		int CO_ID = 0;
		
		if(request.getParameter("CO_ID") != null)
		{
			CO_ID = Integer.parseInt(request.getParameter("CO_ID"));
		}
		else
		{
			CO_ID =(Integer) request.getAttribute("CO_ID");
		}	
		
	
		System.out.println("CO_ID: "+ CO_ID);
		
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		List<LeaveCOBean> listOfCO = allListDAO.getCOByCOId(CO_ID);
		request.setAttribute("listOfCO", listOfCO);
		
		if(request.getParameter("CO_ID") != null)
		{
			request.getRequestDispatcher("LeaveCOManagerShow.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("CO_ID", CO_ID);
			request.getRequestDispatcher("LeaveSpecialCOPending.jsp").forward(request, response);
		}
		
		
		
	}

}
