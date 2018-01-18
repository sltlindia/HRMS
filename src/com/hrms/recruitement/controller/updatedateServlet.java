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

import com.hrms.recruitement.bean.NotifyToCandidateBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;


/**
 * Servlet implementation class updatedateServlet
 */
public class updatedateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatedateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("DONE");
		
		//String GEtDate = request.getParameter("fromDate");
		
		String GEtDate = "09/03/2017";
		//int ID = Integer.parseInt(request.getParameter("ID123"));
		
		int ID = 48;
		
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy"); //08/09/2017
		SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd"); // 2017-09-11
		
		AllRecruitmentListDAO listDAO = new AllRecruitmentListDAO();
		List<ResumeDataBean> listof = listDAO.getListOfupdateinterviewdate(ID);
		String title_of_position1 = "" , interview_time = ""  , interview_location = "" ,to = "" , candidate_name = "";
		String email = "";
		List<String> arrayEmail = new ArrayList<>();
		for(ResumeDataBean re : listof)
		{
			
			int idq = re.getResume_data_id();
			candidate_name = re.getName();
			List<NotifyToCandidateBean> listof2date = listDAO.getListuseforupdateinterviewDate1(idq);
			arrayEmail.add(re.getEmail());
			for(NotifyToCandidateBean n : listof2date)
			{
				interview_time = n.getInterview_time();
			}
			
			
			/*interview_time = re.
			
			String[] split = email.split(",");
			for(String splitEmail : split){
				
				
				if(!splitEmail.equalsIgnoreCase(""))
				{
				arrayEmail.add(splitEmail);
				}*/
			
		}
		
		
		String sd = null;
		
		try {
			  
			SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
			Date result = formater.parse(GEtDate);
			SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			sd = AppDateFormat.format(result);
			System.out.println(AppDateFormat.format(result));
			
			
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}	
	
		
		
		
		try
		{
			
				
				
				
				String subject = "re interview";

				String msg ="Dear Candidate";
				//String msg1 = "Your resume has been shortlisted .You are invited for the interview as per below details.";
				//String position = title_of_position1;
				String desc1  = sd; 
				String desc2 =  interview_time;
				String desc3=  interview_location;
				String desc4 = "Please contact our front desk/security once you arrive at our company.";
				String desc5 = "Come Alteast 15 minutes before from your interview schedule time.";
				String desc6 = "In case of any problem please contact us at +91-7961701616.";
				String to1 = to;
				
				/*new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	Mailer.send(to1, subject, msg, desc1,desc2 ,desc3,desc4,desc5,desc6);
				    	System.out.println("message has been sent successfully");
				    }
				}).start();*/
				
				String name = candidate_name;
				new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	String a = desc1;
				    	String sub = " Interview Notification";
				    	String desc = "Mr./Miss/Mrs. "+name;
				    	String desc1 = "Your interview for rescheduled on "+a+" "+desc2;
				    	Mailer.send12(sub, desc , desc1 ,arrayEmail);
				    	
				    }
				}).start();
				
				
				
			
			
		}
		catch (Exception e) {
			// TODO: handle exceptions
		}
		
		response.sendRedirect(("myVacancyAllocation.jsp"));
		
		
		}
		
	

}
