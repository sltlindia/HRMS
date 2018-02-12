package com.hrms.selfservice.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.DownloadBean;
import com.hrms.selfservice.dao.AllInsertSelfServiceDAO;
import com.hrms.selfservice.dao.AllListSelfServiceDAO;

public class DownloadInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadInsertServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			int download_id =0;
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date2 = new Date();
			System.out.println(dateFormat.format(date2));
			String date = dateFormat.format(date2);
			int employee_master_id = user.getEmployee_master_id();
			int extension = Integer.parseInt(request.getParameter("extension"));
			String link = request.getParameter("link");
			String status = "pending";
	
	
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);
	
	DownloadBean downloadBean = new DownloadBean(extension,link, date, status, employeeBean);
	AllInsertSelfServiceDAO allInsertSelfServiceDAO = new AllInsertSelfServiceDAO();
	boolean result = allInsertSelfServiceDAO.downloadInsert(downloadBean);
	download_id = downloadBean.getDownload_id();
	
	AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
	List<DownloadBean> listofDown = allListSelfServiceDAO.getdownloadByDownoadId(download_id);
	for (DownloadBean d : listofDown) {
		String email_id = "it@sahajanandlaser.com"; 
		/*String email_id = "cprajapati1404@gmail.com"; */
		int employee_code = user.getEmployee_code();
		String username = user.getFirstname() + " " + user.getLastname();
		String link1 = d.getLink();
		String complaintDate = date;
		String dept = d.getEmployeeBean().getDepartmentBean().getDepartment_name();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				String to = email_id;
				String sub = username + " Register a complaint.";
				String userName = username;
				
				String complaint_date = null;
				
				DateFormat appFormater = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				try {
					
					Date result = dateFormat.parse(complaintDate);
					complaint_date = appFormater.format(result);
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				
				int emp_code = employee_code;
				String date = complaint_date;
				String emp_name = username;
				String link1 = link;
				String department = dept;
				

				 System.out.println("test"); 

				Mailer.downloadSend(to, sub, complaint_date, emp_code, username,
						department,link1);

			}
		}).start();
	}
	
	
	request.getRequestDispatcher("complaint.jsp").forward(request, response);
	
	
	
			}
	
		}
}
