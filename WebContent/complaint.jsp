<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.selfservice.bean.DownloadBean"%>
<%@page import="com.hrms.selfservice.bean.ComplaintBean"%>
<%@page import="com.hrms.selfservice.bean.ProblemNatureBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//Dlabel HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dlabel">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
</head>
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">
<script type="text/javascript">

function checkInteger(id) {
	
	var a = document.getElementById(id).value;
	
	if(isNaN(a)){
		alert("Only numeric value is valid.");
		document.getElementById(id).value = 0;
	}
}

function demo(complaint_id){
	
	var retVal = confirm("Are you sure?");
		if( retVal == true )
			{
			window.location.replace("complaintDelete?complaint_id="+complaint_id);
			}
				else
  			{
 				window.location.replace("complaint.jsp");
  				return false;
		 		}
}
</script>



<body>
	<%
		int emp_id = user.getEmployee_master_id();
		int i = 0;
		int j=0 ;
		int manager_id = user.getManagerBean().getManager_id();
		int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
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
				               				<h4 class="card-title" id="horz-layout-basic">Basic Information</h4>
				                		</div>
				            		</div>
		
		<div class="card-body collapse in">
	  <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<div class="panel-body">
							<ul class="nav nav-tabs nav-top-border no-hover-bg">
							<li class="nav-item">
							<a class="nav-link active" id="homeIcon-tab1" data-toggle="tab" href="#complaint" aria-controls="homeIcon1" aria-expanded="true"><i class="icon-ios-plus"></i> F-IT-01_Complain
										Register_2017_FINAL</a>
							</li>
							<li class="nav-item">
							<a class="nav-link" id="profileIcon-tab1" data-toggle="tab" href="#download" aria-controls="profileIcon1" aria-expanded="false"><i class="icon-download"></i> Download Link</a>
							</li>
								 <%if(manager_id == 65 || manager_id == 5 || under_manager_id == 65){ %>
								 <li class="nav-item">
							<a class="nav-link" id="profileIcon-tab1" data-toggle="tab" href="#complaint1" aria-controls="profileIcon1" aria-expanded="false"><i class="icon-question"></i> Complain Register</a>
							</li>
									<% } %>			
							</ul>

							<div class="tab-content px-1 pt-1">
							<div role="tabpanel" class="tab-pane fade active in" id="complaint" aria-labelledby="homeIcon-tab1" aria-expanded="true">
									<form action="complaintInsert" melabelod="post"
										enctype="multipart/form-data">
										<br>
										<div class="row">
											<div class="col-lg-3">
												<label>Employee Name</label> <label>:</label> <font
													color="#3BAFDA"><%=user.getFirstname() + " " + user.getLastname()%></font>
											</div>
											<input type="hidden" name="employee_master_id"
												class="form-control"
												value="<%=user.getEmployee_master_id()%>">
											<div class="col-lg-2">
												<label>Employee Code</label> <label>:</label> <label
													style="color: #3BAFDA"><%=user.getEmployee_code()%></label>
											</div>
											<div class="col-lg-3">
												<label>Department</label> <label>:</label> <label
													style="color: #3BAFDA"><%=user.getDepartmentBean().getDepartment_name()%></label>
											</div>
											<div class="col-lg-4">
												<label>Current Date</label> <label>:</label>
												<%
													DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
													Date today = Calendar.getInstance().getTime();

													String date1 = dateFormat.format(today);

													String d = null;
													String currenlabelate = null;

													try {

														SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");

														Date result = sdf.parse(date1);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
														currenlabelate = AppDateFormat1.format(result);
														d = AppDateFormat.format(result);
														System.out.println(AppDateFormat.format(result));
													} catch (ParseException e1) {
														e1.printStackTrace();
													}
												%>
												<label style="color: #3BAFDA"><%=date1%></label>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-lg-4">
												<label>Extension No.</label> <input type="text"
													class="form-control" name="extension" id="extension"
													placeholder="Enter extension no"
													onchange="checkInteger(this.id)" required>
											</div>
											<div class="col-lg-4">
												<label>Problem Nature</label> <select class="form-control"
													name="problem_nature" id="problem_nature"
													onchange="autoShow(this.value)" required="required">
													<option value="">--Select Problem Nature--</option>
													<%
														AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
														List<ProblemNatureBean> listOfProblemList = allListSelfServiceDAO.getListOfProblem();

														for (ProblemNatureBean problemNatureBean2 : listOfProblemList) {
													%>
													<option
														value="<%=problemNatureBean2.getProblem_nature_id()%>"><%=problemNatureBean2.getProblem_nature_name()%></option>
													<%
														}
													%>
												</select>
											</div>
											<div class="col-lg-4">
												<label>Location</label> <input type="text"
													class="form-control" name="location" id="location"
													placeholder="Enter Location" required>
											</div>

										</div>
										<hr>
										<div class="row">
											<div class="col-lg-12">
												<!-- <label>Deliverable</label> -->
												<label>Problem Description</label><br>
												<textarea id="limiter" rows="5" cols="5"
													class="form-control" name="problem_desc"
													placeholder="Description(max lenghth 1000 words.)"
													maxlength="500" required></textarea>
												<!-- <textarea id="limiter" rows="5" cols="5" class="form-control" name="deliverable" value="" placeholder="Machine Parameters To Be Delivered" maxlength="500"  required></textarea> -->
											</div>

										</div>

										<!-- /.row -->
										<hr>
										<input type="hidden" name="redirect" value="">
										<center>
											<input type="submit" value="Submit" class="btn btn-primary">
											<input type="reset" value="Reset" class="btn btn-danger">
										</center>
										<br>
									</form>
									<div class="panel-group" id="chirag">
										<div class="panel panel-danger">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#chirag"
														href="#collapseOne">Complaint History</a>
												</h4>
											</div>

											<div class="panel-body">
												<div class="dataTable_wrapper">
												<div class="table-responsive"></div>
													<table
														class="table table-striped table-bordered table-hover zero-configuration">
														
														<thead>
															<tr>
																<th>No.</th>
																<th>Employee Name</th>
																<th>Problem Nature</th>
																<th>Submission Date</th>
																<th>Status</th>
																<th>Action</th>

															</tr>
														</thead>
														<tbody>
															<%
																AllListSelfServiceDAO allListSelfServiceDAO2 = new AllListSelfServiceDAO();
																List<ComplaintBean> listOfcomp = allListSelfServiceDAO.getcomplaintByEmployeeId(emp_id);

																for (ComplaintBean a : listOfcomp) {

																	String date = a.getDate();
																	String sd = null;
																	try {

																		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																		Date result = formater.parse(date);
																		SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																		sd = AppDateFormat.format(result);

																	} catch (ParseException e1) {
																		e1.printStackTrace();
																	}
															%>

															<tr class="odd gradeX">
																<td><%=i = i + 1%>
																<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
																<td><%=a.getProblemNatureBean().getProblem_nature_name()%></td>
																<td><%=sd%></td>
																<td><%=a.getStatus()%>
																<td><a href="" data-toggle="modal"
																	data-target="#myModalView<%=a.getComplaint_id()%>"><i
																		class="icon icon-eye4"
																		data-toggle="tooltip" data-placement="top"
																		title="View Broadcast"></i></a>&nbsp; <%
 	if (a.getStatus().equalsIgnoreCase("pending")) {
 %>

																	<a
																	href="complaintUpdate.jsp?complaint_id=<%=a.getComplaint_id()%>"><i
																		class="icon icon-edit2" data-toggle="tooltip"
																		data-placement="top" title="Update Complaint""></i></a>

<a href="complaintDelete?complaint_id=<%=a.getComplaint_id()%>"><i
																		class="icon icon-trash" style="color: red;
																		data-toggle="tooltip" data-placement="top"
																		title="Delete Complaint"
																		onclick="demo(<%=a.getComplaint_id()%>)"></i></a> 
<%
 	}
 %>






																</td>
															</tr>
															<%
																}
															%>
														</tbody>
													</table>


													<%
														for (ComplaintBean a : listOfcomp) {
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
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">&times;</button>
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
																		<td><%=a.getCorrection_datetime()%></td>
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
													<%
														}
													%>

													<h5>
														<b>Legends :&nbsp;</b>
													</h5>
													&nbsp;&nbsp;&nbsp;<i class="icon  icon-edit2"
														style="color: #3BAFDA;"></i><b> : Edit Complaint </b>
													&nbsp;&nbsp;&nbsp;<i class="icon icon-eye4"
														style="color: #3BAFDA;"></i><b> : View Complaint </b>
													&nbsp;&nbsp;&nbsp;<i class="icon icon-trash"
														style="color: red;"></i><b> : Delete Complaint </b>
														
														
												</div>


											</div>
										</div>
									</div>

								</div>
								
								<div class="tab-pane fade" id="complaint1" aria-labelledby="homeIcon-tab1" aria-expanded="false">
									<form action="complaintInsert" melabelod="post"
										enctype="multipart/form-data">
										<br>
										<div class="row">
											<div class="col-lg-2">
											<label>Employee Name</label>
											</div>
											<div class="col-lg-4">
											<input list="employee" class="form-control" name="employee_name" placeholder="Select Employee Code" onchange="replica(this.value)" required>
			  					<datalist id="employee">
			  				 		<%
			  				 		AllListDAO allListDAO = new AllListDAO();
			  				 		List<EmployeeBean> listOfEmployee = allListDAO.getFullListOfEmployee();
			  				 		for(EmployeeBean e : listOfEmployee){
			  				 		%>
			  				 			 		<option value="<%=e.getEmployee_code()+","+e.getFirstname()+" "+e.getLastname()+","+e.getDepartmentBean().getDepartment_name()%>"/>
			  				 		<%} %>
		                         </datalist>
								
											</div>
											<input type="hidden" name="employee_master_id"
												class="form-control"
												value="<%=user.getEmployee_master_id()%>">
								
										</div>
										<hr>
										<div class="row">
											<div class="col-lg-4">
												<label>Extension No.</label> <input type="text"
													class="form-control" name="extension" id="extension"
													placeholder="Enter extension no"
													onchange="checkInteger(this.id)" required>
											</div>
											<div class="col-lg-4">
												<label>Problem Nature</label> <select class="form-control"
													name="problem_nature" id="problem_nature"
													onchange="autoShow(this.value)" required="required">
													<option value="">--Select Problem Nature--</option>
													<%
														List<ProblemNatureBean> listOfProblemList1 = allListSelfServiceDAO.getListOfProblem();

														for (ProblemNatureBean problemNatureBean2 : listOfProblemList1) {
													%>
													<option
														value="<%=problemNatureBean2.getProblem_nature_id()%>"><%=problemNatureBean2.getProblem_nature_name()%></option>
													<%
														}
													%>
												</select>
											</div>
											<div class="col-lg-4">
												<label>Location</label> <input type="text"
													class="form-control" name="location" id="location"
													placeholder="Enter Location" required>
											</div>

										</div>
										<hr>
										<div class="row">
											<div class="col-lg-12">
												<!-- <label>Deliverable</label> -->
												<label>Problem Description</label><br>
												<textarea id="limiter" rows="5" cols="5"
													class="form-control" name="problem_desc"
													placeholder="Description(max lenghth 1000 words.)"
													maxlength="500" required></textarea>
												<!-- <textarea id="limiter" rows="5" cols="5" class="form-control" name="deliverable" value="" placeholder="Machine Parameters To Be Delivered" maxlength="500"  required></textarea> -->
											</div>

										</div>

										<!-- /.row -->
										<hr>
										<input type="hidden" name="redirect" value="">
										<center>
											<input type="submit" value="Submit" class="btn btn-primary">
											<input type="reset" value="Reset" class="btn btn-danger">
										</center>
										<br>
									</form>

								</div>			
								
								
								
								

								
								
								<!-- Download link -->
								<div class="tab-pane fade" id="download" role="tabpanel" aria-labelledby="dropdownIcon2-tab1" aria-expanded="false">
														<form action="downloadInsert" melabelod="post"
										enctype="multipart/form-data">
										<br>
										<div class="row">
											<div class="col-lg-3">
												<label>Employee Name</label> <label>:</label> <font
													color="#3BAFDA"><%=user.getFirstname() + " " + user.getLastname()%></font>
											</div>
											<input type="hidden" name="employee_master_id"
												class="form-control"
												value="<%=user.getEmployee_master_id()%>">
											<div class="col-lg-2">
												<label>Employee Code</label> <label>:</label> <label
													style="color: #3BAFDA"><%=user.getEmployee_code()%></label>
											</div>
											<div class="col-lg-3">
												<label>Department</label> <label>:</label> <label
													style="color: #3BAFDA"><%=user.getDepartmentBean().getDepartment_name()%></label>
											</div>
											<div class="col-lg-4">
												<label>Current Date</label> <label>:</label>
												<%
													DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
													Date today1 = Calendar.getInstance().getTime();

													String date2 = dateFormat.format(today);

													String e = null;
													String currenlabelate1 = null;

													try {

														SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");

														Date result = sdf.parse(date2);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
														currenlabelate = AppDateFormat1.format(result);
														d = AppDateFormat.format(result);
														System.out.println(AppDateFormat.format(result));
													} catch (ParseException e1) {
														e1.printStackTrace();
													}
												%>
												<label style="color: #3BAFDA"><%=date2%></label>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-lg-4">
												<label>Extension No.</label> <input type="text"
													class="form-control" name="extension" id="extension"
													placeholder="Enter extension no"
													onchange="checkInteger(this.id)" required>
											</div>
											
											<div class="col-lg-8">
												<label>Link</label> <input type="text"
													class="form-control" name="link" id="link"
													placeholder="Enter link" required>
											</div>

										</div>
									

										<!-- /.row -->
										<hr>
										<input type="hidden" name="redirect" value="">
										<center>
											<input type="submit" value="Submit" class="btn btn-primary">
											<input type="reset" value="Reset" class="btn btn-danger">
										</center>
										<br>
									</form>
									
												<div class="panel-group" id="chirag">
										<div class="panel panel-danger">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#chirag"
														href="#collapseOne">Complaint History</a>
												</h4>
											</div>

											<div class="panel-body">
												<div class="dataTable_wrapper">
												<div class="table table-responsive">
													<table
														class="table table-striped table-bordered table-hover zero-configuration">
														
														<thead>
															<tr>
																<th>No.</th>
																<th>Employee Name</th>
																<th>Link</th>
																<th>Submission Date</th>
																
																<th>Status</th>
																<th>Action</th>

															</tr>
														</thead>
														<tbody>
															<%
																AllListSelfServiceDAO allListSelfServiceDAO3 = new AllListSelfServiceDAO();
																List<DownloadBean> listOfdownload = allListSelfServiceDAO.getdownloadByEmployeeId(emp_id);

																for (DownloadBean a : listOfdownload) {

																	String date = a.getDate();
																	String sd = null;
																	try {

																		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
																		Date result = formater.parse(date);
																		SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
																		sd = AppDateFormat.format(result);

																	} catch (ParseException e1) {
																		e1.printStackTrace();
																	}
															%>

															<tr class="odd gradeX">
																<td><%=j = j + 1%>
																<td><%=a.getEmployeeBean().getFirstname() + " " + a.getEmployeeBean().getLastname()%></td>
																<td><%=a.getLink() %></td>
																<td><%=sd%></td>
																<td><%=a.getStatus()%>
																
																<td> <a href="" data-toggle="modal"
																	data-target="#myModalView<%=a.getDownload_id()%>">
<%
 	if (a.getStatus().equalsIgnoreCase("pending")) {
 %>

																	<a
																	href="downloadDelete?download_id=<%=a.getDownload_id()%>"><i
																		class="icon icon-trash" style="color: red"
																		data-toggle="tooltip" data-placement="top"
																		title="Delete Link"
																		onclick="demo(<%=a.getDownload_id()%>)"></i></a>  <%
 	}else{
 		%>
 		<a href="" data-toggle="modal"
																	data-target="#myModalView1<%=a.getDownload_id()%>"><i
																		class="icon icon-eye4"
																		data-toggle="tooltip" data-placement="top"
																		title="View Detail"></i></a> 
 		
 <%	
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

													<%
														for (ComplaintBean a : listOfcomp) {
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
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">&times;</button>
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
																		<td><%=a.getCorrection_datetime()%></td>
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
													<%
														}
													%>




<%
														for (DownloadBean b : listOfdownload) {
													%>
													<div class="modal fade"
														id="myModalView1<%=b.getDownload_id()%>" tabindex="-1"
														role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">
														<%
															int download_id = b.getDownload_id();
																String status = b.getStatus();
														%>
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">&times;</button>
																	<h4 class="modal-title" id="myModalLabel"></h4>
																</div>
																<table class="table">
																	<tr>
																		<td><label>&nbsp;Complaint Done By</label></td>
																		<td>:</td>
																		<td><%=b.getEmployeeBean().getFirstname() + " " + b.getEmployeeBean().getLastname()%></td>
																	</tr>
																	
																	<%
																		String ds = b.getDate();
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
																		<td><label>&nbsp;Link</label></td>
																		<td>:</td>
																		<td><%=b.getLink()%></td>
																	</tr>
																	<%
																		if (status.equalsIgnoreCase("completed")) {
																	%>
																	<tr>
																		<td><label>&nbsp;Reply</label></td>
																		<td>:</td>
																		<td><%=b.getReply()%></td>
																	</tr>
																	
																	<tr>
																		<td><label>&nbsp;Remarks</label></td>
																		<td>:</td>
																		<td><%=b.getRemarks()%></td>
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
													<%
														}
													%>



													<h5>
														<b>Legends :&nbsp;</b>
													</h5>
													&nbsp;&nbsp;&nbsp;<i class="icon icon-trash"
														style="color: red;"></i><b> : Delete Link</b>
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
<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	 <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
	
	
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
	</body>
</html>