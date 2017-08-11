package com.hrms.riskmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.recruitement.util.HibernateUtil;
import com.hrms.riskmanagement.bean.ConcernPersonBean;
import com.hrms.riskmanagement.bean.MonitoringFrequencyBean;
import com.hrms.riskmanagement.bean.ProbabilityBean;
import com.hrms.riskmanagement.bean.RiskPriorityBean;
import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.riskmanagement.bean.RiskStatusBean;
import com.hrms.riskmanagement.bean.SeverityBean;
import com.hrms.riskmanagement.bean.StakHoldersDetailsBean;
import com.hrms.riskmanagement.bean.SuggestionBean;

public class AllRiskManagementDAO {

	public List<RiskRepositoryBean> getListOfRiskListed(int manager_id) {
		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery("FROM RiskRepositoryBean where projectMasterBean.managerBean = '" + manager_id + "' and risk_status_id != 4 ")
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
		return listOfRisk;

	}
	public List<RiskRepositoryBean> getListOfRiskByProject(int manager_id,int project_id) {
		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery("FROM RiskRepositoryBean where projectMasterBean.managerBean = '" + manager_id + "' and projectMasterBean = '"+project_id+"' and risk_status_id != 4 ")
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
		return listOfRisk;

	}
	public List<RiskRepositoryBean> getListOfRiskByProjectClose(int manager_id,int project_id) {
		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery("FROM RiskRepositoryBean where projectMasterBean.managerBean = '" + manager_id + "' and projectMasterBean = '"+project_id+"' and risk_status_id = 4 ")
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
		return listOfRisk;

	}
	
	public List<RiskRepositoryBean> getListOfRiskClosed(int manager_id) {
		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery("FROM RiskRepositoryBean where projectMasterBean.managerBean = '" + manager_id + "' and risk_status_id = 4 ")
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
		return listOfRisk;

	}

	public List<RiskRepositoryBean> getListOfAllRiskListed() {
		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery(
							"FROM RiskRepositoryBean where (projectMasterBean.managerBean != 1 and projectMasterBean.managerBean != 2 and projectMasterBean.managerBean != 3) and riskStatusBean  != 4")
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
		return listOfRisk;

	}
	public List<RiskRepositoryBean> getListOfCloseRiskListed() {
		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery(
							"FROM RiskRepositoryBean where (projectMasterBean.managerBean != 1 and projectMasterBean.managerBean != 2 and projectMasterBean.managerBean != 3) and riskStatusBean  = 4")
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
		return listOfRisk;

	}

	public List<RiskRepositoryBean> getListOfRiskListedByRiskId(int risk_repository_id) {
		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery("FROM RiskRepositoryBean where risk_repository_id = '" + risk_repository_id + "' ")
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
		return listOfRisk;

	}

	public List<RiskStatusBean> getListOfRiskStatus() {
		List<RiskStatusBean> listOfRiskStatus = new ArrayList<RiskStatusBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRiskStatus = session.createQuery("FROM RiskStatusBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRiskStatus;

	}

	public List<MonitoringFrequencyBean> getListOfFrequency() {
		List<MonitoringFrequencyBean> getListOfFrequency = new ArrayList<MonitoringFrequencyBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfFrequency = session.createQuery("FROM MonitoringFrequencyBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getListOfFrequency;

	}

	public List<RiskPriorityBean> getListOfPriority() {
		List<RiskPriorityBean> getListOfPriority = new ArrayList<RiskPriorityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfPriority = session.createQuery("FROM RiskPriorityBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getListOfPriority;

	}

	public List<ProbabilityBean> getListOfProbability() {
		List<ProbabilityBean> getListOfProbability = new ArrayList<ProbabilityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfProbability = session.createQuery("FROM ProbabilityBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getListOfProbability;

	}

	public List<SeverityBean> getListOfSeverity() {
		List<SeverityBean> getListOfSeverity = new ArrayList<SeverityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfSeverity = session.createQuery("FROM SeverityBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getListOfSeverity;

	}

	public EmployeeBean getUserByEmployeeId(int employee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_master_id=" + employee_id + "");
			employeeBean = (EmployeeBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeBean;
	}

	public RiskStatusBean getListOfRiskStatusById(int status_id) {
		Session session = HibernateUtil.openSession();
		RiskStatusBean riskStatusBean = null;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM RiskStatusBean where risk_status_id=" + status_id + "");
			riskStatusBean = (RiskStatusBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return riskStatusBean;

	}

	
	public List<RiskRepositoryBean> getListOfProjectWiseRiskListed(int project_id)
	{
        List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfRisk = session.createQuery("FROM RiskRepositoryBean where projectMasterBean = '"+project_id+"' ").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfRisk;
        
	}
	
	public List<RiskRepositoryBean> getListOfImpactOnProject(int project_id, String impact)
	{
        List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            if(!impact.equalsIgnoreCase("0")){
            	listOfRisk = session.createQuery("FROM RiskRepositoryBean where projectMasterBean = '"+project_id+"' and impact = '"+impact+"'").list(); 
            }else{
            	listOfRisk = session.createQuery("FROM RiskRepositoryBean where projectMasterBean = '"+project_id+"'").list();
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfRisk;
        
	}

	
	
	public List<ProjectMasterBean> getListOfProject(int project_id)
	{
        List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfProject = session.createQuery("FROM ProjectMasterBean where project_master_id = '"+project_id+"' ").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfProject;
        
	}
	
	public List<StakHoldersDetailsBean> getListOfStakHolder(int risk_repository_id) {
		List<StakHoldersDetailsBean> listOfRisk = new ArrayList<StakHoldersDetailsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRisk = session
					.createQuery("FROM StakHoldersDetailsBean where risk_repository_id = '" +risk_repository_id+ "' ")
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
		return listOfRisk;

	}
	public List<RiskRepositoryBean> getRiskByEmployee(int employee_id) {

		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where employeeBean=" + employee_id + "");
			listOfRisk = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRisk;
	}
	
	public List<RiskRepositoryBean> getRiskByEmployeeContingency(int employee_id) {

		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where employee_id_contingency =" + employee_id + "");
			listOfRisk = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRisk;
	}
	
	public List<ConcernPersonBean> getlistOfConcernPerson(int risk_id){

		List<ConcernPersonBean> listOfConcernPerson = new ArrayList<ConcernPersonBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ConcernPersonBean concernPersonBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ConcernPersonBean where risk_repository_id =" + risk_id+ "");
			listOfConcernPerson= query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfConcernPerson;
	}
	public List<RiskRepositoryBean> getRiskByDates(String startDate ,String endDate){

		List<RiskRepositoryBean> listOfRiskByDate = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where date_of_risk_identification BETWEEN '"+startDate+"' AND '"+endDate+"'");
			listOfRiskByDate = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRiskByDate;
	}
	public List<RiskRepositoryBean> getRiskOpen(String startDate ,String endDate){

		List<RiskRepositoryBean> listOfRiskByDate = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where (date_of_risk_identification BETWEEN '"+startDate+"' AND '"+endDate+"') and riskStatusBean  = 1");
			listOfRiskByDate = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRiskByDate;
	}
	public List<RiskRepositoryBean> getRiskClose(String startDate ,String endDate){

		List<RiskRepositoryBean> listOfRiskByDate = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where (date_of_risk_identification BETWEEN '"+startDate+"' AND '"+endDate+"') and riskStatusBean  = 4 ");
			listOfRiskByDate = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRiskByDate;
	}
	public List<RiskRepositoryBean> getRiskhighProi(String startDate ,String endDate){

		List<RiskRepositoryBean> listOfRiskByDate = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where (date_of_risk_identification BETWEEN '"+startDate+"' AND '"+endDate+"') and riskPriorityBean = 3");
			listOfRiskByDate = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRiskByDate;
	}
	public List<RiskRepositoryBean> getRiskhighImapct(String startDate ,String endDate){

		List<RiskRepositoryBean> listOfRiskByDate = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where (date_of_risk_identification BETWEEN '"+startDate+"' AND '"+endDate+"') and impact = 'high'");
			listOfRiskByDate = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRiskByDate;
	}
	
	
	
	public ConcernPersonBean getConcernPerson(int employee_id,int risk_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ConcernPersonBean concernPersonBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from ConcernPersonBean where employeeBean= "+employee_id+" and riskRepositoryBean="+risk_id+" ");
            concernPersonBean = (ConcernPersonBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return concernPersonBean;
    }
	
	public List<EmployeeBean> getListOfEmailId(int employee_master_id){

		List<EmployeeBean> listOfRiskByDate = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_master_id = "+employee_master_id+"");
			listOfRiskByDate = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRiskByDate;
	}
	
	public List<SuggestionBean> getSuggestionByRiskId(int risk_id)
	{
	    List<SuggestionBean> listOfSuggestion = new ArrayList<SuggestionBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSuggestion = session.createQuery("FROM SuggestionBean where riskRepositoryBean = '"+risk_id+"'").list();
	        System.out.println(listOfSuggestion.size());
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSuggestion;
	}
public List<SuggestionBean> getSuggestionByEmployeeId(int employee_id)
	{
	    List<SuggestionBean> listOfSuggestion = new ArrayList<SuggestionBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSuggestion = session.createQuery("FROM SuggestionBean where riskRepositoryBean = '"+employee_id+"'").list();
	        System.out.println(listOfSuggestion.size());
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSuggestion;
	}
	
}
