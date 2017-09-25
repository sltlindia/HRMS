<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewEmployeeBean"%>
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
    <title>Exit Interview Form List</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/users.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
  </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%  
int manager_id = user.getManagerBean().getManager_id();

SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");

%>
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h4>Exit Interview List</h4>
			            <hr>
			        </div>
			    </div>
				<div class="row">
				    <div class="col-md-12 col-xs-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Pending Exit Interview List</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
				            <div class="card-body collapse in">
	               				 <div class="card-block card-dashboard">
	               				 	<div class="table-responsive">
				                        <table class="table table-striped table-bordered zero-configuration" width="100%">
				                            <thead>
				                                <tr>
			                                    	<th>Employee Name</th>
			                                    	<th>Department</th>
			                                    	<th>Designation</th>
			                                    	<th>Reporting Manager</th>
			                                    	<th>Date Of Joining</th>
			                                    	<th>Termination Date</th>
			                                    	<th>Action</th>
												</tr>
				                            </thead>
				                            <tbody>
									<%
									AllListExitFormalityDAO allListExitFormalityDAO = new AllListExitFormalityDAO();
									List<ExitInterviewEmployeeBean> listOfExitInterviewEmployees = allListExitFormalityDAO.getListOfExitInterviewEmployeesByManager(employee_master_id, manager_id);
									
									String jd = null;
									String td = null;
									
									for(ExitInterviewEmployeeBean e : listOfExitInterviewEmployees){
										
										String joiningDate = e.getDate_of_joining();
   										String terminationDate = e.getTermination_date();
										
   										try {
  											  
   											
    										Date result = formater.parse(joiningDate);
   											Date result1 = formater.parse(terminationDate);
   											
    										jd = AppDateFormat.format(result);
   											td = AppDateFormat.format(result1);
   											System.out.println(AppDateFormat.format(result));
   											
   											
   											
   										} catch (ParseException e1) {
   											e1.printStackTrace();
   										}	
   										
   										int managerId = Integer.parseInt(e.getReporting_manager());
   										LoginDAO loginDAO = new LoginDAO();
   										EmployeeBean employeeBean = loginDAO.getEmailId(managerId);
									%>
									<tr>
										<td><%=e.getEmployeeBean().getFirstname()+" "+e.getEmployeeBean().getLastname() %></td>
										<td><%=e.getDepartment() %></td>
										<td><%=e.getDesignation() %></td>
										<td><%=employeeBean.getManagerBean().getManager_name() %></td>
										<td><%=jd %></td>
										<td><%=td %></td>
										<td><a href="exitInterviewHRComment.jsp?exit_employee_id=<%=e.getExit_interview_employee_id()%>"><button class="btn btn-xs" style="background-color: #3BAFDA"><i class="ficon icon-edit"></i> Review</button></a></i></a></td>
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
				    
				    <div class="row">
				    <div class="col-md-12 col-xs-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Completed Exit Interview List</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
				            <div class="card-body collapse in">
	               				 <div class="card-body collapse in">
	               				 <div class="card-block card-dashboard">
				                        <div class="table-responsive">
				                        <table class="table table-striped table-bordered zero-configuration" width="100%">
				                            <thead>
				                                <tr>
			                                    	<th>Employee Name</th>
			                                    	<th>Department</th>
			                                    	<th>Designation</th>
			                                    	<th>Reporting Manager</th>
			                                    	<th>Date Of Joining</th>
			                                    	<th>Termination Date</th>
			                                    	<th>Action</th>
												</tr>
				                            </thead>
				                            <tbody>
											<%
											List<ExitInterviewEmployeeBean> listOfExitInterviewEmployeesReviewed = allListExitFormalityDAO.getListOfExitInterviewEmployeesReviewedByManager(employee_master_id, manager_id);
											
											String jd1 = null;
											String td1 = null;
											
											for(ExitInterviewEmployeeBean e : listOfExitInterviewEmployeesReviewed){
												
												String joiningDate = e.getDate_of_joining();
		   										String terminationDate = e.getTermination_date();
												
												try {
													  
		    										Date result = formater.parse(joiningDate);
		   											Date result1 = formater.parse(terminationDate);

		   											jd1 = AppDateFormat.format(result);
		   											td1 = AppDateFormat.format(result1);
		   											System.out.println(AppDateFormat.format(result));
		   											
		   											
		   											
		   										} catch (ParseException e1) {
		   											e1.printStackTrace();
		   										}	
												
												int managerId = Integer.parseInt(e.getReporting_manager());
		   										LoginDAO loginDAO = new LoginDAO();
		   										EmployeeBean employeeBean = loginDAO.getEmailId(managerId);
												
											%>
											<tr>
												<td><%=e.getEmployeeBean().getFirstname()+" "+e.getEmployeeBean().getLastname() %></td>
												<td><%=e.getDepartment() %></td>
												<td><%=e.getDesignation() %></td>
												<td><%=employeeBean.getManagerBean().getManager_name()%></td>
												<td><%=jd1 %></td>
												<td><%=td1 %></td>
												<td><a href="exitInterviewHRComment.jsp?exit_employee_id=<%=e.getExit_interview_employee_id()%>&action=reviewed"><button class="btn btn-xs" style="background-color: #3BAFDA"><i class="icon icon-eye4"></i> View</button></a></td>
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
				 </div>
			</section>
		</div>
	</div>
</div>
				    
				    
				    


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
    <script src="app-assets/js/scripts/pickers/dateTime/picker-date-time.min.js" type="text/javascript"></script>
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