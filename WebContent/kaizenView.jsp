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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Kaizen View</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">

	<link href="offlinetimepicker/jquerysctipttop.css" rel="stylesheet" type="text/css">
	<link href="offlinetimepicker/mdtimepicker.css" rel="stylesheet" type="text/css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp" %>
<!-- JS dependencies -->
   
   <!--  <script type="text/javascript">
var datefield=document.createElement("input")
datefield.setAttribute("type", "text")
if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
    document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
    document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
}
</script>
 -->
<!-- <script>
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
 -->
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
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
<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">CI Detail</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>

	<div class="row">
				<div class="col-lg-12">
					<div class="card">
				        	<div class="card-header">
				        	<div class="card box-shadow-0" data-appear="appear">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					                <div class="col-sm-6">
					                    <h5 class="card-title">CI Detail</h5></div>
					                    <%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id()) {%>
											<div class="col-sm-6" align="right">
												<%if (kaizenBean.getCompletion_status().equalsIgnoreCase("saved") || kaizenBean.getStatus().equalsIgnoreCase("rejected")) {%>
												<a onclick="changeStatus(<%=kaizen_id%>);"><button class="btn mr-1 mb-1 btn-success" id="changeStatus">LOCK</button></a>
												<%} %>
												<%if (kaizenBean.getCompletion_status().equalsIgnoreCase("submitted") && kaizenBean.getStatus().equalsIgnoreCase("approved")) {%>
												<a onclick="changeStatusCompleted(<%=kaizen_id%>);"><button class="btn btn-primary btn-min-width mr-1 mb-1" id="changeStatusCompleted">COMPLETE</button></a>
												<%} %>
												<%if (!kaizenBean.getCompletion_status().equalsIgnoreCase("completed")) {%>
												<a href="kaizenUpdate.jsp?kaizen_id=<%=kaizen_id%>"><button class="btn mr-1 mb-1 btn-primary" id="updateBtn">UPDATE</button></a>
												<%} %>
												<a href="kaizenList.jsp"><button class="btn mr-1 mb-1 btn-warning">Go To List</button></a>
											</div>
											 
											<%} %>	
					                </div>
					                
						<div class="card-body collapse in">
					              <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
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
											    <th>Improvement Plan &emsp; <button type="button" class="btn mr-1 mb-1 btn-primary" name="button" value="RCA" data-toggle="modal" data-target="#rca"><i class="fa fa-thumbs-up"></i> RCA</button></th>
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
											Calendar calKaizenDate = Calendar.getInstance();
											Calendar calkaizenCompletionDate = Calendar.getInstance();
											  
											if(kaizenBean.getCompletion_date() != null){
											  calKaizenDate.setTime(yyyyMMddhh.parse(kaizenBean.getDate()));
											  calkaizenCompletionDate.setTime(yyyyMMddhh.parse(kaizenBean.getCompletion_date())); 
											  
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
												
												<%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getDate()))%>
												 <b>to</b> 
												<%if(kaizenBean.getCompletion_date() != null){ %>
												<%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getCompletion_date()))%>
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
                                        	<input type="text" name="startDate" id="startDate" class="form-control" value="<%=yyyyMMdd.format(yyyyMMddhh.parse(kaizenBean.getDate()))%>">
                                        	<%if(kaizenBean.getCompletion_date() != null){ %>
                                        	<label>End Date</label>
                                        	<input type="text" name="endDate" id="endDate" class="form-control" value="<%=yyyyMMdd.format(yyyyMMddhh.parse(kaizenBean.getCompletion_date()))%>">
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
													<table class="table" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B; border-top: 2px solid #607D8B;border-bottom: 2px solid #607D8B;">
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
												
												
												<img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px;border-radius:20px; border-color: <%=borderColor%>;"  alt="Sample Image"
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
													
													<a tabindex="0"  data-toggle="popover" data-trigger="focus" title="" style="color: black;text-decoration: none; cursor: pointer;" data-content="<a href='kaizenRemoveManagerOrMember?kaizen_manager_id=<%=k.getKaizen_manager_id()%>&kaizen_id=<%=kaizen_id%>'>Remove</a>"><img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px;border-radius:20px;border-color: <%=borderColor%>;"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" id="img<%=k.getEmployeeBean().getEmployee_master_id()%>" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p><p><%=reason%></p></div></div>"/>  
													</a>	
													<%}else{ %>
													
													<img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px;border-radius:20px; border-color: <%=borderColor%>;"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" id="img<%=k.getEmployeeBean().getEmployee_master_id()%>" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p><p><%=reason%></p></div></div>"/>  
													
													<%} %>
													
													
													<%} %>
													<%}%>
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getCompletion_status().equalsIgnoreCase("saved") && !kaizenBean.getCategory_id().equalsIgnoreCase("A")) {%>
													
													<a href="addManagerForKaizen.jsp?kaizen_id=<%=kaizen_id%>" data-target="#myModalManager" id="addManager">&nbsp;<i class="icon-circle-plus" style="color: black;font-size: 20px;padding-top:20px;"></i></a>
													<%} %>
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getStatus().equalsIgnoreCase("rejected") && !kaizenBean.getCategory_id().equalsIgnoreCase("A")) {%>
													
													
													<a href="addManagerForKaizen.jsp?kaizen_id=<%=kaizen_id%>" data-target="#myModalManager" id="addManager">&nbsp;<i class="icon-circle-plus" style="color: black;font-size: 20px;padding-top:20px;"></i></a>
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
															
													%>
													
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && (kaizenBean.getCompletion_status().equalsIgnoreCase("saved") || kaizenBean.getStatus().equalsIgnoreCase("rejected"))) {%>
													<a tabindex="0"  data-toggle="popover" data-trigger="focus" title="" style="color: black;text-decoration: none; cursor: pointer;" data-content="<a href='kaizenRemoveManagerOrMember?kaizen_member_id=<%=k.getKaizen_member_id()%>&kaizen_id=<%=kaizen_id%>'>Remove</a>"><img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" height="40px" width="40px" style="border-radius:20px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p></div></div>"/>  
														</a>
														<%}else{ %>
														<img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" height="40px" width="40px" style="border-radius:20px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p></div></div>"/>  
														<%} %>
														
														
													<%} %>
													<%}else{%>
														No Team Member
													<%} %>
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getCompletion_status().equalsIgnoreCase("saved")) {%>
													<a href="" data-toggle="modal" data-target="#myModalManager">&nbsp;<i class="icon-circle-plus" style="color: black;font-size: 20px;padding-top:20px;"></i></a>
													<%} %>
													
													
													<%if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id() && kaizenBean.getStatus().equalsIgnoreCase("rejected")) {%>
													<a href="" data-toggle="modal" data-target="#myModalManager"><i class="icon-circle-plus" style="color: black;font-size: 20px;padding-top:20px;"></i></a>
													<%} %>
													
												</td>
											</tr>
											
											<tr>
												<th>Higher Authority</th>
												<td>:</td>
												<td colspan="4">
													<%
														for(KaizenManagementApprovalBean k : listOfKaizenManagement){
															String reason = "";
															int company_id = k.getEmployeeBean().getCompanyListBean().getCompany_list_id();
															int emp_code = k.getEmployeeBean().getEmployee_code();
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
													
														<a tabindex="0" data-toggle="popover" data-trigger="focus" title="" style="color: black;text-decoration: none; cursor: pointer;" data-content="<a href='kaizenRemoveManagemnet?kaizen_management_id=<%=k.getKaizen_management_approval_id()%>&kaizen_id=<%=kaizen_id%>'>Remove</a>"><img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" style="border: solid 2px; border-radius:20px; border-color: <%=borderColor%>;"  alt="<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>"
														class="img-circle" id="img<%=k.getEmployeeBean().getEmployee_master_id()%>" height="40px" width="40px" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" title="Manager Info" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp' class='img-circle' height='60px' width='60px' alt='<%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %>'></a><div class='media-body'><h4 class='media-heading'><%=k.getEmployeeBean().getFirstname()+" "+k.getEmployeeBean().getLastname() %> </h4><p><%=k.getEmployeeBean().getDepartmentBean().getDepartment_name()%></p><p><%=reason%></p></div></div>"/>    
														</a>
														<!-- <a href="" data-toggle="modal" data-target="#myModalManager">&nbsp;<i class="icon-circle-plus" style="color: black;font-size: 20px;padding-top:20px;"></i></a> -->
													<%}%>
										                  	<%if((Double.parseDouble(kaizenBean.getImplementation_cost()) > 5000 )
										                  			|| (kaizenBean.getCategory_id().equalsIgnoreCase("C"))){ 
										                  			
										                  			if(user.getEmployee_master_id() == kaizenBean.getEmployeeBean().getEmployee_master_id()){%>
										                  			
										                  			<!-- <button class="btn btn-default btn-circle" id="addAuthority" data-toggle="modal" data-target="#addAuthorityModel"><i class="fa fa-plus"></i></button> -->
										                  			
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
						<a href="kaizenPhotoUpload.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-primary btn-min-width mr-1 mb-1"><i class="fa fa-photo"></i> Add Photos</button></a>
						</div>
						<%} %>
						<%
						List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
						List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
						%>
						<div class="row">
						
							<div class="col-sm-6 col-md-6 col-lg-6">
							
									<%if(listOfBefore.size() != 0){ %>
										<div class="panel panel-primary" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B; border-top: 2px solid #607D8B;border-bottom: 2px solid #607D8B; border-radius: 10px;">
												<div class="panel-body">
														<h5><b> &nbsp;&nbsp; Before Photo List</b></h5>
												<%
												
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
													 &nbsp;&nbsp; <img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
												
												<!-- <hr color="#607D8B"> -->
												<h5><b> &nbsp;&nbsp; Description</b></h5>
												<p style="white-space: pre-wrap;"> &nbsp;&nbsp; <%=kaizenBean.getBefore_description()%></p>								
												</div>
										</div>
						<%} %>
							
							</div>
							
							<div class="col-sm-6 col-md-6 col-lg-6">
							
								<%if(listOfAfter.size() != 0){ %>
							<div class="panel panel-primary" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B; border-top: 2px solid #607D8B;border-bottom: 2px solid #607D8B; border-radius: 10px;">
												<div class="panel-body">
														<h5><b> &nbsp;&nbsp; After Photo List</b></h5>
												<%
												
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													 &nbsp;&nbsp; <img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenAfter\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
												
												<h5><b> &nbsp;&nbsp; Description</b></h5>
												<p style="white-space: pre-wrap;"> &nbsp;&nbsp; <%=kaizenBean.getAfter_description()%></p>									
												</div>
							</div>
								<%} %>
							
							</div>
						
						</div>
						
						<br>
						
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
									
									
								<br>	
						<label><b>Legends :</b></label><br>			
						<img src="img/user.bmp" alt="user" class="mr-1 btn-icon btn btn-outline-primary btn-round" height="40px" width="40px" style="border: solid 2px; border-color:#F1C40F;"> : <b>Pending</b>
						<img src="img/user.bmp" alt="user" class="mr-1 btn-icon btn btn-outline-primary btn-round" height="40px" width="40px" style="border: solid 2px; border-color:green;"> : <b>Approved</b>
						<img src="img/user.bmp" alt="user" class="mr-1 btn-icon btn btn-outline-primary btn-round" height="40px" width="40px" style="border: solid 2px; border-color:red;"> : <b>Rejected</b>
						<br>
						<br>
						<label><font color="red">Note:<br></font> 
						<font color="green">Please click on <button class="btn mr-1 mb-1 btn-success btn-sm">LOCK</button> button for sending your CI to manager's Approval.<br></font>
						<font color="green">After Approval Please click on <button class="btn mr-1 mb-1 btn-primary btn-sm">COMPLETE</button> button for sending your CI to Billboard scoring.
						</font>
						</label>
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
    <script src="js/bootbox.min.js"></script>
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
    <script src="app-assets/js/scripts/extensions/sweet-alerts.min.js" type="text/javascript"></script>
     <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
	<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
	
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
	
	
	function approve() {
		
		//alert("hiiii");
		
		
		$.ajax({
		    method: "POST",
		    url: 'kaizenAcceptReject',
		    data: {id:<%=kaizen_id%>,value :'approved',kaizen_manager_id : <%=kaizenBean.getManager_id()%>},
		    success: function (data) {
		    	alert(data);
		    	<%
	          	if(flag != null){
	          	if((flag.equalsIgnoreCase("concernManager")) || !flag.equalsIgnoreCase("concernManager")){%>
	          	if(data == "null"){
		    		swal("Error!","Some Error occured !","error")
		    	}else{
		    		swal("SUCCESS!","CI Approved","success")
		    	}
	          	
	          	//dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Approved<b></h4></div>');
				<%}}%>
				
				<%
	          	if(kaizenBean.getStatus().equalsIgnoreCase("rejected")){%>
	          	if(data == "null"){
		    		swal("Error!","Some Error occured !","error")
		    	}else{
		    		swal("SUCCESS!","CI Re-Activated Successfully","success")
		    	}
	          	//dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Re-Activated Successfully.<b></h4></div>');
				<%}%>
				
				$('#img'+<%=user.getEmployee_master_id()%>).css('border-color', 'green');
				$('#img'+<%=user.getManagerBean().getManager_id()%>).css('border-color', 'green');
				$('.approvButton').hide();
		    }
		}); 
		
	}
	
	
	function reject() {
		
		
		
		$.ajax({
		    method: "POST",
		    url: 'kaizenAcceptReject',
		    data: {value : 'rejected',reason : $('#reason').val(),id : <%=kaizen_id%>,kaizen_manager_id : <%=kaizenBean.getManager_id()%>},
		    success: function (data) {
		    	//alert(data);
		    	$('#rejectionPanel').modal('hide');
				if(data == "null"){
		    		swal("Error!","Some Error occured !","error")
		    	}else{
		    		swal("SUCCESS!","CI Rejected","success")
		    	}
				//dialog.find('.bootbox-body').html('<div class="text-center"><i class="fa fa-check-circle fa-4x"></i></div><div class="text-center"><h4><b>CI Rejected<b></h4></div>');
				
				$('#img'+<%=user.getEmployee_master_id()%>).css('border-color', 'red');
				$('#img'+<%=user.getManagerBean().getManager_id()%>).css('border-color', 'red');
				$('.approvButton').hide();
		    }
		}); 
	}
	
	
	
	
	function managemnetApprovalInsert() {
		
		
		
		
		$.ajax({
		    method: "POST",
		    url: 'kaizenManagementInsert',
		    data: {employee_id : $('#management_id').val(),kaizen_id : <%=kaizen_id%>},
		    success: function (data) {
		    	//alert(data);
		    	$('#acceptPanel').modal('hide');
				$('#addAuthorityModel').modal('hide');
				if(data == "null"){
		    		swal("Error!","Some Error occured !","error")
		    	}else{
		    		swal("SUCCESS!","Higher Authority Added Successfully.You need refresh page for show result.","success")
		    	}
		    }
		}); 
		
	}

	
	function managemnetApproval(value) {
		
		
		
		if(value == 1){ 
			$.ajax({
			    method: "POST",
			    url: 'kaizenManagementApproval',
			    data: {status : "approved",reason : "-",id : <%=kaizen_id%>},
			    success: function (data) {
			    	//alert(data);
			    	$('#acceptPanel').modal('hide');
					$('#addAuthorityModel').modal('hide');
					if(data == "null"){
			    		swal("Error!","Some Error occured !","error")
			    	}else{
			    		swal("SUCCESS!","Higher Authority Added Successfully.You need refresh page for show result.","success")
			    	}
			    }
			});
			
		}else if(value == 2){
			$.ajax({
			    method: "POST",
			    url: 'kaizenManagementApproval',
			    data: {status : "rejected",reason : $('#reason').val(),id : <%=kaizen_id%>},
			    success: function (data) {
			    	//alert(data);
			    	$('#rejectionPanel').modal('hide');
					if(data == "null"){
			    		swal("Error!","Some Error occured !","error")
			    	}else{
			    		swal("SUCCESS!","CI Rejected.","success")
			    	}
					$('#img'+<%=user.getEmployee_master_id()%>).css('border-color', 'red');
					$('.approvButton').hide();
			    }
			});
		}
	}
	
	
	function changeStatus(id) {
			
			/* var dialog = bootbox.dialog({
		    message: '<div class="text-center"><i class="fa fa-spin fa-spinner"></i> Loading...</div>',
		    onEscape : true,
		}); */

		$.ajax({
		    method: "POST",
		    url: 'kaizenStatusChange',
		    data: {id : id,status : "submitted"},
		    success: function (data) {
		    	//alert(data);
		    	$('#changeStatus').hide();
				$('#addEmployee').hide();
				$('#addManager').hide(); 
				if(data == "null"){
		    		swal("Error!","Some Error occured !","error")
		    	}else{
		    		swal("SUCCESS!","CI Locked","success")
		    	}
				//dialog.find('.bootbox-body').html('<div class="text-center"><i class="icon-checkmark-circled fa-4x"></i></div><div class="text-center"><h4><b>CI Locked<b></h4></div>');
		    }
		});
	}
	
	function changeStatusCompleted(id) {
	
		var retVal = confirm("Would you like to add After photos?");
		if( retVal == true){
			window.location.replace("kaizenPhotoUpload.jsp?kaizen_id="+<%=kaizen_id%>)
		}else{
		
		$.ajax({
		    method: "POST",
		    url: 'kaizenStatusChange',
		    data: {id : id,status : "completed"},
		    success: function (data) {
		    	//alert(data);
		    	var split = data.split(",");
				$('#cDate').text(split[0]);
				$('#days').text(split[1]+' Day(s)');
				$('#changeStatusCompleted').hide();
				$('#addPhoto').hide();
				$('#updateBtn').hide();
				
				if(data == "null"){
		    		swal("Error!","Some Error occured !","error")
		    	}else{
		    		swal("SUCCESS!","CI Completed","success")
		    	}
				//dialog.find('.bootbox-body').html('<div class="text-center"><i class="icon-checkmark-circled fa-4x"></i></div><div class="text-center"><h4><b>CI Locked<b></h4></div>');
		    }
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