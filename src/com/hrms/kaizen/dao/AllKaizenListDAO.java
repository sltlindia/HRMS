package com.hrms.kaizen.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.BrahmastraRepeatBean;
import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean;
import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean;
import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.bean.KaizenMemberBean;
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
			String hql = "from KaizenManagerBean where employeeBean = '"+employee_id+"' and status='pending' and kaizenBean.completion_status ='submitted'";
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
	
	
	public List<KaizenManagerBean> getListOfManagerAllKaizen(int employee_id) {
		List<KaizenManagerBean> listOfAllManager = new ArrayList<KaizenManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenManagerBean where employeeBean = '"+employee_id+"' ";
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
	public List<KaizenBean> getListOfAllKaizenBymanagerId(int manager_id) {
		List<KaizenBean> listOfAllManager = new ArrayList<KaizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from KaizenBean where manager_id = '"+manager_id+"'";
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
			String hql = "from KaizenManagementApprovalBean where employeeBean = '"+employee_master_id+"' and management_approval_status='pending' and kaizenBean.completion_status = 'submitted'";
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
	
}
