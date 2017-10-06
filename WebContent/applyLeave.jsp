<%@page import="org.apache.poi.hssf.record.Margin"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.lms.bean.LeaveTypeBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.hrms.pms.bean.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.List"%>
<html>
<head>
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
	href="app-assets/css/bootstrap.min.css">
<!-- font icons-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/datetime/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/pickers/pickadate/pickadate.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END Custom CSS-->
<%@include file="header.jsp"%>
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<title>Leave Application Form</title>
<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">

<script type="text/javascript">

function redirect(value) {
	/* alert("test"); */
	window.location.replace(value);
}
</script>

<script type="text/javascript">

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

<style>
.ui-datepicker-unselectable.gesloten span.ui-state-default {
	background: #999999 !important;
	border-color: #999999 !important;
	text-decoration: line-through;
}

.ui-datepicker-unselectable.verhuurt span.ui-state-default {
	background: #FF0000 !important;
	border-color: #FF0000 !important;
	color: #FF9966 !important;
}
</style>
<script type="text/javascript">
function checkInteger(id) {
	var a = document.getElementById(id).value;
	if(isNaN(a))
	{
		alert("character not allowed");
		document.getElementById(id).value = "";
	}
	else if(a.length < 10)
		{
			alert("Plase Enter 10 Digit ");
		}
	else if(a.length > 10)
	{
		alert("only 10 Digit Allowed");
		
	}
}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns"
	onload="startTimer()">
	<%
		String under_manager_id = null;
		int dept_id = 0;
		String marrital_status = null;
		String gender = null;
		if (request.getAttribute("HR") == null) {
			employee_master_id = user.getEmployee_master_id();
			under_manager_id = user.getUnder_manager_id();
			dept_id = user.getDepartmentBean().getDepartment_id();
			marrital_status = user.getMarital_status();
			gender = user.getGender();
		} else {
			employee_master_id = (Integer) request.getAttribute("emp_id");
			under_manager_id = (String) request.getAttribute("under_manger_id");
			dept_id = (Integer) request.getAttribute("dept_id");
			marrital_status = (String) request.getAttribute("marrital_status");
			gender = (String) request.getAttribute("gender");
		}

		ArrayList<String> holiday = new ArrayList<String>();
		ArrayList<String> holidayName = new ArrayList<String>();
		ArrayList<String> holidayDate = new ArrayList<String>();
		System.out.print("Employee Master Id " + employee_master_id);
	%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<!-- <div class="row">
					<div class="col-xs-12">
						<h4>Apply Leave Form</h4>
						<hr>
					</div>
				</div> -->
				<div class="card">
					<div class="card-body collapse in">
						<div class="card-block">
							<div class="form-body">
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-primary">
											<div class="panel-heading">Leave / CO / OD Form</div>
											<div class="panel-body">

												<table class="table" style="margin-bottom: 0px;">
													<%
														if (request.getAttribute("HR") == null) {
													%>
													<thead>
														<tr>
															<td width="100px"><label>Select Form</label></td>
															<td width="10px">:</td>
															<td width="200px;"><select class="form-control"
																name="leavetypeselect" id="leavetypeselect"
																onchange="redirect(this.value);" required>
																	<option value="applyLeave.jsp" selected="selected">
																		Leave</option>
																	<option value="leaveCO.jsp">CO</option>
																	<option value="leaveOD.jsp">OD</option>
															</select></td>
															<td></td>
															<td></td>
														</tr>
													</thead>
													<%
														} else {
													%>
													<form action="specialHRLeave" method="post">
														<thead>

															<%
																if (request.getAttribute("empcode") != null) {
																		int comapny_code = Integer.parseInt(request.getParameter("companyId"));
															%>
															<tr>
																<td><label>Enter Employee Code</label></td>
																<td>:</td>
																<td><input type="text" class="form-control"
																	name="empcode" id="empcode" placeholder="Enter Code"
																	value="<%=request.getAttribute("empcode")%>" required />
																</td>
															</tr>

															<tr>
																<td><label>Select Comapny Name</label></td>
																<td>:</td>
																<td><select class="form-control" name="companyId"
																	placeholder="Select Company Name" id="companyId"
																	required="required">

																		<option value="">---Select Company Name---</option>
																		<%
																			CompanyListDAO companyListDAO = new CompanyListDAO();
																					List<CompanyListBean> listOfCompanyList = (ArrayList) companyListDAO.getListOfCompanyList();
																					for (CompanyListBean companyListBean : listOfCompanyList) {
																						if (comapny_code == companyListBean.getCompany_list_id()) {
																		%>
																		<option
																			value="<%=companyListBean.getCompany_list_id()%>"
																			selected="selected"><%=companyListBean.getCompany_name()%></option>

																		<%
																			} else {
																		%>
																		<option
																			value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
																		<%
																			}
																		%>

																		<%
																			}
																		%>
																</select>
															</tr>


															<tr>
																<td><label>Select </label></td>
																<td>:</td>
																<td><select class="form-control"
																	name="leavetypeselect" id="leavetypeselect" required>
																		<option>-- Select Form--</option>
																		<option value="Leave">Leave</option>
																		<option value="CO">CO</option>
																		<option value="OD">OD</option>
																</select></td>
															</tr>




														</thead>
														<tbody>

														<%
															} else {
														%>
														<tr>
															<td><label>Enter Employee Code</label></td>
															<td>:</td>
															<td><input type="text" class="form-control"
																name="empcode" id="empcode" placeholder="Enter Code"
																required></td>
														</tr>


														<tr>
															<td><label>Select Company Name</label></td>
															<td>:</td>
															<td><select class="form-control" name="companyId"
																placeholder="Select Company Name" id="companyId"
																required>

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
															</select></td>
														</tr>


														<tr>
															<td><label>Select </label></td>
															<td>:</td>
															<td><select class="form-control"
																name="leavetypeselect" id="leavetypeselect" required>
																	<option value="">-- Select Form--</option>
																	<option value="Leave">Leave</option>
																	<option value="CO">CO</option>
																	<option value="OD">OD</option>
															</select> <%
 	}
 %>
																<tr>
															<td colspan="3" align="center">
															<button class="btn btn-success" type="submit"
																	value="Submit">Submit</button>
															</td>
														</tr>
														</tbody>
                        </form>
                        <%
                        	}
                        %>
                        </table>
                   </div>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
		</div>     
                        
			
			<%
                             							if (request.getAttribute("LeaveExist") != null) {
                             						%>
		 		<div id="panelbody" class="panel-body">
                            <div
										class="alert alert-dismissable alert-danger">
                                <button type="button" class="close"
											data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveExist}
                            </div>
          		</div>  
          	<%
            		} else if (request.getAttribute("LeaveSuccessfully") != null) {
            	%>
			<div id="panelbody" class="panel-body">
                            <div
										class="alert alert-dismissable alert-success">
                                <button type="button" class="close"
											data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeaveSuccessfully}
                            </div>
          		</div>  
          		<%
            			} else if (request.getAttribute("LeavefromtodateExist") != null) {
            		%>
          		<div id="panelbody" class="panel-body">
                            <div
										class="alert alert-dismissable alert-danger">
                                <button type="button" class="close"
											data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${LeavefromtodateExist}
                            </div>
          		</div>
          		<%
          			}
          		%>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
						<h5 align="left">	
								Date :
								<%
							DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
							Date today = Calendar.getInstance().getTime();

							String date1 = dateFormat.format(today);

							String d = null;
							String currentdate = null;

							try {

								SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
								Date result = formater.parse(date1);
								SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
								SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
								currentdate = AppDateFormat1.format(result);
								d = AppDateFormat.format(result);
								System.out.println(AppDateFormat.format(result));
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
						%><%=d%></h5> 
						</div>
						<div class="panel-body">
						<%
							if (request.getAttribute("HR") == null) {
						%>
							<form action="leaveInsert" id="temp" method="post"
													enctype="multipart/form-data">
							<%
								} else {
							%>
							<form action="specialHRLeaveApproval" id="temp" method="post"
														enctype="multipart/form-data">
							<%
								}
							%>
								<div class="row">
									<div class="col-lg-6">
										
										<div class="row">
											<div class="col-lg-4">
												<center>
																			<label>Employee Name</label>
																		</center>
											</div>
											<!-- ./col-lg-4 -->
											<div class="col-lg-8">
											<%
												if (request.getAttribute("HR") == null) {
											%>
												<%=user.getFirstname() + " " + user.getLastname()%>
												<%
													} else {
												%>
													<%=request.getAttribute("name")%>
												<%
													}
												%>
												
											</div>
											<!-- ./col-lg-8 -->
										</div>
										<!-- ./row -->
										
										<br>
										<div class="row">
											<div class="col-lg-4">
												<center>
																			<label>Purpose Of Leave</label>
																		</center>
											</div>
											<!-- ./col-lg-4 -->
											<div class="col-lg-8">
												<textarea class="form-control" rows="6" id="purposeOfLeave"
																			name="purposeOfLeave"
																			placeholder="Enter purpose of leave" autofocus
																			required></textarea>
												
											</div>
											<!-- ./col-lg-8 -->
										</div>
										<!-- ./row -->
									</div>
									<!-- ./col-lg-6 -->
								
									<div class="col-lg-6">	
										<table class="table table-bordered">
											<tbody>
												<tr bgcolor="#C6C3C2"">
													<th colspan="2" align="center">Type Of Leave </th>
													<th colspan="6" align="left">Leave Balance (Day's)</th>
													<!-- <th colspan="5" id="autoUpdateth">Adjust Of Leave</th> -->
												</tr>
											</tbody>
											<tbody>
											<%
												AllLMSListDAO gradeMasterList1 = new AllLMSListDAO();
												List<LeaveTypeBean> listOfleave1 = gradeMasterList1.getListOfLeave();
												LeaveBalanceBean leaveBalanceBean = (LeaveBalanceBean) gradeMasterList1
														.getleaveListbyEMP(employee_master_id);

												double Co_Leave = leaveBalanceBean.getCO();

												double Plan_Leave = leaveBalanceBean.getPlan_Leave();
												double unplan_Leave = leaveBalanceBean.getUnplan_Leave();
												double lwp = leaveBalanceBean.getLeave_without_pay();
												double MT = 0;
												for (LeaveTypeBean c : listOfleave1) {
													String p = c.getLeave_name();
													if (marrital_status.equalsIgnoreCase("married") && gender.equalsIgnoreCase("female")) {
											%> 
   						 						<tr>
   						 			
				   						 			<td colspan="2">
				   						 				<%=c.getLeave_name()%>
				   						 			</td>	
			   						 				<td colspan="6">
			   						 					 	<%
			   						 					 		if (p.equalsIgnoreCase("CO")) {
			   						 					 	%>
			   						 							<%=Co_Leave%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 						<%
			   						 							if (p.equalsIgnoreCase("Plan Leave")) {
			   						 						%>
			   						 							<%=Plan_Leave%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 						<%
			   						 							if (p.equalsIgnoreCase("Unplan Leave")) {
			   						 						%>
			   						 							<%=unplan_Leave%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 						<%
			   						 							if (p.equalsIgnoreCase("Leave without pay")) {
			   						 						%>
			   						 							<%=lwp%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 						<%
			   						 							if (p.equalsIgnoreCase("Maternity Leave")) {
			   						 						%>
			   						 							<%=MT%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 				</td>	
   						 					<%
	   						 						} else if (!c.getLeave_name().equalsIgnoreCase("Maternity Leave")) {
	   						 					%>
   						 					
			   						 				<td colspan="2">
			   						 					<%=c.getLeave_name()%>
			   						 				</td>
			   						 				<td colspan="6">
			   						 					 	<%
			   						 					 		if (p.equalsIgnoreCase("CO")) {
			   						 					 	%>
			   						 							<%=Co_Leave%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 						<%
			   						 							if (p.equalsIgnoreCase("Plan Leave")) {
			   						 						%>
			   						 							<%=Plan_Leave%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 						<%
			   						 							if (p.equalsIgnoreCase("Unplan Leave")) {
			   						 						%>
			   						 							<%=unplan_Leave%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 						<%
			   						 							if (p.equalsIgnoreCase("Leave without pay")) {
			   						 						%>
			   						 							<%=lwp%>
			   						 						<%
			   						 							}
			   						 						%>
			   						 				</td>
   						 						<%
   						 							}
   						 						%>
   						 						 <%-- <td colspan="5">
   						 						 <div id="autoUpdate<%=c.getLeave_type_id()%>">
   						 							<input type="radio" id="typeOfcheckboxLeave"  name="typeOfcheckboxLeave" onchange="check1()" value="<%=c.getLeave_type_id()%>">
   						 						</div>
   						 						 </td> --%>
   						 					</tr>
   						 			
   						 			
   						 			<%
   						 			   						 			   						 				}
   						 			   						 			   						 			%>
									</tbody>
							</table>
						</div>
						<!-- ./col-lg-6 -->
							
						</div>
						<!-- ./row -->
						
								<input type="hidden" name="employee_master_id"
															value="<%=employee_master_id%>"> 
								<input type="hidden" name="Name" id="Name"
															value="<%=request.getAttribute("name")%>" />
								<input type="hidden" name="EMPCODE" id="EMPCODE"
															value="<%=request.getAttribute("empcode")%>" />
								<input type="hidden" name="CO" id="CO"
															value="<%=leaveBalanceBean.getCO()%>">
								<input type="hidden" name="plan" id="plan"
															value="<%=leaveBalanceBean.getPlan_Leave()%>">
								<input type="hidden" name="unplan" id="unplan"
															value="<%=leaveBalanceBean.getUnplan_Leave()%>" />
								<input type="hidden" name="LWP" id="LWP"
															value="<%=leaveBalanceBean.getLeave_without_pay()%>" />
								<input type="hidden" name="currentdate" id="currentdate"
															value="<%=currentdate%>" />
								<input type="hidden" name="CO1" id="CO1" value="">
								<input type="hidden" name="PL1" id="PL1" value="">
								<input type="hidden" name="SL1" id=SL1 value="">
								<input type="hidden" name="LWP1" id="LWP1" value="">
								<input type="hidden" name="pushMainDate" id="pushMainDate"
															value="" />
								<input type="hidden" name="popMainDate" id="popMainDate"
															value="" />
								<input type="hidden" name="BackwordSunday" id=BackwordSunday
															value="" />
								<input type="hidden" name="monthID" id="monthID" value="" />
								<input type="hidden" name="leavetype" id="leavetype" value="" />
								<input type="hidden" name="COCUT" id="COCUT" value="" />
								<input type="hidden" name="PLCUT" id="PLCUT" value="" />
								<input type="hidden" name="SLCUT" id=SLCUT value="" />
								<input type="hidden" name="LWPCUT" id="LWPCUT" value="" />
								<input type="hidden" name="sunday" id="sunday" value="" />
								<input type="hidden" name="holiday" id="holiday" value="" />
								
								
								<div class="row">
									<div class="col-lg-2">
										<center>
																	<label>Leave Applied For</label>
																</center>
									</div>
									<!-- ./col-lg-2 -->
									<div class="col-lg-6">
										From Date: <input type="text" id="datepicker1" width="155"
																	name="fromDate" placeholder="dd/mm/yyyy" required
																	class="form-control" readonly="readonly">
									</div>
									<!-- ./col-lg-6 -->
										<div id="radiobutton1">
												<input id="0" type="radio" name="leavefromDate" value="FF"
																	onchange="check();" required checked="checked">Full Day
												<input id="1" type="radio" name="leavefromDate" value="FH"
																	onchange="check();" required>First Half
												<input id="2" type="radio" name="leavefromDate" value="SH"
																	onchange="check();" required>Second Half
										</div>
										<input type="hidden" id="date1" value="">
									
								</div>
								<!-- ./row -->
								
								
								<br>
								<div class="row">
									<div class="col-lg-2">
									</div>
									<!-- ./col-lg-2 -->
									<div class="col-lg-6">
										To Date: <input type="text" id="datepicker2"
																	placeholder="dd/mm/yyyy" class="form-control"
																	name="toDate" required readonly="readonly">
									</div>
									<!-- ./col-lg-6 -->
										<div id="radiobutton2">
											<input id="3" type="radio" name="leavetoDate" value="FF"
																	onchange="check();" checked="checked">Full Day
											<input id="4" type="radio" name="leavetoDate" value="FH"
																	onchange="check();">First Half
											<input id="5" type="radio" name="leavetoDate" value="SH"
																	onchange="check();">Second Half
										</div>	
										<input type="hidden" id="date2" value="">
									
								</div>
								<!-- ./row -->
								
								<input type="hidden" class="textbox" id="numdays3"
															name="numdays3" value="00" />
								
								
								<br>
								<div class="row">
									<div class="col-lg-2">
										<center>
																	<label> Holidays Count </label>
																</center>
									</div>
									<!-- ./col-lg-2 -->
									<div class="col-lg-4">
										<input type="text" class="form-control" rows="3"
																	placeholder="Total of holidays " id="numdays4"
																	name="numdays4" required readonly></input>
									</div>
									<!-- ./col-lg-10 -->
									
								<!-- </div>
								./row
								
								
								<br>
								<div class="row"> -->
									<div class="col-lg-2">
										<center>
																	<label> Total Leave Day Count </label>
																</center>
									</div>
									<!-- ./col-lg-2 -->
									<div class="col-lg-4">
										<input type="text" class="form-control" rows="3"
																	placeholder="Total Days" id="numdays2" name="numdays"
																	required readonly></input>
									</div>
									<!-- ./col-lg-10 -->
									
								</div>
								<!-- ./row -->


								<br>
								<div class="row">
									<div class="col-lg-2">
																	<label> Contact Address </label>
									</div>
									<!-- ./col-lg-2 -->
									<div class="col-lg-4">
										<textarea class="form-control" id="contactAddress"
																	placeholder="Alternate Contact Address"
																	name="contactAddress" rows="2" required></textarea>
									</div>
									<!-- ./col-lg-10 -->
									
								<!-- </div>
								./row


								<br>
								<div class="row"> -->
									<div class="col-lg-3">
																	<label> Contact Number During Leave </label>
									</div>
									<!-- ./col-lg-2 -->
									<div class="col-lg-3">
										<input type="text" name="contactNumberDuringLeave"
																	placeholder="Alternate Contact Number"
																	id="contactNumberDuringLeave" class="form-control"
																	onchange="checkInteger(this.id)" required></input>
									</div>
									<!-- ./col-lg-10 -->
									
								</div>
								<!-- ./row -->
								
								
								
								<%
																																	AllLMSListDAO allLMSListDAO = new AllLMSListDAO();

																																	ManagerBean managerBean = allLMSListDAO.getnameOfManager(under_manager_id);
																																%>
								
								
								<br>
								<div class="row">
																	<div class="col-lg-2">
										<center>
																			<label> Reporting Manager </label>
																		</center>
									</div>
									<!-- ./col-lg-2 -->
									<div class="col-lg-10">
										<input type="text" class="form-control" name="Manager"
																			class="form-control" placeholder="Reporting Manager"
																			value="<%=managerBean.getManager_name()%>" required
																			readonly></input>
											<input type="hidden" name="reportingManager"
																			value="<%=under_manager_id%>">
									</div>
									<!-- ./col-lg-10 -->
									
								</div>
								<!-- ./row -->
								
								
								<input type="hidden" name="redirect">
								<input type="hidden" name="Mailredirect">
								
								
								
								
								<br>
								<center>
												<button class="btn btn-success" id="btnsubmit" type="button"
																		value="Submit" onclick="myFunction()">Submit</button>
										</center>
								
								<%
																	AllLMSListDAO allListDAO2 = new AllLMSListDAO();
																	List<HolidayBean> listgholiday = allListDAO2.getListOfHoliday();
																	for (HolidayBean h : listgholiday) {
																		/* SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
																		Date result = formater.parse(h.getHoliday_date());
																		System.out.println(result.toString()); */

																		String date = h.getHoliday_date();
																		String Name = h.getHoliday_name();
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
																			holidayName.add(Name);
																		} catch (ParseException e1) {
																			e1.printStackTrace();
																		}

																	}
																%>
								<%-- <%=holidayDate%> --%>
								
							
														</form>
						
											</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			
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
	<script
		src="app-assets/vendors/js/pickers/dateTime/moment-with-locales.min.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/picker.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/picker.date.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/picker.time.js"
		type="text/javascript"></script>
	<script src="app-assets/vendors/js/pickers/pickadate/legacy.js"
		type="text/javascript"></script>
	<script
		src="app-assets/vendors/js/pickers/daterange/daterangepicker.js"
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
	<script
		src="app-assets/js/scripts/pickers/dateTime/picker-date-time.min.js"
		type="text/javascript"></script>

	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<!-- END PAGE LEVEL JS-->
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script', 'www.google-analytics.com/analytics.js',
				'ga');

		ga('create', 'UA-96096445-1', 'auto');
		ga('send', 'pageview');
	</script>
	
	<script>
			//$(function() {
			//	$( ".datepicker" ).datepicker();
			//});
			
			
			/* if (!$.datepicker.initialized)
			{
    			$(document).mousedown($.datepicker._checkExternalClick);
    			$.datepicker.initialized = true;
			}
			 */
			
			$(document).ready(function()
			{
				
				var $datepicker1 =  $( "#datepicker1" );
			    var $datepicker2 =  $( "#datepicker2" );
				
			    /* $("#datepicker1").datepicker({  dateFormat: 'dd/mm/yy'});
		    	$("#datepicker2").datepicker({ dateFormat: 'dd/mm/yy' }); */
			  var holiDates = [];
		    	var tool = [];
		    var disableddates =[];
		    
		    
		    <%for (int k = 0; k < holidayName.size(); k++) {
				String Name = holidayName.get(k);%>
	 				
	 				tool[<%=k%>] = ("\"<%=Name%>\"");
	   		  		
	   		  <%}%>
		    
	 		<%for (int i = 0; i < holiday.size(); i++) {
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
	   	 	<%for (int z = 0; z < holidayDate.size(); z++) {
				String datedate = holidayDate.get(z);%>
	 				disableddates.push("<%=datedate%>");
	   		  <%}%>
	   		  
	   		  
	   		  
	   		  <%int role_id = dept_id;
			if (role_id == 1) {%>
				   		function noSundaynoHoliday(date)
				   		{
				   			// SUNDAY DISABLE //
				   		    var day = date.getDay();
				   		    if ($.inArray(day, daysToDisable) != -1) {
				   		        return [false];
				   		    } 
				
				   				// HOLIDAYS DISABLE //
				   			 	 var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
				   			 var tooltipDate = "This date is holiday!";
				   				if(disableddates.indexOf(string) != -1)
				   				{
				   					return [false,'verhuurt', tooltipDate];
				   				} 
				   				
				   			// 1ND AND 3TH SAT DISABLE //
				   			/* var tooltipDate1 = "This Day Holiday For Software Department Only!";
				   				 var day = date.getDay(),
				   		        week = Math.floor(date.getDate() / 7);
				   				if(day == 6 && (week == 0 || week == 2))
				   				{
				   					return [false ,'',  tooltipDate1];
				   				}   */
				   		    //return day == 6 && (week == 1 || week == 3)
						
				   		    return [true]
				   		}
	   		<%} else {%>
	   		function noSundaynoHoliday(date)
	   		{
	   			// SUNDAY DISABLE //
	   		    var day = date.getDay();
	   		    if ($.inArray(day, daysToDisable) != -1) {
	   		        return [false];
	   		    } 

	   				// HOLIDAYS DISABLE //
	   			 	var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
	   			 var tooltipDate = "This date is holiday!";
	   				if(disableddates.indexOf(string) != -1)
	   				{
	   					return [false,'verhuurt', tooltipDate];
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
	   		 	maxDate: '+10m',
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
	   	        }
	   		});
	   		
			$datepicker2.datepicker({
			     dateFormat: "dd/mm/yy",
			     maxDate: '+10m',
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
			 			days = (diff / 1000 / 60 / 60 / 24 + 1);
			 		
			            var diff1 = new Date(fromDate - CD);
			            var maindiff = (diff1 / 1000 /60 / 60 /24 + 1);
			          
			           if(maindiff >= 7)
			        	   {
			  
			        	   		document.getElementById("leavetype").value = "PLAN LEAVE";
			        	   }
			           else
			        	   {
			        	   		//alert("UNPLAN LEAVE");
			        	   		document.getElementById("leavetype").value = "UNPLAN LEAVE";
			        	   }
			            
			           
			          
			           
			           
			           // Sendwtich Ruls //
			           	var backDate = new Date(fromDate);
		 				var MonDate = new Date(toDate);
		 				
						backDate.setDate(backDate.getDate());
						MonDate.setDate(MonDate.getDate()); 
						 
						if((backDate.getDay() == 6 || MonDate.getDay() == 1) || MonDate.getDay() == 6 || backDate.getDay() == 1)
						{
							 document.getElementById("sunday").value = "TRUE"; 
						}
						else
					    {
							document.getElementById("sunday").value = "FALSE";
					    }
						
						  
						  for (var i = 0; i < holiDates.length; i++) 
			 				{
			 					 var qwerty = $.datepicker.formatDate('mm/dd/yy', holiDates[i]);
			 					 var abcdef = new Date(qwerty);
			 					 var ghijk = new Date(qwerty);
			 					abcdef.setDate(abcdef.getDate() + 1);
			 					ghijk.setDate(ghijk.getDate() -1);
			 					/* alert("Holiday Next Day" + abcdef + " " + ghijk ) */
			 					 
			 					if(abcdef.getDay() == 0)
			 						{
			 						 	//alert("POP Day is ");
			 						 	abcdef.setDate(abcdef.getDate() + 1);
			 						}
			 					if(ghijk.getDay() == 0)
			 						{
			 							//alert("PUSH Day is ");
			 							ghijk.setDate(ghijk.getDate() -1);
			 						}
			 					
			 					 var q = $.datepicker.formatDate('dd/mm/yy', abcdef);
					 			 var w = $.datepicker.formatDate('dd/mm/yy', ghijk);
					 			/* alert("Final Day " + q + " " + w); */
			 				}
						  
						  
			           var HodidaysCount = 0;
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
					 
					// alert("dayChecker:"+dayChecker);
					 
					 
						var frontDate1 = new Date(fromDate);
					  if(dayChecker == false){ 
						  loop = true;
						 // alert("frontDate1:"+frontDate1);
						  //alert("between:"+between.length);
					  for(var f = 1;f < between.length ; f++){
						 // alert("frontDate1:"+frontDate1);
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
							 //alert("sunday:"+frontDate1);
							 if(loop == false){
								 if(frontDate1.getDay() == 0){
									 frontCount++
									
								 }
							 }
						  }
						 }
					  }
					  
					/*  alert("frontCount:"+frontCount);
					 alert(frontMinus);
					 alert(backMinus); */
					    
					  
					 var frontDate11 = new Date(fromDate);
					 var backDate11 = new Date(toDate);
					 
					 frontDate11.setDate(frontDate11.getDate() + 1);	
					 var k333 = $.datepicker.formatDate('mm/dd/yy', frontDate11);
					 
					 backDate11.setDate(backDate11.getDate() - 1);
					 var k3333 = $.datepicker.formatDate('mm/dd/yy', backDate11);
					 
					 document.getElementById("holiday").value = "FALSE";
					 
					 for (var ff11 = 0; ff11 < holiDates.length; ff11++) 
				 				{ 
				 					 var ff111 = $.datepicker.formatDate('mm/dd/yy', holiDates[ff11]);
				 					 if(k333 == ff111)
				 					 {
				 						document.getElementById("holiday").value = "TRUE";
				 						 
				 					 }
				 					 
				 					if(k3333 == ff111)
				 					{
				 						document.getElementById("holiday").value = "TRUE";
				 					}
				 					
								 }
							 
					     
					 
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
					         
					         for(var aaaaa = 0 ; aaaaa < 100 ; aaaaa++)
					         {
					        	  var cc = $.datepicker.formatDate('mm/dd/yy', pushDate);
					        	  if(pushCheck == true)
					        	  { 
						        		pushCheck = false;
					         			for(var aa = 0; aa < holiDates.length; aa++) 
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
							  $('#radiobutton2').fadeIn('slow');
							  
						}
						else
							{
								document.getElementById('0').checked = true;
								$('#radiobutton1').fadeIn('slow');
								$('#radiobutton2').fadeIn('slow');
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

				 document.getElementById("typeOfcheckboxLeave").checked = false;
			}		
			
		
		</script>
		 <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
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
              $('#radiobutton1').fadeOut('slow');
              $('#radiobutton2').fadeOut('slow');
            //  $('#radiobutton').fadeOut('slow');
        }
        </script>
	
</body>
</html>	
</body>
</html>