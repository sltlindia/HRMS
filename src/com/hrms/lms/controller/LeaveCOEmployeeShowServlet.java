package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class LeaveCOEmployeeShowServlet
 */
public class LeaveCOEmployeeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveCOEmployeeShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int CO_ID = Integer.parseInt(request.getParameter("CO_ID"));
		System.out.println("CO_ID: "+ CO_ID);
		String status = request.getParameter("status");
		
		if(status.equalsIgnoreCase("approved"))
		{
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.COShowView(CO_ID);
			if(result == true)
			{
				System.out.println("CO Show View Update successfully");
			}
		}
		
	
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		List<LeaveCOBean> listOfCO = allListDAO.getCOByCOId(CO_ID);
		request.setAttribute("listOfCO", listOfCO);
		request.getRequestDispatcher("LeaveCOEmployeeShow.jsp").forward(request, response);
		
	}
}
