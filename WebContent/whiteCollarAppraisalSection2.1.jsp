<%@page import="com.hrms.pms.bean.WorkBehaviourBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.AppraisalGradeBean"%>
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
    <title>Appraisal</title>
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
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%
int employee_code = (int)request.getAttribute("employee_id");
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				 <div class="card">
				        	 <div class="card-header">
			<div class="row">
				<div class="col-lg-12">
				<br>
					<center><h3>Compentency</h3>
					<h4>(To be completed by the HOD / Appraiser)</h4>
					<h4>Weightage: 15%</h4></center>
					<hr>
				</div>
				<!-- /.col-lg-12 -->
			</div>
<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
				<br>
					<center><h3>Compentency</h3>
					<h4>(To be completed by the HOD / Appraiser)</h4>
					<h4>Weightage: 15%</h4>
					</center>
					<hr>
				</div>
				/.col-lg-12
			</div>
			/.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
				<form action="workGradeInsert" method="post" enctype="multipart/form-data">
				<input type="hidden" name="appraisal_id" value="<%=request.getAttribute("appraisal_id")%>">
							<div class="panel-group" id="accordion">
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">
											
												<div class="table-responsive">
													<div class="card box-shadow-0" data-appear="appear"  style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
													<table class="table table-bordered">
													<thead style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
														<tr>
														<th style="border-bottom: 1px solid #607D8B;" colspan="2"><h5><center><b>Work Behaviors</b></center></h5></th>
														<th style="border-bottom: 1px solid #607D8B;"><h5><center><b>Rating(1 to 5)</b></center></h5></th>
														</tr>
													</thead>
													<tbody>
													
													<%
													AllListDAO allListDAO = new AllListDAO();
													List<WorkBehaviourBean> listOfWorkBehaviour = allListDAO.getWorkBehaviour();
													for(int i=0;i<listOfWorkBehaviour.size();i++){
														WorkBehaviourBean w = listOfWorkBehaviour.get(i);
													%><input type="hidden" name="work_id" value="<%=w.getWork_behaviors_id()%>">
													<tr>
														<td width="5%"><font size="3"><center><%=i+1%></center></font></td>
														<td><b><font size="3"><%=w.getWork_behaviors_name() %></font></b><br>
														<font size="2"><%=w.getWork_behaviors_desc() %></font><br>
														</td>
														<td width="15%"><select class="form-control" name="grade_id" required="required" style="width: 200px">
																			<option value="">---- Select Rating ----</option>
																			<% 	
																			List<AppraisalGradeBean> listOfAppraisalGrade = allListDAO.getAppraisalGrade();
																			for(AppraisalGradeBean g : listOfAppraisalGrade){
																			if(g.getAppraisal_grade_id()!=0){
																			%>
																			<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
																			<%} }%>
														</select></td>
													</tr>
													<%} %>
													</tbody>
											</table>
												<center><a><input type="submit" value="Next" class="btn btn-primary"></a></center>
												<br>
											</div>
											</div>
											</div>
											</div>
											</div>
											</form>
											</div>
											</div>
											</div>
											<center>
											<input type="hidden" name="employee_id" value="<%= employee_code%>">
											<input type="hidden" name="redirect">
											
								
									</center>
											
											</div>
											</div>
				</form>


					</div>

					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
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
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>


</body>

</html>
											