<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.bean.QuterlyMonthBean"%>
<%@page import="com.hrms.pms.bean.GradeMasterBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.AppraisalGradeBean"%>
<%@page import="java.util.List"%>
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
    <title>Appraisal Section :1</title>
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
    var datefield=document.createElement("input")
    datefield.setAttribute("type", "date")
    if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
    }
</script>


<script type="text/javascript">

if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
    	
        $('#date1').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#date2').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#date3').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#date4').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#date5').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}


function validate(value) {
	var a = document.getElementById(value).value;
	var b = document.getElementById("totalKaizen").value;
	
	var c = parseInt(a);
	var d = parseInt(b);
	if(c>d){
		alert("Approved Kaizen is not greate than total Kaizen")
		document.getElementById(value).value = "";
	}
}


function checkInteger(id) {
	
	
	var a = document.getElementById(id).value;
	
	if(isNaN(a)){
		alert("character not allowed");
		document.getElementById(id).value = 0;
	}
	
}

</script>
<%@include file="header.jsp"%>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%AllListDAO  allListDAO = new AllListDAO();
int month_id =(int)request.getAttribute("month_id");
int q_id =(int)request.getAttribute("q_id");
int id = 0;
if(month_id == 13){
	id = 6;
}
if(month_id == 4 || month_id == 5 || month_id == 6 || q_id == 1){
	id = 1;
	}
if(month_id == 7 || month_id == 8 || month_id == 9 || q_id == 2){
	id = 2;
}
if(month_id == 10 || month_id == 11 || month_id == 12 || q_id == 3){
	id = 3;
}
if(month_id == 1 || month_id == 2 || month_id == 3 || q_id == 4){
	id = 4;
}
int appraisal_id =(Integer) request.getAttribute("appraisal_id");
List<AppraisalBean> appraisalBean = allListDAO.getappraisal(appraisal_id);

int employeemasterID = (Integer)(request.getAttribute("employee_id"));
String unplanstartDate = "2016-12-01";
String unplanendDate = "2017-12-01";

AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
List<LeaveBean> listOfLeave = allLMSListDAO.getUnplanListPerMonth(unplanstartDate, unplanendDate, employeemasterID);

double TOTALLEAVEDAY = 0;
for(LeaveBean leaveBean2 : listOfLeave)
{
	int LeaveID  = leaveBean2.getLeave_id();	
	List<LeavecutBalance> listOfUnplanLeave = allLMSListDAO.getListOfCutLeave(LeaveID);
	for(LeavecutBalance lll : listOfUnplanLeave)
	{
		/* double leave = lll.getSL();
		double pl =  lll.getCO() + lll.getMain_PL() + lll.getSL() + lll.getLWP();
		
		System.out.println("leave" + leave);	
		unplanLeave = unplanLeave + leave;
		planLeave = planLeave + lll.getPL();
		PLAN = PLAN + lll.getPL();
		UNPLAN = UNPLAN + lll.getSL(); */
		
		
	}
	TOTALLEAVEDAY = TOTALLEAVEDAY + leaveBean2.getDay_count();
}


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
			<!-- /.row -->
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">
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
                           <%} }%></h4>
                        </div>
                        </div>
                        <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<div class="panel-body">
				<form action="appraisalSection1Insert" method="post" enctype="multipart/form-data">
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>Attendance Detail</center></a>
										</h4>
									</div>
									<input type="hidden" name="appraisal_id" value="<%=request.getAttribute("appraisal_id")%>">
									<div class="panel-body">
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Working Days</center></th>
									<th><center>Leave</center></th>
									<th><center>Late Coming</center></th>
									<th><center>Ratings <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
									</tr>
									</thead>
							
									<tbody>
									<tr>
									<td><center>299</center></td>
									<td><input type="text" name="leave" id="name" value="<%= TOTALLEAVEDAY %>" class="form-control" onchange="checkInteger(this.id)" readonly="readonly"></td>
									<td><input type="text" name="lateComing" id="lateComing" value="0" class="form-control" onchange="checkInteger(this.id)"></td>
									<td><select class="form-control" name="attendanceGrade" id="attendanceGrade" required="required">
																<option value="">---- Select Rating ----</option>
										<%List<AppraisalGradeBean> listOfAppraisalGrade = allListDAO.getAppraisalGrade();
										for(AppraisalGradeBean g : listOfAppraisalGrade){
											if(g.getAppraisal_grade_id()!=0){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%} }%>
														</select></td>									
									</tr>
									
									</tbody>
									
									</table>
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
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>             
									
								</div>
							</div>
							<br>
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>Kaizen(Targeted Kaizen Minimum 6)</center></a>
										</h4>
									</div>
									<div class="panel-body">
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Total Kaizen Submitted</center></th>
									<th><center>Approved</center></th>
									<th><center>Remarks</center></th>
									<th><center>Ratings <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
									</tr>
									</thead>
									
									<tbody>
									
									<tr>
									<td><input type="text" name="totalKaizen" id="totalKaizen" value="0" class="form-control" onchange="checkInteger(this.id)"></td>
									<td><input type="text" name="approvedKaizen" id="approvedKaizen" value="0" class="form-control" onchange="validate(this.id);checkInteger(this.id)"></td>
									<td><input type="text" name="remarkKizen" value="" class="form-control"></td>
									<td><select class="form-control" name="kaizenGrade" id="kaizenGrade" required="required">
																<option value="">---- Select Rating ----</option>
										<%
										for(AppraisalGradeBean g : listOfAppraisalGrade){
											if(g.getAppraisal_grade_id()!=0){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%}}%>
														</select></td>									
									</tr>
									
									</tbody>
									
									</table>
									</div>
								</div>
							</div>
							<br>
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>5S Score card(Targeted Score Minimum %)</center></a>
										</h4>
									</div>
									
									<div class="panel-body">
									<table class="table table-bordered">
									<thead>
									<tr>
									<th><center>Months</center></th>
									<th><center>Score</center></th>
									<th><center>Remarks</center></th>
									<th><center>Ratings <a href="" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a></center></th>
									</tr>
									</thead>
									
									
									
									<%List<QuterlyMonthBean> listOfQuterlyMonth = allListDAO.getQuterlyMonth();
									for(QuterlyMonthBean q : listOfQuterlyMonth){
										if(q.getQuarterly_month_id() != 5){
										if(id == q.getQuarterly_month_id()){
									%>
									<tbody>
									<tr>
									<td><input type="hidden" name="qid" value="<%=q.getQuarterly_month_id()%>"><%=q.getQuarterly_month_name()%> (<%=q.getMonth_duration()%>)</td>
									<td><input type="text" name="qScore" value="0" id=qscore<%=q.getQuarterly_month_id()%>" class="form-control"  onchange="checkInteger(this.id)"></td>
									<td><input type="text" name="qRemarks" value="" class="form-control"></td>
									<td><select class="form-control" name="qGrade" id="5sGrade" required="required">
																<option value="">---- Select Rating ----</option>
										<%
										for(AppraisalGradeBean g : listOfAppraisalGrade){
											if(g.getAppraisal_grade_id()!=0){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%} }%>
														</select></td>
									</tr>
									</tbody>
									<%}else if(id == 6){%>
									<tbody>
									<tr>
									<td><input type="hidden" name="qid" value="<%=q.getQuarterly_month_id()%>"><%=q.getQuarterly_month_name()%> (<%=q.getMonth_duration()%>)</td>
									<td><input type="text" name="qScore" id="qscore<%=q.getQuarterly_month_id()%>" value="0" class="form-control" onchange="checkInteger(this.id)"></td>
									<td><input type="text" name="qRemarks" value="" class="form-control"></td>
									<td><select class="form-control" name="qGrade" id="5sGrade" required="required">
																<option value="">---- Select Rating ----</option>
										<%
										for(AppraisalGradeBean g : listOfAppraisalGrade){
											if(g.getAppraisal_grade_id()!=0){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%} }%>
														</select></td>
									</tr>
									</tbody>
									<%}%>
									<%} }%>
									</table>
									</div>
								</div>
							</div>
							<br>
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
								<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; outline-width: 2px">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><center>Details Of Training Imparted</center></a>
										</h4>
									</div>
									<div class="panel-body">
									
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
									<%for(int i = 0; i<5; i++){ %>
									<tr>
									<td><input type="text" name="tTopic" value="" class="form-control"></td>
									<td><input type="text" name="tFaculty" value="" class="form-control"></td>
									<td><input type="date" name="tDate" id="date<%=i+1%>" value="" placeholder="yyyy-mm-dd" class="form-control"></td>
									<td><input type="text" name="tHrs" value="0" id="thurs<%=i%>" class="form-control" onchange="checkInteger(this.id)"></td>
									<td><input type="text" name="tTrainingRemark" value="" class="form-control"></td>									
									</tr>
									<%} %>
									</tbody>
									</table>
									</div>
									
									<input type="hidden" name="redirect">
									<center><input type="submit" class="btn btn-primary" name="submit" value="NEXT"></center>
									<br>
								</div>
							</div>
							</div>
							</div>
							</div>
							</div>
				</form>
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
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

  
</body>

</html>