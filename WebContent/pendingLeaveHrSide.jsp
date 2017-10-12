<%@page import="com.sun.corba.se.spi.orbutil.fsm.State"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap.min.css">
<!-- font icons-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<%
	String status = "pending";
	String s = status;

	if (request.getParameter("hrStatus") != null) {
		status = request.getParameter("hrStatus");
		session.setAttribute("hrStatus", status);
	} else if (session.getAttribute("hrStatus") != null) {
		status = (String) session.getAttribute("hrStatus");
	}

	if (status.equalsIgnoreCase("pending")) {
		s = "Pending";
	} else if (status.equalsIgnoreCase("approved")) {
		s = "Approved";
	} else if (status.equalsIgnoreCase("rejected")) {
		s = "Rejected";
	}
%>
<title><%=s%> Leave / CO / OD</title>
<script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "text")
if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
    document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
}
</script>
<script>
if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
        $('#fromDate').datepicker({
            dateFormat: 'dd-mm-yy'
        });
        $('#toDate').datepicker({
            dateFormat: 'dd-mm-yy'
        });
        
    })
}
function deleteLeave(id,status) {
	
	var retVal = confirm("Are you sure?");
	var fromDate = document.getElementById('fromDate').value;
	var toDate = document.getElementById('toDate').value;
	var companyId = document.getElementById('companyId').value;
	
	if( retVal == true )
		{
		window.location.replace("LeaveDelete?leave_id="+id+"&status="+status+"&action=hrSide&fromDate="+fromDate+"&toDate="+toDate+"&companyId="+companyId);
		}
			else
			{
				window.location.replace("pendingLeaveHrSide.jsp");
				return false;
	 		}
}

function changeHrApproval(id) {
	
	if(id==1){
		document.getElementById('hrApproval').value = "leave";
	}else if(id==2){
		document.getElementById('hrApproval').value = "co";
	}else if(id==3){
		document.getElementById('hrApproval').value = "od";
	}
	
}
</script>
<%@include file="header.jsp"%>
</head>
<body>
	<%
		String hrapproval = "leave";
		int emp_id = user.getEmployee_master_id();
		System.out.println("HR Approval:");
		if (request.getAttribute("hrApproval") != null) {
			hrapproval = (String) request.getAttribute("hrApproval");
			session.setAttribute("hrApproval", hrapproval);
		} else if (request.getParameter("hrApproval") != null) {
			hrapproval = request.getParameter("hrApproval");
			session.setAttribute("hrApproval", hrapproval);
		}

		Calendar now = Calendar.getInstance(); // Current Month, Year, Date

		System.out.println("Current Year is : " + now.get(Calendar.YEAR));
		// month start from 0 to 11
		System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
		System.out.println("Current Date is : " + now.get(Calendar.DATE));

		int month_id = now.get(Calendar.MONTH) + 1;
		int year = now.get(Calendar.YEAR);

		String fromDate = null;
		String toDate = null;

		if (month_id == 1 || month_id == 3 || month_id == 5 || month_id == 7 || month_id == 8) {
			fromDate = "01-0" + month_id + "-" + year;
			toDate = "31-0" + month_id + "-" + year;

		} else if (month_id == 4 || month_id == 6 || month_id == 9) {
			fromDate = "01-0" + month_id + "-" + year;
			toDate = "30-0" + month_id + "-" + year;
		} else if (month_id == 10 || month_id == 12) {
			fromDate = "01-" + month_id + "-" + year;
			toDate = "31-" + month_id + "-" + year;
		}
		if (month_id == 11) {
			fromDate = "01-" + month_id + "-" + year;
			toDate = "30-" + month_id + "-" + year;
		}
		if (month_id == 2) {
			if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
				fromDate = "01-0" + month_id + "-" + year;
				toDate = "29-0" + month_id + "-" + year;
			} else {
				fromDate = "01-0" + month_id + "-" + year;
				toDate = "28-0" + month_id + "-" + year;
			}
		}

		int companyId = 0;

		if (request.getParameter("companyId") != null) {
			companyId = Integer.parseInt(request.getParameter("companyId"));
			session.setAttribute("companyId", companyId);
		} else if (session.getAttribute("companyId") != null) {
			companyId = (Integer) session.getAttribute("companyId");
		}
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
								<div class="row">
									<div class="col-lg-12">
										<h1 class="page-header">
											<%=s%>
											Leave / CO / OD List
										</h1>
									</div>
									<!-- /.col-lg-12 -->
								</div>

								<%
									if (request.getAttribute("success") != null) {
								%>
								<div class="panel-body" id="panelbody">
									<div class="alert alert-dismissable alert-success ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${success}
									</div>
								</div>
								<%
									}
								%>

								<%
									if (request.getAttribute("error") != null) {
								%>
								<div class="panel-body" id="panelbody">
									<div class="alert alert-dismissable alert-danger">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${error}
									</div>
								</div>
								<%
									}
								%>
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-default">
											<div class="panel-heading">

												<div class="row">

													<div class="col-md-12">
														<div class="col-md-6"></div>
														<div class="col-md-6" align="right">
															<a href="employeeLeaveDetail.jsp"><button
																	class="btn btn-default btn-xs">
																	<i class="fa fa-user"></i> Detailed Employee Leave
																</button></a>
														</div>
													</div>

												</div>


											</div>
											<%
												String parseFromDate = null;
												String parseToDate = null;
												String parseFromDate1 = null;
												String parseToDate1 = null;

												if (request.getParameter("fromDate") != null && !request.getParameter("toDate").equalsIgnoreCase("")) {
													fromDate = request.getParameter("fromDate");
													toDate = request.getParameter("toDate");

													session.setAttribute("fromDate", fromDate);
													session.setAttribute("toDate", toDate);

												} else if (session.getAttribute("fromDate") != null && session.getAttribute("toDate") != null) {
													fromDate = (String) session.getAttribute("fromDate");
													toDate = (String) session.getAttribute("toDate");
												}

												DateFormat dateFormatForselection = new SimpleDateFormat("dd-MM-yyyy");
												DateFormat dateFormat2Forselection = new SimpleDateFormat("yyyy-MM-dd");
												DateFormat dateFormat1ForSelection = new SimpleDateFormat("dd/MM/yyyy");

												Date datee = dateFormatForselection.parse(fromDate);
												Date datee1 = dateFormatForselection.parse(toDate);

												parseFromDate = dateFormat1ForSelection.format(datee);
												parseToDate = dateFormat1ForSelection.format(datee1);

												parseFromDate1 = dateFormat2Forselection.format(datee);
												parseToDate1 = dateFormat2Forselection.format(datee1);
											%>

											<div class="panel-body">

												<form id="allLeaveHrSide" action="pendingLeaveHrSide.jsp">

													<div class="row">
														<input type="hidden" name="hrApproval" id="hrApproval"
															value="leave">
														<div class="col-md-2">
															<b>Select Status</b>
														</div>

														<div class="col-md-1">
															<b>:</b>
														</div>

														<div class="col-md-8">
															<%
																if (status.equalsIgnoreCase("pending")) {
															%><input type="radio" name="hrStatus" value="pending"
																checked="checked">
															<%
																} else {
															%><input type="radio" name="hrStatus" value="pending">
															<%
																}
															%>
															Pending
															<%
																if (status.equalsIgnoreCase("approved")) {
															%><input type="radio" name="hrStatus" value="approved"
																checked="checked">
															<%
																} else {
															%><input type="radio" name="hrStatus" value="approved">
															<%
																}
															%>
															Approved
															<%
																if (status.equalsIgnoreCase("rejected")) {
															%><input type="radio" name="hrStatus" value="rejected"
																checked="checked">
															<%
																} else {
															%><input type="radio" name="hrStatus" value="rejected">
															<%
																}
															%>
															Rejected
														</div>

													</div>

													<br>
													<%
														if (request.getParameter("fromDate") != null && !request.getParameter("fromDate").equalsIgnoreCase("")) {
													%>
													<div class="row">
														<div class="col-md-2">
															<b>Enter Date </b>
														</div>

														<div class="col-md-1">
															<b>:</b>
														</div>

														<div class="col-md-3">
															<input type="text" class="form-control" name="fromDate"
																id="fromDate" value="<%=fromDate%>" style="width: 200px"
																placeholder="dd-mm-yyyy">
														</div>

														<div class="col-md-1">To</div>

														<div class="col-md-3">
															<input type="text" class="form-control" name="toDate"
																id="toDate" value="<%=toDate%>" style="width: 200px"
																placeholder="dd-mm-yyyy">
														</div>

													</div>
													<%
														} else {
													%>
													<div class="row">
														<div class="col-md-2">
															<b>Enter Date </b>
														</div>

														<div class="col-md-1">
															<b>:</b>
														</div>


														<div class="col-md-3">
															<input type="text" class="form-control" name="fromDate"
																id="fromDate" value="<%=fromDate%>" style="width: 200px"
																placeholder="dd-mm-yyyy">
														</div>

														<div class="col-md-1">To</div>

														<div class="col-md-3">
															<input type="text" class="form-control" name="toDate"
																id="toDate" value="<%=toDate%>" style="width: 200px"
																placeholder="dd-mm-yyyy">
														</div>
													</div>
													<%
														}
													%>

													<br>
													<div class="row">
														<div class="col-md-2">
															<b>Select Company</b>
														</div>

														<div class="col-md-1">
															<b>:</b>
														</div>

														<div class="col-md-8">
															<select class="form-control" name="companyId"
																placeholder="Select Company Name" id="companyId">


																<option value="0">All Company</option>
																<%
																	CompanyListDAO companyListDAO = new CompanyListDAO();
																	List<CompanyListBean> listOfCompanyList = (ArrayList) companyListDAO.getListOfCompanyList();
																	for (CompanyListBean companyListBean : listOfCompanyList) {
																		if (companyId == companyListBean.getCompany_list_id()) {
																%>
																<option
																	value="<%=companyListBean.getCompany_list_id()%>"
																	selected="selected"><%=companyListBean.getCompany_name()%></option>
																<%
																	} else {
																%>
																<option
																	value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
																<%
																	}
																	}
																%>
															</select>
														</div>

													</div>

													<br>
													<div align="center">
														<input type="submit" class="btn btn-primary" name="submit"
															value="SUBMIT">
													</div>

												</form>
											</div>
										</div>
									</div>
								</div>
								<div>
									<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">Gate Pass</div>
											<!-- /.panel-heading -->
											<div class="panel-body">
												<!-- Nav tabs -->
												<ul class="nav nav-tabs">
										<%
											AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
											List<LeaveBean> listOfEmployee = null;
											List<LeaveCOBean> co = null;
											List<LeaveODBean> d = null;

											if (emp_id == 1120 || emp_id == 975 || emp_id == 1946) {

												listOfEmployee = allLMSListDAO.getListOfApprovedEmployeeLeaveForSurat(parseFromDate1, parseToDate1,
														status, companyId);
												co = allLMSListDAO.getApprovedCOSurat(parseFromDate1, parseToDate1, status, companyId);
												d = allLMSListDAO.getApprovedODSurat(parseFromDate1, parseToDate1, status, companyId);

											} else if (emp_id == 1959) {
												listOfEmployee = allLMSListDAO.getListOfApprovedEmployeeLeaveForA8DeptWise(parseFromDate1, parseToDate1,
														status, companyId);
												co = allLMSListDAO.getApprovedCOA8DeptWise(parseFromDate1, parseToDate1, status, companyId);
												d = allLMSListDAO.getApprovedODA8DeptWise(parseFromDate1, parseToDate1, status, companyId);
											} else {

												listOfEmployee = allLMSListDAO.getListOfApprovedEmployeeLeave(parseFromDate1, parseToDate1, status,
														companyId);
												co = allLMSListDAO.getApprovedCO(parseFromDate1, parseToDate1, status, companyId);
												d = allLMSListDAO.getApprovedOD(parseFromDate1, parseToDate1, status, companyId);

											}
										%>
										<%
											if (hrapproval.equalsIgnoreCase("leave")) {
										%>
										<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#leave"
														aria-controls="homeIcon" aria-expanded="true"><i
															class="icon-ios-compose" onclick="changeHrApproval(1)"></i> Leave</a></li>
											<%
												} else {
											%>
										
										<li class="nav-item"><a class="nav-link"
														id="homeIcon-tab" data-toggle="tab" href="#leave"
														aria-controls="homeIcon" aria-expanded="false"><i
															class="icon-ios-compose" onclick="changeHrApproval(1)"></i> Leave</a></li>
											<%
												}
											%> 

										<%
											if (hrapproval.equalsIgnoreCase("co")) {
										%>
										<li class="nav-item"><a class="nav-link active"
														id="profileIcon-tab" data-toggle="tab" href="#co"
														aria-controls="profileIcon" aria-expanded="true"><i
															class="icon-user-plus" onclick="changeHrApproval(2)"></i> CO</a></li>
											<%
												} else {
											%>
												<li class="nav-item"><a class="nav-link"
														id="profileIcon-tab" data-toggle="tab" href="#co"
														aria-controls="profileIcon" aria-expanded="false"><i
															class="icon-user-plus" onclick="changeHrApproval(2)"></i> CO</a></li>
											<%
												}
											%>
										<%
											if (hrapproval.equalsIgnoreCase("od")) {
										%>
										<li class="nav-item dropdown"><a
														class="nav-link active" data-toggle="tab" href="#od"
														role="button" aria-haspopup="true" aria-expanded="true"><i
															class="icon-android-list" onclick="changeHrApproval(3)"></i> OD</a></li>
											<%
												} else {
											%>
										<li class="nav-item dropdown"><a class="nav-link"
														data-toggle="tab" href="#od" role="button"
														aria-haspopup="true" aria-expanded="false"><i
															class="icon-android-list" onclick="changeHrApproval(3)"></i> OD</a></li>										
											<%
												}
											%>
									</ul>

									<!-- Tab panes -->
									<div class="tab-content px-1 pt-1">
										<%
											if (hrapproval.equalsIgnoreCase("leave")) {
										%>
										<div role="tabpanel" class="tab-pane fade active in"
														id="leave" aria-labelledby="homeIcon-tab"
														aria-expanded="true">
											<%
												} else {
											%>
											<div role="tabpanel" class="tab-pane fade" id="leave"
															aria-labelledby="homeIcon-tab" aria-expanded="false">
												<%
													}
												%>

												<h6 align="center">
													<b><%=status.toUpperCase()%> LEAVE </b>(<%=fromDate%>
													to
													<%=toDate%>)
												</h6>
												<hr>
												<div class="panel-body">
													<div class="dataTable_wrapper">
														<div class="table-responsive">
															<table
																class="table table-striped table-bordered table-hover file-export">
																<thead>
																	<tr>
																		<th>Company Name</th>
																		<th>Emp Code</th>
																		<th>Employee Name</th>
																		<th>From Date</th>
																		<th>To Date</th>
																		<th>Day Count</th>
																		<th>Status</th>
																		<th>submission Date</th>
																		<th>Reporting Manager</th>
																		<%
																			if (user.getEmployee_code() == 251 || user.getEmployee_code() == 2714) {
																		%>
																		<th>Action</th>
																		<%
																			}
																		%>
																	</tr>
																</thead>
																<tbody>
																	<%
																		for (LeaveBean l : listOfEmployee) {
																			String leave_to = l.getLeave_To();
																			String leave_from = l.getLeave_From();
																			String submission_date = l.getSubmission_date();
																			String lf = null;
																			String lt = null;
																			String sd = null;
																			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
																			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																			Date date = dateFormat.parse(leave_to);
																			Date date1 = dateFormat.parse(leave_from);
																			Date date2 = formater.parse(submission_date);
																			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
																			SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
																			lt = dateFormat1.format(date);
																			lf = dateFormat1.format(date1);
																			sd = formater1.format(date2);
																	%>

																	<tr>

																		<td><%=l.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																		<td><%=l.getEmployeeBean().getEmployee_code()%></td>
																		<td><%=l.getEmployeeBean().getFirstname() + " " + l.getEmployeeBean().getMiddlename() + " "
						+ l.getEmployeeBean().getLastname()%></td>
																		<td><%=lf%></td>
																		<td><%=lt%></td>
																		<td><%=l.getDay_count()%></td>
																		<td><%=l.getStatus()%></td>
																		<td><%=sd%></td>
																		<%
																			LoginDAO loginDAO = new LoginDAO();
																				int manager_id = Integer.parseInt(l.getEmployeeBean().getUnder_manager_id());
																				EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
																		%>
																		<td><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></td>
																		<%
																			if (user.getEmployee_code() == 251 || user.getEmployee_code() == 2714) {
																		%>
																		<td>
																			<%
																				if (l.getStatus().equalsIgnoreCase("pending")) {
																			%> <a
																			href="pendingLeave?leave_id=<%=l.getLeave_id()%>&status=<%=l.getStatus()%>&hrApproval=leave">
																				<i class="icon-checkmark"></i>
																		</a> <%
 																		} else if (l.getStatus().equalsIgnoreCase("approved")) {
 																		%> <i class="icon-trash" data-toggle="tooltip"
																			id="<%=l.getStatus()%>" data-placement="top"
																			title="Cancel Leave" style="color: red;"
																			onclick="deleteLeave(<%=l.getLeave_id()%>,this.id)"></i>
																			<a
																			href="Myleave?leave_id=<%=l.getLeave_id()%>&status=<%=l.getStatus()%>&action=hrSide"><i
																				class="icon-edit2"
																				data-toggle="tooltip" data-placement="top"
																				title="Update Leave"></i></a> <%
 	}
 %>
																		</td>
																		<%
																			}
																		%>
																	</tr>

																	<%
																		}
																	%>
																</tbody>
															</table>
															<h5>
																<b>Legends :&nbsp;</b>
															</h5>
															<i class="icon icon-eye4" style="color: ;"></i><b>
																: Leave Approval </b>
														</div>
													</div>
												</div>

											</div>
											<%
												if (hrapproval.equalsIgnoreCase("co")) {
											%>
												<div class="tab-pane fade active in" id="co"
															role="tabpanel" aria-labelledby="profileIcon-tab"
															aria-expanded="true">
												<%
													} else {
												%>
													<div class="tab-pane fade" id="co" role="tabpanel"
																aria-labelledby="profileIcon-tab" aria-expanded="false">
													<%
														}
													%>

													<h6 align="center">
														<b><%=status.toUpperCase()%> CO </b>(<%=fromDate%>
														to
														<%=toDate%>)
													</h6>
													<hr>
													<div class="panel-body">
														<div class="dataTable_wrapper">
															<div class="table-responsive">
																<table
																	class="table table-striped table-bordered table-hover file-export">
																	<thead>
																		<tr>
																			<th style="text-align: center">Company Name</th>
																			<th style="text-align: center">Emp Code</th>
																			<th style="text-align: center">Name</th>
																			<th style="text-align: center">Date</th>
																			<th style="text-align: center">Start Time</th>
																			<th style="text-align: center">End Time</th>
																			<th style="text-align: center">Total Hours</th>
																			<th style="text-align: center">Total CO Added</th>
																			<th style="text-align: center">Manager Name</th>
																			<%
																				if (user.getEmployee_code() == 251 || user.getEmployee_code() == 2714) {
																			%>
																			<th style="text-align: center">Action</th>
																			<%
																				}
																			%>
																		</tr>
																	</thead>
																	<tbody>
																		<%
																			for (LeaveCOBean c : co) {

																				String _24HourStartTime = c.getStart_time();
																				String _24HourEndTime = c.getEnd_time();

																				String start = null;

																				try {

																					SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																					Date result1 = formater1.parse(c.getCO_date());
																					SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
																					start = formater2.format(result1);

																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}
																		%>

																		<tr>
																			<td><%=c.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																			<td><%=c.getEmployeeBean().getEmployee_code()%></td>
																			<td><%=c.getEmployeeBean().getFirstname() + " " + c.getEmployeeBean().getMiddlename() + " "
						+ c.getEmployeeBean().getLastname()%></td>
																			<td><%=start%></td>
																			<td><%=c.getStart_time()%></td>
																			<td><%=c.getEnd_time()%></td>
																			<td><%=c.getTotal_Hours()%></td>
																			<td>
																				<%
																					if (c.getTotal_Hours() >= 4) {
																				%> <font color="Red"> 1.0 </font> <%
 	} else if (c.getTotal_Hours() >= 2 && c.getTotal_Hours() <= 4) {
 %> <font color="Red"> 0.5 </font> <%
 	} else if (c.getTotal_Hours() <= 2) {
 %> <font color="Red"> 0.0 </font> <%
 	}
 %>
																			</td>
																			<%
																				LoginDAO loginDAO = new LoginDAO();
																					int manager_id = Integer.parseInt(c.getEmployeeBean().getUnder_manager_id());
																					EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
																			%>
																			<td><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></td>
																			<%
																				if (user.getEmployee_code() == 251 || user.getEmployee_code() == 2714) {
																			%>
																			<td>
																				<%
																					if (c.getStatus().equalsIgnoreCase("pending")) {
																				%> <a
																				href="LeaveCOManagerShow?CO_ID=<%=c.getCO_ID()%>&hrApproval=co">
																					<i class="icon-checkmark"></i>
																			</a> <%
 	}
 %>
																			</td>
																			<%
																				}
																			%>
																		</tr>
																		<%
																			}
																		%>
																	</tbody>
																</table>
															</div>
															<h5>
																<b>Legends :&nbsp;</b>
															</h5>
															<i class="icon-checkmark" style="color: #337ab7;"></i><b>
																: CO Approval </b>
														</div>
													</div>

												</div>
												<%
													if (hrapproval.equalsIgnoreCase("od")) {
												%>
												<div class="tab-pane fade active in" id="od"
																role="tabpanel" aria-labelledby="dropdownIcon1-tab"
																aria-expanded="false">
													<%
														} else {
													%>
													<div class="tab-pane fade" id="od" role="tabpanel"
																	aria-labelledby="dropdownIcon1-tab"
																	aria-expanded="false">
														<%
															}
														%>


														<h6 align="center">
															<b><%=status.toUpperCase()%> OD </b>(<%=fromDate%>
															to
															<%=toDate%>)
														</h6>
														<hr>
														<div class="panel-body">
															<div class="dataTable_wrapper">
																<div class="table-responsive">
																	<table
																		class="table table-striped table-bordered table-hover file-export">
																		<thead>
																			<tr>
																				<th style="text-align: center">Company Name</th>
																				<th style="text-align: center">Emp Code</th>
																				<th style="text-align: center">Name</th>
																				<th style="text-align: center">From Date</th>
																				<th style="text-align: center">To Date</th>
																				<th style="text-align: center">Start Time</th>
																				<th style="text-align: center">End Time</th>
																				<th style="text-align: center">Total Day</th>
																				<th style="text-align: center">Manager Name</th>
																				<th style="text-align: center">Description</th>
																				<%
																					if (user.getEmployee_code() == 251 || user.getEmployee_code() == 2714) {
																				%>
																				<th style="text-align: center">Action</th>
																				<%
																					}
																				%>

																			</tr>
																		</thead>
																		<tbody>
																			<%
																				for (LeaveODBean od : d) {

																					String _24HourStartTime = od.getOD_StartTime();
																					String _24HourEndTime = od.getOD_EndTime();

																					String start = null;
																					String end = null;

																					try {

																						SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																						Date result1 = formater1.parse(od.getOD_StartDate());
																						Date result2 = formater1.parse(od.getOD_EndDate());
																						SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
																						start = formater2.format(result1);
																						end = formater2.format(result2);

																					} catch (ParseException e1) {
																						e1.printStackTrace();
																					}
																			%>
																			<tr>
																				<td><%=od.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
																				<td><%=od.getEmployeeBean().getEmployee_code()%></td>
																				<td><%=od.getEmployeeBean().getFirstname() + " " + od.getEmployeeBean().getMiddlename() + " "
						+ od.getEmployeeBean().getLastname()%></td>
																				<td><%=start%></td>
																				<td><%=end%></td>
																				<td>
																					<%
																						if (od.getOD_StartTime() == "") {
																					%> ----- <%
																						} else {
																					%> <%=od.getOD_StartTime()%> <%
 	}
 %>
																				</td>
																				<td>
																					<%
																						if (od.getOD_EndTime() == "") {
																					%> ----- <%
																						} else {
																					%> <%=od.getOD_EndTime()%> <%
 	}
 %>
																				</td>
																				<td><%=od.getOD_TotalDay()%></td>
																				<%
																					LoginDAO loginDAO = new LoginDAO();
																						int manager_id = Integer.parseInt(od.getEmployeeBean().getUnder_manager_id());
																						EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
																				%>
																				<td><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></td>
																				<td><i class="fa fa-info-circle"
																					data-container="body" data-toggle="popover"
																					data-placement="right" title="Description"
																					data-content="<%=od.getDescription()%>"> <i></i>
																				</i></td>
																				<%
																					if (user.getEmployee_code() == 251 || user.getEmployee_code() == 2714) {
																				%>
																				<td>
																					<%
																						if (od.getStatus().equalsIgnoreCase("pending")) {
																					%> <a
																					href="LeaveODManagerShow?OD_ID=<%=od.getOD_ID()%>&hrApproval=od">
																						<i class="icon-checkmark"></i>
																				</a> <%
 	}
 %>
																				</td>
																				<%
																					}
																				%>
																			</tr>
																			<%
																				}
																			%>
																		</tbody>
																	</table>
																</div>
																<h5>
																	<b>Legends :&nbsp;</b>
																</h5>
																<i class="icon-checkmark"
																	style="color: #337ab7;"></i><b> : OD Approval </b>

															</div>
														</div>

													</div>
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
	<!-- /.panel-heading -->

	<%@include file="footer.html"%>
	<!-- BEGIN VENDOR JS-->
	<!-- build:js app-assets/js/vendors.min.js-->
	<script src="app-assets/js/core/libraries/jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/tether.min.js"
		type="text/javascript"></script>
	<script src="app-assets/js/core/libraries/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/unison.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/blockUI.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery-sliding-menu.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/sliders/slick/slick.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/screenfull.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/pace.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="app-assets/vendors/js/extensions/moment.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/underscore-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/clndr.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/unslider-min.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN ROBUST JS-->
	<!-- build:js app-assets/js/app.min.js-->
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- END ROBUST JS-->

	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="app-assets/vendors/js/tables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/buttons.flash.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/jszip.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/pdfmake.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/vfs_fonts.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/buttons.html5.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/tables/buttons.print.min.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	   <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
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
    
    <!-- BEGIN PAGE LEVEL JS-->
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