<%@page import="com.hrms.tds.bean.TDSHrTotalFBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalEBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalDBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalCBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalABean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalBBean"%>
<%@page import="com.hrms.tds.bean.TDSHrBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.tds.dao.TDSListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>TDS List</title>
    <link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN ROBUST CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/users.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/dropzone.css">
    <script src="js/dropzone.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
    <style type="text/css">
    #tablePadding{
		padding-left: 3px;
	}
    </style>
</head>
<body>
<% double TEX = 0.0; %>
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      	<div class="content-body">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h4>List Of TDS Declaration Forms</h4>
			            <hr>
			        </div>
			    </div>

			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">TDS List</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
						<div class="card-body collapse in">
	               			<div class="card-block">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered file-export">
                                    <thead>
                                        <tr>
                                        	<th id="tablePadding">No.</th>
                                        	<th id="tablePadding">Action</th>
                                        	<th id="tablePadding">Employee Code</th>
                                            <th id="tablePadding">Employee Name</th>
                                            <th id="tablePadding">PAN No</th>
                                            <th id="tablePadding">Date Of Birth</th>
                                            <th id="tablePadding">Designation</th>
                                            <th id="tablePadding">Status</th>
                                            <th class="hide">Submission Date</th>
                                            <th class="hide">Gender</th>
                                            <th class="hide">Period</th>
                                            <th class="hide">Company</th>
                                            <th class="hide">Salary</th>
                                            <th class="hide">Bonus</th>
                                            <th class="hide">Leave</th>
                                            <th class="hide">Full & Final Bonus</th>
                                            <th class="hide">Full & Final Leave</th>
                                            <th class="hide">Incentive</th>
                                            <th class="hide">Previous Salary</th>
                                            <th class="hide">Performance</th>
                                            <th class="hide">Total A</th>
                                            <th class="hide">A_Conveyance</th>
                                            <th class="hide">D_Conveyance</th>
                                            <th class="hide">A_Basic Salary</th>
                                            <th class="hide">A_Rent Slip</th>
                                            <th class="hide">A_Hra</th>
                                            <th class="hide">Metro Or Non_Metro</th>
                                            <th class="hide">D_Non Metro Basic Salary</th>
                                            <th class="hide">D_Metro Basic Salary</th>
                                            <th class="hide">D_Non Metro Rent Slip</th>
                                            <th class="hide">D_Metro Rent Slip</th>
                                            <th class="hide">D_Non Metro Hra</th>
                                            <th class="hide">D_Metro Hra</th>
                                            <th class="hide">D_Non Metro HRA </th>
                                            <th class="hide">D_Metro HRA</th>
                                            <th class="hide">Landlord Name</th>
                                            <th class="hide">Landlord PAN No</th>
                                            <th class="hide">House Rant</th>
                                            <th class="hide">A_Medical Allowance</th>
                                            <th class="hide">D_Medical Allowance</th>
                                            <th class="hide">Yearly Or Monthly</th>
                                            <th class="hide">Yearly Meal Card</th>
                                            <th class="hide">Start Date</th>
                                            <th class="hide">End Date</th>
                                            <th class="hide">Days</th>
                                            <th class="hide">Monthly Meal Card</th>
                                            <th class="hide">Meal Card</th>
                                            <th class="hide">LTA During Year</th>
                                            <th class="hide">Actual LTA</th>
                                            <th class="hide">LTA Allowance</th>
                                            <th class="hide">PTAX</th>
                                            <th class="hide">No Of Child</th>
                                            <th class="hide">Education Allowance</th>
                                            <th class="hide">Uniform Allowance During Year</th>
                                            <th class="hide">Actual Uniform</th>
                                            <th class="hide">Uniform Allowance</th>
                                            <th class="hide">Total HRA</th>
                                            <th class="hide">Total B</th>
                                            <th class="hide">Other Income</th>
                                            <th class="hide">A_House Loan Interest</th>
                                            <th class="hide">D_House Loan Interest</th>
                                            <th class="hide">Bank Name</th>
                                            <th class="hide">Bank PAN No</th>
                                            <th class="hide">Bank Address</th>
                                            <th class="hide">Total C</th>
                                            <th class="hide">LIC</th>
                                            <th class="hide">EPF</th>
                                            <th class="hide">PPF</th>
                                            <th class="hide">NSC</th>
                                            <th class="hide">MF</th>
                                            <th class="hide">Tuition Fees</th>
                                            <th class="hide">House Loan Principal</th>
                                            <th class="hide">Stamp Duty And Registration Charge</th>
                                            <th class="hide">Fixed Deposit</th>
                                            <th class="hide">80C Other</th>
                                            <th class="hide">Total D</th>
                                            <th class="hide">80C Total</th>
                                            <th class="hide">A_NPS</th>
                                            <th class="hide">D_NPS</th>
                                            <th class="hide">A_RGESS</th>
                                            <th class="hide">D_RGESS</th>
                                            <th class="hide">Total NPS RGESS</th>
                                            <th class="hide">Total E</th>
                                            <th class="hide">A_Self</th>
                                            <th class="hide">D_Self</th>
                                            <th class="hide">Father's Birhtdate</th>
                                            <th class="hide">A_Father</th>
                                            <th class="hide">D_Father</th>
                                            <th class="hide">A_Health CHeckup</th>
                                            <th class="hide">D_Health CHeckup</th>
                                            <th class="hide">A_Mediclaim</th>
                                            <th class="hide">D_Mediclaim</th>
                                            <th class="hide">Cash Or Cheque</th>
                                            <th class="hide">A_Donation</th>
                                            <th class="hide">D_Donation</th>
                                            <th class="hide">Donation</th>
                                            <th class="hide">A_Donation 80GGC</th>
                                            <th class="hide">D_Donation 80GGC</th>
                                            <th class="hide">Education Loan Interest</th>
                                            <th class="hide">Total F</th>
                                            <th class="hide">Total-G(Taxable Value)</th>
                                            <th class="hide">Tax</th>
                                            <th class="hide">Tax Remit</th>
                                            <th class="hide">Total Tax</th>
                                            <th class="hide">Edu cess</th>
                                            <th class="hide">Total H</th>
                                            <th class="hide">April</th>
                                            <th class="hide">May</th>
                                            <th class="hide">June</th>
                                            <th class="hide">July</th>
                                            <th class="hide">August</th>
                                            <th class="hide">September</th>
                                            <th class="hide">October</th>
                                            <th class="hide">November</th>
                                            <th class="hide">December</th>
                                            <th class="hide">January</th>
                                            <th class="hide">February</th>
                                            <th class="hide">March</th>
                                            <th class="hide">TAx Paid</th>
                                            <th class="hide">Tax Payable</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    
                                    <%TDSListDAO tdsListDAO = new TDSListDAO(); 
                                    List<TDSHrBean> listOfHrTDS = tdsListDAO.getAllTdsHrList();
                                    
                                    for(int i = 0;i<listOfHrTDS.size();i++){
                                    	TDSHrBean tdsHrBean = listOfHrTDS.get(i);
                                    	int tds_hr_id = tdsHrBean.getTds_hr_id();
                                    	
                                    	TDSHrBean t = tdsListDAO.detailsOfTDSHr(tds_hr_id);
                                    	TDSHrTotalABean ta = tdsListDAO.detailsOfTDSHrTotal_A(tds_hr_id);
                                    	TDSHrTotalBBean tb = tdsListDAO.detailsOfTDSHrTotal_B(tds_hr_id);
                                    	TDSHrTotalCBean tc = tdsListDAO.detailsOfTDSHrTotal_C(tds_hr_id);
                                    	TDSHrTotalDBean td = tdsListDAO.detailsOfTDSHrTotal_D(tds_hr_id);
                                    	TDSHrTotalEBean te = tdsListDAO.detailsOfTDSHrTotal_E(tds_hr_id);
                                    	TDSHrTotalFBean tf = tdsListDAO.detailsOfTDSHrTotal_F(tds_hr_id);
                                    
                                    %>
                                    	<tr>
                                    		<td id="tablePadding"><%=i+1 %></td>
                                    		<td id="tablePadding">
				                                  <a href="TDSHrUpdate.jsp?tds_hr_id=<%=t.getTds_hr_id()%>">
				                                    	<i class=" fa fa-eye" data-toggle="tooltip" data-placement="top" title="View TDS"></i>
				                                   </a>&nbsp;
                                    		<%TEX = tf.getTax();
                                    		System.out.println("TAX:"+TEX);
                                    		if(TEX == 0.0){
                                    		%>
                                    		<a href="TDSForm16PartA.jsp?tds_hr_id=<%=t.getTds_hr_id()%> ">
                                    		<i class=" glyphicon glyphicon-print" data-toggle="tooltip" data-placement="top" title="Form-16(Part-A)"></i></a>
                                    		<%}else{%>
                                    		<a href="TDSForm16PartB.jsp?tds_hr_id=<%=t.getTds_hr_id()%> ">
                                    		<i class=" glyphicon glyphicon-print" data-toggle="tooltip" data-placement="top" title="Form-16(Part-B)"></i></a>
                                    		<% }%>
                                    		</td>
                                    		<td id="tablePadding"><%=t.getEmployeeBean().getEmployee_code()%></td>
                                    		<td id="tablePadding"><%=t.getEmployeeBean().getFirstname()%> <%=t.getEmployeeBean().getLastname()%></td>
                                    		<td id="tablePadding"><%=t.getEmployeeBean().getPan_no()%></td>
                                    		<td id="tablePadding"><%=t.getEmployeeBean().getBirth_date()%></td>
                                    		<td id="tablePadding"><%=t.getEmployeeBean().getRoleBean().getRole_type()%></td>
                                    		<td id="tablePadding"><%=t.getStatus()%></td>
                                    		<td class="hide"><%=t.getSubmission_date() %></td>
                                    		<td class="hide"><%=t.getEmployeeBean().getGender()%></td>
                                    		<td class="hide"><%=t.getPeriod() %></td>
                                    		<td class="hide"><%=t.getEmployeeBean().getCompanyListBean().getCompany_name()%></td>
                                    		<td class="hide"><%=ta.getAnnual_gross_salary()%></td>
                                    		<td class="hide"><%=ta.getBonus() %></td>
                                    		<td class="hide"><%=ta.getLeaveCount()%></td>
                                    		<td class="hide"><%=ta.getFull_final_bonus()%></td>
                                    		<td class="hide"><%=ta.getFull_final_leave()%></td>
                                    		<td class="hide"><%=ta.getIncentive()%></td>
                                    		<td class="hide"><%=ta.getPrevious_employeed_salary()%></td>
                                    		<td class="hide"><%=ta.getPerformance_pay()%></td>
                                    		<td class="hide"><%=ta.getTotal_a() %></td>
                                    		<td class="hide"><%=tb.getConveyance() %></td>
                                    		<td class="hide"><%=tb.getD_conveyance()%></td>
                                    		<td class="hide"><%=tb.getA_total_basic() %></td>
                                    		<td class="hide"><%=tb.getA_rent_slip() %></td>
                                    		<td class="hide"><%=tb.getA_hra() %></td>
                                    		<td class="hide"><%=tb.getMetro_non_metro() %></td>
                                    		<td class="hide"><%=tb.getD_non_metro_total_basic()%></td>
                                    		<td class="hide"><%=tb.getD_metro_total_basic() %></td>
                                    		<td class="hide"><%=tb.getD_non_metro_rent_slip() %></td>
                                    		<td class="hide"><%=tb.getD_metro_rent_slip() %></td>
                                    		<td class="hide"><%=tb.getD_non_metro_hra() %></td>
                                    		<td class="hide"><%=tb.getD_metro_hra() %></td>
                                    		<td class="hide"><%=tb.getHra_non_metro_deduction() %></td>
                                    		<td class="hide"><%=tb.getHra_metro_deduction() %></td>
                                    		<td class="hide"><%=tb.getLandlord_name() %></td>
                                    		<td class="hide"><%=tb.getLandlord_pan_no() %></td>
                                    		<td class="hide"><%=tb.getHouse_rant() %></td>
                                    		<td class="hide"><%=tb.getA_medical()%></td>
                                    		<td class="hide"><%=tb.getD_medical() %></td>
                                    		<td class="hide"><%=tb.getMonthly_yearly()%></td>
                                    		<td class="hide"><%=tb.getYearly_mealcard() %></td>
                                    		<td class="hide"><%=tb.getMonthly_start_date() %></td>
                                    		<td class="hide"><%=tb.getMonthly_end_date() %></td>
                                    		<td class="hide"><%=tb.getDays() %></td>
                                    		<td class="hide"><%=tb.getMonthly_mealcard() %></td>
                                    		<td class="hide"><%=tb.getMeal_card() %></td>
                                    		<td class="hide"><%=tb.getLta_during_year() %></td>
                                    		<td class="hide"><%=tb.getActual_expenditure_lta() %></td>
                                    		<td class="hide"><%=tb.getD_lta()%></td>
                                    		<td class="hide"><%=tb.getPtax() %></td>
                                    		<td class="hide"><%=tb.getNo_of_child() %></td>
                                    		<td class="hide"><%=tb.getD_education_allw() %></td>
                                    		<td class="hide"><%=tb.getUni_allw_during_year() %></td>
                                    		<td class="hide"><%=tb.getActual_expenditure_uni_allw() %></td>
                                    		<td class="hide"><%=tb.getD_uni_allw() %></td>
                                    		<td class="hide"><%=tb.getTotal_hra() %></td>
                                    		<td class="hide"><%=tb.getTotal_b() %></td>
                                    		<td class="hide"><%=tc.getOther_income() %></td>
                                    		<td class="hide"><%=tc.getA_house_loan() %></td>
                                    		<td class="hide"><%=tc.getD_house_loan() %></td>
                                    		<td class="hide"><%=tc.getBank_name() %></td>
                                    		<td class="hide"><%=tc.getBank_pan_no() %></td>
                                    		<td class="hide"><%=tc.getBank_address() %></td>
                                    		<td class="hide"><%=tc.getTotal_c() %></td>
                                    		<td class="hide"><%=td.getLife_insurance() %></td>
                                    		<td class="hide"><%=td.getEPF() %></td>
                                    		<td class="hide"><%=td.getPPF() %></td>
                                    		<td class="hide"><%=td.getNSC() %></td>
                                    		<td class="hide"><%=td.getMF() %></td>
                                    		<td class="hide"><%=td.getTuition_fees() %></td>
                                    		<td class="hide"><%=td.getStamp_duty() %></td>
                                    		<td class="hide"><%=td.getHouse_loan_principal() %></td>
                                    		<td class="hide"><%=td.getTax_saver_deposite() %></td>
                                    		<td class="hide"><%=td.getOther() %></td>
                                    		<td class="hide"><%=td.getA_total_d() %></td>
                                    		<td class="hide"><%=td.getD_total_d() %></td>
                                    		<td class="hide"><%=te.getA_NPS() %></td>
                                    		<td class="hide"><%=te.getD_NPS()%></td>
                                    		<td class="hide"><%=te.getA_RGESS() %></td>
                                    		<td class="hide"><%=te.getD_RGESS() %></td>
                                    		<td class="hide"><%=te.getTotal_NPS_RGESS() %></td>
                                    		<td class="hide"><%=te.getTotal_e() %></td>
                                    		<td class="hide"><%=tf.getA_self() %></td>
                                    		<td class="hide"><%=tf.getD_self() %></td>
                                    		<td class="hide"><%=tf.getFather_birthdate() %></td>
                                    		<td class="hide"><%=tf.getA_parents() %></td>
                                    		<td class="hide"><%=tf.getD_parents() %></td>
                                    		<td class="hide"><%=tf.getA_health_checkup() %></td>
                                    		<td class="hide"><%=tf.getD_health_checkup() %></td>
                                    		<td class="hide"><%=tf.getA_mediclaim() %></td>
                                    		<td class="hide"><%=tf.getD_mediclaim() %></td>
                                    		<td class="hide"><%=tf.getCash_cheque() %></td>
                                    		<%String donation = tf.getCash_cheque();
                                    		if(donation.equalsIgnoreCase("Cash")){%>
                                    			<td class="hide"><%=tf.getA_cash_amount() %></td>
                                    			<td class="hide"><%=tf.getD_cash_amount() %></td>
                                    		<%}else{ %>
                                    			<td class="hide"><%=tf.getA_cheque_amount() %></td>
                                    			<td class="hide"><%=tf.getD_cheque_amount() %></td>
                                    		<%} %>
                                    		<td class="hide"><%=tf.getDonation_80G() %></td>
                                    		<td class="hide"><%=tf.getA_donation_80GGC()%></td>
                                    		<td class="hide"><%=tf.getD_donation_80GGC() %></td>
                                    		<td class="hide"><%=tf.getEducation_loan() %></td>
                                    		<td class="hide"><%=tf.getTotal_80EGD()%></td>
                                    		<td class="hide"><%=tf.getTotal_f() %></td>
                                    		<td class="hide"><%=tf.getTax() %></td>
                                    		<td class="hide"><%=tf.getTax_remit() %></td>
                                    		<td class="hide"><%=tf.getTotal_tax() %></td>
                                    		<td class="hide"><%=tf.getEdu_cess() %></td>
                                    		<td class="hide"><%=tf.getTotal_h() %></td>
                                    		<td class="hide"><%=tf.getApril() %></td>
                                    		<td class="hide"><%=tf.getMay() %></td>
                                    		<td class="hide"><%=tf.getJune() %></td>
                                    		<td class="hide"><%=tf.getJuly() %></td>
                                    		<td class="hide"><%=tf.getAugust() %></td>
                                    		<td class="hide"><%=tf.getSeptember() %></td>
                                    		<td class="hide"><%=tf.getOctober() %></td>
                                    		<td class="hide"><%=tf.getNovember() %></td>
                                    		<td class="hide"><%=tf.getDecember() %></td>
                                    		<td class="hide"><%=tf.getJanuary() %></td>
                                    		<td class="hide"><%=tf.getFebruary() %></td>
                                    		<td class="hide"><%=tf.getMarch() %></td>
                                    		<td class="hide"><%=tf.getTax_paid() %></td>
                                    		<td class="hide"><%=tf.getTax_payable() %></td>
                                    	</tr>
                                    	<%} %>
                                    	
                                    </tbody> 
                         		 </table>
                              </div>
                          </div>
                        </div>
                     </div>
                  </div> 
              </div>
           </div>
        </div>
   </div>
	
<%@include file="footer.html"%>
	
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/tether.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/libraries/bootstrap.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/unison.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/blockUI.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/jquery-sliding-menu.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/sliders/slick/slick.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/ui/screenfull.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/extensions/pace.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
  <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.flash.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/jszip.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/pdfmake.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/vfs_fonts.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.html5.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.print.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <script>
	$(document).ready(function(){
			 $(".hide").hide();
	});
	</script>
	
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
     
</body>
</html>