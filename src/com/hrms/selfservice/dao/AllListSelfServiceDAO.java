package com.hrms.selfservice.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.selfservice.bean.AnnouncementBean;
import com.hrms.selfservice.bean.AnnouncementCategoryBean;
import com.hrms.selfservice.bean.AnnouncementCompanyBean;
import com.hrms.selfservice.bean.AnnouncementDepartmentBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ComplaintVerifiedByBean;
import com.hrms.selfservice.bean.DownloadBean;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.bean.ProblemNatureReplyBean;
import com.hrms.selfservice.bean.RoleCategoryBean;
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.bean.SelfServiceTypeBean;
import com.hrms.timesheet.bean.UnplanProjectBean;

public class AllListSelfServiceDAO {

	public List<SelfServiceTypeBean> getListOfSelfServiceType(){
	    List<SelfServiceTypeBean> listOfSelfServiceType = new ArrayList<SelfServiceTypeBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSelfServiceType = session.createQuery("FROM SelfServiceTypeBean order by selfservice_type ASC").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSelfServiceType;
	    
	}
	
	public List<SelfServiceQuerybean> getListOfSelfServiceQuery(){
	    List<SelfServiceQuerybean> listOfSelfServiceQuery = new ArrayList<SelfServiceQuerybean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSelfServiceQuery = session.createQuery("FROM SelfServiceQuerybean group by employeeBean").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSelfServiceQuery;
	    
	}
	
	
	
	public List<SelfServiceQuerybean> getListOfSelfServiceQueryByEmployeeId(int employee_id){
	    List<SelfServiceQuerybean> listOfSelfServiceQuery = new ArrayList<SelfServiceQuerybean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSelfServiceQuery = session.createQuery("FROM SelfServiceQuerybean where employeeBean ='"+employee_id+"' order by selfservice_query_id desc").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSelfServiceQuery;
	    
	}
	
	/* Store Procedure For List Of Self Service Query By Employee Id*/
	public List<SelfServiceQuerybean> SPgetListOfSelfServiceQueryByEmployeeId(int employee_id){
	    List<SelfServiceQuerybean> listOfSelfServiceQuery = new ArrayList<SelfServiceQuerybean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        SQLQuery query = (SQLQuery) session.createSQLQuery("CALL listOfSelfServiceQueryByEmployeeId(:empId)")
                    .addEntity(SelfServiceQuerybean.class)
                    .setParameter("empId",employee_id);
			
	        listOfSelfServiceQuery = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSelfServiceQuery;
	    
	}
	
	public List<SelfServiceQuerybean> getListOfSelfServiceQueryById(int selfservice_query_id){
	    List<SelfServiceQuerybean> listOfSelfServiceQuery = new ArrayList<SelfServiceQuerybean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSelfServiceQuery = session.createQuery("FROM SelfServiceQuerybean where selfservice_query_id = '"+selfservice_query_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSelfServiceQuery;
	    
	}
	

	public List<MarqueeBean> getListOfMarquee(){
	    List<MarqueeBean> listOfMarquee = new ArrayList<MarqueeBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfMarquee = session.createQuery("FROM MarqueeBean order by marquee_id DESC").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfMarquee;
	    
	}
	public List<MarqueeBean> getListOfMarqueeById(int marquee_id){
	    List<MarqueeBean> listOfMarquee = new ArrayList<MarqueeBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfMarquee = session.createQuery("FROM MarqueeBean where marquee_id = '"+marquee_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfMarquee;
	    
	}
	
	
	
	
	
	
	public List<AnnouncementBean> getListOfAnnouncement() {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session.createQuery("FROM AnnouncementBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}
	
	
	public List<AnnouncementBean> SPgetListOfAnnouncement() {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL announcementList()")
                    .addEntity(AnnouncementBean.class);
			listOfAnnouncement = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementBean> getListOfAnnouncementEndDate(String date) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session
					.createQuery("FROM AnnouncementBean where announcement_enddate >= '" + date + "' ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}
	
	/*Store Procedure For Announcement End Date*/
	public List<AnnouncementBean> SPgetListOfAnnouncementEndDate(String date) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL announcementByEndDate(:date)")
                    .addEntity(AnnouncementBean.class)
                    .setParameter("date",date);
			listOfAnnouncement = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementBean> getListOfAnnouncementEndDatePast(String date) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session
					.createQuery("FROM AnnouncementBean where announcement_enddate <= '" + date + "' ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementBean> getListOfAnnouncementByDate(String date) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session.createQuery("FROM AnnouncementBean where announcement_submission_date = '"
					+ date + "' and announcement_enddate >= '" + date + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}
	
	/*Store Procedure For Announcement*/
	public List<AnnouncementBean> SPgetListOfAnnouncementByDate(String date) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL newAnnouncementByDate(:date)")
                    .addEntity(AnnouncementBean.class)
                    .setParameter("date",date);
			listOfAnnouncement = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementBean> getListOfAnnouncement(int announcement_id) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session
					.createQuery("FROM AnnouncementBean where announcement_id = '" + announcement_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;
	}

	public List<AnnouncementBean> getListOfAnnouncementDoneByMe(int employee_master_id) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session
					.createQuery("FROM AnnouncementBean where employee_master_id = '" + employee_master_id + "'")
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
		return listOfAnnouncement;
	}

	public List<RoleCategoryBean> getListOfAnnouncementCategory() {
		List<RoleCategoryBean> listOfAnnouncement = new ArrayList<RoleCategoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session.createQuery("FROM RoleCategoryBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	
	public List<AnnouncementCategoryBean> getListOfAnnouncementCategoryByRole(int announcement_id,
			String role_category_name) {
		List<AnnouncementCategoryBean> listOfAnnouncement = new ArrayList<AnnouncementCategoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session.createQuery("FROM AnnouncementCategoryBean where announcementBean = "
					+ announcement_id + " and roleCategoryBean.role_category_name = '" + role_category_name + "' ")
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
		return listOfAnnouncement;

	}
	
	/*Store Procedure For Announcement Category By Role*/
	public List<AnnouncementCategoryBean> SPgetListOfAnnouncementCategoryByRole(int announcement_id,String role_category_name) {
		List<AnnouncementCategoryBean> listOfAnnouncement = new ArrayList<AnnouncementCategoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL announcementCategoryByRole(:announcementId,:roleCategoryName)")
                    .addEntity(AnnouncementCategoryBean.class)
                    .setParameter("announcementId",announcement_id)
                    .setParameter("roleCategoryName",role_category_name);
			listOfAnnouncement = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementCategoryBean> getListOfAnnouncementCategoryDetail(int announcement_id) {
		List<AnnouncementCategoryBean> listOfAnnouncement = new ArrayList<AnnouncementCategoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session
					.createQuery("FROM AnnouncementCategoryBean where announcementBean = " + announcement_id + "")
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
		return listOfAnnouncement;

	}
	
	/*Store Procedure For Announcement Category*/
	public List<AnnouncementCategoryBean> SPgetListOfAnnouncementCategoryDetail(int announcement_id) {
		List<AnnouncementCategoryBean> listOfAnnouncement = new ArrayList<AnnouncementCategoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL announcementCategoryByAnnouncementId(:announcementId)")
                    .addEntity(AnnouncementCategoryBean.class)
                    .setParameter("announcementId",announcement_id);
			listOfAnnouncement = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementCategoryBean> getListOfAnnouncementCategoryByRoleId(int announcement_id,
			int role_category_id) {
		List<AnnouncementCategoryBean> listOfAnnouncement = new ArrayList<AnnouncementCategoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session.createQuery("FROM AnnouncementCategoryBean where announcementBean = "
					+ announcement_id + " and roleCategoryBean = '" + role_category_id + "' ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementDepartmentBean> getListOfAnnouncementDepartmentDetail(int announcement_id) {
		List<AnnouncementDepartmentBean> listOfAnnouncement = new ArrayList<AnnouncementDepartmentBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session
					.createQuery("FROM AnnouncementDepartmentBean where announcementBean = " + announcement_id + "")
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
		return listOfAnnouncement;

	}
	
	/*Store Procedure For Announcement Department Detail*/
	public List<AnnouncementDepartmentBean> SPgetListOfAnnouncementDepartmentDetail(int announcement_id) {
		List<AnnouncementDepartmentBean> listOfAnnouncement = new ArrayList<AnnouncementDepartmentBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL announcementDepartmentDetail(:announcementId)")
                    .addEntity(AnnouncementDepartmentBean.class)
                    .setParameter("announcementId",announcement_id);
			listOfAnnouncement = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementCompanyBean> getListOfAnnouncementCompanyDetail(int announcement_id) {
		List<AnnouncementCompanyBean> listOfAnnouncement = new ArrayList<AnnouncementCompanyBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session
					.createQuery("FROM AnnouncementCompanyBean where announcementBean = " + announcement_id + "")
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
		return listOfAnnouncement;

	}
	
	/*Store Procedure For Announcement Company Detail*/
	public List<AnnouncementCompanyBean> SPgetListOfAnnouncementCompanyDetail(int announcement_id) {
		List<AnnouncementCompanyBean> listOfAnnouncement = new ArrayList<AnnouncementCompanyBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL announcementCompanyDetail(:announcementId)")
                    .addEntity(AnnouncementCompanyBean.class)
                    .setParameter("announcementId",announcement_id);
			listOfAnnouncement = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<AnnouncementBean> getBetweenTime(String announcement_date, String toTime, String fromTime) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session.createQuery("FROM AnnouncementBean where announcement_date = '"
					+ announcement_date + "' and ((to_time between '" + fromTime + "' and '" + toTime
					+ "') or (from_time between '" + fromTime + "' and '" + toTime + "'))").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}
	
	
	public List<AnnouncementBean> getBetweenTimeForUpdate(String announcement_date, String toTime, String fromTime,int announcemet_id) {
		List<AnnouncementBean> listOfAnnouncement = new ArrayList<AnnouncementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAnnouncement = session.createQuery("FROM AnnouncementBean where announcement_id != '"+announcemet_id+"' and announcement_date = '"
					+ announcement_date + "' and ((to_time between '" + fromTime + "' and '" + toTime
					+ "') or (from_time between '" + fromTime + "' and '" + toTime + "'))").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAnnouncement;

	}

	public List<EmployeeBean> listOfEmployeeByCategory(String role_authority) {
		List<EmployeeBean> listOfEmployeeByCategory = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployeeByCategory = session
					.createQuery("FROM EmployeeBean where roleBean.role_authority = '" + role_authority + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployeeByCategory;
	}

	public List<EmployeeBean> listOfEmployeeByDepartment(int department_id) {
		List<EmployeeBean> listOfEmployeeByDepartment = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployeeByDepartment = session
					.createQuery("FROM EmployeeBean where departmentBean = '" + department_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployeeByDepartment;
	}

	public List<EmployeeBean> listOfEmployeeByCompany(int company_id) {
		List<EmployeeBean> listOfEmployeeByCompany = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployeeByCompany = session.createQuery("FROM EmployeeBean where companyListBean = '" + company_id + "'")
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
		return listOfEmployeeByCompany;
	}
	 public RoleCategoryBean getRoleByName(int role_category_id) {
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        RoleCategoryBean roleCategoryBean = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from RoleCategoryBean where role_category_id = "+role_category_id+"");
	            roleCategoryBean = (RoleCategoryBean)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return roleCategoryBean;
	    }
	 
	 
	 
	 public List<AnnouncementCategoryBean> getAnnouncementById(int announcement_id) {
			List<AnnouncementCategoryBean> listOfAnnouncementById = new ArrayList<AnnouncementCategoryBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfAnnouncementById = session.createQuery("FROM AnnouncementCategoryBean where announcement_id = "+announcement_id+"")
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
			return listOfAnnouncementById;
		}
	 
	 public List<ProblemNatureBean> getListOfProblem(){
		    List<ProblemNatureBean> listOfProblem = new ArrayList<ProblemNatureBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        listOfProblem = session.createQuery("FROM ProblemNatureBean order by problem_nature_name ASC").list();
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
		
		public List<ComplaintBean> getcomplaintByEmployeeId(int emp_id)
		{
		    List<ComplaintBean> listOfComp = new ArrayList<ComplaintBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ComplaintBean where employee_master_id = '"+emp_id+"'";
				 Query query = session.createQuery(hql);
				 listOfComp = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfComp;
		}
		
		public List<ComplaintBean> getcomplaintByComplaintId(int complaint_id)
		{
		    List<ComplaintBean> listOfComp = new ArrayList<ComplaintBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ComplaintBean where complaint_id = '"+complaint_id+"'";
				 Query query = session.createQuery(hql);
				 listOfComp = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfComp;
		}
		
		public List<ComplaintBean> getcomplaintList()
		{
		    List<ComplaintBean> listOfComp = new ArrayList<ComplaintBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ComplaintBean where status = 'pending'";
				 Query query = session.createQuery(hql);
				 listOfComp = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfComp;
		}
		
		public List<ComplaintBean> getcomplaintList1(int month_id)
		{
		    List<ComplaintBean> listOfComp = new ArrayList<ComplaintBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        
		        String hql = null;
		       
		        if(month_id <10){
		        	hql = "from ComplaintBean where status = 'completed' and date like '%-0"+month_id+"-%'";
		        }else{
		        	hql = "from ComplaintBean where status = 'completed' and date like '%-"+month_id+"-%'";
		        }
		        
		        
				 Query query = session.createQuery(hql);
				 listOfComp = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfComp;
		}

		public List<DownloadBean> getdownloadByEmployeeId(int emp_id)
		{
		    List<DownloadBean> listOfdownload = new ArrayList<DownloadBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from DownloadBean where employee_master_id = '"+emp_id+"'";
				 Query query = session.createQuery(hql);
				 listOfdownload = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfdownload;
		}

		public List<DownloadBean> getdownloadList()
		{
		    List<DownloadBean> listOfDown = new ArrayList<DownloadBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from DownloadBean where status = 'pending'";
				 Query query = session.createQuery(hql);
				 listOfDown = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfDown;
		}
		
		
		public List<DownloadBean> getdownloadList1()
		{
		    List<DownloadBean> listOfDown = new ArrayList<DownloadBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from DownloadBean where status = 'completed'";
				 Query query = session.createQuery(hql);
				 listOfDown = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfDown;
		}
		
		public List<DownloadBean> getdownloadByDownoadId(int download_id)
		{
		    List<DownloadBean> listOfDown = new ArrayList<DownloadBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from DownloadBean where download_id = '"+download_id+"'";
				 Query query = session.createQuery(hql);
				 listOfDown = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfDown;
		}
	
		
		public List<ProblemNatureBean> getListOfAllProblemNature(){
	        List<ProblemNatureBean> problemNatureList = new ArrayList<ProblemNatureBean>();
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;        
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            problemNatureList = session.createQuery("from ProblemNatureBean").list();                        
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return problemNatureList;
	    }
		
		
		public List<ProblemNatureReplyBean> getFullListOftype() {
	        List<ProblemNatureReplyBean> listOfProblemtype = new ArrayList<ProblemNatureReplyBean>();
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;        
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            listOfProblemtype = session.createQuery("from ProblemNatureReplyBean").list();                        
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return listOfProblemtype;
	    }
		
		
		public List<ComplaintVerifiedByBean> getComplaintVerifiedByPerson(int complaint_id)
		{
		    List<ComplaintVerifiedByBean> listOfDown = new ArrayList<ComplaintVerifiedByBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        String hql = "from ComplaintVerifiedByBean where complaint_id = '"+complaint_id+"'";
				 Query query = session.createQuery(hql);
				 listOfDown = query.list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfDown;
		}
		
		public SelfServiceQuerybean getLastAddedData(int employee_master_id) {
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        SelfServiceQuerybean selfServiceQuerybean = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
		        SQLQuery query = (SQLQuery) session.createSQLQuery("CALL lastAddedDocumentByEmpId(:empId)")
	                    .addEntity(SelfServiceQuerybean.class)
	                    .setParameter("empId",employee_master_id);
				
		        selfServiceQuerybean = (SelfServiceQuerybean) query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return selfServiceQuerybean;
	    }
		
		
		
}
