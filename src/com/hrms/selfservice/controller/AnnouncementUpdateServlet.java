package com.hrms.selfservice.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.selfservice.bean.AnnouncementBean;
import com.hrms.selfservice.bean.AnnouncementCategoryBean;
import com.hrms.selfservice.bean.AnnouncementCompanyBean;
import com.hrms.selfservice.bean.AnnouncementDepartmentBean;
import com.hrms.selfservice.bean.RoleCategoryBean;
import com.hrms.selfservice.dao.AllDeleteSelfServiceDAO;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;
import com.hrms.selfservice.dao.AllUpdateSelfServiceDAO;

public class AnnouncementUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			String filePath = getServletContext().getInitParameter("announcement-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String fileName = null;
			File file = null;
			String announcement_title = null;
			String announcement_description = null;
			String announcement_submission_date = null;
			String announcement_enddate = null;
			String announcement_date = null;
			String announcement_attachment = "-";
			String from_time = null;
			String to_time = null;
			int employee_master_id = user.getEmployee_master_id();
			int role_category_id = 0;
			int announcementId = 0;
			String file_name = null;
			String name = user.getFirstname() + " " + user.getLastname();
			int department_id = 0;
			String toTime = "00:00:00";
			String fromTime = "00:00:00";
			int company_list_id = 0;
			List<Integer> listOfCategory = new ArrayList<>();
			List<Integer> listOfDepartment = new ArrayList<>();
			List<Integer> listOfCompany = new ArrayList<>();
			int insertCount = 0;
			boolean flagCheck = false;

			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			announcement_submission_date = dateFormat.format(date);
			AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
			
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);

					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("announcement_id")) {
							String value = fieldValue;
							announcementId = Integer.parseInt(value);
							System.out.println("announcement_id:" + announcementId);
						}
						if (fieldName.equalsIgnoreCase("announcement_title")) {
							announcement_title = fieldValue;
							System.out.println("announcement_title:" + announcement_title);
						}
						if (fieldName.equalsIgnoreCase("description")) {
							announcement_description = fieldValue;
							System.out.println("description:" + announcement_description);

						}
						
						
						if (fieldName.equalsIgnoreCase("announcement_date")) {
							announcement_date = fieldValue;
							System.out.println("announcement_date:" + announcement_date);

						}
						
						
						if (fieldName.equalsIgnoreCase("announcement_submission_date")) {
							announcement_submission_date = fieldValue;
							System.out.println("announcement_submission_date:" + announcement_submission_date);

						}
						if (fieldName.equalsIgnoreCase("announcement_enddate")) {
							announcement_enddate = fieldValue;
							System.out.println("end_date:" + announcement_enddate);

						}
						if (fieldName.equalsIgnoreCase("fromTime")) {
							from_time = fieldValue;
							
							String[] splitTime = from_time.split(":");
							from_time = splitTime[0]+":"+splitTime[1]+":00";
							fromTime = from_time.replaceAll("\\s","");
							System.out.println("from_time:"+fromTime);
						}
						if (fieldName.equalsIgnoreCase("toTime")) {
							to_time = fieldValue;
							
							String[] splitTime = to_time.split(":");
							to_time = splitTime[0]+":"+splitTime[1]+":00";
							toTime = to_time.replaceAll("\\s","");
							System.out.println("to_time:"+toTime);
							
						}
						if (fieldName.equalsIgnoreCase("category")) {
							String value = fieldValue;
							role_category_id = Integer.parseInt(value);
							System.out.println("role_category_id:" + role_category_id);
							listOfCategory.add(role_category_id);
							
							
							
						}
						if (fieldName.equalsIgnoreCase("department")) {
							String value = fieldValue;
							department_id = Integer.parseInt(value);
							System.out.println("department_id:" + department_id);
							listOfDepartment.add(department_id);
							
							
							
						}
						if (fieldName.equalsIgnoreCase("company")) {
							String value = fieldValue;
							company_list_id = Integer.parseInt(value);
							System.out.println("company_list_id:" + company_list_id);
							listOfCompany.add(company_list_id);
							
							
							
							
						}
						
						if (fieldName.equalsIgnoreCase("file")) {
							file_name = fieldValue;
							System.out.println("file_name:" + file_name);

						}

						if (fieldName.equalsIgnoreCase("redirect")) {
							
							
							
							
							List<AnnouncementBean> checkForTime = allListSelfServiceDAO.getBetweenTimeForUpdate(announcement_date, toTime,
									fromTime,announcementId);
							System.out.println("size of check:"+checkForTime.size());
							
							if(checkForTime.size() == 0) {
								AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
								allUpdateSelfServiceDAO.announcementUpdate(announcementId, announcement_title,
										announcement_description, announcement_attachment, announcement_enddate,
										employee_master_id, announcement_submission_date,fromTime,toTime);
								insertCount++;
								
								
								List<AnnouncementCategoryBean> listOfCategoryDefined = allListSelfServiceDAO
										.getListOfAnnouncementCategoryDetail(announcementId);
								for (AnnouncementCategoryBean a : listOfCategoryDefined) {
									int announcement_category_id = a.getAnnouncement_category_id();
									System.out.println("announcement_category_id" + announcement_category_id);
									AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
									allDeleteSelfServiceDAO.announcementCategoryDelete(announcement_category_id);

								}
								List<AnnouncementDepartmentBean> listOfDepartment1 = allListSelfServiceDAO
										.getListOfAnnouncementDepartmentDetail(announcementId);
								for (AnnouncementDepartmentBean a : listOfDepartment1) {
									int announcement_department_id = a.getAnnouncement_department_id();
									System.out.println("announcement_department_id"+announcement_department_id);
									AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
									allDeleteSelfServiceDAO.announcementDepartmentDelete(announcement_department_id);
								}
								List<AnnouncementCompanyBean> listOfCompany1 = allListSelfServiceDAO
										.getListOfAnnouncementCompanyDetail(announcementId);
								for (AnnouncementCompanyBean a : listOfCompany1) {
									int announcement_company_id = a.getAnnouncement_company_id();
									System.out.println("announcement_company_id"+announcement_company_id);
									AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
									allDeleteSelfServiceDAO.announcementCompanyDelete(announcement_company_id);
								}
						
							}else{
							for(AnnouncementBean a : checkForTime){
								int a_id = a.getAnnouncement_id();
								System.out.println("aid"+a_id);
								List<AnnouncementCategoryBean>  announcementCategoryBean1 = allListSelfServiceDAO.getAnnouncementById(a_id);
								List<AnnouncementDepartmentBean>  announcementDepartmentBean = allListSelfServiceDAO.getListOfAnnouncementDepartmentDetail(a_id);
								List<AnnouncementCompanyBean> announcementCompanyBean = allListSelfServiceDAO.getListOfAnnouncementCompanyDetail(a_id);
								
								
								for(AnnouncementCategoryBean bean : announcementCategoryBean1){
								int category_id = bean.getRoleCategoryBean().getRole_category_id();
								System.out.println("category_id"+category_id);
								
								for(Integer category : listOfCategory){
								if(category_id == category){
									flagCheck = true;
								}
								}
								
								}
								
								for(AnnouncementDepartmentBean bean : announcementDepartmentBean){
								int departmentid = bean.getDepartmentBean().getDepartment_id();
								System.out.println("departmentId"+departmentid);
								System.out.println("department_id"+department_id);
								
								for(Integer department : listOfDepartment){
								if(departmentid == department){
									flagCheck = true;
								}
								}
								
								}
								
								for(AnnouncementCompanyBean bean : announcementCompanyBean){
									int companyListId = bean.getCompanyListBean().getCompany_list_id();
											System.out.println("companyListId"+companyListId);
									System.out.println("companyListId"+company_list_id);
									
									
									for(Integer company : listOfCompany){
									if(companyListId == company){
										flagCheck = true;
									}
									}
									
									}
								
							}
							
							if(flagCheck == true){
								System.out.println("inifcategory");
								request.setAttribute("conflictAnnouncement",
										"The Timeslot you added already have a broadcast for this timeslot..So you can't add broadcast for this timeslots");
							}else{
								System.out.println("inelsecategory");
								AllUpdateSelfServiceDAO allUpdateSelfServiceDAO = new AllUpdateSelfServiceDAO();
								allUpdateSelfServiceDAO.announcementUpdate(announcementId, announcement_title,
										announcement_description, announcement_attachment, announcement_enddate,
										employee_master_id, announcement_submission_date,fromTime,toTime);
								
								insertCount++;
								
								List<AnnouncementCategoryBean> listOfCategoryDefined = allListSelfServiceDAO
										.getListOfAnnouncementCategoryDetail(announcementId);
								for (AnnouncementCategoryBean a : listOfCategoryDefined) {
									int announcement_category_id = a.getAnnouncement_category_id();
									System.out.println("announcement_category_id" + announcement_category_id);
									AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
									allDeleteSelfServiceDAO.announcementCategoryDelete(announcement_category_id);

								}
								List<AnnouncementDepartmentBean> listOfDepartment1 = allListSelfServiceDAO
										.getListOfAnnouncementDepartmentDetail(announcementId);
								for (AnnouncementDepartmentBean a : listOfDepartment1) {
									int announcement_department_id = a.getAnnouncement_department_id();
									System.out.println("announcement_department_id"+announcement_department_id);
									AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
									allDeleteSelfServiceDAO.announcementDepartmentDelete(announcement_department_id);
								}
								List<AnnouncementCompanyBean> listOfCompany1 = allListSelfServiceDAO
										.getListOfAnnouncementCompanyDetail(announcementId);
								for (AnnouncementCompanyBean a : listOfCompany1) {
									int announcement_company_id = a.getAnnouncement_company_id();
									System.out.println("announcement_company_id"+announcement_company_id);
									AllDeleteSelfServiceDAO allDeleteSelfServiceDAO = new AllDeleteSelfServiceDAO();
									allDeleteSelfServiceDAO.announcementCompanyDelete(announcement_company_id);
								}
							}
							}
							
							
							if(insertCount != 0){
								
								
								AnnouncementBean announcementBean = new AnnouncementBean();
								announcementBean.setAnnouncement_id(announcementId);
								RoleCategoryBean roleCategoryBean = new RoleCategoryBean();
								
								for(Integer category : listOfCategory){
								roleCategoryBean.setRole_category_id(category);
								AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
								AnnouncementCategoryBean announcementCategoryBean = new AnnouncementCategoryBean(
										roleCategoryBean, announcementBean);
								allInsertSelfServiceDAO.announcementCategoryInsert(announcementCategoryBean);
								}
								
								
								
								DepartmentBean departmentBean = new DepartmentBean();
								for(Integer department : listOfDepartment){
								departmentBean.setDepartment_id(department);
								AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
								AnnouncementDepartmentBean announcementDepartmentBean = new AnnouncementDepartmentBean(
										departmentBean, announcementBean);
								allInsertSelfServiceDAO.announcementDepartmentInsert(announcementDepartmentBean);
								}
								
								
								
								CompanyListBean companyListBean = new CompanyListBean();
								for(Integer company : listOfCompany){
								companyListBean.setCompany_list_id(company);
								AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
								AnnouncementCompanyBean announcementCompanyBean = new AnnouncementCompanyBean(
										companyListBean, announcementBean);
								allInsertSelfServiceDAO.announcementCompanyInsert(announcementCompanyBean);
								}
								
							}
							request.setAttribute("updateAnnouncement", "Announcement Updated Inserted");
							request.getRequestDispatcher("announcementDoneHRList.jsp").forward(request, response);

						}

					} else {
						fieldName = item.getFieldName();
						System.out.println("FieldName : " + fieldName);
						fileName = item.getName();
						System.out.println("File Name : " + fileName);

						fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
						System.out.println("File Name 1 : " + fileName);

						ServletContext context = getServletContext();
						file = new File(filePath + File.separator + fileName);
						System.out.println("filePath:" + file);

						try {

							if (fileName.isEmpty()) {
								announcement_attachment = file_name;
								
								
								
							} else if (fieldName.equalsIgnoreCase("attachment")) {
								System.out.println("MIME : " + context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> " + file.getName());

								announcement_attachment = file.getName();
								
								
								
								
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}

		} else {
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
