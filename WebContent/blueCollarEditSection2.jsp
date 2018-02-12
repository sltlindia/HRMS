<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.pms.bean.AppraisalCriteriaGradeBean"%>
<%@page import="com.hrms.pms.bean.AppraisalCriteriaDescriptionBean"%>
<%@page import="com.hrms.pms.bean.AppraisalGradeBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.AppraisalCriteriaBean"%>
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
    <title>Appraisal Section :2</title>
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
<%int appraisal_id = (Integer)request.getAttribute("appraisal_id"); %>
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
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Appraisal Section:2</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<div class="panel-body">
				<form action="appraisalSection2Edit" method="post" enctype="multipart/form-data">
				<input type="hidden" name="appraisal_id" value="<%=request.getAttribute("appraisal_id")%>">
				
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									
									<div class="panel-body">
									<table class="table table-bordered">
									<thead>
													<tr>
														<th><center>Factors</center></th>
														<th colspan="2"><center>Ratings</center></th>
														<th><center>Remarks</center></th>
														<th><center>Weightage</center></th>
													</tr>
												</thead>

									
									
									<% AllListDAO allListDAO = new AllListDAO();
									List<AppraisalCriteriaGradeBean> listAppraisalCriteriaGrade = allListDAO.getappraisalGradeCriteria(appraisal_id);
									for(AppraisalCriteriaGradeBean a : listAppraisalCriteriaGrade){
									%>
									<input type="hidden" name="ag_id" value="<%=a.getAppraisal_criteria_grade_id()%>">
									<tbody>
									<tr>
										<td><input type="hidden" name="appraisal_criteria_id" value="<%=a.getAppraisalCriteriaBean().getAppraisal_criteria_id()%>"><%=a.getAppraisalCriteriaBean().getAppraisal_criteria_name()%></td>	
										<td>
										<select class="form-control" name="gradeId" requierd="required">
										<option value="">---- Select Rating ----</option>
										<%List<AppraisalGradeBean> listOfAppraisalGrade = allListDAO.getAppraisalGrade();
										for(AppraisalGradeBean g : listOfAppraisalGrade){
										if(a.getAppraisalGradeBean().getAppraisal_grade_id() == g.getAppraisal_grade_id()){
										%>
										<option value="<%=g.getAppraisal_grade_id()%>" selected="selected"><%=g.getAppraisal_grade_name()%></option>
										<%}else{ %>
										<option value="<%=g.getAppraisal_grade_id()%>"><%=g.getAppraisal_grade_name()%></option>
										<%} }%>
										</select>
										</td>
										<td>
										<a href="" data-toggle="modal" data-target="#myModal<%=a.getAppraisalCriteriaBean().getAppraisal_criteria_id()%>"><i class="glyphicon glyphicon-info-sign"  data-toggle="tooltip" data-placement="top" title="Description"></i></a>
										</td>
										<td><textarea class="form-control" name="remarks"><%=a.getRemarks()%></textarea></td>
										<td><%=a.getAppraisalCriteriaBean().getWeightage()%> %</td>
									</tr>
									</tbody>
									
									 <div class="modal fade" id="myModal<%=a.getAppraisalCriteriaBean().getAppraisal_criteria_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel"><%=a.getAppraisalCriteriaBean().getAppraisal_criteria_name() %></h4>
                                        </div>
										<%
										int id = a.getAppraisalCriteriaBean().getAppraisal_criteria_id();
										List<AppraisalCriteriaDescriptionBean> listOfDesc =  allListDAO.getCriteriaDescription(id);
										for(AppraisalCriteriaDescriptionBean bean : listOfDesc){
										%>
										
										<div class="panel-body">
										<b><%=bean.getAppraisalGradeBean().getAppraisal_grade_name()%></b><br>
										<%=bean.getAppraisal_criteria_description()%><br>
										</div>
										<%} %>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>             
									
									<%}%>
									
									</table>
									</div>
									  <% 
									  List<AppraisalBean> appraisalBean = allListDAO.getappraisal(appraisal_id);
									  for(AppraisalBean a : appraisalBean){%>
									  <input type="hidden" name="a_id" value="<%=a.getAppraisal_id()%>">
									<div class="panel-body">
									<!-- /.panel-body -->
										<div class="tooltip-demo">
                                            <label>Achievements</label>
                                   			 <i class="fa fa-question-circle" data-toggle="tooltip" data-placement="top" title="List out major contributions / achievements"></i>
                                            </div>
                                            <textarea class="form-control" name="achivements" id="achivements" value="" placeholder="max 500 words"><%=a.getAchievement()%></textarea>
                                        <br>
                                        <div class="tooltip-demo">
                                            <label>Area of improvement</label>
                                   			 <i class="fa fa-question-circle" data-toggle="tooltip" data-placement="top" title="List down what employee should do to improve performance in job knowledge, technical skills, work habits, communication and other qualities affecting the job? Also mention the plan of action"></i>
                                            </div>
                                            <textarea class="form-control" name="improvement" id="improvement" value="" placeholder="max 500 words"><%=a.getArea_of_improvement()%></textarea>
										<br>
										<div class="tooltip-demo">
                                            <label>Employee's Comments</label>
                                            </div>
                                            <textarea class="form-control" name="employeeComments" id="employeeComments" value="" placeholder="max 500 words"><%=a.getEmp_comment()%></textarea>
                                       	<br>
                                        <div class="tooltip-demo">
                                            <label>Appraiser's Comments</label>
                                   			 
                                            </div>
											<textarea class="form-control" name="appraiserComments" id="appraiserComments" value="" placeholder="max 500 words"><%=a.getAppraiser_commnet()%></textarea>                                           
                                           <br> 
										<div class="tooltip-demo">
                                            <label>Reviewing's Comments</label>
                                   			<textarea class="form-control" name="reviewingComments" id="reviewingComments" value="" placeholder="max 500 words"><%=a.getReviewing_comment()%></textarea>
                                            </div>
                                             <%} %>   
                                        <br>
                                        <br>
                                    <center>
									<!-- <a href="" onclick="validation()"> --><input type="submit" value="FINISH" class="btn btn-primary"></a>
									<input type="reset" value="RESET" class="btn btn-danger">
								</center>
                                 </div>  
							</form>
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