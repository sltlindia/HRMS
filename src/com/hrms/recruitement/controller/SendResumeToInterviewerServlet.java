package com.hrms.recruitement.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.HrSuggestBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class SendResumeToInterviewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		int vacancy_id = Integer.parseInt(request.getParameter("vacancy_id"));
		int resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
		String skill = request.getParameter("skill");
		
		VacancyFormBean vacancyFormBean = new VacancyFormBean();
		ResumeDataBean resumeDataBean = new ResumeDataBean();
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		vacancyFormBean.setVacancy_id(vacancy_id);
		resumeDataBean.setResume_data_id(resume_data_id);
		AllRecruitmentListDAO allRecruitmentListDAO = new AllRecruitmentListDAO();
		HrSuggestBean hrSuggestBean = new HrSuggestBean(resumeDataBean, vacancyFormBean);
		List<ResumeDataBean> searchengine = allRecruitmentListDAO.getListOfResumeDataSearchEngine(skill);
		request.setAttribute("searchengine", searchengine);
		boolean result = allInsertDAO.hrSuggestInsert(hrSuggestBean);
		if(result == true)
		{
			request.getRequestDispatcher("resumeDataSearchEngineWithData.jsp").forward(request, response);
		}
		
		
		
		/*HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			String fieldName = null;
			String fieldValue = null;
			String status = "pending";
			ResumeDataBean resumeDataBean = new ResumeDataBean();

			int resume_data_id = Integer.parseInt(request.getParameter("resume_data_id"));
			
			System.out.println(resume_data_id);
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result1 = allUpdateDAO.resumeStatusUpdate(status, resume_data_id);
			request.getRequestDispatcher("resumeDataSearchEngine").forward(request, response);
	}*/
	}
}
