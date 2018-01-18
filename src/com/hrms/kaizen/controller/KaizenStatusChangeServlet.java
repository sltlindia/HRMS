package com.hrms.kaizen.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.dao.AllKaizenListDAO;
import com.hrms.kaizen.dao.AllKaizenUpdateDAO;
import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class KaizenStatusChangeServlet
 */
public class KaizenStatusChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
		LoginDAO loginDAO = new LoginDAO();
		
		
		
		int kaizen_id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		
		AllKaizenUpdateDAO allKaizenUpdateDAO = new AllKaizenUpdateDAO();
		AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
		KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
		EmployeeBean bean = loginDAO.getEmailId(kaizenBean.getManager_id());
		List<KaizenManagerBean> listOfManager = allKaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
		
		String affectingmanager = "";
		for(KaizenManagerBean k : listOfManager) {
			if(affectingmanager.equalsIgnoreCase("")) {
				affectingmanager = k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname();
			}else {
			affectingmanager = affectingmanager+","+k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname();
			}
			}
		
		
		if(status.equalsIgnoreCase("submitted")) {
		boolean result = allKaizenUpdateDAO.kaizenStatusUpdate(kaizen_id, status);
		String managerList = affectingmanager;
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	
		    	String to = bean.getEmail_id();
		    	String sub ="CI Approval Reminder";
		    	String empname = user.getFirstname()+" "+user.getLastname();
		    	String managername = bean.getFirstname()+" "+bean.getLastname();
		    
		    	Mailer.kaizenManagerReminder(to, sub, empname,managername,kaizenBean.getKaizen_name(),kaizenBean.getKaizen_desc(),user.getDepartmentBean().getDepartment_name(),managerList);
		    	System.out.println("Done");
		    	
		    }
		}).start();
		
		
		}else if(status.equalsIgnoreCase("completed")) {
		
			Date date = new Date();
			SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String parseDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			String parseDate1 = new SimpleDateFormat("dd-MMM-yyyy").format(date);
			
			
			Calendar calKaizenDate = Calendar.getInstance();
			Calendar calkaizenCompletionDate = Calendar.getInstance();
			int numberOfDays = 0;
			
			System.out.println(kaizenBean.getDate());
			System.out.println(parseDate);
			
			
			  try {
				calKaizenDate.setTime(yyyyMMdd.parse(kaizenBean.getDate()));
				calkaizenCompletionDate.setTime(yyyyMMdd.parse(parseDate)); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			  
			  while (calKaizenDate.before(calkaizenCompletionDate)) {
			      numberOfDays++;
			      calKaizenDate.add(Calendar.DATE,1);
			}
			
			String output = parseDate1+","+numberOfDays;
			
		boolean result = allKaizenUpdateDAO.kaizenStatusUpdateWithTime(kaizen_id, status,parseDate);
		
		response.getWriter().print(output);
		
		}
		
	
	}

}
