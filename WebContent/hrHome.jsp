<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagementApprovalBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenManagerBean"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>HR Home</title>
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
<!-- <div class="col-lg-1"></div>
<div class="col-lg-3">
                   <div class="panel panel-primary">
                   
                        <div class="panel-heading">
                         
                     <div><h5>Continuous Improvement</h5></div>
                        <h5>(Kaizen Mela)</h5>
                                <h5><div>On 5th August 2017</div></h5>  
                                <h5><div id="getting-started"></div></h5> 
                        </div>
                            <div class="panel-footer">
                                <span class="pull-left"></span>
                                   <b>Between 4:00 p.m to 6:00 p.m
                                   At E-2</b>
                                <div class="clearfix"></div>
                            </div>
                    </div>
                </div> -->
                <a class="quick-btn" href="#kaizen" data-toggle="tab" style="text-decoration: none;"> <%
							AllKaizenListDAO kaizenListDAO = new AllKaizenListDAO();
                List<KaizenManagerBean> listofAllKaizen = kaizenListDAO.getListOfManagerBymanagerIdSubmitted(employee_id);
				List<KaizenBean> lisOfMainKaizen = kaizenListDAO.getListOfKaizenBymanagerIdSubmitted(manager_id);
				
				int allKaizen = lisOfMainKaizen.size() + listofAllKaizen.size();
					
				
				List<KaizenBean> listOfKaizen = kaizenListDAO.getListOfKaizenByEmployeerIdByStatus(employee_id);
				allKaizen = allKaizen +  listOfKaizen.size();
				
							%>
							 <i class="icon-desktop icon-3x"></i> <span>CI</span> 
					
									<%if (allKaizen != 0) {%>
											<span class="label label-danger"> 	
												<em><b><%=allKaizen%></b></em>
											</span>
									<%}%>	
					
					
					
					</a>
					
<div class="tab-pane fade" id="kaizen">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseABC">CI Notification</a> <a
											href="#close" data-toggle="tab"><span
											class="pull-right text-muted small"><i
												class="glyphicon glyphicon-remove" data-toggle="tooltip"
												data-placement="top" title="Close"></i></span></a>
									</h4>
								</div>
								
								<div id="collapseABC" class="panel-collapse collapse in active">
								<div class="panel-body">
								
								
									<%
								LoginDAO loginDAO = new LoginDAO();
								for(KaizenBean kaizenBean : listOfKaizen){
									int kaizen_id = kaizenBean.getKaizen_id();
									
									int manager_kaizen_id = kaizenBean.getManager_id();
									EmployeeBean employeeBean = loginDAO.getEmailId(manager_kaizen_id);
									
									String managerApproval = employeeBean.getFirstname()+" "+employeeBean.getLastname()+" - "+kaizenBean.getStatus()+"\n";
									
									List<KaizenManagerBean> listofAllKaizenById = kaizenListDAO.getListOfManagerByKaizenId(kaizen_id);
									List<KaizenManagementApprovalBean> listOfKaizenManagement = kaizenListDAO.getListOfManagemnet(kaizen_id);
									
									for(KaizenManagerBean kaizenManagerBean : listofAllKaizenById){
									
									managerApproval = managerApproval +"\n"+" , "+kaizenManagerBean.getEmployeeBean().getFirstname()+" "+kaizenManagerBean.getEmployeeBean().getLastname()+" - "+kaizenManagerBean.getStatus()+"\n";
									}
									
									for(KaizenManagementApprovalBean kaizenManagemnetApprovalBean : listOfKaizenManagement){
										
										managerApproval = managerApproval +"\n"+" , "+kaizenManagemnetApprovalBean.getEmployeeBean().getFirstname()+" "+kaizenManagemnetApprovalBean.getEmployeeBean().getLastname()+" - "+kaizenManagemnetApprovalBean.getManagement_approval_status()+"\n";
										}
									
									%>
										<a
										href="kaizenView.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>"
										class="list-group-item"> <i class="fa fa-comment fa-fw"></i>
										<b>Approval Status of <%=kaizenBean.getKaizen_name()%> ( <%=managerApproval%> )</b>
									</a>
								<%}%>
								
									
								<%for(KaizenBean kaizenBean : lisOfMainKaizen){ %>				
									<a
										href="kaizenView.jsp?kaizen_id=<%=kaizenBean.getKaizen_id()%>"
										class="list-group-item"> <i class="fa fa-comment fa-fw"></i>
										CI submitted by <b><%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%> from <%=kaizenBean.getEmployeeBean().getDepartmentBean().getDepartment_name()%> Department. Kindly Review this.</b>.
									</a>
								<%} %>
								
								
								<%for(KaizenManagerBean kaizenManagerBean : listofAllKaizen){ %>				
									<a
										href="kaizenView.jsp?kaizen_id=<%=kaizenManagerBean.getKaizenBean().getKaizen_id()%>"
										class="list-group-item"> <i class="fa fa-comment fa-fw"></i>
										CI submitted by <b><%=kaizenManagerBean.getKaizenBean().getEmployeeBean().getFirstname()+" "+kaizenManagerBean.getKaizenBean().getEmployeeBean().getLastname()%> from <%=kaizenManagerBean.getKaizenBean().getEmployeeBean().getDepartmentBean().getDepartment_name()%> Department. Kindly Review this.</b>.
									</a>
								<%} %>	
									
									
									<a href="#" class="list-group-item">
										<center>
											<b>(<%=allKaizen%>)
											</b> Notification(s)
										</center>
									</a>
									<!-- /.panel .chat-panel -->
								</div>
							</div>
								
								</div>
								</div>
<!-- BEGIN VENDOR JS-->
	<!-- build:js app-assets/js/vendors.min.js-->
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
</body>
</html>