<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.pms.bean.WorkBehaviourBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.hrms.pms.dao.AllUpdateDAO"%>
<%@page import="com.hrms.pms.bean.AppraisalUpdateManagerScoreBean"%>
<%@page
	import="com.hrms.pms.controller.AppraisalScoreManagerUpdateServlet"%>
<%@page import="com.hrms.pms.bean.WorkGradeBean"%>
<%@page import="com.hrms.pms.bean.AppraisalWhiteCollarSection2Bean"%>
<%@page import="com.hrms.pms.bean.AppraisalWhiteCollarGradeBean"%>
<%@page import="com.hrms.pms.bean.AppraisalWhiteSection1Bean"%>
<%@page import="com.hrms.pms.bean.AppraisalCriteriaManagerBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="org.w3c.dom.ls.LSInput"%>
<%@page import="com.hrms.pms.bean.AppraisalCriteriaGradeBean"%>
<%@page import="com.hrms.pms.bean.AppraisalCriteriaBean"%>
<%@page import="com.hrms.pms.bean.AppraisalCriteriaDescriptionBean"%>
<%@page import="com.hrms.pms.bean.AppraisalTrainingBean"%>
<%@page import="com.hrms.pms.bean.Appraisal5sBean"%>
<%@page import="com.hrms.pms.bean.AppraisalKizenBean"%>
<%@page import="com.hrms.pms.bean.AppraisalLeaveBean"%>
<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Employee List</title>
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
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
	
		int appraisal_id = 0;
		int employee_master_id1 = 0;
		int department_id = 0;
		/* int employee_master_id = 0;
		if(request.getParameter("appraisal_id")!=null)
		{
			appraisal_id =Integer.parseInt(request.getParameter("appraisal_id"));
			//employee_master_id =Integer.parseInt(request.getParameter("employee_id"));
			
		}else{
			appraisal_id =(Integer) request.getAttribute("appraisal_id");
		}*/
		int dept_id = 0;
		if(request.getParameter("dept_id") != null){
			dept_id = Integer.parseInt(request.getParameter("dept_id"));
		}else{
			dept_id = 1;
		}

		
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Employee WhiteCollar Appraisal List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
	<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Employee WhiteCollar Appraisal List</h1>
				</div>
				/.col-lg-12
			</div>
			 -->
			
		 <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">White Collar Appraisal List</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">White Collar Appraisal List</div>
							/.panel-heading
							
								 -->

	<div class="panel-body">
<form action="HRWhiteAppraisalExcel.jsp" method="get">                        
<table class="table">
<tr>
<th>Select Department</th>
<td>:</td>
<td>
	<select class="form-control" name="dept_id" >
	<option value="">---Select Department---</option>
	<%if(department_id == 0){ %>
	<option value="0" selected="selected">All Department</option>
	<%}else{ %>
	<option value="0">All Department</option>
	<%} %>
	<%AllListDAO allListDAO = new AllListDAO();
	List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment(); 
	for(DepartmentBean d : listOfDepartment){
		if(d.getDepartment_id() != 0){
			if(d.getDepartment_id() == dept_id){
	%>
	<% department_id = d.getDepartment_id();%>
	<option value="<%=d.getDepartment_id()%>" selected="selected"><%=d.getDepartment_name() %></option>
	<%}else{ %>
	<option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name() %></option>
	<%} %>
	<%} 
		else{	
	if(dept_id == 0){
		department_id = d.getDepartment_id();
		%>
		<option value="0" selected="selected">All Department</option>
		<%}else{ %>
		<option value="0">All Department</option>
		<%} 	
		}}%>
	</select>
	</td>
	<td><input type="submit" name="submit" class="btn btn-primary" value="SUBMIT"></td>
	</tr>
</table> 
</form>
<%		List<AppraisalBean> appraisalBean = null;

if(department_id == 0){
	appraisalBean = allListDAO.getWhiteAppraisalApprovedByAllDepartment();
}
else{
	 appraisalBean = allListDAO.getWhiteAppraisalApprovedByDepartment(department_id);
}
		%>
		 <div class="panel-body">
						<div class="dataTable_wrapper">
								<div class = "table-responsive">
									<table class="table table-striped table-bordered"
										id="datatable-buttons1">
										<thead>
											<tr>
												<th>No.</th>
												<th style="text-align: center">Emp Name</th>
												<th>Emp_Code</th>
												<th>Department</th>
												<th>Reviewing Officer</th>
												<th>Year </th>
												<th>Goals (70%)</th>
												<th>Competency (15%)</th>
												<th>Employee Hisrory (Attendence ,Kaizen, Trainning)(15%)</th>
												<th>Overall Obtain  (Total %)</th>
													
												
												<th>Work Behaviour</th>
												<%
													List<WorkBehaviourBean> listOfWorkGrade1 = allListDAO.getWorkBehaviour();
													for (WorkBehaviourBean wk : listOfWorkGrade1) {
												%>
												<th><%=wk.getWork_behaviors_name()%> :</th>
												<%
													}
												%>
												
												<%-- <%
													List<AppraisalWhiteCollarGradeBean> listOfGrade123 = allListDAO.getappraisalGrade(appraisal_id);
													for (int i = 0; i < listOfGrade123.size(); i++) {
														AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean = listOfGrade123.get(i);
												%>
												<th><%=appraisalWhiteCollarGradeBean.getGoals()%></th>
												<%
													}
												%>
												 --%>
											
											</tr>
										</thead>
										<tbody>

											<%
												for (AppraisalBean a1 : appraisalBean) {
											%>
											<%
												appraisal_id = a1.getAppraisal_id();
											%>
											<tr align="Center">
												<td><%=1%></td>
												<td><%=a1.getEmployeeBean().getFirstname() + " " + a1.getEmployeeBean().getLastname()%></td>
												<td><%=a1.getEmployeeBean().getEmployee_code()%></td>
												<td><%=a1.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
												<%
													int manager_id = Integer.parseInt(a1.getEmployeeBean().getUnder_manager_id());
														LoginDAO loginDAO = new LoginDAO();
														EmployeeBean employeeBean = loginDAO.getUserByManagerId(manager_id);
												%>
												<td><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></td>
												<td><%=a1.getYearBean().getYear()%></td>
												<%
													double totalSec1 = 0;
														double totalGrade = 0;
														List<AppraisalLeaveBean> listOfLeave = allListDAO.getappraisalLeave(appraisal_id);
														for (AppraisalLeaveBean appraisalLeaveBean : listOfLeave) {
															totalSec1 = totalSec1 + appraisalLeaveBean.getAppraisalGradeBean().getAppraisal_grade_id();
															totalGrade++;
														}
												%>
												<%
													List<AppraisalKizenBean> listOfKaizen = allListDAO.getappraisalKaizen(appraisal_id);
														for (AppraisalKizenBean appraisalKizenBean : listOfKaizen) {
															totalSec1 = totalSec1 + appraisalKizenBean.getAppraisalGradeBean().getAppraisal_grade_id();
															totalGrade++;
														}
												%>
												<%
													List<Appraisal5sBean> listOf5s = allListDAO.getappraisal5s(appraisal_id);
														for (Appraisal5sBean appraisal5sBean : listOf5s) {
															totalSec1 = totalSec1 + appraisal5sBean.getAppraisalGradeBean().getAppraisal_grade_id();
															totalGrade++;
														}

														double aveSec1 = Math.round(totalSec1 / totalGrade);

														double totalGoals = 0;
														double goalSize = 0;

														List<AppraisalWhiteCollarGradeBean> listOfGrade = allListDAO.getappraisalGrade(appraisal_id);
														for (AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean : listOfGrade) {
															totalGoals = totalGoals
																	+ appraisalWhiteCollarGradeBean.getAppraisalGradeBean().getAppraisal_grade_id();
															goalSize++;
														}

														double aveGoal = Math.round(totalGoals / goalSize);

														double totalWork = 0;
														double workSize = 0;

														List<WorkGradeBean> listOfWorkGrade = allListDAO.getWorkGrader(appraisal_id);
														for (WorkGradeBean workGradeBean : listOfWorkGrade) {
															totalWork = totalWork + workGradeBean.getAppraisalGradeBean().getAppraisal_grade_id();
															workSize++;
														}

														double aveWork = Math.round(totalWork / workSize);
														List<AppraisalCriteriaManagerBean> listAppraisalCriteria = allListDAO.getListOfManagerCriteria();

														double total1 = 0;
												%>
												<td>
													<%
														double obtain1 = 0;
															for (int i = 0; i < listAppraisalCriteria.size(); i++) {
																AppraisalCriteriaManagerBean a = listAppraisalCriteria.get(i);
																if (a.getAppraisal_criteria_manager_id() == 3) {
																	obtain1 = (aveGoal * 70) / 5;
																}
															}
													%> <%=obtain1%> %
												</td>
												<td>
													<%
														double obtain2 = 0;
															for (int i = 0; i < listAppraisalCriteria.size(); i++) {

																AppraisalCriteriaManagerBean a = listAppraisalCriteria.get(i);
																if (a.getAppraisal_criteria_manager_id() == 1) {
																	obtain2 = (aveWork * 15) / 5;
																}
															}
													%><%=obtain2%> %
												</td>
												<td>
													<%
														double obtain = 0;
															for (int i = 0; i < listAppraisalCriteria.size(); i++) {
																AppraisalCriteriaManagerBean a = listAppraisalCriteria.get(i);
																if (a.getAppraisal_criteria_manager_id() == 2) {
																	obtain = (aveSec1 * 15) / 5;
																}
															}
													%><%=obtain%> %
												</td>
												<td>
													<%
														total1 = total1 + obtain + obtain1 + obtain2;
													%> <%=total1%> %
												</td>
												
											<td>1</td>
											<%-- 	<%
													for (int i = 0; i < listOfGrade.size(); i++) {
															AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean = listOfGrade.get(i);
												%>
												
												<%
													}
												%> --%>
												<%
													for (int m = 0; m < listOfWorkGrade.size(); m++) {
															WorkGradeBean workGradeBean = listOfWorkGrade.get(m);
												%>
												<td><%=workGradeBean.getAppraisalGradeBean().getAppraisal_grade_name()%></td>

												<%
													
												}
										
												%>
<%-- <%
													List<AppraisalWhiteCollarGradeBean> listOfGrade1 = allListDAO.getappraisalGrade(appraisal_id);
													for (int i = 0; i < listOfGrade1.size(); i++) {
														AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean = listOfGrade1.get(i);
												%>
												<td>
											<%=appraisalWhiteCollarGradeBean.getAppraisalGradeBean().getAppraisal_grade_name()%></td>
												<%
													}
												%> --%>
												<%-- 	
										<%	
									List<AppraisalUpdateManagerScoreBean> listUpdatedScore = allListDAO.getUpdatedScore(appraisal_id);
									
									if(listUpdatedScore.size() == 0){
									
									double total1 = 0;
									for(int i = 0; i<listAppraisalCriteria.size();i++){
										AppraisalCriteriaManagerBean a = listAppraisalCriteria.get(i);
										double obtain = 0;
									%>
										<td><%if(a.getAppraisal_criteria_manager_id() == 3){
											obtain = (aveSec1 * a.getWeightage()) / 5;
											%>
										
										<%} else if(a.getAppraisal_criteria_manager_id() == 1){
											obtain = (aveGoal * a.getWeightage()) / 5;
										%>
										<%} else if(a.getAppraisal_criteria_manager_id() == 2){
											obtain = (aveWork * a.getWeightage()) / 5;
										%>
										<%} %>
										<%} %>
										</td> --%>
												<%-- <td><%total1 = total1 + obtain ;%><%=obtain%> %	</td> --%>
											<% } %>
											</tr>
										<tbody>
									</table>
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
		var handleDataTableButtons = function() {
			"use strict";
			0 !== $("#datatable-buttons").length
					&& $("#datatable-buttons").DataTable({
						dom : "Bfrtip",
						buttons : [ {
							extend : "copy",
							className : "btn-sm"
						}, {
							extend : "csv",
							className : "btn-sm"
						}, {
							extend : "excel",
							className : "btn-sm"
						}, {
							extend : "pdf",
							className : "btn-sm"
						}, {
							extend : "print",
							className : "btn-sm"
						} ],
						responsive : !0
					})
		}, TableManageButtons = function() {
			"use strict";
			return {
				init : function() {
					handleDataTableButtons()
				}
			}
		}();
	</script>

	<script>
		var handleDataTableButtons1 = function() {
			"use strict";
			0 !== $("#datatable-buttons1").length
					&& $("#datatable-buttons1").DataTable({
						dom : "Bfrtip",
						buttons : [ {
							extend : "copy",
							className : "btn-sm"
						}, {
							extend : "csv",
							className : "btn-sm"
						}, {
							extend : "excel",
							className : "btn-sm"
						}, {
							extend : "pdf",
							className : "btn-sm"
						}, {
							extend : "print",
							className : "btn-sm"
						} ],
						responsive : !0
					})
		}, TableManageButtons1 = function() {
			"use strict";
			return {
				init : function() {
					handleDataTableButtons1()
				}
			}
		}();
	</script>

	<script>
		var handleDataTableButtons2 = function() {
			"use strict";
			0 !== $("#datatable-buttons2").length
					&& $("#datatable-buttons2").DataTable({
						dom : "Bfrtip",
						buttons : [ {
							extend : "copy",
							className : "btn-sm"
						}, {
							extend : "csv",
							className : "btn-sm"
						}, {
							extend : "excel",
							className : "btn-sm"
						}, {
							extend : "pdf",
							className : "btn-sm"
						}, {
							extend : "print",
							className : "btn-sm"
						} ],
						responsive : !0
					})
		}, TableManageButtons2 = function() {
			"use strict";
			return {
				init : function() {
					handleDataTableButtons2()
				}
			}
		}();
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#datatable').dataTable();
			$('#datatable1').dataTable();
			$('#datatable-keytable').DataTable({
				keys : true
			});
			$('#datatable-responsive').DataTable();
			$('#datatable-scroller').DataTable({
				ajax : "js/datatables/json/scroller-demo.json",
				deferRender : true,
				scrollY : 380,
				scrollCollapse : true,
				scroller : true
			});
			var table = $('#datatable-fixed-header').DataTable({
				fixedHeader : true
			});
		});
		TableManageButtons.init();
		TableManageButtons1.init()
		TableManageButtons2.init()
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