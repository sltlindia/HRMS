<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.probation.bean.AttributeBean"%>
<%@page import="com.hrms.probation.dao.AllListProbationDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript">
	function handleChange(id) {
		var a = document.getElementById(id).value;

		if (a<1 || a>5) {
			document.getElementById(id).value = 0;
			alert("Please! Enter grade between 1 to 5 ");
		}
	}
	function hideMessage() {
		//document.getElementById("panelbody").style.display="none"; 
		$('#panelbody').fadeOut('slow');
	}

	function startTimer() {
		var tim = window.setTimeout("hideMessage()", 5000); // 5000 milliseconds = 5 seconds
	}
</script>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns " onload="startTimer()">

	<div id="wrapper">
		<div id="page-wrapper">
			</br> </br>
			<%
				if (request.getAttribute("Score") != null) {
			%>
			<div class="panel-body" id="panelbody">
				<div class="alert alert-dismissable alert-success ">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${Score}
				</div>
			</div>
			<%
				}
			%>
			<%
				int manager_id = user.getManagerBean().getManager_id();
			%>

			<%
				if (request.getParameter("employee_master_id") != null) {
					int emp_id = Integer.parseInt(request.getParameter("employee_master_id"));
			%>
			<form action="probation.jsp" method="get">
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-12">
					             <h4 class="card-title" id="horz-layout-basic"><b><font size="2px">Confirmation Assessment Form</font></b></h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
				<!-- <div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Confirmation Assessment Form</h4>
							</div> -->
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-hover">
										<tbody>
											<tr>
												<td><label>Employee Name :</label></td>
												<td colspan="8"><select class="form-control"
													name="employee_master_id" id="employee_master_id"
													required="required">
														<%
															AllListDAO allListDAO = new AllListDAO();
																List<EmployeeBean> getemployeeList = allListDAO.getProbatioEmployeeList(manager_id);
																for (EmployeeBean e : getemployeeList) {
																	if (e.getEmployee_master_id() == emp_id) {
														%>
														<option value="<%=e.getEmployee_master_id()%>"
															selected="selected"><%=e.getFirstname() + " " + e.getLastname()%></option>
														<%
															} else {
														%>
														<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname() + " " + e.getLastname()%></option>
														<%
															}
														%>

														<%
															}
														%>
												</select></td>
											</tr>
											<%
												LoginDAO loginDAO = new LoginDAO();
													EmployeeBean employeeBean = loginDAO.getInfoById(emp_id);
											%>
											<tr>
												<th>Joining Date :</th>
												<td><font color="blue"><%=employeeBean.getJoining_date()%></font></td>
												<%
													String date = employeeBean.getJoining_date();
														/* DateFormat inputDF  = new SimpleDateFormat("mm/dd/yy"); */
														Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);

														Calendar cal = Calendar.getInstance();
														cal.setTime(date1);
														int month_id = cal.get(Calendar.MONTH);
												%>
												<th>Department :</th>
												<td><font color="blue"><%=employeeBean.getDepartmentBean().getDepartment_name()%></font></td>
												<td><label>Designation :</label></td>
												<td><font color="blue"><%=employeeBean.getRoleBean().getRole_type()%></font></td>
												<td><label>Employee Code :</label></td>
												<td><font color="blue"><%=employeeBean.getEmployee_code()%></font></td>
											</tr>
											<tr>
												<td colspan="8" align="center"><input type="submit"
													value="SUBMIT" class="btn btn-primary"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
				</div>
			</form>
			<br>
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-12">
					             <h5 class="card-title" id="horz-layout-basic"><b><font size="2px">Please rate on scale of 1 to 5<br>5 = Excellent,4 = Exceeds Expectations,3 = Fully Achieves Expectations,2 = Met some but not all expectations,1 = Unsatisfactory.</font></b></h5>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					               	 <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<form action="probationM1Insert" enctype="multipart/form-data"
							method="post" name="">
							<input type="hidden" name="employee_master_id"
								value="<%=emp_id%>">
							<div class="panel-body">
								<div class="table-responsive">

									<table class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>Sr. No.</th>
												<th>Attributes</th>
												<%
													AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
														List<MonthBean> listOfMonth = allListProbationDAO.getListOfMonth();

														int size = month_id + 5;

														if (size <= 12) {
															for (int i = month_id; i <= size; i++) {
																MonthBean m = listOfMonth.get(i);
																String month = m.getMonth_name();
												%>		

												<th><%=month%></th>
												<%
													}
												%>

												<%
													} else {

															for (int j = month_id + 1; j <= 12; j++) {
																MonthBean monthBean = allListProbationDAO.getInfoById(j);
												%>

												<th><%=monthBean.getMonth_name()%></th>
												<%
													}

															int size1 = size - 12;
															for (int i = 0; i <= size1; i++) {
																MonthBean m = listOfMonth.get(i);
																String month = m.getMonth_name();
												%>

												<th><%=month%></th>
												<%
													}
												%>

												<%
													}
												%>
											</tr>
										</thead>
										<%
											List<AttributeBean> listOfAttribute = allListProbationDAO.getListOfAttribute();
												for (int i = 0; i < listOfAttribute.size(); i++) {

													AttributeBean a = listOfAttribute.get(i);
										%>

										<tbody>
											<tr>
												<td><input type="hidden" name="attribute_id"
													id="attribute_id<%=i%>"
													value="<%=a.getProbation_attribute_id()%>"><%=i + 1%></td>
												<td><%=a.getProbation_attribute_question()%></td>
												<%
													AllListProbationDAO allListProbationDAO1 = new AllListProbationDAO();
															List<MonthBean> listOfMonth1 = allListProbationDAO.getListOfMonth();

															int size2 = month_id + 5;

															if (size2 <= 12) {
																for (int k = month_id; k <= size2; k++) {
																	MonthBean m = listOfMonth.get(k);
																	String month = m.getMonth_name();
												%>

												<td style="width: 100px;"><input type="hidden"
													name="month_id" value="<%=m.getMonth_id()%>"><input
													type="text" class="form-control" name="month_score"
													id="month_score<%=i%><%=k%>" value="0"
													placeholder="Enter Score" onchange="handleChange(this.id)"></td>
												<%
													}
															} else {

																for (int l = month_id + 1; l <= 12; l++) {
																	MonthBean monthBean = allListProbationDAO.getInfoById(l);
												%>

												<td style="width: 100px;"><input type="hidden"
													name="month_id" value="<%=monthBean.getMonth_id()%>"><input
													type="text" class="form-control" name="month_score"
													id="month_score<%=i%><%=l%>" value="0"
													placeholder="Enter Score" onchange="handleChange(this.id)"></td>
												<%
													}

																int size3 = size2 - 12;
																double sum = 0;
																for (int k = 0; k <= size3; k++) {
																	MonthBean m = listOfMonth.get(k);
																	String month = m.getMonth_name();
												%>

												<td style="width: 100px;"><input type="hidden"
													name="month_id" value="<%=m.getMonth_id()%>"><input
													type="text" class="form-control" name="month_score"
													id="month_score<%=i%><%=k%>" value="0"
													placeholder="Enter Score" onchange="handleChange(this.id)"></td>
												<%
													}
												%>

												<%
													}
												%>
												<%
													}
												%>

											</tr>
											<!-- <tr>
												<td colspan="2">Total</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr> -->
											<tr id="summation">
												<td colspan="2">Total</td>
												<td align="center"><span id="sum">0</span></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>

										</tbody>

									</table>
								</div>
								<div class="col-lg-6">
									<div class="panel-heading">
										<h5>Recommendations of the HOD / Manager (Please mention
											Yes or No)</h5>
									</div>
									<div class="table-responsive">
										<table class="table table-bordered">
											<tr>
												<td>A. To be Confirmed</td>
												<td><div class="form-group">
														<label class="radio-inline"> <input type="radio"
															name="optionsRadiosInline" id="optionsRadiosInline1"
															value="confirmedYes" checked>Yes
														</label> <label class="radio-inline"> <input type="radio"
															name="optionsRadiosInline" id="optionsRadiosInline2"
															value="confirmedNo">No
														</label>
													</div></td>
											</tr>
											<tr>
												<td>B. To be Extended</td>
												<td><div class="form-group">
														<label class="radio-inline"> <input type="radio"
															name="optionsRadiosInline1" id="optionsRadiosInline1"
															value="extendedYes" checked>Yes
														</label> <label class="radio-inline"> <input type="radio"
															name="optionsRadiosInline1" id="optionsRadiosInline2"
															value="extendedNo">No
														</label>
													</div></td>
											</tr>

											<tr>
												<td>C. To be Terminated</td>
												<td><div class="form-group">
														<label class="radio-inline"> <input type="radio"
															name="optionsRadiosInline2" id="optionsRadiosInline1"
															value="terminatedYes" checked>Yes
														</label> <label class="radio-inline"> <input type="radio"
															name="optionsRadiosInline2" id="optionsRadiosInline2"
															value="terminatedNo">No
														</label>
													</div></td>
											</tr>
											<tr id="summation" style="visibility: hidden;">
												<td>&nbsp;</td>
												<td align="right">Sum :</td>
												<td align="center"><span id="sum">0</span></td>
											</tr>
										</table>
									</div>

								</div>
								<div class="col-lg-6">
									<div class="panel-heading">
										<h5>Remarks</h5>
									</div>
									<label class="radio-inline"> <textarea rows="7"
											cols="90" class="form-control" name="remarks"
											placeholder="Enter Your Remarks:"></textarea>
									</label>
								</div>
							</div>
							<center>
								<input type="hidden" name="redirect" id="redirect"> <input
									type="submit" value="SUBMIT" class="btn btn-primary">
							</center>
						</form>
						<br>
					</div>
				</div>
			</div>
		</div>	
			</div>
			
			<%
				} else {
			%>
			<form action="probation.jsp" method="get">
			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-12">
					             <h4 class="card-title" id="horz-layout-basic"><b><font size="2px">Confirmation Assessment Form</font></b></h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
				<!-- <div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Confirmation Assessment Form</h4>
							</div> -->
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-hover">
										<tbody>
											<tr>
												<td><label>Employee Name :</label></td>
												<td colspan="7"><select class="form-control"
													name="employee_master_id" id="employee_master_id"
													required="required">
														<%
															AllListDAO allListDAO = new AllListDAO();
																List<EmployeeBean> getemployeeList = allListDAO.getProbatioEmployeeList(manager_id);
																for (EmployeeBean e : getemployeeList) {
														%>
														<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname() + " " + e.getLastname()%></option>
														<%
															}
														%>
												</select></td>
											</tr>
											<tr>
												<td colspan="3" align="center"><input type="submit"
													value="SUBMIT" class="btn btn-primary"></td>
											</tr>
										</tbody>
									</table>
									</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<%
				}
			%>

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
			$(".form-control").each(function() {

				$(this).keyup(function() {
					calculateSum();
				});
			});

		});

		function calculateSum() {

			var sum = 0;
			//iterate through each textboxes and add the values
			$(".txt").each(function() {

				//add only if the value is number
				if (!isNaN(this.value) && this.value.length != 0) {
					sum += parseFloat(this.value);
				}
				/* if(sum>24){
					alert("WorkedHours can not be greater than 24");
					$('#workedHours').val(0);
				} */
				/* else if(sum < 8)
					{
					alert("WorkedHours can not be less than 8");
					} */
			});
			//.toFixed() method will roundoff the final sum to 2 decimal places
			var sumOfWorkHour = parseInt($('#sumOfworkHours').val());
			var totalWorkHour = sumOfWorkHour + sum;
			/* alert(diff); */
			if (totalWorkHour > 24) {
				alert("WorkedHours can not be greater than 24");
				$('.txt').val(0);
			}
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