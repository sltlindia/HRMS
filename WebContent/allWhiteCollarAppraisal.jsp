<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.pms.bean.ReviewBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
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
    <title>All WhiteCollar Appraisal</title>
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
     <script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
    <%@include file="header.jsp" %>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int manager_id = user.getManagerBean().getManager_id(); 
%>
<div class="app-content container center-layout mt-2">
	<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Review Section</h1>
			        </div>
			    </div>
			<br>	
<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Review Section</h1>
				</div>
				/.col-lg-12
			</div> -->
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Pending Appraisal List</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			<!--  <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Pending Appraisal List
                        </div>
                        /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Employee Name</th>
                                            <th>Role</th>
                                            <th>Month</th>
                                            <th>Year</th>
                                            <th>Submission Date</th>
                                            <th>Action</th>
                                            
                                        </tr>
                                    </thead>
                                      <tbody>
                                   <%
																		AllListDAO allListDAO  = new AllListDAO();
                                        	  List<AppraisalBean> listOfAppraisal = allListDAO.getWhiteAppraisalByManagerId(manager_id);
                                        	  for(AppraisalBean a : listOfAppraisal){
                                        		  
                                        		  String date = a.getDate_of_submission();
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
                                        <td><%=a.getEmployeeBean().getFirstname()+" "+a.getEmployeeBean().getLastname()%></td>
                                        <td><%=a.getEmployeeBean().getRoleBean().getRole_type()%></td>
                                        <td>
                                        	<%if(a.getQuterlyMonthBean().getQuarterly_month_id() != 5){%>
                                         <%=a.getQuterlyMonthBean().getMonth_duration()%>
                                        <%}else{ %>
                                        <%=a.getMonthBean().getMonth_name()%>
                                        <%}%>
                                        </td>
                                        <td>
                                        <%if(a.getMonthBean().getMonth_id() == 13 && a.getQuterlyMonthBean().getQuarterly_month_id() == 5) {
                                        int year = Integer.parseInt(a.getYearBean().getYear()) + 1;
                                        %>
                                        <%=a.getYearBean().getYear()%> - <%=year%>
                                        <%} else{%>
                                        <%=a.getYearBean().getYear()%>
                                        <%} %></td>
                                        <td><%=sd%></td>
                                        <td><a href="appraisalWhitecollarCheck?appraisal_id=<%=a.getAppraisal_id()%>&&employee_id=<%=a.getEmployeeBean().getEmployee_master_id()%>"><i class="icon-edit2" data-toggle="tooltip" data-placement="top" title="Show Appraisal History"></i></a></tr>
                                        <%} %>
                                    </tbody>
                                </table>
                                

                                       
                            </div>

                                        </div>
 <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;"> Approved Appraisal List</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
										
						<!-- <div class="panel-heading">
                           Approved Appraisal List
                        </div> -->
						
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example1">
                                    <thead>
                                        <tr>
                                            <th>Employee Name</th>
                                            <th>Role</th>
                                            <th>Month</th>
                                            <th>Year</th>
                                            <th>Submission Date</th>
                                            <th>Action</th>
                                            
                                        </tr>
                                    </thead>
                                      <tbody>
                                   <%
                                        	  List<AppraisalBean> listOfAppraisal1 = allListDAO.getWhiteAppraisalByManagerIdApproved(manager_id);
                                        	  for(AppraisalBean a : listOfAppraisal1){
                                        		  
                                        		  String date = a.getDate_of_submission();
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
                                        <td><%=a.getEmployeeBean().getFirstname()+" "+a.getEmployeeBean().getLastname()%></td>
                                        <td><%=a.getEmployeeBean().getRoleBean().getRole_type()%></td>
                                        <td>
                                        	<%if(a.getQuterlyMonthBean().getQuarterly_month_id() != 5){%>
                                         <%=a.getQuterlyMonthBean().getMonth_duration()%>
                                        <%}else{ %>
                                        <%=a.getMonthBean().getMonth_name()%>
                                        <%}%>
                                        </td>
                                        <td>
                                        <%if(a.getMonthBean().getMonth_id() == 13 && a.getQuterlyMonthBean().getQuarterly_month_id() == 5) {
                                        int year = Integer.parseInt(a.getYearBean().getYear()) + 1;
                                        %>
                                        <%=a.getYearBean().getYear()%> - <%=year%>
                                        <%} else{%>
                                        <%=a.getYearBean().getYear()%>
                                        <%} %></td>
                                        <td><%=sd%></td>
                                        <td><a href="whiteCollarFinalView.jsp?appraisal_id=<%=a.getAppraisal_id()%>"><i class="icon-eye4" data-toggle="tooltip" data-placement="top" title="Show Appraisal Data"></i></a>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>
                                </div>
                                </div>
                                </div>
                                <br>
                                  <h5><b>Legends :&nbsp;</b></h5>&nbsp;&nbsp;&nbsp;<i class="icon-edit2" style="color:#337ab7;"></i><b> : Edit Appraisal </b> &nbsp;&nbsp;&nbsp;<i class="icon-eye4" style="color:#337ab7;"></i><b> : View Appraisal </b>                            </div>

                                       
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
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
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
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
        
        $('#dataTables-example1').DataTable({
            responsive: true
    });
    });
    </script>
</body>
</html>