package com.hrms.tds.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.tds.bean.TDSBean;
import com.hrms.tds.bean.TDSDocumentUploadBean;
import com.hrms.tds.bean.TDSHistoryBean;
import com.hrms.tds.bean.TDSHrBean;
import com.hrms.tds.bean.TDSHrHistoryBean;
import com.hrms.tds.bean.TDSHrTotalABean;
import com.hrms.tds.bean.TDSHrTotalBBean;
import com.hrms.tds.bean.TDSHrTotalCBean;
import com.hrms.tds.bean.TDSHrTotalDBean;
import com.hrms.tds.bean.TDSHrTotalEBean;
import com.hrms.tds.bean.TDSHrTotalFBean;
import com.hrms.tds.bean.TDSPayrollBean;
import com.hrms.tds.bean.TDSPayrollSalaryDataBean;
import com.hrms.tds.bean.TDSTaxBean;
import com.hrms.tds.bean.TDSTotalABean;
import com.hrms.tds.bean.TDSTotalBBean;
import com.hrms.tds.bean.TDSTotalCBean;
import com.hrms.tds.bean.TDSTotalDBean;
import com.hrms.tds.bean.TDSTotalEBean;
import com.hrms.tds.bean.TDSTotalFBean;

public class TDSListDAO {
	public List<TDSBean> getAllTdsList()
	{
	    List<TDSBean> listOfAllTds = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSBean where status ='pending'";
			 Query query = session.createQuery(hql);
			 listOfAllTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTds;
	}
	
	public List<TDSBean> getTdsList()
	{
	    List<TDSBean> listOfTds = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSBean where status ='submit'";
			 Query query = session.createQuery(hql);
			 listOfTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTds;
	}
	
	public List<TDSBean> getAllTdsListByID(int id)
	{
	    List<TDSBean> listOfTds = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSBean where tds_id="+id+"";
			 Query query = session.createQuery(hql);
			 listOfTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTds;
	}
	
	public List<TDSHistoryBean> getAllTdsHistoryListByischecked()
	{
	    List<TDSHistoryBean> listOfTds = new ArrayList<TDSHistoryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSHistoryBean where ischecked = '0'";
			 Query query = session.createQuery(hql);
			 listOfTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTds;
	}
	
	public List<TDSBean> getAllApprovedTdsList()
	{
	    List<TDSBean> listOfTds = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSBean where status = 'submit'";
			 Query query = session.createQuery(hql);
			 listOfTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTds;
	}
	
	public List<TDSBean> getAllTDSListByUser()
	{
	    List<TDSBean> listOfTds = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSBean";
			 Query query = session.createQuery(hql);
			 listOfTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTds;
	}
	
	public 	TDSBean detailsOfTDSById(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSBean tdsBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSBean where tds_id="+tds_id+"");
		    tdsBean = (TDSBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsBean;
		}
	
	public 	TDSHrBean detailsOfTDSByHrId(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrBean tdsHrBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrBean where tds_hr_id="+tds_hr_id+"");
		    tdsHrBean = (TDSHrBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrBean;
		}
	
	public List<TDSHrBean> getAllTdsHrListById(int id)
	{
	    List<TDSHrBean> listOfAllTds = new ArrayList<TDSHrBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSHrBean where tds_Hr_id ='"+ id +"' ";
			 Query query = session.createQuery(hql);
			 listOfAllTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTds;
	}
	
	public 	TDSBean detailsOfTDS(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSBean tdsBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSBean where tds_id="+tds_id+"");
		    tdsBean = (TDSBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsBean;
		}

	public 	TDSBean detailsOfTDSByEmpID(int employee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSBean tdsBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSBean where employee_master_id="+employee_id+"");
		    tdsBean = (TDSBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsBean;
		}
	
	
	public 	TDSHrBean detailsOfTDSHrByEmpID(int employee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrBean tdsHrBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrBean where employee_master_id="+employee_id+"");
		    tdsHrBean = (TDSHrBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrBean;
		}
	
	public 	TDSPayrollBean detailsOfTDSPayrollBean(int employee_code, String company_name) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSPayrollBean tdsPayroll = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSPayrollBean where employee_code="+employee_code+" AND company_name ='"+company_name+"'  order by tds_payroll_id DESC").setMaxResults(1);
		    
		    tdsPayroll = (TDSPayrollBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsPayroll;
	}
	
	public 	TDSTotalABean detailsOfTDSTotal_A(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSTotalABean tdTotalABean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSTotalABean where tdsBean="+tds_id+"");
		    tdTotalABean = (TDSTotalABean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdTotalABean;
		}
	
	public 	TDSTotalBBean detailsOfTDSTotal_B(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSTotalBBean tdTotalBBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSTotalBBean where tdsBean="+tds_id+"");
		    tdTotalBBean = (TDSTotalBBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdTotalBBean;
		}
	
	public 	TDSTotalCBean detailsOfTDSTotal_C(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSTotalCBean tdTotalCBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSTotalCBean where tdsBean="+tds_id+"");
		    tdTotalCBean = (TDSTotalCBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdTotalCBean;
		}
	
	public 	TDSTotalDBean detailsOfTDSTotal_D(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSTotalDBean tdTotalDBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSTotalDBean where tdsBean="+tds_id+"");
		    tdTotalDBean = (TDSTotalDBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdTotalDBean;
		}
	
	public 	TDSTotalEBean detailsOfTDSTotal_E(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSTotalEBean tdTotalEBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSTotalEBean where tdsBean="+tds_id+"");
		    tdTotalEBean = (TDSTotalEBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdTotalEBean;
		}
	
	public 	TDSTotalFBean detailsOfTDSTotal_F(int tds_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSTotalFBean tdTotalFBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSTotalFBean where tdsBean="+tds_id+"");
		    tdTotalFBean = (TDSTotalFBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdTotalFBean;
		}
	
	public 	TDSTaxBean detailsOfTDSTax(int tds_id, int current_month, int year) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSTaxBean tdsTaxBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSTaxBean where tdsBean='"+tds_id+"' AND monthBean = '"+ current_month +"' AND year = '"+ year+"'");
		    tdsTaxBean = (TDSTaxBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsTaxBean;
		}
	
	@SuppressWarnings("unchecked")
	public List<TDSBean> getTDSDupicate(String period , int emp_id ) 
	{
	
		List<TDSBean> listOfTDS = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
  
    try {
        tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("FROM TDSBean WHERE period = '" + period + "' AND employeeBean ='"+ emp_id +"'");
        listOfTDS = query.list();
        tx.commit();
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return listOfTDS;
}
	
	public List<TDSTaxBean> getTDSTaxList(int current_month, int year, int emp_id) 
	{
	
		List<TDSTaxBean> listOfTDS = new ArrayList<TDSTaxBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
  
    try {
        tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("FROM TDSTaxBean WHERE monthBean = '" + current_month + "' AND year = '"+year +"' AND employeeBean ='"+ emp_id +"'");
        listOfTDS = query.list();
        tx.commit();
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return listOfTDS;
    }
	public List<TDSHrBean> getTdsListById(int emp_id) {
		Session session = HibernateUtil.openSession();
		List<TDSHrBean> listOfTDS = new ArrayList<TDSHrBean>();
		Transaction tx = null;
		TDSHrBean tdsHrBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrBean where employeeBean = "+emp_id+" AND status in('view','LOCK')");
		    listOfTDS = query.list();
		    System.out.println("data get");
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return listOfTDS;
		}
	
	public List<TDSDocumentUploadBean> getTdsDocumentListById(int emp_id) {
		Session session = HibernateUtil.openSession();
		List<TDSDocumentUploadBean> listOfTDSDocument = new ArrayList<TDSDocumentUploadBean>();
		Transaction tx = null;
		TDSDocumentUploadBean tdsDocumentUploadBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSDocumentUploadBean where employeeBean = "+emp_id+" AND status = 'approved' AND ischeckeduserside = '0' GROUP BY attachment_name ");
		    listOfTDSDocument = query.list();
		    System.out.println("data get");
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return listOfTDSDocument;
		}
	
	/* HR TDS */
	public List<TDSHrBean> getAllTdsHrList()
	{
	    List<TDSHrBean> listOfAllHrTds = new ArrayList<TDSHrBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSHrBean where status = 'LOCK'";
			 Query query = session.createQuery(hql);
			 listOfAllHrTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllHrTds;
	}
	
	public List<TDSHrBean> getAllTdsHrListByStatus()
	{
	    List<TDSHrBean> listOfAllHrTds = new ArrayList<TDSHrBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSHrBean";
			 Query query = session.createQuery(hql);
			 listOfAllHrTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllHrTds;
	}
	
	public List<TDSHrBean> getAllTdsHrListByID(int id)
	{
	    List<TDSHrBean> listOfAllTdsHr = new ArrayList<TDSHrBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSHrBean where tds_hr_id ='"+ id +"' ";
			 Query query = session.createQuery(hql);
			 listOfAllTdsHr = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTdsHr;
	}
	
	public 	TDSHrBean detailsOfTDSHr(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrBean tdsHrBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrBean where tds_hr_id="+tds_hr_id+"");
		    tdsHrBean = (TDSHrBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrBean;
		}
	
	
	
	public 	TDSHrTotalABean detailsOfTDSHrTotal_A(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrTotalABean tdsHrTotalABean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrTotalABean where tdsHrBean="+tds_hr_id+"");
		    tdsHrTotalABean = (TDSHrTotalABean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrTotalABean;
		}
	
	public 	TDSHrTotalBBean detailsOfTDSHrTotal_B(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrTotalBBean tdsHrTotalBBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrTotalBBean where tdsHrBean="+tds_hr_id+"");
		    tdsHrTotalBBean = (TDSHrTotalBBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrTotalBBean;
		}
	
	public 	TDSHrTotalCBean detailsOfTDSHrTotal_C(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrTotalCBean tdsHrTotalCBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrTotalCBean where tdsHrBean="+tds_hr_id+"");
		    tdsHrTotalCBean = (TDSHrTotalCBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrTotalCBean;
		}
	
	public 	TDSHrTotalDBean detailsOfTDSHrTotal_D(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrTotalDBean tdsHrTotalDBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrTotalDBean where tdsHrBean="+tds_hr_id+"");
		    tdsHrTotalDBean = (TDSHrTotalDBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrTotalDBean;
		}
	
	public 	TDSHrTotalEBean detailsOfTDSHrTotal_E(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrTotalEBean tdsHrTotalEBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrTotalEBean where tdsHrBean="+tds_hr_id+"");
		    tdsHrTotalEBean = (TDSHrTotalEBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrTotalEBean;
		}
	
	public 	TDSHrTotalFBean detailsOfTDSHrTotal_F(int tds_hr_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSHrTotalFBean tdsHrTotalFBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSHrTotalFBean where tdsHrBean="+tds_hr_id+"");
		    tdsHrTotalFBean = (TDSHrTotalFBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsHrTotalFBean;
		}
	/*Document List*/
	
	public List<TDSDocumentUploadBean> getAllTdsDocumentListByischecked()
	{
	    List<TDSDocumentUploadBean> listOfAllTdsHr = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean where ischecked = '0' GROUP BY attachment_name";
			 Query query = session.createQuery(hql);
			 listOfAllTdsHr = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTdsHr;
	}
	
	public List<TDSDocumentUploadBean> getAllTdsDocumentListByischeckeduserside()
	{
	    List<TDSDocumentUploadBean> listOfAllTdsHr = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean where ischeckeduserside = '0' AND status = 'approved' GROUP BY attachment_name";
			 Query query = session.createQuery(hql);
			 listOfAllTdsHr = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTdsHr;
	}
	
	public List<TDSDocumentUploadBean> getAllTdsDocumentList()
	{
	    List<TDSDocumentUploadBean> listOfAllTdsHr = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean GROUP BY employee_master_id";
			 Query query = session.createQuery(hql);
			 listOfAllTdsHr = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTdsHr;
	}
	
	
	public List<TDSDocumentUploadBean> getAllTdsDocumentListById(int id)
	{
	    List<TDSDocumentUploadBean> listOfAllTdsDocument = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean where employeeBean="+id+"";
			 Query query = session.createQuery(hql);
			 listOfAllTdsDocument = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTdsDocument;
	}
	
	public List<TDSBean> getAllTdsList(int id)
	{
	    List<TDSBean> listOfTds = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSBean where employeeBean="+id+"";
			 Query query = session.createQuery(hql);
			 listOfTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTds;
	}
	
	public List<TDSBean> getAllTdsListByTDSId(int id)
	{
	    List<TDSBean> listOfTds = new ArrayList<TDSBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSBean where tds_id="+id+"";
			 Query query = session.createQuery(hql);
			 listOfTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTds;
	}
	
	
	public List<TDSHistoryBean> getDetailTDSHistoryById(int id)
	{
	    List<TDSHistoryBean> listOfAllTds = new ArrayList<TDSHistoryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSHistoryBean where tdsBean ='"+ id +"' ";
			 Query query = session.createQuery(hql);
			 listOfAllTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTds;
	}
	
	public List<TDSHrHistoryBean> getDetailTDSHrHistoryById(int id)
	{
	    List<TDSHrHistoryBean> listOfAllTds = new ArrayList<TDSHrHistoryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSHrHistoryBean where tdsHrBean ='"+ id +"' ";
			 Query query = session.createQuery(hql);
			 listOfAllTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTds;
	}
	
	
	public List<TDSDocumentUploadBean> getDocumentList(int id,String attachment_name)
	{
	    List<TDSDocumentUploadBean> listOfAllTds = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean where tdsBean ='"+ id +"' and attachment_name = '"+ attachment_name+"'";
			 Query query = session.createQuery(hql);
			 listOfAllTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTds;
	}
	
	public List<TDSDocumentUploadBean> getDocumentListHRSide(int id,String attachment_name)
	{
	    List<TDSDocumentUploadBean> listOfAllTds = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean where employeeBean ='"+ id +"' and attachment_name = '"+ attachment_name+"'";
			 Query query = session.createQuery(hql);
			 listOfAllTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTds;
	}
	
	public List<TDSDocumentUploadBean> getLastAddedData(int tds_id,String attachment_name)
	{
	    List<TDSDocumentUploadBean> listOfAllTds = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean where tdsBean ='"+ tds_id +"' and attachment_name = '"+ attachment_name+"'";
			 Query query = session.createQuery(hql);
			 listOfAllTds = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTds;
	}
	
	public 	TDSPayrollBean getAllTdsPayrollListByEmployeeCode(int tds_payroll_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSPayrollBean tdsPayrollBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSPayrollBean where tds_payroll_id="+tds_payroll_id+"");
		    tdsPayrollBean = (TDSPayrollBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsPayrollBean;
		}
	
	
	public List<TDSTaxBean> getTDSTaxListById(int tds_id,int emp_id)
	{
	    List<TDSTaxBean> listOfAllTdsTax = new ArrayList<TDSTaxBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSTaxBean where tdsBean ='"+ tds_id +"' AND employeeBean = '"+ emp_id+"'";
			 Query query = session.createQuery(hql);
			 listOfAllTdsTax = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllTdsTax;
	}
	
	public 	TDSBean detailsOfTDSIdForDocument(int employee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSBean tdsBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSBean where employeeBean="+employee_id+"");
		    tdsBean = (TDSBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsBean;
		}
	
	public TDSBean getTDSIdByEmployeeMasterId(int employee_master_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSBean tdsBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSBean where employeeBean="+employee_master_id+"");
		    tdsBean = (TDSBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsBean;
		}
	
	public List<TDSPayrollBean> getTDSPayrollDataByEmpCode(int emp_code,String company_name)
	{
	    List<TDSPayrollBean> listOfTDSPayroll = new ArrayList<TDSPayrollBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSPayrollBean where employee_code="+emp_code+" AND company_name = '"+ company_name +"'";
			 Query query = session.createQuery(hql);
			 listOfTDSPayroll = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTDSPayroll;
	}
	
	public List<TDSPayrollSalaryDataBean> getTDSPayrollSalaryDataByEmpCode(int emp_code,String company_name)
	{
	    List<TDSPayrollSalaryDataBean> listOfTDSPayrollSalaryData = new ArrayList<TDSPayrollSalaryDataBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSPayrollSalaryDataBean where employee_code="+emp_code+" AND company_name = '"+ company_name +"'";
			 Query query = session.createQuery(hql);
			 listOfTDSPayrollSalaryData = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTDSPayrollSalaryData;
	}
	
	public List<TDSDocumentUploadBean> getListOfDocument(int tds_id)
	{
	    List<TDSDocumentUploadBean> listOfDocument = new ArrayList<TDSDocumentUploadBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSDocumentUploadBean where tdsBean="+tds_id+"";
			 Query query = session.createQuery(hql);
			 listOfDocument = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfDocument;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TDSHrBean> getTDSHRDuplicate(String period , EmployeeBean emp_id ) 
	{
	
		List<TDSHrBean> listOfTDS = new ArrayList<TDSHrBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
  
    try {
        tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("FROM TDSHrBean WHERE period = '" + period + "' AND employeeBean ='"+ emp_id +"'");
        listOfTDS = query.list();
        tx.commit();
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return listOfTDS;
}
	
	/*public 	TDSDocumentUploadBean getAllTdsDocumentList(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TDSDocumentUploadBean tdsDocumentUploadBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("from TDSDocumentUploadBean where employeeBean="+id+"");
		    tdsDocumentUploadBean = (TDSDocumentUploadBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return tdsDocumentUploadBean;
		}*/
	
	public List<TDSPayrollBean> getSizeOfPayrollDataById(int emp_code,String company_name)
	{
	    List<TDSPayrollBean> listOfTDSPayrollData = new ArrayList<TDSPayrollBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from TDSPayrollBean where employee_code="+emp_code+" AND company_name = '"+ company_name +"'";
			 Query query = session.createQuery(hql);
			 listOfTDSPayrollData = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfTDSPayrollData;
	}
}
