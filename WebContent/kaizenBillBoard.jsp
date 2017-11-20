<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenMemberBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenProblemIdentificationBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBillboardResultBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerScoreBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="org.w3c.dom.ls.LSInput"%>
<%@page import="java.util.List"%>
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
    <title>BillBoard</title>
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
    <%@include file="header.jsp" %>
    
<!-- <style type="text/css">

@media print {

    .breaker {page-break-before: always;}
    body {-webkit-print-color-adjust: exact;}
    
}


@media print {
@page { size : A3 landscape }
  @page rotated { size : A3 landscape }
}

@media print { 
    table td.mainTd { 
        background-color:#7FB3D5 !important; 
        color: white !important; 
    } 
    
    
    
     .table th{ 
        background-color:#2471A3 !important;
        color: white !important; 
    }
    
}

</style> -->
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<%

AllListDAO allListDAO = new AllListDAO();
List<MonthBean> listOfMonth = allListDAO.getListOfMonth();

int employee_id = user.getEmployee_master_id();
int dept_id = user.getDepartmentBean().getDepartment_id();
if(request.getParameter("dept_id") != null){
	dept_id = Integer.parseInt(request.getParameter("dept_id"));
}
AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
String year = request.getParameter("year");

String[] split = year.split("-");

int year1 = Integer.parseInt(split[0]);
int year2 = Integer.parseInt(split[1]);

LoginDAO loginDAO = new LoginDAO();
DepartmentBean departmentBean = loginDAO.getDepartmentName(dept_id);

%>

<table class="table table-bordered">
	<thead>
		<tr>
			<th colspan="2" id="first" style="background: #2471A3;color: white;">Billboard - CI DashBoard</th>
			<th colspan="2" id="second" style="background: #2471A3;color: white;">Year <%=year%></th>
			<th colspan="2" id="third" style="background: #2471A3;color: white;">Department : <%=departmentBean.getDepartment_name()%></th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<%for(int i = 3;i<9;i++){
			MonthBean monthBean = listOfMonth.get(i);
			KaizenBillboardResultBean kaizenBillboardResultBean = allKaizenListDAO.getFinalresultOfBillBordByMonthAndYear(dept_id, monthBean.getMonth_id(), year1);
			if(kaizenBillboardResultBean != null){
				int kaizen_id = kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getKaizen_id();
				KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
				 List<KaizenBean> lisOfKaizen = allKaizenListDAO.getListOfAllKaizenByDepartment(dept_id,year1,monthBean.getMonth_id());
				 List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
				 List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
				 List<KaizenProblemIdentificationBean> listOfIdentification  = allKaizenListDAO.getListOfProblemByDeptIdWithMonthYear(dept_id,monthBean.getMonth_id(),year1);
				 List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id);
			%>
			<td>
			  <table class="table table-bordered">
				<tr>
					<td class="mainTd" style="background: #7FB3D5;color: white;">
					<%=monthBean.getMonth_name()%> &emsp;
					  	<a style="cursor: pointer;" onclick="window.open('kaizenMonthWisePrint.jsp?kaizen_id=<%=kaizen_id%>&dept_id=<%=dept_id%>&year=<%=year1%>&month=<%=monthBean.getMonth_id()%>','_blank')">
							<button type="button" class="btn btn-xs"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Print"> PRINT</button>
						</a>	
						</td>
				</tr>
				
				<tr>
					<td height="445px;" width="200px;">
						
						<div class="row">
								<div class="col-md-4 col-sm-4 col-xs-4 col-lg-4 col-sm-4 col-xs-4 col-lg-4" align="left">
									<%int company_id = kaizenBean.getEmployeeBean().getCompanyListBean().getCompany_list_id();
							int emp_code = kaizenBean.getEmployeeBean().getEmployee_code();
							/* String company_name = null;
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
							} */
							
							%>
							
							<img alt="<%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%>" src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" height="60px;" width="60px;" style="border: solid 1px;">
								</div>
								
								<div class="col-md-8 col-sm-8 col-xs-8 col-lg-8">
								<p>
								<b>
								<%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%>
								</b><br>
								</p>
								<p style="font-size: 7px;">
								<%if(listOfMember.size() > 1){ %>
								<b>Team Members : </b>
								<%} %>
							<%for(KaizenMemberBean kaizenMemberBean : listOfMember){if(kaizenMemberBean.getEmployeeBean().getEmployee_master_id() != kaizenBean.getEmployeeBean().getEmployee_master_id()){%>
								<%=kaizenMemberBean.getEmployeeBean().getFirstname()+" "+kaizenMemberBean.getEmployeeBean().getLastname()%>,
							<%}} %>
						</p>
								</div>
						</div>
						
						<br>
						
						<div class="row">
							<div class="col-md-12" align="justify">
						<p style="font-size: 7px;"><b>
						CI Name : 
						<a style="cursor: pointer;" onclick="window.open('kaizenView.jsp?kaizen_id=<%=kaizen_id%>','_blank');">
						          <%=kaizenBean.getKaizen_name()%>
						   </a> 
						     </b></p>
						<p style="font-size: 7px;width: 290px;"><%=kaizenBean.getKaizen_desc()%></p>
						<p style="font-size: 7px;"><b>Projected Saving</b></p>
						<p style="font-size: 7px;">
							<table class="table" border="1" style="font-size: 7px;">
								<tr>
									<td>Delivery</td>
									<td><%=kaizenBean.getDelivery()%></td>
								</tr>
								<tr>	
									<td>Cost</td>
									<td><%=kaizenBean.getCost()%> Rs.</td>
								</tr>	
								<tr>	
									<td>Quality</td>
									<td><%=kaizenBean.getQuality()%></td>
								</tr>	
								<tr>	
									<td>Safety</td>
									<td><%=kaizenBean.getSafety()%></td>
								</tr>	
								<tr>	
									<td>Productivity</td>
									<td><%=kaizenBean.getProductivity()%></td>
								</tr>	
							</table>
						</p>
							</div>
						</div>
					
							
					</td>
				</tr>
				<tr>
					<td>
					Problem Identification : <font size="5px"><b><%=listOfIdentification.size()%></b></font>
					</td>
				</tr>
			  </table>
			</td>
			<%}else{ %>
			
			<td>
			  <table class="table table-bordered">
				<tr>
					<td class="mainTd" style="background: #7FB3D5;color: white;"><%=monthBean.getMonth_name()%></td>
				</tr>
				
				<tr>
					<td height="445px;" width="200px;">
						<img src="img/user.bmp" height="60px;" width="60px;" style="border: solid 1px;">
						<p style="font-size: 7px; width: 290px;">
						</p>
					</td>
				</tr>
				<tr>
					<td>Problem Identification : <font size="5px"><b>0</b></font></td>
				</tr>
			  </table>
			</td>
			<%} %>
		<%} %>	
		</tr>
		
		
		<tr>
		<%for(int i = 9;i<12;i++){
			MonthBean monthBean = listOfMonth.get(i);
			KaizenBillboardResultBean kaizenBillboardResultBean = allKaizenListDAO.getFinalresultOfBillBordByMonthAndYear(dept_id, monthBean.getMonth_id(), year1);
			if(kaizenBillboardResultBean != null){
				int kaizen_id = kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getKaizen_id();
				KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
				 List<KaizenBean> lisOfKaizen = allKaizenListDAO.getListOfAllKaizenByDepartment(dept_id,year1,monthBean.getMonth_id());
				 List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
				 List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
				 List<KaizenProblemIdentificationBean> listOfIdentification  = allKaizenListDAO.getListOfProblemByDeptIdWithMonthYear(dept_id,monthBean.getMonth_id(),year1);
				 List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id);
			%>
			<td>
			  <table class="table table-bordered">
				<tr>
					<td class="mainTd" style="background: #7FB3D5;color: white;"><%=monthBean.getMonth_name()%>
					<a style="cursor: pointer;" onclick="window.open('kaizenMonthWisePrint.jsp?kaizen_id=<%=kaizen_id%>&dept_id=<%=dept_id%>&year=<%=year1%>&month=<%=monthBean.getMonth_id()%>','_blank')">
							<button type="button" class="btn btn-xs"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Print"> PRINT</button>
						</a>
					</td>
				</tr>
				
				<tr>
					<td height="445px;" width="200px;">
						
						<div class="row">
								<div class="col-md-4 col-sm-4 col-xs-4 col-lg-4" align="left">
									<%int company_id = kaizenBean.getEmployeeBean().getCompanyListBean().getCompany_list_id();
							int emp_code = kaizenBean.getEmployeeBean().getEmployee_code();
							/* String company_name = null;
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
							}  */
							
							%>
							
							<img alt="<%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%>" src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" height="60px;" width="60px;" style="border: solid 1px;">
								</div>
								
								<div class="col-md-8 col-sm-8 col-xs-8 col-lg-8">
								<p>
								<b>
								<a style="cursor: pointer;" onclick="window.open('kaizenMonthWisePrint.jsp?kaizen_id=<%=kaizen_id%>&dept_id=<%=dept_id%>&year=<%=year1%>&month=<%=monthBean.getMonth_id()%>','_blank')">
								<%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%>
								</a>
								</b><br>
								
								</p>
								<p style="font-size: 7px;">
								<%if(listOfMember.size() > 1){ %>
								<b>Team Members : </b>
								<%} %>
							<%for(KaizenMemberBean kaizenMemberBean : listOfMember){
							if(kaizenMemberBean.getEmployeeBean().getEmployee_master_id() != kaizenBean.getEmployeeBean().getEmployee_master_id()){%>
								<%=kaizenMemberBean.getEmployeeBean().getFirstname()+" "+kaizenMemberBean.getEmployeeBean().getLastname()%>,
							<%}} %>
						</p>
								</div>
						</div>
						
						<br>
						
						<div class="row">
							<div class="col-md-12" align="justify">
						<p style="font-size: 7px;"><b>
						CI Name : 
						<a style="cursor: pointer;" onclick="window.open('kaizenView.jsp?kaizen_id=<%=kaizen_id%>','_blank');">
						          <%=kaizenBean.getKaizen_name()%>
						     </a></b></p>
						<p style="font-size: 7px;width: 290px;"><%=kaizenBean.getKaizen_desc()%></p>
						<p style="font-size: 7px;"><b>Projected Saving</b></p>
						<p style="font-size: 7px;">
							<table class="table" border="1" style="font-size: 7px;">
								<tr>
									<td>Delivery</td>
									<td><%=kaizenBean.getDelivery()%></td>
								</tr>
								<tr>	
									<td>Cost</td>
									<td><%=kaizenBean.getCost()%> Rs.</td>
								</tr>	
								<tr>	
									<td>Quality</td>
									<td><%=kaizenBean.getQuality()%></td>
								</tr>	
								<tr>	
									<td>Safety</td>
									<td><%=kaizenBean.getSafety()%></td>
								</tr>	
								<tr>	
									<td>Productivity</td>
									<td><%=kaizenBean.getProductivity()%></td>
								</tr>	
							</table>
						</p>
							</div>
						</div>
					
							
					</td>
				</tr>
				<tr>
					<td>Problem Identification : <font size="5px"><b><%=listOfIdentification.size()%></b></font></td>
				</tr>
			  </table>
			</td>
			<%}else{ %>
			
			<td>
			  <table class="table table-bordered">
				<tr>
					<td class="mainTd" style="background: #7FB3D5;color: white;"><%=monthBean.getMonth_name()%></td>
				</tr>
				
				<tr>
					<td height="445px;" width="200px;">
						<img src="img/user.bmp" height="60px;" width="60px;" style="border: solid 1px;">
						<p style="font-size: 7px;width: 290px;">
						</p>
					</td>
				</tr>
				<tr>
					<td>Problem Identification : <font size="5px"><b>0</b></font></td>
				</tr>
			  </table>
			</td>
			<%} %>
		<%} %>
		
		<%for(int i = 0;i<3;i++){
			MonthBean monthBean = listOfMonth.get(i);
			KaizenBillboardResultBean kaizenBillboardResultBean = allKaizenListDAO.getFinalresultOfBillBordByMonthAndYear(dept_id, monthBean.getMonth_id(), year1);
			if(kaizenBillboardResultBean != null){
				int kaizen_id = kaizenBillboardResultBean.getKaizenManagerScoreBean().getKaizenBean().getKaizen_id();
				KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
				 List<KaizenBean> lisOfKaizen = allKaizenListDAO.getListOfAllKaizenByDepartment(dept_id,year1,monthBean.getMonth_id());
				 List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
				 List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
				 List<KaizenProblemIdentificationBean> listOfIdentification  = allKaizenListDAO.getListOfProblemByDeptIdWithMonthYear(dept_id,monthBean.getMonth_id(),year1);
				 List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id);
			%>
			<td>
			  <table class="table table-bordered">
				<tr>
					<td class="mainTd" style="background: #7FB3D5;color: white;"><%=monthBean.getMonth_name()%>
					<a style="cursor: pointer;" onclick="window.open('kaizenMonthWisePrint.jsp?kaizen_id=<%=kaizen_id%>&dept_id=<%=dept_id%>&year=<%=year1%>&month=<%=monthBean.getMonth_id()%>','_blank')">
							<button type="button" class="btn btn-xs"
																style="background-color: #3BAFDA" data-toggle="tooltip"
																data-placement="top" title="Print"> PRINT</>
						</a>
					</td>
				</tr>
				
				<tr>
					<td height="445px;" width="200px;">
						
						<div class="row">
								<div class="col-md-4 col-sm-4 col-xs-4 col-lg-4" align="left">
									<%int company_id = kaizenBean.getEmployeeBean().getCompanyListBean().getCompany_list_id();
							int emp_code = kaizenBean.getEmployeeBean().getEmployee_code();
							/* String company_name = null;
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
							}  */
							
							%>
							
							<img alt="<%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%>" src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" height="60px;" width="60px;" style="border: solid 1px;">
								</div>
								
								<div class="col-md-8 col-sm-8 col-xs-8 col-lg-8">
								<p>
								<b>
								<a style="cursor: pointer;" onclick="window.open('kaizenMonthWisePrint.jsp?kaizen_id=<%=kaizen_id%>&dept_id=<%=dept_id%>&year=<%=year1%>&month=<%=monthBean.getMonth_id()%>','_blank')">
								
								<%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%>
								</a>
								</b><br>
								</p>
								<p style="font-size: 7px;">
								<%if(listOfMember.size() > 1){ %>
								<b>Team Members : </b>
								<%} %>
							<%for(KaizenMemberBean kaizenMemberBean : listOfMember){
							if(kaizenMemberBean.getEmployeeBean().getEmployee_master_id() != kaizenBean.getEmployeeBean().getEmployee_master_id()){%>
								<%=kaizenMemberBean.getEmployeeBean().getFirstname()+" "+kaizenMemberBean.getEmployeeBean().getLastname()%>,
							<%}} %>
						</p>
								</div>
						</div>
						
						<br>
						
						<div class="row">
							<div class="col-md-12" align="justify">
						<p style="font-size: 7px;"><b>
						CI Name : 
						<a style="cursor: pointer;" onclick="window.open('kaizenView.jsp?kaizen_id=<%=kaizen_id%>','_blank');">
						          <%=kaizenBean.getKaizen_name()%>
						     </a></b></p>
						<p style="font-size: 7px;width: 290px;"><%=kaizenBean.getKaizen_desc()%></p>
						<p style="font-size: 7px;"><b>Projected Saving</b></p>
						<p style="font-size: 7px;">
							<table class="table" border="1" style="font-size: 7px;">
								<tr>
									<td>Delivery</td>
									<td><%=kaizenBean.getDelivery()%></td>
								</tr>
								<tr>	
									<td>Cost</td>
									<td><%=kaizenBean.getCost()%> Rs.</td>
								</tr>	
								<tr>	
									<td>Quality</td>
									<td><%=kaizenBean.getQuality()%></td>
								</tr>	
								<tr>	
									<td>Safety</td>
									<td><%=kaizenBean.getSafety()%></td>
								</tr>	
								<tr>	
									<td>Productivity</td>
									<td><%=kaizenBean.getProductivity()%></td>
								</tr>	
							</table>
						</p>
							</div>
						</div>
					
							
					</td>
				</tr>
				<tr>
					<td>Problem Identification : <font size="5px"><b><%=listOfIdentification.size()%></b></font></td>
				</tr>
			  </table>
			</td>
			<%}else{ %>
			
			<td>
			  <table class="table table-bordered">
				<tr>
					<td class="mainTd" style="background: #7FB3D5;color: white;"><%=monthBean.getMonth_name()%></td>
				</tr>
				
				<tr>
					<td height="445px;" width="200px;">
						<img src="img/user.bmp" height="60px;" width="60px;" style="border: solid 1px;">
						<p style="font-size: 7px;width: 290px;">
						</p>
					</td>
				</tr>
				<tr>
					<td>Problem Identification : <font size="5px"><b>0</b></font></td>
				</tr>
			  </table>
			</td>
			<%} %>
		<%} %>
		</tr>
		
		
	</tbody>
	<tbody>
	
	</tbody>
</table>

</body>
</html>