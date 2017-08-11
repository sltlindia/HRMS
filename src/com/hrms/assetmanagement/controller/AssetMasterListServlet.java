package com.hrms.assetmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.dao.AllListAssetDAO;

public class AssetMasterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AllListAssetDAO allListAssetDAO = new AllListAssetDAO();
		List<AssetMasterBean> listOfAssets = allListAssetDAO.getListOfAssets();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(listOfAssets);
		jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + listOfAssets.size() + ",\"rows\":" + jsonArray + "}";

		System.out.println(jsonArray);

		response.getWriter().print(jsonArray);
		
	
	}

}
