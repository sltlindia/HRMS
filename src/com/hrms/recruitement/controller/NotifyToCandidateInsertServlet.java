package com.hrms.recruitement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.bean.GrievanceEmailBean;
import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.recruitement.bean.InterviewManagerEmailBean;
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
		
		AllRecruitmentListDAO allRecruitmentListDAO = new AllRecruitmentListDAO();
		String candidate_name = null;
		
		String status = "notified";
		int resume_d_id = Integer.parseInt(request.getParameter("resume_d_id"));
		List<ResumeDataBean> listOfResume = allRecruitmentListDAO.getListOfResumeData(resume_d_id);
		for(ResumeDataBean r : listOfResume){
			candidate_name = r.getName();
		}
		
		String interview_date = request.getParameter("interviewDate");
		System.out.println("interview_date"+ interview_date);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		
		String interview_type = request.getParameter("interviewType");
		System.out.println("interview type :"+ interview_type);
		List<String> arrayEmail = new ArrayList<>();
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
		
			String email = request.getParameter("email");
			
					System.out.println("email:"+email);
					
					String[] split = email.split(",");
					for(String splitEmail : split){
						
						
						if(!splitEmail.equalsIgnoreCase("")){
						arrayEmail.add(splitEmail);
						/*String msg1 = query;
						String type1 = type;
						String name1 = fileName;*/
					
					resumeDataBean.setResume_data_id(resume_d_id);
					
					InterviewManagerEmailBean interviewManagerEmailBean = new InterviewManagerEmailBean(splitEmail, resumeDataBean);
					boolean result1 = allInsertDAO.interviewManagerEmailInsert(interviewManagerEmailBean);
					
					}
				}
		
		String interview_time = request.getParameter("interviewTime");
		System.out.println("interview_time"+ interview_time);
		
		String title_of_position = request.getParameter("titleOfPosition");
		System.out.println("title_of_position"+title_of_position);
		
		String interview_location = request.getParameter("interviewLocation");
		System.out.println("interview_location"+interview_location);
		resumeDataBean.setResume_data_id(resume_data_id);
		
		NotifyToCandidateBean notifyToCandidateBean = new NotifyToCandidateBean(interview_date, interview_time, title_of_position, interview_location,resumeDataBean, interview_type);
		boolean result = allInsertDAO.notifyToCandidateInsert(notifyToCandidateBean);
		
		List<NotifyToCandidateBean> getListOfCandidateDetail = allRecruitmentListDAO.getListOfCandidateDetail(resume_data_id);
		String title_of_position1 = null;
		String to = null;
		for(NotifyToCandidateBean n : getListOfCandidateDetail){
		title_of_position1 = n.getResumeDataBean().getVacancyFormBean().getTitle_of_position();
		to = n.getResumeDataBean().getEmail();
		}
		System.out.println("email id"+to);
		
		
		String subject = "Confirmation  for Interview";

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
		
		String name = candidate_name;
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	
		    	String sub = " Interview Notification";
		    	String desc = "Mr./Miss/Mrs. "+name;
		    	String desc1 = "is confirmed for "+interview_type+" round of interview on "+interview_date+" "+interview_time;
		    	
		    	Mailer.send1(sub, desc , desc1 ,arrayEmail);
		    	
		    }
		}).start();
		
		ResumeDataBean resumeDataBean1 = new ResumeDataBean();
		resumeDataBean.setResume_data_id(resume_d_id);
		
		AllUpdateDAO allUpdateDAO =new AllUpdateDAO();
		
		boolean result1 = allUpdateDAO.resumeStatusUpdateAtNotify(status, resume_d_id);
		
		
		request.setAttribute("resume_id", resume_data_id);
		response.sendRedirect(("hrHome.jsp"));
	
	
	}

}
