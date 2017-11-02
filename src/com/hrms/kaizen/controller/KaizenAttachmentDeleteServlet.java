package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.dao.AllKaizenDeleteDAO;

/**
 * Servlet implementation class KaizenAttachmentDeleteServlet
 */
public class KaizenAttachmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int attachment_id = Integer.parseInt(request.getParameter("attachment_id"));
		
		AllKaizenDeleteDAO allKaizenDeleteDAO = new AllKaizenDeleteDAO();
		
		
		if(request.getParameter("kaizenBefore") != null) {
			
			boolean result = allKaizenDeleteDAO.kaizenBeforePhotoDelete(attachment_id);
			
		}else if(request.getParameter("kaizenAfter") != null) {
			
			boolean result = allKaizenDeleteDAO.kaizenAfterPhotoDelete(attachment_id);
			
		}
		
		
		request.getRequestDispatcher("kaizenPhotoUpload.jsp").forward(request, response);
		
	}

}
