package com.hrms.pms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.AllocationNotificationBean;
import com.hrms.pms.bean.Appraisal5sBean;
import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalCriteriaBean;
import com.hrms.pms.bean.AppraisalCriteriaDescriptionBean;
import com.hrms.pms.bean.AppraisalCriteriaGradeBean;
import com.hrms.pms.bean.AppraisalCriteriaManagerBean;
import com.hrms.pms.bean.AppraisalGradeBean;
import com.hrms.pms.bean.AppraisalKizenBean;
import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.AppraisalTrainingBean;
import com.hrms.pms.bean.AppraisalUpdateManagerScoreBean;
import com.hrms.pms.bean.AppraisalUpdateScoreBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.AppraisalWhiteCollarSection2Bean;
import com.hrms.pms.bean.AppraisalWhiteSection1Bean;
import com.hrms.pms.bean.BasicQualificationBean;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.CommentMilestoneBean;
import com.hrms.pms.bean.CommentTaskBean;
import com.hrms.pms.bean.CostFeasibilityBean;
import com.hrms.pms.bean.CurrencyBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.DependencyBean;
import com.hrms.pms.bean.DesignInputsBean;
import com.hrms.pms.bean.DiplomaCourseBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.EmployeeCSVUploadBean;
import com.hrms.pms.bean.EmployeeStatusBean;
import com.hrms.pms.bean.EngineeringFeasibilityBean;
import com.hrms.pms.bean.FamilyDetailBean;
import com.hrms.pms.bean.FamilyRelationBean;
import com.hrms.pms.bean.FixtureFeasibiltyBean;
import com.hrms.pms.bean.GoalAllocationBean;
import com.hrms.pms.bean.GoalDefinitionBean;
import com.hrms.pms.bean.GoalEmployeeAllocationBean;
import com.hrms.pms.bean.GradeMasterBean;
import com.hrms.pms.bean.GraduateDegreeBean;
import com.hrms.pms.bean.ITICourseBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ManagerGradeMasterBean;
import com.hrms.pms.bean.ManufacturingFeasibilityBean;
import com.hrms.pms.bean.MasterDegreeBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.MonthlyGoalDetailBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectAdminTaskBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectAssignToManagerBean;
import com.hrms.pms.bean.ProjectDepartmentTaskBean;
import com.hrms.pms.bean.ProjectDesignHeadBean;
import com.hrms.pms.bean.ProjectDesignInputsBean;
import com.hrms.pms.bean.ProjectDocumentBean;
import com.hrms.pms.bean.ProjectHoldHistoryBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.QualityFeasibilityBean;
import com.hrms.pms.bean.QuterlyMonthBean;
import com.hrms.pms.bean.RecommendationOptionsBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.bean.ScoreAreaBean;
import com.hrms.pms.bean.SoftskillBean;
import com.hrms.pms.bean.SpecialQualificationBean;
import com.hrms.pms.bean.SpecificCriteriaAllocationBean;
import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.pms.bean.SpecificCriteriaMonthBean;
import com.hrms.pms.bean.SpecificCriteriaSoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaTechnicalBean;
import com.hrms.pms.bean.SubGoalAllocationBean;
import com.hrms.pms.bean.TaskDateHistoryBean;
import com.hrms.pms.bean.TaskDefaultListBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.TaskRemarkBean;
import com.hrms.pms.bean.TechnicalBean;
import com.hrms.pms.bean.UnitOfMeasurementBean;
import com.hrms.pms.bean.WorkBehaviourBean;
import com.hrms.pms.bean.WorkGradeBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.bean.YearlyGoalBean;
import com.hrms.pms.controller.ProjectHoldServlet;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.riskmanagement.bean.ConcernPersonBean;
import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.riskmanagement.bean.SuggestionBean;
import com.hrms.timesheet.bean.ProjectAllocationBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.bean.UnplanProjectBean;

public class AllListDAO {

	/* New Entry */

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

	public List<AppraisalBean> getappraisal(int appraisal_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getappraisal() {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=0";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getappraisalByManagerId(int manager_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=0 and employeeBean.under_manager_id='" + manager_id
					+ "'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getappraisalWithPending() {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=0 and status = 'pending'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getappraisalByEmployeeId(int emp_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=0 and employeeBean = '" + emp_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getAllappraisalByEmployeeId(int emp_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=1 and employeeBean = '" + emp_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalLeaveBean> getappraisalLeave(int appraisal_id) {
		List<AppraisalLeaveBean> listOfAppraisaLeave = new ArrayList<AppraisalLeaveBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalLeaveBean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisaLeave = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisaLeave;
	}

	public List<AppraisalKizenBean> getappraisalKaizen(int appraisal_id) {
		List<AppraisalKizenBean> listOfAppraisaKaizen = new ArrayList<AppraisalKizenBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalKizenBean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisaKaizen = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisaKaizen;
	}

	public List<Appraisal5sBean> getappraisal5s(int appraisal_id) {
		List<Appraisal5sBean> listOfAppraisa5s = new ArrayList<Appraisal5sBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from Appraisal5sBean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisa5s = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisa5s;
	}

	public List<AppraisalTrainingBean> getappraisalTraining(int appraisal_id) {
		List<AppraisalTrainingBean> listOfAppraisaTraining = new ArrayList<AppraisalTrainingBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalTrainingBean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisaTraining = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisaTraining;
	}

	public List<AppraisalCriteriaGradeBean> getappraisalGradeCriteria(int appraisal_id) {
		List<AppraisalCriteriaGradeBean> listOfAppraisalCriteriaGrade = new ArrayList<AppraisalCriteriaGradeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalCriteriaGradeBean where appraisalBean='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisalCriteriaGrade = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisalCriteriaGrade;
	}

	public List<WorkBehaviourBean> getWorkBehaviour() {
		List<WorkBehaviourBean> listOfWork = new ArrayList<WorkBehaviourBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from WorkBehaviourBean";
			Query query = session.createQuery(hql);
			listOfWork = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfWork;
	}

	public List<AppraisalCriteriaManagerBean> getListOfManagerCriteria() {
		List<AppraisalCriteriaManagerBean> listOfManagerCriteria = new ArrayList<AppraisalCriteriaManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManagerCriteria = session.createQuery("FROM AppraisalCriteriaManagerBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfManagerCriteria;

	}

	public List<AppraisalWhiteSection1Bean> getappraisalSection1(int appraisal_id) {
		List<AppraisalWhiteSection1Bean> listOfAppraisalSection1 = new ArrayList<AppraisalWhiteSection1Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalWhiteSection1Bean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisalSection1 = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisalSection1;
	}

	public List<AppraisalWhiteCollarGradeBean> getappraisalGrade(int appraisal_id) {
		List<AppraisalWhiteCollarGradeBean> listOfAppraisalGrade = new ArrayList<AppraisalWhiteCollarGradeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalWhiteCollarGradeBean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisalGrade = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisalGrade;
	}

	public List<AppraisalWhiteCollarSection2Bean> getappraisalSection2(int appraisal_id) {
		List<AppraisalWhiteCollarSection2Bean> listOfAppraisalSection2 = new ArrayList<AppraisalWhiteCollarSection2Bean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalWhiteCollarSection2Bean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisalSection2 = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisalSection2;
	}

	public List<WorkGradeBean> getWorkGrader(int appraisal_id) {
		List<WorkGradeBean> listOfWork = new ArrayList<WorkGradeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from WorkGradeBean where appraisal_id='" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfWork = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfWork;
	}

	public List<AppraisalBean> getWhiteAppraisalByManagerId(int manager_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where employeeBean.under_manager_id='" + manager_id
					+ "' and white_collar=1 and status='pending'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getWhiteAppraisalByManagerIdApproved(int manager_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where employeeBean.under_manager_id='" + manager_id
					+ "' and white_collar=1 and status='approved'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getWhiteAppraisalApproved() {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=1 and status='approved'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getWhiteAppraisalApprovedByManagerId(int manager_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=1 and employeeBean.under_manager_id = '" + manager_id
					+ "'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getWhiteAppraisalApprovedByDepartment(int department_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=1 and status='approved' and employeeBean.departmentBean = '"
					+ department_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalUpdateManagerScoreBean> getUpdatedScore(int appraisal_id) {
		List<AppraisalUpdateManagerScoreBean> listOfWork = new ArrayList<AppraisalUpdateManagerScoreBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalUpdateManagerScoreBean where appraisalBean = '" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfWork = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfWork;
	}

	public List<AppraisalUpdateScoreBean> getUpdatedScore1(int appraisal_id) {
		List<AppraisalUpdateScoreBean> listOfWork = new ArrayList<AppraisalUpdateScoreBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalUpdateScoreBean where appraisalBean = '" + appraisal_id + "'";
			Query query = session.createQuery(hql);
			listOfWork = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfWork;
	}

	public AppraisalWhiteSection1Bean getAppraisalQuestionDetail(int appraisal_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AppraisalWhiteSection1Bean appraisalWhiteSection1Bean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from AppraisalWhiteSection1Bean where appraisalBean=" + appraisal_id + " ");
			appraisalWhiteSection1Bean = (AppraisalWhiteSection1Bean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return appraisalWhiteSection1Bean;
	}

	public AppraisalWhiteCollarSection2Bean getAppraisalSection2QuestionDetail(int appraisal_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AppraisalWhiteCollarSection2Bean appraisalWhiteCollarSection2Bean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from AppraisalWhiteCollarSection2Bean where appraisalBean=" + appraisal_id + " ");
			appraisalWhiteCollarSection2Bean = (AppraisalWhiteCollarSection2Bean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return appraisalWhiteCollarSection2Bean;
	}

	public List<AppraisalBean> getAppraisalMonthReport(int emp_id, int year_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where employeeBean='" + emp_id + "' and  yearBean ='" + year_id + "'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getAppraisalCheckYear(int year_id, int emp_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where yearBean ='" + year_id + "' and month_id=13 and employeeBean='"
					+ emp_id + "' and quterlyMonthBean=5";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getAppraisalCheckMonth(int year_id, int month_id, int emp_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where yearBean ='" + year_id + "' and month_id='" + month_id
					+ "' and employeeBean='" + emp_id + "' and quterlyMonthBean = 5";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<AppraisalBean> getAppraisalCheckQuarter(int q_id, int emp_id, int year_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where quterlyMonthBean ='" + q_id + "' and employeeBean='" + emp_id
					+ "' and yearBean ='" + year_id + "' and monthBean = 13";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<GoalDefinitionBean> getListOfGoal() {

		List<GoalDefinitionBean> listOfGoal = new ArrayList<GoalDefinitionBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from GoalDefinitionBean order by goal_definition_id desc");
			listOfGoal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGoal;
	}

	public List<YearlyGoalBean> getListOfGoalByemployeeId(int employee_id) {
		List<YearlyGoalBean> listOfGoal = new ArrayList<YearlyGoalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfGoal = session.createQuery("FROM YearlyGoalBean where employeeBean ='" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGoal;

	}

	public List<YearlyGoalBean> getListOfGoalByemployeeIdGroupByYear(int employee_id) {
		List<YearlyGoalBean> listOfGoal = new ArrayList<YearlyGoalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfGoal = session
					.createQuery("FROM YearlyGoalBean where employeeBean ='" + employee_id + "' group by yearBean")
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
		return listOfGoal;

	}

	public List<YearlyGoalBean> getListOfGoalByYearId(int year_id) {
		List<YearlyGoalBean> listOfGoal = new ArrayList<YearlyGoalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfGoal = session.createQuery("FROM YearlyGoalBean where yearBean ='" + year_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGoal;

	}

	public List<GoalAllocationBean> getListOfAllocatedEmployee(int yearly_goal_id) {
		List<GoalAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session
					.createQuery("FROM GoalAllocationBean where yearlyGoalBean ='" + yearly_goal_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedEmployee;

	}

	public List<GoalAllocationBean> getListOfAllocatedEmployeeId(int employee_id) {
		List<GoalAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session
					.createQuery("FROM GoalAllocationBean where employeeBean ='" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedEmployee;

	}

	public List<GoalEmployeeAllocationBean> getListOfAllocatedEmployee1(int allocation_id) {
		List<GoalEmployeeAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session
					.createQuery("FROM GoalEmployeeAllocationBean where subGoalAllocationBean.goalAllocationBean='"
							+ allocation_id + "'")
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
		return listOfAllocatedEmployee;

	}

	public List<GoalEmployeeAllocationBean> getListOfAllocatedEmployee2(int allocation_id) {
		List<GoalEmployeeAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session
					.createQuery("FROM GoalEmployeeAllocationBean where subGoalAllocationBean='" + allocation_id + "'")
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
		return listOfAllocatedEmployee;

	}

	public List<GoalEmployeeAllocationBean> getListAllocatedEmployeeId(int employee_id) {
		List<GoalEmployeeAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session
					.createQuery("FROM GoalEmployeeAllocationBean where employeeBean ='" + employee_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedEmployee;

	}

	public List<GoalEmployeeAllocationBean> getListAllocatedByManagerId(int manager_id) {
		List<GoalEmployeeAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session
					.createQuery(
							"FROM GoalEmployeeAllocationBean where employeeBean.under_manager_id ='" + manager_id + "'")
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
		return listOfAllocatedEmployee;

	}

	public List<GoalEmployeeAllocationBean> getListAllocatedByManagerId(int manager_id, int goal_id) {
		List<GoalEmployeeAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session
					.createQuery("FROM GoalEmployeeAllocationBean where (employeeBean.under_manager_id ='" + manager_id
							+ "'  and subGoalAllocationBean.goalAllocationBean.yearlyGoalBean = '" + goal_id
							+ "') or (employeeBean.managerBean ='" + manager_id
							+ "'  and subGoalAllocationBean.goalAllocationBean.yearlyGoalBean = '" + goal_id + "')")
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
		return listOfAllocatedEmployee;

	}

	public List<GoalEmployeeAllocationBean> getListAllocatedByGoalId(int goal_id) {
		List<GoalEmployeeAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session.createQuery(
					"FROM GoalEmployeeAllocationBean where subGoalAllocationBean.goalAllocationBean.yearlyGoalBean ='"
							+ goal_id + "'")
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
		return listOfAllocatedEmployee;

	}

	public List<MonthlyGoalDetailBean> getListOfMonthlyGoal(int allocation_id) {
		List<MonthlyGoalDetailBean> listOfMonthlyGoal = new ArrayList<MonthlyGoalDetailBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfMonthlyGoal = session
					.createQuery("FROM MonthlyGoalDetailBean where goalEmployeeAllocationBean ='" + allocation_id + "'")
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
		return listOfMonthlyGoal;

	}

	public List<MonthlyGoalDetailBean> getListOfMonthlyGoalByGoalId(int goal_id) {
		List<MonthlyGoalDetailBean> listOfMonthlyGoal = new ArrayList<MonthlyGoalDetailBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfMonthlyGoal = session.createQuery(
					"FROM MonthlyGoalDetailBean where goalEmployeeAllocationBean.subGoalAllocationBean.goalAllocationBean.yearlyGoalBean ='"
							+ goal_id + "'")
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
		return listOfMonthlyGoal;

	}

	public List<MonthlyGoalDetailBean> getListOfMonthlyGoalByGoalIdorManagerId(int goal_id, int manager_id) {
		List<MonthlyGoalDetailBean> listOfMonthlyGoal = new ArrayList<MonthlyGoalDetailBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfMonthlyGoal = session.createQuery(
					"FROM MonthlyGoalDetailBean where goalEmployeeAllocationBean.subGoalAllocationBean.goalAllocationBean.yearlyGoalBean ='"
							+ goal_id + "' and goalEmployeeAllocationBean.employeeBean.under_manager_id='" + manager_id
							+ "'")
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
		return listOfMonthlyGoal;

	}

	public List<GoalAllocationBean> getListOfAllocation() {
		List<GoalAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session.createQuery("FROM GoalAllocationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedEmployee;

	}

	public List<GoalAllocationBean> getListOfAllAllocatedEmployee() {
		List<GoalAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session.createQuery("FROM GoalAllocationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedEmployee;

	}

	public YearlyGoalBean getInfoOfGoal(int goal_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		YearlyGoalBean yearlyGoalBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from YearlyGoalBean where yearly_goal_id= " + goal_id + "");
			yearlyGoalBean = (YearlyGoalBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return yearlyGoalBean;
	}

	public List<GoalAllocationBean> getListOfAllocatedEmployeeIdYearId(int employee_id, int year_id) {
		List<GoalAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session.createQuery("FROM GoalAllocationBean where employeeBean ='" + employee_id
					+ "' and yearlyGoalBean.yearBean = '" + year_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedEmployee;

	}

	public List<SubGoalAllocationBean> getListOfSubGoal(int allocation_id) {
		List<SubGoalAllocationBean> listOfSubGoal = new ArrayList<SubGoalAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSubGoal = session
					.createQuery("FROM SubGoalAllocationBean where goalAllocationBean ='" + allocation_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSubGoal;

	}

	public List<SubGoalAllocationBean> getListOfAllSubGoal() {
		List<SubGoalAllocationBean> listOfSubGoal = new ArrayList<SubGoalAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSubGoal = session.createQuery("FROM SubGoalAllocationBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSubGoal;

	}

	public List<GoalEmployeeAllocationBean> getListOfSubEmployeeAllocation(int subGoal_id) {
		List<GoalEmployeeAllocationBean> listOfSubGoal = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSubGoal = session
					.createQuery("FROM GoalEmployeeAllocationBean where subGoalAllocationBean ='" + subGoal_id + "'")
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
		return listOfSubGoal;

	}

	public List<Object[]> getListOfGoalDepartment() {
		List<Object[]> listOfGoalDepartment = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from GoalDepartmentBean";
			Query query = session.createQuery(hql);
			listOfGoalDepartment = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGoalDepartment;
	}

	public List<AppraisalCriteriaBean> getAppraisalCriteria() {
		List<AppraisalCriteriaBean> listOfCriteria = new ArrayList<AppraisalCriteriaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalCriteriaBean";
			Query query = session.createQuery(hql);
			listOfCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCriteria;
	}

	public List<AppraisalGradeBean> getAppraisalGrade() {
		List<AppraisalGradeBean> listOfAppraisalGrade = new ArrayList<AppraisalGradeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalGradeBean";
			Query query = session.createQuery(hql);
			listOfAppraisalGrade = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisalGrade;
	}

	public List<AppraisalCriteriaDescriptionBean> getCriteriaDescription(int id) {
		List<AppraisalCriteriaDescriptionBean> listOfCriteriaDescription = new ArrayList<AppraisalCriteriaDescriptionBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalCriteriaDescriptionBean where appraisalCriteriaBean='" + id + "'";
			Query query = session.createQuery(hql);
			listOfCriteriaDescription = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCriteriaDescription;
	}

	public List<YearlyGoalBean> getListOfGoalGroupByYear() {
		List<YearlyGoalBean> listOfGoal = new ArrayList<YearlyGoalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfGoal = session.createQuery("FROM YearlyGoalBean group by yearBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGoal;

	}

	public List<GoalEmployeeAllocationBean> getListOfEmployeeAllocatedEmployeeIdYearId(int employee_id, int year_id) {
		List<GoalEmployeeAllocationBean> listOfAllocatedEmployee = new ArrayList<GoalEmployeeAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedEmployee = session.createQuery("FROM GoalEmployeeAllocationBean where employeeBean ='"
					+ employee_id + "' and subGoalAllocationBean.goalAllocationBean.yearlyGoalBean.yearBean = '"
					+ year_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedEmployee;

	}

	public List<AppraisalWhiteCollarGradeBean> getListOfAllocatedGoals(int appraisal_id) {
		List<AppraisalWhiteCollarGradeBean> listOfAllocatedGoals = new ArrayList<AppraisalWhiteCollarGradeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocatedGoals = session.createQuery("FROM AppraisalWhiteCollarGradeBean where appraisalBean = '"
					+ appraisal_id + "' and appraisalGradeBean != 0 ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocatedGoals;

	}

	public List<WorkGradeBean> getListOfWorkGrade(int appraisal_id) {
		List<WorkGradeBean> listOfWorkGrade = new ArrayList<WorkGradeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfWorkGrade = session.createQuery(
					"FROM WorkGradeBean where appraisalGradeBean != 0 and appraisalBean = '" + appraisal_id + "'")
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
		return listOfWorkGrade;

	}

	/* End Of New Entry */

	public List<Object[]> getPerOfAllocationByProjectId(int project_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationPercentageBean p inner join p.employeeBean e join p.projectMasterBean p1 join p1.projectStatusBean p2 where p1.project_master_id ='"
					+ project_id + "' and allocation_status = 1";

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

	public List<ProjectAllocationBean> getPerOfAllocation1(int project_id, int manager_id) {
		List<ProjectAllocationBean> listOfProjectAllocation = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProjectAllocation = session.createQuery(
					"FROM ProjectAllocationBean WHERE under_manager_id='" + manager_id + "' and projectMasterBean = '"
							+ project_id + "' and allocation_status = 1 group by employeeBean")
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
		return listOfProjectAllocation;

	}

	public List<ProjectAllocationBean> getPerOfAllocation2(int project_id) {
		List<ProjectAllocationBean> listOfProjectAllocation = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProjectAllocation = session.createQuery("FROM ProjectAllocationBean WHERE projectMasterBean = '"
					+ project_id + "' and allocation_status = 1 group by employeeBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfProjectAllocation;

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

	public List<EmployeeBean> getListOfNewEmployee(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE under_manager_id='" + manager_id
					+ "' and employee_code = password and employeeStatusBean != 3").list();
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

	public List<EmployeeBean> getListOfAllNewEmployee() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean WHERE employee_code = password and employeeStatusBean != 3").list();
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

	// New Joini Data For HR(All Employee Data)
	public List<EmployeeBean> getListOfNewEmployeeForHr(String startDate, String endDate) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean WHERE employee_code = password and joining_date between '"
							+ startDate + "' and '" + endDate + "' and employeeStatusBean != 3")
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

	public List<EmployeeBean> getListOfAllEmployee() {
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

	public List<EmployeeBean> getListOfEmployeeAllocation(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE (under_manager_id='" + manager_id
					+ "' or managerBean=" + manager_id + ") and employeeStatusBean != 3").list();
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

	public List<EmployeeBean> getListOfAllEmployeeAllocation() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean WHERE employeeStatusBean != 3 order by companyListBean").list();
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

	public List<EmployeeBean> getListOfAllEmployeeForLeave() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE employeeStatusBean != 3").list();
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

	public List<EmployeeBean> getListOfAllEmployeeForLeaveSurat() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean WHERE employeeStatusBean != 3 and location = 'surat' ").list();
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

	public List<EmployeeBean> getListOfAllEmployeeForLeaveA8DeptWise() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean WHERE employeeStatusBean != 3 and departmentBean In (41,42,43) ")
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

	public List<EmployeeBean> getListOfEmployeeAllocation1() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean where (departmentBean != 3 and departmentBean != 4)").list();
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

	public List<EmployeeBean> getListOfEmployeeAllocationByDepartment(int dept_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery(
							"FROM EmployeeBean where departmentBean = '" + dept_id + "' and employeeStatusBean != 3")
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

	public List<ProjectMasterBean> getListOfProjectMasterWithHold(int manager_id) {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean where managerBean=" + manager_id
					+ " and (projectStatusBean =3 or projectStatusBean = 1)").list();
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

	public List<ProjectMasterBean> getListOfProjectMasterOnHold(int manager_id) {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session
					.createQuery(
							"FROM ProjectMasterBean where managerBean=" + manager_id + " and projectStatusBean = 1")
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

	public List<ProjectMasterBean> getListOfProjectInfoByManagerId() {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean ").list();
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
			listOfTask = session.createQuery("FROM TaskMasterBean ").list();
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

	public List<TaskMasterBean> getListOfTask1(int project_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("FROM TaskMasterBean where projectMasterBean = '" + project_id + "'")
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

	public List<TaskMasterBean> getListOfTask11(int project_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery(
					"FROM TaskMasterBean where projectMasterBean = '" + project_id + "' and master_task_or_not = 1")
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

	public List<MilestoneBean> getListOfMilestone() {
		List<MilestoneBean> listOfMilestone = new ArrayList<MilestoneBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfMilestone = session.createQuery("FROM MilestoneBean ").list();
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

	public List<MilestoneBean> getListOfMilestone1(int project_id) {
		List<MilestoneBean> listOfMilestone = new ArrayList<MilestoneBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfMilestone = session.createQuery("FROM MilestoneBean where projectMasterBean = '" + project_id + "' ")
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
		return listOfMilestone;

	}

	public List<ProjectMasterBean> getListOfProjectInfo() {
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

	public List<ProjectMasterBean> getListOfAllOnHoldProject() {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean where projectStatusBean =1").list();
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

	public List<ProjectMasterBean> getListOfAllProjectsForAdmin() {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery(
					"FROM ProjectMasterBean where projectStatusBean =1 or projectStatusBean =3 or projectStatusBean =4 or projectStatusBean =5")
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

	public List<ProjectMasterBean> getListOfAllProjectsForManager(int manager_id) {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean where managerBean=" + manager_id
					+ " and (projectStatusBean =1 or projectStatusBean =3 or projectStatusBean =4 or projectStatusBean =5)")
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

	public List<ProjectMasterBean> getListOfAllProjectOnHold() {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean where projectStatusBean =1").list();
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

	public List<ProjectAllocationBean> getAllocationProjectList(int manager_id) {
		List<ProjectAllocationBean> listOfAllocationProject = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean where under_manager_id='" + manager_id
					+ "' group by projectMasterBean";

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

	public List<Object[]> getSumOfAllocation(int employee_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationPercentageBean p inner join p.employeeBean e join p.projectMasterBean p1 join p1.projectStatusBean p2 where p.allocation_status = 1 and e.employee_master_id='"
					+ employee_id + "' and p2.project_status_id=3";

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

	public List<Object[]> getPerOfAllocation(int employee_id, int project_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationPercentageBean p inner join p.employeeBean e join p.projectMasterBean p1 join p1.projectStatusBean p2 where e.employee_master_id='"
					+ employee_id + "' and p1.project_master_id ='" + project_id + "' and p.allocation_status = 1";

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

	public List<Object[]> getPerOfAllocationByEmployeeId(int employee_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationPercentageBean p inner join p.employeeBean e join p.projectMasterBean p1 join p1.projectStatusBean p2 where e.employee_master_id ='"
					+ employee_id + "' and allocation_status = 1";

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

	public List<Object[]> getAllocationByEmployeeId(int employee_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean p inner join p.employeeBean e join p.projectMasterBean p1 where e.employee_master_id='"
					+ employee_id + "' group by p1.project_master_id";

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

	public List<Object[]> getAllAllocation(int manager_id) {
		List<Object[]> listOfAllocationProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean p inner join p.employeeBean e join p.projectMasterBean p1 join p1.managerBean m where m.manager_id='"
					+ manager_id + "' group by p1.project_master_id";

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

	public List<ProjectAllocationBean> getAllocationEmployeeList(int manager_id) {
		List<ProjectAllocationBean> listOfEmployeeProject = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean where under_manager_id='" + manager_id + "' group by EmployeeBean";
			Query query = session.createQuery(hql);
			listOfEmployeeProject = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployeeProject;
	}

	public List<ProjectAllocationBean> getAllocationTaskList(int employee_id, int project_id) {
		List<ProjectAllocationBean> listOfTaskList = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean where employeeBean='" + employee_id + "' and projectMasterBean='"
					+ project_id + "' and allocation_status = 1 group by taskMasterBean";
			Query query = session.createQuery(hql);
			listOfTaskList = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTaskList;
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

	public List<Object[]> getMilestoneListByProjectId(int project_id, int manager_id) {
		List<Object[]> listOfMilestone = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from MilestoneBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m1.manager_id = '" + manager_id + "'";
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

	public List<MilestoneBean> getMilestoneListById(int project_id, int manager_id) {
		List<MilestoneBean> listOfMilestone = new ArrayList<MilestoneBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from MilestoneBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "'";
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

	public List<MilestoneBean> getMilestoneListByProjectId1(int project_id, int manager_id) {
		List<MilestoneBean> listOfMilestone = new ArrayList<MilestoneBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from MilestoneBean where (projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "') or projectMasterBean = 2";
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

	public List<TaskMasterBean> getTaskListByProjectId1(int project_id, int manager_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "' and milestoneBean = 1 and task_id = 0 and master_task_or_not = 1";
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

	public List<TaskMasterBean> getTaskListByProjectId2(int project_id, int manager_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "' and milestoneBean = 1";
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

	public List<TaskMasterBean> getTaskListByProjectId1(int project_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "'";
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

	public List<Object[]> getTaskListByProjectId(int project_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "'";
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

	public List<Object[]> getAllocatedTaskListByProjectId(int project_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean p inner join p.projectMasterBean p1 join p.employeeBean e join p.taskMasterBean t where p1.project_master_id='"
					+ project_id + "' group By e.employee_master_id,t.task_master_id";
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

	public List<ProjectAllocationBean> getAllocatedTaskListByMilestoneId(int milestone_id) {
		List<ProjectAllocationBean> listOfTask = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean where taskMasterBean.milestoneBean='" + milestone_id
					+ "' group By employeeBean";
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

	public List<ProjectAllocationBean> getAllocatedTaskListByTaskId(int task_id) {
		List<ProjectAllocationBean> listOfTask = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean where taskMasterBean='" + task_id + "' group By taskMasterBean";
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

	public List<ProjectAllocationBean> getAllocatedTaskListByTaskId1(int task_id) {
		List<ProjectAllocationBean> listOfTask = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectAllocationBean where taskMasterBean='" + task_id
					+ "' and allocation_status = 1  group by employeeBean";
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

	public List<Object[]> getTaskListByProjectMilestoneID(int project_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1";
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

	public List<Object[]> getTaskListByProjectMilestoneID111(int project_id, int manger_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0 and master_task_or_not = 0";
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

	public List<Object[]> getTaskListByProjectMilestoneID11(int project_id, int manger_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0 and master_task_or_not = 1";
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

	public List<Object[]> getTaskListByProjectMilestoneID(int project_id, int manger_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id + "' and task_id = 0";
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

	public List<Object[]> getTaskListByProjectMilestoneID0(int project_id, int manger_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0 and milestone_or_not = 0 and master_task_or_not = 1";
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

	public List<Object[]> getTaskListByProjectMilestoneID1(int project_id, int manger_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0 and milestone_or_not = 0";
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

	public List<Object[]> taskList(int project_master_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean t inner join t.projectMasterBean p where p.project_master_id ="
					+ project_master_id + "";
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

	public List<Object[]> MilestonetaskList(int milestone_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean t inner join t.milestoneBean m where m.milestone_id =" + milestone_id
					+ "";
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

	public List<DependencyBean> getDependencyList(int task_id) {
		List<DependencyBean> listOfdependency = new ArrayList<DependencyBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from DependencyBean  where taskMasterBean=" + task_id + "";
			Query query = session.createQuery(hql);
			listOfdependency = query.list();
			System.out.println(listOfdependency.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfdependency;
	}

	public List<TaskMasterBean> getTaskName(int task_id) {
		List<TaskMasterBean> name = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean  where task_master_id=" + task_id + "";
			Query query = session.createQuery(hql);
			name = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return name;
	}

	public List<ProjectMasterBean> getListOfProjectByManagerId(int manager_id) {
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectMasterBean where (managerBean='" + manager_id
					+ "' and misc_project=1) or (managerBean=7 and misc_project=1) ").list();
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

	public List<ProjectAllocationBean> getListOfAllocation(int year_id, int project_id, int m, int employee_id,
			int task_id) {
		List<ProjectAllocationBean> listOfAllocation = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocation = session.createQuery("FROM ProjectAllocationBean where yearBean='" + year_id
					+ "' and projectMasterBean='" + project_id + "' and monthBean='" + m + "' and employeeBean='"
					+ employee_id + "' and taskMasterBean='" + task_id + "' ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocation;

	}

	public List<TimeSheetBean> getRejectedTimesheet(int employee_master_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean = '" + employee_master_id
					+ "' and approval_status = 'rejected' group by date";
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

	public List<Object[]> getListOfAllocationByProjectId(int project_id) {
		List<Object[]> listOfAllocation = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocation = session.createQuery(
					"FROM ProjectAllocationBean p inner join p.projectMasterBean p1 join p.employeeBean e where p1.project_master_id='"
							+ project_id + "' group by e.employee_master_id ")
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
		return listOfAllocation;

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

	public TaskMasterBean getDetailsOfTask(int task_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TaskMasterBean taskMasterBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from TaskMasterBean where task_master_id = '" + task_id + "'");
			taskMasterBean = (TaskMasterBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return taskMasterBean;
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

	public List<TaskMasterBean> getListOfProjectAllocationRemider(int manager_id) {
		List<TaskMasterBean> listOfProjectAllocationRemider = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProjectAllocationRemider = session.createQuery(
					"FROM TaskMasterBean t where not exists(from ProjectAllocationBean p where t.task_master_id=p.taskMasterBean) and t.managerBean='"
							+ manager_id + "'")
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
		return listOfProjectAllocationRemider;

	}

	public List<MilestoneBean> getListOfMilestoneTaskReminder(int manager_id) {
		List<MilestoneBean> listOfMilestoneTaskReminder = new ArrayList<MilestoneBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfMilestoneTaskReminder = session.createQuery(
					"FROM MilestoneBean m where not exists(from TaskMasterBean t where t.milestoneBean=m.milestone_id) and m.managerBean='"
							+ manager_id + "'")
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
		return listOfMilestoneTaskReminder;

	}

	public List<ProjectAllocationPercentageBean> getListOfFreeResourceRemider(int manager_id) {
		List<ProjectAllocationPercentageBean> listOfFreeResourceRemider = new ArrayList<ProjectAllocationPercentageBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfFreeResourceRemider = session.createQuery(
					"FROM ProjectAllocationPercentageBean p where not exists(from ProjectAllocationBean p1 where p.employeeBean = p1.employeeBean and p.projectMasterBean = p1.projectMasterBean) and p.projectMasterBean.managerBean='"
							+ manager_id
							+ "' and p.allocation_status = 1 and p.projectMasterBean.projectStatusBean = 3")
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
		return listOfFreeResourceRemider;

	}

	public List<Object[]> projectReport(int task_id) {
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
					"from TimeSheetBean t inner join t.employeeBean e join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1  where t1.task_master_id="
							+ task_id
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

	public List<Object[]> employeeReport1(int employee_master_id, int task_id) {
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

	public List<ProjectManagerListBean> listOfProject(int emp_id) {
		List<ProjectManagerListBean> listOfProject = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectManagerListBean where employeeBean = '" + emp_id + "'")
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

	public List<ProjectManagerListBean> listOfProjectWithOnHoldStatus(int emp_id) {
		List<ProjectManagerListBean> listOfProject = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectManagerListBean where employeeBean = '" + emp_id
					+ "' and projectMasterBean.projectStatusBean = 1").list();
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

	public List<EmployeeBean> getAllEmployeeById(int dept_id) {

		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("from EmployeeBean where departmentBean = '" + dept_id
					+ "' and manager_id != 99 and employeeStatusBean != 3").list();
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

	public List<ProjectManagerListBean> getAllManagerProjectList(int project_id, int manager_id) {

		List<ProjectManagerListBean> listOfProject = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("from ProjectManagerListBean where projectMasterBean = '" + project_id
					+ "' and employeeBean.managerBean = '" + manager_id + "' and employeeBean.employeeStatusBean != 3")
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

	public List<TaskMasterBean> getTaskByMilestone(int milestone_id) {

		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("from TaskMasterBean where milestoneBean = '" + milestone_id + "'").list();
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

	public MilestoneBean getMilestoneDetail(int milestone_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		MilestoneBean milestoneBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from MilestoneBean where milestone_id=" + milestone_id + "");
			milestoneBean = (MilestoneBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return milestoneBean;
	}

	public ProjectAllocationPercentageBean getProjectAllocation(int allocation_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectAllocationPercentageBean projectAllocationPercentageBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from ProjectAllocationPercentageBean where project_allocation_percentage_id="
							+ allocation_id + "");
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

	public List<CommentMilestoneBean> getCommentOfMilestone(int milestone_id) {

		List<CommentMilestoneBean> listOfComment = new ArrayList<CommentMilestoneBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfComment = session
					.createQuery("from CommentMilestoneBean where milestoneBean = '" + milestone_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfComment;
	}

	public List<CommentTaskBean> getCommentOfTask(int task_id) {

		List<CommentTaskBean> listOfComment = new ArrayList<CommentTaskBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfComment = session.createQuery("from CommentTaskBean where taskMasterBean = '" + task_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfComment;
	}

	public List<EngineeringFeasibilityBean> getEngineeringFeasibility(int project_id) {

		List<EngineeringFeasibilityBean> listOfEngineeringFeasibility = new ArrayList<EngineeringFeasibilityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEngineeringFeasibility = session
					.createQuery("from EngineeringFeasibilityBean where projectMasterBean = '" + project_id + "'")
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
		return listOfEngineeringFeasibility;
	}

	public List<FixtureFeasibiltyBean> getFixtureFeasibility(int project_id) {

		List<FixtureFeasibiltyBean> listOfFixtureFeasibility = new ArrayList<FixtureFeasibiltyBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfFixtureFeasibility = session
					.createQuery("from FixtureFeasibiltyBean where projectMasterBean = '" + project_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfFixtureFeasibility;
	}

	public List<ManufacturingFeasibilityBean> getManufactureFeasibility(int project_id) {

		List<ManufacturingFeasibilityBean> listOfManufactureFeasibility = new ArrayList<ManufacturingFeasibilityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManufactureFeasibility = session
					.createQuery("from ManufacturingFeasibilityBean where projectMasterBean = '" + project_id + "'")
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
		return listOfManufactureFeasibility;
	}

	public List<QualityFeasibilityBean> getQualityFeasibility(int project_id) {

		List<QualityFeasibilityBean> listOfQualityFeasibility = new ArrayList<QualityFeasibilityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfQualityFeasibility = session
					.createQuery("from QualityFeasibilityBean where projectMasterBean = '" + project_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfQualityFeasibility;
	}

	public List<CostFeasibilityBean> getCostFeasibility(int project_id) {

		List<CostFeasibilityBean> listOfCostFeasibility = new ArrayList<CostFeasibilityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCostFeasibility = session
					.createQuery("from CostFeasibilityBean where projectMasterBean = '" + project_id + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCostFeasibility;
	}

	public List<DesignInputsBean> getListOfDesignInputs() {

		List<DesignInputsBean> listOfDesignInputs = new ArrayList<DesignInputsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDesignInputs = session.createQuery("from DesignInputsBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDesignInputs;
	}

	public ProjectDesignHeadBean getDetailsOfHeadForProject(int project_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectDesignHeadBean projectDesignHeadBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectDesignHeadBean where projectMasterBean=" + project_id + "");
			projectDesignHeadBean = (ProjectDesignHeadBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectDesignHeadBean;
	}

	public List<ProjectDesignInputsBean> getListOfProjectDesignInputs(int project_id) {

		List<ProjectDesignInputsBean> listOfDesignInputs = new ArrayList<ProjectDesignInputsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDesignInputs = session
					.createQuery("from ProjectDesignInputsBean where projectMasterBean = " + project_id + " ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDesignInputs;
	}

	public List<TaskDefaultListBean> getListOfDefaultTask(int dept_id) {

		List<TaskDefaultListBean> listOfDefaultTask = new ArrayList<TaskDefaultListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDefaultTask = session.createQuery("from TaskDefaultListBean where departmentBean = " + dept_id + " ")
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
		return listOfDefaultTask;
	}

	public List<TaskMasterBean> getTaskByTadskID(int task_id) {

		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("from TaskMasterBean where task_id = '" + task_id + "'").list();
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

	public List<ProjectManagerListBean> getListOfDepartmentByManager(int project_id) {

		List<ProjectManagerListBean> listOfDepartmentByManagerId = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartmentByManagerId = session.createQuery("from ProjectManagerListBean where projectMasterBean = '"
					+ project_id + "' group by employeeBean.departmentBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDepartmentByManagerId;
	}

	public List<ProjectAdminTaskBean> getListOfProjectAdminTask(int project_id) {

		List<ProjectAdminTaskBean> listOfAdminTask = new ArrayList<ProjectAdminTaskBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAdminTask = session.createQuery("from ProjectAdminTaskBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAdminTask;
	}

	public List<ProjectManagerListBean> getListOfProjectManagerByDeptId(int manager_id, int project_id) {
		List<ProjectManagerListBean> listOfManager = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManager = session.createQuery("from ProjectManagerListBean where employeeBean.managerBean = '"
					+ manager_id + "' and projectMasterBean = '" + project_id + "'").list();
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

	public List<ProjectManagerListBean> getListOfProjectManagerByDeptId1(int dept_id, int project_id) {
		List<ProjectManagerListBean> listOfManager = new ArrayList<ProjectManagerListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManager = session.createQuery("from ProjectManagerListBean where employeeBean.departmentBean = '"
					+ dept_id + "' and projectMasterBean = '" + project_id + "'").list();
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

	public List<ProjectDepartmentTaskBean> getListOfDepartmentByTaskId(int task_id) {
		List<ProjectDepartmentTaskBean> listOfDepartment = new ArrayList<ProjectDepartmentTaskBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartment = session
					.createQuery("from ProjectDepartmentTaskBean where task_master_id = '" + task_id + "'").list();
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

	public List<ProjectDepartmentTaskBean> getListOfDepartmentByProjectId(int project_id) {
		List<ProjectDepartmentTaskBean> listOfDepartment = new ArrayList<ProjectDepartmentTaskBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartment = session
					.createQuery("from ProjectDepartmentTaskBean where projectMasterBean = '" + project_id + "'")
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
		return listOfDepartment;
	}

	public List<ProjectDepartmentTaskBean> getListOfDepartmentByProjectId1(int project_id, int task_id) {
		List<ProjectDepartmentTaskBean> listOfDepartment = new ArrayList<ProjectDepartmentTaskBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartment = session.createQuery("from ProjectDepartmentTaskBean where projectMasterBean = '"
					+ project_id + "' and task_master_id = " + task_id + "").list();
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

	public List<TaskDateHistoryBean> getDateOfTask(int task_id) {
		List<TaskDateHistoryBean> listOfTask = new ArrayList<TaskDateHistoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskDateHistoryBean where task_master_id = '" + task_id + "'";
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

	public List<ProjectDesignHeadBean> ListOfProjectDesignHeadGroupByDate(int project_id) {

		List<ProjectDesignHeadBean> listOfDesignHead = new ArrayList<ProjectDesignHeadBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDesignHead = session.createQuery(
					"from ProjectDesignHeadBean where projectMasterBean = " + project_id + " group by submission_date ")
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
		return listOfDesignHead;
	}

	public List<ProjectDesignHeadBean> ListOfProjectDesignHead(int project_id) {

		List<ProjectDesignHeadBean> listOfDesignHead = new ArrayList<ProjectDesignHeadBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDesignHead = session
					.createQuery("from ProjectDesignHeadBean where projectMasterBean = " + project_id + "").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDesignHead;
	}

	public ProjectDesignHeadBean getDetailsOfHeadForProjectByDate(int project_id, String date) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectDesignHeadBean projectDesignHeadBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectDesignHeadBean where projectMasterBean=" + project_id
					+ " and submission_date='" + date + "'");
			projectDesignHeadBean = (ProjectDesignHeadBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectDesignHeadBean;
	}

	public List<ProjectDesignInputsBean> getListOfProjectDesignInputsByDate(int project_id, String date) {

		List<ProjectDesignInputsBean> listOfDesignInputs = new ArrayList<ProjectDesignInputsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDesignInputs = session.createQuery("from ProjectDesignInputsBean where projectMasterBean = "
					+ project_id + " and submission_date='" + date + "' ").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDesignInputs;
	}

	public List<Object[]> getTaskListByMasterId(int project_id, int manger_id, int master_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0 and master_task_id = " + master_id + "";
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

	public List<TaskMasterBean> getTaskByTadskIDByMasterId(int task_id, int master_id) {

		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery(
					"from TaskMasterBean where task_id = '" + task_id + "' and master_task_id='" + master_id + "'")
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

	public List<TaskMasterBean> getTaskListByProjectId2(int project_id, int manager_id, int master_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "' and milestone_or_not = 1 and task_id = 0 and master_task_id = '" + master_id
					+ "'";
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

	public List<TaskMasterBean> getSizeOfMilestone(int project_id, int manager_id, int master_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "' and milestone_or_not = 1 and task_id = 0 and master_task_id = '" + master_id
					+ "'";
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

	public List<TaskMasterBean> getSizeOfTask(int project_id, int manager_id, int master_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "' and milestone_or_not = 0 and master_task_id = '" + master_id + "'";
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

	public List<Object[]> getTaskListMasterId(int project_id, int manger_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0 and master_task_id = 0 ";
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

	public List<Object[]> getTaskListMasterId1(int project_id, int manger_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0  and master_task_or_not = 0";
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

	public List<Object[]> getTaskListMasterId11(int project_id, int manger_id, int task_id) {
		List<Object[]> listOfTask = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean m inner join m.projectMasterBean p join m.priorityBean p1 join m.managerBean m1  where (p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and task_id = 0 and master_task_or_not = 0 and  m.master_task_id = 0) or (p.project_master_id='"
					+ project_id + "' and m.milestoneBean = 1 and m1.manager_id='" + manger_id
					+ "' and  m.master_task_id = '" + task_id + "' and task_id = 0 and master_task_or_not = 0)";
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

	public ProjectDepartmentTaskBean getProjectDepartmentDetail(int deptTaskId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectDepartmentTaskBean projectDepartmentTaskBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from ProjectDepartmentTaskBean where project_department_task_id=" + deptTaskId + "");
			projectDepartmentTaskBean = (ProjectDepartmentTaskBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectDepartmentTaskBean;
	}

	public List<ProjectAssignToManagerBean> getListOfProjectAssignToMaster(int emp_id) {
		List<ProjectAssignToManagerBean> listOfProject = new ArrayList<ProjectAssignToManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectAssignToManagerBean where employeeBean=" + emp_id + " ")
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

	public List<ProjectAssignToManagerBean> getListOfProjectAssignToMasterWithActiveStatus(int emp_id) {
		List<ProjectAssignToManagerBean> listOfProject = new ArrayList<ProjectAssignToManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session.createQuery("FROM ProjectAssignToManagerBean where employeeBean=" + emp_id
					+ " and projectMasterBean.projectStatusBean = 3 ").list();
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

	public ProjectAssignToManagerBean getListOfProjectAssignToMasterProjectID(int emp_id, int project_id) {

		ProjectAssignToManagerBean projectAssignToManagerBean = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM ProjectAssignToManagerBean where employeeBean=" + emp_id
					+ " and projectMasterBean ='" + project_id + "' ");
			projectAssignToManagerBean = (ProjectAssignToManagerBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectAssignToManagerBean;

	}

	public List<ProjectAssignToManagerBean> getListOfProjectAssignToMasterProjectID1(int project_id) {
		List<ProjectAssignToManagerBean> listOfProject = new ArrayList<ProjectAssignToManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProject = session
					.createQuery("FROM ProjectAssignToManagerBean where projectMasterBean=" + project_id + " ").list();
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

	public ProjectDepartmentTaskBean getProjectDepartmentTask(int project_id, int manager_id, int task_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectDepartmentTaskBean projectDepartmentTaskBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectDepartmentTaskBean where projectMasterBean=" + project_id
					+ " and managerBean = '" + manager_id + "' and task_master_id='" + task_id + "'");
			projectDepartmentTaskBean = (ProjectDepartmentTaskBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projectDepartmentTaskBean;
	}

	public List<TaskMasterBean> getTaskByManagetAndProject(int project_id, int manager_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskMasterBean where projectMasterBean='" + project_id + "' and managerBean = '"
					+ manager_id + "' and task_id != 0 ";
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

	public List<ProjectDocumentBean> getDocumentByProjectId(int project_id) {
		List<ProjectDocumentBean> listOfTask = new ArrayList<ProjectDocumentBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ProjectDocumentBean where projectMasterBean='" + project_id + "'";
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

	public List<TaskRemarkBean> getRemarksByHeadId(int headId) {
		List<TaskRemarkBean> listOfRemarks = new ArrayList<TaskRemarkBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TaskRemarkBean where projectDesignHeadBean='" + headId + "'";
			Query query = session.createQuery(hql);
			listOfRemarks = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRemarks;
	}

	public TaskRemarkBean getRemarkOfTask(int task_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		TaskRemarkBean taskRemarkBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from TaskRemarkBean where task_master_id='" + task_id + "'");
			taskRemarkBean = (TaskRemarkBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return taskRemarkBean;
	}

	public List<EmployeeBean> getFullListOfManager() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean e where manager_id != 99)").list();
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

	public List<EmployeeBean> getListOfunderOrownEmployee(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery(
					"FROM EmployeeBean WHERE under_manager_id='" + manager_id + "' or managerBean='" + manager_id + "'")
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

	public List<GradeMasterBean> getListOfGrade() {
		List<GradeMasterBean> listOfGrade = new ArrayList<GradeMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfGrade = session.createQuery("FROM GradeMasterBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGrade;

	}

	public List<MonthBean> getListOfMonth() {
		List<MonthBean> listofMonth = new ArrayList<MonthBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listofMonth = session.createQuery("from MonthBean where month_id !=13").list();
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
			listofyear = session.createQuery("from YearBean order by year DESC").list();
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

	public List<SoftskillBean> getListOfSoftskill() {
		List<SoftskillBean> listOfSoftskill = new ArrayList<SoftskillBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSoftskill = session.createQuery("FROM SoftskillBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSoftskill;

	}

	public List<TechnicalBean> getListOfTechnical() {
		List<TechnicalBean> listOfTechnical = new ArrayList<TechnicalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTechnical = session.createQuery("FROM TechnicalBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfTechnical;
	}

	public List<ManagerBean> getListOfManager() {
		List<ManagerBean> listOfManager = new ArrayList<ManagerBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManager = session.createQuery("FROM ManagerBean order by manager_name ASC").list();
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

	public List<Object[]> getReviewbyId(int review_id) {
		List<Object[]> listOfReview = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ReviewBean r inner join r.projectMasterBean p join r.yearBean y join r.monthBean m join r.employeeBean e  where r.review_id='"
					+ review_id + "' ";

			Query query = session.createQuery(hql);
			listOfReview = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReview;
	}

	public List<Object[]> getTechnicalbyId(int review_id) {
		List<Object[]> listOfReviewCriteria = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ReviewCriteriaBean rt inner join rt.reviewBean r join rt.technicalBean t join rt.gradeMasterBean g where r.review_id='"
					+ review_id + "' ";

			Query query = session.createQuery(hql);
			listOfReviewCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReviewCriteria;
	}

	public List<Object[]> getSoftskillbyId(int review_id) {
		List<Object[]> listOfReviewSoftskill = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ReviewSoftskillBean st inner join st.reviewBean r join st.softskillBean s join st.gradeMasterBean g where r.review_id='"
					+ review_id + "' ";

			Query query = session.createQuery(hql);
			listOfReviewSoftskill = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReviewSoftskill;
	}

	public List<Object[]> getSpecificCriteriaById(int manager_id) {
		List<Object[]> listOfSpecificCriteria = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaAllocationBean s inner join s.yearBean y join s.monthBean m join s.projectMasterBean p join s.employeeBean m where s.under_manager_id='"
					+ manager_id + "'";

			Query query = session.createQuery(hql);
			listOfSpecificCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteria;
	}

	public List<Object[]> getSpecificAllocatedCriteriaById(int manager_id) {
		List<Object[]> listOfSpecificCriteria = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaBean s inner join s.projectMasterBean p join s.employeeBean m where s.under_manager_id='"
					+ manager_id + "'";

			Query query = session.createQuery(hql);
			listOfSpecificCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteria;
	}

	public List<Object[]> getSpecificCriteriaSearch(int employee_master_id, int project_master_id, int month_id,
			int year_id) {
		List<Object[]> listOfSpecificCriteria = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaAllocationBean s inner join s.yearBean y join s.monthBean m join s.projectMasterBean p join s.employeeBean e where e.employee_master_id='"
					+ employee_master_id + "' and p.project_master_id='" + project_master_id + "' and m.month_id='"
					+ month_id + "' and y.year_id='" + year_id + "'";

			Query query = session.createQuery(hql);
			listOfSpecificCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteria;
	}

	public List<Object[]> getSpecificAllocatedCriteriaSearch(int employee_master_id, int project_master_id,
			int month_id, int year_id) {
		List<Object[]> listOfSpecificCriteria = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaMonthBean s inner join s.yearBean y join s.monthBean m join s.specificCriteriaBean s1 where s1.employeeBean='"
					+ employee_master_id + "' and s1.projectMasterBean='" + project_master_id + "' and m.month_id='"
					+ month_id + "' and y.year_id='" + year_id + "'";

			Query query = session.createQuery(hql);
			listOfSpecificCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteria;
	}

	public List<Object[]> getReviewByUserId(int employee_master_id) {

		List<Object[]> listOfReview = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ReviewBean reviewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from ReviewBean r inner join r.employeeBean e join r.monthBean m join r.yearBean y where e.employee_master_id="
							+ employee_master_id + "");
			listOfReview = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReview;
	}

	public List<ManagerGradeMasterBean> getListOfManagerGrade() {
		List<ManagerGradeMasterBean> listOfManagerGrade = new ArrayList<ManagerGradeMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfManagerGrade = session.createQuery("FROM ManagerGradeMasterBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfManagerGrade;

	}

	public List<Object[]> getReviewByEmployeeId(int employee_master_id) {

		List<Object[]> listOfReview = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ReviewBean reviewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from ReviewBean r inner join r.employeeBean e join r.monthBean m join r.projectMasterBean p join r.yearBean y where e.employee_master_id="
							+ employee_master_id + "");
			listOfReview = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReview;
	}

	public List<Object[]> getTechnicalManagerbyId(int review_id) {
		List<Object[]> listOfReviewCriteria = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ReviewCriteriaBean rt inner join rt.reviewBean r join rt.technicalBean t join rt.gradeMasterBean g join rt.managerGradeMasterBean mg where r.review_id='"
					+ review_id + "' ";

			Query query = session.createQuery(hql);
			listOfReviewCriteria = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReviewCriteria;
	}

	public List<Object[]> getSoftskillManagerbyId(int review_id) {
		List<Object[]> listOfReviewSoftskill = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from ReviewSoftskillBean st inner join st.reviewBean r join st.softskillBean s join st.gradeMasterBean g join st.managerGradeMasterBean where r.review_id='"
					+ review_id + "' ";

			Query query = session.createQuery(hql);
			listOfReviewSoftskill = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReviewSoftskill;
	}

	public List<Object[]> getReviewByMonth(int employee_master_id, int month_id, int year_id) {

		List<Object[]> listOfReview = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ReviewBean reviewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from ReviewBean r inner join r.employeeBean e join r.monthBean m join r.yearBean y where e.employee_master_id="
							+ employee_master_id + " and m.month_id=" + month_id + " and y.year_id=" + year_id + "");
			listOfReview = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReview;
	}

	public List<Object[]> duplicationSearch(int employee_master_id, int month_id, int year, int project_id) {

		List<Object[]> listOfsearch = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ReviewBean reviewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from ReviewBean r inner join r.employeeBean e join r.monthBean m join r.yearBean y join r.projectMasterBean p where e.employee_master_id='"
							+ employee_master_id + "' and m.month_id='" + month_id + "' and y.year_id='" + year
							+ "' and p.project_master_id='" + project_id + "'");
			listOfsearch = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfsearch;
	}

	public List<Object[]> getReviewByManagerId(int manager_id) {

		List<Object[]> listOfReview = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ReviewBean reviewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from ReviewBean r inner join r.employeeBean e join r.monthBean m join r.projectMasterBean p join r.yearBean y where e.under_manager_id="
							+ manager_id + " and (r.approve_status='pending' or r.approve_status='updated')");
			listOfReview = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReview;
	}

	public List<Object[]> getEscalatedReview(int employee_id) {

		List<Object[]> listOfReview = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ReviewBean reviewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from ReviewBean r inner join r.employeeBean e join r.monthBean m join r.projectMasterBean p join r.yearBean y where escalated_employee_id = '"
							+ employee_id + "' and r.approve_status='escalated'");
			listOfReview = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReview;
	}

	public List<Object[]> getSpecificProject(int employee_master_id) {
		List<Object[]> listOfSpecificCriteriaProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaAllocationBean s inner join s.yearBean y join s.monthBean m join s.projectMasterBean p join s.employeeBean e where e.employee_master_id='"
					+ employee_master_id + "' and p.projectStatusBean = 3  group by p.project_master_id";

			Query query = session.createQuery(hql);
			listOfSpecificCriteriaProject = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteriaProject;
	}

	public SpecificCriteriaAllocationBean getspecificById(int specific_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		SpecificCriteriaAllocationBean specificCriteriaAllocationBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from SpecificCriteriaAllocationBean where specific_criteria_id=" + specific_id + "");
			specificCriteriaAllocationBean = (SpecificCriteriaAllocationBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return specificCriteriaAllocationBean;
	}

	public List<Object[]> getReviewByEmployee(int employee_id) {

		List<Object[]> listOfReview = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ReviewBean reviewBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from ReviewBean r inner join r.employeeBean e join r.monthBean m join r.projectMasterBean p join r.yearBean y where e.employee_master_id="
							+ employee_id + " and r.approve_status='rejected'");
			listOfReview = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfReview;
	}

	public List<RecommendationOptionsBean> getListOfRecommendtion() {
		List<RecommendationOptionsBean> listOfGrade = new ArrayList<RecommendationOptionsBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfGrade = session.createQuery("FROM RecommendationOptionsBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGrade;

	}

	public List<PriorityBean> getListOfPriority() {
		List<PriorityBean> listOfPriority = new ArrayList<PriorityBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfPriority = session.createQuery("FROM PriorityBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfPriority;

	}

	public List<Object[]> getSpecificProjectList(int manager_id) {
		List<Object[]> listOfSpecificCriteriaProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaAllocationBean s inner join s.projectMasterBean p  where s.under_manager_id='"
					+ manager_id + "' group by p.project_master_id";

			Query query = session.createQuery(hql);
			listOfSpecificCriteriaProject = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteriaProject;
	}

	public List<Object[]> getSpecificEmployeeList(int manager_id) {
		List<Object[]> listOfSpecificCriteriaProject = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaAllocationBean s inner join s.employeeBean e  where s.under_manager_id='"
					+ manager_id + "' group by e.employee_master_id";

			Query query = session.createQuery(hql);
			listOfSpecificCriteriaProject = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteriaProject;
	}

	public List<ClientMasterBean> getListOfClient() {
		List<ClientMasterBean> listOfClient = new ArrayList<ClientMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfClient = session.createQuery("FROM ClientMasterBean order by client_master_name ASC").list();
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

	public List<Object[]> pendingTimeSheetHome(int manager_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where (t.task_time_status ='submit' or t.task_time_status ='updated') and (t.approval_status = 'pending') and e.under_manager_id='"
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

	public List<Object[]> getListOfChangePriorityByEmployeeId(int employee_id) {
		List<Object[]> listOfChangePriority = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfChangePriority = session.createQuery(
					"FROM ChangePriorityNotificationBean c inner join c.employeeBean e where e.employee_master_id='"
							+ employee_id + "' and show_notification = 0")
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
		return listOfChangePriority;

	}

	public List<Object[]> getListOfUpdateProject(int employee_id) {
		List<Object[]> listOfChangePriority = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfChangePriority = session.createQuery(
					"FROM ProjectUpdateNotificationBean c inner join c.employeeBean e where e.employee_master_id='"
							+ employee_id + "' and show_view = 0")
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
		return listOfChangePriority;

	}

	public List<TimeSheetBean> getSavedTimesheet(int employee_master_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where employeeBean = '" + employee_master_id
					+ "' and task_time_status = 'saved' group by date";
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

	public List<Object[]> getWeeklyTimesheet(int employee_master_id) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + " and  t.task_time_status ='saved' group by t.date";
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

	public List<Object[]> getSumOfHours1(int employee_master_id, String date) {
		List<Object[]> listOfTimeSheet = new ArrayList<Object[]>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean t inner join t.employeeBean e join t.dayBean d join t.projectMasterBean p join t.clientMasterBean c join t.taskMasterBean t1 where e.employee_master_id="
					+ employee_master_id + " and t.date ='" + date + "' and (task_time_status = 'saved') ";
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

	public List<EmployeeBean> getFullListOfEmployee() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean where employeeStatusBean != 3").list();
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

	public List<EmployeeBean> getFullListOfEmployeeIt() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean where managerBean = 65 or under_manager_id = 65")
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

	public List<UnitOfMeasurementBean> getListOfUnit() {
		List<UnitOfMeasurementBean> listOfUnit = new ArrayList<UnitOfMeasurementBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfUnit = session.createQuery("from UnitOfMeasurementBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfUnit;
	}

	public List<AllocationNotificationBean> getFullNotification(int manager_id) {
		List<AllocationNotificationBean> listOfAllocation = new ArrayList<AllocationNotificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocation = session.createQuery(
					"FROM AllocationNotificationBean where allocationPercentageBean.employeeBean.under_manager_id = "
							+ manager_id + " and show_view = 0")
					.list();
			System.out.println(listOfAllocation.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocation;

	}

	public List<AllocationNotificationBean> getFullNotificationOfAllocation(int manager_id) {
		List<AllocationNotificationBean> listOfAllocation = new ArrayList<AllocationNotificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfAllocation = session.createQuery(
					"FROM AllocationNotificationBean where projectAllocationBean.employeeBean.under_manager_id = "
							+ manager_id + " and show_view = 0")
					.list();
			System.out.println(listOfAllocation.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAllocation;

	}

	public SpecificCriteriaBean getspecificCriteriaById(int specific_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		SpecificCriteriaBean specificCriteriaBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from SpecificCriteriaBean where specific_criteria_Allocation_id=" + specific_id + "");
			specificCriteriaBean = (SpecificCriteriaBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return specificCriteriaBean;
	}

	public List<SpecificCriteriaSoftskillBean> getSpecificAllocatedCriteriaSoftskill(int id) {
		List<SpecificCriteriaSoftskillBean> listOfSpecificCriteriaSoftskill = new ArrayList<SpecificCriteriaSoftskillBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaSoftskillBean where specificCriteriaBean=" + id + "";

			Query query = session.createQuery(hql);
			listOfSpecificCriteriaSoftskill = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteriaSoftskill;
	}

	public List<SpecificCriteriaTechnicalBean> getSpecificAllocatedCriteriaTechnical(int id) {
		List<SpecificCriteriaTechnicalBean> listOfSpecificCriteriaTechnical = new ArrayList<SpecificCriteriaTechnicalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaTechnicalBean where specificCriteriaBean=" + id + "";

			Query query = session.createQuery(hql);
			listOfSpecificCriteriaTechnical = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteriaTechnical;
	}

	public List<SpecificCriteriaMonthBean> getSpecificAllocatedCriteriaMonth(int id) {
		List<SpecificCriteriaMonthBean> listOfSpecificCriteriaMonth = new ArrayList<SpecificCriteriaMonthBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from SpecificCriteriaMonthBean where specificCriteriaBean=" + id + "";

			Query query = session.createQuery(hql);
			listOfSpecificCriteriaMonth = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecificCriteriaMonth;
	}

	public List<RoleBean> getListOfRole() {
		List<RoleBean> listOfRole = new ArrayList<RoleBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRole = session.createQuery("FROM RoleBean order by role_type ASC").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRole;

	}

	public List<ProjectMasterBean> getListOfProjectTaskReminder(int manager_id) {
		List<ProjectMasterBean> listProjectTaskReminder = new ArrayList<ProjectMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listProjectTaskReminder = session.createQuery(
					"FROM ProjectMasterBean p where not exists(from TaskMasterBean t where p.project_master_id=t.projectMasterBean) and p.managerBean='"
							+ manager_id + "'")
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
		return listProjectTaskReminder;

	}

	public List<CurrencyBean> getListOfCurrency() {
		List<CurrencyBean> listOfCurrency = new ArrayList<CurrencyBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCurrency = session.createQuery("FROM CurrencyBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCurrency;

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

	public List<EmployeeBean> getListOfEmployeeById(int employee_master_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session
					.createQuery("FROM EmployeeBean where employee_master_id = '" + employee_master_id + "'").list();
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

	/* risk Management */

	public List<RiskRepositoryBean> getRiskByEmployee(int employee_id) {

		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from RiskRepositoryBean where employeeBean=" + employee_id + "");
			listOfRisk = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRisk;
	}

	public List<RiskRepositoryBean> getRiskByEmployeeContingency(int employee_id) {

		List<RiskRepositoryBean> listOfRisk = new ArrayList<RiskRepositoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		RiskRepositoryBean riskRepositoryBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from RiskRepositoryBean where employee_id_contingency =" + employee_id + "");
			listOfRisk = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRisk;
	}

	public List<ConcernPersonBean> getConcernPersonByEmployeeId(int employee_id) {

		List<ConcernPersonBean> listOfRisk = new ArrayList<ConcernPersonBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ConcernPersonBean concernPersonBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ConcernPersonBean where employee_master_id =" + employee_id + "");
			listOfRisk = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRisk;
	}

	public List<SpecificCriteriaBean> getSpecificCriteria(int emp_id, int project_id) {

		List<SpecificCriteriaBean> specificCriteriaBean = new ArrayList<SpecificCriteriaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM SpecificCriteriaBean WHERE employeeBean = '" + emp_id
					+ "' and projectMasterBean = '" + project_id + "'");
			specificCriteriaBean = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return specificCriteriaBean;
	}

	public List<ProjectAllocationBean> getAllocation(int emp_id, int task_id) {

		List<ProjectAllocationBean> listOfProjectAllocation = new ArrayList<ProjectAllocationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM ProjectAllocationBean WHERE employeeBean = '" + emp_id
					+ "' and taskMasterBean = '" + task_id + "'");
			listOfProjectAllocation = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfProjectAllocation;
	}

	public List<ScoreAreaBean> getListOfScoreArea() {
		List<ScoreAreaBean> listOfScore = new ArrayList<ScoreAreaBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfScore = session.createQuery("FROM ScoreAreaBean").list();
			System.out.println(listOfScore.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfScore;

	}

	public List<SuggestionBean> getSuggestionByEmployeeId(int employee_id) {
		List<SuggestionBean> listOfSuggestion = new ArrayList<SuggestionBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSuggestion = session
					.createQuery("FROM SuggestionBean where riskRepositoryBean.employeeBean = '" + employee_id + "'")
					.list();
			System.out.println(listOfSuggestion.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSuggestion;
	}

	public List<ConcernPersonBean> getlistOfConcernPersonWithEmployee(int risk_id, int employee_id) {

		List<ConcernPersonBean> listOfConcernPerson = new ArrayList<ConcernPersonBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ConcernPersonBean concernPersonBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ConcernPersonBean where risk_repository_id =" + risk_id
					+ " and employee_master_id =" + employee_id + " ");
			listOfConcernPerson = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfConcernPerson;
	}

	public List<ConcernPersonBean> getlistOfConcernPerson(int risk_id) {

		List<ConcernPersonBean> listOfConcernPerson = new ArrayList<ConcernPersonBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ConcernPersonBean concernPersonBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ConcernPersonBean where risk_repository_id =" + risk_id + "");
			listOfConcernPerson = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfConcernPerson;
	}

	public List<SuggestionBean> getSuggestionByEmployeeIdConcernPerson() {
		List<SuggestionBean> listOfSuggestion = new ArrayList<SuggestionBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSuggestion = session.createQuery("FROM SuggestionBean").list();
			System.out.println(listOfSuggestion.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSuggestion;
	}

	public List<SuggestionBean> getSuggestionByEmployeeIdContingency(int employee_id) {
		List<SuggestionBean> listOfSuggestion = new ArrayList<SuggestionBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSuggestion = session.createQuery(
					"FROM SuggestionBean where riskRepositoryBean.employee_id_contingency = '" + employee_id + "'")
					.list();
			System.out.println(listOfSuggestion.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSuggestion;
	}

	public List<EmployeeStatusBean> getListOfEmployeeStatus() {
		List<EmployeeStatusBean> listOfEmployeeStatus = new ArrayList<EmployeeStatusBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployeeStatus = session.createQuery("FROM EmployeeStatusBean").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployeeStatus;

	}

	public List<DepartmentBean> getListOfDepartment() {
		List<DepartmentBean> listOfDepartment = new ArrayList<DepartmentBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDepartment = session.createQuery("FROM DepartmentBean order by department_name ASC").list();
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

	public List<UnplanProjectBean> getUnplanRejectedTimesheet(int employee_master_id) {
		List<UnplanProjectBean> listOfTimeSheet = new ArrayList<UnplanProjectBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from UnplanProjectBean u where not exists(from TimeSheetBean t where t.date=u.date) and approval_status = 'rejected' and employeeBean='"
					+ employee_master_id + "' group by date";
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

	public List<TimeSheetBean> pendingAndUpdatedTimeSheet(int manager_id) {
		List<TimeSheetBean> listOfPendingAndUpdatedTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from TimeSheetBean where task_time_status ='submit' and (approval_status = 'pending' or approval_status = 'updated') and employeeBean.under_manager_id='"
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

	public List<EmployeeCSVUploadBean> getListOfEmployee(String employee_code, int com_id, String mob_num) {
		List<EmployeeCSVUploadBean> listOfEmployee = new ArrayList<EmployeeCSVUploadBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeCSVUploadBean where employee_code='" + employee_code
					+ "' and company_list_id = '" + com_id + "' ").list();
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

	public List<AppraisalBean> getAllappraisalByEmployeeIDStatus(int emp_id) {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=1 and employeeBean.under_manager_id = '" + emp_id
					+ "' and status = 'pending'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<EmployeeBean> getListOfEmployeeM1() {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery(
					"FROM EmployeeBean WHERE roleBean.role_authority ='A1' OR roleBean.role_authority ='A2' OR roleBean.role_authority ='A3' Or roleBean.role_authority ='A4' OR roleBean.role_authority ='W1' OR roleBean.role_authority ='W2' OR roleBean.role_authority ='W3' OR roleBean.role_authority ='T2'")
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

	public List<EmployeeBean> getListOfEmployeeM1AndManager(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery(
					"FROM EmployeeBean WHERE (roleBean.role_authority ='A1' OR roleBean.role_authority ='A2' OR roleBean.role_authority ='A3' Or roleBean.role_authority ='A4' OR roleBean.role_authority ='W1' OR roleBean.role_authority ='W2' OR roleBean.role_authority ='W3' OR roleBean.role_authority ='T2')   and under_manager_id = "
							+ manager_id + " and employeeStatusBean != 3")
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

	public ProjectMasterBean detailsOfProject(int project_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ProjectMasterBean projectMasterBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ProjectMasterBean where project_master_id=" + project_id + "");
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

	public List<EmployeeBean> getAllManager() {

		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("from EmployeeBean where manager_id != 99").list();
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

	public ClientMasterBean getClientInfoById(String client_name) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ClientMasterBean clientMasterBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM ClientMasterBean WHERE client_master_name='" + client_name + "'");
			clientMasterBean = (ClientMasterBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return clientMasterBean;

	}

	public List<TaskMasterBean> getListOfTaskWithoutManager(int project_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("FROM TaskMasterBean where projectMasterBean='" + project_id
					+ "' and managerBean = 200 group by emp_id ").list();
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

	public List<TaskMasterBean> getListOfFullTaskWithoutManager(int project_id, int emp_id) {
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfTask = session.createQuery("FROM TaskMasterBean where projectMasterBean='" + project_id
					+ "' and managerBean = 200 and emp_id ='" + emp_id + "' and task_id = 0").list();
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

	public List<EmployeeBean> getListOfAllEmployeeByCompanyCodeOrEmpCode(String com_code, int emp_code) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery(
					"FROM EmployeeBean where companyListBean='" + com_code + "' and employee_code = '" + emp_code + "'")
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

	public List<AppraisalBean> getWhiteAppraisalApprovedByAllDepartment() {
		List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from AppraisalBean where white_collar=1 and status='approved'";
			Query query = session.createQuery(hql);
			listOfAppraisal = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfAppraisal;
	}

	public List<RoleBean> getListOfRoleById(String role_name) {
		List<RoleBean> listOfRole = new ArrayList<RoleBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRole = session.createQuery("FROM RoleBean where role_authority = '" + role_name + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRole;

	}

	public List<EmployeeBean> getListOfEmployeeByCompany(int company_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery(
					"FROM EmployeeBean where companyListBean = '" + company_id + "' and employeeStatusBean != 3")
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

	public List<RoleBean> getListOfRoleByType(String role_type) {
		List<RoleBean> listOfRole = new ArrayList<RoleBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfRole = session.createQuery("FROM RoleBean where role_type = '" + role_type + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRole;

	}

	public List<CompanyListBean> getListOfCompany() {
		List<CompanyListBean> listOfCompany = new ArrayList<CompanyListBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfCompany = session.createQuery("FROM CompanyListBean").list();
			System.out.println(listOfCompany.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfCompany;

	}

	public List<ProjectHoldHistoryBean> getListOfHistoryByProject(int project_id) {
		List<ProjectHoldHistoryBean> listOfProjectHistory = new ArrayList<ProjectHoldHistoryBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfProjectHistory = session
					.createQuery("FROM ProjectHoldHistoryBean where projectMasterBean = '" + project_id + "'").list();
			System.out.println(listOfProjectHistory.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfProjectHistory;

	}

	public List<FamilyDetailBean> getListOfFamilyMember(int employee_master_id) {
		List<FamilyDetailBean> listOfFamilyMember = new ArrayList<FamilyDetailBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfFamilyMember = session
					.createQuery("FROM FamilyDetailBean where employeeBean = '" + employee_master_id + "'").list();
			System.out.println(listOfFamilyMember.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfFamilyMember;

	}

	// List of Relation Detail from family_relation_tbl

	public List<FamilyRelationBean> getListOfFamilyRelation() {
		List<FamilyRelationBean> listOfFamilyRelation = new ArrayList<FamilyRelationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfFamilyRelation = session.createQuery("FROM FamilyRelationBean").list();
			System.out.println(listOfFamilyRelation.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfFamilyRelation;

	}

	// List Of Basic Qualification
	// Date : 22-06-2017

	public List<BasicQualificationBean> getListOfBasicQualification() {
		List<BasicQualificationBean> listOfBasicQualification = new ArrayList<BasicQualificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfBasicQualification = session.createQuery("FROM BasicQualificationBean").list();
			System.out.println(listOfBasicQualification.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfBasicQualification;

	}

	// List Of Special Qualification
	// Date : 22-06-2017

	public List<SpecialQualificationBean> getListOfSpecialQualification() {
		List<SpecialQualificationBean> listOfSpecialQualification = new ArrayList<SpecialQualificationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfSpecialQualification = session.createQuery("FROM SpecialQualificationBean").list();
			System.out.println(listOfSpecialQualification.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSpecialQualification;

	}

	// List Of Graduate Degree
	// Date : 22-06-2017

	public List<GraduateDegreeBean> getListOfGraduateDegree() {
		List<GraduateDegreeBean> listOfGraduateDegree = new ArrayList<GraduateDegreeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfGraduateDegree = session.createQuery("FROM GraduateDegreeBean").list();
			System.out.println(listOfGraduateDegree.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfGraduateDegree;

	}

	// List Of Graduate Degree
	// Date : 22-06-2017

	public List<MasterDegreeBean> getListOfMasterDegree() {
		List<MasterDegreeBean> listOfMasterDegree = new ArrayList<MasterDegreeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfMasterDegree = session.createQuery("FROM MasterDegreeBean").list();
			System.out.println(listOfMasterDegree.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfMasterDegree;

	}

	// List Of ITI Course
	// Date : 22-06-2017

	public List<ITICourseBean> getListOfITICourse() {
		List<ITICourseBean> listOfITICourse = new ArrayList<ITICourseBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfITICourse = session.createQuery("FROM ITICourseBean").list();
			System.out.println(listOfITICourse.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfITICourse;
	}

	// List Of Diploma Course
	// Date : 22-06-2017

	public List<DiplomaCourseBean> getListOfDiplomaCourse() {
		List<DiplomaCourseBean> listOfDiplomaCourse = new ArrayList<DiplomaCourseBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDiplomaCourse = session.createQuery("FROM DiplomaCourseBean").list();
			System.out.println(listOfDiplomaCourse.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDiplomaCourse;
	}

	// List Of Birth Days
	// Date : 22-06-2017

	public List<EmployeeBean> getListOfBirthDays() {
		List<EmployeeBean> listOfDiplomaCourse = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDiplomaCourse = session.createQuery(
					"FROM EmployeeBean where (DAY(birth_date)=DAY(NOW()) AND MONTH(birth_date)=MONTH(NOW())) AND employeeStatusBean != 3")
					.list();
			System.out.println(listOfDiplomaCourse.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDiplomaCourse;
	}

	// List Of Work Anniversary
	// Date : 23-08-2017

	public List<EmployeeBean> getListOfWorkAnniversary() {
		List<EmployeeBean> listOfDiplomaCourse = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfDiplomaCourse = session.createQuery(
					"FROM EmployeeBean where (DAY(joining_date)=DAY(NOW()) AND MONTH(joining_date)=MONTH(NOW())) AND employeeStatusBean != 3")
					.list();
			System.out.println(listOfDiplomaCourse.size());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfDiplomaCourse;
	}

	public List<EmployeeBean> getProbatioEmployeeList(int manager_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from EmployeeBean where under_manager_id='" + manager_id
					+ "' and employeeStatusBean.employee_status_id = 2 and company_list_id != 8";

			Query query = session.createQuery(hql);
			listOfEmployee = query.list();
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

	public MonthBean getListOfMonthById(int month_id) {
		List<MonthBean> listofMonth = new ArrayList<MonthBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		MonthBean monthBean = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from MonthBean where month_id !=13 and month_id = " + month_id + "");
			monthBean = (MonthBean) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return monthBean;
	}

	public List<EmployeeBean> getEmployeeDetail(int employee_master_id) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from EmployeeBean where employee_master_id = '" + employee_master_id + "'";

			Query query = session.createQuery(hql);
			listOfEmployee = query.list();
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

	
	/* Stored Procedure for rejected timesheet*/
	public List<TimeSheetBean> SPgetRejectedTimesheet(int employee_master_id) {
		List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			
			SQLQuery query = (SQLQuery) session.createSQLQuery("CALL rejectedTimesheetByEmpId(:empId)")
                    .addEntity(TimeSheetBean.class)
                    .setParameter("empId",employee_master_id);
			
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
	
	
	// Store Procedure For Pending Timesheet
		public List<TimeSheetBean> SPgetPendingTimeSheet(int manager_id) {
			List<TimeSheetBean> listOfTimeSheet = new ArrayList<TimeSheetBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				
				SQLQuery query = (SQLQuery) session.createSQLQuery("CALL pendingTimesheet(:managerId)")
	            .addEntity(TimeSheetBean.class)
	            .setParameter("managerId",manager_id);
				
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
		
		
		
		/* Store Procedure For Unplan Rejected Timesheet*/
		public List<UnplanProjectBean> SPgetUnplanRejectedTimesheet(int employee_master_id) {
			List<UnplanProjectBean> listOfTimeSheet = new ArrayList<UnplanProjectBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				
				SQLQuery query = (SQLQuery) session.createSQLQuery("CALL unplanRejectedTimesheetById(:empId)")
	                    .addEntity(UnplanProjectBean.class)
	                    .setParameter("empId",employee_master_id);
				
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
		
		
		
		// Store Procedure For Unplan Time sheet
		public List<UnplanProjectBean> SPUnplanTimeSheet(int manager_id) {
			List<UnplanProjectBean> listOfPendingAndUpdatedTimeSheet = new ArrayList<UnplanProjectBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				
				
				
				SQLQuery query = (SQLQuery) session.createSQLQuery("CALL unplanTimesheetByManagerId(:managerId)")
	            .addEntity(UnplanProjectBean.class)
	            .setParameter("managerId",manager_id);
				
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
		
		
		//Store procedure for appraisal by manager_id and status
		public List<AppraisalBean> SPgetAllappraisalByEmployeeIDStatus(int manager_id) {
			List<AppraisalBean> listOfAppraisal = new ArrayList<AppraisalBean>();
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				
				
				SQLQuery query = (SQLQuery) session.createSQLQuery("CALL appraisalByManagerIdStatus(:managerId)")
	            .addEntity(AppraisalBean.class)
	            .setParameter("managerId",manager_id);
				
				listOfAppraisal = query.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listOfAppraisal;
		}
	
}