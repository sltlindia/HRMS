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

import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class ResumeDataSearchEngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String skill = request.getParameter("skill");
		String experience = request.getParameter("experience");
		int expected_salary =Integer.parseInt(request.getParameter("expectedSalary"));
		
		
		System.out.println(skill);
		System.out.println(experience);
		System.out.println(expected_salary);
		
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<ResumeDataBean> searchengine = AllRecruitmentListDAO.getListOfResumeDataSearchEngine(skill, experience, expected_salary);
		request.setAttribute("searchengine", searchengine);
		request.setAttribute("skill", skill);
		request.setAttribute("experience", experience);
		request.setAttribute("expectedsalary", expected_salary);
		
		request.getRequestDispatcher("resumeDataSearchEngineWithData.jsp").forward(request, response);
		if(searchengine.size()==0){
			System.out.println("Data Not Found");
		}
		else{
			
			System.out.println("Data Found");
		}
	}

}

