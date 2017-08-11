package com.hrms.selfservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;

public class DownloadDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadDeleteServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int down_id = Integer.parseInt(request.getParameter("download_id"));
		
		AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
		boolean result = allDeleteSelfServiceDAO.downloadDelete(down_id);
		request.setAttribute("delete", "Link deleted successfully....");
		request.getRequestDispatcher("complaint.jsp").forward(request, response);
	
	}

}
