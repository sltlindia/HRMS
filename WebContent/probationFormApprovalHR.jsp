<%@page import="com.hrms.probation.bean.ProbationAssessmentTerminationBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM2Bean"%>
<%@page import="com.hrms.probation.bean.ProbationExtendBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentManagerBean"%>
<%@page import="java.util.Calendar"%>
<!-- Author Name :- Ripal Soni
For Getting data from user
Jsp for displaying data at hr side  -->

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
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns " onload="startTimer()">
	<%
		int manager_id = user.getManagerBean().getManager_id();
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Probation Assessment</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
	<!-- <div id="wrapper">
		<div id="page-wrapper">
		<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">Probation Assessment</h2>
				</div>
				/.col-lg-12
			</div> -->
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Probation Form(Employees)</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b><font size="3px">Probation Form(Employees)</font></b>
						</div>
						/.panel-heading -->
						<div class="panel-body">
						
						
						<div class="panel-group" id="accordion"  style=" border: 2px solid #bbb7b7b0; border-radius: 5px; ">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									&nbsp;Approval pending list</h4>
								</div>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Employee Name</th>
									<th>Reporting Manager Name</th>
									<th>Total Extended Period</th>
									<th>Action</th>
								</tr>
								<%
									AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
									List<ProbationAssessmentManagerBean> listOfEmployee = allListProbationDAO.getListOfAllReviewsPending();
									for (ProbationAssessmentManagerBean pa : listOfEmployee) {
										String employee_name = pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname();
										int emp_id = pa.getEmployeeBean().getEmployee_master_id();
										int probationManagerId = pa.getProbation_assessment_manager_id();
										String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
										String to_be_extended = pa.getRepoting_manager_approval();
										String status = null;
										List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationManagerId);
										for(ProbationExtendBean p : listForExtend){
											status = p.getStatus();
										}
										long maxValue = 0;
										if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1")
												|| authority.equals("T2") || authority.equals("T3") || authority.equals("A1")
												|| authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
											maxValue = allListProbationDAO.getCount(emp_id);
										} else {
											maxValue = allListProbationDAO.getCountForM2(emp_id);
										}
										LoginDAO loginDAO2 = new LoginDAO();
										int id = pa.getReviewing_manager_id();
										EmployeeBean employeeBean2 = loginDAO2.getEmailIdEmployee(id);
										
										%>
								
								<tr>
									<td><%=pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname()%></td>
									<td><%=employeeBean2.getFirstname() +" "+ employeeBean2.getLastname()%></td>
									<td><%=pa.getPeriod_to_be_extended() %></td>
									<td>
									
											<a
										href="probationListByIdIndirectApproval.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-compose" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											</td>
								</tr>
								<%
										
									}
										
								%>
							</table>
							</div>
							</div>
							<br>
							<div class="panel-group" id="accordion"  style=" border: 2px solid #bbb7b7b0; border-radius: 5px; ">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									&nbsp;List of Confirmed employees</h4>
								</div>
								<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Employee Name</th>
												<th>Reporting Manager Name</th>
												<th>Direct/Indirect
												<th>Joining Date</th>
												<th>Filled Month</th>
												<th>Extended Probation(Month)</th>
												<th>Manager's Approval</th>
												<th>HR's Approval</th>
												<th>Top Management's Approval</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<%
											List<ProbationAssessmentManagerBean> listOfEmployeeesCompleted = allListProbationDAO.getListOfAllReviewsCompleted();
												for (ProbationAssessmentManagerBean pa : listOfEmployeeesCompleted) {
													String employee_name = pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname();
													int emp_id = pa.getEmployeeBean().getEmployee_master_id();
													String date = pa.getEmployeeBean().getJoining_date();
													String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
													String to_be_extended = pa.getTo_be_extended();
													int extended = 6;
													String print_status = null;
													String print_status_hr = null;
													String print_status_top = null;
													int probationmanager_id = pa.getProbation_assessment_manager_id();
													String status = null;
													List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
													for (ProbationExtendBean p : listForExtend) {
														status = p.getStatus();

													}

													List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO
															.getListOfScoreByEmpId(emp_id);
													for (ProbationAssessmentManagerBean li : listOfExtended1) {
														int probationmanager_idd = li.getProbation_assessment_manager_id();

														List<ProbationExtendBean> listForExtend1 = allListProbationDAO
																.getProbationExtend(probationmanager_idd);
														for (ProbationExtendBean p1 : listForExtend) {
															String extend_period = p1.getExtended_period();
															extended = extended + Integer.parseInt(extend_period);

														}
													}
													if(pa.getManager_approval().equalsIgnoreCase("pending")){
														print_status = "Pending";
													}
													else if(pa.getManager_approval().equalsIgnoreCase("approved")){
														print_status = "Approved";
													}
													else{
														print_status = "Rejected";
													}
													if(pa.getHr_approval().equalsIgnoreCase("pending")){
														print_status_hr = "Pending";
													}
													else if(pa.getManager_approval().equalsIgnoreCase("approved")){
														print_status_hr = "Approved";
													}
													else{
														print_status_hr = "Rejected";
													}
													if(pa.getTop_management_approval().equalsIgnoreCase("pending")){
														print_status_top = "Pending";
													}
													else if(pa.getTop_management_approval().equalsIgnoreCase("approved")){
														print_status_top = "Approved";
													}
													else if(pa.getTop_management_approval().equalsIgnoreCase("hrapproved")){
														print_status_top = "HR-Approved";
													}
														
													else{
														print_status_top = "Rejected";
													}
													long maxValue = 0;
													String sd = null;
													try {

														SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
														Date result = formater.parse(date);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														sd = AppDateFormat.format(result);

													} catch (ParseException e1) {
														e1.printStackTrace();
													}
													boolean flag = false;
													if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1")
															|| authority.equals("T2") || authority.equals("T3") || authority.equals("A1")
															|| authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
														maxValue = allListProbationDAO.getCount(emp_id);
													} else {
														maxValue = allListProbationDAO.getCountForM2(emp_id);
														flag = true;
													}
													int reviewing_manager_id = pa.getReviewing_manager_id();
													LoginDAO loginDAO2 = new LoginDAO();
													int id = pa.getReviewing_manager_id();
													EmployeeBean employeeBean2 = loginDAO2.getEmailIdEmployee(reviewing_manager_id);
											%>

											<tr>
												<td><%=pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname()%></td>
												<td><%=employeeBean2.getFirstname() +" "+ employeeBean2.getLastname()%></td>
												<%if(flag == false){ %>
									<td>Direct Employee</td>
									<%}else{ %>
									<td>Indirect Employee</td>
									<%} %>
									<td><%=sd%></td>
									<td><%=maxValue%></td>
									<td><%=pa.getPeriod_to_be_extended()%></td>	
												<td><center><%=print_status%></center></td>
												<td><center><%=print_status_hr%></center></td>
												<td><center><%=print_status_top%></center></td>
												<td><center>
												<%if(maxValue == extended){%>
											 <a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-eye" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											<%}else{
												%>
												Extended
											<%} %>
											</center>
											</td>
											</tr>
										
										<%
											}
										%>
</tbody>
									</table>
									</div>
							</div>
							</div>
							<br>
							<div class="panel-group" id="accordion"  style=" border: 2px solid #bbb7b7b0; border-radius: 5px; ">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									&nbsp;List of Extended employees</h4>
								</div>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Employee Name</th>
									<th>Reporting Manager Name</th>
									<th>Total Extended Period</th>
									<th>Action</th>
								</tr>
								<%
									List<ProbationAssessmentM2Bean> listOfEmployeess = allListProbationDAO.getListOfWarningEmployeeAll();
									for (ProbationAssessmentM2Bean pa : listOfEmployeess) {
										String employee_name = pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname();
										int emp_id = pa.getEmployeeBean().getEmployee_master_id();
										String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
										
										
															LoginDAO loginDAO2 = new LoginDAO();
										ProbationAssessmentManagerBean passessmentManagerBean = allListProbationDAO.getListOfProbationByEmpId(emp_id);					
															int id = passessmentManagerBean.getReviewing_manager_id();
															EmployeeBean employeeBean2 = loginDAO2.getEmailIdEmployee(id);
								%>

								<tr>
									<td><%=pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname()%></td>
									<td><%=employeeBean2.getFirstname() +" "+ employeeBean2.getLastname()%></td>
									<td><%=passessmentManagerBean.getPeriod_to_be_extended() %></td>
									<td>
											<a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-eye" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											</td>
								</tr>
								<%
									}
								%>
							</table>
							</div>
							</div>
							<br>
						<div class="panel-group" id="accordion" style=" border: 2px solid #bbb7b7b0; border-radius: 5px; ">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									&nbsp;List of Terminated employees</h4>
								</div>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Employee Name</th>
									<th>Manager's Approval</th>
									<th>HR's Approval</th>
									<th>Top Management's Approval</th>
									<th colspan="2">Action</th>
								</tr>
								<%
									List<ProbationAssessmentTerminationBean> listOfEmployeees = allListProbationDAO.getListOfAllTerminatedEmployees();
									for (ProbationAssessmentTerminationBean pa : listOfEmployeees) {
										String employee_name = pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname();
										int emp_id = pa.getEmployeeBean().getEmployee_master_id();
										String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
										
										ProbationAssessmentManagerBean passessmentManagerBean = allListProbationDAO.getListOfProbationByEmpId(emp_id);
										String to_be_extended = passessmentManagerBean.getTo_be_extended();
										int extended = 6;
										String print_status = null;
										String print_status_hr = null;
										String print_status_top = null;
										int probationmanager_id = passessmentManagerBean.getProbation_assessment_manager_id();
										String status = null;
										List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
										for(ProbationExtendBean p : listForExtend){
											status  = p.getStatus();
											
										}
										List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO.getListOfScoreByEmpId(emp_id);
										for(ProbationAssessmentManagerBean li : listOfExtended1){
											int probationmanager_idd = li.getProbation_assessment_manager_id();
											
											List<ProbationExtendBean> listForExtend1 = allListProbationDAO.getProbationExtend(probationmanager_idd);
											for(ProbationExtendBean p1 : listForExtend){
												String extend_period = p1.getExtended_period();
												extended = extended + Integer.parseInt(extend_period);
												
											}
										}
										
										long maxValue = 0;
										if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1")
												|| authority.equals("T2") || authority.equals("T3") || authority.equals("A1")
												|| authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
											maxValue = allListProbationDAO.getCount(emp_id);
										} else {
											maxValue = allListProbationDAO.getCountForM2(emp_id);
										}
										int reviewing_manager_id = pa.getReviewing_manager_id();
										if(passessmentManagerBean.getManager_approval().equalsIgnoreCase("pending")){
											print_status = "Pending";
										}
										else if(passessmentManagerBean.getManager_approval().equalsIgnoreCase("approved")){
											print_status = "Approved";
										}
										else{
											print_status = "Rejected";
										}
										if(passessmentManagerBean.getHr_approval().equalsIgnoreCase("pending")){
											print_status_hr = "Pending";
										}
										else if(passessmentManagerBean.getHr_approval().equalsIgnoreCase("approved")){
											print_status_hr = "Approved";
										}
										else{
											print_status_hr = "Rejected";
										}
										if(passessmentManagerBean.getTop_management_approval().equalsIgnoreCase("pending")){
											print_status_top = "Pending";
										}
										else if(passessmentManagerBean.getTop_management_approval().equalsIgnoreCase("approved")){
											print_status_top = "Approved";
										}
										else if(passessmentManagerBean.getTop_management_approval().equalsIgnoreCase("hrapproved")){
											print_status_top = "HR-Approved";
										}
											
										else{
											print_status_top = "Rejected";
										}
								%>

								<tr>
									<td><%=pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname()%></td>
									<td><center><%=print_status%></center></td>
												<td><center><%=print_status_hr%></center></td>
												<td><center><%=print_status_top%></center></td>
									
										<%long count = allListProbationDAO.getCountOfTopManagement(passessmentManagerBean.getProbation_assessment_manager_id());
										if(count == 0){
										 if(maxValue == extended){ %>
											 <td><a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-eye" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											</td>
											<%} else{ %>
											<td>Extended</td>
											<%} %>
									<%}else{ %>
									 <%if(maxValue == extended){ %>
									 <td>
											 <a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-eye" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											</td>
											<%}else{ %>
											<td>Extended</td>
											<%} %>
									<%} %>
								</tr>
								
								<div class="modal fade" id="myModalReason<%=passessmentManagerBean.getProbation_assessment_manager_id()%>" tabindex="-1"
														role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">&times;</button>
																	<h3 class="modal-title" id="myModalLabel">Select
																		Person</h3>
																</div>
																<form action="topManagementApproval">
																<input type="hidden" name="probation_assessment_manager_id" value="<%=passessmentManagerBean.getProbation_assessment_manager_id()%>">
																	<div class="modal-body">
																	<%List<EmployeeBean> listOfTopManagement =  allListProbationDAO.getlistOfTopManagement();%>
																		<select class="form-control"
														name="employee_master_id" id="employee_master_id" required ="required">
														<option value="">---Select Employee---</option>
		  				 															<%for(EmployeeBean e : listOfTopManagement){%>
		  				 															<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(<%=e.getRoleBean().getRole_type()%>)</option>
		  				 															<%} %>
                          													 	
																			</select>
																	</div>

																	<div class="modal-footer">
																	<input type="submit" class="btn btn-primary"
																			value="Submit">
																		<button type="button" class="btn btn-danger"
																			data-dismiss="modal">Close</button>
																		
																	</div>
																</form>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
								<%
									}
								%>
								
							</table>
							</div>
							</div>
						</div>
					</div>
					<br>
					<font size="3px;" color="#337ab7"><b>Legends :&nbsp;</b></font><b><i class="icon-eye" style="color:#337ab7; size: 100px;"></i></b> <b> : View Employee's Review </b> &nbsp;&nbsp;&nbsp;<i class="icon-ios-plus" style="color:#337ab7;"></i><b> : Add Review</b> &nbsp;&nbsp;&nbsp;<i class=" icon-compose" style="color:#337ab7;"></i><b> : Update Review</b> &nbsp;&nbsp;&nbsp;
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
			$('[name="month_score"]').each(function() {

				$(this).keyup(function() {
					calculateSum();
				});
			});

		});

		function calculateSum() {

			var sum = 0;
			//iterate through each textboxes and add the values
			$('[name="month_score"]').each(function() {

				//add only if the value is number
				if (!isNaN(this.value) && this.value.length != 0) {
					sum += parseFloat(this.value);
				}

			});
			var sumOfWorkHour = parseInt($('#sumOfworkHours').val());
			var totalWorkHour = sumOfWorkHour + sum;
			$("#sum").html(sum.toFixed(2));
		}
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