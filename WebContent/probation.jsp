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
<%@include file="header.jsp"%>
<body onload="startTimer()">

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
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Confirmation Assessment Form</h4>
							</div>
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
			</form>
			<br>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h5>5 = Excellent , 4 = Exceeds Expectations , 3 = Fully
								Achieves Expectations , 2 = Met some bit not all expectations ,
								1 = Unsatisfactory.</h5>
							<h4></h4>
						</div>
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
			<%
				} else {
			%>
			<form action="probation.jsp" method="get">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Confirmation Assessment Form</h4>
							</div>
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
			</form>
			<%
				}
			%>

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