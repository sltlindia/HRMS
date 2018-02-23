<%@page import="com.hrms.incentive.bean.IncentiveCriteriaHistoryBean"%>
<%@page import="com.hrms.incentive.bean.BrahmastraRepeatHistoryBean"%>
<%@page import="com.hrms.incentive.bean.AksharRepeatHistoryBean"%>
<%@page import="com.hrms.incentive.bean.BrahmastraNewHistoryBean"%>
<%@page import="com.hrms.incentive.bean.AksharNewHistoryBean"%>
<%@page import="com.hrms.incentive.bean.BrahmastraRepeatBean"%>
<%@page import="com.hrms.incentive.bean.AksharRepeatBean"%>
<%@page import="com.hrms.incentive.bean.BrahmastraNewBean"%>
<%@page import="com.hrms.incentive.bean.AksharNewBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveCriteriaBean"%>
<%@page import="com.hrms.incentive.bean.IncentiveBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.incentive.bean.TargetBean"%>
<%@page import="com.hrms.incentive.bean.LaserMasterBean"%>
<%@page import="com.hrms.incentive.bean.ClassificationBean"%>
<%@page import="com.hrms.incentive.bean.ProductMasterBean"%>
<%@page import="com.hrms.incentive.bean.ZoneBean"%>
<%@page import="com.hrms.incentive.bean.SalespersonBean"%>
<%@page import="com.hrms.incentive.dao.AllIncentiveListDAO"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//Dlabel HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dlabel">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Incentive</title>
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
<style type="text/css">
<%
String colorChanger = "";
if(request.getAttribute("colorChanger") != null){
	colorChanger = (String) request.getAttribute("colorChanger");
}
%>
#<%=colorChanger%> {
   background-color : #A9DFBF;
}

</style>


<%@include file="header.jsp"%>
</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%AllIncentiveListDAO allIncentiveListDAO = new AllIncentiveListDAO();%>
	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        	 <h1 class="page-header">Incentive Policy</h1>
				        	 <br>
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Incentive Master</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
	<!-- <div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Incentive Policy</h3>
				</div>
				/.col-lg-12
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Incentive Master</div> -->
						<div class="panel-body">

							<div class="tab-content">
								<div class="tab-pane fade in active" id="complaint">

									<div class="panel-body">
										<div class="dataTable_wrapper">
											<div class="panel-body">
											<div class="row">
											
												<div class="col-md-6">
												<h5>AKSHAR (For New Order)</h5>
												<table class="table table-striped table-bordered table-hover" border="3">
													<thead>
														<tr>
															<th>Sr No</th>
															<th>% Discount</th>
															<th>SE/SSE</th>
															<th>ASM</th>
															<th>ZSM</th>
															<th>Action</th>
														</tr>
													</thead>

													<tbody>
														<% 
										List<AksharNewBean> listOfAksharNewData  = allIncentiveListDAO.getListOfAksharNew();
														for(AksharNewBean aksharNewBean : listOfAksharNewData){
                                   				
                                   		%>
														<tr id="aksharNew<%=aksharNewBean.getAkshar_new_id()%>">
															<td><a id="aksharNewHistory<%=aksharNewBean.getAkshar_new_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData(this.id)"><i class="icon-android-add-circle"></i></a>&nbsp;&nbsp; <%=aksharNewBean.getAkshar_new_id() %></td>
															<td><%=aksharNewBean.getDiscount_to()%> - <%=aksharNewBean.getDiscount_from()%> </td>
															<td id="aksharnewse/sse"><%=aksharNewBean.getSe_sse()%></td>
															<td id="aksharnewasm"><%=aksharNewBean.getAsm()%></td>
															<td id="aksharnewzsm"><%=aksharNewBean.getZsm()%></td>
															<td><a href="" data-toggle="modal" data-target="#aksharNewOrder<%=aksharNewBean.getAkshar_new_id()%>"><i class="icon-edit2"></i></a></td>
														</tr>
														
														<tr class="aksharNewHistory<%=aksharNewBean.getAkshar_new_id()%>">
															<td colspan="6">
																<table class="table table-striped table-bordered table-hover" border="3">
																		<tr>
																			<th>Discount</th>
																			<th>SE/SSE</th>
																			<th>ASM</th>
																			<th>ZSM</th>
																			<th colspan="2">Time</th>
																		</tr>
																	
																	
																		<% 
																			List<AksharNewHistoryBean> listOfAksharNewHistoryData  = allIncentiveListDAO.getDetailOfNewAksharHistoryById(aksharNewBean.getAkshar_new_id());
																			for(AksharNewHistoryBean aksharNewHistoryBean : listOfAksharNewHistoryData){
				                                   						%>
				                                   						
																		<tr>
																			<td><%=aksharNewHistoryBean.getDiscount_to()%> - <%=aksharNewHistoryBean.getDiscount_from()%> </td>
																			<td><%=aksharNewHistoryBean.getSe_sse()%></td>
																			<td><%=aksharNewHistoryBean.getAsm()%></td>
																			<td><%=aksharNewHistoryBean.getZsm()%></td>
																			<td><%=aksharNewHistoryBean.getDate()%></td>
																		</tr>
																		<%} %>
																	
																	
																	
																</table>
															</td>
														</tr>
														
														
														
														 <div class="modal fade" id="aksharNewOrder<%=aksharNewBean.getAkshar_new_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								                                <div class="modal-dialog">
								                                    <div class="modal-content">
								                                    <form action="incentiveMasterEdit">
								                                        <div class="modal-header">
								                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								                                            <h4 class="modal-title" id="myModalLabel">AKSHAR (For New Order)</h4>
								                                        </div>
								                                        <div class="modal-body">
								                                        <input type="hidden" name="action" value="aksharNew">
																		<input type="hidden" name="akshar_new_id" value="<%=aksharNewBean.getAkshar_new_id()%>">
																		<label>% Discount To : </label><input type="text" name="discount_to" class="form-control" value="<%=aksharNewBean.getDiscount_to()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																		<label>% Discount From : </label><input type="text" name="discount_from" class="form-control" value="<%=aksharNewBean.getDiscount_from()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																		<label>SE/SSE : </label><input type="text" name="se_sse" class="form-control" value="<%=aksharNewBean.getSe_sse()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																		<label>ASM : </label><input type="text" name="asm" class="form-control" value="<%=aksharNewBean.getAsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																		<label>ZSM : </label><input type="text" name="zsm" class="form-control" value="<%=aksharNewBean.getZsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;">
																		
																		</div>
																		
								                                        <div class="modal-footer">
								                                        	 <input type="SUBMIT" class="btn btn-primary" value="SUBMIT">
								                                        	 <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
								                                        </div>
								                                      </form>
								                                    </div>
								                                    <!-- /.modal-content -->
								                                </div>
								                               <!--  /.modal-dialog -->
								                            </div>          
														
												<%} %>
													</tbody>
												</table>
																										
												</div>
												
												
												<div class="col-md-6">
												<h5>BRAHMASTRA (For New Order)</h5>
														<table class="table table-striped table-bordered table-hover" border="3">
													<thead>
														<tr>
															<th>Sr No</th>
															<th>% Discount</th>
															<th>AM</th>
															<th>RSM</th>
															<th>ZSM</th>
															<th>Action</th>
														</tr>
													</thead>

													<tbody>
														<% 
										List<BrahmastraNewBean> listOfBraAksharNewBean  = allIncentiveListDAO.getListOfBarahmashtraNew();
														for(BrahmastraNewBean brahmastraNewBean : listOfBraAksharNewBean){
                                   				
                                   		%>
														<tr id="brahmastraNew<%=brahmastraNewBean.getBrahmastra_new_id()%>">
															<td><a id="brahmastraNewHistory<%=brahmastraNewBean.getBrahmastra_new_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData(this.id)"><i class="icon-android-add-circle"></i></a>&nbsp;&nbsp;<%=brahmastraNewBean.getBrahmastra_new_id()%></td>
															<td><%=brahmastraNewBean.getDiscount_to()%> - <%=brahmastraNewBean.getDiscount_from()%></td>
															<td id="brahmastranewam"><%=brahmastraNewBean.getAm()%></td>
															<td id="brahmastranewrsm"><%=brahmastraNewBean.getRsm()%></td>
															<td id="brahmastranewzsm"><%=brahmastraNewBean.getZsm()%></td>
															<td><a href="" data-toggle="modal" data-target="#brahmastraNewOrder<%=brahmastraNewBean.getBrahmastra_new_id()%>"><i class="icon-edit2"></i></a></td>
														</tr>
														
														
														<tr class="brahmastraNewHistory<%=brahmastraNewBean.getBrahmastra_new_id()%>">
															<td colspan="6">
																<table class="table table-striped table-bordered table-hover" border="3">
																	<thead>
																		<tr>
																			<th>Discount</th>
																			<th>AM</th>
																			<th>RSM</th>
																			<th>ZSM</th>
																			<th colspan="2">Time</th>
																		</tr>
																	</thead>
																	
																	<tbody>
																	
																		<% 
																			List<BrahmastraNewHistoryBean> listOfBrahmastraNewHistoryData  = allIncentiveListDAO.getDetailOfNewBrahmastraHistoryById(brahmastraNewBean.getBrahmastra_new_id());
																			for(BrahmastraNewHistoryBean brahmastraNewHistoryBean : listOfBrahmastraNewHistoryData){
				                                   						%>
				                                   						
																		<tr>
																			<td><%=brahmastraNewHistoryBean.getDiscount_to()%> - <%=brahmastraNewHistoryBean.getDiscount_from()%> </td>
																			<td><%=brahmastraNewHistoryBean.getAm()%></td>
																			<td><%=brahmastraNewHistoryBean.getRsm()%></td>
																			<td><%=brahmastraNewHistoryBean.getZsm()%></td>
																			<td><%=brahmastraNewHistoryBean.getDate()%></td>
																		</tr>
																		<%} %>
																	</tbody>
																	
																	
																	
																</table>
															</td>
														</tr>
														
														
														 <div class="modal fade" id="brahmastraNewOrder<%=brahmastraNewBean.getBrahmastra_new_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								                                <div class="modal-dialog">
								                                    <div class="modal-content">
								                                    <form action="incentiveMasterEdit">
								                                        <div class="modal-header">
								                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								                                            <h4 class="modal-title" id="myModalLabel">BRAHMASTRA (For New Order)</h4>
								                                        </div>
																		<div class="modal-body">
																		<input type="hidden" name="brahmastra_new_id" value="<%=brahmastraNewBean.getBrahmastra_new_id()%>">
																		<input type="hidden" name="action" value="brahmastraNew">
																			<label>% Discount To : </label><input type="text" name="discount_to" class="form-control" value="<%=brahmastraNewBean.getDiscount_to()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>% Discount From : </label><input type="text" name="discount_from" class="form-control" value="<%=brahmastraNewBean.getDiscount_from()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>AM : </label><input type="text" name="asm" class="form-control" value="<%=brahmastraNewBean.getAm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>RSM : </label><input type="text" name="rsm" class="form-control" value="<%=brahmastraNewBean.getRsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>ZSM : </label><input type="text" name="zsm" class="form-control" value="<%=brahmastraNewBean.getZsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;">
																			
																		</div>
																		
								                                        <div class="modal-footer">
								                                        	 <input type="SUBMIT" class="btn btn-primary" value="SUBMIT">
								                                        	 <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
								                                        </div>
								                                        </form>
								                                    </div>
								                                    <!-- /.modal-content -->
								                                </div>
								                               <!--  /.modal-dialog -->
								                            </div>          
															
														
												<%} %>
													</tbody>
												</table>											
												</div>
											
											
											<div class="col-md-6">
											<h5>AKSHAR (For Repeat Order)</h5>
												<table class="table table-striped table-bordered table-hover" border="3">
													<thead>
														<tr>
															<th>Sr No</th>
															<th>% Discount</th>
															<th>SE/SSE</th>
															<th>ASM</th>
															<th>ZSM</th>
															<th>Service</th>
															<th>Action</th>
														</tr>
													</thead>

													<tbody>
														<% 
										List<AksharRepeatBean> listOfAksharRepeatData  = allIncentiveListDAO.getListOfAksharRepeat();
														for(AksharRepeatBean aksharRepeatBean : listOfAksharRepeatData){
                                   				
                                   		%>
														<tr id="aksharRepeat<%=aksharRepeatBean.getAkshar_repeat_id()%>">
															<td><a id="aksharRepeatHistory<%=aksharRepeatBean.getAkshar_repeat_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData(this.id)"><i class="icon-android-add-circle"></i></a>&nbsp;&nbsp;<%=aksharRepeatBean.getAkshar_repeat_id()%></td>
															<td><%=aksharRepeatBean.getDiscount_to()%> - <%=aksharRepeatBean.getDiscount_from()%> </td>
															<td id="aksharrepeatse/sse"><%=aksharRepeatBean.getSe_sse()%></td>
															<td id="aksharrepeatasm"><%=aksharRepeatBean.getAsm()%></td>
															<td id="aksharrepeatzsm"><%=aksharRepeatBean.getZsm()%></td>
															<td id="aksharrepeatservice"><%=aksharRepeatBean.getService() %></td>
															<td><a href="" data-toggle="modal" data-target="#aksharRepeatOrder<%=aksharRepeatBean.getAkshar_repeat_id()%>"><i class="icon-edit2"></i></a></td>
														</tr>
														
														<tr class="aksharRepeatHistory<%=aksharRepeatBean.getAkshar_repeat_id()%>">
															<td colspan="7">
																<table class="table table-striped table-bordered table-hover" border="3">
																	<thead>
																		<tr>
																			<th>Discount</th>
																			<th>SE/SSE</th>
																			<th>ASM</th>
																			<th>ZSM</th>
																			<th>Service</th>
																			<th colspan="2">Time</th>
																		</tr>
																	</thead>
																	
																	<tbody>
																	
																		<% 
																			List<AksharRepeatHistoryBean> listOfAksharRepeatHistoryData  = allIncentiveListDAO.getDetailOfRepeatAksharHistoryById(aksharRepeatBean.getAkshar_repeat_id());
																			for(AksharRepeatHistoryBean aksharRepeatHistoryBean : listOfAksharRepeatHistoryData){
				                                   						%>
				                                   						
																		<tr>
																			<td><%=aksharRepeatHistoryBean.getDiscount_to()%> - <%=aksharRepeatHistoryBean.getDiscount_from()%> </td>
																			<td><%=aksharRepeatHistoryBean.getSe_sse()%></td>
																			<td><%=aksharRepeatHistoryBean.getAsm()%></td>
																			<td><%=aksharRepeatHistoryBean.getZsm()%></td>
																			<td><%=aksharRepeatHistoryBean.getService()%></td>
																			<td colspan="2"><%=aksharRepeatHistoryBean.getDate()%></td>
																		</tr>
																		<%} %>
																	</tbody>
																	
																	
																	
																</table>
															</td>
														</tr>
															
															
															 <div class="modal fade" id="aksharRepeatOrder<%=aksharRepeatBean.getAkshar_repeat_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								                                <div class="modal-dialog">
								                                    <div class="modal-content">
								                                    <form action="incentiveMasterEdit">
								                                        <div class="modal-header">
								                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								                                            <h4 class="modal-title" id="myModalLabel">AKSHAR (For Repeat Order)</h4>
								                                        </div>
																		<div class="modal-body">
																		<input type="hidden" name="akshar_repeat_id" value="<%=aksharRepeatBean.getAkshar_repeat_id()%>">
																		<input type="hidden" name="action" value="aksharRepeat">
																			<label>% Discount To : </label><input type="text" name="discount_to" class="form-control" value="<%=aksharRepeatBean.getDiscount_to()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>% Discount From : </label><input type="text" name="discount_from" class="form-control" value="<%=aksharRepeatBean.getDiscount_from()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>SE/SSE : </label><input type="text" name="se_sse" class="form-control" value="<%=aksharRepeatBean.getSe_sse()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>ASM : </label><input type="text" name="asm" class="form-control" value="<%=aksharRepeatBean.getAsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>ZSM : </label><input type="text" name="zsm" class="form-control" value="<%=aksharRepeatBean.getZsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<label>Service : </label><input type="text" name="service" class="form-control" value="<%=aksharRepeatBean.getService()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;">
																			
																		</div>
																		
								                                        <div class="modal-footer">
								                                        	 <input type="SUBMIT" class="btn btn-primary" value="SUBMIT">
								                                        	 <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
								                                        </div>
								                                        </form>
								                                    </div>
								                                    <!-- /.modal-content -->
								                                </div>
								                               <!--  /.modal-dialog -->
								                            </div>          
															
														
												<%} %>
													</tbody>
												</table>
																										
												</div>
												
												
												<div class="col-md-6">
												<h5>BRAHMASTRA (For Repeat Order)</h5>
														<table class="table table-striped table-bordered table-hover" border="3">
													<thead>
														<tr>
															<th>Sr No</th>
															<th>% Discount</th>
															<th>SE/SSE</th>
															<th>ASM</th>
															<th>ZSM</th>
															<th>Service</th>
															<th>Action</th>
														</tr>
													</thead>

													<tbody>
														<% 
										List<BrahmastraRepeatBean> listOfBrahmastraRepeat  = allIncentiveListDAO.getListOfBarahmashtraRepeat();
														for(BrahmastraRepeatBean brahmastraRepeatBean : listOfBrahmastraRepeat){
                                   				
                                   		%>
														<tr id="brahmastraRepeat<%=brahmastraRepeatBean.getBrahmastra_repeat_id()%>">
															<td><a id="brahmastraRepeatHistory<%=brahmastraRepeatBean.getBrahmastra_repeat_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData(this.id)"><i class="icon-android-add-circle"></i></a>&nbsp;&nbsp;<%=brahmastraRepeatBean.getBrahmastra_repeat_id()%></td>
															<td><%=brahmastraRepeatBean.getDiscount_to()%> - <%=brahmastraRepeatBean.getDiscount_from()%></td>
															<td id="brahmastrarepeatsesse"><%=brahmastraRepeatBean.getSe_sse()%></td>
															<td id="brahmastrarepeatasm"><%=brahmastraRepeatBean.getAsm()%></td>
															<td id="brahmastrarepeatzsm"><%=brahmastraRepeatBean.getZsm()%></td>
															<td id="brahmastrarepeatservice"><%=brahmastraRepeatBean.getService() %></td>
															<td><a href="" data-toggle="modal" data-target="#brahmastraRepeatOrder<%=brahmastraRepeatBean.getBrahmastra_repeat_id()%>"><i class="icon-edit2"></i></a></td>
														</tr>
														
														<tr class="brahmastraRepeatHistory<%=brahmastraRepeatBean.getBrahmastra_repeat_id()%>">
															<td colspan="7">
																<table class="table table-striped table-bordered table-hover" border="3">
																	<thead>
																		<tr>
																			<th>Discount</th>
																			<th>SE/SSE</th>
																			<th>ASM</th>
																			<th>ZSM</th>
																			<th>Service</th>
																			<th colspan="2">Time</th>
																		</tr>
																	</thead>
																	
																	<tbody>
																	
																		<% 
																			List<BrahmastraRepeatHistoryBean> listOfBrahmastraRepeatHistoryData  = allIncentiveListDAO.getDetailOfRepeatBrahmastraRepeatById(brahmastraRepeatBean.getBrahmastra_repeat_id());
																			for(BrahmastraRepeatHistoryBean brahmastraRepeatHistoryBean : listOfBrahmastraRepeatHistoryData){
				                                   						%>
				                                   						
																		<tr>
																			<td><%=brahmastraRepeatHistoryBean.getDiscount_to()%> - <%=brahmastraRepeatHistoryBean.getDiscount_from()%> </td>
																			<td><%=brahmastraRepeatHistoryBean.getSe_sse()%></td>
																			<td><%=brahmastraRepeatHistoryBean.getAsm()%></td>
																			<td><%=brahmastraRepeatHistoryBean.getZsm()%></td>
																			<td><%=brahmastraRepeatHistoryBean.getService()%></td>
																			<td colspan="2"><%=brahmastraRepeatHistoryBean.getDate()%></td>
																		</tr>
																		<%} %>
																	</tbody>
																	
																	
																	
																</table>
															</td>
														</tr>
														
															 <div class="modal fade" id="brahmastraRepeatOrder<%=brahmastraRepeatBean.getBrahmastra_repeat_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									                                <div class="modal-dialog">
									                                    <div class="modal-content">
									                                    <form action="incentiveMasterEdit">
									                                        <div class="modal-header">
									                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									                                            <h4 class="modal-title" id="myModalLabel">BRAHMASTRA (For Repeat Order)</h4>
									                                        </div>
																			<div class="modal-body">
																			<input type="hidden" name="brahmastra_repeat_id" value="<%=brahmastraRepeatBean.getBrahmastra_repeat_id()%>">
																			<input type="hidden" name="action" value="brahmastraRepeat">
																				<label>% Discount To : </label><input type="text" name="discount_to" class="form-control" value="<%=brahmastraRepeatBean.getDiscount_to()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																				<label>% Discount From : </label><input type="text" name="discount_from" class="form-control" value="<%=brahmastraRepeatBean.getDiscount_from()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																				<label>SE/SSE : </label><input type="text" name="se_sse" class="form-control" value="<%=brahmastraRepeatBean.getSe_sse()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																				<label>ASM : </label><input type="text" name="asm" class="form-control" value="<%=brahmastraRepeatBean.getAsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																				<label>ZSM : </label><input type="text" name="zsm" class="form-control" value="<%=brahmastraRepeatBean.getZsm()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																				<label>Service : </label><input type="text" name="service" class="form-control" value="<%=brahmastraRepeatBean.getService()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;">
																				
																			</div>
																			
									                                        <div class="modal-footer">
									                                        	 <input type="SUBMIT" class="btn btn-primary" value="SUBMIT">
									                                        	 <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
									                                        </div>
									                                        </form>
									                                    </div>
									                                    <!-- /.modal-content -->
									                                </div>
									                               <!--  /.modal-dialog -->
									                            </div>     
															
												<%} %>
													</tbody>
												</table>											
												</div>
											
																				
										<div class="col-md-6">
												<h5>Incentive Criteria</h5>
														<table class="table table-striped table-bordered table-hover" border="3">
													<thead>
														<tr>
															<th>Sr No</th>
															<th>Target To</th>
															<th>Target From</th>
															<th>Eligible Incentive</th>
															<th>Action</th>
														</tr>
													</thead>

													<tbody>
													
													<%  List<IncentiveCriteriaBean> listOfIncentiveCriteria = allIncentiveListDAO.getListOfIncentiveCriteria();
														for(IncentiveCriteriaBean incentiveCriteriaBean : listOfIncentiveCriteria){
													%>
													
														<tr id="incentiveCriteria<%=incentiveCriteriaBean.getIncentive_criteria_id()%>">
															<td><a id="incentiveCriteriaHistory<%=incentiveCriteriaBean.getIncentive_criteria_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData(this.id)"><i class="icon-android-add-circle"></i></a>&nbsp;&nbsp;<%=incentiveCriteriaBean.getIncentive_criteria_id()%></td>
															<td><%=incentiveCriteriaBean.getTarget_to()%></td>
															<td>
															<%if(incentiveCriteriaBean.getTarget_to() >= 100){ %>
															> <%=incentiveCriteriaBean.getTarget_to()%>
															<%}else{ %>
															<%=incentiveCriteriaBean.getTarget_from()%>
															<%} %>
															
															</td>
															<td><%=incentiveCriteriaBean.getEligible_incentive()%></td>
															<td><a href="" data-toggle="modal" data-target="#incentiveCriteria<%=incentiveCriteriaBean.getIncentive_criteria_id()%>"><i class="icon-edit2"></i></a></td>
														</tr>
														
														<tr class="incentiveCriteriaHistory<%=incentiveCriteriaBean.getIncentive_criteria_id()%>">
															<td colspan="6">
																<table class="table table-striped table-bordered table-hover" border="3">
																	<thead>
																		<tr>
																			<th>Target To</th>
																			<th>Target From</th>
																			<th>Eligible Incentive</th>
																			<th colspan="2">Time</th>
																		</tr>
																	</thead>
																	
																	<tbody>
																	
																		<% 
																			List<IncentiveCriteriaHistoryBean> listOfIncentiveCriteriaHistoryData  = allIncentiveListDAO.getDetailOfIncentiveCriteriaHistoryById(incentiveCriteriaBean.getIncentive_criteria_id());
																			for(IncentiveCriteriaHistoryBean incentiveCriteriaHistoryBean : listOfIncentiveCriteriaHistoryData){
				                                   						%>
				                                   						
																		<tr>
																			<td><%=incentiveCriteriaHistoryBean.getTarget_to()%></td>
																			<td><%=incentiveCriteriaHistoryBean.getTarget_to()%></td>
																			<td><%=incentiveCriteriaHistoryBean.getEligible_incentive()%></td>
																			<td colspan="2"><%=incentiveCriteriaHistoryBean.getDate()%></td>
																		</tr>
																		<%} %>
																	</tbody>
																	
																	
																	
																</table>
															</td>
														</tr>
														
													
														<div class="modal fade" id="incentiveCriteria<%=incentiveCriteriaBean.getIncentive_criteria_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								                                <div class="modal-dialog">
								                                    <div class="modal-content">
								                                    <form action="incentiveMasterEdit">
								                                        <div class="modal-header">
								                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								                                            <h4 class="modal-title" id="myModalLabel">Incentive Criteria</h4>
								                                        </div>
																		<div class="modal-body">
																		<input type="hidden" name="incentive_criteria_id" value="<%=incentiveCriteriaBean.getIncentive_criteria_id()%>">
																		<input type="hidden" name="action" value="incentiveCriteria">
																			<label>% Target To : </label><input type="text" name="discount_to" class="form-control" value="<%=incentiveCriteriaBean.getTarget_to()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<%if(incentiveCriteriaBean.getTarget_to() != 100) {%>
																			<label>% Target From : </label><input type="text" name="discount_from" class="form-control" value="<%=incentiveCriteriaBean.getTarget_from()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			<%}else{ %>
																			<input type="hidden" name="discount_from" class="form-control" value="200">
																			<%} %>
																			<label>Eligible Incentive : </label><input type="text" name="eligible_criteria" class="form-control" value="<%=incentiveCriteriaBean.getEligible_incentive()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>
																			
																		</div>
																		
								                                        <div class="modal-footer">
								                                        	 <input type="SUBMIT" class="btn btn-primary" value="SUBMIT">
								                                        	 <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
								                                        </div>
								                                        </form>
								                                    </div>
								                                    <!-- /.modal-content -->
								                                </div>
								                               <!--  /.modal-dialog -->
								                            </div>       
													<%} %>	
															
													</tbody>
												</table>											
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
	<script type="text/javascript">

$(document).ready(function(){
	for(var i=1;i<=4;i++){
		 $(".aksharNewHistory"+i).hide();
		 $(".brahmastraNewHistory"+i).hide();
		 $(".aksharRepeatHistory"+i).hide();
		 $(".brahmastraRepeatHistory"+i).hide();
		 $(".incentiveCriteriaHistory"+i).hide();
	}
	
});


function showData(id){
	 $("."+id).slideToggle(2);
     $("i", "#"+id).toggleClass("icon-android-remove-circle icon-android-add-circle");
}

</script>
	
	
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
        $('#dataTables-example1').DataTable({
            responsive: true
    });
        $('#dataTables-example2').DataTable({
            responsive: true
    });
    });
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