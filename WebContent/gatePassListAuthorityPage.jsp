<%@page import="com.hrms.lms.bean.GatePassAuthorityBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>CUG List</title>
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
<%@include file="header.jsp"%>

<script type="text/javascript">
	function autoInsert(id) {

		if (id == 1) {
			document.getElementById('openStatus').value = "out";
		}
		if (id == 2) {
			document.getElementById('openStatus').value = "in";
		}
		if (id == 3) {
			document.getElementById('openStatus').value = "inOut";
		}
		if (id == 4) {
			document.getElementById('openStatus').value = "interCompany";
		}
		if (id == 5) {
			document.getElementById('openStatus').value = "history";
		}

	}
</script>
<script type="text/javascript">
	var datefield = document.createElement("input")
	datefield.setAttribute("type", "text")
	if (datefield.type != "date") { //if browser doesn't support input type="date", load files for jQuery UI Date Picker
		document
				.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
		document
				.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
	}
</script>
<script>
	if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
		jQuery(function($) { //on document.ready
			$('#date').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		})
	}
</script>
<script>
	function demo(gate_pass_id) {
		var retVal = confirm("Are you sure?");
		if (retVal == true) {
			window.location.replace("gatePassDelete?gate_pass_id="
					+ gate_pass_id + "&openStatus=interCompany");
		} else {
			window.location
					.replace("gatePassListSecurity.jsp?openStatus=interCompany");
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>


<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns ">
	<%
		int emp_id = user.getEmployee_master_id();
		String openStatus = "out";

		String parseCurrDate = null;
		if (request.getParameter("date") != null) {
			parseCurrDate = request.getParameter("date");
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date currDate = new Date();
			parseCurrDate = simpleDateFormat.format(currDate);
		}

		AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
		GatePassAuthorityBean gatePassAuthorityBean = allLMSListDAO.authorityOfGatePass(emp_id);
		String gate_name = gatePassAuthorityBean.getGateLoationBean().getGate_location_name();
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
										<h1 class="page-header">Gate Pass Status</h1>
									</div>
								</div>
								<!-- /.row -->
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<div class="row">

													<div class="col-md-10">
														<h4>Gate Pass</h4>
													</div>
													<div class="col-md-2" align="right">

														<input type="hidden" name="openStatus" id="openStatus"
															value="out">
													</div>
												</div>


											</div>



											<!-- /.panel-heading -->
											<div class="panel-body">
												<!-- Nav tabs -->

												<div class="row">
													<form action="gatePassListAuthorityPage.jsp">
														<input type="hidden" name="openStatus" value="history">
														<div class="col-md-1"
															style="padding-right: 0px; width: 100px;" align="right">
															<b>Select Date</b>
														</div>
														<div class="col-md-1"
															style="padding-left: 0px; padding-right: 0px; width: 30px;">
															<center>
																<b>:</b>
															</center>
														</div>
														<div class="col-md-2"
															style="padding-left: 0px; width: 190px;" align="left">
															<input type="text" name="date" id="date"
																value="<%=parseCurrDate%>" placeholder="yyyy-mm-dd"
																class="form-control">
														</div>
														<div class="col-md-4">
															<input type="submit" value="SUBMIT"
																class="btn btn-primary">
														</div>
													</form>
												</div>

												<hr>
												<ul class="nav nav-tabs">
													<%
														if (openStatus.equalsIgnoreCase("out")) {
													%><li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#out"
														aria-controls="homeIcon" aria-expanded="true"><i
															class="icon-ios-compose" onclick="autoInsert(1)"></i>
															Gate Pass</a></li>
													<%
														} else {
													%>
													<li class="nav-item"><a class="nav-link"
														id="homeIcon-tab" data-toggle="tab" href="#out"
														aria-controls="homeIcon" aria-expanded="false"><i
															class="icon-ios-compose" onclick="autoInsert(1)"></i>
															Gate Pass</a></li>
													<%
														}
													%>
													<%
														if (openStatus.equalsIgnoreCase("interCompany")) {
													%><li class="nav-item"><a class="nav-link active"
														id="profileIcon-tab" data-toggle="tab"
														href="#interCompany" aria-controls="profileIcon"
														aria-expanded="true"><i class="icon-user-plus"
															onclick="autoInsert(4)"></i> Inter Company</a></li>
													<%
														} else {
													%>
													<li class="nav-item"><a class="nav-link"
														id="profileIcon-tab" data-toggle="tab"
														href="#interCompany" aria-controls="profileIcon"
														aria-expanded="false"><i class="icon-user-plus"
															onclick="autoInsert(4)"></i> Inter Company</a></li>
													<%
														}
													%>
												</ul>

												<!-- Tab panes -->
												<div class="tab-content px-1 pt-1">
													<%
														if (openStatus.equalsIgnoreCase("out")) {
													%>
													<div role="tabpanel" class="tab-pane fade active in"
														id="out" aria-labelledby="homeIcon-tab"
														aria-expanded="true">
														<%
															} else {
														%>

														<div role="tabpanel" class="tab-pane fade" id="out"
															aria-labelledby="homeIcon-tab" aria-expanded="false">
															<%
																}
															%>
															<h4>Gate Pass</h4>
															<div class="panel-body">
																<div class="dataTable_wrapper">
																	<div class="table-responsive">

																		<table class="table table-striped table-bordered zero-configuration">
																			<thead>
																				<tr bgcolor="#d7dbdd">
																					<th width="100px"><center>Date</center></th>
																					<th><center>Code</center></th>
																					<th><center>Name</center></th>
																					<th><center>Department</center></th>
																					<th><center>Approved By</center></th>
																					<th><center>Type</center></th>
																					<th><center>Source Out Time</center></th>
																					<th><center>Source In Time</center></th>
																					<th><center>Status</center></th>
																					<th><center>Action</center></th>
																				</tr>
																			</thead>


																			<%
																				List<GatePassBean> listOfGatePass = allLMSListDAO.getListOfAllApprovedGatePass(parseCurrDate, gate_name);
																				for (GatePassBean g : listOfGatePass) {
																					String date = g.getSubmission_date_time();
																					String[] split = date.split(" ");
																					String date1 = null;
																					int e_id = g.getApprove_ID();

																					String outTime = g.getSecurity_out_time();
																					String inTime = g.getSecurity_in_time();

																					String sOutTime = "-------";
																					String sInTime = "-------";

																					try {
																						SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																						SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

																						Date result = formater.parse(split[0]);
																						date1 = AppDateFormat.format(result);

																					} catch (ParseException e1) {
																						e1.printStackTrace();
																					}

																					try {
																						final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");

																						if (g.getSecurity_out_time() != null) {

																							String[] split1 = outTime.split(" ");
																							final String time = split1[1];
																							final Date dateObj = sdf.parse(time);
																							sOutTime = new SimpleDateFormat("K:mm a").format(dateObj);
																						}
																						if (g.getSecurity_in_time() != null) {
																							String[] split2 = inTime.split(" ");
																							final String time1 = split2[1];
																							final Date dateObj1 = sdf.parse(time1);
																							sInTime = new SimpleDateFormat("K:mm a").format(dateObj1);
																						}

																					} catch (final ParseException e) {
																						e.printStackTrace();
																					}
																			%>


																			<tr>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center><%=date1%></center>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><a href="" data-toggle="modal"
																					data-target="#myModalView<%=g.getGate_pass_id()%>"
																					style="text-decoration: none; color: black; cursor: pointer;"><%=g.getEmployeeBean().getEmployee_code()%></a>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center>
																						<a href="" data-toggle="modal"
																							data-target="#myModalView<%=g.getGate_pass_id()%>"
																							style="text-decoration: none; color: black; cursor: pointer;"><%=g.getEmployeeBean().getFirstname() + " " + g.getEmployeeBean().getLastname()%></a>
																					</center>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></center>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center>
																						<%
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
																					</center>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center><%=g.getPurpose_of_leave()%></center>
																				</td>
																				<%-- <%if(e_id == 0){%><td bgcolor="#F2D7D5"><%}else{%><td><%} %><center><%=g.getOut_time()%></center></td> --%>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center><%=sOutTime%></center>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center><%=sInTime%></center>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center>
																						<%
																							if (g.getStatus().equalsIgnoreCase("pending")) {
																						%>
																						<font color="blue"> <%
 	} else if (g.getStatus().equalsIgnoreCase("in") || g.getStatus().equalsIgnoreCase("Approved")) {
 %> <font color="green"> <%
 	} else {
 %> <font color="red"> <%
 	}
 %> <b><%=g.getStatus()%></b></font>
																					</center>
																				</td>
																				<%
																					if (e_id == 0) {
																				%><td bgcolor="#F2D7D5">
																					<%
																						} else {
																					%>
																				
																				<td>
																					<%
																						}
																					%><center>
																						<a href="" data-toggle="modal"
																							data-target="#myModalView<%=g.getGate_pass_id()%>"
																							style="text-decoration: none; color: black; cursor: pointer;"><button
																								class="btn btn-primary btn-xs">Detail</button></a>
																				</td>
																			</tr>


																			</tbody>




																			<%
																				}
																			%>


																		</table>
																	</div>
																</div>
															</div>
														</div>



														<%
															if (openStatus.equalsIgnoreCase("interCompany")) {
														%>
													<div role="tabpanel" class="tab-pane fade active in"
															id="interCompany" aria-labelledby="homeIcon-tab"
															aria-expanded="true">
															<%
																} else {
															%>
														<div role="tabpanel" class="tab-pane fade"
																id="interCompany" aria-labelledby="homeIcon-tab"
																aria-expanded="false">
																<%
																	}
																%>
																<h4>Inter Company Gate Pass</h4>

																<div class="row">
																	<div class="col-lg-12">

																		<div class="panel-body">
																			<!-- Nav tabs -->
																			<ul class="nav nav-tabs">
																				<li class="active"><a href="#home"
																					data-toggle="tab">Out (<%=gate_name%>)
																				</a></li>
																				<li><a href="#profile" data-toggle="tab">IN
																						(<%=gate_name%>)
																				</a></li>
																			</ul>

																			<!-- Tab panes -->
																			<div class="tab-content">
																				<div class="tab-pane fade in active" id="home">
																					<h4></h4>
																					<br>
																					<table class="table table-striped table-bordered zero-configuration">
																						<thead>
																							<tr bgcolor=" #d7dbdd">
																								<th width="100px"><center>Date</center></th>
																								<th><center>Code</center></th>
																								<th><center>Name</center></th>
																								<th><center>Department</center></th>
																								<th><center>Source</center></th>
																								<th><center>Destination</center></th>
																								<th width="100px"><center>Source
																										Out Time</center></th>
																								<th width="100px"><center>Destination
																										In Time</center></th>
																								<th width="100px"><center>Destination
																										Out Time</center></th>
																								<th width="100px"><center>Source
																										In Time</center></th>
																								<th width="100px"><center>Action</center></th>
																							</tr>
																						</thead>

																						<tbody>

																							<%
																								List<GatePassBean> listOfInterCompanyOut = allLMSListDAO.getListOfInterCompanyOut(parseCurrDate, gate_name);
																								for (GatePassBean g : listOfInterCompanyOut) {

																									String date = g.getSubmission_date_time();
																									String outTime = g.getSecurity_out_time();
																									String destInTime = g.getDestination_in_time();
																									String destOutTime = g.getDestination_out_time();
																									String inTime = g.getSecurity_in_time();

																									String[] split = date.split(" ");

																									String sOutTime = "-------";
																									String sInTime = "-------";
																									String dInTime = "-------";
																									String dOutTime = "-------";

																									String date11 = null;

																									try {
																										SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																										SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

																										Date result = formater.parse(split[0]);
																										date11 = AppDateFormat.format(result);

																										System.out.println(AppDateFormat.format(result));
																									} catch (ParseException e1) {
																										e1.printStackTrace();
																									}

																									try {
																										final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");

																										if (g.getSecurity_out_time() != null) {

																											String[] split1 = outTime.split(" ");
																											final String time = split1[1];
																											final Date dateObj = sdf.parse(time);
																											sOutTime = new SimpleDateFormat("K:mm a").format(dateObj);
																										}

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

																										if (g.getSecurity_in_time() != null) {
																											String[] split2 = inTime.split(" ");
																											final String time1 = split2[1];
																											final Date dateObj1 = sdf.parse(time1);
																											sInTime = new SimpleDateFormat("K:mm a").format(dateObj1);
																										}

																									} catch (final ParseException e) {
																										e.printStackTrace();
																									}
																							%>



																							<tr>
																								<td><center><%=date11%></center></td>
																								<td><center>
																										<a href="" data-toggle="modal"
																											data-target="#myModalView<%=g.getGate_pass_id()%>"
																											style="text-decoration: none; color: black; cursor: pointer;"><%=g.getEmployeeBean().getEmployee_code()%></a>
																									</center></td>
																								<td><center>
																										<a href="" data-toggle="modal"
																											data-target="#myModalView<%=g.getGate_pass_id()%>"
																											style="text-decoration: none; color: black; cursor: pointer;"><%=g.getEmployeeBean().getFirstname() + " " + g.getEmployeeBean().getLastname()%></a>
																									</center>
																								<td><center><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></center></td>
																								<td><center><%=g.getCompanyName()%></center></td>
																								<td><center><%=g.getTodec()%></center></td>
																								<td><center><%=sOutTime%></center></td>
																								<td><center><%=dInTime%></center></td>
																								<td><center><%=dOutTime%></center></td>
																								<td><center><%=sInTime%></center></td>
																								<td><center>
																										<a href="" data-toggle="modal"
																											data-target="#myModalView<%=g.getGate_pass_id()%>"
																											style="text-decoration: none; color: black; cursor: pointer;"><button
																												class="btn btn-primary btn-xs">Detail</button></a>
																									</center></td>
																							</tr>

																							<%
																								}
																							%>

																						</tbody>
																					</table>

																				</div>


																				<div class="tab-pane fade" id="profile">
																					<h4></h4>
																					<br>
																					<table class="table table-striped table-bordered zero-configuration">
																						<thead>
																							<tr bgcolor=" #d7dbdd">
																								<th width="100px"><center>Date</center></th>
																								<th><center>Code</center></th>
																								<th><center>Name</center></th>
																								<th><center>Department</center></th>
																								<th><center>Source</center></th>
																								<th><center>Destination</center></th>
																								<th width="100px"><center>Source
																										Out Time</center></th>
																								<th width="100px"><center>Destination
																										In Time</center></th>
																								<th width="100px"><center>Destination
																										Out Time</center></th>
																								<th width="100px"><center>Source
																										In Time</center></th>
																								<th width="100px"><center>Action</center></th>
																							</tr>
																						</thead>

																						<tbody>

																							<%
																								List<GatePassBean> listOfInterCompanyIN = allLMSListDAO.getListOfInterCompanyIN(parseCurrDate, gate_name);
																								for (GatePassBean g : listOfInterCompanyIN) {

																									String date = g.getSubmission_date_time();
																									String outTime = g.getSecurity_out_time();
																									String destInTime = g.getDestination_in_time();
																									String destOutTime = g.getDestination_out_time();
																									String inTime = g.getSecurity_in_time();

																									String[] split = date.split(" ");

																									String sOutTime = "-------";
																									String sInTime = "-------";
																									String dInTime = "-------";
																									String dOutTime = "-------";

																									String date11 = null;

																									try {
																										SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																										SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

																										Date result = formater.parse(split[0]);
																										date11 = AppDateFormat.format(result);

																										System.out.println(AppDateFormat.format(result));
																									} catch (ParseException e1) {
																										e1.printStackTrace();
																									}

																									try {
																										final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");

																										if (g.getSecurity_out_time() != null) {

																											String[] split1 = outTime.split(" ");
																											final String time = split1[1];
																											final Date dateObj = sdf.parse(time);
																											sOutTime = new SimpleDateFormat("K:mm a").format(dateObj);
																										}

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

																										if (g.getSecurity_in_time() != null) {
																											String[] split2 = inTime.split(" ");
																											final String time1 = split2[1];
																											final Date dateObj1 = sdf.parse(time1);
																											sInTime = new SimpleDateFormat("K:mm a").format(dateObj1);
																										}

																									} catch (final ParseException e) {
																										e.printStackTrace();
																									}
																							%>



																							<tr>
																								<td><center><%=date11%></center></td>
																								<td><center>
																										<a href="" data-toggle="modal"
																											data-target="#myModalView<%=g.getGate_pass_id()%>"
																											style="text-decoration: none; color: black; cursor: pointer;"><%=g.getEmployeeBean().getEmployee_code()%></a>
																									</center></td>
																								<td><center>
																										<a href="" data-toggle="modal"
																											data-target="#myModalView<%=g.getGate_pass_id()%>"
																											style="text-decoration: none; color: black; cursor: pointer;"><%=g.getEmployeeBean().getFirstname() + " " + g.getEmployeeBean().getLastname()%></a>
																									</center>
																								<td><center><%=g.getEmployeeBean().getDepartmentBean().getDepartment_name()%></center></td>
																								<td><center><%=g.getCompanyName()%></center></td>
																								<td><center><%=g.getTodec()%></center></td>
																								<td><center><%=sOutTime%></center></td>
																								<td><center><%=dInTime%></center></td>
																								<td><center><%=dOutTime%></center></td>
																								<td><center><%=sInTime%></center></td>
																								<td><center>
																										<a href="" data-toggle="modal"
																											data-target="#myModalView<%=g.getGate_pass_id()%>"
																											style="text-decoration: none; color: black; cursor: pointer;"><button
																												class="btn btn-primary btn-xs">Detail</button></a>
																									</center></td>
																							</tr>

																							<%
																								}
																							%>

																						</tbody>
																					</table>

																				</div>


																			</div>
																		</div>

																		<!-- /.panel-heading -->

																	</div>
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


										<%
											List<GatePassBean> listOfallGatePass = allLMSListDAO.getListOfAllGatePass(parseCurrDate, gate_name);
											for (GatePassBean g : listOfallGatePass) { //converstion of time 24 hours to 12 hours format

												String date = g.getSecurity_out_time();
												String date11 = g.getSecurity_in_time();
												String date22 = g.getSubmission_date_time();

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
														String[] split1 = date11.split(" ");
														final String time1 = split1[1];
														final Date dateObj1 = sdf.parse(time1);
														sInTime = new SimpleDateFormat("K:mm a").format(dateObj1);
													}
													if (g.getSubmission_date_time() != null) {
														String[] split2 = date22.split(" ");
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
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title" id="myModalLabel">Detail Of
															Gate Pass</h4>
													</div>

													<div class="modal-body">

														<%
															int company_id = g.getEmployeeBean().getCompanyListBean().getCompany_list_id();
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
	<script
		src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
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

	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script', 'www.google-analytics.com/analytics.js',
				'ga');

		ga('create', 'UA-96096445-1', 'auto');
		ga('send', 'pageview');
	</script>
</body>
</html>