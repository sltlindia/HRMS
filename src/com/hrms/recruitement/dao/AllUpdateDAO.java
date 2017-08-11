package com.hrms.recruitement.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.recruitement.bean.CityBean;
import com.hrms.recruitement.bean.DailyCallingDataBean;
import com.hrms.recruitement.bean.DesignationTemplateBean;
import com.hrms.recruitement.bean.PostGraduateQualificationBean;
import com.hrms.recruitement.bean.PostGraduateSpecificationBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.StateBean;
import com.hrms.recruitement.bean.UnderGraduateQualificationBean;
import com.hrms.recruitement.bean.UnderGraduateSpecificationBean;
import com.hrms.recruitement.bean.VacancyApprovalBean;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.controller.VacancyViewServlet;
import com.hrms.recruitement.util.HibernateUtil;

public class AllUpdateDAO {

	public boolean vacancyMdUpdate(String date, String status, int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			System.out.println(date);
			System.out.println(status);
			System.out.println(id);

			Query query = session.createQuery(
					"update VacancyFormBean set director_status = :ds ,ceo_status=:cs, hr_status=:hs, director_status_datetime = :dsd,approved_status =:as where vacancy_id = :vi ");
			query.setString("ds", status);
			query.setString("cs", status);
			query.setString("hs", status);
			query.setString("dsd", date);
			query.setString("as", status);
			query.setInteger("vi", id);
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

	public boolean vacancyHrUpdate(String date, String status, int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"update VacancyFormBean set hr_status = :ds ,hr_status_datetime = :dsd,approved_status =:as where vacancy_id = :vi ");
			query.setString("ds", status);
			query.setString("as", status);
			query.setString("dsd", date);
			query.setInteger("vi", id);
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

	public boolean vacancyCeoUpdate(String date, String status, int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"update VacancyFormBean set ceo_status = :cs ,ceo_status_datetime = :dsd,approved_status =:as,director_status = :ds,hod_status = :hs,hr_status =:hs1 where vacancy_id = :vi ");
			query.setString("cs", status);
			query.setString("as", status);
			query.setString("hs", status);
			query.setString("ds", status);
			query.setString("hs1", status);
			query.setString("dsd", date);
			query.setInteger("vi", id);
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

	public boolean vacancyHodUpdate(String date, String status, int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"update VacancyFormBean set hod_status = :ds ,hod_status_datetime = :dsd,approved_status=:as where vacancy_id = :vi ");
			query.setString("ds", status);
			query.setString("as", status);
			query.setString("dsd", date);
			query.setInteger("vi", id);
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

	public boolean vacancyUpdate(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update VacancyFormBean set approved_status = :as where vacancy_id = :vi ");
			query.setString("as", "approved");
			query.setInteger("vi", id);
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

	public boolean resumeDataUpdate(int id, String status, String date, int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update ResumeShareBean set status = :s,reply_date=:rd where resume_data_id = :rdi and employee_master_id = :emp");
			query.setString("s", status);
			query.setInteger("rdi", id);
			query.setString("rd", date);
			query.setInteger("emp", emp_id);
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

	public boolean resumeStatusUpdate(String status, int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			System.out.println(status);
			System.out.println(id);

			Query query = session.createQuery("update ResumeDataBean set status = :s where resume_data_id = :ri ");
			query.setString("s", status);
			query.setInteger("ri", id);
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

	public boolean vacancyStatusUpdate(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update VacancyFormBean set approved_status =:as where vacancy_id = :vi ");
			query.setString("as", "allocated");
			query.setInteger("vi", id);
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

	public boolean vacancyAllocationUpdate(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update VacancyAllocationBean set show_view =:sv where vacancy_allocation_id =:vai");
			query.setInteger("sv", 1);
			query.setInteger("vai", id);
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

	public boolean interviewTimeUpdate(int id, String first, String second, String third,String status) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"update ResumeShareBean set first_date_time =:fdt,second_date_time =:sdt,third_date_time =:tdt,show_view =:sv,status=:st  where resume_share_id =:iti");
			query.setString("fdt", first);
			query.setString("sdt", second);
			query.setString("tdt", third);
			query.setInteger("iti", id);
			query.setInteger("sv", 1);
			query.setString("st", status);
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

	public boolean feedbackUpdate(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("update InterviewFeedbackBean set decision=:dec where interview_feedback_id = :ifi ");
			query.setString("dec", "Offer Letter");
			query.setInteger("ifi", id);
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

	public boolean addRolesAuthoritySkillsInsert(DesignationTemplateBean designationTemplateBean) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(designationTemplateBean);
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

	public boolean benefitDeleted(int vacancy_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("delete VacancyBenefitsBean where vacancyFormBean = :vid");
			query.setInteger("vid", vacancy_id);
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

	public boolean interviewerDelete(int vacancy_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("delete InterviewedByBean where vacancyFormBean = :vid");
			query.setInteger("vid", vacancy_id);
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

	public boolean vacancyUpdateShowView(int show_view, int v_id, int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"update VacancyApprovalBean set show_view = :sv where vacancy_id = :vid AND employee_master_id= :ei");
			query.setInteger("sv", show_view);
			query.setInteger("vid", v_id);
			query.setInteger("ei", emp_id);
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

	public boolean vacancyApprovalStatusUpdate(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update VacancyApprovalBean set approval_status = 'updated' where vacancy_id = :vi ");
			query.setInteger("vi", id);
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

	public boolean vacancyApprovalStatusForwarded(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"update VacancyApprovalBean set approval_status = 'forwarded' where vacancy_id = :vi ");
			query.setInteger("vi", id);
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

	public boolean dailyCallingDataUpdate(int daily_calling_data_id, int vacancy_id, int source_of_resume_id,
			int department_id, int employee_master_id, String candidate_name, String current_location,
			String mobile_number, String email_id, String current_designation, String total_experience,
			String highest_qualification, String current_CTC, String expected_CTC, String notice_period, String status,
			String remarks, String offered_gross, String offered_CTC, String joining_date, String submission_date) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			DepartmentBean departmentBean = new DepartmentBean();
			departmentBean.setDepartment_id(department_id);

			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployee_master_id(employee_master_id);

			VacancyFormBean vacancyFormBean = new VacancyFormBean();
			vacancyFormBean.setVacancy_id(vacancy_id);

			SourceOfResumeBean sourceOfResumeBean = new SourceOfResumeBean();
			sourceOfResumeBean.setSource_of_resume_id(source_of_resume_id);

			DailyCallingDataBean dailyCallingDataBean = new DailyCallingDataBean();
			dailyCallingDataBean.setDaily_calling_data_id(daily_calling_data_id);

			dailyCallingDataBean.setVacancyFormBean(vacancyFormBean);
			dailyCallingDataBean.setSourceOfResumeBean(sourceOfResumeBean);
			dailyCallingDataBean.setDepartmentBean(departmentBean);
			dailyCallingDataBean.setEmployeeBean(employeeBean);
			dailyCallingDataBean.setCandidate_name(candidate_name);
			dailyCallingDataBean.setCurrent_location(current_location);
			dailyCallingDataBean.setMobile_number(mobile_number);
			dailyCallingDataBean.setEmail_id(email_id);
			dailyCallingDataBean.setCurrent_designation(current_designation);
			dailyCallingDataBean.setTotal_experience(total_experience);
			dailyCallingDataBean.setHighest_qualification(highest_qualification);
			dailyCallingDataBean.setCurrent_CTC(current_CTC);
			dailyCallingDataBean.setExpected_CTC(expected_CTC);
			dailyCallingDataBean.setNotice_period(notice_period);
			dailyCallingDataBean.setStatus(status);
			dailyCallingDataBean.setRemarks(remarks);
			dailyCallingDataBean.setOffered_gross(offered_gross);
			dailyCallingDataBean.setOffered_CTC(offered_CTC);
			dailyCallingDataBean.setJoining_date(joining_date);
			dailyCallingDataBean.setSubmission_date(submission_date);

			session.update(dailyCallingDataBean);
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
	
	public boolean inviteStatusUpdate(int id, String status) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update ResumeShareBean set status = :s where resume_data_id = :rdi ");
			query.setString("s", status);
			query.setInteger("rdi", id);
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
