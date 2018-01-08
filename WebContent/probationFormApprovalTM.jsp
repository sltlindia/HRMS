<%@page import="com.hrms.probation.bean.ProbationExtendBean"%>
<%@page import="com.hrms.probation.bean.ProbationTopManagementApprovalBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentManagerBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.probation.bean.AttributeBean"%>
<%@page import="com.hrms.probation.dao.AllListProbationDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.hrms.pms.bean.CurrencyBean"%>
<%@page import="com.hrms.pms.bean.PriorityBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.bean.CriteriaPerBean"%>
<%@page import="com.hrms.pms.dao.CriteriaPerDAO"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="com.hrms.pms.bean.GradeMasterBean"%>
<%@page import="com.hrms.pms.bean.SoftskillBean"%>
<%@page import="com.hrms.pms.bean.TechnicalBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>SLTL HRMS</title>
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
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns " onload="startTimer()">
<%int manager_id = user.getManagerBean().getManager_id(); %>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Probation Assessment</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
		<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Probation Form(Employees)</h4>
				                </div>
				            </div>
			 <div class="card-body collapse in">
				<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
				<div class="panel-body">
						<div class="panel-group" id="accordion"  style=" border: 2px solid #bbb7b7b0; border-radius: 5px; ">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									&nbsp;Approval Pending Employee List</h4>
								</div>
					<!-- 	<div class="panel-body">
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
									Approval Pending Employee List</h3>
								</div> -->
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Employee Name</th>
									<th>Action</th>
								</tr>
								<%
									AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
									int top_management_id  = user.getEmployee_master_id();
										List<ProbationTopManagementApprovalBean> listOfEmployee = allListProbationDAO.getListOfTopManagementApproval(top_management_id);
										for(ProbationTopManagementApprovalBean ptm : listOfEmployee){
											int probation_assessment_manager_id = ptm.getProbationAssessmentManagerBean().getProbation_assessment_manager_id();
											String hr_approval = ptm.getProbationAssessmentManagerBean().getHr_approval();
											String tm_approval = ptm.getProbationAssessmentManagerBean().getTop_management_approval();
											int emp_id = ptm.getProbationAssessmentManagerBean().getEmployeeBean().getEmployee_master_id();
											String authority = ptm.getProbationAssessmentManagerBean().getEmployeeBean().getRoleBean().getRole_authority();
								if(hr_approval.equalsIgnoreCase("approved") &&  tm_approval.equalsIgnoreCase("pending")){
								%>
								<tr>
									<td><%=ptm.getProbationAssessmentManagerBean().getEmployeeBean().getFirstname() + " " + ptm.getProbationAssessmentManagerBean().getEmployeeBean().getLastname()%></td>
									
									<td>
									<a
										href="probationListByIdIndirectApproval.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-compose" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											</td>
									</tr><%}}
								%>
							</table>
							</div>
							</div>
							<br>
							<div class="panel-body">
						
						
						<div class="panel-group" id="accordion"  style=" border: 2px solid #bbb7b7b0; border-radius: 5px; ">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									&nbsp;Approved Employee List</h4>
								</div>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Employee Name</th>
									<th>Action</th>
								</tr>
									<%List<ProbationTopManagementApprovalBean> listOfEmployees = allListProbationDAO.getListOfAllReviewsTMApprove(top_management_id);
									for (ProbationTopManagementApprovalBean pa : listOfEmployees) {
										int emp_id = pa.getProbationAssessmentManagerBean().getEmployeeBean().getEmployee_master_id();
										String authority = pa.getProbationAssessmentManagerBean().getEmployeeBean().getRoleBean().getRole_authority();
										int extended = 6;
										int probationmanager_id = pa.getProbationAssessmentManagerBean().getProbation_assessment_manager_id();
										String status = null;
										List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
										for(ProbationExtendBean p : listForExtend){
											status  = p.getStatus();
											
										}
										
										List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO.getListOfScoreByEmpId(emp_id);
										for(ProbationAssessmentManagerBean li : listOfExtended1){
											int probationmanager_idd = li.getProbation_assessment_manager_id();
											
											List<ProbationExtendBean> listForExtend1 = allListProbationDAO.getProbationExtend(probationmanager_idd);
											for(ProbationExtendBean p1 : listForExtend){
												String extend_period = p1.getExtended_period();
												extended = extended + Integer.parseInt(extend_period);
												
											}
										}
										long maxValue = 0;
										if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1")
												|| authority.equals("T2") || authority.equals("T3") || authority.equals("A1")
												|| authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
											maxValue = allListProbationDAO.getCount(emp_id);
										} else {
											maxValue = allListProbationDAO.getCountForM2(emp_id);
										}
											
										String employee_name = pa.getProbationAssessmentManagerBean().getEmployeeBean().getFirstname() + " " + pa.getProbationAssessmentManagerBean().getEmployeeBean().getLastname();
								%>

								<tr>
									<td><%=pa.getProbationAssessmentManagerBean().getEmployeeBean().getFirstname() + " " + pa.getProbationAssessmentManagerBean().getEmployeeBean().getLastname()%></td>
									
									
									<%if(maxValue == extended){%>
									<td>
									<a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-eye" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											</td>
											<%}else{ %>
											<td>Extended</td>
											<%} %>
											
								</tr>
								<%
									}
								%>
							</table>
							</div>
							</div>
							<br>
							<div class="panel-body">
						
						
						<div class="panel-group" id="accordion"  style=" border: 2px solid #bbb7b7b0; border-radius: 5px; ">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									&nbsp;Rejected Employee List</h4>
								</div>
							<!-- <div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
									Rejected Employee List</h3>
								</div> -->
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Employee Name</th>
									<th>Action</th>
								</tr>
								<%
									List<ProbationAssessmentManagerBean> listOfEmployeess = allListProbationDAO.getListOfAllReviewsTMReject();
									for (ProbationAssessmentManagerBean pa : listOfEmployeess) {
										
										int emp_id = pa.getEmployeeBean().getEmployee_master_id();
										String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
										String employee_name = pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname();
								%>

								<tr>
									<td><%=pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname()%></td>
									<td>
									<a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="icon-eye" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											
											</td>
								</tr>
								<%
									}
								%>
							</table>
							</div>
							</div>
							</div>
						</div>
					</div>
					
					</div>
				</div>
				</div>
				<font size="3px;" color="#337ab7"><b>Legends :&nbsp;</b></font><b><i class="icon-eye" style="color:#337ab7; size: 100px;"></i></b><b> : View Employee's Review </b> &nbsp;&nbsp;&nbsp;<i class="icon-ios-plus" style="color:#337ab7;"></i><b> : Add Review</b> &nbsp;&nbsp;&nbsp;<i class=" icon-compose" style="color:#337ab7;"></i><b> : Update Review</b> &nbsp;&nbsp;&nbsp;
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

			//iterate through each textboxes and add keyup
			//handler to trigger sum event
			$('[name="month_score"]').each(function() {

				$(this).keyup(function() {
					calculateSum();
				});
			});

		});

		function calculateSum() {

			var sum = 0;
			//iterate through each textboxes and add the values
			$('[name="month_score"]').each(function() {

				//add only if the value is number
				if (!isNaN(this.value) && this.value.length != 0) {
					sum += parseFloat(this.value);
				}
			
			});
			var sumOfWorkHour = parseInt($('#sumOfworkHours').val());
			var totalWorkHour = sumOfWorkHour + sum;
			$("#sum").html(sum.toFixed(2));
		}
	</script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({ 
				responsive : true
			});
		});
	</script>
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>
</body>
</html>