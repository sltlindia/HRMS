package com.hrms.kaizen.dao;

import java.time.Year;
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
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.vehicletracking.bean.VehicleTrackingBean;

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
	
	
	public KaizenBean getDetailOfKaizenByProblemId(int problem_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		KaizenBean kaizenBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from KaizenBean where kaizenProblemIdentificationBean = '"+problem_id+"'");
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
	
	
	public List<KaizenAuthorityScoreBean> listOfAuthorityScoring(int year,int month) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<KaizenAuthorityScoreBean> listOfAuthorityScoring = new ArrayList<KaizenAuthorityScoreBean>();
		try {
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createQuery("from KaizenAuthorityScoreBean where year = '"+year+"' and month = '"+month+"' group by employee_master_id");
			
			listOfAuthorityScoring = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAuthorityScoring;
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
					listOfProblem = session.createQuery("FROM KaizenProblemIdentificationBean where employeeBean.departmentBean = '"+dept_id+"' order by kaizen_problem_identification_id DESC").list();
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
			
			
			
			public List<KaizenBillboardResultBean> listOfBillboardDepartment(int year,int month,int dept_id) {
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				List<KaizenBillboardResultBean> listOfBillBoard = new ArrayList<KaizenBillboardResultBean>();
				try {
					tx = session.getTransaction();
					tx.begin();
					
					Query query = session.createQuery("from KaizenBillboardResultBean where year = '"+year+"' and monthBean = '"+month+"' and kaizenManagerScoreBean.kaizenBean.employeeBean.departmentBean = '"+dept_id+"'");
					
					listOfBillBoard = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfBillBoard;
			}
			
			public List<KaizenAuthorityScoreBean> listOfAuthorityScoringByEmpId(int year,int month,int emp_id) {
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				List<KaizenAuthorityScoreBean> listOfAuthorityScoring = new ArrayList<KaizenAuthorityScoreBean>();
				try {
					tx = session.getTransaction();
					tx.begin();
					
					Query query = session.createQuery("from KaizenAuthorityScoreBean where year = '"+year+"' and month = '"+month+"' and employee_master_id = '"+emp_id+"'");
					
					listOfAuthorityScoring = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfAuthorityScoring;
			}
			
			
			public List<KaizenBean> getListOfKaizenByStatusApproved(int year,int year1) {
				List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenBean where status = 'approved' and (((MONTH(date) between 4 and 12) and YEAR(date) = '"+year+"') or ((MONTH(date) between 1 and 3) and YEAR(date) = '"+year1+"'))";
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
			
			public List<KaizenBean> getListOfKaizenByStatusPending(int year,int year1) {
				List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenBean where status = 'pending' and (((MONTH(date) between 4 and 12) and YEAR(date) = '"+year+"') or ((MONTH(date) between 1 and 3) and YEAR(date) = '"+year1+"'))";
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
			
			
			public List<KaizenProblemIdentificationBean> getListOfProlemIdentificationCategory(String ptype,int year,int year1) {
				List<KaizenProblemIdentificationBean> listOfKaizenByEmployeeId = new ArrayList<KaizenProblemIdentificationBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenProblemIdentificationBean where category = '"+ptype+"' and (((MONTH(date) between 4 and 12) and YEAR(date) = '"+year+"') or ((MONTH(date) between 1 and 3) and YEAR(date) = '"+year1+"'))";
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

			public List<KaizenBean> getListOfProlemIdentificationCategoryInKaizen(String ptype,int year,int year1) {
				List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenBean where category_id = '"+ptype+"' and (((MONTH(date) between 4 and 12) and YEAR(date) = '"+year+"') or ((MONTH(date) between 1 and 3) and YEAR(date) = '"+year1+"')) and status = 'approved'";
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

			
			public List<KaizenBean> getListOfImplementedCIByMonth(int month_id,int year) {
				List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenBean where status = 'approved' and MONTH(date)='"+month_id+"' and YEAR(date) = '"+year+"'";
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
			

			public List<KaizenBean> getListOfFactors(String ptype,int year,int year1) {
				List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenBean where "+ptype+" != ' ' and status = 'approved' and (((MONTH(date) between 4 and 12) and YEAR(date) = '"+year+"') or ((MONTH(date) between 1 and 3) and YEAR(date) = '"+year1+"'))";
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
			
			public String getListOfCostByMonth(int month_id,int year) {
				String sum = null;
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					Query query = session.createQuery("select sum(cost) from KaizenBean where cost != '' and  status = 'approved' and MONTH(date)='"+month_id+"' and YEAR(date) = '"+year+"'");
					sum = (String)query.uniqueResult();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return sum;

			}
			
			public String getListOfImplemetationCostByMonth(int month_id,int year) {
				String sum = null;
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					Query query = session.createQuery("select sum(implementation_cost) from KaizenBean where status = 'approved' and MONTH(date)='"+month_id+"' and YEAR(date) = '"+year+"'");
					sum = (String)query.uniqueResult();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return sum;

			}

			
			public List<KaizenBean> getListCountByDeptId(int monthId,int year) {
				List<KaizenBean> listOfKaizenByEmployeeId = new ArrayList<KaizenBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					String hql = "from KaizenBean where status = 'approved' and MONTH(date) ='"+monthId+"' and YEAR(date) = '"+year+"' group by employeeBean.departmentBean";
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
			
			
			//List Method for getting count of month filled from probation_assessment_direct_tbl by employee_master_id	
			public long getCountOfKaizenByDeptId(int monthId,int year,int dept_id) {
		        Session session = HibernateUtil.openSession();
		        Transaction tx = null;
		        long maxvalue = 0;
		        
		        try {
		            tx = session.getTransaction();
		            tx.begin();
		            
		            Query query = session.createQuery("select count(kaizen_id) from KaizenBean where status = 'approved' and MONTH(date) ='"+monthId+"' and YEAR(date) = '"+year+"' and employeeBean.departmentBean = '"+dept_id+"'");
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
	
			public List<KaizenBean> getListOfReportKaizen(String year_id,String month_id,String dept_id,int count) {
				String v1 = null;
				String v2 = null;
				String v3 = null;

				String c1 = null;
				String c2 = null;
				String c3 = null;

				if (!year_id.equalsIgnoreCase("0")) {
					if (c1 == null) {
						c1 = "YEAR(date)";
						AllListDAO allListDAO = new AllListDAO();
						YearBean yearBean1 = allListDAO.getInfoByIdYear(Integer.parseInt(year_id));
						v1 = yearBean1.getYear();
					}
				}

				if (!month_id.equalsIgnoreCase("0")) {
					if (c1 == null) {
						c1 = "MONTH(date)";
						v1 = month_id;
					} else if (c2 == null) {
						c2 = "MONTH(date)";
						v2 = month_id;
					} 
				}
				
				if (!dept_id.equalsIgnoreCase("0")) {
					if (c1 == null) {
						c1 = "employeeBean.departmentBean";
						v1 = dept_id;
					} else if (c2 == null) {
						c2 = "employeeBean.departmentBean";
						v2 = dept_id;
					} else if (c3 == null) {
						c3 = "employeeBean.departmentBean";
						v3 = dept_id;
					} 
				}


				List<KaizenBean> listOfKaizen = new ArrayList<KaizenBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();


						if (count == 1) {
							listOfKaizen = session
									.createQuery("FROM KaizenBean where status = 'approved' and "+c1+" = '"+v1+"' ")
									.list();
						} else if (count == 2) {
							listOfKaizen = session.createQuery("FROM KaizenBean where status = 'approved' and "+c1+" = '"+v1+"' and "+c2+" = '"+v2+"'").list();
						} else if (count == 3) {
							listOfKaizen = session.createQuery("FROM KaizenBean where status = 'approved' and " + c1 + " = '" + v1 + "' and "
									+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' ").list();
						} 

					System.out.println(listOfKaizen.size());
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfKaizen;

			}
			
}
