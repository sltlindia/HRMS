package com.hrms.kaizen.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.BrahmastraRepeatBean;
import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean;
import com.hrms.kaizen.bean.KaizenAuthorityScoreBean;
import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean;
import com.hrms.kaizen.bean.KaizenBillboardResultBean;
import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.bean.KaizenManagerScoreBean;
import com.hrms.kaizen.bean.KaizenMemberBean;
import com.hrms.kaizen.bean.KaizenProblemIdentificationBean;
import com.hrms.kaizen.bean.kaizenRCABean;
import com.hrms.lms.util.HibernateUtil;
import com.hrms.pms.bean.EmployeeBean;

public class AllKaizenListDAO {

	public KaizenBean getDetailOfKaizenById(int kaizen_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenBean kaizenBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from KaizenBean where kaizen_id = '"+kaizen_id+"'");
			kaizenBean = (KaizenBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kaizenBean;
	}
	
	
	public List<KaizenManagerBean> getListOfManagerByKaizenId(int kaizenId) {
		List<KaizenManagerBean> listOfAllManager = new ArrayList<KaizenManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenManagerBean where kaizenBean = '"+kaizenId+"'";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	public List<KaizenManagerBean> getListOfManagerByKaizenIdSubmitted(int kaizenId) {
		List<KaizenManagerBean> listOfAllManager = new ArrayList<KaizenManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenManagerBean where kaizenBean = '"+kaizenId+"' and completion_status ='submitted'";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	public List<KaizenMemberBean> getListOfMemberByKaizenId(int kaizenId) {
		List<KaizenMemberBean> listOfAllMember = new ArrayList<KaizenMemberBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenMemberBean where kaizenBean = '"+kaizenId+"'";
			Query query = session.createQuery(hql);
			listOfAllMember = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllMember;

	}
	
	
	public List<KaizenManagerBean> getListOfManagerBymanagerId(int employee_id) {
		List<KaizenManagerBean> listOfAllManager = new ArrayList<KaizenManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenManagerBean where employeeBean = '"+employee_id+"' and status='pending'";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	public List<KaizenManagerBean> getListOfManagerBymanagerIdSubmitted(int employee_id) {
		List<KaizenManagerBean> listOfAllManager = new ArrayList<KaizenManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenManagerBean where employeeBean = '"+employee_id+"' and status='pending' and kaizenBean.completion_status ='submitted' and kaizenBean.status = 'genuine'";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	public List<KaizenManagerBean> getListOfManagerAllKaizen(int employee_id,int year,int month) {
		List<KaizenManagerBean> listOfAllManager = new ArrayList<KaizenManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			if(month<=9) {
				 hql = "from KaizenManagerBean where employeeBean = '"+employee_id+"' and kaizenBean.date like '"+year+"%' and kaizenBean.date like '%-0"+month+"-%'";
			}else {
				 hql = "from KaizenManagerBean where employeeBean = '"+employee_id+"' and kaizenBean.date like '"+year+"%' and kaizenBean.date like '%-"+month+"-%'";
			}
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	
	
	public List<KaizenBean> getListOfKaizenBymanagerId(int manager_id) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenBean where manager_id = '"+manager_id+"' and status='pending'";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	public List<KaizenBean> getListOfKaizenBymanagerIdSubmitted(int manager_id) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenBean where manager_id = '"+manager_id+"' and status='pending' and completion_status = 'submitted'";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;
	}	
	
	
	public List<KaizenBean> getListOfAllKaizenBymanagerId(int manager_id,int year,int month) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			if(month<=9) {
				 hql = "from KaizenBean where manager_id = '"+manager_id+"' and date like '"+year+"%' and date like '%-0"+month+"-%' and status != 'rejected'";
			}else {
				 hql = "from KaizenBean where manager_id = '"+manager_id+"' and date like '"+year+"%' and date like '%-"+month+"-%' and status != 'rejected'";
			}
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	public List<KaizenBean> getListOfKaizenBymanagerIdAndStatus(int manager_id,int year,int month,String status,String cStatus) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			hql = "from KaizenBean where manager_id = '"+manager_id+"' and YEAR(date)='"+year+"' AND MONTH(date)='"+month+"' and status = '"+status+"' and completion_status = '"+cStatus+"'";
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	public List<KaizenBean> getListOfAllCompletedKaizenBymanagerId(int manager_id,int year,int month) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
				 hql = "from KaizenBean where manager_id = '"+manager_id+"' and YEAR(completion_date)='"+year+"' AND MONTH(completion_date)='"+month+"' and status != 'rejected'";
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	public List<KaizenBean> getListOfAllKaizenBymanagerIdWithRejected(int manager_id,int year,int month) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			if(month<=9) {
				 hql = "from KaizenBean where manager_id = '"+manager_id+"' and date like '"+year+"%' and date like '%-0"+month+"-%' and status = 'rejected'";
			}else {
				 hql = "from KaizenBean where manager_id = '"+manager_id+"' and date like '"+year+"%' and date like '%-"+month+"-%' and status = 'rejected'";
			}
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	
	public List<KaizenBean> getListOfAllKaizenByEmpId(int emp_id,int year,int month) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			hql = "from KaizenBean where employeeBean = '"+emp_id+"' and YEAR(date)='"+year+"' AND MONTH(date)='"+month+"'";
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	
	public List<KaizenBean> getListOfAllKaizenByEmpIdWithStatus(int emp_id,int year,int month,String status,String cStatus) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			hql = "from KaizenBean where employeeBean = '"+emp_id+"' and YEAR(date)='"+year+"' AND MONTH(date)='"+month+"' and status = '"+status+"' and completion_status = '"+cStatus+"'";
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	public List<KaizenBean> getListOfAllKaizenByEmpIdOfCurrentMonth(int emp_id) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			hql = "from KaizenBean where employeeBean = '"+emp_id+"' and YEAR(date)= YEAR(NOW()) AND MONTH(date)=MONTH(NOW())";
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	public List<KaizenBean> getListOfAllKaizenByDepartment(int dept_id,int year,int month) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			if(month<=9) {
				 hql = "from KaizenBean where employeeBean.departmentBean = '"+dept_id+"' and date like '"+year+"%' and date like '%-0"+month+"-%'";
			}else {
				 hql = "from KaizenBean where employeeBean.departmentBean = '"+dept_id+"' and date like '"+year+"%' and date like '%-"+month+"-%'";
			}
			
			
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	
	public List<KaizenBean> getListOfKaizenByEmployeerId(int emp_id) {
		List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenBean where employeeBean = '"+emp_id+"'";
			Query query = session.createQuery(hql);
			listOfKaizenByEmployeeId = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfKaizenByEmployeeId;

	}
	
	public List<KaizenBean> getListOfKaizenByEmployeerIdByStatus(int emp_id) {
		List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenBean where employeeBean = '"+emp_id+"' and completion_status != 'completed'";
			Query query = session.createQuery(hql);
			listOfKaizenByEmployeeId = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfKaizenByEmployeeId;

	}

	public List<KaizenBean> getListOfKaizenByEmployeerIdSumitted(int emp_id) {
		List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenBean where employeeBean = '"+emp_id+"' and completion_status = 'submitted'";
			Query query = session.createQuery(hql);
			listOfKaizenByEmployeeId = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfKaizenByEmployeeId;

	}
	
	
	public List<KaizenBeforeUploadAttachmentBean> getListOfBeforeUploadAttachment(int kaizen_id){
		List<KaizenBeforeUploadAttachmentBean> listOfAttribute = new ArrayList<KaizenBeforeUploadAttachmentBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAttribute = session
					.createQuery("FROM KaizenBeforeUploadAttachmentBean where kaizen_id = '"+kaizen_id+"'")
					.list();
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
	
	
	public List<KaizenAfterUploadAttachmentBean> getListOfAfterUploadAttachment(int kaizen_id){
	List<KaizenAfterUploadAttachmentBean> listOfAttribute = new ArrayList<KaizenAfterUploadAttachmentBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;
	try {
		tx = session.getTransaction();
		tx.begin();
		listOfAttribute = session
				.createQuery("FROM KaizenAfterUploadAttachmentBean where kaizen_id='"+kaizen_id+"'")
				.list();
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
	
	
	public List<EmployeeBean> getlistOfTopManagement() {
		List<EmployeeBean> listOfscore = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM EmployeeBean where roleBean.role_authority in ('D1','D2','D3','D4') and employeeStatusBean = 1")
					.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfscore;

	}	
	
	
	
	public List<KaizenManagementApprovalBean> getListOfManagemnet(int kaizen_id){
		List<KaizenManagementApprovalBean> listOfManagement = new ArrayList<KaizenManagementApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManagement = session
					.createQuery("FROM KaizenManagementApprovalBean where kaizen_id='"+kaizen_id+"'")
					.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfManagement;

	}
	

	
	public List<KaizenManagementApprovalBean> getListOfKaizenByTopManagementId(int employee_master_id) {
		List<KaizenManagementApprovalBean> listOfAllManager = new ArrayList<KaizenManagementApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenManagementApprovalBean where employeeBean = '"+employee_master_id+"' and management_approval_status='pending' ";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}

	public List<KaizenManagementApprovalBean> getListOfKaizenByTopManagementIdSubmitted(int employee_master_id) {
		List<KaizenManagementApprovalBean> listOfAllManager = new ArrayList<KaizenManagementApprovalBean>();
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenManagementApprovalBean kma where employeeBean = '"+employee_master_id+"' and management_approval_status='pending' and kaizenBean.completion_status = 'submitted'";
			Query query = session.createQuery(hql);
			listOfAllManager = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllManager;

	}
	
	
	public KaizenManagerScoreBean getDetailOfKaizenScoreByempId(int kaizen_id,int emplopyee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenManagerScoreBean kaizenManagerScoreBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from KaizenManagerScoreBean where kaizenBean = '"+kaizen_id+"' and employee_master_id = '"+emplopyee_id+"'");
			kaizenManagerScoreBean = (KaizenManagerScoreBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kaizenManagerScoreBean;
	}
	
	
	
	public KaizenAuthorityScoreBean getDetailOfKaizenAuthorityScoreByempId(int kaizen_id,int emplopyee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenAuthorityScoreBean kaizenAuthorityScoreBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from KaizenAuthorityScoreBean where kaizenBean = '"+kaizen_id+"' and employee_master_id = '"+emplopyee_id+"'");
			kaizenAuthorityScoreBean = (KaizenAuthorityScoreBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kaizenAuthorityScoreBean;
	}
	
	
	public KaizenManagerScoreBean getresultOfBillBordByMonthAndYear(int emp_id,int month, int year) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenManagerScoreBean kaizenManagerScoreBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL kaizenManagerResult(:empId,:month,:year)")
                    .addEntity(KaizenManagerScoreBean.class)
                    .setParameter("empId",emp_id)
                    .setParameter("month",month)
                    .setParameter("year",year);
			kaizenManagerScoreBean = (KaizenManagerScoreBean) query.uniqueResult();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kaizenManagerScoreBean;
	}
	
	
	
	public KaizenBillboardResultBean getFinalresultOfBillBordByMonthAndYear(int dept_id,int month, int year) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenBillboardResultBean kaizenBillboardResultBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL kaizenManagerFinalResult(:deptId,:month,:year)")
                    .addEntity(KaizenBillboardResultBean.class)
                    .setParameter("deptId",dept_id)
                    .setParameter("month",month)
                    .setParameter("year",year);
			kaizenBillboardResultBean = (KaizenBillboardResultBean) query.uniqueResult();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kaizenBillboardResultBean;
	}
	
	
	public KaizenAuthorityScoreBean getFinalresultOfLeaderBoardByMonthAndYear(int month, int year) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenAuthorityScoreBean kaizenAuthorityScoreBean = null;
		System.out.println(month);
		System.out.println(year);
		try {
			tx = session.getTransaction();
			tx.begin();
			
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL kaizenLeaderBoardResult(:year,:month)")
                    .addEntity(KaizenAuthorityScoreBean.class)
                    .setParameter("month",month)
                    .setParameter("year",year);
			kaizenAuthorityScoreBean = (KaizenAuthorityScoreBean) query.uniqueResult();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kaizenAuthorityScoreBean;
	}
	
	
	public KaizenBillboardResultBean getDetailOfKaizenBillBoard(int emp_id,int year,int month) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenBillboardResultBean kaizenBillboardResultBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from KaizenBillboardResultBean where year = '"+year+"' and kaizenManagerScoreBean.employee_master_id = '"+emp_id+"' and monthBean = '"+month+"'");
			kaizenBillboardResultBean = (KaizenBillboardResultBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kaizenBillboardResultBean;
	}
	
	
	public List<KaizenBillboardResultBean> getListForLeaderBoard(int month, int year) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<KaizenBillboardResultBean> listOfLeaderBoard = new ArrayList<KaizenBillboardResultBean>();
		try {
			tx = session.getTransaction();
			tx.begin();
			
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL kaizenListForLeaderBoard(:month,:year)")
                    .addEntity(KaizenBillboardResultBean.class)
                    .setParameter("month",month)
                    .setParameter("year",year);
			listOfLeaderBoard = query.list();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeaderBoard;
	}
	
	
	

			public List<KaizenProblemIdentificationBean> getListOfProblem() {
				List<KaizenProblemIdentificationBean> listOfProblem = new ArrayList<KaizenProblemIdentificationBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					listOfProblem = session.createQuery("FROM KaizenProblemIdentificationBean where (YEAR(date)=YEAR(NOW()) AND MONTH(date)=MONTH(NOW()))").list();
					System.out.println(listOfProblem.size());
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfProblem;
			}
			
			
			public List<KaizenProblemIdentificationBean> getListOfProblemByDeptId(int dept_id) {
				List<KaizenProblemIdentificationBean> listOfProblem = new ArrayList<KaizenProblemIdentificationBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					listOfProblem = session.createQuery("FROM KaizenProblemIdentificationBean where (YEAR(date)=YEAR(NOW()) AND MONTH(date)=MONTH(NOW())) and employeeBean.departmentBean = '"+dept_id+"'").list();
					System.out.println(listOfProblem.size());
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfProblem;
			}
			
			
			public List<KaizenProblemIdentificationBean> getListOfProblemByDeptIdWithMonthYear(int dept_id,int month,int year) {
				List<KaizenProblemIdentificationBean> listOfProblem = new ArrayList<KaizenProblemIdentificationBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					listOfProblem = session.createQuery("FROM KaizenProblemIdentificationBean where YEAR(date)='"+year+"' AND MONTH(date)='"+month+"' and employeeBean.departmentBean = '"+dept_id+"'").list();
					System.out.println(listOfProblem.size());
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfProblem;
			}
			
			
			public List<KaizenProblemIdentificationBean> getListOfProblemWithMonthYear(int month,int year) {
				List<KaizenProblemIdentificationBean> listOfProblem = new ArrayList<KaizenProblemIdentificationBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					listOfProblem = session.createQuery("FROM KaizenProblemIdentificationBean where YEAR(date)='"+year+"' AND MONTH(date)='"+month+"'").list();
					System.out.println(listOfProblem.size());
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfProblem;
			}
	
			
			public KaizenProblemIdentificationBean getDetailOfProblem(int id) {
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				KaizenProblemIdentificationBean kaizenProblemIdentificationBean = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					Query query = session.createQuery("from KaizenProblemIdentificationBean where kaizen_problem_identification_id = '"+id+"'");
					kaizenProblemIdentificationBean = (KaizenProblemIdentificationBean) query.uniqueResult();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return kaizenProblemIdentificationBean;
			}
			
			public List<kaizenRCABean> getListOfRCAByKaizednId(int kizenId) {
				List<kaizenRCABean> listOfRCA = new ArrayList<kaizenRCABean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					listOfRCA = session.createQuery("FROM kaizenRCABean where kaizenBean = '"+kizenId+"'").list();
					System.out.println(listOfRCA.size());
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfRCA;
			}
			
			
			public List<KaizenAuthorityScoreBean> getListOfAuthorityScoreBykaizenId(int kaizen_id) {
				List<KaizenAuthorityScoreBean> listOfScore = new ArrayList<KaizenAuthorityScoreBean>();
				Session session = HibernateUtil.openSession();
				
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenAuthorityScoreBean where kaizenBean = '"+kaizen_id+"'";
					Query query = session.createQuery(hql);
					listOfScore = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfScore;

			}
	
			
}
