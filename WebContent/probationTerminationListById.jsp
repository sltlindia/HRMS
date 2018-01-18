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
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

	<%
		int employee_master_id1 = 0;

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
				               		<h4 class="card-title" id="horz-layout-basic">Employee's Probation Form Detail</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			
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
			</div>
			</div>
			</div>
			</div>

			<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Terminated Employee's Score Details</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
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