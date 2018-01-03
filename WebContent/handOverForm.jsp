<%@page import="com.hrms.exitformality.bean.DetailsOfHandOverFormBean"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.pms.bean.ProjectMasterBean"%>
<%@page import="com.hrms.pms.bean.ProjectDesignInputsBean"%>
<%@page import="com.hrms.pms.bean.ProjectDesignHeadBean"%>
<%@page import="com.hrms.pms.bean.DesignInputsBean"%>
<%@page import="com.hrms.pms.bean.PriorityBean"%>
<%@page import="com.hrms.pms.bean.CurrencyBean"%>
<%@page import="com.hrms.pms.bean.ClientMasterBean"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HandOver Form</title>
<%@include file="header.jsp"%>
 <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/selects/select2.min.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <!-- END Custom CSS-->

<script type="text/javascript">
function getResponse(value){
	  
	$("#"+value).fadeIn('slow');	
			} 


function autoInsert(){
	
	alert("In Misc You don't need to enter cost or resources its by default 0. and you select date as a financial year..")
	
	document.getElementById('cost').value= 0;
	document.getElementById('resources').value= 0;
	
}


function demo() {
	
	alert("akash");
	var minutes = 1000*60;
	var hours = minutes*60;
	var days = hours*24;
	
	var start = document.getElementById('plannedStartDate').value;
	var end = document.getElementById('plannedEndDate').value;
	
	alert(start);
	alert(end);
	
	var foo_date1 = getDateFromFormat(start, "M/d/y");
	var foo_date2 = getDateFromFormat(end , "M/d/y");

	var diff_date = Math.round((foo_date2 - foo_date1)/days);
	alert("Diff date is: " + diff_date );
}

function days_between() {

	var date1 = document.getElementById('plannedStartDate').value;
	var date2 = document.getElementById('plannedEndDate').value;

	if(date1>date2){
		alert("start date is not greater than end date");
		document.getElementById('plannedStartDate').value = 00-00-0000;
		document.getElementById('plannedEndDate').value = 00-00-0000;
		
	}else{
	
		function getBusinessDatesCount(startDate, endDate) {
		    var count = 0;
		    var curDate = startDate;
		    while (curDate <= endDate) {
		        var dayOfWeek = curDate.getDay();
		        if(!((dayOfWeek == 8) || (dayOfWeek == 0)))
		           count++;
		        curDate.setDate(curDate.getDate() + 1);
		    }
		    return count;
		}


		//Usage

		var startDate = new Date(date1);
		var endDate = new Date(date2);
		var numOfDates = getBusinessDatesCount(startDate,endDate);
	var a = document.getElementById('duration');
	a.value= numOfDates+" day(s)";
}
	}
	
function checkedstartDate() {
	
	var a = document.getElementById('start_date');
	var b = document.getElementById('plannedStartDate');
	var c = document.getElementById('plannedEndDate');
		c.value = b.value;
}

function checkInteger(id) {
	
	if(isNaN(id)){
		alert("not valid");
		document.getElementById('resources').value = 1;
	}else{
		if(id == 0){
			alert("task must conatin 1 resource")
			document.getElementById('resources').value = 1;
		}
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
        $('#plannedStartDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#plannedEndDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}
</script>


<script type="text/javascript">
function unchecked(id) {
	
	
	if(id==1){
	document.getElementById("bill").value=0;
	}else if(id==2){
		document.getElementById("employeeCost").value="";
		document.getElementById("managerCost").value="";
		document.getElementById("leaderCost").value="";
		
	}else if(id==3){
		document.getElementById("bill").value=0;
		/* document.getElementById("employeeCost").value="";
		document.getElementById("managerCost").value="";
		document.getElementById("leaderCost").value=""; */
		
		 var radios = document.getElementsByName("rdbBillType");

	     for (var i = 0, len = radios.length; i < len; i++) {
	        	  document.getElementById("rdbBillType").checked = false;
	     }
	}
}


function hideMessage()
{
	//document.getElementById("panelbody").style.display="none"; 
	 $('#panelbody').fadeOut('slow');
}

	function startTimer()
	 {
			var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
	 }
</script>	

<script type="text/javascript">



function addRow(tableID) {

	var table = document.getElementById(tableID);

	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);

	var colCount = table.rows[0].cells.length;

	for(var i=0; i<colCount; i++) {

		var newcell	= row.insertCell(i);
		
		if(i == 0){
			newcell.innerHTML = count + 1;
			count++;
		}else{
		newcell.innerHTML = table.rows[0].cells[i].innerHTML;
		//alert(newcell.childNodes);
		switch(newcell.childNodes[0].type) {
			case "text":
					newcell.childNodes[0].value = "";
					break;
			case "checkbox":
					newcell.childNodes[0].checked = false;
					break;
			case "select-one":
					newcell.childNodes[0].selectedIndex = 0;
					break;
		}
		}
	}
}
	
function addColumn() {
    var row = document.getElementById("myRow");
    var x = row.insertCell(3);
    x.innerHTML = "New cell";
}



</script>
<style>
.form-control1 {
  display: block;
  width: 270px;
  height: 30px ;
  }
</style>




<script type="text/javascript">


/* function EnableDisableTextBox(chkOther) {
	var txtSpecific = document.getElementById("specificPurpose");
	txtSpecific.disabled = purpose.checked ? false : true;
	
}	 */	



function test(id) {
	
	if(id == 1){
		document.getElementById("specificPurpose").disabled = false;
	}else if(id == 2){
		document.getElementById("specificPurpose").disabled = true;
	}
}

</script>




</head>

<body onload="startTimer()"> 


<%
AllListExitFormalityDAO allListExitFormalityDAO = new AllListExitFormalityDAO();

%>
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
			<section id="file-export">
    			<div class="row">
        			<div class="col-xs-12">
            			<div class="card">
                			<div class="card-header">
					        		<div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            		<div class="col-sm-6">
				               				<h4 class="card-title" id="horz-layout-basic">Exit Interview Form</h4>
				                		</div>
				            		</div>

      					<div class="card">
	      					 <div class="card-body collapse in">
	  							<div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
									<div class="form-body">
			<div class="row">
				<div class="col-lg-12" align="right">
				<%
				int company_id = user.getCompanyListBean().getCompany_list_id();
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
					src="img/COSMOS.png" width="170px" height="70px">
				<%} else if (company_id == 5) {%>
					<img alt="logo"
					src="img/CS.png" width="170px" height="70px">
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
					<h3 align="Center" style="margin-bottom: 20px; margin-top: 0px;">Hand Over Form</h3>
				</div>
				<!-- /.col-md-12 -->
			</div>
			<!-- /.row -->
			
			<div class="panel panel-default">
				<div class="panel-body">
					
							
							<br>
							<%if(request.getAttribute("hand_over_form_detail_id") != null){ %>
							<form action="handOverFormDetail" method="post" enctype="multipart/form-data">
							<input type="hidden" name="hand_over_form_detail_id" value="<%=request.getAttribute("hand_over_form_detail_id")%>">
							<%
								int hand_over_detail_id = (Integer)  request.getAttribute("hand_over_form_detail_id");
								DetailsOfHandOverFormBean detailsOfHandOverFormBean = allListExitFormalityDAO.getDetailOfHandOverById(hand_over_detail_id);
							%>
							
								<div class="row">
									<div class="col-md-12">
										<div class="table-responsive">
											<table class="table">
												<thead>
													<tr>
														<th colspan="2" style="background-color: #e7e7e7;">Hand Over From</th>
														<th colspan="2" style="background-color: #e7e7e7;">Hand Over To</th>
													</tr>
												</thead>
												
												<tbody>
													<tr>
														<th>Name</th>
														<th><label><%=detailsOfHandOverFormBean.getHand_over_from_name()%></label></th>
														<th>Name</th>
														<th><% 
															List<EmployeeBean> listOfAllEmployee = allListExitFormalityDAO.getListOfAllEmployee();
															for(EmployeeBean e  : listOfAllEmployee){
																if(e.getEmployee_master_id() == detailsOfHandOverFormBean.getHand_over_to_name()){
																%>
																	<label><%=e.getFirstname()+" "+e.getLastname()%></label>
																<%} %>
															<%} %>
														</th>
													</tr>
													
													<tr>
														<th>Designation</th>
														<th><label><%=detailsOfHandOverFormBean.getHand_over_from_designation()%></label></th>
														<th>Designation</th>
														<th><% 
															List<RoleBean> listOfAllRole = allListExitFormalityDAO.getListOfAllRoles();
															for(RoleBean r  : listOfAllRole){
															if(r.getRole_id() == detailsOfHandOverFormBean.getHand_over_to_designation()){
																%>
																	<label><%=r.getRole_type()%></label>
																<%} %>
															<%} %>
														</th>
													</tr>
													
													<tr>
														<th>Department</th>
														<th><label><%=detailsOfHandOverFormBean.getHand_over_from_department()%></label></th>
														<th>Department</th>
														<th><% 
														List<DepartmentBean> listOfAllDepartment = allListExitFormalityDAO.getListOfAllDepartment();
														for(DepartmentBean d  : listOfAllDepartment){
															if(d.getDepartment_id() == detailsOfHandOverFormBean.getHand_over_to_department()){
																%>
																	<label><%=d.getDepartment_name()%></label>
																<%} %>
														<%} %>
														</th>
													</tr>
													
												</tbody>
											</table>
										
										</div>
									
									</div>
								
									
								</div>
								<!-- /.row -->
							  <br>
								<div class="row">
									<div class="col-md-2">
										<b>Purpose Of Hand Over:</b>
									</div>
									
									<%String purpose = detailsOfHandOverFormBean.getPurpose_of_hand_over(); %>
									
									<div class="col-md-2">
										Annual Leave &nbsp;&nbsp;
										<%if(purpose.equalsIgnoreCase("Annual Leave")){ %>
											<input type="radio" name="purpose" value="Annual Leave" checked="checked" disabled="disabled">
										<%}else{ %>
											<input type="radio" name="purpose" value="Annual Leave" disabled="disabled">
										<%} %>
										
									</div>
									<div class="col-md-2">
										Business Travel &nbsp;&nbsp;
										
										<%if(purpose.equalsIgnoreCase("Business Travel")){ %>
											<input type="radio" name="purpose" value="Business Travel" checked="checked" disabled="disabled">
										<%}else{ %>
											<input type="radio" name="purpose" value="Business Travel" disabled="disabled">
										<%} %>
										
										
									</div>
									<div class="col-md-2">
										Resignation &nbsp;&nbsp;
										
										<%if(purpose.equalsIgnoreCase("Resignation")){ %>
											<input type="radio" name="purpose" value="Resignation" checked="checked" disabled="disabled">
										<%}else{ %>
											<input type="radio" name="purpose" value="Resignation" disabled="disabled">
										<%} %>
										
										
									</div>
									<div class="col-md-2">
										Other &nbsp;&nbsp;
										
										<%if(purpose.equalsIgnoreCase("Other")){ %>
											<input type="radio" name="purpose" id="other" value="Other" onchange="disabled(1)" checked="checked" disabled="disabled">
										<%}else{ %>
											<input type="radio" name="purpose" id="other" value="Other" onchange="disabled(1)" disabled="disabled">
										<%} %>
										
										
									</div>
										
								</div>
							
								<br>
								<div class="row">
									<div class="col-md-1" style="padding-right: 0px;">
										<label>Specify : </label>
									</div>
									<div class="col-md-11" style="padding-left: 0px; padding-right: 52px;">
									<%if(detailsOfHandOverFormBean.getSpecific_purpose_of_hand_over().equalsIgnoreCase("null")){ %>
										<input type="text" class="form-control" id="specificPurpose" name="specificPurpose" value="-" disabled="disabled">
									<%}else{ %>
										<input type="text" class="form-control" id="specificPurpose" name="specificPurpose" value="<%=detailsOfHandOverFormBean.getSpecific_purpose_of_hand_over() %>" disabled="disabled">
									<%} %>
									</div>
								</div>
							
							
							
							
							<%}else{ %>
							<form action="detailsOfHandOverInsert" method="post" enctype="multipart/form-data">
							<div class="row">
						<div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
						
							<div class="row">
								<div class="col-md-11 col-lg-11 col-sm-12 col-xs-12" style="background-color: #e7e7e7;">
									<b>Hand Over From</b>
								</div>
							</div>	
							
							<br>
							<div class="row">
								<div class="col-md-3" style="padding-right: 0px;">
									<label>Name : </label>
								</div>
								<div class="col-md-8" style="padding-left: 0px;">
									<input type="text" class="form-control" value="<%=user.getFirstname()+" "+user.getLastname() %>" name="handOverFromName">
								</div> 
							</div>
							
							<br>
							<div class="row">
								<div class="col-md-3" style="padding-right: 0px;">
									<label>Designation : </label>
								</div>
								<div class="col-md-8" style="padding-left: 0px;">
									<input type="text" class="form-control" value="<%=user.getRoleBean().getRole_type() %>" name="handOverFromDesignation">
								</div> 
							</div>
							
							<br>
							<div class="row">
								<div class="col-md-3" style="padding-right: 0px;">
									<label>Department : </label>
								</div>
								<div class="col-md-8" style="padding-left: 0px;">
									<input type="text" class="form-control" value="<%=user.getDepartmentBean().getDepartment_name() %>" name="handOverFromDepartment">
								</div> 
							</div>
							
							
						</div>
						<!-- /.col-md-6 -->
						<div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
							
							<div class="row">
								<div class="col-md-11 col-lg-11 col-sm-12 col-xs-12" style="background-color: #e7e7e7;">
									<b>Hand Over To</b>
								</div>
							</div>
							
							<br>
							<div class="row">
								<div class="col-md-3" style="padding-right: 0px;">
									<label>Name : </label>
								</div>
								<div class="col-md-8" style="padding-left: 0px;">
		                         <select class="select2-language form-control" id="select2-language" name="handOverToName"> 
		                       
										<option value="">---Select Name---</option>
											  <%
			  				 		AllListDAO allListDAO = new AllListDAO();
			  				 		List<EmployeeBean> listOfEmployee = allListDAO.getFullListOfEmployee();
			  				 		for(EmployeeBean e : listOfEmployee){
			  				 		%>
										<option value="<%=e.getEmployee_master_id()%>"><%=e.getEmployee_code()+","+e.getFirstname()+" "+e.getLastname()%></option>
									
											<%} %>
									</select>
								</div> 
							</div>
							
							<br>
							<div class="row">
								<div class="col-md-3" style="padding-right: 0px;">
									<label>Designation : </label>
								</div>
								<div class="col-md-8" style="padding-left: 0px;">
									<select class="select2-language form-control" id="select2-language" name="handOverToDesignation"> 
										<option value="">---Select Designation---</option>
											<% 
											List<RoleBean> listOfAllRole = allListExitFormalityDAO.getListOfAllRoles();
											for(RoleBean r  : listOfAllRole){
											%>
										<option value="<%=r.getRole_id()%>"><%=r.getRole_type()%></option>
									
											<%} %>
									</select>
									
								</div> 
							</div>
							
							<br>
							<div class="row">
								<div class="col-md-3" style="padding-right: 0px;">
									<label>Department : </label>
								</div>
								<div class="col-md-8" style="padding-left: 0px;">
									
									<select class="select2-language form-control" id="select2-language" name="handOverToDepartment"> 
										<option value="">---Select Department---</option>
											<% 
											List<DepartmentBean> listOfAllDepartment = allListExitFormalityDAO.getListOfAllDepartment();
											for(DepartmentBean d  : listOfAllDepartment){
											%>
										<option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name()%></option>
									
											<%} %>
									</select>
									
									
								</div> 
							</div>
						
						</div>
						<!-- /.col-md-6 -->
						
					</div>
					<!-- /.row -->
				  <br>
					<div class="row">
						<div class="col-md-2">
							<label>Purpose Of Hand Over:</label>
						</div>
						<div class="col-md-2">
							Annual Leave &nbsp;&nbsp;<input type="radio" name="purpose" value="Annual Leave" onclick="test(2)">
						</div>
						<div class="col-md-2">
							Business Travel &nbsp;&nbsp;<input type="radio" name="purpose" value="Business Travel" onclick="test(2)">
						</div>
						<div class="col-md-2">
							Resignation &nbsp;&nbsp;<input type="radio" name="purpose" value="Resignation" onclick="test(2)">
						</div>
						<div class="col-md-2">
							Other &nbsp;&nbsp;<input type="radio" name="purpose" id="purpose" value="Other" onclick="test(1)">
						</div>
							
					</div>
				
					<br>
					<div class="row">
						<div class="col-md-1" style="padding-right: 0px;">
							<label>Specify : </label>
						</div>
						<div class="col-md-11" style="padding-left: 0px; padding-right: 52px;">
							<input type="text" class="form-control" id="specificPurpose" name="specificPurpose" disabled="disabled">
						</div>
					</div>
					<input type="hidden" name="handOverDetailInsert" > 
							
							<%} %>
							
				
					
					<br>
			
			<%if(request.getAttribute("hand_over_form_detail_id") != null){%>
					<div class="row" style="background-color: #e7e7e7; padding-top: 4px; padding-bottom: 4px;">
						<div class="col-md-8" style="background-color: #e7e7e7; padding-top: 4px;">
							<label>Handover Detail</label>
						</div>
						<!-- /.col-md-8 -->
						<div class="col-md-4" align="right">
							<i class="icon icon-ios-plus" id="irow" style="cursor: pointer;font-size: 30px;"></i>
							<!-- <i class="fa fa-plus-circle fa-2x"></i> -->
						</div>
						<!-- /.col-md-4 -->
					</div>
					<!-- /.row -->
					
					<br>
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
							<input type="hidden" id="row" placeholder="Enter Item Name" value="2" />
								<table class="table" border="1" id="mtable">
								<thead>
								<tr>
									<th style="width: 50px;"><center>Sr. No</center></th>
									<th><center>Details of Responsibilities Handed Over (Details of Important Tasks)</center></th>
									<th>Status</th>
								</tr>
								</thead>
								
								<tbody>
								<tr>
									<td>1</td>
									<td><textarea name="responsibility" class="form-control" placeholder="Max. 500 words" style="resize: none;"></textarea></td>
									<td><textarea name="responsibilityStatus" class="form-control" placeholder="Max. 500 words" style="resize: none;"></textarea></td>
									<input type="hidden" name="responsibilityInsert" id="" >
								
								</tr>
								</tbody>
							</table>
							<!-- /table -->
							
							
							
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.col-md-12 -->
					
					</div>
					<!-- /.row -->
					
					
					
					
					<div class="row" style="background-color: #e7e7e7; padding-top: 4px; padding-bottom: 4px;">
						<div class="col-md-8" style="background-color: #e7e7e7; padding-top: 4px;">
							<label>Hand Over From</label>
						</div>
						<!-- /.col-md-8 -->
						<div class="col-md-4" align="right">
							<i class="icon icon-ios-plus" id="irow1" style="cursor: pointer;font-size: 30px;"></i>
							<!-- <i class="fa fa-plus-circle fa-2x"></i> -->
						</div>
						<!-- /.col-md-4 -->
					</div>
					<!-- /.row -->
					
					<br>
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
							<input type="hidden" id="row1" placeholder="Enter Item Name" value="2" />
								<table class="table" border="1" id="mtable1">
								<thead>
								<tr>
									<th style="width: 50px;"><center>Sr. No</center></th>
									<th><center>Details of important matters pending.<p class="help-block">(Correspondence, short note of the present status and future course of action)</p></center></th>
									<th><center>Status</center></th>
								</tr>
								</thead>
								
								<tbody>
								<tr>
									<td>1</td>
									<td><textarea name="pendingMatters" class="form-control" placeholder="Max. 500 words" style="resize: none;"></textarea></td>
									<td><textarea name="pendingMattersStatus" class="form-control" placeholder="Max. 500 words" style="resize: none;"></textarea></td>
									<input type="hidden" name="pendingMattersInsert" id="" >
								</tr>
								</tbody>
							</table>
							<!-- /table -->
							
							
							
							</div>
							<!-- /.table-responsive -->
							
							
							
							<br>
							
							
							
							<div class="row">
								
								<div class="col-md-12" align="right">
									<i class="icon icon-ios-plus" id="irow2" style="cursor: pointer;font-size: 30px;"></i>
									<!-- <i class="fa fa-plus-circle fa-2x"></i> -->
								</div>
								<!-- /.col-md-4 -->
							</div>
							<!-- /.row -->
							
							<div class="table-responsive">
							<input type="hidden" id="row2" placeholder="Enter Item Name" value="2" />
								<table class="table" border="1" id="mtable2">
								<thead>
								<tr>
									<th style="width: 50px;"><center>Sr. No</center></th>
									<th><center>Details of Files /Keys /Other Material Handed Over</center></th>
									<th>Status</th>
								</tr>
								</thead>
								
								<tbody>
								<tr>
									<td>1</td>
									<td><textarea name="material" class="form-control" placeholder="Max. 500 words" style="resize: none;"></textarea></td>
									<td><textarea name="materialStatus" class="form-control" placeholder="Max. 500 words" style="resize: none;"></textarea></td>
									<input type="hidden" name="materialInsert" id="" >
								</tr>
								</tbody>
							</table>
							<!-- /table -->
							
							
							
							</div>
							<!-- /.table-responsive -->
							
							
						</div>
						<!-- /.col-md-12 -->
					
					</div>
					<!-- /.row -->
					
					
					<!-- <div class="row">
						<div class="col-md-12">
							<p>Certified that I have fully understood the job assignments/processes and have taken over all the relevant documents / files / source codes, etc from Mr.___________________ and am in a position to handle above assignments without any assistance.</p>
						</div>
					</div> -->
					<input type="hidden" name="approvalInsert">
					<%} %>
					<center>
						<input type="submit" class="btn btn-primary" name="submit" value="SUBMIT">
					</center>
					
					</form>
					
					</div>
					<!-- /.panel-body -->
					
				</div>
				<!-- /.panel panel-default -->
		</div>
		<!-- /.page-wrapper -->
		
</div>
<!-- /.wrapper -->
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
    <script src="app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/forms/select/form-select2.min.js" type="text/javascript"></script>
     <script src="app-assets/js/scripts/extensions/sweet-alerts.min.js" type="text/javascript"></script>
     <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
    
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <!-- END PAGE LEVEL JS-->
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
			for(var a = 1;a<=39;a++){
			$("#"+a).fadeOut('slow');
			}
		});
	</script>

	<script>
	
	var count = 2;
	
	$('#irow').click(function(){
	    if($('#row').val()){
	        $('#mtable tbody').append($("#mtable tbody tr:last").clone());
	        $('#mtable tbody tr:last :checkbox').attr('checked',false);
	        $('#mtable tbody tr:last td:first').html($('#row').val());
	        count++;
	        document.getElementById("row").value=count;
	    }else{alert('Enter Text');}
	});
	
	
	var count1 = 2;
	$('#irow1').click(function(){
	    if($('#row1').val()){
	        $('#mtable1 tbody').append($("#mtable1 tbody tr:last").clone());
	        $('#mtable1 tbody tr:last :checkbox').attr('checked',false);
	        $('#mtable1 tbody tr:last td:first').html($('#row1').val());
	        count1++;
	        document.getElementById("row1").value=count1;
	    }else{alert('Enter Text');}
	});
	
	
	
	var count2 = 2;
	$('#irow2').click(function(){
	    if($('#row2').val()){
	        $('#mtable2 tbody').append($("#mtable2 tbody tr:last").clone());
	        $('#mtable2 tbody tr:last :checkbox').attr('checked',false);
	        $('#mtable2 tbody tr:last td:first').html($('#row2').val());
	        count2++;
	        document.getElementById("row2").value=count1;
	    }else{alert('Enter Text');}
	});
	
	
	
	$('#icol').click(function(){
	    if($('#col').val()){
	    	var a = $('#col').val();
	        $('#mtable tr').append($("<td>"));
	        $('#mtable thead tr>td:last').html($('<input type=\'text\' value='+a+' name=\'headCol'+colCount+'\'>'));
	        $('#mtable tbody tr').each(function(){$(this).children('td:last').append($('<textarea class=\'form-control\' name=\'remarks'+colCount+'\' placeholder=\'Max. 500 words\' style=\'resize: none;\'>'))});
	        colCount++;
	    }else{alert('Enter Text');}
	});
	
	
	/*  $("#subm").click(function(e){
	        if($(".chkemployee:checked").length == 0){
				alert("Please select atlest one Manager");           
	        	e.preventDefault();
	        }
	    	}); */
	</script>
</body>
</html>
