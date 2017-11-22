package com.hrms.tds.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;
import com.hrms.tds.bean.TDSDocumentUploadBean;
import com.hrms.tds.bean.TDSPayrollBean;

public class PayrollList {
	
	public double getdueMonthIncentive(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(incentive) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthBasicSalary(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(basic_salary) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	
	public double getDueMonthHRA(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(hra) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthConveyance(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(conveyance) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthLTC(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(ltc) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthMedical(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(medical) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	
	public double getDueMonthUniAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(uni_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthEduAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(edu_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthOtherAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(other_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthAdhocAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(adhoc_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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

	public double getDueMonthSalary(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(salary) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthPTAX(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(ptax) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getDueMonthPF(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(pf) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getdueMonthPreviousSalary(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(previous_salary) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getdueMonthPerformancePay(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(performance_pay) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getdueMonthLeave(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select sum(leave) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	// max value 
	public double getMaxBasicSalary(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(basic_salary) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxHRA(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(hra) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxConveyance(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(conveyance) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxLTC(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(ltc) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxMedical(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(medical) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	
	public double getMaxUniAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(uni_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxEduAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(edu_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxOtherAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(other_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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

	public double getMaxAdhocAllw(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(adhoc_allw) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxIncentive(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(incentive) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxSalary(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(salary) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxPreviousSalary(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(previous_salary) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxPerformancePay(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(performance_pay) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	public double getMaxLeave(int emp_code, String company_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select max(leave) from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31')");
             maxvalue = (Double) query1.uniqueResult();
            
            
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
	
	// last record
	public List<TDSPayrollBean> getLastBasicSalary(int emp_code, String company_code)
	{
	    List<TDSPayrollBean> listOfDocument = new ArrayList<TDSPayrollBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
            
            Query query1 = session.createQuery("from TDSPayrollBean where employee_code = '"+emp_code+"' and company_name = '"+ company_code+"' and (date BETWEEN '2017-04-01' AND '2018-03-31') ORDER BY tds_payroll_id DESC");
            query1.setMaxResults(1);
            listOfDocument =  query1.list();
            
            
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
	
	/*public List<TDSPayrollBean> getLastBasicSalary(int tds_id)
	{
	    List<TDSPayrollBean> listOfDocument = new ArrayList<TDSPayrollBean>();
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
	}*/
	
}
