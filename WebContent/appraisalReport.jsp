 <%@page import="com.hrms.pms.bean.QuterlyMonthBean"%>
<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.pms.bean.TaskMasterBean"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.util.stream.IntStream"%>
<%@page import="java.time.Month"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.Collection"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
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
    <title>Track History Report</title>
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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
     <script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript">

function getRequest(project_master_id){
    //  stateId='';
		/* alert(project_master_id); */
		dwr.util.removeAllOptions(taskName);
		document.getElementById('imgLoader').style.visibility = 'hidden';
		if(project_master_id==''){
			var data=[{ task_master_name:'-- Select --', task_master_id:'' }];
			dwr.util.addOptions("taskName",data,"task_master_id","task_master_name");
		document.getElementById('imgLoader').style.visibility = 'hidden';
		}else{
			/* alert(project_master_id); */
	  	  document.getElementById('imgLoader').style.visibility = 'visible';
	  	  
			AjaxDataDAO.getAllTask(project_master_id,function(data){
				
			dwr.util.addOptions(taskName,data,"task_master_id","task_master_name");
	   document.getElementById('imgLoader').style.visibility = 'hidden';
			});
		}
}  


</script>
<script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "date")
if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
    document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
}
</script>

<script>
if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
        $('#startDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#endDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}

function listOfDefaulter() {
	alert("ripal");
	var startDate = document.getElementById('startDate').value;
	var endDate  = document.getElementById('endDate').value;
	window.location.replace("defaulterReportDateWise?startDate="+startDate+"&endDate="+endDate);
} 
</script>
<script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "date")
if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
    document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
}
</script>

<script>
if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    jQuery(function($){ //on document.ready
        $('#plannedStartDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#plannedEndDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}
function hide(){
        $("#sub").hide();
        $("#print").hide();
        window.print();
        $("#sub").show();
        $("#print").show();
}
</script>
<%@include file="header.jsp"%>
</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
AllListDAO allListDAO = new AllListDAO();
int role_id = user.getRoleBean().getRole_id();
int manager_id = user.getManagerBean().getManager_id();
List<String> array = new ArrayList<String>();

double aveQ1 = 0;
double aveQ2 = 0;
double aveQ3 = 0;
double aveQ4 = 0;
%>
<% 
int year_id = 0;
int employee_id = 0;

if(request.getParameter("year_id") != null){
year_id = Integer.parseInt(request.getParameter("year_id"));
employee_id = Integer.parseInt(request.getParameter("employee_id"));
}
%>

<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-lg-12">
				
					<%if(request.getParameter("taskId")!=null){%>
					<center><h1 class="page-header"><img alt="logo" src="img/sltllogo.png" height="75px" width="125px"></h1></center>
				<%}else{ %>
				<h1 class="page-header">Reports</h1>
				
					<%} %>
				</div>
						
				</div>
			
			<!-- /.row -->
<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">
				               		<h4 class="card-title" id="horz-layout-basic">Appraisal Report</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
				<!-- <div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">Appraisal Report</div>
							
							/.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
								<form action = "appraisalReport" method="post">
								<div class="table-responsive">
										<table class="table">
										
										<tr>
										<th>Select Report type</th>
										<td>:</td>
										<td>
										<%
										if(request.getParameter("rdbMonth") != null){
										if(request.getParameter("rdbMonth").equalsIgnoreCase("Monthly")){%>
										<input type="radio" name="rdbMonth"
											value="monthly" checked="checked">&nbsp; Monthly
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="radio" name="rdbMonth"
											value="quarterly">&nbsp; Quarterly &nbsp;<br>
											<%}else if(request.getParameter("rdbMonth").equalsIgnoreCase("Quarterly")){ %>
											<input type="radio" name="rdbMonth"
											value="monthly">&nbsp; Monthly
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="radio" name="rdbMonth"
											value="quarterly" checked="checked">&nbsp; Quarterly &nbsp;<br>
											<%} } else{%>
											
											<input type="radio" name="rdbMonth"
											value="monthly" checked="checked">&nbsp; Monthly
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="radio" name="rdbMonth"
											value="quarterly">&nbsp; Quarterly &nbsp;<br>
											
											<%} %>
											
											</td>
										</tr>
										
										<tr><th>Select Year</th>
										<td>:</td>
										<td><select class="form-control" name="year_id" id="year11" required="required">
																		<option value="">---Select Year---</option>
																		<%
																		AllListDAO yearList  = new AllListDAO();
                                          List<YearBean> listOfYear = yearList.getListOfYear();
                 						 	for (YearBean y : listOfYear){
                 						 		if(year_id == y.getYear_id()){
                                          %>
																		<option value="<%=y.getYear_id()%>" selected="selected"><%=y.getYear() %></option>
																		<%}else{%>
																		<option value="<%=y.getYear_id()%>"><%=y.getYear() %></option>
																		<%} %>
																		<%}%>
																</select>
										</td>
										</tr>
										
										
										
										<%if(role_id == 1 || role_id == 2 || role_id == 3 || role_id == 12) {%>
															
															
															<tr>	
															<th><label>Employee Name</label></th>
															<td>:</td>
															<td colspan=4"><select class="form-control" name="employee_id"
															id="employee_id" >
														<option value="0">---Select Employee Name---</option>
														 <%
																		AllListDAO employeeList  = new AllListDAO();
                                        	  List<EmployeeBean> listOfEmployee = employeeList.underHrList();
                 						 	for (EmployeeBean e : listOfEmployee){
                 						 		 if(request.getParameter("year_id") != null){
                                               	  if(employee_id == e.getEmployee_master_id()){
                                                 %>
                                                 	 <option value="<%=e.getEmployee_master_id()%>" selected="selected"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
										<%} %>	 
														</select>
														</td>
														</tr>
															
															
															<%} else{%>
															<tr>	
															<th><label>Employee Name</label></th>
															<td>:</td>
															<td colspan=4"><select class="form-control" name="employee_id"
															id="employee_id" >
														<option value="0">---Select Employee Name---</option>
														 <%
																		AllListDAO employeeList  = new AllListDAO();
                                        	  List<EmployeeBean> listOfEmployee = employeeList.getListOfEmployee(manager_id);
                 						 	for (EmployeeBean e : listOfEmployee){
                 						 		int managerId = e.getManagerBean().getManager_id();
                                          
                 						 		 if(request.getAttribute("employee_id")!=null){
                                               	  int id =(Integer) request.getAttribute("employee_id");
                                               	  if(id == e.getEmployee_master_id()){
                                                 %>
                                                 	 <option value="<%=e.getEmployee_master_id()%>" selected="selected"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
                                                 	 <%}else{ %>
                                                 	  <option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname()+" "+e.getLastname() %></option>
                                                 	 <%} %>
                                          <%List<EmployeeBean> listOfEmployee1 = employeeList.getListOfEmployee(managerId); 
                                          for (EmployeeBean e1 : listOfEmployee1){
                                          if(request.getParameter("year_id") != null){
                                        	  if(employee_id == e1.getEmployee_master_id()){
                                          %>
                                          	 <option value="<%=e1.getEmployee_master_id()%>" selected="selected"><%=e1.getFirstname()+" "+e1.getLastname() %></option>
                                          	 <%}else{ %>
                                          	  <option value="<%=e1.getEmployee_master_id()%>"><%=e1.getFirstname()+" "+e1.getLastname() %></option>
                                          	 <%} %>
                                          	 <%}else{ %>
                                          	  <option value="<%=e1.getEmployee_master_id()%>"><%=e1.getFirstname()+" "+e1.getLastname() %></option>
                                          	 <%} %>
										<%} }%>	 
														</select>
														</td>
														</tr>
														<%} %>
										
											
										</table>
										</div>
										<div id="sub">
										<center><input type="submit" class="btn btn-primary" name="submit" value="SUBMIT"></center>
										</div>
										</form>
										</div>
										</div>
										<div class="panel-body">
								<div class="dataTable_wrapper">
								<div class="table-responsive">
								<%if(request.getAttribute("listOfAppraisal") != null){ %>
										<table class="table table-striped table-bordered table-hover">
										<thead>
										<tr>	<th>Month</th>
										<%if(request.getParameter("rdbMonth").equalsIgnoreCase("monthly")){%>
												<th>Submission Date</th>
												<%} %>
												<th>Appraisal Percentage</th>
											</tr>
										</thead>
										
										
											<%
												if(request.getParameter("rdbMonth").equalsIgnoreCase("monthly")){
													double totalPer = 0;
													int totalsize = 0;
											List<AppraisalBean> listOfAppraisal =(ArrayList)request.getAttribute("listOfAppraisal");
												for(AppraisalBean a : listOfAppraisal){
													
													String date = a.getDate_of_submission();
													String d = null;
													
													totalPer = totalPer + a.getPer();
													totalsize++;
													
													try {
														SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
														Date result = formater.parse(date);
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
														d = AppDateFormat.format(result);
														System.out.println(AppDateFormat.format(result));
													} catch (ParseException e1) {
														e1.printStackTrace();
													} 
											%>	
											<tbody>	
											<tr>
												<td><%=a.getMonthBean().getMonth_name()%></td>
												<td><%=d%></td>
												<td><%=a.getPer()%> %</td>
												<%String merge = a.getMonthBean().getMonth_name() +","+a.getPer();
												array.add(merge);
												%>
											</tr>
										</tbody>
										<%}%>
										<tr>
											<td>Average</td>
											<td></td>
											<td><b>Average : <%=totalPer/totalsize%> %</b></td>
											</tr>	
										<%}else{
											
											List<AppraisalBean> listOfAppraisal =(ArrayList)request.getAttribute("listOfAppraisal");
												
										double q1 = 0;
										double q2 = 0;
										double q3 = 0;
										double q4 = 0;
										
										int totalSizeQ1 = 0;
										int totalSizeQ4 = 0;
										int totalSizeQ3 = 0;
										int totalSizeQ2 = 0;
										
										
										
										for(AppraisalBean a : listOfAppraisal){
													int month_id =a.getMonthBean().getMonth_id();
													if(month_id == 4 || month_id == 5 || month_id == 6){
														double per = a.getPer();
														q1 = q1 + per; 
														totalSizeQ1++;
													}
													
													if(month_id == 7 || month_id == 8 || month_id == 9){
														double per = a.getPer();
														q2 = q2 + per; 
														totalSizeQ2++;
													}
													
													if(month_id == 10 || month_id == 11 || month_id == 12){
														double per = a.getPer();
														q3 = q3 + per; 
														totalSizeQ3++;
													}
													
													if(month_id == 1 || month_id == 2 || month_id == 3){
														double per = a.getPer();
														q4 = q4 + per; 
														totalSizeQ4++;
													}
													
													if(q1!=0){
													 aveQ1 = q1/totalSizeQ1;
													}
													if(q2!=0){
													 aveQ2 = q2/totalSizeQ2;
													}
													if(q3!=0){
													 aveQ3 = q3/totalSizeQ3;
													}
													if(q4!=0){
													 aveQ4 = q4/totalSizeQ4;
													}
												} 
											
											
											%>	
											<%List<QuterlyMonthBean> listOfQuterlyMonth = allListDAO.getQuterlyMonth();
									for(QuterlyMonthBean q : listOfQuterlyMonth){
										if(q.getQuarterly_month_id() != 5){
										int q_id = q.getQuarterly_month_id();
									%>
									<tbody>
									<tr>
									<td><%=q.getQuarterly_month_name() %></td>
									<td>
									<%if(q_id==1){%>
									<%=aveQ1%> %
									<%} %>
									
									<%if(q_id==2){%>
									<%=aveQ2%> %
									<%} %>
									
									<%if(q_id==3){%>
									<%=aveQ3%> %
									<%} %>
									
									<%if(q_id==4){%>
									<%=aveQ4%> %
									<%} %>
									</td>
									</tr>
									</tbody>
									<%} %>
										<%} }%>
									</table>
									<%} %>
									<!-- /.table -->
								</div>
								</div>
								<%if(request.getAttribute("listOfAppraisal") != null){%>
								<div id="chartContainer" style="height: 350px; width: 70%;"></div><!-- /.panel-body -->
								
								<div id="print">
								<input type="button" name="print" class="btn btn-default" value="PRINT" onclick="hide()">
								</div>
								<%} %>
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
<%if(request.getAttribute("listOfAppraisal") != null){
if(request.getParameter("rdbMonth").equalsIgnoreCase("monthly")){%>
<script type="text/javascript">
  FusionCharts.ready(function(){
    var revenueChart = new FusionCharts({
        "type": "column3d",
        "renderAt": "chartContainer",
        "width": "650",
        "height": "300",
        "dataFormat": "json",
        "dataSource":  {
          "chart": {
            "caption": "Monthly Appraisal Report",
            /* "subCaption": "Harry's SuperMart", */
            "xAxisName": "MONTH",
            "yAxisName": "PERCENTAGE (%)",
            "theme": "fint"
         },
         "data": [
                  <%for(int i=0;i<array.size();i++){
	String a =  array.get(i);
	 String[] ac = a.split(",");
	 double per =  Double.parseDouble(ac[1]);
		             String name = ac[0];
		             %>
            {
               "label": "<%=name%>",
               "value": <%=per%>
            },
            <%}%>
          ]
      }

  });
revenueChart.render();
})
</script>
<%}else{%>

<script type="text/javascript">
  FusionCharts.ready(function(){
    var revenueChart = new FusionCharts({
        "type": "column3d",
        "renderAt": "chartContainer",
        "width": "650",
        "height": "300",
        "dataFormat": "json",
        "dataSource":  {
          "chart": {
            "caption": "Quarterly Appraisal Report",
            /* "subCaption": "Harry's SuperMart", */
            "xAxisName": "QUARTER",
            "yAxisName": "PERCENTAGE (%)",
            "theme": "fint"
         },
         "data": [
            {
               "label": "Q1",
               "value": <%=aveQ1%>
            },
            
            {
                "label": "Q2",
                "value": <%=aveQ2%>
             },
             
             {
                 "label": "Q3",
                 "value": <%=aveQ3%>
              },
              
              {
                  "label": "Q4",
                  "value": <%=aveQ4%>
               },
           
          ]
      }

  });
revenueChart.render();
})
</script>
<%}}%>
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
	<script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.flash.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/jszip.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/pdfmake.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/vfs_fonts.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.html5.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.print.min.js" type="text/javascript"></script> 
    <!-- END PAGE VENDOR JS-->
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>


</body>

</html>
