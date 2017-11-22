<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
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
    <title>Kaizen Manager</title>
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
    
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%

int kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
AllListDAO allListDAO = new AllListDAO();
List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment();
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Department Head</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>

	<div class="row">
				<div class="col-lg-12">
					<div class="card">
				        	<div class="card-header">
				        	<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
				        		<div class="col-lg-6">
				               		<h4 class="card-title" id="horz-layout-basic">Department Head</h4>
				                </div>
				            </div>
				                
								<div class="col-lg-6" align="right">
									<a href="kaizenView.jsp?kaizen_id=<%=kaizen_id%>"><i class="fa fa-chevron-circle-left fa-2x" style="color: white;"></i></a>
								</div>
								
							
						 
						<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<div align="right">
						</div>
						<br>
							<form action="kaizenManagerInsert" method="post" enctype="multipart/form-data">
												<input type="hidden" name="kaizen_id"
											value="<%=kaizen_id%>">
											<%if(request.getParameter("reject") != null){%>
											<input type="hidden" name="reject" value="rejectionUpdate">
									 		<%} %>
										<!-- /table -->
										<h3>Department Head Selection</h3>
										
											<div class="row">
												<div class="col-md-4">
												Select Department Head<p class="help-block">(Select Multiple Department Head)</p></th>
												</div>
												
												<div class="col-md-8">
												<select class="form-control" name="dept_id" id="dept_id" onChange="test(this.value)">
												<option value="">---Select Department Head---</option>
													<%
													for(DepartmentBean d : listOfDepartment){%>
													<option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name() %></option>
													<%} %>
													</select>
			
													<%for(DepartmentBean d :listOfDepartment){
														if(d.getDepartment_id() != 0){
														int dept_id = d.getDepartment_id();
														List<EmployeeBean> listOfEmployee = allListDAO.getAllEmployeeById(dept_id);
														if(listOfEmployee.size() != 0){
														%>
														<div id="<%=d.getDepartment_id()%>">
														<div class="row">
														<div class="col-lg-12">
															<h5><b><%=d.getDepartment_name() %></b></h5>
														</div>
														<% 
														for(EmployeeBean e : listOfEmployee){
													%>
													<div class="col-lg-4">
															<label><input type="checkbox" class="chkemployee"  name="mngEmployee" id="chkemployee" value="<%=e.getEmployee_master_id()%>"> <%=e.getFirstname()+" "+e.getLastname()%></label>
														</div>
													<%}%>
													</div>
													</div>	
													<%} } }%>
													</div>
											</div>
											
									
									<!-- /table-responsive -->
								<input type="hidden" name="redirection">
								<br>
								<center>
								<input type="submit" class="btn btn-primary" id="subm"  name="submit" value="SUBMIT">
								</center>		
							</form>
							<!-- /form -->
						</div>
						</div>
						</div>
					
						<!-- /.panel-body -->
					</div>
					<!-- /.panel-primary -->	
				</div>
				<!-- /.col-lg-12 -->
				
				</section>
					
			</div>
			<!-- /.row -->						
		
	</div>
	<!-- /.page-wrapper -->
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
	<script>
		$(document).ready(function() {
			for(var a = 1;a<=60;a++){
			$("#"+a).fadeOut('slow');
			}
		});
		
		
		function test(id) {
			$('#' + id).fadeIn('slow');

		}
	</script>
</body>
</html>