<!-- Author Name :- Ripal Soni
For Getting data from user
Jsp for adding employee's scores and get their decisoin  -->


<%@page import="com.hrms.probation.bean.ProbationAssessmentTerminationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM2Bean"%>
<%@page import="com.hrms.probation.bean.AttributeM2Bean"%>
<%@page import="com.hrms.probation.bean.ProbationExtendBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentManagerBean"%>
<%@page import="com.hrms.probation.bean.ProbationAssessmentM1Bean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.probation.bean.AttributeBean"%>
<%@page import="com.hrms.probation.dao.AllListProbationDAO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			document.getElementById(id).value = 1;
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
<script type="text/javascript">
	function check1(id) {
		if (id == "continueYes") {
			document.getElementById("terminationNo").checked = true;
		}
		if (id == "terminationYes") {
			document.getElementById("continueNo").checked = true;
		}
		if (id == "continueNo") {
			document.getElementById("terminationYes").checked = true;
		}
		if (id == "terminationNo") {
			document.getElementById("continueYes").checked = true;
		}

	}
	function checkInteger(id) {

		var a = document.getElementById(id).value;

		if (isNaN(a)) {
			alert("Please! Enter grade between 1 to 5 ");
			document.getElementById(id).value = 1;
		} else if ((a % 1) != 0) {
			var b = parseInt(a);
			document.getElementById(id).value = b;
		} else {
			document.getElementById(id).value = a;

		}
	}
</script>
<%@include file="header.jsp"%>
<title>SLTL HRMS</title>
</head>
<body>

<%
List<Double> listOfTwiseMonthAverage = new ArrayList(); 
List<String> listOfComment = new ArrayList();
List<Double> listOfFinalPercentage = new ArrayList();
AllListProbationDAO allListProbationDAO = new AllListProbationDAO();
int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
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
											int month_id = Integer.parseInt(request.getParameter("month_id"));
											int year_id = Integer.parseInt(request.getParameter("year_id"));
											int probation_assessment_termination_id = Integer
													.parseInt(request.getParameter("probation_assessment_termination_id"));
											int reviewing_manager_id = Integer.parseInt(request.getParameter("reviewing_manager_id"));
											List<ProbationAssessmentM2Bean> listOfExtendedMonths = allListProbationDAO
													.getListOfScoreByEmpIdGroupbyMonthId(employee_master_id);
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
												}
										%>
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
					<div class="row">
						<div class="col-lg-12">
							<br>
							<div class="panel panel-primary">
									<div class="panel-heading">
									<b><font size="3px">Please rate on scale of 1 to 5</font></b>
									<h5>5 = Excellent , 4 = Exceeds Expectations , 3 = Fully
										Achieves Expectations , 2 = Met some but not all expectations
										, 1 = Unsatisfactory.</h5>
								</div>
								<div class="panel-body">
									<div class="table-responsive">
										<%
									
											try {

												SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
												Date result = formater.parse(date);
												SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
												sd = AppDateFormat.format(result);

											} catch (ParseException e1) {
												e1.printStackTrace();
											}
										%>
										<%
											List<ProbationAssessmentM2Bean> listOfScore = allListProbationDAO
													.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id, month_id, year_id);
										%>

										<div class="panel-body">
											<div class="table-responsive">
												<form action="probationTerminationUpdateMonthScore"
													method="post" enctype="multipart/form-data">
													<table class="table table-striped table-bordered">
														<thead>
															<tr>
																<th>Sr. No.</th>
																<th>Attributes</th>
																<%
																	AllListDAO allListDAO2 = new AllListDAO();
																	MonthBean monthBean = new MonthBean();
																	MonthBean monthBean2 = allListDAO2.getListOfMonthById(month_id);
																	String month_name = monthBean2.getMonth_name();
																%>
																<th><%=month_name%> Score</th>
															</tr>
														</thead>
														<tbody>
															<input type="hidden" name="employee_master_id"
																id="employee_master_id" value="<%=employee_master_id%>">
															<input type="hidden" name="reviewing_manager_id"
																id="reviewing_manager_id"
																value="<%=reviewing_manager_id%>">
															<input type="hidden" name="month_id" id="month_id"
																value="<%=month_id%>">
															<input type="hidden" name="year_id" id="year_id"
																value="<%=year_id%>">
															<input type="hidden"
																name="probation_assessment_termination_id"
																id="probation_assessment_termination_id"
																value="<%=probation_assessment_termination_id%>">
															<%
																for (int i = 0; i < listOfScore.size(); i++) {
																	ProbationAssessmentM2Bean p = listOfScore.get(i);
															%>
															<input type="hidden" name="attribute_id"
																id="attribute_id"
																value="<%=p.getProbation_assessment_m2_id()%>">
															<tr>

																<td><%=i + 1%></td>
																<td><%=p.getAttributeM2Bean().getProbation_attribute_M2_question()%></td>
																<td style="width: 100px;"><input type="text"
																	class="form-control" name="month_score"
																	id="month_score<%=i%>"
																	value="<%=p.getAttribute_m2_score()%>"
																	onchange="handleChange(this.id);checkInteger(this.id)"
																	required></td>
															</tr>
															<%
																}
															%>

															<%
																String continueForNextMonth = null;
																String warningLetter = null;
																String terminationLetter = null;
																String termination_remarks = null;
																
																for (ProbationAssessmentM2Bean p : listOfScore) {
																	continueForNextMonth = p.getContinue_for_next_month();
																	warningLetter = p.getWarning_letter();
																	terminationLetter = p.getTermination_letter();

																}
																List<ProbationAssessmentTerminationBean> listOfTermination = allListProbationDAO
																		.getListOfTerminatedEmployee(employee_master_id);
																for (ProbationAssessmentTerminationBean p : listOfTermination) {
																	termination_remarks = p.getTermination_remarks();
																}
															%>
															<tr id="summation">
																<td colspan="2">Total</td>
																<td align="center"><span class="sum">0</span></td>
															</tr>
											<tr>
													
													<%if(listOfExtendedMonths.size() - 1 != 0){ %>
														<td>
														<table class="table table-striped table-bordered" height="5px">
														<tr>
														<td>
														Month Name</td></tr>
														<tr><td>Total Score</td></tr>
														<tr>	<td>Average Score Per Attribute By Month</td>
														</tr>
														
														<%if(listOfExtendedMonths.size() - 1>=1){ %>
														<tr>	<td height="50px">Average Of Assessment Period</td>
														</tr>
														
														
														<%if(listOfExtendedMonths.size() - 1 >=2 ) {%>
														<tr>	<td height="50px">Cumulative Average Of Assessment Period</td>
														</tr>
														<%} %>
														
														<%if(listOfExtendedMonths.size() - 1 >=1 ) {%>
														<tr>	<td height="80px">Comment if any</td>
														</tr>
														<%} %>
														
														<%if(listOfExtendedMonths.size() - 1 >=1 ) {%>
														<tr>	<td>Action As per Key</td>
														</tr>
														<%} %>
														<%} %>
														
														</table>
														</td>
														<td colspan="2">
														<table class="table table-striped table-bordered" height="5px">
														<tr>
													<%for(int i=0;i<listOfExtendedMonths.size() - 1;i++){
												
												ProbationAssessmentM2Bean p = listOfExtendedMonths.get(i);
												
												String monthName = null;
												List<ProbationAssessmentM2Bean> listOfScoreCount = allListProbationDAO.getListOfProbationAssessmentM2ByEmpIdAndMonthId(employee_master_id,p.getMonthBean().getMonth_id(),p.getYearBean().getYear_id());
												for(ProbationAssessmentM2Bean p1 : listOfScoreCount){
													/* sumOfScore = sumOfScore + p1.getAttribute_m2_score(); */
													monthName = p.getMonthBean().getMonth_name();
												} %>
													
														
														<td align="center" width="100px"><%=monthName%></td>
												<%} %>
												<td align="center" width="100px"><%=month_name%></td>
												</tr>
												
												<tr>
												<%for(int i=0;i<listOfExtendedMonths.size() - 1;i++){
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
												<td align="center" width="100px"><span class="sum">0</span></td>
												</tr>
												<tr>
												<%for(int i=0;i<listOfExtendedMonths.size() - 1;i++){
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
													<td align="center" width="100px"><span class="sumPerAttribute">0</span></td>
												</tr>
												<%if(listOfExtendedMonths.size() - 1 >= 1){ %>
													<tr>
											<%
											double score = 0;
											double sumOfTwoMonth = 0;
											String showView = null;
											
											for(int i=0;i<listOfExtendedMonths.size() - 1;i++){
												
												
												
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
											 <b>(<%=String.format("%.2f",((sumOfTwoMonth/2)*100)/(listOfAttribute.size() * 5))%>%) <%listOfFinalPercentage.add(((sumOfTwoMonth/2)*100)/(listOfAttribute.size() * 5));%></b> <%sumOfTwoMonth = 0;showView =null;%>
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
													
													<%if((listOfExtendedMonths.size() - 1 + 1)%2 == 0 && listOfExtendedMonths.size() - 1 >=2 ) {%>
													
													<td height="50px" colspan=2 align="center">
															<label><span id="test"></span></label>
															<label><span id="test1"></span></label>
													</td>
													<%} %>
													</tr>
													
													<tr>
													<%
													for(int i = 0;i<listOfComment.size();i++){
														String comment = listOfComment.get(i);
													%>
													<td colspan="2" height ="80px" style="white-space: pre-wrap;"><%=comment %></td>
													<%} %>
													
													<%if((listOfExtendedMonths.size() - 1 + 1)%2 == 0 && listOfExtendedMonths.size() - 1 >=1 ) {%>
													
													<td colspan="2"><textarea name="comments_month_wise" class="form-control"rows="3" cols="3">-</textarea></td>
													<%} %>
													</tr>
													
													
													
													
													<tr>
													<%
													int to_be_extended = 0;

													List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO
															.getListOfScoreByEmpId(employee_master_id);
													for (ProbationAssessmentManagerBean pb : listOfExtended) {
														int probationmanager_id = pb.getProbation_assessment_manager_id();

														List<ProbationExtendBean> listForExtend = allListProbationDAO
																.getProbationExtend(probationmanager_id);
														for (ProbationExtendBean p : listForExtend) {
															String extend_period = p.getExtended_period();
															to_be_extended = to_be_extended + Integer.parseInt(extend_period);
														}
													}
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
													
													<%if((listOfExtendedMonths.size() - 1 + 1)%2 == 0 && listOfExtendedMonths.size() - 1 >=1 ) {%>
													
													<td colspan="2" class="descsion"></td>
													<%} %>
													</tr>
											</table>
													</td>
													<%} %>
												</tr>
															<tr class="hideFile">
																<td colspan="2">Continue for next month(Yes/No)</td>
																<td>
																	<div class="form-group">
																		<%
																			if (continueForNextMonth.equalsIgnoreCase("continueYes")) {
																		%>
																		<label class="radio-inline"> <input
																			type="radio" name="ContinueMonth" id="continueYes"
																			value="continueYes" onclick="check1(this.id)" checked>Yes
																		</label><br> <label class="radio-inline"> <input
																			type="radio" name="ContinueMonth" id="continueNo"
																			value="continueNo" onclick="check1(this.id)">No
																		</label>
																		<%
																			} else {
																		%>
																		<label class="radio-inline"> <input
																			type="radio" name="ContinueMonth" id="continueYes"
																			value="continueYes" onclick="check1(this.id)">Yes
																		</label><br> <label class="radio-inline"> <input
																			type="radio" name="ContinueMonth" id="continueNo"
																			value="continueNo" onclick="check1(this.id)" checked>No
																		</label>
																		<%
																			}
																		%>
																	</div>
																</td>
															</tr>
															<tr class="hideFile">
																<td colspan="2">Issue warning letter(Yes/No)</td>
																<td>
																	<div class="form-group">
																		<%
																			if (warningLetter.equalsIgnoreCase("warningYes")) {
																		%>

																		<label class="radio-inline"> <input
																			type="radio" name="warningLetter" id="warningYes"
																			value="warningYes" checked>Yes
																		</label><br> <label class="radio-inline"> <input
																			type="radio" name="warningLetter" id="warningNo"
																			value="warningNo">No
																		</label>
																		<%
																			} else {
																		%>
																		<label class="radio-inline"> <input
																			type="radio" name="warningLetter" id="warningYes"
																			value="warningYes">Yes
																		</label><br> <label class="radio-inline"> <input
																			type="radio" name="warningLetter" id="warningNo"
																			value="warningNo" checked>No
																		</label>
																		<%
																			}
																		%>
																	</div>
																</td>
															</tr>
															
															<tr class="hideFile">
																<td colspan="2">Issue termination letter(Yes/No)</td>
																<td>
																	<div class="form-group">
																		<%
																			if (continueForNextMonth.equalsIgnoreCase("continueYes")) {
																		%>
																		<label class="radio-inline"> <input
																			type="radio" name="terminationLetter"
																			id="terminationYes" value="terminationYes"
																			onclick="check1(this.id)">Yes
																		</label><br> <label class="radio-inline"> <input
																			type="radio" name="terminationLetter"
																			id="terminationNo" onclick="check1(this.id)"
																			value="terminationNo" checked>No
																		</label>
																		<%
																			} else {
																		%>
																		<label class="radio-inline"> <input
																			type="radio" name="terminationLetter"
																			id="terminationYes" value="terminationYes"
																			onclick="check1(this.id)" checked="checked">Yes
																		</label><br> <label class="radio-inline"> <input
																			type="radio" name="terminationLetter"
																			id="terminationNo" onclick="check1(this.id)"
																			value="terminationNo">No
																		</label>
																		<%
																			}
																		%>
																	</div>
																</td>
															</tr>
												
														</tbody>
													</table>
													<%
														if (terminationLetter.equalsIgnoreCase("terminationYes")) {
													%>
													<div class="col-lg-12" id="divshow">
														<label style="color: red">
															<h5>Termination Reason: (Please mention the reason for decision of Termination )</h5>
														</label>
														<textarea rows="3" cols="90" class="form-control"
															name="termination_remarks"
															placeholder="Enter Your Remarks:"><%=termination_remarks%></textarea>
														<br>
													</div>
													<%
														}
													%>			
													<center>
														<input type="hidden" name="redirect" id="redirect">
														<input type="submit" value="Update"
															class="btn btn-primary">
													</center>
												</form>
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
			
			$(".hideFile").hide();
			
			
			$('[name="month_score"]').each(function() {

				$(this).keyup(function() {
					calculateSum();
				});
			});

		});

		function calculateSum() {
		
			<%
			if(request.getParameter("employee_master_id") != null){
			employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));%>
			var sum = 0;
			var previousMonthScore = parseInt($('#previousMonthScore').val());
			var sumOfTwoMonth = previousMonthScore;
			var finalViewOfCumulative = null;
			var finalSum = 0;
			//iterate through each textboxes and add the values
			$('[name="month_score"]').each(function() {

				//add only if the value is number
				if (!isNaN(this.value) && this.value.length != 0) {
					sum += parseFloat(this.value);
					sumOfTwoMonth += parseFloat(this.value);
				}

			});
			
			var sumOfWorkHour = parseInt($('#sumOfworkHours').val());
			var totalWorkHour = sumOfWorkHour + sum;
			var sumPerAttribute = (sum/<%=listOfAttribute.size()%>).toFixed(2)
			var pecentagePerAttribute = ((sum*100)/<%=(listOfAttribute.size())*5%>).toFixed(2)
			var finalOutput = "("+previousMonthScore.toFixed(0) +' + '+sum+') =';
			var finalOutputDisplay = sumOfTwoMonth +' / '+2+' =';
		/* 	var finalOutputDisplay = $('#previousMonthScore').val() +'+'+sum +'/'+ 2;  */


		<%for(double d : listOfTwiseMonthAverage){%>
			if(finalViewOfCumulative == null){
				finalViewOfCumulative = <%=d%>+'';
			}else{
				finalViewOfCumulative = finalViewOfCumulative+'+'+<%=d%>;
			}
			
			finalSum += <%=d%>;
			
		<%}%>
		
		finalSum += sumOfTwoMonth.toFixed(2)/2;
		var twoMonthPer = ((((sumOfTwoMonth.toFixed(2)/2)*100)/<%=(listOfAttribute.size())*5%>).toFixed(2));
		var descsion = null;
		
		
		
		<%
		int to_be_extended = 0;
		List<ProbationAssessmentManagerBean> listOfExtended = allListProbationDAO
				.getListOfScoreByEmpId(employee_master_id);
		for (ProbationAssessmentManagerBean pb : listOfExtended) {
			int probationmanager_id = pb.getProbation_assessment_manager_id();

			List<ProbationExtendBean> listForExtend = allListProbationDAO
					.getProbationExtend(probationmanager_id);
			for (ProbationExtendBean p : listForExtend) {
				String extend_period = p.getExtended_period();
				to_be_extended = to_be_extended + Integer.parseInt(extend_period);
			}
		}
		if(listOfExtendedMonths.size() == 2){
			%>
			if(twoMonthPer < 35){
				descsion = 'Terminate';
				document.getElementById("terminationYes").checked = true;
				document.getElementById("continueNo").checked = true;
				document.getElementById("warningNo").checked = true;
				$("#divshow").show();
				
			}else if(twoMonthPer>=35 && twoMonthPer < 40){
				descsion = 'Warn';
				document.getElementById("terminationNo").checked = true;
				document.getElementById("continueYes").checked = true;
				document.getElementById("warningYes").checked = true;
				$("#divshow").hide();
				
			}else if(twoMonthPer>=40){
				descsion = 'Retain';
				document.getElementById("terminationNo").checked = true;
				document.getElementById("continueYes").checked = true;
				document.getElementById("warningNo").checked = true;
				$("#divshow").hide();
			}
			<%}else if(listOfExtendedMonths.size() == 4){ %>
			
			if(twoMonthPer<40){
				descsion = 'Terminate';
				document.getElementById("terminationYes").checked = true;
				document.getElementById("continueNo").checked = true;
				document.getElementById("warningNo").checked = true;
				$("#divshow").show();
				
			}else if(twoMonthPer>=40 && twoMonthPer < 45){
				descsion = 'Warn';
				document.getElementById("warningYes").checked = true;
				document.getElementById("terminationNo").checked = true;
				document.getElementById("continueYes").checked = true;
				$("#divshow").hide();
				
			}else if(twoMonthPer>=45){
				descsion = 'Retain';
				document.getElementById("terminationNo").checked = true;
				document.getElementById("continueYes").checked = true;
				document.getElementById("warningNo").checked = true;
				$("#divshow").hide();
			}
			
			
			<%}else if(listOfExtendedMonths.size() == 6){ %>
			
			if(twoMonthPer<50){
				descsion = 'Terminate';
				document.getElementById("terminationYes").checked = true;
				document.getElementById("continueNo").checked = true;
				document.getElementById("warningNo").checked = true;
				$("#divshow").show();
				
			}else if(twoMonthPer>=50 && twoMonthPer <55){
				descsion = 'Warn';
				document.getElementById("terminationNo").checked = true;
				document.getElementById("continueYes").checked = true;
				document.getElementById("warningYes").checked = true;
				$("#divshow").hide();
			}else if(twoMonthPer>=55){
				descsion = 'Retain';
				document.getElementById("terminationNo").checked = true;
				document.getElementById("continueYes").checked = true;
				document.getElementById("warningNo").checked = true;
				
			}
			
			<%}else if(listOfExtendedMonths.size() == 8){ %>
			
			if(<%=to_be_extended%> == 2){
				if(twoMonthPer<55){
					descsion = 'Terminate';
					document.getElementById("terminationYes").checked = true;
					document.getElementById("continueNo").checked = true;
					document.getElementById("warningNo").checked = true;
					$("#divshow").show();
				}else if(twoMonthPer>=55){
					descsion = 'Retain';
					document.getElementById("terminationNo").checked = true;
					document.getElementById("continueYes").checked = true;
					document.getElementById("warningNo").checked = true;
					$("#divshow").hide();
				}
				}else{
					if(twoMonthPer<50){
						descsion = 'Terminate';
						document.getElementById("terminationYes").checked = true;
						document.getElementById("continueNo").checked = true;
						document.getElementById("warningNo").checked = true;
						$("#divshow").show();
						
					}else if(twoMonthPer>=50 && twoMonthPer <55){
						descsion = 'Warn';
						document.getElementById("terminationNo").checked = true;
						document.getElementById("continueYes").checked = true;
						document.getElementById("warningYes").checked = true;
						$("#divshow").hide();
					}else if(twoMonthPer>=55){
						descsion = 'Retain';
						document.getElementById("terminationNo").checked = true;
						document.getElementById("continueYes").checked = true;
						document.getElementById("warningNo").checked = true;
						
					}
				}
			
			<%}else if(listOfExtendedMonths.size() == 10){ %>
			
			
			if(twoMonthPer<55){
				descsion = 'Terminate';
				document.getElementById("terminationYes").checked = true;
				document.getElementById("continueNo").checked = true;
				document.getElementById("warningNo").checked = true;
				$("#divshow").show();
			}else if(twoMonthPer>=55){
				descsion = 'Retain';
				document.getElementById("terminationNo").checked = true;
				document.getElementById("continueYes").checked = true;
				document.getElementById("warningNo").checked = true;
				$("#divshow").hide();
			}
			<%}%>
		
			
			$(".sum").html(sum.toFixed(2));
			$(".sumPerAttribute").html(sumPerAttribute);
			$(".pecentagePerAttribute").html(pecentagePerAttribute+'%');
			$("#finalOutputDisplay").html(finalOutputDisplay);
			$("#sumOfTwoMonth").html(sumOfTwoMonth.toFixed(2)/2);
			$("#sumOfTwoMonthPer").html('('+twoMonthPer+'%)');
			$("#finalOutput").html(finalOutput);
			
			var fSum = finalSum/(<%=listOfTwiseMonthAverage.size() + 1 %>);
			
			$("#test").html(finalViewOfCumulative+'+'+sumOfTwoMonth.toFixed(2)/2+'='+finalSum+'/'+<%=listOfTwiseMonthAverage.size() + 1%> +'='+fSum.toFixed(2));
			$("#test1").html('('+((fSum*100)/<%=((listOfAttribute.size())*5)%>).toFixed(2)+'%)');
			$(".descsion").html(descsion);
			
			
			/* $("#finalOutputDisplay").html(finalOutputDisplay); */
			<%}%>	
		}
			
			
	</script>
	<script>
		$(document).ready(function() {
			$('#continueYes').on('change', function() {
				if (this.value == 'continueYes') {
					$("#divshow").hide();
				}

			});
			$('#continueNo').on('change', function() {
				if (this.value == 'continueNo') {
					$("#divshow").show();
				}

			});
			$('#terminationYes').on('change', function() {
				if (this.value == 'terminationYes') {
					$("#divshow").show();
				}

			});
			$('#terminationNo').on('change', function() {
				if (this.value == 'terminationNo') {
					$("#divshow").hide();
				}
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
