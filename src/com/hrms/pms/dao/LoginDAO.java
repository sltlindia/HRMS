package com.hrms.pms.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.OTPBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.timesheet.bean.ProjectAllocationBean;

public class LoginDAO {

	public boolean authenticateUser(int company_list_id, int employee_code, String password) {
		EmployeeBean employeeBean = getUserByUserId(company_list_id, employee_code);
		if (employeeBean != null && employeeBean.getCompanyListBean().getCompany_list_id() == company_list_id
				&& employeeBean.getEmployee_code() == (employee_code) && employeeBean.getPassword().equals(password)
				&& employeeBean.getEmployeeStatusBean().getEmployee_status_id() != 3) {
			return true;
		} else {
			return false;
		}
	}

	public EmployeeBean getUserByUserId(int company_list_id, int employee_code) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where company_list_id= " + company_list_id
					+ " and employee_code=" + employee_code + " ");
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

	public EmployeeBean getUserByUserId(int employee_code) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_code=" + employee_code + "");
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

	public EmployeeBean getUserByManagerId(int manager_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where managerBean=" + manager_id + "");
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

	public List<EmployeeBean> getListOfEmployee() {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery("from EmployeeBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofEmployee;
	}

	public EmployeeBean getUserDetails(int emp_code, int pass, int company_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_code=" + emp_code + " and password="
					+ pass + " and companyListBean = " + company_id + "");
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

	public boolean employeeUpdate(int employee_id, String new_pass, String email) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"update EmployeeBean set password = :pw , email_id = :eid  where employee_master_id = :emi ");
			query.setString("pw", new_pass);
			query.setString("eid", email);
			query.setInteger("emi", employee_id);

			int result = query.executeUpdate();
			System.out.println("result :" + result);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	public EmployeeBean getEmployeeId(int under_manager_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where managerBean=" + under_manager_id + "");
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

	public EmployeeBean getEmailId(int manager_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where managerBean=" + manager_id + "");
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

	public EmployeeBean getEmailIdEmployee(int employee_master_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_master_id=" + employee_master_id + "");
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

	public EmployeeBean getInfoById(int employee_master_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_master_id=" + employee_master_id + "");
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

	public ProjectAllocationBean getAllocationByTaskId(int taskId, int employee_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectAllocationBean projectAllocationBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectAllocationBean where employeeBean=" + employee_id
					+ " and taskMasterBean=" + taskId + " group by taskMasterBean");
			projectAllocationBean = (ProjectAllocationBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectAllocationBean;
	}

	public EmployeeBean getUserInfoForForgotPassWord(int company_list_id, int employee_code, String email_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where company_list_id= " + company_list_id
					+ " and employee_code=" + employee_code + " and email_id='" + email_id + "'");
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

	public OTPBean otpAuthentication(String otp, int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		OTPBean otpBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from OTPBean where otp= " + otp + " and employeeBean=" + emp_id + "");
			otpBean = (OTPBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return otpBean;
	}

	public boolean employeeUpdateInForgotPassword(int employee_id, String new_pass) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update EmployeeBean set password = :pw where employee_master_id = :emi ");
			query.setString("pw", new_pass);
			query.setInteger("emi", employee_id);

			int result = query.executeUpdate();
			System.out.println("result :" + result);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	public EmployeeBean getUserByUserCodeAndName(int employee_code, String firstName, String lastName) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_code=" + employee_code
					+ " and firstname = '" + firstName + "' and lastname ='" + lastName + "'");
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
	
	public EmployeeBean getUserByUserCodeAndNameWithCompany(int employee_code, String firstName, String lastName,int company_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		EmployeeBean employeeBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from EmployeeBean where employee_code=" + employee_code
					+ " and firstname = '" + firstName + "' and lastname ='" + lastName + "' and companyListBean.company_list_id = '"+company_id+"' ");
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

	public List<EmployeeBean> getListOfEmployeeByDepartment() {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery(
					"from EmployeeBean where managerBean = 8 or under_manager_id= 8 or managerBean = 9 or under_manager_id= 9 or managerBean = 15 or under_manager_id= 15 or managerBean = 11 or under_manager_id= 11 or employee_master_id =30 or employee_master_id = 1836 or employee_master_id = 1494 or employee_master_id = 1586")
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
		return listofEmployee;
	}

	public List<EmployeeBean> getListOfEmployeeZeroLevel(int manager_id) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery("from EmployeeBean where  managerBean='" + manager_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofEmployee;
	}

	public List<EmployeeBean> getListByDepartmentUnderManagerId(int manager_id, int dept_id) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			if (dept_id != 0) {
				listofEmployee = session.createQuery("from EmployeeBean where  under_manager_id= '" + manager_id
						+ "' and departmentBean = '" + dept_id
						+ "' and employeeStatusBean != 3 and managerBean != 1 group by departmentBean").list();
			} else {
				listofEmployee = session.createQuery("from EmployeeBean where  under_manager_id= '" + manager_id
						+ "' and employeeStatusBean != 3 and managerBean != 1 group by departmentBean").list();
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
		return listofEmployee;
	}

	public List<EmployeeBean> getListByDepartmentUnderForAuthorityManagerId(int manager_id, int dept_id) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery(
					"from EmployeeBean e where exists (from EmployeeBean e1 where e.under_manager_id = '" + manager_id
							+ "' and e.managerBean != '" + manager_id + "' and e1.departmentBean = '" + dept_id
							+ "' and e.managerBean = e1.under_manager_id and e1.employeeStatusBean != 3) OR  (e.under_manager_id= '"
							+ manager_id + "' and e.departmentBean = '" + dept_id
							+ "' and e.employeeStatusBean != 3) group by departmentBean")
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
		return listofEmployee;
	}

	public List<EmployeeBean> getListOfManagerFromEmployeeMaster() {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery(
					"from EmployeeBean e where  manager_id != 99 and employeeStatusBean != 3 order by firstname asc")
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
		return listofEmployee;
	}

	public List<EmployeeBean> getListByDesignationUnderManagerId(int manager_id, int dept_id) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			if (dept_id != 0) {
				listofEmployee = session.createQuery("from EmployeeBean where  under_manager_id= '" + manager_id
						+ "' and departmentBean = '" + dept_id
						+ "'  and employeeStatusBean != 3 and managerBean != 1 group by departmentBean").list();
			} else {
				listofEmployee = session.createQuery("from EmployeeBean where  under_manager_id= '" + manager_id
						+ "' and employeeStatusBean != 3 and managerBean != 1 group by departmentBean").list();
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
		return listofEmployee;
	}

	public List<EmployeeBean> getListByUnderManagerId(int manager_id) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery("from EmployeeBean where  under_manager_id= '" + manager_id
					+ "' and employeeStatusBean != 3 and managerBean != 1	 ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofEmployee;
	}

	public List<EmployeeBean> getListByUnderManagerIdAndDeptId(int manager_id, int dept_id) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery("from EmployeeBean where  under_manager_id= '" + manager_id
					+ "' and departmentBean = '" + dept_id + "' and employeeStatusBean != 3 and managerBean != 1	")
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
		return listofEmployee;
	}

	public List<EmployeeBean> getListByUnderManagerIdAndGroupBySubDeptId(int manager_id, int dept_id) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery(
					"from EmployeeBean where  under_manager_id= '" + manager_id + "' and departmentBean = '" + dept_id
							+ "' and employeeStatusBean != 3 and managerBean != 1 group by sub_department")
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
		return listofEmployee;
	}

	public List<EmployeeBean> getListByUnderManagerIdAndSubDeptId(int manager_id, int dept_id, String sub_department) {
		List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofEmployee = session.createQuery(
					"from EmployeeBean where  under_manager_id= '" + manager_id + "' and departmentBean = '" + dept_id
							+ "' and employeeStatusBean != 3 and managerBean != 1 and sub_department = '"
							+ sub_department + "'")
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
		return listofEmployee;
	}

	 public List<EmployeeBean> getListOfEmployeeUnderProbation(){
	        List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;        
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            listofEmployee = session.createQuery("from EmployeeBean where employee_status_id = 2 and company_list_id != 8").list();                        
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return listofEmployee;
	    }
	 
	 
	 public DepartmentBean getDepartmentName(int dept_id) {
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			DepartmentBean departmentBean = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from DepartmentBean where department_id = '"+dept_id+"'");
				departmentBean = (DepartmentBean) query.uniqueResult();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return departmentBean;
		}
}
