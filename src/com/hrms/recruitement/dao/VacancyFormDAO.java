package com.hrms.recruitement.dao;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.CityBean;
import com.hrms.recruitement.bean.EducationalQualificationBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.bean.PostGraduateQualificationBean;
import com.hrms.recruitement.bean.PostGraduateSpecificationBean;
import com.hrms.recruitement.bean.StateBean;
import com.hrms.recruitement.bean.UnderGraduateQualificationBean;
import com.hrms.recruitement.bean.UnderGraduateSpecificationBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.util.HibernateUtil;

public class VacancyFormDAO {

	public boolean vacancyInsert(VacancyFormBean vacancyFormBean) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(vacancyFormBean);
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

	public boolean vacancyUpdate(int no_of_vacancy,int reporting_manager,String tentative_joining_date,
			String required_experience,String salary_range, String skillAndCompetencies,
			String reason_for_hire, String vacancy_type, String replacement_of, String title_of_position,
			String role_objective, String span_of_control, String internal_operating_network, 
			String external_operating_network, String personal_competencies, String key_performance_indicator, 
			int department_id, int manager_id, int state_id, int city_id, int under_graduate_qualification_id, 
			int under_graduate_specification_id,int post_graduate_qualification_id, int post_graduate_specification_id,
			String country, String role_description, int vacancy_id, String bill_limit, String submission_date, int employee_master_id) 
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			DepartmentBean departmentBean = new DepartmentBean();
			departmentBean.setDepartment_id(department_id);
			
			ManagerBean managerBean = new ManagerBean();
			managerBean.setManager_id(manager_id);
			
			StateBean stateBean = new StateBean();
			stateBean.setState_id(state_id);
			
			CityBean cityBean = new CityBean();
			cityBean.setCity_id(city_id);
			
			UnderGraduateQualificationBean underGraduateQualificationBean = new UnderGraduateQualificationBean();
			underGraduateQualificationBean.setUnder_graduate_qualification_id(under_graduate_qualification_id);
			
			UnderGraduateSpecificationBean underGraduateSpecificationBean = new UnderGraduateSpecificationBean();
			underGraduateSpecificationBean.setUnder_graduate_specification_id(under_graduate_specification_id);
			
			PostGraduateQualificationBean postGraduateQualificationBean = new PostGraduateQualificationBean();
			postGraduateQualificationBean.setPost_graduate_qualification_id(post_graduate_qualification_id);
			
			PostGraduateSpecificationBean postGraduateSpecificationBean = new PostGraduateSpecificationBean();
			postGraduateSpecificationBean.setPost_graduate_specification_id(post_graduate_specification_id);
			
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);
			
			VacancyFormBean vacancyFormBean = new VacancyFormBean();
			vacancyFormBean.setVacancy_id(vacancy_id);
			
			vacancyFormBean.setTitle_of_position(title_of_position);
			vacancyFormBean.setNo_of_vacancy(no_of_vacancy);
			vacancyFormBean.setTentative_joining_date(tentative_joining_date);
			vacancyFormBean.setDepartmentBean(departmentBean);
			vacancyFormBean.setReporting_manager(reporting_manager);
			vacancyFormBean.setRequired_experience(required_experience);
			vacancyFormBean.setSalary_range(salary_range);
			vacancyFormBean.setSkillandcompetencies(skillAndCompetencies);
			vacancyFormBean.setReason_for_hire(reason_for_hire);
			vacancyFormBean.setVacancy_type(vacancy_type);
			vacancyFormBean.setReplacement_of(replacement_of);
			vacancyFormBean.setManagerBean(managerBean);
			vacancyFormBean.setRole_objective(role_objective);
			vacancyFormBean.setSpan_of_control(span_of_control);
			vacancyFormBean.setInternal_operating_network(internal_operating_network);
			vacancyFormBean.setExternal_operating_network(external_operating_network);
			vacancyFormBean.setPersonal_competencies(personal_competencies); 
			vacancyFormBean.setKey_performance_indicator(key_performance_indicator);
			vacancyFormBean.setDepartmentBean(departmentBean);
			vacancyFormBean.setUnderGraduateQualificationBean(underGraduateQualificationBean);
			vacancyFormBean.setUnderGraduateSpecificationBean(underGraduateSpecificationBean);
			vacancyFormBean.setPostGraduateQualificationBean(postGraduateQualificationBean);
			vacancyFormBean.setPostGraduateSpecificationBean(postGraduateSpecificationBean);
			vacancyFormBean.setStateBean(stateBean);
			vacancyFormBean.setCityBean(cityBean);
			vacancyFormBean.setRole_description(role_description);
			vacancyFormBean.setCountry(country);
			vacancyFormBean.setBill_limit(bill_limit);
			vacancyFormBean.setSubmission_date(submission_date);
			vacancyFormBean.setEmployeeBean(employeeBean);
			
			session.update(vacancyFormBean);
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

	public boolean vacancyBenefits(VacancyBenefitsBean vacancyBenefitsBean) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(vacancyBenefitsBean);
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

	public boolean vacancyUpdate1(String reason, int v_id, int hr_approval, int director_approval, int hod_approval,
			int ceo, String status, String hrstatus, String ceostatus, String hodstatus, String directorstatus,
			String directordatetime, String hoddatetime, String ceodatetime, String hrdatetime) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		VacancyFormBean vacancyFormBean = new VacancyFormBean();

		try {
			tx = session.getTransaction();
			tx.begin();
			// Query query = session.createQuery("update EmployeeBean set
			// Privilege_Leave = :pl where employee_master_id = :empid");
			Query query = session.createQuery(
					"update VacancyFormBean set reason = :r, hr_approval = :ha, director_approval= :da, hod_approval = :hoa,"
							+ "ceo_approval = :ceo, approved_status = :s, hr_status = :hs, ceo_status = :cs, hod_status = :hos, director_status = :ds, "
							+ "director_status_datetime = :dsd, hod_status_datetime = :hosd, ceo_status_datetime = :csd, hr_status_datetime = :hsd  where vacancy_id = :vid");
			query.setString("r", reason);
			query.setInteger("ha", hr_approval);
			query.setInteger("da", director_approval);
			query.setInteger("hoa", hod_approval);
			query.setInteger("ceo", ceo);
			query.setString("s", status);
			query.setString("hs", hrstatus);
			query.setString("cs", ceostatus);
			query.setString("hos", hodstatus);
			query.setString("ds", directorstatus);
			query.setString("dsd", directordatetime);
			query.setString("hosd", hoddatetime);
			query.setString("csd", ceodatetime);
			query.setString("hsd", hrdatetime);
			query.setInteger("vid", v_id);
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

	public boolean vacancyUpdateBillLimit(String bill_limit, int v_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		VacancyFormBean vacancyFormBean = new VacancyFormBean();

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("update VacancyFormBean set bill_limit = :b where vacancy_id = :vid");
			query.setString("b", bill_limit);
			query.setInteger("vid", v_id);
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

	// update query for vacancy approval table by approveorreject.jsp page

	public boolean vacancyApproveRejectUpdate(String reason, int v_id, String approval_status, int employee_master_id,
			String approval_datetime) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		VacancyFormBean vacancyFormBean = new VacancyFormBean();

		try {
			tx = session.getTransaction();
			tx.begin();
			// Query query = session.createQuery("update EmployeeBean set
			// Privilege_Leave = :pl where employee_master_id = :empid");
			Query query = session.createQuery(
					"update VacancyApprovalBean set reason = :r, approval_status = :s, approval_datetime = :d where vacancy_id = :vid AND employee_master_id = :employee_master_id"
							+ "");
			query.setString("r", reason);
			query.setString("s", approval_status);
			query.setString("d", approval_datetime);
			query.setInteger("vid", v_id);
			query.setInteger("employee_master_id", employee_master_id);
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

}
