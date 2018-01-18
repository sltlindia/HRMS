package com.hrms.timesheet.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.QuterlyMonthBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.timesheet.bean.DayBean;
import com.hrms.timesheet.bean.HolidayBean;
import com.hrms.timesheet.bean.ProjectAllocationBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.timesheet.util.HibernateUtil;

public class AllListDAO {

	public List<EmployeeBean> getListOfEmployee() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE role_id=9").list();
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

	public List<EmployeeBean> getListOfAllEmployee() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean").list();
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

	public List<ProjectMasterBean> getListOfProject() {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean").list();
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

	public List<TaskMasterBean> getListOfTask() {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "FROM TaskMasterBean";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;

	}

	public List<ClientMasterBean> getListOfClient() {
		List<ClientMasterBean> listOfClient = new ArrayList<ClientMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfClient = session.createQuery("FROM ClientMasterBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfClient;

	}

	public List<Object[]> getmanagerTimeSheetList(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d where e.employee_master_id='"
					+ employee_master_id + "' and t.date='" + date + "' and t.task_time_status='pending'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getdayTimeSheetList(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1  where e.employee_master_id='"
					+ employee_master_id + "' and t.date='" + date + "'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getmanagerTimeSheetList1(int employee_master_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + "";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getWeeklyTimesheet(int employee_master_id, String startDate, String endDate) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + " and (t.date BETWEEN '" + startDate + "' AND '" + endDate
					+ "') and  (t.task_time_status ='saved' or  t.task_time_status ='submit')";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getWeeklyTimesheet2(int employee_master_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id
					+ " and  (t.task_time_status ='saved' or  t.task_time_status ='submit' or   t.task_time_status ='updated') group by t.date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getSumOfHours(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + " and t.date ='" + date + "' ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getSumOfHoursApprovedTs(String d) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where t.date ='"
					+ d + "' ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getDateTimesheet(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + " and t.date ='" + date
					+ "' and  (t.task_time_status ='saved' or  t.task_time_status ='submit') ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getDuplicateDateTimesheet(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + " and t.date ='" + date
					+ "' and t.task_time_status ='submit' and (t.approval_status = 'pending' or t.approval_status = 'updated' or t.approval_status = 'approved')";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<UnplanProjectBean> getDuplicateDateUnplanTimesheet(int employee_master_id, String date) {
		List<UnplanProjectBean> listOfTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean where employeeBean =" + employee_master_id + " and date ='" + date
					+ "' and task_time_status ='submit' and (approval_status = 'pending' or approval_status = 'updated' or approval_status = 'approved')";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getallTimesheet(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + " and t.date ='" + date + "')";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> pendingTimeSheet(int manager_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where (t.task_time_status ='submit' or t.task_time_status ='updated') and (t.approval_status = 'pending' or t.approval_status = 'rejected') and e.under_manager_id='"
					+ manager_id + "' group by e.employee_master_id,t.date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> pendingTimesheetView(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id ="
					+ employee_master_id + " and t.date = '" + date + "'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> approvedEmployeeTimeSheet(int employee_master_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id = "
					+ employee_master_id + " group by t.date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> rejectedEmployeeTimeSheet(int employee_master_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where t.approval_status = 'rejected' and e.employee_master_id = "
					+ employee_master_id + " group by t.date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> approvedTimeSheet(int manager_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where t.approval_status = 'approved' and e.under_manager_id='"
					+ manager_id + "' group by e.employee_master_id,t.date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> rejectedTimeSheet(int manager_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where t.approval_status = 'rejected' and e.under_manager_id='"
					+ manager_id + "' group by e.employee_master_id,t.date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> weeklyReport(int employee_master_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id = "
					+ employee_master_id + " ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> timeSheetUpdateButton(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1   where e.employee_master_id ="
					+ employee_master_id + " and t.date = '" + date + "'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> timeSheetUpdateButtonId(int timesheet_master_id, int employee_master_id, String startDate,
			String endDate) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where (t.date BETWEEN '"
					+ startDate + "' AND '" + endDate + "') and t.timesheet_master_id !=" + timesheet_master_id
					+ " and e.employee_master_id =" + employee_master_id + " ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> timeSheetUpdateButtonId1(int timesheet_master_id, int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where t.date ='"
					+ date + "' and t.timesheet_master_id !=" + timesheet_master_id + " and e.employee_master_id ="
					+ employee_master_id + " ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getWeeklyTimesheet1(ProjectMasterBean projectMasterBean) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			/*
			 * String hql =
			 * "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1"
			 * ; Query query = session.createQuery(hql);
			 */
			/* listOfTimeSheet = query.list(); */
			Query query1 = session.createQuery("from ProjectMasterBean p GROUP BY project_master_name");
			query1.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			listOfTimeSheet = query1.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> employeeReport(int employee_master_id) {
		List<Object[]> listOfEmployeeReport = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id ="
					+ employee_master_id
					+ " and (task_time_status='submit' or task_time_status= 'updated') group by p.project_master_id";
			Query query = session.createQuery(hql);
			listOfEmployeeReport = query.list();
			System.out.println(listOfEmployeeReport.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployeeReport;
	}

	public List<Object[]> employeeReport1(int employee_master_id, int project_id) {
		List<Object[]> listOfEmployeeReport = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id ="
					+ employee_master_id + " and approval_status='approved' and p.project_master_id='" + project_id
					+ "'";
			Query query = session.createQuery(hql);
			listOfEmployeeReport = query.list();
			System.out.println(listOfEmployeeReport.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployeeReport;
	}

	public List<Object[]> projectReport(int project_id) {
		List<Object[]> listOfProjectReport = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			/*
			 * String hql =
			 * "select DISTINCT e.employee_master_id from TimeSheetBean t inner join t.employeeBean e join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where p.project_master_id ="
			 * +project_id+" and task_time_status='submit'";
			 */
			Query query = session.createQuery(
					"from TimeSheetBean t inner join t.employeeBean e join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1  where p.project_master_id ="
							+ project_id
							+ " and (task_time_status='submit' or t.task_time_status = 'updated') group by e.employee_master_id");
			listOfProjectReport = query.list();
			System.out.println(listOfProjectReport.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfProjectReport;
	}

	public List<EmployeeBean> underManagerList(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from EmployeeBean where under_manager_id =" + manager_id + "";
			Query query = session.createQuery(hql);
			listOfEmployee = query.list();
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
	
	
	
	public List<EmployeeBean> departmentList(int deptId) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from EmployeeBean where departmentBean =" + deptId + "";
			Query query = session.createQuery(hql);
			listOfEmployee = query.list();
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

	public List<EmployeeBean> underManagerList1(int dept_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from EmployeeBean where departmentBean =" + dept_id + "";
			Query query = session.createQuery(hql);
			listOfEmployee = query.list();
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

	public List<EmployeeBean> underManagerAllList() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from EmployeeBean where (role_id != 2 and role_id !=3 and role_id !=9)";
			Query query = session.createQuery(hql);
			listOfEmployee = query.list();
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

	public List<EmployeeBean> underHrList() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from EmployeeBean where (role_id != 2 and role_id !=3 and role_id !=9 and manager_id != 4)";
			Query query = session.createQuery(hql);
			listOfEmployee = query.list();
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

	public List<ProjectMasterBean> underManagerProjectList(int manager_id) {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectMasterBean where managerBean =" + manager_id + " ";
			Query query = session.createQuery(hql);
			listOfProject = query.list();
			System.out.println(listOfProject.size());
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

	public List<Object[]> assignedProjectList(int employee_master_id) {
		List<Object[]> listOfProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean p inner join p.employeeBean e join p.projectMasterBean p1 join p.taskMasterBean t where e.employee_master_id ="
					+ employee_master_id + " and p.allocation_status = 1 group by p1.project_master_id ";
			Query query = session.createQuery(hql);
			listOfProject = query.list();
			System.out.println("akash:" + listOfProject.size());
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

	public List<Object[]> assignedProjectList1(int employee_master_id) {
		List<Object[]> listOfProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean where employeeBean =" + employee_master_id
					+ " group by projectMasterBean ";
			Query query = session.createQuery(hql);
			listOfProject = query.list();
			System.out.println("akash:" + listOfProject.size());
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

	public List<Object[]> assignedTaskList(int project_master_id, int employee_master_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean p inner join p.projectMasterBean p1 join p.employeeBean e join p.taskMasterBean t1 where p1.project_master_id ="
					+ project_master_id + " and e.employee_master_id = " + employee_master_id
					+ " and allocation_status = 1 group by t1.task_master_id";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			System.out.println(listOfTask.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<Object[]> duplicateTimeSheetList(int employee_master_id, String date, int project_master_id,
			int task_master_id, int client_master_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.taskMasterBean tm join t.clientMasterBean c where e.employee_master_id='"
					+ employee_master_id + "' and t.date='" + date + "' and p.project_master_id='" + project_master_id
					+ "' and c.client_master_id='" + client_master_id + "' and tm.task_master_id='" + task_master_id
					+ "'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<EmployeeBean> getListOfEmployeeForProject(int manager_id) {
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

	public List<ProjectMasterBean> getListOfProjectMaster(int manager_id) {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session
					.createQuery("FROM ProjectMasterBean where managerBean=" + manager_id + " and projectStatusBean =3")
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
		return listOfProject;

	}

	public List<ProjectMasterBean> getListOfUnderProjectMaster(int emp_manager_id) {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session
					.createQuery(
							"FROM ProjectMasterBean where managerBean=" + emp_manager_id + " and projectStatusBean =3")
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
		return listOfProject;

	}

	public List<Object[]> getPerOfAllocationByProjectId(int employee_id, int project_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationPercentageBean p inner join p.employeeBean e join p.projectMasterBean p1 join p1.projectStatusBean p2 where e.employee_master_id ='"
					+ employee_id + "' and p1.project_master_id='" + project_id + "'";

			Query query = session.createQuery(hql);
			listOfAllocationProject = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocationProject;
	}

	public List<Object[]> getAllocatedTaskListByProjectId(int task_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean p inner join p.projectMasterBean p1 join p.employeeBean e join p.taskMasterBean t where t.task_master_id='"
					+ task_id + "' group By e.employee_master_id";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TaskMasterBean> getTaskListByProjectId1(int milestone_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean t where milestoneBean='" + milestone_id + "'";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TaskMasterBean> getTaskListByProjectId2(int project_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean t where projectMasterBean='" + project_id
					+ "' and master_task_or_not = 1 and task_id = 0";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TaskMasterBean> getTaskListByProjectIdWithTaskId(int project_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean t where projectMasterBean='" + project_id + "' and task_id != 0";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TaskMasterBean> getTaskListForUnallocatedProject(int project_id, int employee_master_id, int dept_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = null;

			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(employee_master_id);
			String loctaion = employeeBean.getLocation();
			int under_manager_id = Integer.parseInt(employeeBean.getUnder_manager_id());

			if (employee_master_id == 1166 || employee_master_id == 1494) {
				dept_id = 18;
				hql = "from TaskMasterBean t where (not exists (from ProjectAllocationBean p where p.projectMasterBean ="
						+ project_id + " and p.employeeBean = " + employee_master_id
						+ " and t.task_master_id = p.taskMasterBean ) and exists(from EmployeeBean e where (e.managerBean = t.managerBean or e.employee_master_id = t.emp_id) and (e.departmentBean = '"
						+ dept_id + "' or e.managerBean = '" + under_manager_id + "') )) and projectMasterBean='"
						+ project_id + "' and location='E2' and master_task_or_not = 0";
			} else if (employee_master_id == 1836) {
				dept_id = 18;
				hql = "from TaskMasterBean t where (not exists (from ProjectAllocationBean p where p.projectMasterBean ="
						+ project_id + " and p.employeeBean = " + employee_master_id
						+ " and t.task_master_id = p.taskMasterBean ) and exists(from EmployeeBean e where (e.managerBean = t.managerBean or e.employee_master_id = t.emp_id) and (e.departmentBean = '"
						+ dept_id + "' or e.managerBean = '" + under_manager_id + "') )) and projectMasterBean='"
						+ project_id + "' and location='A8' and master_task_or_not = 0";
			} else {
				hql = "from TaskMasterBean t where (not exists (from ProjectAllocationBean p where p.projectMasterBean ="
						+ project_id + " and p.employeeBean = " + employee_master_id
						+ " and t.task_master_id = p.taskMasterBean ) and exists(from EmployeeBean e where (e.managerBean = t.managerBean or e.employee_master_id = t.emp_id) and (e.departmentBean = '"
						+ dept_id + "' or e.managerBean = '" + under_manager_id + "') )) and projectMasterBean='"
						+ project_id + "' and master_task_or_not = 0";
			}

			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TaskMasterBean> getTaskListByManagerId(int manager_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean t where projectMasterBean != 18 and managerBean='" + manager_id + "'";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TaskMasterBean> getAllTaskList() {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean t where projectMasterBean != 2 and projectMasterBean != 18 and  projectMasterBean.projectStatusBean=3 ";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TimeSheetBean> getListOfAprovedTimesheet(int task_id) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean  where taskMasterBean='" + task_id + "' and approval_status ='approved'";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public List<TimeSheetBean> getListOfAprovedTimesheetByEmployeeId(int task_id, int employee_id) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean  where taskMasterBean='" + task_id + "' and employeeBean='" + employee_id
					+ "' and approval_status ='approved'";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public List<TimeSheetBean> getListOfRejectTimesheet(int task_id) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean  where taskMasterBean='" + task_id + "' and approval_status ='rejected'";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public double getMaxPer(int task_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		double maxvalue = 0;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("select max(t.percentage_completed) from TimeSheetBean t where t.taskMasterBean='"
							+ task_id + "' and t.approval_status ='approved' group by t.taskMasterBean");
			maxvalue = (Double) query.uniqueResult();
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

	public double getMaxPerByDate(int task_id, String startDate, String endDate) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		double maxvalue = 0;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("select max(t.percentage_completed) from TimeSheetBean t where t.taskMasterBean='"
							+ task_id + "' and (date BETWEEN '" + startDate + "' AND '" + endDate
							+ "') and t.approval_status ='approved'");
			maxvalue = (Double) query.uniqueResult();
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

	public List<TimeSheetBean> getListOfAprovedTimesheetDuration(int task_id) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where taskMasterBean='" + task_id
					+ "' and approval_status ='approved' group by date";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public List<EmployeeBean> getListOfEmployeeDefaulter(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE under_manager_id = " + manager_id + "")
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
		return listOfEmployee;

	}

	public List<Object[]> getListOfEmployeeDefaulterWithDate(int manager_id, String startDate, String endDate) {
		List<Object[]> listOfEmployee = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM TimeSheetBean t inner join t.employeeBean e WHERE e.under_manager_id = "
							+ manager_id + " and (t.date BETWEEN '" + startDate + "' AND '" + endDate + "')")
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
		return listOfEmployee;

	}

	public List<Object[]> getListOfEmployeeDefaulterWithDate1(int manager_id, String startDate, String endDate) {
		List<Object[]> listOfEmployee = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM TimeSheetBean t inner join t.employeeBean e WHERE e.under_manager_id = "
							+ manager_id + " and (t.date BETWEEN '" + startDate + "' AND '" + endDate
							+ "') union from HolidayBean h where h.holiday_date between '" + startDate + "' AND '"
							+ endDate + "'")
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
		return listOfEmployee;

	}

	public List<TimeSheetBean> getlistOfTimesheet(int employee_master_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean=" + employee_master_id + "";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TimeSheetBean> getListOfAprovedTimesheetProjectDuration(int project_id) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean  where projectMasterBean='" + project_id
					+ "' and approval_status ='approved' group by date";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public List<TimeSheetBean> getListOfAprovedTimesheetProjectDurationByDate(int project_id, String startDate,
			String endDate) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean  where projectMasterBean='" + project_id + "' and (date BETWEEN '"
					+ startDate + "' AND '" + endDate + "') and approval_status ='approved'";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public List<TimeSheetBean> getListOfAprovedTimesheetTaskDurationByDate(int taskId, String startDate,
			String endDate) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean  where taskMasterBean='" + taskId + "' and (date BETWEEN '" + startDate
					+ "' AND '" + endDate + "') and approval_status ='approved'";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public double getMaxPerProject(int project_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		double maxvalue = 0;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("select max(t.percentage_completed) from TimeSheetBean t where t.projectMasterBean='"
							+ project_id + "' and t.approval_status ='approved'");
			maxvalue = (Double) query.uniqueResult();
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

	public List<HolidayBean> getListOfHolidays(String startDate, String endDate) {
		List<HolidayBean> listofHolidays = new ArrayList<HolidayBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofHolidays = session
					.createQuery(
							"from HolidayBean where holiday_date between '" + startDate + "' and '" + endDate + "'")
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
		return listofHolidays;
	}

	public List<TimeSheetBean> getListOfTimesheet(int employee_id, String startDate, String endDate) {
		List<TimeSheetBean> listOfTimesheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean  where employeeBean='" + employee_id + "' and date between '" + startDate
					+ "' and '" + endDate + "'";
			Query query = session.createQuery(hql);
			listOfTimesheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimesheet;
	}

	public List<LeaveBean> getListOfLeave(int employee_id, String startDate, String endDate) {
		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from LeaveBean  where employeeBean='" + employee_id + "' and Leave_To between '" + startDate
					+ "' and '" + endDate + "'";
			Query query = session.createQuery(hql);
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

	public List<Object[]> getOverTimeReportHours(int manager_id, String startDate, String endDate) {
		List<Object[]> listOfEmployee = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM TimeSheetBean t inner join t.employeeBean e WHERE e.under_manager_id = "
							+ manager_id + " and (t.date BETWEEN '" + startDate + "' AND '" + endDate
							+ "') and t.approval_status ='approved' group by t.date")
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
		return listOfEmployee;

	}

	public List<Object[]> getOverTimeAllReportHours(String startDate, String endDate) {
		List<Object[]> listOfEmployee = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM TimeSheetBean t inner join t.employeeBean e WHERE  (t.date BETWEEN '" + startDate
							+ "' AND '" + endDate + "') and t.approval_status ='approved' group by t.date")
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
		return listOfEmployee;

	}

	public List<ProjectMasterBean> getListOfAllProject() {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean where projectStatusBean =3").list();
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

	public List<TimeSheetBean> getStatusReport(int manager_id, String startDate, String endDate, int employee_id,
			int department_id) {
		List<TimeSheetBean> listOfEmployee = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			if (employee_id != 0) {
				listOfEmployee = session.createQuery("FROM TimeSheetBean WHERE employeeBean.employee_master_id='"
						+ employee_id + "' and date BETWEEN '" + startDate + "' AND '" + endDate
						+ "' group by employeeBean,taskMasterBean").list();
			} else if (department_id != 0) {
				listOfEmployee = session
						.createQuery("FROM TimeSheetBean WHERE employeeBean.departmentBean.department_id='"
								+ department_id + "' and date BETWEEN '" + startDate + "' AND '" + endDate
								+ "' group by employeeBean,taskMasterBean")
						.list();
			} else {
				listOfEmployee = session.createQuery(
						"FROM TimeSheetBean WHERE employeeBean.under_manager_id='" + manager_id + "' and date BETWEEN '"
								+ startDate + "' AND '" + endDate + "' group by employeeBean,taskMasterBean")
						.list();
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
		return listOfEmployee;

	}

	public List<TimeSheetBean> TimeSheetListUsingProject(int project_master_id, int task_master_id,
			int client_master_id, int manager_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join p.managerBean m join t.clientMasterBean c join t.taskMasterBean t1 where p.project_master_id='"
					+ project_master_id + "' and c.client_master_id='" + client_master_id + "' and t1.task_master_id='"
					+ task_master_id + "' and  m.manager_id = " + manager_id + " ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<Object[]> getSumOfHoursInProject(int project_master_id, int task_master_id, int client_master_id,
			int manager_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join p.managerBean m join t.clientMasterBean c join t.taskMasterBean t1 where p.project_master_id='"
					+ project_master_id + "' and c.client_master_id='" + client_master_id + "' and t1.task_master_id='"
					+ task_master_id + "' and  m.manager_id = " + manager_id + "  ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TimeSheetBean> getStatusReportAll(String startDate, String endDate, int employee_id,
			int department_id) {
		List<TimeSheetBean> listOfEmployee = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			if (employee_id != 0) {
				listOfEmployee = session.createQuery("FROM TimeSheetBean WHERE employeeBean.employee_master_id = '"
						+ employee_id + "' and date BETWEEN '" + startDate + "' AND '" + endDate
						+ "' group by employeeBean,taskMasterBean").list();
			} else if (department_id != 0) {
				listOfEmployee = session
						.createQuery("FROM TimeSheetBean WHERE employeeBean.departmentBean.department_id = '"
								+ department_id + "' and date BETWEEN '" + startDate + "' AND '" + endDate
								+ "' group by employeeBean,taskMasterBean")
						.list();
			} else {
				listOfEmployee = session.createQuery("FROM TimeSheetBean WHERE date BETWEEN '" + startDate + "' AND '"
						+ endDate + "' group by employeeBean,taskMasterBean").list();
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
		return listOfEmployee;

	}

	public List<Object[]> getTimesheetForResourceUsage(int employee_master_id, int project_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where p.project_master_id='"
					+ project_id + "' and e.employee_master_id=" + employee_master_id
					+ " and approval_status ='approved'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TaskMasterBean> getListOfTaskByDate(int manager_id, String endDate, String date) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("FROM TaskMasterBean where managerBean='" + manager_id
					+ "' and task_planned_start_date between '" + endDate + "' and '" + date + "'").list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;

	}

	public List<TaskMasterBean> getListOfAllTaskByDate(String endDate, String date) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery(
					"FROM TaskMasterBean where task_planned_start_date between '" + endDate + "' and '" + date + "'")
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
		return listOfTask;

	}

	public List<ProjectAllocationBean> getListOfTaskByDate1(int emp_id, String endDate, String date) {
		List<ProjectAllocationBean> listOfTask = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("FROM ProjectAllocationBean where employeeBean='" + emp_id
					+ "' and taskMasterBean.task_planned_start_date between '" + endDate + "' and '" + date
					+ "' group by taskMasterBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;

	}

	public String getMinDate(int task_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		String maxvalue = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("select min(t.date) from TimeSheetBean t where t.taskMasterBean='"
					+ task_id + "' and t.approval_status ='approved'");
			maxvalue = (String) query.uniqueResult();
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
			System.out.println(listOfDepartment.size());
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

	public List<QuterlyMonthBean> getQuterlyMonth() {
		List<QuterlyMonthBean> listOfQuaterly = new ArrayList<QuterlyMonthBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from QuterlyMonthBean";
			Query query = session.createQuery(hql);
			listOfQuaterly = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfQuaterly;
	}

	public List<TimeSheetBean> getSumOfHoursEmployeeWise(int employee_master_id, String date, int project_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean=" + employee_master_id + " and date='" + date
					+ "' and projectMasterBean = " + project_id + " and unplanned_task=0";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TimeSheetBean> getSumOfHoursEmployeeWise1(int employee_master_id, String date) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean=" + employee_master_id + " and date='" + date
					+ "' and unplanned_task=0";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TimeSheetBean> getSumOfUnplannedTaskHoursEmployeeWise(int employee_master_id, String date,
			int project_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean=" + employee_master_id + " and date='" + date
					+ "' and projectMasterBean = " + project_id + " and unplanned_task=1";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TimeSheetBean> getSumOfUnplannedTaskEmployeeWise1(int employee_master_id, String date) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean=" + employee_master_id + " and date='" + date
					+ "' and unplanned_task=1";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public DayBean getDayNameByDayId(int dayId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		DayBean dayBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from DayBean where day_id=" + dayId + "");
			dayBean = (DayBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dayBean;
	}

	public List<UnplanProjectBean> duplicateUnplanTimeSheetList(int employee_master_id, String date,
			String project_master_name, String task_master_name) {
		List<UnplanProjectBean> listOfTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean where employeeBean='" + employee_master_id + "' and date='" + date
					+ "' and project_name='" + project_master_name + "' and task_name='" + task_master_name + "'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<UnplanProjectBean> getdayUnplanTimeSheetList(int employee_master_id, String date) {
		List<UnplanProjectBean> listOfTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean where employeeBean='" + employee_master_id + "' and date='" + date
					+ "'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<UnplanProjectBean> getdayUnplanTimeSheet(int employee_master_id) {
		List<UnplanProjectBean> listOfTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean u where not exists (from TimeSheetBean t where employeeBean="
					+ employee_master_id + " and t.date = u.date) and employeeBean='" + employee_master_id
					+ "'  group by date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<UnplanProjectBean> getSumOfHoursEmployeeWiseUnplanList(int employee_master_id, String date) {
		List<UnplanProjectBean> listOfTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean where employeeBean=" + employee_master_id + " and date='" + date + "'";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TimeSheetBean> getSumOfWorkHours(int employee_master_id, String date) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean=" + employee_master_id + " and date ='" + date + "' ";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<TimeSheetBean> getAllTimesheet(int employee_master_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean=" + employee_master_id + " group by date";
			Query query = session.createQuery(hql);
			listOfTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTimeSheet;
	}

	public List<UnplanProjectBean> UnplanTimeSheet(int manager_id) {
		List<UnplanProjectBean> listOfPendingAndUpdatedTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean u where not exists(from TimeSheetBean t where employeeBean.under_manager_id='"
					+ manager_id
					+ "' and t.date=u.date and t.employeeBean = u.employeeBean) and task_time_status ='submit' and (approval_status = 'pending' or approval_status = 'updated') and employeeBean.under_manager_id='"
					+ manager_id + "' group by employeeBean,date";
			Query query = session.createQuery(hql);
			listOfPendingAndUpdatedTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPendingAndUpdatedTimeSheet;
	}

	public List<UnplanProjectBean> UnplanRejectedTimeSheet(int manager_id) {
		List<UnplanProjectBean> listOfPendingAndUpdatedTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean u where not exists(from TimeSheetBean t where employeeBean.under_manager_id='"
					+ manager_id
					+ "' and t.date=u.date and t.employeeBean = u.employeeBean) and task_time_status ='submit' and approval_status = 'rejected'  and employeeBean.under_manager_id='"
					+ manager_id + "' group by employeeBean,date";
			Query query = session.createQuery(hql);
			listOfPendingAndUpdatedTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPendingAndUpdatedTimeSheet;
	}

	public List<UnplanProjectBean> UnplanApproveTimeSheet(int manager_id) {
		List<UnplanProjectBean> listOfPendingAndUpdatedTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean u where not exists(from TimeSheetBean t where employeeBean.under_manager_id='"
					+ manager_id
					+ "' and t.date=u.date and t.employeeBean = u.employeeBean) and task_time_status ='submit' and approval_status = 'approved'  and employeeBean.under_manager_id='"
					+ manager_id + "' group by employeeBean,date";
			Query query = session.createQuery(hql);
			listOfPendingAndUpdatedTimeSheet = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPendingAndUpdatedTimeSheet;
	}

	public ProjectMasterBean getDetailsOfProject(String code, String name) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectMasterBean projectMasterBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectMasterBean where project_code = '" + code
					+ "' and project_master_name = '" + name + "'");
			projectMasterBean = (ProjectMasterBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectMasterBean;
	}

	public List<ProjectManagerListBean> getAllManagerProjectList(int project_id, int manager_id) {

		List<ProjectManagerListBean> listOfProject = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("from ProjectManagerListBean where projectMasterBean = '" + project_id
					+ "' and employeeBean.managerBean = '" + manager_id + "'").list();
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

	public YearBean detailsOfYear(int year) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		YearBean yearBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from YearBean where year=" + year + "");
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

	public ProjectMasterBean getDetailsOfProject(int project_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectMasterBean projectMasterBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectMasterBean where project_master_id = '" + project_id + "'");
			projectMasterBean = (ProjectMasterBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectMasterBean;
	}

	public List<Object[]> employeeReportByTaskId(int employee_master_id, int task_id) {
		List<Object[]> listOfEmployeeReport = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id ="
					+ employee_master_id + " and approval_status='approved' and t1.task_master_id='" + task_id + "'";
			Query query = session.createQuery(hql);
			listOfEmployeeReport = query.list();
			System.out.println(listOfEmployeeReport.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployeeReport;
	}

	public List<ProjectManagerListBean> listOfProjectWithActiveStatus(int emp_id) {
		List<ProjectManagerListBean> listOfProject = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectManagerListBean where employeeBean = '" + emp_id
					+ "' and projectMasterBean.projectStatusBean = 3").list();
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
	
	
	public List<ProjectManagerListBean> listOfAllProjectWithActiveStatus() {
		List<ProjectManagerListBean> listOfProject = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectManagerListBean where  projectMasterBean.projectStatusBean = 3").list();
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
	
	public List<ProjectMasterBean> listOfAllProject() {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean where  projectStatusBean = 3").list();
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
	

	public ProjectAllocationPercentageBean getDetailsOfProjectALlocastion(int project_id, int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectAllocationPercentageBean projectAllocationPercentageBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectAllocationPercentageBean where project_master_id = '"
					+ project_id + "' and employeeBean = '" + emp_id + "'");
			projectAllocationPercentageBean = (ProjectAllocationPercentageBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectAllocationPercentageBean;
	}

	public List<ProjectAllocationBean> getListOfAllocationByTaskId(int emp_id, int task_id) {
		List<ProjectAllocationBean> listOfTask = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("FROM ProjectAllocationBean where employeeBean='" + emp_id
					+ "' and taskMasterBean = '" + task_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;

	}

	public List<Object[]> getPerOfAllocationByProjectIdUnique(int project_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationPercentageBean p inner join p.employeeBean e join p.projectMasterBean p1 join p1.projectStatusBean p2 where p1.project_master_id ='"
					+ project_id + "' group by e.employee_master_id";

			Query query = session.createQuery(hql);
			listOfAllocationProject = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocationProject;
	}

	public List<Object[]> getMilestoneListByProjectId(int project_id) {
		List<Object[]> listOfMilestone = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from MilestoneBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "'";
			Query query = session.createQuery(hql);
			listOfMilestone = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfMilestone;
	}

	public String getMaxDateOfProject(int project_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		String maxvalue = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("select max(date) from TimeSheetBean  where projectMasterBean = '"
					+ project_id + "' and  approval_status='Approved'");
			maxvalue = (String) query.uniqueResult();
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

	public String getMinDateOfProject(int project_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		String maxvalue = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("select min(date) from TimeSheetBean  where projectMasterBean = '"
					+ project_id + "' and  approval_status='Approved'");
			maxvalue = (String) query.uniqueResult();
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

	public List<ProjectManagerListBean> getListOfManagerForProject(int project_id) {
		List<ProjectManagerListBean> listOfManager = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManager = session
					.createQuery("FROM ProjectManagerListBean where projectMasterBean = '" + project_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfManager;

	}

	public List<TaskMasterBean> getTaskListByManagerID(int project_id, int manager_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "' and master_task_or_not = 0";
			Query query = session.createQuery(hql);
			listOfTask = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

	public List<TaskMasterBean> getTaskByTadskIDByMasterId(int master_id) {

		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("from TaskMasterBean where master_task_id='" + master_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTask;
	}

}
