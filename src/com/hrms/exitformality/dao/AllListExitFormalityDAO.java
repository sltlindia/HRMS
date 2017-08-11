package com.hrms.exitformality.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.exitformality.bean.DetailsOfHandOverFormBean;
import com.hrms.exitformality.bean.DetailsOfMaterialBean;
import com.hrms.exitformality.bean.DetailsOfPendingMattersBean;
import com.hrms.exitformality.bean.DetailsOfResponsibilitiesBean;
import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.bean.ExitInterviewFormAttributeBean;
import com.hrms.exitformality.bean.ExitInterviewManagerCommentsBean;
import com.hrms.exitformality.bean.ExitInterviewScoreBean;
import com.hrms.exitformality.bean.HandOverApprovalBean;
import com.hrms.exitformality.util.HibernateUtil;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.bean.SpecificCriteriaBean;


public class AllListExitFormalityDAO {
 
	public List<ExitInterviewFormAttributeBean> getListOfAttribute()
	{
	List<ExitInterviewFormAttributeBean> listOfAttribute = new ArrayList<ExitInterviewFormAttributeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfAttribute = session.createQuery("FROM ExitInterviewFormAttributeBean").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfAttribute;

	}
	
	public List<ExitInterviewEmployeeBean> getListOfFinalReview()
	{
	List<ExitInterviewEmployeeBean> listOfFinalReview = new ArrayList<ExitInterviewEmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfFinalReview = session.createQuery("FROM ExitInterviewEmployeeBean").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfFinalReview;

	}
	
	
	public List<ExitInterviewEmployeeBean> getListOfExitInterviewEmployees(int employee_master_id)
	{
	List<ExitInterviewEmployeeBean> listOfExitInterviewEmployees = new ArrayList<ExitInterviewEmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfExitInterviewEmployees = session.createQuery("FROM ExitInterviewEmployeeBean e where not exists ( FROM ExitInterviewManagerCommentsBean e1 where e.exit_interview_employee_id = e1.exitInterviewEmployeeBean and e1.employeeBean='"+employee_master_id+"') ").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitInterviewEmployees;

	}
	
	public List<ExitInterviewEmployeeBean> getListOfExitInterviewEmployeesByManager(int employee_master_id, int manager_id)
	{
	List<ExitInterviewEmployeeBean> listOfExitInterviewEmployees = new ArrayList<ExitInterviewEmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfExitInterviewEmployees = session.createQuery("FROM ExitInterviewEmployeeBean e where not exists ( FROM ExitInterviewManagerCommentsBean e1 where e.exit_interview_employee_id = e1.exitInterviewEmployeeBean and e1.employeeBean='"+employee_master_id+"') and e.employeeBean.under_manager_id = '"+manager_id+"'").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitInterviewEmployees;

	}
	
	
	public List<ExitInterviewEmployeeBean> getListOfExitInterviewEmployeesReviewed(int employee_master_id)
	{
	List<ExitInterviewEmployeeBean> listOfExitInterviewEmployeesReviewed = new ArrayList<ExitInterviewEmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfExitInterviewEmployeesReviewed = session.createQuery("FROM ExitInterviewEmployeeBean e where exists ( FROM ExitInterviewManagerCommentsBean e1 where e.exit_interview_employee_id = e1.exitInterviewEmployeeBean and e1.employeeBean='"+employee_master_id+"') ").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitInterviewEmployeesReviewed;

	}
	
	
	public List<ExitInterviewEmployeeBean> getListOfExitInterviewEmployeesReviewedByManager(int employee_master_id, int manager_id)
	{
	List<ExitInterviewEmployeeBean> listOfExitInterviewEmployeesReviewed = new ArrayList<ExitInterviewEmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfExitInterviewEmployeesReviewed = session.createQuery("FROM ExitInterviewEmployeeBean e where exists ( FROM ExitInterviewManagerCommentsBean e1 where e.exit_interview_employee_id = e1.exitInterviewEmployeeBean and e1.employeeBean='"+employee_master_id+"') and e.employeeBean.under_manager_id = '"+manager_id+"'").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitInterviewEmployeesReviewed;

	}
	
	
	public List<ExitInterviewScoreBean> getListOfAttributeScore(int exit_interview_id)
	{
	List<ExitInterviewScoreBean> listOfAttributeScore = new ArrayList<ExitInterviewScoreBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfAttributeScore = session.createQuery("FROM ExitInterviewScoreBean where exitInterviewEmployeeBean = '"+exit_interview_id+"'").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfAttributeScore;

	}
	
	
	public List<ExitInterviewEmployeeBean> getListOfExitEmployee(int exit_interview_id)
	{
	List<ExitInterviewEmployeeBean> listOfExitEmployee = new ArrayList<ExitInterviewEmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    listOfExitEmployee = session.createQuery("FROM ExitInterviewEmployeeBean where exit_interview_employee_id = '"+exit_interview_id+"'").list();                        
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitEmployee;

	}
	
	
	public List<ExitInterviewManagerCommentsBean> getListOfExitEmployeeFinalReview(int exit_interview_id)
	{
	List<ExitInterviewManagerCommentsBean> listOfExitEmployeeFinalReview = new ArrayList<ExitInterviewManagerCommentsBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM ExitInterviewManagerCommentsBean where exitInterviewEmployeeBean = '"+exit_interview_id+"'");                        
	    listOfExitEmployeeFinalReview = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitEmployeeFinalReview;

	}
	
	
	
	public ExitInterviewManagerCommentsBean getManagerCommentById(int employee_master_id, int exit_interview_employee_id) {
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    ExitInterviewManagerCommentsBean exitInterviewManagerCommentsBean = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from ExitInterviewManagerCommentsBean where employeeBean="+employee_master_id+" and exitInterviewEmployeeBean='"+exit_interview_employee_id+"'");
	        exitInterviewManagerCommentsBean = (ExitInterviewManagerCommentsBean)query.uniqueResult();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return exitInterviewManagerCommentsBean;
	}
	
	
	public List<EmployeeBean> getListOfAllEmployee()
	{
	List<EmployeeBean> listOfAllEmployee = new ArrayList<EmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM EmployeeBean");                        
	    listOfAllEmployee = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfAllEmployee;

	}
	
	
	public List<DepartmentBean> getListOfAllDepartment()
	{
	List<DepartmentBean> listOfAllDepartment = new ArrayList<DepartmentBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DepartmentBean");                        
	    listOfAllDepartment = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfAllDepartment;

	}
	
	
	
	public List<RoleBean> getListOfAllRoles()
	{
	List<RoleBean> listOfAllRole = new ArrayList<RoleBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM RoleBean");                        
	    listOfAllRole = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfAllRole;

	}
	
	
	public DetailsOfHandOverFormBean getDetailOfHandOverById(int hand_over_detail_id) {
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    DetailsOfHandOverFormBean detailsOfHandOverFormBean = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from DetailsOfHandOverFormBean where details_of_hand_over_form_id = '"+hand_over_detail_id+"'");
	        detailsOfHandOverFormBean = (DetailsOfHandOverFormBean)query.uniqueResult();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return detailsOfHandOverFormBean;
	}
	
	
	
	public List<DetailsOfHandOverFormBean> getListOfExitFormalityFormByHandOverId(int hand_over_id)
	{
	List<DetailsOfHandOverFormBean> listOfExitFormalityFormByHandOverId = new ArrayList<DetailsOfHandOverFormBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DetailsOfHandOverFormBean d where EXISTS(From HandOverApprovalBean h WHERE d.details_of_hand_over_form_id =  h.detailsOfHandOverFormBean  and d.hand_over_to_name = h.employeeBean and h.status = 'Pending') and  hand_over_to_name = '"+hand_over_id+"'");                        
	    listOfExitFormalityFormByHandOverId = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitFormalityFormByHandOverId;

	}
	
	
	public List<DetailsOfHandOverFormBean> getListOfExitFormalityFormByHandOverIdForView(int hand_over_id)
	{
	List<DetailsOfHandOverFormBean> listOfExitFormalityFormByHandOverIdForView = new ArrayList<DetailsOfHandOverFormBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DetailsOfHandOverFormBean d where EXISTS(From HandOverApprovalBean h WHERE d.details_of_hand_over_form_id =  h.detailsOfHandOverFormBean  and d.hand_over_to_name = h.employeeBean and h.status = 'Approved') and  hand_over_to_name = '"+hand_over_id+"'");                        
	    listOfExitFormalityFormByHandOverIdForView = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitFormalityFormByHandOverIdForView;

	}
	
	
	public List<DetailsOfHandOverFormBean> getListOfExitFormalityFormByHandOverIdAfterSecondApproval(int manager_id)
	{
	List<DetailsOfHandOverFormBean> listOfExitFormalityFormByHandOverId = new ArrayList<DetailsOfHandOverFormBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DetailsOfHandOverFormBean d where EXISTS(From HandOverApprovalBean h WHERE d.details_of_hand_over_form_id =  h.detailsOfHandOverFormBean and (d.hand_over_to_name = h.employeeBean and h.status = 'Approved')) and  d.employeeBean.under_manager_id = '"+manager_id+"'");                        
	    listOfExitFormalityFormByHandOverId = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitFormalityFormByHandOverId;

	}
	
	
	
	
	public List<HandOverApprovalBean> getListOfHandOverApprovalName(int details_of_hand_over_form_id)
	{
	List<HandOverApprovalBean> listOfHandOverApprovalName = new ArrayList<HandOverApprovalBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM HandOverApprovalBean where detailsOfHandOverFormBean = '"+details_of_hand_over_form_id+"' and status='Approved'");                        
	    listOfHandOverApprovalName = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfHandOverApprovalName;

	}

	
	
	public HandOverApprovalBean getHandOverDetailIdByEmpId(int emp_id,int details_of_hand_over_form_id) {
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    HandOverApprovalBean handOverApprovalBean = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from HandOverApprovalBean where detailsOfHandOverFormBean = '"+details_of_hand_over_form_id+"' and employeeBean = '"+emp_id+"' and status='Pending'");
	        handOverApprovalBean = (HandOverApprovalBean)query.uniqueResult();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return handOverApprovalBean;
	}
	
	
	public HandOverApprovalBean getHandOverDetailIdByEmpIdForView(int emp_id,int details_of_hand_over_form_id) {
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    HandOverApprovalBean handOverApprovalBean = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from HandOverApprovalBean where detailsOfHandOverFormBean = '"+details_of_hand_over_form_id+"' and employeeBean = '"+emp_id+"' and status='Approved'");
	        handOverApprovalBean = (HandOverApprovalBean)query.uniqueResult();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return handOverApprovalBean;
	}
	
	public long getCountOfApprovalHandOver(int details_of_hand_over_form_id) {
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    Long maxvalue = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("select count(hand_over_approval_id) from HandOverApprovalBean where detailsOfHandOverFormBean = '"+details_of_hand_over_form_id+"' and  status='Approved'");
	        maxvalue = (long) query.uniqueResult();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return maxvalue;
	}
	
	
	
	
	public List<DetailsOfHandOverFormBean> getListOfExitFormalityFormForHRApproval()
	{
	List<DetailsOfHandOverFormBean> listOfExitFormalityFormByHandOverId = new ArrayList<DetailsOfHandOverFormBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DetailsOfHandOverFormBean");                        
	    listOfExitFormalityFormByHandOverId = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfExitFormalityFormByHandOverId;

	}
	
	
	public List<DetailsOfResponsibilitiesBean> getListOfResponsibilitiesById(int hand_over_form_detail_id)
	{
	List<DetailsOfResponsibilitiesBean> listOfResponsibilitiesById = new ArrayList<DetailsOfResponsibilitiesBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DetailsOfResponsibilitiesBean where detailsOfHandOverFormBean = '"+hand_over_form_detail_id+"'");                        
	    listOfResponsibilitiesById = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfResponsibilitiesById;

	}
	
	
	public List<DetailsOfPendingMattersBean> getListOfPendingMattersById(int hand_over_form_detail_id)
	{
	List<DetailsOfPendingMattersBean> listOfPendingMattersById = new ArrayList<DetailsOfPendingMattersBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DetailsOfPendingMattersBean where detailsOfHandOverFormBean = '"+hand_over_form_detail_id+"'");                        
	    listOfPendingMattersById = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfPendingMattersById;

	}
	
	
	
	public List<DetailsOfMaterialBean> getListOfMaterialById(int hand_over_form_detail_id)
	{
	List<DetailsOfMaterialBean> listOfMaterialById = new ArrayList<DetailsOfMaterialBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("FROM DetailsOfMaterialBean where detailsOfHandOverFormBean = '"+hand_over_form_detail_id+"'");                        
	    listOfMaterialById = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfMaterialById;

	}
	
}
