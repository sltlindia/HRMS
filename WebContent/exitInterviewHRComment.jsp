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
<title>Insert title here</title>
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
									<textarea rows="" cols="" class="form-control" name="mainIssue" readonly="readonly"><%=exitInterviewManagerCommentsBean.getMain_issue() %></textarea>
									(only one issue please)
									<br>
									<br>
									2. What are secondary issues which may have reinforced the individual's decision to leave?
									<textarea rows="" cols="" class="form-control" name="secondaryIssue" readonly="readonly"><%=exitInterviewManagerCommentsBean.getSecondary_issue() %></textarea>
									<br>
									3. What are the two key suggestions made by the individual which can actually change (for the better) the way we work?
									<textarea rows="" cols="" class="form-control" name="keySuggestions" readonly="readonly"><%=exitInterviewManagerCommentsBean.getKey_suggestions() %></textarea>
								
									<br>
								
								
								<br>
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
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
       
    });
    </script>
	

</body>
</html>