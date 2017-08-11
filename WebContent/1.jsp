<!DOCTYPE html>
<html lang="en" data-textdirection="LTR" class="loading">
  
<!-- Mirrored from pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 09 Aug 2017 08:48:02 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
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
          <li data-menu="dropdown" class="dropdown nav-item"><a href="index-2.html" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-home3"></i><span data-i18n="nav.dash.main">Dashboard</span></a>
            <ul class="dropdown-menu">
              <li data-menu="" class="active"><a href="dashboard-ecommerce.html" data-toggle="dropdown" class="dropdown-item">eCommerce</a>
              </li>
              <li data-menu=""><a href="dashboard-project.html" data-toggle="dropdown" class="dropdown-item">Project</a>
              </li>
              <li data-menu=""><a href="dashboard-analytics.html" data-toggle="dropdown" class="dropdown-item">Analytics</a>
              </li>
              <li data-menu=""><a href="dashboard-crm.html" data-toggle="dropdown" class="dropdown-item">CRM</a>
              </li>
              <li data-menu=""><a href="dashboard-fitness.html" data-toggle="dropdown" class="dropdown-item">Fitness</a>
              </li>
            </ul>
          </li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-paper-stack"></i><span data-i18n="nav.templates.main">Templates</span></a>
            <ul class="dropdown-menu">
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Vertical</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-menu-template" data-toggle="dropdown" class="dropdown-item">Classic Menu</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-compact-menu-template" data-toggle="dropdown" class="dropdown-item">Compact Menu</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-content-menu-template" data-toggle="dropdown" class="dropdown-item">Content Menu</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-overlay-menu-template" data-toggle="dropdown" class="dropdown-item">Overlay Menu</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-multi-level-menu-template" data-toggle="dropdown" class="dropdown-item">Multi-level Menu</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Horizontal</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template" data-toggle="dropdown" class="dropdown-item">Classic</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-top-icon-menu-template" data-toggle="dropdown" class="dropdown-item">Top Icon</a>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-layout"></i><span data-i18n="nav.layouts.temp">Layouts</span></a>
            <ul class="dropdown-menu">
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Page layouts</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="horizontal-layout-1-column.html" data-toggle="dropdown" class="dropdown-item">1 column</a>
                  </li>
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Content Det. Sidebar</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="layout-content-detached-left-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached left sidebar</a>
                      </li>
                      <li data-menu=""><a href="layout-content-detached-left-sticky-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached sticky left sidebar</a>
                      </li>
                      <li data-menu=""><a href="layout-content-detached-right-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached right sidebar</a>
                      </li>
                      <li data-menu=""><a href="layout-content-detached-right-sticky-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached sticky right sidebar</a>
                      </li>
                    </ul>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li data-menu=""><a href="layout-fixed-navigation.html" data-toggle="dropdown" class="dropdown-item">Fixed navigation</a>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li data-menu=""><a href="layout-fixed.html" data-toggle="dropdown" class="dropdown-item">Fixed layout</a>
                  </li>
                  <li data-menu=""><a href="layout-boxed.html" data-toggle="dropdown" class="dropdown-item">Boxed layout</a>
                  </li>
                  <li data-menu=""><a href="layout-static.html" data-toggle="dropdown" class="dropdown-item">Static layout</a>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li data-menu=""><a href="layout-light.html" data-toggle="dropdown" class="dropdown-item">Light layout</a>
                  </li>
                  <li data-menu=""><a href="layout-dark.html" data-toggle="dropdown" class="dropdown-item">Dark layout</a>
                  </li>
                  <li data-menu=""><a href="layout-semi-dark.html" data-toggle="dropdown" class="dropdown-item">Semi dark layout</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Navbars</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="navbar-light.html" data-toggle="dropdown" class="dropdown-item">Navbar Light</a>
                  </li>
                  <li data-menu=""><a href="navbar-dark.html" data-toggle="dropdown" class="dropdown-item">Navbar Dark</a>
                  </li>
                  <li data-menu=""><a href="navbar-semi-dark.html" data-toggle="dropdown" class="dropdown-item">Navbar Semi Dark</a>
                  </li>
                  <li data-menu=""><a href="navbar-brand-center.html" data-toggle="dropdown" class="dropdown-item">Brand Center</a>
                  </li>
                  
                  
                  <li data-menu=""><a href="navbar-components.html" data-toggle="dropdown" class="dropdown-item">Navbar Components</a>
                  </li>
                  <li data-menu=""><a href="navbar-styling.html" data-toggle="dropdown" class="dropdown-item">Navbar Styling</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Vertical Nav</a>
                <ul class="dropdown-menu">
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Navigation Types</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-menu-template" data-toggle="dropdown" class="dropdown-item">Vertical Menu</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-multi-level-menu-template" data-toggle="dropdown" class="dropdown-item">Vertical MMenu</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-overlay-menu-template" data-toggle="dropdown" class="dropdown-item">Vertical Overlay</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-compact-menu-template" data-toggle="dropdown" class="dropdown-item">Vertical Compact</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/vertical-content-menu-template" data-toggle="dropdown" class="dropdown-item">Vertical Content</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Horizontal Nav</a>
                <ul class="dropdown-menu">
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Navigation Types</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template" data-toggle="dropdown" class="dropdown-item">Left Icon Navigation</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-top-icon-menu-template" data-toggle="dropdown" class="dropdown-item">Top Icon Navigation</a>
                      </li>
                    </ul>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-mega-menu.html" data-toggle="dropdown" class="dropdown-item">Mega Menu</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-fixed.html" data-toggle="dropdown" class="dropdown-item">Fixed Navigation</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-flipped.html" data-toggle="dropdown" class="dropdown-item">Flipped Navigation</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-submenu-click.html" data-toggle="dropdown" class="dropdown-item">Submenu on Click</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-submenu-hover.html" data-toggle="dropdown" class="dropdown-item">Submenu on Hover</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-light.html" data-toggle="dropdown" class="dropdown-item">Light Navigation</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-dark.html" data-toggle="dropdown" class="dropdown-item">Dark Navigation</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-right-side-icons.html" data-toggle="dropdown" class="dropdown-item">Right side icons</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-no-dropdown.html" data-toggle="dropdown" class="dropdown-item">No Dropdown Arrow</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-disabled.html" data-toggle="dropdown" class="dropdown-item">Disabled Navigation</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-tags-pills.html" data-toggle="dropdown" class="dropdown-item">Tags &amp; Pills</a>
                  </li>
                  <li data-menu=""><a href="horizontal-nav-styling.html" data-toggle="dropdown" class="dropdown-item">Navigation Styling</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Page Headers</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="headers-breadcrumbs-basic.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs basic</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-top.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs top</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-bottom.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs bottom</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-top-with-description.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs top with desc</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-with-button.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs with button</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-with-round-button.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs with button 2</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-with-button-group.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs with buttons</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-with-description.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs with desc</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-with-search.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs with search</a>
                  </li>
                  <li data-menu=""><a href="headers-breadcrumbs-with-stats.html" data-toggle="dropdown" class="dropdown-item">Breadcrumbs with stats</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Footers</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="footer-light.html" data-toggle="dropdown" class="dropdown-item">Footer Light</a>
                  </li>
                  <li data-menu=""><a href="footer-dark.html" data-toggle="dropdown" class="dropdown-item">Footer Dark</a>
                  </li>
                  <li data-menu=""><a href="footer-transparent.html" data-toggle="dropdown" class="dropdown-item">Footer Transparent</a>
                  </li>
                  <li data-menu=""><a href="footer-fixed.html" data-toggle="dropdown" class="dropdown-item">Footer Fixed</a>
                  </li>
                  <li data-menu=""><a href="footer-components.html" data-toggle="dropdown" class="dropdown-item">Footer Components</a>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-folder4"></i><span data-i18n="nav.category.general">General</span></a>
            <ul class="dropdown-menu">
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Color Palette</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="color-palette-primary.html" data-toggle="dropdown" class="dropdown-item">Primary palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-danger.html" data-toggle="dropdown" class="dropdown-item">Danger palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-success.html" data-toggle="dropdown" class="dropdown-item">Success palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-warning.html" data-toggle="dropdown" class="dropdown-item">Warning palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-info.html" data-toggle="dropdown" class="dropdown-item">Info palette</a>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li data-menu=""><a href="color-palette-red.html" data-toggle="dropdown" class="dropdown-item">Red palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-pink.html" data-toggle="dropdown" class="dropdown-item">Pink palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-purple.html" data-toggle="dropdown" class="dropdown-item">Purple palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-deep-purple.html" data-toggle="dropdown" class="dropdown-item">Deep Purple palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-indigo.html" data-toggle="dropdown" class="dropdown-item">Indigo palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-blue.html" data-toggle="dropdown" class="dropdown-item">Blue palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-light-blue.html" data-toggle="dropdown" class="dropdown-item">Light Blue palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-cyan.html" data-toggle="dropdown" class="dropdown-item">Cyan palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-teal.html" data-toggle="dropdown" class="dropdown-item">Teal palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-green.html" data-toggle="dropdown" class="dropdown-item">Green palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-light-green.html" data-toggle="dropdown" class="dropdown-item">Light Green palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-lime.html" data-toggle="dropdown" class="dropdown-item">Lime palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-yellow.html" data-toggle="dropdown" class="dropdown-item">Yellow palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-amber.html" data-toggle="dropdown" class="dropdown-item">Amber palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-orange.html" data-toggle="dropdown" class="dropdown-item">Orange palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-deep-orange.html" data-toggle="dropdown" class="dropdown-item">Deep Orange palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-brown.html" data-toggle="dropdown" class="dropdown-item">Brown palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-blue-grey.html" data-toggle="dropdown" class="dropdown-item">Blue Grey palette</a>
                  </li>
                  <li data-menu=""><a href="color-palette-grey.html" data-toggle="dropdown" class="dropdown-item">Grey palette</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Starter kit</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/horizontal-layout-1-column.html" data-toggle="dropdown" class="dropdown-item">1 column</a>
                  </li>
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Content Det. Sidebar</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-content-detached-left-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached left sidebar</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-content-detached-left-sticky-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached sticky left sidebar</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-content-detached-right-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached right sidebar</a>
                      </li>
                      <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-content-detached-right-sticky-sidebar.html" data-toggle="dropdown" class="dropdown-item">Detached sticky right sidebar</a>
                      </li>
                    </ul>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-fixed-navigation.html" data-toggle="dropdown" class="dropdown-item">Fixed navigation</a>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-fixed.html" data-toggle="dropdown" class="dropdown-item">Fixed layout</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-boxed.html" data-toggle="dropdown" class="dropdown-item">Boxed layout</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-static.html" data-toggle="dropdown" class="dropdown-item">Static layout</a>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-light.html" data-toggle="dropdown" class="dropdown-item">Light layout</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-dark.html" data-toggle="dropdown" class="dropdown-item">Dark layout</a>
                  </li>
                  <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/starter-kit/LTR/horizontal-menu-template/layout-semi-dark.html" data-toggle="dropdown" class="dropdown-item">Semi dark layout</a>
                  </li>
                </ul>
              </li>
              <li data-menu=""><a href="changelog.html" data-toggle="dropdown" class="dropdown-item">Changelog</a>
              </li>
              <li data-menu="" class="disabled"><a href="#" data-toggle="dropdown" class="dropdown-item">Disabled Menu</a>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Menu levels</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="#" data-toggle="dropdown" class="dropdown-item">Second level</a>
                  </li>
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Second level child</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="#" data-toggle="dropdown" class="dropdown-item">Third level</a>
                      </li>
                      <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Third level child</a>
                        <ul class="dropdown-menu">
                          <li data-menu=""><a href="#" data-toggle="dropdown" class="dropdown-item">Fourth level</a>
                          </li>
                          <li data-menu=""><a href="#" data-toggle="dropdown" class="dropdown-item">Fourth level</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-paper"></i><span data-i18n="nav.category.pages">Pages</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-3" class="col-md-3">
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-briefcase4"></i>Project</a>
                        <ul class="mega-menu-sub">
                          <li><a href="project-summary.html" class="dropdown-item"><i class="undefined"></i>Project Summary</a>
                          </li>
                          <li><a href="project-tasks.html" class="dropdown-item"><i class="undefined"></i>Project Task</a>
                          </li>
                          <li><a href="project-bugs.html" class="dropdown-item"><i class="undefined"></i>Project Bugs</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="scrumboard.html" class="dropdown-item"><i class="icon-android-checkbox-outline"></i>Scrumboard</a>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-file-subtract"></i>Invoice</a>
                        <ul class="mega-menu-sub">
                          <li><a href="invoice-summary.html" class="dropdown-item"><i class="undefined"></i>Invoice Summary</a>
                          </li>
                          <li><a href="invoice-template.html" class="dropdown-item"><i class="undefined"></i>Invoice Template</a>
                          </li>
                          <li><a href="invoice-list.html" class="dropdown-item"><i class="undefined"></i>Invoice List</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-film"></i>Timelines</a>
                        <ul class="mega-menu-sub">
                          <li><a href="timeline-center.html" class="dropdown-item"><i class="undefined"></i>Timelines Center</a>
                          </li>
                          <li><a href="timeline-left.html" class="dropdown-item"><i class="undefined"></i>Timelines Left</a>
                          </li>
                          <li><a href="timeline-right.html" class="dropdown-item"><i class="undefined"></i>Timelines Right</a>
                          </li>
                          <li><a href="timeline-horizontal.html" class="dropdown-item"><i class="undefined"></i>Timelines Horizontal</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-head"></i>Users</a>
                        <ul class="mega-menu-sub">
                          <li><a href="user-profile.html" class="dropdown-item"><i class="undefined"></i>Users Profile</a>
                          </li>
                          <li><a href="user-cards.html" class="dropdown-item"><i class="undefined"></i>Users Cards</a>
                          </li>
                          <li><a href="users-contacts.html" class="dropdown-item"><i class="undefined"></i>Users List</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-image4"></i>Gallery</a>
                        <ul class="mega-menu-sub">
                          <li><a href="gallery-grid.html" class="dropdown-item"><i class="undefined"></i>Gallery Grid</a>
                          </li>
                          <li><a href="gallery-grid-with-desc.html" class="dropdown-item"><i class="undefined"></i>Gallery Grid with Desc</a>
                          </li>
                          <li><a href="gallery-masonry.html" class="dropdown-item"><i class="undefined"></i>Masonry Gallery</a>
                          </li>
                          <li><a href="gallery-masonry-with-desc.html" class="dropdown-item"><i class="undefined"></i>Masonry Gallery with Desc</a>
                          </li>
                          <li><a href="gallery-hover-effects.html" class="dropdown-item"><i class="undefined"></i>Hover Effects</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-search7"></i>Search</a>
                        <ul class="mega-menu-sub">
                          <li><a href="search-page.html" class="dropdown-item"><i class="undefined"></i>Search Page</a>
                          </li>
                          <li><a href="search-website.html" class="dropdown-item"><i class="undefined"></i>Search Website</a>
                          </li>
                          <li><a href="search-images.html" class="dropdown-item"><i class="undefined"></i>Search Images</a>
                          </li>
                          <li><a href="search-videos.html" class="dropdown-item"><i class="undefined"></i>Search Videos</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-unlock2"></i>Authentication</a>
                        <ul class="mega-menu-sub">
                          <li><a href="login-simple.html" class="dropdown-item"><i class="undefined"></i>Login Simple</a>
                          </li>
                          <li><a href="login-with-bg.html" class="dropdown-item"><i class="undefined"></i>Login with Bg</a>
                          </li>
                          <li><a href="login-with-bg-image.html" class="dropdown-item"><i class="undefined"></i>Login with Bg Image</a>
                          </li>
                          <li><a href="login-with-navbar.html" class="dropdown-item"><i class="undefined"></i>Login with Navbar</a>
                          </li>
                          <li><a href="login-advanced.html" class="dropdown-item"><i class="undefined"></i>Login Advanced</a>
                          </li>
                          <li><a href="register-simple.html" class="dropdown-item"><i class="undefined"></i>Register Simple</a>
                          </li>
                          <li><a href="register-with-bg.html" class="dropdown-item"><i class="undefined"></i>Register with Bg</a>
                          </li>
                          <li><a href="register-with-bg-image.html" class="dropdown-item"><i class="undefined"></i>Register with Bg Image</a>
                          </li>
                          <li><a href="register-with-navbar.html" class="dropdown-item"><i class="undefined"></i>Register with Navbar</a>
                          </li>
                          <li><a href="register-advanced.html" class="dropdown-item"><i class="undefined"></i>Register Advanced</a>
                          </li>
                          <li><a href="unlock-user.html" class="dropdown-item"><i class="undefined"></i>Unlock User</a>
                          </li>
                          <li><a href="recover-password.html" class="dropdown-item"><i class="undefined"></i>recover-password</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-warning"></i>Error</a>
                        <ul class="mega-menu-sub">
                          <li><a href="error-400.html" class="dropdown-item"><i class="undefined"></i>Error 400</a>
                          </li>
                          <li><a href="error-400-with-navbar.html" class="dropdown-item"><i class="undefined"></i>Error 400 with Navbar</a>
                          </li>
                          <li><a href="error-401.html" class="dropdown-item"><i class="undefined"></i>Error 401</a>
                          </li>
                          <li><a href="error-401-with-navbar.html" class="dropdown-item"><i class="undefined"></i>Error 401 with Navbar</a>
                          </li>
                          <li><a href="error-403.html" class="dropdown-item"><i class="undefined"></i>Error 403</a>
                          </li>
                          <li><a href="error-403-with-navbar.html" class="dropdown-item"><i class="undefined"></i>Error 403 with Navbar</a>
                          </li>
                          <li><a href="error-404.html" class="dropdown-item"><i class="undefined"></i>Error 404</a>
                          </li>
                          <li><a href="error-404-with-navbar.html" class="dropdown-item"><i class="undefined"></i>Error 404 with Navbar</a>
                          </li>
                          <li><a href="error-500.html" class="dropdown-item"><i class="undefined"></i>Error 500</a>
                          </li>
                          <li><a href="error-500-with-navbar.html" class="dropdown-item"><i class="undefined"></i>Error 500 with Navbar</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-file2"></i>Others
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="coming-soon.html" class="dropdown-item"><i class="undefined"></i>Coming Soon</a>
                        <ul class="mega-menu-sub">
                          <li><a href="coming-soon-flat.html" class="dropdown-item"><i></i>Flat</a>
                          </li>
                          <li><a href="coming-soon-bg-image.html" class="dropdown-item"><i></i>Bg image</a>
                          </li>
                          <li><a href="coming-soon-bg-video.html" class="dropdown-item"><i></i>Bg video</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="under-maintenance.html" class="dropdown-item"><i class="undefined"></i>Maintenance</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-pencil22"></i><span data-i18n="nav.category.ui">UI</span></a>
            <ul class="dropdown-menu">
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Cards</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="card-bootstrap.html" data-toggle="dropdown" class="dropdown-item">Bootstrap</a>
                  </li>
                  <li data-menu=""><a href="card-headings.html" data-toggle="dropdown" class="dropdown-item">Headings</a>
                  </li>
                  <li data-menu=""><a href="card-options.html" data-toggle="dropdown" class="dropdown-item">Options</a>
                  </li>
                  <li data-menu=""><a href="card-actions.html" data-toggle="dropdown" class="dropdown-item">Action</a>
                  </li>
                  <li data-menu=""><a href="card-draggable.html" data-toggle="dropdown" class="dropdown-item">Draggable</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Advance Cards</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="card-statistics.html" data-toggle="dropdown" class="dropdown-item">Statistics</a>
                  </li>
                  <li data-menu=""><a href="card-weather.html" data-toggle="dropdown" class="dropdown-item">Weather</a>
                  </li>
                  <li data-menu=""><a href="card-charts.html" data-toggle="dropdown" class="dropdown-item">Charts</a>
                  </li>
                  <li data-menu=""><a href="card-interactive.html" data-toggle="dropdown" class="dropdown-item">Interactive</a>
                  </li>
                  <li data-menu=""><a href="card-maps.html" data-toggle="dropdown" class="dropdown-item">Maps</a>
                  </li>
                  <li data-menu=""><a href="card-social.html" data-toggle="dropdown" class="dropdown-item">Social</a>
                  </li>
                  <li data-menu=""><a href="card-ecommerce.html" data-toggle="dropdown" class="dropdown-item">E-Commerce</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Content</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="content-grid.html" data-toggle="dropdown" class="dropdown-item">Grid</a>
                  </li>
                  <li data-menu=""><a href="content-typography.html" data-toggle="dropdown" class="dropdown-item">Typography</a>
                  </li>
                  <li data-menu=""><a href="content-text-utilities.html" data-toggle="dropdown" class="dropdown-item">Text utilities</a>
                  </li>
                  <li data-menu=""><a href="content-syntax-highlighter.html" data-toggle="dropdown" class="dropdown-item">Syntax highlighter</a>
                  </li>
                  <li data-menu=""><a href="content-helper-classes.html" data-toggle="dropdown" class="dropdown-item">Helper classes</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Components</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="component-alerts.html" data-toggle="dropdown" class="dropdown-item">Alerts</a>
                  </li>
                  <li data-menu=""><a href="component-callout.html" data-toggle="dropdown" class="dropdown-item">Callout</a>
                  </li>
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="components-buttons.html" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Buttons</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="component-buttons-basic.html" data-toggle="dropdown" class="dropdown-item">Basic Buttons</a>
                      </li>
                      <li data-menu=""><a href="component-buttons-extended.html" data-toggle="dropdown" class="dropdown-item">Extended Buttons</a>
                      </li>
                    </ul>
                  </li>
                  <li data-menu=""><a href="component-carousel.html" data-toggle="dropdown" class="dropdown-item">Carousel</a>
                  </li>
                  <li data-menu=""><a href="component-collapse.html" data-toggle="dropdown" class="dropdown-item">Collapse</a>
                  </li>
                  <li data-menu=""><a href="component-dropdowns.html" data-toggle="dropdown" class="dropdown-item">Dropdowns</a>
                  </li>
                  <li data-menu=""><a href="component-list-group.html" data-toggle="dropdown" class="dropdown-item">List Group</a>
                  </li>
                  <li data-menu=""><a href="component-modals.html" data-toggle="dropdown" class="dropdown-item">Modals</a>
                  </li>
                  <li data-menu=""><a href="component-pagination.html" data-toggle="dropdown" class="dropdown-item">Pagination</a>
                  </li>
                  <li data-menu=""><a href="component-navs-component.html" data-toggle="dropdown" class="dropdown-item">Navs Component</a>
                  </li>
                  <li data-menu=""><a href="component-tabs-component.html" data-toggle="dropdown" class="dropdown-item">Tabs Component</a>
                  </li>
                  <li data-menu=""><a href="component-pills-component.html" data-toggle="dropdown" class="dropdown-item">Pills Component</a>
                  </li>
                  <li data-menu=""><a href="component-tooltips.html" data-toggle="dropdown" class="dropdown-item">Tooltips</a>
                  </li>
                  <li data-menu=""><a href="component-popovers.html" data-toggle="dropdown" class="dropdown-item">Popovers</a>
                  </li>
                  <li data-menu=""><a href="component-tags.html" data-toggle="dropdown" class="dropdown-item">Tags</a>
                  </li>
                  <li data-menu=""><a href="component-pill-tags.html" data-toggle="dropdown" class="dropdown-item">Pill Tags</a>
                  </li>
                  <li data-menu=""><a href="component-progress.html" data-toggle="dropdown" class="dropdown-item">Progress</a>
                  </li>
                  <li data-menu=""><a href="component-media-objects.html" data-toggle="dropdown" class="dropdown-item">Media Objects</a>
                  </li>
                  <li data-menu=""><a href="component-scrollable.html" data-toggle="dropdown" class="dropdown-item">Scrollable</a>
                  </li>
                  <li data-menu=""><a href="component-loaders.html" data-toggle="dropdown" class="dropdown-item">Loaders</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Extra Components</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="ex-component-sweet-alerts.html" data-toggle="dropdown" class="dropdown-item">Sweet Alerts</a>
                  </li>
                  <li data-menu=""><a href="ex-component-tree-views.html" data-toggle="dropdown" class="dropdown-item">Tree Views</a>
                  </li>
                  <li data-menu=""><a href="ex-component-toastr.html" data-toggle="dropdown" class="dropdown-item">Toastr</a>
                  </li>
                  <li data-menu=""><a href="ex-component-ratings.html" data-toggle="dropdown" class="dropdown-item">Ratings</a>
                  </li>
                  <li data-menu=""><a href="ex-component-context-menu.html" data-toggle="dropdown" class="dropdown-item">Context Menu</a>
                  </li>
                  <li data-menu=""><a href="ex-component-noui-slider.html" data-toggle="dropdown" class="dropdown-item">NoUI Slider</a>
                  </li>
                  <li data-menu=""><a href="ex-component-date-time-dropper.html" data-toggle="dropdown" class="dropdown-item">Date Time Dropper</a>
                  </li>
                  <li data-menu=""><a href="ex-component-lists.html" data-toggle="dropdown" class="dropdown-item">Lists</a>
                  </li>
                  <li data-menu=""><a href="ex-component-toolbar.html" data-toggle="dropdown" class="dropdown-item">Toolbar</a>
                  </li>
                  <li data-menu=""><a href="ex-component-unslider.html" data-toggle="dropdown" class="dropdown-item">Unslider</a>
                  </li>
                  <li data-menu=""><a href="ex-component-knob.html" data-toggle="dropdown" class="dropdown-item">Knob</a>
                  </li>
                  <li data-menu=""><a href="ex-component-long-press.html" data-toggle="dropdown" class="dropdown-item">Long Press</a>
                  </li>
                  <li data-menu=""><a href="ex-component-offline.html" data-toggle="dropdown" class="dropdown-item">Offline</a>
                  </li>
                  <li data-menu=""><a href="ex-component-zoom.html" data-toggle="dropdown" class="dropdown-item">Zoom</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Icons</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="icons-feather.html" data-toggle="dropdown" class="dropdown-item">Feather</a>
                  </li>
                  <li data-menu=""><a href="icons-ionicons.html" data-toggle="dropdown" class="dropdown-item">Ionicons</a>
                  </li>
                  <li data-menu=""><a href="icons-fps-line.html" data-toggle="dropdown" class="dropdown-item">FPS Line Icons</a>
                  </li>
                  <li data-menu=""><a href="icons-ico-moon.html" data-toggle="dropdown" class="dropdown-item">Ico Moon</a>
                  </li>
                  <li data-menu=""><a href="icons-font-awesome.html" data-toggle="dropdown" class="dropdown-item">Font Awesome</a>
                  </li>
                  <li data-menu=""><a href="icons-meteocons.html" data-toggle="dropdown" class="dropdown-item">Meteocons</a>
                  </li>
                  <li data-menu=""><a href="icons-evil.html" data-toggle="dropdown" class="dropdown-item">Evil Icons</a>
                  </li>
                  <li data-menu=""><a href="icons-linecons.html" data-toggle="dropdown" class="dropdown-item">Linecons</a>
                  </li>
                </ul>
              </li>
              <li data-menu=""><a href="animation.html" data-toggle="dropdown" class="dropdown-item">Animation</a>
              </li>
            </ul>
          </li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-wpforms"></i><span data-i18n="nav.category.forms">Forms</span></a>
            <ul class="dropdown-menu">
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Form Elements</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="form-inputs.html" data-toggle="dropdown" class="dropdown-item">Form Inputs</a>
                  </li>
                  <li data-menu=""><a href="form-input-groups.html" data-toggle="dropdown" class="dropdown-item">Input Groups</a>
                  </li>
                  <li data-menu=""><a href="form-input-grid.html" data-toggle="dropdown" class="dropdown-item">Input Grid</a>
                  </li>
                  <li data-menu=""><a href="form-extended-inputs.html" data-toggle="dropdown" class="dropdown-item">Extended Inputs</a>
                  </li>
                  <li data-menu=""><a href="form-checkboxes-radios.html" data-toggle="dropdown" class="dropdown-item">Checkboxes &amp; Radios</a>
                  </li>
                  <li data-menu=""><a href="form-switch.html" data-toggle="dropdown" class="dropdown-item">Switch</a>
                  </li>
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Select</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="form-select2.html" data-toggle="dropdown" class="dropdown-item">Select2</a>
                      </li>
                      <li data-menu=""><a href="form-selectize.html" data-toggle="dropdown" class="dropdown-item">Selectize</a>
                      </li>
                      <li data-menu=""><a href="form-selectivity.html" data-toggle="dropdown" class="dropdown-item">Selectivity</a>
                      </li>
                      <li data-menu=""><a href="form-select-box-it.html" data-toggle="dropdown" class="dropdown-item">Select Box It</a>
                      </li>
                    </ul>
                  </li>
                  <li data-menu=""><a href="form-dual-listbox.html" data-toggle="dropdown" class="dropdown-item">Dual Listbox</a>
                  </li>
                  <li data-menu=""><a href="form-tags-input.html" data-toggle="dropdown" class="dropdown-item">Tags Input</a>
                  </li>
                  <li data-menu=""><a href="form-validation.html" data-toggle="dropdown" class="dropdown-item">Validation</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Form Layouts</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="form-layout-basic.html" data-toggle="dropdown" class="dropdown-item">Basic Forms</a>
                  </li>
                  <li data-menu=""><a href="form-layout-horizontal.html" data-toggle="dropdown" class="dropdown-item">Horizontal Forms</a>
                  </li>
                  <li data-menu=""><a href="form-layout-hidden-labels.html" data-toggle="dropdown" class="dropdown-item">Hidden Labels</a>
                  </li>
                  <li data-menu=""><a href="form-layout-form-actions.html" data-toggle="dropdown" class="dropdown-item">Form Actions</a>
                  </li>
                  <li data-menu=""><a href="form-layout-row-separator.html" data-toggle="dropdown" class="dropdown-item">Row Separator</a>
                  </li>
                  <li data-menu=""><a href="form-layout-bordered.html" data-toggle="dropdown" class="dropdown-item">Bordered</a>
                  </li>
                  <li data-menu=""><a href="form-layout-striped-rows.html" data-toggle="dropdown" class="dropdown-item">Striped Rows</a>
                  </li>
                  <li data-menu=""><a href="form-layout-striped-labels.html" data-toggle="dropdown" class="dropdown-item">Striped Labels</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Form Wizard</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="form-wizard-circle-style.html" data-toggle="dropdown" class="dropdown-item">Circle Style</a>
                  </li>
                  <li data-menu=""><a href="form-wizard-notification-style.html" data-toggle="dropdown" class="dropdown-item">Notification Style</a>
                  </li>
                </ul>
              </li>
              <li data-menu=""><a href="form-repeater.html" data-toggle="dropdown" class="dropdown-item">Form Repeater</a>
              </li>
            </ul>
          </li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-table2"></i><span data-i18n="nav.category.tables">Tables</span></a>
            <ul class="dropdown-menu">
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Bootstrap Tables</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="table-basic.html" data-toggle="dropdown" class="dropdown-item">Basic Tables</a>
                  </li>
                  <li data-menu=""><a href="table-border.html" data-toggle="dropdown" class="dropdown-item">Table Border</a>
                  </li>
                  <li data-menu=""><a href="table-sizing.html" data-toggle="dropdown" class="dropdown-item">Table Sizing</a>
                  </li>
                  <li data-menu=""><a href="table-styling.html" data-toggle="dropdown" class="dropdown-item">Table Styling</a>
                  </li>
                  <li data-menu=""><a href="table-components.html" data-toggle="dropdown" class="dropdown-item">Table Components</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">DataTables</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="dt-basic-initialization.html" data-toggle="dropdown" class="dropdown-item">Basic Initialisation</a>
                  </li>
                  <li data-menu=""><a href="dt-advanced-initialization.html" data-toggle="dropdown" class="dropdown-item">Advanced initialisation</a>
                  </li>
                  <li data-menu=""><a href="dt-styling.html" data-toggle="dropdown" class="dropdown-item">Styling</a>
                  </li>
                  <li data-menu=""><a href="dt-data-sources.html" data-toggle="dropdown" class="dropdown-item">Data Sources</a>
                  </li>
                  <li data-menu=""><a href="dt-api.html" data-toggle="dropdown" class="dropdown-item">API</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">DataTables Ext.</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="dt-extensions-autofill.html" data-toggle="dropdown" class="dropdown-item">AutoFill</a>
                  </li>
                  <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Buttons</a>
                    <ul class="dropdown-menu">
                      <li data-menu=""><a href="dt-extensions-buttons-basic.html" data-toggle="dropdown" class="dropdown-item">Basic Buttons</a>
                      </li>
                      <li data-menu=""><a href="dt-extensions-buttons-html-5-data-export.html" data-toggle="dropdown" class="dropdown-item">HTML 5 Data Export</a>
                      </li>
                      <li data-menu=""><a href="dt-extensions-buttons-flash-data-export.html" data-toggle="dropdown" class="dropdown-item">Flash Data Export</a>
                      </li>
                      <li data-menu=""><a href="dt-extensions-buttons-column-visibility.html" data-toggle="dropdown" class="dropdown-item">Column Visibility</a>
                      </li>
                      <li data-menu=""><a href="dt-extensions-buttons-print.html" data-toggle="dropdown" class="dropdown-item">Print</a>
                      </li>
                      <li data-menu=""><a href="dt-extensions-buttons-api.html" data-toggle="dropdown" class="dropdown-item">API</a>
                      </li>
                    </ul>
                  </li>
                  <li data-menu=""><a href="dt-extensions-column-reorder.html" data-toggle="dropdown" class="dropdown-item">Column Reorder</a>
                  </li>
                  <li data-menu=""><a href="dt-extensions-fixed-columns.html" data-toggle="dropdown" class="dropdown-item">Fixed Columns</a>
                  </li>
                  <li data-menu=""><a href="dt-extensions-key-table.html" data-toggle="dropdown" class="dropdown-item">Key Table</a>
                  </li>
                  <li data-menu=""><a href="dt-extensions-row-reorder.html" data-toggle="dropdown" class="dropdown-item">Row Reorder</a>
                  </li>
                  <li data-menu=""><a href="dt-extensions-select.html" data-toggle="dropdown" class="dropdown-item">Select</a>
                  </li>
                  <li data-menu=""><a href="dt-extensions-fix-header.html" data-toggle="dropdown" class="dropdown-item">Fix Header</a>
                  </li>
                  <li data-menu=""><a href="dt-extensions-responsive.html" data-toggle="dropdown" class="dropdown-item">Responsive</a>
                  </li>
                  <li data-menu=""><a href="dt-extensions-column-visibility.html" data-toggle="dropdown" class="dropdown-item">Column Visibility</a>
                  </li>
                </ul>
              </li>
              <li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a href="#" data-toggle="dropdown" class="dropdown-item dropdown-toggle">Handson Table</a>
                <ul class="dropdown-menu">
                  <li data-menu=""><a href="handson-table-appearance.html" data-toggle="dropdown" class="dropdown-item">Appearance</a>
                  </li>
                  <li data-menu=""><a href="handson-table-rows-columns.html" data-toggle="dropdown" class="dropdown-item">Rows Columns</a>
                  </li>
                  <li data-menu=""><a href="handson-table-rows-only.html" data-toggle="dropdown" class="dropdown-item">Rows Only</a>
                  </li>
                  <li data-menu=""><a href="handson-table-columns-only.html" data-toggle="dropdown" class="dropdown-item">Columns Only</a>
                  </li>
                  <li data-menu=""><a href="handson-table-data-operations.html" data-toggle="dropdown" class="dropdown-item">Data Operations</a>
                  </li>
                  <li data-menu=""><a href="handson-table-cell-features.html" data-toggle="dropdown" class="dropdown-item">Cell Features</a>
                  </li>
                  <li data-menu=""><a href="handson-table-cell-types.html" data-toggle="dropdown" class="dropdown-item">Cell Types</a>
                  </li>
                  <li data-menu=""><a href="handson-table-integrations.html" data-toggle="dropdown" class="dropdown-item">Integrations</a>
                  </li>
                  <li data-menu=""><a href="handson-table-utilities.html" data-toggle="dropdown" class="dropdown-item">Utilities</a>
                  </li>
                </ul>
              </li>
              <li data-menu=""><a href="table-jsgrid.html" data-toggle="dropdown" class="dropdown-item">jsGrid</a>
              </li>
            </ul>
          </li>
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-square-plus"></i><span data-i18n="nav.category.addons">Add Ons</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-edit2"></i>Editors
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="editor-quill.html" class="dropdown-item"><i></i>Quill</a>
                      </li>
                      <li><a href="editor-ckeditor.html" class="dropdown-item"><i></i>CKEditor</a>
                      </li>
                      <li><a href="editor-summernote.html" class="dropdown-item"><i></i>Summernote</a>
                      </li>
                      <li><a href="editor-tinymce.html" class="dropdown-item"><i></i>TinyMCE</a>
                      </li>
                      <li><a href="code-editor-codemirror.html" class="dropdown-item"><i></i>Code Editor</a>
                        <ul class="mega-menu-sub">
                          <li><a href="code-editor-codemirror.html" class="dropdown-item"><i></i>CodeMirror</a>
                          </li>
                          <li><a href="code-editor-ace.html" class="dropdown-item"><i></i>Ace</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-air-play"></i>jQuery UI
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="jquery-ui-interactions.html" class="dropdown-item"><i class="undefined"></i>Interactions</a>
                      </li>
                      <li><a href="jquery-ui-navigations.html" class="dropdown-item"><i class="undefined"></i>Navigations</a>
                      </li>
                      <li><a href="jquery-ui-date-pickers.html" class="dropdown-item"><i class="undefined"></i>Date Pickers</a>
                      </li>
                      <li><a href="jquery-ui-autocomplete.html" class="dropdown-item"><i class="undefined"></i>Autocomplete</a>
                      </li>
                      <li><a href="jquery-ui-buttons-select.html" class="dropdown-item"><i class="undefined"></i>Buttons &amp; Select</a>
                      </li>
                      <li><a href="jquery-ui-slider-spinner.html" class="dropdown-item"><i class="undefined"></i>Slider &amp; Spinner</a>
                      </li>
                      <li><a href="jquery-ui-dialog-tooltip.html" class="dropdown-item"><i class="undefined"></i>Dialog &amp; Tooltip</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-tune"></i>Other Addons
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-calendar5"></i>Pickers</a>
                        <ul class="mega-menu-sub">
                          <li><a href="pickers-date-%26-time-picker.html" class="dropdown-item"><i></i>Date &amp; Time Picker</a>
                          </li>
                          <li><a href="pickers-color-picker.html" class="dropdown-item"><i></i>Color Picker</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="add-on-block-ui.html" class="dropdown-item"><i class="icon-security"></i>Block UI</a>
                      </li>
                      <li><a href="add-on-image-cropper.html" class="dropdown-item"><i class="icon-crop"></i>Image Cropper</a>
                      </li>
                      <li><a href="add-on-drag-drop.html" class="dropdown-item"><i class="icon-arrow-move"></i>Drag &amp; Drop</a>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-cloud-upload3"></i>File Uploader</a>
                        <ul class="mega-menu-sub">
                          <li><a href="file-uploader-dropzone.html" class="dropdown-item"><i class="undefined"></i>Dropzone</a>
                          </li>
                          <li><a href="file-uploader-jquery.html" class="dropdown-item"><i class="undefined"></i>jQuery File Upload</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-calendar4"></i>Event Calendars</a>
                        <ul class="mega-menu-sub">
                          <li><a href="#" class="dropdown-item"><i class="undefined"></i>Full Calendar</a>
                            <ul class="mega-menu-sub">
                              <li><a href="full-calender-basic.html" class="dropdown-item"><i class="undefined"></i>Basic</a>
                              </li>
                              <li><a href="full-calender-events.html" class="dropdown-item"><i class="undefined"></i>Events</a>
                              </li>
                              <li><a href="full-calender-advance.html" class="dropdown-item"><i class="undefined"></i>Advance</a>
                              </li>
                              <li><a href="full-calender-extra.html" class="dropdown-item"><i class="undefined"></i>Extra</a>
                              </li>
                            </ul>
                          </li>
                          <li><a href="calendars-clndr.html" class="dropdown-item"><i class="icon-calendar2"></i>CLNDR</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <h6 data-toggle="dropdown" class="dropdown-menu-header text-uppercase"><i class="icon-table2"></i>Internationalization
                </h6>
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="i18n-resources.html" class="dropdown-item"><i class="undefined"></i>Resources</a>
                      </li>
                      <li><a href="i18n-xhr-backend.html" class="dropdown-item"><i class="undefined"></i>XHR Backend</a>
                      </li>
                      <li><a href="i18n-query-string.html" class="dropdown-item"><i class="undefined"></i>Query String</a>
                      </li>
                      <li><a href="i18n-on-init.html" class="dropdown-item"><i class="undefined"></i>On Init</a>
                      </li>
                      <li><a href="i18n-after-init.html" class="dropdown-item"><i class="undefined"></i>After Init</a>
                      </li>
                      <li><a href="i18n-fallback.html" class="dropdown-item"><i class="undefined"></i>Fallback</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-timeline"></i><span data-i18n="nav.category.charts_maps">Charts &amp; Maps</span></a>
            <ul class="mega-dropdown-menu dropdown-menu row">
              <li data-mega-col="col-md-3" class="col-md-3">
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-bar-graph-2"></i>google Charts</a>
                        <ul class="mega-menu-sub">
                          <li><a href="google-bar-charts.html" class="dropdown-item"><i class="undefined"></i>Bar charts</a>
                          </li>
                          <li><a href="google-line-charts.html" class="dropdown-item"><i class="undefined"></i>Line charts</a>
                          </li>
                          <li><a href="google-pie-charts.html" class="dropdown-item"><i class="undefined"></i>Pie charts</a>
                          </li>
                          <li><a href="google-scatter-charts.html" class="dropdown-item"><i class="undefined"></i>Scatter charts</a>
                          </li>
                          <li><a href="google-bubble-charts.html" class="dropdown-item"><i class="undefined"></i>Bubble charts</a>
                          </li>
                          <li><a href="google-other-charts.html" class="dropdown-item"><i class="undefined"></i>Other charts</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-bubble_chart"></i>Echarts</a>
                        <ul class="mega-menu-sub">
                          <li><a href="echarts-line-area-charts.html" class="dropdown-item"><i class="undefined"></i>Line &amp; Area charts</a>
                          </li>
                          <li><a href="echarts-bar-column-charts.html" class="dropdown-item"><i class="undefined"></i>Bar &amp; Column charts</a>
                          </li>
                          <li><a href="echarts-pie-doughnut-charts.html" class="dropdown-item"><i class="undefined"></i>Pie &amp; Doughnut charts</a>
                          </li>
                          <li><a href="echarts-scatter-charts.html" class="dropdown-item"><i class="undefined"></i>Scatter charts</a>
                          </li>
                          <li><a href="echarts-radar-chord-charts.html" class="dropdown-item"><i class="undefined"></i>Radar &amp; Chord charts</a>
                          </li>
                          <li><a href="echarts-funnel-gauges-charts.html" class="dropdown-item"><i class="undefined"></i>Funnel &amp; Gauges charts</a>
                          </li>
                          <li><a href="echarts-combination-charts.html" class="dropdown-item"><i class="undefined"></i>Combination charts</a>
                          </li>
                          <li><a href="echarts-advance-charts.html" class="dropdown-item"><i class="undefined"></i>Advance charts</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-stats-dots"></i>Chartjs</a>
                        <ul class="mega-menu-sub">
                          <li><a href="chartjs-line-charts.html" class="dropdown-item"><i class="undefined"></i>Line charts</a>
                          </li>
                          <li><a href="chartjs-bar-charts.html" class="dropdown-item"><i class="undefined"></i>Bar charts</a>
                          </li>
                          <li><a href="chartjs-pie-doughnut-charts.html" class="dropdown-item"><i class="undefined"></i>Pie &amp; Doughnut charts</a>
                          </li>
                          <li><a href="chartjs-scatter-charts.html" class="dropdown-item"><i class="undefined"></i>Scatter charts</a>
                          </li>
                          <li><a href="chartjs-polar-radar-charts.html" class="dropdown-item"><i class="undefined"></i>Polar &amp; Radar charts</a>
                          </li>
                          <li><a href="chartjs-advance-charts.html" class="dropdown-item"><i class="undefined"></i>Advance charts</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-stats-bars2"></i>D3 Charts</a>
                        <ul class="mega-menu-sub">
                          <li><a href="d3-line-chart.html" class="dropdown-item"><i class="undefined"></i>Line Chart</a>
                          </li>
                          <li><a href="d3-bar-chart.html" class="dropdown-item"><i class="undefined"></i>Bar Chart</a>
                          </li>
                          <li><a href="d3-pie-chart.html" class="dropdown-item"><i class="undefined"></i>Pie Chart</a>
                          </li>
                          <li><a href="d3-circle-diagrams.html" class="dropdown-item"><i class="undefined"></i>Circle Diagrams</a>
                          </li>
                          <li><a href="d3-tree-chart.html" class="dropdown-item"><i class="undefined"></i>Tree Chart</a>
                          </li>
                          <li><a href="d3-other-charts.html" class="dropdown-item"><i class="undefined"></i>Other Charts</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-arrow-graph-up-right"></i>C3 Charts</a>
                        <ul class="mega-menu-sub">
                          <li><a href="c3-line-chart.html" class="dropdown-item"><i class="undefined"></i>Line Chart</a>
                          </li>
                          <li><a href="c3-bar-pie-chart.html" class="dropdown-item"><i class="undefined"></i>Bar &amp; Pie Chart</a>
                          </li>
                          <li><a href="c3-axis-chart.html" class="dropdown-item"><i class="undefined"></i>Axis Chart</a>
                          </li>
                          <li><a href="c3-data-chart.html" class="dropdown-item"><i class="undefined"></i>Data Chart</a>
                          </li>
                          <li><a href="c3-grid-chart.html" class="dropdown-item"><i class="undefined"></i>Grid Chart</a>
                          </li>
                          <li><a href="c3-transform-chart.html" class="dropdown-item"><i class="undefined"></i>Transform Chart</a>
                          </li>
                          <li><a href="c3-other-charts.html" class="dropdown-item"><i class="undefined"></i>Other Charts</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-stats-bars"></i>Chartist</a>
                        <ul class="mega-menu-sub">
                          <li><a href="chartist-line-charts.html" class="dropdown-item"><i class="undefined"></i>Line charts</a>
                          </li>
                          <li><a href="chartist-bar-charts.html" class="dropdown-item"><i class="undefined"></i>Bar charts</a>
                          </li>
                          <li><a href="chartist-pie-charts.html" class="dropdown-item"><i class="undefined"></i>Pie charts</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="#" class="dropdown-item"><i class="icon-timeline"></i>Dimple Charts</a>
                        <ul class="mega-menu-sub">
                          <li><a href="dimple-line-area-chart.html" class="dropdown-item"><i class="undefined"></i>Line &amp; Area Chart</a>
                          </li>
                          <li><a href="dimple-bar-column-chart.html" class="dropdown-item"><i class="undefined"></i>Bar &amp; Column Chart</a>
                          </li>
                          <li><a href="dimple-pie-ring-chart.html" class="dropdown-item"><i class="undefined"></i>Pie &amp; Ring Chart</a>
                          </li>
                          <li><a href="dimple-step-chart.html" class="dropdown-item"><i class="undefined"></i>Step Chart</a>
                          </li>
                          <li><a href="dimple-scatter-chart.html" class="dropdown-item"><i class="undefined"></i>Scatter Chart</a>
                          </li>
                          <li><a href="dimple-bubble-chart.html" class="dropdown-item"><i class="undefined"></i>Bubble Chart</a>
                          </li>
                        </ul>
                      </li>
                      <li><a href="morris-charts.html" class="dropdown-item"><i class="icon-graphic_eq"></i>Morris Charts</a>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-pie-graph2"></i>Flot Charts</a>
                        <ul class="mega-menu-sub">
                          <li><a href="flot-line-charts.html" class="dropdown-item"><i class="undefined"></i>Line charts</a>
                          </li>
                          <li><a href="flot-bar-charts.html" class="dropdown-item"><i class="undefined"></i>Bar charts</a>
                          </li>
                          <li><a href="flot-pie-charts.html" class="dropdown-item"><i class="undefined"></i>Pie charts</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li data-mega-col="col-md-3" class="col-md-3">
                <ul class="drilldown-menu">
                  <li class="menu-list">
                    <ul class="mega-menu-sub">
                      <li><a href="rickshaw-charts.html" class="dropdown-item"><i class="icon-grain"></i>Rickshaw Charts</a>
                      </li>
                      <li><a href="#" class="dropdown-item"><i class="icon-map22"></i>Maps</a>
                        <ul class="mega-menu-sub">
                          <li><a href="#" class="dropdown-item"><i class="undefined"></i>google Maps</a>
                            <ul class="mega-menu-sub">
                              <li><a href="gmaps-basic-maps.html" class="dropdown-item"><i class="undefined"></i>Maps</a>
                              </li>
                              <li><a href="gmaps-services.html" class="dropdown-item"><i class="undefined"></i>Services</a>
                              </li>
                              <li><a href="gmaps-overlays.html" class="dropdown-item"><i class="undefined"></i>Overlays</a>
                              </li>
                              <li><a href="gmaps-routes.html" class="dropdown-item"><i class="undefined"></i>Routes</a>
                              </li>
                              <li><a href="gmaps-utils.html" class="dropdown-item"><i class="undefined"></i>Utils</a>
                              </li>
                            </ul>
                          </li>
                          <li><a href="#" class="dropdown-item"><i class="undefined"></i>Vector Maps</a>
                            <ul class="mega-menu-sub">
                              <li><a href="#" class="dropdown-item"><i class="undefined"></i>jQuery Mapael</a>
                                <ul class="mega-menu-sub">
                                  <li><a href="vector-maps-mapael-basic.html" class="dropdown-item"><i class="undefined"></i>Basic Maps</a>
                                  </li>
                                  <li><a href="vector-maps-mapael-advance.html" class="dropdown-item"><i class="undefined"></i>Advance Maps</a>
                                  </li>
                                </ul>
                              </li>
                              <li><a href="vector-maps-jvector.html" class="dropdown-item"><i class="undefined"></i>jVector Map</a>
                              </li>
                              <li><a href="vector-maps-jvq.html" class="dropdown-item"><i class="undefined"></i>JQV Map</a>
                              </li>
                            </ul>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li data-menu="dropdown" class="dropdown nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i class="icon-help2"></i><span data-i18n="nav.category.support">Support</span></a>
            <ul class="dropdown-menu">
              <li data-menu=""><a href="http://support.pixinvent.com/" data-toggle="dropdown" class="dropdown-item">Raise Support</a>
              </li>
              <li data-menu=""><a href="https://pixinvent.com/bootstrap-admin-template/robust/documentation" data-toggle="dropdown" class="dropdown-item">Documentation</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <!-- /horizontal menu content-->
    </div>
    <!-- Horizontal navigation-->

   
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <footer class="footer undefined footer-light navbar-shadow">
      <p class="clearfix text-muted text-sm-center mb-0 px-2"><span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="https://themeforest.net/user/pixinvent/portfolio?ref=pixinvent" target="_blank" class="text-bold-800 grey darken-2">PIXINVENT </a>, All rights reserved. </span><span class="float-md-right d-xs-block d-md-inline-block">Hand-crafted & Made with <i class="icon-heart5 pink"></i></span></p>
    </footer>

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

<!-- Mirrored from pixinvent.com/bootstrap-admin-template/robust/html/ltr/horizontal-menu-template/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 09 Aug 2017 08:49:40 GMT -->
</html>
