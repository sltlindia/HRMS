package com.hrms.lms.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.lms.bean.IntervieweeBean;
import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.util.HibernateUtil;

public class AllUpdateDAO 
{
	public boolean LeaveUpdate(String ColumnName , Double maternity_Leave,int employee_master_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 System.out.println("Emp Is :"+ employee_master_id);
			 System.out.println("count :"+ maternity_Leave);
			 System.out.println("column :"+ ColumnName);
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("UPDATE LeaveBalanceBean SET " + ColumnName + " = :pl where employee_master_id = :empid");
			 query.setDouble("pl" ,maternity_Leave);
			 query.setInteger("empid",employee_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveUpdate1(String ColumnName1 , double CO, String ColunmName2 , double PL , String ColunmName3 , double SL , String ColunmName4 , double LWP , int employee_master_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 System.out.println("Emp Is :"+ employee_master_id);
			 System.out.println("count :"+ CO);
			 System.out.println("column1 :"+ PL);
			 System.out.println("column2 :"+ SL);
			 System.out.println("adjust :"+ LWP);
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBalanceBean set "+ ColumnName1 +" = :CO , "+ ColunmName2 +" = :PL , "+ ColunmName3 +" = :SL , "+ ColunmName4 +" = :LWP  where employeeBean = :empid");
			 query.setDouble("CO"   ,CO);
			 query.setDouble("PL"   ,PL);
			 query.setDouble("SL"   ,SL);
			 query.setDouble("LWP" ,LWP);
			 query.setInteger("empid", employee_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean LeaveUpdateBeforeApproved(String ColumnName1 , double CO, String ColunmName2 , double PL , String ColunmName3 , double SL, String colunmname4 , double adjest ,  int employee_master_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBalanceBean set "+ ColumnName1 +" = :CO , "+ ColunmName2 +" = :PL , "+ ColunmName3 +" = :SL , " + colunmname4 + " = :LWP   where employeeBean = :empid");
			 query.setDouble("CO"   ,CO);
			 query.setDouble("PL"   ,PL);
			 query.setDouble("SL"   ,SL);
			 query.setDouble("LWP"   ,adjest);
			 query.setInteger("empid", employee_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveUpdateStatus(String status ,int leave_id,String approval_date)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set status = :st ,approval_rejected_date = :ad, mail_view = :mv  where leave_id = :lid");
			 query.setString("st" ,status);
			 query.setString("ad" ,approval_date);
			 query.setInteger("mv",0);
			 query.setInteger("lid",leave_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveStatusreject(String status , String reason , int leave_id ,String approvalDate)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set status = :st , reason = :re , approval_rejected_date = :ard, mail_view = :mv where leave_id = :lid");
			 query.setString("st" ,status);
			 query.setString("re" ,reason);
			 query.setInteger("lid",leave_id);
			 query.setInteger("mv",0);
			 query.setString("ard" ,approvalDate);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean Leaverejectupdate(String Purpose_of_Leave ,String fromDate, String toDate, double daycount, double CO , double PL ,double SL , double LWP , String Address, String Number, String pushMainDate , String popMainDate , String status, int leaveid,String RFT,String RTT)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set Purpose_of_Leave = :PPL ,Leave_From = :fd ,Leave_To = :td ,Day_count = :dc ,CO = :CO ,PL = :PL ,SL = :SL ,LWP = :LWP ,Address = :add ,Number = :num , pushMainDate = :push , popMainDate =:pop , status = :st, from_half = :RFT, to_half = :RTT  where leave_id = :lid");
			 query.setString("PPL",Purpose_of_Leave);
			 query.setString("fd",fromDate);
			 query.setString("td",toDate);
			 query.setDouble("dc",daycount);
			 query.setDouble("CO",CO);
			 query.setDouble("PL",PL);
			 query.setDouble("SL",SL);
			 query.setDouble("LWP",LWP);
			 query.setString("add",Address);
			 query.setString("num",Number);
			 query.setString("push",pushMainDate);
			 query.setString("pop",popMainDate);
			 query.setString("st",status);
			 query.setString("RFT",RFT);
			 query.setString("RTT",RTT);
			 query.setInteger("lid",leaveid);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeavesendwitchleaveBeanupdate(String Purpose_of_Leave ,String fromDate, String RFT , String toDate, String RTT , double daycount, double CO , double PL ,double SL , double LWP , String Address, String Number, String status, String PushDate , String popdate,  int leaveid,String date1)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set Purpose_of_Leave = :PPL ,Leave_From = :fd , from_half =:RFT , Leave_To = :td , to_half =:RTT , Day_count = :dc ,CO = :CO ,PL = :PL ,SL = :SL ,LWP = :LWP ,Address = :add ,Number = :num , status = :st, pushMainDate =:PSD , popMainDate =:PPD, submission_date =:sbd, show_view = :sv, mail_view = :mv where leave_id = :lid");
			 query.setString("PPL",Purpose_of_Leave);
			 query.setString("fd",fromDate);
			 query.setString("RFT",RFT);
			 query.setString("td",toDate);
			 query.setString("RTT",RTT);
			 query.setDouble("dc",daycount);
			 query.setDouble("CO",CO);
			 query.setDouble("PL",PL);
			 query.setDouble("SL",SL);
			 query.setDouble("LWP",LWP);
			 query.setString("add",Address);
			 query.setString("num",Number);
			 query.setString("st",status);
			 query.setString("PSD",PushDate);
			 query.setString("PPD",popdate);
			 query.setString("sbd",date1);
			 query.setInteger("sv",0);
			 query.setInteger("mv",0);
			 query.setInteger("lid",leaveid);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	/*leaveBean,BCO,BPL,BSL,ADJDAY , MAIN_CO , MAIN_PL , MAIN_SL , MAIN_LWP);*/
	
	
	public boolean Leavesendwitchroulupdate(double BCO , double BPL , double BSL , double ADJDAY , double MAIN_CO , double MAIN_PL , double MAIN_SL , double MAIN_LWP,  int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeavecutBalance set CO = :BCO , PL =:BPL , SL =:BSL , LWP =:BLWP , Main_CO = :MAIN_CO , Main_PL = :MAIN_PL , Main_SL = :MAIN_SL , Main_LWP =:MAIN_LWP  where leave_id = :leaveid");
			 query.setDouble("BCO", BCO);
			 query.setDouble("BPL", BPL);
			 query.setDouble("BSL", BSL);
			 query.setDouble("BLWP", ADJDAY);
			 query.setDouble("MAIN_CO", MAIN_CO);
			 query.setDouble("MAIN_PL", MAIN_PL);
			 query.setDouble("MAIN_SL", MAIN_SL);
			 query.setDouble("MAIN_LWP", MAIN_LWP);
			 query.setInteger("leaveid",leave_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveUpdateHR(String ColumnName1 , double sumplan , String currentdate , String column2 , String Reason , int employee_master_id,String name)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			// System.out.println("Emp Is :"+ employee_master_id);
			 System.out.println("column Name Query :"+ ColumnName1);
			 System.out.println("Add value Query  :"+ sumplan);
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBalanceBean set " + ColumnName1 + " = :pl , leave_update_date = :cd , leave_update_name =:nm  , " + column2 + " = :re where employeeBean = :empid");
			 query.setDouble("pl" ,sumplan);
			 query.setString("cd",currentdate);
			 query.setString("nm", name);
			 query.setString("re",Reason);
			 query.setInteger("empid",employee_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	
	public boolean LeaveUpdateAfterApproved(int employee_master_id,double co,double pl,double sl,double lwp)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveBalanceBean set Plan_Leave = :pl ,Unplan_Leave =:sl,CO =:co,Leave_without_pay =:lwp where employeeBean = :empid");
			 query.setDouble("pl" ,pl);
			 query.setDouble("sl" ,sl);
			 query.setDouble("co" ,co);
			 query.setDouble("lwp" ,lwp);
			 query.setInteger("empid",employee_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	

	public boolean LeaveCUTUpdateBeforeApproved(double BCO , double BPL , double BSL , double ADJUST , int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeavecutBalance set CO = :cutCo , PL =:cutPl , SL =:cutSL , LWP =:cutLwp where leave_id = :leaveid");
			 query.setDouble("cutCo", BCO);
			 query.setDouble("cutPl", BPL);
			 query.setDouble("cutSL", BSL);
			 query.setDouble("cutLwp", ADJUST);
			 query.setInteger("leaveid",leave_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveShowView(int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set show_view = :sv where leave_id = :lid");
			 query.setInteger("sv" ,1);
			 query.setInteger("lid",leave_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean COShowView(int CO_ID)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveCOBean set show_view = :sv where CO_ID = :lid");
			 query.setInteger("sv" ,1);
			 query.setInteger("lid",CO_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean ODShowView(int OD_ID)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveODBean set show_view = :sv where OD_ID = :lid");
			 query.setInteger("sv" ,1);
			 query.setInteger("lid",OD_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveCancelled(String status ,int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set status = :st , show_view = :sv where leave_id = :lid");
			 query.setString("st" ,status);
			 query.setInteger("sv",1);
			 query.setInteger("lid",leave_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveCOUpdateStatus(String status , String apdate , int CO_ID)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveCOBean set status = :st, mail_view = :mv , approval_rejected_date =:ap  where CO_ID = :CO_ID ");
			 query.setString("st" ,status);
			 query.setString("ap" ,apdate);
			 query.setInteger("mv",0);
			 query.setInteger("CO_ID",CO_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean ODApprovedStatus(String status , String apdate , int OD_ID)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveODBean set status = :st,mail_view = :mv, approval_rejected_date =:ap where OD_ID = :OD_ID");
			 query.setString("st" ,status);
			 query.setInteger("mv",0);
			 query.setString("ap" ,apdate);
			 query.setInteger("OD_ID",OD_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean COStatusreject(String status , String reason , int CO_ID)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveCOBean set status = :st , reason = :re ,mail_view = :mv where CO_ID = :CO_ID");
			 query.setString("st" ,status);
			 query.setString("re" ,reason);
			 query.setInteger("CO_ID",CO_ID);
			 query.setInteger("mv",0);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean ODStatusreject(String status , String reason , int OD_ID)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveODBean set status = :st , reason = :re, mail_view= :mv where OD_ID = :CO_ID");
			 query.setString("st" ,status);
			 query.setString("re" ,reason);
			 query.setInteger("mv",0);
			 query.setInteger("CO_ID",OD_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}

	public boolean COUpdateManager(double SUMCO , int EMP_ID)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBalanceBean set CO = :co  where employee_master_id = :emp_id");
			 query.setDouble("co", SUMCO);
			 query.setInteger("emp_id",EMP_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean COupdateEmployee(String date , String Start_time , String End_time , double Totalhoures , String Status , int CO_ID,String describ)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveCOBean set CO_date = :co , Start_time = :cst , End_time = :et, Total_Hours = :th, status = :st, decripction = :des  where CO_ID = :co_id");
			 query.setString("co", date);
			 query.setString("cst", Start_time);
			 query.setString("et", End_time);
			 query.setDouble("th",Totalhoures);
			 query.setString("st", Status);
			 query.setString("des", describ);
			 query.setInteger("co_id",CO_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	
	public boolean ODupdateEmployee(String Start_Date , String End_Date , String Start_Time , String End_Time , int Total_Day , String Status , int OD_ID,String describe)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveODBean set OD_StartDate = :sd , OD_EndDate = :ed , OD_StartTime = :ost, OD_EndTime = :oet, OD_TotalDay = :th , status = :st , description = :desc  where OD_ID = :OD_ID");
			 query.setString("sd", Start_Date);
			 query.setString("ed", End_Date);
			 query.setString("ost", Start_Time);
			 query.setString("oet", End_Time);
			 query.setInteger("th",Total_Day);
			 query.setString("st", Status);
			 query.setString("desc", describe);
			 query.setInteger("OD_ID",OD_ID);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	

	public boolean HolidaysUpdatesHR(String Dates , String Name , int Holidays_Id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 try {
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("update HolidayBean set holiday_date = :hd , holiday_name = :hn where holiday_id = :hid");
				 query.setString("hd" ,Dates);
				 query.setString("hn" ,Name);
				 query.setInteger("hid",Holidays_Id);
				 int result = query.executeUpdate();
				 System.out.println("result :"+result);
				 tx.commit();
			
		 } 
		 catch (Exception e)
		 {
			 if (tx != null) {
				 tx.rollback();
		 }
			 e.printStackTrace();
		 } finally 
		 {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean LeaveHrApprove(int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set HR_Flag_unplan_leave = :st where leave_id = :lid");
			 query.setString("st" ,"YES");
			 query.setInteger("lid",leave_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}

	
	public boolean COCancelEmployee(int CO_id)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveCOBean set status = :st where CO_ID = :co_id");
			 query.setString("st", "cancelled");
			 query.setInteger("co_id",CO_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean ODCancelEmployee(int OD_id)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveODBean set status = :st where OD_ID = :OD_id");
			 query.setString("st", "cancelled");
			 query.setInteger("OD_id",OD_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveApproveupdate(String Purpose_of_Leave ,String fromDate, String toDate, double daycount, String Address, String Number, int leaveid,String RFT,String RTT)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set Purpose_of_Leave = :PPL ,Leave_From = :fd ,Leave_To = :td ,Day_count = :dc ,Address = :add ,Number = :num , from_half = :RFT, to_half = :RTT  where leave_id = :lid");
			 query.setString("PPL",Purpose_of_Leave);
			 query.setString("fd",fromDate);
			 query.setString("td",toDate);
			 query.setDouble("dc",daycount);
			 query.setString("add",Address);
			 query.setString("num",Number);
			 query.setString("RFT",RFT);
			 query.setString("RTT",RTT);
			 query.setInteger("lid",leaveid);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean LeaveCUTUpdateApproved(double BCO , double BPL , double BSL , double LWP , int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeavecutBalance set CO = :cutCo , PL =:cutPl , SL =:cutSL , LWP =:cutLwp where leave_id = :leaveid");
			 query.setDouble("cutCo", BCO);
			 query.setDouble("cutPl", BPL);
			 query.setDouble("cutSL", BSL);
			 query.setDouble("cutLwp", LWP);
			 query.setInteger("leaveid",leave_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveMailUpdate(int leaveid,int mail_view)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveBean set mail_view = :mail where leave_id = :lid");
			 query.setInteger("mail",mail_view);
			 query.setInteger("lid",leaveid);
			 int result = query.executeUpdate();
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean CoMailUpdate(int coId,int mail_view)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveCOBean set mail_view = :mail where CO_ID = :cid");
			 query.setInteger("mail",mail_view);
			 query.setInteger("cid",coId);
			 int result = query.executeUpdate();
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean ODMailUpdate(int odId,int mail_view)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveODBean set mail_view = :mail where OD_ID = :odid");
			 query.setInteger("mail",mail_view);
			 query.setInteger("odid",odId);
			 int result = query.executeUpdate();
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}

	public boolean LeaveCancelUpdate(int leaveid,String status)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveCancelRequestBean set approved_status = :as, mail_view = :mv where leave_id = :lid");
			 query.setString("as", status);
			 query.setInteger("lid",leaveid);
			 query.setInteger("mv",0);
			 int result = query.executeUpdate();
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveApprovanceupdate(String fromDate, String toDate, double daycount,int leaveid,String RFT,String RTT)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set Leave_From = :fd ,Leave_To = :td ,Day_count = :dc , from_half = :RFT, to_half = :RTT  where leave_id = :lid");
			 query.setString("fd",fromDate);
			 query.setString("td",toDate);
			 query.setDouble("dc",daycount);
			 query.setString("RFT",RFT);
			 query.setString("RTT",RTT);
			 query.setInteger("lid",leaveid);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean LeaveApprovanceUpdate(int leaveid,String status,String fromDate,String toDate, String fromHalf,String toHalf,double days)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveCancelRequestBean set approved_status = :as,updated_leave_from = :ulf,updated_leave_to = :ult,updated_day_count = :udc, updated_from_half = :ufh,updated_to_half = :uth, mail_view = :mv  where leave_id = :lid");
			 query.setString("as", status);
			 query.setString("ulf", fromDate);
			 query.setString("ult", toDate);
			 query.setDouble("udc", days);
			 query.setString("ufh", fromHalf);
			 query.setString("uth", toHalf);
			 query.setInteger("lid",leaveid);
			 query.setInteger("mv",0);
			 int result = query.executeUpdate();
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean cancelLeaveMailUpdate(int leaveid)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update LeaveCancelRequestBean set mail_view = :mail where leaveBean = :lid");
			 query.setInteger("mail",1);
			 query.setInteger("lid",leaveid);
			 int result = query.executeUpdate();
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean gatePassStatusUpdate(int gate_pass_id, String status,String date,  String reason , int Approved_ID)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 Query query = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 if(status.equalsIgnoreCase("Approved"))
			 {
				 query = session.createQuery("update GatePassBean set status =:st, approve_reject_date_time =:date , approve_ID =:aid where gate_pass_id =:gp_id");
			 }
			 else
			 {
				 query = session.createQuery("update GatePassBean set status =:st, approve_reject_date_time =:date, approve_ID =:aid, rejected_reason =:r where gate_pass_id =:gp_id");
				 query.setString("r", reason);
			 }
			 query.setString("st", status);
			 query.setString("date", date);
			 query.setInteger("aid",Approved_ID);
			 query.setInteger("gp_id",gate_pass_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean gatePassStatusCancelledEMP(int gate_pass_id, String status)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 Query query = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 
				 query = session.createQuery("update GatePassBean set status = :st  where gate_pass_id = :gp_id");
			
			 query.setString("st", status);
			 query.setInteger("gp_id",gate_pass_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean gatePassInOutStatusUpdate(int gate_pass_id, String status,String date)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 Query query = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 if(status.equalsIgnoreCase("Out")){
				 query = session.createQuery("update GatePassBean set status = :st, security_out_time =:date where gate_pass_id = :gp_id");
			 }else{
				 query = session.createQuery("update GatePassBean set status = :st, security_in_time =:date where gate_pass_id = :gp_id");
			 }
			 query.setString("st", status);
			 query.setString("date", date);
			 query.setInteger("gp_id",gate_pass_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	
	public boolean gatePassTimeUpdate(int gate_pass_id, String status,String date)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 Query query = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 if(status.equalsIgnoreCase("Out")){
				 query = session.createQuery("update GatePassBean set destination_out_time =:date where gate_pass_id = :gp_id");
			 }else{
				 query = session.createQuery("update GatePassBean set destination_in_time =:date where gate_pass_id = :gp_id");
			 }
			 query.setString("date", date);
			 query.setInteger("gp_id",gate_pass_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	

	public boolean gatePassInOutStatusUpdateWithSecurityId(int gate_pass_id, String status, String date, int e_id) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 Query query = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 if(status.equalsIgnoreCase("Out")){
				 query = session.createQuery("update GatePassBean set status = :st, security_out_time =:date,approve_ID = :ai,status = :st where gate_pass_id = :gp_id");
			 }else{
				 query = session.createQuery("update GatePassBean set status = :st, security_in_time =:date,approve_ID = :ai,status = :st where gate_pass_id = :gp_id");
			 }
			 query.setString("st", status);
			 query.setString("date", date);
			 query.setString("st", "Out");
			 query.setInteger("ai",e_id);
			 query.setInteger("gp_id",gate_pass_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		return true;
	}
	
	public boolean COADDWITHOD(double CO, int employee_master_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			 System.out.println("Emp Is :"+ employee_master_id);
			 String ColumnName1 = "CO";
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBalanceBean set "+ ColumnName1 +" = :CO where employee_master_id = :empid");
			 query.setDouble("CO",CO);
			 query.setInteger("empid", employee_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean intervieweeOutTimeUpdate(int interviewee_id, String out_time)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 IntervieweeBean intervieweeBean = new IntervieweeBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update IntervieweeBean set interviewee_out_time = :iot where interviewee_id = :id");
			 query.setString("iot" ,out_time);
			 query.setInteger("id",interviewee_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
			 tx.commit();
			
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean updateIntervieweeInfo(IntervieweeBean intervieweeBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(intervieweeBean);
			 System.out.println("updated");
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
}
