<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.kaizen.bean.KaizenBillboardResultBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenAuthorityScoreBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerScoreBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="java.util.List"%>
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
    <title>CI Manager List</title>
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
    <%@include file="header.jsp" %>
  </head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int employee_id = user.getEmployee_master_id(); 
int manager_id = user.getManagerBean().getManager_id();

int year = Integer.parseInt(request.getParameter("year"));
int month = Integer.parseInt(request.getParameter("month"));
String month_name = request.getParameter("month_name");

AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();

List<KaizenManagerBean> listofAllKaizen = allKaizenListDAO.getListOfManagerAllKaizen(employee_id,year,month);


List<KaizenBean> lisOfApprovedOnProgressCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year,month,"approved","submitted");
List<KaizenBean> lisOfApprovedCompletedCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year,month,"approved","completed");
List<KaizenBean> lisOfPendingForApprovalCI = allKaizenListDAO.getListOfKaizenBymanagerIdAndStatus(manager_id,year,month,"pending","completed");
List<KaizenBean> lisOfMainRejectedKaizen = allKaizenListDAO.getListOfAllKaizenBymanagerIdWithRejected(manager_id,year,month);%>
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
					<h1 class="page-header">CI List of <%=month_name%>,<%=year%></h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <div class="row">
                        	<div class="col-md-6">
                        	Approved Pending CI List
                        	</div>
                        	
                        </div>
                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover file-export">
                                    <thead>
                                        <tr>
                                           <th></th>
                                        	<th>CI Name</th>
                                        	<th>Added By</th>
                                        	<th>Creation Time</th>
                                        	<th>Action</th>
                                        </tr>
                                    </thead>
                                    
                                     <tbody>
                                     	
                                     	<%for(KaizenBean kaizenBean : lisOfPendingForApprovalCI){
                                     		int kaizen_id = kaizenBean.getKaizen_id();
                                     	%>
	                                     <tr>
	                                     <td><a id="kaizen<%=kaizenBean.getKaizen_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData1(this.id)"><i class="fa fa-plus-circle"></i></a></td>
	                                     	<td><%=kaizenBean.getKaizen_name()%></td>
	                                     	<td><%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%></td>
	                                     	<td><%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getDate()))%></td>
	                                     	<td><a href="kaizenView.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-outline btn-default btn-xs"><i class="fa fa-share-square"></i> Detail</button></a>

	                                     	</td>
	                                     </tr>
	                                     
	                                     
	                                      <tr class="kaizen<%=kaizenBean.getKaizen_id()%>">
	                                     <td colspan="6">
	                                     <div class="col-md-6 col-sm-6 col-lg-6">
	                                      <div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>Before Photo List</b></h5>
												<%
												List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
											</div>	
												
											  <div class="col-md-6 col-sm-6 col-lg-6">	
												<div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>After Photo List</b></h5>
												<%
												List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
												</div>
	                                     </td>
	                                     </tr>
	                                     
	                                     
	                                     
	                                     <tr class="kaizen<%=kaizenBean.getKaizen_id()%>">
	                                     <td colspan="6">
	                                     <div class="col-md-6 col-sm-6 col-lg-6">
	                                      		<b>BillBoard Scoring</b>
	                                      		<table class="table table-bordered">
	                                      		<tr bgcolor="#D6DBDF">
	                                      			<th>Quality</th>
	                                      			<th>Cost</th>
	                                      			<th>Safety</th>
	                                      			<th>Delivery</th>
	                                      			<th>Horizontal Deployment</th>
	                                      			<th>Average</th>
	                                      		</tr>	
	                                      		<%KaizenManagerScoreBean kaizenManagerScoreBean = allKaizenListDAO.getDetailOfKaizenScoreByempId(kaizen_id, employee_id); 
	                                      			if(kaizenManagerScoreBean != null){
	                                      		%>
	                                      		
	                                      		<tr>
	                                      			<td><%=kaizenManagerScoreBean.getQuality()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getCost()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getSafety()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getDelivery()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getHorizontal_deployment()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getTotal()%></td>
	                                      		</tr>
	                                      		<%} %>
	                                      		</table>
											</div>	
												
											  <div class="col-md-6 col-sm-6 col-lg-6">	
														<b>LeaderBoard Scoring</b>
	                                      		<table class="table table-bordered">
	                                      		<tr bgcolor="#D6DBDF">
	                                      			<th>Authority Name</th>
	                                      			<th>Quality</th>
	                                      			<th>Cost</th>
	                                      			<th>Safety</th>
	                                      			<th>Delivery</th>
	                                      			<th>Horizontal Deployment</th>
	                                      			<th>Average</th>
	                                      		</tr>	
	                                      		<%List<KaizenAuthorityScoreBean> listKaizenAuthorityScoreBean = allKaizenListDAO.getListOfAuthorityScoreBykaizenId(kaizen_id); 
	                                      			for(KaizenAuthorityScoreBean authorityScoreBean : listKaizenAuthorityScoreBean){
	                                      				
	                                      				int emp_id = authorityScoreBean.getEmployee_master_id();
	                                      				LoginDAO loginDAO = new LoginDAO();
	                                      				EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(emp_id);
	                                      		%>
	                                      		
	                                      		<tr>
	                                      			<td><%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%></td>
	                                      			<td><%=authorityScoreBean.getQuality()%></td>
	                                      			<td><%=authorityScoreBean.getCost()%></td>
	                                      			<td><%=authorityScoreBean.getSafety()%></td>
	                                      			<td><%=authorityScoreBean.getDelivery()%></td>
	                                      			<td><%=authorityScoreBean.getHorizontal_deployment()%></td>
	                                      			<td><%=authorityScoreBean.getTotal()%></td>
	                                      		</tr>
	                                      		<%} %>
	                                      		<%if(listKaizenAuthorityScoreBean.size() == 0){%>
	                                      			<tr>
	                                      				<td colspan="7" align="center">
	                                      					No Leader Board Score Available
	                                      				</td>
	                                      			</tr>
	                                      		<%} %>
	                                      		</table>
												</div>
	                                     </td>
	                                     </tr>
	                                      <script>
	
																$(document).ready(function(){
																		 $(".kaizen"+<%=kaizenBean.getKaizen_id()%>).hide();
																});
	
															</script>
                                     	<%} %>
                                    </tbody>
                                </table>
                            </div>

                </div>
                </div>
                </div>
                </div>
			 
			 
			 
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <div class="row">
                        	<div class="col-md-6">
                        	Approved Completed CI List
                        	</div>
                        	
                        </div>
                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover file-export">
                                    <thead>
                                        <tr>
                                           <th></th>
                                        	<th>CI Name</th>
                                        	<th>Added By</th>
                                        	<th>Creation Time</th>
                                        	<th>Action</th>
                                        </tr>
                                    </thead>
                                    
                                     <tbody>
                                     	
                                     	<%for(KaizenBean kaizenBean : lisOfApprovedCompletedCI){
                                     		int kaizen_id = kaizenBean.getKaizen_id();
											Date date = yyyyMMddhh.parse(kaizenBean.getCompletion_date());
											
											boolean billboard = false;
											boolean leaderboard = false;
											
											 Calendar cal = Calendar.getInstance();
											    cal.setTime(date);
											    int year_id = cal.get(Calendar.YEAR);
											    int month_id = cal.get(Calendar.MONTH)+1;
											
											int dept_id = kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_id();
											
											KaizenBillboardResultBean kaizenBillboardResultBean = allKaizenListDAO.getFinalresultOfBillBordByMonthAndYear(dept_id,month_id, year_id);
											KaizenAuthorityScoreBean kaiAuthorityScoreBean = allKaizenListDAO.getFinalresultOfLeaderBoardByMonthAndYear(month_id, year_id);
											if(kaizenBillboardResultBean != null){
												if(kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getKaizen_id() == kaizen_id){
													billboard = true;
												}
											}
											
											if(kaiAuthorityScoreBean != null){
												if(kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getKaizen_id() == kaizen_id){
													leaderboard = true;
												}
											}
                                     	%>
	                                     <tr>
	                                     <td>
	                                     <a id="kaizen<%=kaizenBean.getKaizen_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData1(this.id)"><i class="fa fa-plus-circle"></i></a>
	                                      <%if(billboard == true) {%>
	                                     		<i class="fa fa-star" style="color: silver;" data-toggle="tooltip"
														data-placement="top" title="Billboard Result"></i>
	                                     <%} %>
	                                     
	                                     <%if(leaderboard == true) {%>
	                                     		<i class="fa fa-star" style="color: gold;" data-toggle="tooltip"
														data-placement="top" title="Leaderboard Result"></i>
	                                     <%} %>
	                                     
	                                     </td>
	                                     	<td><%=kaizenBean.getKaizen_name()%></td>
	                                     	<td><%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%></td>
	                                     	<td><%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getDate()))%></td>
	                                     	<td><a href="kaizenView.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-outline btn-default btn-xs"><i class="fa fa-share-square"></i> Detail</button></a>

	                                     	</td>
	                                     </tr>
	                                     
	                                     
	                                      <tr class="kaizen<%=kaizenBean.getKaizen_id()%>">
	                                     <td colspan="6">
	                                     <div class="col-md-6 col-sm-6 col-lg-6">
	                                      <div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>Before Photo List</b></h5>
												<%
												List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
											</div>	
												
											  <div class="col-md-6 col-sm-6 col-lg-6">	
												<div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>After Photo List</b></h5>
												<%
												List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
												</div>
	                                     </td>
	                                     </tr>
	                                     
	                                     
	                                     
	                                     <tr class="kaizen<%=kaizenBean.getKaizen_id()%>">
	                                     <td colspan="6">
	                                     <div class="col-md-6 col-sm-6 col-lg-6">
	                                      		<b>BillBoard Scoring</b>
	                                      		<table class="table table-bordered">
	                                      		<tr bgcolor="#D6DBDF">
	                                      			<th>Quality</th>
	                                      			<th>Cost</th>
	                                      			<th>Safety</th>
	                                      			<th>Delivery</th>
	                                      			<th>Horizontal Deployment</th>
	                                      			<th>Average</th>
	                                      		</tr>	
	                                      		<%KaizenManagerScoreBean kaizenManagerScoreBean = allKaizenListDAO.getDetailOfKaizenScoreByempId(kaizen_id, employee_id); 
	                                      			if(kaizenManagerScoreBean != null){
	                                      		%>
	                                      		
	                                      		<tr>
	                                      			<td><%=kaizenManagerScoreBean.getQuality()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getCost()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getSafety()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getDelivery()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getHorizontal_deployment()%></td>
	                                      			<td><%=kaizenManagerScoreBean.getTotal() %></td>
	                                      		</tr>
	                                      		<%} %>
	                                      		</table>
											</div>	
												
											  <div class="col-md-6 col-sm-6 col-lg-6">	
														<b>LeaderBoard Scoring</b>
	                                      		<table class="table table-bordered">
	                                      		<tr bgcolor="#D6DBDF">
	                                      			<th>Authority Name</th>
	                                      			<th>Quality</th>
	                                      			<th>Cost</th>
	                                      			<th>Safety</th>
	                                      			<th>Delivery</th>
	                                      			<th>Horizontal Deployment</th>
	                                      			<th>Average</th>
	                                      		</tr>	
	                                      		<%List<KaizenAuthorityScoreBean> listKaizenAuthorityScoreBean = allKaizenListDAO.getListOfAuthorityScoreBykaizenId(kaizen_id); 
	                                      			for(KaizenAuthorityScoreBean authorityScoreBean : listKaizenAuthorityScoreBean){
	                                      				
	                                      				int emp_id = authorityScoreBean.getEmployee_master_id();
	                                      				LoginDAO loginDAO = new LoginDAO();
	                                      				EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(emp_id);
	                                      		%>
	                                      		
	                                      		<tr>
	                                      			<td><%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%></td>
	                                      			<td><%=authorityScoreBean.getQuality()%></td>
	                                      			<td><%=authorityScoreBean.getCost()%></td>
	                                      			<td><%=authorityScoreBean.getSafety()%></td>
	                                      			<td><%=authorityScoreBean.getDelivery()%></td>
	                                      			<td><%=authorityScoreBean.getHorizontal_deployment()%></td>
	                                      			<td><%=authorityScoreBean.getTotal() %></td>
	                                      		</tr>
	                                      		<%} %>
	                                      		<%if(listKaizenAuthorityScoreBean.size() == 0){%>
	                                      			<tr>
	                                      				<td colspan="7" align="center">
	                                      					No Leader Board Score Available
	                                      				</td>
	                                      			</tr>
	                                      		<%} %>
	                                      		</table>
												</div>
	                                     </td>
	                                     </tr>
	                                      <script>
	
																$(document).ready(function(){
																		 $(".kaizen"+<%=kaizenBean.getKaizen_id()%>).hide();
																});
	
															</script>
                                     	<%} %>
                                    </tbody>
                                </table>
                            </div>

                </div>
                </div>
                </div>
                </div>
                
                
                			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <div class="row">
                        	<div class="col-md-6">
                        	Approved On-Progress CI List
                        	</div>
                        	
                        </div>
                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover file-export">
                                    <thead>
                                        <tr>
                                           <th></th>
                                        	<th>CI Name</th>
                                        	<th>Added By</th>
                                        	<th>Creation Time</th>
                                        	<th>Action</th>
                                        </tr>
                                    </thead>
                                    
                                     <tbody>
                                     	
                                     	<%for(KaizenBean kaizenBean : lisOfApprovedOnProgressCI){
                                     		int kaizen_id = kaizenBean.getKaizen_id();
                                     	%>
	                                     <tr>
	                                     <td><a id="kaizen<%=kaizenBean.getKaizen_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData1(this.id)"><i class="fa fa-plus-circle"></i></a></td>
	                                     	<td><%=kaizenBean.getKaizen_name()%></td>
	                                     	<td><%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%></td>
	                                     	<td><%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getDate()))%></td>
	                                     	<td><a href="kaizenView.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-outline btn-default btn-xs"><i class="fa fa-share-square"></i> Detail</button></a>

	                                     	</td>
	                                     </tr>
	                                     
	                                     
	                                      <tr class="kaizen<%=kaizenBean.getKaizen_id()%>">
	                                     <td colspan="6">
	                                     <div class="col-md-6 col-sm-6 col-lg-6">
	                                      <div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>Before Photo List</b></h5>
												<%
												List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
											</div>	
												
											  <div class="col-md-6 col-sm-6 col-lg-6">	
												<div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>After Photo List</b></h5>
												<%
												List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
												</div>
	                                     </td>
	                                     </tr>
	                                     
	                                      <script>
	
																$(document).ready(function(){
																		 $(".kaizen"+<%=kaizenBean.getKaizen_id()%>).hide();
																});
	
															</script>
                                     	<%} %>
                                    </tbody>
                                </table>
                            </div>

                </div>
                </div>
                </div>
                </div>
                

			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <div class="row">
                        	<div class="col-md-6">
                        	Rejected CI List
                        	</div>
                        	
                        </div>
                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover file-export">
                                    <thead>
                                        <tr>
                                           <th></th>
                                        	<th>CI Name</th>
                                        	<th>Added By</th>
                                        	<th>Creation Time</th>
                                        	<th>Action</th>
                                        </tr>
                                    </thead>
                                    
                                     <tbody>
                                     	
                                     	<%for(KaizenBean kaizenBean : lisOfMainRejectedKaizen){
                                     		int kaizen_id = kaizenBean.getKaizen_id();
                                     	%>
	                                     <tr>
	                                     <td><a id="kaizen<%=kaizenBean.getKaizen_id()%>" style="color: black;text-decoration: none;cursor: pointer;" onclick="showData1(this.id)"><i class="fa fa-plus-circle"></i></a></td>
	                                     	<td><%=kaizenBean.getKaizen_name()%></td>
	                                     	<td><%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%></td>
	                                     	<td><%=ddMMMyyyy.format(yyyyMMddhh.parse(kaizenBean.getDate()))%></td>
	                                     	<td><a href="kaizenRejectionUpdate.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>" style="color: black;"><button class="btn btn-outline btn-default btn-xs"><i class="fa fa-share-square"></i> Detail</button></a>

	                                     	</td>
	                                     </tr>
	                                     
	                                     
	                                      <tr class="kaizen<%=kaizenBean.getKaizen_id()%>">
	                                     <td colspan="6">
	                                     <div class="col-md-6 col-sm-6 col-lg-6">
	                                      <div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>Before Photo List</b></h5>
												<%
												List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
												for(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean : listOfBefore){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenBeforeUploadAttachmentBean.getKaizen_before_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
											</div>	
												
											  <div class="col-md-6 col-sm-6 col-lg-6">	
												<div class="panel panel-primary">
												<div class="panel-body">
														<h5><b>After Photo List</b></h5>
												<%
												List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
												for(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean : listOfAfter){
												%>
													<img
														src="FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>"
														alt="User Avatar" height="60px" width="60px" style="border: solid 1px;"
														tabindex="0" data-placement="top" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\kaizen\KaizenBefore\<%=kaizenAfterUploadAttachmentBean.getKaizen_after_uploaded_attachment_name()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
												<%} %>
																					
												</div>
												</div>
												</div>
	                                     </td>
	                                     </tr>
	                                     
	                                      <script>
	
																$(document).ready(function(){
																		 $(".kaizen"+<%=kaizenBean.getKaizen_id()%>).hide();
																});
	
															</script>
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
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
</body>
</html>