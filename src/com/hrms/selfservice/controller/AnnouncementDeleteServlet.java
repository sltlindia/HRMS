package com.hrms.selfservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.AnnouncementBean;
import com.hrms.selfservice.bean.AnnouncementCategoryBean;
import com.hrms.selfservice.bean.AnnouncementCompanyBean;
import com.hrms.selfservice.bean.AnnouncementDepartmentBean;
import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;

public class AnnouncementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user != null){
	int announcement_id = Integer.parseInt(request.getParameter("announcement_id"));
	
	AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
	AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
	List<AnnouncementCategoryBean> listOfCategory = allListSelfServiceDAO.getListOfAnnouncementCategoryDetail(announcement_id);
	if(listOfCategory.size() != 0){
	for(AnnouncementCategoryBean a: listOfCategory){
		int announcement_category_id = a.getAnnouncement_category_id();
		allDeleteSelfServiceDAO.announcementCategoryDelete(announcement_category_id);
	}
	}
	List<AnnouncementDepartmentBean> listOfDepartment = allListSelfServiceDAO.getListOfAnnouncementDepartmentDetail(announcement_id);
	if(listOfDepartment.size() != 0){
	for(AnnouncementDepartmentBean a: listOfDepartment){
		int announcement_department_id = a.getAnnouncement_department_id();
		allDeleteSelfServiceDAO.announcementDepartmentDelete(announcement_department_id);
}
	}
	List<AnnouncementCompanyBean> listOfCompany = allListSelfServiceDAO.getListOfAnnouncementCompanyDetail(announcement_id);
	if(listOfCompany.size() != 0){
	for(AnnouncementCompanyBean a: listOfCompany){
		int announcement_company_id = a.getAnnouncement_company_id();
		allDeleteSelfServiceDAO.announcementCompanyDelete(announcement_company_id);
	}
	}
	allDeleteSelfServiceDAO.announcementDelete(announcement_id);
	request.setAttribute("deleteAnnouncement", "Broadcast Successfully Deleted");
	request.getRequestDispatcher("announcementList.jsp").forward(request, response);
	
	}
	
	}

}
