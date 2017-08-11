package com.hrms.recruitement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.NotifyToCandidateBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllInsertDAO;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;
import com.hrms.recruitement.dao.AllUpdateDAO;

public class NotifyToCandidateInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 ResumeDataBean resumeDataBean = new ResumeDataBean();
		int resume_data_id = Integer.parseInt(request.getParameter("candidateName"));
		System.out.println("resume_data_id"+resume_data_id);
		
		String status = "notified";
		int resume_d_id = Integer.parseInt(request.getParameter("resume_d_id"));
		
		String interview_date = request.getParameter("interviewDate");
		System.out.println("interview_date"+ interview_date);
		
		String sd = null;
		
			try {
				  
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				Date result = formater.parse(interview_date);
				SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				sd = AppDateFormat.format(result);
				System.out.println(AppDateFormat.format(result));
				
				
				
			} catch (ParseException e1) {
				e1.printStackTrace();
			}	
		
		
		
		String interview_time = request.getParameter("interviewTime");
		System.out.println("interview_time"+ interview_time);
		
		String title_of_position = request.getParameter("titleOfPosition");
		System.out.println("title_of_position"+title_of_position);
		
		String interview_location = request.getParameter("interviewLocation");
		System.out.println("interview_location"+interview_location);
		resumeDataBean.setResume_data_id(resume_data_id);
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		NotifyToCandidateBean notifyToCandidateBean = new NotifyToCandidateBean(interview_date, interview_time, title_of_position, interview_location,resumeDataBean);
		boolean result = allInsertDAO.notifyToCandidateInsert(notifyToCandidateBean);
		
		AllRecruitmentListDAO allRecruitmentListDAO = new AllRecruitmentListDAO();
		List<NotifyToCandidateBean> getListOfCandidateDetail = allRecruitmentListDAO.getListOfCandidateDetail(resume_data_id);
		String title_of_position1 = null;
		String to = null;
		for(NotifyToCandidateBean n : getListOfCandidateDetail){
		title_of_position1 = n.getResumeDataBean().getVacancyFormBean().getTitle_of_position();
		
		
		
		to = n.getResumeDataBean().getEmail();
		}
		String subject = "Confirmation  for interview";

		String msg ="Dear Candidate";
		String msg1 = "Your resume has been shortlisted .You are invited for the interview as per below details.";
		String position = title_of_position1;
		String desc1 = sd; 
		String desc2=  interview_time;
		String desc3=  interview_location;
		String desc4 = "Please contact our front desk/security once you arrive at our company.";
		String desc5 = "Come Alteast 15 minutes before from your interview schedule time.";
		String desc6 = "In case of any problem please contact us at +91-7961701616.";
		String to1 = to;
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	
		    	Mailer.send(to1, subject, msg, msg1,position, desc1,desc2 ,desc3,desc4,desc5,desc6);
		    	System.out.println("message has been sent successfully");
		    }
		}).start();
		ResumeDataBean resumeDataBean1 = new ResumeDataBean();
		resumeDataBean.setResume_data_id(resume_d_id);
		
		AllUpdateDAO allUpdateDAO =new AllUpdateDAO();
		
		boolean result1 = allUpdateDAO.resumeStatusUpdate(status, resume_d_id);
		
		
		request.setAttribute("resume_id", resume_data_id);
		request.getRequestDispatcher("candidateExamTypes.jsp").forward(request, response);
	
	
	}

}
