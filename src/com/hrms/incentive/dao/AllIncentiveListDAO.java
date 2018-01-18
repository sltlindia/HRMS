package com.hrms.incentive.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.AksharNewBean;
import com.hrms.incentive.bean.AksharNewHistoryBean;
import com.hrms.incentive.bean.AksharRepeatBean;
import com.hrms.incentive.bean.AksharRepeatHistoryBean;
import com.hrms.incentive.bean.AmountHistoryBean;
import com.hrms.incentive.bean.BrahmastraNewBean;
import com.hrms.incentive.bean.BrahmastraNewHistoryBean;
import com.hrms.incentive.bean.BrahmastraRepeatBean;
import com.hrms.incentive.bean.BrahmastraRepeatHistoryBean;
import com.hrms.incentive.bean.ClassificationBean;
import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.incentive.bean.IncentiveCriteriaBean;
import com.hrms.incentive.bean.IncentiveCriteriaHistoryBean;
import com.hrms.incentive.bean.IncentiveDesignationBean;
import com.hrms.incentive.bean.IncentiveSalesPersonListBean;
import com.hrms.incentive.bean.LaserMasterBean;
import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.incentive.bean.TargetBean;
import com.hrms.incentive.bean.ZoneBean;
import com.hrms.lms.util.HibernateUtil;
import com.hrms.pms.bean.TaskRemarkBean;
import com.hrms.pms.bean.YearBean;

public class AllIncentiveListDAO {

	public List<SalespersonBean> getnameOfsales() {
		List<SalespersonBean> listOfSales = new ArrayList<SalespersonBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SalespersonBean";
			Query query = session.createQuery(hql);
			listOfSales = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSales;

	}

	public List<ZoneBean> getnameOfzone() {
		List<ZoneBean> listOfZone = new ArrayList<ZoneBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ZoneBean";
			Query query = session.createQuery(hql);
			listOfZone = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfZone;

	}

	public List<ProductMasterBean> getnameOfproduct() {
		List<ProductMasterBean> listOfproduct = new ArrayList<ProductMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProductMasterBean";
			Query query = session.createQuery(hql);
			listOfproduct = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfproduct;

	}

	public List<ClassificationBean> getnameOfclassification() {
		List<ClassificationBean> listOfclassification = new ArrayList<ClassificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ClassificationBean";
			Query query = session.createQuery(hql);
			listOfclassification = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfclassification;

	}

	public List<LaserMasterBean> getListOfLaser() {
		List<LaserMasterBean> listOfLaser = new ArrayList<LaserMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from LaserMasterBean";
			Query query = session.createQuery(hql);
			listOfLaser = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLaser;

	}

	public List<TargetBean> getListOfTarget() {
		List<TargetBean> listOfTarget = new ArrayList<TargetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TargetBean";
			Query query = session.createQuery(hql);
			listOfTarget = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTarget;

	}

	public List<TargetBean> getListOfTargetByYearId(int year_id) {
		List<TargetBean> listOfTarget = new ArrayList<TargetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TargetBean where yearBean = '" + year_id + "'";
			Query query = session.createQuery(hql);
			listOfTarget = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTarget;

	}
	
	public List<TargetBean> getListOfTargetByYearId(int year_id,int month_id) {
		List<TargetBean> listOfTarget = new ArrayList<TargetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TargetBean where yearBean = '" + year_id + "' and monthBean = '"+month_id+"'";
			Query query = session.createQuery(hql);
			listOfTarget = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTarget;

	}
	
	
	
	public List<TargetBean> getListOfTargetByYearIdGroup(int year_id) {
		List<TargetBean> listOfTarget = new ArrayList<TargetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TargetBean where yearBean = '" + year_id + "' group by salespersonBean";
			Query query = session.createQuery(hql);
			listOfTarget = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTarget;

	}


	public SalespersonBean getListOfPerson(int sales_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		SalespersonBean salespersonBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from SalespersonBean where sales_person_id='" + sales_id + "'");
			salespersonBean = (SalespersonBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salespersonBean;
	}

	public ProductMasterBean getListOfProduct(int product_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProductMasterBean productMasterBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProductMasterBean where product_master_id='" + product_id + "'");
			productMasterBean = (ProductMasterBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return productMasterBean;
	}

	public AksharNewBean getDetailOfNewAkshar(double discount) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AksharNewBean aksharNewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			
			Query query = null;
			
			if(discount == 0) {
				 query = session.createQuery("from AksharNewBean where discount_to <= '" + discount + "' and '"
						+ discount + "' <= discount_from");;
			}else {
				 query = session.createQuery("from AksharNewBean where discount_to < '" + discount + "' and '"
						+ discount + "' <= discount_from");
			}
			
			
			aksharNewBean = (AksharNewBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return aksharNewBean;
	}

	public BrahmastraNewBean getDetailOfNewBrahmastra(double discount) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		BrahmastraNewBean brahmastraNewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			
			
			
			if(discount == 0) {
				query = session.createQuery("from BrahmastraNewBean where discount_to <= '" + discount + "' and '"
						+ discount + "' <= discount_from");
			}else {
				query = session.createQuery("from BrahmastraNewBean where discount_to < '" + discount + "' and '"
						+ discount + "' <= discount_from");
			}
			 
			brahmastraNewBean = (BrahmastraNewBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return brahmastraNewBean;
	}

	public BrahmastraRepeatBean getDetailOfRepeatBrahmastra(double discount) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		BrahmastraRepeatBean brahmastraRepeatBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			
			Query query  = null;
			
			if(discount == 0) {
				 query = session.createQuery("from BrahmastraRepeatBean where discount_to <= '" + discount + "' and '"
						+ discount + "' <= discount_from");
			}else {
				 query = session.createQuery("from BrahmastraRepeatBean where discount_to < '" + discount + "' and '"
						+ discount + "' <= discount_from");
			}
			
			brahmastraRepeatBean = (BrahmastraRepeatBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return brahmastraRepeatBean;
	}

	public AksharRepeatBean getDetailOfrepeatAkshar(double discount) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AksharRepeatBean aksharRepeatBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			
			Query query = null;
			
			if(discount == 0) {
				 query = session.createQuery("from AksharRepeatBean where discount_to <= '" + discount + "' and '"
						+ discount + "' <= discount_from");
			}else {
				 query = session.createQuery("from AksharRepeatBean where discount_to < '" + discount + "' and '"
						+ discount + "' <= discount_from");
			}
			
			
			
			aksharRepeatBean = (AksharRepeatBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return aksharRepeatBean;
	}

	public IncentiveBean getListOfIncentiveById(int incentive_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		IncentiveBean incentiveBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from IncentiveBean where incentive_id = '" + incentive_id + "'");
			incentiveBean = (IncentiveBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return incentiveBean;
	}

	public List<IncentiveBean> getListOfAllIncentive(int year_id) {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveBean where yearBean = '"+year_id+"'";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	public List<IncentiveBean> getListOfAllIncentive() {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveBean order by incentive_id DESC";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}

	public List<IncentiveBean> getListOfIncentiveByYearId(String year) {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveBean where YEAR(sjo_date)='" + year + "'";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {					
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	
	public List<IncentiveBean> getListOfIncentiveByYearId(String year,int fromMont,int toMonth) {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveBean where YEAR(sjo_date)='" + year + "' and (MONTH(sjo_date) between "+fromMont+" and "+toMonth+")";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {					
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	
	public List<IncentiveBean> getListOfIncentiveByCustomerCode(String customerCode) {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveBean where customer_code = '"+customerCode+"'";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {					
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	public List<IncentiveBean> getListOfIncentiveByYearId(int year_id) {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveBean where yearBean =  '" + year_id + "'";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}

	public List<IncentiveBean> getListOfIncentiveBySalesId(int sales_id, int month_id, int year_id, int product_id) {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			
			
			
			/*if(month_id<10){
			hql = "from IncentiveBean where salespersonBean = '" + sales_id + "' and po_date like '%-0"
					+ month_id + "-%'  and po_date like '" + year_id + "%' and productMasterBean = '" + product_id
					+ "'";
			}else{
				hql = "from IncentiveBean where salespersonBean = '" + sales_id + "' and po_date like '%-"
						+ month_id + "-%'  and po_date like '" + year_id + "%' and productMasterBean = '" + product_id
						+ "'";
			}*/
			
			
			
			if(month_id<10){
				hql = "from IncentiveBean where salespersonBean = '" + sales_id + "' and sjo_date like '%-0"
						+ month_id + "-%'  and po_date like '" + year_id + "%' and productMasterBean = '" + product_id
						+ "'";
				}else{
					hql = "from IncentiveBean where salespersonBean = '" + sales_id + "' and sjo_date like '%-"
							+ month_id + "-%'  and sjo_date like '" + year_id + "%' and productMasterBean = '" + product_id
							+ "'";
				}
			
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	public List<IncentiveSalesPersonListBean> getListOfIncentiveBySalesIdForHigherDesignation(int sales_id, int month_id, int year_id, int product_id) {
		List<IncentiveSalesPersonListBean> listOfAllIncentive = new ArrayList<IncentiveSalesPersonListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			
			
			/*if(month_id<10){
			hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.po_date like '%-0"
					+ month_id + "-%'  and incentiveBean.po_date like '" + year_id + "%' and incentiveBean.productMasterBean = '" + product_id
					+ "' and salespersonBean != incentiveBean.salespersonBean";
			}else{
				hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.po_date like '%-"
						+ month_id + "-%'  and incentiveBean.po_date like '" + year_id + "%' and incentiveBean.productMasterBean = '" + product_id
						+ "' and salespersonBean != incentiveBean.salespersonBean";
			}*/
			
			
			
			if(month_id<10){
				hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.sjo_date like '%-0"
						+ month_id + "-%'  and incentiveBean.sjo_date like '" + year_id + "%' and incentiveBean.productMasterBean = '" + product_id
						+ "' and salespersonBean != incentiveBean.salespersonBean";
				}else{
					hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.sjo_date like '%-"
							+ month_id + "-%'  and incentiveBean.sjo_date like '" + year_id + "%' and incentiveBean.productMasterBean = '" + product_id
							+ "' and salespersonBean != incentiveBean.salespersonBean";
				}
			
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	public List<IncentiveSalesPersonListBean> getListOfAllIncentiveBySalespersonList(int year_id) {
		List<IncentiveSalesPersonListBean> listOfAllIncentive = new ArrayList<IncentiveSalesPersonListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			
			hql = "from IncentiveSalesPersonListBean where incentiveBean.yearBean = '" + year_id + "'";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	public List<IncentiveSalesPersonListBean> getListOfAllIncentiveBySalespersonListBetweenMonth(String year,int fromMont,int toMonth) {
		List<IncentiveSalesPersonListBean> listOfAllIncentive = new ArrayList<IncentiveSalesPersonListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			
			hql = "from IncentiveSalesPersonListBean where YEAR(incentiveBean.sjo_date)='" + year + "' and (MONTH(incentiveBean.sjo_date) between "+fromMont+" and "+toMonth+")";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	
	public List<IncentiveSalesPersonListBean> getListOfAllIncentiveBySalespersonListByCustomerCode(String customerCode) {
		List<IncentiveSalesPersonListBean> listOfAllIncentive = new ArrayList<IncentiveSalesPersonListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			
			hql = "from IncentiveSalesPersonListBean where incentiveBean.customer_code = '"+customerCode+"'";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	public List<IncentiveSalesPersonListBean> getListOfAllIncentiveBySalespersonIdList(int sales_id,int month_id,int year,int product_id) {
		List<IncentiveSalesPersonListBean> listOfAllIncentive = new ArrayList<IncentiveSalesPersonListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			
			/*if(month_id<10){
				hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.po_date like '%-0"
						+ month_id + "-%'  and incentiveBean.po_date like '" + year + "%' and incentiveBean.productMasterBean = '" + product_id
						+ "'";
				}else{
					hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.po_date like '%-"
							+ month_id + "-%'  and incentiveBean.po_date like '" + year + "%' and incentiveBean.productMasterBean = '" + product_id
							+ "'";
				}*/
			
			
			if(month_id<10){
				hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.sjo_date like '%-0"
						+ month_id + "-%'  and incentiveBean.sjo_date like '" + year + "%' and incentiveBean.productMasterBean = '" + product_id
						+ "'";
				}else{
					hql = "from IncentiveSalesPersonListBean isplb where salespersonBean = '" + sales_id + "' and incentiveBean.sjo_date like '%-"
							+ month_id + "-%'  and incentiveBean.sjo_date like '" + year + "%' and incentiveBean.productMasterBean = '" + product_id
							+ "'";
				}
			
			
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	

	
	
	public List<IncentiveBean> getListOfIncentiveBySalesIdAndYearId(int sales_id,int year_id) {
		List<IncentiveBean> listOfAllIncentive = new ArrayList<IncentiveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;
			
			hql = "from IncentiveBean where salespersonBean = '" + sales_id + "'and po_date like '" + year_id + "%' ";
			Query query = session.createQuery(hql);
			listOfAllIncentive = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllIncentive;

	}
	
	
	public IncentiveCriteriaBean getListOfIncentiveByCriteria(double percentage) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		IncentiveCriteriaBean incentiveCriteriaBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if (percentage > 100) {
				query = session.createQuery(
						"from IncentiveCriteriaBean where target_to <'" + percentage + "' and target_to = 100.01");
			}
			else {
				query = session.createQuery("from IncentiveCriteriaBean where target_to<='" + percentage + "' and '"
						+ percentage + "' < target_from");
			}
			incentiveCriteriaBean = (IncentiveCriteriaBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return incentiveCriteriaBean;
	}

	public TargetBean getListOfTargetById(int target_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TargetBean targetBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from TargetBean where sales_target_id='" + target_id + "'");
			targetBean = (TargetBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return targetBean;
	}

	public List<AksharNewBean> getListOfAksharNew() {
		List<AksharNewBean> listOfNewAkshar = new ArrayList<AksharNewBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AksharNewBean";
			Query query = session.createQuery(hql);
			listOfNewAkshar = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfNewAkshar;

	}

	public List<AksharRepeatBean> getListOfAksharRepeat() {
		List<AksharRepeatBean> listOfRepeatAkshar = new ArrayList<AksharRepeatBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AksharRepeatBean";
			Query query = session.createQuery(hql);
			listOfRepeatAkshar = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRepeatAkshar;

	}

	public List<BrahmastraNewBean> getListOfBarahmashtraNew() {
		List<BrahmastraNewBean> listOfNewBrahmastra = new ArrayList<BrahmastraNewBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from BrahmastraNewBean";
			Query query = session.createQuery(hql);
			listOfNewBrahmastra = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfNewBrahmastra;

	}

	public List<BrahmastraRepeatBean> getListOfBarahmashtraRepeat() {
		List<BrahmastraRepeatBean> listOfRepeatBrahmastra = new ArrayList<BrahmastraRepeatBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from BrahmastraRepeatBean";
			Query query = session.createQuery(hql);
			listOfRepeatBrahmastra = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRepeatBrahmastra;

	}

	public List<ProductMasterBean> getListOfProduct1() {
		List<ProductMasterBean> listOfProd = new ArrayList<ProductMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProductMasterBean";
			Query query = session.createQuery(hql);
			listOfProd = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfProd;
	}

	public List<SalespersonBean> getListOfSalesPerson() {
		List<SalespersonBean> listOfSalesPerson = new ArrayList<SalespersonBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SalespersonBean";
			Query query = session.createQuery(hql);
			listOfSalesPerson = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSalesPerson;
	}

	public List<ClassificationBean> getListOfClassification() {
		List<ClassificationBean> listOfClassification = new ArrayList<ClassificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ClassificationBean";
			Query query = session.createQuery(hql);
			listOfClassification = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfClassification;
	}

	public List<IncentiveCriteriaBean> getListOfIncentiveCriteria() {
		List<IncentiveCriteriaBean> listOfIncentiveCriteria = new ArrayList<IncentiveCriteriaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveCriteriaBean";
			Query query = session.createQuery(hql);
			listOfIncentiveCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfIncentiveCriteria;
	}

	public List<AmountHistoryBean> getListOfAccountHostory(int incentive_id) {
		List<AmountHistoryBean> listOfIncentiveCriteria = new ArrayList<AmountHistoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AmountHistoryBean where incentiveBean = '" + incentive_id + "'";
			Query query = session.createQuery(hql);
			listOfIncentiveCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfIncentiveCriteria;
	}

	public AksharNewBean getDetailOfNewAksharById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AksharNewBean aksharNewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from AksharNewBean where akshar_new_id = '" + id + "' ");
			aksharNewBean = (AksharNewBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return aksharNewBean;
	}

	public AksharRepeatBean getDetailOfRepeatAksharById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AksharRepeatBean aksharRepeatBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from AksharRepeatBean where akshar_repeat_id = '" + id + "' ");
			aksharRepeatBean = (AksharRepeatBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return aksharRepeatBean;
	}

	public BrahmastraNewBean getDetailOfNewBrahmastraById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		BrahmastraNewBean brahmastraNewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BrahmastraNewBean where brahmastra_new_id = '" + id + "' ");
			brahmastraNewBean = (BrahmastraNewBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return brahmastraNewBean;
	}

	public BrahmastraRepeatBean getDetailOfrepeatBrahmashtraById(double id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		BrahmastraRepeatBean brahmastraRepeatBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BrahmastraRepeatBean where brahmastra_repeat_id = '" + id + "' ");
			brahmastraRepeatBean = (BrahmastraRepeatBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return brahmastraRepeatBean;
	}

	public IncentiveCriteriaBean getDetailOfIncentiveCriteriaById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		IncentiveCriteriaBean incentiveCriteriaBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from IncentiveCriteriaBean where incentive_criteria_id  =  '" + id + "' ");
			incentiveCriteriaBean = (IncentiveCriteriaBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return incentiveCriteriaBean;
	}

	public List<AksharNewHistoryBean> getDetailOfNewAksharHistoryById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<AksharNewHistoryBean> listOfAksharNewHistory = new ArrayList<AksharNewHistoryBean>();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from AksharNewHistoryBean where aksharNewBean = '" + id
					+ "' order by  akshar_new_history_id desc");
			listOfAksharNewHistory = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAksharNewHistory;
	}

	public List<BrahmastraNewHistoryBean> getDetailOfNewBrahmastraHistoryById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<BrahmastraNewHistoryBean> listOfBrahmastraNewHistory = new ArrayList<BrahmastraNewHistoryBean>();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BrahmastraNewHistoryBean where brahmastraNewBean = '" + id
					+ "' order by  brahmastra_new_history_id desc");
			listOfBrahmastraNewHistory = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfBrahmastraNewHistory;
	}

	public List<AksharRepeatHistoryBean> getDetailOfRepeatAksharHistoryById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<AksharRepeatHistoryBean> listOfAksharRepeatHistory = new ArrayList<AksharRepeatHistoryBean>();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from AksharRepeatHistoryBean where aksharRepeatBean = '" + id
					+ "' order by  akshar_repeat_history_id desc");
			listOfAksharRepeatHistory = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAksharRepeatHistory;
	}

	public List<BrahmastraRepeatHistoryBean> getDetailOfRepeatBrahmastraRepeatById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<BrahmastraRepeatHistoryBean> listOfBrahmastraRepeatHistory = new ArrayList<BrahmastraRepeatHistoryBean>();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from BrahmastraRepeatHistoryBean where brahmastraRepeatBean = '" + id
					+ "' order by  brahmastra_repeat_history_id desc");
			listOfBrahmastraRepeatHistory = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfBrahmastraRepeatHistory;
	}

	public List<IncentiveCriteriaHistoryBean> getDetailOfIncentiveCriteriaHistoryById(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<IncentiveCriteriaHistoryBean> listOfIncentiveCriteriaHistory = new ArrayList<IncentiveCriteriaHistoryBean>();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from IncentiveCriteriaHistoryBean where incentiveCriteriaBean = '" + id
					+ "' order by  incentive_criteria_history_id desc");
			listOfIncentiveCriteriaHistory = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfIncentiveCriteriaHistory;
	}

	
	//List Of All Designation
	public List<IncentiveDesignationBean> getnameOfDesignation() {
		List<IncentiveDesignationBean> listOfSales = new ArrayList<IncentiveDesignationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveDesignationBean";
			Query query = session.createQuery(hql);
			listOfSales = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSales;
	}
	
		//List Of All Incentive Sales Person List
		public List<IncentiveSalesPersonListBean> getNameOfIncentiveList(int id) {
			List<IncentiveSalesPersonListBean> listOfSalesPerson = new ArrayList<IncentiveSalesPersonListBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				String hql = "from IncentiveSalesPersonListBean where incentiveBean = '"+id+"'";
				Query query = session.createQuery(hql);
				listOfSalesPerson = query.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfSalesPerson;
		}
		
		// Incentive Sales Person OF SE/SSE
		
		public List<IncentiveSalesPersonListBean> getIncentiveByDesgnation(int id,String designation) {
			List<IncentiveSalesPersonListBean> listOfSalesPerson = new ArrayList<IncentiveSalesPersonListBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				String hql = "from IncentiveSalesPersonListBean where incentiveBean = '"+id+"' and designation='"+designation+"'";
				Query query = session.createQuery(hql);
				listOfSalesPerson = query.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfSalesPerson;
		}
		
		
		
		
		
		public YearBean getyearByYearId(int year_id) {
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			YearBean yearBean = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from YearBean where year_id='" + year_id + "'");
				yearBean = (YearBean) query.uniqueResult();
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
	
		
		
		
		public String getCountOfTargetBySalesIdAndYear(int salesId, int year_id) {
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			String sum = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createQuery("select sum(target_value) from TargetBean  where salespersonBean='"
								+ salesId + "' and yearBean ='"+year_id+"' ");
				sum = (String) query.uniqueResult();
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
		
		
		public String getCountOfTargetBySalesIdAndYearAndProductId(int salesId, int year,int product_id,int month_id) {
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			String sum = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createQuery("select sum(target_value) from TargetBean where salespersonBean='"
								+ salesId + "' and yearBean.year ='"+year+"' and monthBean = '"+month_id+"' and productMasterBean = '"+product_id+"'");
				sum = (String) query.uniqueResult();
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
		
		
		public List<TargetBean> getTargetBySalesIdAndYear(int salesId, int year_id) {
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			List<TargetBean> listOfTargetByMonth = new ArrayList<TargetBean>();
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createQuery("From TargetBean  where salespersonBean='"
								+ salesId + "' and yearBean ='"+year_id+"' ");
				listOfTargetByMonth = query.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfTargetByMonth;
		}
		

}
