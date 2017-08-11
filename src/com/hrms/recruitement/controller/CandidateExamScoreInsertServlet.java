package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.CandidateExamScoreBean;
import com.hrms.recruitement.bean.InductionQABean;
import com.hrms.recruitement.bean.InterviewQaWithResumeidBean;
import com.hrms.recruitement.bean.InterviewQuestionBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllInsertDAO;

//
public class CandidateExamScoreInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String total_iq_score = null;
		String total_technical_interview_score = null;
		String total_technical_written_score = null;
		String total_hr_interview_score = null;
		String total_gd_score = null;
		String obtained_iq_score = null;
		String obtained_technical_interview_score = null;
		String obtained_technical_written_score = null;
		String obtained_hr_interview_score = null;
		String obtained_gd_score = null;
		String total_personality_score = null;
		String total_aptitude_score = null;
		String obtained_personality_score = null;
		String obtained_aptitude_score = null;
		int resume_data_id = 0;
		double total = 0;
		double obtain = 0;
		double average = 0;
		ResumeDataBean resumeDataBean = new ResumeDataBean();
		resume_data_id = Integer.parseInt(request.getParameter("resumeDataId"));
		System.out.println("resume_data_id"+resume_data_id);
		resumeDataBean.setResume_data_id(resume_data_id);

		InterviewQuestionBean interviewQuestionBean = new InterviewQuestionBean();
		
		List<Integer> questionList = new ArrayList<>();
	    List<String> answerList = new ArrayList<>();
	    List<String> ratingList = new ArrayList<>();
	   
	    String[] question_id = request.getParameterValues("question_id");
	    String[] answer = request.getParameterValues("answer");
	    String[] rating = request.getParameterValues("rating");
	    
	    for(String q_id:question_id){
	    	System.out.println("q_id :"+ q_id);
	    	int qid = Integer.parseInt(q_id);
	    	questionList.add(qid);
	    }
	    
	    for(String ans:answer){
	    	System.out.println("answer :"+ans);
	    	answerList.add(ans);
	    }
	    for(String rat:rating){
	    	System.out.println("rating :"+ rat);
	    	ratingList.add(rat);
	    }
	    
	  for(int i=0;i<question_id.length;i++){
		  int qqid = questionList.get(i);
		  interviewQuestionBean.setInterview_question_id(qqid);
		  String answer1 = answerList.get(i);
		  String rating1 = ratingList.get(i);
		  
		  AllInsertDAO allInsertDAO = new AllInsertDAO();
		  InterviewQaWithResumeidBean interviewQaWithResumeidBean = new InterviewQaWithResumeidBean(answer1, rating1, interviewQuestionBean, resumeDataBean);
		  boolean result = allInsertDAO.interviewQaWithResumeidInsert(interviewQaWithResumeidBean);
	  }  
	    
	    
	    
	    
	    System.out.println("size:"+question_id.length);
		
		
		
		
		total_iq_score = request.getParameter("totalIqScore");
		System.out.println("totalIqScore : " + total_iq_score);
		
		total_technical_written_score = request.getParameter("totalTechWrittenScore");
		System.out.println("totalTechWrittenScore :"+total_technical_written_score);

		total_technical_interview_score = request.getParameter("totalTechInterviewScore");
		System.out.println("totalTechInterviewScore"+total_technical_interview_score);
		
		total_hr_interview_score = request.getParameter("totalHrInterviewScore");
		System.out.println("totalHrInterviewScore"+ total_hr_interview_score);
		
		total_gd_score = request.getParameter("totalGdScore");
		System.out.println("totalGdScore"+ total_gd_score);
		
		total_personality_score = request.getParameter("totalPersonalityScore");
		System.out.println("total_personality_score"+total_personality_score);
		
		total_aptitude_score = request.getParameter("totalAptitudeScore");
		System.out.println("total_aptitude_score"+total_aptitude_score);
		
		obtained_personality_score = request.getParameter("obtainedPersonalityScore");
		System.out.println("obtained_personality_score"+obtained_personality_score);
		
		obtained_aptitude_score = request.getParameter("obtainedAptitudeScore");
		System.out.println("obtained_aptitude_score"+obtained_aptitude_score);
		
		obtained_iq_score = request.getParameter("obtainedIqScore");
		System.out.println("obtainedIqScore : " + obtained_iq_score);
		
		obtained_technical_interview_score = request.getParameter("obtainedTechInterviewScore");
		System.out.println("obtainedTechWrittenScore :"+obtained_technical_interview_score);
		
		obtained_technical_written_score = request.getParameter("obtainedTechWrittenScore");
		System.out.println("obtainedTechInterviewScore"+obtained_technical_written_score);
		
		obtained_hr_interview_score = request.getParameter("obtainedHrInterviewScore");
		System.out.println("obtainedHrInterviewScore"+ obtained_hr_interview_score);
		
		obtained_gd_score = request.getParameter("obtainedGdScore");
		System.out.println("obtainedGdScore"+ obtained_gd_score);
		
		
		
		
		total = Integer.parseInt(total_iq_score) + Integer.parseInt(total_technical_interview_score) + 
				Integer.parseInt(total_technical_written_score) + Integer.parseInt(total_hr_interview_score) + Integer.parseInt(total_gd_score) + Integer.parseInt(total_personality_score) + Integer.parseInt(total_aptitude_score);
		obtain = Integer.parseInt(obtained_iq_score) + Integer.parseInt(obtained_technical_written_score) + Integer.parseInt(obtained_technical_interview_score) + Integer.parseInt(obtained_hr_interview_score)
					+ Integer.parseInt(obtained_gd_score) + Integer.parseInt(obtained_personality_score) + Integer.parseInt(obtained_aptitude_score);
		
		average = ((obtain*100)/total);
		System.out.println("average :"+average);
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		CandidateExamScoreBean candidateExamScoreBean = new CandidateExamScoreBean(total_iq_score, total_technical_written_score, total_technical_interview_score, total_hr_interview_score, total_gd_score, obtained_iq_score, obtained_technical_written_score, obtained_technical_interview_score, obtained_hr_interview_score, obtained_gd_score, resumeDataBean, average,total_personality_score,total_aptitude_score,obtained_personality_score,obtained_aptitude_score);
		boolean result = allInsertDAO.candidateExamScoreInsert(candidateExamScoreBean);
		response.sendRedirect("hrHome.jsp");
	}

}
