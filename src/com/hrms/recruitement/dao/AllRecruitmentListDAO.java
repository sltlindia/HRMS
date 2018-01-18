package com.hrms.recruitement.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.dialect.lock.PessimisticReadUpdateLockingStrategy;
import org.hibernate.engine.query.ParameterParser.Recognizer;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.bean.InterviewedByBean;
import com.hrms.recruitement.bean.InterviewerPanelBean;
import com.hrms.recruitement.bean.LastEmploymentDetailCheckBean;
import com.hrms.recruitement.bean.NotifyToCandidateBean;
import com.hrms.recruitement.bean.OfferLetterBean;
import com.hrms.recruitement.bean.PersonalDetailCheckBean;
import com.hrms.recruitement.bean.PhilTestBean;
import com.hrms.recruitement.bean.PostGraduateQualificationBean;
import com.hrms.recruitement.bean.PostGraduateSpecificationBean;
import com.hrms.recruitement.bean.PreEmploymentArrangementBean;
import com.hrms.recruitement.bean.PriorEmploymentDetailCheckBean;
import com.hrms.recruitement.bean.ReferenceDetailCheckBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.bean.ResumeShareBean;
import com.hrms.recruitement.bean.SoftskillCriteriaBean;
import com.hrms.recruitement.bean.SourceOfResumeBean;
import com.hrms.recruitement.bean.StateBean;
import com.hrms.recruitement.bean.SubSoftskillCriteriaBean;
import com.hrms.recruitement.bean.SubTechnicalCriteriaBean;
import com.hrms.recruitement.bean.TechnicalCriteriaBean;
import com.hrms.recruitement.bean.UnderGraduateQualificationBean;
import com.hrms.recruitement.bean.UnderGraduateSpecificationBean;
import com.hrms.recruitement.bean.VacancyAllocationBean;
import com.hrms.recruitement.bean.VacancyApprovalBean;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.bean.VacancyGradeLevelBean;
import com.hrms.recruitement.bean.VacancyPayrollHrInfoBean;
import com.hrms.recruitement.bean.VacancytitleBean;
import com.hrms.recruitement.util.HibernateUtil;
import com.hrms.recruitement.bean.AcademicDetailCheckBean;
import com.hrms.recruitement.bean.AppointmentLetterBean;
import com.hrms.recruitement.bean.BenefitsBean;
import com.hrms.recruitement.bean.CandidateExamInfoBean;
import com.hrms.recruitement.bean.CandidateExamScoreBean;
import com.hrms.recruitement.bean.DailyCallingDataBean;
import com.hrms.recruitement.bean.DailyCallingStatusBean;
import com.hrms.recruitement.bean.DepartmentDesignationBean;
import com.hrms.recruitement.bean.DesignationTemplateBean;
import com.hrms.recruitement.bean.EducationalQualificationBean;
import com.hrms.recruitement.bean.FinalSelectionBean;
import com.hrms.recruitement.bean.HRInterviewFeedbackBean;
import com.hrms.recruitement.bean.HrSuggestBean;
import com.hrms.recruitement.bean.HrresumeBean;
import com.hrms.recruitement.bean.InductionFeedbackBean;
import com.hrms.recruitement.bean.InductionQABean;
import com.hrms.recruitement.bean.InterviewFeedbackBean;
import com.hrms.recruitement.bean.InterviewQaWithResumeidBean;
import com.hrms.recruitement.bean.InterviewQuestionBean;
import com.hrms.recruitement.bean.InterviewTimingBean;

public class AllRecruitmentListDAO {

	public List<EmployeeBean> getListOfEmployee() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE role_id=4").list();
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

	// Used at vacancyForm.jsp

	public List<BenefitsBean> getListOfBenefits() {
		List<BenefitsBean> listOfBenefits = new ArrayList<BenefitsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfBenefits = session.createQuery("FROM BenefitsBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfBenefits;

	}

	public List<VacancyFormBean> getListOfVacancy(int v_id) {
		List<VacancyFormBean> listofVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofVacancy = session.createQuery("from VacancyFormBean where vacancy_id='" + v_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofVacancy;
	}

	public List<InterviewedByBean> getListOfInterviewer(int v_id) {
		List<InterviewedByBean> listofInterview = new ArrayList<InterviewedByBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofInterview = session.createQuery("from InterviewedByBean where vacancyFormBean = " + v_id + "").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofInterview;
	}

	public List<Object[]> getListOfBenefits(int v_id) {
		List<Object[]> listofBenefits = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofBenefits = session.createQuery(
					"from VacancyBenefitsBean v inner join v.vacancyFormBean vf join v.benefitsBean b where vf.vacancy_id='"
							+ v_id + "'")
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
		return listofBenefits;
	}

	public List<VacancyBenefitsBean> getListOfBenefitss(int v_id) {
		List<VacancyBenefitsBean> listofBenefits = new ArrayList<VacancyBenefitsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofBenefits = session.createQuery("from VacancyBenefitsBean where vacancy_id='" + v_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofBenefits;
	}

	public List<VacancyFormBean> getListOfvacancyNotification(String name) {
		List<VacancyFormBean> listofVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofVacancy = session.createQuery(
					"from VacancyFormBean v inner join v.jobLocationBean j join v.departmentBean d where v.reporting_manager='"
							+ name + "'")
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
		return listofVacancy;
	}

	public List<VacancyFormBean> getListOfvacancymanager(int employee_id) {
		List<VacancyFormBean> listOfvacancymanager = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfvacancymanager = session
					.createQuery("FROM VacancyFormBean WHERE employeeBean = '" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfvacancymanager;

	}

	public List<VacancyFormBean> getListOfNotification(int employee_id) {
		List<VacancyFormBean> listOfvacancymanager = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfvacancymanager = session
					.createQuery("FROM VacancyFormBean WHERE employeeBean = '" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfvacancymanager;

	}

	public List<EmployeeBean> getFullListOfEmployee(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean where manager_id <'" + manager_id + "'").list();
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

	public List<ManagerBean> getNameOfManager(String id) {
		List<ManagerBean> NameOfManager = new ArrayList<ManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			NameOfManager = session.createQuery("FROM ManagerBean where manager_id='" + id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return NameOfManager;

	}

	public List<ManagerBean> getListOfManager() {
		List<ManagerBean> NameOfManager = new ArrayList<ManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			NameOfManager = session.createQuery("FROM ManagerBean order by manager_name asc").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return NameOfManager;
	}

	public List<VacancyFormBean> getListOfVacancy() {
		List<VacancyFormBean> getListOfVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfVacancy = session.createQuery("from VacancyFormBean where approved_status='pending'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getListOfVacancy;
	}

	public List<VacancyFormBean> getListOfVacancyBymanagerId(int manager_id) {
		List<VacancyFormBean> getListOfVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfVacancy = session.createQuery("from VacancyFormBean where managerBean='" + manager_id + "'")
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
		return getListOfVacancy;
	}

	public List<VacancyFormBean> getListOfPosition() {
		List<VacancyFormBean> listOfPosition = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPosition = session.createQuery("FROM VacancyFormBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPosition;

	}

	public List<Object[]> getListOfResume(int manager_id) {
		List<Object[]> listOfResume = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResume = session
					.createQuery("from ResumeDataBean r inner join r.vacancyFormBean v where v.managerBean = "
							+ manager_id + " group by v.vacancy_id")
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
		return listOfResume;

	}

	public List<Object[]> getListOfResumePerVacancyId(int vacancy_id) {
		List<Object[]> listOfResume = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResume = session
					.createQuery("from ResumeDataBean where vacancyFormBean= " + vacancy_id + " and status='pending'")
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
		return listOfResume;

	}

	public List<ResumeShareBean> getListOfCandidate(int resume_data_id, int employee_master_id) {
		List<ResumeShareBean> listOfCandidate = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCandidate = session.createQuery("FROM ResumeShareBean where resume_data_id= " + resume_data_id
					+ " and employee_master_id= " + employee_master_id + " and status='pending'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCandidate;

	}

	public List<ResumeDataBean> getListOfResumeByVacancyId(int vacancy_id) {
		List<ResumeDataBean> listOfCandidate = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCandidate = session.createQuery("FROM ResumeDataBean where vacancyFormBean= " + vacancy_id + "")
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
		return listOfCandidate;
	}

	public List<ResumeDataBean> getListOfResumeByVacancyIdInterested(int vacancy_id) {
		List<ResumeDataBean> listOfresume = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfresume = session
					.createQuery("FROM ResumeDataBean where vacancyFormBean= " + vacancy_id
							+ " and (status ='interested' or status='allocated' or status='notified' or status='interview completed' or status='')")
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
		return listOfresume;
	}

	public List<ResumeDataBean> getListOfResumeByVacancyIdInterested1(int vacancy_id) {
		List<ResumeDataBean> listOfresume = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfresume = session.createQuery(
					"FROM ResumeDataBean where vacancyFormBean= " + vacancy_id + " and (status ='interview completed')")
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
		return listOfresume;
	}

	public List<ResumeDataBean> getListOfResumeData(int resume_id) {
		List<ResumeDataBean> listOfResumeData = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResumeData = session.createQuery("FROM ResumeDataBean where resume_data_id = " + resume_id + "")
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
		return listOfResumeData;

	}

	public List<ResumeDataBean> getListOfResumeData() {
		List<ResumeDataBean> listOfResumeData = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResumeData = session.createQuery("FROM ResumeDataBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfResumeData;

	}

	public List<InterviewerPanelBean> getListOfInterviewerPanel() {
		List<InterviewerPanelBean> NameOfInterviewerPanel = new ArrayList<InterviewerPanelBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			NameOfInterviewerPanel = session.createQuery("FROM InterviewerPanelBean order by interviewer_name asc")
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
		return NameOfInterviewerPanel;
	}

	public List<ResumeShareBean> getListOfResumeByForManager(int employee_master_id) {
		List<ResumeShareBean> listOfCandidate = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCandidate = session
					.createQuery("FROM ResumeShareBean where resumeDataBean.vacancyFormBean.managerBean='"
							+ employee_master_id + "'")
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
		return listOfCandidate;

	}

	public List<ResumeDataBean> getListOfInterviewee(int resume_id) {
		List<ResumeDataBean> listOfCandidate = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCandidate = session
					.createQuery("FROM ResumeDataBean where status='interested' and resume_data_id='" + resume_id + "'")
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
		return listOfCandidate;
	}

	// used at aalInterviewFeedback.jsp for notified candidate

	public List<ResumeDataBean> getListOfAllocatedCandidate() {
		List<ResumeDataBean> ListOfAllocatedCandidate = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			ListOfAllocatedCandidate = session.createQuery("FROM ResumeDataBean where status='notified'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ListOfAllocatedCandidate;

	}

	public List<ResumeDataBean> getListOfAllocatedCandidate1() {
		List<ResumeDataBean> ListOfAllocatedCandidate = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			ListOfAllocatedCandidate = session.createQuery("FROM ResumeDataBean where status='shared'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ListOfAllocatedCandidate;

	}

	// for searching specific data String from resume data
	
	public List<ResumeDataBean> getListOfResumeDataSearchEngine(String skill) {
		List<ResumeDataBean> listOfResumeData = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResumeData = session
					.createQuery("FROM ResumeDataBean where  key_skills  LIKE '%" + skill + "%'")
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
		return listOfResumeData;
	}

	
	public List<HrresumeBean> getListOfResumeDataSearchEnginebyhr(String skill) {
		List<HrresumeBean> listOfResumeData = new ArrayList<HrresumeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResumeData = session
					.createQuery("FROM HrresumeBean where  key_skills  LIKE '%" + skill + "%'")
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
		return listOfResumeData;
	}
	
	public List<HrresumeBean> getListOfgetallResumeData(int id) {
		List<HrresumeBean> listOfResumeData = new ArrayList<HrresumeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResumeData = session
					.createQuery("FROM HrresumeBean where hr_resume_id = '" + id + "' ")
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
		return listOfResumeData;
	}
	
	public List<EmployeeBean> getListOfinterviewer() {
		List<EmployeeBean> listOfInterviewer = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session.createQuery("FROM EmployeeBean order by firstname ASC").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}

	public List<TechnicalCriteriaBean> getListOfTechnicalCriteria() {
		List<TechnicalCriteriaBean> listOfTechnicalCriteria = new ArrayList<TechnicalCriteriaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTechnicalCriteria = session.createQuery("FROM TechnicalCriteriaBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTechnicalCriteria;

	}

	public List<SoftskillCriteriaBean> getListOfSoftskillCriteria() {
		List<SoftskillCriteriaBean> listOfSoftskillCriteria = new ArrayList<SoftskillCriteriaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSoftskillCriteria = session.createQuery("FROM SoftskillCriteriaBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSoftskillCriteria;

	}

	public List<InterviewFeedbackBean> getListOfInterviewFeedback() {
		List<InterviewFeedbackBean> listOfInterviewFeedback = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewFeedback = session.createQuery("FROM InterviewFeedbackBean WHERE decision = 'selected'")
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
		return listOfInterviewFeedback;

	}

	public List<InterviewFeedbackBean> getListOfInterviewFeedbackByVacancy_id(int vacancy_id) {
		List<InterviewFeedbackBean> listOfInterviewFeedback = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewFeedback = session.createQuery(
					"FROM InterviewFeedbackBean WHERE vacancyFormBean='" + vacancy_id + "' and decision = 'selected'")
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
		return listOfInterviewFeedback;

	}

	public List<InterviewFeedbackBean> getListOfAllInterviewFeedback() {
		List<InterviewFeedbackBean> listOfAllInterviewFeedback = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllInterviewFeedback = session.createQuery("FROM InterviewFeedbackBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllInterviewFeedback;
	}

	public List<InterviewFeedbackBean> getListOfInterviewFeedback1(int interview_id) {
		List<InterviewFeedbackBean> listOfInterviewFeedback = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewFeedback = session
					.createQuery("FROM InterviewFeedbackBean WHERE interview_feedback_id='" + interview_id + "'")
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
		return listOfInterviewFeedback;
	}

	public List<OfferLetterBean> getListOfAllOfferLetter() {
		List<OfferLetterBean> listOfAllOfferLetter = new ArrayList<OfferLetterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllOfferLetter = session.createQuery("FROM OfferLetterBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllOfferLetter;
	}

	public List<OfferLetterBean> getListOfOfferLetter(int offer_letter_id) {
		List<OfferLetterBean> listofOfferLetter = new ArrayList<OfferLetterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofOfferLetter = session
					.createQuery("from OfferLetterBean where offer_letter_id='" + offer_letter_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofOfferLetter;
	}

	public List<OfferLetterBean> getListOfOfferLetterByFeedbackId(int feedback_id) {
		List<OfferLetterBean> listofOfferLetter = new ArrayList<OfferLetterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofOfferLetter = session
					.createQuery("from OfferLetterBean where interviewFeedbackBean='" + feedback_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofOfferLetter;
	}
	
	// used at automaticappointmentletter.jsp and GenerateAppointmentletterservlet
	
	public List<AppointmentLetterBean> getListOfAppointment(int appointment_letter_id) {
		List<AppointmentLetterBean> listofAppointment = new ArrayList<AppointmentLetterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofAppointment = session
					.createQuery("from AppointmentLetterBean where appointment_letter_id = '" + appointment_letter_id+ "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofAppointment;
	}

	public List<PreEmploymentArrangementBean> getListOfPreEmploymentArrangement(int pre_employment_arrangement_id) {
		List<PreEmploymentArrangementBean> listofPreEmploymentArrangement = new ArrayList<PreEmploymentArrangementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofPreEmploymentArrangement = session
					.createQuery("from PreEmploymentArrangementBean where pre_employment_arrangement_id='"
							+ pre_employment_arrangement_id + "'")
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
		return listofPreEmploymentArrangement;
	}

	public List<PreEmploymentArrangementBean> getListOfAllPreEmploymentArrangement() {
		List<PreEmploymentArrangementBean> listOfAllPreEmploymentArrangement = new ArrayList<PreEmploymentArrangementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllPreEmploymentArrangement = session.createQuery("FROM PreEmploymentArrangementBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllPreEmploymentArrangement;
	}

	public List<InductionFeedbackBean> getListOfAllInductionFeedback() {
		List<InductionFeedbackBean> listOfAllInductionFeedback = new ArrayList<InductionFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllInductionFeedback = session.createQuery("FROM InductionFeedbackBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllInductionFeedback;
	}

	public List<InductionFeedbackBean> getListOfInductionFeedback(int induction_feedback_id) {
		List<InductionFeedbackBean> listofInductionFeedback = new ArrayList<InductionFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofInductionFeedback = session
					.createQuery(
							"from InductionFeedbackBean where induction_feedback_id ='" + induction_feedback_id + "'")
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
		return listofInductionFeedback;
	}

	public List<InductionQABean> getListOfAllInductionQA() {
		List<InductionQABean> listOfAllInductionQA = new ArrayList<InductionQABean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllInductionQA = session.createQuery("FROM InductionQABean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllInductionQA;
	}

	public List<InductionQABean> getListOfInductionQA(int induction_qa_id) {
		List<InductionQABean> listofInductionFeedback = new ArrayList<InductionQABean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofInductionFeedback = session
					.createQuery("from InductionQABean where induction_qa_id ='" + induction_qa_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofInductionFeedback;
	}

	public List<CandidateExamScoreBean> getListOfAllCandidateExamScore() {
		List<CandidateExamScoreBean> listOfAllCandidateExamScore = new ArrayList<CandidateExamScoreBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllCandidateExamScore = session.createQuery("FROM CandidateExamScoreBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllCandidateExamScore;
	}

	public List<CandidateExamScoreBean> getListOfAllCandidateExamScoreByResumeID(int resume_id) {
		List<CandidateExamScoreBean> listOfAllCandidateExamScore = new ArrayList<CandidateExamScoreBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllCandidateExamScore = session
					.createQuery("FROM CandidateExamScoreBean where resumeDataBean = '" + resume_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllCandidateExamScore;
	}

	public List<CandidateExamScoreBean> getListOfCandidateExamScore(int candidate_exam_score_id) {
		List<CandidateExamScoreBean> listofCandidateExamScore = new ArrayList<CandidateExamScoreBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofCandidateExamScore = session.createQuery(
					"from CandidateExamScoreBean where candidate_exam_score_id ='" + candidate_exam_score_id + "'")
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
		return listofCandidateExamScore;
	}

	public List<VacancyFormBean> getListOfVacancyByDate(String startDate, String endDate, int dept_id) {
		List<VacancyFormBean> listofVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			if (dept_id != 0) {
				listofVacancy = session.createQuery("from VacancyFormBean where departmentBean='" + dept_id
						+ "' and (submission_date BETWEEN '" + startDate + "' AND '" + endDate
						+ "') and (ceo_status = 'approved' or hr_status='approved')").list();
			} else {
				listofVacancy = session.createQuery("from VacancyFormBean where submission_date BETWEEN '" + startDate
						+ "' AND '" + endDate + "' and (ceo_status = 'approved' or hr_status='approved')").list();
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
		return listofVacancy;
	}

	public List<VacancyFormBean> getListOfVacancyByDateByRecruiter(String startDate, String endDate, int employee_id) {
		List<VacancyFormBean> listofVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			if (employee_id != 0) {
				listofVacancy = session.createQuery("from VacancyFormBean where employeeBean='" + employee_id
						+ "' and (submission_date BETWEEN '" + startDate + "' AND '" + endDate
						+ "') and (ceo_status = 'approved' or hr_status='approved')").list();
			} else {
				listofVacancy = session.createQuery("from VacancyFormBean where submission_date BETWEEN '" + startDate
						+ "' AND '" + endDate + "' and (ceo_status = 'approved' or hr_status='approved')").list();
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
		return listofVacancy;
	}

	public List<ResumeDataBean> getListOfResumeForInterviewSchedual(int vacancy_id) {
		List<ResumeDataBean> listOfresume = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfresume = session
					.createQuery(
							"FROM ResumeDataBean where vacancyFormBean= " + vacancy_id + " and status='allocated')")
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
		return listOfresume;
	}

	public List<InterviewFeedbackBean> getListOfAllInterviewFeedbackByvacancyId(int vacancy_id) {
		List<InterviewFeedbackBean> listOfAllInterviewFeedback = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllInterviewFeedback = session
					.createQuery("FROM InterviewFeedbackBean where vacancyFormBean = '" + vacancy_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllInterviewFeedback;
	}

	public List<OfferLetterBean> getListOfOfferLetterByVacancyId(int vacancy_id) {
		List<OfferLetterBean> listOfAllOfferLetter = new ArrayList<OfferLetterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllOfferLetter = session
					.createQuery("FROM OfferLetterBean where vacancyFormBean='" + vacancy_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllOfferLetter;
	}

	public List<CandidateExamInfoBean> getListOfCandidateForExam(int resume_id) {
		List<CandidateExamInfoBean> listOfAllCandidate = new ArrayList<CandidateExamInfoBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllCandidate = session
					.createQuery("FROM CandidateExamInfoBean where resumeDataBean='" + resume_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllCandidate;
	}

	public List<VacancyFormBean> getListOfAllVacancy() {
		List<VacancyFormBean> getListOfVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfVacancy = session.createQuery("from VacancyFormBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getListOfVacancy;
	}

	public List<NotifyToCandidateBean> getListOfCandidateDetail(int resume_data_id) {
		List<NotifyToCandidateBean> getListOfCandidateDetail = new ArrayList<NotifyToCandidateBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfCandidateDetail = session
					.createQuery(
							"from NotifyToCandidateBean where resumeDataBean.resume_data_id = '" + resume_data_id + "'")
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
		return getListOfCandidateDetail;
	}

	public List<SubTechnicalCriteriaBean> getListOfAllTechnical() {
		List<SubTechnicalCriteriaBean> listOfAllOfTechnical = new ArrayList<SubTechnicalCriteriaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllOfTechnical = session.createQuery("FROM SubTechnicalCriteriaBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllOfTechnical;
	}

	public List<SubSoftskillCriteriaBean> getListOfAllSoftskill() {
		List<SubSoftskillCriteriaBean> listOfAllOfSoftskill = new ArrayList<SubSoftskillCriteriaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllOfSoftskill = session.createQuery("FROM SubSoftskillCriteriaBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllOfSoftskill;
	}

	public List<VacancyFormBean> getListOfAllVacancyForAllocation() {
		List<VacancyFormBean> getListOfVacancy = new ArrayList<VacancyFormBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			getListOfVacancy = session.createQuery("from VacancyFormBean where approved_status='approved'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getListOfVacancy;
	}

	public List<VacancyAllocationBean> getListOfVacancyAllocation(int employee_id) {
		List<VacancyAllocationBean> listOfAllocatedVacancy = new ArrayList<VacancyAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedVacancy = session
					.createQuery(
							"FROM VacancyAllocationBean WHERE employeeBean = '" + employee_id + "' and show_view=0")
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
		return listOfAllocatedVacancy;

	}

	public List<VacancyAllocationBean> getListOfVacancyAllocation1(int employee_id) {
		List<VacancyAllocationBean> listOfAllocatedVacancy = new ArrayList<VacancyAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedVacancy = session
					.createQuery("FROM VacancyAllocationBean WHERE employeeBean = '" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedVacancy;

	}

	public List<VacancyAllocationBean> getListOfVacancyAllAllocation(int employee_id) {
		List<VacancyAllocationBean> listOfAllocatedVacancy = new ArrayList<VacancyAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedVacancy = session
					.createQuery("FROM VacancyAllocationBean WHERE employeeBean = '" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedVacancy;

	}

	public List<ResumeDataBean> getListOfAllResumeByVacancyId(int vacancy_id) {
		List<ResumeDataBean> listOfresume = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfresume = session.createQuery("FROM ResumeDataBean where vacancyFormBean= " + vacancy_id + "").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfresume;
	}

	public List<SourceOfResumeBean> getListOfAllRecruiter() {
		List<SourceOfResumeBean> listOfResumeRecruiter = new ArrayList<SourceOfResumeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfResumeRecruiter = session.createQuery("FROM SourceOfResumeBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfResumeRecruiter;
	}

	public List<InterviewedByBean> getListOfInterviewerByVacncyId(int vacancy_id) {
		List<InterviewedByBean> listOfInterviewer = new ArrayList<InterviewedByBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session
					.createQuery("FROM InterviewedByBean where vacancyFormBean = '" + vacancy_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}

	public List<ResumeShareBean> getListOfInterviewByEmployeeID(int employee_id) {
		List<ResumeShareBean> listOfInterviewer = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session.createQuery("FROM ResumeShareBean where employeeBean = '" + employee_id
					+ "' and show_view = 0 and resumeDataBean.status = 'Invited'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}

	public List<ResumeShareBean> getListOfInterviewByEmployeeID1(int employee_id) {
		List<ResumeShareBean> listOfInterviewer = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session.createQuery("FROM ResumeShareBean where employeeBean = '" + employee_id + "'")
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
		return listOfInterviewer;
	}

	public List<InterviewTimingBean> getListOfInterviewByEmployeeID2(int employee_id) {
		List<InterviewTimingBean> listOfInterviewer = new ArrayList<InterviewTimingBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session
					.createQuery("FROM InterviewTimingBean where employeeBean = '" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}

	public List<InterviewTimingBean> getListOfInterviewByVacncyId(int vacancy_id) {
		List<InterviewTimingBean> listOfInterviewer = new ArrayList<InterviewTimingBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session
					.createQuery("FROM InterviewTimingBean where resumeDataBean.vacancyFormBean = '" + vacancy_id + "'")
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
		return listOfInterviewer;
	}

	public List<ResumeShareBean> getListOfInterviewByResumeID(int resume_id) {
		List<ResumeShareBean> listOfInterviewer = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session.createQuery("FROM ResumeShareBean where resumeDataBean = '" + resume_id + "'")
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
		return listOfInterviewer;
	}

	public List<NotifyToCandidateBean> getListOfInterviewByResumeId(int resume_id) {
		List<NotifyToCandidateBean> listOfInterviewer = new ArrayList<NotifyToCandidateBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session.createQuery("FROM NotifyToCandidateBean where resumeDataBean= '" + resume_id
					+ "' and resumeDataBean.status='notified'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}

	public List<NotifyToCandidateBean> getListOfInterviewByResumeId1(int resume_id) {
		List<NotifyToCandidateBean> listOfInterviewer = new ArrayList<NotifyToCandidateBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session
					.createQuery("FROM NotifyToCandidateBean where resumeDataBean= '" + resume_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}

	
	public List<ResumeDataBean> getListOfupdateinterviewdate(int resume_id) {
		List<ResumeDataBean> listOfInterviewer = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session
					.createQuery("FROM ResumeDataBean where vacancyFormBean = '" + resume_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}
	
	public List<ResumeDataBean> getListOfupdateinterviewdate23(int resume_id) {
		List<ResumeDataBean> listOfInterviewer = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session
					.createQuery("FROM NotifyToCandidateBean where resumeDataBean = '" + resume_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewer;
	}
	
	
	public List<InterviewFeedbackBean> getListOfAllInterviewFeedbackByResumeId(int vacancy_id) {
		List<InterviewFeedbackBean> listOfAllInterviewFeedback = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllInterviewFeedback = session
					.createQuery("FROM InterviewFeedbackBean where resumeDataBean.vacancyFormBean='" + vacancy_id + "'")
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
		return listOfAllInterviewFeedback;
	}

	public List<DepartmentDesignationBean> getListOfAllDepartmentDesignation() {
		List<DepartmentDesignationBean> listOfDepartmentDesignation = new ArrayList<DepartmentDesignationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartmentDesignation = session.createQuery("FROM DepartmentDesignationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDepartmentDesignation;
	}

	public List<DepartmentDesignationBean> getListOfDepartmentDesignationByDeptId(int dept_id) {
		List<DepartmentDesignationBean> listOfDepartmentDesignation = new ArrayList<DepartmentDesignationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartmentDesignation = session
					.createQuery("FROM DepartmentDesignationBean where departmentBean='" + dept_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDepartmentDesignation;
	}

	public List<DesignationTemplateBean> getListOfAllDesignationTemplate(int id) {
		List<DesignationTemplateBean> listOfDepartmentDesignation = new ArrayList<DesignationTemplateBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartmentDesignation = session
					.createQuery("FROM DesignationTemplateBean where departmentDesignationBean='" + id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDepartmentDesignation;
	}

	public List<AppointmentLetterBean> getListOfAllAppointmentLetter() {
		List<AppointmentLetterBean> listOfAppointmentLetter = new ArrayList<AppointmentLetterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAppointmentLetter = session.createQuery("FROM AppointmentLetterBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppointmentLetter;
	}

	public List<ResumeDataBean> getListOfAllResume1() {
		List<ResumeDataBean> listOfAllResume = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllResume = session.createQuery("FROM ResumeDataBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllResume;
	}

	public List<VacancyAllocationBean> getListOfAllRecruiterVacancy(int employee_id) {
		List<VacancyAllocationBean> listOfAllRecruiterVacancy = new ArrayList<VacancyAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllRecruiterVacancy = session
					.createQuery("FROM VacancyAllocationBean where employeeBean = '" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllRecruiterVacancy;
	}

	public List<ResumeDataBean> getListOfCandidateByEmployee(int vacancy_id, int employee_id) {
		List<ResumeDataBean> listOfCandidateByEmployee = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCandidateByEmployee = session.createQuery("FROM ResumeDataBean where employeeBean = '" + employee_id
					+ "' and vacancyFormBean = '" + vacancy_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCandidateByEmployee;
	}

	public List<ResumeDataBean> getListOfResumeByVacancyIdTimeGiven(int vacancy_id) {
		List<ResumeDataBean> listOfresume = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfresume = session
					.createQuery("FROM ResumeDataBean where vacancyFormBean= " + vacancy_id + " and status ='Invited'")
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
		return listOfresume;
	}

	public List<ResumeShareBean> getListOfInterviewByVacncyId1(int resume_id) {
		List<ResumeShareBean> listOfInterviewer = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewer = session.createQuery("FROM ResumeShareBean where resumeDataBean = '" + resume_id + "'")
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
		return listOfInterviewer;
	}

	public List<ResumeDataBean> getListOfInterviewee1(int resume_id) {
		List<ResumeDataBean> listOfCandidate = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCandidate = session
					.createQuery("FROM ResumeDataBean where status='notified' and resume_data_id='" + resume_id + "'")
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
		return listOfCandidate;
	}

	public List<InterviewQuestionBean> getListOfAllInterviewQuestion() {
		List<InterviewQuestionBean> listOfAllInterviewQuestion = new ArrayList<InterviewQuestionBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllInterviewQuestion = session.createQuery("FROM InterviewQuestionBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllInterviewQuestion;
	}

	public List<VacancyAllocationBean> getListOfVacancyAllocationByVacancyID(int vacancy_id) {
		List<VacancyAllocationBean> listOfVacancy = new ArrayList<VacancyAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfVacancy = session
					.createQuery("FROM VacancyAllocationBean where vacancyFormBean ='" + vacancy_id + "' ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfVacancy;
	}

	public List<InterviewQaWithResumeidBean> getListOfInterviewQuestionAnswerByResumeId(int resume_id) {
		List<InterviewQaWithResumeidBean> listOfInterviewQA = new ArrayList<InterviewQaWithResumeidBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfInterviewQA = session
					.createQuery("FROM InterviewQaWithResumeidBean where resumeDataBean = '" + resume_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfInterviewQA;
	}

	public List<EducationalQualificationBean> getListOfEducationalQualification() {
		List<EducationalQualificationBean> listOfEducationalQualification = new ArrayList<EducationalQualificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEducationalQualification = session
					.createQuery("FROM EducationalQualificationBean order by educational_qualification_name asc")
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
		return listOfEducationalQualification;
	}

	public List<InterviewFeedbackBean> getListOfOfferLatteredCandidate() {
		List<InterviewFeedbackBean> listOfOfferLetterCandidate = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfOfferLetterCandidate = session
					.createQuery("FROM InterviewFeedbackBean where decision = 'Offer Letter'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfOfferLetterCandidate;
	}

	public List<PersonalDetailCheckBean> getListOfPersonalDetailCheck() {
		List<PersonalDetailCheckBean> listOfPersonalDetailCheck = new ArrayList<PersonalDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPersonalDetailCheck = session.createQuery("FROM PersonalDetailCheckBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPersonalDetailCheck;
	}

	public List<PersonalDetailCheckBean> getListOfPersonalDetailCheck1(int personal_detail_check_id) {
		List<PersonalDetailCheckBean> listOfPersonalDetailCheck = new ArrayList<PersonalDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPersonalDetailCheck = session.createQuery(
					"FROM PersonalDetailCheckBean where personal_detail_check_id='" + personal_detail_check_id + "'")
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
		return listOfPersonalDetailCheck;
	}

	public List<AcademicDetailCheckBean> getListOfAcademicDetailCheck() {
		List<AcademicDetailCheckBean> listOfAcademicDetailCheck = new ArrayList<AcademicDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAcademicDetailCheck = session.createQuery("FROM AcademicDetailCheckBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAcademicDetailCheck;
	}

	public List<AcademicDetailCheckBean> getListOfAcademicDetailCheck1(int academic_detail_check_id) {
		List<AcademicDetailCheckBean> listOfAcademicDetailCheck = new ArrayList<AcademicDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAcademicDetailCheck = session.createQuery(
					"FROM AcademicDetailCheckBean where academic_detail_check_id='" + academic_detail_check_id + "'")
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
		return listOfAcademicDetailCheck;
	}

	public List<LastEmploymentDetailCheckBean> getListOfLastEmploymentDetailCheck() {
		List<LastEmploymentDetailCheckBean> listOfLastEmploymentDetailCheck = new ArrayList<LastEmploymentDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLastEmploymentDetailCheck = session.createQuery("FROM LastEmploymentDetailCheckBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfLastEmploymentDetailCheck;
	}

	public List<LastEmploymentDetailCheckBean> getListOfLastEmploymentlDetailCheck1(
			int last_employment_detail_check_id) {
		List<LastEmploymentDetailCheckBean> listOfLastEmploymentDetailCheck = new ArrayList<LastEmploymentDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfLastEmploymentDetailCheck = session
					.createQuery("FROM LastEmploymentDetailCheckBean where last_employment_detail_check_id='"
							+ last_employment_detail_check_id + "'")
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
		return listOfLastEmploymentDetailCheck;
	}

	public List<PriorEmploymentDetailCheckBean> getListOfPriorEmploymentDetailCheck() {
		List<PriorEmploymentDetailCheckBean> listOfPriorEmploymentDetailCheck = new ArrayList<PriorEmploymentDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPriorEmploymentDetailCheck = session.createQuery("FROM PriorEmploymentDetailCheckBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPriorEmploymentDetailCheck;
	}

	public List<PriorEmploymentDetailCheckBean> getListOfPriorEmploymentlDetailCheck1(
			int prior_employment_detail_check_id) {
		List<PriorEmploymentDetailCheckBean> listOfPriorEmploymentDetailCheck = new ArrayList<PriorEmploymentDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPriorEmploymentDetailCheck = session
					.createQuery("FROM PriorEmploymentDetailCheckBean where prior_employment_detail_check_id='"
							+ prior_employment_detail_check_id + "'")
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
		return listOfPriorEmploymentDetailCheck;
	}

	public List<ReferenceDetailCheckBean> getListOfReferenceDetailCheck() {
		List<ReferenceDetailCheckBean> listOfReferenceEmploymentDetailCheck = new ArrayList<ReferenceDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfReferenceEmploymentDetailCheck = session.createQuery("FROM ReferenceDetailCheckBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReferenceEmploymentDetailCheck;
	}

	public List<ReferenceDetailCheckBean> getListOfReferenceDetailCheck1(int reference_detail_check_id) {
		List<ReferenceDetailCheckBean> listOfReferenceDetailCheck = new ArrayList<ReferenceDetailCheckBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfReferenceDetailCheck = session.createQuery(
					"FROM ReferenceDetailCheckBean where reference_detail_check_id='" + reference_detail_check_id + "'")
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
		return listOfReferenceDetailCheck;
	}

	public List<ResumeDataBean> getListOfAllResumeByEmployeeId(int employee_master_id) {
		List<ResumeDataBean> listOfAllResumeByEmployeeId = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllResumeByEmployeeId = session.createQuery(
					"FROM ResumeDataBean where employee_master_id = '" + employee_master_id + "' and status='pending' ")
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
		return listOfAllResumeByEmployeeId;
	}

	public List<EmployeeBean> getListOfTopManagement() {
		List<EmployeeBean> listOfTopManagement = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTopManagement = session
					.createQuery(
							"FROM EmployeeBean where roleBean = '1' OR roleBean = '2' OR roleBean = '3' OR roleBean = '71' ")
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
		return listOfTopManagement;
	}

	public List<PhilTestBean> getListOfAllPhilTestScore() {
		List<PhilTestBean> listOfAllPhilTestScore = new ArrayList<PhilTestBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllPhilTestScore = session.createQuery("FROM PhilTestBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllPhilTestScore;
	}

	public List<PhilTestBean> getListOfPhilTest(int phil_test_id) {
		List<PhilTestBean> listofPhilTest = new ArrayList<PhilTestBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofPhilTest = session.createQuery("from PhilTestBean where phil_test_id ='" + phil_test_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listofPhilTest;
	}

	// Used at vacancyForm.jsp for interviewer

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

	public List<VacancyApprovalBean> getListForVacancyNotification(int employee_id) {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery("FROM VacancyApprovalBean WHERE employeeBean = '" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<VacancyApprovalBean> getListForUniqueInsert() {
		List<VacancyApprovalBean> listForUniqueInsert = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForUniqueInsert = session.createQuery("FROM VacancyApprovalBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForUniqueInsert;
	}

	public List<VacancyApprovalBean> getListForVacancyNotificationByEmployeeId(int employee_id) {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session.createQuery("FROM VacancyApprovalBean WHERE employeeBean = '"
					+ employee_id + "' and (approval_status = 'updated' OR approval_status = 'pending')").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<InterviewedByBean> getListOfInterviewer1(int vacancy_id) {
		List<InterviewedByBean> listForVacancyNotification = new ArrayList<InterviewedByBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery("FROM InterviewedByBean WHERE vacancyFormBean = '" + vacancy_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	// used at vacancyForm.jsp for State dropdown

	public List<StateBean> getListOfState() {
		List<StateBean> listOfState = new ArrayList<StateBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfState = session.createQuery("FROM StateBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfState;
	}

	// used at vacancyForm.jsp for list of undergraduate Qualification

	public List<UnderGraduateQualificationBean> getListOfUnderGraduateQualification() {
		List<UnderGraduateQualificationBean> listOfUnderGraduateQualification = new ArrayList<UnderGraduateQualificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfUnderGraduateQualification = session.createQuery("FROM UnderGraduateQualificationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfUnderGraduateQualification;
	}

	// used at vacancyForm.jsp for list of undergraduate Specialization

	public List<UnderGraduateSpecificationBean> getListOfUnderGraduateSpecification() {
		List<UnderGraduateSpecificationBean> listOfUnderGraduateSpecification = new ArrayList<UnderGraduateSpecificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfUnderGraduateSpecification = session.createQuery("FROM UnderGraduateSpecificationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfUnderGraduateSpecification;
	}

	// used at vacancyForm.jsp for list of Post Graduate Qualification

	public List<PostGraduateQualificationBean> getListOfPostGraduateQualification() {
		List<PostGraduateQualificationBean> listOfPostGraduateQualification = new ArrayList<PostGraduateQualificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPostGraduateQualification = session.createQuery("FROM PostGraduateQualificationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPostGraduateQualification;
	}

	// used at vacancyForm.jsp for list of Post Graduate Specialization

	public List<PostGraduateSpecificationBean> getListOfPostGraduateSpecification() {
		List<PostGraduateSpecificationBean> listOfPostGraduateSpecification = new ArrayList<PostGraduateSpecificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPostGraduateSpecification = session.createQuery("FROM PostGraduateSpecificationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPostGraduateSpecification;
	}

	public List<VacancyBenefitsBean> getListOfAllBenefits(int vacancy_id) {
		List<VacancyBenefitsBean> listOfAllBenefits = new ArrayList<VacancyBenefitsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllBenefits = session.createQuery("FROM VacancyBenefitsBean where vacancy_id = '" + vacancy_id + "'")
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
		return listOfAllBenefits;
	}

	public List<VacancyApprovalBean> getListForVacancyNotificationForTopmanagement(int vacancy_id) {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session.createQuery("FROM VacancyApprovalBean WHERE vacancy_id= '" + vacancy_id
					+ "' and approval_number = '0' and approval_status = 'approved'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<VacancyApprovalBean> getListForVacancyNotificationForTopmanagementEntry(int vacancy_id) {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery(
							"FROM VacancyApprovalBean WHERE vacancy_id= '" + vacancy_id + "' and approval_number = '1'")
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
		return listForVacancyNotification;
	}

	public List<VacancyApprovalBean> getListForVacancyNotificationForHr(int vacancy_id) {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session.createQuery("FROM VacancyApprovalBean WHERE vacancy_id= '" + vacancy_id
					+ "' and approval_number = '0' and approval_status = 'approved'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<VacancyApprovalBean> getListOfVacancyForApproveReject(int vacancy_id) {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery("FROM VacancyApprovalBean WHERE vacancy_id = '" + vacancy_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<VacancyApprovalBean> getListOfVacancyForReason(int vacancy_id) {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session.createQuery(
					"FROM VacancyApprovalBean WHERE vacancy_id = '" + vacancy_id + "' AND approval_status = 'modified'")
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
		return listForVacancyNotification;
	}

	public List<VacancyApprovalBean> getListOfVacancyForForward() {
		List<VacancyApprovalBean> listForVacancyNotification = new ArrayList<VacancyApprovalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session.createQuery("FROM VacancyApprovalBean  GROUP BY vacancy_id").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<VacancyPayrollHrInfoBean> getListOfVacancyForHrPerson(int vacancy_id) {
		List<VacancyPayrollHrInfoBean> listForVacancyNotification = new ArrayList<VacancyPayrollHrInfoBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery("FROM VacancyPayrollHrInfoBean WHERE vacancy_id = '" + vacancy_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<VacancyGradeLevelBean> getListOfGradeForVacancy() {
		List<VacancyGradeLevelBean> listForVacancyNotification = new ArrayList<VacancyGradeLevelBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery("FROM VacancyGradeLevelBean order by vacancy_grade_name ASC").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<VacancyGradeLevelBean> getListOfVacancyTargatedDays(int vacancy_grade_level_id) {
		List<VacancyGradeLevelBean> listForVacancyNotification = new ArrayList<VacancyGradeLevelBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session.createQuery(
					"FROM VacancyGradeLevelBean WHERE vacancy_grade_level_id = '" + vacancy_grade_level_id + "'")
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
		return listForVacancyNotification;
	}

	public List<DailyCallingDataBean> getListOfDailyCallingData() {
		List<DailyCallingDataBean> listForVacancyNotification = new ArrayList<DailyCallingDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session.createQuery("FROM DailyCallingDataBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<DailyCallingDataBean> getListOfDailyCallingDataById(int id) {
		List<DailyCallingDataBean> listForVacancyNotification = new ArrayList<DailyCallingDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery("FROM DailyCallingDataBean where daily_calling_data_id='" + id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<DailyCallingDataBean> getListOfDailyCallingDataByEmpId(int id) {
		List<DailyCallingDataBean> listForVacancyNotification = new ArrayList<DailyCallingDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listForVacancyNotification = session
					.createQuery("FROM DailyCallingDataBean where employee_master_id ='" + id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listForVacancyNotification;
	}

	public List<ResumeDataBean> getListOfSharedResumeByEmployee(int employee_master_id) {
		List<ResumeDataBean> listOfAllResumeByEmployeeId = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllResumeByEmployeeId = session.createQuery(
					"FROM ResumeDataBean where employee_master_id = '" + employee_master_id + "' and status='shared'")
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
		return listOfAllResumeByEmployeeId;
	}

	public List<ResumeShareBean> getListOfResumeForApproveReject(int employee_master_id) {
		List<ResumeShareBean> listOfAllResumeByEmployeeId = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllResumeByEmployeeId = session.createQuery(
					"FROM ResumeShareBean where employee_master_id = '" + employee_master_id + "' and status='pending'")
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
		return listOfAllResumeByEmployeeId;
	}

	public List<ResumeShareBean> getListOfResumeShare() {
		List<ResumeShareBean> listOfAllResumeByEmployeeId = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllResumeByEmployeeId = session.createQuery("FROM ResumeShareBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllResumeByEmployeeId;
	}

	public List<ResumeShareBean> getListOfCandidateWithResumeId(int resume_data_id) {
		List<ResumeShareBean> listOfCandidate = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCandidate = session.createQuery("FROM ResumeShareBean where resume_data_id= " + resume_data_id + "")
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
		return listOfCandidate;

	}

	// used at vacancyForm.jsp and viewResumeDataForManager.jsp for list of
	// Daily calling status

	public List<DailyCallingStatusBean> getListOfDailyCallingStatus() {
		List<DailyCallingStatusBean> listOfStatus = new ArrayList<DailyCallingStatusBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfStatus = session.createQuery("FROM DailyCallingStatusBean order by daily_calling_status_name asc")
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
		return listOfStatus;
	}

	// Used at allResumeList.jsp for list of all the resume filled by employee.

	public List<ResumeDataBean> getListOfAllResumeByEmployee(int employee_master_id) {
		List<ResumeDataBean> listOfAllResumeByEmployeeId = new ArrayList<ResumeDataBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllResumeByEmployeeId = session
					.createQuery("FROM ResumeDataBean where employee_master_id = '" + employee_master_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllResumeByEmployeeId;
	}

	// used at interviewfeedback.jsp

	public List<HRInterviewFeedbackBean> getListOfHrInterview(int resume_data_id) {
		List<HRInterviewFeedbackBean> listOfAllResumeByEmployeeId = new ArrayList<HRInterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllResumeByEmployeeId = session
					.createQuery("FROM HRInterviewFeedbackBean where resume_data_id = '" + resume_data_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllResumeByEmployeeId;
	}

	// used at resumeSharedWith.jsp for knowing resume shared with

	public List<ResumeShareBean> getListOfSharedPerson(int resume_data_id) {
		List<ResumeShareBean> ListOfAllocatedCandidate = new ArrayList<ResumeShareBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			ListOfAllocatedCandidate = session
					.createQuery("FROM ResumeShareBean where resume_data_id='" + resume_data_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ListOfAllocatedCandidate;
	}

	// used at resumeSharedWith.jsp for interview feedback form

	public List<InterviewFeedbackBean> getListOfPerticularInterview(int resume_data_id, int employee_master_id) {
		List<InterviewFeedbackBean> ListOfAllocatedCandidate = new ArrayList<InterviewFeedbackBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			ListOfAllocatedCandidate = session
					.createQuery("FROM InterviewFeedbackBean where resume_data_id='" + resume_data_id + "' and employee_master_id = '"+employee_master_id+"'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ListOfAllocatedCandidate;
	}
	
	// used at resumeDataSearchEngineWithData.jsp 

		public List<HrSuggestBean> getListOfSuggestedResume(int vacancy_id) {
			List<HrSuggestBean> ListOfAllocatedCandidate = new ArrayList<HrSuggestBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				ListOfAllocatedCandidate = session
						.createQuery("FROM HrSuggestBean where vacancy_id = '"+vacancy_id+"'").list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return ListOfAllocatedCandidate;
		}
		
		
		
		// used at offerletterViaFeedback.jsp 

				public List<FinalSelectionBean> getListOfSelectedResume() {
					List<FinalSelectionBean> ListOfAllocatedCandidate = new ArrayList<FinalSelectionBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfAllocatedCandidate = session
								.createQuery("FROM FinalSelectionBean where decision = 'selected'").list();
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfAllocatedCandidate;
				}	
				
				
				// used at offerletterViaFeedback.jsp 

				public List<FinalSelectionBean> getListOfFinalSelection(int final_selection_id) {
					List<FinalSelectionBean> ListOfAllocatedCandidate = new ArrayList<FinalSelectionBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfAllocatedCandidate = session
								.createQuery("FROM FinalSelectionBean where final_selection_id = '"+final_selection_id +"'").list();
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfAllocatedCandidate;
				}	
				
				
				 // used to update Interview Date for HR Side
				
				public List<ResumeDataBean> getListuseforupdateinterviewDate(int vac_id) {
					List<ResumeDataBean> ListOfAllocatedCandidate = new ArrayList<ResumeDataBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfAllocatedCandidate = session
								.createQuery("FROM ResumeDataBean where vacancyFormBean = '"+ vac_id  +"'").list();
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfAllocatedCandidate;
				}		
				
				 // used to update Interview Date for HR Side 1
				public List<NotifyToCandidateBean> getListuseforupdateinterviewDate1(int vac_id) {
					List<NotifyToCandidateBean> ListOfAllocatedCandidate = new ArrayList<NotifyToCandidateBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfAllocatedCandidate = session
								.createQuery("FROM NotifyToCandidateBean where resumeDataBean = '"+ vac_id  +"'").list();
						System.out.println(ListOfAllocatedCandidate.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfAllocatedCandidate;
				}		
				
				
				public ResumeDataBean getResumeDetailByResumeId(int resume_id)
				{
			        Session session = HibernateUtil.openSession();
			        Transaction tx = null;  
			        ResumeDataBean resumeDataBean = null;
			        try {
			            tx = session.getTransaction();
			            tx.begin();
			            Query query= session.createQuery("FROM ResumeDataBean WHERE resume_data_id='"+resume_id+"'");
			            resumeDataBean = (ResumeDataBean)query.uniqueResult();
			            tx.commit();
			        } catch (Exception e) {
			            if (tx != null) {
			                tx.rollback();
			            }
			            e.printStackTrace();
			        } finally {
			            session.close();
			        }
			        return resumeDataBean;
			        
				}
				
				
				public List<VacancyFormBean> getVacancyList() {
					List<VacancyFormBean> ListOfVacancy = new ArrayList<VacancyFormBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM VacancyFormBean where approved_status = 'pending'").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}
				
				
				
				public List<VacancytitleBean> getVacancyListforname() {
					List<VacancytitleBean> ListOfVacancy = new ArrayList<VacancytitleBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM VacancytitleBean").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}
				
				
				public List<DailyCallingDataBean> getListdailycalllist() {
					List<DailyCallingDataBean> listOfResumeData = new ArrayList<DailyCallingDataBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					try {
						tx = session.getTransaction();
						tx.begin();
						listOfResumeData = session
								.createQuery("FROM DailyCallingDataBean") //key_skills  LIKE '%" + skill + "%'
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
					return listOfResumeData;
				}
				
				
				public List<DailyCallingDataBean> getListdailycalllforinsert(int dailyid) {
					List<DailyCallingDataBean> listOfResumeData = new ArrayList<DailyCallingDataBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					try {
						tx = session.getTransaction();
						tx.begin();
						listOfResumeData = session
								.createQuery("FROM DailyCallingDataBean where daily_calling_data_id = " + dailyid + "") //key_skills  LIKE '%" + skill + "%'
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
					return listOfResumeData;
				}
				
				public List<VacancyFormBean> getVacancyListfordeshbord() {
					List<VacancyFormBean> ListOfVacancy = new ArrayList<VacancyFormBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM VacancyFormBean").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}
				


public List<VacancyFormBean> getVacancyListalowd() {
					List<VacancyFormBean> ListOfVacancy = new ArrayList<VacancyFormBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM VacancyFormBean where approved_status = 'allocated'").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}
public List<VacancyFormBean> getVacancyListpending() {
					List<VacancyFormBean> ListOfVacancy = new ArrayList<VacancyFormBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM VacancyFormBean where approved_status = 'pending'").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}


public List<DailyCallingDataBean> getVacancyalsource(int vid) {
					List<DailyCallingDataBean> ListOfVacancy = new ArrayList<DailyCallingDataBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM DailyCallingDataBean where vacancy_id = " + vid + "").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}
				
				

public List<ResumeDataBean> getVacancyListoffer(int vid) {
					List<ResumeDataBean> ListOfVacancy = new ArrayList<ResumeDataBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM ResumeDataBean where vacancy_id = '"+vid+"' AND status = 'Offer Letter'").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}


public List<VacancyAllocationBean> getVacancyalw(int vid) {
					List<VacancyAllocationBean> ListOfVacancy = new ArrayList<VacancyAllocationBean>();
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					System.out.println("akash");
					try {
						tx = session.getTransaction();
						tx.begin();
						ListOfVacancy = session
								.createQuery("FROM VacancyAllocationBean where vacancy_id = " + vid + "").list();
						System.out.println(ListOfVacancy.size());
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						session.close();
					}
					return ListOfVacancy;
				}


}