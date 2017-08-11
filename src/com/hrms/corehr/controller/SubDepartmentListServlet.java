package com.hrms.corehr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.corehr.bean.SubDepartmentBean;
import com.hrms.corehr.dao.AllListCoreHrDAO;

/**
 * Servlet implementation class SubDepartmentListServlet
 */
public class SubDepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllListCoreHrDAO allListCoreHrDAO = new AllListCoreHrDAO();
		List<SubDepartmentBean> listOfSubDepartment = allListCoreHrDAO.getListOfSubDepartent();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(listOfSubDepartment);
		jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + listOfSubDepartment.size() + ",\"rows\":" + jsonArray + "}";

		System.out.println(jsonArray);

		response.getWriter().print(jsonArray);
	}

}
