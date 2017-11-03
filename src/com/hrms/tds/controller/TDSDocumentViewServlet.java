package com.hrms.tds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.tds.dao.TDSListDAO;
import com.hrms.tds.dao.TDSUpdateDAO;

public class TDSDocumentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int doc_id = 0;
		String attachment_name  = null;
		String action = request.getParameter("action");
		System.err.println("Action :"+action);
		TDSUpdateDAO updateDAO = new TDSUpdateDAO();
			if(action.equals("hrSide")) 
			{
				System.err.println("HR SIDE");
				doc_id = Integer.parseInt(request.getParameter("id"));
				attachment_name = request.getParameter("name");
				int ischecked = 1 ;
				
				boolean result =  updateDAO.ischeckedUpdate(doc_id, attachment_name, ischecked);
				response.sendRedirect("TDSDemo.jsp");
			}
			else if(action.equals("userSide"))
			{
				System.err.println("USER SIDE");
				doc_id = Integer.parseInt(request.getParameter("id"));
				attachment_name = request.getParameter("name");
				int ischeckeduserside = 1;
				boolean result1 = updateDAO.ischeckedUpdateuserside(doc_id,attachment_name,ischeckeduserside);
				response.sendRedirect("TDSList.jsp");
			}
			System.err.println("Done");
	}

}
