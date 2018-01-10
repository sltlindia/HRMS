<%@page import="com.hrms.tds.bean.TDSPayrollBean"%>
<%@page import="com.hrms.tds.bean.TDSPayrollMasterDataBean"%>
<%@page import="com.hrms.tds.dao.TDSListDAO"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.ArrayList"%>
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
    <title>Upload Document</title>
    <link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/users.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/dropzone.css">
    <script src="js/dropzone.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
<style type="text/css">
    #tablePadding{
		padding-left: 3px;
	}
    </style>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h4>Uploaded Salary Data</h4>
			            <hr>
			        </div>
			    </div>
		
		<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Document Upload</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
				            <div class="card-body collapse in">
	               				 <div class="card-block">
	               				 		<div class="row">
											<div class="col-lg-12">
												<div class="col-lg-2"><label>Please Enter Key</label></div>
							       				<div class="col-lg-3"><input type="password" class="form-control" name="password" id="password" onchange="test();"></div>
							       			</div>
						       			</div>
						       			<br>
										<div class="row" id="ListType">
												<div class="col-lg-12">
													<div class="col-lg-3"><label>Select Which Data You Want To See</label></div>
													<div class="col-lg-3">
														<input type="radio" name="dataType" value="Master" onclick="show()">Master Data
														<input type="radio" name="dataType" value="Basic" onclick="show()">Basic Data
													</div>
								       			</div>
								       	</div>
	               				 </div>
	               			</div>
	               			
	               			
				        </div>
				    </div>
		</div>
		
           <div class="row" id="masterSalaryData">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Master Data</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
		 <div class="card-body collapse in">
	         <div class="card-block">
               	<div class="table-responsive">
					<table class="table table-striped table-bordered zero-configuration" width="100%">
               	<thead>
               		<tr>
               			<th id="tablePadding">Code</th>
               			<th id="tablePadding" width="30%;">Employee Name</th>
               			<th id="tablePadding">Salary</th>
               			<th id="tablePadding">Bonus</th>
               			<th id="tablePadding">Leave</th>
               			<th id="tablePadding">Incentive</th>
               			<th id="tablePadding">Previous Salary</th>
               			<th id="tablePadding">Performance</th>
               			<th id="tablePadding">LTC</th>
               			<th id="tablePadding">PTAX</th>
               			<th id="tablePadding">Meal Card</th>
               			<th id="tablePadding">PF</th>
               			<th id="tablePadding">Action</th>
               		</tr>
               	</thead>
               	<tbody>
               		<% TDSListDAO tdsListDAO = new TDSListDAO();
               			List<TDSPayrollMasterDataBean> dataBeans = tdsListDAO.getListOfPayrollData();
               			for(TDSPayrollMasterDataBean bean : dataBeans){
               		%>
               	
	               	<tr>
	               		<td id="employeeCode<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getEmployee_code() %></td>
	               		<td id="employeeName<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getEmployee_name() %></td>
	               		<td id="salary<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getSalary() %></td>
	               		<td id="bonus_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getBonus() %></td>
	               		<td id="leave_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getLeave_count() %></td>
	               		<td id="incentive_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getIncentive() %></td>
	               		<td id="previousSalary_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getPrevious_salary() %></td>
	               		<td id="performance_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getPerformance() %></td>
	               		<td id="ltc_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getLta() %></td>
	               		<td id="ptax_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getPtax() %></td>
	               		<td id="mealCard_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getMealcard() %></td>
	               		<td id="pf_data<%=bean.getTds_payroll_master_data_id()%>" style="padding : 3px;"><%=bean.getEpf() %></td>
	               		<td style="padding-left: 3px;"><a href="" data-toggle="modal" data-target="#MasterData<%=bean.getTds_payroll_master_data_id()%>"><i class="icon-edit" data-toggle="tooltip" data-placement="top" title="Update Data"></i></a></td>
	               	</tr>
	               	<%} %>
	            </tbody>
               </table>
               </div>
			</div>
          </div>
        </div>
        </div>
        </div>
        												<% for(TDSPayrollMasterDataBean bean : dataBeans){%>
        																	<div class="modal fade" id="MasterData<%=bean.getTds_payroll_master_data_id()%>" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content" style="width: 700px;">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Master Data</h4>
																							</div>
																							<form id="form<%=bean.getTds_payroll_master_data_id()%>">
																							<div class="modal-body">
																								<table class="table">

																										<input type="hidden" class="form-control" name="id" id="id" value="<%=bean.getTds_payroll_master_data_id() %>">
																									<tr>
																										<td>Employee Name</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="employeeName" id="employeeName" value="<%=bean.getEmployee_name() %>"></td>
																										<td>Employee Code</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="employeeCode" id="employeeCode" value="<%=bean.getEmployee_code() %>"></td>
																									</tr>
																									<tr>
																										<td>Employee Company</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="employeeCompany" id="employeeCompany" value="<%=bean.getCompany_name() %>"></td>
																										<td>Annual Salary</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="annualSalary" id="annualSalary<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getSalary() %>"></td>
																									</tr>
																									<tr>
																										<td>Bonus</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="bonus" id="bonus<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getBonus() %>"></td>
																										<td>Leave</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="leave" id="leave<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getLeave_count() %>"></td>
																									</tr>
																									<tr>
																										<td>Incentive</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="incentive" id="incentive<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getIncentive() %>"></td>
																										<td>Previous Salary</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="previousSalary" id="previousSalary<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getPrevious_salary() %>"></td>
																									</tr>
																									<tr>
																										<td>Full & Final Leave</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="fullFinalLeave" id="fullFinalLeave<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getFull_final_leave() %>"></td>
																										<td>Full & Final Bonus</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="fullFinalBonus" id="fullFinalBonus<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getFull_final_bonus() %>"></td>
																									</tr>
																									<tr>
																										<td>Performance</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="performance" id="performance<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getPerformance() %>"></td>
																										<td>LTC</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="ltc" id="ltc<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getLta() %>"></td>
																									</tr>
																									<tr>
																										<td>PTAX</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="ptax" id="ptax<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getPtax() %>"></td>
																										<td>PF</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="pf" id="pf<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getEpf() %>"></td>
																									</tr>
																									<tr>
																										<td>Meal Card</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="mealCard" id="mealCard<%=bean.getTds_payroll_master_data_id() %>" value="<%=bean.getMealcard() %>"></td>
																									</tr>
																								</table>
																								
																							</div>
																							<input type="hidden" name="action" value="Master">
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="updateData(<%=bean.getTds_payroll_master_data_id()%>,'Master');">
																							</div>
																							</form>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<%} %>
        	
        	
        	
               <div class="row" id="basicSalaryData">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Basic Data</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
		 <div class="card-body collapse in">
	         <div class="card-block">
               		<div class="table-responsive">
					<table class="table table-striped table-bordered zero-configuration" width="100%">
               	<thead>
               		<tr>
               			<th id="tablePadding">Code</th>
               			<th id="tablePadding">Basic Salary</th>
               			<th id="tablePadding">Conveyance</th>
               			<th id="tablePadding">Medical</th>
               			<th id="tablePadding">Edu Allw</th>
               			<th id="tablePadding">Uni Allw</th>
               			<th id="tablePadding">HRA</th>
               			<th id="tablePadding">Annual Basic Salary</th>
               			<th id="tablePadding">Annual Conveyance</th>
               			<th id="tablePadding">Annual Medical</th>
               			<th id="tablePadding">Annual Edu Allw</th>
               			<th id="tablePadding">Annual Uni Allw</th>
               			<th id="tablePadding">Annual HRA</th>
               			<th id="tablePadding">Action</th>
               		</tr>
               	</thead>
               	<tbody>
               		<% 
               			List<TDSPayrollBean> basicDataBeans = tdsListDAO.getListOfBasicPayrollData();
               			for(TDSPayrollBean basiDataBean : basicDataBeans){
               		%>
               	
	               	<tr>
	               		<td style="padding : 3px;"><%=basiDataBean.getEmployee_code() %></td>
	               		<td id="basicSalaryData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getBasic_salary() %></td>
	               		<td id="conveyanceData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getConveyance() %></td>
	               		<td id="medicalData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getMedical() %></td>
	               		<td id="eduAllwData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getEdu_allw() %></td>
	               		<td id="uniAllwData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getUni_allw() %></td>
	               		<td id="hraData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getHra() %></td>
	               		<td id="annualBasicSalaryData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getAnnual_basic_salary() %></td>
	               		<td id="annualConveyanceData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getAnnual_conveyance() %></td>
	               		<td id="annualMedicalData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getAnnual_medical() %></td>
	               		<td id="annualEduAllwData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getAnnual_edu_allw() %></td>
	               		<td id="annualUniAllwData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getAnnual_uni_allw() %></td>
	               		<td id="annualHraData<%=basiDataBean.getTds_payroll_id()%>" style="padding : 3px;"><%=basiDataBean.getAnnual_hra() %></td>
	               		<td style="padding : 3px;"><a href="" data-toggle="modal" data-target="#BasicData<%=basiDataBean.getTds_payroll_id()%>"><i class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="Update Data"></i></a></td>
	               	</tr>
	               	<%} %>
	            </tbody>
               </table>
               </div>
		</div>
            </div>
        </div>
        </div>
        </div>
        
        									<%for(TDSPayrollBean basiDataBean : basicDataBeans){ %>
        									<div class="modal fade" id="BasicData<%=basiDataBean.getTds_payroll_id()%>" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content" style="width: 700px;">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Master Data</h4>
																							</div>
																							<form id="basicForm<%=basiDataBean.getTds_payroll_id()%>">
																							<div class="modal-body">
																								<table class="table">
																										
																									<input type="hidden" class="form-control" name="basicId" id="basicId" value="<%=basiDataBean.getTds_payroll_id()%>">
																									<tr>
																										<td>Employee Name</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="employeeName" id="employeeName" value=""></td>
																										<td>Employee Code</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="employeeCode" id="employeeCode" value="<%=basiDataBean.getEmployee_code() %>"></td>
																									</tr>
																									<tr>
																										<td>Employee Company</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="employeeCompany" id="employeeCompany" value="<%=basiDataBean.getCompany_name() %>"></td>
																										<td>Basic Salary</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="basicSalary" id="basicSalary<%=basiDataBean.getTds_payroll_id() %>" value="<%=basiDataBean.getBasic_salary() %>"></td>
																									</tr>
																									<tr>
																										<td>Conveyance</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="conveyance" id="conveyance<%=basiDataBean.getTds_payroll_id() %>" value="<%=basiDataBean.getConveyance() %>"></td>
																										<td>Medical</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="medical" id="medical<%=basiDataBean.getTds_payroll_id() %>" value="<%=basiDataBean.getMedical() %>"></td>
																									</tr>
																									<tr>
																										<td>Uniform Allowance</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="uniAllw" id="uniAllw<%=basiDataBean.getTds_payroll_id() %>" value="<%=basiDataBean.getUni_allw()%>"></td>
																										<td>Education Allowance</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="eduAllw" id="eduAllw<%=basiDataBean.getTds_payroll_id()%>" value="<%=basiDataBean.getEdu_allw()%>"></td>
																									</tr>
																									<tr>
																										<td>HRA</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="hra" id="hra<%=basiDataBean.getTds_payroll_id()%>" value="<%=basiDataBean.getHra()%>"></td>
																										<td>Annual Basic Salary</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="annualBasicSalary" id="annualBasicSalary<%=basiDataBean.getTds_payroll_id()%>" value="<%=basiDataBean.getAnnual_basic_salary() %>"></td>
																									</tr>
																									<tr>
																										<td>Annual Conveyance</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="annualConveyance" id="annualConveyance<%=basiDataBean.getTds_payroll_id() %>" value="<%=basiDataBean.getAnnual_conveyance() %>"></td>
																										<td>Annual Medical</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="annualMedical" id="annualMedical<%=basiDataBean.getTds_payroll_id()%>" value="<%=basiDataBean.getAnnual_medical() %>"></td>
																									</tr>
																									<tr>
																										<td>Annual Uniform Allowance</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="annualUniAllow" id="annualUniAllow<%=basiDataBean.getTds_payroll_id()%>" value="<%=basiDataBean.getAnnual_uni_allw() %>"></td>
																										<td>Annual Education Allowance</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="annualEduAllow" id="annualEduAllow<%=basiDataBean.getTds_payroll_id()%>" value="<%=basiDataBean.getAnnual_edu_allw()%>"></td>
																									</tr>
																									<tr>
																										<td>Annual HRA</td>
																										<td>:</td>
																										<td><input type="text" class="form-control" name="annualHra" id="annualHra<%=basiDataBean.getTds_payroll_id()%>" value="<%=basiDataBean.getAnnual_hra()%>"></td>
																									</tr>
																								</table>
																								
																							</div>
																							<input type="hidden" name="action" value="Basic">
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="updateBasicData(<%=basiDataBean.getTds_payroll_id()%>);">
																							</div>
																							</form>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
       	</section>
       	</div>
        </div>													<%} %>
		</div>
	
	<%@include file="footer.html"%>

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
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe-ui-default.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	
	<script type="text/javascript">
	
		
			function test() {

				var password = "SLTL@123";
				var test = $("#password").val();
				//alert(test);
				
				if(test == password)
				{
					$("#ListType").show();
				}
				else
				{
					 $("#ListType").hide();
					 alert("Please Check Your Key....And Enter Right Key...");
				}
			}
			
			function show() {
				var type = $('input[name=dataType]:checked').val();
				//alert(type);
				if(type == "Master")
				{
					$("#masterSalaryData").show();
					$("#basicSalaryData").hide();
				}
				else if(type == "Basic")
				{
					$("#basicSalaryData").show();
					$("#masterSalaryData").hide();
				}
			}
			
			var id;
			function updateData(id) {
				id = id;
					var salary = $("#annualSalary"+id).val();
					var bonus = $("#bonus"+id).val();
					var leave = $("#leave"+id).val();
					var incentive = $("#incentive"+id).val();
					var previousSalary = $("#previousSalary"+id).val();
					var performance = $("#performance"+id).val();
					var fullFinalLeave = $("#fullFinalLeave"+id).val();
					var fullFinalBonus = $("#fullFinalBonus"+id).val();
					var ltc = $("#ltc"+id).val();
					var ptax = $("#ptax"+id).val();
					var pf = $("#pf"+id).val();
					var mealCard = $("#mealCard"+id).val();
					
					
					$.ajax({
	   				    method: "get",
	   				    url: 'updatePayrollMasterData',
	   				    data:$('#form'+id).serialize(),
	   				    success: function (data) {
	   				    	alert("Data Updated Successfully...!!!");
	   				    	
	   				    	$("#salary"+id).text(salary);
	   				    	$("#bonus_data"+id).text(bonus);
	   				    	$("#leave_data"+id).text(leave);
	   				    	$("#incentive_data"+id).text(incentive);
	   				    	$("#previousSalary_data"+id).text(previousSalary);
	   				    	$("#performance_data"+id).text(performance);
	   				    	$("#fullFinalLeave_data"+id).text(fullFinalLeave);
	   				    	$("#fullFinalBonus_data"+id).text(fullFinalBonus);
	   				    	$("#ltc_data"+id).text(ltc);
	   				    	$("#ptax_data"+id).text(ptax);
	   				    	$("#pf_data"+id).text(pf);
	   				    	$("#mealCard_data"+id).text(mealCard);
	   				    }
					});
			}
			
			var payroll_id;
			function updateBasicData(id)
			{
				payroll_id = id;
				var basicSalary = $("#basicSalary"+id).val();
				var conveyance = $("#conveyance"+id).val();
				var medical = $("#medical"+id).val();
				var eduAllw = $("#eduAllw"+id).val();
				var uniAllw = $("#uniAllw"+id).val();
				var hra = $("#hra"+id).val();
				var annualBasicSalary = $("#annualBasicSalary"+id).val();
				var annualConveyance = $("#annualConveyance"+id).val();
				var annualMedical = $("#annualMedical"+id).val();
				var annualEduAllw = $("#annualUniAllow"+id).val();
				var annualUniAllw = $("#annualUniAllow"+id).val();
				var annualHra = $("#annualHra"+id).val();
				
				$.ajax({
   				    method: "get",
   				    url: 'updatePayrollBasicData',
   				    data:$('#basicForm'+id).serialize(),
   				    success: function (data) {
   				    	alert("Data Updated Successfully...!!!");
   				    	
   				    	$("#basicSalaryData"+id).text(basicSalary);
   				    	$("#conveyanceData"+id).text(conveyance);
   				    	$("#medicalData"+id).text(medical);
   				    	$("#eduAllwData"+id).text(eduAllw);
   				    	$("#uniAllwData"+id).text(uniAllw);
   				    	$("#hraData"+id).text(hra);
   				    	$("#annualBasicSalaryData"+id).text(annualBasicSalary);
   				    	$("#annualConveyanceData"+id).text(annualConveyance);
   				    	$("#annualMedicalData"+id).text(annualMedical);
   				    	$("#annualEduAllwData"+id).text(annualEduAllw);
   				    	$("#annualUniAllwData"+id).text(annualUniAllw);
   				    	$("#annualHraData"+id).text(annualHra);
   				    }
				});
			}
		
	</script>
	
	
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
		
		$(document).ready(function() {
			$("#basicSalaryData").hide();
			$("#masterSalaryData").hide();
			$("#ListType").hide();
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
	
	<script src="js/index.js"></script>
</body>
</html>