package com.hrms.pms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.SpecificCriteriaAllocationBean;
import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.pms.bean.SpecificCriteriaMonthBean;
import com.hrms.pms.bean.SpecificCriteriaSoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaTechnicalBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllListDAO;

public class SpecificAllocationSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		 String employee_master_id = request.getParameter("employee_master_id");
		 String project_master_id = request.getParameter("project_master_id");
		 String month_id = request.getParameter("month");
		 String year_id = request.getParameter("year");
		 int i = 0;
		 System.out.println(employee_master_id);
		 System.out.println(project_master_id);
		 System.out.println(month_id);
		 System.out.println(year_id);
		 AllListDAO allListDAO = new AllListDAO();
		 
		 
		 int project_id = Integer.parseInt(project_master_id);
			int month = Integer.parseInt(month_id);
			int year = Integer.parseInt(year_id);
			int employee = Integer.parseInt(employee_master_id);
			
			/*List<Object[]> listOfsearch = allListDAO.duplicationSearch(employee, month, year, project_id);
			System.out.println("list:"+listOfsearch.size());
			if(listOfsearch.size()!=0){
				request.setAttribute("duplicate", "You already review for this project.See your Riview History..");
				request.getRequestDispatcher("selfReviewBasic.jsp").forward(request, response);
			}else{
		 
		 List<Object[]> listOfSpecificSearch = allListDAO.getSpecificCriteriaSearch(employee,project_id,month,year);
		 System.out.println(listOfSpecificSearch.size());
		 
			
			for(Object[] aRow : listOfSpecificSearch) {
			SpecificCriteriaAllocationBean s = (SpecificCriteriaAllocationBean) aRow[0];
			YearBean y = (YearBean) aRow[1];
			MonthBean m = (MonthBean) aRow[2];
			ProjectMasterBean p = (ProjectMasterBean) aRow[3];
			EmployeeBean e = (EmployeeBean) aRow[4];
			
			i = s.getSpecific_criteria_id();
			
			}
		 
			
		 
		 if(i != 0 ){
			 session.setAttribute("project_master_id", project_id);
			 session.setAttribute("month_id", month);
			 session.setAttribute("year_id", year);
		 request.setAttribute("listOfSpecificSearch", listOfSpecificSearch);
		 request.getRequestDispatcher("specificCriteriaReview.jsp").forward(request, response);
		 }else{
			 session.setAttribute("project_master_id", project_id);
			 session.setAttribute("month_id", month);
			 session.setAttribute("year_id", year);
			 request.getRequestDispatcher("selfReview.jsp").forward(request, response);
		 }
		 
			}*/
			
			
			
			List<Object[]> listOfsearch = allListDAO.duplicationSearch(employee, month, year, project_id);
			System.out.println("list:"+listOfsearch.size());
			if(listOfsearch.size()!=0){
				request.setAttribute("duplicate", "You already review for this project.See your Riview History..");
				request.getRequestDispatcher("selfReviewBasic.jsp").forward(request, response);
			}else{
		 
		 List<Object[]> listOfSpecificSearch = allListDAO.getSpecificAllocatedCriteriaSearch(employee,project_id,month,year);
		 System.out.println(listOfSpecificSearch.size());
		 
			
			for(Object[] aRow : listOfSpecificSearch) {
			SpecificCriteriaMonthBean s = (SpecificCriteriaMonthBean) aRow[0];
			YearBean y = (YearBean) aRow[1];
			MonthBean m = (MonthBean) aRow[2];
			SpecificCriteriaBean s1 = (SpecificCriteriaBean) aRow[3];
			
			i = s1.getSpecific_criteria_allocation_id();
			
			}
		 
			int id =i;
			 List<SpecificCriteriaSoftskillBean> listOfSpecificSoftskill= allListDAO.getSpecificAllocatedCriteriaSoftskill(id);
			 List<SpecificCriteriaTechnicalBean> listOfSpecificTechnical= allListDAO.getSpecificAllocatedCriteriaTechnical(id);
			
			
		 if(i != 0 ){
			 session.setAttribute("project_master_id", project_id);
			 session.setAttribute("month_id", month);
			 session.setAttribute("year_id", year);
		 request.setAttribute("listOfSpecificSearch", listOfSpecificSearch);
		 request.setAttribute("listOfSpecificSoftskill", listOfSpecificSoftskill);
		 request.setAttribute("listOfSpecificTechnical", listOfSpecificTechnical);
		 request.getRequestDispatcher("specificAllocatedCriteriaReview.jsp").forward(request, response);
		 }else{
			 session.setAttribute("project_master_id", project_id);
			 session.setAttribute("month_id", month);
			 session.setAttribute("year_id", year);
			 request.getRequestDispatcher("selfReview.jsp").forward(request, response);
		 }
		 
			}
			
			
			
			
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
