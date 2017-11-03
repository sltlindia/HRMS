package com.hrms.tds.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.tds.bean.TDSDocumentUploadBean;
import com.hrms.tds.dao.TDSListDAO;

public class TDSDocumentDataList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		
		int tds_id = 0;
		String attachment_name = "LIC";
		attachment_name = request.getParameter("attachment_name");
		tds_id = (Integer)session.getAttribute("tds_id");
		TDSListDAO tdsListDAO = new TDSListDAO();
		List<TDSDocumentUploadBean> documentUploadBean = tdsListDAO.getLastAddedData(tds_id, attachment_name);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(documentUploadBean);

		System.out.println(jsonArray);

		response.getWriter().print(jsonArray);
	}

}
