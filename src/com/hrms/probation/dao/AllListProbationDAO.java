package com.hrms.probation.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.probation.bean.AttributeBean;
import com.hrms.probation.bean.AttributeM2Bean;
import com.hrms.probation.bean.ProbationAssessmentM1Bean;
import com.hrms.probation.bean.ProbationAssessmentM2Bean;
import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationAssessmentTerminationBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.bean.ProbationOpenInfopageBean;
import com.hrms.probation.bean.ProbationTopManagementApprovalBean;

//Author Name :- Ripal Soni
//For Getting Data into list(All List Methods)


public class AllListProbationDAO {

	//List Method for getting attributes from probation_attributes_direct_tbl
	public List<AttributeBean> getListOfAttribute() {
		List<AttributeBean> listOfAttribute = new ArrayList<AttributeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAttribute = session
					.createQuery("FROM AttributeBean")
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
	
	//List Method for getting attributes from probation_attributes_indirect_tbl
	public List<AttributeM2Bean> getListOfAttributeM2() {
		List<AttributeM2Bean> listOfAttribute = new ArrayList<AttributeM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAttribute = session
					.createQuery("FROM AttributeM2Bean where employee_role = '"+0+"'")
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
	public List<AttributeM2Bean> getListOfAttributeM2Direct() {
		List<AttributeM2Bean> listOfAttribute = new ArrayList<AttributeM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAttribute = session
					.createQuery("FROM AttributeM2Bean where employee_role = '"+1+"'")
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
	
	//List Method for getting month from month_tbl
	public List<MonthBean>  getListOfMonth(){
	    List<MonthBean> listofMonth = new ArrayList<MonthBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listofMonth = session.createQuery("from MonthBean where month_id !=13").list();                        
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listofMonth;
	}
	
	//List Method for getting month from month_tbl by month_id
	public MonthBean getInfoById(int month_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        MonthBean monthBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from MonthBean where month_id="+month_id+"");
            monthBean = (MonthBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return monthBean;
    }
	
	//List Method for getting year from year_tbl by year_id
	public YearBean getInfoByIdYear(int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        YearBean yearBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from YearBean where year_id="+year_id+"");
            yearBean = (YearBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return yearBean;
    }
	
	//List Method for getting scores from probation_assessment_direct_tbl group by employee_master_id
	public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM1() {
		List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentM2Bean where employee_role = '"+1+"' group by employee_master_id")
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
	
	//List Method for getting scores from probation_assessment_direct_tbl by employee_master_id
	public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM1ByEmpID(int emp_id) {
		List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentM2Bean where employee_master_id ='"+emp_id+"' and employee_role = '"+1+"'")
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
	
	//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id
	public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM2ByEmpID(int emp_id) {
		List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentM2Bean where employee_master_id ='"+emp_id+"'")
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
	
	
	//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id group by month id
	public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM2ByEmpIDGroupBy(int emp_id) {
		List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentM2Bean where employee_master_id ='"+emp_id+"' group by monthBean")
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
	
	
	//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id and que_id
	public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM2ByEmpIDAndQueID(int emp_id, int que_id) {
		List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentM2Bean where employee_master_id ='"+emp_id+"' and attributeM2Bean = '"+que_id+"'")
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
	
	
	
	
	//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id and que_id
		public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM2ByEmpIDAndQueIDGroupByMonthId(int emp_id, int que_id) {
			List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfscore = session
						.createQuery("FROM ProbationAssessmentM2Bean where employee_master_id ='"+emp_id+"' and attributeM2Bean = '"+que_id+"' group by monthBean")
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
		//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id and month_id and year_id
		public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM2ByEmpIdAndMonthId(int emp_id, int month_id , int year_id) {
			List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfscore = session
						.createQuery("FROM ProbationAssessmentM2Bean where employee_master_id ='"+emp_id+"' and monthBean = '"+month_id+"' and yearBean = '"+year_id+"'")
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
		
	
	//List Method for getting scores from probation_assessment_direct_tbl by employee_master_id,month_id,year_id,attribute_que_id for getting particular one row from table and using for displaying score
	public ProbationAssessmentM2Bean test(int employee_master_id,int month_id,int que_id,int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ProbationAssessmentM2Bean probationAssessmentM2Bean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM ProbationAssessmentM2Bean where employeeBean = "+employee_master_id+" and monthBean = "+month_id+" and attributeBean = "+que_id+" and year_id = "+year_id+" and employee_role = '"+1+"'");
            probationAssessmentM2Bean = (ProbationAssessmentM2Bean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return probationAssessmentM2Bean;
    }
	
	//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id,month_id,year_id,attribute_que_id for getting particular one row from table and using for displaying score
	public ProbationAssessmentM2Bean testForM2(int employee_master_id,int month_id,int que_id,int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ProbationAssessmentM2Bean probationAssessmentM2Bean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM ProbationAssessmentM2Bean where employeeBean = "+employee_master_id+" and monthBean = "+month_id+" and attributeM2Bean = "+que_id+" and year_id = "+year_id+"");
            probationAssessmentM2Bean = (ProbationAssessmentM2Bean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return probationAssessmentM2Bean;
    }
	
	//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id,month_id,year_id,attribute_que_id for getting particular one row from table and using for displaying score
	public ProbationAssessmentM2Bean testM2(int employee_master_id,int month_id,int que_id,int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ProbationAssessmentM2Bean probationAssessmentM2Bean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM ProbationAssessmentM2Bean where employeeBean = "+employee_master_id+" and monthBean = "+month_id+" and attributeM2Bean = "+que_id+" and year_id = "+year_id+"");
            probationAssessmentM2Bean = (ProbationAssessmentM2Bean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return probationAssessmentM2Bean;
    }
	
	//List Method for getting year from year_tbl by year_id
	public YearBean yearCheck(int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        YearBean yearBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM YearBean where year = "+year_id+"");
            yearBean = (YearBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return yearBean;
    }
	//List Method for getting month from month_tbl by month_id
		public MonthBean monthCheck(int month_id) {
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        MonthBean monthBean = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("FROM MonthBean where month_name = "+month_id+"");
	            monthBean = (MonthBean)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return monthBean;
	    }
	
	//List Method for getting scores from probation_assessment_direct_tbl by employee_master_id
	public List<ProbationAssessmentM2Bean> getListOfProbationAssessmentM1(int employee_master_id) {
		List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentM2Bean where employeeBean = "+employee_master_id+" and employee_role = '"+1+"'")
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
	
	//List Method for getting count of month filled from probation_assessment_direct_tbl by employee_master_id	
	public long getCount(int emp_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        long maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select count(probation_attributes_m2_id) from AttributeM2Bean where employee_role = '"+1+"'");
            long maxvalue1 = (Long) query1.uniqueResult();
            
            Query query = session.createQuery("select count(month_id)/"+maxvalue1+" from ProbationAssessmentM2Bean where employeeBean = '"+emp_id+"'");
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
	
	//List Method for getting count of month filled from probation_assessment_indirect_tbl by employee_master_id
	public long getCountForM2(int emp_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        long maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query query1 = session.createQuery("select count(probation_attributes_m2_id) from AttributeM2Bean where employee_role = '"+0+"'");
            long maxvalue1 = (Long) query1.uniqueResult();
            
            Query query = session.createQuery("select count(month_id)/"+maxvalue1+" from ProbationAssessmentM2Bean where employeeBean = '"+emp_id+"'");
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
	
	//List Method for getting sum of month filled from probation_assessment_direct_tbl by employee_master_id
	public double getSumByMonth(int emp_id,int month_id,int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select sum(attribute_score) from ProbationAssessmentM2Bean where employeeBean = '"+emp_id+"' and monthBean = '"+month_id+"' and year_id = '"+year_id+"' and employee_role = '"+1+"'");
            maxvalue = (double) query.uniqueResult();
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
	
	//List Method for getting sum of month filled from probation_assessment_indirect_tbl by employee_master_id
	public double getSumByMonthForM2(int emp_id,int month_id,int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        double maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select sum(attribute_m2_score) from ProbationAssessmentM2Bean where employeeBean = '"+emp_id+"' and monthBean = '"+month_id+"' and year_id = '"+year_id+"'");
            maxvalue = (double) query.uniqueResult();
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
	
	//List Method for getting scores from probation_assessment_indirect_tbl by employee_master_id,month_id,year_id for getting particular one row from table and using for displaying score
	public ProbationAssessmentM2Bean getValueForExtraParmForM2(int emp_id,int month_id,int year_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ProbationAssessmentM2Bean probationAssessmentM2Bean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from ProbationAssessmentM2Bean where employeeBean = '"+emp_id+"' and monthBean = '"+month_id+"' and year_id = '"+year_id+"' group by employeeBean");
            probationAssessmentM2Bean = (ProbationAssessmentM2Bean) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return probationAssessmentM2Bean;
    }

	//List Method for getting Employee List from employee_master_tbl by manager_id and not in manager_tbl
	public List<EmployeeBean> getListOfUnderEmployee(int manager_id) {
		List<EmployeeBean> listOfscore = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM EmployeeBean where under_manager_id = "+manager_id+"  and  manager_id != 99 and (joining_date > '2017-10-31')")
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
	
	//List Method for getting Employee List from employee_master_tbl by d1 to d4 all top_management_authority
	public List<EmployeeBean> getlistOfTopManagement() {
		List<EmployeeBean> listOfscore = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM EmployeeBean where roleBean.role_id in ('2','3','9') and employeeStatusBean = 1")
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
	
	//List Method for getting Under Employee List from employee_master_tbl by manager_id
	public List<EmployeeBean> getListOfUnderEmployeepProbation(int manager_id) {
		List<EmployeeBean> listOfscore = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM EmployeeBean where under_manager_id = "+manager_id+"  and employee_status_id = 2 and companyListBean.company_list_id != 8 and (joining_date > '2017-10-31')")
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

	//List Method for getting Under Employee List from employee_master_tbl by manager_id
	public List<EmployeeBean> getListOfUnderManagerEmployee(int manager_id) {
		List<EmployeeBean> listOfscore = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM EmployeeBean where under_manager_id = "+manager_id+" and (joining_date > '2017-10-31')")
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
	
	//List Method for getting Under Employee List from probation_assessment_manager_tbl by manager_id
	public List<ProbationAssessmentManagerBean> getListOfReviews(int manager_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean.under_manager_id = "+manager_id+"")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl
	public List<ProbationAssessmentManagerBean> getListOfAllReviews() {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		 
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean)")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsByEmployeeId(int employee_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		 
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where reviewing_manager_id = '"+employee_id+"')")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl group by employee_id
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsByEmployeeIdForManager(int under_manager_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		 
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean as p where exists (FROM EmployeeBean as e where e.employee_master_id = p.reviewing_manager_id and e.under_manager_id = '"+under_manager_id+"')")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl group by employee_id and hr_approval=pending,manager_approval
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsPending() {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where (hr_approval = 'pending' and manager_approval = 'approved') group by employeeBean")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl group by employee_id and hr_approval!=pending,hr_approval!=rejected,top_manager_approval=pending
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsHRApproved() {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where (hr_approval != 'pending' and hr_approval != 'rejected' and top_management_approval = 'pending') group by employeeBean")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl  by employee_id and hr_approval!=pending,top_manager_approval=approved
	public List<ProbationTopManagementApprovalBean> getListOfAllReviewsTMApprove(int t_id) {
		
		    List<ProbationTopManagementApprovalBean> listOfAppraisal = new ArrayList<ProbationTopManagementApprovalBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationTopManagementApprovalBean where top_management_id ='"+t_id+"' and top_management_status = 'approved'";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
		
	}

	//List Method for getting All data from probation_assessment_manager_tbl  by employee_id and hr_approval!=pending,top_manager_approval=rejected
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsTMReject() {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where (hr_approval != 'pending' and top_management_approval = 'rejected') group by employeeBean")
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

	//List Method for getting All data from probation_assessment_manager_tbl  by employee_id and hr_approval=approved
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsHRApprove() {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where hr_approval = 'approved' group by employeeBean")
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

	//List Method for getting All data from probation_assessment_manager_tbl  by employee_id and hr_approval=rejected
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsHRRejected() {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where hr_approval = 'rejected' group by employeeBean")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl  by employee_id and hr_approval!=pending and top_management_approval != pending	
	public List<ProbationAssessmentManagerBean> getListOfAllReviewsApproved() {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where (hr_approval != 'pending' and top_management_approval != 'pending')  group by employeeBean")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id for getting count
	public long getCountOfProbation(int emp_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        long maxvalue = 0;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select count(probation_assessment_manager_id) from ProbationAssessmentManagerBean where employeeBean = '"+emp_id+"'");
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id and reviewing_manager_id for getting count	
	public List<ProbationAssessmentManagerBean> getListOfScoreById(int emp_id,int reviewing_manager_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+" and reviewing_manager_id = "+reviewing_manager_id+"")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id
	public List<ProbationAssessmentM2Bean> getListOfScoreByEmpIdGroupbyMonthId(int emp_id) {
		List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentM2Bean where employeeBean = "+emp_id+" group by yearBean,monthBean")
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
	
	public List<ProbationAssessmentManagerBean> getListOfScoreByEmpId(int emp_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+"")
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

	//List Method for getting All data from probation_assessment_manager_tbl by employee_id and manager_approval = approved
	public List<ProbationAssessmentManagerBean> getListOfScoreByEmpIdWithApproval(int emp_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+" and manager_approval = 'approved'")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id and manager_approval = approved,hr_approved = approved;
	public List<ProbationAssessmentManagerBean> getListOfScoreByEmpIdWithHRApproval(int emp_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+" and manager_approval = 'approved' and hr_approval = 'approved'")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id all approval;
	public List<ProbationAssessmentManagerBean> getListOfScoreByEmpIdWithTMApproval(int emp_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+" and manager_approval = 'approved' and hr_approval = 'approved' and (top_management_approval = 'approved' or top_management_approval = 'hrapproved')")
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
	
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id
		public List<ProbationAssessmentM2Bean> getListOfWarningEmployee(int emp_id) {
			List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfscore = session
						.createQuery("FROM ProbationAssessmentM2Bean pm2 where not exists(FROM ProbationAssessmentManagerBean pmb where pm2.employeeBean  = pmb.employeeBean) and pm2.employeeBean = "+emp_id+" and warning_letter = 'warningYes' group by yearBean,monthBean")
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
		
		//List Method for getting All data from probation_assessment_manager_tbl by employee_id
				public List<ProbationAssessmentM2Bean> getListOfWarningEmployeeAll() {
					List<ProbationAssessmentM2Bean> listOfscore = new ArrayList<ProbationAssessmentM2Bean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					try {
						tx = session.getTransaction();
						tx.begin();
						listOfscore = session
								.createQuery("FROM ProbationAssessmentM2Bean pm2 where not exists(FROM ProbationAssessmentManagerBean pmb where pm2.employeeBean  = pmb.employeeBean) and warning_letter = 'warningYes' group by yearBean,monthBean")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id all approval;
	public List<ProbationAssessmentManagerBean> getListOfConfirmation(int emp_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+" and manager_approval = 'approved' and hr_approval = 'approved' and (top_management_approval = 'approved' or top_management_approval = 'hrapproved') and show_view = '0'")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id manager_approval=rejected;
	public List<ProbationAssessmentManagerBean> getListOfScoreByEmpIdRejected(int emp_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+" and manager_approval = 'rejected'")
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
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id manager_approval=approved;
	public List<ProbationAssessmentManagerBean> getListOfScoreByEmpIdApproved(int emp_id) {
		List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfscore = session 
					.createQuery("FROM ProbationAssessmentManagerBean where employeeBean = "+emp_id+" and manager_approval = 'approved' ")
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
	
	//List Method for getting All data from probation_assessment_direct_tbl by employee_id,month_id,year_id;
	public List<ProbationAssessmentM2Bean> getProbationCheckMonth(int employee_master_id , int month_id,int year_id)
	{
	    List<ProbationAssessmentM2Bean> listOfAppraisal = new ArrayList<ProbationAssessmentM2Bean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentM2Bean where monthBean ='"+month_id+"' and employeeBean='"+employee_master_id+"' and year_id  = '"+year_id+"' and employee_role = '"+1+"'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
	}
	
	//List Method for getting All data from probation_assessment_indirect_tbl by employee_id and not countinued_for_next_month
	public List<ProbationAssessmentM2Bean> getProbationCheckContinueMonth(int employee_master_id)
	{
	    List<ProbationAssessmentM2Bean> listOfAppraisal = new ArrayList<ProbationAssessmentM2Bean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentM2Bean where employeeBean='"+employee_master_id+"' and continue_for_next_month = 'continueNo'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
	}
	
	//List Method for getting All data from probation_assessment_indirect_tbl by employee_id,month_id,year_id;
	public List<ProbationAssessmentM2Bean> getProbationCheckMonthM2(int employee_master_id , int month_id,int year_id)
	{
	    List<ProbationAssessmentM2Bean> listOfAppraisal = new ArrayList<ProbationAssessmentM2Bean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentM2Bean where monthBean ='"+month_id+"' and employeeBean='"+employee_master_id+"' and year_id  = '"+year_id+"'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
	}
	//List Method for getting All data from probation_assessment_indirect_tbl by employee_id,month_id,year_id;
	public List<ProbationAssessmentM2Bean> getProbationCheckMonthM2YearName(int employee_master_id , int month_id,int year_id)
	{
	    List<ProbationAssessmentM2Bean> listOfAppraisal = new ArrayList<ProbationAssessmentM2Bean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentM2Bean where monthBean ='"+month_id+"' and employeeBean='"+employee_master_id+"' and yearBean.year  = '"+year_id+"'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
	}
	//List Method for getting All data from probation_assessment_direct_tbl by employee_id,month_id,year_id;
		public List<ProbationAssessmentM2Bean> getProbationCheckMonthM1YearName(int employee_master_id , int month_id,int year_id)
		{
		    List<ProbationAssessmentM2Bean> listOfAppraisal = new ArrayList<ProbationAssessmentM2Bean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentM2Bean where monthBean ='"+month_id+"' and employeeBean='"+employee_master_id+"' and yearBean.year  = '"+year_id+"' and employee_role = '"+1+"'";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
		}
	
	//List Method for getting All data from probation_extend_tbl by probation_manager_id,status=approved;
	public List<ProbationExtendBean> getProbationExtend(int p_id)
	{
	    List<ProbationExtendBean> listOfAppraisal = new ArrayList<ProbationExtendBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationExtendBean where probationAssessmentManagerBean ='"+p_id+"' and status = 'approved'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
	}
	
	
	//List Method for getting All data from probation_extend_tbl by probation_manager_id,status=approved;
		public List<ProbationExtendBean> getProbationExtendByEmpId(int emp_id)
		{
		    List<ProbationExtendBean> listOfAppraisal = new ArrayList<ProbationExtendBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationExtendBean where probationAssessmentManagerBean.employeeBean ='"+emp_id+"' and status = 'approved'";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
		}
	
	
	
	//List Method for getting All data from probation_extend_tbl by probation_manager_id,status=pending;
	public ProbationExtendBean getListOfProbationPending(int p_id) {
		ProbationExtendBean probationExtendBean = new ProbationExtendBean();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				probationExtendBean = (ProbationExtendBean) session.createQuery("FROM ProbationExtendBean where probation_assessment_manager_id = "+p_id+" and status = 'pending'").uniqueResult();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return probationExtendBean;
		}
	
	//List Method for getting All data from probation_assessment_manager_tbl by probation_manager_id
	public ProbationAssessmentManagerBean  getListOfProbationById(int p_id) {
	ProbationAssessmentManagerBean probationAssessmentManagerBean = new ProbationAssessmentManagerBean();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			probationAssessmentManagerBean = (ProbationAssessmentManagerBean) session.createQuery("FROM ProbationAssessmentManagerBean where probation_assessment_manager_id = "+p_id+"").uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return probationAssessmentManagerBean;
	}
	
	//List Method for getting All data from probation_assessment_manager_tbl by employee_id
	public ProbationAssessmentManagerBean  getListOfProbationByEmpId(int e_id) {
		ProbationAssessmentManagerBean probationAssessmentManagerBean = new ProbationAssessmentManagerBean();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				probationAssessmentManagerBean = (ProbationAssessmentManagerBean) session.createQuery("FROM ProbationAssessmentManagerBean where employee_master_id = "+e_id+"").uniqueResult();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return probationAssessmentManagerBean;
		}
	
	//List Method for getting All data from probation_topmanagement_approval_tbl by top_management_id
	public List<ProbationTopManagementApprovalBean> getListOfTopManagementApproval(int t_id)
	{
	    List<ProbationTopManagementApprovalBean> listOfAppraisal = new ArrayList<ProbationTopManagementApprovalBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationTopManagementApprovalBean where top_management_id ='"+t_id+"' and top_management_status = 'pending'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
	}
	
	//List Method for getting All data from probation_topmanagement_approval_tbl by probation_manager_id
	public long getCountOfTopManagement(int prob_manager_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        long maxvalue = 0;
        
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select count(probation_topmanagement_approval_id) from ProbationTopManagementApprovalBean where probationAssessmentManagerBean = '"+prob_manager_id+"' and top_management_status = 'pending'");
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
	
	//List Method for getting All data from probation_topmanagement_approval_tbl by probation_manager_id
	public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployees(int manager_id){
	 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        String hql = "from ProbationAssessmentTerminationBean where reviewing_manager_id ='"+manager_id+"'";
		 Query query = session.createQuery(hql);
		 listOfAppraisal = query.list();
        tx.commit();
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return listOfAppraisal;
		
}
	
	//List Method for getting All data from probation_topmanagement_approval_tbl by probation_manager_id
		public List<ProbationAssessmentTerminationBean> getListOfAllTerminatedEmployees(){
		 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentTerminationBean";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
			
	}
	public List<ProbationAssessmentTerminationBean> getListOfTerminatedEmployee(int employee_master_id){
		 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentTerminationBean where employee_master_id ='"+employee_master_id+"'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
			
	}	
	//List Method for getting All data from probation_topmanagement_approval_tbl by probation_manager_id
			public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesPending(int employee_master_id){
			 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentTerminationBean where employee_master_id ='"+employee_master_id+"' and (manager_status = 'pending' or  manager_status = 'hrPending')";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
			}
	
	//List Method for getting All data from probation_assessment_termination_tbl by manager_id for displaying data both manager side
	public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesForManager(int manager_id){
		 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentTerminationBean p where exists (from EmployeeBean e where e.employee_master_id = p.reviewing_manager_id and e.under_manager_id = '"+manager_id+"' and p.manager_status = 'pending')";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
			
	}
	
	//List Method for getting All data from probation_assessment_termination_tbl by manager_id for displaying data both manager side
		public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesForManagerApproved(int manager_id){
			 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentTerminationBean p where exists (from EmployeeBean e where e.employee_master_id = p.reviewing_manager_id and e.under_manager_id = '"+manager_id+"' and (p.manager_status = 'approved' or p.manager_status = 'hrApproved'))";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
				
		}
	
	
	
		//List Method for getting All data from probation_assessment_termination_tbl by manager_id for displaying data both manager side
		public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesForHRPending(){
			 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentTerminationBean where manager_status = 'hrPending')";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
				
		}
	
	
	//List Method for getting All data from probation_assessment_termination_tbl by manager_id for displaying data both manager side
		public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesForManagers(int manager_id){
			 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentTerminationBean p where exists (from EmployeeBean e where e.employee_master_id = p.reviewing_manager_id and e.under_manager_id = '"+manager_id+"')";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
				
		}

	//List Method for getting All data from probation_assessment_termination_tbl by reviewing_manager_id and status = rejected
	public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesRejected(int reviewing_manager_id){
		 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentTerminationBean where reviewing_manager_id ='"+reviewing_manager_id+"' and manager_status = 'rejected'";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
			
	}
	
	//List Method for getting All data from probation_assessment_termination_tbl by reviewing_manager_id and status = approved
		public List<ProbationAssessmentTerminationBean> getListOfTerminatedEmployeeApproved(int emp_id){
			 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
			    Session session = HibernateUtil.openSession();
			    Transaction tx = null;        
			    try {
			        tx = session.getTransaction();
			        tx.begin();
			        String hql = "from ProbationAssessmentTerminationBean where employee_master_id ='"+emp_id+"' and manager_status = 'approved'";
					 Query query = session.createQuery(hql);
					 listOfAppraisal = query.list();
			        tx.commit();
			    } catch (Exception e) {
			        if (tx != null) {
			            tx.rollback();
			        }
			        e.printStackTrace();
			    } finally {
			        session.close();
			    }
			    return listOfAppraisal;
				
		}
	
	
	//List Method for getting All data from probation_assessment_termination_tbl by reviewing_manager_id and status = approved
	public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesApproved(int reviewing_manager_id){
		 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentTerminationBean where reviewing_manager_id ='"+reviewing_manager_id+"' and manager_status = 'approved'";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
			
	}

	//List Method for getting All data from probation_assessment_termination_tbl by manager_status = approved for displaying data at manager side
	public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployees(){
		 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProbationAssessmentTerminationBean where manager_status = 'approved' or 'hrApproved'";
			 Query query = session.createQuery(hql);
			 listOfAppraisal = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAppraisal;
			
	}
	
	//List Method for getting All data from probation_assessment_termination_tbl by manager_status = approved for displaying data at manager side
		public List<ProbationAssessmentTerminationBean> getAllListOfTerminatedEmployeesall(){
			 List<ProbationAssessmentTerminationBean> listOfAppraisal = new ArrayList<ProbationAssessmentTerminationBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ProbationAssessmentTerminationBean";
				 Query query = session.createQuery(hql);
				 listOfAppraisal = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfAppraisal;
				
		}
		
		//List Method for getting All data from probation_assessment_manager_tbl
		public List<ProbationAssessmentManagerBean> getListOfAllReviewsCompleted() {
			List<ProbationAssessmentManagerBean> listOfscore = new ArrayList<ProbationAssessmentManagerBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			
			 
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfscore = session
						.createQuery("FROM ProbationAssessmentManagerBean where to_be_confirmed = 'confirmedYes')")
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
		
		//List Method for getting All data from probation_assessment_manager_tbl
				public List<ProbationOpenInfopageBean> getProbationOpenInfoPage(int manager_id,int month_id,int year) {
					List<ProbationOpenInfopageBean> listOfscore = new ArrayList<ProbationOpenInfopageBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					
					 
					try {
						tx = session.getTransaction();
						tx.begin();
						listOfscore = session
								.createQuery("FROM ProbationOpenInfopageBean where managerBean = "+manager_id+" and monthBean = "+month_id+" and year = "+year+" ")
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
}
