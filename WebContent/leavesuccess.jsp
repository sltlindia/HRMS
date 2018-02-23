<%@page import="java.lang.System"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="shortcut icon" sizes="152x152" href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<%@include file="header.jsp"%>
<title>Leave Status</title>
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



function deleteOD(id) {
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("odDelete?OD_id="+id);
		}
			else
			{
	 		}
}


function deleteCO(id) {
	var retVal = confirm("Are you sure?");
	if( retVal == true )
		{
		window.location.replace("coDelete?CO_id="+id);
		}
			else
			{
	 		}
}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
	<%
		int userId = user.getEmployee_master_id();
		double CoADD = 0;
		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
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
 	double sundayco = 0, holidayco = 0, tempsunco = 0, tempholico = 0, totalco = 0;
 	List<LeaveODBean> coholiday = allLMSListDAO.getSUNHOLICO(userId);

 	for (LeaveODBean coho : coholiday) {
 		sundayco = sundayco + coho.getSundayCOadd();
 		holidayco = holidayco + coho.getHolidayCOadd();

 		System.out.println("sunday " + sundayco + " holidy " + holidayco);
 		totalco = sundayco + holidayco;

 		//System.out.println("TOTAL " + totalco);
 	}

 	List<LeaveCOBean> coadd = allLMSListDAO.getCOByEmpId1(userId);

 	String status = null;
 	double totalcoadd = 0, getco = 0, gethours = 0;
 	for (LeaveCOBean cd : coadd) {
 		status = cd.getStatus();

 		if (status.equals("approved")) {
 			getco = cd.getTotal_Hours();
 			if (getco > 4) {
 				totalcoadd = totalcoadd + 1;
 			} else if (getco > 2 && getco <= 4) {
 				totalcoadd = totalcoadd + 0.5;
 			} else if (getco <= 2) {
 				totalcoadd = totalcoadd + 0.0;
 			}
 		}
 	}

 	//System.out.println("TOTAL CO " + totalcoadd);
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
				               				<h4 class="card-title" id="horz-layout-basic">Leave/CO/OD Status</h4>
				                		</div>
				            		</div>
				
										<div class="card-body collapse in">
	 									  <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
												
												<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
													<%
														if (openStatus.equalsIgnoreCase("leave")) {
													%>
													<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#leave"
														aria-controls="homeIcon" aria-expanded="true"><i
															class="icon-ios-compose"></i> Leave</a></li>
													<%
														} else {
													%>

													<li class="nav-item"><a class="nav-link"
														id="homeIcon-tab" data-toggle="tab" href="#leave"
														aria-controls="homeIcon" aria-expanded="false"><i
															class="icon-ios-compose"></i> Leave</a></li>
													<%
														}
													%>

													<%
														if (openStatus.equalsIgnoreCase("co")) {
													%>
													<li class="nav-item"><a class="nav-link active"
														id="profileIcon-tab" data-toggle="tab" href="#co"
														aria-controls="profileIcon" aria-expanded="true"><i
															class="icon-user-plus"></i> CO</a></li>
													<%
														} else {
													%>
													<li class="nav-item"><a class="nav-link"
														id="profileIcon-tab" data-toggle="tab" href="#co"
														aria-controls="profileIcon" aria-expanded="false"><i
															class="icon-user-plus"></i> CO</a></li>

													<%
														}
													%>
													<%
														if (openStatus.equalsIgnoreCase("od")) {
													%>
													<li class="nav-item dropdown"><a
														class="nav-link active" data-toggle="tab" href="#od"
														role="button" aria-haspopup="true" aria-expanded="true"><i
															class="icon-android-list"></i> OD</a></li>
													<%
														} else {
													%>
													<li class="nav-item dropdown"><a class="nav-link"
														data-toggle="tab" href="#od" role="button"
														aria-haspopup="true" aria-expanded="false"><i
															class="icon-android-list"></i> OD</a></li>
													<%
														}
													%>
												</ul>
												<hr>
												<div class="tab-content px-1 pt-1">
													<%
														if (openStatus.equalsIgnoreCase("leave")) {
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
															<br>
															<h4>
																<i class="icon-ios-compose"></i> Leave
															</h4>
															<div class="row">
																<div class="col-lg-12">
																	<div class="panel panel-default ">
																		<div class="panel-body">
																			<div class="dataTable_wrapper">
																					<table
																						class="table table-striped table-bordered table-hover file-export">
																						<thead>
																							<tr>
																								<th style="text-align: center">No</th>
																								<th style="text-align: center">From Date</th>
																								<th style="text-align: center">To Date</th>
																								<th style="text-align: center">Total Day</th>
																								<th style="text-align: center" colspan="2">Count</th>
																								<th style="text-align: center" width="180px">Submission Date</th>
																								<th style="text-align: center" width="160px">Approval/Rejected 	Date</th>
																								<th style="text-align: center" width="110px">Status</th>
																								<th style="text-align: center">Action</th>
																							</tr>
																						</thead>

																						<%
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
																												class="icon icon-edit2"
																												data-toggle="popover" data-placement="top"
																												title="Update Leave"></i></a>
																										</p>
																										<p>
																											<i class="icon-trash-a"
																												data-toggle="popover"
																												id="<%=leaveBean.getStatus()%>"
																												data-placement="top" title="Cancel Leave"
																												style="color: red; cursor: pointer;"
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
																												data-toggle="popover"
																												id="<%=leaveBean.getStatus()%>"
																												data-placement="top" title="Cancel Leave"
																												style="color: red; cursor: pointer;"
																												onclick="deleteLeave(<%=leaveBean.getLeave_id()%>,this.id)"></i>
																										</p>
																										<p>
																											<a
																												href="Myleave?leave_id=<%=leaveBean.getLeave_id()%>&status=<%=leaveBean.getStatus()%>"><i
																												class="icon icon-edit2"
																												data-toggle="popover" data-placement="top"
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
																												data-toggle="popover"
																												id="<%=leaveBean.getStatus()%>"
																												data-placement="top" title="Cancel Leave"
																												style="color: red;"></i></a>
																										</p>
																										<p>
																											<a
																												href="Myleave?leave_id=<%=leaveBean.getLeave_id()%>&status=<%=leaveBean.getStatus()%>&action=afterApprove"><i
																												class="icon icon-edit2"
																												data-toggle="popover" data-placement="top"
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
																				<h5>
																					<b>Legends :&nbsp;</b>
																				</h5>
																				<i class="icon icon-edit2" style="color: #337ab7;"></i><b>
																					: Update Leave </b> &nbsp;&nbsp;&nbsp;<i
																					class="icon-trash-a" style="color: red;"></i><b>
																					: Cancel Leave </b> &nbsp;&nbsp;&nbsp;

																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<%
															if (openStatus.equalsIgnoreCase("co")) {
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
																<br>
																<div class="row">
																	<div class="col-md-6">
																		<h4>Compensatory Off</h4>
																	</div>
																	<div class="col-md-6" align="right">
																		<div>
																			<b>CO added by OD : <%=totalco%>
																			</b>
																		</div>
																		<div>
																			<b>Total CO : <%=totalcoadd%>
																			</b>
																		</div>
																	</div>

																</div>
																<div class="row">
																	<div class="col-lg-12">
																		<div class="panel panel-default">
																			<div class="panel-body">
																				<div class="dataTable_wrapper">
																						<table
																							class="table table-striped table-bordered table-hover zero-configuration">
																							<thead>
																								<tr>
																									<th style="text-align: center">Date</th>
																									<th style="text-align: center">Start Time</th>
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
																										%> <font color="blue">Pending</font> <%
 	} else if (c.getStatus().equalsIgnoreCase("approved")) {
 %> <font color="green">Approved</font> <%
 	} else if (c.getStatus().equalsIgnoreCase("rejected")) {
 %> <font color="red">Rejected</font> <%
 	} else if (c.getStatus().equalsIgnoreCase("cancelled")) {
 %> <font color="orange">Cancelled</font> <%
 	}
 %>

																									</td>
																									<td>
																										<%
																											if (c.getStatus().equalsIgnoreCase("pending") || c.getStatus().equalsIgnoreCase("rejected")) {
																										%> <a
																										href="LeaveCOEmployeeShow?CO_ID=<%=c.getCO_ID()%>&status=Pending"><i
																											class="icon icon-edit2" data-toggle="popover"></i></a> <i
																										class="icon-trash-a" onclick="deleteCO(<%=c.getCO_ID()%>);"
																										style="color: red; cursor: pointer;" data-toggle="popover"></i> <%
 	}
 %>
																									</td>
																								</tr>

																							</tbody>
																							<%
																								}
																							%>
																						</table>
																					<h5>
																						<b>Legends :&nbsp;</b>
																					</h5>
																					<i class="icon icon-eye4" style="color: #337ab7;"></i><b>
																						: View CO </b> &nbsp;&nbsp;&nbsp;<i
																						class=" icon-trash-a" style="color: red;"></i><b>
																						: Cancel CO </b> &nbsp;&nbsp;&nbsp;

																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<%
																if (openStatus.equalsIgnoreCase("od")) {
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
																	<br>
																	<h4>
																		<i class="icon-android-list"></i> OutDoor Duty
																	</h4>
																	<div class="row">
																		<div class="col-lg-12">
																			<div class="panel panel-default">
																				<div class="panel-body">
																					<div class="dataTable_wrapper">
																							<table
																								class="table table-striped table-bordered table-hover"
																								id="dataTables-example3">
																								<thead>
																									<tr>
																										<th style="text-align: center">From Date</th>
																										<th style="text-align: center">To Date</th>
																										<th style="text-align: center" width="200px">
																											Description</th>
																										<!-- <th style="text-align:center">End Time </th> -->
																										<th style="text-align: center">Total Day</th>
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
																										sundayco = od.getOD_TotalDay();
																										holidayco = od.getHolidayCOadd();

																										tempsunco = tempsunco + sundayco;
																										tempholico = tempholico + holidayco;

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
																												if (od.getDescription() == "") {
																											%> ----- <%
																												} else {
																											%>
																											<%--  <i class="icon-information-circled"
																											data-container="body" data-toggle="popover"
																											data-placement="top" title="Description"
																											data-content="<%=od.getDescription()%>">
																												<i></i>
																										</i> --%>
																										
																										<i class="icon-information-circled" data-container="body" data-toggle="popover" data-trigger="hover" data-placement="right" title="Description" data-content="<%=od.getDescription()%>"> <i></i> </i>
																										
																										 <%}%>
																										</td>
																										<%-- <td>
													<% if(od.getOD_EndTime() == ""){%>
													-----
													<%}else{%>
													<%= od.getOD_EndTime() %>
													<%} %>
   						 					</td>	 --%>
																										<td><%=od.getOD_TotalDay()%></td>

																										<td>
																											<%
																												if (od.getStatus().equalsIgnoreCase("Pending")) {
																											%> <font color="blue">Pending</font> <%
 	} else if (od.getStatus().equalsIgnoreCase("approved")) {
 %> <font color="green">Approved</font> <%
 	} else if (od.getStatus().equalsIgnoreCase("rejected")) {
 %> <font color="red">Rejected</font> <%
 	} else if (od.getStatus().equalsIgnoreCase("cancelled")) {
 %> <font color="orange">Cancelled</font> <%
 	}
 %>
																										</td>
																										<td>
																											<%
																												if (od.getStatus().equalsIgnoreCase("pending")) {
																											%> <a
																											href="LeaveODEmployeeShow?OD_ID=<%=od.getOD_ID()%>&status=Pending"><i
																												class="icon icon-edit2" data-toggle="popover"
																											data-placement="top" title="Edit"></i></a> 
																											
																											<i class="icon-trash-a" data-toggle="popover"
																											data-placement="top" title="Delete"
																											onclick="deleteOD(<%=od.getOD_ID()%>);"
																											style="color: red; cursor: pointer;"></i> <%
 	}
 %>
																										</td>
																									</tr>

																								</tbody>
																								<%
																									}
																								%>
																							</table>
																						<h5>
																							<b>Legends :&nbsp;</b>
																						</h5>
																						<i class="icon icon-eye4" style="color: #337ab7;"></i><b>
																							: View OD </b> &nbsp;&nbsp;&nbsp;<i
																							class="icon-trash-a" style="color: red;"></i><b>
																							: Cancel OD </b> &nbsp;&nbsp;&nbsp;<i
																							class="icon-android-list" style="color: #337ab7;"></i><b>
																						: Description of OD</b>

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

	<!-- BEGIN PAGE LEVEL JS-->
	<script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script type="text/javascript">
	
	 $('[data-toggle="popover"]').popover({
		    /* container: 'body'
		    	max-width: '600px'
		   		 width: 'auto' */
			});
	
	</script>
</body>
</html>