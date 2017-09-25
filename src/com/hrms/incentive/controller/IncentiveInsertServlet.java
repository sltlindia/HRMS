package com.hrms.incentive.controller;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.incentive.bean.AksharNewBean;
import com.hrms.incentive.bean.AksharRepeatBean;
import com.hrms.incentive.bean.BrahmastraNewBean;
import com.hrms.incentive.bean.BrahmastraRepeatBean;
import com.hrms.incentive.bean.ClassificationBean;
import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.incentive.bean.IncentiveCriteriaBean;
import com.hrms.incentive.bean.IncentiveSalesPersonListBean;
import com.hrms.incentive.bean.LaserMasterBean;
import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.incentive.bean.TargetBean;
import com.hrms.incentive.bean.ZoneBean;
import com.hrms.incentive.dao.AllIncentiveDeleteDAO;
import com.hrms.incentive.dao.AllIncentiveInsertDAO;
import com.hrms.incentive.dao.AllIncentiveListDAO;
import com.hrms.incentive.dao.AllIncentiveUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllListDAO;

public class IncentiveInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IncentiveInsertServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {

			AllListDAO allListDAO = new AllListDAO();
			MonthBean monthBean = new MonthBean();

			String poDate = request.getParameter("poDate");
			String sjoDate = request.getParameter("sjoDate");
			String invDate = request.getParameter("invDate");
			String invoiceNo = request.getParameter("invoiceNo");

			String[] split = invDate.split("-");
			int year = Integer.parseInt(split[0]);
			int month = Integer.parseInt(split[1]);
			String date = split[2];
			
			
			String[] splitPO = poDate.split("-");
			int yearPO = Integer.parseInt(splitPO[0]);
			int monthPO = Integer.parseInt(splitPO[1]);
			String datePO = splitPO[2];

			YearBean yearBean = allListDAO.detailsOfYear(year);
			monthBean.setMonth_id(month);

			String customer = request.getParameter("customer");
			int zone_id = Integer.parseInt(request.getParameter("zone"));
			int product_id = Integer.parseInt(request.getParameter("product"));
			int classification_id = Integer.parseInt(request.getParameter("classification"));
			String scope = request.getParameter("scope");
			String remarks = request.getParameter("remarks");

			double inv_amt = Double.parseDouble(request.getParameter("inv_amt"));
			double basicPrice = Double.parseDouble(request.getParameter("basicPrice"));
			double qut_price = Double.parseDouble(request.getParameter("qut_price"));
			double deductions = Double.parseDouble(request.getParameter("deductions"));
			double accesories = Double.parseDouble(request.getParameter("accesories"));
			double netBasic = Double.parseDouble(request.getParameter("netBasic"));
			double discount = Double.parseDouble(request.getParameter("discount"));

			String product_code = request.getParameter("model");
			int lasersource = Integer.parseInt(request.getParameter("laserSource"));
			String newRepeat = request.getParameter("newRepeat");
			String customer_code = request.getParameter("customerCode");

			yearBean.setYear_id(yearBean.getYear_id());

			SalespersonBean salespersonBean = new SalespersonBean();

			ZoneBean zoneBean = new ZoneBean();
			zoneBean.setZone_id(zone_id);

			ProductMasterBean productMasterBean = new ProductMasterBean();
			productMasterBean.setProduct_master_id(product_id);

			ClassificationBean classificationBean = new ClassificationBean();
			classificationBean.setClassification_id(classification_id);

			LaserMasterBean laserMasterBean = new LaserMasterBean();
			laserMasterBean.setLaser_master_id(lasersource);

			String[] sales_idList = request.getParameterValues("sales");
			String[] designationList = request.getParameterValues("designation");

			AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();

			/*
			 * String designation = salespersonBean2.getDesignation(); //
			 * Designation Of Sales Person
			 */

			ProductMasterBean productMasterBean2 = allIncentiveListDAO.getListOfProduct(product_id);
			String machine_category = productMasterBean2.getMachine_category();

			String incentive_status = "not paid";
			int incentive_id = 0;
			IncentiveBean incentiveBean = null;
			double incentive_eligible_percentage = 0;
			String eligible_incentive_save = "yes";
			String newRepeatFlag = newRepeat;
			boolean flag = false;
			
			if(newRepeat.equalsIgnoreCase("repeat")) {
				
			for (int i = 0; i < sales_idList.length; i++) {
				String designation = designationList[i];
					if(designation.equalsIgnoreCase("SERVICE")) {
						flag = true;
					}
			}
			
			if(flag == false) {
				newRepeatFlag = "new";
			}
			
			}
			
			System.out.println(newRepeatFlag);

			if(request.getParameter("inc_id") == null){
				
			for (int i = 0; i < sales_idList.length; i++) {
				double valueOfSlab = 0;
				int sales_id = Integer.parseInt(sales_idList[i]);
				String designation = designationList[i];
				

				if (sales_id != 0) {

					System.out.println("salesId:" + sales_id);
					System.out.println("designation:" + designation);

					if (newRepeatFlag.equalsIgnoreCase("new")) {

						if (machine_category.equalsIgnoreCase("AKSHAR")) {
							System.out.println("akshar");

							AksharNewBean aksharNewBean = allIncentiveListDAO.getDetailOfNewAkshar(discount);

							if (designation.toUpperCase().equals("SE/SSE") || designation.toUpperCase().equals("SSE")
									|| designation.toUpperCase().equals("SE")) {
								valueOfSlab = aksharNewBean.getSe_sse();
							} else if (designation.toUpperCase().equals("ASM")) {
								valueOfSlab = aksharNewBean.getAsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = aksharNewBean.getZsm();

							}

						} else if (machine_category.equalsIgnoreCase("BRAHMASTRA")) {
							BrahmastraNewBean brahmastraNewBean = allIncentiveListDAO
									.getDetailOfNewBrahmastra(discount);

							if (designation.toUpperCase().equals("AM")) {
								valueOfSlab = brahmastraNewBean.getAm();
							} else if (designation.toUpperCase().equals("RSM")) {
								valueOfSlab = brahmastraNewBean.getRsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = brahmastraNewBean.getZsm();
							}

						}

					} else if (newRepeatFlag.equalsIgnoreCase("repeat")) {

						if (machine_category.equalsIgnoreCase("AKSHAR")) {

							AksharRepeatBean aksharRepeatBean = allIncentiveListDAO.getDetailOfrepeatAkshar(discount);

							if (designation.toUpperCase().equals("SE/SSE") || designation.toUpperCase().equals("SSE")
									|| designation.toUpperCase().equals("SE")) {
								valueOfSlab = aksharRepeatBean.getSe_sse();
							} else if (designation.toUpperCase().equals("ASM")) {
								valueOfSlab = aksharRepeatBean.getAsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = aksharRepeatBean.getZsm();
							} else if (designation.toUpperCase().equals("SERVICE")) {
								valueOfSlab = aksharRepeatBean.getService();
							}

						} else if (machine_category.equalsIgnoreCase("BRAHMASTRA")) {
							BrahmastraRepeatBean brahmastraRepeatBean = allIncentiveListDAO
									.getDetailOfRepeatBrahmastra(discount);

							if (designation.toUpperCase().equals("SE/SSE") ||designation.toUpperCase().equals("SE") || designation.toUpperCase().equals("SSE")) {
								valueOfSlab = brahmastraRepeatBean.getSe_sse();
							} else if (designation.toUpperCase().equals("ASM")) {
								valueOfSlab = brahmastraRepeatBean.getAsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = brahmastraRepeatBean.getZsm();
							} else if (designation.toUpperCase().equals("SERVICE")) {
								valueOfSlab = brahmastraRepeatBean.getService();
							}

						}

					}

					System.out.println("slabe:" + valueOfSlab);

					double amount = (valueOfSlab * netBasic) / 100;

					System.out.println("Amount:" + amount);

					salespersonBean.setSales_person_id(sales_id);

					AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
					AllIncentiveInsertDAO allInsertDAO = new AllIncentiveInsertDAO();
					
					
					
					
					
					

					if (i == 0) {

						if (request.getParameter("incentive_id") != null) {

							incentive_id = Integer.parseInt(request.getParameter("incentive_id"));
							boolean result = allIncentiveUpdateDAO.incentiveSlabValueUpdate(incentive_id, valueOfSlab,
									amount);
							request.setAttribute("incentive_id", incentive_id);

						} else if (request.getParameter("inc_id") != null) {
							
							incentive_id = Integer.parseInt(request.getParameter("inc_id"));
							incentiveBean = new IncentiveBean(incentive_id, poDate, sjoDate, invDate, customer, scope,
									remarks, basicPrice, discount, qut_price, product_code, newRepeat, deductions,
									netBasic, accesories, valueOfSlab, amount, invoiceNo, incentive_status, monthBean,
									yearBean, salespersonBean, zoneBean, productMasterBean, classificationBean,
									laserMasterBean, customer_code,incentive_eligible_percentage,eligible_incentive_save,inv_amt);
							boolean result = allIncentiveUpdateDAO.incentiveUpdate(incentiveBean);
							request.setAttribute("incentive_id", incentive_id);
						} else {
							
							incentiveBean = new IncentiveBean(poDate, sjoDate, invDate, customer, scope, remarks,
									basicPrice, discount, qut_price, product_code, monthBean, yearBean, salespersonBean,
									zoneBean, productMasterBean, classificationBean, laserMasterBean, newRepeat,
									deductions, netBasic, accesories, valueOfSlab, amount, invoiceNo, incentive_status,
									customer_code,incentive_eligible_percentage,eligible_incentive_save,inv_amt);
							
							boolean result = allInsertDAO.incentiveInsert(incentiveBean);
							incentive_id = incentiveBean.getIncentive_id();
							incentiveBean.setIncentive_id(incentive_id);
							request.setAttribute("incentive_id", incentive_id);

							IncentiveSalesPersonListBean incentiveSalesPersonListBean = new IncentiveSalesPersonListBean(
									valueOfSlab, amount, salespersonBean, designation, incentiveBean,incentive_status);
							boolean reslut1 = allInsertDAO.incentiveSalesPersonInsert(incentiveSalesPersonListBean);
							
							
							String count = allIncentiveListDAO.getCountOfTargetBySalesIdAndYearAndProductId(sales_id, yearPO,product_id,monthPO);
							List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(sales_id, monthPO , yearPO, product_id);
							List<IncentiveSalesPersonListBean> listOfIncentiveAsHigherDesignation = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(sales_id, monthPO, yearPO, product_id);
							
							
							
							int achived = listOfIncentive.size()+listOfIncentiveAsHigherDesignation.size();
							
							double achived_per = 0;
							int target = 0;
							if(count != null) {
								target = Integer.parseInt(count);
							}
							
							
							if(target != 0){
							 achived_per = (achived * 100)/target;
							}else if(achived != 0){
								achived_per = 50;
							}
							
							
							System.out.println("achieved:"+achived);
							System.out.println("target:"+target);
							
							String w = String.format("%.2f", achived_per);
							System.out.println(w);
								
								if(achived_per != 0){
								IncentiveCriteriaBean incentiveCriteriaBean = allIncentiveListDAO.getListOfIncentiveByCriteria(achived_per);
								incentive_eligible_percentage = incentiveCriteriaBean.getEligible_incentive();																	
								}
								
								System.out.println("incentive_eligible_percentage"+incentive_eligible_percentage);
								
								for(IncentiveSalesPersonListBean incentiveSalesPersonListBean1 : listOfIncentiveAsHigherDesignation) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveSalesPersonListBean1.getIncentiveBean().getIncentive_id());
								}
								
								
								for(IncentiveBean incentiveBean1 : listOfIncentive) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveBean1.getIncentive_id());
								}
								
							
						}
					} else {
						
						IncentiveSalesPersonListBean incentiveSalesPersonListBean = new IncentiveSalesPersonListBean(
								valueOfSlab, amount, salespersonBean, designation, incentiveBean,incentive_status);
						boolean reslut1 = allInsertDAO.incentiveSalesPersonInsert(incentiveSalesPersonListBean);
						
						String count = allIncentiveListDAO.getCountOfTargetBySalesIdAndYearAndProductId(sales_id, yearPO,product_id,monthPO);
						List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(sales_id, monthPO , yearPO, product_id);
						List<IncentiveSalesPersonListBean> listOfIncentiveAsHigherDesignation = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(sales_id, monthPO, yearPO, product_id);
						
						
						
						int achived = listOfIncentive.size()+listOfIncentiveAsHigherDesignation.size();
						
						double achived_per = 0;
						int target = 0;
						if(count != null) {
							target = Integer.parseInt(count);
						}
						
						if(target != 0){
						 achived_per = (achived * 100)/target;
						}
						else if(achived != 0){
							achived_per = 50;
						}
						
						String w = String.format("%.2f", achived_per);
						System.out.println("achieved:"+achived);
						System.out.println("target:"+target);	
							if(achived_per != 0){
							IncentiveCriteriaBean incentiveCriteriaBean = allIncentiveListDAO.getListOfIncentiveByCriteria(achived_per);
							incentive_eligible_percentage = incentiveCriteriaBean.getEligible_incentive();																	
							}
							
							
							System.out.println("incentive_eligible_percentage"+incentive_eligible_percentage);
							
					
							for(IncentiveSalesPersonListBean incentiveSalesPersonListBean1 : listOfIncentiveAsHigherDesignation) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveSalesPersonListBean1.getIncentiveBean().getIncentive_id());
								}
								
								
								for(IncentiveBean incentiveBean1 : listOfIncentive) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveBean1.getIncentive_id());
								}
						
						
					}

				}

			}
			
			
		}else{
			String[] incentivePersonList = request.getParameterValues("incentivePersonListId");
			incentive_eligible_percentage = Double.parseDouble(request.getParameter("incentive_eligible_percentage"));
			eligible_incentive_save = request.getParameter("eligible_incentive_save");
			
			for (int i = 0; i < sales_idList.length; i++) {
				double valueOfSlab = 0;
				int sales_id = Integer.parseInt(sales_idList[i]);
				
				int incentivePersonListId = Integer.parseInt(incentivePersonList[i]);
				if (sales_id != 0) {
					String designation = designationList[i];
					System.out.println("salesId:" + sales_id);
					System.out.println("designation:" + designation);
					System.out.println("incentivePersonListId:" + incentivePersonListId);

					if (newRepeatFlag.equalsIgnoreCase("new")) {

						if (machine_category.equalsIgnoreCase("AKSHAR")) {

							AksharNewBean aksharNewBean = allIncentiveListDAO.getDetailOfNewAkshar(discount);

							if (designation.toUpperCase().equals("SE/SSE") || designation.toUpperCase().equals("SSE")
									|| designation.toUpperCase().equals("SE")) {
								valueOfSlab = aksharNewBean.getSe_sse();
							} else if (designation.toUpperCase().equals("ASM")) {
								valueOfSlab = aksharNewBean.getAsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = aksharNewBean.getZsm();

							}

						} else if (machine_category.equalsIgnoreCase("BRAHMASTRA")) {
							BrahmastraNewBean brahmastraNewBean = allIncentiveListDAO
									.getDetailOfNewBrahmastra(discount);

							if (designation.toUpperCase().equals("AM")) {
								valueOfSlab = brahmastraNewBean.getAm();
							} else if (designation.toUpperCase().equals("RSM")) {
								valueOfSlab = brahmastraNewBean.getRsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = brahmastraNewBean.getZsm();
							}

						}

					} else if (newRepeatFlag.equalsIgnoreCase("repeat")) {

						if (machine_category.equalsIgnoreCase("AKSHAR")) {

							AksharRepeatBean aksharRepeatBean = allIncentiveListDAO.getDetailOfrepeatAkshar(discount);

							if (designation.toUpperCase().equals("SE/SSE") || designation.toUpperCase().equals("SSE")
									|| designation.toUpperCase().equals("SE")) {
								valueOfSlab = aksharRepeatBean.getSe_sse();
							} else if (designation.toUpperCase().equals("ASM")) {
								valueOfSlab = aksharRepeatBean.getAsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = aksharRepeatBean.getZsm();
							} else if (designation.toUpperCase().equals("SERVICE")) {
								valueOfSlab = aksharRepeatBean.getService();
							}

						} else if (machine_category.equalsIgnoreCase("BRAHMASTRA")) {
							BrahmastraRepeatBean brahmastraRepeatBean = allIncentiveListDAO
									.getDetailOfRepeatBrahmastra(discount);

							if (designation.toUpperCase().equals("SE/SSE") ||designation.toUpperCase().equals("SE") || designation.toUpperCase().equals("SSE")) {
								valueOfSlab = brahmastraRepeatBean.getSe_sse();
							} else if (designation.toUpperCase().equals("ASM")) {
								valueOfSlab = brahmastraRepeatBean.getAsm();
							} else if (designation.toUpperCase().equals("ZSM")) {
								valueOfSlab = brahmastraRepeatBean.getZsm();
							} else if (designation.toUpperCase().equals("SERVICE")) {
								valueOfSlab = brahmastraRepeatBean.getService();
							}

						}

					}
					
					

					System.out.println("slabe:" + valueOfSlab);

					double amount = (valueOfSlab * netBasic) / 100;

					System.out.println("Amount:" + amount);

					salespersonBean.setSales_person_id(sales_id);

					AllIncentiveUpdateDAO allIncentiveUpdateDAO = new AllIncentiveUpdateDAO();
					AllIncentiveInsertDAO allInsertDAO = new AllIncentiveInsertDAO();
					
					
					
					
						
					

					if (i == 0) {
							incentive_id = Integer.parseInt(request.getParameter("inc_id"));
							incentiveBean = new IncentiveBean(incentive_id, poDate, sjoDate, invDate, customer, scope,
									remarks, basicPrice, discount, qut_price, product_code, newRepeat, deductions,
									netBasic, accesories, valueOfSlab, amount, invoiceNo, incentive_status, monthBean,
									yearBean, salespersonBean, zoneBean, productMasterBean, classificationBean,
									laserMasterBean, customer_code,incentive_eligible_percentage,eligible_incentive_save,inv_amt);
							boolean result = allIncentiveUpdateDAO.incentiveUpdate(incentiveBean);
							request.setAttribute("incentive_id", incentive_id);
							
							IncentiveSalesPersonListBean  incentiveSalesPersonListBean = new IncentiveSalesPersonListBean(incentivePersonListId, valueOfSlab, amount, designation, salespersonBean, incentiveBean,incentive_status);
							boolean result1 = allIncentiveUpdateDAO.incentiveListSaPersonUpdate(incentiveSalesPersonListBean);
							
							String count = allIncentiveListDAO.getCountOfTargetBySalesIdAndYearAndProductId(sales_id, yearPO,product_id,monthPO);
							List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(sales_id, monthPO , yearPO, product_id);
							List<IncentiveSalesPersonListBean> listOfIncentiveAsHigherDesignation = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(sales_id, monthPO, yearPO, product_id);
							
							
							
							int achived = listOfIncentive.size()+listOfIncentiveAsHigherDesignation.size();
							
							double achived_per = 0;
							int target = 0;
							if(count != null) {
								target = Integer.parseInt(count);
							}
							
							if(target != 0){
							 achived_per = (achived * 100)/target;
							}
							else if(achived != 0){
								achived_per = 50;
							}
							
							System.out.println("achieved:"+achived);
							System.out.println("target:"+target);
							
							String w = String.format("%.2f", achived_per);
							System.out.println(w);
								
								if(achived_per != 0){
								IncentiveCriteriaBean incentiveCriteriaBean = allIncentiveListDAO.getListOfIncentiveByCriteria(achived_per);
								incentive_eligible_percentage = incentiveCriteriaBean.getEligible_incentive();																	
								}
								
								
								System.out.println("incentive_eligible_percentage"+incentive_eligible_percentage);
								
								
								for(IncentiveSalesPersonListBean incentiveSalesPersonListBean1 : listOfIncentiveAsHigherDesignation) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveSalesPersonListBean1.getIncentiveBean().getIncentive_id());
								}
								
								
								for(IncentiveBean incentiveBean1 : listOfIncentive) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveBean1.getIncentive_id());
								}
								
							
							
					} else {
						
						if(incentivePersonListId !=0){
							IncentiveSalesPersonListBean  incentiveSalesPersonListBean = new IncentiveSalesPersonListBean(incentivePersonListId, valueOfSlab, amount, designation, salespersonBean, incentiveBean,incentive_status);
							boolean result1 = allIncentiveUpdateDAO.incentiveListSaPersonUpdate(incentiveSalesPersonListBean);
							
							String count = allIncentiveListDAO.getCountOfTargetBySalesIdAndYearAndProductId(sales_id, yearPO,product_id,monthPO);
							List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(sales_id, monthPO , yearPO, product_id);
							List<IncentiveSalesPersonListBean> listOfIncentiveAsHigherDesignation = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(sales_id, monthPO, yearPO, product_id);
							
							
							
							int achived = listOfIncentive.size()+listOfIncentiveAsHigherDesignation.size();
							
							double achived_per = 0;
							int target = 0;
							if(count != null) {
								target = Integer.parseInt(count);
							}
							
							if(target != 0){
							 achived_per = (achived * 100)/target;
							}
							else if(achived != 0){
								achived_per = 50;
							}
							
							System.out.println("achieved:"+achived);
							System.out.println("target:"+target);
							
							String w = String.format("%.2f", achived_per);
							System.out.println(w);
								
								if(achived_per != 0){
								IncentiveCriteriaBean incentiveCriteriaBean = allIncentiveListDAO.getListOfIncentiveByCriteria(achived_per);
								incentive_eligible_percentage = incentiveCriteriaBean.getEligible_incentive();																	
								}
								
								
								System.out.println("incentive_eligible_percentage"+incentive_eligible_percentage);
								
								
								for(IncentiveSalesPersonListBean incentiveSalesPersonListBean1 : listOfIncentiveAsHigherDesignation) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveSalesPersonListBean1.getIncentiveBean().getIncentive_id());
								}
								
								
								for(IncentiveBean incentiveBean1 : listOfIncentive) {
								boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveBean1.getIncentive_id());
								}
								
							
						}else{
						IncentiveSalesPersonListBean incentiveSalesPersonListBean = new IncentiveSalesPersonListBean(
								valueOfSlab, amount, salespersonBean, designation, incentiveBean,incentive_status);
						boolean reslut1 = allInsertDAO.incentiveSalesPersonInsert(incentiveSalesPersonListBean);
						
						String count = allIncentiveListDAO.getCountOfTargetBySalesIdAndYearAndProductId(sales_id, yearPO,product_id,monthPO);
						List<IncentiveBean> listOfIncentive = allIncentiveListDAO.getListOfIncentiveBySalesId(sales_id, monthPO , yearPO, product_id);
						List<IncentiveSalesPersonListBean> listOfIncentiveAsHigherDesignation = allIncentiveListDAO.getListOfIncentiveBySalesIdForHigherDesignation(sales_id, monthPO, yearPO, product_id);
						
						
						
						int achived = listOfIncentive.size()+listOfIncentiveAsHigherDesignation.size();
						
						double achived_per = 0;
						int target = 0;
						if(count != null) {
							target = Integer.parseInt(count);
						}
						
						if(target != 0){
						 achived_per = (achived * 100)/target;
						}
						else if(achived != 0){
							achived_per = 50;
						}
						
						String w = String.format("%.2f", achived_per);
						System.out.println(w);
							
							if(achived_per != 0){
							IncentiveCriteriaBean incentiveCriteriaBean = allIncentiveListDAO.getListOfIncentiveByCriteria(achived_per);
							incentive_eligible_percentage = incentiveCriteriaBean.getEligible_incentive();																	
							}
							
							System.out.println("incentive_eligible_percentage"+incentive_eligible_percentage);
							
							for(IncentiveSalesPersonListBean incentiveSalesPersonListBean1 : listOfIncentiveAsHigherDesignation) {
							   boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveSalesPersonListBean1.getIncentiveBean().getIncentive_id());
							}
							
							
							for(IncentiveBean incentiveBean1 : listOfIncentive) {
							boolean result2 = allIncentiveUpdateDAO.incentiveEligibleStatusUpdateSalesPersoWise(sales_id,incentive_eligible_percentage,incentiveBean1.getIncentive_id());
							}
							
						
						}
					}
						
						

				}else if(incentivePersonListId != 0){
					
					AllIncentiveDeleteDAO allIncentiveDeleteDAO = new AllIncentiveDeleteDAO();
					boolean result = allIncentiveDeleteDAO.incentiveSalesPersonId(incentivePersonListId);
					
					
				}
				
				

			}
			
			
			
		}

			request.getRequestDispatcher("incentiveView.jsp").forward(request, response);

		} else {
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
