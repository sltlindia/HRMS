<%@page import="com.hrms.selfservice.bean.ProblemNatureBean"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.selfservice.bean.ComplaintVerifiedByBean"%>
<%@page import="com.hrms.selfservice.bean.ComplaintBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.selfservice.bean.ProblemNatureReplyBean"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.lms.bean.IntervieweeBean"%>
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
    <title>Complain Report</title>
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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">
<!-- <link href="css/timepicki.css" rel="stylesheet"> -->

<script type="text/javascript">

function changeOpenStatus(id) {
	
	if(id==1){
		/* document.getElementById('openStatus').value = "pendingInterview"; */
		$(".openStatus").val("pendingComplaint");
	}else if(id==2){
		/* document.getElementById('openStatus').value = "completedInterview"; */
		$(".openStatus").val("completedComplaint");	
	}
	
}

</script>
<script type="text/javascript">
		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#date" );
				     var $datepicker2 =  $( "#datee" );
				     var $datepicker3 =  $( "#date1" );
				     var $datepicker4 =  $( "#intervieweeDate" );
				     var $datepicker5 =  $( "#interviewDate" );
				     var $datepicker6 =  $( "#toInterviewDate" );
				     
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
								 
				 			 }
				      
				 		});
				      
				      $datepicker2.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
								 
				 			 }
				      
				 		});
				      
				      $datepicker3.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
								 
				 			 }
				      
				 		});
				      
				      $datepicker4.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
								 
				 			 }
				      
				 		});
				      $datepicker5.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
								 
				 			 }
				      
				 		});
				      
				      $datepicker6.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
								 
				 			 }
				      
				 		});
				 });
		



</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO(); 
int employee_id = user.getEmployee_master_id();
int manager_id = user.getManagerBean().getManager_id();
int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
List<ComplaintBean> listOfPendingComplaint  = allListSelfServiceDAO.getcomplaintList();;


String parseCurrDate = "";
String openStatus = "pendingComplaint";

SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat appFormater = new SimpleDateFormat("yy-mm-ddyy");
Date currDate = new Date();
parseCurrDate = simpleDateFormat.format(currDate);

if(request.getParameter("date") != null){
	parseCurrDate = request.getParameter("date");
}


if(request.getParameter("date1") != null){
	String unparseCurrDate = request.getParameter("date1");
	Date date = appFormater.parse(unparseCurrDate);
	parseCurrDate = simpleDateFormat.format(date);
	
}

if(request.getParameter("openStatus") != null){
	openStatus = request.getParameter("openStatus");
}



Date date = simpleDateFormat.parse(parseCurrDate);
String parseCurrDate1 = appFormater.format(date);

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
					<h3 class="page-header">Complaint Detail</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">

						<!-- /.panel-heading -->
						<div class="panel-body">


							<br>
							<!-- Nav tabs -->
							<ul class="nav nav-tabs nav-top-border no-hover-bg">

								<%if(openStatus.equalsIgnoreCase("pendingComplaint")){ %>
								<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#pendingComplaint"
														aria-controls="homeIcon" aria-expanded="true" onclick="changeOpenStatus(1)"><i
															class="icon-alert"></i> Pending</a></li>
									<%}else{ %>
								
								<li class="nav-item"><a class="nav-link"
														id="homeIcon-tab" data-toggle="tab" href="#pendingComplaint"
														aria-controls="homeIcon" aria-expanded="false" onclick="changeOpenStatus(1)"><i
															class="icon-alert"></i> Pending</a></li>
									<%} %>
								

								<%if(openStatus.equalsIgnoreCase("completedComplaint")){ %>
								<li class="nav-item"><a class="nav-link active"
														id="homeIcon-tab" data-toggle="tab" href="#completedComplaint" 
														aria-controls="homeIcon" aria-expanded="true" onclick="changeOpenStatus(2)">
														<i
															class="icon-android-checkbox-outline"></i> Completed</a></li>
									<%}else{ %>
								
								<li class="nav-item"><a class="nav-link"
														id="homeIcon-tab" data-toggle="tab" href="#completedComplaint" 
														aria-controls="homeIcon" aria-expanded="false" onclick="changeOpenStatus(2)">
														<i
															class="icon-android-checkbox-outline"></i> Completed</a></li>
									<%} %>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content px-1 pt-1">
								<%if(openStatus.equalsIgnoreCase("pendingComplaint")){ %>
								<div role="tabpanel" class="tab-pane fade active in" id="pendingComplaint" aria-labelledby="homeIcon-tab1" aria-expanded="true">
									<%}else{ %>
									<div role="tabpanel" class="tab-pane fade" id="pendingComplaint" aria-labelledby="homeIcon-tab1" aria-expanded="false">
										<%} %>
										<div class="panel-body">
										<div class="table table-responsive">
											<table class="table table-striped table-bordered table-hover file-export"
												border="1">

												<thead>
													<tr>
														<th>NO</th>
														<th>Employee Code</th>
														<th>Employee Name</th>
														<th>Department</th>
														<th>Extension No.</th>
														<th>Problem Nature</th>
														<th>Problem Description</th>
														<th>Date Of Submission</th>
														<th>Location</th>
													</tr>
												</thead>

												<tbody>
													<% 
									
                                   	for(ComplaintBean c1 : listOfPendingComplaint){
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
					   					}%>
													<tr>
														<td><%=c1.getComplaint_id() %></td>
														<td><%=c1.getEmployeeBean().getEmployee_code()%></td>
														<td><%=c1.getEmployeeBean().getFirstname()+" "+c1.getEmployeeBean().getLastname()%></td>
														<td><%=c1.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
														<td><%=c1.getExtension()%></td>
														<td><%=c1.getProblemNatureBean().getProblem_nature_name()%></td>
														<td><%=c1.getDescription() %></td>
														<td><%=ds%></td>
														<td><%=c1.getLocation()%></td>
														<%} %>

														<!-- <input type="text"  name="ManagerName" id="ManagerName"   value=""/> -->
													</tr>
												</tbody>
											</table>
											</div>
										</div>
									</div>




									<%if(openStatus.equalsIgnoreCase("completedComplaint")){ %>
									<div class="tab-pane fade active in" id="completedComplaint" aria-labelledby="homeIcon-tab1" aria-expanded="true">
										<%}else{ %>
										<div class="tab-pane fade" id="completedComplaint" aria-labelledby="homeIcon-tab1" aria-expanded="false">
											<%} %>




											<%
										String fromDate = "";
										String toDate = "";
										String department = "";
										String location = "";
										String nature = "";
										int count = 0;
										
										
										if(request.getParameter("fromDate") != null){ 
											fromDate = request.getParameter("fromDate");
											if(!fromDate.equalsIgnoreCase("")){
												count++;
											}
										}
										
										
										if(request.getParameter("toDate") != null){ 
											toDate = request.getParameter("toDate");
											if(!toDate.equalsIgnoreCase("")){
												count++;
											}
										}
											
										
										if(request.getParameter("department") != null){ 
											department = request.getParameter("department");
											if(!department.equalsIgnoreCase("") && !department.equalsIgnoreCase("0")){
												count++;
											}
										}
										
										
										
										if(request.getParameter("location") != null){ 
											location = request.getParameter("location");
											if(!location.equalsIgnoreCase("")){
												count++;
											}
										}
										
										
										if(request.getParameter("nature") != null){ 
											nature = request.getParameter("nature");
											if(!nature.equalsIgnoreCase("") && !nature.equalsIgnoreCase("0")){
												count++;
											}
										}
										
										
										%>


											<div class="panel-body">
												<form action="" method="post">
													<div class="row">
														<input type="hidden" name="openStatus" id="openStatus1"
															value="completedComplaint">

														<div class="col-md-2"
															style="padding-right: 0px; width: 130px;">
															<h6>From Date :</h6>
														</div>
														<div class="col-md-3">
															<input type="text" class="form-control" name="fromDate"
																id="interviewDate" value="<%=fromDate %>" placeholder="yyyy-MM-dd">
														</div>

														<div class="col-md-2"
															style="padding-right: 0px; width: 100px;">
															<center>
																<h6>To Date :</h6>
															</center>
														</div>
														<div class="col-md-3">
															<input type="text" class="form-control" name="toDate"
																id="toInterviewDate" value="<%=toDate %>" placeholder="yyyy-MM-dd">
														</div>


													</div>
													<br>


													<div class="row">
														<div class="col-md-2"
															style="padding-right: 0px; width: 130px;">
															<h6>Department :</h6>
														</div>
														<div class="col-md-3">
															<select class="form-control" name="department"
												id="department">
													<option value="0">--Select Department--</option>
													<%
														DepartmentDAO departmentDAO = new DepartmentDAO();
															List<DepartmentBean> listOfDepartment = departmentDAO.getListOfDepartment();
															for (DepartmentBean departmentBean : listOfDepartment) {
																	int dept_id = 0;
																if(!department.equalsIgnoreCase("")){
																	dept_id = Integer.parseInt(department);
																}
																
																if (dept_id == departmentBean.getDepartment_id()) {
																	
													%>
													
													<option value="<%=departmentBean.getDepartment_id()%>"
														selected="selected"><%=departmentBean.getDepartment_name()%></option>
													<%
														} else {
													%>
													<option value="<%=departmentBean.getDepartment_id()%>"><%=departmentBean.getDepartment_name()%></option>
													<%
														}
															}
													%>
											</select>
														</div>
														
														
														
														
														
														
														<div class="col-md-2"
															style="padding-right: 0px; width: 130px;">
															<h6>Problem Nature :</h6>
														</div>
														<div class="col-md-3">
															<select class="form-control" name="nature">
													<option value="0">--Select Problem Nature--</option>
													<%
														List<ProblemNatureBean> listOfProblemList = allListSelfServiceDAO.getListOfProblem();
														for (ProblemNatureBean problemNatureBean2 : listOfProblemList) { 
															
															int nature_id = 0;
															if(!nature.equalsIgnoreCase("")){
																nature_id = Integer.parseInt(nature);
															}
															
															if(nature_id == problemNatureBean2.getProblem_nature_id()){
															
													%>
													<option
														value="<%=problemNatureBean2.getProblem_nature_id()%>" selected="selected"><%=problemNatureBean2.getProblem_nature_name()%></option>
													
													<%}else{ %>
													
													<option
														value="<%=problemNatureBean2.getProblem_nature_id()%>"><%=problemNatureBean2.getProblem_nature_name()%></option>
														
													<%} %>
													
													<%
														}
													%>
												</select>
														</div>
														
														
														

														
													</div>
													
													
													<br>
													
													<div class="row">
														<div class="col-md-2"
															style="padding-right: 0px; width: 130px;">
															<h6>Location :</h6>
														</div>
														<div class="col-md-3">
															<input type="text" class="form-control" name="location"
																id="location" value="<%=location %>" >
														</div>

													</div>
													
													
													

													<center><input type="submit" class="btn btn-primary" name="submit" value="Submit"></center>
												</form>
												<hr>
												<div class="table table-responsive">
												<table
													class="table table-striped table-bordered table-hover file-export">
													<thead>
													<tr>
															<th>No</th>
															<th>Employee Code</th>
															<th>Employee Name</th>
															<th>Department</th>
															<th>Extension No.</th>
															<th>Problem Nature</th>
															<th>Date Of Submission</th>
															<th>Date Of Correction</th>
															<th>Location</th>
															<th>Concern Person</th>
														</tr>
													</thead>

													<tbody>
														<% 
										List<ComplaintBean> listOfComplaint1  =  allListSelfServiceDAO.getListOfComplaintBySearchEngine(fromDate, toDate, department, location,nature,count);
										
										
                                   	for(ComplaintBean c1 : listOfComplaint1){
                                   		String date_of_submission = c1.getDate();
                                   		String date_of_resolve = c1.getDate_of_resolve();
                          			  String ds = "-";
                          			  String dr = "-";
										   try {
					   							SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
					   							SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
					    						
					   							Date result = formater.parse(date_of_submission);
					   							Date result1 = formater.parse(date_of_resolve);
					   							ds = AppDateFormat.format(result);
					   							dr = AppDateFormat.format(result1);
					   					
					   							System.out.println(AppDateFormat.format(result));
					   						} catch (ParseException e1) {
					   							e1.printStackTrace();
					   					}%>
														<tr>
															<td><%=c1.getComplaint_id() %></td>
															<td><%=c1.getEmployeeBean().getEmployee_code()%></td>
															<td><%=c1.getEmployeeBean().getFirstname()+" "+c1.getEmployeeBean().getLastname()%></td>
															<td><%=c1.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
															<td><%=c1.getExtension()%></td>
															<td><%=c1.getProblemNatureBean().getProblem_nature_name()%></td>
															<td><%=ds%></td>
															<td><%=dr %></td>
															<td><%=c1.getLocation()%></td>
															<td>
																<%
                                         	int complaint_id = c1.getComplaint_id();      
                                         	List<ComplaintVerifiedByBean> listOfVerified = allListSelfServiceDAO.getComplaintVerifiedByPerson(complaint_id); 
											if(listOfVerified.size() != 0){                                    	
                                         	for(ComplaintVerifiedByBean cvb : listOfVerified){%>
																<%=cvb.getEmployeeBean().getFirstname()+" "+cvb.getEmployeeBean().getLastname() %>,
																<%}}%>
															</td>

														</tr>
														<%} %>
													</tbody>
												</table>
											</div>



											</div>
										</div>
									</div>
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
</section>
</div>
</div>
</div>



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
			<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
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
</body>
</html>

