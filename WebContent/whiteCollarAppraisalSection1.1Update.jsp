<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.pms.bean.AppraisalWhiteCollarGradeBean"%>
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
int appraisal_id = Integer.parseInt(request.getParameter("appraisal_id"));
AllListDAO allListDAO = new AllListDAO();
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
				<form action="whiteCollarSection11Update" method="post" enctype="multipart/form-data">
				<input type="hidden" name="appraisal_id" value="<%=request.getParameter("appraisal_id")%>">
				<div class="card-header">
				<div class="card-body collapse in">
				<div class="card-block" style= "outline-style:solid; outline-color: #607D8B; ">
							<div class="panel-group" id="accordion">
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body"	>
												<div class="table-responsive">
												<div class="card box-shadow-0" data-appear="appear"  style="border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;
					                					border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">
													<table class="table table-bordered">
													<thead style="background-color: #d2d9dc;padding: 0.5rem 0rem 1rem 0rem;height: 40px; border-left: 1px solid #607D8B;border-right: 1px solid #607D8B;  
					        						   border-bottom: 1px solid #607D8B; border-top: 1px solid #607D8B;">	
														<tr>
														<th style="border-bottom: 1px solid #607D8B;"><b><center>Allocated Goal</b></center></th>
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
													
													<%List<AppraisalWhiteCollarGradeBean> listOfGrade = allListDAO.getappraisalGrade(appraisal_id);
													int count = 0;
													%>
													<%for(int i = 0;i<listOfGrade.size();i++){
														count++;
														AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean = listOfGrade.get(i);
													%>
													<tr>
														<td>
														<input type="hidden" name="action" value="update">
														<input  type="hidden" name="whiteCollarGradeId" value="<%=appraisalWhiteCollarGradeBean.getAppraisal_white_grade_id()%>"> 
														<input type="text" class="form-control" name="goals" value="<%=appraisalWhiteCollarGradeBean.getGoals()%>"></td>
														<td><input type="text" class="form-control" name="result" id="result" value="<%=appraisalWhiteCollarGradeBean.getResult()%>" onchange="checkInteger(this.id)"></td>
														<td><input type="text" class="form-control" name="employee_cmt" value="<%=appraisalWhiteCollarGradeBean.getEmployee_comment()%>">
														
														</td>
													</tr>
													<%} %>
													<%for(int j=count;j<10;j++){ %>
													
													<tr>
														<td>
														<input type="hidden" name="action" value="insert">
														<input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment">
														</td>
													</tr>
													<%} %>
													<!-- <tr>
														<td>
														<input type="hidden" name="action" value="insert">
														<input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment">
														
														</td>
													</tr>
													<tr>
														<td>
														<input type="hidden" name="action" value="insert">
														<input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment">
														</td>
													</tr>
													<tr>
														<td>
														<input type="hidden" name="action" value="insert">
														<input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment">
														</td>
													</tr>
													<tr>
														<td>
														<input type="hidden" name="action" value="insert">
														<input type="text" name="goals" class="form-control" placeholder="Enter Goal" value=""></td>
														<td><input type="text" name="result" id="result" class="form-control" placeholder="Enter result" onchange="checkInteger(this.id)"></td>
														<td><input type="text" name="employee_cmt" class="form-control" placeholder="Enter Comment">
														</td>
													</tr> -->
													
													
													</tbody>	
											</table>
											</div>
											</div>
											<input type="hidden" name="redirect">
											<center><input type="submit" class="btn btn-primary" name="submit" value="Update"></center>
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
</section>
					</div>
				</div>
			</div>
<script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>


</body>

</html>
											