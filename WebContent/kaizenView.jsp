<%@page import="com.hrms.kaizen.bean.kaizenRCABean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagementApprovalBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenMemberBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kaizen View</title>
<%@include file="header.jsp"%>
<!-- JS dependencies -->
    
    
    
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
        $('#startDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
        $('#endDate').datepicker({
            dateFormat: 'yy-mm-dd'
        });
    })
}
</script>
</head>
<body>
<%
int kaizen_id = 0;

if(request.getParameter("kaizen_id") != null){
	kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
}else if(request.getAttribute("kaizen_id") != null){
	kaizen_id = (Integer) request.getAttribute("kaizen_id");
}
AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
AllListDAO allListDAO = new AllListDAO();

KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
List<KaizenManagerBean> listOfManager = allKaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id);
List<KaizenManagementApprovalBean> listOfKaizenManagement = allKaizenListDAO.getListOfManagemnet(kaizen_id);


String flag = null;
for(KaizenManagerBean k : listOfManager){
	if(k.getEmployeeBean().getEmployee_master_id() == user.getEmployee_master_id()){
		if(k.getStatus().equalsIgnoreCase("pending")){
		flag = "affectedManager";
		}
	}
}

if(user.getManagerBean().getManager_id() == kaizenBean.getManager_id()){
	if(kaizenBean.getStatus().equalsIgnoreCase("pending")){
	flag = "concernManager";
	}
}

for(KaizenManagementApprovalBean k1 : listOfKaizenManagement){
	if(k1.getEmployeeBean().getEmployee_master_id() == user.getEmployee_master_id()){
		if(k1.getManagement_approval_status().equalsIgnoreCase("pending")){
		flag = "affectedManagemnet";
		}
	}
}

%>

	<div id="wrapper"> 
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">CI Detail</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
						
						<div class="row">
						
							<div class="col-sm-6 col-md-6 col-lg-6">
								CI Detail
							</div>
							
							<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id()) {%>
							<div class="col-sm-6 col-md-6 col-lg-6" align="right">
								<%if (kaizenBean.getCompletion_status().equalsIgnoreCase("saved") || kaizenBean.getStatus().equalsIgnoreCase("rejected")) {%>
								<a onclick="changeStatus(<%=kaizen_id%>);"><button class="btn btn-default btn-xs" id="changeStatus">LOCK</button></a>
								<%} %>
								<%if (kaizenBean.getCompletion_status().equalsIgnoreCase("submitted") && kaizenBean.getStatus().equalsIgnoreCase("approved")) {%>
								<a onclick="changeStatusCompleted(<%=kaizen_id%>);"><button class="btn btn-default btn-xs" id="changeStatusCompleted">COMPLETE</button></a>
								<%} %>
								<%if (!kaizenBean.getCompletion_status().equalsIgnoreCase("completed")) {%>
								<a href="kaizenUpdate.jsp?kaizen_id=<%=kaizen_id%>"><button class="btn btn-default btn-xs" id="updateBtn">UPDATE</button></a>
								<%} %>
								<a href="kaizenList.jsp"><button class="btn btn-default btn-xs">Go To List</button></a>
							</div>
							<%} %>
							
							
						</div>
							
						
						
						</div>
						<div class="panel-body">
						
						<div id="table-responsive">
										<table class="table table-stripped ">
										
										
											<tr>
												<th>Problem Description</th>
												<td>:</td>
												<td style="white-space: pre-wrap;"><%=kaizenBean.getKaizenProblemIdentificationBean().getProblem_description()%></td>

												<th>Category</th>
												<td>:</td>
												<td align="left"><%=kaizenBean.getKaizenProblemIdentificationBean().getCategory()%></td>

											</tr>
										
											<tr>
												<th>CI Name</th>
												<td>:</td>
												<td><%=kaizenBean.getKaizen_name()%></td>

												<th>Implementation Cost </th>
												<td>:</td>
												<td align="left"><%=kaizenBean.getImplementation_cost()%></td>
												

											</tr>
	
											<tr>
											    <th>Improvement Plan &emsp; <button type="button" class="btn btn-default btn-xs" name="button" value="RCA" data-toggle="modal" data-target="#rca"><i class="fa fa-thumbs-up"></i> RCA</button></th>
												<td>:</td>
												<td style="white-space: pre-wrap;" colspan="4"><%=kaizenBean.getKaizen_desc()%></td>
											</tr>	

											
											
											
											
				<!-- -------------------------------------ROOT CAUSE ANALYSIS----------------------------------------- -->							
											
					<div class="modal fade" id="rca" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Root Cause Analysis</h4>
                                        </div>
                                        <div class="modal-body">
                                        
                                        <%List<kaizenRCABean> listOfRCA = allKaizenListDAO.getListOfRCAByKaizednId(kaizen_id); 
                                        int rcaCount = 1;
                                        String ans = "";
                                        if(listOfRCA.size() != 0){
                                        for(kaizenRCABean kaizenRCABean : listOfRCA){
                                        	if(rcaCount == 1){
                                        %>
											<p id="rcaQue1" style="font-weight: bold;">1. Why <%=kaizenBean.getExisting_problem()%> ?</p>
											<p><i class="fa fa-hand-o-right"></i> <%=kaizenRCABean.getRca_ans()%></p>
										<%}else{ %>
											<p id="rcaQue1" style="font-weight: bold;">1. Why <%=ans%> ?</p>
											<p><i class="fa fa-hand-o-right"></i> <%=kaizenRCABean.getRca_ans()%></p>
										<%} ans = kaizenRCABean.getRca_ans();rcaCount++;%>
									
										<%} }else{%>
											No Root Cause Analysis
										<%} %>	
                                        </div>
                                        <div class="modal-footer">
                                         <button type="button" class="btn btn-danger btn-xs" data-dismiss="modal">CLOSE</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                  	</div>
											
											
					<!-- -------------------------------------ROOT CAUSE ANALYSIS----------------------------------------- -->						
											
											
											
											
											
											<tr>
											<%
											int numberOfDays = 0;
											SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
											SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd-MMM-yyyy");
											SimpleDateFormat yyyyMMdds = new SimpleDateFormat("yyyy-MM-dd");
											Calendar calKaizenDate = Calendar.getInstance();
											Calendar calkaizenCompletionDate = Calendar.getInstance();
											  
											if(kaizenBean.getCompletion_date() != null){
											  calKaizenDate.setTime(yyyyMMdd.parse(kaizenBean.getDate()));
											  calkaizenCompletionDate.setTime(yyyyMMdd.parse(kaizenBean.getCompletion_date())); 
											  
											  while (calKaizenDate.before(calkaizenCompletionDate)) {
											      numberOfDays++;
											      calKaizenDate.add(Calendar.DATE,1);
											}
											}
											  %>
											  
											  
												<th>CI Date</th>
												<td>:</td>
												<td>
												<i class="fa fa-edit" data-toggle="modal" data-target="#dateChange" style="cursor: pointer;"></i>
												
												<%=ddMMyyyy.format(yyyyMMdd.parse(kaizenBean.getDate()))%>
												 <b>to</b> 
												<%if(kaizenBean.getCompletion_date() != null){ %>
												<%=ddMMyyyy.format(yyyyMMdd.parse(kaizenBean.getCompletion_date()))%>
												<%}else{ %>
												<font id="cDate">-</font>
												<%} %> 
												
												</td>
											
												<th>Days</th>
												<td>:</td>
												<td>
												<font id="days"><%=numberOfDays%> Day(s)</font>
												</td>
												
											</tr>
											
											
											 <!-- -------------------------------------DATE CHNGE----------------------------------------- -->							
											
					<div class="modal fade" id="dateChange" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Root Cause Analysis</h4>
                                        </div>
                                        <form action="kaizenDateUpdate" method="post">
                                        <div class="modal-body">
                                        <input type="hidden" name="kaizen_id" value="<%=kaizen_id%>"> 
                                        	<label>Start Date</label>
                                        	<input type="text" name="startDate" id="startDate" class="form-control" value="<%=yyyyMMdds.format(yyyyMMdd.parse(kaizenBean.getDate()))%>">
                                        	<%if(kaizenBean.getCompletion_date() != null){ %>
                                        	<label>End Date</label>
                                        	<input type="text" name="endDate" id="endDate" class="form-control" value="<%=yyyyMMdds.format(yyyyMMdd.parse(kaizenBean.getCompletion_date()))%>">
                                      		<%} %>
                                        </div>
                                        <div class="modal-footer">
                                         <button type="submit" class="btn btn-primary btn-xs">UPDATE</button>
                                         <button type="button" class="btn btn-danger btn-xs" data-dismiss="modal">CLOSE</button>
                                        </div>
                                        </form>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                  	</div>
											
											
					<!-- -------------------------------------DATE CHANGE----------------------------------------- -->	
											  
											


											<tr>
												<th>Projected Saving</th>
												<td>:</td>
												<td>
												<%if(!kaizenBean.getDelivery().equalsIgnoreCase("")){%>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" checked="checked" disabled="disabled"> Delivery 
												<%}else{ %>
												<input type="checkbox" name="" id="Time"
													value="Time" onclick="projectedSaving();" disabled="disabled"> Delivery 
												<%} %>
												
												
												<%if(!kaizenBean.getCost().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" checked="checked" disabled="disabled"> Cost 
												<%}else{ %>
												<input
													type="checkbox" name="" id="Money" value="Money"
													onclick="projectedSaving();" disabled="disabled"> Cost 
												<%} %>
												
												
												
												<%if(!kaizenBean.getQuality().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" checked="checked" disabled="disabled"> Quality
												<%}else{ %>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" disabled="disabled"> Quality
												<%} %>
												
												<%if(!kaizenBean.getSafety().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Safety" value="Effort"
													onclick="projectedSaving();" checked="checked" disabled="disabled"> Safety
												<%}else{ %>
												<input
													type="checkbox" name="" id="Effort" value="Effort"
													onclick="projectedSaving();" disabled="disabled"> Safety
												<%} %>
												
												<%if(!kaizenBean.getProductivity().equalsIgnoreCase("")){%>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" checked="checked" disabled="disabled"> Productivity
												<%}else{ %>
												<input
													type="checkbox" name="" id="Productivity" value="Productivity"
													onclick="projectedSaving();" disabled="disabled"> Productivity
												<%} %>
												
												</td>


												<td colspan="3">
												<div class="panel panel-primary">
													<table class="table" >
													<%if(!kaizenBean.getDelivery().equalsIgnoreCase("")){%>
														<tr id="timeField">
															<th>Delivery </th>
															<td>:</td>
															<td style="white-space: pre-wrap;"><%=kaizenBean.getDelivery()%></td>
														</tr>
													<%}%>
													
													<%if(!kaizenBean.getCost().equalsIgnoreCase("")){%>
														<tr id="moneyField">
															<th>Cost </th>
															<td>:</td>
															<td style="white-space: pre-wrap;"><%=kaizenBean.getCost()%></td>
														</tr> 
													<%}%>
													
													<%if(!kaizenBean.getQuality().equalsIgnoreCase("")){%>
														<tr id="effortField">
															<th>Quality </th>
															<td>:</td>
															<td style="white-space: pre-wrap;"><%=kaizenBean.getQuality()%></td>
														</tr> 
													<%}%>
														
														<%if(!kaizenBean.getSafety().equalsIgnoreCase("")){%>
														<tr id="safetyField">
															<th>Safety </th>
															<td>:</td>
															<td style="white-space: pre-wrap;"><%=kaizenBean.getSafety()%></td>
														</tr> 
													<%}%>
													
														<%if(!kaizenBean.getProductivity().equalsIgnoreCase("")){%>
														<tr id="productivityField">
															<th>Productivity </th>
															<td>:</td>
															<td style="white-space: pre-wrap;"><%=kaizenBean.getProductivity()%></td>
														</tr> 
													<%}%>
														
													</table>
													</div>
													 <input type="hidden" name="insert">
												</td>

											</tr>
											
											
											<tr>
												<th>HOD (Head Of Department)</th>
												<td>:</td>
												<td colspan="4">
													
												<%
												if(kaizenBean.getStatus() != null){
												int under_manager_id = kaizenBean.getManager_id();
													LoginDAO loginDAO = new LoginDAO();
													String reason = "";
													
													EmployeeBean employeeBean = loginDAO.getEmailId(under_manager_id);
													
													
													int company_id = employeeBean.getCompanyListBean().getCompany_list_id();
													int emp_code = employeeBean.getEmployee_code();
													String company_name = null;
													if(company_id == 1){
														company_name = "SLTL";
													}else if(company_id == 2){
														company_name = "SS";
													}else if(company_id == 3){
														company_name = "S.HR";
													}else if(company_id == 4){
														company_name = "COSMOS";
													}else if(company_id == 5){
														company_name = "CSLASER";
													}else if(company_id == 6){
														company_name = "SEZ";
													}else if(company_id == 7){
														company_name = "CL";
													}if(company_id == 8){
														company_name = "App";
													}
												
													String borderColor = null;
													
													if(kaizenBean.getStatus().equalsIgnoreCase("approved") || kaizenBean.getStatus().equalsIgnoreCase("genuine")){
														
														borderColor = "green";
														
													}else if(kaizenBean.getStatus().equalsIgnoreCase("rejected")){
														
														borderColor = "red";
														
													}else{
														
														borderColor = "#F1C40F";
														
													}
													
													if(kaizenBean.getRejection_reason() != null && !kaizenBean.getRejection_reason().equalsIgnoreCase("-") && !kaizenBean.getRejection_reason().equalsIgnoreCase("null")){
														reason = "Reason : " +kaizenBean.getRejection_reason();
													}
													
												%>
												
												<img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px; border-color: <%=borderColor%>;"  alt="Sample Image"
														class="img-circle" id="img<%=kaizenBean.getManager_id()%>" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='Sample Image'></a><div class='media-body'><h4 class='media-heading'><%=employeeBean.getFirstname()+" "+employeeBean.getLastname() %> </h4><p><%=employeeBean.getDepartmentBean().getDepartment_name()%></p><p><%=reason%></p></div></div>"/>  
												
												<%} %>
												</td>
											</tr>
											

											<tr>
												<th>Required support of other Department</th>
												<td>:</td>
												<td colspan="4">
													
													<%if(listOfManager.size() != 0){
														for(KaizenManagerBean k : listOfManager){
															
															int company_id = k.getEmployeeBean().getCompanyListBean().getCompany_list_id();
															String reason = "";
															
															int emp_code = k.getEmployeeBean().getEmployee_code();
															String company_name = null;
															if(company_id == 1){
																company_name = "SLTL";
															}else if(company_id == 2){
																company_name = "SS";
															}else if(company_id == 3){
																company_name = "S.HR";
															}else if(company_id == 4){
																company_name = "COSMOS";
															}else if(company_id == 5){
																company_name = "CSLASER";
															}else if(company_id == 6){
																company_name = "SEZ";
															}else if(company_id == 7){
																company_name = "CL";
															}if(company_id == 8){
																company_name = "App";
															}
														
															String borderColor = null;
															
															if(k.getStatus().equalsIgnoreCase("approved")){
																
																borderColor = "green";
																
															}else if(k.getStatus().equalsIgnoreCase("rejected")){
																
																borderColor = "red";
																
															}else{
																
																borderColor = "#F1C40F";
																
															}
															
															
															
															if(k.getRejection_reason() != null && !k.getRejection_reason().equalsIgnoreCase("-") && !k.getRejection_reason().equalsIgnoreCase("null")){
																reason = "Reason : " +k.getRejection_reason();
															}
															
															
													%>
													
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && (kaizenBean.getCompletion_status().equalsIgnoreCase("saved") || kaizenBean.getStatus().equalsIgnoreCase("rejected"))) {%>
													
													<a tabindex="0"  data-toggle="popover" data-trigger="focus" title="" style="color: black;text-decoration: none; cursor: pointer;" data-content="<a href='kaizenRemoveManagerOrMember?kaizen_manager_id=<%=k.getKaizen_manager_id()%>&kaizen_id=<%=kaizen_id%>'>Remove</a>"><img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px; border-color: <%=borderColor%>;"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" id="img<%=k.getEmployeeBean().getEmployee_master_id()%>" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p><p><%=reason%></p></div></div>"/>  
													</a>	
													<%}else{ %>
													
													<img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px; border-color: <%=borderColor%>;"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" id="img<%=k.getEmployeeBean().getEmployee_master_id()%>" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p><p><%=reason%></p></div></div>"/>  
													
													<%} %>
													
													
													<%} %>
													<%}%>
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getCompletion_status().equalsIgnoreCase("saved") && !kaizenBean.getCategory_id().equalsIgnoreCase("A")) {%>
													
													<a href="addManagerForKaizen.jsp?kaizen_id=<%=kaizen_id%>"><button class="btn btn-default btn-circle" id="addManager"><i class="fa fa-plus"></i></button></a>
												
													<%} %>
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getStatus().equalsIgnoreCase("rejected") && !kaizenBean.getCategory_id().equalsIgnoreCase("A")) {%>
													
													<a href="addManagerForKaizen.jsp?kaizen_id=<%=kaizen_id%>"><button class="btn btn-default btn-circle" id="addManager"><i class="fa fa-plus"></i></button></a>
												
													<%} %>
													
												</td>
											</tr>
											
											
											<tr>
												<th>Team Member</th>
												<td>:</td>
												<td colspan="4">
													<%if(listOfMember.size() != 0){
														for(KaizenMemberBean k : listOfMember){
															
															int company_id = k.getEmployeeBean().getCompanyListBean().getCompany_list_id();
															int emp_code = k.getEmployeeBean().getEmployee_code();
															String company_name = null;
															if(company_id == 1){
																company_name = "SLTL";
															}else if(company_id == 2){
																company_name = "SS";
															}else if(company_id == 3){
																company_name = "S.HR";
															}else if(company_id == 4){
																company_name = "COSMOS";
															}else if(company_id == 5){
																company_name = "CSLASER";
															}else if(company_id == 6){
																company_name = "SEZ";
															}else if(company_id == 7){
																company_name = "CL";
															}if(company_id == 8){
																company_name = "App";
															}
														
															
															
															
													%>
													
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && (kaizenBean.getCompletion_status().equalsIgnoreCase("saved") || kaizenBean.getStatus().equalsIgnoreCase("rejected"))) {%>
													<a tabindex="0"  data-toggle="popover" data-trigger="focus" title="" style="color: black;text-decoration: none; cursor: pointer;" data-content="<a href='kaizenRemoveManagerOrMember?kaizen_member_id=<%=k.getKaizen_member_id()%>&kaizen_id=<%=kaizen_id%>'>Remove</a>"><img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p></div></div>"/>  
														</a>
														<%}else{ %>
														<img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p></div></div>"/>  
														<%} %>
														
														
													<%} %>
													<%}else{%>
														No Team Member
													<%} %>
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getCompletion_status().equalsIgnoreCase("saved")) {%>
													<a href="" data-toggle="modal" data-target="#myModalManager"><button class="btn btn-default btn-circle" id="addEmployee"><i class="fa fa-plus"></i></button></a>
													<%} %>
													
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getStatus().equalsIgnoreCase("rejected")) {%>
													<a href="" data-toggle="modal" data-target="#myModalManager"><button class="btn btn-default btn-circle" id="addEmployee"><i class="fa fa-plus"></i></button></a>
													<%} %>
													
												</td>
											</tr>
											
											<tr>
												<th>Higher Authority</th>
												<td>:</td>
												<td colspan="4">
													<%
														for(KaizenManagementApprovalBean k : listOfKaizenManagement){
															
															int company_id = k.getEmployeeBean().getCompanyListBean().getCompany_list_id();
															int emp_code = k.getEmployeeBean().getEmployee_code();
															String company_name = null;
															String reason ="";
															if(company_id == 1){
																company_name = "SLTL";
															}else if(company_id == 2){
																company_name = "SS";
															}else if(company_id == 3){
																company_name = "S.HR";
															}else if(company_id == 4){
																company_name = "COSMOS";
															}else if(company_id == 5){
																company_name = "CSLASER";
															}else if(company_id == 6){
																company_name = "SEZ";
															}else if(company_id == 7){
																company_name = "CL";
															}if(company_id == 8){
																company_name = "App";
															}
															
															
															String borderColor = null;
															
															if(k.getManagement_approval_status().equalsIgnoreCase("approved")){
																
																borderColor = "green";
																
															}else if(k.getManagement_approval_status().equalsIgnoreCase("rejected")){
																
																borderColor = "red";
																
															}else{
																
																borderColor = "#F1C40F";
																
															}
															
															
															
															if(k.getManagement_rejection_reason() != null && !k.getManagement_rejection_reason().equalsIgnoreCase("-") && !k.getManagement_rejection_reason().equalsIgnoreCase("null")){
																reason = "Reason : " +k.getManagement_rejection_reason();
															}
														
															
													%>
													
													
														<a tabindex="0"  data-toggle="popover" data-trigger="focus" title="" style="color: black;text-decoration: none; cursor: pointer;" data-content="<a href='kaizenRemoveManagemnet?kaizen_management_id=<%=k.getKaizen_management_approval_id()%>&kaizen_id=<%=kaizen_id%>'>Remove</a>"><img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px; border-color: <%=borderColor%>;"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" id="img<%=k.getEmployeeBean().getEmployee_master_id()%>" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p><p><%=reason%></p></div></div>"/>    
														</a>
													<%}%>
										                  	<%if((Double.parseDouble(kaizenBean.getImplementation_cost()) > 5000 )
										                  			|| (kaizenBean.getCategory_id().equalsIgnoreCase("C"))){ 
										                  			
										                  			if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id()){%>
										                  			
										                  			<button class="btn btn-default btn-circle" id="addAuthority" data-toggle="modal" data-target="#addAuthorityModel"><i class="fa fa-plus"></i></button>
										                  			
													<%}} %>
													
													
												</td>
											</tr>
											
											
											<tr>
												<td colspan="6"></td>
											<tr>
											
										<div class="modal fade" id="myModalManager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                              	  <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Add Team member </h4>
                                        </div>
                                         <form action="kaizenMemberInsert" method="post" enctype="multipart/form-data">
                                        <div class="modal-body">
			                                        	<input type="hidden" name="kaizen_id" value="<%=kaizen_id%>">
                                        
                                        <input list="employee" class="form-control" name="employee_name" placeholder="Select Team Member" value="" required>
			  						<datalist id="employee">
				  				 		<%
				  				 	 	
				  				 		List<EmployeeBean> listOfEmployee = allListDAO.getFullListOfEmployee();
				  				 		for(EmployeeBean e : listOfEmployee){
				  				 		%>
				  				 			 		<option value="<%=e.getEmployee_code()+","+e.getFirstname()+" "+e.getLastname()%>"/>
				  				 		<%} %>
		                         	</datalist>
		                         	<br>
                                        </div>
                                        <div class="modal-footer">
                                        <input type="hidden" name="redirectionTeamMember">
                                            <input type="submit" class="btn btn-primary" name="submit" value="SUBMIT">
                                               <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
                                        </div>
                                        </form>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
          				 </div>            	

						</table>
						<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && !kaizenBean.getCompletion_status().equalsIgnoreCase("completed")) {%>
						<div align="center" id="addPhoto">
						<a href="kaizenPhotoUpload.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-outline btn-default btn-xs"><i class="fa fa-photo"></i> Add Photos</button></a>
						</div>
						<%} %>
						<%
						List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
						List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
						%>
						<div class="row">
						
							<div class="col-sm-6 col-md-6 col-lg-6">
							
									<%if(listOfBefore.size() != 0){ %>
						<div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>Before Photo List</b></h5>
												<%
												
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
												
												<h5><b>Description</b></h5>
												<p style="white-space: pre-wrap;"><%=kaizenBean.getBefore_description()%></p>								
												</div>
						</div>
						<%} %>
							
							</div>
							
							<div class="col-sm-6 col-md-6 col-lg-6">
							
								<%if(listOfAfter.size() != 0){ %>
							<div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>After Photo List</b></h5>
												<%
												
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
												
												<h5><b>Description</b></h5>
												<p style="white-space: pre-wrap;"><%=kaizenBean.getAfter_description()%></p>									
												</div>
												</div>
								<%} %>
							
							</div>
						
						</div>
						
						
						
					
						
						
						
						
						<%
						if(flag != null){
							if(flag.equalsIgnoreCase("affectedManagemnet")){
						%>
						<div class="approvButton" align="center">
						<input type="button" name="submit" value="Accept" class="btn btn-primary" onclick="managemnetApproval(1);">
						<input type="button" name="reject" value="Reject" class="btn btn-danger" data-toggle="modal" data-target="#rejectionPanel">
						</div>
						<%}else{ %>
						<div class="approvButton" align="center">
						<input type="button" name="submit" value="Accept" class="btn btn-primary" onclick="approve();" data-toggle="modal" data-target="#acceptPanel">
						<input type="button" name="reject" value="Reject" class="btn btn-danger" data-toggle="modal" data-target="#rejectionPanel">
						</div>
						<%}} %>
						
						<%if(kaizenBean.getStatus().equalsIgnoreCase("rejected")){
							%>
							<div class="approvButton" align="center">
								<input type="button" name="submit" value="ReActive" class="btn btn-primary" onclick="approve();" data-toggle="modal" data-target="#acceptPanel">
							</div>
						<%}%>
						<div class="modal fade" id="rejectionPanel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Rejection Remarks</h4>
                                        </div>
                                        <div class="modal-body">
                                      <input type="text" class="form-control" name="reason" id="reason">
                                        </div>
                                        <div class="modal-footer">
                                        <%if(flag != null){
                							if(flag.equalsIgnoreCase("affectedManagemnet")){ %>
                                        <input type="button" class="btn btn-primary" name="submit" value="SUBMIT" onclick="managemnetApproval(2);">
                                        <%}else{ %>
                                         <input type="button" class="btn btn-primary" name="submit" value="SUBMIT" onclick="reject()">
                                        <%}} %>
                                         <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                  	</div>
                  	
                  	<div class="modal fade" id="addAuthorityModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Select Management</h4>
                                        </div>
                                        <div class="modal-body">
											<%
												List<EmployeeBean> listOfTopManagement = allKaizenListDAO.getlistOfTopManagement();
											%>
											<select class="form-control" name="management_id"
												id="management_id">
												<option value="">---Select Employee---</option>
												<%
													for (EmployeeBean e : listOfTopManagement) {
														if(e.getEmployee_master_id() != 1017 && e.getEmployee_master_id() != 1201 && e.getEmployee_master_id() != 974){
												%>
												<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname() + " " + e.getLastname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(<%=e.getRoleBean().getRole_type()%>)
												</option>
												<%
													}}
												%>

											</select>
                                        </div>
                                        <div class="modal-footer">
                                        <input type="button" class="btn btn-primary" name="submit" value="SUBMIT" onclick="managemnetApprovalInsert()">
                                         <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                  	</div>
                  	
                  	<%-- <%
                  	if(flag != null){
                  	if((Double.parseDouble(kaizenBean.getImplementation_cost()) > 5000 && flag.equalsIgnoreCase("concernManager"))
                  			|| (kaizenBean.getCategory_id().equalsIgnoreCase("C") && flag.equalsIgnoreCase("concernManager"))){%>
                  	<div class="modal fade" id="acceptPanel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Select Management</h4>
                                        </div>
                                        <div class="modal-body">
											<select class="form-control" name="management_id"
												id="management_id">
												<option value="">---Select Employee---</option>
												<%
												List<EmployeeBean> listOfTopManagement = allKaizenListDAO.getlistOfTopManagement();
													for (EmployeeBean e : listOfTopManagement) {
														if(e.getEmployee_master_id() != 1017 && e.getEmployee_master_id() != 1201 && e.getEmployee_master_id() != 974){
												%>
												<option value="<%=e.getEmployee_master_id()%>"><%=e.getFirstname() + " " + e.getLastname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(<%=e.getRoleBean().getRole_type()%>)
												</option>
												<%
													}}
												%>

											</select>
                                        </div>
                                        <div class="modal-footer">
                                        <input type="button" class="btn btn-primary" name="submit" value="SUBMIT" onclick="managemnetApprovalInsert()">
                                         <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                  	</div>
                  	<%} }%> --%>
                  
									</div>
									
									
									
						<label>Legends :</label><br>			
						<img src="img/user.bmp" alt="user" class="img-circle" height="40px" width="40px" style="border: solid 2px; border-color:#F1C40F;"> : <b>Pending</b>
						<img src="img/user.bmp" alt="user" class="img-circle" height="40px" width="40px" style="border: solid 2px; border-color:green;"> : <b>Approved</b>
						<img src="img/user.bmp" alt="user" class="img-circle" height="40px" width="40px" style="border: solid 2px; border-color:red;"> : <b>Rejected</b>
						
						</div>
						
					</div>
				</div>
			</div>


		</div>
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- bootbox code -->
    <script src="js/bootbox.min.js"></script>

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
	
	function approve() {
		
		var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		});
		
		var $form = $(this), url = 'kaizenAcceptReject';
		

		var posting = $.post(url, {
			value : 'approved',
			id : <%=kaizen_id%>,
			kaizen_manager_id : <%=kaizenBean.getManager_id()%>
		});
		
		
		posting.done(function(data) {
			<%
          	if(flag != null){
          	if((flag.equalsIgnoreCase("concernManager")) || !flag.equalsIgnoreCase("concernManager")){%>
          	dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Approved<b></h4></div>');
			<%}}%>
			
			<%
          	if(kaizenBean.getStatus().equalsIgnoreCase("rejected")){%>
          	
          	dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Re-Activated Successfully.<b></h4></div>');
			<%}%>
			
			$('#img'+<%=user.getEmployee_master_id()%>).css('border-color', 'green');
			$('#img'+<%=user.getManagerBean().getManager_id()%>).css('border-color', 'green');
			$('.approvButton').hide();
		});
	}
	
	
	
	function reject() {
		
		var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		});
		
		
		var $form = $(this), url = 'kaizenAcceptReject';
		

		var posting = $.post(url, {
			value : 'rejected',
			reason : $('#reason').val(),
			id : <%=kaizen_id%>,
			kaizen_manager_id : <%=kaizenBean.getManager_id()%>
		});
		
		
		posting.done(function(data) {
			$('#rejectionPanel').modal('hide');
			dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Rejected<b></h4></div>');
			
			$('#img'+<%=user.getEmployee_master_id()%>).css('border-color', 'red');
			$('#img'+<%=user.getManagerBean().getManager_id()%>).css('border-color', 'red');
			$('.approvButton').hide();
		});
	}
	
	
	
	
	function managemnetApprovalInsert() {
		
		
		var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		});
		
		var $form = $(this), url = 'kaizenManagementInsert';
		
		

		var posting = $.post(url, {
			employee_id : $('#management_id').val(),
			kaizen_id : <%=kaizen_id%>,
		});
		
		
		posting.done(function(data) {
			$('#acceptPanel').modal('hide');
			$('#addAuthorityModel').modal('hide');
			
			dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>Higher Authority Added Successfully.You need refresh page for show result.<b></h4></div>');
			
		});
	}

	
	function managemnetApproval(value) {
		
		var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		});
		
		var $form = $(this), url = 'kaizenManagementApproval';
		
		
		if(value == 1){ 
			
		var posting = $.post(url, {
			status : "approved",
			reason : "-",
			id : <%=kaizen_id%>,
		});
		
		
		posting.done(function(data) {
			$('#acceptPanel').modal('hide');
			
			dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Approved<b></h4></div>');
			
			$('#img'+<%=user.getEmployee_master_id()%>).css('border-color', 'green');
			$('.approvButton').hide();
		});
		
		}else if(value == 2){
			
			var posting = $.post(url, {
				status : "rejected",
				reason : $('#reason').val(),
				id : <%=kaizen_id%>,
			});
			
			
			posting.done(function(data) {
				$('#rejectionPanel').modal('hide');
				dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Rejected<b></h4></div>');
				$('#img'+<%=user.getEmployee_master_id()%>).css('border-color', 'red');
				$('.approvButton').hide();
			});
			
		}
		
		
	}
	
	
	function changeStatus(id) {
		
		var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		});

		var $form = $(this), url = 'kaizenStatusChange';
		

		var posting = $.post(url, {
			id : id,
			status : "submitted"
		});
		
		
		posting.done(function(data) {
			$('#changeStatus').hide();
			$('#addEmployee').hide();
			$('#addManager').hide();
			dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Locked<b></h4></div>');			
		});
		
	}
	
	function changeStatusCompleted(id) {
	
		var retVal = confirm("Would you like to add After photos?");
		if( retVal == true){
			window.location.replace("kaizenPhotoUpload.jsp?kaizen_id="+<%=kaizen_id%>)
	}else{
		
		var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		});
		var $form = $(this), url = 'kaizenStatusChange';
		

		var posting = $.post(url, {
			id : id,
			status : "completed"
		});
		
		
		posting.done(function(data) {
			var split = data.split(",");
			$('#cDate').text(split[0]);
			$('#days').text(split[1]+' Day(s)');
			$('#changeStatusCompleted').hide();
			$('#addPhoto').hide();
			$('#updateBtn').hide();
			dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Completed<b></h4></div>');			
		});
		
	}
		
	}
	
	
	
	</script>
	
	
	<script>
	  $("[data-toggle=popover]")
	    .popover({html:true})
	    
	    $('.popover-dismiss').popover({
	  	trigger: 'focus'
		})
	</script>
	
</body>
</html>