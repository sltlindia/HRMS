<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.lms.bean.LeaveTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<%@include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<title>Leave Report</title>
<script>
		function myFunction111() 
		{
    		var empcode =  document.getElementById("empcode").value;
    		var leavetypeselect =  document.getElementById("leavetypeselect").value;
    		var companyId = document.getElementById("companyId").value;
    		if(empcode == "" || leavetypeselect == "" || companyId == "")
    		{
        		alert("Please enter the Employee Code or company id or select Form");
        	}
    		else
    		{
    			 document.getElementById("selecttype").value = leavetypeselect ;
    			
    			window.location.replace("specialHRLeave?empcode="+empcode+"&leavetypeselect="+leavetypeselect+"&companyId="+companyId);
    			onclick1();
        	}
		}
	
		
</script>




 <script type = "text/javascript">

 var y;
 var x;
 var x1;
 var b;
 var y1;
 var days;
 var CO , PL , SL, LWP;
 var BCO = 0 , BPL = 0 , BSL = 0 , BLWP = 0;
 var COO , PLL , SLL , LWPP ,ADJDAY ,CONSTANTDAY= 9 ,COPY;
 var sundayworking = false;
 var minusOneDay = false;
 var minusCount = 0;
 var dayChecker = false;
 var backCount = 0;
 var frontCount = 0;
 var frontMinus = false;
 var backMinus = false;
 
			function hideMessage()
			 {
				//document.getElementById("panelbody").style.display="none"; 
				 $('#panelbody').fadeOut('slow');
			 }

				function startTimer()
				 {
						var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
				 }


				function myFunction() 
				{
		    		var temp = document.getElementById("numdays2").value
		    		var purposeOfLeave =  document.getElementById("purposeOfLeave").value
		    		var contactAddress =  document.getElementById("contactAddress").value
		    		var contactNumberDuringLeave =  document.getElementById("contactNumberDuringLeave").value
		    		if(purposeOfLeave == "")
		    		{
		    			alert("Please Fill Up Purpose Of Leave");
		    		}
		    		else if(temp == 0)
			    	{
		        		alert("Please Day Select At least One Day");
		       		}
		    		else if(temp < 0)
			    	{
		    			alert("Please Day Select At least One Day");
			    	}
		    		else if(contactAddress == "")
	    			{
	    				alert("Please Fill Up Contact Address");
	    			}
		    		else if(contactNumberDuringLeave == 0)
		    		{
		    			alert("Please Enter Contact Number");
		   			}
		  	 		else
		   			{
		    				document.getElementById("temp").submit();
		   			}
				}

		</script>
</head>

	
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns">
<%
ArrayList<String> holiday = new ArrayList<String>();
ArrayList<String> holidayDate = new ArrayList<String>();
String Name = null;
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
					<h3 class="page-header">Special Leave Form</h3>
				</div>
			</div>
			<%if(request.getAttribute("LeaveExist") !=null) {%>
		 		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-danger ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveExist}
                            </div>
          		</div>  
          		<%}
			else if(request.getAttribute("LeaveSuccessfully") !=null) 
			{	
			%>
			<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-success">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveSuccessfully}
                            </div>
          		</div>  
          		<%}
			else if(request.getAttribute("LeavefromtodateExist") !=null) 
				{	
          		%>
          		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-danger ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeavefromtodateExist}
                            </div>
          		</div>
          		<%} %>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4 align="left">
								Date :
								<%
								DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
								Date today = Calendar.getInstance().getTime();  
							
							String date1= dateFormat.format(today);
							
							String d = null;
							String currentdate = null;
							
							
							try {
								  
								SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
								Date result = formater.parse(date1);
								SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
								SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
								currentdate = AppDateFormat1.format(result);
								
								d = AppDateFormat.format(result);
								System.out.println(AppDateFormat.format(result));
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							
							
							
							%><%=d %></h4>

						</div>
						
						
						<div class="panel-body">
						<%if(request.getAttribute("empcode") != null)
						{ 
							if(request.getAttribute("leavetypeselect").equals("Leave"))
							{
								%>
							<form action="specialHRLeaveApproval" method="post" enctype="multipart/form-data">
						<%}
							else if(request.getAttribute("leavetypeselect").equals("CO"))
						   {%>
							<form action="SpecialHRCOApproval" method="post" enctype="multipart/form-data">
						<%}
						else if(request.getAttribute("leavetypeselect").equals("OD"))
						{
							%>
							<form action="SpecialHRODApproval" method="post" enctype="multipart/form-data">
							<%}
						else if(request.getAttribute("leavetypeselect").equals("GatePass"))
						{
						%>
						<form action="SpecialHRGatePassApproval" method="get" enctype="multipart/form-data">
						<%	
						  }} %>
						
						
						<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">Employee Detail </div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">

												<div class="table-responsive">
													<table class="table table-stripped" border="0">
														<thead>
															
																<%if(request.getAttribute("empcode") != null)
																{ 
																	int comapny_code = Integer.parseInt(request.getParameter("companyId"));
																%>
																<tr>
																<td><label>Enter Employee Code</label></td>
																<td>:</td>
																<td>
																<input type="text" class="form-control" name="empcode" id="empcode" placeholder="Enter Code"  value="<%=request.getAttribute("empcode")%>" required />
																</td>
															</tr>
															
															<tr><td><label>Select Comapny Name</label></td>
																<td>:</td><td><select class="form-control"
																name="companyId" placeholder="Select Company Name"
																id="companyId" required="required">
																
																	<option value="">---Select Company Name---</option>
																	<%
																		CompanyListDAO companyListDAO = new CompanyListDAO();
																	List<CompanyListBean> listOfCompanyList = (ArrayList) companyListDAO.getListOfCompanyList();
																		for (CompanyListBean companyListBean : listOfCompanyList) {
																			if(comapny_code == companyListBean.getCompany_list_id()){
																	%>
																	<option
																		value="<%=companyListBean.getCompany_list_id()%>" selected="selected"><%=companyListBean.getCompany_name()%></option>
																	
																	<%}else{ %>
																	<option
																		value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
																	<%} %>
																	
																	<%
																		}
																	%>
															</select></tr>
															
															
															<tr>
																<td><label>Select </label></td>
																<td>:</td>
																<td>
																<select class="form-control" name="leavetypeselect" id="leavetypeselect" required>
																	<option>-- Select Form--</option>
																	<option value="Leave">   Leave    </option>
																	<option value="CO">   	 CO       </option>
																	<option value="OD">      OD       </option>
																	<option value="GatePass">      GatePass       </option>
																	</select>
																</td>
															</tr>
															
															
															
															
														</thead>
													
														<%}
															else
															{ %>
															<tr>
																<td><label>Enter Employee Code</label></td>
																<td>:</td>
															<td><input type="text" class="form-control" name="empcode" id="empcode"	placeholder="Enter Code" required>
												</td>
												</tr>
												
												
															<tr>
															<td><label>Select Company Name</label></td>
															<td>:</td>
															<td><select class="form-control"
																name="companyId" placeholder="Select Company Name"
																id="companyId" required>
																
																	<option value="">---Select Company Name---</option>
																	<%
																		CompanyListDAO companyListDAO = new CompanyListDAO();
																	List<CompanyListBean> listOfCompanyList = (ArrayList) companyListDAO.getListOfCompanyList();
																		for (CompanyListBean companyListBean : listOfCompanyList) {
																	%>
																	<option
																		value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
																	<%
																		}
																	%>
															</select>
															</td>
												</tr>
												
												
												<tr>
																<td><label>Select </label></td>
																<td>:</td>
																<td>
																<select class="form-control" name="leavetypeselect" id="leavetypeselect" required>
																	<option value="">-- Select Form--</option>
																	<option value="Leave">   Leave    </option>
																	<option value="CO">   	 CO       </option>
																	<option value="OD">      OD       </option>
																	<option value="GatePass">      GatePass       </option>
																	</select>
												<%} %>
												<tr>
															<td colspan="3" align="center">
															<button class="btn btn-success" id="btnsubmit" type="button" value="Submit" onclick="myFunction111()">Submit</button>
															</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<input type="hidden" name="selecttype" id="selecttype" value="<%=request.getAttribute("leavetypeselect")%>">
								
								<%
								
								EmployeeBean employeeBean = (EmployeeBean)request.getAttribute("employeeBean"); 
								
								if(employeeBean != null)
								{
									employee_master_id = employeeBean.getEmployee_master_id();
									Name = employeeBean.getFirstname() + " " +  employeeBean.getLastname();
								}
								
								if(request.getAttribute("empcode") != null){ 
									
									if(request.getAttribute("leavetypeselect").equals("Leave")){
								%> 
								<%
								
								
								
								
								%>
								
								
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading"> Leave </div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">
												<div class="table-responsive">
												<table class="table table-stripped" border="0">
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="6"><%=Name%>
										</tr>
									</tbody>
								<thead>
								<tbody>
									<tr>
										<td><label>Purpose Of Leave</label></td>
										<td>:</td>
										<td colspan="6"><textarea class="form-control" id="purposeOfLeave" name="purposeOfLeave" autofocus required></textarea>
										</td>
									</tr>
									</tbody>
										<tbody>
											<tr>
												<th colspan="3" align="center">Type Of Leave </th>
												<th colspan="3" align="center">Leave Balance (Day's)</th>
												<!-- <th colspan="5" id="autoUpdateth">Adjust Of Leave</th> -->
											</tr>
									</tbody>
										<tbody>
										<%  
									
										 AllLMSListDAO gradeMasterList1 = new AllLMSListDAO();
   						 				List<LeaveTypeBean> listOfleave1 = gradeMasterList1.getListOfLeave();
   						 				LeaveBalanceBean leaveBalanceBean =(LeaveBalanceBean) gradeMasterList1.getleaveListbyEMP(employee_master_id);
   						 		
   						 				double Co_Leave = leaveBalanceBean.getCO();
   						 				double Plan_Leave = leaveBalanceBean.getPlan_Leave();
						 				double unplan_Leave = leaveBalanceBean.getUnplan_Leave();
						 				double lwp = leaveBalanceBean.getLeave_without_pay();
   						 				for (LeaveTypeBean c : listOfleave1)
   						 					{
   						 						 if(user.getMarital_status().equalsIgnoreCase("married") && user.getGender().equalsIgnoreCase("female"))
   		   						 					{
   						 						%> 
   						 			<tr>
   						 				<%String p = c.getLeave_name();%>
   						 				<td colspan="3">
   						 						<%--  <input type="radio" name="typeOfLeave" onclick="check1(this.id);" id="<%=c.getLeave_type_id()%>" value="<%=c.getLeave_type_id()%>" required="required"> --%><%=c.getLeave_name()%>
   						 					 </td>
   						 					 	<%if(p.equalsIgnoreCase("CO")){%>
   						 						<td colspan="4" ><%=Co_Leave%></td>
   						 						<%} %>
   						 						<%if(p.equalsIgnoreCase("Plan Leave")){%>
   						 						<td colspan="4"><%=Plan_Leave%></td>
   						 						<%} %>
   						 						<%if(p.equalsIgnoreCase("Unplan Leave")){%>
   						 						<td colspan="4"><%=unplan_Leave%></td>
   						 						<%} %>
   						 						<%if(p.equalsIgnoreCase("Leave without pay")){%>
   						 						<td colspan="4" ><%= lwp %></td>
   						 						<%} %>
   						 						<%}
   						 						 else
   						 						 {%>
   						 						 
   						 				<%String p = c.getLeave_name();%>
   						 				
   						 				<%if(! c.getLeave_name().equalsIgnoreCase("Maternity Leave")) {%>
   						 				<td colspan="3">
   						 						<%=c.getLeave_name()%>
   						 						</td>
   						 						<%} %>
   						 					 	<%if(p.equalsIgnoreCase("CO")){%>
   						 						<td colspan="4" ><%=Co_Leave%></td>
   						 						<%} %>
   						 						<%if(p.equalsIgnoreCase("Plan Leave")){%>
   						 						<td colspan="4"><%=Plan_Leave%></td>
   						 						<%} %>
   						 						<%if(p.equalsIgnoreCase("Unplan Leave")){%>
   						 						<td colspan="4"><%=unplan_Leave%></td>
   						 						<%} %>
   						 						<%if(p.equalsIgnoreCase("Leave without pay")){%>
   						 						<td colspan="4" ><%= lwp %></td>
   						 						<%} %>
   						 						
   						 						 <%} %>
   						 						 <%-- <td colspan="5">
   						 						 <div id="autoUpdate<%=c.getLeave_type_id()%>">
   						 							<input type="radio" id="typeOfcheckboxLeave"  name="typeOfcheckboxLeave" onchange="check1()" value="<%=c.getLeave_type_id()%>">
   						 						</div>
   						 						 </td> --%>
   						 			</tr>
   						 			
   						 			
   						 			<%} %>
							</tbody>
											<input type="hidden"  name="employee_master_id" 					value="<%=employeeBean.getEmployee_master_id()%>">
											
											<input type="hidden"  name="CO" 				id="CO" 			value="<%=leaveBalanceBean.getCO()%>">
											<input type="hidden"  name="plan" 				id="plan" 			value="<%=leaveBalanceBean.getPlan_Leave()%>">
											<input type="hidden"  name="unplan" 			id="unplan" 		value="<%=leaveBalanceBean.getUnplan_Leave()%>"/>
											<input type="hidden"  name="LWP" 				id="LWP" 			value="<%= leaveBalanceBean.getLeave_without_pay()%>"/>
											<input type="hidden"  name="currentdate" 		id="currentdate"	value="<%= currentdate %>"/>
											<input type="hidden"  name="CO1" 				id="CO1" 			value="">
											<input type="hidden"  name="PL1" 				id="PL1"	 		value="">
											<input type="hidden"  name="SL1" 				id=SL1 				value="">
											<input type="hidden"  name="LWP1" 				id="LWP1" 			value="">
											<input type="hidden"  name="pushMainDate" id="pushMainDate" value=""/>
											<input type="hidden"  name="popMainDate" id="popMainDate" value=""/>
											<input type="hidden"  name="BackwordSunday" id=BackwordSunday value=""/>
											<input type="hidden"  name="monthID" id="monthID" value=""/>
											<input type="hidden"  name="leavetype" id="leavetype" value=""/>
											<input type="hidden"  name="COCUT" id="COCUT" value=""/>
											<input type="hidden"  name="PLCUT" id="PLCUT" value=""/>
											<input type="hidden"  name="SLCUT" id=SLCUT value=""/>
											<input type="hidden"  name="LWPCUT" id="LWPCUT" value=""/>
									<tbody>	
									<tr>
										<td><label>Leave Applied For</label></td>
										<td>:</td>
										<td colspan="2">From Date: <input type="text" id="datepicker1" width="155" name="fromDate" required class="form-control"><!-- From<input type="date" id="pick_date"   name="fromDate"
											 placeholder="yyyy-MM-dd" class="form-control" onchange="cal()"
											style="width: 160px;" required /> -->
										</td>
										<td colspan="4">
										<div id="radiobutton1">
												<input id="0" type="radio" name="leavefromDate" value="FF" onchange="check();" required checked="checked">Full Day
												<input id="1" type="radio" name="leavefromDate" value="FH" onchange="check();" required>First Half
												<input id="2" type="radio" name="leavefromDate" value="SH" onchange="check();" required>Second Half
												</div>
												<input type="hidden" id="date1" value="">
									</td>
									</tr>
									</tbody>
									<tbody>
									<tr>
									<td colspan="2"></td>									
									<td colspan="2">
													To Date: <input type="text" id="datepicker2" class="form-control" name="toDate"  required>
											<!-- To<input id="drop_date"  type="date"
											name="toDate" onchange="cal()" placeholder="yyyy-MM-dd" style="width: 160px;"
											class="form-control" required /> -->
											<p></p>
											</td>
											<td colspan="4">
											<div id="">
												<input id="3" type="radio" name="leavetoDate"  value="FF" onchange="check();"  checked="checked">Full Day
												<input id="4" type="radio" name="leavetoDate"  value="FH" onchange="check();" >First Half
												<input id="5" type="radio" name="leavetoDate"  value="SH" onchange="check();" >Second Half
											</div>	<input type="hidden" id="date2" value="">
									</br>
									
										 <input type="hidden" class="textbox" id="numdays3" name="numdays3" value="00"/> 
									</td>
									</tr>
									</tbody>
									<tbody>
									<tr>
										<td><label> Holidays Count </label></td>
										<td>:</td>
										<td colspan="6"><input type="text" class="form-control" rows="3" id="numdays4" name="numdays4" required readonly></input>
									</tr>
									</tbody>
									<tbody>
									<tr>
										<td><label>Total Leave Day Count </label></td>
										<td>:</td>
										<td colspan="6"><input type="text" class="form-control" rows="3" id="numdays2" name="numdays" required readonly></input>
									</tr>
									</tbody>
									<tbody>
									<tr>
										<td><label>Contact Address </label></td>
										<td>:</td>
										<td colspan="6"><textarea class="form-control" id="contactAddress" name="contactAddress" rows="2" required></textarea>
									</tr>
									</tbody>
									<tbody>
									<tr>
										<td><label>Contact Number During Leave</label></td>
										<td>:</td>
										<td colspan="6"><input type="text" name="contactNumberDuringLeave" id="contactNumberDuringLeave" class="form-control"  onchange="checkInteger(this.id)" required></input></td>
									</tr>
								</tbody>
								<tbody>
									<tr>
									
									<% 
									AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
									String under_manager_id = employeeBean.getUnder_manager_id();
									
									 ManagerBean managerBean = allLMSListDAO.getnameOfManager(under_manager_id);
									%>
										<td><label>Reporting Manager</label></td>
										<td>:</td>
										<td colspan="6"><input type="text" class="form-control" name="Manager"
											class="form-control" placeholder="Reporting Manager" value="<%=managerBean.getManager_name()%>" required readonly></input>
											<input type="hidden"  name="reportingManager" value="<%=employeeBean.getUnder_manager_id()%>">
											</td>
								
									</tr>
								</tbody>
									<!-- <tr>
									<tbody>
										<td><label>Get approval From</label></td>
										<td>:</td>
										<td colspan="3"><input type="checkbox" name="approval" value="HRD">&nbsp HR Department<br> 
											<input type="checkbox" name="approval" value="HOD">&nbsp HOD &nbsp<br>
											<input type="time" />
										</td>
									<tbody>
									</tr> -->
									<tbody>
									<tr>
									<input type="hidden" name="redirect">
									<input type="hidden" name="Mailredirect">
									
									
										<td align="center" colspan="6">
												<button class="btn btn-success" id="btnsubmit" type="submit" value="update">Submit</button>
										</td>
										
									</tr>
									</tbody>
							</tbody>
								</table>
								</form>					
												</div>
											</div>
										</div>
									</div>
								</div>
					
							<%

									
									}else if(request.getAttribute("leavetypeselect").equals("CO")) {
									%>
					
	
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading"> Compensatory Off Form </div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">
												<div class="table-responsive">
												<table class="table table-stripped" border="0">
												<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="3"><%=Name%>
											<input type="hidden"  name="employee_master_id" value="<%=employeeBean.getEmployee_master_id()%>">	
										</tr>	
									</tbody>
									<tbody>
										<tr >
											<th><label style="width: 200px">Please briefly describe the need of working on holiday</label></th>
											<td>:</td>
											<td colspan="3"><textarea id="describe" rows="2" width="155" name="describe" required class="form-control"></textarea>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>Date</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="datepicker1" width="155" name="fromDate" required class="form-control">
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>Start Time</label></th>
											<td>:</td>
											<td colspan="3"><input type="time" id="starttime" name="starttime" onchange="diff()" value="18:00"  class="form-control">
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>End Time</label></th>
											<td>:</td>
											<td colspan="3"><input type="time" id="endtime" value="" name="endtime" onchange="diff()" class="form-control">
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>Total Hours Count</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="totalhours" value="" name ="totalhours" class="form-control" readonly="readonly">
										</tr>	
									</tbody>
									<tbody>
									<tr>
									
									<% 
									AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
									String under_manager_id = employeeBean.getUnder_manager_id();
									
									 ManagerBean managerBean = allLMSListDAO.getnameOfManager(under_manager_id);
									%>
										<td><label>Reporting Manager</label></td>
										<td>:</td>
										<td colspan="6"><input type="text" class="form-control" name="Manager"
											class="form-control" placeholder="Reporting Manager" value="<%=managerBean.getManager_name()%>" required readonly></input>
											<input type="hidden"  name="reportingManager" value="<%=employeeBean.getUnder_manager_id()%>">
											</td>
								
									</tr>
								</tbody>
							</tbody>
							<tr>
										<input type="hidden" name="sunday" id="sunday" value="">	
								<input type="hidden" name="redirect">
								<td align="center" colspan="7">
								
										<button class="btn btn-success" id="btnsubmit" type="submit" value="Submit">Submit</button>
										
								</td>
								
							</tr>
							<tbody>
						
												</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<%
		
						
						
									}else if(request.getAttribute("leavetypeselect").equals("OD")){ %>
								
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading"> Outdoor duty slip </div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">
												<div class="table-responsive">
												
													<table class="table table-stripped" border="0">
											
									<tbody>
										<tr>
											<th><label>Employee Name</label></th>
											<td>:</td>
											<td colspan="3"><%=Name%>
											<input type="hidden"  name="employee_master_id" value="<%=employeeBean.getEmployee_master_id()%>">
										</tr>	
									</tbody>
									<tbody>
										<tr >
											<th><label style="width: 200px">Please briefly describe the need of working on holiday</label></th>
											<td>:</td>
											<td colspan="3"><textarea id="describe" rows="2" width="155" name="describe" required class="form-control"></textarea>
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>From Date</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="datepicker1" width="155" name="StartDate" required class="form-control">
										</tr>	
									</tbody>
									<tbody>
									<tr>
											<th><label>To Date</label></th>
											<td>:</td>
											<td colspan="3"><input type="text" id="datepicker2" width="155" name="EndDate"  required class="form-control"></td>
									</tr>
									</tbody>
									<tbody>
										<tr>
											<th><label>Start Time</label></th>
											<td>:</td>
											<td colspan="3"><input type="time" id="my_timepicker_input" name="starttime" class="form-control">
										</tr>	
									</tbody>
									<tbody>
										<tr>
											<th><label>End Time</label></th>
											<td>:</td>
											<td colspan="3"><input type="time" id="diff_time2" value="" name="endtime" class="form-control">
										</tr>	
									</tbody>
									<tbody>
									<tr>
									
										<td><label>Total Day Count </label></td>
										<td>:</td>
										<td colspan="3"><input type="text" class="form-control"	rows="3" id="numdays2" name="numdays" required readonly></input>
								
									</tr>
									</tbody>
									<tbody>
									<tr>
									<% 
									AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
									String under_manager_id = employeeBean.getUnder_manager_id();
									
									 ManagerBean managerBean = allLMSListDAO.getnameOfManager(under_manager_id);
									%>
										<td><label>Reporting Manager</label></td>
										<td>:</td>
										<td colspan="6"><input type="text" class="form-control" name="Manager"
											class="form-control" placeholder="Reporting Manager" value="<%=managerBean.getManager_name()%>" required readonly></input>
											<input type="hidden"  name="reportingManager" value="<%=employeeBean.getUnder_manager_id()%>">
											</td>
								
									</tr>
								</tbody>
							</tbody>
							<tr>
								
									<input type="hidden" name="redirect">
								<td align="center" colspan="7">
								
										<button class="btn btn-success" id="btnsubmit" type="submit" value="Submit">Submit</button>
										
								</td>
								
							</tr>
							<tbody>
							</table>
													
												</div>
											</div>
										</div>
									</div>
								</div>
								
	
								
								<%}
									else if((request.getAttribute("leavetypeselect").equals("GatePass")))
									{
									%>
									<div class="panel-body">
									<input type="hidden" name="emp_id" value="<%=employeeBean.getEmployee_master_id()%>">
							
								<div class="row"> 
								<div class="col-lg-12">
								<br>
									<b>To : The Security Gate,<br> 
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please Allow The following Persons....... To go Out for Official / Personal Work.</b>
								</div>
								</div>
								<br>
								<br>
								<table class="table table-stripped">	
									<tbody>
											<tr bgcolor="#DCDCDC">
												<!-- <th style="width: 20px;"></th> -->
												<th style="width: 260px;"><center> Name </center></th>
												<th style="width: 100px;"><center> Personal </center></th>
												<th style="width: 100px;"><center> Official </center></th>
												<th style="width: 180px;"><center> At </center></th>
												<th style="width: 260px;"><center> Remark </center></th>
											</tr>
									</tbody>
									
								</table>
								<table class="table table-stripped" id="dataTable">	
									
								<tbody>
								<tr>
									<!-- <TD style="width: 20px;"><INPUT type="checkbox" name="chk"/></TD> -->
									<td style="width: 260px;"><input type="text" class="form-control" id="employeeName" name="employeeName" value="<%=employeeBean.getFirstname()+ " "+employeeBean.getLastname() %>" readonly="readonly"></td>
									<td style="width: 100px;"><center><input type="radio" name="purpose_of_leave" value="Personal" required></center></td>
									<td style="width: 100px;"><center><input type="radio" name="purpose_of_leave" value="Official" required></center></td>
									<td style="width: 180px;"><input id="outTime" type="text" class="form-control" name="outTime" placeholder="HH:mm" required></td>
									<td style="width: 260px;"><textarea class="form-control" style="height: 34px" name="reason" placeholder="Enter Remark" required ></textarea></td>
								</tr>
								</tbody>
								</table>
								
								
								<table class="table table-stripped" bgcolor="#DCDCDC">								
								<tbody>
								
									<tr bgcolor="#DCDCDC">
										<th><center>From</center></th>
										<th><center>To</center></th>
									</tr>
									<tr>
										<td>
											<center>
											<select class="form-control" name="CompanyName"  placeholder="Select Company Name" id="CompanyName" required="required" style="width: 200px;" onchange="diff(this.value);">
												<option value="">---Select Location---</option>
												<option value="A-8">A-8</option>
												<option value="A-15">A-15</option>
												<option value="E-2">E-2</option>
												<option value="E-30">E-30</option>
												<option value="SEZ">SEZ</option>
										 	</select>
										 	</center>
									 	</td>
										<td>
												<input type="text" class="form-control" name="Todec" width="200px" placeholder="Enter Destination" required>
										</td>
									</tr>
									
									</tbody>
									
									
								</table>
								
								<br>
								
								<%int manager_id = Integer.parseInt(employeeBean.getUnder_manager_id());
											LoginDAO loginDAO = new LoginDAO();
											EmployeeBean employeeBean1 = loginDAO.getUserByManagerId(manager_id);
										%>
								<table class="table table-stripped">								
								<tbody>
								
									<tr bgcolor="#DCDCDC">
										<th><center>Authorised By</center></th>
										<th><center>Date</center></th>
									</tr>
									<tr> 
										<%-- <td><center><%=employeeBean.getFirstname()+ " "+employeeBean.getLastname() %></center></td> --%>
										<td style="width: 460px;"><center>
											<input type="radio" name="manager" value="<%=employeeBean1.getManagerBean().getManager_id()%>" checked="checked"/>  <%=employeeBean1.getFirstname()+ " "+employeeBean1.getLastname() %>
											<%int under_manager_id = Integer.parseInt(employeeBean1.getUnder_manager_id());
											EmployeeBean employeeBean2 = loginDAO.getUserByManagerId(under_manager_id);%>
											&nbsp;&nbsp;&nbsp;<input type="radio" name="manager" value="<%=employeeBean2.getManagerBean().getManager_id()%>"/>  <%=employeeBean2.getFirstname()+ " "+employeeBean2.getLastname() %>
										</center> </td>
										<td><center><%=currentdate %></center></td>
									</tr>
										
									</tbody>
									<tbody>
									<tr>
										<td colspan="6" align="Center">
										<input type="submit" class="btn btn-success" id="btnsubmit" value="Submit">
									 	<!-- <input type="button" value="Add Row" onclick="addRow('dataTable')" />
									 	<INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" /> -->
									 	</td>
									</tr>
									</tbody>
									
								</table>
								
									
									</div>
									
									
									<%} %>
									
								<%
								AllLMSListDAO allListDAO2 = new AllLMSListDAO();
								List<HolidayBean> listgholiday = allListDAO2.getListOfHoliday();
								for(HolidayBean h : listgholiday)
								{
									
									String date = h.getHoliday_date();
									String d1 = null;	
									String d2 = null;
										try {
											  
											SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
											Date result2 = formater1.parse(date);
											SimpleDateFormat AppDateFormat = new SimpleDateFormat("MM/dd/yyyy");
											SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
											d1 = AppDateFormat.format(result2);
											d2 = AppDateFormat1.format(result2);
											//System.out.println("date:"+d1);
											holiday.add(d1);
											holidayDate.add(d2);
										} catch (ParseException e1) {
											e1.printStackTrace();
										}	

								}
								%>
								
								
					<%}%>
					
					
					
					
					
				</form>
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
						
					
</body>
<% 

if(request.getAttribute("leavetypeselect") != null )
{
	if(request.getAttribute("leavetypeselect").equals("Leave"))
	{
%> 
 <script type="text/javascript">

var days;

var currentdate = document.getElementById("currentdate").value;
	

$(document).ready(function()
		{
		    var $datepicker1 =  $( "#datepicker1" );
		    var $datepicker2 =  $( "#datepicker2" );
			
		    /* $("#datepicker1").datepicker({  dateFormat: 'dd/mm/yy'});
	    	$("#datepicker2").datepicker({ dateFormat: 'dd/mm/yy' }); */
		  var holiDates = [];
	    var disableddates =[];
 		<%for (int i =0; i<holiday.size(); i++)
 		{
 				String date = holiday.get(i);%>
   		  		holiDates[<%=i%>] = new Date("\"<%=date%>\"");
   		  <%}%>
  
   		 /*  holiDates[1] = new Date("01/26/2016");
   		  holiDates[2] = new Date("03/23/2016");
   		  holiDates[3] = new Date("08/15/2016");
   		  holiDates[4] = new Date("08/18/2016");
   		  holiDates[5] = new Date("08/25/2016");
   		  holiDates[6] = new Date("08/26/2016");
   		  holiDates[7] = new Date("10/11/2016");
   		  holiDates[8] = new Date("10/29/2016");
   		  holiDates[9] = new Date("10/30/2016");
   		  holiDates[10] = new Date("10/31/2016");
   		  holiDates[11] = new Date("11/01/2016");
   		  holiDates[12] = new Date("11/02/2016");
   		  holiDates[14] = new Date("11/03/2016");
   		  holiDates[15] = new Date("11/04/2016");
   		 /*  holiDates[16] = new Date("09/01/2016");
   		  holiDates[17] = new Date("09/01/2016"); */
   		
   		var daysToDisable = [0];
   	 	<%for (int z =0; z<holidayDate.size(); z++)
 		{
 				String datedate = holidayDate.get(z);%>
 				disableddates.push("<%=datedate%>");
   		  <%}%>
   		  
   		  
   		  
   		  <% int role_id = user.getDepartmentBean().getDepartment_id();
   		  if(role_id == 1)
   		  {
			%>
			   		function noSundaynoHoliday(date)
			   		{
			   			// SUNDAY DISABLE //
			   		    var day = date.getDay();
			   		    if ($.inArray(day, daysToDisable) != -1) {
			   		        return [false];
			   		    } 
			
			   				// HOLIDAYS DISABLE //
			   			 	var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
			   				if(disableddates.indexOf(string) != -1)
			   				{
			   					 return [false];
			   				} 
			   		   
			   			// 1ND AND 3TH SAT DISABLE //
			   				/*  var day = date.getDay(),
			   		        week = Math.floor(date.getDate() / 7);
			   				if(day == 6 && (week == 0 || week == 2))
			   				{
			   					return [false];
			   				} */
			   		    //return day == 6 && (week == 1 || week == 3)
					
			   		    return [true]
			   		}
   		<%
   		}
   		  else
   		  {
   		%>
   		function noSundaynoHoliday(date)
   		{
   			// SUNDAY DISABLE //
   		    var day = date.getDay();
   		    if ($.inArray(day, daysToDisable) != -1) {
   		        return [false];
   		    } 

   				// HOLIDAYS DISABLE //
   			 	var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
   				if(disableddates.indexOf(string) != -1)
   				{
   					 return [false];
   				} 
   		   
   			// 2ND AND 4TH SAT DISABLE //
   				/* var day = date.getDay(),
   		        week = Math.floor(date.getDate() / 7);
   				if(day == 6 && (week == 1 || week == 3))
   				{
   					return [false];
   				} */
   		    //return day == 6 && (week == 1 || week == 3)
				 	
   		    return [true]
   		}
   		
   		  <%}%>
   		  
   	
   		  
   	 	/* var disableddates = ["29-10-2016", "30-10-2016", "31-10-2016", "01-11-2016" , "02-11-2016", "03-11-2016", "04-11-2016", "11-10-2016"]; */
   		
   		 
   //......... THIS FUNCTON SUNDAY DATE HIDE //.......
   		function noSunday(date)
		 { 
            return [date.getDay() != 0, ''];
         }; 
   		  
         
   		$datepicker1.datepicker({		
   			dateFormat: 'dd/mm/yy' , 
   		 	minDate: '-10', 
   		 	maxDate: '+2m',
   			beforeShowDay: noSundaynoHoliday,
   			 changeMonth: true,
   			 onSelect: function(dateStr)
   			 {
   	            $('#datepicker2').datepicker('option', 'defaultDate', dateStr);
   	           	$('#datepicker2').datepicker('option', 'minDate', dateStr);
   	         	setTimeout(function()
   	         			{
   	           				 $( "#datepicker2").datepicker('show');
   	        			}, 300); 
   	         	
   	         	
   	         	
   	         var toDate = $datepicker1.datepicker('getDate');  
				var backDate = new Date(toDate);
				 backDate.setDate(backDate.getDate());
				
				 if(backDate.getDay() == 0)
				 {
					 
					 document.getElementById("sunday").value = "YES";
				 }
				 else
					 {
						 document.getElementById("sunday").value = "NO";
					 } 	
   	         	
   	         	
   	        }
   		});
   		
		$datepicker2.datepicker({
		     dateFormat: "dd/mm/yy",
		     maxDate: '+2m',
		     beforeShowDay: noSundaynoHoliday,
		     changeMonth: true,
		         onClose: function() 
		         {
		        	
		           	var firstCheck = false;
		            var lastCheck = false;   
		        	var fromDate = $datepicker1.datepicker('getDate');
		            var toDate = $datepicker2.datepicker('getDate');  
		           	var CD = new Date();
	
		            var currentdate = $.datepicker.formatDate('dd/mm/yy', CD);
		            var currentdate1 =  $datepicker1.datepicker('getDate' ,CD);
		    		         
		            
		            var monthID = fromDate.getMonth() + 1;
		          // alert(monthID);
		           document.getElementById("monthID").value = monthID;
		            var nextDayDate = new Date();
		       		nextDayDate.setDate(nextDayDate.getDate() + 7);
		       		var e = $.datepicker.formatDate('dd/mm/yy', nextDayDate);
		       	
		            var sundayCheker1 = $datepicker1.datepicker('getDate');
		            var sundayCheker = $datepicker2.datepicker('getDate');
		            var sundayCheker11 = $datepicker2.datepicker('getDate');
		             
		 		    var f = $.datepicker.formatDate('mm/dd/yy', fromDate);
		 			var t = $.datepicker.formatDate('mm/dd/yy', toDate);
		 			var f1 = $.datepicker.formatDate('dd/mm/yy', fromDate);
		 			var t1 = $.datepicker.formatDate('dd/mm/yy', toDate);
		 			
		 			var diff = new Date(toDate - fromDate);
		 			days = ((diff/1000/60/60/24) + 1);
		 		
		            var diff1 = new Date(fromDate - CD);
		            var maindiff = ((diff1/1000/60/60/24) + 1);
		          
		           if(maindiff > 7)
		        	   {
		  
		        	   		document.getElementById("leavetype").value = "PLAN LEAVE";
		        	   }
		           else
		        	   {
		        	   		//alert("UNPLAN LEAVE");
		        	   		document.getElementById("leavetype").value = "UNPLAN LEAVE";
		        	   }
		            
		           var paidCount = 0;
		 			for (var i = 0; i < holiDates.length; i++) 
		 				{
		 					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiDates[i]);
		 					
		 					if((f == f1) || (t == f1))
		 					{
		 						if(f == f1)
			 					{
		 							var d  = $.datepicker.formatDate('dd/mm/yy', fromDate);
		 							alert(d + " Is Already Public Holiday");
		 							firstCheck = true;
				 				}
		 						else if(t == f1)
			 						{
		 								var d  = $.datepicker.formatDate('dd/mm/yy', toDate);
		 								alert(d + " Is Already Public Holiday");
		 								lastCheck = true;
		 								/* sundayCheker.setDate(sundayCheker.getDate() - 1);
			 			               	if(sundayCheker.getDay() == 0)
				 			               {
						 						days = days - 1;
						 						alert("sunday");
				 			               }  */
			 						}
		 						 
									//days = days - 1;	    
		 					}
		 				}


		 			sundayCheker1.setDate(sundayCheker1.getDate() - 1);
		               	if(sundayCheker1.getDay() == 0)
			               {
	 						
	 						//alert("sunday");
			               }  
		 			
		 			
		 			
					// more Then Date Select
					if(toDate < fromDate)
					{
						//alert("Date More Then Select");
						document.getElementById("datepicker2").value = "";
						document.getElementById("numdays2").value = 0;
					}
					else
						{
							document.getElementById("numdays2").value  = days;
						}

					 var SunDay = 0;
					var HodidaysCount = 0;
					 currentDate = new Date(fromDate);
				     var between = [];
				     while (currentDate <= toDate)
					 {
				         between.push(new Date(currentDate));
				         currentDate.setDate(currentDate.getDate() + 1);
				     }
				     
				     
				     sundayworking = false;
				     for(var k = 0; k < between.length; k++)
					  {
				    	 var sundayCheck = between[k].getDay();
						if(sundayCheck == 0)
						{
							SunDay++;
							HodidaysCount++;
							sundayworking = true;
						}
					}
				     
				     
				     
				     minusOneDay = false;
				     dayChecker = false;
				     frontMinus = false;
				     backMinus = false;
				    var backDate = new Date(toDate);
					 backDate.setDate(backDate.getDate() - 1);
					 var frontDate = new Date(fromDate);
						frontDate.setDate(frontDate.getDate() + 1);
				     
				     for(var k = 0; k < between.length; k++)
					  {
				    	 var k2 = $.datepicker.formatDate('mm/dd/yy', between[k]);
				    	 var k3 = $.datepicker.formatDate('mm/dd/yy', backDate);
				    	 var k4 = $.datepicker.formatDate('mm/dd/yy', frontDate); 
				    	 for (var i = 0; i < holiDates.length; i++) 
			 				{
			 					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiDates[i]);
			 					 if(k2 == f1)
			 					 {
			 						HodidaysCount++;
			 						sundayworking = true;
			 					 }
			 					 
			 					 if(k3 == f1){
			 						 backMinus = true;
			 						minusOneDay = true;
			 					 }
			 					 
			 					 if(k4 == f1){
			 						frontMinus = true; 
			 						minusOneDay = true;
			 					 }
			 				}
					  }
				    
				   if(backDate.getDay() == 0){
					   backMinus = true;
					   minusOneDay = true;
				   }
				   if(frontDate.getDay() == 0){
					   frontMinus = true; 
					   minusOneDay = true;
				   }
				   
				   
				   
				 
				var backDate1 = new Date(toDate);
				
				 var k333 = $.datepicker.formatDate('mm/dd/yy', frontDate);
				 var loop = true;
				  minusCount = 0;
				  backCount = 0;
				  frontCount = 0;
				  var fromCheckDate = f;
				  
				  for(var f = 1;f < between.length ; f++){
					  if(loop == true){
					   	loop = false;
						 backDate1.setDate(backDate1.getDate() - 1);
						 var k33 = $.datepicker.formatDate('mm/dd/yy', backDate1);
						 for (var f1 = 0; f1 < holiDates.length; f1++) 
			 				{
			 					 var f111 = $.datepicker.formatDate('mm/dd/yy', holiDates[f1]);
			 					 if(k33 == f111)
			 					 {
			 						backCount++;
			 						//alert("holiday:"+f111);
			 						loop = true;
			 						
			 						//alert("k33:"+k33);
			 						//alert("fromDate:"+fromCheckDate);
			 					 }
			 					if(k33 == fromCheckDate){
		 							//alert("dayChecker");
			 						dayChecker = true;
			 					 }
							 }
						 if(loop == false){
							 if(backDate1.getDay() == 0){
								 backCount++
								//alert("sunday:"+backDate1);
								 if(k333 == k33){
									 dayChecker = true;
								 }
							 }
						 }
					  }
					 }

				 // alert("backCount:"+backCount);
				  
					var frontDate1 = new Date(fromDate);
				  if(dayChecker == false){ 
					  loop = true;
				  for(var f = 1;f < between.length ; f++){
					  if(loop == true){
					   	loop = false;
					   	frontDate1.setDate(frontDate1.getDate() + 1);	
						 var k33 = $.datepicker.formatDate('mm/dd/yy', frontDate1);
						 for (var f1 = 0; f1 < holiDates.length; f1++) 
			 				{
			 					 var f111 = $.datepicker.formatDate('mm/dd/yy', holiDates[f1]);
			 					 if(k33 == f111)
			 					 {
			 						frontCount++;
			 						//alert("holiday:"+f111);
			 						loop = true;
			 					 }
							 }
						 if(loop == false){
							 if(frontDate1.getDay() == 0){
								 frontCount++
								// alert("sunday:"+backDate1);
							 }
						 }
					  }
					 }
				  }
				  
				 // alert("frontCount:"+frontCount);
				 // alert(frontMinus);
				 // alert(backMinus);
				    
				  
				     
				     // Pre Working Day
				     popDate = new Date(fromDate);
				     var between = [];
				     var popCheck = true;
				     while (popDate >= fromDate)
					 {
				    	
				         between.pop(new Date(popDate)); 
				         popDate.setDate(popDate.getDate() - 1);
				        for(var aaaa = 0 ; aaaa < 100 ; aaaa++){
				        	 var ccc = $.datepicker.formatDate('mm/dd/yy', popDate);
				        	
				        	if(popCheck == true){ 
				        		popCheck = false;
				         for (var aaa = 0; aaa < holiDates.length; aaa++) 
			 				{
			 					  var bbb = $.datepicker.formatDate('mm/dd/yy', holiDates[aaa]);
			 					
			 					 if(bbb == ccc)
			 					 {
			 						
			 						popDate.setDate(popDate.getDate() - 1);
			 						popCheck = true;
			 						
			 					 } 
							 }
				        }
				        }   
				         
				         if(popDate.getDay() == 0)
				        	{
				        		popDate.setDate(popDate.getDate() - 1);
				        		document.getElementById("BackwordSunday").value = "Y";
				        		//alert("b:"+ccc);
				        	}
				         else
				        	 {
				        		 document.getElementById("BackwordSunday").value = "N";
				        		 //alert("c:"+ccc);
				        	 }
				     }
				     
				     
				     var popMainDate = $.datepicker.formatDate('yy-mm-dd', popDate);
				     document.getElementById("popMainDate").value = popMainDate;
				     
				     // Next Working Day
				     pushDate = new Date(toDate);
				     var between = [];
				     var SunDay = null;
				     var loop1 = true;
				     var pushCheck = true;
				     while (pushDate <= toDate)
					 {
				    	 
				         between.push(new Date(pushDate));
				         pushDate.setDate(pushDate.getDate() + 1);
				         
				         for(var aaaaa = 0 ; aaaaa < 100 ; aaaaa++){
				        	  var cc = $.datepicker.formatDate('mm/dd/yy', pushDate);
				        	  if(pushCheck == true){ 
					        		pushCheck = false;
				         for (var aa = 0; aa < holiDates.length; aa++) 
			 				{
			 					  var bb = $.datepicker.formatDate('mm/dd/yy', holiDates[aa]);
			 					
			 					 
			 					 if(bb == cc)
			 					 {
			 						
			 						pushDate.setDate(pushDate.getDate() + 1);
			 						pushCheck = true;
			 						
			 					 } 
							 }
				         }
				         }  	  
					         if(pushDate.getDay() == 0)
				        	{
				        		pushDate.setDate(pushDate.getDate() + 1);
				        		document.getElementById("BackwordSunday").value = "Y";
				        		//alert("e:"+cc);
				        	}
				         else
				        	 {
				        		 document.getElementById("BackwordSunday").value = "N";
				        		 //alert("f:"+cc);
				        	 }
				     }
				    
	
				     	var pushMainDate = $.datepicker.formatDate('yy-mm-dd', pushDate);
				     	document.getElementById("pushMainDate").value = pushMainDate;
				     	
				     // Finish Next Working Day	
				     	
						var firstWorkingDay = null;
						var lastWorkingDay = null;
						
				    	 for(var k = 0; k < between.length; k++)
						  {
					    	 var k2 = $.datepicker.formatDate('mm/dd/yy', between[k]);
					    	 var sundayCheck = between[k].getDay();
					    	 var k21 = between[k];
					    	 var flag = false;
					    	 for(var l = 0; l < holiDates.length; l++)
							{
									 holiday = holiDates[l].getDay();
								     var l2 = $.datepicker.formatDate('mm/dd/yy', holiDates[l]);
									
								 	 if(k2 == l2)
									 {
										flag = true;
									 }
							}

							if(flag == false)
							{
									if(firstWorkingDay == null)
									{
										if(sundayCheck != 0)
										{
											firstWorkingDay = k21
										}
									}
									else
										{
											if(sundayCheck != 0)
											{
												lastWorkingDay = k21;
											}
										}
							}
							
							
						}
			
			 		
			 		
					if(firstWorkingDay != null && lastWorkingDay !=null)
					{
						
						if(!sundayCheker == toDate)
						{
							var  fWork =firstWorkingDay;
							var  lWork = lastWorkingDay;
							
							var diff = new Date(lWork - fWork);
							var finalLeaveDays = ((diff/1000/60/60/24) + 1);
							days = finalLeaveDays;
							
						}
						
					}
					else
					{
						 for(var j = 0; j < holiDates.length; j++)
							{
								holiday = holiDates[j].getDay();
								var f2 = $.datepicker.formatDate('mm/dd/yy', holiDates[j]);
								if(firstCheck == false && lastCheck == false )
								{
											
								}
								else
									{
							    		  if((f2 > f && f2 < t))
							        		  {   		
															days = days - 1;
							    		      			 	 paidCount++;	
							        		   		}
								    		   		 if(f2 == f)
									    		   		{
									    		   			paidCount++;
									    		   			days = days - 1;
									    		   			
								    		   				
									    		   		 }	
								    		   		 		else if(f2 == t)
										    		   		{
										    		   			sundayCheker.setDate(sundayCheker.getDate() - 1);
									 			               	if(sundayCheker.getDay() == 0)
										 			               {
									 			               			
												 						days = days - 1;
										 			               } 
				
						 			              					 paidCount++;
							    		   							 days = days - 1;
							    		   							
							    		   					 }			 	   		 
												}
						    		   		 
								   		}
 
									}
					
				
								if(firstCheck == false)
								{
									sundayCheker1.setDate(sundayCheker1.getDate());
					               	if(sundayCheker.getDay() == 0)
						               {
					 						days = days - 1;
					 						//alert("sunday again");
						               } 
								}
								
					
					
							if(lastCheck == false )
							{
								sundayCheker.setDate(sundayCheker.getDate());
				               	if(sundayCheker.getDay() == 0)
					               {
				 						days = days - 1;
				 						//alert("sunday again");
					               } 
							}
					
							
							
					
						x = days;
						y1 = days;
						y = days - 1;
						b = x;	
						
						

						
			        document.getElementById("numdays4").value  = HodidaysCount; 
			        document.getElementById("numdays2").value  = days;	

			        if(days == 1)
					{
						 // document.getElementById('3').checked = false;
						  $('#radiobutton1').fadeOut('slow');
					}
					else
						{
							document.getElementById('0').checked = true;
							$('#radiobutton1').fadeIn('slow');
						}	
			        
			       
		      	 // check();
			       
		        }
		    });
		});

function check()
{
		var radios = document.getElementsByName("leavefromDate");
		var radios1 = document.getElementsByName("leavetoDate");
	
		for( i = 0; i < 3; i++ )
		{
			if( radios[i].checked || radios1[i].checked)
			{
				if((radios[i].id == 0) || (radios1[i].id == 3))
				{
					minusOneDay = true;
					if(y1 == days)
					{
						x = y1;	
						//alert("1");
					}
					else
					{
						//alert("b:"+b);
						b = y1 + 0.5;
						x = b;	
						//alert("B:"+b)
						//alert("2");
					}
				
				}
				else if((radios[i].id == 1) || (radios[i].id == 2) || (radios1[i].id == 4) || (radios1[i].id == 5))
				{
					if(y == b)
					{
						x = b;
						//alert("3");
						minusOneDay = true;
					}
					else
					{
						//alert("X:"+x);
						y1 = b;
						b = x - 0.5;
						x = b;
						//alert("4");
						minusOneDay = true;
						
					}			
				}
			}
		}
	
		var xx= 0;		
	/* for( i = 0; i < 3; i++ )
		{
			if( radios[i].checked || radios1[i].checked)
			{
				if((radios[i].id == 0) || (radios1[i].id == 3))
				{
				}
				else if((radios[i].id == 1) || (radios[i].id == 2) || (radios1[i].id == 4) || (radios1[i].id == 5))
				{
					if(minusOneDay == true){
						
							if(frontMinus == true){
								alert("frontCount");
								xx = x-frontCount;
							}
							if(backMinus == true){
								alert("backCount");
								xx = x-backCount;
								minusOneDay = false;
							}
					}
				}
			}
			
			
			
		}  */
		
		
		
	if ((document.getElementById('0').checked && document.getElementById('4').checked) || (document.getElementById('0').checked && document.getElementById('5').checked) )
	{
if(minusOneDay == true){
			
			if(backMinus == true){
				//alert("backCount");
				xx = x-backCount;
				minusOneDay = false;
			}
	}	
		}
		
	if ((document.getElementById('3').checked && document.getElementById('1').checked) || (document.getElementById('3').checked && document.getElementById('2').checked) )
	{
		
if(minusOneDay == true){
			
			if(frontMinus == true && dayChecker == false){
				//alert("frontCount");
				xx = x-frontCount;
			}else if(frontMinus == true && dayChecker == true){
				xx = x-backCount;
			}
	}
		
		}
	
	if ((document.getElementById('1').checked && document.getElementById('4').checked) || (document.getElementById('1').checked && document.getElementById('5').checked) || (document.getElementById('2').checked && document.getElementById('4').checked || (document.getElementById('2').checked && document.getElementById('5').checked)))
	{
		
	if(minusOneDay == true){
			
				//alert("frontCount");
				xx = x-frontCount-backCount;
	}
		
		}
	
		
			if(xx!=0){
			document.getElementById("numdays2").value = xx;
			}else{
				document.getElementById("numdays2").value = x;
			}
			
}

function fadeout()
{
	document.getElementsByName('typeOfcheckboxLeave').checked = false;
    $('#autoUpdate1').fadeOut('slow');
    $('#autoUpdate2').fadeOut('slow');
    $('#autoUpdate3').fadeOut('slow');
    $('#autoUpdate4').fadeOut('slow');
    $('#autoUpdate5').fadeOut('slow');
    $('#autoUpdate6').fadeOut('slow');
    $('#autoUpdate7').fadeOut('slow');
    $('#autoUpdateth').fadeOut('slow');
   
}

function unchecked(){

	alert("akash");
	 document.getElementById("typeOfcheckboxLeave").checked = false;
}		

</script>
  <% 
	}
  	else if(request.getAttribute("leavetypeselect").equals("CO"))
	{
%> 
<script type="text/javascript">

		var days;
		var y;
		var x;
		var x1;
		var b , y1;

		 $(document).ready(function()
				 {
				     var $datepicker1 =  $( "#datepicker1" );
				   
				      $datepicker1.datepicker({		
				 			dateFormat: 'dd/mm/yy' ,
				 			 maxDate: 0,
				 			 changeMonth: true,
				 			 onSelect: function(dateStr)
				 			 {
				 	           
				 				<%-- var holiDates = [];
				 			    var disableddates =[];
				 		 		<%for (int i =0; i<holiday.size(); i++)
				 		 		{
				 		 				String date = holiday.get(i);%>
				 		   		  		holiDates[<%=i%>] = new Date("\"<%=date%>\"");
				 		   		<%}%> --%>
				 				 
				 				 
				 				 
				 				var toDate = $datepicker1.datepicker('getDate');  
				 				var backDate = new Date(toDate);
								 backDate.setDate(backDate.getDate());
								
								 if(backDate.getDay() == 0)
								 {
									 
									 document.getElementById("sunday").value = "YES";
								 }
								 else
									 {
										 document.getElementById("sunday").value = "NO";
									 } 	

							/* 	 
								 var holiDates = [];
								 for (var i = 0; i < holiDates.length; i++) 
					 				{
					 					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiDates[i]);
					 					alert("OK");
					 					
					 				} */

								 
								 
								 
								 
				 			 }
				      
				 		});
				 });
		
/* $(document).ready(function()
{
    var $datepicker1 =  $( "#datepicker1" );
    var $datepicker2 =  $( "#datepicker2" );
	 var holiday = [];
     holiday[0] = new Date("08/15/2016");
     holiday[1] = new Date("08/17/2016");
    $datepicker1.datepicker({ dateFormat: "dd/mm/yy"});
    $datepicker2.datepicker({
    dateFormat: "dd/mm/yy",
         onClose: function() {
            var fromDate = $datepicker1.datepicker('getDate');
            var toDate = $datepicker2.datepicker('getDate');
            
			  var f = $.datepicker.formatDate('mm/dd/yy', fromDate);
			  var t = $.datepicker.formatDate('mm/dd/yy', toDate);
				var diff = new Date(toDate - fromDate);
              days = ((diff/1000/60/60/24) + 1);
			  
			  
			for (var i = 0; i < holiday.length; i++) 
				{
					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiday[i]);
					if((f == f1) || (t == f1))
					{
						alert("true");
						days = days - 1;
						 alert("For loop " + days);
					}
				}
		 
		 
		 
		 
			b = days;
			y1 = days;
			y = days - 1;
           // alert(days);
			document.getElementById("myText").value = days;
			//alert(holiday[0] + " " + fromDate);
				
			
        }
    });
});

		 */


		</script>
		
		
<script>

/* function GetHours()
{

	var starttime = document.getElementById("starttime").value;
	var endtime =  document.getElementById("endtime").value;
	var timeStart = new Date("01/01/2007 " + starttime).getHours();
	var timeEnd = new Date("01/01/2007 " + endtime).getHours();
	return parseInt ((timeEnd - timeStart)); 
	
} 
function myFunction()
{
	
	var starttime = document.getElementById("starttime").value;
	var endtime =  document.getElementById("endtime").value;
	var timeStart = new Date("01/01/2007 " + starttime).getHours();
	var timeEnd = new Date("01/01/2007 " + endtime).getHours();
	
	document.getElementById("totalhours").value = GetHours();
	
	
	if(document.getElementById("endtime"))
	{

		var starttime = document.getElementById("starttime").value;
		var endtime =  document.getElementById("endtime").value;
		var timeStart = new Date("01/01/2007 " + starttime).getHours();
		var timeEnd = new Date("01/01/2007 " + endtime).getHours();
		
		if(starttime > endtime)
		{
			document.getElementById("totalhours").value = 0;
			 document.getElementById("endtime").value = 0;	
		}

		
		if(hourDiff < 0)
		{
			 //document.getElementById("totalhours").value = 0;
			// document.getElementById("endtime").value = 0;
			document.getElementById("totalhours").value = GetHours();
		}
		else
			{
				alert("Houre Count" + hourDiff);
			 	document.getElementById("totalhours").value =GetHours();
			}
		//create date format          
	
		
	}    
   
}
 */


function diff() {

	var start = document.getElementById("starttime").value;
	var end =  document.getElementById("endtime").value;
	
    start = start.split(":");
    end = end.split(":");
    var startDate = new Date(0, 0, 0, start[0], start[1], 0);
    var endDate = new Date(0, 0, 0, end[0], end[1], 0);
    var diff = endDate.getTime() - startDate.getTime();
    var hours = Math.floor(diff / 1000 / 60 / 60);
    diff -= hours * 1000 * 60 * 60;
    var minutes = Math.floor(diff / 1000 / 60);

    // If using time pickers with 24 hours format, add the below line get exact hours
    if (hours < 0)
       hours = hours + 24;

    document.getElementById("totalhours").value = hours;

    
    return (hours <= 9 ? "0" : "") + hours + ":" + (minutes <= 9 ? "0" : "") + minutes;
}


</script>
<%
	}
	else if(request.getAttribute("leavetypeselect").equals("OD"))
	{
%>
<script type="text/javascript">

		var days;
		var y;
		var x;
		var x1;
		var b , y1;
/* 
		/* $(function() {
			  $( "#datepicker1" ).datepicker({  maxDate: 0 });
			});  */
		/* $(function() {
			  $( "#datepicker2" ).datepicker({  maxDate: 0 });
			}); */
		
$(document).ready(function()
{
    var $datepicker1 =  $( "#datepicker1" );
    var $datepicker2 =  $( "#datepicker2" );
	 var holiday = [];
     holiday[0] = new Date("08/15/2016");
     holiday[1] = new Date("08/17/2016");
     
     
     
     $datepicker1.datepicker({		
			dateFormat: 'dd/mm/yy' , 
		 	minDate: '-10', 
		 	maxDate: '+2m',
			 changeMonth: true,
			 onSelect: function(dateStr)
			 {
	            $('#datepicker2').datepicker('option', 'defaultDate', dateStr);
	           	$('#datepicker2').datepicker('option', 'minDate', dateStr);
	         	setTimeout(function()
	         			{
	           				 $( "#datepicker2").datepicker('show');
	        			}, 300); 
	        }
		});
		
		$datepicker2.datepicker({
		    dateFormat: "dd/mm/yy",
		     maxDate: '+2m',
		     changeMonth: true,
		         onClose: function() 
		         {
        	 maxDate: 0 
            var fromDate = $datepicker1.datepicker('getDate');
            var toDate = $datepicker2.datepicker('getDate');
            
			  var f = $.datepicker.formatDate('mm/dd/yy', fromDate);
			  var t = $.datepicker.formatDate('mm/dd/yy', toDate);
				var diff = new Date(toDate - fromDate);
              days = ((diff/1000/60/60/24) + 1);
			  
			  
			for (var i = 0; i < holiday.length; i++) 
				{
					 var f1 = $.datepicker.formatDate('mm/dd/yy', holiday[i]);
					if((f == f1) || (t == f1))
					{
						//alert("true");
						days = days - 1;
						// alert("For loop " + days);
					}
				}
			
		//alert(days);
		 
		 var SunDay = null;
		 currentDate = new Date(fromDate);
	     var between = [];
	    
	     while (currentDate <= toDate)
		 {
	         between.push(new Date(currentDate));
	         currentDate.setDate(currentDate.getDate() + 1);
	     }

		
	    	 for(var k = 0; k < between.length; k++)
			  {
		    	 var sundayCheck = between[k].getDay();
				if(sundayCheck == 0)
				{
					SunDay++;
				}
			}
		 
			// alert(SunDay);
			b = days;
			y1 = days;
			y = days - 1;
           // alert(days);
			document.getElementById("numdays2").value = days;
			//alert(holiday[0] + " " + fromDate);
				
        }
    });
});

</script>
<script>

function GetHours()
{

	var starttime = document.getElementById("starttime").value;
	var endtime =  document.getElementById("endtime").value;
	var timeStart = new Date("01/01/2007 " + starttime).getHours();
	var timeEnd = new Date("01/01/2007 " + endtime).getHours();
	return parseInt ((timeEnd - timeStart)); 
	
} 
function myFunction()
{
	
	var starttime = document.getElementById("starttime").value;
	var endtime =  document.getElementById("endtime").value;
	var timeStart = new Date("01/01/2007 " + starttime).getHours();
	var timeEnd = new Date("01/01/2007 " + endtime).getHours();
	
	document.getElementById("totalhours").value = GetHours();
	
	
	if(document.getElementById("endtime"))
	{

		var starttime = document.getElementById("starttime").value;
		var endtime =  document.getElementById("endtime").value;
		var timeStart = new Date("01/01/2007 " + starttime).getHours();
		var timeEnd = new Date("01/01/2007 " + endtime).getHours();
		
		if(starttime > endtime)
		{
			document.getElementById("totalhours").value = 0;
			 document.getElementById("endtime").value = 0;	
		}

		
		if(hourDiff < 0)
		{
			 //document.getElementById("totalhours").value = 0;
			// document.getElementById("endtime").value = 0;
			document.getElementById("totalhours").value = GetHours();
		}
		else
			{
				alert("Houre Count" + hourDiff);
			 	document.getElementById("totalhours").value =GetHours();
			}
		//create date format          
	
		
	}    
   
}
</script>
<%}
	else if(request.getAttribute("leavetypeselect").equals("GatePass"))
	{
	%>
	<script type="text/javascript" src="css/TimerPicker/jquery.min.js"></script>
<script type="text/javascript" src="css/TimerPicker/jquery-ui.min.js"></script>
<link href="css/TimerPicker/jquery-ui.css" rel="stylesheet">

<link href="css/timepicki.css" rel="stylesheet">

<style type="text/css">

.timepicker_wrap {
	padding: 10px;
	border-radius: 5px;
	z-index: 998;
	display: none;
	box-shadow: 2px 2px 5px 0 rgba(50,50,50,0.35);
	background: #f6f6f6;
	border: 1px solid #ccc;
	float: left;
	position: absolute;
	top: 27px;
	left: 0;
	width: 280px;
	format: 'HH:mm'; 
	showMeridian:false;
}



</style>
	
   <script src="js/timepicki1.js"></script>
 
    <script>
	$('#outTime').timepicki();
    </script> 
	
<script type="text/javascript">
	$(function() {
		$('#outTime').timepicki({
			  showMeridian : false
				});
		});
	</script>
	
	
	
	<%}}%>
	<%@include file="footer.html"%>
	<!-- BEGIN VENDOR JS-->
	<!-- build:js app-assets/js/vendors.min.js-->
	<script src="app-assets/js/core/libraries/jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/tether.min.js"
		type="text/javascript"></script>
	<script src="app-assets/js/core/libraries/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/unison.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/blockUI.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery.matchHeight-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/jquery-sliding-menu.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/sliders/slick/slick.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/ui/screenfull.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/pace.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script type="text/javascript"
		src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="app-assets/vendors/js/extensions/moment.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/underscore-min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/clndr.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/extensions/unslider-min.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN ROBUST JS-->
	<!-- build:js app-assets/js/app.min.js-->
	<script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
	<script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
	<script src="app-assets/js/scripts/ui/fullscreenSearch.min.js"
		type="text/javascript"></script>
	<!-- /build-->
	<!-- END ROBUST JS-->
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
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
   
        <script type="text/javascript">
        window.onload = function() 
        {            
          
              $('#autoUpdate1').fadeOut('slow');
              $('#autoUpdate2').fadeOut('slow');
              $('#autoUpdate3').fadeOut('slow');
              $('#autoUpdate4').fadeOut('slow');
              $('#autoUpdate5').fadeOut('slow');
              $('#autoUpdate6').fadeOut('slow');
              $('#autoUpdate7').fadeOut('slow');
              $('#autoUpdateth').fadeOut('slow');
            //  $('#radiobutton').fadeOut('slow');
        }
        </script>
</html>