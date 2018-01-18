package com.hrms.selfservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.selfservice.bean.SoftwareNatureBean;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;

/**
 * Servlet implementation class SoftwareNatureListServlet
 */
public class SoftwareNatureListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
		List<SoftwareNatureBean> listOfSoftwareNature = allListSelfServiceDAO.getListOfSoftwareProblem();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(listOfSoftwareNature);
		jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + listOfSoftwareNature.size() + ",\"rows\":" + jsonArray + "}";

		System.out.println(jsonArray);

		response.getWriter().print(jsonArray);	
	}

}
