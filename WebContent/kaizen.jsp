<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenProblemIdentificationBean"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCompanyBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementDepartmentBean"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementBean"%>
<%@page import="com.hrms.selfservice.bean.RoleCategoryBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCategoryBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page
	import="com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
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
    <title>CI</title>
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
<script type="text/javascript" src="css/TimerPicker/jquery.min.js"></script>
<script type="text/javascript" src="css/TimerPicker/jquery-ui.min.js"></script>
<link href="css/TimerPicker/jquery-ui.css" rel="stylesheet">
<link href="css/timepicki.css" rel="stylesheet">

<script>									
	function checkInteger(id) {
		
			var a = document.getElementById(id).value;
		
		if(isNaN(a)){
			alert("Cost should be only in digits.Please enter digits only!!!");
			document.getElementById(id).value = "";
		}else{
		if(id == "memberCount"){
			if(a>10){
				alert("More Than 10 team member are not Allowed...");
				document.getElementById(id).value = "";
			}
		}
		}
	}
	</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String date1 = dateFormat.format(date);
		
		int id = Integer.parseInt(request.getParameter("id"));
		AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
		KaizenProblemIdentificationBean kaizenProblemIdentificationBean = allKaizenListDAO.getDetailOfProblem(id);
	%>
	<%
		int employee_id = user.getEmployee_master_id();
	%>

	   
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">CI Form</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
				<div class="card">
					<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
				                <h4 class="card-title" id="horz-layout-basic"> &nbsp; CI Form</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
				            </div>
					<div class="card-body collapse in">
						<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
							<div class="form-body">
			
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-body">

							<form action="kaizenInsert" method="post" name=""
								enctype="multipart/form-data">
								
								<input type="hidden" name="problem_id" value="<%=id%>">
								
								<div class="panel-group" id="accordion">
									<div id="table-responsive">
										<table class="table table-stripped table-hover">

											<tr>

												<td colspan="3"><label>Problem Identification </label>
													<input type="hidden" name="existing_problem"
													value="<%=kaizenProblemIdentificationBean.getProblem_description()%>">
													<p style="white-space: pre-wrap;"><%=kaizenProblemIdentificationBean.getProblem_description()%></p>
												</td>

												<td><label>Root Cause Analysis&nbsp;<i
														class="icon icon-question-circle" data-toggle="tooltip"
														data-placement="top" title="Root cause analysis (RCA) is a method of problem solving used for identifying the root causes of faults or problems."></i></label>
													<p>
														<input type="button" class="btn btn-default btn-xs"
															name="button" value="Click Here To Start RCA"
															data-toggle="modal" data-target="#rca">
													</p></td>

												<td><label>Category</label> <input type="hidden"
													class="form-control" name="category" id="category"
													value="<%=kaizenProblemIdentificationBean.getCategory()%>"
													onchange="departmentHideShow(this.value);"
													readonly="readonly">
													<p><%=kaizenProblemIdentificationBean.getCategory()%></p></td>

											</tr>

											<tr>
												<td><label>CI Name</label> <input class="form-control"
													type="text" name="kaizen_name" placeholder="CI Short name"
													required></td>

												<td colspan="6"><label>Improvement Plan</label> <textarea
														maxlength="820" name="description" class="form-control"
														id="description" placeholder="max 800 words" required></textarea>
												</td>


											</tr>



											<tr>

												<td colspan="3"><label>Projected Saving</label> <br>
													<label><input type="checkbox" name="" id="Time"
														value="Time" onclick="projectedSaving();">
														Delivery</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label><input
														type="checkbox" name="" id="Money" value="Money"
														onclick="projectedSaving();"> Cost </label>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label><input
														type="checkbox" name="" id="Effort" value="Effort"
														onclick="projectedSaving();"> Quality </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<label><input type="checkbox" name="" id="safety"
														value="safety" onclick="projectedSaving();">
														Safety </label>&nbsp;&nbsp;&nbsp; <label><input
														type="checkbox" name="" id="productivity"
														value="productivity" onclick="projectedSaving();">
														Productivity </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>



												<td><label>Team Member Count</label> <input type="text"
													name="memberCount" class="form-control" id="memberCount"
													value="1" placeholder="Enter Team Member"
													onchange="checkInteger(this.id);" required></td>


												<td colspan="2"><label>Implementation Cost</label> <input
													type="text" name="implementation_cost" class="form-control"
													id="implementationCount" placeholder="Enter Cost" value="0"
													onchange="checkInteger(this.id);showAuthority(this.value);" required></td>


											</tr>


											<tr>
												<td id="timeField"><label>Time Saving
														(Delivery)</label> <textarea maxlength="75" name="time_saving"
														id="time_saving" class="form-control"
														placeholder="Max 75 words"></textarea></td>


												<td id="moneyField"><label>Money Saving(Cost)</label>
													<textarea maxlength="75" name="money_saving"
														id="money_saving" class="form-control"
														placeholder="Enter Amount"
														onchange="checkInteger(this.id);"></textarea></td>


												<td id="effortField"><label>EffortSaving(Quality)</label> <textarea maxlength="75" name="effort_saving"
														id="effort_saving" class="form-control"
														placeholder="Max 75 words"></textarea></td>

												<td id="safetyField"><label>Safety</label> <textarea
														maxlength="75" name="safety_saving" id="safety_saving"
														class="form-control" placeholder="Max 75 words"></textarea>
												</td>


												<td id="productivityField"><label>Productivity</label>
													<textarea maxlength="75" name="productivity_saving"
														id="productivity_saving" class="form-control"
														placeholder="Max 75 words"></textarea></td>
											</tr>
											
											<tr>
												<th>HOD Selection</th>
												<td>:</td>
												<td colspan="4">
														<select class="form-control" name="under_manager_id"
												 required="required">
													<option value="0">-- Select Manager --</option>

													<%
													LoginDAO loginDAO = new LoginDAO();
													String under_manager_id = null;
															List<EmployeeBean> ListOfManager = loginDAO.getListOfManager();
															for (EmployeeBean employeeBean : ListOfManager) {
																if(employeeBean.getManagerBean().getManager_id() == Integer.parseInt(user.getUnder_manager_id())){
													%>
														<option value="<%=employeeBean.getManagerBean().getManager_id()%>" selected="selected"><%=employeeBean.getFirstname()+" "+employeeBean.getMiddlename()+" "+employeeBean.getLastname()+" <b>("+employeeBean.getDepartmentBean().getDepartment_name()+")</b>"%></option>			
													<%}else{ %>
													<option value="<%=employeeBean.getManagerBean().getManager_id()%>"><%=employeeBean.getFirstname()+" "+employeeBean.getMiddlename()+" "+employeeBean.getLastname()+" <b>("+employeeBean.getDepartmentBean().getDepartment_name()+")</b>"%></option>
													<%
															}}
													%>
											</select>										
												</td>
											</tr>
											
											<input type="hidden" name="insert">
											
											<tr id="managementOption">
												<th>Higher Authority</th>
												<td>:</td>
												<td colspan="4">
														<select class="form-control" name="management_id"
												id="management_id">
												<option value="0">---Select Management---</option>
												<%
												List<EmployeeBean> listOfTopManagement = allKaizenListDAO.getlistOfTopManagement();
													for (EmployeeBean e : listOfTopManagement) {
														if(e.getEmployee_master_id() != 1017 && e.getEmployee_master_id() != 1201 && e.getEmployee_master_id() != 974){
												%>
												<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname() + " " + e.getLastname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(<%=e.getRoleBean().getRole_type()%>)
												</option>
												<%
													}}
												%>

											</select>												
												</td>
											</tr>
											
											
											<tr id="departmentOption">
												<th>Required support of other Department?</th>
												<td>:</td>
												<td colspan="4"><input type="radio"
													name="affecting_department" id="Yes" value="Yes"
													onchange="affetingDepartment(this.id);"> Yes <input
													type="radio" name="affecting_department" id="No" value="No"
													onchange="affetingDepartment(this.id);" checked="checked">
													No</td>
											</tr>

											<tr>
												<td colspan="6">
													<table class="table table-hover">
														<tr id="department">
															<td>
																<div class="row">
																	<div class="col-md-4">
																		Select Department Head
																		<p class="help-block">(Select Multiple Department
																			Head)</p>
																	</div>

																	<div class="col-md-8">
																		<select class="form-control" name="dept_id"
																			id="dept_id" onChange="test(this.value);">
																			<option value="">---Select Department---</option>
																			<%
																				AllListDAO allListDAO = new AllListDAO();
																				List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment();
																				for (DepartmentBean d : listOfDepartment) {
																					if(d.getDepartment_id() != 0 && d.getDepartment_id() != 47){
																			%>
																			<option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name()%></option>
																			<%
																				}}
																			%>
																		</select>

																		<%
																			for (DepartmentBean d : listOfDepartment) {
																				if (d.getDepartment_id() != 0) {
																					int dept_id = d.getDepartment_id();
																					List<EmployeeBean> listOfEmployee = allListDAO.getAllEmployeeById(dept_id);
																					if (listOfEmployee.size() != 0) {
																		%>
																		<div id="<%=d.getDepartment_id()%>">
																			<div class="row">
																				<div class="col-lg-12">
																					<h5>
																						<b><%=d.getDepartment_name()%></b>
																					</h5>
																				</div>
																				<%
																					for (EmployeeBean e : listOfEmployee) {
																				%>
																				<div class="col-lg-4">
																					<label><input type="checkbox"
																						class="chkemployee" name="mngEmployee"
																						id="chkemployee"
																						value="<%=e.getEmployee_master_id()%>"> <%=e.getFirstname() + " " + e.getLastname()%></label>
																				</div>
																				<%
																					}
																				%>
																			</div>
																		</div>
																		<%
																			}
																				}
																			}
																		%>
																	</div>
																</div>
															</td>
														</tr>
													</table>
												</td>
											</tr>


										</table>


									</div>


									<!-- -------------------------------------ROOT CAUSE ANALYSIS----------------------------------------- -->

									<div class="modal fade" id="rca" tabindex="-1" role="dialog"
										aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h4 class="modal-title" id="myModalLabel">Root Cause
														Analysis</h4>
												</div>
												<div class="modal-body">
													<p id="rcaQue1" style="font-weight: bold;">
														1. Why
														<%=kaizenProblemIdentificationBean.getProblem_description() %>
														?
													</p>
													<textarea rows="" cols="" id="rcaAns1" name="rcaAns1"
														class="form-control" placeholder="max 800 words"
														onchange="rcaAns(1)"></textarea>

													<p id="rcaQue2" style="font-weight: bold;"></p>
													<textarea rows="" cols="" id="rcaAns2" name="rcaAns2"
														class="form-control" placeholder="max 800 words"
														onchange="rcaAns(2)"></textarea>

													<p id="rcaQue3" style="font-weight: bold;"></p>
													<textarea rows="" cols="" id="rcaAns3" name="rcaAns3"
														class="form-control" placeholder="max 800 words"
														onchange="rcaAns(3)"></textarea>

													<p id="rcaQue4" style="font-weight: bold;"></p>
													<textarea rows="" cols="" id="rcaAns4" name="rcaAns4"
														class="form-control" placeholder="max 800 words"
														onchange="rcaAns(4)"></textarea>


													<p id="rcaQue5" style="font-weight: bold;"></p>
													<textarea rows="" cols="" id="rcaAns5" name="rcaAns5"
														class="form-control" placeholder="max 800 words"
														onchange="rcaAns(5)"></textarea>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-primary"
														data-dismiss="modal">Submit</button>
												</div>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>


									<!-- -------------------------------------ROOT CAUSE ANALYSIS----------------------------------------- -->

									<center>
									
										<input type="hidden" name="redirection"> <input
											type="submit" value="Next" class="btn btn-primary">
										<input type="reset" value="Cancel" class="btn btn-danger">
										
									</center>
									<br>

								</div>
							</form>

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
	<script src="js/timepicki.js"></script>
	<script>
		$('#fromTime').timepicki();
	</script>
	<script type="text/javascript">
		$(function() {
			$('#fromTime').timepicki({
				showMeridian : false
			});
		});
	</script>
	<script>
		$('#toTime').timepicki();
	</script>


	<script type="text/javascript">
		$(function() {
			$('#toTime').timepicki({
				showMeridian : false
			});
		});
	</script>

	<script>
		window.onload = function() {

			$('#timeField').fadeOut('fast');
			$('#moneyField').fadeOut('fast');
			$('#effortField').fadeOut('fast');
			$('#safetyField').fadeOut('fast');
			$('#productivityField').fadeOut('fast');
			$('#department').fadeOut('fast');
			$('#departmentOption').fadeOut('fast');
			$('#managementOption').fadeOut('fast');
			
			for(var i=2;i<=5;i++){
			$('#rcaQue'+i).fadeOut('fast');
			$('#rcaAns'+i).fadeOut('fast');
			}
			
			departmentHideShow();
		}
	</script>



	<script>
		function projectedSaving() {
			if ($('#Time').is(":checked")) {
				$('#timeField').fadeIn('slow');

			} else {
				$('#time_saving').val('');
				$('#timeField').fadeOut('slow');

			}
			if ($('#Money').is(":checked")) {
				$('#moneyField').fadeIn('slow');
			} else {
				$('#money_saving').val('');
				$('#moneyField').fadeOut('slow');

			}
			
			if ($('#Effort').is(":checked")) {
				$('#effortField').fadeIn('slow');

			} else {
				$('#effort_saving').val('');
				$('#effortField').fadeOut('slow');
			}
			
			
			if ($('#safety').is(":checked")) {
				$('#safetyField').fadeIn('slow');

			} else {
				$('#safety_saving').val('');
				$('#safetyField').fadeOut('slow');
			}
			
			
			
			if ($('#productivity').is(":checked")) {
				$('#productivityField').fadeIn('slow');

			} else {
				$('#productivity_saving').val('');
				$('#productivityField').fadeOut('slow');
			}
		}

		function affetingDepartment(id) {
			if ($('#Yes').is(":checked")) {
				$('#department').fadeIn('slow');

			} else {
				$('#department').fadeOut('slow');

			}
		}
		
		function departmentHideShow() {
			var value = $("#category").val();
			if(value == "A"){
				$('#department').fadeOut('fast');
				$('#departmentOption').fadeOut('fast');
			}else if(value == "B"){
				$('#department').fadeIn('fast');
				$('#departmentOption').fadeOut('fast');
			}else if(value == "C"){
				$('#department').fadeOut('fast');
				$('#departmentOption').fadeIn('fast');
				$('#managementOption').fadeIn('fast');
				
			}
		}
		
		
		function showAuthority(value) {
			var category = $("#category").val();
			if(value>5000){
				$('#managementOption').fadeIn('fast');
			}else{
				if(category != "C"){
					$('#managementOption').fadeOut('fast');
				}
			}
		}
		
		
	</script>


	<script>
		function test(id) {
			$('#' + id).fadeIn('slow');

		}

		$(document).ready(function() {
			$('#selecctall1').click(function(event) { //on click 
				if (this.checked) { // check select status
					$('.checkbox2').each(function() { //loop through each checkbox
						this.checked = true; //select all checkboxes with class "checkbox1"               
					});
				} else {
					$('.checkbox2').each(function() { //loop through each checkbox
						this.checked = false; //deselect all checkboxes with class "checkbox1"                       
					});
					$('.checkbox2').each(function() { //loop through each checkbox
						this.checked = false; //deselect all checkboxes with class "checkbox2"                       
					});
				}
			});

			for (var a = 0; a <= 60; a++) {
				$('#' + a).fadeOut('slow');
			}

		});
		
		
		function rcaAns(id) {
			
			var showId = id + 1;
			
			var que = $('#rcaQue'+id).text();
			var ans = $('#rcaAns'+id).val();
			
			
			$('#description').val(ans);
			$('#rcaQue'+showId).text(showId+'. '+'why '+ans+'?');
			$('#rcaQue'+showId).fadeIn('fast');
			$('#rcaAns'+showId).fadeIn('fast');
			

		}
	</script>

</body>

</html>
