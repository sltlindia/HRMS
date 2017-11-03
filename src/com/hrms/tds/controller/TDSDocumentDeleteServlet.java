package com.hrms.tds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.tds.dao.TDSDeleteDAO;

public class TDSDocumentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int tds_doc_id = Integer.parseInt(request.getParameter("tds_doc_id"));
		System.out.println("TDS DOCUMENT ID :"+tds_doc_id);
		
		TDSDeleteDAO tdsDeleteDAO = new TDSDeleteDAO();
		boolean result = tdsDeleteDAO.tdsDocumentDeleteByDocId(tds_doc_id);
		System.out.println("DONE");
	}

}
