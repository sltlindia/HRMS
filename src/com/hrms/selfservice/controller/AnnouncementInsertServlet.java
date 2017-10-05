package com.hrms.selfservice.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
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
import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.selfservice.bean.AnnouncementBean;
import com.hrms.selfservice.bean.AnnouncementCategoryBean;
import com.hrms.selfservice.bean.AnnouncementCompanyBean;
import com.hrms.selfservice.bean.AnnouncementDepartmentBean;
import com.hrms.selfservice.bean.RoleCategoryBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;

public class AnnouncementInsertServlet extends HttpServlet {
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
			String announcement_attachment = "-";
			String from_time = null;
			String to_time = null;
			int id = user.getEmployee_master_id();
			int role_category_id = 0;
			String name = user.getFirstname() + " " + user.getLastname();
			int announcementId = 0;
			int department_id = 0;
			int company_list_id = 0;
			String toTime = "00:00:00";
			String fromTime = "00:00:00";
			String announcement_date = null;
			String announced_by = null;
			boolean flagCheck = false;
			List<Integer> listOfMatch = new ArrayList<>();
			List<Integer> listOfCategory = new ArrayList<>();
			List<Integer> listOfDepartment = new ArrayList<>();
			List<Integer> listOfCompany = new ArrayList<>();
			int insertCount = 0;

			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(id);

			AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
			AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			announcement_submission_date = dateFormat.format(date);
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);

					if (item.isFormField()) {
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("announcement_title")) {
							announcement_title = fieldValue;
							System.out.println("query:" + announcement_title);
						}

						if (fieldName.equalsIgnoreCase("description")) {
							announcement_description = fieldValue;
							System.out.println("description:" + announcement_description);

						}
						if (fieldName.equalsIgnoreCase("announcement_enddate")) {
							announcement_enddate = fieldValue;
							System.out.println("end_date:" + announcement_enddate);

						}
						if (fieldName.equalsIgnoreCase("fromTime")) {
							from_time = fieldValue;

							String[] splitTime = from_time.split(":");
							from_time = splitTime[0] + ":" + splitTime[1] + ":00";
							fromTime = from_time.replaceAll("\\s", "");
							System.out.println("from_time:" + fromTime);
						}
						if (fieldName.equalsIgnoreCase("toTime")) {
							to_time = fieldValue;

							String[] splitTime = to_time.split(":");
							to_time = splitTime[0] + ":" + splitTime[1] + ":00";
							toTime = to_time.replaceAll("\\s", "");
							System.out.println("to_time:" + toTime);

						}
						if (fieldName.equalsIgnoreCase("announcement_date")) {
							announcement_date = fieldValue;
							System.out.println("announcment_date" + announcement_date);

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
							System.out.println("Department_id:" + department_id);
							listOfDepartment.add(department_id);

						}
						if (fieldName.equalsIgnoreCase("company")) {
							String value = fieldValue;
							company_list_id = Integer.parseInt(value);
							System.out.println("company_list_id done:" + company_list_id);
							listOfCompany.add(company_list_id);
						}
						if (fieldName.equalsIgnoreCase("redirection")) {

							AnnouncementBean announcementBean = new AnnouncementBean(announcement_title,
									announcement_description, announcement_attachment, announcement_enddate,
									announcement_submission_date, employeeBean, fromTime, toTime, announcement_date);

							List<AnnouncementBean> checkForTime = allListSelfServiceDAO
									.getBetweenTime(announcement_date, toTime, fromTime);
							System.out.println("size of check:" + checkForTime.size());

							if (checkForTime.size() == 0 && insertCount == 0) {
								boolean result = allInsertSelfServiceDAO.announcementInsert(announcementBean);
								announcementId = announcementBean.getAnnouncement_id();
								insertCount++;

							} else {
								for (AnnouncementBean a : checkForTime) {
									int a_id = a.getAnnouncement_id();
									System.out.println("aid" + a_id);
									List<AnnouncementCategoryBean> announcementCategoryBean1 = allListSelfServiceDAO
											.getAnnouncementById(a_id);
									List<AnnouncementDepartmentBean> announcementDepartmentBean = allListSelfServiceDAO
											.getListOfAnnouncementDepartmentDetail(a_id);
									List<AnnouncementCompanyBean> announcementCompanyBean = allListSelfServiceDAO
											.getListOfAnnouncementCompanyDetail(a_id);

									for (AnnouncementCategoryBean bean : announcementCategoryBean1) {
										int category_id = bean.getRoleCategoryBean().getRole_category_id();
										System.out.println("category_id" + category_id);

										for (Integer category : listOfCategory) {
											if (category_id == category) {
												flagCheck = true;
											}
										}

									}

									for (AnnouncementDepartmentBean bean : announcementDepartmentBean) {
										int departmentid = bean.getDepartmentBean().getDepartment_id();
										System.out.println("departmentId" + departmentid);
										System.out.println("department_id" + department_id);

										for (Integer department : listOfDepartment) {
											if (departmentid == department) {
												flagCheck = true;
											}
										}

									}

									for (AnnouncementCompanyBean bean : announcementCompanyBean) {
										int companyListId = bean.getCompanyListBean().getCompany_list_id();
										System.out.println("companyListId" + companyListId);
										System.out.println("companyListId" + company_list_id);

										for (Integer company : listOfCompany) {
											if (companyListId == company) {
												flagCheck = true;
											}
										}

									}

								}

								if (flagCheck == true) {
									System.out.println("inifcategory");
									request.setAttribute("conflictAnnouncement",
											"The Timeslot you added already have a broadcast for this timeslot..So you can't add broadcast for this timeslots");
								} else {
									System.out.println("inelsecategory");
									if (insertCount == 0) {
										boolean result = allInsertSelfServiceDAO.announcementInsert(announcementBean);
										announcementId = announcementBean.getAnnouncement_id();
										insertCount++;
									}
								}
							}
							announcementBean.setAnnouncement_id(announcementId);
							RoleCategoryBean roleCategoryBean = new RoleCategoryBean();
							for (Integer category : listOfCategory) {
								roleCategoryBean.setRole_category_id(category);
								AnnouncementCategoryBean announcementCategoryBean = new AnnouncementCategoryBean(
										roleCategoryBean, announcementBean);
								allInsertSelfServiceDAO.announcementCategoryInsert(announcementCategoryBean);
								/*
								 * List<EmployeeBean> listOfEmployeeByCategory =
								 * allListSelfServiceDAO.
								 * listOfEmployeeByCategory(role_authority);
								 */
								RoleCategoryBean roleCategoryBean1 = allListSelfServiceDAO
										.getRoleByName(role_category_id);
								String role_category_name = roleCategoryBean1.getRole_category_name();
								System.out.println("role_category_name" + role_category_name);
								String ad = null;
								List<AnnouncementBean> listOfAnnouncment = allListSelfServiceDAO
										.getListOfAnnouncement(announcementId);
								for (AnnouncementBean a : listOfAnnouncment) {
									announcement_description = a.getAnnouncement_description();
									announcement_date = a.getAnnouncment_date();
									try {

										SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
										Date result = formater.parse(announcement_date);
										SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
										ad = AppDateFormat.format(result);
										System.out.println(AppDateFormat.format(result));

									} catch (ParseException e1) {
										e1.printStackTrace();
									}
									announcement_title = a.getAnnouncement_title();
									announced_by = a.getEmployeeBean().getFirstname() + " "
											+ a.getEmployeeBean().getLastname();
								}

								List<EmployeeBean> listOfEmployeeWithRole = allListSelfServiceDAO
										.listOfEmployeeByCategory(role_category_name);
								for (EmployeeBean e : listOfEmployeeWithRole) {
									String email_id = e.getEmail_id();
									int employee_code = e.getEmployee_code();
									String username = e.getFirstname() + " " + e.getLastname();
									String announcementDescription = announcement_description;
									String announcmentDate = ad;
									String announcementTitle = announcement_title;
									String totime = toTime;
									String fromtime = fromTime;
									String announcedBy = announced_by;
									String departmentName = e.getDepartmentBean().getDepartment_name();

									new Thread(new Runnable() {
										@Override
										public void run() {

											String to = email_id;
											String sub = username + " Broadcast for you";
											String userName = username;
											String to_time = totime;
											String from_time = fromtime;
											String announcement_date = announcmentDate;
											String announcment_title = announcementTitle;
											int emp_code = employee_code;
											String announcement_description = announcementDescription;
											String announced_by = announcedBy;
											String department_name = departmentName;

											/* System.out.println("test"); */

											Mailer.announcementRolecategorySend(to, sub, to_time, from_time,
													announcement_date, emp_code, announcement_description, userName,
													announcment_title, announced_by, department_name,
													role_category_name);

										}
									}).start();
								}
							}
							String ad = null;
							List<AnnouncementBean> listOfAnnouncment = allListSelfServiceDAO
									.getListOfAnnouncement(announcementId);
							for (AnnouncementBean a : listOfAnnouncment) {
								announcement_description = a.getAnnouncement_description();
								announcement_date = a.getAnnouncment_date();
								try {

									SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
									Date result = formater.parse(announcement_date);
									SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
									ad = AppDateFormat.format(result);
									System.out.println(AppDateFormat.format(result));

								} catch (ParseException e1) {
									e1.printStackTrace();
								}
								announcement_title = a.getAnnouncement_title();
								announced_by = a.getEmployeeBean().getFirstname() + " "
										+ a.getEmployeeBean().getLastname();
							}

							DepartmentBean departmentBean = new DepartmentBean();

							for (Integer department : listOfDepartment) {
								departmentBean.setDepartment_id(department);
								AnnouncementDepartmentBean announcementDepartmentBean = new AnnouncementDepartmentBean(
										departmentBean, announcementBean);
								allInsertSelfServiceDAO.announcementDepartmentInsert(announcementDepartmentBean);
								List<EmployeeBean> listOfEmployeeByDepartment = allListSelfServiceDAO
										.listOfEmployeeByDepartment(department_id);
								for (EmployeeBean e : listOfEmployeeByDepartment) {
									String email_id = e.getEmail_id();
									int employee_code = e.getEmployee_code();
									String username = e.getFirstname() + " " + e.getLastname();
									String announcementDescription = announcement_description;
									String announcmentDate = ad;
									String announcementTitle = announcement_title;
									String totime = toTime;
									String fromtime = fromTime;
									String announcedBy = announced_by;
									String departmentName = e.getDepartmentBean().getDepartment_name();

									new Thread(new Runnable() {

										@Override
										public void run() {

											String to = email_id;
											String sub = username + " Broadcast for you";
											String userName = username;
											String to_time = totime;
											String from_time = fromtime;
											String announcement_date = announcmentDate;
											String announcment_title = announcementTitle;
											int emp_code = employee_code;
											String announcement_description = announcementDescription;
											String announced_by = announcedBy;
											String department_name = departmentName;

											System.out.println("test");

											Mailer.announcementDepartmentSend(to, sub, to_time, from_time,
													announcement_date, emp_code, announcement_description, userName,
													announcment_title, announced_by, department_name);
											/*
											 * boolean result =
											 * allUpdateDAO.LeaveMailUpdate(lId)
											 * ;
											 */

										}
									}).start();

								}

							}

							CompanyListBean companyListBean = new CompanyListBean();
							for (Integer company : listOfCompany) {
								companyListBean.setCompany_list_id(company);
								AnnouncementCompanyBean announcementCompanyBean = new AnnouncementCompanyBean(
										companyListBean, announcementBean);
								allInsertSelfServiceDAO.announcementCompanyInsert(announcementCompanyBean);
								String ad1 = null;
								List<AnnouncementBean> listOfAnnouncment1 = allListSelfServiceDAO
										.getListOfAnnouncement(announcementId);
								for (AnnouncementBean a : listOfAnnouncment1) {
									announcement_description = a.getAnnouncement_description();
									announcement_date = a.getAnnouncment_date();
									try {

										SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
										Date result = formater.parse(announcement_date);
										SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
										ad1 = AppDateFormat.format(result);
										System.out.println(AppDateFormat.format(result));

									} catch (ParseException e1) {
										e1.printStackTrace();
									}
									announcement_title = a.getAnnouncement_title();
									announced_by = a.getEmployeeBean().getFirstname() + " "
											+ a.getEmployeeBean().getLastname();
								}
								List<EmployeeBean> listOfEmployeeByCompany = allListSelfServiceDAO
										.listOfEmployeeByCompany(company_list_id);
								for (EmployeeBean e : listOfEmployeeByCompany) {
									
									System.out.println(e.getEmployee_master_id()+":"+e.getEmail_id());
									
									String email_id = e.getEmail_id();
									int employee_code = e.getEmployee_code();
									String username = e.getFirstname() + " " + e.getLastname();
									String announcementDescription = announcement_description;
									String announcmentDate = ad1;
									String announcementTitle = announcement_title;
									String totime = toTime;
									String fromtime = fromTime;
									String announcedBy = announced_by;
									String departmentName = e.getDepartmentBean().getDepartment_name();
									String comapnyName = e.getCompanyListBean().getCompany_name();

									/*new Thread(new Runnable() {
										@Override
										public void run() {

											String to = email_id;
											String sub = username + " Broadcast for you";
											String userName = username;
											String to_time = totime;
											String from_time = fromtime;
											String announcement_date = announcmentDate;
											String announcment_title = announcementTitle;
											int emp_code = employee_code;
											String announcement_description = announcementDescription;
											String announced_by = announcedBy;
											String department_name = departmentName;
											String company_name = comapnyName;

											System.out.println("test");

											Mailer.announcementCompanySend(to, sub, to_time, from_time,
													announcement_date, emp_code, announcement_description, userName,
													announcment_title, announced_by, department_name, company_name);
											
											 * boolean result =
											 * allUpdateDAO.LeaveMailUpdate(lId)
											 * ;
											 

										}
									}).start();*/

								}

							}

							if (request.getAttribute("conflictAnnouncement") == null) {
								request.setAttribute("successAnnouncement", "Broadcast Successfully Added");
							}
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

								announcement_attachment = "-";

							} else if (fieldName.equalsIgnoreCase("attachment")) {
								System.out.println("MIME : " + context.getMimeType(fileName));
								item.write(file);
								System.out.println("===> " + file.getName());

								announcement_attachment = file.getName();
								/*
								 * AnnouncementBean announcementBean = new
								 * AnnouncementBean(announcement_title,
								 * announcement_description,
								 * announcement_attachment,
								 * announcement_enddate,
								 * announcement_submission_date, employeeBean,
								 * fromTime, toTime, announcement_date);
								 * List<AnnouncementBean> checkForTime =
								 * allListSelfServiceDAO.getBetweenTime(
								 * announcement_date, toTime,fromTime); if
								 * (checkForTime.size() == 0) { boolean result =
								 * allInsertSelfServiceDAO.announcementInsert(
								 * announcementBean); } else {
								 * request.setAttribute("conflictAnnouncement",
								 * "The Timeslot you added already have a broadcast for this timeslot..So you can't add announcement for this timeslots"
								 * ); }
								 * 
								 * announcementId =
								 * announcementBean.getAnnouncement_id();
								 * System.out.println("photo uploaded");
								 */
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
