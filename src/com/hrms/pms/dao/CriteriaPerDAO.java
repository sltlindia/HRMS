package com.hrms.pms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.CriteriaPerBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.GradeMasterBean;
import com.hrms.pms.util.HibernateUtil;

public class CriteriaPerDAO {

	public CriteriaPerBean getCriteria() {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        CriteriaPerBean criteriaPerBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from CriteriaPerBean where default_criteria_per_id=1");
            criteriaPerBean = (CriteriaPerBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return criteriaPerBean;
    
	}
}
