<%@page import="com.hrms.lms.bean.GatePassAuthorityBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLTL</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/charts/jquery-jvectormap-2.0.3.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/charts/morris.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/unslider.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/weather-icons/climacons.min.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/colors/palette-gradient.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/plugins/calendars/clndr.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
	
	
	<style>
		#grad2 {
    background: #80D2EF; /* For browsers that do not support gradients */        
    background: -webkit-linear-gradient(90deg, #80D2EF, #80D2EF); /* For Safari 5.1 to 6.0 */
    background: -o-linear-gradient(90deg, #80D2EF, #80D2EF); /* For Opera 11.1 to 12.0 */
    background: -moz-linear-gradient(90deg, #80D2EF, #80D2EF); /* For Firefox 3.6 to 15 */
    background: linear-gradient(90deg, #80D2EF, #80D2EF); /* Standard syntax (must be last) */
}
	</style>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		LoginDAO loginDAO1 = new LoginDAO();

		if (user != null) {
			request.setAttribute("loginError", "You need to login first with your Id and Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			
			/* int role_id = user.getRoleBean().getRole_id();
			String authority = user.getRoleBean().getRole_authority();
			int id = user.getEmployee_master_id();
			int manager_id = user.getManagerBean().getManager_id();
			int emp_id = user.getEmployee_master_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());

			EmployeeBean employeeBean = loginDAO1.getEmailIdEmployee(id);
			String photo = employeeBean.getPhoto();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);

			int company_id = user.getCompanyListBean().getCompany_list_id();
			String company_name = null;
			if (company_id == 1) {
				company_name = "SLTL";
			} else if (company_id == 2) {
				company_name = "SS";
			} else if (company_id == 3) {
				company_name = "S.HR";
			} else if (company_id == 4) {
				company_name = "COSMOS";
			} else if (company_id == 5) {
				company_name = "CSLASER";
			} else if (company_id == 6) {
				company_name = "SEZ";
			} else if (company_id == 7) {
				company_name = "CL";
			}
			if (company_id == 8) {
				company_name = "App";
			}

			AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
			GatePassAuthorityBean gatePassAuthorityBean = allLMSListDAO.authorityOfGatePass(emp_id); */
	%>
    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu undefined navbar-light navbar-border navbar-brand-center">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="icon-menu5 font-large-1"></i></a></li>
            <li class="nav-item"><a href="index-2.html" class="navbar-brand nav-link"><img alt="branding logo" src="app-assets/images/logo/hrms.png" data-expand="app-assets/images/logo/robust-logo-dark.png" data-collapse="app-assets/images/logo/robust-logo-small.png" class="brand-logo" height="45px" width="120px" style="padding-bottom:inherit;padding-top:0px;"></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="icon-ellipsis pe-2x icon-icon-rotate-right-right"></i></a></li> 
          </ul>
        </div>
        <div class="navbar-container container center-layout">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
            <ul class="nav navbar-nav">
              <li class="nav-item hidden-sm-down"><a class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="icon-menu5"></i></a></li>
           
              <li class="nav-item hidden-sm-down"><a href="#" class="nav-link nav-link-expand"><i class="ficon icon-expand2"></i></a></li>
            </ul>
            <ul class="nav navbar-nav float-xs-right">
              <li class="dropdown dropdown-notification nav-item"><a href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i class="ficon icon-bell4"></i><span class="tag tag-pill tag-default tag-danger tag-default tag-up">5</span></a>
                <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
                  <li class="dropdown-menu-header">
                    <h6 class="dropdown-header m-0"><span class="grey darken-2">Notifications</span><span class="notification-tag tag tag-default tag-danger float-xs-right m-0">5 New</span></h6>
                  </li>
                  <li class="list-group scrollable-container"><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left valign-middle"><i class="icon-cart3 icon-bg-circle bg-cyan"></i></div>
                        <div class="media-body">
                          <h6 class="media-heading">You have new order!</h6>
                          <p class="notification-text font-small-3 text-muted">Lorem ipsum dolor sit amet, consectetuer elit.</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">30 minutes ago</time></small>
                        </div>
                      </div></a><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left valign-middle"><i class="icon-monitor3 icon-bg-circle bg-red bg-darken-1"></i></div>
                        <div class="media-body">
                          <h6 class="media-heading red darken-1">99% Server load</h6>
                          <p class="notification-text font-small-3 text-muted">Aliquam tincidunt mauris eu risus.</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Five hour ago</time></small>
                        </div>
                      </div></a><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left valign-middle"><i class="icon-server2 icon-bg-circle bg-yellow bg-darken-3"></i></div>
                        <div class="media-body">
                          <h6 class="media-heading yellow darken-3">Warning notifixation</h6>
                          <p class="notification-text font-small-3 text-muted">Vestibulum auctor dapibus neque.</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Today</time></small>
                        </div>
                      </div></a><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left valign-middle"><i class="icon-check2 icon-bg-circle bg-green bg-accent-3"></i></div>
                        <div class="media-body">
                          <h6 class="media-heading">Complete the task</h6><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Last week</time></small>
                        </div>
                      </div></a><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left valign-middle"><i class="icon-bar-graph-2 icon-bg-circle bg-teal"></i></div>
                        <div class="media-body">
                          <h6 class="media-heading">Generate monthly report</h6><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Last month</time></small>
                        </div>
                      </div></a></li>
                  <li class="dropdown-menu-footer"><a href="javascript:void(0)" class="dropdown-item text-muted text-xs-center">Read all notifications</a></li>
                </ul>
              </li>
              <li class="dropdown dropdown-notification nav-item"><a href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i class="ficon icon-mail6"></i><span class="tag tag-pill tag-default tag-info tag-default tag-up">8</span></a>
                <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
                  <li class="dropdown-menu-header">
                    <h6 class="dropdown-header m-0"><span class="grey darken-2">Messages</span><span class="notification-tag tag tag-default tag-info float-xs-right m-0">4 New</span></h6>
                  </li>
                  <li class="list-group scrollable-container"><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left"><span class="avatar avatar-sm avatar-online rounded-circle"><img src="app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span></div>
                        <div class="media-body">
                          <h6 class="media-heading">Margaret Govan</h6>
                          <p class="notification-text font-small-3 text-muted">I like your portfolio, let's start the project.</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Today</time></small>
                        </div>
                      </div></a><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left"><span class="avatar avatar-sm avatar-busy rounded-circle"><img src="app-assets/images/portrait/small/avatar-s-2.png" alt="avatar"><i></i></span></div>
                        <div class="media-body">
                          <h6 class="media-heading">Bret Lezama</h6>
                          <p class="notification-text font-small-3 text-muted">I have seen your work, there is</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Tuesday</time></small>
                        </div>
                      </div></a><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left"><span class="avatar avatar-sm avatar-online rounded-circle"><img src="app-assets/images/portrait/small/avatar-s-3.png" alt="avatar"><i></i></span></div>
                        <div class="media-body">
                          <h6 class="media-heading">Carie Berra</h6>
                          <p class="notification-text font-small-3 text-muted">Can we have call in this week ?</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Friday</time></small>
                        </div>
                      </div></a><a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left"><span class="avatar avatar-sm avatar-away rounded-circle"><img src="app-assets/images/portrait/small/avatar-s-6.png" alt="avatar"><i></i></span></div>
                        <div class="media-body">
                          <h6 class="media-heading">Eric Alsobrook</h6>
                          <p class="notification-text font-small-3 text-muted">We have project party this saturday night.</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">last month</time></small>
                        </div>
                      </div></a></li>
                  <li class="dropdown-menu-footer"><a href="javascript:void(0)" class="dropdown-item text-muted text-xs-center">Read all messages</a></li>
                </ul>
              </li>
              <li class="dropdown dropdown-user nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link dropdown-user-link"><span class="avatar avatar-online"><img src="app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span><span class="user-name">John Doe</span></a>
                <div class="dropdown-menu dropdown-menu-right"><a href="#" class="dropdown-item"><i class="icon-head"></i> Edit Profile</a><a href="#" class="dropdown-item"><i class="icon-mail6"></i> My Inbox</a><a href="#" class="dropdown-item"><i class="icon-clipboard2"></i> Task</a><a href="#" class="dropdown-item"><i class="icon-calendar5"></i> Calender</a>
                  <div class="dropdown-divider"></div><a href="#" class="dropdown-item"><i class="icon-power3"></i> Logout</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
 
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <!-- Horizontal navigation-->
    <div role="navigation" data-menu="menu-wrapper" class="header-navbar navbar navbar-horizontal navbar-fixed navbar-light navbar-without-dd-arrow navbar-bordered navbar-shadow">
      <!-- Horizontal menu content-->
      <div data-menu="menu-container" class="navbar-container main-menu-content container center-layout">
        <!-- include includes/mixins-->
        <ul id="main-menu-navigation" data-menu="menu-navigation" class="nav navbar-nav">
          <li data-menu="dropdown" class="dropdown nav-item"><a href="index-2.html" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-home3"></i><span data-i18n="nav.dash.main">Dashboard</span></a></li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-paper-stack"></i><span data-i18n="nav.templates.main">Company Details</span></a>
            <ul class="dropdown-menu">
              <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Company Address</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">CUG No</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Extension No.</a></li>
            </ul>
          </li>
          
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-paper-stack"></i><span data-i18n="nav.templates.main">Employee Master</span></a>
            <ul class="dropdown-menu">
              <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Add New Employee</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">View All Employee</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">CompanyWxise Employee</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Add Designation</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Add Sub Department</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Employee CSV upload</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">View Documents</a></li>
            </ul>
          </li>
          
          
           <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-paper-stack"></i><span data-i18n="nav.templates.main">Self Service HR</span></a>
            <ul class="dropdown-menu">
              <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Upload Attachment</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">My Documents</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Update Profile</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">View Employee</a></li>
            </ul>
          </li>
          
          
           <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-paper-stack"></i><span data-i18n="nav.templates.main">Project Master</span></a>
            <ul class="dropdown-menu">
              <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Add New Project</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Project List</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">My Project Allocations</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Employee Allocation</a></li>
            </ul>
          </li>
          
          
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-paper-stack"></i><span data-i18n="nav.templates.main">Time-Sheet Management</span></a>
            <ul class="dropdown-menu">
              <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">My Time-sheet</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item"> Timesheet Status</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">My Project Allocations</a></li>
               <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Employee Allocation</a></li>
            </ul>
          </li>
          
          
          
        </ul>
      </div>
      <!-- /horizontal menu content-->
    </div>
    <!-- Horizontal navigation-->

   
    <!-- ////////////////////////////////////////////////////////////////////////////-->

<%} %>

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
    <script src="app-assets/vendors/js/charts/raphael-min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/charts/morris.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/charts/chart.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/charts/jvector/jquery-jvectormap-2.0.3.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/charts/jvector/jquery-jvectormap-world-mill.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/extensions/moment.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/extensions/underscore-min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/extensions/clndr.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/charts/echarts/echarts.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/extensions/unslider-min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/pages/dashboard-ecommerce.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
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