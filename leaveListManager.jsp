<%@page import="java.text.ParseException"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%

String status = "pending";
String s = status;

if(request.getParameter("Status") != null){
  	status = request.getParameter("Status");
  	session.setAttribute("Status", status);
}else if(session.getAttribute("Status") != null){
	 status = (String) session.getAttribute("Status");
}

if(status.equalsIgnoreCase("pending")){
s = "Pending";
}else if(status.equalsIgnoreCase("approved")){
s = "Approved";
}else if(status.equalsIgnoreCase("rejected")){
s = "Rejected";
}


%>
<title><%=s%> Leave / CO / OD</title>
<link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "text")
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
            dateFormat: 'dd-mm-yy'
        });
        $('#toDate').datepicker({
            dateFormat: 'dd-mm-yy'
        });
        
    })
}


function deleteLeave(id,status) {
	
	var retVal = confirm("Are you sure?");
	var fromDate = document.getElementById('fromDate').value;
	var toDate = document.getElementById('toDate').value;
	var companyId = document.getElementById('companyId').value;
	
	if( retVal == true )
		{
		window.location.replace("LeaveDelete?leave_id="+id+"&status="+status+"&action=hrSide&fromDate="+fromDate+"&toDate="+toDate+"&companyId="+companyId);
		}
			else
			{
				window.location.replace("pendingLeaveHrSide.jsp");
				return false;
	 		}
}

function changeHrApproval(id) {
	
	if(id==1){
		document.getElementById('hrApproval').value = "leave";
	}else if(id==2){
		document.getElementById('hrApproval').value = "co";
	}else if(id==3){
		document.getElementById('hrApproval').value = "od";
	}
	
}
</script>

<%@include file="header.jsp" %>
</head>
<body>
<% 
int managerId = user.getManagerBean().getManager_id();
String hrapproval = "leave";
System.out.println("HR Approval:");
if(request.getAttribute("hrApproval") != null)
{
	hrapproval = (String) request.getAttribute("hrApproval");
	System.out.println("HR Approval:"+ hrapproval);
}else if(request.getParameter("hrApproval") != null){
	hrapproval = request.getParameter("hrApproval");
}


Calendar now = Calendar.getInstance();  // Current Month, Year, Date

   System.out.println("Current Year is : " + now.get(Calendar.YEAR));
   // month start from 0 to 11
   System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
   System.out.println("Current Date is : " + now.get(Calendar.DATE));
   
   
  int  month_id = now.get(Calendar.MONTH) + 1;
  int year = now.get(Calendar.YEAR);
   
  String fromDate = null;
 	String toDate = null;
  
   if(month_id==1 || month_id==3 ||month_id==5 ||month_id==7 ||month_id==8){
	   fromDate = "01-0"+month_id+"-"+year;
	   toDate = "31-0"+month_id+"-"+year;
	   
	}else if(month_id==4 ||month_id==6 ||month_id==9){
		 fromDate = "01-0"+month_id+"-"+year;
		   toDate = "30-0"+month_id+"-"+year;
	}else if(month_id==10 || month_id==12){
		 fromDate = "01-"+month_id+"-"+year;
		   toDate = "31-"+month_id+"-"+year;
	}if(month_id == 11){
		 fromDate = "01-"+month_id+"-"+year;
		   toDate = "30-"+month_id+"-"+year;
	}if(month_id==2){
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
			 fromDate = "01-0"+month_id+"-"+year;
			   toDate = "29-0"+month_id+"-"+year;
		}else{
			 fromDate = "01-0"+month_id+"-"+year;
			   toDate = "28-0"+month_id+"-"+year;
		}
	}
	
	
	 
	  int companyId = 0;
	  
      if(request.getParameter("companyId") != null){
      	companyId =Integer.parseInt(request.getParameter("companyId"));
      }
	
%>
<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
					<%=s%> Leave / CO / OD List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			<%if(request.getAttribute("success") !=null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-success ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${success}
                                 </div>
                                 <%} %>
                                 
                                 <%if(request.getAttribute("error") !=null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-danger">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${error}
                                 </div>
                                 <%} %>
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                         <%=s%> Leave / CO / OD
                        </div>
                       	<%
                        String parseFromDate = null;
                        String parseToDate = null;
                        String parseFromDate1 = null;
                        String parseToDate1 = null;
                      
                        
                        
                        if(request.getParameter("fromDate") != null && !request.getParameter("fromDate").equalsIgnoreCase("")){
                       	 fromDate = request.getParameter("fromDate");
                        toDate = request.getParameter("toDate");
                        
                        session.setAttribute("fromDate", fromDate);
                        session.setAttribute("toDate", toDate);
                        
                        }else if(session.getAttribute("fromDate") != null && session.getAttribute("toDate") != null ){
                        	fromDate = (String) session.getAttribute("fromDate");
                            toDate = (String) session.getAttribute("toDate");
                        }
                       	 
                         DateFormat dateFormatForselection  = new SimpleDateFormat("dd-MM-yyyy");
                         DateFormat dateFormat2Forselection  = new SimpleDateFormat("yyyy-MM-dd");
                         DateFormat dateFormat1ForSelection = new SimpleDateFormat("dd/MM/yyyy");
                         
                       	 Date datee = dateFormatForselection.parse(fromDate);
                    	 Date datee1 = dateFormatForselection.parse(toDate);
                    	 
                    	 parseFromDate = dateFormat1ForSelection.format(datee);
                    	 parseToDate = dateFormat1ForSelection.format(datee1);
                    	 
                    	 parseFromDate1 = dateFormat2Forselection.format(datee);
                    	 parseToDate1 = dateFormat2Forselection.format(datee1);
                    	 

                        
                       
                        %>
                        
                          <div class="panel-body">
                          
                          <form  id="allLeaveHrSide" action="leaveListManager.jsp">
                          
                          <div class="row">
                          <input type="hidden" name="hrApproval" id="hrApproval" value="<%=hrapproval%>">
									<div class="col-md-2">
										<b>Select Status</b>
									</div>
									
									<div class="col-md-1">
										<b>:</b>
									</div>
									
									<div class="col-md-8">
										<%if(status.equalsIgnoreCase("pending")){%><input type="radio" name="Status" value="pending" checked="checked"><%}else{%><input type="radio" name="Status" value="pending"><%}%> Pending
										<%if(status.equalsIgnoreCase("approved")){%><input type="radio" name="Status" value="approved" checked="checked"><%}else{%><input type="radio" name="Status" value="approved"><%}%> Approved
										<%if(status.equalsIgnoreCase("rejected")){%><input type="radio" name="Status" value="rejected" checked="checked"><%}else{%><input type="radio" name="Status" value="rejected"><%}%> Rejected
									</div>
									
						</div>	
						
						<br>
									<%if(request.getParameter("fromDate") != null && !request.getParameter("fromDate").equalsIgnoreCase("")){ %>
								<div class="row">
									<div class="col-md-2">
										<b>Enter Date </b>
									</div>
									
									<div class="col-md-1">
										<b>:</b>
									</div>
									
									<div class="col-md-3">
									<input type="text" class="form-control" name="fromDate" id="fromDate"
											value="<%=fromDate%>"
											style="width: 200px" placeholder="dd-mm-yyyy">
											</div>
											
											<div class="col-md-1">	
											To
											</div>
											
									<div class="col-md-3">		
									<input type="text" class="form-control" name="toDate" id="toDate"
											value="<%=toDate%>"
											style="width: 200px" placeholder="dd-mm-yyyy">
											</div>
											
											</div>
									<%}else{ %>
									<div class="row">
									<div class="col-md-2">
										<b>Enter Date </b>
									</div>
									
									<div class="col-md-1">
										<b>:</b>
									</div>
									
									
									<div class="col-md-3">
									<input type="text" class="form-control" name="fromDate" id="fromDate"
											value="<%=fromDate%>"
											style="width: 200px" placeholder="dd-mm-yyyy">
											</div>
											
											<div class="col-md-1">	
											To
											</div>
											
									<div class="col-md-3">		
									<input type="text" class="form-control" name="toDate" id="toDate"
											value="<%=toDate%>"
											style="width: 200px" placeholder="dd-mm-yyyy">
											</div>
											</div>
									<%} %>
						
						<br>
								<div align="center">
									<input type="submit" class="btn btn-primary" name="submit" value="SUBMIT">
								</div>	
							
							</form>
							<hr>
                          
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                            <%
                            AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
                            List<LeaveBean> listOfEmployee = null;
                            List<LeaveCOBean> co = null;
                            List<LeaveODBean> d = null;
                            
                            
                            listOfEmployee = allLMSListDAO.getListOfApprovedEmployeeLeaveByManager(parseFromDate1,parseToDate1,status,managerId);
                            co = allLMSListDAO.getApprovedCOByManager(parseFromDate1,parseToDate1,status,managerId);
                            d = allLMSListDAO.getApprovedODByManager(parseFromDate1,parseToDate1,status,managerId);
                             
                            %>
                            	<% if(hrapproval.equalsIgnoreCase("leave"))
                            		{%>
                                <li class="active">
                                <%}
                                else{
                                %>
                                <li>
                                <%} %>
                                <a href="#home" data-toggle="tab" onclick="changeHrApproval(1)">Leave (<%=listOfEmployee.size() %>)</a>
                                </li>
                                
                                <% if(hrapproval.equalsIgnoreCase("co"))
                            		{%>
                                <li class="active">
                                <%}
                                else{
                                %>
                                <li>
                                <%} %><a href="#profile" data-toggle="tab" onclick="changeHrApproval(2)">CO (<%=co.size() %>)</a>
                                </li>
                                
                               <% if(hrapproval.equalsIgnoreCase("od"))
                            		{%>
                                <li class="active">
                                <%}
                                else{
                                %>
                                <li>
                                <%} %><a href="#messages" data-toggle="tab" onclick="changeHrApproval(3)">OD (<%=d.size() %>)</a>
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
                                
                                    <h6 align="center"><b><%=status.toUpperCase()%> LEAVE </b>(<%=fromDate%> to <%=toDate %>)</h6>
                                    <hr>
                         <div class="panel-body">
                            <div class="dataTable_wrapper">
                             <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="datatable-buttons">
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
                                            <%if(s.equalsIgnoreCase("pending")) {%>
                                            <th>Action</th>
                                            <%} %>
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
                                     		int manager_id = Integer.parseInt(l.getEmployeeBean().getUnder_manager_id());
                                     			EmployeeBean employeeBean = loginDAO.getEmployeeId(manager_id);
                                     		%>
                                     		<td><%=employeeBean.getFirstname() +" "+employeeBean.getLastname()%></td>
                                     		
	                                     		<%if(l.getStatus().equalsIgnoreCase("pending")){%>
	                                     		<td>
	                                     			
	                                     			<a href="pendingLeave?leave_id=<%=l.getLeave_id()%>&status=<%=l.getStatus()%>"><i class="fa fa-external-link" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
	                                     		</td>
	                                     		<%} %>
                                     		
                                     	</tr>
                                    
                                    <%} %>
                                    </tbody>
                                </table>
                                <%if(s.equalsIgnoreCase("pending")) {%>
                                 <h5><b>Legends :&nbsp;</b></h5><i class="glyphicon glyphicon-ok" style="color:#337ab7;"></i><b> : Leave Approval </b>
                               	<%} %>
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
                                
                                    <h6 align="center"><b><%=status.toUpperCase()%> CO </b>(<%=fromDate%> to <%=toDate %>)</h6>
                                     <hr>
						<div class="panel-body">
								<div class="dataTable_wrapper">
								 <div class="table-responsive">
								 
							  <table class="table table-striped table-bordered table-hover" id="datatable-buttons1">
                                    <thead>
                                        <tr>
                                        	<tr><th style="text-align:center">Company Name</th>
												<th style="text-align:center">Emp Code</th>
												<th style="text-align:center">Name</th>
												<th style="text-align:center">Date</th>
												<th style="text-align:center">Start Time </th>
												<th style="text-align:center">End Time </th>
												<th style="text-align:center">Total Hours </th>
												<th style="text-align:center">Total CO Added </th>
												<th style="text-align:center">Manager Name </th>
												<%if(s.equalsIgnoreCase("pending")) {%>
												<th style="text-align:center">Action</th>
												<%} %>
												
											</tr>
                                        </tr>
                                      </thead>  
                                       <tbody>
                                       <%
										for(LeaveCOBean c : co)
										{
											
											String _24HourStartTime = c.getStart_time();
											String _24HourEndTime = c.getEnd_time();
											
											String start = null;
											
											try 
											{
												
												SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result1 = formater1.parse(c.getCO_date());
												SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
												start = formater2.format(result1);
											
											}
											catch (ParseException e1) 
											{
												e1.printStackTrace();
											}	
										%>
										
										<tr>
											<td><%=c.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
											<td><%=c.getEmployeeBean().getEmployee_code() %></td>
											<td><%=c.getEmployeeBean().getFirstname()+" "+c.getEmployeeBean().getMiddlename()  + " " +c.getEmployeeBean().getLastname()%></td>
											<td>
													<%= start%>
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
                                     		
                                     		<%if(c.getStatus().equalsIgnoreCase("pending")){%>
                                     		<td>
												<a href="LeaveCOManagerShow?CO_ID=<%=c.getCO_ID()%>"><i class="fa fa-external-link" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                     		</td>
                                     		<%} %>
                                     		
										</tr>
										<%} %>
										</tbody>
                                </table>
								 
								 
										</div>
										<%if(s.equalsIgnoreCase("pending")) {%>
										 <h5><b>Legends :&nbsp;</b></h5> <i class="glyphicon glyphicon-ok" style="color:#337ab7;"></i><b> : CO Approval </b>                      
										<%} %>
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
                                
                               
                              <h6 align="center"><b><%=status.toUpperCase()%> OD </b>(<%=fromDate%> to <%=toDate %>)</h6>
                               <hr>
                               <div class="panel-body">
								<div class="dataTable_wrapper">
								 <div class="table-responsive">
								 
								 
								 
								 							  <table class="table table-striped table-bordered table-hover" id="datatable-buttons2">
                                    <thead>
                                        <tr>
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
												<%if(s.equalsIgnoreCase("pending")) {%>
												<th style="text-align:center">Action </th>
												<%} %>
												
											</tr>
                                      </thead>  
                                       <tbody>
                                      <%
										
										for(LeaveODBean od : d)
										{
											String _24HourStartTime = od.getOD_StartTime();
											String _24HourEndTime = od.getOD_EndTime();
											
											String start = null;
											String end = null;
											
											try 
											{
												
												SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result1 = formater1.parse(od.getOD_StartDate());
												Date result2 = formater1.parse(od.getOD_EndDate());
												SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy");
												start = formater2.format(result1);
												end = formater2.format(result2);
											
											}
											catch (ParseException e1) 
											{
												e1.printStackTrace();
											}	
											
									
										%>
										<tr>
											<td><%=od.getEmployeeBean().getCompanyListBean().getCompany_code()%></td>
											<td><%=od.getEmployeeBean().getEmployee_code() %></td>
											<td><%=od.getEmployeeBean().getFirstname()+" "+od.getEmployeeBean().getMiddlename()  + " "+od.getEmployeeBean().getLastname() %></td>
											<td>
													<%= start  %>
											</td>
											<td>
													<%= end %>
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
                                     		
                                     		<%if(od.getStatus().equalsIgnoreCase("pending")){%>
                                     		<td>
												<a href="LeaveODManagerShow?OD_ID=<%=od.getOD_ID()%>"><i class="fa fa-external-link" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                     		</td>
                                     		<%} %>
                                     		
										</tr>
										<%} %>
										</tbody>
                                </table>
								 
										</div>
										<%if(s.equalsIgnoreCase("pending")) {%>
										<h5><b>Legends :&nbsp;</b></h5> <i class="glyphicon glyphicon-ok" style="color:#337ab7;"></i><b> : OD Approval </b> 
                                		<%} %>
										</div>
										</div>	
                                    
                                </div>
                            </div>
                        </div>
                        
                        <!-- /.panel-heading -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
  <!--   <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script> -->

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

    
    
     <script src="js/datatables/jquery.dataTables.min.js"></script>
        <script src="js/datatables/dataTables.bootstrap.js"></script>
        <script src="js/datatables/dataTables.buttons.min.js"></script>
        <script src="js/datatables/buttons.bootstrap.min.js"></script>
        <script src="js/datatables/jszip.min.js"></script>
        <script src="js/datatables/pdfmake.min.js"></script>
        <script src="js/datatables/vfs_fonts.js"></script>
        <script src="js/datatables/buttons.html5.min.js"></script>
        <script src="js/datatables/buttons.print.min.js"></script>
        <script src="js/datatables/dataTables.fixedHeader.min.js"></script>
        <script src="js/datatables/dataTables.keyTable.min.js"></script>
        <script src="js/datatables/dataTables.responsive.min.js"></script>
        <script src="js/datatables/responsive.bootstrap.min.js"></script>
        <script src="js/datatables/dataTables.scroller.min.js"></script>
    
      <script src="js/pace/pace.min.js"></script>
        <script>
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#datatable-buttons").length && $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0	
              })
            },
            TableManageButtons = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons()
                }
              }
            }();
        </script>
        
        
        <script>
          var handleDataTableButtons1 = function() {
              "use strict";
              0 !== $("#datatable-buttons1").length && $("#datatable-buttons1").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0	
              })
            },
            TableManageButtons1 = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons1()
                }
              }
            }();
        </script>
        
        
        <script>
          var handleDataTableButtons2 = function() {
              "use strict";
              0 !== $("#datatable-buttons2").length && $("#datatable-buttons2").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0	
              })
            },
            TableManageButtons2 = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons2()
                }
              }
            }();
        </script>
        
        
        <script type="text/javascript">
          $(document).ready(function() {
            $('#datatable').dataTable();
            $('#datatable1').dataTable();
            $('#datatable-keytable').DataTable({
              keys: true
            });
            $('#datatable-responsive').DataTable();
            $('#datatable-scroller').DataTable({
              ajax: "js/datatables/json/scroller-demo.json",
              deferRender: true,
              scrollY: 380,
              scrollCollapse: true,
              scroller: true	
            });
            var table = $('#datatable-fixed-header').DataTable({
              fixedHeader: true
            });
          });
          TableManageButtons.init();
          TableManageButtons1.init();
          TableManageButtons2.init();
        </script>
    
    
    
     <script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>
</body>
</html>