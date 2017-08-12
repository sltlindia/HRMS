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
   <!--  <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png"> -->
	   <!--  <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
	    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png"> -->
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

		if (user == null) {
			request.setAttribute("loginError", "You need to login first with your Id and Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			
			int role_id = user.getRoleBean().getRole_id();
			String authority = user.getRoleBean().getRole_authority();
			int id = user.getEmployee_master_id();
			int manager_id = user.getManagerBean().getManager_id();
			int emp_id = user.getEmployee_master_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());

			EmployeeBean employeeBean = loginDAO1.getEmailIdEmployee(id);
			/* System.out.println("-----------------");
			EmployeeBean employeeBean1 = loginDAO1.getEmailIdEmployeeByCallProcedure(342); */  // Store Procedure Demo
			
			
			
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
			GatePassAuthorityBean gatePassAuthorityBean = allLMSListDAO.authorityOfGatePass(emp_id);
	%>
    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu undefined navbar-light navbar-border navbar-brand-center">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="icon-menu5 font-large-1"></i></a></li>
            <li class="nav-item"><a href="index-2.html" class="navbar-brand nav-link"><img alt="branding logo" src="app-assets/images/logo/robust-logo-dark.png" data-expand="app-assets/images/logo/robust-logo-dark.png" data-collapse="app-assets/images/logo/robust-logo-small.png" class="brand-logo"></a></li>
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
                          <h6 class="media-heading">john </h6>
                          <p class="notification-text font-small-3 text-muted">We have project party this saturday night.</p><small>
                            <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">last month</time></small>
                        </div>
                      </div></a></li>
                  <li class="dropdown-menu-footer"><a href="javascript:void(0)" class="dropdown-item text-muted text-xs-center">Read all messages</a></li>
                </ul>
              </li>
              <li class="dropdown dropdown-user nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link dropdown-user-link"><span class="avatar avatar-online"><img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=user.getEmployee_code()%>.bmp" alt="avatar"><i></i></span><span class="user-name"><%=user.getFirstname()+" "+user.getLastname()%></span></a>
                <div class="dropdown-menu dropdown-menu-right"><a href="#" class="dropdown-item"><i class="icon-head"></i> Edit Profile</a>
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
          <li data-menu="dropdown" class="dropdown nav-item"><a href="hrHome.jsp" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-home3"></i><span data-i18n="nav.dash.main">Dashboard</span></a>
          	<ul class="dropdown-menu">
          	<%if(manager_id != 99){ 
          		if(manager_id == 1 || manager_id == 2 || manager_id == 3){ %>
              		<li data-menu="" class="active"><a href="sltlAdmin.jsp" data-toggle="dropdown" class="dropdown-item">Home</a></li>
          	<%}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){ %>
              		<li data-menu="" class="active"><a href="hrHome.jsp" data-toggle="dropdown" class="dropdown-item">Home</a></li>
          	<%}else{ %>
              		<li data-menu="" class="active"><a href="managerHome.jsp" data-toggle="dropdown" class="dropdown-item">Home</a></li>
          	<%}%>
          	<%}else{
			if(under_manager_id == 4 || under_manager_id == 117){ %>
              				<li data-menu="" class="active"><a href="hrHome.jsp" data-toggle="dropdown" class="dropdown-item">Home</a></li>
					<%}else{%>
              				<li data-menu="" class="active"><a href="empHome.jsp" data-toggle="dropdown" class="dropdown-item">Home</a></li>
				<%} }%>	
				
				<li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Company Details</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="companyAddresses.jsp" data-toggle="dropdown" class="dropdown-item">Company Address</a>
                  </li>
                  <li data-menu=""><a href="cugList.jsp" data-toggle="dropdown" class="dropdown-item">CUG No</a>
                  </li>
                  <li data-menu=""><a href="extentionNumber.jsp" data-toggle="dropdown" class="dropdown-item">Extension No</a>
                  </li>
                </ul>
              </li>
				
          		</ul>
          </li>
          
          <%if(manager_id == 26 || manager_id == 11 || manager_id == 53){ %>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="index-2.html" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-home3"></i><span data-i18n="nav.dash.main">Incentive</span></a>
            <ul class="dropdown-menu">
              <li data-menu=""><a href="targetSales.jsp" data-toggle="dropdown" class="dropdown-item">Add Target</a>
              </li>
              <li data-menu=""><a href="incentive.jsp" data-toggle="dropdown" class="dropdown-item">Incentive Form</a>
              </li>
              <li data-menu=""><a href="incentiveListByYear.jsp" data-toggle="dropdown" class="dropdown-item">Incentive List</a>
              </li>
              <li data-menu=""><a href="incentiveMaster.jsp" data-toggle="dropdown" class="dropdown-item">Incentive Policy</a>
              </li>
              <li data-menu=""><a href="incentiveMaster1.jsp" data-toggle="dropdown" class="dropdown-item">Incentive Master</a>
              </li>
            </ul>
          </li>
          <%} %>
          
          
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-square-plus"></i><span data-i18n="nav.category.addons">Self Service</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Self Service HR
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="selfService.jsp" class="dropdown-item"><i></i>Upload Document</a>
                      </li>
                      <li><a href="selfServiceList.jsp" class="dropdown-item"><i></i>My Document</a>
                      </li>
                      <li><a href="employeeSelfUpdate.jsp" class="dropdown-item"><i></i>Update Profile</a>
                      </li>
                      <li><a href="employeeList.jsp" class="dropdown-item"><i></i>View Employee</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-air-play"></i>TDS Calculation
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="jquery-ui-interactions.html" class="dropdown-item"><i class="undefined"></i>Rules</a>
                      </li>
                      <li><a href="jquery-ui-navigations.html" class="dropdown-item"><i class="undefined"></i>Declaration Form</a>
                      </li>
                      <li><a href="jquery-ui-date-pickers.html" class="dropdown-item"><i class="undefined"></i>Upload Investment Proofs</a>
                      </li>
                      
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-tune"></i>Exit Formality
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-calendar5"></i>Exit Interview</a>
                      <ul class="mega-menu-sub">
                          <li><a href="exitInterviewForm.jsp" class="dropdown-item"><i></i>Exit Interview Form</a>
                          </li>
                          <li><a href="exitInterviewManagerList.jsp" class="dropdown-item"><i></i>Exit Interview List</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="add-on-block-ui.html" class="dropdown-item"><i class="icon-security"></i>Hand Over</a>
                      <ul class="mega-menu-sub">
                          <li><a href="handOverForm.jsp" class="dropdown-item"><i></i>Hand Over Form</a>
                          </li>
                          <li><a href="handOverFormList.jsp" class="dropdown-item"><i></i>Hand Over Form List</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-table2"></i>Broadcast
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                    <%if(manager_id != 99){%>
                      <li><a href="announcementForm.jsp" class="dropdown-item"><i class="undefined"></i>Add Broadcast</a>
                      </li>
                      <li><a href="announcementList.jsp" class="dropdown-item"><i class="undefined"></i>Send Broadcast History</a>
                      </li>
                      <%} %>
                      <li><a href="announcementEmployeeSide.jsp" class="dropdown-item"><i class="undefined"></i>Receive Broadcast History</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          
          
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-square-plus"></i><span data-i18n="nav.category.addons">Project & Timesheet</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Project Management
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                    <%if (manager_id != 99) { %>
                      <li><a href="addProject.jsp" class="dropdown-item"><i></i>Add New Project</a>
                      </li>
                      <li><a href="projectList.jsp" class="dropdown-item"><i></i>Project List</a>
                      </li>
                      <%}%>
                      <li><a href="myProjectAllocations.jsp" class="dropdown-item"><i></i>My Project Allocation</a>
                      </li>
                      <%if (manager_id != 99) { %>
                      <li><a href="employeeAllocationStatus.jsp" class="dropdown-item"><i></i>Employee Allocation</a>
                      </li>
                      <%} %>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-air-play"></i>Timesheet Management
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="timesheet.jsp" class="dropdown-item"><i class="undefined"></i>My Timesheet</a>
                      </li>
                      <%if (manager_id != 99) { %>
                      <li><a href="jquery-ui-navigations.html" class="dropdown-item"><i class="undefined"></i>Timesheet Status</a>
                      	<ul class="mega-menu-sub">
                          <li><a href="pendingTimeSheetList" class="dropdown-item"><i></i>Pending Timesheet</a>
                          </li>
                          <li><a href="approvedTimeSheet" class="dropdown-item"><i></i>Approved Timesheet</a>
                          </li>
                          <li><a href="rejectedTimeSheet" class="dropdown-item"><i></i>Rejected Timesheet</a>
                          </li>
                        </ul>
                      </li>
                      <%} %>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-table2"></i>Appraisal Management
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                    <%if (manager_id == 99) { %>
                      <li><a href="whiteCollarAppraisal.jsp" class="dropdown-item"><i class="undefined"></i>Self Appraisal</a>
                      </li>
                      <li><a href="appraisalHistory.jsp" class="dropdown-item"><i class="undefined"></i>My Appraisal History</a>
                      </li>
                      <%} %>
                      <%if (manager_id != 99) { %>
                      <li><a href="i18n-query-string.html" class="dropdown-item"><i class="undefined"></i>Indirect Employee</a>
                      	<ul class="mega-menu-sub">
                          <li><a href="whiteCollarAppraisal.jsp" class="dropdown-item"><i></i>Self Appraisal</a>
                          </li>
                          <li><a href="appraisalHistory.jsp" class="dropdown-item"><i></i>My Appraisal History</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="i18n-on-init.html" class="dropdown-item"><i class="undefined"></i>Direct Employee</a>
                      	<ul class="mega-menu-sub">
                          <li><a href="appraisalFormManager.jsp" class="dropdown-item"><i></i>Blue Collar Appraisal</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="i18n-after-init.html" class="dropdown-item"><i class="undefined"></i>Appraisal History</a>
                      	<ul class="mega-menu-sub">
                          <li><a href="allWhiteCollarAppraisal.jsp" class="dropdown-item"><i></i>Team Appraisal</a>
                          </li>
                          <li><a href="allAppraisal.jsp" class="dropdown-item"><i></i>All Appraisal</a>
                          </li>
                        </ul>
                       </li>
                       <%} %>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-tune"></i>Reports
                </h6>
                <%if (manager_id != 99) { %>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-calendar5"></i>Project Report</a>
                        <ul class="mega-menu-sub">
                          <li><a href="weeklyCostReport.jsp" class="dropdown-item"><i></i>Cash-flow Report</a>
                          </li>
                          <li><a href="resourceUsageReport.jsp" class="dropdown-item"><i></i>Resource usage</a>
                          </li>
                          <li><a href="weeklyHourReport.jsp" class="dropdown-item"><i></i>Weekly-Hours Report</a>
                          </li>
                          <li><a href="effortReport.jsp" class="dropdown-item"><i></i>Effort Variance Report</a>
                          </li>
                          <li><a href="scheduleReport.jsp" class="dropdown-item"><i></i>Schedule Variance Report</a>
                          </li>
                          <li><a href="overTimeReport.jsp" class="dropdown-item"><i></i>Over-Time Report</a>
                          </li>
                          <li><a href="managerStatusReport.jsp" class="dropdown-item"><i></i>Status Report</a>
                          </li>
                          <li><a href="weeklyTaskReport.jsp" class="dropdown-item"><i></i>Weekly Task Report</a>
                          </li>
                          <li><a href="costVariance.jsp" class="dropdown-item"><i></i>Cost Variance</a>
                          </li>
                          <li><a href="delayedTaskReport.jsp" class="dropdown-item"><i></i>Delayed Task Report</a>
                          </li>
                        </ul>
                      </li>
                      
                      <li><a href="#" class="dropdown-item"><i class="icon-cloud-upload3"></i>Timesheet Report</a>
                        <ul class="mega-menu-sub">
                          <li><a href="projectReport.jsp" class="dropdown-item"><i class="undefined"></i>Project Wise Report</a>
                          </li>
                          <li><a href="employeeReport.jsp" class="dropdown-item"><i class="undefined"></i>Employee Wise Report</a>
                          </li>
                          <li><a href="defaultersReport.jsp" class="dropdown-item"><i class="undefined"></i>Defaulters Report</a>
                          </li>
                          <li><a href="statusReport.jsp" class="dropdown-item"><i class="undefined"></i>Status Report</a>
                          </li>
                        </ul>
                      </li>
                      
                       <!-- <li><a href="#" class="dropdown-item"><i class="icon-cloud-upload3"></i>Appraisal Report</a>
                        <ul class="mega-menu-sub">
                          <li><a href="file-uploader-dropzone.html" class="dropdown-item"><i class="undefined"></i>White Collar Excel Report</a>
                          </li>
                          <li><a href="file-uploader-jquery.html" class="dropdown-item"><i class="undefined"></i>Blue Collar Excel Report</a>
                          </li>
                        </ul>
                      </li> -->
                      
                      
                    </ul>
                  </li>
                </ul>
                <%} %>
              </li>
            </ul>
          </li>
          
          <%if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){ %>
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-square-plus"></i><span data-i18n="nav.category.addons">HR Management</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-2" class="col-md-2">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Employee Master
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="ornogram.jsp" class="dropdown-item"><i></i>Organigram</a>
                      </li>
                      <li><a href="newEmployee.jsp" class="dropdown-item"><i></i>Add New Employee</a>
                      </li>
                      <li><a href="employeeList.jsp" class="dropdown-item"><i></i>View All Employee</a>
                      </li>
                      <li><a href="employeeListCompanyWise.jsp" class="dropdown-item"><i></i>Employee By Company</a>
                      </li>
                      <li><a href="addDesignation.jsp" class="dropdown-item"><i></i>Add Designation</a>
                      </li>
                      <li><a href="addSubDepartment.jsp" class="dropdown-item"><i></i>Add Sub Department</a>
                      </li>
                      <li><a href="employeeCSV.jsp" class="dropdown-item"><i></i>Employee CSV Upload</a>
                      </li>
                      <li><a href="selfServiceAllEmployee.jsp" class="dropdown-item"><i></i>View Documents</a>
                      </li>
                      
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-2" class="col-md-2">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-air-play"></i>Leave
                
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="leaveadjustHR.jsp" class="dropdown-item"><i class="undefined"></i>Leave Adjust Form</a>
                      </li>
                      <li><a href="leaveHolidayAddHR.jsp" class="dropdown-item"><i class="undefined"></i>Holiday Update</a>
                      </li>
                      <li><a href="pendingLeaveHrSide.jsp" class="dropdown-item"><i class="undefined"></i>All Leave / CO / OD</a>
                      </li>
                      <li><a href="leaveReportByDate?date=<%=date1%>" class="dropdown-item"><i class="undefined"></i>Leave Report By Date</a>
                      </li>
                      <li><a href="specialHRLeavep.jsp" class="dropdown-item"><i class="undefined"></i>Special Leave Taken</a>
                      </li>
                      <li><a href="gatePassHistoryHRSide.jsp" class="dropdown-item"><i class="undefined"></i>Gate Pass Status</a>
                      </li>
                      <li><a href="hrShowAttendance.jsp" class="dropdown-item"><i class="undefined"></i>In / Out Report</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-2" class="col-md-2">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-table2"></i>Grievance 
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                    <li><a href="allGrievanceList.jsp" class="dropdown-item"><i class="undefined"></i>All Query</a>
                      </li>
                      <li><a href="grievanceQueryType.jsp" class="dropdown-item"><i class="undefined"></i>Add Query Type</a>
                      </li>
                      <li><a href="grievanceDashboard.jsp" class="dropdown-item"><i class="undefined"></i>Grievance Report</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-2" class="col-md-2">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-tune"></i>Appraisal 
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                          <li><a href="allAppraisal.jsp" class="dropdown-item"><i></i>All Appraisal</a>
                          </li>
                          <li><a href="HRWhiteAppraisalExcel.jsp" class="dropdown-item"><i></i>White Collar Excel</a>
                          </li>
                          <li><a href="HRBlueAppraisalExcel.jsp" class="dropdown-item"><i></i>Blue Collar Excel</a>
                          </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-2" class="col-md-2">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-tune"></i>Exit Interview 
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                          <li><a href="exitInterviewHRList.jsp" class="dropdown-item"><i></i>Exit Interview Form List</a>
                          </li>
						  <li><a href="exitInterviewFinalReviewList.jsp" class="dropdown-item"><i></i>Exit Interview Final List</a>
                          </li>                          
                          <li><a href="handOverFormHRList.jsp" class="dropdown-item"><i></i>Hand Over Form List</a>
                          </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-2" class="col-md-2">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-tune"></i>TDS Calculation 
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                          <li><a href="jquery-ui-autocomplete.html" class="dropdown-item"><i class="undefined"></i>Declaration Form List</a>
                      </li>
                      <li><a href="jquery-ui-buttons-select.html" class="dropdown-item"><i class="undefined"></i>Investment Proof List</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>

              <li data-mega-col="col-md-2" class="col-md-2">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-tune"></i>Broadcast
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                          <li><a href="announcementList.jsp" class="dropdown-item"><i></i>All Broadcast</a>
                          </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
            </ul>
          </li>
          <%} %>
          
          
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-square-plus"></i><span data-i18n="nav.category.addons">Leave & Gate Pass</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-6" class="col-md-6">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Leave Management
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="leaveholidayList.jsp" class="dropdown-item"><i></i>Holiday List</a>
                      </li>
                      <li><a href="leavebalance.jsp" class="dropdown-item"><i></i>Leave Balance</a>
                      </li>
                      <li><a href="applyLeaveODCOForm.jsp" class="dropdown-item"><i></i>Apply Leave / CO / OD</a>
                      </li>
                      <li><a href="leavesuccess.jsp" class="dropdown-item"><i></i>Leave / CO / OD Status</a>
                      </li>
                      <li><a href="ShowAttendance.jsp" class="dropdown-item"><i></i>Self IN / OUT</a>
                      </li>
                      <li><a href="leaveRules.jsp" class="dropdown-item"><i></i>Leave Rules</a>
                      </li>
                      <%if(manager_id != 99){%>
                      <li><a href="editor-quill.html" class="dropdown-item"><i></i>Team Member Status</a>
                      	<ul class="mega-menu-sub">
                          <li><a href="leaveListManager.jsp" class="dropdown-item"><i></i>Leave / CO / OD Status</a>
                          </li>
                          <li><a href="gatePassListManager.jsp" class="dropdown-item"><i></i>IN / OUT Status</a>
                          </li>
                    	</ul>
                      </li>
                      <%} %>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-6" class="col-md-6">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Gate Pass
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="leave_gatepassEmployee.jsp" class="dropdown-item"><i></i>Gate Pass Form</a>
                      </li>
                      <li><a href="gatePassListEmployee.jsp" class="dropdown-item"><i></i>Gate Pass List</a>
                      </li>
                       <%if(manager_id != 99){%>
                      <li><a href="editor-quill.html" class="dropdown-item"><i></i>Team Member Status</a>
                      	<ul class="mega-menu-sub">
                          <li><a href="gatePassListManager.jsp" class="dropdown-item"><i></i>Gate Pass Status</a>
                          </li>
                    	</ul>
                      </li>
                      <%} %>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          
          
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-square-plus"></i><span data-i18n="nav.category.addons">Complaint Management</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-6" class="col-md-6">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Grievance Management
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="grievance.jsp" class="dropdown-item"><i></i>Add Query</a>
                      </li>
                      <li><a href="allGrievanceList.jsp" class="dropdown-item"><i></i>My All Queries</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-6" class="col-md-6">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>IT Complaint
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="complaint.jsp" class="dropdown-item"><i></i>Add Complaint</a>
                      </li>
                      <li><a href="complaintList.jsp" class="dropdown-item"><i></i>My All Complaints</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          
          <%if(manager_id == 65 || manager_id == 5 || under_manager_id == 65) {%>
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-square-plus"></i><span data-i18n="nav.category.addons">IT</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-6" class="col-md-6">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Complaint Register
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="ProblemNature.jsp" class="dropdown-item"><i></i>Add Problem Nature</a>
                      </li>
                      <li><a href="itComplaint.jsp" class="dropdown-item"><i></i>All Complaints</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              
              <li data-mega-col="col-md-6" class="col-md-6">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Asset Management
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="editor-quill.html" class="dropdown-item"><i></i>Machine Detail</a>
                      		<ul class="mega-menu-sub">
		                      <li><a href="machineDetail.jsp" class="dropdown-item"><i></i>Fill Machine Detail</a>
		                      </li>
		                      <li><a href="machineDetailList.jsp" class="dropdown-item"><i></i>Machine Report</a>
		                      </li>
		                    </ul>
                      </li>
                      <li><a href="editor-quill.html" class="dropdown-item"><i></i>Asset Detail</a>
                      		<ul class="mega-menu-sub">
		                      <li><a href="stockDetail.jsp" class="dropdown-item"><i></i>Add Stock</a>
		                      </li>
		                      <li><a href="addAsset.jsp" class="dropdown-item"><i></i>Asset Master</a>
		                      </li>
		                      <li><a href="stockList.jsp" class="dropdown-item"><i></i>IT Asset</a>
		                      </li>
		                      <li><a href="assetAllocation.jsp" class="dropdown-item"><i></i>Asset List</a>
		                      </li>
		                      <li><a href="scrapList.jsp" class="dropdown-item"><i></i>All Scrap List</a>
		                      </li>
		                      <li><a href="assetTransfer.jsp" class="dropdown-item"><i></i>Allocated Asset List</a>
		                      </li>
		                    </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <%} %>
          
          
          
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