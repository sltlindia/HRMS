<!-- Author Name :- Ripal Soni
For Getting data from user
Jsp for adding employee's scores and get their decision  -->

<%@page import="com.hrms.probation.bean.ProbationAssessmentTerminationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM2Bean"%>
<%@page import="com.hrms.probation.bean.AttributeM2Bean"%>
<%@page import="com.hrms.probation.bean.ProbationExtendBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentManagerBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM1Bean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.probation.bean.AttributeBean"%>
<%@page import="com.hrms.probation.dao.AllListProbationDAO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

		var employee_master_id1 = document
				.getElementById("employee_master_id1").value;
		window.location.replace("probationFormDisabled.jsp?employee_master_id="
				+ employee_master_id1);

	}

	function refresh1(id) {

		var month_id1 = document.getElementById("month_id").value;
		var employee_master_id1 = document
				.getElementById("employee_master_id1").value;
		window.location.replace("probationScoreCheck?month_id=" + month_id1
				+ "&employee_master_id=" + employee_master_id1);

	}
	function handleChange(id) {
		var a = document.getElementById(id).value;
		if (a<1 || a>5) {
			document.getElementById(id).value = 1;
			alert("Please! Enter grade between 1 to 5 ");
		}
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
	function checkInteger(id) {
		
		var a = document.getElementById(id).value;
		
		
		if(isNaN(a)){
			alert("Please! Enter grade between 1 to 5 ");
			document.getElementById(id).value = 1;
		}else if((a%1) != 0){
			var b = parseInt(a);
		 document.getElementById(id).value = b;
		}
		else{document.getElementById(id).value = a;
		
		}
	}
	
</script>

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns " onload="startTimer()">
	<div id="wrapper">
	<%List<Double> listOfTwiseMonthAverage = new ArrayList(); 
	List<String> listOfComment = new ArrayList();
	List<Double> listOfFinalPercentage = new ArrayList();
	AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
	int current_month  = Calendar.getInstance().get(Calendar.MONTH) + 1;
	int current_year = Calendar.getInstance().get(Calendar.YEAR);
	%>
	
		<div id="page-wrapper">
			<%
				if (request.getAttribute("monthExist") != null) {
			%>
			<div class="panel-body" id="panelbody">
				<div class="alert alert-dismissable alert-danger ">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${monthExist}
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("monthExistDirect") != null) {
			%>
			<div class="panel-body" id="panelbody">
				<div class="alert alert-dismissable alert-danger ">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${monthExist}
				</div>
			</div>
			<%
				}
			%>
			<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Probation Assessment
						<%=current_year%></h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Confirmation Assessment Form</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<b><font size="3px">Confirmation Assessment Form</font></b>
						</div> -->
						<%
							int manager_id = user.getManagerBean().getManager_id();
							/* int employee_master_id = 0; */
							if (request.getParameter("employee_master_id") != null) {
								employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
							}
							if (request.getParameter("month_id") != null && request.getParameter("employee_master_id") != null) {
								employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
								int month_id1 = 0;
								int yearId = 0;
								String mm_id = request.getParameter("month_id");

								String[] split = mm_id.split(",");
								month_id1 = Integer.parseInt(split[0]);
								yearId = Integer.parseInt(split[1]);

								LoginDAO loginDAO = new LoginDAO();
								EmployeeBean employeeBean = loginDAO.getInfoById(employee_master_id);
								String authority = employeeBean.getRoleBean().getRole_authority();
								List<String> listOfMonth = new ArrayList();
								
								
									List<ProbationAssessmentM2Bean> monthList = allListProbationDAO
											.getListOfProbationAssessmentM2ByEmpID(employee_master_id);
									for (ProbationAssessmentM2Bean probationAssessmentM2Bean : monthList) {
										listOfMonth.add(probationAssessmentM2Bean.getMonthBean().getMonth_id()+""+probationAssessmentM2Bean.getYearBean().getYear());
									}
						%>
						<form action="probationFormDisabled.jsp" method="post">

							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-hover">
										<tbody>
											<tr>
												<%
													int emp_id = 0;
												%>
												<td><label>List Of Employee Under Probationdddd :</label></td>
												<td colspan="4"><select class="form-control"
													name="employee_master_id" id="employee_master_id1"
													required="required" onchange="refresh(this.id)">
														<%
															AllListDAO allListDAO = new AllListDAO();
																List<EmployeeBean> getemployeeList = allListDAO.getProbatioEmployeeList(manager_id);
																for (EmployeeBean e : getemployeeList) {
														%>
														<%
															if (e.getEmployee_master_id() == employee_master_id) {
														%>
														<option value="<%=e.getEmployee_master_id()%>"
															selected="selected"><%=e.getFirstname() + " " + e.getLastname()%></option>
														<%
															} else {
														%>
														<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname() + " " + e.getLastname()%></option>
														<%
															}
																	emp_id = e.getEmployee_master_id();
																}
														%>
												</select></td>
												<td><label>Month : </label></td>
												<%
													int to_be_extended = 0;

														List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO
																.getListOfScoreByEmpId(employee_master_id);
														List<ProbationAssessmentM2Bean> listOfExtendedMonths = allListProbationDAO
																.getListOfScoreByEmpIdGroupbyMonthId(employee_master_id);
														for (ProbationAssessmentManagerBean pb : listOfExtended) {
															int probationmanager_id = pb.getProbation_assessment_manager_id();

															List<ProbationExtendBean> listForExtend = allListProbationDAO
																	.getProbationExtend(probationmanager_id);
															for (ProbationExtendBean p : listForExtend) {
																String extend_period = p.getExtended_period();
																to_be_extended = to_be_extended + Integer.parseInt(extend_period);
															}
														}
														String date = employeeBean.getJoining_date();
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
														YearBean yearBean = allListProbationDAO.yearCheck(yearId);
														int insert_year_id = yearBean.getYear_id();
														int printYearId = year_id;
														month_id = month_id + 1;
														
														if (day >= 15) {
															month_id = month_id + 1;
														}

														if (month_id > month_id1) {
															year_id = year_id + 1;
														}

														int size = month_id + 5 + to_be_extended;
												%>
												<td colspan="6"><select class="form-control"
													name="month_id" id="month_id" required="required"
													onchange="refresh1(this.id);">
														<option value="">--Select Month--</option>
														<%
															if (size <= 12) {
																	
																	for (int i = month_id; i <= size; i++) {
																		MonthBean m = allListProbationDAO.getInfoById(i);
																		String month = m.getMonth_name();
																		month_id = m.getMonth_id();

																		boolean checkMonth = false;

																		for (String mId : listOfMonth) {
																			if (mId.equalsIgnoreCase(month_id+""+printYearId)) {
																				checkMonth = true;
																			}
																		}

																		if (checkMonth == false) {
																			if (month_id == month_id1) {
																				String prop ="";
																				if(month_id > current_month || printYearId > current_year){
																					prop = "disabled = \"disabled\"";
																				}
														%>
														<option value="<%=month_id%>,<%=printYearId%>"
															selected="selected" <%=prop%>><%=month%>,<%=printYearId%>
														</option>
														<%
															} else {
																String prop ="";
																if(month_id > current_month || printYearId > current_year){
																	prop = "disabled = \"disabled\"";
																}
														%>
														<option value="<%=month_id%>,<%=printYearId%>" <%=prop%>><%=month%>,<%=printYearId%>
														</option>
														<%
															}
																		}
																	}
														%>

														<%
															} else {
																	for (int j = month_id; j <= 12; j++) {
																		MonthBean monthBean = allListProbationDAO.getInfoById(j);
																		month_id = monthBean.getMonth_id();

																		boolean checkMonth = false;

																		for (String mId : listOfMonth) {
																			if (mId.equalsIgnoreCase(month_id+""+printYearId)) {
																				checkMonth = true;
																			}
																		}
																		
																		if (checkMonth == false) {
																			if (month_id == month_id1) {
																				String prop ="";
																				if(month_id > current_month ){
																					prop = "disabled = \"disabled\"";
																				}
																				
																				if(printYearId > current_year){
																					prop = "disabled = \"disabled\"";
																				}
														%>
														<option value="<%=month_id%>,<%=printYearId%>"
															selected="selected" <%=prop%>><%=monthBean.getMonth_name()%>,<%=printYearId%>
														</option>
														<%
															} else {
																String prop ="";
																if(month_id > current_month ){
																	prop = "disabled = \"disabled\"";
																}
																
																if(printYearId > current_year){
																	prop = "disabled = \"disabled\"";
																}
														%>
														<option value="<%=month_id%>,<%=printYearId%>" <%=prop%>><%=monthBean.getMonth_name()%>,<%=printYearId%>
														</option>
														<%
															}

																		}
																	}

																	printYearId = printYearId + 1;
																	int size1 = size - 12;
																	for (int i = 1; i <= size1; i++) {
																		MonthBean m = allListProbationDAO.getInfoById(i);
																		String month = m.getMonth_name();
																		month_id = m.getMonth_id();

																		boolean checkMonth = false;

																		for (String mId : listOfMonth) {
																			if (mId.equalsIgnoreCase(month_id+""+printYearId)) {
																				checkMonth = true;
																			}
																		}
																		if (checkMonth == false) {

																			if (month_id == month_id1) {
																				String prop ="";
																				if(month_id > current_month ){
																					prop = "disabled = \"disabled\"";
																				}
																				
																				if(printYearId > current_year){
																					prop = "disabled = \"disabled\"";
																				}
														%>
														<option value="<%=month_id%>,<%=printYearId%>"
															selected="selected" <%=prop%>><%=month%>,<%=printYearId%></option>
														<%
															} else {
																String prop ="";
																if(month_id > current_month || printYearId > current_year){
																	prop = "disabled = \"disabled\"";
																}
														%>
														<option value="<%=month_id%>,<%=printYearId%>" <%=prop%>><%=month%>,<%=printYearId%></option>
														<%
															}
																		}
																	}
																}
														%>
												</select></td>
											</tr>
											<tr>
												<td><label>Date Of Joining:</label></td>
												<td><font color="blue"><%=sd%></font></td>
												<td><label>Designation :</label></td>
												<td colspan="3"><font color="blue"><%=employeeBean.getRoleBean().getRole_type()%></font></td>
												<td><label>Employee Code :</label></td>
												<td colspan="2"><font color="blue"><%=employeeBean.getEmployee_code()%></font></td>
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
						</form>
					</div>
					<%
						List<ProbationAssessmentM2Bean> listOfEmployeesM2 = allListProbationDAO
									.getProbationCheckMonthM2(employee_master_id, month_id1, insert_year_id);
							List<ProbationAssessmentM2Bean> listOfEmployeesContinue = allListProbationDAO
									.getProbationCheckContinueMonth(employee_master_id);
							List<ProbationAssessmentTerminationBean> listOfEmployeesTerminatedPending = allListProbationDAO
									.getAllListOfTerminatedEmployeesPending(employee_master_id);
							
							String monthCheck = null;
							if(request.getAttribute("monthCheck") != null){
								monthCheck = (String) request.getAttribute("monthCheck");
							}
							
					if (listOfEmployeesM2.size() != 0 || listOfEmployeesContinue.size() != 0 || listOfEmployeesTerminatedPending.size() != 0 || monthCheck != null) {
					%>
					<div class="panel-body" id="panelbody">
						<div class="alert alert-dismissable alert-danger ">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							<%
							
								if (listOfEmployeesContinue.size() != 0) {

											if (listOfEmployeesM2.size() != 0) {
							%>
							Score already exist for this month.
							<%
								} else {
							%>
							This employee is not further continued for probation
							<%
								}
							%>

							<%
								} else if(listOfEmployeesTerminatedPending.size() != 0) {
									if (listOfEmployeesM2.size() != 0) {
							%>
							Score already exist for this month.
							
							<%}else{ %>
							Termination/Confirmation Approval for this Employee is pending from manager side.
							<%} %>
							<%
								}else if(monthCheck != null){
							%>
							${monthCheck}
							<%}else{ %>
							Score already exist for this month.
							<%} %>

						</div>
					</div>
					<%
						} else {
					%>
					<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-12">
					             <h5 class="card-title" id="horz-layout-basic"><b><font size="2px">Please rate on scale of 1 to 5<br>5 = Excellent,4 = Exceeds Expectations,3 = Fully Achieves Expectations,2 = Met some but not all expectations,1 = Unsatisfactory.</font></b></h5>
									<!-- <h5 class="card-title" id="horz-layout-basic">Please rate on scale of 1 to 5</h5> -->
				               		<!-- <h4 class="card-title" id="horz-layout-basic">Probation Confirmation Assessment Form</h4> -->
				                </div>
				            </div>
				               <div class="card-body collapse in">
					               	 <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
					<!-- <div class="row">
						<div class="col-lg-12">
							<div class="panel panel-primary">
									<div class="panel-heading">
									<b><font size="3px">Please rate on scale of 1 to 5</font></b>
									<h5>5 = Excellent , 4 = Exceeds Expectations , 3 = Fully
										Achieves Expectations , 2 = Met some but not all expectations
										, 1 = Unsatisfactory.</h5>
								</div> -->
								
									<form action="probationM2Insert" enctype="multipart/form-data"
										method="post" name="">
										
										<input type="hidden" name="employee_master_id"
											value="<%=employee_master_id%>"> <input type="hidden"
											value="<%=insert_year_id%>" name="year_id">

										<div class="panel-body">
											<div class="table-responsive">

												<table class="table table-striped table-bordered">
													<thead>
														<tr>
															<td width="50px">Sr. No.</td>
															<td>Attributes</td>
															<%
																AllListDAO allListDAO2 = new AllListDAO();
																		MonthBean monthBean = new MonthBean();
																		MonthBean monthBean2 = allListDAO2.getListOfMonthById(month_id1);
																		String month_name = monthBean2.getMonth_name();
															%>
															<th><%=month_name%> Score</th>
														</tr>
													</thead>
													<tbody>
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
													%><tr>
														<td><input type="hidden" name="attribute_id"
															id="attribute_id"
															value="<%=a.getProbation_attribute_M2_id()%>"><%=i + 1%></td>
														<td><%=a.getProbation_attribute_M2_question()%></td>
														<td style="width: 100px;"><input type="hidden"
															name="month_id" value="<%=month_id1%>"><input
															type="text" class="form-control" name="month_score"
															id="month_score<%=i%>" value=""
															onchange="handleChange(this.id);checkInteger(this.id)" required> <input
															type="hidden" value="<%=insert_year_id%>"  name="year_id">
														</td>
													</tr>
													<%
														}
													%>
													<tr>
														<td colspan="2">Total</td>
														<td align="center"><span class="sum">0</span></td>
													</tr>
													<tr>
														<td colspan="2">Average Score Per Attribute</td>
														<td align="center"><span class="sumPerAttribute">0</span></td>
													</tr>
													<tr>
														<td colspan="2">Total Percentage</td>
														<td align="center"><span class="pecentagePerAttribute">0 %</span></td>
													</tr>
													</table>
													</div>
													<div class="table-responsive">

												<table class="table table-striped table-bordered">
													<tr>
													
													<%if(listOfExtendedMonths.size() != 0){ %>
														<td>
														<table class="table table-striped table-bordered" height="5px">
														<tr>
														<td>
														Month Name</td></tr>
														<tr><td>Total Score</td></tr>
														<tr>	<td>Average Score Per Attribute By Month</td>
														</tr>
														
														<%if(listOfExtendedMonths.size()>=1){ %>
														<tr>	<td height="50px">Average Of Assessment Period</td>
														</tr>
														
														
														<%if(listOfExtendedMonths.size() >=2 ) {%>
														<tr>	<td height="50px">Cumulative Average Of Assessment Period</td>
														</tr>
														<%} %>
														
														<%if(listOfExtendedMonths.size() >=1 ) {%>
														<tr>	<td height="100px">Comment if any</td>
														</tr>
														<%} %>
														
														<%if(listOfExtendedMonths.size() >=1 ) {%>
														<tr>	<td>Action As per Key</td>
														</tr>
														<%} %>
														<%} %>
														
														</table>
														</td>
														<td colspan="2">
														<table class="table table-striped table-bordered" height="5px">
														<tr>
													<%for(int i=0;i<listOfExtendedMonths.size();i++){
												
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												
												String monthName = null;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){
													/* sumOfScore = sumOfScore + p1.getAttribute_m2_score(); */
													monthName = p.getMonthBean().getMonth_name();
												} %>
													
														
														<td align="center" width="100px"><%=monthName%></td>
												<%} %>
												<td align="center" width="100px"><%=month_name%></td>
												</tr>
												
												<tr>
												<%for(int i=0;i<listOfExtendedMonths.size();i++){
												double sumOfScore = 0;
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												
												String monthName = null;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){

													sumOfScore = sumOfScore + p1.getAttribute_m2_score();
													monthName = p.getMonthBean().getMonth_name();
												} %>
													
														
														<td align="center" width="100px"><%=sumOfScore%></td>
														
														
												<%} %>
												<td align="center" width="100px"><span class="sum">0</span></td>
												</tr>
												<tr>
												<%for(int i=0;i<listOfExtendedMonths.size();i++){
												double sumOfScore = 0;
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												
												String monthName = null;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){

													sumOfScore = sumOfScore + p1.getAttribute_m2_score();
													monthName = p.getMonthBean().getMonth_name();
												} %>
													
														
														<td align="center" width="100px"><%=String.format("%.2f", sumOfScore/(listOfAttribute.size())) %></td>
														
												<%} %>
													<td align="center" width="100px"><span class="sumPerAttribute">0</span></td>
												</tr>
												<%if(listOfExtendedMonths.size() >= 1){ %>
													<tr>
											<%
											double score = 0;
											double sumOfTwoMonth = 0;
											String showView = null;
											
											for(int i=0;i<listOfExtendedMonths.size();i++){
												
												
												
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												double sumOfScore = 0;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){
													sumOfScore = sumOfScore + p1.getAttribute_m2_score();
													
												}
												
												sumOfTwoMonth = sumOfTwoMonth + sumOfScore;	
												
												
												if(showView == null){
													showView = sumOfScore+"";
												}else{
													showView = showView +" + "+sumOfScore;
												}
												
												
												if((i+1)%2 != 0){
													score = sumOfScore;
												}else{
													score = 0;
													listOfTwiseMonthAverage.add(sumOfTwoMonth/2);
													listOfComment.add(p.getComment_monthly());
													
											%>
											<td height="50px" colspan="2" align="center">(<%=showView%>) = <%=sumOfTwoMonth%>/2 = <%=sumOfTwoMonth/2%>
											<br>
											 <b>(<%=String.format("%.2f",((sumOfTwoMonth/2)*100)/(listOfAttribute.size() * 5))%>%) <%listOfFinalPercentage.add(((sumOfTwoMonth/2)*100)/(listOfAttribute.size() * 5));%></b> <%sumOfTwoMonth = 0;showView =null;%>
											</td>
											<%} %>
											<%} %>
											
											<%if(score != 0){ %>
											
											<td height="50px" colspan="2" align="center">
											<input type="hidden" id="previousMonthScore" value="<%=score%>"> 
											<span id="finalOutput"></span> 
											<span id="finalOutputDisplay"></span>
											<span id="sumOfTwoMonth"></span>
											<br>
											<span style="font-weight: bold;" id="sumOfTwoMonthPer"></span>
											</td>
									<%} %>
											
											</tr>
											<%} %>
											<tr>
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
													<td height="50px" colspan="2" align="center"><label><%=twiseMonthAverageDisplay%>=<%=sumOfAverage%>/<%=i+1%> = <%=String.format("%.2f",sumOfAverage/(i+1))%> (<%=String.format("%.2f",((sumOfAverage/(i+1)*100)/(listOfAttribute.size() * 5)))%>%)</label></td>
													<%} else{%>
													<td height="50px" colspan="2" align="center"><label>NA</label></td>
													<%} %>
													<%} %>
													
													<%if((listOfExtendedMonths.size() + 1)%2 == 0 && listOfExtendedMonths.size() >=2 ) {%>
													
													<td height="50px" colspan=2 align="center">
															<label><span id="test"></span></label>
															<label><span id="test1"></span></label>
													</td>
													<%} %>
													</tr>
													
													<tr>
													<%
													for(int i = 0;i<listOfComment.size();i++){
														String comment = listOfComment.get(i);
													%>
													<td colspan="2" height ="100px" style="white-space: pre-wrap;"><%=comment %></td>
													<%} %>
													
													<%if((listOfExtendedMonths.size() + 1)%2 == 0 && listOfExtendedMonths.size() >=1 ) {%>
													
													<td colspan="2"><textarea name="comments_month_wise" class="form-control"rows="3" cols="3">-</textarea></td>
													<%} %>
													</tr>
													
													
													
													
													<tr>
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
													
													<%if((listOfExtendedMonths.size() + 1)%2 == 0 && listOfExtendedMonths.size() >=1 ) {%>
													
													<td colspan="2" class="descsion"></td>
													<%} %>
													</tr>
													
													
													
													
													
											<%-- <tr>
											
									
											
											
											
											
											
											<td colspan="2" align="center">(<%=showView%>) = <%=sumOfTwoMonth%>/2 = <%=sumOfTwoMonth/2%> <%sumOfTwoMonth = 0;showView =null;%>
											</td>
											
											
											
											
											</tr> --%>
											</table>
													</td>
													<%} %>
												</tr>
													
											
													
													
													<!-- <tr id="summation" style="visibility: hidden;">
												<td>&nbsp;</td>
												<td align="right">Sum :</td>
												<td align="center"><span id="sum">0</span></td>
											</tr> -->

													<tr class="hideFile">
														<td colspan="2">Continue for next month(Yes/No)</td>
														<td>
															<div class="form-group">
																<label class="radio-inline"> <input type="radio"
																	name="ContinueMonth" id="continueYes"
																	value="continueYes" onclick="check1(this.id)" checked readonly="readonly">Yes
																</label><br> <label class="radio-inline"> <input
																	type="radio" name="ContinueMonth" id="continueNo"
																	value="continueNo" onclick="check1(this.id)" readonly="readonly">No
																</label>
															</div>
														</td>
													</tr>
													<tr class="hideFile">
														<td colspan="2">Issue warning letter(Yes/No)</td>
														<td>
															<div class="form-group">
																<label class="radio-inline"> <input type="radio"
																	name="warningLetter" id="warningYes" value="warningYes"
																	 readonly="readonly">Yes
																</label><br> <label class="radio-inline"> <input
																	type="radio" name="warningLetter" id="warningNo"
																	value="warningNo" readonly="readonly" checked>No
																</label>
															</div>
														</td>
													</tr>
													<tr class="hideFile">
														<td colspan="2">Issue termination letter(Yes/No)</td>
														<td>
															<div class="form-group">
																<label class="radio-inline"> <input type="radio"
																	name="terminationLetter" id="terminationYes"
																	value="terminationYes" onclick="check1(this.id)" readonly="readonly">Yes
																</label><br> <label class="radio-inline"> <input
																	type="radio" name="terminationLetter"
																	id="terminationNo" onclick="check1(this.id)"
																	value="terminationNo" checked readonly="readonly">No
																</label>
															</div>
														</td>
													</tr>

													</tbody>
											
													<%-- <%
														}
													%> --%>

												</table>
										<div class="col-lg-12" id="divshow">
										<label style="color: red">
											<h5>Termination Remarks: (Please mention the reason for decision of Termination )</h5>
										</label>
										<textarea rows="3" cols="90" class="form-control"
											name="termination_remarks" placeholder="Enter Your Remarks:"></textarea>
									</div>
											</div>
										</div>
										<center>
											<input type="hidden" name="redirect" id="redirect"> <input
												type="submit" value="SUBMIT" class="btn btn-primary">
										</center>
									</form>
									<br>
							</div>
						</div>
					</div>
					</div>
					</div>
					
					<%} %>
					<%
						} else {
							LoginDAO loginDAO = new LoginDAO();
							EmployeeBean employeeBean = loginDAO.getInfoById(employee_master_id);
							String authority = "";

							if (employeeBean != null) {
								authority = employeeBean.getRoleBean().getRole_authority();
							}
							List<String> listOfMonth = new ArrayList();
							
								List<ProbationAssessmentM2Bean> monthList = allListProbationDAO
										.getListOfProbationAssessmentM2ByEmpID(employee_master_id);
								for (ProbationAssessmentM2Bean probationAssessmentM2Bean : monthList) {
									listOfMonth.add(probationAssessmentM2Bean.getMonthBean().getMonth_id()+""+probationAssessmentM2Bean.getYearBean().getYear());
								}
					%>
					<form action="probationFormDisabled.jsp" method="post">
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-hover">
									<tbody>
										<tr>
											<%
												int emp_id = 0;
											%>
											<td><label>List Of Employee Under Probation :</label></td>
											<td colspan="4"><select class="form-control"
												name="employee_master_id" id="employee_master_id1"
												required="required" onchange="refresh(this.id)">
													<option value="">--Select Employee--</option>
													<%
														AllListDAO allListDAO = new AllListDAO();
															List<EmployeeBean> getemployeeList = allListDAO.getProbatioEmployeeList(manager_id);
															for (EmployeeBean e : getemployeeList) {
													%>
													<%
														if (e.getEmployee_master_id() == employee_master_id) {
													%>
													<option value="<%=e.getEmployee_master_id()%>"
														selected="selected"><%=e.getFirstname() + " " + e.getLastname()%></option>
													<%
														} else {
													%>
													<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname() + " " + e.getLastname()%></option>
													<%
														}
																emp_id = e.getEmployee_master_id();
															}
													%>
											</select></td>

											<%
												if (employee_master_id != 0) {
											%>
											<td><label>Month : </label></td>
											<%
												int to_be_extended = 0;
														List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO
																.getListOfScoreByEmpId(employee_master_id);
														for (ProbationAssessmentManagerBean pb : listOfExtended) {
															int probationmanager_id = pb.getProbation_assessment_manager_id();

															List<ProbationExtendBean> listForExtend = allListProbationDAO
																	.getProbationExtend(probationmanager_id);
															for (ProbationExtendBean p : listForExtend) {
																String extend_period = p.getExtended_period();
																to_be_extended = to_be_extended + Integer.parseInt(extend_period);

															}
														}
														String date = employeeBean.getJoining_date();
														/* DateFormat inputDF  = new SimpleDateFormat("mm/dd/yy"); */
														Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);

														Calendar cal = Calendar.getInstance();
														cal.setTime(date1);
														int month_id = cal.get(Calendar.MONTH);
														month_id = month_id + 1;
														int year_id = cal.get(Calendar.YEAR);
														int printYearId = year_id;
														int day = cal.get(Calendar.DAY_OF_MONTH);

														if (day >= 15) {
															month_id = month_id + 1;
														}

														int size = month_id + 5 + to_be_extended;
											%>
											<td colspan="6"><select class="form-control"
												name="month_id" id="month_id" required="required"
												onchange="refresh1(this.id)">
													<option value="" selected="selected">--Select
														Month--</option>
													<%
														if (size <= 12) {

																	for (int i = month_id; i <= size; i++) {
																		MonthBean m = allListProbationDAO.getInfoById(i);
																		String month = m.getMonth_name();

																		boolean checkMonth = false;

																		for (String mId : listOfMonth) {
																			if (mId.equalsIgnoreCase(m.getMonth_id()+""+printYearId)) {
																				checkMonth = true;
																			}
																		}
																		if (checkMonth == false) {
																			String prop ="";
																			
																			
																			if(printYearId > current_year){
																				prop = "disabled = \"disabled\"";
																			}
																			if(m.getMonth_id() > current_month){
																				prop = "disabled = \"disabled\"";
																			}
													%>
													
													<option value="<%=m.getMonth_id()%>,<%=printYearId%>" <%=prop%>><%=month%>,<%=printYearId%>
													</option>
													<%
														}
																	}
													%>

													<%
														} else {

																	for (int j = month_id; j <= 12; j++) {
																		MonthBean monthBean = allListProbationDAO.getInfoById(j);
																		boolean checkMonth = false;

																		for (String mId : listOfMonth) {
																			if (mId.equalsIgnoreCase(monthBean.getMonth_id()+""+printYearId)) {
																				checkMonth = true;
																			}
																		}
																		if (checkMonth == false) {
																			String prop ="";
																			
																		
																			
																			if(printYearId > current_year){
																				prop = "disabled = \"disabled\"";
																			}
																			
																			
																			if(monthBean.getMonth_id() > current_month){
																				prop = "disabled = \"disabled\"";
																			}
													%>
													<option
														value="<%=monthBean.getMonth_id()%>,<%=printYearId%>" <%=prop%>><%=monthBean.getMonth_name()%>,<%=printYearId%>
													</option>
													<%
														}
																	}
																	printYearId = printYearId + 1;
																	int size1 = size - 12;
																	for (int i = 1; i <= size1; i++) {
																		MonthBean m = allListProbationDAO.getInfoById(i);
																		String month = m.getMonth_name();

																		boolean checkMonth = false;

																		for (String mId : listOfMonth) {
																			if (mId.equalsIgnoreCase(m.getMonth_id()+""+printYearId)) {
																				checkMonth = true;
																			}
																		}
													
																		if (checkMonth == false) {
																			String prop ="";
																			
																			
																			if(printYearId > current_year){
																				prop = "disabled = \"disabled\"";
																			}
																			
																			if(m.getMonth_id() > current_month){
																				prop = "disabled = \"disabled\"";
																			}
													%>
													
													<option value="<%=m.getMonth_id()%>,<%=printYearId%>" <%=prop%>><%=month%>,<%=printYearId%></option>
													<%
														}
																	}
													%>

													<%
														}
													%>
											</select></td>
											<%
												}
											%>
										</tr>
										<tr></tr>
									</tbody>
								</table>
							</div>
						</div>
					</form>
					<%
						}
					%>
				</div>
			</div>
			</div>
			</div>
			</div>
			</div>
			</section>
		</div>
	</div>
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

			//iterate through each textboxes and add keyup
			//handler to trigger sum event
			
			$(".hideFile").hide();
			
			
			$('[name="month_score"]').each(function() {

				$(this).keyup(function() {
					calculateSum();
				});
			});

		});

		function calculateSum() {
		
			<%
			if(request.getParameter("employee_master_id") != null){
			employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean = loginDAO.getInfoById(employee_master_id);
			String authority = employeeBean.getRoleBean().getRole_authority();
			List<AttributeM2Bean> listOfAttribute = null;
			if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3")
																			|| authority.equals("T1") || authority.equals("T2") || authority.equals("T3")
																			|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3")
																			|| authority.equals("A4")) {

																		 listOfAttribute = allListProbationDAO.getListOfAttributeM2Direct();
}else {
																	
														 listOfAttribute = allListProbationDAO.getListOfAttributeM2();

}%>
			var sum = 0;
			var previousMonthScore = parseInt($('#previousMonthScore').val());
			var sumOfTwoMonth = previousMonthScore;
			var finalViewOfCumulative = null;
			var finalSum = 0;
			//iterate through each textboxes and add the values
			$('[name="month_score"]').each(function() {

				//add only if the value is number
				if (!isNaN(this.value) && this.value.length != 0) {
					sum += parseFloat(this.value);
					sumOfTwoMonth += parseFloat(this.value);
				}

			});
			
			var sumOfWorkHour = parseInt($('#sumOfworkHours').val());
			var totalWorkHour = sumOfWorkHour + sum;
			var sumPerAttribute = (sum/<%=listOfAttribute.size()%>).toFixed(2)
			var pecentagePerAttribute = ((sum*100)/<%=(listOfAttribute.size())*5%>).toFixed(2)
			var finalOutput = "("+previousMonthScore.toFixed(0) +' + '+sum+') =';
			var finalOutputDisplay = sumOfTwoMonth +' / '+2+' =';
		/* 	var finalOutputDisplay = $('#previousMonthScore').val() +'+'+sum +'/'+ 2;  */


		<%for(double d : listOfTwiseMonthAverage){%>
			if(finalViewOfCumulative == null){
				finalViewOfCumulative = <%=d%>+'';
			}else{
				finalViewOfCumulative = finalViewOfCumulative+'+'+<%=d%>;
			}
			
			finalSum += <%=d%>;
			
		<%}%>
		
		finalSum += sumOfTwoMonth.toFixed(2)/2;
		var twoMonthPer = ((((sumOfTwoMonth.toFixed(2)/2)*100)/<%=(listOfAttribute.size())*5%>).toFixed(2));
		var descsion = null;
		
		
		<%
		if(request.getParameter("employee_master_id") != null){
		List<ProbationAssessmentM2Bean> listOfExtendedMonths = allListProbationDAO
		.getListOfScoreByEmpIdGroupbyMonthId(employee_master_id);
		if(listOfExtendedMonths.size() == 1){
		%>
		if(twoMonthPer < 35){
			descsion = 'Terminate';
			document.getElementById("terminationYes").checked = true;
			document.getElementById("continueNo").checked = true;
			document.getElementById("warningNo").checked = true;
			$("#divshow").show();
			
		}else if(twoMonthPer>=35 && twoMonthPer < 40){
			descsion = 'Warn';
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			document.getElementById("warningYes").checked = true;
			$("#divshow").hide();
			
		}else if(twoMonthPer>=40){
			descsion = 'Retain';
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			document.getElementById("warningNo").checked = true;
			$("#divshow").hide();
		}
		<%}else if(listOfExtendedMonths.size() == 3){ %>
		
		if(twoMonthPer<40){
			descsion = 'Terminate';
			document.getElementById("terminationYes").checked = true;
			document.getElementById("continueNo").checked = true;
			document.getElementById("warningNo").checked = true;
			$("#divshow").show();
			
		}else if(twoMonthPer>=40 && twoMonthPer < 45){
			descsion = 'Warn';
			document.getElementById("warningYes").checked = true;
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			$("#divshow").hide();
			
		}else if(twoMonthPer>=45){
			descsion = 'Retain';
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			document.getElementById("warningNo").checked = true;
			$("#divshow").hide();
		}
		
		
		<%}else if(listOfExtendedMonths.size() == 5){ %>
		
		if(twoMonthPer<50){
			descsion = 'Terminate';
			document.getElementById("terminationYes").checked = true;
			document.getElementById("continueNo").checked = true;
			document.getElementById("warningNo").checked = true;
			$("#divshow").show();
			
		}else if(twoMonthPer>=50 && twoMonthPer <55){
			descsion = 'Warn';
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			document.getElementById("warningYes").checked = true;
			$("#divshow").hide();
		}else if(twoMonthPer>=55){
			descsion = 'Retain';
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			document.getElementById("warningNo").checked = true;
			
		}
		
		<%}else{%>
		
		
		if(twoMonthPer<50){
			descsion = 'Terminate';
			document.getElementById("terminationYes").checked = true;
			document.getElementById("continueNo").checked = true;
			document.getElementById("warningNo").checked = true;
			$("#divshow").show();
			
		}else if(twoMonthPer>=50 && twoMonthPer <55){
			descsion = 'Warn';
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			document.getElementById("warningYes").checked = true;
			$("#divshow").hide();
		}else if(twoMonthPer>=55){
			descsion = 'Retain';
			document.getElementById("terminationNo").checked = true;
			document.getElementById("continueYes").checked = true;
			document.getElementById("warningNo").checked = true;
			
		}
		
		
		<%}}%>
		
			
			$(".sum").html(sum.toFixed(2));
			$(".sumPerAttribute").html(sumPerAttribute);
			$(".pecentagePerAttribute").html(pecentagePerAttribute+'%');
			$("#finalOutputDisplay").html(finalOutputDisplay);
			$("#sumOfTwoMonth").html(sumOfTwoMonth.toFixed(2)/2);
			$("#sumOfTwoMonthPer").html('('+twoMonthPer+'%)');
			$("#finalOutput").html(finalOutput);
			
			var fSum = finalSum/(<%=listOfTwiseMonthAverage.size() + 1 %>);
			
			$("#test").html(finalViewOfCumulative+'+'+sumOfTwoMonth.toFixed(2)/2+'='+finalSum+'/'+<%=listOfTwiseMonthAverage.size() + 1%> +'='+fSum.toFixed(2));
			$("#test1").html('('+((fSum*100)/<%=((listOfAttribute.size())*5)%>).toFixed(2)+'%)');
			$(".descsion").html(descsion);
			
			
			/* $("#finalOutputDisplay").html(finalOutputDisplay); */
			
		}
			<%}%>
			
	</script>
	
	<script>
	
	$(document).ready(function() {
		$("#divshow").hide();
	});
	
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