package com.hrms.kaizen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagerScoreBean;
import com.hrms.kaizen.dao.AllKaizenInsertDAO;
import com.hrms.kaizen.dao.AllKaizenListDAO;

/**
 * Servlet implementation class ContinuousImprovementScoreInsertServlet
 */
public class ContinuousImprovementScoreInsertServlet extends HttpServlet {
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
		
		AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
		
		KaizenBean kaizenBean = new KaizenBean();
		kaizenBean.setKaizen_id(kaizen_id);
		AllKaizenInsertDAO allKaizenInsertDAO = new AllKaizenInsertDAO();
		
		KaizenManagerScoreBean kaizenManagerScoreBean = allKaizenListDAO.getDetailOfKaizenScoreByempId(kaizen_id, employee_id);
		if(kaizenManagerScoreBean != null) {
			int kaizen_manager_score_id = kaizenManagerScoreBean.getKaizen_manager_score_id();
			KaizenManagerScoreBean kaizenManagerScoreBean1 = new KaizenManagerScoreBean(kaizen_manager_score_id, quality, cost, safety, productivity, delivery, horizontal_deployment, employee_id, kaizenBean);
			boolean result = allKaizenInsertDAO.kaizenManagerScoreInsert(kaizenManagerScoreBean1);
		}else {
			KaizenManagerScoreBean kaizenManagerScoreBean1 = new KaizenManagerScoreBean(quality, cost, safety, productivity, delivery, horizontal_deployment, employee_id, kaizenBean);
			boolean result = allKaizenInsertDAO.kaizenManagerScoreInsert(kaizenManagerScoreBean1);
		}
		
		
		System.out.println("insert");
	
	
	}

}
