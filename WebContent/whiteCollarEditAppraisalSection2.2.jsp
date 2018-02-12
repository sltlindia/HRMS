<%@page import="com.hrms.pms.bean.AppraisalTrainingBean"%>
<%@page import="com.hrms.pms.bean.Appraisal5sBean"%>
<%@page import="com.hrms.pms.bean.AppraisalKizenBean"%>
<%@page import="com.hrms.pms.bean.AppraisalLeaveBean"%>
<%@page import="com.hrms.pms.bean.QuterlyMonthBean"%>
<%@page import="com.hrms.pms.bean.GradeMasterBean"%>
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
    <title>Appraisal Section :1</title>
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
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int appraisal_id = 0;
if(request.getParameter("appraisal_id") != null){
	 appraisal_id =Integer.parseInt(request.getParameter("appraisal_id"));
}else{
	 appraisal_id = (Integer) request.getAttribute("appraisal_id");
}


AllListDAO  allListDAO = new AllListDAO();
List<AppraisalLeaveBean> listOfLeave = allListDAO.getappraisalLeave(appraisal_id);
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Appraisal</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Appraisal</h1>
				</div>
				/.col-lg-12
			</div>
			/.row -->
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Appraisal Section:1</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Appraisal Section:1</div> -->
						<div class="panel-body">
				<form action="whiteCollarSection22Edit" method="post" enctype="multipart/form-data">
							<div class="panel-group" id="accordion">
							<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>Attendance Detail</center></a>
										</h4>
										<input type="hidden" name="appraisal_id" value="<%=appraisal_id%>">
									</div>
									<div class="panel-body">
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Working Days</center></th>
									<th><center>Leave</center></th>
									<th><center>Late Coming</center></th>
									<th><center>Ratings</center></th>
									</tr>
									</thead>
									<%
									for(AppraisalLeaveBean appraisalLeaveBean : listOfLeave){
									%>
									<input type="hidden" name="aLeave_id" value="<%=appraisalLeaveBean.getAppraisal_leave_id()%>">
									<tbody>
									<tr>
									<td><center>299</center></td>
									<td><input type="text" name="leave" value="<%=appraisalLeaveBean.getLeave_count()%>" class="form-control"></td>
									<td><input type="text" name="lateComing" value="<%=appraisalLeaveBean.getLate_coming() %>" class="form-control"></td>
									<td><select class="form-control" name="attendanceGrade" id="attendanceGrade" required="required">
																<option value="">---- Select Rating ----</option>
										<%List<AppraisalGradeBean> listOfAppraisalGrade = allListDAO.getAppraisalGrade();
										for(AppraisalGradeBean g : listOfAppraisalGrade){
										if(appraisalLeaveBean.getAppraisalGradeBean().getAppraisal_grade_id() == g.getAppraisal_grade_id()){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>" selected="selected"><%=g.getAppraisal_grade_name()%></option>
										<%}else{ %>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%} %>
										<%} %>
														</select></td>									
									</tr>
									</tbody>
									<%} %>
									</table>
									</div>
									</div>
									
								</div>
							</div>
						<br>
							<!-- /.panel-body -->
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>Kaizen(Targeted Kaizen Minimum 6)</center></a>
										</h4>
									</div>
									<div class="panel-body">
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Total Kaizen Submitted</center></th>
									<th><center>Approved</center></th>
									<th><center>Remarks</center></th>
									<th><center>Ratings</center></th>
									</tr>
									</thead>
									
									<%List<AppraisalKizenBean> listOfKaizen = allListDAO.getappraisalKaizen(appraisal_id);
									for(AppraisalKizenBean appraisalKizenBean : listOfKaizen){
									%>
									<input type="hidden" name="aKizen_id" value="<%=appraisalKizenBean.getAppraisal_kaizen_id()%>">
									<tbody>
									<tr>
									<td><input type="text" name="totalKaizen" value="<%=appraisalKizenBean.getKizen()%>" class="form-control"></td>
									<td><input type="text" name="approvedKaizen" value="<%=appraisalKizenBean.getKizen_approve()%>" class="form-control"></td>
									<td><input type="text" name="remarkKizen" value="<%=appraisalKizenBean.getRemarks()%>" class="form-control"></td>
									<td><select class="form-control" name="kaizenGrade" id="kaizenGrade" required="required">
																<option value="">---- Select Rating ----</option>
										<%List<AppraisalGradeBean> listOfAppraisalGrade = allListDAO.getAppraisalGrade();
										for(AppraisalGradeBean g : listOfAppraisalGrade){
										if(appraisalKizenBean.getAppraisalGradeBean().getAppraisal_grade_id() == g.getAppraisal_grade_id()){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>" selected="selected"><%=g.getAppraisal_grade_name()%></option>
										<%}else{ %>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%} %>
										<%} %>
														</select></td>									
									</tr>
									</tbody>
									<%} %>
									</table>
									
									</div>
									</div>
									
								</div>
							</div>
							
							<br>
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>5S Score card(Targeted Score Minimum %)</center></a>
										</h4>
									</div>
									
									<div class="panel-body">
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Months</center></th>
									<th><center>Score</center></th>
									<th><center>Remarks</center></th>
									<th><center>Ratings</center></th>
									</tr>
									</thead>
									
									
									
									<%List<Appraisal5sBean> listOf5s = allListDAO.getappraisal5s(appraisal_id);
									for(Appraisal5sBean appraisal5sBean : listOf5s){
									%>
									<input type="hidden" name="a5s_id" value="<%=appraisal5sBean.getAppraisal_5s_id()%>">
									<tbody>
									<tr>
									<td><input type="hidden" name="qid" value="<%=appraisal5sBean.getQuterlyMonthBean().getQuarterly_month_id()%>"><%=appraisal5sBean.getQuterlyMonthBean().getQuarterly_month_name()%></td>
									<td><input type="text" name="qScore" value="<%=appraisal5sBean.getScore() %>" class="form-control"></td>
									<td><input type="text" name="qRemarks" value="<%=appraisal5sBean.getRemarks() %>" class="form-control"></td>
									<td><select class="form-control" name="qGrade" id="5sGrade" required="required">
																<option value="">---- Select Rating ----</option>
										<%List<AppraisalGradeBean> listOfAppraisalGrade = allListDAO.getAppraisalGrade();
										for(AppraisalGradeBean g : listOfAppraisalGrade){
										if(appraisal5sBean.getAppraisalGradeBean().getAppraisal_grade_id() == g.getAppraisal_grade_id()){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>" selected="selected"><%=g.getAppraisal_grade_name()%></option>
										<%}else{ %>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%} %>
										<%} %>
														</select></td>
									</tr>
									</tbody>
									<%} %>
									
									</table>
									
									</div>
									</div>
									
								</div>
							</div>
							<br>
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>Details Of Training Imparted</center></a>
										</h4>
									</div>
									<div class="panel-body">
									
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Topic</center></th>
									<th><center>Faculty</center></th>
									<th><center>Date</center></th>
									<th><center>Hrs</center></th>
									<th><center>Remarks</center></th>
									</tr>
									</thead>
									
									<tbody>
									<%List<AppraisalTrainingBean> listOfTraining = allListDAO.getappraisalTraining(appraisal_id);
									for(AppraisalTrainingBean appraisalTrainingBean : listOfTraining){
									%>
									<input type="hidden" name="atraining_id" value="<%=appraisalTrainingBean.getAppraisal_training_id()%>">
									<tr>
									<td><input type="text" name="tTopic" value="<%=appraisalTrainingBean.getTopic() %>" class="form-control"></td>
									<td><input type="text" name="tFaculty" value="<%=appraisalTrainingBean.getFaculty() %>" class="form-control"></td>
									<td><input type="date" name="tDate" value="<%=appraisalTrainingBean.getDate()%>" class="form-control"></td>
									<td><input type="text" name="tHrs" value="<%=appraisalTrainingBean.getHrs() %>" class="form-control"></td>
									<td><input type="text" name="tTrainingRemark" value="<%=appraisalTrainingBean.getRemarks()%>" class="form-control"></td>									
									</tr>
									<%} %>
									</tbody>
									</table>
									<center><input type="submit" name="submit" class="btn btn-primary" value="Next"></center>
									</div>
									</div>
									<input type="hidden" name="redirect1">
									
								</div>
							</div>
							
				</form>
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
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>


</body>

</html>