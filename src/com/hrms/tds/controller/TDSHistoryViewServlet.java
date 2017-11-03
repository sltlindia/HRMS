package com.hrms.tds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.tds.dao.TDSUpdateDAO;

public class TDSHistoryViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TDSHistoryViewServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int his_id = Integer.parseInt(request.getParameter("his_id"));
		int ischecked = 1;
		TDSUpdateDAO updateDAO = new TDSUpdateDAO();
		boolean result =  updateDAO.ischeckedUpdateForTDSHistory(his_id,ischecked);
		response.sendRedirect("TDSDemo.jsp");
	}

}
