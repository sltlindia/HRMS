<%@page import="com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean"%>
<%@page import="com.hrms.meetingmanagemnet.dao.AllListMeetingDAO"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.selfservice.bean.ComplaintBean"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
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
    <title>Meeting Report</title>
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
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">

<link href="offlinetimepicker/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link href="offlinetimepicker/mdtimepicker.css" rel="stylesheet" type="text/css">

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	
<%
SimpleDateFormat HHmmaa = new SimpleDateFormat("hh:mm aa");
SimpleDateFormat mmddyyyy = new SimpleDateFormat("dd/MM/yyyy");
%>		

<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Meeting Report</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>

				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				               <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Meeting Calender</h4>
				                </div>
				            </div>
						<div class="card-body collapse in">
					        <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
											<%
										String fromDate = "";
										String toDate = "";
										String department = "";
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
										
										
										
										
										%>


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
																id="fromDate" value="<%=fromDate %>" placeholder="yyyy-MM-dd">
														</div>

														<div class="col-md-2"
															style="padding-right: 0px; width: 100px;">
															<center>
																<h6>To Date :</h6>
															</center>
														</div>
														<div class="col-md-3">
															<input type="text" class="form-control" name="toDate"
																id="toDate" value="<%=toDate %>" placeholder="yyyy-MM-dd">
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
														
													</div>
													
													
													<br>
													
													
													
													

													<center><input type="submit" class="btn btn-primary" name="submit" value="Submit"></center>
												</form>
												<hr>

												<table class="table table-striped table-bordered table-hover file-export" border="1">
													<thead>
													<tr>
															<th>Name</th>
															<th>Department</th>
															<th>Date</th>
															<th>Time Period</th>
															<th>Room Name</th>
														</tr>
													</thead>

													<tbody>
														<% 
														AllListMeetingDAO allListMeetingDAO = new AllListMeetingDAO();
										List<MeetingBookingDetailBean> listOfMeeting  =  allListMeetingDAO.getListOfMeetingBySerchEngine(fromDate, toDate, department,count);
											for(MeetingBookingDetailBean meetingBookingDetailBean : listOfMeeting){
										%>
													<tr>
														<td><%=meetingBookingDetailBean.getEmployee_name() %></td>
														<td><%=meetingBookingDetailBean.getDepartmentBean().getDepartment_name()%></td>
														<td><%=mmddyyyy.format(meetingBookingDetailBean.getDate())%></td>
														<td><%=HHmmaa.format(meetingBookingDetailBean.getFrom_time())%> to <%=HHmmaa.format(meetingBookingDetailBean.getTo_time())%></td>
														<td><%=meetingBookingDetailBean.getMeetingRoomDetailBean().getFacility_name()%></td>
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
	<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
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
   
	
	<script type="text/javascript">


	
		
		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#fromDate" );
				     var $datepicker2 =  $( "#toDate" );
				     
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 				 $('#toDate').val(dateStr);
				 			 }
				      
				 		});
				      
				      $datepicker2.datepicker({		
				 			dateFormat: 'yy-mm-dd' , 
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 			 }
				      
				 		});
				      
				     
				 });
		



</script>
</body>
</html>