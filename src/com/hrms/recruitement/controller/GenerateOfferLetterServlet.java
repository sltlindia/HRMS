package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.recruitement.bean.OfferLetterBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

/**
 * Servlet implementation class GenerateOfferLetterServlet
 */
public class GenerateOfferLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int offerletterid = Integer.parseInt(request.getParameter("offer_letter_id"));
		System.out.println("offerletterid:"+offerletterid);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<OfferLetterBean> listofofferletter = AllRecruitmentListDAO.getListOfOfferLetter(offerletterid);
		request.setAttribute("offerletterid", offerletterid);
		request.setAttribute("listofofferletter", listofofferletter);
		if(request.getParameter("action") != null){
			request.getRequestDispatcher("offerLetterWordExport.jsp").forward(request, response);
		}else{
		request.getRequestDispatcher("automaticOfferLetter.jsp").forward(request, response);
		}
		
	}

}
