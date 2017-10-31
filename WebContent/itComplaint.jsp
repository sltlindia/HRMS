<%@page import="java.text.ParseException"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.selfservice.bean.ProblemNatureBean"%>
<%@page import="org.directwebremoting.extend.AllScriptSessionFilter"%>
<%@page import="com.hrms.selfservice.bean.ProblemNatureReplyBean"%>
<%@page import="com.hrms.selfservice.bean.ComplaintVerifiedByBean"%>
<%@page import="com.hrms.selfservice.bean.DownloadBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.selfservice.bean.ComplaintBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.selfservice.dao.AllInsertSelfServiceDAO"%>
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
<title>It Complaint</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/images/ico/apple-icon-60.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="app-assets/images/ico/apple-icon-76.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="app-assets/images/ico/apple-icon-120.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="app-assets/images/ico/apple-icon-152.png">
<link rel="shortcut icon" type="image/x-icon"
	href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
<link rel="shortcut icon" type="image/png"
	href="app-assets/images/ico/favicon-32.png">
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
	href="app-assets/vendors/css/extensions/sweetalert.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">

<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<%@include file="header.jsp"%>
</head>

<script type="text/javascript">
function demo(complaint_id){
	var retVal = confirm("Are you sure?");
		if( retVal == true )
			{
			window.location.replace("complaintHide?complaint_id="+complaint_id);
			}
				else
  			{
 				window.location.replace("itComplaint.jsp"); 
  				return false;
		 		}
}
</script>
<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script> -->
<title>SLTL HRMS</title>

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
        	<%AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
			int employee_id = user.getEmployee_master_id();
			int manager_id = user.getManagerBean().getManager_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
			List<ComplaintBean> listOfComplaint = null;
			if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
				listOfComplaint = allListSelfServiceDAO.getcomplaintList();
			} else {
				listOfComplaint = allListSelfServiceDAO.getcomplaintList();
			}

			for (ComplaintBean c1 : listOfComplaint) {%>
                $('#date_of_resolve'+<%=c1.getComplaint_id()%>).datepicker({
                    dateFormat: 'yy-mm-dd'
                });
            <%}%>
        })
    }
</script>




</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns ">

	<%
		int problem_nature_id = 0;
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
										<h4 class="page-header"></h4>
									</div>
								</div>
								<!-- /.row -->
								<%
									if (request.getAttribute("delete") != null) {
								%>
								<div class="panel-body" id="panelbody">
									<div class="alert alert-dismissable alert-danger ">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${delete}
									</div>
								</div>
								<%
									}
								%>
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-body">
												<ul class="nav nav-tabs nav-top-border no-hover-bg">
													<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab1" data-toggle="tab" href="#complaint"
														aria-controls="homeIcon1" aria-expanded="true"><i
															class="icon-ios-plus"></i> F-IT-01_Complain
															Register_2017_FINAL</a></li>
													<li class="nav-item"><a class="nav-link"
														id="profileIcon-tab1" data-toggle="tab" href="#download"
														aria-controls="profileIcon1" aria-expanded="false"><i
															class="icon-download"></i> Download Link</a>
												</ul>

												<div class="tab-content px-1 pt-1">
													<div role="tabpanel" class="tab-pane fade active in"
														id="complaint" aria-labelledby="homeIcon-tab1"
														aria-expanded="true">

														<%
															int month_id = Calendar.getInstance().get(Calendar.MONTH) + 1;
															String action = "pending";
															if (request.getParameter("month_id") != null) {
																month_id = Integer.parseInt(request.getParameter("month_id"));
																action = request.getParameter("approve");
															}
														%>

														<div class="panel-body">
															<ul class="nav nav-tabs nav-linetriangle nav-justified">
																<%
																	if (action.equalsIgnoreCase("pending")) {
																%>
																<li class="nav-item"><a class="nav-link active"
																	id="activeIcon22-tab1" data-toggle="tab"
																	href="#pending" aria-controls="activeIcon22"
																	aria-expanded="true"><i class="icon-alert"></i>
																		Pending</a></li>
																<%
																	} else {
																%>
																<li class="nav-item"><a class="nav-link"
																	id="activeIcon22-tab1" data-toggle="tab"
																	href="#pending" aria-controls="activeIcon22"
																	aria-expanded="false"><i class="icon-alert"></i>
																		Pending</a></li>

																<%
																	}
																%>

																<%
																	if (action.equalsIgnoreCase("approved")) {
																%>
																<li class="nav-item"><a class="nav-link active"
																	id="linkIcon22-tab1" data-toggle="tab" href="#approved"
																	aria-controls="linkIcon22" aria-expanded="true"><i
																		class="icon-thumbsup"></i> Approved</a></li>
																<%
																	} else {
																%>
																<li class="nav-item"><a class="nav-link"
																	id="linkIcon22-tab1" data-toggle="tab" href="#approved"
																	aria-controls="linkIcon22" aria-expanded="false"><i
																		class="icon-thumbsup"></i> Approved</a></li>
																<%
																	}
																%>
															</ul>

															<div class="tab-content">

																<%
																	if (action.equalsIgnoreCase("pending")) {
																%>
																<div class="tab-pane fade in active" id="pending">
																	<%
																		} else {
																	%>
																	<div class="tab-pane fade" id="pending">
																		<%
																			}
																		%>

																		<br>
																		<div class="panel-body">
																			<div class="dataTable_wrapper">
																				<div class="panel panel-danger">
																					<div class="panel-heading">
																						<b>Report Of Pending Complaints</b>
																					</div>
																					<br>
																					<div class="panel-body">
																						<div class="table table-responsive">
																							<table
																								class="table table-striped table-bordered table-hover file-export">

																								<thead>
																									<tr>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<th>Employee Code</th>
																										<th>Employee Name</th>
																										<th>Department</th>
																										<th>Extension No.</th>
																										<th>Problem Nature</th>
																										<th>Problem Description</th>
																										<th>Date Of Submission</th>
																										<th>Location</th>

																										<th>Status</th>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<th>Action</th>
																										<%
																											}
																											}
																										%>
																									</tr>
																								</thead>

																								<tbody>
																									<%
																										for (ComplaintBean c1 : listOfComplaint) {
																											String date_of_submission = c1.getDate();
																											String date_of_resolve = c1.getDate_of_resolve();
																											String ds = "-";
																											String dr = "-";
																											try {
																												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																												Date result = formater.parse(date_of_submission);
																												ds = AppDateFormat.format(result);

																												System.out.println(AppDateFormat.format(result));
																											} catch (ParseException e1) {
																												e1.printStackTrace();
																											}
																									%>
																									<tr>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<td><%=c1.getEmployeeBean().getEmployee_code()%></td>
																										<td><%=c1.getEmployeeBean().getFirstname() + " " + c1.getEmployeeBean().getLastname()%></td>
																										<td><%=c1.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
																										<%
																											}
																										%>
																										<td><%=c1.getExtension()%></td>
																										<td><%=c1.getProblemNatureBean().getProblem_nature_name()%></td>
																										<td><%=c1.getDescription()%></td>
																										<td><%=ds%></td>
																										<td><%=c1.getLocation()%></td>
																										<td><%=c1.getStatus()%></td>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<td><a href="" data-toggle="modal"
																											data-target="#myModal<%=c1.getComplaint_id()%>"><i
																												class="icon icon-reply"
																												data-toggle="tooltip" data-placement="top"
																												title="Reply"></i></a></td>
																										<%
																											}
																										%>

																										<%
																											}
																										%>

																										<!-- <input type="text"  name="ManagerName" id="ManagerName"   value=""/> -->
																									</tr>
																								</tbody>
																							</table>


																						</div>
																						<h5>
																							<b>Legends :&nbsp;</b>
																						</h5>
																						&nbsp;&nbsp;&nbsp;<i class="icon icon-reply"
																							style="color: #3BAFDA;"></i><b> : Reply </b>&nbsp;&nbsp;&nbsp;<i
																							class="icon icon-remove" style="color: red;"></i><b>
																							: Delete </b>
																					</div>
																					<%
																						for (ComplaintBean c1 : listOfComplaint) {
																					%>
																					<div class="modal fade"
																						id="myModal<%=c1.getComplaint_id()%>"
																						tabindex="-1" role="dialog"
																						aria-labelledby="myModalLabel" aria-hidden="true">
																						<div class="modal-dialog">
																							<div class="modal-content">
																								<div class="modal-header">
																									<button type="button" class="close"
																										data-dismiss="modal" aria-hidden="true">&times;</button>
																									<h4 class="modal-title" id="myModalLabel">
																										Reply For Query :
																										<%=c1.getDescription()%></h4>
																								</div>
																								<form action="complaintReplyInsert"
																									method="post">
																									<input type="hidden" name="complaint_id"
																										id="complaint_id"
																										value="<%=c1.getComplaint_id()%>">
																									<table class="table">
																										<tr>
																											<td><label>Reply</label>
																												<p class="help-block">(Max 1000 Words.)</p></td>
																											<td>:</td>
																											<td><textarea class="form-control"
																													name="reply" required></textarea></td>
																										</tr>
																										<tr>
																											<td><label>Date</label>
																												<p class="help-block"></p></td>
																											<td>:</td>
																											<td><input type="text"
																												class="form-control"
																												id="date_of_resolve<%=c1.getComplaint_id()%>"
																												name="date_of_resolve<%%>"
																												placeholder="yyyy-mm-dd" required></td>
																										</tr>
																										<tr>
																											<td><label>Concern Person</label>
																												<p class="help-block"></p></td>
																											<td>:</td>
																											<td>
																												<%-- select class="form-control" name="employee_master_id"
												id="employee_master_id" 
												onchange="autoShow(this.value)" required="required">
													<option value="">--Select Employee--</option>
													<%
													EmployeeBean employeeBean = new EmployeeBean();
													AllListDAO allListDAO = new AllListDAO();
															List<EmployeeBean> listOfProblemList = allListDAO.getFullListOfEmployee();
																
															for (EmployeeBean employees : listOfProblemList) {
																int under_manager_id1 = Integer.parseInt(employees.getUnder_manager_id());
																if(employees.getManagerBean().getManager_id() == 65 || under_manager_id1 == 65){
													%>
													<option value="<%=employees.getEmployee_master_id()%>"><%=employees.getFirstname()+" "+employees.getLastname()%></option>
													<%
														
																}}
													%>
											</select> --%> <%
 	EmployeeBean employeeBean = new EmployeeBean();
 		AllListDAO allListDAO = new AllListDAO();
 		List<EmployeeBean> listOfProblemList = allListDAO.getFullListOfEmployeeIt();

 		for (EmployeeBean employees : listOfProblemList) {
 			int under_manager_id1 = Integer.parseInt(employees.getUnder_manager_id());
 %> <input id="managername" type="checkbox"
																												name="managerName"
																												value="<%=employees.getEmployee_master_id()%>"
																												" onchange="check();">&nbsp;<%=employees.getFirstname() + " " + employees.getLastname()%>
																												<%
																													}
																												%>


																											</td>
																										</tr>


																										<tr>
																											<td><label>Problem Category</label>
																												<p class="help-block"></p></td>
																											<td>:</td>
																											<td><select class="form-control"
																												name="prob_nature_rly_id"
																												id="prob_nature_rly_id"
																												onchange="autoShow(this.value)"
																												required="required">
																													<option value="">--Select Problem
																														Category--</option>
																													<%
																														ProblemNatureReplyBean problemNatureReplyBean = new ProblemNatureReplyBean();

																															AllListSelfServiceDAO allListSelfServiceDAO3 = new AllListSelfServiceDAO();

																															List<ProblemNatureReplyBean> listOfProblemtype = allListSelfServiceDAO3.getFullListOftype();

																															for (ProblemNatureReplyBean p : listOfProblemtype) {
																													%>
																													<option
																														value="<%=p.getProb_nature_rly_id()%>"><%=p.getProb_nature_rly_name()%></option>
																													<%
																														}
																													%>
																											</select> <%-- <%
													EmployeeBean employeeBean = new EmployeeBean();
													AllListDAO allListDAO = new AllListDAO();
															List<EmployeeBean> listOfProblemList = allListDAO.getFullListOfEmployee();
																
															for (EmployeeBean employees : listOfProblemList) {
																int under_manager_id1 = Integer.parseInt(employees.getUnder_manager_id());
																if(employees.getManagerBean().getManager_id() == 65 || under_manager_id1 == 65){
													%>
													<input id="managername" type="checkbox" name="managerName" value="<%=employees.getEmployee_master_id()%>"" onchange="check();" >&nbsp;<%=employees.getFirstname()+" "+employees.getLastname()%>
													<%
														
																}}
													%> --%></td>
																										</tr>





																										<tr>
																											<td><label>Remarks</label>
																												<p class="help-block">(Max 1000 Words.)</p></td>
																											<td>:</td>
																											<td><textarea class="form-control"
																													name="remarks" required></textarea></td>
																										</tr>
																									</table>
																									<input type="hidden" name="redirect">
																									<div class="modal-footer">
																										<input type="submit" name="submit"
																											value="SUBMIT" class="btn btn-primary">
																										<button type="button" class="btn btn-danger"
																											data-dismiss="modal">CLOSE</button>
																									</div>
																							</div>
																							</form>
																							<!-- /.modal-content -->
																						</div>
																						<!-- /.modal-dialog -->
																					</div>
																					<%
																						}
																					%>
																				</div>
																			</div>
																		</div>



																	</div>


																	<script type="text/javascript">
											function redirect(value) {
												window.location.replace("itComplaint.jsp?month_id="+value+"&approve=approved");
											}
										</script>

																	<%
																		if (action.equalsIgnoreCase("approved")) {
																	%>
																	<div class="tab-pane fade in active" id="approved">
																		<%
																			} else {
																		%>
																		<div class="tab-pane fade" id="approved">
																			<%
																				}
																			%>
																			<div class="panel-body">
																			<br>
																			<div class="row">
																			<div class="col-lg-12">
																			<div class="col-lg-2">
																				<label><b>Select Month</b></label>
																			</div>
																			<div class="col-lg-10">
																				 <select
																					class="form-control" name="month_id" id="month"
																					required="required" onchange="redirect(this.value)">
																					<option value="">---Month---</option>
																					<%
																						AllListDAO monthList = new AllListDAO();
																						List<MonthBean> listOfMonth = monthList.getListOfMonth();
																						for (MonthBean m : listOfMonth) {
																							if (m.getMonth_id() != 0 && m.getMonth_id() < 13) {
																								if (month_id == m.getMonth_id()) {
																					%>
																					<option value="<%=m.getMonth_id()%>"
																						selected="selected"><%=m.getMonth_name()%></option>

																					<%
																						} else {
																					%>

																					<option value="<%=m.getMonth_id()%>"><%=m.getMonth_name()%></option>

																					<%
																						}
																					%>

																					<%
																						}
																						}
																					%>
																				</select>
																				</div>
																				</div>
																				</div>
																				 <br>
																				<div class="dataTable_wrapper">
																					<div class="panel panel-success">
																						<div class="panel-heading">
																							<b>Report Of Completed Complaints</b>
																						</div>
																						<br>
																						<div class="panel-body">
																						<div class="table-responsive">
																							<table
																								class="table table-striped table-bordered table-hover file-export"
																								border="1">
																								<thead>
																									<tr>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<th>Employee Code</th>
																										<th>Employee Name</th>
																										<th>Department</th>
																										<th>Extension No.</th>
																										<th>Problem Nature</th>
																										<th>Date Of Submission</th>
																										<th>Location</th>
																										<th>Concern Person</th>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<th style="width: 90px;">Action</th>
																										<%
																											}
																											}
																										%>
																									</tr>
																								</thead>

																								<tbody>
																									<%
																										List<ComplaintBean> listOfComplaint1 = null;

																										if (manager_id == 65 || under_manager_id == 65) {
																											listOfComplaint1 = allListSelfServiceDAO.getcomplaintList1(month_id);
																										} else {
																											listOfComplaint1 = allListSelfServiceDAO.getcomplaintList1(month_id);
																										}

																										for (ComplaintBean c1 : listOfComplaint1) {
																											String date_of_submission = c1.getDate();
																											String date_of_resolve = c1.getDate_of_resolve();
																											String ds = "-";
																											String dr = "-";
																											try {
																												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																												Date result = formater.parse(date_of_submission);
																												ds = AppDateFormat.format(result);

																												System.out.println(AppDateFormat.format(result));
																											} catch (ParseException e1) {
																												e1.printStackTrace();
																											}
																									%>
																									<tr>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<td><%=c1.getEmployeeBean().getEmployee_code()%></td>
																										<td><%=c1.getEmployeeBean().getFirstname() + " " + c1.getEmployeeBean().getLastname()%></td>
																										<td><%=c1.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
																										<%
																											}
																										%>
																										<td><%=c1.getExtension()%></td>
																										<td><%=c1.getProblemNatureBean().getProblem_nature_name()%></td>
																										<td><%=ds%></td>
																										<td><%=c1.getLocation()%></td>
																										<td>
																											<%
																												int complaint_id = c1.getComplaint_id();
																													List<ComplaintVerifiedByBean> listOfVerified = allListSelfServiceDAO
																															.getComplaintVerifiedByPerson(complaint_id);
																													if (listOfVerified.size() != 0) {
																														for (ComplaintVerifiedByBean cvb : listOfVerified) {
																											%>
																											<%=cvb.getEmployeeBean().getFirstname() + " " + cvb.getEmployeeBean().getLastname()%>,
																											<%
																												}
																													}
																											%>
																										</td>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<td>&nbsp;<i class="icon icon-remove"
																											data-toggle="tooltip" data-placement="top"
																											title="Delete" style="color: red;"
																											onclick="demo(<%=c1.getComplaint_id()%>)"></i>
																											&nbsp;<a href="" data-toggle="modal"
																											data-target="#myModalView<%=c1.getComplaint_id()%>"><i
																												class="icon icon-eye-open"
																												data-toggle="tooltip" data-placement="top"
																												title="View Complaint Detail""></i></a> &nbsp;<a
																											href="" data-toggle="modal"
																											data-target="#myModalView1<%=c1.getComplaint_id()%>"><i
																												class="icon icon-edit" data-toggle="tooltip"
																												data-placement="top"
																												title="Update Complaint"></i></a> <%
 	}
 %>
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
																					<!-- <h5><b>Legends :&nbsp;</b></h5>  
                                       &nbsp;&nbsp;<i class="icon icon-remove" data-toggle="tooltip" data-placement="top" title="Delete" style="color: red;"><b> : Remove Form View List</b></i> -->
																				</div>

																			</div>

																		</div>





																	</div>


																</div>

															</div>

															<div class="tab-pane fade" id="download" role="tabpanel"
																aria-labelledby="dropdownIcon2-tab1"
																aria-expanded="false">
																<div class="row">
																	<div class="panel-body">
																		<div class="dataTable_wrapper">
																			<div class="panel panel-danger">
																				<div class="panel-heading">
																					<b>Report Of Pending Complaints</b>
																				</div>
																				<br>
																				<div class="panel-body">
																					<div class="table table-responsive">

																						<table
																							class="table table-striped table-bordered table-hover file-export"
																							border="1">

																							<thead>
																								<tr>
																									<%
																										if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																									%>
																									<th>Employee Code</th>
																									<th>Employee Name</th>
																									<th>Department</th>
																									<th>Extension No.</th>
																									<th>Download Link</th>
																									<th>Date Of Submission</th>
																									<th>Status</th>
																									<%
																										if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																									%>
																									<th>Action</th>
																									<%
																										}
																										}
																									%>
																								</tr>
																							</thead>

																							<tbody>
																								<%
																									AllListSelfServiceDAO allListSelfServiceDAO2 = new AllListSelfServiceDAO();

																									List<DownloadBean> listOfDownload = null;
																									if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										listOfDownload = allListSelfServiceDAO2.getdownloadList();
																									} else {
																										listOfDownload = allListSelfServiceDAO2.getdownloadList();
																									}

																									for (DownloadBean d1 : listOfDownload) {
																										String date_of_submission = d1.getDate();
																										String ds = "-";
																										String dr = "-";
																										try {
																											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																											Date result = formater.parse(date_of_submission);
																											ds = AppDateFormat.format(result);

																											System.out.println(AppDateFormat.format(result));
																										} catch (ParseException e1) {
																											e1.printStackTrace();
																										}
																								%>
																								<tr>
																									<%
																										if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																									%>
																									<td><%=d1.getEmployeeBean().getEmployee_code()%></td>
																									<td><%=d1.getEmployeeBean().getFirstname() + " " + d1.getEmployeeBean().getLastname()%></td>
																									<td><%=d1.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
																									<%
																										}
																									%>
																									<td><%=d1.getExtension()%></td>
																									<td><%=d1.getLink()%></td>
																									<td><%=ds%></td>
																									<td><%=d1.getStatus()%></td>
																									<%
																										if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																									%>
																									<td><a href="" data-toggle="modal"
																										data-target="#myModal<%=d1.getDownload_id()%>"><i
																											class="icon icon-reply" data-toggle="tooltip"
																											data-placement="top" title="Reply"></i></a>&nbsp;&nbsp;<a
																										href=""><i class="icon icon-remove"
																											data-toggle="tooltip" data-placement="top"
																											title="Delete" style="color: red;"></i></a></td>
																									<%
																										}
																									%>

																									<%
																										}
																									%>
																								</tr>
																							</tbody>
																						</table>

																					</div>
																					<h5>
																						<b>Legends :&nbsp;</b>
																					</h5>
																					&nbsp;&nbsp;&nbsp;<i class="icon icon-reply"
																						style="color: #3BAFDA;"></i><b> : Reply </b>&nbsp;&nbsp;&nbsp;<i
																						class="icon icon-remove" style="color: red;"></i><b>
																						: Delete </b>
																						<br>
																					<%
																						for (DownloadBean d2 : listOfDownload) {
																					%>
																					<div class="modal fade"
																						id="myModal<%=d2.getDownload_id()%>" tabindex="-1"
																						role="dialog" aria-labelledby="myModalLabel"
																						aria-hidden="true">
																						<div class="modal-dialog">
																							<div class="modal-content">
																								<div class="modal-header">
																									<button type="button" class="close"
																										data-dismiss="modal" aria-hidden="true">&times;</button>
																									<h4 class="modal-title" id="myModalLabel">
																										Reply For Query :
																										<%=d2.getLink()%></h4>
																								</div>
																								<form action="downloadReplyInsert" method="post">
																									<input type="hidden" name="download_id"
																										id="download_id"
																										value="<%=d2.getDownload_id()%>">
																									<table class="table">
																										<tr>
																											<td><label>Reply</label>
																												<p class="help-block">(Max 1000 Words.)</p></td>
																											<td>:</td>
																											<td><textarea class="form-control"
																													name="reply" required></textarea></td>
																										</tr>


																										<tr>
																											<td><label>Remarks</label>
																												<p class="help-block">(Max 1000 Words.)</p></td>
																											<td>:</td>
																											<td><textarea class="form-control"
																													name="remarks" required></textarea></td>
																										</tr>
																									</table>
																									<input type="hidden" name="redirect">
																									<div class="modal-footer">
																										<input type="submit" name="submit"
																											value="SUBMIT" class="btn btn-primary">
																										<button type="button" class="btn btn-danger"
																											data-dismiss="modal">CLOSE</button>
																									</div>
																							</div>
																							</form>
																							<!-- /.modal-content -->
																						</div>
																						<!-- /.modal-dialog -->
																					</div>
																					<%
																						}
																					%>




																				</div>
																			</div>
																		</div>
																		<hr>
																		<div class="panel-body">
																			<div class="dataTable_wrapper">
																				<div class="panel panel-success">
																					<div class="panel-heading">
																						<b>Report Of Completed Complaints</b>
																					</div>
																					<br>
																					<div class="panel-body">
																						<div class="table table-responsive">
																							<table
																								class="table table-striped table-bordered table-hover file-export"
																								border="1">
																								<thead>
																									<tr>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<th>Employee Code</th>
																										<th>Employee Name</th>
																										<th>Department</th>
																										<th>Extension No.</th>
																										<th>Download Link</th>
																										<th>Date Of Submission</th>

																										<th>Status</th>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<th style="width: 100px;">Action</th>
																										<%
																											}
																											}
																										%>
																									</tr>
																								</thead>

																								<tbody>
																									<%
																										AllListSelfServiceDAO allListSelfServiceDAO3 = new AllListSelfServiceDAO();

																										List<DownloadBean> listOfDownlaod1 = null;
																										if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																											listOfDownload = allListSelfServiceDAO2.getdownloadList1();
																										} else {
																											listOfDownload = allListSelfServiceDAO2.getdownloadList1();
																										}

																										for (DownloadBean d1 : listOfDownload) {
																											String date_of_submission = d1.getDate();
																											String ds = "-";
																											String dr = "-";
																											try {
																												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																												Date result = formater.parse(date_of_submission);
																												ds = AppDateFormat.format(result);

																												System.out.println(AppDateFormat.format(result));
																											} catch (ParseException e1) {
																												e1.printStackTrace();
																											}
																									%>
																									<tr>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<td><%=d1.getEmployeeBean().getEmployee_code()%></td>
																										<td><%=d1.getEmployeeBean().getFirstname() + " " + d1.getEmployeeBean().getLastname()%></td>
																										<td><%=d1.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
																										<%
																											}
																										%>
																										<td><%=d1.getExtension()%></td>
																										<td><%=d1.getLink()%></td>
																										<td><%=ds%></td>
																										<td><%=d1.getStatus()%></td>
																										<%
																											if (manager_id == 65 || manager_id == 5 || under_manager_id == 65) {
																										%>
																										<td><a href="" data-toggle="modal"
																											data-target="#myModal<%=d1.getDownload_id()%>"><i
																												class="icon icon-reply"
																												data-toggle="tooltip" data-placement="top"
																												title="Reply"></i></a>&nbsp;&nbsp;<a href=""><i
																												class="icon icon-remove"
																												data-toggle="tooltip" data-placement="top"
																												title="Delete" style="color: red;"></i></a></td>
																										<%
																											}
																										%>

																										<%
																											}
																										%>
																									</tr>
																								</tbody>
																							</table>

																						</div>
																					</div>
																					<br>
																					<h5>
																						<b>Legends :&nbsp;</b>
																					</h5>

																					&nbsp;&nbsp;&nbsp;<i class="icon icon-remove"
																						style="color: red;"></i><b> : Remove Form View
																						List</b>

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


											<%
												for (ComplaintBean a : listOfComplaint1) {
											%>
											<div class="modal fade"
												id="myModalView<%=a.getComplaint_id()%>" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<%
													int complaint_id = a.getComplaint_id();
														String status = a.getStatus();
												%>
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<h4 class="modal-title" id="myModalLabel"></h4>
														</div>
														<table class="table">
															<tr>
																<td><label>&nbsp;Complaint Done By</label></td>
																<td>:</td>
																<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
															</tr>
															<tr>
																<td><label>&nbsp;Problem Nature</label></td>
																<td>:</td>
																<td><%=a.getProblemNatureBean().getProblem_nature_name()%></td>
															</tr>
															<%
																String ds = a.getDate();
																	try {
																		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																		SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																		Date result1 = formater.parse(ds);
																		ds = AppDateFormat.format(result1);

																		System.out.println(AppDateFormat.format(result1));
																	} catch (ParseException e1) {
																		e1.printStackTrace();
																	}
															%>
															<tr>
																<td><label>&nbsp;Date Of Submission</label></td>
																<td>:</td>
																<td><%=ds%></td>
															</tr>
															<tr>
																<td><label>&nbsp;Description</label></td>
																<td>:</td>
																<td><%=a.getDescription()%></td>
															</tr>
															<tr>
																<td><label>&nbsp;Location</label></td>
																<td>:</td>
																<td><%=a.getLocation()%></td>
															</tr>
															<tr>
																<td><label>&nbsp;Extension</label></td>
																<td>:</td>
																<td><%=a.getExtension()%></td>
															</tr>
															<%
																if (status.equalsIgnoreCase("completed")) {
															%>
															<tr>
																<td><label>&nbsp;Correction</label></td>
																<td>:</td>
																<td><%=a.getCorrection()%></td>
															</tr>
															<tr>
																<td><label>&nbsp;Correction Date</label></td>
																<td>:</td>
																<td>
																	<%
																		String cd = "-";
																				try {
																					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																					SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																					Date result1 = formater.parse(a.getDate_of_resolve());
																					cd = AppDateFormat.format(result1);

																					System.out.println(AppDateFormat.format(result1));
																				} catch (ParseException e1) {
																					e1.printStackTrace();
																				}
																	%> <%=cd%></td>
															</tr>
															<tr>
																<td><label>&nbsp;Correction Date</label></td>
																<td>:</td>
																<td>
																	<%
																		int complaint_id1 = a.getComplaint_id();
																				List<ComplaintVerifiedByBean> listOfVerified = allListSelfServiceDAO
																						.getComplaintVerifiedByPerson(complaint_id);
																				if (listOfVerified.size() != 0) {
																					for (ComplaintVerifiedByBean cvb : listOfVerified) {
																	%>
																	<%=cvb.getEmployeeBean().getFirstname() + " " + cvb.getEmployeeBean().getLastname()%>,
																	<%
																		}
																				}
																	%>
																</td>




															</tr>
															<tr>
																<td><label>&nbsp;Remarks</label></td>
																<td>:</td>
																<td><%=a.getRemarks()%></td>
															</tr>
															<%
																}
															%>

														</table>
														<input type="hidden" name="redirect">
														<div class="modal-footer">
															<button type="button" class="btn btn-danger"
																data-dismiss="modal">CLOSE</button>
														</div>
													</div>
													</form>
													<!-- /.modal-content -->
												</div>
												<!-- /.modal-dialog -->



											</div>



											<div class="modal fade"
												id="myModalView1<%=a.getComplaint_id()%>" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<center>
																<h4 class="modal-title" id="myModalLabel">Update
																	Complaint</h4>
															</center>
														</div>
														<form action="updateReply" method="post">
															<input type="hidden" name="complaint_id"
																id="complaint_id" value="<%=a.getComplaint_id()%>">
															<input type="hidden" name="month_id"
																value="<%=month_id%>"> <input type="hidden"
																name="approve" value="approved">
															<div class="table table-responsive">
																<table
																	class="table table-striped table-bordered table-hover"
																	border="1" id="dataTables-example">
																	<tr>
																		<td><label>&nbsp;Complaint Done By</label></td>
																		<td>:</td>


																		<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
																	</tr>
																	<tr>
																		<td><label>&nbsp;Problem Nature</label></td>
																		<td>:</td>
																		<td>
																			<%-- <input type="text" class="form-control"
												name="prob_nature" value="<%=a.getProblemNatureBean().getProblem_nature_name()%>" required>
							 --%> <select class="form-control" name="problem_nature_id"
																			id="problem_nature_id" required="required"
																			onchange="autoShow(this.value)">
																				<option value="0">--Select Problem Nature--</option>
																				<%
																					AllListSelfServiceDAO allListSelfServiceDAO4 = new AllListSelfServiceDAO();
																						List<ProblemNatureBean> listOfProb = allListSelfServiceDAO4.getListOfAllProblemNature();
																						for (ProblemNatureBean problemNatureBean : listOfProb) {

																							if (a.getProblemNatureBean().getProblem_nature_id() == problemNatureBean.getProblem_nature_id()) {
																				%>
																				<option
																					value="<%=problemNatureBean.getProblem_nature_id()%>"
																					selected="selected"><%=problemNatureBean.getProblem_nature_name()%></option>
																				<%
																					problem_nature_id = problemNatureBean.getProblem_nature_id();
																							} else {
																				%>
																				<option
																					value="<%=problemNatureBean.getProblem_nature_id()%>"><%=problemNatureBean.getProblem_nature_name()%></option>
																				<%
																					}
																						}
																				%>
																		</select>

																		</td>
																	</tr>
																	<%
																		String ds1 = a.getDate();
																			try {
																				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																				SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																				Date result1 = formater.parse(ds1);
																				ds1 = formater.format(result1);

																				System.out.println(AppDateFormat.format(result1));
																			} catch (ParseException e1) {
																				e1.printStackTrace();
																			}
																	%>
																	<tr>
																		<td><label>&nbsp;Date Of Submission</label></td>
																		<td>:</td>
																		<td><input type="text" class="form-control"
																			id="datepicker1" name="date" value="<%=ds1%>"
																			placeholder="yyyy-mm-dd" required> <!--  <input type="text" id="datepicker1" width="155" name="fromDate" placeholder="dd/mm/yyyy" required class="form-control"> -->
																		</td>
																	</tr>
																	<tr>
																		<td><label>&nbsp;Description</label></td>
																		<td>:</td>
																		<td><input type="text" class="form-control"
																			name="description" value="<%=a.getDescription()%>"
																			required></td>
																	</tr>
																	<tr>
																		<td><label>&nbsp;Location</label></td>
																		<td>:</td>
																		<td><input type="text" class="form-control"
																			name="location" value="<%=a.getLocation()%>" required></td>
																	</tr>
																	<tr>
																		<td><label>&nbsp;Extension</label></td>
																		<td>:</td>
																		<td><input type="text" class="form-control"
																			name="extension" value="<%=a.getExtension()%>"
																			required></td>
																	</tr>
																	<%
																		String status1 = a.getStatus();
																			if (status1.equalsIgnoreCase("completed")) {
																	%>
																	<tr>
																		<td><label>&nbsp;Correction</label></td>
																		<td>:</td>
																		<td><input type="text" class="form-control"
																			name="correction" value="<%=a.getCorrection()%>"
																			required></td>
																	</tr>
																	<tr>
																		<td><label>&nbsp;Correction Date</label></td>
																		<td>:</td>
																		<td>
																			<%
																				String cd = "-";
																						try {
																							SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																							SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

																							Date result1 = formater.parse(a.getDate_of_resolve());
																							cd = formater.format(result1);

																							System.out.println(AppDateFormat.format(result1));
																						} catch (ParseException e1) {
																							e1.printStackTrace();
																						}
																			%> <input type="text" class="form-control" id="datepicker2"
																			name="date2" value="<%=cd%>" required>
																		</td>


																	</tr>
																	<tr>
																		<td><label>&nbsp;Complaint verified by</label></td>
																		<td>:</td>
																		<td>
																			<%
																				AllListDAO allListDAO = new AllListDAO();
																						List<EmployeeBean> listOfProblemList = allListDAO.getFullListOfEmployeeIt();

																						for (EmployeeBean employees : listOfProblemList) {
																							int under_manager_id1 = Integer.parseInt(employees.getUnder_manager_id());

																							boolean flag = false;
																							List<ComplaintVerifiedByBean> listOfCategoryDetail = allListSelfServiceDAO
																									.getComplaintVerifiedByPerson(complaint_id);
																							for (ComplaintVerifiedByBean a1 : listOfCategoryDetail) {
																								if (a1.getEmployeeBean().getEmployee_master_id() == employees.getEmployee_master_id()) {
																									flag = true;
																								}
																							}
																			%> <%
 	if (flag == true) {
 %> <label><input id="managername" type="checkbox"
																				name="managerName"
																				value="<%=employees.getEmployee_master_id()%>"
																				" onchange="check();" checked="checked">&nbsp;<%=employees.getFirstname() + " " + employees.getLastname()%>
																		</label> <%
 	} else {
 %> <label><input id="managername" type="checkbox"
																				name="managerName"
																				value="<%=employees.getEmployee_master_id()%>"
																				" onchange="check();">&nbsp;<%=employees.getFirstname() + " " + employees.getLastname()%>
																		</label> <%
 	}
 			}
 %>
																		</td>
																	</tr>
																	<tr>
																		<td><label>&nbsp;Remarks</label></td>
																		<td>:</td>
																		<td><input type="text" class="form-control"
																			name="remarks" value="<%=a.getRemarks()%>" required></td>
																	</tr>
																	<%
																		}
																	%>

																</table>
																<input type="hidden" name="redirect">
																<div class="modal-footer">
																	<input type="submit" name="submit" value="SUBMIT"
																		class="btn btn-primary">
																	<button type="button" class="btn btn-danger"
																		data-dismiss="modal">CLOSE</button>
																</div>
															</div>
													</div>
													</form>
													<!-- /.modal-content -->
												</div>
												<!-- /.modal-dialog -->



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
		}
	%>

	<!--             Update the complaint -->




	<!--             Update the complaint -->



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
	<script src="app-assets/vendors/js/extensions/sweetalert.min.js"
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
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
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
	<script
		src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	<script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#datepicker1");
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'dd/mm/yy' ,
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 	           
				 				
							
				 			 }
				      
				 		});
				 });
		 
		

</script>
	<script type="text/javascript">
		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#datepicker2");
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'dd/mm/yy' ,
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 	           
				 			
							
				 			 }
				      
				 		});
				 });
</script>
</body>
</html>