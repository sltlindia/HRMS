<%@page import="com.hrms.lms.bean.GatePassBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.grievancemanagement.bean.GrievanceQueryBean"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
<%@page import="com.hrms.recruitement.bean.ResumeDataBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.recruitement.bean.VacancyFormBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.recruitement.dao.AllRecruitmentListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gate Pass</title>
<%@include file="header.jsp"%>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>CUG List</title>
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
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		int manager_id = user.getManagerBean().getManager_id();
	%>
	<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
			<section id="file-export">
    			<div class="row">
        			<div class="col-xs-12">
            			<div class="card">
                			<div class="card-header">
                    			<div class="card box-shadow-0" data-appear="appear">
					        		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            		<div class="col-sm-6">
				               				<h4 class="card-title" id="horz-layout-basic">Gate Pass Status</h4>
				                		</div>
				            		</div>
	
								<%
									if (request.getAttribute("Success") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-success ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${Success}
									</div>
								</div>
								<%
									} else if (request.getAttribute("reject") != null) {
								%>
								<div id="panelbody" class="panel-body">
									<div class="alert alert-dismissable alert-danger ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${reject}
									</div>
								</div>
								<%
									}
								%>
				<div class="card-body collapse in">
	  				<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading"></div>
											<!-- /.panel-heading -->
											<div class="panel-body">
												<!-- Nav tabs -->
												<ul class="nav nav-tabs">
													<!-- Nav tabs -->
													<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#pending"
														aria-controls="homeIcon" aria-expanded="true"><i
															class="icon-ios-compose"></i> Pending</a></li>

													<li class="nav-item"><a class="nav-link"
														id="profileIcon-tab" data-toggle="tab" href="#approve"
														aria-controls="profileIcon" aria-expanded="false"><i
															class="icon-user-plus"></i> Approved</a></li>

													<li class="nav-item"><a class="nav-link"
														id="profileIcon-tab" data-toggle="tab" href="#reject"
														aria-controls="profileIcon" aria-expanded="false"><i
															class="icon-android-list"></i> Rejected</a></li>
												</ul>

												<!-- Tab panes -->
												<div class="tab-content px-1 pt-1">
													<div role="tabpanel" class="tab-pane fade active in"
														id="pending" aria-labelledby="homeIcon-tab"
														aria-expanded="true">
														<br>
														<h4>Pending Gate Pass</h4>
														<div class="panel-body">
															<div class="dataTable_wrapper">
																<div class="table-responsive">

																	<table
																		class="table table-striped table-bordered zero-configuration">
																		<thead>
																			<tr>
																				<th><center>Submission Date</center></th>
																				<th><center>Employee Code</center></th>
																				<th><center>Employee Name</center></th>
																				<th><center>Department</center></th>
																				<th><center>Type</center></th>
																				<th><center>Out Time</center></th>
																				<th><center>From</center></th>
																				<th><center>To</center></th>
																				<th colspan="3"><center>Action</center></th>
																			</tr>
																		</thead>

																		<tbody>

																			<%
																				AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
																				List<GatePassBean> listOfGatePass = null;
																				listOfGatePass = allLMSListDAO.getListOfPendingGatePassManagerWithOtherId(manager_id);
																				for (GatePassBean g : listOfGatePass) {

																					String date = g.getSubmission_date_time();
																					String[] split = date.split(" ");
																					String date1 = null;

																					try {
																						SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																						SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

																						Date result = formater.parse(split[0]);
																						date1 = AppDateFormat.format(result);

																						System.out.println(AppDateFormat.format(result));
																					} catch (ParseException e1) {
																						e1.printStackTrace();
																					}
																			%>
																			<tr>
																				<td><center><%=date1%></center></td>
																				<td><center><%=g.getEmployeeBean().getEmployee_code()%></center></td>
																				<td><center><%=g.getEmployeeBean().getFirstname() + " " + g.getEmployeeBean().getLastname()%></center>
																				<td><center><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></center></td>
																				<td><center><%=g.getPurpose_of_leave()%></center></td>
																				<td><center><%=g.getOut_time()%></center></td>
																				<td><center><%=g.getCompanyName()%></center></td>
																				<td><center><%=g.getTodec()%></center></td>
																				<td align="Center">&nbsp;&nbsp;<a
																					href="gatePassStatusUpdate?gate_pass_id=<%=g.getGate_pass_id()%>&status=Approved"><i
																						class="icon-checkmark"></i></a>
																				<a href=""
																					data-toggle="modal"
																					data-target="#myModal<%=g.getGate_pass_id()%>"><i
																						class="icon-close" style="color: red;"></i></a>
																				<a href=""
																					data-toggle="modal"
																					data-target="#myModalView<%=g.getGate_pass_id()%>"><i
																						class="icon icon-eye4"></i></a></td>


																			</tr>

																			<div class="modal fade"
																				id="myModal<%=g.getGate_pass_id()%>" tabindex="-1"
																				role="dialog" aria-labelledby="myModalLabel"
																				aria-hidden="true">
																				<div class="modal-dialog">
																					<div class="modal-content">
																						<div class="modal-header">
																							<button type="button" class="close"
																								data-dismiss="modal" aria-hidden="true">&times;</button>
																							<h4 class="modal-title" id="myModalLabel">Rejection
																								Reason</h4>
																						</div>
																						<form action="gatePassStatusUpdate" method="post">
																							<input type="hidden" name="gate_pass_id"
																								value="<%=g.getGate_pass_id()%>"> <input
																								type="hidden" name="status" value="Rejected">
																							<div class="modal-body">
																								<textarea class="form-control" name="reason"
																									placeholder="Type Rejection Reason"></textarea>
																							</div>

																							<div class="modal-footer">
																								<input type="submit" name="submit"
																									value="SUBMIT" class="btn btn-primary">
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

																		</tbody>
																	</table>
																</div>
															</div>
															<h4>
																<b>Legends :&nbsp;</b>
															</h4>
															<i class="fa fa-check" style="color: #337ab7;"></i><b>
																: Approve </b>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-close"
																style="color: red;"></i><b> : Reject </b>&nbsp;&nbsp;&nbsp;&nbsp;<i
																class="icon icon-eye4"
																style="color: #337ab7;"></i><b> : View Detail </b>
														</div>
													</div>





													<div role="tabpanel" class="tab-pane fade" id="approve"
														aria-labelledby="homeIcon-tab" aria-expanded="true">


														<br>
														<h4>Approved Gate Pass</h4>

														<div class="row">
															<div class="col-lg-12">


																<%--   ${delete } --%>
																<!-- /.panel-heading -->
																<div class="panel-body">
																	<div class="dataTable_wrapper">
																		<div class="table-responsive">

																			<table
																				class="table table-striped table-bordered zero-configuration">
																				<thead>
																					<tr>
																						<th><center>Submission Date</center></th>
																						<th><center>Employee Code</center></th>
																						<th><center>Employee Name</center></th>
																						<th><center>Department</center></th>
																						<th><center>Approved By</center></th>
																						<th><center>Type</center></th>
																						<th><center>Out Time</center></th>
																						<th><center>Status</center></th>
																						<th><center>Action</center></th>
																					</tr>
																				</thead>

																				<tbody>

																					<%
																						List<GatePassBean> listOfGatePass1 = null;
																						listOfGatePass1 = allLMSListDAO.getListOfAllGatePassManager(manager_id);
																						for (GatePassBean g : listOfGatePass1) {
																							String date = g.getSubmission_date_time();
																							String[] split = date.split(" ");
																							String date1 = null;
																							try {
																								SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																								SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

																								Date result = formater.parse(split[0]);
																								date1 = AppDateFormat.format(result);

																								System.out.println(AppDateFormat.format(result));
																							} catch (ParseException e1) {
																								e1.printStackTrace();
																							}
																					%>
																					<tr>
																						<td><center><%=date1%></center></td>
																						<td><center><%=g.getEmployeeBean().getEmployee_code()%></center></td>
																						<td><center><%=g.getEmployeeBean().getFirstname() + " " + g.getEmployeeBean().getLastname()%></center>
																						<td><center><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></center></td>
																						<td><center>
																								<%
																									int e_id = g.getApprove_ID();
																										if (e_id != 0) {
																											LoginDAO loginDAO = new LoginDAO();
																											EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(e_id);
																								%>
																								<%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%>
																								<%
																									} else {
																								%>
																								-----
																								<%
																									}
																								%>
																							</center></td>
																						<td><center><%=g.getPurpose_of_leave()%></center></td>
																						<td><center><%=g.getOut_time()%></center></td>
																						<td><center>
																								<b> <%
 	if (g.getStatus().equalsIgnoreCase("Approved")) {
 %> <font color="green"><%=g.getStatus()%></font> <%
 	} else if (g.getStatus().equalsIgnoreCase("In")) {
 %> <font color="#337ab7"><%=g.getStatus()%></font> <%
 	} else if (g.getStatus().equalsIgnoreCase("Out")) {
 %> <font color="red"><%=g.getStatus()%></font>
																									<%
																										}
																									%>
																								</b>
																							</center></td>
																						<td><center>
																								<a href="" data-toggle="modal"
																									data-target="#myModalView<%=g.getGate_pass_id()%>"><i
																									class="icon icon-eye4"></i></a>
																							</center></td>
																					</tr>


																					<%
																						}
																					%>

																				</tbody>
																			</table>
																		</div>
																		<!-- /.modal-content -->
																	</div>
																	<!-- /.modal-dialog -->
																	<h4>
																		<b>Legends :&nbsp;</b>
																	</h4>
																	<i class="icon icon-eye4"
																		style="color: #337ab7;"></i><b> : View Detail </b>
																</div>
															</div>
														</div>
													</div>

													<%
														List<GatePassBean> listOfFullGatePass = allLMSListDAO
																.getListOfAllGatePassByManager(user.getManagerBean().getManager_id());
														for (GatePassBean g : listOfFullGatePass) { //converstion of time 24 hours to 12 hours format

															String date = g.getSecurity_out_time();
															String date1 = g.getSecurity_in_time();
															String date2 = g.getSubmission_date_time();

															String sOutTime = "-------";
															String sInTime = "-------";
															String outTime = null;

															try {
																final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");

																if (g.getSecurity_out_time() != null) {

																	String[] split = date.split(" ");
																	final String time = split[1];
																	final Date dateObj = sdf.parse(time);
																	sOutTime = new SimpleDateFormat("K:mm a").format(dateObj);
																}
																if (g.getSecurity_in_time() != null) {
																	String[] split1 = date1.split(" ");
																	final String time1 = split1[1];
																	final Date dateObj1 = sdf.parse(time1);
																	sInTime = new SimpleDateFormat("K:mm a").format(dateObj1);
																}
																if (g.getSubmission_date_time() != null) {
																	String[] split2 = date2.split(" ");
																	outTime = split2[0];

																	try {
																		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																		SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

																		Date result = formater.parse(split2[0]);
																		outTime = AppDateFormat.format(result);

																		System.out.println(AppDateFormat.format(result));
																	} catch (ParseException e1) {
																		e1.printStackTrace();
																	}

																}
															} catch (final ParseException e) {
																e.printStackTrace();
															}
													%>
													<div class="modal fade"
														id="myModalView<%=g.getGate_pass_id()%>" tabindex="-1"
														role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content" style="width: 500px;">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">&times;</button>
																	<h4 class="modal-title" id="myModalLabel">Detail
																		Of Gate Pass</h4>
																</div>

																<div class="modal-body">
																	<%
																		int company_id = g.getEmployeeBean().getCompanyListBean().getCompany_list_id();
																			/* String company_name = null; */
																			if (company_id == 1) {
																				company_name = "SLTL";
																			} else if (company_id == 2) {
																				company_name = "SS";
																			} else if (company_id == 3) {
																				company_name = "S.HR";
																			} else if (company_id == 4) {
																				company_name = "COSMOS";
																			} else if (company_id == 5) {
																				company_name = "CSLASER";
																			} else if (company_id == 6) {
																				company_name = "SEZ";
																			} else if (company_id == 7) {
																				company_name = "CL";
																			}
																			if (company_id == 8) {
																				company_name = "App";
																			}
																	%>

																	<div class="row">
																		<div class="col-md-4" style="padding-right: 0px;">
																			<img
																				src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=g.getEmployeeBean().getEmployee_code()%>.bmp"
																				alt="User Avatar" height="130px" width="130px"
																				style="border: 1px solid black" />
																		</div>
																		<!-- ./col-md-4 -->
																		<div class="col-md-8" style="padding-right: 0px;">
																			<div class="row">
																				<div class="col-md-4" style="padding-right: 0px;">
																					<label>Employee Code</label>
																				</div>
																				<!-- ./col-md-4 -->
																				<div class="col-md-1" style="padding-right: 0px;">:
																				</div>
																				<!-- ./col-md-1 -->
																				<div class="col-md-7" style="padding-right: 0px;">
																					<label><%=g.getEmployeeBean().getEmployee_code()%></label>
																				</div>
																				<!-- ./col-md-7 -->
																			</div>
																			<!-- /.row -->

																			<br>
																			<div class="row">
																				<div class="col-md-4" style="padding-right: 0px;">
																					<label>Employee Name</label>
																				</div>
																				<!-- ./col-md-4 -->
																				<div class="col-md-1" style="padding-right: 0px;">:
																				</div>
																				<!-- ./col-md-1 -->
																				<div class="col-md-7" style="padding-right: 0px;">
																					<label><%=g.getEmployeeBean().getFirstname() + " " + g.getEmployeeBean().getLastname()%></label>
																				</div>
																				<!-- ./col-md-7 -->
																			</div>
																			<!-- /.row -->

																			<br>
																			<div class="row">
																				<div class="col-md-4" style="padding-right: 0px;">
																					<label>Department</label>
																				</div>
																				<!-- ./col-md-4 -->
																				<div class="col-md-1" style="padding-right: 0px;">:
																				</div>
																				<!-- ./col-md-1 -->
																				<div class="col-md-7" style="padding-right: 0px;">
																					<label><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></label>
																				</div>
																				<!-- /.col-md-7 -->
																			</div>
																			<!-- /.row -->

																			<br>
																			<div class="row">
																				<div class="col-md-4" style="padding-right: 0px;">
																					<label>Type</label>
																				</div>
																				<!-- ./col-md-4 -->
																				<div class="col-md-1" style="padding-right: 0px;">:
																				</div>
																				<!-- ./col-md-1 -->
																				<div class="col-md-7" style="padding-right: 0px;">
																					<label><%=g.getPurpose_of_leave()%></label>
																				</div>
																				<!-- /.col-md-7 -->
																			</div>
																			<!-- /.row -->
																		</div>
																		<!-- ./col-md-8 -->
																	</div>
																	<!-- /.row -->

																	<hr>


																	<br>
																	<div class="row">
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Purpose</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-9" style="padding-left: 0px;">
																			<%=g.getReason()%>
																		</div>
																		<!-- ./col-md-9 -->
																	</div>
																	<!-- ./row -->

																	<br>
																	<div class="row">
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Date</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-left: 0px;">
																			<%=outTime%>
																		</div>
																		<!-- ./col-md-3 -->
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Out Time</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-left: 0px;">
																			<%=g.getOut_time()%>
																		</div>
																		<!-- ./col-md-3 -->
																	</div>
																	<!-- ./row -->

																	<br>
																	<div class="row">
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>From</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%=g.getCompanyName()%>
																		</div>
																		<!-- ./col-md-3 -->
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>To</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%=g.getTodec()%>
																		</div>
																		<!-- ./col-md-3 -->
																	</div>
																	<!-- ./row -->

																	<br>
																	<div class="row">
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Source Out Time</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%=sOutTime%>
																		</div>
																		<!-- ./col-md-3 -->
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Source In Time</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%=sInTime%>
																		</div>
																		<!-- ./col-md-3 -->
																	</div>
																	<!-- ./row -->



																	<%
																		String destInTime = g.getDestination_in_time();
																			String destOutTime = g.getDestination_out_time();

																			String dInTime = "-------";
																			String dOutTime = "-------";
																			try {
																				final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");

																				if (g.getDestination_in_time() != null) {

																					String[] split1 = destInTime.split(" ");
																					final String time = split1[1];
																					final Date dateObj = sdf.parse(time);
																					dInTime = new SimpleDateFormat("K:mm a").format(dateObj);
																				}

																				if (g.getDestination_out_time() != null) {

																					String[] split1 = destOutTime.split(" ");
																					final String time = split1[1];
																					final Date dateObj = sdf.parse(time);
																					dOutTime = new SimpleDateFormat("K:mm a").format(dateObj);
																				}

																			} catch (final ParseException e) {
																				e.printStackTrace();
																			}
																	%>


																	<br>
																	<div class="row">
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Destination In Time</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%=dInTime%>
																		</div>
																		<!-- ./col-md-3 -->
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Destination Out Time</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%=dOutTime%>
																		</div>
																		<!-- ./col-md-3 -->
																	</div>
																	<!-- ./row -->


																	<br>
																	<div class="row">
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Approved By</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%
																				int e_id = g.getApprove_ID();
																					if (e_id != 0) {
																						LoginDAO loginDAO = new LoginDAO();
																						EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(e_id);
																			%>
																			<%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%>
																			<%
																				} else {
																			%>
																			-----
																			<%
																				}
																			%>
																		</div>
																		<!-- ./col-md-3 -->
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Status</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-3" style="padding-right: 0px;">
																			<%=g.getStatus()%>
																		</div>
																		<!-- ./col-md-3 -->
																	</div>
																	<!-- ./row -->

																	<%
																		if (g.getStatus().equalsIgnoreCase("Rejected")) {
																	%>
																	<br>
																	<div class="row">
																		<div class="col-md-2" style="padding-right: 0px;">
																			<label>Rejected Reason</label>
																		</div>
																		<!-- ./col-md-2 -->
																		<div class="col-md-1">:</div>
																		<!-- ./col-md-1 -->
																		<div class="col-md-9" style="padding-right: 0px;">
																			<%=g.getRejected_reason()%>
																		</div>
																		<!-- ./col-md-9 -->
																	</div>
																	<!-- ./row -->
																	<%
																		}
																	%>

																</div>

																<div class="modal-footer">

																	<button type="button" class="btn btn-danger"
																		data-dismiss="modal">CLOSE</button>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div>
													<%
														}
													%>



													<div role="tabpanel" class="tab-pane fade" id="reject"
														aria-labelledby="homeIcon-tab" aria-expanded="true">
														<br>
														<h4>Rejected Gate Pass</h4>

														<div class="panel-body">
															<div class="dataTable_wrapper">
																<div class="table-responsive">

																	<table
																		class="table table-striped table-bordered zero-configuration">
																		<thead>
																			<tr>
																				<th><center>Submission Date</center></th>
																				<th><center>Employee Code</center></th>
																				<th><center>Employee Name</center></th>
																				<th><center>Department</center></th>
																				<th><center>Type</center></th>
																				<th><center>Out Time</center></th>
																				<th><center>Status</center></th>
																				<th><center>Action</center></th>
																			</tr>
																		</thead>

																		<tbody>

																			<%
																				List<GatePassBean> listOfGatePass2 = null;
																				if (user.getRoleBean().getRole_authority().equals("M5")) {
																					listOfGatePass2 = allLMSListDAO.getListOfRejectedGatePassHR();
																				} else {
																					listOfGatePass2 = allLMSListDAO.getListOfRejectedGatePassManager(manager_id);
																				}
																				for (GatePassBean g : listOfGatePass2) {
																					String date = g.getSubmission_date_time();
																					String[] split = date.split(" ");
																					String date1 = null;
																					try {
																						SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																						SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

																						Date result = formater.parse(split[0]);
																						date1 = AppDateFormat.format(result);

																						System.out.println(AppDateFormat.format(result));
																					} catch (ParseException e1) {
																						e1.printStackTrace();
																					}
																			%>
																			<tr>
																				<td><center><%=date1%></center></td>
																				<td><center><%=g.getEmployeeBean().getEmployee_code()%></center></td>
																				<td><center><%=g.getEmployeeBean().getFirstname() + " " + g.getEmployeeBean().getLastname()%></center>
																				<td><center><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></center></td>
																				<td><center><%=g.getPurpose_of_leave()%></center></td>
																				<td><center><%=g.getOut_time()%></center></td>
																				<td><center>
																						<b><font color="red"><%=g.getStatus()%></font></b>
																					</center></td>
																				<td><center>
																						<a href="" data-toggle="modal"
																							data-target="#myModalView<%=g.getGate_pass_id()%>"><i
																							class="icon icon-eye4"></i></a>
																					</center></td>
																			</tr>

																			<%
																				}
																			%>

																		</tbody>
																	</table>
																</div>
															</div>
															<h4>
																<b>Legends :&nbsp;</b>
															</h4>
															<i class="icon icon-eye4"
																style="color: #337ab7;"></i><b> : View Detail </b>
														</div>



													</div>
												</div>
											</div>
											<!-- /.panel-body -->
										</div>
										<!-- /.panel -->
									</div>
									<!-- /.col-lg-6 -->
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

	<%
		for (GatePassBean g : listOfGatePass) {
	%>

	<%
		}
	%>
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
    <script src="app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe-ui-default.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
	<script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
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
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
</body>

<!-- Mirrored from pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template/dt-advanced-initialization.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 09 Aug 2017 08:52:11 GMT -->
</html>