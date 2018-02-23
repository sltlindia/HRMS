<%@page import="com.hrms.incentive.bean.IncentiveDesignationBean"%>
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
    <title>Incentive Master</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
function getRespose(id){
			 dwr.util.removeAllOptions('reportingId');
			 IncentiveAjaxDataDAO.getnameOfPersonByDesignation(id,function(data){
			dwr.util.addOptions('reportingId',["---Select---"]);
			var data1=[{ fullname:'--- Select Task ---', sales_person_id:'' }];
			dwr.util.addOptions("taskName1",data1,"task_master_id","task_master_name");
			dwr.util.addOptions('reportingId',data,"sales_person_id","fullname");
			});
	
}	



	
</script>
</head>
<%@include file="header.jsp"%>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
	<%
int product_master_id = 0;
int i = 0;
String action = "sales";

if(session.getAttribute("incentiveMasterAction") != null){
	action = (String) session.getAttribute("incentiveMasterAction");
}else if(request.getParameter("incentiveMasterAction") != null){
	action = request.getParameter("incentiveMasterAction");
}

AllIncentiveListDAO allIncentiveListDAO1 = new AllIncentiveListDAO();

%>

<%if(request.getAttribute("success") !=null) {%>
		 		<div class="panel-body" id="panelbody">
                            <div class="alert alert-dismissable alert-success ">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 <%=session.getAttribute("success") %>
                            </div>
          		</div>  
          		<%} %>

	<div class="app-content container center-layout mt-2">
		<div class="content-wrapper">
			<div class="content-body">
				<section id="horizontal-form-layouts">
				<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic"> Incentive Master Data</h4>
				               		
				                </div>
				            </div>
				            
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
						<div class="panel-body">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs nav-linetriangle no-hover-bg">

								<%if(action.equalsIgnoreCase("sales")){%><li class="nav-item">
									<%}else{%>
								
								<li class="nav-item">
									<%} %><a class="nav-link active" id="base-tab" aria-expanded="true" href="#sales" data-toggle="tab">Sales Person</a>
								</li>
								
								<%if(action.equalsIgnoreCase("laser")){%>
									<%}else{%>
								
								<li class="nav-item">
									<%} %><a class="nav-link" id="base-tab" aria-expanded="true" href="#laser" data-toggle="tab">Laser Source Master</a>
								</li>
								
								<%if(action.equalsIgnoreCase("product")){%>
									<%}else{%>
								
								<li class="nav-item">
									<%} %><a class="nav-link" id="base-tab" aria-expanded="true" href="#product" data-toggle="tab">Product Master</a>
								</li>
								<%if(action.equalsIgnoreCase("classification")){%>
									<%}else{%>
								
								<li class="nav-item">
									<%} %><a class="nav-link" id="base-tab" aria-expanded="true" href="#classification" data-toggle="tab">Classification
										Master</a>
								</li>
								

							</ul>

							<!-- Tab panes -->
							<div class="tab-content">

								<%if(action.equalsIgnoreCase("sales")){ %>
								<div class="tab-pane fade in active" id="sales">
									<%}else{ %>
									<div class="tab-pane fade" id="sales">
										<%} %>


										<form action="salesPersonInsert" method="post">
											<table>


												<div class="row">
													<br>
													<div class="col-lg-4">
														<label>Employee Name</label> <input list="employee"
															class="form-control" name="employee_name"
															placeholder="Select Employee Code"
															onchange="replica(this.value)" required>
														<datalist id="employee"> <%
			  				 		AllListDAO allListDAO = new AllListDAO();
			  				 		List<EmployeeBean> listOfEmployee = allListDAO.getFullListOfEmployee();
			  				 		for(EmployeeBean e : listOfEmployee){
			  				 		%>
														<option
															value="<%=e.getEmployee_code()+","+e.getFirstname().trim()+" "+e.getLastname().trim()%>" />
														<%} %> </datalist>
													</div>

													<div class="col-lg-4">
														<label>Designation</label> <select class="form-control"
															name="designation" id="designation"
															placeholder="Enter Designation" required onchange="getRespose(this.value)">
															<option value="">---Select Designation---</option>
															
															<%List<IncentiveDesignationBean> listOfDesignation = allIncentiveListDAO1.getnameOfDesignation(); 
																for(IncentiveDesignationBean designationBean : listOfDesignation){
															%>
															<option value="<%=designationBean.getIncentive_designation_name()%>"><%=designationBean.getIncentive_designation_name()%></option>
															<%} %>

														</select>
													</div>

													<div class="col-lg-4">
														<label>Alias Name</label> <input type="text"
															class="form-control" name="alias" id="alias"
															placeholder="Enter Aliasname" value="" required>
													</div>
													
													
													
													
												</div>
												<br>

												<input type="hidden" name="redirect" value="">
												<center>
													<input type="submit" value="Submit" class="btn btn-primary">
													<input type="reset" value="Reset" class="btn btn-danger">
												</center>
											</table>
										</form>

										<br>

										<div class="panel panel-primary">
											<!-- <div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#"
														href="#collapseOne">Sales Person List</a>
												</h4>
											</div> -->

											<div class="panel-body">
												<div class="dataTable_wrapper">
													<div class="table-responsive">
														<table
															class="table table-striped table-bordered table-hover"
															id="dataTables-example1">
															<thead>
																<tr>
																	<th>No.</th>
																	<th>First Name</th>
																	<th>Middle Name</th>
																	<th>Last Name</th>
																	<th>Designation</th>
																	<th>Alias</th>
																	<th>Action</th>

																</tr>
															</thead>
															<tbody>
																<%
															
															
																List<SalespersonBean> listOfSalesPerson = allIncentiveListDAO1.getListOfSalesPerson();
																for (SalespersonBean s : listOfSalesPerson) {
															%>
																<tr class="odd gradeX">
																	<td><%=i = i + 1%></td>
																	<td><%=s.getFirstname()%></td>
																	<td><%=s.getMiddlename()%></td>
																	<td><%=s.getLastname()%></td>
																	<td><%=s.getDesignation()%></td>
																	<td><%=s.getAlias()%></td>
																	<td><a href="" data-toggle="modal"
																		data-target="#sales1<%=s.getSales_person_id()%>"><i
																			class="icon-edit2"></i></a></td>
																</tr>
																<%
																}	
															%>
															</tbody>

														</table>
													</div>
													<%
															for (SalespersonBean s : listOfSalesPerson) {
						 %>
													<div class="modal fade"
														id="sales1<%=s.getSales_person_id()%>" tabindex="-1"
														role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<form action="salesMasterUpdate">
																	<div class="modal-header">
																		<button type="button" class="close"
																			data-dismiss="modal" aria-hidden="true">&times;</button>
																		<h4 class="modal-title" id="myModalLabel">Sales
																			Master Update</h4>
																	</div>
																	<div class="modal-body">
																	<input type="hidden" name="action" value="aksharNew">
																	<input type="hidden" name="sales_person_id"
																		value="<%=s.getSales_person_id()%>"> <input
																		type="hidden" name="emp_id"
																		value="<%=s.getEmployeeBean().getEmployee_master_id()%>">
																	

																		<label>Firstname :</label><input type="text"
																			name="first_name" class="form-control"
																			value="<%=s.getFirstname()%>"><br> <label>Middlename
																			: </label><input type="text" name="middle_name"
																			class="form-control" value="<%=s.getMiddlename()%>"><br>
																		<label>Lastname : </label><input type="text"
																			name="last_name" class="form-control"
																			value="<%=s.getLastname()%>"><br>
																			
																			 <label>Designation
																			: </label> <select class="form-control"
															name="designation" id="designation"
															placeholder="Enter Designation" required onchange="getRespose(this.value)">
															<option value="">---Select Designation---</option>
															
															<% 
																for(IncentiveDesignationBean designationBean : listOfDesignation){
																	if(designationBean.getIncentive_designation_name().equalsIgnoreCase(s.getDesignation())){
															%>
															<option value="<%=designationBean.getIncentive_designation_name()%>" selected="selected"><%=designationBean.getIncentive_designation_name()%></option>
															<%}else{ %>
															<option value="<%=designationBean.getIncentive_designation_name()%>"><%=designationBean.getIncentive_designation_name()%></option>
															<%} %>
															<%} %>

														</select>
																		<label>Aliasname : </label><input type="text"
																			name="alias" class="form-control"
																			value="<%=s.getAlias()%>"><br>
																	</div>

																	<div class="modal-footer">
																		<input type="SUBMIT" class="btn btn-primary"
																			value="SUBMIT">
																		<button type="button" class="btn btn-danger"
																			data-dismiss="modal">CLOSE</button>
																	</div>
																</form>
															</div>
															<!-- /.modal-content -->
														</div>
														<!--  /.modal-dialog -->
													</div>

													<% } %>


												</div>
											</div>
										</div>



									</div>

									<!--  Product Master  -->


									<%if(action.equalsIgnoreCase("product")){ %>
									<div class="tab-pane fade in active" id="product">
										<%}else{ %>
										<div class="tab-pane fade" id="product">
											<%} %>



											<form action="productMasterInsert" melabelod="post"
												enctype="multipart/form-data">
												<br>
												<div class="row">

													<input type="hidden" name="employee_master_id"
														class="form-control"
														value="<%=user.getEmployee_master_id()%>"> </b>

												</div>


												<div class="row">

													<div class="col-lg-4">
														<label>Product Name</label> <input type="text"
															class="form-control" name="productName" id="productName"
															placeholder="Enter Product Name" value="" required>
													</div>
													
													
													<%AllIncentiveListDAO allIncentiveListDAO3 = new AllIncentiveListDAO();
											List<LaserMasterBean> listOflaser = allIncentiveListDAO3.getListOfLaser(); %>

													<%-- <div class="col-lg-4">

														<% %>

														<label>Laser Source</label> 
														
														
														<select class="form-control"
															name="laserSource" id="laserSource"
															placeholder="---Select Laser Source---" required>
															<option value="">---Select Laser Source---</option>
															<%for(LaserMasterBean laserMasterBean : listOflaser){%>
															<option value="<%=laserMasterBean.getLaser_source()%>"><%=laserMasterBean.getLaser_source()%></option>
															<%} %>

														</select>

													</div> --%>

													<div class="col-lg-4">
														<label>Machine Category</label> <select
															class="form-control" name="product" id="product"
															required="required">
															<option value="">---Select Product---</option>
															<option value="AKSHAR">AKSHAR</option>
															<option value="BRAHMASTRA">BRAHMASTRA</option>
														</select>
													</div>


												</div>

												<!-- <div class="row">

											<div class="col-lg-4">
												<label>Designation</label> <input type="text"
													class="form-control" name="designation" id="designation"
													placeholder="Enter Designation" value="" required>
											</div>

											<div class="col-lg-4">
												<label>Alias Name</label> <input type="text"
													class="form-control" name="alias" id="alias"
													placeholder="Enter Aliasname" value="" required>
											</div>
										</div> -->
												<br> <input type="hidden" name="redirect" value="">
												<center>
													<input type="submit" value="Submit" class="btn btn-primary">
													<input type="reset" value="Reset" class="btn btn-danger">
												</center>

											</form>

											<br>


											<div class="panel panel-primary">
												<!-- <div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#chirag"
														href="#collapseOne">Product Master List</a>
												</h4>
											</div> -->

												<div class="panel-body">
													<div class="dataTable_wrapper">
														<div class="table-responsive"></div>
														<table
															class="table table-striped table-bordered table-hover"
															id="dataTables-example">

															<thead>
																<tr>
																	<th>No.</th>
																	<th>Product Name</th>
																	<th>Machine Category</th>
																	<th>Action</th>

																</tr>
															</thead>
															<tbody>
																<%
															
															AllIncentiveListDAO allIncentiveListDAO5 = new AllIncentiveListDAO();
																List<ProductMasterBean> listOfprod = allIncentiveListDAO5.getListOfProduct1();
																for (ProductMasterBean p : listOfprod) {
															%>
																<tr class="odd gradeX">
																	<td><%=i = i + 1%>
																	<td><%=p.getProduct_name()%></td>
																	<td><%=p.getMachine_category()%></td>
																	<td><a href="" data-toggle="modal"
																		data-target="#product1<%=p.getProduct_master_id()%>"><i
																			class="icon-edit2"></i></a></td>
																</tr>
																<%
																}	
															%>

																<%
															for (ProductMasterBean p : listOfprod) {
						 %>
																<div class="modal fade"
																	id="product1<%=p.getProduct_master_id()%>"
																	tabindex="-1" role="dialog"
																	aria-labelledby="myModalLabel" aria-hidden="true">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<form action="productMasterEdit">
																				<div class="modal-header">
																					<button type="button" class="close"
																						data-dismiss="modal" aria-hidden="true">&times;</button>
																					<h4 class="modal-title" id="myModalLabel">Product
																						Master Update</h4>
																				</div>
																				<div class="modal-body">
																				<input type="hidden" name="action" value="aksharNew" class="form-control">
																				<input type="hidden" class="form-control" name="prod_new_id"
																					value="<%=p.getProduct_master_id()%>">

																					<label>Product Name :</label><input type="text"
																						name="prod_name" class="form-control"
																						value="<%=p.getProduct_name()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;" ><br>
																					 <label>Machine
																						Category : </label><input type="text" name="category"
																						class="form-control"
																						value="<%=p.getMachine_category()%>"  style="color: #5A5A5A; border: 1px solid #D4D4D4;"><br>

																				</div>

																				<div class="modal-footer">
																					<input type="SUBMIT" class="btn btn-primary"
																						value="SUBMIT">
																					<button type="button" class="btn btn-danger"
																						data-dismiss="modal">CLOSE</button>
																				</div>
																			</form>
																		</div>
																		<!-- /.modal-content -->
																	</div>
																	<!--  /.modal-dialog -->
																</div>

																</div>
																</div>
																</div>


																<%} %>

															</tbody>
														</table>
													</div>
												</div>
											</div>

										</div>


										<!--  Classification Master  -->
										<%if(action.equalsIgnoreCase("classification")){ %>
										<div class="tab-pane fade in active" id="classification">
											<%}else{ %>
											<div class="tab-pane fade" id="classification">
												<%} %>


												<form action="classificationMasterInsert" method="get">

													<br>

													<div class="row">

														<div class="col-lg-4">
															<label>Classification Name</label> <input type="text"
																class="form-control" name="classificationName"
																id="classificationName"
																placeholder="Enter Classification Name" value=""
																required>
														</div>

														<%-- <div class="col-lg-4">
															<label>Product Name</label> <select class="form-control"
																name="product" id="product" required="required">
																<option value="">---Select Product---</option>
																<%
                                          
											AllIncentiveListDAO productList = new AllIncentiveListDAO();
                                         	 List<ProductMasterBean> listofProduct = productList.getnameOfproduct();
                 						 	for (ProductMasterBean p : listofProduct){
                 			
                                          
                                          %>
																<option value="<%=p.getProduct_master_id()%>"><%=p.getProduct_name()%></option>
																<%} %>
															</select>
														</div> --%>


													</div>

													<br> <input type="hidden" name="redirect" value="">
													<center>
														<input type="submit" value="Submit"
															class="btn btn-primary"> <input type="reset"
															value="Reset" class="btn btn-danger">
													</center>

												</form>

												<br>


												<div class="panel panel-primary">
													<!-- <div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#chirag"
														href="#collapseOne">Classification Master List</a>
												</h4>
											</div> -->

													<div class="panel-body">
														<div class="dataTable_wrapper">
															<div class="table-responsive"></div>
															<table
																class="table table-striped table-bordered table-hover"
																id="dataTables-example2">

																<thead>
																	<tr>
																		<th>No.</th>
																		<th>Classification Name</th>
																		<th>Action</th>

																	</tr>
																</thead>
																<tbody>
																	<%
															
															AllIncentiveListDAO allIncentiveListDAO2 = new AllIncentiveListDAO();
																List<ClassificationBean> listOfClassification = allIncentiveListDAO2.getListOfClassification();
																for (ClassificationBean c : listOfClassification) {
															%>
																	<tr class="odd gradeX">
																		<td><%=c.getClassification_id()%>
																		<td><%=c.getClassification_name()%></td>
																		<td><a href="" data-toggle="modal"
																			data-target="#class1<%=c.getClassification_id()%>"><i
																				class="icon-edit2"></i></a></td>
																	</tr>
																	<%
																}	
															%>
																</tbody>
															</table>

															<%
															for (ClassificationBean c : listOfClassification) {
						 %>
															<div class="modal fade"
																id="class1<%=c.getClassification_id()%>" tabindex="-1"
																role="dialog" aria-labelledby="myModalLabel"
																aria-hidden="true">
																<div class="modal-dialog">
																	<div class="modal-content">
																		<form action="classMasterUpdate">
																			<div class="modal-header">
																				<button type="button" class="close"
																					data-dismiss="modal" aria-hidden="true">&times;</button>
																				<h4 class="modal-title" id="myModalLabel">Classification
																					Master Update</h4>
																			</div>
																			<div class="modal-body">
																			<input type="hidden" name="action"
																				value="classification"> <input type="hidden"
																				name="classification_id"
																				value="<%=c.getClassification_id()%>">

																				<label>Classification Name :</label><input
																					type="text" name="class_name" class="form-control"
																					value="<%=c.getClassification_name()%>"><br>
																				<%-- <label>Product Master Name : </label> <select
																					class="form-control" name="product_master_id"
																					id="product_master_id" required="required"
																					onchange="autoShow(this.value)">
																					<option value="0">--Select Product--</option>
																					<%
													AllIncentiveListDAO allListSelfServiceDAO4 = new AllIncentiveListDAO();
														List<ProductMasterBean> listOfProd = allListSelfServiceDAO4.getListOfProduct1();
														for (ProductMasterBean productMasterBean : listOfProd) {

															if (c.getProductMasterBean().getProduct_master_id() == productMasterBean.getProduct_master_id()) 
																{
																%>
																					<option
																						value="<%=productMasterBean.getProduct_master_id()%>"
																						selected="selected"><%=productMasterBean.getProduct_name()%></option>
																					<% product_master_id = productMasterBean.getProduct_master_id();
																	}else{%>
																					<option
																						value="<%=productMasterBean.getProduct_master_id()%>"><%=productMasterBean.getProduct_name()%></option>
																					<%}
																	}
																%>
																				</select>
 --%>
																			</div>

																			<div class="modal-footer">
																				<input type="SUBMIT" class="btn btn-primary"
																					value="SUBMIT">
																				<button type="button" class="btn btn-danger"
																					data-dismiss="modal">CLOSE</button>
																			</div>
																		</form>
																	</div>
																	<!-- /.modal-content -->
																</div>
																<!--  /.modal-dialog -->
															</div>



															<%} %>


														</div>
													</div>
												</div>


											</div>

											<%if(action.equalsIgnoreCase("laser")){ %>
											<div class="tab-pane fade in active" id="laser">
												<%}else{ %>
												<div class="tab-pane fade" id="laser">
													<%} %>





													<form action="laserSourceInsert" method="post">
														<br>
														<div class="row">

															<input type="hidden" name="employee_master_id"
																class="form-control"
																value="<%=user.getEmployee_master_id()%>"> </b>

														</div>


														<div class="row">

															<div class="col-lg-4">
																<label>Laser Name</label> <input type="text"
																	class="form-control" name="laserName" id="laserName"
																	placeholder="Enter Laser Source" value="" required>
															</div>

														</div>


														<br> <input type="hidden" name="redirect" value="">
														<center>
															<input type="submit" value="Submit"
																class="btn btn-primary"> <input type="reset"
																value="Reset" class="btn btn-danger">
														</center>

													</form>

													<br>


													<div class="panel panel-primary">
														<!-- <div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#chirag"
														href="#collapseOne">Laser Master</a>
												</h4>
											</div> -->

														<div class="panel-body">
															<div class="dataTable_wrapper">
																<div class="table-responsive"></div>
																<table
																	class="table table-striped table-bordered table-hover"
																	id="dataTables-example3">

																	<thead>
																		<tr>
																			<th>No.</th>
																			<th>Laser Source</th>
																			<th>Action</th>

																		</tr>
																	</thead>
																	<tbody>
																		<%
															
																for (LaserMasterBean l : listOflaser) {
															%>
																		<tr class="odd gradeX">
																			<td><%=i = i + 1%>
																			<td><%=l.getLaser_source()%></td>
																			<td><a href="" data-toggle="modal"
																				data-target="#laser<%=l.getLaser_master_id()%>"><i
																					class="icon-edit2"></i></a></td>
																		</tr>
																		<%
																}	
															%>
																	</tbody>
																</table>

																<%
															for (LaserMasterBean l : listOflaser) {
						 %>
																<div class="modal fade"
																	id="laser<%=l.getLaser_master_id()%>" tabindex="-1"
																	role="dialog" aria-labelledby="myModalLabel"
																	aria-hidden="true">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<form action="classMasterUpdate">
																				<div class="modal-header">
																					<button type="button" class="close"
																						data-dismiss="modal" aria-hidden="true">&times;</button>
																					<h4 class="modal-title" id="myModalLabel">Laser
																						Master Update</h4>
																				</div>
																				<div class="modal-body">
																				<input type="hidden" name="action" value="laser">
																				<input type="hidden" name="laser_master_id"
																					value="<%=l.getLaser_master_id()%>">

																					<label>Laser Source:</label><input type="text"
																						name="laser_source" class="form-control"
																						value="<%=l.getLaser_source()%>"><br>
																				</div>

																				<div class="modal-footer">
																					<input type="SUBMIT" class="btn btn-primary"
																						value="SUBMIT">
																					<button type="button" class="btn btn-danger"
																						data-dismiss="modal">CLOSE</button>
																				</div>
																			</form>
																		</div>
																	</div>
																</div>
																<%} %>
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
							</div>
							</section>
							</div>
							</div>
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
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
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
    
      <script src="js/pace/pace.min.js"></script>
							<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
			$('#dataTables-example1').DataTable({
				responsive : true
			});
			$('#dataTables-example2').DataTable({
				responsive : true
			});
			$('#dataTables-example3').DataTable({
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




							<!-- Custom Theme JavaScript -->
							<script src="../dist/js/sb-admin-2.js"></script>
</body>
</html>