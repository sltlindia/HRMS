<%@page import="com.hrms.pms.dao.LoginDAO"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLTL</title>
<link rel="apple-touch-icon" sizes="60x60"
	href="app-assets/images/ico/apple-icon-60.png">

<link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">

<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap.min.css">
<!-- font icons-->
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/icomoon.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/sliders/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/charts/jquery-jvectormap-2.0.3.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/charts/morris.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/unslider.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/weather-icons/climacons.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN ROBUST CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- END ROBUST CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/colors/palette-gradient.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="css/logocss.css">
<!-- END Custom CSS-->

<%-- <%@include file="pageLoader.jsp"%> --%>
</head>

<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<!-- <div class="se-pre-con" align="center" style="padding: 370px;"></div> -->
<%
EmployeeBean user = (EmployeeBean) session.getAttribute("user");
int companyId = user.getCompanyListBean().getCompany_list_id();
String company_name = null;
String manager_name  = null;
int employee_master_id = 0;
LoginDAO loginDAO1 = new LoginDAO();

if (user == null){
	request.setAttribute("loginError", "You need to login first with your Id and Password");
	request.getRequestDispatcher("login.jsp").forward(request, response);
} else { 
	if (companyId == 1) {
		company_name = "SLTL";
	} else if (companyId == 2) {
		company_name = "SS";
	} else if (companyId == 3) {
		company_name = "S.HR";
	} else if (companyId == 4) {
		company_name = "COSMOS";
	} else if (companyId == 5) {
		company_name = "CSLASER";
	} else if (companyId == 6) {
		company_name = "SEZ";
	} else if (companyId == 7) {
		company_name = "CL";
	}
	if (companyId == 8) {
		company_name = "App";
	}
%>
    <div id="wrapper">
        <nav
		class="header-navbar navbar navbar-with-menu undefined navbar-light navbar-border navbar-brand-center">
	<div class="navbar-wrapper">
		<div class="navbar-header">
			<ul class="nav navbar-nav">
				<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
					class="nav-link nav-menu-main menu-toggle hidden-xs"><i
						class="icon-menu5 font-large-1"></i></a></li>
				<li class="nav-item">
					
				</li>
				<li class="nav-item hidden-md-up float-xs-right"><a
					data-toggle="collapse" data-target="#navbar-mobile"
					class="nav-link open-navbar-container"><i
						class="icon-ellipsis pe-2x icon-icon-rotate-right-right"></i></a></li>
			</ul>
		</div>
		<div class="navbar-container container center-layout">
			<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
				<ul class="nav navbar-nav">
					<li class="nav-item hidden-sm-down"><a
						class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="icon-menu5"></i></a></li>

					<li class="nav-item hidden-sm-down"><a href="#"
						class="nav-link nav-link-expand"><i class="ficon icon-expand2"></i></a></li>
				</ul>
				<ul class="nav navbar-nav float-xs-right">
			
				<li class="dropdown dropdown-user nav-item"><a href="#"
						data-toggle="dropdown"
						class="dropdown-toggle nav-link dropdown-user-link"><span
							class="avatar avatar-online"><img
								src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=user.getEmployee_code()%>.bmp"
								alt="avatar"><i></i></span><span class="user-name"><%=user.getFirstname()+" "+user.getLastname()%></span></a>
						<div class="dropdown-menu dropdown-menu-right">
							<!-- <a href="employeeSelfUpdate.jsp" class="dropdown-item"><i class="icon-head"></i>
								User Profile</a> -->
							<!-- <div class="dropdown-divider"></div> -->
							<a href="logout" class="dropdown-item"><i class="icon-power3"></i>
								Logout</a>
						</div></li>
						</ul>
        </div>
		</div>
	</div>
	</nav>
    </div>
   <%}	 %>
</body>

</html>
