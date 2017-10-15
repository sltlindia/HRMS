<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
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
    <!-- END Custom CSS-->
    <title>All Leave / CO / OD</title>
  </head>
  <body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

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
        $('#fromDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#toDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        
    })
}
</script>
<%@include file="header.jsp" %>

</head>

<body>
<% 
String hrapproval = "leave";
System.out.println("HR Approval:");
if(request.getAttribute("hrApproval") != null)
{
	hrapproval = (String) request.getAttribute("hrApproval");
	System.out.println("HR Approval:"+ hrapproval);
}else if(request.getParameter("hrApproval") != null){
	hrapproval = request.getParameter("hrApproval");
}
%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Approved Leave / CO / OD List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			<%if(request.getAttribute("success") !=null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-success ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${success}
                                 </div>
                                 </div>
                                 <%} %>
                                 
                                 <%if(request.getAttribute("error") !=null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-danger">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${error}
                                 </div>
                                 </div>
                                 <%} %>
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           Approved Leave / CO / OD
                        </div>
                       	<%String fromDate = null;
                       	String toDate = null;
                        String parseFromDate = null;
                        String parseToDate = null;
                        String status = "pending";
                        
                        if(request.getParameter("fromDate") != null && !request.getParameter("fromDate").equalsIgnoreCase("")){
                       	 fromDate = request.getParameter("fromDate");
                       	toDate = request.getParameter("toDate");
                       	 
                         DateFormat dateFormatForselection  = new SimpleDateFormat("yyyy-MM-dd");
                         DateFormat dateFormat1ForSelection = new SimpleDateFormat("dd/MM/yyyy");
                       	 Date date = dateFormatForselection.parse(fromDate);
                    	 Date date1 = dateFormatForselection.parse(toDate);
                    	 parseFromDate = dateFormat1ForSelection.format(date);
                    	 parseToDate = dateFormat1ForSelection.format(date1);
                    	 
                        } 
                        
                        if(request.getParameter("status") != null){
                        	status = request.getParameter("status");
                        }
                        %>
                        
                          <div class="panel-body">
                          <form action="approvedLeaveHrSide.jsp">
                          
									<%if(request.getParameter("fromDate") != null){ %>
								<div class="row">
									<div class="col-md-2">
										<b>Enter Date :</b>
									</div>
									<div class="col-md-3">
									<input type="date" class="form-control" name="fromDate" id="fromDate"
											value="<%=fromDate%>"
											style="width: 200px">
											</div>
											
											<div class="col-md-1">	
											To
											</div>
											
									<div class="col-md-3">		
									<input type="date" class="form-control" name="toDate" id="toDate"
											value="<%=toDate%>"
											style="width: 200px" >
											</div>
											
											</div>
									<%}else{ %>
									<div class="row">
									<div class="col-md-2">
										<b>Enter Date :</b>
									</div>
									<div class="col-md-3">
									<input type="date" class="form-control" name="fromDate" id="fromDate"
											value=""
											style="width: 200px" >
											</div>
											
											<div class="col-md-1">	
											To
											</div>
											
									<div class="col-md-3">		
									<input type="date" class="form-control" name="toDate" id="toDate"
											value=""
											style="width: 200px" >
											</div>
											</div>
									<%} %>
										<br>
									<div class="row">
									<div class="col-md-2">
										<b>Select option:</b>
									</div>
									
									<div class="col-md-8">
									
										<%if(status.equalsIgnoreCase("pending")){%><input type="radio" name="status" value="pending" checked="checked"><%}else{%><input type="radio" name="status" value="pending"><%}%> Pending
										<%if(status.equalsIgnoreCase("approved")){%><input type="radio" name="status" value="approved" checked="checked"><%}else{%><input type="radio" name="status" value="approved" ><%}%> Approved
										<%if(status.equalsIgnoreCase("rejected")){%><input type="radio" name="status" value="rejected" checked="checked"><%}else{%><input type="radio" name="status" value="rejected" ><%}%> Rejected
									</div>
									
									</div>	
									<input type="submit" class="btn btn-primary" name="submit"
												value="SUBMIT">
							
							</form>
							<hr>
                          
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                            <%AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
                            List<LeaveBean> listOfEmployee = null;
                            List<LeaveCOBean> co = null;
                            List<LeaveODBean> d = null;
                            
                            
                             listOfEmployee = allLMSListDAO.getListOfApprovedEmployeeLeave(fromDate,toDate,status);
                             co = allLMSListDAO.getApprovedCO(parseFromDate,parseToDate,status);
                             d = allLMSListDAO.getApprovedOD(parseFromDate,parseToDate,status);
                             
                            %>
                            	<% if(hrapproval.equalsIgnoreCase("leave"))
                            		{%>
                                <li class="active">
                                <%}
                                else{
                                %>
                                <li>
                                <%} %>
                                <a href="#home" data-toggle="tab">Leave (<%=listOfEmployee.size() %>)</a>
                                </li>
                                
                                <% if(hrapproval.equalsIgnoreCase("co"))
                            		{%>
                                <li class="active">
                                <%}
                                else{
                                %>
                                <li>
                                <%} %><a href="#profile" data-toggle="tab">CO (<%=co.size() %>)</a>
                                </li>
                                
                               <% if(hrapproval.equalsIgnoreCase("od"))
                            		{%>
                                <li class="active">
                                <%}
                                else{
                                %>
                                <li>
                                <%} %><a href="#messages" data-toggle="tab">OD (<%=d.size() %>)</a>
                                </li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                            <% if(hrapproval.equalsIgnoreCase("leave"))
                            		{%>
                              <div class="tab-pane fade in active" id="home">
                                <%}
                                else{
                                %>
                                <div class="tab-pane fade" id="home">
                                <%} %>
                                
                                    <h4>Approved Leave</h4>
                                                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                             <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover file-export">
                                    <thead>
                                        <tr>
                                        	<th>Company Name</th>
                                        	<th>Emp Code</th>
                                            <th>Employee Name</th>
                                            <th>From Date</th>
                                            <th>To Date</th>
                                            <th>Day Count</th>
                                            <th>Status</th>
                                            <th>submission Date</th>
                                            <th>Reporting Manager</th>
                                        </tr>
                                      </thead>  
                                       <tbody>
                                        <%
                                        for(LeaveBean l : listOfEmployee){
                                        	String leave_to = l.getLeave_To();
                                        	String  leave_from = l.getLeave_From();
                                        	String submission_date = l.getSubmission_date();
                                        	String lf = null;
                                        	String lt = null;
                                        	String sd = null;
                                                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                                    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                    Date date = dateFormat.parse(leave_to);
                                                    Date date1 = dateFormat.parse(leave_from);
                                                    Date date2 = formater.parse(submission_date);
                                                    DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                                                    SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
                                                    lt = dateFormat1.format(date);
                                                    lf = dateFormat1.format(date1);
                                                    sd = formater1.format(date2);
                                                    
                                        %>
                                    
                                     	<tr>
                                     	
                                     		<td><%=l.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
                                     		<td><%=l.getEmployeeBean().getEmployee_code()%></td>
                                     		<td><%=l.getEmployeeBean().getFirstname()+" "+l.getEmployeeBean().getMiddlename() + " "+l.getEmployeeBean().getLastname() %></td>
                                     		<td><%=lf%></td>
                                     		<td><%=lt %></td>
                                     		<td><%=l.getDay_count()%></td>
                                     		<td><%=l.getStatus()%></td>
                                     		<td><%=sd%></td>
                                     		<%
                                     			LoginDAO loginDAO = new LoginDAO();
                                     		int manager_id = l.getUnder_manager_id();
                                     			EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
                                     		%>
                                     		<td><%=employeeBean.getFirstname() +" "+employeeBean.getLastname()%></td>
                                     		
                                     		
                                     	</tr>
                                    
                                    <%} %>
                                    </tbody>
                                </table>
                                 <h5><b>Legends :&nbsp;</b></h5><i class="glyphicon glyphicon-ok" style="color:#337ab7;"></i><b> : Leave Approval </b>
                            </div>
									</div>
                                        </div>
                                    
                                </div>
                                 <% if(hrapproval.equalsIgnoreCase("co"))
                            		{%>
                              <div class="tab-pane fade in active" id="profile">
                                <%}
                                else{
                                %>
                                <div class="tab-pane fade" id="profile">
                                <%} %>
                                
                                    <h4>Approved CO</h4>
									 							<div class="panel-body">
								<div class="dataTable_wrapper">
								 <div class="table-responsive">
									<table class="table table-striped table-bordered table-hover file-export">
										<thead>
											<tr><th style="text-align:center">Company Name</th>
												<th style="text-align:center">Emp Code</th>
												<th style="text-align:center">Name</th>
												<th style="text-align:center">Date</th>
												<th style="text-align:center">Start Time </th>
												<th style="text-align:center">End Time </th>
												<th style="text-align:center">Total Hours </th>
												<th style="text-align:center">Total CO Added </th>
												<th style="text-align:center">Manager Name </th>
											</tr>
										</thead>
										<tbody>
										<%
										for(LeaveCOBean c : co)
										{
											
											String _24HourStartTime = c.getStart_time();
											String _24HourEndTime = c.getEnd_time();
										%>
										
										<tr>
											<td><%=c.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
											<td><%=c.getEmployeeBean().getEmployee_code() %></td>
											<td><%=c.getEmployeeBean().getFirstname()+" "+c.getEmployeeBean().getMiddlename()  + " " +c.getEmployeeBean().getLastname()%></td>
											<td>
													<%= c.getCO_date() %>
											</td>
											<td>
													<%= c.getStart_time()%>
											</td>
											<td>
													<%=c.getEnd_time() %>
   						 					</td>	
   						 					<td>
   						 							<%= c.getTotal_Hours() %>
   						 					</td>
   						 					<td>
   						 						<% if(c.getTotal_Hours() >= 4) 
   						 							{%>
   						 							 <font color="Red"> 1.0 </font>
   						 							<% }
   						 								else if(c.getTotal_Hours()  >= 2 && c.getTotal_Hours() <= 4)
   						 								{%>
   						 								 <font color="Red"> 0.5 </font>
   						 								<%}
   						 									else if(c.getTotal_Hours() <= 2)
   						 									{%>
   						 									<font color="Red"> 0.0 </font>
   						 									<%} %>
   						 					</td>
   						 					<%
                                     			LoginDAO loginDAO = new LoginDAO();
                                     		int manager_id = Integer.parseInt(c.getEmployeeBean().getUnder_manager_id());
                                     			EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
                                     		%>
                                     		<td><%=employeeBean.getFirstname() +" "+employeeBean.getLastname()%></td>
										</tr>
										<%} %>
										</tbody>
								 		</table>
										</div>
										 <h5><b>Legends :&nbsp;</b></h5> <i class="glyphicon glyphicon-ok" style="color:#337ab7;"></i><b> : CO Approval </b>                      
										</div>
										</div>	
									                                    
                                </div>
                                <% if(hrapproval.equalsIgnoreCase("od"))
                            		{%>
                              <div class="tab-pane fade in active" id="messages">
                                <%}
                                else{
                                %>
                                <div class="tab-pane fade" id="messages">
                                <%} %>
                                
                               
                              <h4>Approved OD</h4>
                               <div class="panel-body">
								<div class="dataTable_wrapper">
								 <div class="table-responsive">
									<table class="table table-striped table-bordered table-hover file-export">
										<thead>
											<tr>
												<th style="text-align:center">Company Name</th>
												<th style="text-align:center">Emp Code</th>
												<th style="text-align:center">Name</th>
												<th style="text-align:center">From Date</th>
												<th style="text-align:center">To Date </th>
												<th style="text-align:center">Start Time </th>
												<th style="text-align:center">End Time </th>
												<th style="text-align:center">Total Day </th>
												<th style="text-align:center">Manager Name </th>
												
											</tr>
										</thead>
										<tbody>
										<%
										for(LeaveODBean od : d)
										{
											
											String _24HourStartTime = od.getOD_StartTime();
											String _24HourEndTime = od.getOD_EndTime();
											
									
										%>
										<tr>
											<td><%=od.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
											<td><%=od.getEmployeeBean().getEmployee_code() %></td>
											<td><%=od.getEmployeeBean().getFirstname()+" "+od.getEmployeeBean().getMiddlename()  + " "+od.getEmployeeBean().getLastname() %></td>
											<td>
													<%= od.getOD_StartDate()  %>
											</td>
											<td>
													<%= od.getOD_EndDate() %>
											</td>
											<td>
													<% if(od.getOD_StartTime() == "")
														{%>
													-----
													<%
														}
													else
														{%>
														<%= od.getOD_StartTime() %>
														<%} %>
   						 					</td>	
											<td>
													<% if(od.getOD_EndTime() == ""){%>
													-----
													<%}else{%>
													<%= od.getOD_EndTime() %>
													<%} %>
   						 					</td>	
   						 					<td>
   						 							<%= od.getOD_TotalDay() %>
   						 					</td>
   						 					<%
                                     			LoginDAO loginDAO = new LoginDAO();
                                     		int manager_id = Integer.parseInt(od.getEmployeeBean().getUnder_manager_id());
                                     			EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
                                     		%>
                                     		<td><%=employeeBean.getFirstname() +" "+employeeBean.getLastname()%></td>
										</tr>
										<%} %>
										</tbody>
										</table>
										</div>
										<h5><b>Legends :&nbsp;</b></h5> <i class="glyphicon glyphicon-ok" style="color:#337ab7;"></i><b> : OD Approval </b> 
                                
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


  
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
      <!-- BEGIN PAGE VENDOR JS-->
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
    <!-- END PAGE LEVEL JS-->
</body>
</html>