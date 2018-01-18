<!-- Author Name :- Ripal Soni
For Getting data from user
Jsp for getting data from manager,hr manager and top managements and their view  
for indirect employees
 -->

<%@page import="java.util.ArrayList"%>
<%@page
	import="com.hrms.probation.bean.ProbationTopManagementApprovalBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM2Bean"%>
<%@page import="com.hrms.probation.bean.AttributeM2Bean"%>
<%@page import="com.hrms.probation.bean.ProbationExtendBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentManagerBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM1Bean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.probation.bean.AttributeBean"%>
<%@page import="com.hrms.probation.dao.AllListProbationDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.hrms.pms.bean.CurrencyBean"%>
<%@page import="com.hrms.pms.bean.PriorityBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.bean.CriteriaPerBean"%>
<%@page import="com.hrms.pms.dao.CriteriaPerDAO"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="com.hrms.pms.bean.GradeMasterBean"%>
<%@page import="com.hrms.pms.bean.SoftskillBean"%>
<%@page import="com.hrms.pms.bean.TechnicalBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>SLTL HRMS</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
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
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
<script type="text/javascript">
	function refresh(id) {

		var employee_master_id = document.getElementById("employee_master_id").value;
		window.location
				.replace("probationListByIdDirect.jsp?employee_master_id="
						+ employee_master_id);

	}

	function hideMessage() {
		//document.getElementById("panelbody").style.display="none"; 
		$('#panelbody').fadeOut('slow');
	}

	function startTimer() {
		var tim = window.setTimeout("hideMessage()", 5000); // 5000 milliseconds = 5 seconds
	}
</script>
<script type="text/javascript">
	function check(id) {
		if (id == "confirmedNo") {
			if (document.getElementById("extendedNo").checked == true) {
				document.getElementById("terminatedYes").checked = true;
			}
			if (document.getElementById("terminatedNo").checked == true) {
				document.getElementById("extendedYes").checked = true;
			}
		} else if (id == "extendedNo") {
			if (document.getElementById("terminatedNo").checked == true) {
				document.getElementById("confirmedYes").checked = true;
			}
			if (document.getElementById("confirmedNo").checked == true) {
				document.getElementById("terminatedYes").checked = true;
			}
		} else if (id == "terminatedNo") {
			if (document.getElementById("extendedNo").checked == true) {
				document.getElementById("confirmedYes").checked = true;
			}
			if (document.getElementById("confirmedNo").checked == true) {
				document.getElementById("extendedYes").checked = true;
			}
		}

		if (id == "confirmedYes") {
			document.getElementById("extendedNo").checked = true;
			document.getElementById("terminatedNo").checked = true;
		} else if (id == "extendedYes") {
			document.getElementById("confirmedNo").checked = true;
			document.getElementById("terminatedNo").checked = true;
		} else if (id == "terminatedYes") {
			document.getElementById("extendedNo").checked = true;
			document.getElementById("confirmedNo").checked = true;
		}

	}
</script>
<script>
	$(document).ready(function() {
		$("#period_extend").hide();

		$('#extendedYes').on('change', function() {
			if (this.value == 'extendedYes') {
				$("#period_extend").show();
			}

		});
		$('#extendedNo').on('change', function() {
			if (this.value == 'extendedNo') {
				$("#period_extend").hide();
			}
		});
	});
</script>
<title>SLTL HRMS</title>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns " onload="startTimer()">
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Probation Assessment</h1>
			        </div>
			    </div>
	
			<%
				if (request.getAttribute("Score") != null) {
			%>
			<div class="panel-body" id="panelbody">
				<div class="alert alert-dismissable alert-success ">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${Score}
				</div>
			</div>
			<%
				}
			%>
			<%
				int manager_id = user.getManagerBean().getManager_id();
				int emp_id = 0;

				if (request.getParameter("employee_master_id") != null) {
					emp_id = Integer.parseInt(request.getParameter("employee_master_id"));
				} else {
					emp_id = (Integer) request.getAttribute("employee_master_id");
				}
			%>
			<form action="probation.jsp" method="get">
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Employee's Probation Form Detail</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-hover">
										<tbody>
											<%
												LoginDAO loginDAO = new LoginDAO();
												EmployeeBean employeeBean = loginDAO.getInfoById(emp_id);
												String authority = employeeBean.getRoleBean().getRole_authority();
											%>
											<tr>
												<td><label>Employee Name :</label></td>
												<td colspan="2"><font color="blue"><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></font></td>
												<td><label>Employee Code :</label></td>
												<td colspan="2"><font color="blue"><%=employeeBean.getEmployee_code()%></font></td>
												<td><label>Reporting Manager Name :</label></td>
												<%
													LoginDAO loginDAO2 = new LoginDAO();
													int id = Integer.parseInt(employeeBean.getUnder_manager_id());
													EmployeeBean employeeBean2 = loginDAO2.getEmailId(id);
												%>
												<td><font color="blue"><%=employeeBean2.getFirstname() + " " + employeeBean2.getLastname()%></font></td>
											</tr>
												<%
													String date = employeeBean.getJoining_date();
													/* DateFormat inputDF  = new SimpleDateFormat("mm/dd/yy"); */
													Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
													String sd = null;
													try {

														SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
														Date result = formater.parse(date);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														sd = AppDateFormat.format(result);

													} catch (ParseException e1) {
														e1.printStackTrace();
													}

													Calendar cal = Calendar.getInstance();
													cal.setTime(date1);
													int month_id = cal.get(Calendar.MONTH);
													int day = cal.get(Calendar.DAY_OF_MONTH);
													int year_id = cal.get(Calendar.YEAR);
													month_id = month_id + 1;
													if (day >= 15) {
														month_id = month_id + 1;
													}
												%>
											<tr>
												<td><label>Date Of Joining:</label></td>
												<td colspan="4"><font color="blue"><%=sd%></font></td>
												<td><label>Designation :</label></td>
												<td colspan="3"><font color="blue"><%=employeeBean.getRoleBean().getRole_type()%></font></td>
											</tr>
											<tr>
											<td><label>Department :</label></td>
											<td colspan="4"><font color="blue"><%=employeeBean.getDepartmentBean().getDepartment_name()%></font></td>
											<td><label>Sub Department :</label></td>
											<td colspan="3"><font color="blue"><%=employeeBean.getSub_department()%></font></td>
											</tr>
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
			</form>
			<%
				AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
				String approval_manager = null;
				String status = null;

				int probation_assessment_manager_id = 0;
				List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO.getListOfScoreByEmpId(emp_id);
				for (ProbationAssessmentManagerBean pm : listOfExtended1) {
					probation_assessment_manager_id = pm.getProbation_assessment_manager_id();

				}
			%>
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-12">
					             <h5 class="card-title" id="horz-layout-basic"><b><font size="2px">Please rate on scale of 1 to 5<br>5 = Excellent,4 = Exceeds Expectations,3 = Fully Achieves Expectations,2 = Met some but not all expectations,1 = Unsatisfactory.</font></b></h5>
				                </div>
				            </div>
					               	 <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">

						<input type="hidden" name="employee_master_id" value="<%=emp_id%>">
						<input type="hidden" name="transfer" value="manager1">
						<div class="panel-body">
							<div class="table-responsive">

								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Sr. No.</th>
											<th>Attributes</th>
											<%
												int to_be_extended = 0;
												List<MonthBean> listOfMonth = allListProbationDAO.getListOfMonth();
												List<ProbationAssessmentManagerBean> listOfExtended2 = allListProbationDAO.getListOfScoreByEmpId(emp_id);
												List<ProbationAssessmentM2Bean> listOfExtendedMonths = allListProbationDAO
														.getListOfScoreByEmpIdGroupbyMonthId(emp_id);
												for (ProbationAssessmentManagerBean li : listOfExtended2) {
													int probationmanager_id = li.getProbation_assessment_manager_id();

													List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
													for (ProbationExtendBean p : listForExtend) {
														String extend_period = p.getExtended_period();
														to_be_extended = to_be_extended + Integer.parseInt(extend_period);

													}
												}
												int size = month_id + 5 + to_be_extended;

												if (size <= 12) {
													for (int i = month_id; i <= size; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														String month = m.getMonth_name();
											%>

											<th><%=month%>, <%=year_id%></th>
											<%
												}
											%>

											<%
												} else {

													for (int j = month_id; j <= 12; j++) {
														MonthBean monthBean = allListProbationDAO.getInfoById(j);
											%>

											<th><%=monthBean.getMonth_name()%>, <%=year_id%></th>
											<%
												}

													int size1 = size - 12;
													for (int i = 1; i <= size1; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														String month = m.getMonth_name();
											%>

											<th><%=month%>, <%=year_id + 1%></th>
											<%
												}
											%>

											<%
												}
											%>
										</tr>
									</thead>
								<%List<AttributeM2Bean> listOfAttribute = null;
if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3")
																			|| authority.equals("T1") || authority.equals("T2") || authority.equals("T3")
																			|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3")
																			|| authority.equals("A4")) {

																		 listOfAttribute = allListProbationDAO.getListOfAttributeM2Direct();
}else {
																	
														 listOfAttribute = allListProbationDAO.getListOfAttributeM2();

}
										for (int i = 0; i < listOfAttribute.size(); i++) {

											AttributeM2Bean a = listOfAttribute.get(i);
											int que_id = a.getProbation_attribute_M2_id();
									%>
									<tbody>
										<tr>

											<td><input type="hidden" name="attribute_id"
												id="attribute_id<%=i%>"
												value="<%=a.getProbation_attribute_M2_id()%>"><%=i + 1%></td>
											<td><%=a.getProbation_attribute_M2_question()%></td>
											<%
												AllListProbationDAO allListProbationDAO1 = new AllListProbationDAO();
													List<MonthBean> listOfMonth1 = allListProbationDAO.getListOfMonth();
													int size2 = month_id + 5 + to_be_extended;

													if (size2 <= 12) {

														for (int k = month_id; k <= size2; k++) {
															MonthBean m = allListProbationDAO.getInfoById(k);
															String month = m.getMonth_name();
															int monthId = m.getMonth_id();
															int employee_master_id1 = emp_id;
															int printYearId = year_id;
															YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
															int insert_year_id = yearBean.getYear_id();
															ProbationAssessmentM2Bean pa = allListProbationDAO.testForM2(employee_master_id1, monthId,
																	que_id, insert_year_id);
											%>

											<td style="width: 100px;"><input type="hidden"
												name="month_id" value="<%=m.getMonth_id()%>"> <%
 	if (pa != null) {
 %>
												<input type="text" class="form-control" name="month_score"
												id="month_score<%=i%><%=k%>"
												value="<%=pa.getAttribute_m2_score()%>"
												placeholder="Enter Score" onchange="handleChange(this.id)"
												disabled="disabled"> <%
 	} else {
 %> <input type="text"
												class="form-control" name="month_score"
												id="month_score<%=i%><%=k%>" value="0" disabled="disabled"
												placeholder="Enter Score" onchange="handleChange(this.id)">
												<%
													}
												%></td>
											<%
												}
													} else {

														for (int l = month_id; l <= 12; l++) {
															MonthBean monthBean = allListProbationDAO.getInfoById(l);
															int employee_master_id1 = emp_id;
															int monthId = monthBean.getMonth_id();
															int printYearId = year_id;
															YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
															int insert_year_id = yearBean.getYear_id();
															ProbationAssessmentM2Bean pa1 = allListProbationDAO.testForM2(employee_master_id1, monthId,
																	que_id, insert_year_id);

															if (pa1 != null) {
											%>
											<td style="width: 100px;"><input type="hidden"
												name="month_id" value="<%=monthBean.getMonth_id()%>"><input
												type="text" class="form-control" name="month_score"
												id="month_score<%=i%><%=l%>"
												value="<%=pa1.getAttribute_m2_score()%>" disabled="disabled"
												placeholder="Enter Score" onchange="handleChange(this.id)">
												<%
													} else {
												%>
											<td style="width: 100px;"><input type="hidden"
												name="month_id" value="<%=monthBean.getMonth_id()%>"><input
												type="text" class="form-control" name="month_score"
												id="month_score<%=i%><%=l%>" value="0" disabled="disabled"
												placeholder="Enter Score" onchange="handleChange(this.id)">
												<%
													}
												%></td>
											<%
												}

														int size3 = size2 - 12;
														for (int k = 1; k <= size3; k++) {
															MonthBean m = allListProbationDAO.getInfoById(k);
															String month = m.getMonth_name();
															int monthId = m.getMonth_id();
															int employee_master_id1 = emp_id;
															int printYearId = year_id + 1;
															YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
															int insert_year_id = yearBean.getYear_id();
															ProbationAssessmentM2Bean pa2 = allListProbationDAO.testForM2(employee_master_id1, monthId,
																	que_id, insert_year_id);
															if (pa2 != null) {
											%>
											<td style="width: 100px;"><input type="hidden"
												name="month_id" value="<%=m.getMonth_id()%>"><input
												type="text" class="form-control" name="month_score"
												id="month_score<%=i%><%=k%>"
												value="<%=pa2.getAttribute_m2_score()%>" disabled="disabled"
												placeholder="Enter Score" onchange="handleChange(this.id)">
												<%
													} else {
												%>
											<td style="width: 100px;"><input type="hidden"
												name="month_id" value="<%=m.getMonth_id()%>"><input
												type="text" class="form-control" name="month_score"
												id="month_score<%=i%><%=k%>" value="0" disabled="disabled"
												placeholder="Enter Score" onchange="handleChange(this.id)">
												<%
													}
												%></td>
											<%
												}
											%>

											<%
												}
											%>
											<%
												}
										int size1 = month_id + 5 + to_be_extended;
											%>

										</tr>

									<%-- 	<tr>
											<td colspan="2">Continue for next month(Yes/No)</td>
											<%
												int size1 = month_id + 5 + to_be_extended;

												if (size1 <= 12) {
													String nextMonth = "-";
													for (int i = month_id; i <= size1; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														int month = m.getMonth_id();
														int printYearId = year_id;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, month, insert_year_id);
														nextMonth = probationAssessmentM2Bean.getContinue_for_next_month();
														if (nextMonth.equalsIgnoreCase("continueYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}
											%>

											<%
												} else {
													String nextMonth = "-";
													for (int j = month_id; j <= 12; j++) {
														MonthBean monthBean = allListProbationDAO.getInfoById(j);
														int printYearId = year_id;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														int month = monthBean.getMonth_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, month, insert_year_id);
														nextMonth = probationAssessmentM2Bean.getContinue_for_next_month();

														if (nextMonth.equalsIgnoreCase("continueYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}

													int size11 = size - 12;
													for (int i = 1; i <= size11; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														String month = m.getMonth_name();
														int monthId = m.getMonth_id();
														int printYearId = year_id + 1;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, monthId, insert_year_id);
														nextMonth = probationAssessmentM2Bean.getContinue_for_next_month();
														if (nextMonth.equalsIgnoreCase("continueYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}
												}
											%>

										</tr>
										<tr>
											<td colspan="2">Issue warning letter(Yes/No)</td>
											<%
												if (size1 <= 12) {
													String warningLetter = "-";
													for (int i = month_id; i <= size1; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														int month = m.getMonth_id();
														int printYearId = year_id;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, month, insert_year_id);
														warningLetter = probationAssessmentM2Bean.getWarning_letter();

														if (warningLetter.equalsIgnoreCase("warningYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}
											%>

											<%
												} else {
													String warningLetter = "-";
													for (int j = month_id; j <= 12; j++) {
														MonthBean monthBean = allListProbationDAO.getInfoById(j);
														int month = monthBean.getMonth_id();
														int printYearId = year_id;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, month, insert_year_id);
														warningLetter = probationAssessmentM2Bean.getWarning_letter();

														if (warningLetter.equalsIgnoreCase("warningYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}

													int size11 = size - 12;
													for (int i = 1; i <= size11; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														String month = m.getMonth_name();
														int monthId = m.getMonth_id();
														int printYearId = year_id + 1;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, monthId, insert_year_id);
														warningLetter = probationAssessmentM2Bean.getWarning_letter();
														if (warningLetter.equalsIgnoreCase("warningYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}
												}
											%>
										</tr>
										<tr>
											<td colspan="2">Issue termination letter(Yes/No)</td>
											<%
												if (size1 <= 12) {
													String terminatoionLetter = "-";
													for (int i = month_id; i <= size1; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														int month = m.getMonth_id();
														int printYearId = year_id;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, month, insert_year_id);
														terminatoionLetter = probationAssessmentM2Bean.getTermination_letter();

														if (terminatoionLetter.equalsIgnoreCase("terminationYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}
											%>

											<%
												} else {
													String terminatoionLetter = "-";
													for (int j = month_id; j <= 12; j++) {
														MonthBean monthBean = allListProbationDAO.getInfoById(j);
														int month = monthBean.getMonth_id();
														int printYearId = year_id;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, month, insert_year_id);
														terminatoionLetter = probationAssessmentM2Bean.getTermination_letter();

														if (terminatoionLetter.equalsIgnoreCase("terminationYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}

													int size11 = size - 12;
													for (int i = 1; i <= size11; i++) {
														MonthBean m = allListProbationDAO.getInfoById(i);
														String month = m.getMonth_name();
														int monthId = m.getMonth_id();
														int printYearId = year_id + 1;
														YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
														int insert_year_id = yearBean.getYear_id();
														ProbationAssessmentM2Bean probationAssessmentM2Bean = allListProbationDAO
																.getValueForExtraParmForM2(emp_id, monthId, insert_year_id);
														terminatoionLetter = probationAssessmentM2Bean.getTermination_letter();
														if (terminatoionLetter.equalsIgnoreCase("terminationYes")) {
											%>
											<td>Yes</td>
											<%
												} else {
											%>
											<td>No</td>
											<%
												}
											%>
											<%
												}
												}
											%>
										</tr> --%>
										<tr>
													<%
														double average = 0;
														double ave = 0;
														double avg_per_attribue = 0;
														List<Double> listOfSeperateArray = new ArrayList();
														List<Double> listOfSeperateArrayPerAttrbute = new ArrayList();
														List<Double> listOfSumByMonth = new ArrayList();
														List<Double> listOfTwiseMonthAverage = new ArrayList();
														List<String> listOfComment = new ArrayList();
														List<Double> listOfFinalPercentage = new ArrayList();
														String final_result = null;
													%>
													<td colspan="2">Total</td>
													<%
														if (size1 <= 12) {
															for (int i = month_id; i <= size1; i++) {
																MonthBean m = allListProbationDAO.getInfoById(i);
																int month = m.getMonth_id();
																int printYearId = year_id;
																YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
																int insert_year_id = yearBean.getYear_id();
																double sum = allListProbationDAO.getSumByMonthForM2(emp_id, month, insert_year_id);
																average = average + sum;
																avg_per_attribue = (sum*100)/(listOfAttribute.size() * 5);
																listOfSeperateArray.add(sum/listOfAttribute.size());
																listOfSeperateArrayPerAttrbute.add(avg_per_attribue);
																listOfSumByMonth.add(sum);
													%>

													<th><%=sum%></th>
													<%
														}
													%>

													<%
														} else {

															for (int j = month_id; j <= 12; j++) {
																MonthBean monthBean = allListProbationDAO.getInfoById(j);
																int printYearId = year_id;
																YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
																int insert_year_id = yearBean.getYear_id();
																int month = monthBean.getMonth_id();

																double sum = allListProbationDAO.getSumByMonthForM2(emp_id, month, insert_year_id);
																average = average + sum;
																avg_per_attribue = (sum*100)/(listOfAttribute.size() * 5);
																listOfSeperateArray.add(sum/listOfAttribute.size());
																listOfSeperateArrayPerAttrbute.add(avg_per_attribue);
																listOfSumByMonth.add(sum);
													%>

													<th><%=sum%></th>
													<%
														}

															int size11 = size - 12;
															for (int i = 1; i <= size11; i++) {
																int printYearId = year_id + 1;
																YearBean yearBean = allListProbationDAO.yearCheck(printYearId);
																int insert_year_id = yearBean.getYear_id();
																MonthBean m = allListProbationDAO.getInfoById(i);
																String month = m.getMonth_name();
																int monthId = m.getMonth_id();
																double sum = allListProbationDAO.getSumByMonthForM2(emp_id, monthId, insert_year_id);
																average = average + sum;
																avg_per_attribue = (sum*100)/(listOfAttribute.size() * 5);
																listOfSeperateArray.add(sum/listOfAttribute.size());
																listOfSeperateArrayPerAttrbute.add(avg_per_attribue);
																listOfSumByMonth.add(sum);
													%>

													<th><%=sum%></th>
													<%
														}
													%>

													<%
														}
													%>
												</tr>
												<tr>
													<td colspan="2">Total Percentage</td>
													<%for(Double d: listOfSeperateArrayPerAttrbute){%>
													<th><%=String.format("%.2f", d)%>%</th>
													<%} %>
												</tr>
												
												<tr>
													<td colspan="2">Average Score Per Attribute</td>
													<%for(Double d: listOfSeperateArray){%>
													<th><%=String.format("%.2f", d)%></th>
													<%} %>
												</tr>
												
												<tr>
													<td colspan="2">Average of Assessment Period</td>
													<%
													double twiseMonthSum = 0;
													String displayOfTwiseMonth = null;
													
													for(int i =0;i<listOfSumByMonth.size();i++){
														ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
														Double d = listOfSumByMonth.get(i);
														twiseMonthSum = twiseMonthSum + d;
														if(displayOfTwiseMonth == null){
															displayOfTwiseMonth = d.toString();
														}else{
															displayOfTwiseMonth = displayOfTwiseMonth +"+"+d;
														}
														if((i+1) % 2 == 0){
															
													%>
													<th colspan="2"><%=displayOfTwiseMonth%>=<%=twiseMonthSum%>/2 = <%=String.format("%.2f", twiseMonthSum/2)%> 
													(<%=String.format("%.2f", ((twiseMonthSum/2) * 100 ) / (listOfAttribute.size() * 5))%>%)
													
													<%listOfTwiseMonthAverage.add(twiseMonthSum/2);
													listOfComment.add(p.getComment_monthly());
													listOfFinalPercentage.add(((twiseMonthSum/2)*100)/(listOfAttribute.size() * 5));
													%>
													
													<%twiseMonthSum = 0;displayOfTwiseMonth=null;%></th>
													<%} %>
													<%} %>
												</tr>
												
												<tr>
													<td colspan="2">Cumulative Average of Assessment Period</td>
													<%
													double sumOfAverage = 0;
													String twiseMonthAverageDisplay = null;
													for(int i = 0;i<listOfTwiseMonthAverage.size();i++){
														Double d = listOfTwiseMonthAverage.get(i);
													 	sumOfAverage = sumOfAverage + d;
													 	if(twiseMonthAverageDisplay == null){
													 		twiseMonthAverageDisplay = d.toString();
													 	}else{
													 		twiseMonthAverageDisplay = twiseMonthAverageDisplay +"+"+d;
													 	}
													 	if(i!=0){
													%>
													<th colspan="2"><%=twiseMonthAverageDisplay%>=<%=sumOfAverage%>/<%=i+1%> = <%=String.format("%.2f", sumOfAverage/(i+1))%>
													(<%=String.format("%.2f", ((sumOfAverage/(i+1)) * 100 ) / (listOfAttribute.size() * 5))%>%)
													</th>
													<%} else{%>
													<th colspan="2">NA</th>
													<%} %>
													<%} %>
												</tr>
												
												<tr>
												<td colspan="2">Comments If Any</td>
													<%
													for(int i = 0;i<listOfComment.size();i++){
														String comment = listOfComment.get(i);
													%>
													<td colspan="2" height ="80px" style="white-space: pre-wrap;"><%=comment %></td>
													<%} %>
												</tr>	
												<tr>
												<td colspan="2">Action As Per Key</td>
													<%
													for(int i = 0;i<listOfFinalPercentage.size();i++){
														Double d = listOfFinalPercentage.get(i);
														String result = null;

														if(i==0){
															if(d<35){
																result = "Terminate";
															}else if(d>=35 && d<40){
																result = "Warn";
															}else if(d>=40){
																result = "Retain";
															}
														}else if(i==1){
															if(d<40){
																result = "Terminate";
															}else if(d>=40 && d<45){
																result = "Warn";
															}else if(d>=45){
																result = "Retain";
															}
														}else if(i==2){
															
															if(d<50){
																result = "Terminate";
															}else if(d>=50 && d<55){
																result = "Warn";
															}else if(d>=55){
																result = "Retain";
															}
														}else {
															if(d<50){
																result = "Terminate";
															}else if(d>=50 && d<55){
																result = "Warn";
															}else if(d>=55){
																result = "Retain";
															}
														}
													%>
													<td colspan="2"><%=result%></td>
													<%} %>
													
													<%-- <%if((listOfExtendedMonths.size() + 1)%2 == 0 && listOfExtendedMonths.size() >=1 ) {%>
													
													<td colspan="2" class="descsion"></td>
													<%} %> --%>
												</tr>	
												
												<%
													ave = average / (6 + to_be_extended);
													String w = String.format("%.2f", ave);
													double overall = ((ave / 50) * 100);
													String overall_performance = String.format("%.2f", overall);
												%>
													<%-- <tr>
														<td colspan="<%=8 + to_be_extended%>"></td>
													</tr>
										<tr>
											<td colspan="<%=8 + to_be_extended%>"><center>
													<b>Part B (To be filled up)</b>
												</center></td>
										</tr>
										<tr>
											<td colspan="2">Average</td>
											<td colspan="<%=to_be_extended + 6%>"><%=w%></td>
										</tr>
										<tr>
											<td colspan="2">Overall Performance(Average Score/50 *
												100)</td>
											<td colspan="<%=to_be_extended + 6%>"><%=overall_performance%>
												%</td>
										</tr>
 --%>



										<input type="hidden" value="<%=w%>" name="average">
										<input type="hidden" value="<%=user.getEmployee_master_id()%>"
											name="reviewing_manager_id">
									</tbody>

								</table>
							</div>




							<%
								String manager_approval = null;
								String manager_rejection_remarks = null;
								String manager_suggestion = null;
								String hr_approval = null;
								String rejection_remarks = null;
								String top_management_approval = null;
								String top_management_rejection_remarks = null;
								int manager_emp_id = 0;
								String reporting_manager_name = null;
								String manager_name1 = null;
								List<ProbationAssessmentManagerBean> listOfScore = allListProbationDAO.getListOfScoreByEmpId(emp_id);
								for (ProbationAssessmentManagerBean score : listOfScore) {

									manager_approval = score.getManager_approval();
									manager_rejection_remarks = score.getManager_rejection_remarks();
									manager_suggestion = score.getManager_suggestion();
									hr_approval = score.getHr_approval();
									rejection_remarks = score.getHr_rejection_remarks();
									top_management_approval = score.getTop_management_approval();
									top_management_rejection_remarks = score.getTop_management_rejection_remarks();
									manager_emp_id = score.getReviewing_manager_id();
									EmployeeBean employeeBean3 = loginDAO.getEmailIdEmployee(manager_emp_id);
									reporting_manager_name = employeeBean3.getFirstname() + " " + employeeBean3.getLastname();
									int under_manager_id = Integer.parseInt(employeeBean3.getUnder_manager_id());
									EmployeeBean employeeBean4 = loginDAO.getEmailId(under_manager_id);
									manager_name = employeeBean4.getFirstname() + " " + employeeBean4.getLastname();
							%>

							<%
								if (manager_approval.equalsIgnoreCase("pending")) {
							%>
							<form action="probationIndirectManagerReviewInsert" method="get"
								name="">
								<%
									} else if (hr_approval.equalsIgnoreCase("pending")) {
								%>
								<form action="probationIndirectHrReviewInsert" method="get"
									name="">
									<%
										} else if (top_management_approval.equalsIgnoreCase("pending")) {
									%>
									<form action="probationIndirectTopManagementReviewInsert"
										method="get" name="">
										<%
											}
										%>



										<div class="col-lg-6">
											<div class="panel-heading">
												<h5>Recommendations of the HOD / Manager (Please
													mention Yes or No)</h5>
											</div>
											<div class="table-responsive">
												<table class="table table-bordered">
													<tr>
														<td>A. To be Confirmed</td>
														<td>
															<%
																if (score.getTo_be_confirmed().equalsIgnoreCase("confirmedYes")) {
															%>
															<div class="form-group">
																<label class="radio-inline"><input type="radio"
																	name="confirmed1" id="confirmed" value="confirmedYes"
																	checked disabled="disabled">Yes </label><label
																	class="radio-inline"><input type="radio"
																	name="confirmed1" id="confirmed" value="confirmedNo"
																	disabled="disabled">No </label>
															</div> <%
 	} else {
 %>
															<div class="form-group">
																<label class="radio-inline"> <input type="radio"
																	name="confirmed1" id="confirmed" value="confirmedYes"
																	disabled="disabled">Yes
																</label> <label class="radio-inline"><input type="radio"
																	name="confirmed1" id="confirmed" value="confirmedNo"
																	checked disabled="disabled">No </label>
															</div> <%
 	}
 %>
														</td>
													</tr>
													<tr>
														<td>B. To be Extended</td>
														<td>
															<%
																if (score.getTo_be_extended().equalsIgnoreCase("extendedYes")) {
															%>
															<div class="form-group">
																<label class="radio-inline"> <input type="radio"
																	name="extended1" id="extended" value="extendedYes"
																	checked disabled="disabled">Yes
																</label> <label class="radio-inline"><input type="radio"
																	name="extended1" id="extended" value="extendedNo"
																	disabled="disabled">No </label>
															</div> <%
 	} else {
 %>
															<div class="form-group">
																<label class="radio-inline"> <input type="radio"
																	name="extended1" id="extended" value="extendedYes"
																	disabled="disabled">Yes
																</label><label class="radio-inline"><input type="radio"
																	name="extended1" id="extended" value="extendedNo"
																	checked disabled="disabled">No </label>
															</div> <%
 	}
 %>
														</td>
													</tr>

													<tr>
														<td>C. To be Terminated</td>
														<td>
															<%
																if (score.getTo_be_terminated().equalsIgnoreCase("terminatedYes")) {
															%>
															<div class="form-group">
																<label class="radio-inline"><input type="radio"
																	name="terminated1" id="terminated"
																	value="terminatedYes" checked disabled="disabled">Yes
																</label> <label class="radio-inline"><input type="radio"
																	name="terminated1" id="terminated" value="terminatedNo"
																	disabled="disabled">No </label>
															</div> <%
 	} else {
 %>
															<div class="form-group">
																<label class="radio-inline"><input type="radio"
																	name="terminated1" id="terminated"
																	value="terminatedYes" disabled="disabled">Yes </label>
																<label class="radio-inline"><input type="radio"
																	name="terminated1" id="terminated" value="terminatedNo"
																	checked disabled="disabled">No </label>
															</div> <%
 	}
 %>
														</td>
													</tr>
												</table>
											</div>

										</div>
										<div class="col-lg-6">
											<div class="panel-heading">
												<h5>Reporting Manager Remarks</h5>
											</div>
											<textarea rows="7" cols="90" class="form-control"
												name="remarks" placeholder="Enter Your Remarks:"
												disabled="disabled"><%=score.getRemarks()%></textarea>
										</div>
										<div class="col-lg-12">
											<label>Total Period To be Extended : </label>
											<%=score.getPeriod_to_be_extended()%>
										</div>
										<%
											}
										%>

										<div class="col-lg-12">
											<label><%=reporting_manager_name%>'s Approval Status: </label> <b><font
												color="green">Approved</font></b>
										</div>
										<%
											if (!manager_approval.equalsIgnoreCase("pending")) {
										%>
										<div class="col-lg-12">
											<label><%=manager_name%>'s Approval Status: </label>
											<%
												if (manager_approval.equalsIgnoreCase("approved")) {
											%>
											<font color="green"><b>Approved</b></font>
											<%
												} else if (manager_approval.equalsIgnoreCase("rejected")) {
											%>
											<font color="red"><b>Rejected</b></font>
											<%
												} else if (manager_approval.equalsIgnoreCase("pending")) {
											%>
											<font color="blue">Pending</font>
											<%
												}
											%>
										</div>
										<%
									if (manager_approval.equalsIgnoreCase("rejected")) {
								%>
								<div class="col-lg-6">
											<label style="color: red">Manager's Reason for Rejection: </label>
											<%if(manager_suggestion.equalsIgnoreCase("toBeConfirmed")){%>
											<input type="text" class="form-control" value="Confirmed" readonly="readonly">
											<%}else if(manager_suggestion.equalsIgnoreCase("toBeExtended")){ %>
											<input type="text" class="form-control" value="Extended" readonly="readonly">
											<%}else {%>
											<input type="text" class="form-control" value="Terminated" readonly="readonly">
											<%} %>
											<!-- <textarea class="form-control" disabled="disabled"></textarea> -->
										</div>
										<br>
								<div class="col-lg-6">
									<label style="color: red">Rejection Remarks: </label> &nbsp;&nbsp;
									<textarea class="form-control" disabled="disabled"><%=manager_rejection_remarks%></textarea>
								</div>
								<%
									}
											}
											if (!hr_approval.equalsIgnoreCase("pending")) {
										%>
										<div class="col-lg-12">
											<label>HR Approval Status: </label>
											<%
												if (hr_approval.equalsIgnoreCase("approved")) {
											%>
											<font color="green"><b>Approved</b></font>
											<%
												} else if (hr_approval.equalsIgnoreCase("rejected")) {
											%>
											<font color="red"><b>Rejected</b></font>
											<%
												} else if (hr_approval.equalsIgnoreCase("pending")) {
											%>
											<font color="blue">Pending</font>
											<%
												}
											%>
										</div>
										<%
											if (hr_approval.equalsIgnoreCase("rejected")) {
										%>
										<div class="col-lg-12">
											<label style="color: red">Hr Rejection Remarks: </label>
											&nbsp;&nbsp;
											<textarea class="form-control" disabled="disabled"><%=rejection_remarks%></textarea>
										</div>
										<%
											}
											}
											if (!top_management_approval.equalsIgnoreCase("pending")) {
										%>
										<div class="col-lg-12">
											<label>Top Management Approval Status: </label>
											<%
												if (top_management_approval.equalsIgnoreCase("approved")
															|| top_management_approval.equalsIgnoreCase("hrapproved")) {
											%>
											<font color="green"><b>Approved</b></font>
											<%
												} else if (top_management_approval.equalsIgnoreCase("rejected")) {
											%>
											<font color="red"><b>Rejected</b></font>
											<%
												} else if (top_management_approval.equalsIgnoreCase("pending")) {
											%>
											<font color="blue">Pending</font>
											<%
												}
											%>
										</div>
										<%
											if (top_management_approval.equalsIgnoreCase("rejected")) {
										%>
										<div class="col-lg-12">
											<label style="color: red">Rejection Remarks: </label>
											&nbsp;&nbsp;
											<textarea class="form-control" disabled="disabled"><%=top_management_rejection_remarks%></textarea>
										</div>
										<%
											}
											}
										%>
								</form>
								</form>
								</form>
								</div>
								</div>
						</div>
						<br>
						
			
			</div>
			</div>
			</section>
		</div>
	</div>
	</div>
	<%@include file="footer.html"%>
    <!-- BEGIN VENDOR JS-->
    <!-- build:js app-assets/js/vendors.min.js-->
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
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>
</body>
</html>