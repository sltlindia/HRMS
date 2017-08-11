package com.hrms.incentive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.ClassificationBean;
import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;

public class ClassificationMasterInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassificationMasterInsertServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String classification_name = request.getParameter("classificationName");
		
		System.out.println(classification_name);
		
		ProductMasterBean productMasterBean = new ProductMasterBean();
		
		ClassificationBean classificationBean = new ClassificationBean(classification_name);
		
		AllIncentiveInsertDAO allIncentiveInsertDAO = new AllIncentiveInsertDAO();
		boolean result = allIncentiveInsertDAO.classificationMasterInsert(classificationBean);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("incentiveMasterAction", "classification");
		session.setAttribute("success", "SuccessFully added");
		
		response.sendRedirect("incentiveMaster1.jsp");
	}

}
