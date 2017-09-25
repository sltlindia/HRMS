<%@page import="java.text.ParseException"%>
<%@page import="java.util.ListResourceBundle"%>
<%@page import="com.hrms.exitformality.bean.HandOverApprovalBean"%>
<%@page import="com.hrms.exitformality.bean.DetailsOfMaterialBean"%>
<%@page import="com.hrms.exitformality.bean.DetailsOfResponsibilitiesBean"%>
<%@page import="com.hrms.exitformality.bean.DetailsOfPendingMattersBean"%>
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
<title>Insert title here</title>
<%@include file="header.jsp"%>

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


function EnableDisableTextBox(chkOther) {
	var txtSpecific = document.getElementById("specificPurpose");
	txtSpecific.disabled = purpose.checked ? false : true;
	
}		


</script>




</head>

<body onload="startTimer()"> 


<%
AllListExitFormalityDAO allListExitFormalityDAO = new AllListExitFormalityDAO();
%>

<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12" align="right">
					<%
						int hand_over_detail_id = Integer.parseInt(request.getParameter("hand_over_form_detail_id"));
						DetailsOfHandOverFormBean detailsOfHandOverFormBean = allListExitFormalityDAO.getDetailOfHandOverById(hand_over_detail_id);
					
						int company_id  = detailsOfHandOverFormBean.getEmployeeBean().getCompanyListBean().getCompany_list_id();
				
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
			<%-- <div class="row">
				<div class="col-lg-12" align="right">
				<%
				int company_id = user.getCompanyListBean().getCompany_list_id();
				String company_name = null;
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
			</div> --%>
			
				<div class="col-lg-12">
					<h3 align="Center" style="margin-bottom: 20px; margin-top: 0px;">Hand Over Form</h3>
				</div>
				
				<!-- /.col-md-12 -->
			</div>
			<!-- /.row -->
			
			<div class="panel panel-default">
				<div class="panel-body">
					
							
							<br>
							<form action="handOverApprovalStatus" method="post">
							
							<input type="hidden" name="hand_over_form_detail_id" value="<%=request.getParameter("hand_over_form_detail_id")%>">
							
							
								<div class="row">
									<div class="col-md-12">
										<div class="table-responsive">
											<table class="table" style="margin-bottom: 0px;">
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
								<div class="row">
									<div class="col-md-12">	
									<div class="table-responsive" style="width: 100%;">
										<table class="table" style="margin-bottom: 0px;">
										<%String purpose = detailsOfHandOverFormBean.getPurpose_of_hand_over(); %>
											<tr>
												<td colspan="2"><label>Purpose Of Hand Over</label></td>
												<th style="width: 5px;">:</th>
												<td colspan="2">Annual Leave &nbsp;&nbsp;
													<%if(purpose.equalsIgnoreCase("Annual Leave")){ %>
														<input type="radio" name="purpose" value="Annual Leave" checked="checked" disabled="disabled">
													<%}else{ %>
														<input type="radio" name="purpose" value="Annual Leave" disabled="disabled">
													<%} %>
												</td>
												<td colspan="2">
												Business Travel &nbsp;&nbsp;
												<%if(purpose.equalsIgnoreCase("Business Travel")){ %>
													<input type="radio" name="purpose" value="Business Travel" checked="checked" disabled="disabled">
												<%}else{ %>
													<input type="radio" name="purpose" value="Business Travel" disabled="disabled">
												<%} %>
												</td>
												<td colspan="2">
												Resignation &nbsp;&nbsp;
											
												<%if(purpose.equalsIgnoreCase("Resignation")){ %>
													<input type="radio" name="purpose" value="Resignation" checked="checked" disabled="disabled">
												<%}else{ %>
													<input type="radio" name="purpose" value="Resignation" disabled="disabled">
												<%} %>
												</td>
												<td colspan="2">
												Other &nbsp;&nbsp;
											
												<%if(purpose.equalsIgnoreCase("Other")){ %>
													<input type="radio" name="purpose" id="purpose" value="Other" onchange="EnableDisableTextBox(this)" checked="checked" disabled="disabled">
												<%}else{ %>
													<input type="radio" name="purpose" id="purpose" value="Other" onchange="EnableDisableTextBox(this)" disabled="disabled">
												<%} %>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<label>Specify</label>
												</td>
												<th>:</th>
												<td colspan="8">
													<%if(detailsOfHandOverFormBean.getSpecific_purpose_of_hand_over().equalsIgnoreCase("null")){ %>
														<input type="text" class="form-control" id="specificPurpose" name="specificPurpose" value="-" disabled="disabled">
													<%}else{ %>
														<input type="text" class="form-control" id="specificPurpose" name="specificPurpose" value="<%=detailsOfHandOverFormBean.getSpecific_purpose_of_hand_over() %>" disabled="disabled">
													<%} %>
												</td>
											</tr>								
										</table>
									</div>
								</div>
							</div>
								
					
			
					<div class="row" style="background-color: #e7e7e7; padding-top: 4px; padding-bottom: 4px;">
						<div class="col-md-8" style="background-color: #e7e7e7; padding-top: 4px;">
							<label>Handover Detail</label>
						</div>
						<!-- /.col-md-8 -->
						
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
									<th style="width: 650px;"><center>Details of Responsibilities Handed Over (Details of Important Tasks)</center></th>
									<th>Status</th>
								</tr>
								</thead>
								
								<tbody>
								<%
								int i=0;
								List<DetailsOfResponsibilitiesBean> listOfResponsibilitiesById = allListExitFormalityDAO.getListOfResponsibilitiesById(hand_over_detail_id);
								for(DetailsOfResponsibilitiesBean d : listOfResponsibilitiesById){  
								i=i+1;
								%>
								
								<tr>
									<td><%=i%></td>
									<td><%=d.getDetail_of_responsibilities() %></td>
									<td><%=d.getResponibility_status() %></td>
								
								</tr>
								
								
								<%} %>
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
									<th style="width: 650px;"><center>Details of important matters pending.<p class="help-block">(Correspondence, short note of the present status and future course of action)</p></center></th>
									<th><center>Status</center></th>
								</tr>
								</thead>
								
								<tbody>
								<%
								List<DetailsOfPendingMattersBean> listOfPendingMattersById = allListExitFormalityDAO.getListOfPendingMattersById(hand_over_detail_id);
								for(int j=0;j<listOfPendingMattersById.size();j++){  
									DetailsOfPendingMattersBean pm = listOfPendingMattersById.get(j);
								%>
								
								<tr>
									<td><%=j+1%></td>
									<td><%=pm.getDetails_of_important_matters_pending()%></td>
									<td><%=pm.getPending_matters_status() %></td>
								</tr>
								
								<%} %>
								
								
								</tbody>
							</table>
							<!-- /table -->
							
							
							
							</div>
							<!-- /.table-responsive -->
							
							
							
							
							<div class="table-responsive">
							<input type="hidden" id="row2" placeholder="Enter Item Name" value="2" />
								<table class="table" border="1" id="mtable2">
								<thead>
								<tr>
									<th style="width: 50px;"><center>Sr. No</center></th>
									<th style="width: 650px;"><center>Details of Files /Keys /Other Material Handed Over</center></th>
									<th>Status</th>
								</tr>
								</thead>
								
								<tbody>
								<%
								int k = 0;
								List<DetailsOfMaterialBean> listOfMaterialById = allListExitFormalityDAO.getListOfMaterialById(hand_over_detail_id);
								for(DetailsOfMaterialBean dm : listOfMaterialById){  
								k = k+1 ;
								%>
								
								<tr>
									<td><%=k%></td>
									<td><%=dm.getDetails_of_material() %></td>
									<td><%=dm.getMaterial_status() %></td>
								
								</tr>
								
								<%} %>
								
								</tbody>
							</table>
							<!-- /table -->
							
							
							
							</div>
							<!-- /.table-responsive -->
							
							
						</div>
						<!-- /.col-md-12 -->
					
					</div>
					<!-- /.row -->
					
					
					<div class="row">
						<div class="col-md-12">
							<p>Certified that I have fully understood the job assignments/processes and have taken over all the relevant documents / files / source codes, etc from <b><%=detailsOfHandOverFormBean.getHand_over_from_name() %></b> and am in a position to handle above assignments without any assistance.</p>
						</div>
					</div>
					
					
					<div class="row">
					<%List<HandOverApprovalBean> listOfHandOverApprovalName = allListExitFormalityDAO.getListOfHandOverApprovalName(hand_over_detail_id);
					for(int j = 0;j<listOfHandOverApprovalName.size();j++){
						
						HandOverApprovalBean handOverApprovalBean = listOfHandOverApprovalName.get(j);
					%>
						<div class="col-md-6">
						
						
						
						
						<label>
						<%if(j == 0){ %>
							Name (Handed Over By)
						<%}else if(j == 1){ %>
							Name (Taken Over By)
						<%}else if(j == 2){ %>
							Head Of Department
						<%}else if(j == 3){ %>
							Handover to HRD
						<%} %>						
						 : <%=handOverApprovalBean.getEmployeeBean().getFirstname()+" "+handOverApprovalBean.getEmployeeBean().getLastname()%></label>
						<br>
						
						<%
						
						String approvalDate = handOverApprovalBean.getApproval_date() ;
						
						try {
							
							SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Date date = formater.parse(approvalDate);
							SimpleDateFormat formater1 = new SimpleDateFormat("dd-MM-yyyy");
							approvalDate = formater1.format(date);
						
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						%>
						
						
						<label>Date : <%=approvalDate %></label>
						<br>
						<br>
						</div>
						<%} %>
					</div>
					
					<%if(request.getParameter("hrApproval") != null){%>
						<input type="hidden" name="hrApproval">
					<%} %>
					
					
					<%if(request.getParameter("approved") == null){%>
					<center>
						<input type="submit" class="btn btn-primary" name="submit" value="APPROVE">
						
					</center>
					<%} %>
					</form>
					
					</div>
					<!-- /.panel-body -->
					
				</div>
				<!-- /.panel panel-default -->
		</div>
		<!-- /.page-wrapper -->
		
</div>
<!-- /.wrapper -->


				
					
	<script>
		$(document).ready(function() {
			for(var a = 1;a<=39;a++){
			$("#"+a).fadeOut('slow');
			}
		});
	</script>

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

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>

	
	
</body>
</html>
