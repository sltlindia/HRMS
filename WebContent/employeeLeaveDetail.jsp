<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveCancelRequestBean"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.lms.bean.LeaveTypeBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.util.List"%>
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
    <title>Pending Leave HrSide</title>
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
<style type="text/css">
.txt {
	text-align: center;
	line-height: 10vh;
}
</style>

<script type="text/javascript">
function deleteLeave(id,status) {
	
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("LeaveDelete?leave_id="+id+"&status="+status);
		}
			else
			{
				window.location.replace("leavesuccess.jsp");
				return false;
	 		}
}

</script>

</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
		int userId = 0;
		String emp_name = "";

		if (request.getParameter("employee_name") != null) {

			String value = request.getParameter("employee_name");

			String[] split = value.split(",");
			int emp_code = Integer.parseInt(split[0]);
			String name = split[1];
			emp_name = name;

			String[] splitName = name.split(" ");
			String firstName = splitName[0];
			String lastName = splitName[1];

			System.out.println("emp_code:" + emp_code);
			System.out.println("firstName:" + firstName);
			System.out.println("lastName:" + lastName);

			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);

			userId = employeeBean1.getEmployee_master_id();

		}

		String openStatus = "leave";
		if (request.getParameter("openStatus") != null) {
			openStatus = request.getParameter("openStatus");
		} else if (request.getAttribute("openStatus") != null) {
			openStatus = (String) request.getAttribute("openStatus");
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
										<h1 class="page-header">Leave / CO / OD Status</h1>
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
		<br>
	<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">
											Leave / CO / OD Status</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">

											<form action="employeeLeaveDetail.jsp">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-2">Select Employee Name</div>
														<div class="col-md-4">
															<input list="employee" class="form-control"
																name="employee_name" placeholder="Select Employee Code"
																value="<%=emp_name%>" required>
															<datalist id="employee"> <%
 	AllListDAO allListDAO = new AllListDAO();
 	List<EmployeeBean> listOfEmployee = allListDAO.getFullListOfEmployee();
 	for (EmployeeBean e : listOfEmployee) {
 %>
															<option
																value="<%=e.getEmployee_code() + "," + e.getFirstname() + " " + e.getLastname()%>" />
															<%
																}
															%> </datalist>
														</div>
														<div class="col-md-2">
															<input type="submit" class="btn btn-primary"
																name="submit" value="SUBMIT">
														</div>
													</div>
												</div>
											</form>

											<div class="panel-body">
												<!-- Nav tabs -->
												<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
													<%
														if (openStatus.equalsIgnoreCase("leave")) {
													%><li class="nav-item">
														<%
															} else {
														%>
													
													<li class="nav-item">
														<%
															}
														%> <a class="nav-link active" href="#leave" data-toggle="tab">Leave</a>
													</li>
													<%
														if (openStatus.equalsIgnoreCase("co")) {
													%><li class="nav-item">
														<%
															} else {
														%>
													
													<li class="nav-item">
														<%
															}
														%><a class="nav-link" href="#co" data-toggle="tab">CO</a>
													</li>
													<%
														if (openStatus.equalsIgnoreCase("od")) {
													%><li class="nav-item">
														<%
															} else {
														%>
													
													<li class="nav-item"> 
														<%
															}
														%><a class="nav-link" href="#od" data-toggle="tab">OD</a>
													</li>
													<%
														if (openStatus.equalsIgnoreCase("totalreport")) {
													%><li class="nav-item">
														<%
															} else {
														%>
													
													<li class="nav-item">
														<%
															}
														%><a class="nav-link" href="#totalreport" data-toggle="tab">Total
															Count</a>
													</li>
												</ul>

												<!-- Tab panes -->
												<div class="tab-content">

													<!-- Leave Tab -->
													<%
														if (openStatus.equalsIgnoreCase("leave")) {
													%>
													<div class="tab-pane fade in active" id="leave">
														<%
															} else {
														%>
														<div class="tab-pane fade" id="leave">
															<%
																}
															%>
															<br>
															<h4>Leave</h4>
															<div class="row">
																<div class="col-lg-12">
																	<div class="panel panel-default ">
																		<div class="panel-body">
																			<div class="dataTable_wrapper">
																				<div class="table-responsive">
																					<table
																						class="table table-striped table-bordered table-hover"
																						id="">
																						<thead>
																							<tr>
																								<th style="text-align: center">No</th>
																								<th style="text-align: center">From Date</th>
																								<th style="text-align: center">To Date</th>
																								<th style="text-align: center">Total Day</th>
																								<th style="text-align: center" colspan="2">Applied
																									Leave Adjusted From</th>
																								<th style="text-align: center" width="160px">Submission
																									Date</th>
																								<th style="text-align: center" width="160px">Approval/Rejected
																									Date</th>
																								<th style="text-align: center" width="160px">Status</th>
																								<th style="text-align: center">Action</th>
																							</tr>
																						</thead>

																						<%
																							AllLMSListDAO allLMSListDAO = new AllLMSListDAO();

																							List<LeaveBean> r = allLMSListDAO.getLeaveByEmpId1(userId);
																							for (int i = 0; i < r.size(); i++) {
																								LeaveBean leaveBean = r.get(i);
																								int id = leaveBean.getLeave_id();
																								LeaveCancelRequestBean leaveCancelRequestBean = allLMSListDAO.getCancelLeaveById(id);
																								Date date = new Date();

																								String Leave_From = leaveBean.getLeave_From();
																								String Leave_To = leaveBean.getLeave_To();
																								Date result1 = null;
																								Date result2 = null;

																								try {
																									SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
																									result1 = formater1.parse(Leave_From);
																									result2 = formater1.parse(Leave_To);
																									SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
																									Leave_From = formater2.format(result1);
																									Leave_To = formater2.format(result2);
																									System.out.println("Leave From Date " + Leave_From);
																									System.out.println("Leave TO Date " + Leave_To);
																								} catch (ParseException e1) {
																									e1.printStackTrace();
																								}
																						%>
																						<tbody>
																							<tr align="Center">
																								<td><div class="txt">
																										<%=i + 1%>
																									</div></td>
																								<td>
																									<div class="txt"><%=Leave_From%></div>
																								</td>
																								<td>
																									<div class="txt"><%=Leave_To%></div>
																								</td>
																								<td><div class="txt">
																										<%=leaveBean.getDay_count()%>
																									</div></td>
																								<%
																									List<LeavecutBalance> l = (ArrayList) allLMSListDAO.getListOfCutLeave(id);

																										for (LeavecutBalance c : l) {
																								%>
																								<td align="right">
																									<p align="right">CO</p>
																									<p>PL</p>
																									<p>UPL</p>
																									</center>
																									<p>LWP</p>

																								</td>
																								<td>
																									<p><%=c.getCO()%></p>
																									<p><%=c.getPL()%></p>
																									<p><%=c.getSL()%></p>
																									<p><%=c.getLWP()%></p>
																								</td>
																								<%
																									}
																								%>
																								<td><div class="txt">
																										<%
																											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
																												Date date1 = formater.parse(leaveBean.getSubmission_date());
																												SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
																												String sd = formater1.format(date1);
																										%>
																										<%=sd%></div></td>
																								<td><div class="txt">
																										<%
																											if (leaveBean.getApproval_rejected_date() != null) {
																													Date date2 = formater.parse(leaveBean.getApproval_rejected_date());
																													String rd = formater1.format(date2);
																										%>
																										<div class="txt"><%=rd%></div>
																										<%
																											} else {
																										%>
																										----
																										<%
																											}
																										%>
																									</div></td>
																								<td>

																									<div class="txt">
																										<%
																											if (leaveBean.getStatus().equalsIgnoreCase("Pending")) {
																										%>
																										<font color="blue">Pending</font>
																										<%
																											}
																												if (leaveBean.getStatus().equalsIgnoreCase("approved")) {
																													if (leaveCancelRequestBean != null) {
																														if (leaveCancelRequestBean.getApproved_status().equalsIgnoreCase("pending")
																																&& leaveCancelRequestBean.getLeave_cancel_type() == 1) {
																										%>
																										<font color="blue">Cancellation pending</font>
																										<%
																											} else if (leaveCancelRequestBean.getApproved_status().equalsIgnoreCase("rejected")
																																&& leaveCancelRequestBean.getLeave_cancel_type() == 1) {
																										%>
																										<font color="red">Rejected Cancellation</font>
																										<%
																											} else if (leaveCancelRequestBean.getApproved_status().equalsIgnoreCase("pending")
																																&& leaveCancelRequestBean.getLeave_cancel_type() == 2) {
																										%>
																										<font color="blue">Updation pending</font>
																										<%
																											} else if (leaveCancelRequestBean.getApproved_status().equalsIgnoreCase("rejected")
																																&& leaveCancelRequestBean.getLeave_cancel_type() == 2) {
																										%>
																										<font color="red">Rejected Updation</font>
																										<%
																											} else {
																										%>
																										<font color="green">Approved</font>
																										<%
																											}
																													} else {
																										%>
																										<font color="green">Approved</font>
																										<%
																											}
																												}
																										%>
																										<%
																											if (leaveBean.getStatus().equalsIgnoreCase("rejected")) {
																										%>
																										<font color="red">Rejected</font>
																										<%
																											}
																												if (leaveBean.getStatus().equalsIgnoreCase("cancelled")) {
																										%>
																										<font color="brown">Cancelled</font>
																										<%
																											}
																										%>
																									</div>
																								</td>

																								<td>
																									<div class="txt">
																										<%
																											if (leaveBean.getStatus().equalsIgnoreCase("Pending")
																														|| leaveBean.getStatus().equalsIgnoreCase("rejected")) {
																										%>
																										<p>
																											<a
																												href="Myleave?leave_id=<%=leaveBean.getLeave_id()%>&status=<%=leaveBean.getStatus()%>"><i
																												class=" icon-edit2"
																												data-toggle="tooltip" data-placement="top"
																												title="Update Leave"></i></a>
																										</p>
																										<p>
																											<i class="icon-trash-a"
																												data-toggle="tooltip"
																												id="<%=leaveBean.getStatus()%>"
																												data-placement="top" title="Cancel Leave"
																												style="color: red;"
																												onclick="deleteLeave(<%=leaveBean.getLeave_id()%>,this.id)"></i>
																										</p>

																										<%
																											} else if (leaveBean.getStatus().equalsIgnoreCase("approved")) {
																										%>
																										<%
																											if (!date.after(result1)) {
																										%>
																										<p>
																											<i class="icon-trash-a"
																												data-toggle="tooltip"
																												id="<%=leaveBean.getStatus()%>"
																												data-placement="top" title="Cancel Leave"
																												style="color: red;"
																												onclick="deleteLeave(<%=leaveBean.getLeave_id()%>,this.id)"></i>
																										</p>
																										<p>
																											<a
																												href="Myleave?leave_id=<%=leaveBean.getLeave_id()%>&status=<%=leaveBean.getStatus()%>"><i
																												class=" icon-edit2"
																												data-toggle="tooltip" data-placement="top"
																												title="Update Leave"></i></a>
																										</p>
																										<%
																											} else {
																														if (leaveCancelRequestBean == null) {
																										%>
																										<p>
																											<a href="" data-toggle="modal"
																												data-target="#myModal<%=leaveBean.getLeave_id()%>"><i
																												class="icon-trash-a"
																												data-toggle="tooltip"
																												id="<%=leaveBean.getStatus()%>"
																												data-placement="top" title="Cancel Leave"
																												style="color: red;"></i></a>
																										</p>
																										<p>
																											<a
																												href="Myleave?leave_id=<%=leaveBean.getLeave_id()%>&status=<%=leaveBean.getStatus()%>&action=afterApprove"><i
																												class=" icon-edit2"
																												data-toggle="tooltip" data-placement="top"
																												title="Update Leave"></i></a>
																										</p>
																										<%
																											}
																													}
																										%>
																										<%
																											}
																										%>
																									</div>
																								</td>
																							</tr>
																						</tbody>

																						<div class="modal fade"
																							id="myModal<%=leaveBean.getLeave_id()%>"
																							tabindex="-1" role="dialog"
																							aria-labelledby="myModalLabel" aria-hidden="true">
																							<div class="modal-dialog">
																								<div class="modal-content">
																									<div class="modal-header">
																										<button type="button" class="close"
																											data-dismiss="modal" aria-hidden="true">&times;</button>
																										<h4 class="modal-title" id="myModalLabel">Reason</h4>
																									</div>
																									<form action="cancelLeaveInsert">
																										<div class="modal-body">
																											<input type="hidden" name="leave_id"
																												value="<%=leaveBean.getLeave_id()%>">
																											<textarea class="form-control" rows="3"
																												name="remarks" id="remarks" required></textarea>
																										</div>
																										<div class="modal-footer">
																											<input type="submit" class="btn btn-primary"
																												name="button" value="SUBMIT">
																											<button type="button" class="btn btn-danger"
																												data-dismiss="modal">CLOSE</button>
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
																				<h5>
																					<b>Legends :&nbsp;</b>
																				</h5>
																				<i class="icon-edit2"
																					style="color: #337ab7;"></i><b> : Update Leave
																				</b> &nbsp;&nbsp;&nbsp;<i
																					class="icon-trash-a"
																					style="color: red;"></i><b> : Cancel Leave </b>
																				&nbsp;&nbsp;&nbsp;

																			</div>
																		</div>
																	</div>
																</div>
															</div>

														</div>



														<!-- CO Tab -->
														<%
															if (openStatus.equalsIgnoreCase("co")) {
														%>
														<div class="tab-pane fade in active" id="co">
															<%
																} else {
															%>
															<div class="tab-pane fade" id="co">
																<%
																	}
																%>
																<br>
																<h4>Compensatory Off</h4>
																<div class="row">
																	<div class="col-lg-12">
																		<div class="panel panel-default">
																			<div class="panel-body">
																				<div class="dataTable_wrapper">
																					<div class="table-responsive">
																						<table
																							class="table table-striped table-bordered table-hover"
																							id="dataTables-example2">
																							<thead>
																								<tr>
																									<th style="text-align: center">Date</th>
																									<th style="text-align: center">Start Time
																									</th>
																									<th style="text-align: center">End Time</th>
																									<th style="text-align: center">Total Hours
																									</th>
																									<th style="text-align: center">Total CO
																										Added</th>
																									<th style="text-align: center">Status</th>
																									<th style="text-align: center">Action</th>
																								</tr>
																							</thead>
																							<%
																								List<LeaveCOBean> co = allLMSListDAO.getCOByEmpId1(userId);
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

																							<tbody>
																								<tr align="Center">
																									<td><%=start%></td>
																									<td><%=c.getStart_time()%></td>
																									<td><%=c.getEnd_time()%></td>
																									<td><%=c.getTotal_Hours()%></td>
																									<td>
																										<%
																											if (c.getTotal_Hours() > 4) {
																										%> <font color="Red"> 1.0 </font> <%
 	} else if (c.getTotal_Hours() > 2 && c.getTotal_Hours() <= 4) {
 %> <font color="Red"> 0.5 </font> <%
 	} else if (c.getTotal_Hours() <= 2) {
 %> <font color="Red"> 0.0 </font> <%
 	}
 %>
																									</td>
																									<td>
																										<%
																											if (c.getStatus().equalsIgnoreCase("Pending")) {
																										%>
																										<font color="blue">Pending</font> <%
 	} else if (c.getStatus().equalsIgnoreCase("approved")) {
 %>
																										<font color="green">Approved</font> <%
 	} else if (c.getStatus().equalsIgnoreCase("rejected")) {
 %>
																										<font color="red">Rejected</font> <%
 	} else if (c.getStatus().equalsIgnoreCase("cancelled")) {
 %>
																										<font color="orange">Cancelled</font> <%
 	}
 %>

																									</td>
																									<td>
																										<%
																											if (c.getStatus().equalsIgnoreCase("pending") || c.getStatus().equalsIgnoreCase("rejected")) {
																										%>
																										<a
																										href="LeaveCOEmployeeShow?CO_ID=<%=c.getCO_ID()%>&status=Pending"><i
																											class="icon-edit2"></i></a> <i
																										class="icon-trash-a"
																										onclick="deleteCO(<%=c.getCO_ID()%>);"
																										style="color: red;"></i> <%
 	}
 %>
																									</td>
																								</tr>

																							</tbody>
																							<%
																								}
																							%>
																						</table>
																					</div>
																					<h5>
																						<b>Legends :&nbsp;</b>
																					</h5>
																					<i class="icon-eye4"
																						style="color: #337ab7;"></i><b> : View CO </b>
																					&nbsp;&nbsp;&nbsp;<i
																						class=" icon-trash-a"
																						style="color: red;"></i><b> : Cancel CO </b>
																					&nbsp;&nbsp;&nbsp;

																				</div>
																			</div>
																		</div>
																	</div>
																</div>

															</div>



															<!-- OD Tab -->
															<%
																if (openStatus.equalsIgnoreCase("od")) {
															%>
															<div class="tab-pane fade in active" id="od">
																<%
																	} else {
																%>
																<div class="tab-pane fade" id="od">
																	<%
																		}
																	%>
																	<br>
																	<h4>OutDoor Duty</h4>
																	<div class="row">
																		<div class="col-lg-12">
																			<div class="panel panel-default">
																				<div class="panel-body">
																					<div class="dataTable_wrapper">
																						<div class="table-responsive">
																							<table
																								class="table table-striped table-bordered table-hover"
																								id="dataTables-example3">
																								<thead>
																									<tr>
																										<th style="text-align: center">From Date</th>
																										<th style="text-align: center">To Date</th>
																										<th style="text-align: center">Start Time
																										</th>
																										<th style="text-align: center">End Time</th>
																										<th style="text-align: center">Total Day
																										</th>
																										<th style="text-align: center">Status</th>
																										<th style="text-align: center">Action</th>
																									</tr>
																								</thead>
																								<%
																									List<LeaveODBean> d = allLMSListDAO.getODByEmpId1(userId);
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

																								<tbody>
																									<tr align="Center">
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
																											%>
																											<%=od.getOD_EndTime()%> <%
 	}
 %>
																										</td>
																										<td><%=od.getOD_TotalDay()%></td>

																										<td>
																											<%
																												if (od.getStatus().equalsIgnoreCase("Pending")) {
																											%>
																											<font color="blue">Pending</font> <%
 	} else if (od.getStatus().equalsIgnoreCase("approved")) {
 %>
																											<font color="green">Approved</font> <%
 	} else if (od.getStatus().equalsIgnoreCase("rejected")) {
 %>
																											<font color="red">Rejected</font> <%
 	} else if (od.getStatus().equalsIgnoreCase("cancelled")) {
 %>
																											<font color="orange">Cancelled</font> <%
 	}
 %>
																										</td>
																										<td>
																											<%
																												if (od.getStatus().equalsIgnoreCase("pending")) {
																											%>
																											<a
																											href="LeaveODEmployeeShow?OD_ID=<%=od.getOD_ID()%>&status=Pending"><i
																												class="icon-edit2"></i></a> <i
																											class="icon-trash-a"
																											onclick="deleteOD(<%=od.getOD_ID()%>);"
																											style="color: red;"></i> <%
 	}
 %>
																										</td>
																									</tr>

																								</tbody>
																								<%
																									}
																								%>
																							</table>
																						</div>
																						<h5>
																							<b>Legends :&nbsp;</b>
																						</h5>
																						<i class="icon-eye4"
																							style="color: #337ab7;"></i><b> : View OD </b>
																						&nbsp;&nbsp;&nbsp;<i
																							class=" icon-trash-a"
																							style="color: red;"></i><b> : Cancel OD </b>
																						&nbsp;&nbsp;&nbsp;

																					</div>
																				</div>
																			</div>
																		</div>
																	</div>

																</div>


																<!-- TOTAL COUNT  Tab -->
																<%
																	if (openStatus.equalsIgnoreCase("totalreport")) {
																%>
																<div class="tab-pane fade in active" id="totalreport">
																	<%
																		} else {
																	%>
																	<div class="tab-pane fade" id="totalreport">
																		<%
																			}
																		%>
																		<br>
																		<h4>Total Count Report</h4>
																		<div class="row">
																			<div class="col-lg-12">
																				<div class="panel panel-default">
																					<div class="panel-body">
																						<div class="dataTable_wrapper">
																							<div class="table-responsive">
																								<table
																									class="table table-striped table-bordered table-hover"
																									id="dataTables-example">
																									<!-- id="dataTables-example" -->
																									<tr>
																										<th style="text-align: center">Type Of
																											Leave</th>
																										<th style="text-align: center">Leave
																											Balance (Day's)</th>

																									</tr>
																									<%
																										if (userId != 0) {
																											AllLMSListDAO gradeMasterList1 = new AllLMSListDAO();
																											List<LeaveTypeBean> listOfleave1 = gradeMasterList1.getListOfLeave();

																											LeaveBalanceBean leaveBalanceBean = (LeaveBalanceBean) gradeMasterList1.getleaveListbyEMP(userId);
																											double Co_Leave = leaveBalanceBean.getCO();
																											double Plan_Leave = leaveBalanceBean.getPlan_Leave();
																											double unplan_Leave = leaveBalanceBean.getUnplan_Leave();
																											double LWP = leaveBalanceBean.getLeave_without_pay();
																											double MT = 0;
																											for (LeaveTypeBean c : listOfleave1)

																											{

																												if (user.getMarital_status().equalsIgnoreCase("married")
																														&& user.getGender().equalsIgnoreCase("female")) {
																									%>
																									<tr align="Center">

																										<%
																											String p = c.getLeave_name();
																										%>
																										<td align="Center"><%=c.getLeave_name()%>
																										</td>
																										<%
																											if (p.equalsIgnoreCase("Plan Leave")) {
																										%>
																										<td><%=Plan_Leave%></td>
																										<%
																											}
																										%>
																										<%
																											if (p.equalsIgnoreCase("Unplan Leave")) {
																										%>
																										<td><%=unplan_Leave%></td>
																										<%
																											}
																										%>
																										<%
																											if (p.equalsIgnoreCase("CO")) {
																										%>
																										<td><%=Co_Leave%></td>
																										<%
																											}
																										%>
																										<%
																											if (p.equalsIgnoreCase("Leave without pay")) {
																										%>
																										<td><%=LWP%></td>
																										<%
																											}
																										%>
																										<%
																											if (p.equalsIgnoreCase("Maternity Leave")) {
																										%>
																										<td><%=MT%></td>
																										<%
																											}
																										%>
																									</tr>

																									<%
																										} else {
																													if (c.getLeave_type_id() != 5) {
																									%>
																									<tr align="Center">
																										<%
																											String p = c.getLeave_name();
																										%>
																										<td><%=c.getLeave_name()%></td>
																										<%
																											if (p.equalsIgnoreCase("Plan Leave")) {
																										%>
																										<td colspan="4"><%=Plan_Leave%></td>
																										<%
																											}
																										%>
																										<%
																											if (p.equalsIgnoreCase("Unplan Leave")) {
																										%>
																										<td colspan="4"><%=unplan_Leave%></td>
																										<%
																											}
																										%>
																										<%
																											if (p.equalsIgnoreCase("CO")) {
																										%>
																										<td colspan="4"><%=Co_Leave%></td>
																										<%
																											}
																										%>
																										<%
																											if (p.equalsIgnoreCase("Leave without pay")) {
																										%>
																										<td colspan="4"><%=LWP%></td>
																										<%
																											}
																										%>

																									</tr>
																									<%
																										}
																												}
																											}
																										}
																									%>

																								</table>

																								<br>

																								<%
																									List<LeaveCOBean> coadd = allLMSListDAO.getCOByEmpId1(userId);

																									String status = null;
																									double totalcoadd = 0, getco = 0, gethours = 0, getfullCO = 0, totalfinalco = 0;
																									int count = 0;
																									for (LeaveCOBean cd : coadd) {
																										status = cd.getStatus();

																										if (status.equals("approved")) {
																											getco = cd.getTotal_Hours();
																											if (getco > 4) {
																												getfullCO = getfullCO + 1;
																												totalfinalco = totalfinalco + 1;
																											} else if (getco > 2 && getco <= 4) {
																												totalcoadd = totalcoadd + 0.5;
																												count = count + 1;
																												totalfinalco = totalfinalco + 0.5;
																											} else if (getco <= 2) {
																												//totalcoadd = totalcoadd + 0.0;
																												totalfinalco = totalfinalco + 0.0;
																											}
																										}
																									}
																								%>


																								<table
																									class="table table-striped table-bordered table-hover"
																									id="">
																									<thead>
																										<tr>
																											<th style="text-align: center">No</th>
																											<th style="text-align: center">FUll CO</th>
																											<th style="text-align: center">Half CO</th>
																											<th style="text-align: center">Total
																												Count</th>

																										</tr>
																										<tr align="Center">
																											<th style="text-align: center">1</th>
																											<th style="text-align: center"><%=getfullCO%></th>
																											<th style="text-align: center"><%=count%>
																												X <%=totalcoadd%></th>
																											<th style="text-align: center"><%=totalfinalco%></th>
																										</tr>


																									</thead>
																								</table>




																							</div>
																						</div>
																						<!-- /.panel-body -->
																					</div>
																					<!-- /.panel -->
																				</div>
																				<!-- /.col-lg-12 -->
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
	
	<!--END PAGE LEVEL SCRIPTS -->
</body>
</html>