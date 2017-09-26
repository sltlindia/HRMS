<%@page import="java.text.ParseException"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewManagerCommentsBean"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewEmployeeBean"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewScoreBean"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewFormAttributeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exit Interview Approval</title>
 <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/users.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
<%@include file="header.jsp" %>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%
int exit_interview_id = Integer.parseInt(request.getParameter("exit_employee_id"));
String emp_name = user.getFirstname()+" "+ user.getLastname();
int manager_id = user.getManagerBean().getManager_id();
int under_manager_id = Integer.parseInt(user.getUnder_manager_id());

%>


<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      <div class="content-body">
      				<section id="horizontal-form-layouts">
      					<div class="row"> 
							<div class="col-xs-12">
								<h4>Exit Interview Form</h4>
								<hr>
							</div>
						</div>
      					<div class="card">
	      					<div class="card-body collapse in">
			               		<div class="card-block">
									<div class="form-body">
			<div class="row">
			<div class="col-lg-12" align="right">
				<%
			
				AllListExitFormalityDAO allListExitFormalityDAO= new AllListExitFormalityDAO();
				List<ExitInterviewEmployeeBean> listOfExitEmployee = allListExitFormalityDAO.getListOfExitEmployee(exit_interview_id);	
				for(ExitInterviewEmployeeBean e : listOfExitEmployee){
				
					int company_id = e.getEmployeeBean().getCompanyListBean().getCompany_list_id();
					
					if (company_id == 1) {%>
					<img alt="logo"
					src="img/sltllogo.png" width="170px" height="70px">
				<%} else if (company_id == 2) {%>
					<img alt="logo"
					src="img/SS.png" width="170px" height="70px">
				<%} else if (company_id == 3) {%>
					<img alt="logo"
					src="img/S.HR.png" width="170px" height="70px">
				<%} else if (company_id == 4) {%>
					<img alt="logo"
					src="img/sltllogo.png" width="170px" height="70px">
				<%} else if (company_id == 5) {%>
					<img alt="logo"
					src="img/sltllogo.png" width="170px" height="70px">
				<%} else if (company_id == 6) {%>
					<img alt="logo"
					src="img/sltllogo.png" width="170px" height="70px">
				<%} else if (company_id == 7) {%>
					<img alt="logo"
					src="img/SE.png" width="170px" height="70px">
				<%} else if (company_id == 8) {%>
					<img alt="logo"
					src="img/sltllogo.png" width="170px" height="70px">
				<%}%>
			</div>
				<div class="col-lg-12">
					<h3 class="page-header" align="Center" style="margin-top: 0px;">Exit Interview Form<br>
										F-HRD-19</h3>
				</div>
			</div>
			
			
			
			<div class="panel panel-default">
				<div class="panel-body">
				
				
				
				<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-lg-6">
									<b>EXIT INTERVIEW FORM</b>
								</div>
								<div class="col-lg-6" align="right">
								<%
								if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){%>
									<a href="exitInterviewHRList.jsp">
								<%}else{%>
									<a href="exitInterviewManagerList.jsp">
								<%
								}
								%>
									<button class="btn btn-default btn-xs">
									<span class="fa fa-chevron-circle-left"></span>&nbsp;&nbsp;<b>Back</b></button></a>
									
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="row">
									<div class="col-md-2"><label>1) Name Of Employee:</label></div>
									<div class="col-md-4"><%=e.getEmployeeBean().getFirstname() +" "+ e.getEmployeeBean().getLastname() %></div>
									<div class="col-md-2"><label>4) Designation : </label></div> 
									<div class="col-md-4"><%=e.getDesignation() %></div>
								</div>
								<!-- /.row -->
								
								<%
								String jd = null;
								String td = null;
									
									String joiningDate = e.getDate_of_joining();
									String terminationDate = e.getTermination_date();
								
									try {
										  
										SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
									Date result = formater.parse(joiningDate);
										Date result1 = formater.parse(terminationDate);
										SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
									jd = AppDateFormat.format(result);
										td = AppDateFormat.format(result1);
										System.out.println(AppDateFormat.format(result));
										
										
										
									} catch (ParseException e1) {
										e1.printStackTrace();
									}	
								
								%>
								
								<div class="row">
									<div class="col-md-2"><label>2)Department : </label></div>
									<div class="col-md-4"><%=e.getDepartment() %></div>
									<div class="col-md-2"><label>5)Date Of  Joining : </label></div>
									<div class="col-md-4"><%=jd %></div>
								</div>
								<!-- /.row -->
								
								<div class="row">
								
								<%
								int managerId = Integer.parseInt(e.getReporting_manager());
								LoginDAO loginDAO = new LoginDAO();
								EmployeeBean employeeBean = loginDAO.getEmailId(managerId);
								%>
									<div class="col-md-2"><label>3)Reports To : </label></div>
									<div class="col-md-4"><%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%></div>
									<div class="col-md-2"><label>6)Termination Date : </label></div>
									<div class="col-md-4"><%=td %></div>
								</div>
								<!-- /.row --> 
								<input type="hidden" name="terminate">
							</div>
							<!-- /.panel-body -->
				</div>
				<!-- /.panel-default -->
			
				<div class="panel panel-default">
							<div class="panel-body">
							
								<div class="row">
									<div class="col-md-12">
										<b>Score the attributes below with a response which comes closest to how you feel or act</b>
									</div>
								</div>
								<!-- /.row -->
								<br>
 								<div class="row">
 									<div class="col-md-1" style="width : 10px;"></div>
									<div class="col-md-3">
										<b>1. Always / Absolutely</b>
									</div>
									<div class="col-md-3">
										<b>2. Most often / To a great extent</b>
									</div>	
									<div class="col-md-3">
										<b>3. Sometimes / Fairly</b>
									</div>	
								</div>
								<!-- /.row -->
								
								<div class="row">
									<div class="col-md-1" style="width : 10px;"></div>
									<div class="col-md-3">
										<b>4. Rarely / Somewhat</b>
									</div>
									<div class="col-md-3">
										<b>5. Never / Not at all</b>
									</div>	
								</div>
								<!-- /.row -->
								
								
							</div>
							<!-- /.panel-body -->
				</div>
				<!-- /.panel-default -->
				
				<div class="dataTable_wrapper">
                              <div class="table-responsive">
                              
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                 	<tr>
                                    	<th>Sr No.</th>
                                    	<th>Attribute</th>
                                    	<th>Score</th>
                                    	<th>Comments</th>
									</tr>
									</thead>
									
									<tbody>
										<%
										AllListExitFormalityDAO allListDAO = new AllListExitFormalityDAO();
										List<ExitInterviewScoreBean> listOfAttributeScore = allListDAO.getListOfAttributeScore(exit_interview_id);
											for(int i=0;i<listOfAttributeScore.size();i++){
												ExitInterviewScoreBean eis = listOfAttributeScore.get(i);
										%>
										<tr>
											<td><%=i+1 %></td>
											<td><%=eis.getExit_interview_attribute()%></td>
											<td style="width: 190px;"><%=eis.getExit_interview_score() %></td>
											<td><%=eis.getExit_interview_comments() %></td>
										</tr>
										<input type="hidden" name="attributeInsert">
										<%} %>
										
										
									</tbody>
								</table>
								
								<p><b>(If you have any further comments/suggestions, you may enclose an additional sheet)</b></p>
								<p style="white-space: pre-wrap;"><i class="icon icon-android-arrow-dropright"></i><%=e.getAdditional_comment() %></p>
								<input type="hidden" name="temp">
								<br>
							
							
							<%if(request.getParameter("action") != null){ 
							
								ExitInterviewManagerCommentsBean exitInterviewManagerCommentsBean = allListExitFormalityDAO.getManagerCommentById(employee_master_id, exit_interview_id);
							
							%>
									
								<h4><u>Discussing Manager's Comments :</u> (<%=emp_name %>)</h4>
								<p>(Please remember the objective of the Exit Interview is to obtain feedback)</p>
									1. The main issue responsible for the individual's resignation is :
									<p style="white-space: pre-wrap;"><i class="icon icon-android-arrow-dropright"></i><%=exitInterviewManagerCommentsBean.getMain_issue() %></p>
									2. What are secondary issues which may have reinforced the individual's decision to leave?
									<p style="white-space: pre-wrap;"><i class="icon icon-android-arrow-dropright"></i><%=exitInterviewManagerCommentsBean.getSecondary_issue() %></p>
									3. What are the two key suggestions made by the individual which can actually change (for the better) the way we work?
									<p style="white-space: pre-wrap;"><i class="icon icon-android-arrow-dropright"></i><%=exitInterviewManagerCommentsBean.getKey_suggestions() %></p>
								</div>
							</div>
								
								
							<%}else{%>
							
								<form action="exitInterviewManagerCommentsInsert" method="post">
										<h4><u>Discussing Manager's Comments :</u> (<%=emp_name %>)</h4>
										<p>(Please remember the objective of the Exit Interview is to obtain feedback)</p>
											1. The main issue responsible for the individual's resignation is :
											<textarea rows="" cols="" class="form-control" name="mainIssue"></textarea>
											(only one issue please)
											<br>
											<br>
											2. What are secondary issues which may have reinforced the individual's decision to leave?
											<textarea rows="" cols="" class="form-control" name="secondaryIssue"></textarea>
											<br>
											3. What are the two key suggestions made by the individual which can actually change (for the better) the way we work?
											<textarea rows="" cols="" class="form-control" name="keySuggestions"></textarea>
										
											<br>
											<center><input type="submit" class="btn btn-primary" id="subm"  name="submit" value="SUBMIT"></center>
										
										<input type="hidden" name="exit_interview_employee_id" value="<%=exit_interview_id%>">
										<br>
										</div>
									</div>
								</form>
							
							<%} %>
						<%} %>
					</div>
					
				</div>
				<br>
			
		</div>
</div>
</section>
</div>
</div>
</div>
<%@include file="footer.html"%>

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
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe-ui-default.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
	

</body>
</html>