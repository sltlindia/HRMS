<%@page import="java.text.ParseException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentTerminationBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM2Bean"%>
<%@page import="com.hrms.probation.dao.AllListProbationDAO"%>
<%@page import="com.hrms.probation.bean.AttributeM2Bean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/fixedHeader.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<%@include file="header.jsp"%>
</head>
<script type="text/javascript">
	function save(id) {
		if (id == 1) {
			document.getElementById('action').value = "approved";
		} else if (id == 2) {
			document.getElementById('action').value = "rejected";
		}
	}
</script>
<body>

	<%
		int employee_master_id = 0;

		if (request.getParameter("employee_master_id") != null) {
			employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		}

		AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
		List<Double> listOfTwiseMonthAverage = new ArrayList(); 
		List<String> listOfComment = new ArrayList();
		List<Double> listOfFinalPercentage = new ArrayList();
		AllListDAO allListDAO = new AllListDAO();
		LoginDAO loginDAO = new LoginDAO();
		EmployeeBean employeeBean = loginDAO.getInfoById(employee_master_id);
		String authority = employeeBean.getRoleBean().getRole_authority();
		List<AttributeM2Bean> listOfAttribute = null;
		if (authority.equals("W1") || authority.equals("W2") || authority.equals("W3")
																					|| authority.equals("T1") || authority.equals("T2") || authority.equals("T3")
																					|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3")
																					|| authority.equals("A4")) {

																				 listOfAttribute = allListProbationDAO.getListOfAttributeM2Direct();
		}else {
																			
																 listOfAttribute = allListProbationDAO.getListOfAttributeM2();

		}
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
					<div class="panel panel-primary">
						<div class="panel-heading">
							<b><font size="3px">Employee's Probation Form Detail</font></b>
						</div>
						<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-hover">
											<tr>
												<%
												int emp_id = 0;
												employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
												List<ProbationAssessmentM2Bean> listOfExtendedMonths = allListProbationDAO
														.getListOfScoreByEmpIdGroupbyMonthId(employee_master_id);
												/* int month_id = Integer.parseInt(request.getParameter("month_id"));
												int year_id = Integer.parseInt(request.getParameter("year_id"));
												int probation_assessment_termination_id = Integer.parseInt(request.getParameter("probation_assessment_termination_id"));
												int reviewing_manager_id = Integer.parseInt(request.getParameter("reviewing_manager_id")); */
											%>
												<td><label>Employee Name :</label></td>
												<td colspan="2"><font color="blue"><%=employeeBean.getFirstname() + " " + employeeBean.getLastname()%></font></td>
												<td><label>Employee Code :</label></td>
												<td colspan="2"><font color="blue"><%=employeeBean.getEmployee_code()%></font></td>
												<td><label>Reporting Manager Name :</label></td>
												<%
													LoginDAO loginDAO2 = new LoginDAO();
													int id = Integer.parseInt(employeeBean.getUnder_manager_id());
													EmployeeBean employeeBean2 = loginDAO2.getEmailId(id);
												%>
												<td><font color="blue"><%=employeeBean2.getFirstname() + " " + employeeBean2.getLastname()%></font></td>
											</tr>
											<tbody>
											<%
											String date = employeeBean.getJoining_date();
											/* DateFormat inputDF  = new SimpleDateFormat("mm/dd/yy"); */
											Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
											String sd = null;
											try {

												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												Date result = formater.parse(date);
												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												sd = AppDateFormat.format(result);

											} catch (ParseException e1) {
												e1.printStackTrace();
											} %>
												<tr>
												<td><label>Date Of Joining:</label></td>
												<td colspan="4"><font color="blue"><%=sd%></font></td>
												<td><label>Designation :</label></td>
												<td colspan="3"><font color="blue"><%=employeeBean.getRoleBean().getRole_type()%></font></td>
											</tr>
											<tr>
											<td><label>Department :</label></td>
											<td colspan="4"><font color="blue"><%=employeeBean.getDepartmentBean().getDepartment_name()%></font></td>
											<td><label>Sub Department :</label></td>
											<td colspan="3"><font color="blue"><%=employeeBean.getSub_department()%></font></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form id="approvalForm" action="probationTerminationStatusInsert"
						method="get" name="approvalForm">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<b><font size="3px">Terminated Employee's Score Details</font></b>
							</div>
							<input type="hidden" name="employee_master_id"
								id="employee_master_id" value="<%=employee_master_id%>">
							<input type="hidden" name="action" id="action" value="">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered">
										<tr>
											<th>Sr. No</th>
											<th>Attribute</th>
											<%
												List<ProbationAssessmentM2Bean> listOfMonthByProbationM2 = allListProbationDAO
														.getListOfProbationAssessmentM2ByEmpIDGroupBy(employee_master_id);
											String termination = null;
												for (ProbationAssessmentM2Bean probationAssessmentM2Bean : listOfMonthByProbationM2) {
											%>

											<th><%=probationAssessmentM2Bean.getMonthBean().getMonth_name()%></th>
											<%
												}
											%>
										</tr>


										<%
											for (int i = 0; i < listOfAttribute.size(); i++) {
												AttributeM2Bean p = listOfAttribute.get(i);
												int attribute_id = p.getProbation_attribute_M2_id();
										%>

										<tr>
											<td><%=i + 1%></td>
											<td><%=p.getProbation_attribute_M2_question()%></td>
											<%
												List<ProbationAssessmentM2Bean> listOfAssetmentM2Bean = allListProbationDAO
															.getListOfProbationAssessmentM2ByEmpIDAndQueID(employee_master_id, attribute_id);
													for (ProbationAssessmentM2Bean probationAssessmentM2Bean : listOfAssetmentM2Bean) {
											%>

											<td><%=probationAssessmentM2Bean.getAttribute_m2_score()%></td>
											<%
												}
											%>
										</tr>
										<%
											}
										%>
										</table>
</div>
													<div class="table-responsive">

												<table class="table table-striped table-bordered">

																				<tr>
													
													<%if(listOfExtendedMonths.size() != 0){ %>
														<td>
														<table class="table table-striped table-bordered" height="5px">
														<tr>
														<td>
														Month Name</td></tr>
														<tr><td>Total Score</td></tr>
														<tr>	<td>Average Score Per Attribute By Month</td>
														</tr>
														
														<%if(listOfExtendedMonths.size()>=1){ %>
														<tr>	<td height="50px">Average Of Assessment Period</td>
														</tr>
														
														
														<%if(listOfExtendedMonths.size() >=2 ) {%>
														<tr>	<td height="50px">Cumulative Average Of Assessment Period</td>
														</tr>
														<%} %>
														
														<%if(listOfExtendedMonths.size() >=1 ) {%>
														<tr>	<td height="80px">Comment if any</td>
														</tr>
														<%} %>
														
														<%if(listOfExtendedMonths.size() >=1 ) {%>
														<tr>	<td>Action As per Key</td>
														</tr>
														<%} %>
														<%} %>
														
														</table>
														</td>
														<td colspan="2">
														<table class="table table-striped table-bordered" height="5px">
														<tr>
													<%for(int i=0;i<listOfExtendedMonths.size();i++){
												
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												
												String monthName = null;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){
													/* sumOfScore = sumOfScore + p1.getAttribute_m2_score(); */
													monthName = p.getMonthBean().getMonth_name();
												} %>
													
														
														<td align="center" width="100px"><%=monthName%></td>
												<%} %>
												</tr>
												
												<tr>
												<%for(int i=0;i<listOfExtendedMonths.size();i++){
												double sumOfScore = 0;
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												
												String monthName = null;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){

													sumOfScore = sumOfScore + p1.getAttribute_m2_score();
													monthName = p.getMonthBean().getMonth_name();
												} %>
													
														
														<td align="center" width="100px"><%=sumOfScore%></td>
														
														
												<%} %>
												</tr>
												<tr>
												<%for(int i=0;i<listOfExtendedMonths.size();i++){
												double sumOfScore = 0;
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												
												String monthName = null;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){

													sumOfScore = sumOfScore + p1.getAttribute_m2_score();
													monthName = p.getMonthBean().getMonth_name();
												} %>
													
														
														<td align="center" width="100px"><%=String.format("%.2f", sumOfScore/listOfAttribute.size()) %></td>
														
												<%} %>
												</tr>
												<%if(listOfExtendedMonths.size() >= 1){ %>
													<tr>
											<%
											double score = 0;
											double sumOfTwoMonth = 0;
											String showView = null;
											
											for(int i=0;i<listOfExtendedMonths.size();i++){
												
												
												
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												double sumOfScore = 0;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){
													sumOfScore = sumOfScore + p1.getAttribute_m2_score();
													
												}
												
												sumOfTwoMonth = sumOfTwoMonth + sumOfScore;	
												
												
												if(showView == null){
													showView = sumOfScore+"";
												}else{
													showView = showView +" + "+sumOfScore;
												}
												
												
												
												if((i+1)%2 != 0){
													score = sumOfScore;
												}else{
													score = 0;
													listOfTwiseMonthAverage.add(sumOfTwoMonth/2);
													listOfComment.add(p.getComment_monthly());
													
											%>
											<td height="50px" colspan="2" align="center">(<%=showView%>) = <%=sumOfTwoMonth%>/2 = <%=sumOfTwoMonth/2%>
											<br>
											 <b>(<%=String.format("%.2f",(((sumOfTwoMonth/2)*100)/(listOfAttribute.size() * 5)))%>%) <%listOfFinalPercentage.add(((sumOfTwoMonth/2)*100)/(listOfAttribute.size() * 5));%></b> <%sumOfTwoMonth = 0;showView =null;%>
											</td>
											<%} %>
											<%} %>
											
											<%if(score != 0){ %>
											
											<td height="50px" colspan="2" align="center">
											<input type="hidden" id="previousMonthScore" value="<%=score%>"> 
											<span id="finalOutput"></span> 
											<span id="finalOutputDisplay"></span>
											<span id="sumOfTwoMonth"></span>
											<br>
											<span style="font-weight: bold;" id="sumOfTwoMonthPer"></span>
											</td>
									<%} %>
											
											</tr>
											<%} %>
											<tr>
											<%
													double sumOfAverage = 0;
													String twiseMonthAverageDisplay = null;
													for(int i = 0;i<listOfTwiseMonthAverage.size();i++){
														Double d = listOfTwiseMonthAverage.get(i);
													 	sumOfAverage = sumOfAverage + d;
													 	if(twiseMonthAverageDisplay == null){
													 		twiseMonthAverageDisplay = d.toString();
													 	}else{
													 		twiseMonthAverageDisplay = twiseMonthAverageDisplay +"+"+d;
													 	}
													 	if(i!=0){
													%>
													<td height="50px" colspan="2" align="center"><label><%=twiseMonthAverageDisplay%>=<%=sumOfAverage%>/<%=i+1%> = <%=sumOfAverage/(i+1)%> (<%=String.format("%.2f",((sumOfAverage/(i+1)*100)/(listOfAttribute.size() * 5)))%>%)</label></td>
													<%} else{%>
													<td height="50px" colspan="2" align="center"><label>NA</label></td>
													<%} %>
													<%} %>
													
													</tr>
													
													<tr>
													<%
													for(int i = 0;i<listOfComment.size();i++){
														String comment = listOfComment.get(i);
													%>
													<td colspan="2" height ="80px" style="white-space: pre-wrap;"><%=comment %></td>
													<%} %>
													
													</tr>
													
													
													
													
													<tr>
													<%
													for(int i = 0;i<listOfFinalPercentage.size();i++){
														Double d = listOfFinalPercentage.get(i);
														String result = null;
														

														if(i==0){
															if(d<35){
																result = "Terminate";
															}else if(d>=35 && d<40){
																result = "Warn";
															}else if(d>=40){
																result = "Retain";
															}
														}else if(i==1){
															if(d<40){
																result = "Terminate";
															}else if(d>=40 && d<45){
																result = "Warn";
															}else if(d>=45){
																result = "Retain";
															}
														}else if(i==2){
															
															if(d<50){
																result = "Terminate";
															}else if(d>=50 && d<55){
																result = "Warn";
															}else if(d>=55){
																result = "Retain";
															}
														}else {
															if(d<50){
																result = "Terminate";
															}else if(d>=50 && d<55){
																result = "Warn";
															}else if(d>=55){
																result = "Retain";
															}
														}
														
														
													%>
													<td colspan="2"><%=result%></td>
													<%} %>
													</tr>
													
													
													
													
													
											<%-- <tr>
											
									
											
											
											
											
											
											<td colspan="2" align="center">(<%=showView%>) = <%=sumOfTwoMonth%>/2 = <%=sumOfTwoMonth/2%> <%sumOfTwoMonth = 0;showView =null;%>
											</td>
											
											
											
											
											</tr> --%>
											</table>
													</td>
													<%} %>
												</tr>
										<%-- <tr>
											<th colspan="2">Continue For Next Month</th>
											<%
												for (ProbationAssessmentM2Bean probationAssessmentM2Bean : listOfMonthByProbationM2) {
													
											if (probationAssessmentM2Bean.getContinue_for_next_month().equalsIgnoreCase("continueYes")) {%>
											<th>Yes</th>
											<%
												}else{
											%>
											<th>No</th>
											<%}} %>
										</tr>


										<tr>
											<th colspan="2">Issue Warning Letter</th>
											<%
												for (ProbationAssessmentM2Bean probationAssessmentM2Bean : listOfMonthByProbationM2) {
											if (probationAssessmentM2Bean.getWarning_letter().equalsIgnoreCase("warningYes")){%>
											<th>Yes</th>
											<%
												}else{
											%>
											<th>No</th>
											<%}} %>
										</tr>
										<tr>
											<th colspan="2">Issue Termination Letter</th>
											<%
												for (ProbationAssessmentM2Bean probationAssessmentM2Bean : listOfMonthByProbationM2) {
													termination = probationAssessmentM2Bean.getTermination_letter();
											if (probationAssessmentM2Bean.getTermination_letter().equalsIgnoreCase("terminationYes")) {%>
											<th>Yes</th>
											<%
												}else{
											%>
											<th>No</th>
											<%}} %>
										</tr>
 --%>
									</table>
								<%
								List<ProbationAssessmentTerminationBean> listOfTermination = allListProbationDAO.getListOfTerminatedEmployee(employee_master_id);
								for(ProbationAssessmentTerminationBean p : listOfTermination){ %>
								<%-- <%if(termination.equalsIgnoreCase("terminationYes")){ %> --%>
								<%if(!p.getTermination_remarks().equalsIgnoreCase("null")){ %>
									<div class="col-lg-12" id="divshow">
										<label style="color: red">
											<h5>Termination Remarks: (Termination reason for decision of Termination )</h5>
										</label>
										<textarea rows="3" cols="90" class="form-control"
											name="remarks1" placeholder="Enter Your Remarks:" readonly="readonly"><%=p.getTermination_remarks()%></textarea>
												<br>
									</div>
									<%}%>
								<%if(!p.getManager_status().equalsIgnoreCase("pending")) %>	
								<div class="col-lg-12">
								<label>Manager's Approval Status: </label>
								<%
									if (p.getManager_status().equalsIgnoreCase("approved")) {
								%>
								<font color="green"><b>Approved</b></font>
								<%
									} else if (p.getManager_status().equalsIgnoreCase("Rejected")) {
								%>
								<font color="red"><b>Rejected</b></font>
								<%
									}
								 else if (p.getManager_status().equalsIgnoreCase("pending")) {
								%>
								<%
									}%>
							</div>
								<%if(p.getManager_status().equalsIgnoreCase("rejected")){ %>
								<div class="col-lg-12" id="divshow">
									<label style="color: red">
										<h5>Manager Rejection Remarks:</h5>
									</label>
									<textarea rows="3" cols="90" class="form-control"
										name="remarks1" placeholder="Enter Your Remarks:" readonly="readonly"><%=p.getManager_rejection_remarks()%></textarea>
											<br>
								</div>
								<%}
								
								}%>
								</div>
						
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h3 class="modal-title" id="myModalLabel">Rejection
												Remarks</h3>
										</div>
										<div class="modal-body">
											<textarea class="form-control" rows="3" name="remarks"
												id="remarks"></textarea>
										</div>
										<div class="modal-footer">
											<input type="submit" class="btn btn-primary" name="submit"
												value="SUBMIT" onclick="save(2)">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<br>
							<center>
								<button type="submit" class="btn btn-primary" id="action"
									onclick="save(1)">Approve</button>
								<button type="button" class="btn btn-danger" id="action"
									data-toggle="modal" data-target="#myModal">Reject</button>
							</center>

							<!-- /.row -->

							<!-- /#page-wrapper -->
							<br>
						</div>
							</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<!--   <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script> -->

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<!--  <script>
    $(document).ready(function() {
       /*  $('#dataTables-example').DataTable({
                responsive: true
        }); */
        $('#dataTables-example1').DataTable({
            responsive: true
    });
        $('#dataTables-example2').DataTable({
            responsive: true
    });
    });
    </script> -->

	<script src="js/datatables/jquery.dataTables.min.js"></script>
	<script src="js/datatables/dataTables.bootstrap.js"></script>
	<script src="js/datatables/dataTables.buttons.min.js"></script>
	<script src="js/datatables/buttons.bootstrap.min.js"></script>
	<script src="js/datatables/jszip.min.js"></script>
	<script src="js/datatables/pdfmake.min.js"></script>
	<script src="js/datatables/vfs_fonts.js"></script>
	<script src="js/datatables/buttons.html5.min.js"></script>
	<script src="js/datatables/buttons.print.min.js"></script>
	<script src="js/datatables/dataTables.fixedHeader.min.js"></script>
	<script src="js/datatables/dataTables.keyTable.min.js"></script>
	<script src="js/datatables/dataTables.responsive.min.js"></script>
	<script src="js/datatables/responsive.bootstrap.min.js"></script>
	<script src="js/datatables/dataTables.scroller.min.js"></script>

	<script src="js/pace/pace.min.js"></script>
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