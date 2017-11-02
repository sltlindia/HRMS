package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.bean.KaizenAuthorityScoreBean;
import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagerScoreBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.kaizen.dao.AllKaizenListDAO;

/**
 * Servlet implementation class KaizenAuthorityScoreInsertServlet
 */
public class KaizenAuthorityScoreInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		int quality = Integer.parseInt(request.getParameter("quality"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		int safety = Integer.parseInt(request.getParameter("safety"));
		int productivity = Integer.parseInt(request.getParameter("productivity"));
		int delivery = Integer.parseInt(request.getParameter("delivery"));
		int horizontal_deployment = Integer.parseInt(request.getParameter("horizontal_deployment"));
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		double ave = Double.parseDouble(request.getParameter("ave"));
		
		AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
		
		KaizenBean kaizenBean = new KaizenBean();
		kaizenBean.setKaizen_id(kaizen_id);
		AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
		
		KaizenAuthorityScoreBean kaizenAuthorityScoreBean = allKaizenListDAO.getDetailOfKaizenAuthorityScoreByempId(kaizen_id, employee_id);
		
		
		if(kaizenAuthorityScoreBean != null) {
			int kaizen_authority_score_id = kaizenAuthorityScoreBean.getKaizen_authority_score_id();
			KaizenAuthorityScoreBean authorityScoreBean = new KaizenAuthorityScoreBean(kaizen_authority_score_id, quality, cost, safety, productivity, delivery, horizontal_deployment, employee_id, kaizenBean,year,month,ave);
			boolean result = allKaizenInsertDAO.kaizenAuthorityScoreInsert(authorityScoreBean);
		}else {
			KaizenAuthorityScoreBean authorityScoreBean = new KaizenAuthorityScoreBean(quality, cost, safety, productivity, delivery, horizontal_deployment, employee_id, kaizenBean,year,month,ave);
			boolean result = allKaizenInsertDAO.kaizenAuthorityScoreInsert(authorityScoreBean);
		}
		
		
		System.out.println("insert");
	
	
	}

}
