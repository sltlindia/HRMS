<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.pms.bean.GoalEmployeeAllocationBean"%>
<%@page import="com.hrms.pms.bean.SubGoalAllocationBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.GoalAllocationBean"%>
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
<%@include file="header.jsp"%>
<script type="text/javascript">
function checkInteger(id) {
	
	var a = document.getElementById(id).value;
	
	if(isNaN(a)){
		alert("not valid");
		document.getElementById(id).value = 0;
	}
}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int employee_id = user.getEmployee_master_id();
int year_id = Integer.parseInt(request.getParameter("year_id"));
AllListDAO allListDAO = new AllListDAO();
int appraisal_id = (int) request.getAttribute("appraisal_id");
List<AppraisalBean> appraisalBean = allListDAO.getappraisal(appraisal_id);
%>
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
				<br>
					<center><h3><%
                                        for(AppraisalBean a : appraisalBean){
                                        	if(a.getQuterlyMonthBean().getQuarterly_month_id() != 5){%>
                                        	Appraisal of <%=a.getQuterlyMonthBean().getMonth_duration()%>,<%=a.getYearBean().getYear()%>
                                        	<%}else if(a.getMonthBean().getMonth_id() == 13){
                                        		int year =Integer.parseInt(a.getYearBean().getYear()) + 1;
                                        %>
                                        Goals of year <%=a.getYearBean().getYear()%> - <%=year%>
                                        <%}else{ %>
                           Goals of <%=a.getMonthBean().getMonth_name()%>,<%=a.getYearBean().getYear()%>
                           <%} }%></h3>
					<h4>(The sum of the weightage should be 100%)</h4></center>
			
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<h4><font color="red">${duplicate}</font></h4>
				<form action="whiteCollarSection11Insert" method="post" enctype="multipart/form-data">
				<input type="hidden" name="appraisal_id" value="<%=request.getAttribute("appraisal_id")%>">
							<div class="card">
				<div class="card-header">
				<div class="card-body collapse in">
				<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; ">
										<div class="panel-body"	>
												<div class="table-responsive" >
												<div class="card box-shadow-0" data-appear="appear" style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
													<table class="table table-bordered">
													<thead style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">	
														<tr>
														<th  style="border-bottom: 1px solid #607D8B;"><b><center>Allocated Goal</b></center></th>
														<th  style="border-bottom: 1px solid #607D8B;" colspan="3"><h5><center><b>To be competed by Employee / Appraisee</b></center></h5></th>
														<!-- <th colspan="3"><h5><center><b>To be competed by HOD / Appraiser</b></center></h5></th> -->
														</tr>
													</thead>
													<tbody>
													<tr>
														<th width="15%"><center>Goals</center></th>
														<th width="15%"><center>Result</center></th>
														<th width="15%"><center>Employee's/Appraisee's Comments</center></th>
														<!-- <th width="15%"><center>Weightage</center></th>
														<th width="15%"><center>Appraiser's Comments</center></th>
														<th width="15%"><center>Appraiser's Ratings</center></th> -->
													</tr>
													
													
													
													<%List<GoalAllocationBean> listOfGoal = allListDAO.getListOfAllocatedEmployeeIdYearId(employee_id,year_id);
													if(listOfGoal.size() !=0){
							for(GoalAllocationBean g : listOfGoal){%>

													<tr>
														<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value="<%=g.getYearlyGoalBean().getGoalDefinitionBean().getGoal_definition_name()%>" readonly="readonly"></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" required="required" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
													</tr>
													
													<%}%>
							<tr>
							<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
							<td><input type="text" name="result" class="form-control" id="result" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
							<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
						</tr>
												<%	} else{%>
												
												<%List<GoalEmployeeAllocationBean> listOfSubGoal = allListDAO.getListOfEmployeeAllocatedEmployeeIdYearId(employee_id, year_id);
							for(GoalEmployeeAllocationBean g : listOfSubGoal){%>

													<tr>
														<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value="<%=g.getSubGoalAllocationBean().getGoalAllocationBean().getYearlyGoalBean().getGoalDefinitionBean().getGoal_definition_name()%>" readonly="readonly"></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" required="required" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
													</tr>
													<%} %>
												
														<tr>
														<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
														</tr>
														<tr>
														<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
													</tr>
														<tr>
														<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
													</tr>
														<tr>
														<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
													</tr>
														<tr>
														<td><input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment"></td>
													</tr>
													<%}
													%>
													
													
													
													</tbody>	
											</table>
											</div>
											</div>
											</div>
											<input type="hidden" name="redirect">
											<center><input type="submit" class="btn btn-primary" name="submit" value="Next"></center>
											<br>
											<h5><b style="color: red">&nbsp;&nbsp;&nbsp;&nbsp; Note :&nbsp;</b>Comment is optional.It is not mendetory to fill the comment.</b> </h5>
											</div>
											</div>
											</div>
											</div>
											</div>
											
				</div>
				</form>


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
											