<!-- Author Name :- Ripal Soni
For Getting data from user
Jsp for displaying data at manager side  -->
<%@page
	import="com.hrms.probation.bean.ProbationAssessmentTerminationBean"%>
<%@page import="com.hrms.probation.bean.ProbationExtendBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentManagerBean"%>
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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
</head>
<%-- <%HttpSession session1 = request.getSession(); 
EmployeeBean probation = (EmployeeBean)session1.getAttribute("probationSession");
if(probation != null){ 
%> --%>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns " onload="startTimer()">
	<%
		int manager_id = user.getManagerBean().getManager_id();
		int employeeId = user.getEmployee_master_id();
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Probation Assessment</h1>
			        </div>
			    </div>
	<!-- <div id="wrapper">
		<div id="page-wrapper">
<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">Probation Assessment</h2>
				</div>
				/.col-lg-12
			</div> -->
			<div class="row">
				<div class="col-lg-12">
					<%
						AllListProbationDAO allListProbationDAO1 = new AllListProbationDAO();
						List<EmployeeBean> listForUnderCheckProbation = allListProbationDAO1
								.getListOfUnderEmployeepProbation(manager_id);
						if (listForUnderCheckProbation.size() != 0) {
					%>
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
					<!-- <div class="panel panel-primary">
						<div class="panel-heading">
							<b><font size="3px">Probation Form(Employees)</font></b>
						</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
								<tr>
									<th>Employee Name</th>
									<th>Direct/Indirect
									<th>Joining Date</th>
									<th>Filled Month</th>
									<th>Extended Probation(Month)</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
								</thead>
								<%
									for (EmployeeBean p : listForUnderCheckProbation) {
											int employee_master_id_emp = p.getEmployee_master_id();
											int to_be_extended = 0;
											int extended_month = 0;
											LoginDAO loginDAO = new LoginDAO();
											String date = p.getJoining_date();
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
											EmployeeBean employeeBean = loginDAO.getInfoById(employee_master_id_emp);
											String authority = employeeBean.getRoleBean().getRole_authority();
											long maxValue = 0;
											
											boolean flag = false;
											
											
											
											if(authority.equals("W1") || authority.equals("W2") || authority.equals("W3") 
													|| authority.equals("T1") || authority.equals("T2") || authority.equals("T3") 
													|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")){ 
												maxValue = allListProbationDAO1.getCount(employee_master_id);
												flag = false;
											}else{
												maxValue = allListProbationDAO1.getCountForM2(employee_master_id_emp);
												flag=true;
											}
											
											
											
											AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
											List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO
													.getListOfScoreByEmpId(employee_master_id_emp);
											for (ProbationAssessmentManagerBean li : listOfExtended1) {	
											int probationmanager_id = li.getProbation_assessment_manager_id();
											List<ProbationExtendBean> listForExtend = allListProbationDAO
														.getProbationExtend(probationmanager_id);
												for (ProbationExtendBean p1 : listForExtend) {
													String extend_period = p1.getExtended_period();
													to_be_extended = to_be_extended + Integer.parseInt(extend_period);
													System.out.println("to_be_extended:" + to_be_extended);
													extended_month =  extended_month + Integer.parseInt(extend_period);
												}
											}
											to_be_extended = to_be_extended + 6;
											System.out.println("maxvalue:" + maxValue);
											System.out.println("to_be_extended:" + to_be_extended);
								%>
								<tbody>
								<tr>
									<td><%=p.getFirstname() + " " + p.getLastname()%></td>
									<%if(flag == false){ %>
									<td>Direct Employee</td>
									<%}else{ %>
									<td>Indirect Employee</td>
									<%} %>
									<td><%=sd%></td>
									<td><%=maxValue%></td>
									<td><%=extended_month%></td>
									<%
									List<ProbationAssessmentTerminationBean> listOfTermination = allListProbationDAO1.getAllListOfTerminatedEmployeesPending(employee_master_id);
										List<ProbationAssessmentManagerBean> listForCheck = allListProbationDAO1
														.getListOfScoreByEmpId(employee_master_id_emp);
										String statusPrint = null; 
												if (listForCheck.size() != 0) {
													for (ProbationAssessmentManagerBean probationAssessmentManagerBean : listForCheck) {
														
														String status = probationAssessmentManagerBean.getManager_approval();
														String hr_status = probationAssessmentManagerBean.getHr_approval();
														String top_management_status = probationAssessmentManagerBean.getTop_management_approval();
														
														if(status.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("approved") & (top_management_status.equalsIgnoreCase("approved") || top_management_status.equalsIgnoreCase("hrapproved"))){
															statusPrint = "Approved";
														}else if(status.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("approved") & top_management_status.equalsIgnoreCase("rejected")){
															statusPrint = " Top Management Rejected";
														}else if(status.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("rejected")){
															statusPrint = "Hr Rejected";
														}else if(status.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("pending")){
															statusPrint = "Hr Approval Pending";
														}else if(status.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("approved") & top_management_status.equalsIgnoreCase("pending")){
															statusPrint = " Top Management Approval Pending";
														}else if(status.equalsIgnoreCase("rejected")){
															statusPrint = "Manager Rejected";
														}
														else{
															statusPrint = "Pending";
														}
									%>
									<%
										if (status.equalsIgnoreCase("pending") || status.equalsIgnoreCase("approved")) {
															if (probationAssessmentManagerBean.getTo_be_extended().equalsIgnoreCase("extendedYes")
																		&& status.equalsIgnoreCase("approved") && hr_status.equalsIgnoreCase("approved") && (top_management_status.equalsIgnoreCase("approved") ||  top_management_status.equalsIgnoreCase("hrapproved"))) {
									%>
									<td><%=statusPrint%>(Extended)</td>
									<td><a
										href="probationOpenInfopage?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-plus-circled" data-toggle="tooltip"
											data-placement="top" title="Add Review"></i></a></td>
									<%
										} else if (probationAssessmentManagerBean.getTo_be_extended().equalsIgnoreCase("extendedNo")
												&& status.equalsIgnoreCase("approved")) { %>
									<td><%=statusPrint%></td>
									<td><a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-eye4" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a></td>

									<%}else if(maxValue == 6){ %>

									<td><%=statusPrint%></td>
									<td><a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-eye4" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a></td>

									<%}else{		
											
											if((maxValue == to_be_extended) && !probationAssessmentManagerBean.getRepoting_manager_approval().equalsIgnoreCase("approved")){ %>

									<td>Your Review Pending</td>
									
										
										 <%if(probationAssessmentManagerBean.getTo_be_extended().equalsIgnoreCase("extendedYes")
														&& status.equalsIgnoreCase("pending")){
												 if(listOfTermination.size() == 0){
												%> <td><a
										href="probationListByIdIndirect.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-edit2" data-toggle="tooltip"
											data-placement="top" title="Edit Data"></i></a></td> <%}
												 else{%>
													 <td>Termination Approval Pending</td>
												 <%}
											 }else{ %> <td><a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-eye4" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a></td> <%} %> 

									</td>
									<%}else{ %>
									<td><%=statusPrint%>(Manager)</td>
									<td>
										 <a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-eye4" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>


									</td>
									<%}}%>


									<%
										} else if (status.equalsIgnoreCase("rejected")) {
									%>
									<td><%=statusPrint%></td>
									<td>
										 <a
										href="probationListByIdIndirectUpdate.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-edit2" data-toggle="tooltip"
											data-placement="top" title="Edit Data"></i></a> 

									</td>
									<%
										} else {
									%>
									<td><%=statusPrint%></td>
									<td>
										 <a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-eye4" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>

									</td>
									<%
										}
									%>
									<%
										}
												} else {
									%>

									<%
										if (maxValue == to_be_extended) {
											if(listOfTermination.size() != 0){%>
												<td>Termination Approval Pending</td>
												<td></td>
											<%}else{
									%>
									<td>Your Review Pending</td>
									<td>
										<a
										href="probationListByIdIndirect.jsp?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-edit2" data-toggle="tooltip"
											data-placement="top" title="Edit Data"></i></a> 
									</td>
									<%
											}}
										
										else {
									
									
									if(listOfTermination.size() != 0){%>
												<td>Termination Approval Pending</td>
												<td></td>
											<%}else{%>
									<td>Review to be filled</td>
									<td><a
										href="probationOpenInfopage?employee_master_id=<%=p.getEmployee_master_id()%>"><i
											class="icon-plus-circled" data-toggle="tooltip"
											data-placement="top" title="Add Review"></i></a></td>
									<%
										}
									%>
									<%
										}}
									%>
								</tr>
								<%
									}
								%>
</tbody>
							</table>
			 <font size="3px;" color="#337ab7"><b>Legends
					:&nbsp;</b></font> <i class="icon-eye4"
				style="color: #337ab7;"></i><b> : View Employee's Review </b>
			&nbsp;&nbsp;&nbsp;<i class="icon-plus-circled"
				style="color: #337ab7;"></i><b> : Add Review</b> &nbsp;&nbsp;&nbsp;<i
				class=" icon-edit2" style="color: #337ab7;"></i><b>
				: Update Review</b> &nbsp;&nbsp;&nbsp;
				</div>
				</div>
				
				
				
				
				
				</div>
</div>
			<%
				}
			%>
			<br>
			<% List<EmployeeBean> listForUnderCheck = allListProbationDAO1.getListOfUnderEmployee(manager_id);
						boolean flag1 = false;
						int count = 0;
						if(listForUnderCheck.size() != 0){ %>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b><font size="3px">Probation Form(Manager)</font></b>
				</div>
				<div class="panel-body">
					<%
										AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
										List<EmployeeBean> listForReview = allListProbationDAO.getListOfUnderEmployee(manager_id);
										for (EmployeeBean p : listForReview) {
											int employee_id = p.getEmployee_master_id();
											int managerId = p.getManagerBean().getManager_id();
											String name = p.getFirstname() + " " + p.getLastname();
											
									%>
					<%
												List<ProbationAssessmentManagerBean> listOfEmployee = allListProbationDAO.getListOfReviews(managerId);
													if (listOfEmployee.size() != 0) {
											%>
					<div class="panel-body">
						<table>
							<tr>
								<td>Manager Name : <%=name%></td>
							</tr>
						</table>

						<br>
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										Reviews of Employees of
										<%=name%>
									</h3>
								</div>
								<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>Employee Name</th>
										<th>Reporting Manager</th>
										<th>Total Extended Period</th>
										<th>Approval Status</th>
										<th>Action</th>
									</tr>
									</thead>
									<%
															for (ProbationAssessmentManagerBean pa : listOfEmployee) {
																		String employee_name = pa.getEmployeeBean().getFirstname() + " "
																				+ pa.getEmployeeBean().getLastname();
																		int emp_id = pa.getEmployeeBean().getEmployee_master_id();
																		String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
																		int probationmanager_id = pa.getProbation_assessment_manager_id();
																		String status = null;
																		int extended = 6;
																		String to_be_extended = pa.getTo_be_extended();
																		long maxValue = 0;
																		List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
																		for(ProbationExtendBean pe : listForExtend){
																			status  = pe.getStatus();
																			
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
																		if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1")
																				|| authority.equals("T2") || authority.equals("T3") || authority.equals("A1")
																				|| authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
																			maxValue = allListProbationDAO.getCount(emp_id);
																		} else {
																			maxValue = allListProbationDAO.getCountForM2(emp_id);
																		}
														%>
									<%List<ProbationAssessmentManagerBean> listOfEmployee1 = allListProbationDAO.getListOfScoreByEmpId(emp_id); %>
									<%for(ProbationAssessmentManagerBean p1 : listOfEmployee1){
																String manager_approval = p1.getManager_approval();
																int employee_master_id_emp = p1.getEmployeeBean().getEmployee_master_id();
																String status1 = p1.getManager_approval();
																String hr_status = p1.getHr_approval();
																String top_management_status = p1.getTop_management_approval();
																
																if(status1.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("approved") & (top_management_status.equalsIgnoreCase("approved") || top_management_status.equalsIgnoreCase("hrapproved"))){
																	status = "Approved";
																}else if(status1.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("approved") & top_management_status.equalsIgnoreCase("rejected")){
																	status1 = " Top Management Rejected";
																}else if(status1.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("rejected")){
																	status1 = "Hr Rejected";
																}else if(status1.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("pending")){
																	status = "Hr Approval Pending";
																}else if(status1.equalsIgnoreCase("approved") & hr_status.equalsIgnoreCase("approved") & top_management_status.equalsIgnoreCase("pending")){
																	status1 = " Top Management Approval Pending";
																}else if(status1.equalsIgnoreCase("rejected")){
																	status1 = "Manager Rejected";
																}
																else{
																	status1 = "pending";
																}
										List<ProbationAssessmentTerminationBean> listOfTerminationEmployee = allListProbationDAO.getAllListOfTerminatedEmployeesPending(employee_master_id_emp);
																%>
																
<tbody>
									<tr>
										<td><%=employee_name%></td>
										<td><%=name%></td>
										<td><center><%=pa.getPeriod_to_be_extended() %></center></td>
										<td><%=status1%></td>
										<!-- &nbsp;&nbsp;&nbsp; --> 
										<%if(manager_approval.equalsIgnoreCase("pending")){ %>
											<%if(listOfTerminationEmployee.size() == 0){ %>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
											href="probationListByIdIndirectApproval.jsp?employee_master_id=<%=emp_id%>&&reviewing_manager_id=<%=employee_id%>"><i
												class="icon-edit2" data-toggle="tooltip"
												data-placement="top" title="Edit Data"></i></a></td> <%}
											else{%>
												<td>Termination Approval Pending</td>
											<%}
										
										} else{
																		if(maxValue == extended){%>
																		 <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
											href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>&&reviewing_manager_id=<%=employee_id%>"><i
												class="icon-eye4" data-toggle="tooltip"
												data-placement="top" title="Show View"></i></a></td>  <%}
																		else{%>
																			<td>Extended</td>
																		<%}
										} %>
									</tr>
									<%}} %>
</tbody>
								</table>

							</div>
						</div>
					</div>

					<%
																}else{
																	flag1 = true;
																	count++;
														}%>
					<%if(flag1 == true & count == listForReview.size()){ %>
					No Data Available
					<%} %>
					<%
										}
									%>
										</div>
			</div>
 <font size="3px;" color="#337ab7"><b>Legends
					:&nbsp;</b></font> <i class="icon-eye4"
				style="color: #337ab7;"></i><b> : View Employee's Review </b>
			&nbsp;&nbsp;&nbsp;<i class="icon-plus-circled"
				style="color: #337ab7;"></i><b> : Add Review</b> &nbsp;&nbsp;&nbsp;<i
				class=" icon-edit2" style="color: #337ab7;"></i><b>
				: Update Review</b> &nbsp;&nbsp;&nbsp;
				
			
			<br><br>
			<%}%>
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Terminated Employee List</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading"><b><font size="3px">Terminated Employee List</font></b></div> -->
	<div class="panel-body">
	<%List<ProbationAssessmentTerminationBean> listOfTerminatedEmployee = allListProbationDAO1.getAllListOfTerminatedEmployees(employeeId);
	List<ProbationAssessmentTerminationBean> listOfTerminatedEmployeeForManager = allListProbationDAO1.getAllListOfTerminatedEmployeesForManagers(manager_id);%>
	<%if(listOfTerminatedEmployee.size() != 0 || listOfTerminatedEmployeeForManager.size() != 0) { %>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example3">
								<thead>
							<tr>
								<th>Employee Name</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
							</thead>
			<%for(ProbationAssessmentTerminationBean patb : listOfTerminatedEmployee){%>
			<tbody>
							<tr>
								<td><%=patb.getEmployeeBean().getFirstname()%> <%=patb.getEmployeeBean().getLastname()%></td>
								<td><%=patb.getManager_status() %></td>
								<%if(patb.getManager_status().equalsIgnoreCase("pending")){ %>
								<td></td>
								<%}else if(patb.getManager_status().equalsIgnoreCase("rejected")){ %>
								<td>
								<a
									href="probationTerminatedUpdate.jsp?employee_master_id=<%=patb.getEmployeeBean().getEmployee_master_id()%>&month_id=<%=patb.getMonthBean().getMonth_id()%>&year_id=<%=patb.getYearBean().getYear_id()%>&reviewing_manager_id=<%=patb.getReviewing_manager_id()%>&probation_assessment_termination_id=<%=patb.getProbation_assessment_termination_id()%>"><i
										class="icon-edit2" data-toggle="tooltip"
										data-placement="top" title="Show View"></i></a>
								
								</td>
								<%}else{%>
								<td>
								</td>
								<%} %>
							</tr>
							<%}
				%>


							<%for(ProbationAssessmentTerminationBean patb : listOfTerminatedEmployeeForManager){%>
							<tr>
								<td><%=patb.getEmployeeBean().getFirstname()%> <%=patb.getEmployeeBean().getLastname()%></td>
								<td><%=patb.getManager_status() %></td>
								<%if(patb.getManager_status().equalsIgnoreCase("pending")){ %>
								<td><a
									href="probationTerminationListById.jsp?employee_master_id=<%=patb.getEmployeeBean().getEmployee_master_id()%>"><i
										class="icon-edit2" data-toggle="tooltip"
										data-placement="top" title="Show View"></i></a></td>
								<%}else{ %>
								<td><a
									href="probationTerminationListByIdView.jsp?employee_master_id=<%=patb.getEmployeeBean().getEmployee_master_id()%>"><i
										class="icon-eye4" data-toggle="tooltip"
										data-placement="top" title="Show View"></i></a></td>
								<%} %>
							</tr>
							<%}
				%>
				</tbody>
						</table>
						<%}else{ %>
						
						No Data Available
						<%} %>
</div>
						<!-- /.row -->
					</div>
					<!-- /#page-wrapper -->
				</div>
			</div>
			</div>
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
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
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
		$(document).ready(function() {
			$('#dataTables-example1').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example2').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example3').DataTable({
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
		<%-- <%}else{ %>
	response.sendRedirect("probationForm.jsp");
	<%} %> --%>
</body>
</html>