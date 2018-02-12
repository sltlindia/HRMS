<!DOCTYPE html>
<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.pms.bean.QuterlyMonthBean"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.timesheet.bean.ProjectAllocationBean"%>
<%@page import="com.hrms.pms.bean.SpecificCriteriaAllocationBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.hrms.pms.bean.ReviewBean"%>
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
<%@page import="java.util.List"%>
<html lang="en">
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

window.onload = function auto(){
	
	document.getElementById("year22").disabled = true;
	$("#year22").hide();
	document.getElementById("year33").disabled = true;
	$("#year33").hide();
}

function monthDisabled(value) {
	if(value == "monthly"){
		document.getElementById("month").disabled = false;
		document.getElementById("year22").disabled = true;
		document.getElementById("year11").disabled = false;
		document.getElementById("year33").disabled = true;
		$("#year22").hide();
		$("#year33").hide();
		$("#year11").show();
		$("#month").show();
		
	}else if(value == "yearly"){
		document.getElementById("month").disabled = true;
		document.getElementById("year11").disabled = true;
		document.getElementById("year22").disabled = false;
		document.getElementById("year33").disabled = true;
		$("#year33").hide();
		$("#year11").hide();
		$("#year22").show();
		$("#month").hide();
	}else if(value == "quarterly"){
		document.getElementById("month").disabled = true;
		document.getElementById("year11").disabled = false;
		document.getElementById("year33").disabled = false;
		document.getElementById("year22").disabled = true;
		$("#year33").show();
		$("#year11").show();
		$("#year22").hide();
		$("#month").hide();
	}
}
</script>
</head>
<%@include file="header.jsp"%>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
int employee_master_id1 = 0;
if(request.getParameter("employee_id") != null){
employee_master_id = Integer.parseInt(request.getParameter("employee_id"));
}else{
	employee_master_id = (int) request.getAttribute("employee_id");
}

int month;
int year1;
GregorianCalendar date1 = new GregorianCalendar();      
month = date1.get(Calendar.MONTH);
year1 = date1.get(Calendar.YEAR);
month = month+1;
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
			<%if(request.getAttribute("yearExist") !=null || request.getAttribute("monthExist") != null || request.getAttribute("quarterExist") != null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-danger ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${yearExist}${monthExist}${quarterExist}
                            </div>
          		</div>  
          		<%} %>
			<!-- /.row -->
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Appraisal</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
		<!-- 	<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Appraisal</div> -->
						<div class="panel-body">
						<h4><font color="red">${duplicate}</font></h4>
				<form action="appraisalInsert" method="get">
							<div class="panel-group" id="accordion">
							<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Basics Information</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
								<!-- <div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne">Basics Information</a>
										</h4>
									</div> -->
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<%LoginDAO loginDAO = new LoginDAO();
											EmployeeBean employeeBean = loginDAO.getInfoById(employee_master_id);
											%>
												<div class="table-responsive">
													<table class="table table-striped">
														<tbody>
															<tr>
																<th>Employee Name</th>
																<td>:</td>
																<td><%=employeeBean.getFirstname()+" "+employeeBean.getMiddlename()+" "+employeeBean.getLastname()%>	
															</tr>
														</tbody>

														<input type="hidden" name="employee_master_id" class="form-control"
																	value="<%=employeeBean.getEmployee_master_id()%>">
														<tbody>
															<tr>
																<th>Employee Code</th>
																<td>:</td>
																<td><%=employeeBean.getEmployee_code()%></td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th>Designation</th>
																<td>:</td>
																<td><%=employeeBean.getRoleBean().getRole_type()%></td>
															</tr>
														</tbody>
														
														<tbody>
															<tr>
																<th>Department</th>
																<td>:</td>
																<td><%=employeeBean.getDepartmentBean().getDepartment_name()%></td>
															</tr>
														</tbody>
														<tbody>
															<tr>
																<th>Date Of Joining</th>
																<td>:</td>
																<%
																String joiningDate = employeeBean.getJoining_date();
																String d = null;
																				
										   										try {
										  											  
										   											SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
										    										Date result = formater.parse(joiningDate);
										   											SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
										    										d = AppDateFormat.format(result);
										   											System.out.println(AppDateFormat.format(result));
										   											
										   											
										   											
										   										} catch (ParseException e1) {
										   											e1.printStackTrace();
										   										}	
										   									 %>
																<td><%=d%></td>
															</tr>
														</tbody>
														
														<tbody>
															<tr>
																<th>Month</th>
																<td>:</td>
																<td><input type="radio" name="rdbMonth"
											value="monthly" checked="checked" onclick="monthDisabled(this.value)">&nbsp; Monthly
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="rdbMonth"
											value="yearly" onclick="monthDisabled(this.value)">&nbsp; Yearly
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="rdbMonth"
											value="quarterly" onclick="monthDisabled(this.value)">&nbsp; Quarterly &nbsp;<br>
											<br>
											<select class="form-control" name="month_id" id="month" required="required">
																		<option value="">---Select Month---</option>
																		<%
                                          
											AllListDAO monthList = new AllListDAO();
                                         	 List<MonthBean> listOfMonth = monthList.getListOfMonth();
                 						 	for (MonthBean m : listOfMonth){
                 						 		if(m.getMonth_id() !=0 && m.getMonth_id() <13){
                                          
                                          %>
																		<option value="<%=m.getMonth_id()%>"><%=m.getMonth_name()%></option>
																		<%} }%>
																</select>
																
																<select class="form-control" name="q_id" id="year33" required="required">
																		<option value="">---Select Quarter---</option>
																		<%
																		List<QuterlyMonthBean> listOfQuterlyMonth = monthList.getQuterlyMonth();
																		for(QuterlyMonthBean q : listOfQuterlyMonth){
                                          									if(q.getQuarterly_month_id() != 5){
                                          %>
																		<option value="<%=q.getQuarterly_month_id()%>"><%=q.getMonth_duration()%></option>
																		<%}} %>
																</select>
																
																</td>
															</tr>
															<input type="hidden" name="month_id" value="13">
															<input type="hidden" name="q_id" value="5">
														</tbody>

														
															<tr>
																<th>Year</th>
																<td>:<w/td>
																<td>
																<select class="form-control" name="year_id" id="year11" required="required">
																		<option value="">---Select Year---</option>
																		<%
																		AllListDAO yearList  = new AllListDAO();
                                          List<YearBean> listOfYear = yearList.getListOfYear();
                 						 	for (YearBean y : listOfYear){
                 						 		if(Integer.parseInt(y.getYear()) <= year1){
                                          
                                          %>
																		<option value="<%=y.getYear_id()%>"><%=y.getYear() %></option>
																		<%} }%>
																</select>
																
																<select class="form-control" name="year_id" id="year22" required="required">
																		<option value="">---Select Year---</option>
																		<%
                 						 	for (YearBean y : listOfYear){
                 						 		int year = Integer.parseInt(y.getYear())+1;
                                          
                                          %>
																		<option value="<%=y.getYear_id()%>"><%=y.getYear()%> - <%=year%></option>
																		<%} %>
																</select>
																</td>
															</tr>
													</table>
													
												</div>
										</div>

									</div>
								</div>
							</div>
							<br>
								<center>
									<input type="submit" value="Continue" class="btn btn-primary"></a>
									<input type="reset" value="Cancel" class="btn btn-danger">
								</center>
							
				</form>
</div>

					</div>
					<div class="row">
				    <div class="col-md-12">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic" style="color: #000000;">Employee History</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B;">
					<!-- <div class="panel-group" id="accordion">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne">Employee History</a>
										</h4>
									</div> -->
					
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Employee Name</th>
                                            <th>Role</th>
                                            <th>Month</th>
                                            <th>Year</th>
                                            <th>Submission Date</th>
                                            <th>Action</th>
                                            
                                        </tr>
                                    </thead>
                                      <tbody>
                                   <%
																		AllListDAO allListDAO  = new AllListDAO();
                                        	  List<AppraisalBean> listOfAppraisal = allListDAO.getappraisalByEmployeeId(employee_master_id);
                                        	  for(AppraisalBean a : listOfAppraisal){
                                        		  
                                        		  String date = a.getDate_of_submission();
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
                                  
                                        <tr class="odd gradeX">
                                        <td><%=a.getEmployeeBean().getFirstname()+" "+a.getEmployeeBean().getLastname()%></td>
                                        <td><%=a.getEmployeeBean().getRoleBean().getRole_type()%></td>
                                        <td>
                                        	<%if(a.getQuterlyMonthBean().getQuarterly_month_id() != 5){%>
                                         <%=a.getQuterlyMonthBean().getMonth_duration()%>
                                        <%}else{ %>
                                        <%=a.getMonthBean().getMonth_name()%>
                                        <%}%>
                                        </td>
                                        <td>
                                        <%if(a.getMonthBean().getMonth_id() == 13 && a.getQuterlyMonthBean().getQuarterly_month_id() == 5) {
                                        int year = Integer.parseInt(a.getYearBean().getYear()) + 1;
                                        %>
                                        <%=a.getYearBean().getYear()%> - <%=year%>
                                        <%} else{%>
                                        <%=a.getYearBean().getYear()%>
                                        <%} %></td>
                                        <td><%=sd%></td>
                                        <td><a href="blueCollarFinalView.jsp?appraisal_id=<%=a.getAppraisal_id()%>"><i class="icon-eye4" data-toggle="tooltip" data-placement="top" title="Show Appraisal History"></i></a>&nbsp;&nbsp;&nbsp;<a href="appraisalBluecollarCheck?appraisal_id=<%=a.getAppraisal_id()%>&employee_master_id=<%=a.getEmployeeBean().getEmployee_master_id()%>&month_id=<%=a.getMonthBean().getMonth_id()%>&year_id=<%=a.getYearBean().getYear_id()%>&q_id=<%=a.getQuterlyMonthBean().getQuarterly_month_id()%>"><i class="icon-edit2" data-toggle="tooltip" data-placement="top" title="Edit Appraisal"></i></a></td>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>
                                </div>
                                </div>
                                </div>
                                <br>
                                  <h5><b>Legends :&nbsp;</b></h5>&nbsp;&nbsp;&nbsp;<i class="icon-edit2" style="color:#337ab7;"></i><b> : Edit Appraisal </b> &nbsp;&nbsp;&nbsp;<i class="icon-eye4" style="color:#337ab7;"></i><b> : View Appraisal </b>                            </div>
                                       
                            </div>
                            </div></div></div>
                                        </div>
								</div>
								</div></div></div>
								</section>
								</div></div>
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
