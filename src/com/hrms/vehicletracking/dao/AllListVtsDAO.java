package com.hrms.vehicletracking.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.MonthBean;
import com.hrms.timesheet.util.HibernateUtil;
import com.hrms.vehicletracking.bean.DriverBean;
import com.hrms.vehicletracking.bean.VehicleBean;
import com.hrms.vehicletracking.bean.VehicleDocumentAttachmentBean;
import com.hrms.vehicletracking.bean.VehicleDocumentBean;
import com.hrms.vehicletracking.bean.VehiclePolicyDocumentBean;
import com.hrms.vehicletracking.bean.VehicleServiceRecordBean;
import com.hrms.vehicletracking.bean.VehicleTrackingBean;
import com.hrms.vehicletracking.bean.VehicleTypeBean;

public class AllListVtsDAO {

	public AllListVtsDAO() {
	}		
		// TODO Auto-generated constructor stub
		public List<VehicleTypeBean> getListOfVehicleType() {
			List<VehicleTypeBean> listOfVehicleType = new ArrayList<VehicleTypeBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfVehicleType = session.createQuery("FROM VehicleTypeBean").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfVehicleType;

		}

		
		public List<VehicleBean> getListOfVehicles() {
			List<VehicleBean> listOfVehicleType = new ArrayList<VehicleBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfVehicleType = session.createQuery("FROM VehicleBean").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfVehicleType;

		}
		
		public List<VehicleServiceRecordBean> getListOfVehicleService() {
			List<VehicleServiceRecordBean> listOfVehicleType = new ArrayList<VehicleServiceRecordBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfVehicleType = session.createQuery("FROM VehicleServiceRecordBean").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfVehicleType;

		}
		
		public List<VehicleServiceRecordBean> getListOfVehicleServiceCurrentMonth() {
			List<VehicleServiceRecordBean> listOfVehicleType = new ArrayList<VehicleServiceRecordBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfVehicleType = session.createQuery("FROM VehicleServiceRecordBean where MONTH(record_date) = MONTH(now())").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfVehicleType;

		}
		
		public List<DriverBean> getListOfDriver() {
			List<DriverBean> listOfDriver = new ArrayList<DriverBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfDriver = session.createQuery("FROM DriverBean").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfDriver;

		}

		public List<VehicleTrackingBean> getListOfVehiclesTracking() {
			List<VehicleTrackingBean> listOfVehicleTracking = new ArrayList<VehicleTrackingBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfVehicleTracking = session.createQuery("FROM VehicleTrackingBean").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfVehicleTracking;

		}

		public List<VehicleTrackingBean> getListOfVehiclesTrackingEndReadingZero() {
			List<VehicleTrackingBean> listOfVehicleTracking = new ArrayList<VehicleTrackingBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfVehicleTracking = session.createQuery("FROM VehicleTrackingBean where end_reading = 0").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfVehicleTracking;

		}
		
		public List<VehicleTrackingBean> getVehicleAverageGraph(int vehicle_graph_id,int month_id) {
			List<VehicleTrackingBean> listOfVehicleTracking = new ArrayList<VehicleTrackingBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfVehicleTracking = session.createQuery("FROM VehicleTrackingBean where vehicleBean = '"+vehicle_graph_id+"' and MONTH(date) = '"+month_id+"'").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfVehicleTracking;

		}
		
		
		//List Method for getting vehicle details from vehicle_tracking_tbl by vehicle_tracking_id
		public VehicleTrackingBean getVehicleTrackingById(int vehicle_id) {
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        VehicleTrackingBean vehicleTrackingBean = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from VehicleTrackingBean where vehicle_tracking_id ="+vehicle_id+"");
	            vehicleTrackingBean = (VehicleTrackingBean)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return vehicleTrackingBean;
	    }
		
		//List Method for getting vehicle details from vehicle_service_record_tbl by vehicle_Service_id
				public VehicleServiceRecordBean getVehicleServiceRecordById(int vehicle_id) {
			        Session session = HibernateUtil.openSession();
			        Transaction tx = null;
			        VehicleServiceRecordBean vehicleServiceRecordBean = null;
			        try {
			            tx = session.getTransaction();
			            tx.begin();
			            Query query = session.createQuery("from VehicleServiceRecordBean where vehicle_service_record_id ="+vehicle_id+"");
			            vehicleServiceRecordBean = (VehicleServiceRecordBean)query.uniqueResult();
			            tx.commit();
			        } catch (Exception e) {
			            if (tx != null) {
			                tx.rollback();
			            }
			            e.printStackTrace();
			        } finally {
			            session.close();
			        }
			        return vehicleServiceRecordBean;
			    }
		
	
		public List<VehicleServiceRecordBean> getListOfVehicleServiceFilter(String fromDate, String toDate,
				String vehicleNo, String driver, int count) {
			String v1 = null;
			String v2 = null;
			String v3 = null;
			String v4 = null;

			String c1 = null;
			String c2 = null;
			String c3 = null;
			String c4 = null;

			if (!fromDate.equalsIgnoreCase("")) {
				c1 = "record_date";
				v1 = fromDate;
			}

			if (!toDate.equalsIgnoreCase("")) {
				if (c1 == null) {
					c1 = "record_date";
					v1 = toDate;
				} else {
					c2 = "record_date";
					v2 = toDate;
				}
			}

			if (!vehicleNo.equalsIgnoreCase("0")) {
				if (c1 == null) {
					c1 = "vehicleBean";
					v1 = vehicleNo;
				} else if (c2 == null) {
					c2 = "vehicleBean";
					v2 = vehicleNo;
				} else {
					c3 = "vehicleBean";
					v3 = vehicleNo;
				}
			}

			if (!driver.equalsIgnoreCase("0")) {
				if (c1 == null) {
					c1 = "driverBean";
					v1 = driver;
				} else if (c2 == null) {
					c2 = "driverBean";
					v2 = driver;
				} else if (c3 == null) {
					c3 = "driverBean";
					v3 = driver;
				} else {
					c4 = "driverBean";
					v4 = driver;
				}
			}


			List<VehicleServiceRecordBean> listOfHistory = new ArrayList<VehicleServiceRecordBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();

				if (c1.equals("record_date")) {

					if (count == 2) {
						listOfHistory = session
								.createQuery("FROM VehicleServiceRecordBean where " + c1 + " between '" + v1 + "' and  '" + v2 + "' order by record_date ASC")
								.list();
					} else if (count == 3) {
						listOfHistory = session.createQuery("FROM VehicleServiceRecordBean where (" + c1 + " between '" + v1
								+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "' order by record_date ASC").list();
					} else if (count == 4) {
						listOfHistory = session.createQuery("FROM VehicleServiceRecordBean where (" + c1 + " between '" + v1
								+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "' order by record_date ASC").list();
					} 

				} else {
					if (count == 1) {
						listOfHistory = session.createQuery("FROM VehicleServiceRecordBean where " + c1 + " = '" + v1 + "' order by record_date ASC")
								.list();
					} else if (count == 2) {
						listOfHistory = session.createQuery(
								"FROM VehicleServiceRecordBean where " + c1 + " = '" + v1 + "' and " + c2 + " = '" + v2 + "' order by record_date ASC")
								.list();
					} else if (count == 3) {
						listOfHistory = session.createQuery("FROM VehicleServiceRecordBean where " + c1 + " = '" + v1 + "' and "
								+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' order by record_date ASC").list();
					} else if (count == 4) {
						listOfHistory = session.createQuery("FROM VehicleServiceRecordBean where " + c1 + " = '" + v1 + "' and "
								+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "' order by record_date ASC")
								.list();
					} 
				}

				System.out.println(listOfHistory.size());
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfHistory;

		}
		
		
		public List<VehicleTrackingBean> getListOfVehicleFilter(String fromDate, String toDate,
				String vehicleNo, String driver, int count) {
			String v1 = null;
			String v2 = null;
			String v3 = null;
			String v4 = null;

			String c1 = null;
			String c2 = null;
			String c3 = null;
			String c4 = null;

			if (!fromDate.equalsIgnoreCase("")) {
				c1 = "date";
				v1 = fromDate;
			}

			if (!toDate.equalsIgnoreCase("")) {
				if (c1 == null) {
					c1 = "date";
					v1 = toDate;
				} else {
					c2 = "date";
					v2 = toDate;
				}
			}

			if (!vehicleNo.equalsIgnoreCase("0")) {
				if (c1 == null) {
					c1 = "vehicleBean";
					v1 = vehicleNo;
				} else if (c2 == null) {
					c2 = "vehicleBean";
					v2 = vehicleNo;
				} else {
					c3 = "vehicleBean";
					v3 = vehicleNo;
				}
			}

			if (!driver.equalsIgnoreCase("0")) {
				if (c1 == null) {
					c1 = "driverBean";
					v1 = driver;
				} else if (c2 == null) {
					c2 = "driverBean";
					v2 = driver;
				} else if (c3 == null) {
					c3 = "driverBean";
					v3 = driver;
				} else {
					c4 = "driverBean";
					v4 = driver;
				}
			}


			List<VehicleTrackingBean> listOfHistory = new ArrayList<VehicleTrackingBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();

				if (c1.equals("date")) {

					if (count == 2) {
						listOfHistory = session
								.createQuery("FROM VehicleTrackingBean where " + c1 + " between '" + v1 + "' and  '" + v2 + "' order by date ASC")
								.list();
					} else if (count == 3) {
						listOfHistory = session.createQuery("FROM VehicleTrackingBean where (" + c1 + " between '" + v1
								+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "' order by date ASC").list();
					} else if (count == 4) {
						listOfHistory = session.createQuery("FROM VehicleTrackingBean where (" + c1 + " between '" + v1
								+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "' order by date ASC").list();
					} 

				} else {
					if (count == 1) {
						listOfHistory = session.createQuery("FROM VehicleTrackingBean where " + c1 + " = '" + v1 + "' order by date ASC")
								.list();
					} else if (count == 2) {
						listOfHistory = session.createQuery(
								"FROM VehicleTrackingBean where " + c1 + " = '" + v1 + "' and " + c2 + " = '" + v2 + "' order by date ASC")
								.list();
					} else if (count == 3) {
						listOfHistory = session.createQuery("FROM VehicleTrackingBean where " + c1 + " = '" + v1 + "' and "
								+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' order by date ASC").list();
					} else if (count == 4) {
						listOfHistory = session.createQuery("FROM VehicleTrackingBean where " + c1 + " = '" + v1 + "' and "
								+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "' order by date ASC")
								.list();
					} 
				}

				System.out.println(listOfHistory.size());
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfHistory;

		}
		
		public List<VehiclePolicyDocumentBean> getListOfDocuments() {
			List<VehiclePolicyDocumentBean> listOfDocuments = new ArrayList<VehiclePolicyDocumentBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfDocuments = session.createQuery("FROM VehiclePolicyDocumentBean").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfDocuments;

		}
		public List<VehiclePolicyDocumentBean> getListOfDocumentsPolicyNull() {
			List<VehiclePolicyDocumentBean> listOfDocuments = new ArrayList<VehiclePolicyDocumentBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfDocuments = session.createQuery("FROM VehiclePolicyDocumentBean where attachment = '-'").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfDocuments;

		}
		
		public List<VehiclePolicyDocumentBean> getListOfDocumentsById(int vehicle_master_id) {
			List<VehiclePolicyDocumentBean> listOfDocuments = new ArrayList<VehiclePolicyDocumentBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfDocuments = session.createQuery("FROM VehiclePolicyDocumentBean where vehicleBean = "+vehicle_master_id+"").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfDocuments;

		}
		public List<VehicleDocumentBean> getListOfVehicleDocuments() {
			List<VehicleDocumentBean> listOfDocuments = new ArrayList<VehicleDocumentBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfDocuments = session.createQuery("FROM VehicleDocumentBean").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfDocuments;

		}
		
		public List<VehicleDocumentBean> getListOfVehicleDocumentsById(int vehicle_master_id) {
			List<VehicleDocumentBean> listOfDocuments = new ArrayList<VehicleDocumentBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfDocuments = session.createQuery("FROM VehicleDocumentBean where vehicleBean = "+vehicle_master_id+"").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfDocuments;

		}
		
	
		public List<VehicleDocumentAttachmentBean> getListOfVehicleDocumentAttachments(int vehicle_document_id) {
			List<VehicleDocumentAttachmentBean> listOfDocuments = new ArrayList<VehicleDocumentAttachmentBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				listOfDocuments = session.createQuery("FROM VehicleDocumentAttachmentBean where vehicleDocumentBean = "+vehicle_document_id+"").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfDocuments;

		}
		
		//List Method for getting vehicle details from vehicle_tracking_tbl by vehicle_tracking_id
				public VehiclePolicyDocumentBean getVehiclePolicyDocumentById(int vehicle_policy_document_id) {
			        Session session = HibernateUtil.openSession();
			        Transaction tx = null;
			        VehiclePolicyDocumentBean vehiclePolicyDocumentBean = null;
			        try {
			            tx = session.getTransaction();
			            tx.begin();
			            Query query = session.createQuery("from VehiclePolicyDocumentBean where vehicle_policy_document_id ="+vehicle_policy_document_id+"");
			            vehiclePolicyDocumentBean = (VehiclePolicyDocumentBean)query.uniqueResult();
			            tx.commit();
			        } catch (Exception e) {
			            if (tx != null) {
			                tx.rollback();
			            }
			            e.printStackTrace();
			        } finally {
			            session.close();
			        }
			        return vehiclePolicyDocumentBean;
			    }
			
		
	
	}


