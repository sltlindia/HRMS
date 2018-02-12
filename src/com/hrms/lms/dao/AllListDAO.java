package com.hrms.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.bean.LeaveAdjustBalanceBean;
import com.hrms.lms.bean.LeaveAfterAddBean;
import com.hrms.lms.bean.LeaveBalanceBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveCancelRequestBean;
import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.bean.LeaveTypeBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.util.HibernateUtil;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.SpecificCriteriaAllocationBean;
import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.timesheet.bean.HolidayBean;

public class AllListDAO 
{
	
	@SuppressWarnings("unchecked")
	public List<LeaveTypeBean> getListOfLeave()
	{
        List<LeaveTypeBean> listOfLeave = new ArrayList<LeaveTypeBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfLeave = session.createQuery("FROM LeaveTypeBean").list();                        
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
	public List<LeavecutBalance> getListOfCutLeave(int id)
	{
        List<LeavecutBalance> listOfLeave = new ArrayList<LeavecutBalance>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfLeave = session.createQuery("FROM LeavecutBalance where leaveBean = '"+id+"'").list();                        
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
	
	public ManagerBean getnameOfManager(String manager_id)
	{
        Session session = HibernateUtil.openSession();
        Transaction tx = null;  
        ManagerBean managerBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query= session.createQuery("FROM ManagerBean WHERE manager_id='"+manager_id+"'");
            managerBean = (ManagerBean)query.uniqueResult();
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
	 
	public List<Object[]> getLeaveByManagerId(int manager_id) {
		
		List<Object[]> listOfLeave = new ArrayList<Object[]>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	  
		LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveBean WHERE manager_id='"+manager_id+"'");
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
	
	
	public List<LeaveBean> getLeaveByLeaveId(int leave_id)
	{
		
		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveBean WHERE leave_id='"+leave_id+"'");
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
	
	
	public List<LeaveCOBean> getCOByCOId(int CO_ID)
	{
		
		List<LeaveCOBean> listOfCO = new ArrayList<LeaveCOBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveCOBean WHERE CO_ID ='"+ CO_ID +"'");
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



	public List<LeaveBean> getLeaveDupicate(String Leave_From , String Leave_To, int emp_id ) {
	
	List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;
    LeaveBean leaveBean = null;;
    try {
        tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("from LeaveBean WHERE Leave_From = '" + Leave_From + "' AND Leave_To = '"+ Leave_To +"' AND employee_master_id ='"+emp_id+"'");
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


	public LeaveTypeBean getLeaveTypeId(int leave_id)
	{
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        LeaveTypeBean leaveTypeBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from LeaveTypeBean where leave_type_id="+leave_id+"");
            leaveTypeBean = (LeaveTypeBean)query.uniqueResult();
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
	
	
	public List<LeaveBean> getLeaveByEmpId(int emp_id) {
		
		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveBean WHERE employee_master_id='"+ emp_id+"'");
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
	public List<LeaveBean> getLeavefromtodate(String Leave_From , String Leave_To, int emp_id ) {
		
		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    @SuppressWarnings("unused")
		LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveBean where employee_master_id ='"+emp_id+"' and Leave_From BETWEEN '" + Leave_From + "' AND '"+ Leave_To +"'");
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
	
	
	
	
	
	public List<LeaveBean> getLeaveByEmpID(int employee_id)
	{
		
		List<LeaveBean> listOfLeave = new ArrayList<LeaveBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	  
		LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveBean WHERE employee_master_id='"+employee_id+"'");
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
	public List<HolidayBean> getListOfHoliday()
	{
        List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfLeave = session.createQuery("FROM HolidayBean FROM HolidayBean WHERE IsVisible = 1 ORDER BY holiday_date").list();                        
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
	
	public LeaveBalanceBean getleaveListbyEMPCode(int emp_code)
	{
        Session session = HibernateUtil.openSession();
        Transaction tx = null;  
        LeaveBalanceBean leaveBalanceBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query= session.createQuery("FROM LeaveBalanceBean WHERE employeeBean.employee_code='"+ emp_code +"'");
            leaveBalanceBean = (LeaveBalanceBean)query.uniqueResult();
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
	
	public List<LeaveCOBean> getCODupicate(String DATE , int emp_id ) {
		
		List<LeaveCOBean> listOfLeave = new ArrayList<LeaveCOBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveCOBean WHERE CO_date = '" + DATE + "'  AND employee_master_id ='"+emp_id+"'");
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
	
	public List<LeaveODBean> getODDupicate(String STARTDATE , String ENDDATE , int emp_id ) {
		
		List<LeaveODBean> listOfLeave = new ArrayList<LeaveODBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("from LeaveODBean WHERE OD_StartDate = '" + STARTDATE + "' AND OD_EndDate = '" + ENDDATE + "'  AND employee_master_id ='"+emp_id+"'");
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


	public List<LeavecutBalance> getLeaveReport(int emp_code) {
	
	List<LeavecutBalance> listOfLeaveReport = new ArrayList<LeavecutBalance>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;
    LeaveBean leaveBean = null;;
    try {
        tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("from LeavecutBalance WHERE leaveBean.employeeBean.employee_code ='"+emp_code+"'");
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
	
	
	public List<HolidayBean> getHolidayDupicate(String Holiday_day) {
		
		List<HolidayBean> listOfLeave = new ArrayList<HolidayBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    LeaveBean leaveBean = null;;
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
	
	public List<EmployeeBean> getNameforUnderManager(int Manager_id) {
		
		List<EmployeeBean> listOfLeave = new ArrayList<EmployeeBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    LeaveBean leaveBean = null;;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("FROM EmployeeBean WHERE under_manager_id = '" + Manager_id + "'");
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
	
	
public List<LeaveAfterAddBean> getLeaveAddAfter(int leave_id) {
		
		List<LeaveAfterAddBean> listOfLeave = new ArrayList<LeaveAfterAddBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        Query query = session.createQuery("FROM LeaveAfterAddBean WHERE leaveBean = '" + leave_id + "'");
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

public List<LeaveHRBean> getLeaveHr() {
	
	List<LeaveHRBean> listOfLeaveHr = new ArrayList<LeaveHRBean>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;
    try {
        tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("FROM LeaveHRBean");
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
	

public List<LeaveHRBean> getLeaveHrByDate(String toDate, String fromDate) {
	
	List<LeaveHRBean> listOfLeaveHr = new ArrayList<LeaveHRBean>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;
    try {
        tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("FROM LeaveHRBean where From_Date  between '"+toDate+"' and '"+fromDate+"'");
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

public List<EmployeeBean> getListOfAllEmployeeByCompanyCodeOrEmpCode(String com_code , int emp_code)
{
    List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        listOfEmployee = session.createQuery("FROM EmployeeBean where companyListBean='"+com_code+"' and employee_code = '"+emp_code+"'").list();
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





}