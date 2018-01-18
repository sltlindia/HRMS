package com.hrms.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.lms.bean.GatePassAuthorityBean;
import com.hrms.lms.bean.GatePassBean;
import com.hrms.lms.bean.IntervieweeBean;
import com.hrms.lms.bean.LeaveAdjustBalanceBean;
import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeaveBalanceYearWiseBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveCancelRequestBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.bean.LeaveTypeBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.bean.NopunchBean;
import com.hrms.lms.util.HibernateUtil;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.timesheet.bean.HolidayBean;

public class AllLMSListDAO {

	@SuppressWarnings("unchecked")
	public List<LeaveTypeBean> getListOfLeave() {
		List<LeaveTypeBean> listOfLeave = new ArrayList<LeaveTypeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM LeaveTypeBean ORDER BY leave_type_id  ASC").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	@SuppressWarnings("unchecked")
	public List<LeavecutBalance> getListOfAllLeave() {
		List<LeavecutBalance> listOfLeave = new ArrayList<LeavecutBalance>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM LeavecutBalance").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	@SuppressWarnings("unchecked")
	public List<LeavecutBalance> getListOfAllLeaveDepartmentGroup(int Department_id) {
		List<LeavecutBalance> listOfLeave = new ArrayList<LeavecutBalance>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM LeavecutBalance WHERE leaveBean.employeeBean.departmentBean ='"
					+ Department_id + "' GROUP BY leaveBean.employeeBean.departmentBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	@SuppressWarnings("unchecked")
	public List<EmployeeBean> getListOfEmployeeName(int manager_id) {
		List<EmployeeBean> listOfLeave = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM EmployeeBean WHERE under_manager_id = '" + manager_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	@SuppressWarnings("unchecked")
	public List<LeavecutBalance> getListOfCutLeave(int id) {
		List<LeavecutBalance> listOfLeave = new ArrayList<LeavecutBalance>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM LeavecutBalance where leaveBean = '" + id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	public ManagerBean getnameOfManager(String manager_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ManagerBean managerBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM ManagerBean WHERE manager_id='" + manager_id + "'");
			managerBean = (ManagerBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return managerBean;

	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveByManagerId(int manager_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from LeaveBean WHERE employeeBean.under_manager_id='" + manager_id + "' and status ='pending'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveByLeaveId(int leave_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE leave_id='" + leave_id + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveCOBean> getCOByCOId(int CO_ID) {

		List<LeaveCOBean> listOfCO = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveCOBean WHERE CO_ID ='" + CO_ID + "'");
			listOfCO = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCO;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getODByODId(int OD_ID) {

		List<LeaveODBean> listOfOD = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveODBean WHERE OD_ID ='" + OD_ID + "'");
			listOfOD = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfOD;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveDupicate(String Leave_From, String Leave_To, int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE Leave_From = '" + Leave_From
					+ "' AND from_half = 'FF' AND Leave_To = '" + Leave_To + "' AND to_half = 'FF'  AND employeeBean ='"
					+ emp_id + "' AND status = 'approved'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public LeaveTypeBean getLeaveTypeId(int leave_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		LeaveTypeBean leaveTypeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveTypeBean where leave_type_id=" + leave_id + "");
			leaveTypeBean = (LeaveTypeBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return leaveTypeBean;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveByEmpId(int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from LeaveBean WHERE employeeBean='" + emp_id + "' AND show_view= 0 AND status != 'Cancelled'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeavefromtodate(String a, String a1, int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where employeeBean ='" + emp_id
					+ "' and ('"+a+"' BETWEEN Leave_From AND Leave_To) and status='approved'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveBean> getLeavefromtodate1(String Leave_From, String Leave_To, int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where employeeBean ='" + emp_id + "' and (Leave_From ='"
					+ Leave_From + "' OR Leave_To='" + Leave_To + "' OR Leave_To ='" + Leave_From + "' OR Leave_From ='"
					+ Leave_To + "') and status='approved'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveByEmpID(int employee_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE employeeBean='" + employee_id + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHoliday() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Gujarat' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidaybyshowattdenace() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Gujarat' ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	public LeaveBalanceBean getleaveListbyEMP(int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		LeaveBalanceBean leaveBalanceBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM LeaveBalanceBean WHERE employeeBean='" + emp_id + "'");
			leaveBalanceBean = (LeaveBalanceBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return leaveBalanceBean;

	}
	
	
	
	public LeaveBalanceYearWiseBean getleaveListbyEMPYearWise(int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		LeaveBalanceYearWiseBean leaveBalanceBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM LeaveBalanceYearWiseBean WHERE employeeBean='" + emp_id + "'");
			leaveBalanceBean = (LeaveBalanceYearWiseBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return leaveBalanceBean;

	}

	public LeaveBalanceBean getleaveListbyEMPCode(int emp_code) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		LeaveBalanceBean leaveBalanceBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("FROM LeaveBalanceBean WHERE employeeBean.employee_code='" + emp_code + "'");
			leaveBalanceBean = (LeaveBalanceBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return leaveBalanceBean;

	}

	public LeaveBalanceBean getleaveListbyEMPCodeAndCopanyID(int emp_code, int companyId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		LeaveBalanceBean leaveBalanceBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM LeaveBalanceBean WHERE employeeBean.employee_code='" + emp_code
					+ "' AND employeeBean.companyListBean='" + companyId + "'");
			leaveBalanceBean = (LeaveBalanceBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return leaveBalanceBean;

	}

	public EmployeeBean getspecialleaveListbyEMPCode(int emp_code, int company_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM EmployeeBean WHERE employee_code ='" + emp_code
					+ "' AND companyListBean = '" + company_id + "' ");
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

	@SuppressWarnings("unchecked")
	public List<LeaveCOBean> getCODupicate(String DATE, int emp_id) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveCOBean WHERE CO_date = '" + DATE + "'  AND employee_master_id ='" + emp_id
							+ "' AND status != 'cancelled' and sundayholiday != 'YES'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getODDupicate(String STARTDATE, String ENDDATE, int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveODBean WHERE OD_StartDate = '" + STARTDATE + "' AND OD_EndDate = '"
							+ ENDDATE + "'  AND employeeBean ='" + emp_id + "' AND status != 'cancelled'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeavecutBalance> getLeaveReport(int emp_code) {

		List<LeavecutBalance> listOfLeaveReport = new ArrayList<LeavecutBalance>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeavecutBalance WHERE leaveBean.employeeBean.employee_code ='" + emp_code + "'");
			listOfLeaveReport = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeaveReport;
	}

	@SuppressWarnings("unchecked")
	public List<HolidayBean> getHolidayDupicate(String Holiday_day) {

		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM HolidayBean WHERE holiday_date = '" + Holiday_day + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveByUnderManagerId(String manager_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveBean WHERE employeeBean.under_manager_id='" + manager_id + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveCOBean> getCOByManagerId(int manager_id) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveCOBean WHERE employeeBean.under_manager_id='" + manager_id
					+ "' and status = 'pending' ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getShowViewLeaveByEmpId(int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE employeeBean='" + emp_id + "' and show_view = '0'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveCOBean> getCOByEmpId(int emp_id) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveCOBean WHERE employeeBean='" + emp_id
					+ "' AND show_view = '0' AND status != 'cancelled'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveCOBean> getCOByEmpId1(int emp_id, String from_date, String to_date) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveCOBean WHERE employeeBean='" + emp_id
					+ "' and CO_date between '" + from_date + "' and '" + to_date + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveCOBean> getCOByEmpId1(int emp_id) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveCOBean WHERE employeeBean='" + emp_id + "' and CO_date between '2017-10-01' and '2018-09-31' order by CO_ID DESC ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	public List<LeaveCOBean> getCOByEmpIdandYearwise(int emp_id) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveCOBean WHERE employeeBean='" + emp_id + "' and CO_date between '2017-10-01' and '2018-09-31' order by CO_ID DESC ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	

	public List<LeaveCOBean> getPendingCO() {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveCOBean WHERE status='pending'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getODByEmpId(int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveODBean WHERE employeeBean='" + emp_id
					+ "' AND show_view = '0' AND status != 'cancelled'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getODByEmpId1(int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveODBean WHERE employeeBean='" + emp_id + "' order by OD_ID DESC ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getODByEmpIdandYearwise(int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveODBean WHERE employeeBean='" + emp_id + "' and OD_StartDate between '2017-10-01' and '2018-09-31' order by OD_ID DESC ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getPendingOD() {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveODBean WHERE status='pending'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getODByManagerId(int manager_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveODBean WHERE employeeBean.under_manager_id ='" + manager_id
					+ "' and status = 'Pending'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeavecutBalance> getListOfAdjustLeave(int id) {
		List<LeavecutBalance> listOfLeave = new ArrayList<LeavecutBalance>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM LeavecutBalance where leaveBean = '" + id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getManagerLeaveforPending(int UnderManager_Id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveBean where status='Pending' AND employeeBean.under_manager_id ='"
							+ UnderManager_Id + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeavesendwitchroul(String Leave_From, String Leave_To, int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE (pushMainDate = '" + Leave_From
					+ "' OR pushMainDate = '" + Leave_To + "' OR popMainDate= '" + Leave_From + "' OR popMainDate = '"
					+ Leave_To + "') AND employeeBean ='" + emp_id + "' AND status != 'Cancelled' ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getunplannedByEmp_code(int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE employeeBean ='" + emp_id + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public LeavecutBalance getleaveCUTBYLeaveID(int Leave_ID) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		LeavecutBalance leavecutBalance = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM LeavecutBalance WHERE leave_id='" + Leave_ID + "'");
			leavecutBalance = (LeavecutBalance) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return leavecutBalance;

	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveOfNoStatus() {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE HR_Flag_unplan_leave ='NO'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeBean> getListOfEmployee(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE under_manager_id='" + manager_id + "'")
					.list();
			System.out.println(listOfEmployee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployee;

	}

	public List<DepartmentBean> getListOfDepartment() {
		List<DepartmentBean> listOfDepartment = new ArrayList<DepartmentBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartment = session.createQuery("FROM DepartmentBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDepartment;

	}

	@SuppressWarnings("unchecked")
	public List<MonthBean> getListOfMonth() {
		List<MonthBean> listofMonth = new ArrayList<MonthBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofMonth = session.createQuery("from MonthBean where month_id != 13").list();
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

	public List<LeaveBean> getleaveCUTBYBetweenDate(String from, String to) {
		List<LeaveBean> listofLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofLeave = session
					.createQuery("FROM LeaveBean where Leave_From between '" + from + "' AND '" + to + "' ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofLeave;
	}

	public List<LeaveBean> getleaveCUTBYBetweenDateAndDepartment(String from, String to, int Department_id) {
		List<LeaveBean> listofLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofLeave = session.createQuery("FROM LeaveBean where (Leave_From between '" + from + "' AND '" + to
					+ "') AND employeeBean.departmentBean = '" + Department_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofLeave;
	}

	public List<LeaveBean> getUnplanListPerMonth(String from, String to, int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where employeeBean ='" + emp_id
					+ "' and status ='approved' and (Leave_From BETWEEN '" + from + "' AND '" + to + "') ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveBean> getLeaveByEmpId1(int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveBean WHERE employeeBean='" + emp_id + "' order by leave_id desc");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	public List<LeaveBean> getLeaveByEmpIdAndYearWise(int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveBean WHERE employeeBean='" + emp_id + "' and Leave_From between '2017-10-01' and '2018-09-31' order by leave_id desc");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	

	public List<LeaveBean> getListOfEmployeeLeave(int manager_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from LeaveBean where employeeBean.under_manager_id ='" + manager_id + "' and status='approved'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	public List<LeaveBean> getListOfEmployeeLeaveBetween(int manager_id,String fromDate,String toDate) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from LeaveBean where employeeBean.under_manager_id ='" + manager_id + "' and status='approved' and  ((Leave_From  between '" + fromDate + "' and '"+ toDate +"') OR (Leave_To  between '" + fromDate + "' and '"+ toDate +"'))");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveBean> getListOfPendingEmployeeLeave() {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where status='pending'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveBean> getListOfEmployeeLeaveByDate(String date) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where (submission_date like '%" + date + "%')");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveApproved(int manager_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from LeaveBean WHERE employeeBean.under_manager_id='" + manager_id + "' and status ='approved'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveAdjustBalanceBean> getLeaveAdjustByEmpId(int emp_id) {

		List<LeaveAdjustBalanceBean> listOfLeaveHr = new ArrayList<LeaveAdjustBalanceBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM LeaveAdjustBalanceBean where employeeBean='" + emp_id + "'");
			listOfLeaveHr = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeaveHr;
	}

	public List<LeaveBean> getListOfApprovedEmployeeLeave(String fromDate, String toDate, String Status,
			int companyId) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and Leave_From between '" + fromDate + "' and '" + toDate + "'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveBean where  status ='" + Status + "'");
			} else {
				query = session.createQuery("from LeaveBean where status ='" + Status + "' and Leave_From between '"
						+ fromDate + "' and '" + toDate + "' ");
			}
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	public List<LeaveBean> getListOfApprovedEmployeeLeaveForSurat(String fromDate, String toDate, String Status,
			int companyId) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and Leave_From between '" + fromDate + "' and '" + toDate + "' and employeeBean.location = 'Surat' ");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveBean where  status ='" + Status + "' and employeeBean.location = 'Surat'");
			} else {
				query = session.createQuery("from LeaveBean where status ='" + Status + "' and Leave_From between '"
						+ fromDate + "' and '" + toDate + "' and employeeBean.location = 'Surat' ");
			}
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	public List<LeaveBean> getListOfApprovedEmployeeLeaveForA8DeptWise(String fromDate, String toDate, String Status,
			int companyId) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and Leave_From between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean In  (41,42,43) ");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveBean where  status ='" + Status + "' and employeeBean.departmentBean In  (41,42,43)");
			} else {
				query = session.createQuery("from LeaveBean where status ='" + Status + "' and Leave_From between '"
						+ fromDate + "' and '" + toDate + "' and employeeBean.departmentBean In  (41,42,43) ");
			}
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	
	
	public List<LeaveBean> getListOfApprovedEmployeeLeaveForA8EMPWise(String fromDate, String toDate, String Status,
			int companyId) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and Leave_From between '" + fromDate + "' and '" + toDate + "' and employeeBean In  (979,2018,2000,1431,1429,1199)");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveBean where  status ='" + Status + "' and employeeBean In  (979,2018,2000,1431,1429,1199)");
			} else {
				query = session.createQuery("from LeaveBean where status ='" + Status + "' and Leave_From between '"
						+ fromDate + "' and '" + toDate + "' and employeeBean In  (979,2018,2000,1431,1429,1199) ");
			}
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	public List<LeaveBean> getListOfApprovedEmployeeLeaveForNYDeptWise(String fromDate, String toDate, String Status,
			int companyId) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and Leave_From between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean = 27 ");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveBean where  status ='" + Status + "' and employeeBean.departmentBean = 27");
			} else {
				query = session.createQuery("from LeaveBean where status ='" + Status + "' and Leave_From between '"
						+ fromDate + "' and '" + toDate + "' and employeeBean.departmentBean = 27");
			}
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	

	public List<LeaveCOBean> getApprovedCO(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveCOBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and CO_date between '" + fromDate + "' and '" + toDate + "'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveCOBean WHERE  status ='" + Status + "'");
			} else {
				query = session.createQuery("from LeaveCOBean WHERE status ='" + Status + "' and CO_date between '"
						+ fromDate + "' and '" + toDate + "'");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	public List<LeaveCOBean> getApprovedCOSurat(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveCOBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and CO_date between '" + fromDate + "' and '" + toDate + "' and employeeBean.location = 'Surat'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveCOBean WHERE  status ='" + Status + "' and employeeBean.location = 'Surat'");
			} else {
				query = session.createQuery("from LeaveCOBean WHERE status ='" + Status + "' and CO_date between '"
						+ fromDate + "' and '" + toDate + "' and employeeBean.location = 'Surat'");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
			
		public List<LeaveCOBean> getApprovedCOA8DeptWise(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			
			
			Query query = null;
			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveCOBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and CO_date between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean In  (41,42,43)");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveCOBean WHERE  status ='" + Status + "' and employeeBean.departmentBean In  (41,42,43)");
			} else {
				query = session.createQuery("from LeaveCOBean WHERE status ='" + Status + "' and CO_date between '"
						+ fromDate + "' and '" + toDate + "' and employeeBean.departmentBean In  (41,42,43)");
			}

			

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
		
		
		public List<LeaveCOBean> getApprovedCOA8EMPWise(String fromDate, String toDate, String Status, int companyId) {

			List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {
				tx = session.getTransaction();
				tx.begin();

				Query query = null;
				if (companyId != 0) {
					query = session.createQuery(
							"from LeaveCOBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
									+ companyId + "' and CO_date between '" + fromDate + "' and '" + toDate + "' and employeeBean In  (979,2018,2000,1431,1429,1199)");
				} else if (fromDate == null) {
					query = session.createQuery("from LeaveCOBean WHERE  status ='" + Status + "' and employeeBean In  (979,2018,2000,1431,1429,1199)");
				} else {
					query = session.createQuery("from LeaveCOBean WHERE status ='" + Status + "' and CO_date between '"
							+ fromDate + "' and '" + toDate + "' and employeeBean In  (979,2018,2000,1431,1429,1199)");
				}

				listOfLeave = query.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfLeave;
		}
		
		
		
		public List<LeaveCOBean> getApprovedCONYDeptWise(String fromDate, String toDate, String Status, int companyId) {

			List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {
				tx = session.getTransaction();
				tx.begin();

				Query query = null;
				if (companyId != 0) {
					query = session.createQuery(
							"from LeaveCOBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
									+ companyId + "' and CO_date between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean = 27");
				} else if (fromDate == null) {
					query = session.createQuery("from LeaveCOBean WHERE  status ='" + Status + "' and employeeBean.departmentBean = 27");
				} else {
					query = session.createQuery("from LeaveCOBean WHERE status ='" + Status + "' and CO_date between '"
							+ fromDate + "' and '" + toDate + "' and employeeBean.departmentBean = 27");
				}

				listOfLeave = query.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfLeave;
		}
		
	

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getApprovedOD(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;

			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveODBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status + "'");
			} else {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status
						+ "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "'");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getApprovedODSurat(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;

			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveODBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean.location = 'Surat'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status + "' and employeeBean.location = 'Surat' ");
			} else {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status
						+ "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean.location = 'Surat'");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getApprovedODA8DeptWise(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;

			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveODBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean In  (41,42,43)");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status + "' and employeeBean.departmentBean In  (41,42,43) ");
			} else {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status
						+ "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean In  (41,42,43)");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getApprovedODA8EMPWise(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;

			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveODBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean In  (979,2018,2000,1431,1429,1199)");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status + "' and employeeBean In  (979,2018,2000,1431,1429,1199) ");
			} else {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status
						+ "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean In  (979,2018,2000,1431,1429,1199)");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	

	
	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getApprovedODNYDeptWise(String fromDate, String toDate, String Status, int companyId) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;

			if (companyId != 0) {
				query = session.createQuery(
						"from LeaveODBean where  status ='" + Status + "' and employeeBean.companyListBean = '"
								+ companyId + "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean = 27");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status + "' and employeeBean.departmentBean = 27 ");
			} else {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status
						+ "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "' and employeeBean.departmentBean = 27");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeave(int i) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if(i==1){
			query = session.createQuery("from LeaveBean where mail_view = 0");
			}else{
			query = session.createQuery("from LeaveBean where status = 'pending'");
			}
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveCOBean> getCO(int i) {

		List<LeaveCOBean> listOfCo = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if(i == 1){
				 query = session.createQuery("from LeaveCOBean where mail_view = 0");
			}else{
				 query = session.createQuery("from LeaveCOBean where status = 'pending'");
			}
			
			listOfCo = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCo;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getOD(int i) {

		List<LeaveODBean> listOfOD = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			
			Query query = null;
			
			if(i == 1){
				 query = session.createQuery("from LeaveODBean where mail_view = 0");
			}else{
				 query = session.createQuery("from LeaveODBean where Status = 'pending'");
			}
			
			
			listOfOD = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfOD;
	}

	public List<EmployeeBean> getFullListOfEmployee() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean").list();
			System.out.println(listOfEmployee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployee;

	}

	public List<LeaveBean> getLeaveByEmpId2(int emp_id, String from_date, String to_Date) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE employeeBean='" + emp_id
					+ "' and Leave_From between '" + from_date + "' and '" + to_Date + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<YearBean> getListOfYear() {
		List<YearBean> listofyear = new ArrayList<YearBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofyear = session.createQuery("from YearBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofyear;
	}

	public List<LeaveBean> getListOfApprovedEmployeeLeaveByManager(String fromDate, String toDate, String Status,
			int managerId) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		@SuppressWarnings("unused")
		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = null;
			if (managerId != 0) {
				query = session.createQuery(
						"from LeaveBean where  status ='" + Status + "' and employeeBean.under_manager_id = '"
								+ managerId + "' and Leave_From between '" + fromDate + "' and '" + toDate + "'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveBean where status ='" + Status + "'");
			} else {
				query = session.createQuery("from LeaveBean where status ='" + Status + "' and Leave_From between '"
						+ fromDate + "' and '" + toDate + "' ");
			}
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveCOBean> getApprovedCOByManager(String fromDate, String toDate, String Status, int managerId) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;
			if (managerId != 0) {
				query = session.createQuery(
						"from LeaveCOBean where  status ='" + Status + "' and employeeBean.under_manager_id = '"
								+ managerId + "' and CO_date between '" + fromDate + "' and '" + toDate + "'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveCOBean WHERE  status ='" + Status + "'");
			} else {
				query = session.createQuery("from LeaveCOBean WHERE status ='" + Status + "' and CO_date between '"
						+ fromDate + "' and '" + toDate + "'");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getApprovedODByManager(String fromDate, String toDate, String Status, int managerId) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = null;

			if (managerId != 0) {
				query = session.createQuery(
						"from LeaveODBean where  status ='" + Status + "' and employeeBean.under_manager_id = '"
								+ managerId + "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "'");
			} else if (fromDate == null) {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status + "'");
			} else {
				query = session.createQuery("from LeaveODBean WHERE status ='" + Status
						+ "' and  OD_StartDate between '" + fromDate + "' and '" + toDate + "'");
			}

			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveCancelRequestBean> getLeaveForCancelByManagerId(int manager_id) {

		List<LeaveCancelRequestBean> listOfLeave = new ArrayList<LeaveCancelRequestBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveCancelRequestBean WHERE leaveBean.employeeBean.under_manager_id ='"
							+ manager_id + "' and leaveBean.status = 'approved' and approved_status = 'pending'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public LeaveCancelRequestBean getCancelLeaveById(int Leave_ID) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		LeaveCancelRequestBean leaveCancelRequestBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM LeaveCancelRequestBean WHERE leaveBean='" + Leave_ID + "'");
			leaveCancelRequestBean = (LeaveCancelRequestBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return leaveCancelRequestBean;

	}

	@SuppressWarnings("unchecked")
	public List<LeaveCancelRequestBean> getListOfCancelLeave(int i) {

		List<LeaveCancelRequestBean> listOfCancelLeave = new ArrayList<LeaveCancelRequestBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			
			Query query = null;
			
			if(i==1){
				 query = session.createQuery("from LeaveCancelRequestBean where mail_view = 0");
			}else{
				 query = session.createQuery("from LeaveCancelRequestBean where approved_status = 'pending'");
			}
			
			listOfCancelLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCancelLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveFromDateCheck(String Leave_From, int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE Leave_From = '" + Leave_From
					+ "' AND employeeBean = '" + emp_id + "'  AND status != 'Cancelled' ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveBean> getLeaveToDateCheck(String Leave_To, int emp_id) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean WHERE Leave_To = '" + Leave_To + "' AND  employeeBean = '"
					+ emp_id + "'  AND status != 'Cancelled' ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<GatePassBean> getListOfPendingGatePassEmployee(int emp_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"FROM GatePassBean where (status = 'pending' or status = 'cancelled') and employeeBean='" + emp_id
							+ "' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfApprovedGatePassEmployee(int emp_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where employeeBean='" + emp_id
					+ "' and (status='Approved' or status='In' or status = 'Out') order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfRejectedGatePassEmployee(int emp_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where employeeBean='" + emp_id
					+ "' and status='Rejected' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfPendingGatePassManager(int manager_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where employeeBean.under_manager_id='" + manager_id
					+ "' and status='Pending' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfPendingGatePassManagerWithOtherId(int manager_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where (employeeBean.under_manager_id='" + manager_id
					+ "' OR other_manager_id = '" + manager_id + "') and status='Pending' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GrievanceQueryBean> getListOfGrievanceQuery() {

		List<GrievanceQueryBean> listOfGrienvance = new ArrayList<GrievanceQueryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GrievanceQueryBean where status = 'pending'");
			listOfGrienvance = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGrienvance;
	}

	public List<GatePassBean> getListOfAllGatePassManager(int manager_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where (employeeBean.under_manager_id='" + manager_id
					+ "' OR other_manager_id = '" + manager_id
					+ "') and status!='Pending' and status!='Rejected' and status!='Cancelled' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfPendingGatePassHR() {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where status='Pending' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfAllGatePassHR() {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"FROM GatePassBean where status!='Pending' and status!='Rejected' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfAllGatePass() {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfAllGatePassByManager(int manager_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where (employeeBean.under_manager_id='" + manager_id
					+ "' or other_manager_id = '" + manager_id + "') order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfAllGatePassByEmployee(int emp_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("FROM GatePassBean where employeeBean = '" + emp_id + "' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfOutStatus(String date, String gate_name) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where status='Out' and submission_date_time like '"
					+ date + "%' and CompanyName = '" + gate_name + "' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfInterCompany(String date, String gate_name) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"FROM GatePassBean where (status='Out' or status = 'In') and submission_date_time like '" + date
							+ "%' and (Todec = '" + gate_name + "' or CompanyName = '" + gate_name
							+ "') and gate_entry = 1  order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfInterCompanyOut(String date, String gate_name) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"FROM GatePassBean where (status='Out' or status = 'In') and submission_date_time like '" + date
							+ "%' and (CompanyName = '" + gate_name
							+ "') and gate_entry = 1  order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfInterCompanyIN(String date, String gate_name) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"FROM GatePassBean where (status='Out' or status = 'In') and submission_date_time like '" + date
							+ "%' and (Todec = '" + gate_name + "') and gate_entry = 1  order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfInStatus(String date, String gate_name) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where status='In' and submission_date_time like '"
					+ date + "%' and CompanyName = '" + gate_name + "' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfAllGatePass(String date, String gate_name) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where submission_date_time like '" + date
					+ "%' and (CompanyName = '" + gate_name + "' or Todec = '" + gate_name
					+ "' ) and (status = 'pending' or status = 'in' or status = 'approved' or status = 'out') order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfRejectedGatePassHR() {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where status='Rejected' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfRejectedGatePassManager(int manager_id) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where (employeeBean.under_manager_id='" + manager_id
					+ "' OR other_manager_id = '" + manager_id + "') and status='Rejected' order by gate_pass_id DESC");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public List<GatePassBean> getListOfAllApprovedGatePass(String date, String gate_name) {

		List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM GatePassBean where submission_date_time like '" + date
					+ "%' and CompanyName = '" + gate_name
					+ "' and(status = 'Pending' OR status = 'Approved' OR status = 'In' Or status = 'Out') and gate_entry = 0 order by gate_pass_id DESC ");
			listOfGatePass = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGatePass;
	}

	public GatePassAuthorityBean authorityOfGatePass(int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		GatePassAuthorityBean gatePassAuthorityBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from GatePassAuthorityBean where employeeBean=" + emp_id + "");
			gatePassAuthorityBean = (GatePassAuthorityBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return gatePassAuthorityBean;
	}

	public List<LeaveBean> getAllPlanLeaveForExcel(String fromDate, String toDate,String status) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where ((Leave_From  between '" + fromDate + "' and '"
					+ toDate + "') OR (Leave_To  between '" + fromDate + "' and '"+ toDate +"'))  and status='"+status+"' and  Day_count not like '%.5' and LeaveType_ID = 1");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveBean> getAllUnPlanLeaveForExcel(String fromDate, String toDate,String status) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where ((Leave_From  between '" + fromDate + "' and '"
					+ toDate + "') OR (Leave_To  between '" + fromDate + "' and '"+ toDate +"')) and status='"+status+"' and  Day_count not like '%.5' and LeaveType_ID = 5");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveBean> getAllHalfLeaveForExcel(String fromDate, String toDate,String status) {

		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveBean where ((Leave_From  between '" + fromDate + "' and '"
					+ toDate + "') OR (Leave_To  between '" + fromDate + "' and '"+ toDate +"')) and status='"+status+"' and  Day_count  like '%.5'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveCOBean> getAllFullCOForExcel(String fromDate, String toDate,String status) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from LeaveCOBean  where status='"+status+"' and (Total_Hours > 4) and (CO_date between '" + fromDate
							+ "' and '" + toDate + "')");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveCOBean> getAllHalfCOForExcel(String fromDate, String toDate,String status) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		LeaveBean leaveBean = null;
	
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from LeaveCOBean  where status='"+status+"' and (Total_Hours > 2 and  Total_Hours <= 4) and (CO_date between '"
							+ fromDate + "' and '" + toDate + "')");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveODBean> getAllODForExcel(String fromDate, String toDate,String status) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		LeaveBean leaveBean = null;
		;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveODBean where Status='"+status+"' and ((OD_StartDate between '"
					+ fromDate + "' and '" + toDate + "' ) OR (OD_EndDate between '"+fromDate+"' and '"+toDate+"'))");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<GatePassBean> getGatePassListPerMonth(String GatePassDate, int emp_id) {

		List<GatePassBean> listOfLeave = new ArrayList<GatePassBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from GatePassBean where employeeBean ='" + emp_id + "' and submission_date_time like '"
							+ GatePassDate + "%'  And  status='Out' ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	public GatePassBean getGatePassDetail(int gate_id) {

		GatePassBean gatePassBean = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from GatePassBean where gate_pass_id = '"+gate_id+"' ");
			gatePassBean = (GatePassBean)query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return gatePassBean;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getSUNHOLICO(int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveODBean WHERE employeeBean='" + emp_id + "' AND  Status='approved' ");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<IntervieweeBean> getListOfInterviewee() {
		List<IntervieweeBean> listOfInterviewee = new ArrayList<IntervieweeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewee = session.createQuery("FROM IntervieweeBean where interviewer_feedback = 'null'").list();
			System.out.println(listOfInterviewee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewee;

	}

	public List<EmployeeBean> getListOfEmployeeByRoleAuthority() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery(
					"FROM EmployeeBean WHERE managerBean = 4 or managerBean = 117 or under_manager_id = 4 or under_manager_id = 117")
					.list();
			System.out.println(listOfEmployee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployee;

	}

	public List<IntervieweeBean> getListOfInterviewee(String parseDate) {
		List<IntervieweeBean> listOfInterviewee = new ArrayList<IntervieweeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewee = session.createQuery("FROM IntervieweeBean where interview_date = '" + parseDate + "'")
					.list();
			System.out.println(listOfInterviewee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewee;

	}

	public IntervieweeBean intervieweeById(int interviewee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		IntervieweeBean intervieweeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from IntervieweeBean where interviewee_id=" + interviewee_id + "");
			intervieweeBean = (IntervieweeBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return intervieweeBean;
	}

	public List<IntervieweeBean> getListOfIntervieweePending() {
		List<IntervieweeBean> listOfInterviewee = new ArrayList<IntervieweeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewee = session.createQuery("FROM IntervieweeBean where interviewer_name = 'null'").list();
			System.out.println(listOfInterviewee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewee;

	}

	public List<IntervieweeBean> getListOfIntervieweeSubmit(String parseCurrDate) {
		List<IntervieweeBean> listOfInterviewee = new ArrayList<IntervieweeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewee = session.createQuery("FROM IntervieweeBean where interview_date = '" + parseCurrDate
					+ "' and interviewer_name != 'null'").list();
			System.out.println(listOfInterviewee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewee;

	}

	public List<IntervieweeBean> getListOfFullInterviewee() {
		List<IntervieweeBean> listOfInterviewee = new ArrayList<IntervieweeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewee = session.createQuery("FROM IntervieweeBean").list();
			System.out.println(listOfInterviewee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewee;

	}

	public List<EmployeeBean> getListOfEmployeeByRoleAuthority(String role_authority) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean WHERE roleBean.role_authority ='" + role_authority + "'").list();
			System.out.println(listOfEmployee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployee;

	}

	public List<IntervieweeBean> getListOfIntervieweeByName(String interview_date, String toInterview_date,
			String designation, String location, String hrPerson, String feedback, int count) {
		String v1 = null;
		String v2 = null;
		String v3 = null;
		String v4 = null;
		String v5 = null;
		String v6 = null;

		String c1 = null;
		String c2 = null;
		String c3 = null;
		String c4 = null;
		String c5 = null;
		String c6 = null;

		if (!interview_date.equalsIgnoreCase("")) {
			c1 = "interview_date";
			v1 = interview_date;
		}

		if (!interview_date.equalsIgnoreCase("")) {
			if (c1 == null) {
				c1 = "interview_date";
				v1 = toInterview_date;
			} else {
				c2 = "interview_date";
				v2 = toInterview_date;
			}
		}

		if (!designation.equalsIgnoreCase("")) {
			if (c1 == null) {
				c1 = "designation";
				v1 = designation;
			} else if (c2 == null) {
				c2 = "designation";
				v2 = designation;
			} else {
				c3 = "designation";
				v3 = designation;
			}
		}

		if (!location.equalsIgnoreCase("")) {
			if (c1 == null) {
				c1 = "interviewee_location";
				v1 = location;
			} else if (c2 == null) {
				c2 = "interviewee_location";
				v2 = location;
			} else if (c3 == null) {
				c3 = "interviewee_location";
				v3 = location;
			} else {
				c4 = "interviewee_location";
				v4 = location;
			}
		}

		if (!hrPerson.equalsIgnoreCase("0")) {
			if (c1 == null) {
				c1 = "employee_master_id";
				v1 = hrPerson;
			} else if (c2 == null) {
				c2 = "employee_master_id";
				v2 = hrPerson;
			} else if (c3 == null) {
				c3 = "employee_master_id";
				v3 = hrPerson;
			} else if (c4 == null) {
				c4 = "employee_master_id";
				v4 = hrPerson;
			} else {
				c5 = "employee_master_id";
				v5 = hrPerson;
			}
		}

		if (!feedback.equalsIgnoreCase("")) {
			if (c1 == null) {
				c1 = "interviewer_feedback";
				v1 = feedback;
			} else if (c2 == null) {
				c2 = "interviewer_feedback";
				v2 = feedback;
			} else if (c3 == null) {
				c3 = "interviewer_feedback";
				v3 = feedback;
			} else if (c4 == null) {
				c4 = "interviewer_feedback";
				v4 = feedback;
			} else if (c5 == null) {
				c5 = "interviewer_feedback";
				v5 = feedback;
			} else {
				c6 = "interviewer_feedback";
				v6 = feedback;
			}
		}

		List<IntervieweeBean> listOfInterviewee = new ArrayList<IntervieweeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			if (c1.equals("interview_date")) {

				if (count == 2) {
					listOfInterviewee = session
							.createQuery("FROM IntervieweeBean where " + c1 + " between '" + v1 + "' and  '" + v2 + "'")
							.list();
				} else if (count == 3) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where (" + c1 + " between '" + v1
							+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "'").list();
				} else if (count == 4) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where (" + c1 + " between '" + v1
							+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "'").list();
				} else if (count == 5) {
					listOfInterviewee = session.createQuery(
							"FROM IntervieweeBean where (" + c1 + " between '" + v1 + "' and  '" + v2 + "') and " + c3
									+ " = '" + v3 + "' and " + c4 + " = '" + v4 + "' and " + c5 + " = '" + v5 + "'")
							.list();
				} else if (count == 6) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where (" + c1 + " between '" + v1
							+ "' and '" + v2 + "') and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "' and "
							+ c5 + " = '" + v5 + "' and " + c6 + " = '" + v6 + "' ").list();
				}

			} else {
				if (count == 1) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where " + c1 + " = '" + v1 + "'")
							.list();
				} else if (count == 2) {
					listOfInterviewee = session.createQuery(
							"FROM IntervieweeBean where " + c1 + " = '" + v1 + "' and " + c2 + " = '" + v2 + "'")
							.list();
				} else if (count == 3) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where " + c1 + " = '" + v1 + "' and "
							+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "'").list();
				} else if (count == 4) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where " + c1 + " = '" + v1 + "' and "
							+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "'")
							.list();
				} else if (count == 5) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where " + c1 + " = '" + v1 + "' and "
							+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "' and "
							+ c5 + " = '" + v5 + "'").list();
				} else if (count == 6) {
					listOfInterviewee = session.createQuery("FROM IntervieweeBean where " + c1 + " = '" + v1 + "' and "
							+ c2 + " = '" + v2 + "' and " + c3 + " = '" + v3 + "' and " + c4 + " = '" + v4 + "' and "
							+ c5 + " = '" + v5 + "' and " + c6 + " = '" + v6 + "' ").list();
				}
			}

			System.out.println(listOfInterviewee.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewee;

	}

	public List<LeaveODBean> getODListPerMonth(String ODDate, String ODENDDATE, int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveODBean where employeeBean ='" + emp_id
					+ "' and  Status='approved' and (OD_StartDate between '" + ODDate + "' and '" + ODENDDATE + "')");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	public List<LeaveCOBean> getCOListPerMonth(String ODDate, String ODENDDATE, int emp_id) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveCOBean where employeeBean ='" + emp_id
					+ "' and status='approved' and (CO_date between '" + ODDate + "' and '" + ODENDDATE + "')");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}

	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getCOODDupicate(String STARTDATE, String ENDDATE, int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveODBean WHERE OD_StartDate <= '" + STARTDATE + "' AND OD_EndDate >= '"
							+ ENDDATE + "'  AND employeeBean ='" + emp_id + "' AND status != 'cancelled'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveODBean> getODForHDSL(String STARTDATE, String ENDDATE, int emp_id) {

		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from LeaveODBean WHERE OD_StartDate <= '" + STARTDATE + "' AND OD_EndDate >= '"
							+ ENDDATE + "'  AND employeeBean ='" + emp_id + "' AND status = 'approved'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	

	@SuppressWarnings("unchecked")
	public List<LeaveCOBean> getCODupicateWithOD(String DATE, int emp_id) {

		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from LeaveCOBean WHERE CO_date = '" + DATE + "'  AND employeeBean ='"
					+ emp_id + "' AND status != 'cancelled'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<NopunchBean> getLeavefornopunch(String LeaveDate , int employeemasterid , int under_manager_id) {

		List<NopunchBean> listOfLeave = new ArrayList<NopunchBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM NopunchBean where employee_master_id = '" + employeemasterid  + "' AND nopunch_date = '" + LeaveDate+ "' AND under_manager_id = '" + under_manager_id + "'");
			listOfLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;
	}
	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidayGujarat() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Gujarat' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}
	
	
	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidaySurat() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Surat' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidayDelhi() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Delhi' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}
	
	

	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidaykerala() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'kerala' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	
	

	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidaykarnataka() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'karnataka' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	
	

	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidayAndraPradesh() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Andra Pradesh' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	

	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidayTamilNadu() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Tamil Nadu' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}

	
	

	@SuppressWarnings("unchecked")
	public List<HolidayBean> getListOfHolidayMumbai() {
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLeave = session.createQuery("FROM HolidayBean WHERE location = 'Mumbai' AND IsVisible = 1 ORDER BY holiday_date").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLeave;

	}


	//Store Procedure For Levae By Manager 
			@SuppressWarnings("unchecked")
			public List<LeaveBean> SPgetLeaveByManagerId(int manager_id) {

				List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL leaveByManagerId(:managerId)")
		                    .addEntity(LeaveBean.class)
		                    .setParameter("managerId",manager_id);
					listOfLeave = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfLeave;
			}
			
			
			@SuppressWarnings("unchecked")
			public List<LeaveBean> SPgetLeaveByEmpId(int emp_id) {

				List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;

				try {
					tx = session.getTransaction();
					tx.begin();
					
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL leaveByEmpId(:empId)")
		                    .addEntity(LeaveBean.class)
		                    .setParameter("empId",emp_id);
					
					listOfLeave = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfLeave;
			}
			
			
			
			// Store Procedure For Co By Manager coByManager
			@SuppressWarnings("unchecked")
			public List<LeaveCOBean> SPgetCOByManagerId(int manager_id) {

				List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				@SuppressWarnings("unused")
				LeaveBean leaveBean = null;
				;
				try {
					tx = session.getTransaction();
					tx.begin();
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL coByManagerId(:managerId)")
		                    .addEntity(LeaveCOBean.class)
		                    .setParameter("managerId",manager_id);
					listOfLeave = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfLeave;
			}
			
			
			@SuppressWarnings("unchecked")
			public List<LeaveCOBean> SPgetCOByEmpId(int emp_id) {

				List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;

				try {
					tx = session.getTransaction();
					tx.begin();
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL coByEmpId(:empId)")
		                    .addEntity(LeaveCOBean.class)
		                    .setParameter("empId",emp_id);
					listOfLeave = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfLeave;
			}
			
			
			@SuppressWarnings("unchecked")
			public List<LeaveODBean> SPgetODByEmpId(int emp_id) {

				List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL odByEmpId(:empId)")
		                    .addEntity(LeaveODBean.class)
		                    .setParameter("empId",emp_id);
					
					listOfLeave = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfLeave;
			}
			
			
			// Store Procedure For OD By Manager 
			@SuppressWarnings("unchecked")
			public List<LeaveODBean> SPgetODByManagerId(int manager_id) {

				List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;

				try {
					tx = session.getTransaction();
					tx.begin();
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL odByManagerId(:managerId)")
		                    .addEntity(LeaveODBean.class)
		                    .setParameter("managerId",manager_id);
					listOfLeave = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfLeave;
			}
			
			
			//Store Procedure for cancel leave list for manager
			public List<LeaveCancelRequestBean> SPgetLeaveForCancelByManagerId(int manager_id) {

				List<LeaveCancelRequestBean> listOfLeave = new ArrayList<LeaveCancelRequestBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;

				try {
					tx = session.getTransaction();
					tx.begin();
					
					
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL leaveForCancelByManagerId(:managerId)")
		                    .addEntity(LeaveCancelRequestBean.class)
		                    .setParameter("managerId",manager_id);
					
					listOfLeave = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfLeave;
			}
			
			
			
			//Store procedure Gate pass List
			public List<GatePassBean> SPgetListOfPendingGatePassManagerWithOtherId(int manager_id) {

				List<GatePassBean> listOfGatePass = new ArrayList<GatePassBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL listOfPendingGatePassManagerWithOtherId(:managerId)")
		                    .addEntity(GatePassBean.class)
		                    .setParameter("managerId",manager_id);
					
					listOfGatePass = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfGatePass;
			}
			
			
			
			public List<GrievanceQueryBean> SPgetListOfGrievanceQuery() {

				List<GrievanceQueryBean> listOfGrienvance = new ArrayList<GrievanceQueryBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL listOfGrievanceQuery()")
		                    .addEntity(GrievanceQueryBean.class);
					listOfGrienvance = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfGrienvance;
			}
}