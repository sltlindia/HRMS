package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

/**
 * Servlet implementation class ShowServlet
 */
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int v_id = (Integer) session.getAttribute("v_id");
		System.out.println("v_id:"+v_id);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<VacancyFormBean> listofVacancy = AllRecruitmentListDAO.getListOfVacancy(v_id);
		List<Object[]> listofBenefits = AllRecruitmentListDAO.getListOfBenefits(v_id);
		request.setAttribute("listofVacancy", listofVacancy);
		request.setAttribute("listofBenefits", listofBenefits);
		request.getRequestDispatcher("approveorrejectForm.jsp").forward(request, response);
	}

}
