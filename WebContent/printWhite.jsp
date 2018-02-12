<%@page import="com.hrms.pms.bean.AppraisalUpdateManagerScoreBean"%>
<%@page import="com.hrms.pms.controller.AppraisalScoreManagerUpdateServlet"%>
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
    <title>Appraisal</title>
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
<script type="text/javascript">
function hide(){
	for(var a=0;a<3;a++){
	$("#ave"+a).hide();
	$("#avef"+a).show();
	}
	
	$("#avef").show();
	$("#ave").hide();
}
</script>
<script>
window.onload = function(){
	$("#avef").hide();
	for(var a=0;a<3;a++){
		$("#avef"+a).hide();
	}
}
</script>
<%@include file="header.jsp"%>
</head>
<style>
@media print {
.break {page-break-before: always;}	
</style>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
int appraisal_id = 0;
if(request.getParameter("appraisal_id")!=null){
	appraisal_id =Integer.parseInt(request.getParameter("appraisal_id"));
}else{
	appraisal_id =(Integer) request.getAttribute("appraisal_id");
}
AllListDAO allListDAO = new AllListDAO();
List<AppraisalBean> appraisalBean = allListDAO.getappraisal(appraisal_id);
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
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <%
                                        for(AppraisalBean a : appraisalBean){
                                        	if(a.getQuterlyMonthBean().getQuarterly_month_id() != 5){%>
                                        	Appraisal of <%=a.getQuterlyMonthBean().getMonth_duration()%>,<%=a.getYearBean().getYear()%>
                                        	<%}else if(a.getMonthBean().getMonth_id() == 13){
                                        		int year =Integer.parseInt(a.getYearBean().getYear()) + 1;
                                        %>
                                         Appraisal of <%=a.getYearBean().getYear()%> - <%=year%>
                                        <%}else{ %>
                           Appraisal of <%=a.getMonthBean().getMonth_name()%>,<%=a.getYearBean().getYear()%>
                           <%} }%>
                        </div>
                        <!-- .panel-heading -->
                        <div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Appraisal Summary</h4>
				                </div>
				            </div>
                       <!--  <div class="panel-body">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Appraisal Summary</a>
                                        </h4>
                                    </div> -->
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                        <%
                                        for(AppraisalBean a : appraisalBean){
                                        %>
										<table class="table table-bordered">
											<tr>
											<th>Employee Name</th>
											<td><%=a.getEmployeeBean().getFirstname()+" "+a.getEmployeeBean().getLastname()%></td>
											<th>Employee Code</th>
											<td><%=a.getEmployeeBean().getEmployee_code()%></td>
											</tr>	
											
											<tr>
											<th>Designation</th>
											<td><%=a.getEmployeeBean().getRoleBean().getRole_type() %></td>
											<th>Department</th>
											<td><%=a.getEmployeeBean().getDepartmentBean().getDepartment_name()%></td>
											</tr>
											
											<%
											String joining_date = a.getEmployeeBean().getJoining_date();
											String sd = null;
											try {
    											  
    											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    											Date result = formater.parse(joining_date);
    											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    											sd = AppDateFormat.format(result);
    											System.out.println(AppDateFormat.format(result));
    											
    											
    											
    										} catch (ParseException e1) {
    											e1.printStackTrace();
    										}%>	
											<tr>
											<th>Date of Joining</th>
											<td><%=sd%></td>
											<th>Location</th>
											<td></td>
											</tr>
											
											<tr>
											<th>Total Work Experience</th>
											<td></td>
											<th>Prsesent Grade</th>
											<td></td>
											</tr>	
											
											<tr>
											<th colspan="2">Name & Designation of Appraising Officer</th>
											<%int manager_id =Integer.parseInt(a.getEmployeeBean().getUnder_manager_id());
											LoginDAO loginDAO = new LoginDAO();
											EmployeeBean employeeBean = loginDAO.getUserByManagerId(manager_id);
											%>
											<td colspan="2"><%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%></td>
											</tr>
											
											<tr>
											<th colspan="2">Name & Designation of Reviewing Officer</th>
											<td colspan="2"><%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%></td>
											</tr>
																				
										</table>
										<%} %>   
										<%
										double totalSec1 = 0;
										double totalGrade = 0;
										List<AppraisalLeaveBean> listOfLeave = allListDAO.getappraisalLeave(appraisal_id);
									for(AppraisalLeaveBean appraisalLeaveBean : listOfLeave){
										totalSec1 = totalSec1 + appraisalLeaveBean.getAppraisalGradeBean().getAppraisal_grade_id();
										totalGrade++;
									}
									%>
									<%List<AppraisalKizenBean> listOfKaizen = allListDAO.getappraisalKaizen(appraisal_id);
									for(AppraisalKizenBean appraisalKizenBean : listOfKaizen){
										totalSec1 = totalSec1 + appraisalKizenBean.getAppraisalGradeBean().getAppraisal_grade_id();
										totalGrade++;
									}
									%>
										<%List<Appraisal5sBean> listOf5s = allListDAO.getappraisal5s(appraisal_id);
									for(Appraisal5sBean appraisal5sBean : listOf5s){
										totalSec1 = totalSec1 + appraisal5sBean.getAppraisalGradeBean().getAppraisal_grade_id();
										totalGrade++;
									}
									
									double aveSec1 = Math.round(totalSec1/totalGrade);
									
									double totalGoals = 0;
									double goalSize = 0;
									
									List<AppraisalWhiteCollarGradeBean> listOfGrade = allListDAO.getappraisalGrade(appraisal_id);
									for(AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean : listOfGrade){
										totalGoals = totalGoals + appraisalWhiteCollarGradeBean.getAppraisalGradeBean().getAppraisal_grade_id();
										goalSize++;
									}
									
									double aveGoal =Math.round(totalGoals/goalSize);
									
									double totalWork = 0;
									double workSize = 0;
									
									List<WorkGradeBean> listOfWorkGrade = allListDAO.getWorkGrader(appraisal_id);
									for(WorkGradeBean workGradeBean : listOfWorkGrade){
										totalWork = totalWork + workGradeBean.getAppraisalGradeBean().getAppraisal_grade_id();
										workSize++;
									}
									
									double aveWork =Math.round(totalWork / workSize);
									
									%>
									
									<div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <center>Summary Of Ratings</center>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
									<form action="appraisalScoreManagerUpdate" method="post" enctype="multipart/form-data">
									<input type="hidden" name="appraisal_id" value="<%=appraisal_id%>">
									<table class="table table-bordered">
									<thead>
													<tr>
														<th><center>Factors</center></th>
														<th><center>Ratings <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
														<th><center>Weightage</center></th>
														<th><center>Obtain</center></th>
													</tr>
												</thead>
									
									<%
									List<AppraisalCriteriaManagerBean> listAppraisalCriteria = allListDAO.getListOfManagerCriteria();
									List<AppraisalUpdateManagerScoreBean> listUpdatedScore = allListDAO.getUpdatedScore(appraisal_id);
									
									if(listUpdatedScore.size() == 0){
									
									double total1 = 0;
									for(int i = 0; i<listAppraisalCriteria.size();i++){
										AppraisalCriteriaManagerBean a = listAppraisalCriteria.get(i);
										double obtain = 0;
									%>
									<tbody>
									<tr>
										<td>
										<input type="hidden" name="appraisal_criteria_id" value="<%=a.getAppraisal_criteria_manager_id()%>">
										<%=a.getAppraisal_criteria_name()%></td>	
										<td><%if(a.getAppraisal_criteria_manager_id() == 3){
											obtain = (aveSec1 * a.getWeightage()) / 5;
											%>
										<div id="ave<%=i%>"><%=aveSec1%></div>
										<div id="avef<%=i%>"><input type="hidden" value="<%=aveSec1%>" name="score" class="form-control"></div>
										<%} else if(a.getAppraisal_criteria_manager_id() == 1){
											obtain = (aveGoal * a.getWeightage()) / 5;
										%>
										<div id="ave<%=i%>"><%=aveGoal %></div>
										<div id="avef<%=i%>"><input type="hidden" value="<%=aveGoal %>" name="score" class="form-control"></div>
										<%} else if(a.getAppraisal_criteria_manager_id() == 2){
											obtain = (aveWork * a.getWeightage()) / 5;
										%>
										<div id="ave<%=i%>"><%=aveWork %></div>
										<div id="avef<%=i%>"><input type="hidden" value="<%=aveWork %>" name="score" class="form-control"></div>
										<%} %>
										</td>
										<td><%=a.getWeightage()%> %</td>
										<td><%total1 = total1 + obtain ;%><%=obtain%> %	</td>
									</tr>
									</tbody>
									<%} %>
									</tbody>
									<tbody>
									<tr>
										<td><b>TOTAL</b></td>	
										<td>
										<div id="ave">
										<!-- <input type="button" value="EDIT" onclick="hide()" class="btn btn-default"> -->
										</div>
										
										<div id="avef">
										<!-- <input type="submit" value="SUBMIT" class="btn btn-default"> -->
										</div>
										</td>
										<td><b>100 %</b></td>
										<td><b><%=total1%> %</b></td>
									</tr>
									</tbody>
									
									<%}else{
										double totalPer = 0;%>
									<%for(AppraisalUpdateManagerScoreBean a : listUpdatedScore){
									%>
									<tbody>
									<tr>
										<td>
										<%=a.getAppraisalCriteriaManagerBean().getAppraisal_criteria_name()%></td>	
										<td><%=a.getScore() %></td>
										<td><%=a.getAppraisalCriteriaManagerBean().getWeightage()%> %</td>
										<td><% double per = (a.getScore() * a.getAppraisalCriteriaManagerBean().getWeightage()) / 5;
											totalPer = totalPer + per;
										%>
										<%=per%> %</td>
									</tr>
									</tbody>
									<%} %>
									<tbody>
									<tr>
										<td><b>TOTAL</b></td>
										<td></td>
										<td>100 %</td>
										<td><%=totalPer%> %</td>
										
									</tr>
									</tbody>
									<%} %>
									
								</table>
								<input type="hidden" name="redirect">
									</form>	
										      </div>
										      </div>
                                        </div>
                                    </div>
                                </div>
                               <div class="break">
                               </div>
                                   <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Appraisal Section:1</a>
                                        </h4>
                                    </div>
                                    <%List<AppraisalWhiteSection1Bean> listOfAppraisal = allListDAO.getappraisalSection1(appraisal_id);
                                    for(AppraisalWhiteSection1Bean appraisalWhiteSection1Bean : listOfAppraisal){
                                    %>
                                    
                                    <div id="collapseTwo" class="panel-collapse collapse in">
                                        <div class="panel-body">
									<div class="panel-body">
									<div class="panel panel-default">
								<div class="panel-body">
                                       <div class="tooltip-demo">
										<label>
											Describe your key roles & responsibility in the organization
										</label>
									</div>
									<textarea class="form-control" name="roles" disabled="disabled"><%=appraisalWhiteSection1Bean.getRoles_Responsibility()%></textarea>
									<br>
									<div class="tooltip-demo">
										<label>
											List out your major contributions / achievements this year (Other than goals/objectives)
										</label>
									</div>
									<textarea class="form-control" name="contributions" disabled="disabled"><%=appraisalWhiteSection1Bean.getContribution_achievememt()%></textarea>
									<br>
									<div class="tooltip-demo">
										<label>
											What are the obstacles you have found in your growth?
										</label>
									</div>
									<textarea class="form-control" name="obstacles" disabled="disabled"><%=appraisalWhiteSection1Bean.getObstacles()%></textarea>
									<br>
									<div class="tooltip-demo">
										<label>
											Identify opportunities for development, which could benefit you in current or future assignments. Development activities may include strength you wish to enhance, new area for you, or areas which need improvement.
										</label>
									</div>
									<textarea class="form-control" name="opportunities" disabled="disabled"><%=appraisalWhiteSection1Bean.getOpportunities()%></textarea>
                                      <br>
                                        <%} %>
										<br>
									
										</div>
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <center>Goals</center>
                                        </h4>
                                    </div>
													<table class="table table-bordered">
													<thead>	
														<tr>
														<th></th>
														<th colspan="3"><h5><center><b>To be competed by Employee / Appraisee</b></center></h5></th>
														<th colspan="3"><h5><center><b>To be competed by HOD / Appraiser</b></center></h5></th>
														</tr>
													</thead>
													<tbody>
													<tr>
														<th width="1%"></th>
														<th width="15%"><center>Goals</center></th>
														<th width="15%"><center>Result</center></th>
														<th width="15%"><center>Employee's/Appraisee's Comments</center></th>
														<th width="15%"><center>Weightage</center></th>
														<th width="15%"><center>Appraiser Comment</center></th>
														<th width="15%"><center>Appraiser Rating <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
													</tr>
													
													<%for(int i = 0;i<listOfGrade.size();i++){
														AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean = listOfGrade.get(i);
													%>
													<tr>
														<td><%=i+1%></td>
														<td><%=appraisalWhiteCollarGradeBean.getGoals()%></td>
														<td><%=appraisalWhiteCollarGradeBean.getResult()%></td>
														<td><%=appraisalWhiteCollarGradeBean.getEmployee_comment()%></td>
														<td><%=appraisalWhiteCollarGradeBean.getWeightage()%></td>
														<td><%=appraisalWhiteCollarGradeBean.getAppraiser_comment()%></td>
														<td><%=appraisalWhiteCollarGradeBean.getAppraisalGradeBean().getAppraisal_grade_name()%></td>
													</tr>
													<%} %>
													
													</tbody>	
											</table>
											</div>
                                        
                                        </div>
                                    </div>
                                </div>
                               
                               </div>
                    <div class="break">
                    </div>
                  <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Appraisal Section:2</a>
                                        </h4>
                                    </div>
                                        <div id="collapseThree" class="panel-collapse collapse in">
									
								<div class="panel-body">
                                        <%List<AppraisalWhiteCollarSection2Bean> listOfSection2 = allListDAO.getappraisalSection2(appraisal_id);
                                    for(AppraisalWhiteCollarSection2Bean appraisalWhiteCollarSection2Bean : listOfSection2){
                                    	
                                    %>
                                        <div class="tooltip-demo">
										<label>
											Review employee's input on "Roles and Responsibilities" and make any needed comments on additions, deletions, or changes.
										</label>
									</div>
									<textarea class="form-control" name="Roles" disabled="disabled"><%=appraisalWhiteCollarSection2Bean.getRoles_and_responsibilities() %></textarea>
									<br>
									<div class="tooltip-demo">
										<label>
											Review employee's input on "Major Accomplishments" and makes any needed comments on additions, deletions, or changes.
										</label>
									</div>
									<textarea class="form-control" name="Accomplishments" disabled="disabled"><%=appraisalWhiteCollarSection2Bean.getMajor_accomplishments()%></textarea>
									<br>
									<div class="tooltip-demo">
										<label>
											Review employee's input on "Opportunities for Development" and makes any needed comments on additions, deletions, or changes.
										</label>
									</div>
									<textarea class="form-control" name="Opportunities" disabled="disabled"><%=appraisalWhiteCollarSection2Bean.getOpportunities_for_development()%></textarea>
									<br>
									<div class="tooltip-demo">
										<label>
											Identify next potential job/assignment, if appropriate, and timing. Discuss your view of employee's potential and career path.
										</label>
									</div>
									<textarea class="form-control" name="job/assignment" disabled="disabled"><%=appraisalWhiteCollarSection2Bean.getJob_assignment()%></textarea>
									<br>
									<%} %>
									<br>
										<div class="table-responsive">
													<table class="table table-bordered">
													<thead>	
														<tr>
														<th colspan="2"><h5><center><b>Work Behaviors</b></center></h5></th>
														<th><h5><center><b>Rating(1 to 5)</b></center></h5></th>
														</tr>
													</thead>
													<tbody>
													
													<%
														for(int i=0 ; i<listOfWorkGrade.size(); i++){
															WorkGradeBean workGradeBean =  listOfWorkGrade.get(i);
													%>
													<tr>
														<td width="5%"><font size="3"><center><%=i+1%></center></font></td>
														<td><b><font size="3"><%=workGradeBean.getWorkBehaviourBean().getWork_behaviors_name()%></font></b><br>
														<font size="2"><%=workGradeBean.getWorkBehaviourBean().getWork_behaviors_desc()%></font><br>
														</td>
														<td width="15%"><%=workGradeBean.getAppraisalGradeBean().getAppraisal_grade_name()%></td>
													</tr>
													<%} %>
													</tbody>	
											</table>
											</div>
							
							   <div class="panel-group" id="accordion">
								<div class="panel panel-default">
							<div class="panel-heading">
										<h4 class="panel-title">
											<center>Attendance Detail</center>
										</h4>
									</div>		
							<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Working Days</center></th>
									<th><center>Leave</center></th>
									<th><center>Late Coming</center></th>
									<th><center>Ratings <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
									</tr>
									</thead>
									
									<%
									for(AppraisalLeaveBean appraisalLeaveBean : listOfLeave){
									%>
									<tbody>
									<tr>
									<td><center>299</center></td>
									<td><center><%=5%></center></td>
									<td><center><%=appraisalLeaveBean.getLate_coming()%></center></td>
									<td><center><%=appraisalLeaveBean.getAppraisalGradeBean().getAppraisal_grade_name() %></center></td>
									</tr>
									</tbody>
									<%} %>
									</table>
									</div>
									</div>
                                       
                             <div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<center>Kaizen(Targeted Kaizen Minimum 6)</center>
										</h4>
									</div>
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Total Kaizen Submitted</center></th>
									<th><center>Approved</center></th>
									<th><center>Remarks</center></th>
									<th><center>Ratings <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
									</tr>
									</thead>
									
									<%
									for(AppraisalKizenBean appraisalKizenBean : listOfKaizen){
									%>
									<tbody>
									<tr>
									<td><center><%=appraisalKizenBean.getKizen() %></center></td>
									<td><center><%=appraisalKizenBean.getKizen_approve() %></center></td>
									<td><center><%=appraisalKizenBean.getRemarks()%></center></td>
									<td><center><%=appraisalKizenBean.getAppraisalGradeBean().getAppraisal_grade_name()%></center></td>									
									</tr>
									</tbody>
									<%} %>
									</table>
									
								</div>
							</div>
                                       
                                       
                                       							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<center>5S Score card(Targeted Score Minimum %)</center>
										</h4>
									</div>
									
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Months</center></th>
									<th><center>Score</center></th>
									<th><center>Remarks</center></th>
									<th><center>Ratings <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
									</tr>
									</thead>
									
									
									<%
									for(Appraisal5sBean appraisal5sBean : listOf5s){
									%>
									<tbody>
									<tr>
									<td><center><%=appraisal5sBean.getQuterlyMonthBean().getQuarterly_month_name() %></center></td>
									<td><center><%=appraisal5sBean.getScore() %></center></td>
									<td><center><%=appraisal5sBean.getRemarks()%></center></td>
									<td><center><%=appraisal5sBean.getAppraisalGradeBean().getAppraisal_grade_name()%></center></td>
									</tr>
									</tbody>
									<%} %>
									</table>
									
								</div>
							</div>
                                       
                                       
                            <div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<center>Details Of Training Imparted</center>
										</h4>
									</div>
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
									int total = 0;
									for(AppraisalTrainingBean appraisalTrainingBean : listOfTraining){
										total = total + appraisalTrainingBean.getHrs();
										
										String date = appraisalTrainingBean.getDate();
										String sd = null;
										try {
											  
											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
											Date result = formater.parse(date);
											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
											sd = AppDateFormat.format(result);
											System.out.println(AppDateFormat.format(result));
											
											
											
										} catch (ParseException e1) {
											e1.printStackTrace();
										}
									%>
									<tr>
									<td><center><%=appraisalTrainingBean.getTopic()%></center></td>
									<td><center><%=appraisalTrainingBean.getFaculty()%></center></td>
									<td><center><%=sd%></center></td>
									<td><center><%=appraisalTrainingBean.getHrs()%></center></td>
									<td><center><%=appraisalTrainingBean.getRemarks()%></center></td>									
									</tr>
									<%}%>
									<tr>
									<td colspan="3" align="right">Total</td>
									<td><%=total%></td>
									<td></td>
									</tr>
									</tbody>
									</table>
								</div>
							</div>
											
											
									
                                        
                                        </div>
                                    </div>
                                </div>
                               
                               <div class="break">
                               </div>
                               
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive">Appraisal Section:3</a>
                                        </h4>
                                    </div>
                                    <div id="collapseFive" class="panel-collapse collapse in">
                                        <div class="panel-body">
									<div class="panel-body">
									
									<div class="panel panel-default">
								<div class="panel-body">
								
                                        <% for(AppraisalBean a : appraisalBean){%>
									<!-- /.panel-body -->
										<div class="tooltip-demo">
                                            <label>Employee's Comments</label>
                                            </div>
                                            <textarea class="form-control" name="employeeComments" id="employeeComments" value="" placeholder="max 500 words" readonly="readonly"><%=a.getEmp_comment()%></textarea>
                                       	<br>
                                        <div class="tooltip-demo">
                                            <label>Appraiser's Comments</label>
                                   			 
                                            </div>
											<textarea class="form-control" name="appraiserComments" id="appraiserComments" value="" placeholder="max 500 words" readonly="readonly"><%=a.getAppraiser_commnet()%></textarea>                                           
                                           <br> 
										<div class="tooltip-demo">
                                            <label>Reviewing's Comments</label>
                                   			<textarea class="form-control" name="reviewingComments" id="reviewingComments" value="" placeholder="max 500 words" readonly="readonly"><%=a.getReviewing_comment()%></textarea>
                                            </div>
                                        <br>
                                        <br>
						
							<%} %>
									</div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
									<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Ratings</h4>
                                        </div>
										
										<div class="panel-body">
										<table class="table table-bordered">
										
											<tr>
												<td>Description</td>
												<td>Rating </td>
											</tr>
											<tr>
												<td>Unsatisfactory / Needs Improvement</td>
												<td>1</td>
											</tr>
											<tr>
												<td>Meet some but not All Expectations</td>
												<td>2</td>
											</tr>
											<tr>
												<td>Fully Achieves Expectations</td>
												<td>3</td>
											</tr>
											<tr>
												<td>Exceeds Expectations</td>
												<td>4</td>
											</tr>
											<tr>
												<td>Excellent</td>
												<td>5</td>
											</tr>
										
										</table>
										</div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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
<script type="text/javascript">
window.onload = function print(){
	window.print();
	window.location.replace("whiteCollarFinalView.jsp?appraisal_id="+<%= appraisal_id %>);
}
</script>

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