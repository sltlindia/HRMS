<%@page import="com.hrms.probation.bean.ProbationExtendBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentManagerBean"%>
<%@page import="java.util.Calendar"%>
<!-- Author Name :- Ripal Soni
For Getting data from user
Jsp for displaying data at hr side  -->

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
<%@include file="header.jsp"%>
<title>SLTL HRMS</title>
</head>
<body onload="startTimer()">
	<%
		int manager_id = user.getManagerBean().getManager_id();
	%>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">Probation Assessment</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b><font size="3px">Probation Track Report</font></b>
						</div>
						<div class="panel-body">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h3 class="panel-title">All Reviews</h3>
								</div>
								<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Employee Name</th>
												<th>Reporting Manager Name</th>
												<th>Direct/Indirect
												<th>Joining Date</th>
												<th>Filled Month</th>
												<th>Extended Probation(Month)</th>
												<th>Manager's Approval</th>
												<th>HR's Approval</th>
												<th>Top Management's Approval</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<%
												AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
												List<ProbationAssessmentManagerBean> listOfEmployeees = allListProbationDAO.getListOfAllReviews();
												List<ProbationAssessmentManagerBean> listOfEmployeeesCompleted = allListProbationDAO.getListOfAllReviewsCompleted();
												for (ProbationAssessmentManagerBean pa : listOfEmployeees) {
													String employee_name = pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname();
													int emp_id = pa.getEmployeeBean().getEmployee_master_id();
													String date = pa.getEmployeeBean().getJoining_date();
													String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
													String to_be_extended = pa.getTo_be_extended();
													int extended = 6;
													String print_status = null;
													String print_status_hr = null;
													String print_status_top = null;
													int probationmanager_id = pa.getProbation_assessment_manager_id();
													String status = null;
													List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
													for (ProbationExtendBean p : listForExtend) {
														status = p.getStatus();

													}

													List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO
															.getListOfScoreByEmpId(emp_id);
													for (ProbationAssessmentManagerBean li : listOfExtended1) {
														int probationmanager_idd = li.getProbation_assessment_manager_id();

														List<ProbationExtendBean> listForExtend1 = allListProbationDAO
																.getProbationExtend(probationmanager_idd);
														for (ProbationExtendBean p1 : listForExtend) {
															String extend_period = p1.getExtended_period();
															extended = extended + Integer.parseInt(extend_period);

														}
													}
													if(pa.getManager_approval().equalsIgnoreCase("pending")){
														print_status = "Pending";
													}
													else if(pa.getManager_approval().equalsIgnoreCase("approved")){
														print_status = "Approved";
													}
													else{
														print_status = "Rejected";
													}
													if(pa.getHr_approval().equalsIgnoreCase("pending")){
														print_status_hr = "Pending";
													}
													else if(pa.getManager_approval().equalsIgnoreCase("approved")){
														print_status_hr = "Approved";
													}
													else{
														print_status_hr = "Rejected";
													}
													if(pa.getTop_management_approval().equalsIgnoreCase("pending")){
														print_status_top = "Pending";
													}
													else if(pa.getTop_management_approval().equalsIgnoreCase("approved")){
														print_status_top = "Approved";
													}
													else if(pa.getTop_management_approval().equalsIgnoreCase("hrapproved")){
														print_status_top = "HR-Approved";
													}
														
													else{
														print_status_top = "Rejected";
													}
													long maxValue = 0;
													String sd = null;
													try {

														SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
														Date result = formater.parse(date);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														sd = AppDateFormat.format(result);

													} catch (ParseException e1) {
														e1.printStackTrace();
													}
													boolean flag = false;
													if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1")
															|| authority.equals("T2") || authority.equals("T3") || authority.equals("A1")
															|| authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
														maxValue = allListProbationDAO.getCount(emp_id);
													} else {
														maxValue = allListProbationDAO.getCountForM2(emp_id);
														flag = true;
													}
													int reviewing_manager_id = pa.getReviewing_manager_id();
													LoginDAO loginDAO2 = new LoginDAO();
													int id = pa.getReviewing_manager_id();
													EmployeeBean employeeBean2 = loginDAO2.getEmailIdEmployee(reviewing_manager_id);
											%>

											<tr>
												<td><%=pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname()%></td>
												<td><%=employeeBean2.getFirstname() +" "+ employeeBean2.getLastname()%></td>
												<%if(flag == false){ %>
									<td>Direct Employee</td>
									<%}else{ %>
									<td>Indirect Employee</td>
									<%} %>
									<td><%=sd%></td>
									<td><%=maxValue%></td>
									<td><%=pa.getPeriod_to_be_extended()%></td>	
												<td><center><%=print_status%></center></td>
												<td><center><%=print_status_hr%></center></td>
												<td><center><%=print_status_top%></center></td>
												<td><center>
												<%if(maxValue == extended){%>
											 <a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="glyphicon glyphicon-eye-open" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											<%}else{
												%>
												Extended
											<%} %>
											</center>
											</td>
											</tr>
										
										<%
											}
										%>
</tbody>
									</table>
								</div>
</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b><font size="3px">Probation Track Report</font></b>
						</div>
						<div class="panel-body">
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h3 class="panel-title">Confirmed Employees</h3>
								</div>
								<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Employee Name</th>
												<th>Reporting Manager Name</th>
												<th>Direct/Indirect
												<th>Joining Date</th>
												<th>Filled Month</th>
												<th>Extended Probation(Month)</th>
												<th>Manager's Approval</th>
												<th>HR's Approval</th>
												<th>Top Management's Approval</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<%
												for (ProbationAssessmentManagerBean pa : listOfEmployeeesCompleted) {
													String employee_name = pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname();
													int emp_id = pa.getEmployeeBean().getEmployee_master_id();
													String date = pa.getEmployeeBean().getJoining_date();
													String authority = pa.getEmployeeBean().getRoleBean().getRole_authority();
													String to_be_extended = pa.getTo_be_extended();
													int extended = 6;
													String print_status = null;
													String print_status_hr = null;
													String print_status_top = null;
													int probationmanager_id = pa.getProbation_assessment_manager_id();
													String status = null;
													List<ProbationExtendBean> listForExtend = allListProbationDAO.getProbationExtend(probationmanager_id);
													for (ProbationExtendBean p : listForExtend) {
														status = p.getStatus();

													}

													List<ProbationAssessmentManagerBean> listOfExtended1 = allListProbationDAO
															.getListOfScoreByEmpId(emp_id);
													for (ProbationAssessmentManagerBean li : listOfExtended1) {
														int probationmanager_idd = li.getProbation_assessment_manager_id();

														List<ProbationExtendBean> listForExtend1 = allListProbationDAO
																.getProbationExtend(probationmanager_idd);
														for (ProbationExtendBean p1 : listForExtend) {
															String extend_period = p1.getExtended_period();
															extended = extended + Integer.parseInt(extend_period);

														}
													}
													if(pa.getManager_approval().equalsIgnoreCase("pending")){
														print_status = "Pending";
													}
													else if(pa.getManager_approval().equalsIgnoreCase("approved")){
														print_status = "Approved";
													}
													else{
														print_status = "Rejected";
													}
													if(pa.getHr_approval().equalsIgnoreCase("pending")){
														print_status_hr = "Pending";
													}
													else if(pa.getManager_approval().equalsIgnoreCase("approved")){
														print_status_hr = "Approved";
													}
													else{
														print_status_hr = "Rejected";
													}
													if(pa.getTop_management_approval().equalsIgnoreCase("pending")){
														print_status_top = "Pending";
													}
													else if(pa.getTop_management_approval().equalsIgnoreCase("approved")){
														print_status_top = "Approved";
													}
													else if(pa.getTop_management_approval().equalsIgnoreCase("hrapproved")){
														print_status_top = "HR-Approved";
													}
														
													else{
														print_status_top = "Rejected";
													}
													long maxValue = 0;
													String sd = null;
													try {

														SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
														Date result = formater.parse(date);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														sd = AppDateFormat.format(result);

													} catch (ParseException e1) {
														e1.printStackTrace();
													}
													boolean flag = false;
													if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1")
															|| authority.equals("T2") || authority.equals("T3") || authority.equals("A1")
															|| authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
														maxValue = allListProbationDAO.getCount(emp_id);
													} else {
														maxValue = allListProbationDAO.getCountForM2(emp_id);
														flag = true;
													}
													int reviewing_manager_id = pa.getReviewing_manager_id();
													LoginDAO loginDAO2 = new LoginDAO();
													int id = pa.getReviewing_manager_id();
													EmployeeBean employeeBean2 = loginDAO2.getEmailIdEmployee(reviewing_manager_id);
											%>

											<tr>
												<td><%=pa.getEmployeeBean().getFirstname() + " " + pa.getEmployeeBean().getLastname()%></td>
												<td><%=employeeBean2.getFirstname() +" "+ employeeBean2.getLastname()%></td>
												<%if(flag == false){ %>
									<td>Direct Employee</td>
									<%}else{ %>
									<td>Indirect Employee</td>
									<%} %>
									<td><%=sd%></td>
									<td><%=maxValue%></td>
									<td><%=pa.getPeriod_to_be_extended()%></td>	
												<td><center><%=print_status%></center></td>
												<td><center><%=print_status_hr%></center></td>
												<td><center><%=print_status_top%></center></td>
												<td><center>
												<%if(maxValue == extended){%>
											 <a
										href="probationListByIdIndirectApprovalView.jsp?employee_master_id=<%=emp_id%>"><i
											class="glyphicon glyphicon-eye-open" data-toggle="tooltip"
											data-placement="top" title="Show View"></i></a>
											<%}else{
												%>
												Extended
											<%} %>
											</center>
											</td>
											</tr>
										
										<%
											}
										%>
</tbody>
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
	<script type='text/javascript' src='/HRMS/dwr/interface/AjaxDataDAO.js'></script>
	<script type='text/javascript' src='/HRMS/dwr/engine.js'></script>
	<script type='text/javascript' src='/HRMS/dwr/util.js'></script>
	<script type="text/javascript">
		
	</script>

	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	<script
		src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
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