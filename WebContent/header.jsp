<%@page import="com.hrms.exitformality.bean.HandOverApprovalBean"%>
<%@page import="com.hrms.exitformality.bean.ExitInterviewEmployeeBean"%>
<%@page import="com.hrms.exitformality.bean.DetailsOfHandOverFormBean"%>
<%@page import="com.hrms.exitformality.dao.AllListExitFormalityDAO"%>
<%@page import="com.hrms.grievancemanagement.bean.GrievanceQueryBean"%>
<%@page import="com.hrms.pms.bean.AppraisalBean"%>
<%@page import="com.hrms.lms.bean.GatePassBean"%>
<%@page import="com.hrms.lms.bean.LeaveCancelRequestBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementDepartmentBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCompanyBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementCategoryBean"%>
<%@page import="com.hrms.selfservice.bean.AnnouncementBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="com.hrms.timesheet.bean.UnplanProjectBean"%>
<%@page import="com.hrms.timesheet.bean.TimeSheetBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.util.List"%>
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

<!-- Card Box CSS -->



<style>
#grad2 {
	background: #80D2EF; /* For browsers that do not support gradients */
	background: -webkit-linear-gradient(90deg, #80D2EF, #80D2EF);
	/* For Safari 5.1 to 6.0 */
	background: -o-linear-gradient(90deg, #80D2EF, #80D2EF);
	/* For Opera 11.1 to 12.0 */
	background: -moz-linear-gradient(90deg, #80D2EF, #80D2EF);
	/* For Firefox 3.6 to 15 */
	background: linear-gradient(90deg, #80D2EF, #80D2EF);
	/* Standard syntax (must be last) */
}
</style>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns"
	class="horizontal-layout horizontal-menu 2-columns ">
	<%
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		LoginDAO loginDAO1 = new LoginDAO();
		String company_name = null;
		String manager_name  = null;
		int employee_master_id = 0;
		
		
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat ddMMyyyy= new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat ddMMMyyyy= new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat yyyyMMddhh = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date current_date = new Date();

		if (user == null) {
			request.setAttribute("loginError", "You need to login first with your Id and Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			int emp_id = user.getEmployee_master_id();
			int role_id = user.getRoleBean().getRole_id();
			String authority = user.getRoleBean().getRole_authority();
			int id = user.getEmployee_master_id();
			int manager_id = user.getManagerBean().getManager_id();
			employee_master_id = user.getEmployee_master_id();
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
			
			LoginDAO loginDAO = new LoginDAO();
			
			EmployeeBean employeeBean1 = loginDAO.getEmailId(under_manager_id);
			manager_name = employeeBean1.getSalutation()+" "+employeeBean1.getFirstname()+" "+employeeBean1.getLastname();
			
			String role_authority = user.getRoleBean().getRole_authority();
			int department_id = user.getDepartmentBean().getDepartment_id();

			EmployeeBean employeeBean = loginDAO1.getEmailIdEmployee(id);
			
			
			
			String photo = employeeBean.getPhoto();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);

			int company_id = user.getCompanyListBean().getCompany_list_id();
			
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
			GatePassAuthorityBean gatePassAuthorityBean = allLMSListDAO.authorityOfGatePass(employee_master_id);
			
			AllListDAO allListDAO = new AllListDAO();
	%>
	<!-- navbar-fixed-top-->
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
				
				
				<!-- Leave And Gatepass notification -->
				
				<%
				
				List<LeaveBean> getLeaveByEmpId = allLMSListDAO.SPgetLeaveByEmpId(employee_master_id);
				List<LeaveCOBean> getCOByEmpid = allLMSListDAO.SPgetCOByEmpId(employee_master_id);
				List<LeaveODBean> getODByEmpid = allLMSListDAO.SPgetODByEmpId(employee_master_id); 
				
				List<LeaveCancelRequestBean> getLeaveForCancelByManager = null;
			 	List<LeaveBean> getLeaveByManager = null;
			 	List<LeaveCOBean> getCOByManager = null;
			 	List<LeaveODBean> getODByManager = null;
			 	List<GatePassBean> listOfGatePass = null;
			 	int totalOfLeave_CO_OD_Approval = 0;
				
				if(manager_id != 99){
					 getLeaveForCancelByManager = allLMSListDAO.SPgetLeaveForCancelByManagerId(manager_id);
				 	 getLeaveByManager = allLMSListDAO.SPgetLeaveByManagerId(manager_id);
				 	 getCOByManager = allLMSListDAO.SPgetCOByManagerId(manager_id);
				 	 getODByManager = allLMSListDAO.SPgetODByManagerId(manager_id);
				 	listOfGatePass = allLMSListDAO.SPgetListOfPendingGatePassManagerWithOtherId(manager_id);
				 	 
				 	 totalOfLeave_CO_OD_Approval = getLeaveForCancelByManager.size() + getLeaveByManager.size() + getCOByManager.size() + getODByManager.size() +  listOfGatePass.size();
				}
				
				int totalOfLeave_CO_OD = getLeaveByEmpId.size() + getCOByEmpid.size() + getODByEmpid.size() + totalOfLeave_CO_OD_Approval;
				
				%>
					<li class="dropdown dropdown-notification nav-item"><a
						href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i
							class="ficon icon-paper-airplane"></i><span
							class="tag tag-pill tag-default tag-info tag-default tag-up"><%=totalOfLeave_CO_OD%></span></a>
						<ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
							<li class="dropdown-menu-header">
								<h6 class="dropdown-header m-0">
									<span class="grey darken-2">Notification</span><span
										class="notification-tag tag tag-default tag-info float-xs-right m-0"><%=totalOfLeave_CO_OD%>
										NEW</span>
								</h6>
							</li>
							<li class="list-group scrollable-container">
							<%if(manager_id != 99){%>
							
							
							
							<%
				                	  if(listOfGatePass.size() != 0){
                  			%>
                  			
                   <a href="gatePassListManager.jsp"
								class="list-group-item">
									<div class="media">
										<div class="media-left valign-middle" style="color: black;">
											<i class="ficon icon-exit"></i>
										</div>
										<div class="media-body">
													<h6 class="media-heading">
													<b><%=listOfGatePass.size()%></b>	Gate Pass For Approval
													</h6>
													
													<p class="notification-text font-small-3 text-muted">Click here to open Gate Pass List</p>
										</div>
									</div>
							</a> <%} %>
							
							
							
							<%
				                  for(LeaveCancelRequestBean leaveCancelRequestBean : getLeaveForCancelByManager){
				                	  if (leaveCancelRequestBean.getLeave_cancel_type() == 1) {
                  			%>
                  			
                   <a href="cancelLeave.jsp?leave_id=<%=leaveCancelRequestBean.getLeaveBean().getLeave_id()%>&status=<%=leaveCancelRequestBean.getLeaveBean().getStatus()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left valign-middle" style="color: black;">
											<i class="ficon icon-paper-airplane"></i>
										</div>
										<div class="media-body">
													<h6 class="media-heading">
														Leave Cancel Request
													</h6>
													
													<p class="notification-text font-small-3 text-muted">
														<%=leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getLastname()%>
														(<%=ddMMyyyy.format(yyyyMMdd.parse(leaveCancelRequestBean.getLeaveBean().getLeave_From()))%>
														to
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveCancelRequestBean.getLeaveBean().getLeave_To()))%>)</p>
										</div>
									</div>
							</a>
							<%}else if(leaveCancelRequestBean.getLeave_cancel_type() == 2){%>
							
							<a href="leaveUpdateApprovance.jsp?leave_id=<%=leaveCancelRequestBean.getLeaveBean().getLeave_id()%>&status=<%=leaveCancelRequestBean.getLeaveBean().getStatus()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left valign-middle" style="color: black;">
											<i class="ficon icon-paper-airplane"></i>
										</div>
										<div class="media-body">
													<h6 class="media-heading">
														Leave Update Request
													</h6>
													
													<p class="notification-text font-small-3 text-muted">
														<%=leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getFirstname()+" "+leaveCancelRequestBean.getLeaveBean().getEmployeeBean().getLastname()%>
														(<%=ddMMyyyy.format(yyyyMMdd.parse(leaveCancelRequestBean.getLeaveBean().getLeave_From()))%>
														to
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveCancelRequestBean.getLeaveBean().getLeave_To()))%>)</p>
										</div>
									</div>
							</a>
							<%} %>
							
							 <%} %>
							
							
							
							<%
				                  for(LeaveBean leaveBean : getLeaveByManager){
                  			%>
                  			
                   <a href="pendingLeave?leave_id=<%=leaveBean.getLeave_id()%>&status=<%=leaveBean.getStatus()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left valign-middle" style="color: black;">
											<i class="ficon icon-paper-airplane"></i>
										</div>
										<div class="media-body">
													<h6 class="media-heading">
														Leave For Approval
													</h6>
													
													<p class="notification-text font-small-3 text-muted">
														<%=leaveBean.getEmployeeBean().getFirstname()+" "+leaveBean.getEmployeeBean().getLastname()%>
														(<%=ddMMyyyy.format(yyyyMMdd.parse(leaveBean.getLeave_From()))%>
														to
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveBean.getLeave_To()))%>)</p>
										</div>
									</div>
							</a> <%} %>
							
							
							<%
				                  for(LeaveCOBean leaveCOBean : getCOByManager){
                  			%>
                   <a href="LeaveCOManagerShow?CO_ID=<%=leaveCOBean.getCO_ID()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left valign-middle" style="color: black;">
											<i class="ficon icon-watch"></i>
										</div>
										<div class="media-body">
													<h6 class="media-heading">
														CO For Approval
													</h6>
													
													<p class="notification-text font-small-3 text-muted">
														<%=leaveCOBean.getEmployeeBean().getFirstname()+" "+leaveCOBean.getEmployeeBean().getLastname()%>
														(<%=ddMMyyyy.format(yyyyMMdd.parse(leaveCOBean.getCO_date()))%>)</p>
										</div>
									</div>
							</a> <%} %>
							
							
							<%
				                  for(LeaveODBean leaveODBean : getODByManager){
                  			%>
                   <a href="LeaveODManagerShow?OD_ID=<%=leaveODBean.getOD_ID()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left valign-middle" style="color: black;">
											<i class="ficon icon-file-text2"></i>
										</div>
										<div class="media-body">
													<h6 class="media-heading">
														OD For Approval
													</h6>
													
													<p class="notification-text font-small-3 text-muted">
														<%=leaveODBean.getEmployeeBean().getFirstname()+" "+leaveODBean.getEmployeeBean().getLastname()%>
														(<%=ddMMyyyy.format(yyyyMMdd.parse(leaveODBean.getOD_StartDate()))%>
														to 
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveODBean.getOD_EndDate()))%>
														)</p>
										</div>
									</div>
							</a> <%} %>
							
							
							<%} %>
							
								<%
                  String color = null;
                  for(LeaveBean leaveBean : getLeaveByEmpId){
                  	 String status1 = leaveBean.getStatus();
                	 
                	  
                  %> <a href="Myleave?leave_id=<%=leaveBean.getLeave_id()%>&status=<%=leaveBean.getStatus()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left valign-middle" style="color: black;">
											<i class="ficon icon-paper-airplane"></i>
										</div>
										<div class="media-body">
											<% if(status1.equalsIgnoreCase("pending")){%>
											<h6 class="media-heading" style="color: #3BAFDA">
												<%}else if(status1.equalsIgnoreCase("rejected")){%>
												<h6 class="media-heading red darken-1">
													<%}else if(status1.equalsIgnoreCase("approved")){%>
													<h6 class="media-heading green darken-1">
														<%} %>

														Your Leave <b><%=leaveBean.getStatus().toUpperCase()%></b>
													</h6>
													<p class="notification-text font-small-3 text-muted">
														Your Leave from
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveBean.getLeave_From()))%>
														to
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveBean.getLeave_To()))%></p>
										</div>
									</div>
							</a> <%} %> <%for(LeaveCOBean leaveCOBean : getCOByEmpid){
                    	 String status1 = leaveCOBean.getStatus();
                    	
                    	 
                     %> <a href="LeaveCOEmployeeShow?CO_ID=<%=leaveCOBean.getCO_ID()%>&status=<%=leaveCOBean.getStatus()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;">
											<i class="ficon icon-watch"></i>
										</div>
										<div class="media-body">

											<% if(status1.equalsIgnoreCase("pending")){%>
											<h6 class="media-heading" style="color: #3BAFDA">
												<%}else if(status1.equalsIgnoreCase("rejected")){%>
												<h6 class="media-heading red darken-1">
													<%}else if(status1.equalsIgnoreCase("approved")){%>
													<h6 class="media-heading green darken-1">
														<%} %>

														Your CO <b><%=leaveCOBean.getStatus().toUpperCase()%></b>
													</h6>
													<p class="notification-text font-small-3 text-muted">
														Your CO date is
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveCOBean.getCO_date()))%></p>
										</div>
									</div>
							</a> <%} %> <%for(LeaveODBean leaveODBean : getODByEmpid){
                    	String status1 = leaveODBean.getStatus();
                    	 
                    %> <a href="LeaveODEmployeeShow?OD_ID=<%=leaveODBean.getOD_ID()%>&status=<%=leaveODBean.getStatus()%>"
								class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;">
											<i class="ficon icon-file-text2"></i>
										</div>
										<div class="media-body">

											<% if(status1.equalsIgnoreCase("pending")){%>
											<h6 class="media-heading" style="color: #3BAFDA">
												<%}else if(status1.equalsIgnoreCase("rejected")){%>
												<h6 class="media-heading red darken-1">
													<%}else if(status1.equalsIgnoreCase("approved")){%>
													<h6 class="media-heading green darken-1">
														<%} %>

														Your OD <b><%=leaveODBean.getStatus().toUpperCase()%></b>
													</h6>
													<p class="notification-text font-small-3 text-muted">
														Your OD from
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveODBean.getOD_StartDate()))%>
														to
														<%=ddMMyyyy.format(yyyyMMdd.parse(leaveODBean.getOD_EndDate()))%></p>
										</div>
									</div>
							</a> <%} %>

							</li>
							<li class="dropdown-menu-footer"><a
								href="javascript:void(0)"
								class="dropdown-item text-muted text-xs-center">Read all
									messages</a></li>
						</ul></li>


				<!-- Timesheet and project and appraisal Notification -->
				
					<%	
					
              		List<TimeSheetBean> listOftimesheet = allListDAO.SPgetRejectedTimesheet(employee_master_id);
              		List<UnplanProjectBean> listOfUnplanProject = allListDAO.SPgetUnplanRejectedTimesheet(employee_master_id);
              		int totalTimesheet = listOftimesheet.size() + listOfUnplanProject.size();
              		
              		List<AppraisalBean> listOfAppraisal = null;
              		
              		List<TimeSheetBean> pendingTimesheet = null;
              		
              		List<UnplanProjectBean> getUnplanTimeSheetList = null;
            		int totalTimesheetForApproval = 0;
              		
              		if(manager_id != 99){
              			
              		 listOfAppraisal = allListDAO.SPgetAllappraisalByEmployeeIDStatus(manager_id);
              			
              			
              		 pendingTimesheet = allListDAO.SPgetPendingTimeSheet(manager_id);
                  	 getUnplanTimeSheetList = allListDAO.SPUnplanTimeSheet(manager_id);
                  	 
                  	totalTimesheetForApproval = pendingTimesheet.size() + getUnplanTimeSheetList.size(); 
                  	totalTimesheet = totalTimesheet + listOfAppraisal.size() + totalTimesheetForApproval;
                  	 
              		}
              		
              	
              %>
              
              
              
					<li class="dropdown dropdown-notification nav-item"><a
						href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i
							class="ficon icon-calendar3"></i><span
							class="tag tag-pill tag-default tag-info tag-default tag-up"><%=totalTimesheet %></span></a>
						<ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
							<li class="dropdown-menu-header">
								<h6 class="dropdown-header m-0">
									<span class="grey darken-2">Notification</span><span
										class="notification-tag tag tag-default tag-info float-xs-right m-0"><%=totalTimesheet %>
										NEW</span>
								</h6>
							</li>
							<li class="list-group scrollable-container">
							
							
							<%
                  		if(totalTimesheetForApproval !=0){
                  	%> <a href="pendingTimeSheetList"
								class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;">
											<i class="ficon icon-calendar4"></i>
										</div>
										<div class="media-body">
											<h6 class="media-heading red darken-1">
												<b><%=totalTimesheetForApproval %></b> Timesheet(s) for approval
											</h6>
											<%-- <p class="notification-text font-small-3 text-muted"><%=ddMMyyyy.format(yyyyMMdd.parse(timeSheetBean.getDate()))%></p> --%>
										</div>
									</div>
							</a> <%} %>
							
							
							
								<%
                  		for(TimeSheetBean timeSheetBean : listOftimesheet){
                  	%> <a href="duplicatTimesheetCheck?date=<%=timeSheetBean.getDate()%>&allList=allList"
								class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;">
											<i class="ficon icon-calendar4"></i>
										</div>
										<div class="media-body">
											<h6 class="media-heading red darken-1">
												Your Timesheet <b> <%=timeSheetBean.getApproval_status().toUpperCase()%></b>
											</h6>
											<p class="notification-text font-small-3 text-muted"><%=ddMMyyyy.format(yyyyMMdd.parse(timeSheetBean.getDate()))%></p>
										</div>
									</div>
							</a> <%} %>
							
							
							 <%
                  		for(UnplanProjectBean unplanProjectBean : listOfUnplanProject){
                  	%> <a href="duplicatTimesheetCheck?date=<%=unplanProjectBean.getDate()%>&allList=allList"
								class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;">
											<i class="ficon icon-calendar4"></i>
										</div>
										<div class="media-body">
											<h6 class="media-heading red darken-1">
												Your Timesheet
												<b><%=unplanProjectBean.getApproval_status().toUpperCase()%></b></h6>
											<p class="notification-text font-small-3 text-muted"><%=ddMMyyyy.format(yyyyMMdd.parse(unplanProjectBean.getDate()))%></p>
										</div>
									</div>
							</a> <%} %>
							
							
							<%
							if(manager_id != 99){
											for (AppraisalBean appraisalBean : listOfAppraisal) {
												if (appraisalBean.getQuterlyMonthBean().getQuarterly_month_id() != 5) {
										%>
											<a href="appraisalWhitecollarCheck?appraisal_id=<%=appraisalBean.getAppraisal_id()%>&&employee_id=<%=appraisalBean.getEmployeeBean().getEmployee_master_id()%>"
														class="list-group-item">
												<div class="media">
													<div class="media-left" style="color: black;">
														<i class="ficon icon-layout"></i>
													</div>
													<div class="media-body">
														<h6 class="media-heading" style="color: #3BAFDA">
															Appraisal Of 
															<b><%=appraisalBean.getEmployeeBean().getFirstname()+" "+appraisalBean.getEmployeeBean().getLastname()%></b></h6>
														<p class="notification-text font-small-3 text-muted">For Quater of<%=appraisalBean.getQuterlyMonthBean().getMonth_duration()%>,<%=appraisalBean.getYearBean().getYear()%></p>
													</div>
												</div>
											</a>
										<%
											} else if (appraisalBean.getMonthBean().getMonth_id() == 13) {
													int year_id = Integer.parseInt(appraisalBean.getYearBean().getYear()) + 1;
										%>
										<a href="appraisalWhitecollarCheck?appraisal_id=<%=appraisalBean.getAppraisal_id()%>&&employee_id=<%=appraisalBean.getEmployeeBean().getEmployee_master_id()%>"
														class="list-group-item">
												<div class="media">
													<div class="media-left" style="color: black;">
														<i class="ficon icon-layout"></i>
													</div>
													<div class="media-body">
														<h6 class="media-heading" style="color: #3BAFDA">
															Appraisal Of 
															<b><%=appraisalBean.getEmployeeBean().getFirstname()+" "+appraisalBean.getEmployeeBean().getLastname()%></b></h6>
														<p class="notification-text font-small-3 text-muted">For year of <%=appraisalBean.getYearBean().getYear()%></p>
													</div>
												</div>
											</a>
										<%
											} else {
										%>
										<a href="appraisalWhitecollarCheck?appraisal_id=<%=appraisalBean.getAppraisal_id()%>&&employee_id=<%=appraisalBean.getEmployeeBean().getEmployee_master_id()%>"
														class="list-group-item">
												<div class="media">
													<div class="media-left" style="color: black;">
														<i class="ficon icon-layout"></i>
													</div>
													<div class="media-body">
														<h6 class="media-heading" style="color: #3BAFDA">
															Appraisal Of 
															<b><%=appraisalBean.getEmployeeBean().getFirstname()+" "+appraisalBean.getEmployeeBean().getLastname()%></b></h6>
														<p class="notification-text font-small-3 text-muted">for month of <%=appraisalBean.getMonthBean().getMonth_name()%>,<%=appraisalBean.getYearBean().getYear()%></p>
													</div>
												</div>
											</a>
										<%
											}
											}
											}
										%>
							
							
							</li>
							<li class="dropdown-menu-footer"><a
								href="javascript:void(0)"
								class="dropdown-item text-muted text-xs-center">Read all
									messages</a></li>
						</ul></li>
					
					<!-- Self service notification -->
					
					
					<%
              		String curr_date = yyyyMMdd.format(current_date);
              		AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
              		List<AnnouncementBean> listOfAnnouncement = allListSelfServiceDAO.SPgetListOfAnnouncement();
              		List<AnnouncementBean> listOfNewAnnouncment = allListSelfServiceDAO.SPgetListOfAnnouncementByDate(curr_date);
					List<AnnouncementBean> listOfAnnouncementEndDate = allListSelfServiceDAO.SPgetListOfAnnouncementEndDate(curr_date);
					
					int announcement_count = 0;
					
					for(AnnouncementBean a : listOfAnnouncementEndDate){
					int announcement_id = a.getAnnouncement_id();
					boolean result1 = false;
					List<AnnouncementCategoryBean> listOfCategory = allListSelfServiceDAO.SPgetListOfAnnouncementCategoryDetail(announcement_id);
					for(AnnouncementCategoryBean a1 : listOfCategory){
						String role_category_name = a1.getRoleCategoryBean().getRole_category_name();
						int announcementId = a1.getRoleCategoryBean().getRole_category_id();
						if(role_category_name.equalsIgnoreCase(role_authority)){
							result1 = true;
							List<AnnouncementCategoryBean> listOfCategoryByRole = allListSelfServiceDAO.SPgetListOfAnnouncementCategoryByRole(announcementId, role_category_name);
							for (AnnouncementCategoryBean a2 : listOfCategoryByRole) {
								announcement_count++;
							}
						}
					}
					
					List<AnnouncementCompanyBean> listOfCompany  = allListSelfServiceDAO.SPgetListOfAnnouncementCompanyDetail(announcement_id);
					if(result1 == false){
					for(AnnouncementCompanyBean a2 : listOfCompany){
						System.out.println("result1" + result1);
						int companyId = a2.getCompanyListBean().getCompany_list_id();
						int announcementId1 = a2.getAnnouncementBean().getAnnouncement_id();
						if(companyId == company_id){
							announcement_count++;
						}
					}
					}
					
					List<AnnouncementDepartmentBean> listOfDepartment = allListSelfServiceDAO.SPgetListOfAnnouncementDepartmentDetail(announcement_id);
					if(result1 == false){
						for(AnnouncementDepartmentBean a3 : listOfDepartment){
						int departmentId = a3.getDepartmentBean().getDepartment_id();
						int announcementId2 = a3.getAnnouncementBean().getAnnouncement_id();
						if(departmentId == department_id){
							announcement_count++;
						}
						}
					}
				}
					
					
					
					
					AllListExitFormalityDAO allListExitFormalityDAO = new AllListExitFormalityDAO();
					 List<DetailsOfHandOverFormBean> listOfExitFormalityFormByEmpId = allListExitFormalityDAO.getListOfExitFormalityFormByHandOverId(employee_master_id); 
					 int secondHandOver = 0;
					 
					 if(manager_id != 99){
					List<ExitInterviewEmployeeBean> listOfExitInterviewEmployees  = allListExitFormalityDAO.getListOfExitInterviewEmployeesByManager(employee_master_id, manager_id);
					 List<DetailsOfHandOverFormBean> listOfExitFormalityFormByHandOverIdAfterSecondApproval = allListExitFormalityDAO.getListOfExitFormalityFormByHandOverIdAfterSecondApproval(manager_id);
					 
					 
					 for(DetailsOfHandOverFormBean d : listOfExitFormalityFormByHandOverIdAfterSecondApproval){ 
							
							int details_of_hand_over_form_id = d.getDetails_of_hand_over_form_id();
							
							HandOverApprovalBean handOverApprovalBean = allListExitFormalityDAO.getHandOverDetailIdByEmpId(employee_master_id, details_of_hand_over_form_id);
							if(handOverApprovalBean != null){
								secondHandOver++;
								
							}
						 }
					 
					 secondHandOver = secondHandOver + listOfExitInterviewEmployees.size();
					 }
					 
					 
					 int hrListOfexitfromality = 0;
					 if(employee_master_id == 1474 || employee_master_id == 8){
					 List<ExitInterviewEmployeeBean> listOfExitInterviewEmployeesForHR = allListExitFormalityDAO.getListOfExitInterviewEmployees(employee_master_id);
					 hrListOfexitfromality = listOfExitInterviewEmployeesForHR.size();
					 }
					 List<DetailsOfHandOverFormBean> listOfExitFormalityFormByHandOverIdAfterSecondApproval = allListExitFormalityDAO.getListOfExitFormalityFormByHandOverIdAfterSecondApproval(manager_id);
					 
					 
					 int hrHandOver = 0;
					 if(employee_master_id == 1474 || employee_master_id == 8){
							
							List<DetailsOfHandOverFormBean> listOfExitFormalityForHrApproval = allListExitFormalityDAO.getListOfExitFormalityFormForHRApproval();
							for(DetailsOfHandOverFormBean d : listOfExitFormalityForHrApproval){ 
							
							int details_of_hand_over_form_id = d.getDetails_of_hand_over_form_id();
							
							Long count = allListExitFormalityDAO.getCountOfApprovalHandOver(details_of_hand_over_form_id);
							if(count == 3){
								hrHandOver++;
							}
						}
					 }		
					 int exitTotal = listOfExitFormalityFormByEmpId.size() + hrListOfexitfromality + secondHandOver + hrHandOver + announcement_count;
					 
					 
					
              %>
					<li class="dropdown dropdown-notification nav-item"><a
						href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i
							class="ficon icon-android-hand"></i><span
							class="tag tag-pill tag-default tag-info tag-default tag-up"><%=exitTotal %></span></a>
						<ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
							<li class="dropdown-menu-header">
								<h6 class="dropdown-header m-0">
									<span class="grey darken-2">Notification</span><span
										class="notification-tag tag tag-default tag-info float-xs-right m-0"><%=exitTotal %>
										NEW</span>
								</h6>
							</li>
							<li class="list-group scrollable-container">
								<%
										
							for (AnnouncementBean a : listOfAnnouncementEndDate) {
							int announcement_id = a.getAnnouncement_id();
							boolean result1 = false;
							List<AnnouncementCategoryBean> listOfCategory = allListSelfServiceDAO.SPgetListOfAnnouncementCategoryDetail(announcement_id);
							for (AnnouncementCategoryBean a1 : listOfCategory) {
								String role_category_name = a1.getRoleCategoryBean().getRole_category_name();
								int announcementId = a1.getAnnouncementBean().getAnnouncement_id();
								if (role_category_name.equalsIgnoreCase(role_authority)) {
									result1 = true;
								List<AnnouncementCategoryBean> listOfCategoryByRole = allListSelfServiceDAO.SPgetListOfAnnouncementCategoryByRole(announcementId, role_category_name);
								for (AnnouncementCategoryBean a2 : listOfCategoryByRole) {
					%> <a href="announcementById.jsp?announcement_id=<%=a2.getAnnouncementBean().getAnnouncement_id()%>" class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;"><i class="ficon icon-bullhorn"></i></div>
										<div class="media-body">
											<h6 class="media-heading">
												Broadcast For <b> <%=a2.getAnnouncementBean().getAnnouncement_title()%></b>
											</h6>
											<p class="notification-text font-small-3 text-muted">
												By
												<%=a2.getAnnouncementBean().getEmployeeBean().getFirstname()+" "+a2.getAnnouncementBean().getEmployeeBean().getLastname()%></p>

										</div>
									</div>
							</a> <%
							}
						}
						}
							List<AnnouncementCompanyBean> listOfCompany  = allListSelfServiceDAO.SPgetListOfAnnouncementCompanyDetail(announcement_id);
							if(result1 == false){
							for(AnnouncementCompanyBean a2 : listOfCompany){
								System.out.println("result1" + result1);
								int companyId = a2.getCompanyListBean().getCompany_list_id();
								int announcementId1 = a2.getAnnouncementBean().getAnnouncement_id();
								if(companyId == company_id){
						%> <a href="announcementById.jsp?announcement_id=<%=a2.getAnnouncementBean().getAnnouncement_id()%>" class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;"><i class="ficon icon-bullhorn"></i></div>
										<div class="media-body">
											<h6 class="media-heading">
												Broadcast For <b> <%=a2.getAnnouncementBean().getAnnouncement_title()%></b>
											</h6>
											<p class="notification-text font-small-3 text-muted">
												By
												<%=a2.getAnnouncementBean().getEmployeeBean().getFirstname()+" "+a2.getAnnouncementBean().getEmployeeBean().getLastname()%></p>
										</div>
									</div>
							</a> <%	}
							}
							}				
							List<AnnouncementDepartmentBean> listOfDepartment = allListSelfServiceDAO.SPgetListOfAnnouncementDepartmentDetail(announcement_id);
							if(result1 == false){
							for(AnnouncementDepartmentBean a3 : listOfDepartment){
								int departmentId = a3.getDepartmentBean().getDepartment_id();
								int announcementId2 = a3.getAnnouncementBean().getAnnouncement_id();
								if(departmentId == department_id){
						%> <a href="announcementById.jsp?announcement_id=<%=a3.getAnnouncementBean().getAnnouncement_id()%>" class="list-group-item">
									<div class="media">
										<div class="media-left" style="color: black;"><i class="ficon icon-bullhorn"></i></div>
										<div class="media-body">
											<h6 class="media-heading">
												Broadcast For <b> <%=a3.getAnnouncementBean().getAnnouncement_title()%></b>
											</h6>
											<p class="notification-text font-small-3 text-muted">
												By
												<%=a3.getAnnouncementBean().getEmployeeBean().getFirstname()+" "+a3.getAnnouncementBean().getEmployeeBean().getLastname()%></p>
										</div>
									</div>
							</a> <%	}
												}
											}}
									%>
									
									
									<%for(DetailsOfHandOverFormBean detailsOfHandOverFormBean : listOfExitFormalityFormByEmpId){%>
										<a
										href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=detailsOfHandOverFormBean.getDetails_of_hand_over_form_id()%>"
										class="list-group-item" style=""> <i class="ficon icon-stack3"></i>
										<b><%=detailsOfHandOverFormBean.getEmployeeBean().getFirstname()+" "+detailsOfHandOverFormBean.getEmployeeBean().getLastname()%></b> Handed Over you.
									</a>
									<%} %>
									
									
									<%for(DetailsOfHandOverFormBean detailsOfHandOverFormBean : listOfExitFormalityFormByHandOverIdAfterSecondApproval){
									int handedOverEmployee = detailsOfHandOverFormBean.getHand_over_to_name();
									
									EmployeeBean bean = loginDAO.getEmailIdEmployee(handedOverEmployee);
										int details_of_hand_over_form_id = detailsOfHandOverFormBean.getDetails_of_hand_over_form_id();
									
									HandOverApprovalBean handOverApprovalBean = allListExitFormalityDAO.getHandOverDetailIdByEmpId(employee_master_id, details_of_hand_over_form_id);
									if(handOverApprovalBean != null){
									
									%>
									
									
												<a href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=detailsOfHandOverFormBean.getDetails_of_hand_over_form_id()%>" class="list-group-item">
							                      <div class="media">
							                        <div class="media-left" style="color: black;"><i class="ficon icon-stack3"></i></div>
							                        <div class="media-body">
							                          <p class="notification-text font-small-3 text-muted"><b><%=detailsOfHandOverFormBean.getEmployeeBean().getFirstname()+" "+detailsOfHandOverFormBean.getEmployeeBean().getLastname()%>'s</b> Hand Over taken by <b><%=bean.getFirstname()+" "+bean.getLastname()%>.Please Give Your Approval.</b>.</p>
							                        </div>
							                      </div>
							                   </a>
									
									<%} }%>
									
									
									
									<%
									List<ExitInterviewEmployeeBean> listOfExitInterviewEmployees  = allListExitFormalityDAO.getListOfExitInterviewEmployeesByManager(employee_master_id, manager_id);
									for(ExitInterviewEmployeeBean exitInterviewEmployeeBean : listOfExitInterviewEmployees){%>
									
									
									<a href="exitInterviewHRComment.jsp?exit_employee_id=<%=exitInterviewEmployeeBean.getExit_interview_employee_id()%>" class="list-group-item">
							                      <div class="media">
							                        <div class="media-left" style="color: black;"><i class="ficon icon-exit"></i></div>
							                        <div class="media-body">
							                          <p class="notification-text font-small-3 text-muted"><%=exitInterviewEmployeeBean.getEmployeeBean().getFirstname()+" "+exitInterviewEmployeeBean.getEmployeeBean().getLastname()%> send you Exit Formality Form For Approval.</p>
							                        </div>
							                      </div>
							            </a>
									
									<%} %>
									
									<%if(employee_master_id == 1474 || employee_master_id == 8){
										List<ExitInterviewEmployeeBean> listOfExitInterviewEmployeesForHR = allListExitFormalityDAO.getListOfExitInterviewEmployees(employee_master_id);
									
									%>
									<%for(ExitInterviewEmployeeBean exitInterviewEmployeeBean : listOfExitInterviewEmployeesForHR){%>
										
										<a href="exitInterviewHRComment.jsp?exit_employee_id=<%=exitInterviewEmployeeBean.getExit_interview_employee_id()%>" class="list-group-item">
							                      <div class="media">
							                        <div class="media-left" style="color: black;"><i class="ficon icon-exit"></i></div>
							                        <div class="media-body">
							                          <p class="notification-text font-small-3 text-muted"><%=exitInterviewEmployeeBean.getEmployeeBean().getFirstname()+" "+exitInterviewEmployeeBean.getEmployeeBean().getLastname()%>'s</b> Exit Formality form Approved by Department Head.Please Give Your Approval.</p>
							                        </div>
							                      </div>
							                   </a>
									
										
										
									<%} %>
									<%} %>
									
									
									
									<%if(employee_master_id == 1474 || employee_master_id == 8){
									
									List<DetailsOfHandOverFormBean> listOfExitFormalityForHrApproval = allListExitFormalityDAO.getListOfExitFormalityFormForHRApproval();
									for(DetailsOfHandOverFormBean d : listOfExitFormalityForHrApproval){ 
									
									int details_of_hand_over_form_id = d.getDetails_of_hand_over_form_id();
									
									Long count = allListExitFormalityDAO.getCountOfApprovalHandOver(details_of_hand_over_form_id);
									if(count == 3){%>
									
									
									<a href="handOverApprovalForm.jsp?hand_over_form_detail_id=<%=d.getDetails_of_hand_over_form_id()%>" class="list-group-item">
							                      <div class="media">
							                        <div class="media-left" style="color: black;"><i class="ficon icon-stack3"></i></div>
							                        <div class="media-body">
							                          <p class="notification-text font-small-3 text-muted"><%=d.getEmployeeBean().getFirstname()+" "+d.getEmployeeBean().getLastname()%>'s Hand Over process finish.Please Give Your Approval.</p>
							                        </div>
							                      </div>
							                   </a>
									
									<% }}} %>
									
									
							</li>
							<li class="dropdown-menu-footer"><a
								href="javascript:void(0)"
								class="dropdown-item text-muted text-xs-center">Read all
									messages</a></li>
						</ul></li>
						
			<%	if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){  
				List<GrievanceQueryBean> listOfGrievance = allLMSListDAO.SPgetListOfGrievanceQuery(); %>	
			<li class="dropdown dropdown-notification nav-item"><a href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i class="ficon icon-user-tie"></i><span class="tag tag-pill tag-default tag-info tag-default tag-up"><%=listOfGrievance.size()%></span></a>
                <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
                  <li class="dropdown-menu-header">
                    <h6 class="dropdown-header m-0"><span class="grey darken-2">Notification</span><span class="notification-tag tag tag-default tag-info float-xs-right m-0"><%=listOfGrievance.size()%> New</span></h6>
                  </li>
                  <li class="list-group scrollable-container">
                  <a href="javascript:void(0)" class="list-group-item">
                      <div class="media">
                        <div class="media-left"><i class="ficon icon-table2"></i></div>
                        <div class="media-body">
                          <h6 class="media-heading"><b><%=listOfGrievance.size()%></b> Grievance query(s).</h6>
                          <p class="notification-text font-small-3 text-muted"></p>
                        </div>
                      </div>
                   </a>
                   </li>
                  <li class="dropdown-menu-footer"><a href="javascript:void(0)" class="dropdown-item text-muted text-xs-center">Read all messages</a></li>
                </ul>
              </li>
				<%} %>
				
				
				
				
              
              
              
              

					<li class="dropdown dropdown-user nav-item"><a href="#"
						data-toggle="dropdown"
						class="dropdown-toggle nav-link dropdown-user-link"><span
							class="avatar avatar-online"><img
								src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=user.getEmployee_code()%>.bmp"
								alt="avatar"><i></i></span><span class="user-name"><%=user.getFirstname()+" "+user.getLastname()%></span></a>
						<div class="dropdown-menu dropdown-menu-right">
							<a href="employeeSelfUpdate.jsp" class="dropdown-item"><i class="icon-head"></i>
								User Profile</a>
							<div class="dropdown-divider"></div>
							<a href="logout" class="dropdown-item"><i class="icon-power3"></i>
								Logout</a>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->


	<!-- Horizontal navigation-->
	<div role="navigation" data-menu="menu-wrapper"
		class="header-navbar navbar navbar-horizontal navbar-fixed navbar-light navbar-without-dd-arrow navbar-bordered navbar-shadow">
		<!-- Horizontal menu content-->
		<div data-menu="menu-container"
			class="navbar-container main-menu-content container center-layout">
			<!-- include includes/mixins-->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="nav navbar-nav">


				<li data-menu="dropdown" class="dropdown nav-item"><a
					href="index-2.html" data-toggle="dropdown"
					class="dropdown-toggle nav-link"><i class="icon-home3"></i><span
						data-i18n="nav.dash.main">Dashboard</span></a>
					<ul class="dropdown-menu">
						<%if(manager_id != 99){ 
          		if(manager_id == 1 || manager_id == 2 || manager_id == 3){ %>
						<li data-menu="" class="active"><a href="sltlAdmin.jsp"
							data-toggle="dropdown" class="dropdown-item">Home</a></li>
						<%}else if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){ %>
						<li data-menu="" class="active"><a href="hrHome.jsp"
							data-toggle="dropdown" class="dropdown-item">Home</a></li>
						<%}else{ %>
						<li data-menu="" class="active"><a href="managerHome.jsp"
							data-toggle="dropdown" class="dropdown-item">Home</a></li>
						<%}%>
						<%}else{
			if(under_manager_id == 4 || under_manager_id == 117){ %>
						<li data-menu="" class="active"><a href="hrHome.jsp"
							data-toggle="dropdown" class="dropdown-item">Home</a></li>
						<%}else{%>
						<li data-menu="" class="active"><a href="empHome.jsp"
							data-toggle="dropdown" class="dropdown-item">Home</a></li>
						<%} }%>

						<li data-menu="dropdown-submenu" class="dropdown dropdown-submenu"><a
							href="#" data-toggle="dropdown"
							class="dropdown-item dropdown-toggle">Company Details</a>
							<ul class="dropdown-menu">
								<li data-menu=""><a href="companyAddresses.jsp"
									data-toggle="dropdown" class="dropdown-item">Company
										Address</a></li>
								<li data-menu=""><a href="cugList.jsp"
									data-toggle="dropdown" class="dropdown-item">CUG No</a></li>
								<li data-menu=""><a href="extentionNumber.jsp"
									data-toggle="dropdown" class="dropdown-item">Extension No</a></li>
							</ul></li>
					</ul></li>





				<%if(manager_id == 26 || manager_id == 11 || manager_id == 53){ %>
				<li data-menu="dropdown" class="dropdown nav-item"><a
					href="index-2.html" data-toggle="dropdown"
					class="dropdown-toggle nav-link"><i class="icon-home3"></i><span
						data-i18n="nav.dash.main">Incentive</span></a>
					<ul class="dropdown-menu">
						<li data-menu=""><a href="targetSales.jsp"
							data-toggle="dropdown" class="dropdown-item">Add Target</a></li>
						<li data-menu=""><a href="incentive.jsp"
							data-toggle="dropdown" class="dropdown-item">Incentive Form</a></li>
						<li data-menu=""><a href="incentiveListByYear.jsp"
							data-toggle="dropdown" class="dropdown-item">Incentive List</a></li>
						<li data-menu=""><a href="incentiveMaster.jsp"
							data-toggle="dropdown" class="dropdown-item">Incentive Policy</a>
						</li>
						<li data-menu=""><a href="incentiveMaster1.jsp"
							data-toggle="dropdown" class="dropdown-item">Incentive Master</a>
						</li>
					</ul></li>
				<%} %>


				<li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a
					href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i
						class="icon-android-hand"></i><span
						data-i18n="nav.category.addons">Self Service</span></a>
					<ul class="mega-dropdown-menu dropdown-menu row">
						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-android-hand"></i>Self Service HR
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="selfService.jsp" class="dropdown-item"><i></i>Upload
												Document</a></li>
										
										<% if(manager_id != 99){ %>
										<li><a href="employeeList.jsp" class="dropdown-item"><i></i>View
												Employee</a></li>
											<%} %>
									</ul>
								</li>
							</ul>
						</li>
						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-inr"></i>TDS Calculation
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="jquery-ui-interactions.html"
											class="dropdown-item"><i class="undefined"></i>Rules</a></li>
										<li><a href="TDSCalculation.jsp"
											class="dropdown-item"><i class="undefined"></i>Declaration Form</a></li>
										<li><a href="TDSList.jsp"
											class="dropdown-item"><i class="undefined"></i>Update TDS Form</a></li>

									</ul>
								</li>
							</ul>
						</li>
						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-exit"></i>Exit Formality
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="#" class="dropdown-item"><i></i>Exit
												Interview</a>
											<ul class="mega-menu-sub">
												<li><a href="exitInterviewForm.jsp"
													class="dropdown-item"><i></i>Exit Interview Form</a></li>
												<li><a href="exitInterviewManagerList.jsp"
													class="dropdown-item"><i></i>Exit Interview List</a></li>
											</ul></li>
										<li><a href="add-on-block-ui.html" class="dropdown-item"><i></i>Hand
												Over</a>
											<ul class="mega-menu-sub">
												<li><a href="handOverForm.jsp" class="dropdown-item"><i></i>Hand
														Over Form</a></li>
												<li><a href="handOverFormList.jsp"
													class="dropdown-item"><i></i>Hand Over Form List</a></li>
											</ul></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-bullhorn"></i>Broadcast
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<%if(manager_id != 99){%>
										<li><a href="announcementForm.jsp" class="dropdown-item"><i
												class="undefined"></i>Add Broadcast</a></li>
										<li><a href="announcementList.jsp" class="dropdown-item"><i
												class="undefined"></i>Send Broadcast History</a></li>
										<%} %>
										<li><a href="announcementEmployeeSide.jsp"
											class="dropdown-item"><i class="undefined"></i>Receive
												Broadcast History</a></li>
									</ul>
								</li>
							</ul>
						</li>
							<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-bullhorn"></i>Continuous Improvement
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										
										<li><a href="kaizenProblemIdentification.jsp" class="dropdown-item"><i
										class="undefined"></i> Add CI</a></li>
										<li><a href="kaizenEmpYearWiseList.jsp" class="dropdown-item"><i
										class="undefined"></i> My CI List</a></li>
												<%if(manager_id != 99){%>
												<li><a href="kaizenYearWiseList.jsp" class="dropdown-item"><i
										class="undefined"></i> CI BillBoard</a></li>
										<%if(emp_id == 989 || emp_id == 8 || emp_id == 7 || emp_id == 984 || emp_id == 62){ %>
										<li><a href="kaizenAuthorityYearWiseList.jsp" class="dropdown-item"><i
										class="undefined"></i> CI LeaderBoard </a></li>
										<%} %>
										<%if(emp_id == 8 ){ %>
										<li><a href="kaizenBillBoardExceptionReport.jsp" class="dropdown-item"><i
										class="undefined"></i> CI Exception Report </a></li>
										<li><a href="kaizenDashboard.jsp" class="dropdown-item"><i
										class="undefined"></i> CI Dashboard </a></li>
										<%} %>
										<%} %>
										<li><a href="kaizenBillBoardHistory.jsp" class="dropdown-item"><i
										class="undefined"></i> CI History</a></li>
									</ul>
								</li>
							</ul>
						</li>
						
						<%if(manager_id != 99){ %>
						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-inr"></i>Meeting Management
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="meetingBook.jsp"
											class="dropdown-item"><i class="undefined"></i>Add Meeting</a></li>
										<li><a href="meetingCalenderViewEmployee.jsp"
											class="dropdown-item"><i class="undefined"></i>My Calender</a></li>
										<li><a href="meetingCalenderViewHR.jsp"
											class="dropdown-item"><i class="undefined"></i>SLTL Meeting Calender</a></li>
										
										<%if(emp_id == 8 || emp_id == 61){ %>
										<li><a href="meetingReport.jsp"
											class="dropdown-item"><i class="undefined"></i> Meeting Report</a></li>
										<%} %>
									</ul>
								</li>
							</ul>
						</li>
						<%} %>
						<%-- <li><a href="#"><i class="fa fa-file-text">&nbsp;</i>
								Continuous Improvement<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<%
									if  (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
											|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
											|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
											|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
									%>
								<li><a href="kaizenProblemIdentification.jsp"><i
										class="fa fa-plus-circle"></i> Add CI</a></li>
								<%
									}
								%>
								<%
									if  (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
											|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
											|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
											|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
								%>
								<li><a href="kaizenEmpYearWiseList.jsp"><i
										class="fa fa-tasks"></i> My CI List</a></li>
								<%
									}
								%>
								<%
									if  (authority.equals("D1") || authority.equals("D2") || authority.equals("D3") || authority.equals("D4")
											|| authority.equals("W1") || authority.equals("W2") || authority.equals("W3") || authority.equals("T1") || authority.equals("T2") || authority.equals("T3") || authority.equals("E1") || authority.equals("E2") 
											|| authority.equals("E3") || authority.equals("E4")  || authority.equals("M1") || authority.equals("M2") ||  authority.equals("M3") || authority.equals("M4") || authority.equals("M5") || authority.equals("M6") || authority.equals("M7") || authority.equals("M8") || authority.equals("M9") || authority.equals("M10") || authority.equals("M11") || authority.equals("M12") || authority.equals("M13") || authority.equals("M14")
											|| authority.equals("A1") || authority.equals("A2") || authority.equals("A3") || authority.equals("A4")) {
								%>
								<%if(manager_id != 99){ %>
								<li><a href="kaizenYearWiseList.jsp"><i
										class="glyphicon glyphicon-th"></i> CI BillBoard</a></li>
										
										<%if(emp_id == 989 || emp_id == 8 || emp_id == 7 || emp_id == 984 || emp_id == 62){ %>
										<li><a href="kaizenAuthorityYearWiseList.jsp"><i
										class="glyphicon glyphicon-th"></i> CI LeaderBoard </a></li>
										<%} %>
										
										
										<%if(emp_id == 8 ){ %>
										<li><a href="kaizenBillBoardExceptionReport.jsp"><i
										class="glyphicon glyphicon-ban-circle"></i> CI Exception Report </a></li>
										<li><a href="kaizenDashboard.jsp"><i
										class="fa fa-bar-chart-o"></i> CI Dashboard </a></li>
										<%} %>
								<%
									}}
								%>
								
								<li><a href="kaizenBillBoardHistory.jsp"><i
										class="fa  fa-history"></i> CI History</a></li>
								</ul>
								</li> --%>
					</ul></li>


				<li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a
					href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i
						class="icon-calendar3"></i><span data-i18n="nav.category.addons">Project
							& Timesheet</span></a>
					<ul class="mega-dropdown-menu dropdown-menu row">
						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-book2"></i>Project Management
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<%if (manager_id != 99) { %>
										<li><a href="addProject.jsp" class="dropdown-item"><i></i>Add
												New Project</a></li>
										<li><a href="projectList.jsp" class="dropdown-item"><i></i>Project
												List</a></li>
										<%}%>
										<li><a href="myProjectAllocations.jsp"
											class="dropdown-item"><i></i>My Project Allocation</a></li>
										<%if (manager_id != 99) { %>
										<li><a href="employeeAllocationStatus.jsp"
											class="dropdown-item"><i></i>Employee Allocation</a></li>
										<%} %>
									</ul>
								</li>
							</ul>
						</li>
						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-calendar4"></i>Timesheet Management
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="timesheet.jsp" class="dropdown-item"><i
												class="undefined"></i>My Timesheet</a></li>
										<%if (manager_id != 99) { %>
										<li><a href="jquery-ui-navigations.html"
											class="dropdown-item"><i class="undefined"></i>Timesheet
												Status</a>
											<ul class="mega-menu-sub">
												<li><a href="pendingTimeSheetList"
													class="dropdown-item"><i></i>Pending Timesheet</a></li>
												<li><a href="approvedTimeSheet" class="dropdown-item"><i></i>Approved
														Timesheet</a></li>
												<li><a href="rejectedTimeSheet" class="dropdown-item"><i></i>Rejected
														Timesheet</a></li>
											</ul></li>
										<%} %>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-wpforms"></i>Appraisal Management
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<%if (manager_id == 99) { %>
										<li><a href="whiteCollarAppraisal.jsp"
											class="dropdown-item"><i class="undefined"></i>Self
												Appraisal</a></li>
										<li><a href="appraisalHistory.jsp" class="dropdown-item"><i
												class="undefined"></i>My Appraisal History</a></li>
										<%} %>
										<%if (manager_id != 99) { %>
										<li><a href="i18n-query-string.html"
											class="dropdown-item"><i class="undefined"></i>Indirect
												Employee</a>
											<ul class="mega-menu-sub">
												<li><a href="whiteCollarAppraisal.jsp"
													class="dropdown-item"><i></i>Self Appraisal</a></li>
												<li><a href="appraisalHistory.jsp"
													class="dropdown-item"><i></i>My Appraisal History</a></li>
											</ul></li>
										<li><a href="i18n-on-init.html" class="dropdown-item"><i
												class="undefined"></i>Direct Employee</a>
											<ul class="mega-menu-sub">
												<li><a href="appraisalFormManager.jsp"
													class="dropdown-item"><i></i>Blue Collar Appraisal</a></li>
											</ul></li>
										<li><a href="i18n-after-init.html" class="dropdown-item"><i
												class="undefined"></i>Appraisal History</a>
											<ul class="mega-menu-sub">
												<li><a href="allWhiteCollarAppraisal.jsp"
													class="dropdown-item"><i></i>Team Appraisal</a></li>
												<li><a href="allAppraisal.jsp" class="dropdown-item"><i></i>All
														Appraisal</a></li>
											</ul></li>
										<%} %>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-3" class="col-md-3">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-books"></i>Reports
							</h6>

							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<%if (manager_id != 99) { %>
										<li><a href="#" class="dropdown-item"><i
												class="icon-calendar5"></i>Project Report</a>
											<ul class="mega-menu-sub">
												<li><a href="weeklyCostReport.jsp"
													class="dropdown-item"><i></i>Cash-flow Report</a></li>
												<li><a href="resourceUsageReport.jsp"
													class="dropdown-item"><i></i>Resource usage</a></li>
												<li><a href="weeklyHourReport.jsp"
													class="dropdown-item"><i></i>Weekly-Hours Report</a></li>
												<li><a href="effortReport.jsp" class="dropdown-item"><i></i>Effort
														Variance Report</a></li>
												<li><a href="scheduleReport.jsp" class="dropdown-item"><i></i>Schedule
														Variance Report</a></li>
												<li><a href="overTimeReport.jsp" class="dropdown-item"><i></i>Over-Time
														Report</a></li>
												<li><a href="managerStatusReport.jsp"
													class="dropdown-item"><i></i>Status Report</a></li>
												<li><a href="weeklyTaskReport.jsp"
													class="dropdown-item"><i></i>Weekly Task Report</a></li>
												<li><a href="costVariance.jsp" class="dropdown-item"><i></i>Cost
														Variance</a></li>
												<li><a href="delayedTaskReport.jsp"
													class="dropdown-item"><i></i>Delayed Task Report</a></li>
											</ul></li>
										<%} %>
										<li><a href="#" class="dropdown-item"><i
												class="icon-cloud-upload3"></i>Timesheet Report</a>
											<ul class="mega-menu-sub">
												<li><a href="projectReport.jsp" class="dropdown-item"><i
														class="undefined"></i>Project Wise Report</a></li>
												<%if (manager_id != 99) { %>
												<li><a href="employeeReport.jsp" class="dropdown-item"><i
														class="undefined"></i>Employee Wise Report</a></li>
												<%} %>
												<li><a href="defaultersReport.jsp"
													class="dropdown-item"><i class="undefined"></i>Defaulters
														Report</a></li>
												<li><a href="statusReport.jsp" class="dropdown-item"><i
														class="undefined"></i>Status Report</a></li>
											</ul></li>

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
						</li>
					</ul></li>

				<%if(manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){ %>
				<li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a
					href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i
						class="icon-user-tie"></i><span data-i18n="nav.category.addons">HR
							Management</span></a>
					<ul class="mega-dropdown-menu dropdown-menu row">
						<li data-mega-col="col-md-2" class="col-md-2">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-users3"></i>Employee Master
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="ornogram.jsp" class="dropdown-item"><i></i>Organigram</a>
										</li>
										<li><a href="newEmployee.jsp" class="dropdown-item"><i></i>Add
												New Employee</a></li>
										<li><a href="newEmployee.jsp" class="dropdown-item"><i></i>Employee
												List</a>
											<ul class="mega-menu-sub">
												<li><a href="employeeList.jsp" class="dropdown-item"><i></i>Department Wise</a></li>
												<li><a href="employeeListCompanyWise.jsp"
													class="dropdown-item"><i></i>Company Wise</a></li>
											</ul></li>
										<li><a href="addDesignation.jsp" class="dropdown-item"><i></i>Add
												Designation</a></li>
										<li><a href="addSubDepartment.jsp" class="dropdown-item"><i></i>Add
												Sub Department</a></li>
										<li><a href="employeeCSV.jsp" class="dropdown-item"><i></i>CSV
												Upload</a></li>
										<li><a href="selfServiceAllEmployee.jsp"
											class="dropdown-item"><i></i>View Documents</a></li>

									</ul>
								</li>
							</ul>
						</li>
						<li data-mega-col="col-md-2" class="col-md-2">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-air-play"></i>Leave

							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="leaveadjustHR.jsp" class="dropdown-item"><i
												class="undefined"></i>Leave Adjust Form</a></li>
										<li><a href="leaveHolidayAddHR.jsp" class="dropdown-item"><i
												class="undefined"></i>Holiday Update</a></li>
										<li><a href="pendingLeaveHrSide.jsp"
											class="dropdown-item"><i class="undefined"></i>All Leave
												/ CO / OD</a></li>
										<li><a href="leaveReportByDate?date=<%=date1%>"
											class="dropdown-item"><i class="undefined"></i>Leave
												Report By Date</a></li>
										<li><a href="specialHRLeave.jsp" class="dropdown-item"><i
												class="undefined"></i>Special Leave Taken</a></li>
										<li><a href="gatePassHistoryHRSide.jsp"
											class="dropdown-item"><i class="undefined"></i>Gate Pass
												Status</a></li>
										<li><a href="hrShowAttendance.jsp" class="dropdown-item"><i
												class="undefined"></i>In / Out Report</a></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-2" class="col-md-2">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-table2"></i>Grievance
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="allGrievanceList.jsp" class="dropdown-item"><i
												class="undefined"></i>All Query</a></li>
										<li><a href="grievanceQueryType.jsp"
											class="dropdown-item"><i class="undefined"></i>Add Query
												Type</a></li>
										<li><a href="grievanceDashboard.jsp"
											class="dropdown-item"><i class="undefined"></i>Grievance
												Report</a></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-2" class="col-md-2">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-tune"></i>Appraisal
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="allAppraisal.jsp" class="dropdown-item"><i></i>All
												Appraisal</a></li>
										<li><a href="HRWhiteAppraisalExcel.jsp"
											class="dropdown-item"><i></i>White Collar Excel</a></li>
										<li><a href="HRBlueAppraisalExcel.jsp"
											class="dropdown-item"><i></i>Blue Collar Excel</a></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-2" class="col-md-2">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-tune"></i>Exit Interview
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="exitInterviewHRList.jsp"
											class="dropdown-item"><i></i>Exit Interview Form List</a></li>
										<li><a href="handOverFormHRList.jsp"
											class="dropdown-item"><i></i>Hand Over Form List</a></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-2" class="col-md-2">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-tune"></i>TDS Calculation
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="jquery-ui-interactions.html"
											class="dropdown-item"><i class="undefined"></i>Rules</a></li>
										<li><a href="TDSCalculation.jsp"
											class="dropdown-item"><i class="undefined"></i>Declaration
												Form</a></li>
										<li><a href="TDSDemo.jsp" class="dropdown-item"><i class="undefined"></i>Declaration
												Form List</a></li>
										<li><a href="jquery-ui-buttons-select.html"
											class="dropdown-item"><i class="undefined"></i>Investment
												Proof List</a></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-2" class="col-md-2">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-tune"></i>Broadcast
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="announcementList.jsp" class="dropdown-item"><i></i>All
												Broadcast</a></li>
									</ul>
								</li>
							</ul>
						</li>

					</ul></li>
				<%} %>


				<li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a
					href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i
						class="icon-paper-airplane"></i><span
						data-i18n="nav.category.addons">Leave & Gate Pass</span></a>
					<ul class="mega-dropdown-menu dropdown-menu row">
						<li data-mega-col="col-md-6" class="col-md-6">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-edit2"></i>Leave Management
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="leaveholidayList.jsp" class="dropdown-item"><i></i>Holiday
												List</a></li>
										<li><a href="leavebalance.jsp" class="dropdown-item"><i></i>Leave
												Balance</a></li>
										<li><a href="applyLeaveODCOForm.jsp"
											class="dropdown-item"><i></i>Apply Leave / CO / OD</a></li>
										<li><a href="leavesuccess.jsp" class="dropdown-item"><i></i>Leave
												/ CO / OD Status</a></li>
										<li><a href="ShowAttendance.jsp" class="dropdown-item"><i></i>Self
												IN / OUT</a></li>
										<li><a href="leaveRules.jsp" class="dropdown-item"><i></i>Leave
												Rules</a></li>
										<%if(manager_id != 99){%>
										<li><a href="editor-quill.html" class="dropdown-item"><i></i>Team
												Member Status</a>
											<ul class="mega-menu-sub">
												<li><a href="leaveListManager.jsp"
													class="dropdown-item"><i></i>Leave / CO / OD Status</a></li>
												<li><a href="masterINOUT.jsp"
													class="dropdown-item"><i></i>IN / OUT Status</a></li>
											</ul></li>
										<%} %>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-6" class="col-md-6">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-edit2"></i>Gate Pass
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="leave_gatepassEmployee.jsp"
											class="dropdown-item"><i></i>Gate Pass Form</a></li>
										<li><a href="gatePassListEmployee.jsp"
											class="dropdown-item"><i></i>Gate Pass List</a></li>
										<%if(manager_id != 99){%>
										<li><a href="editor-quill.html" class="dropdown-item"><i></i>Team
												Member Status</a>
											<ul class="mega-menu-sub">
												<li><a href="gatePassListManager.jsp"
													class="dropdown-item"><i></i>Gate Pass Status</a></li>
											</ul></li>
										<%} %>
									</ul>
								</li>
							</ul>
						</li>
					</ul></li>


				<li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a
					href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i
						class="icon-birdpen"></i><span data-i18n="nav.category.addons">Complaint
							Management</span></a>
					<ul class="mega-dropdown-menu dropdown-menu row">
						<li data-mega-col="col-md-6" class="col-md-6">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-edit2"></i>Grievance Management
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="grievance.jsp" class="dropdown-item"><i></i>Add
												Query</a></li>
										<li><a href="allGrievanceList.jsp" class="dropdown-item"><i></i>My
												All Queries</a></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-6" class="col-md-6">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-edit2"></i>IT Complaint
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="complaint.jsp" class="dropdown-item"><i></i>Add
												Complaint</a></li>
										<li><a href="complaintList.jsp" class="dropdown-item"><i></i>My
												All Complaints</a></li>
									</ul>
								</li>
							</ul>
						</li>
					</ul></li>

				<%if(manager_id == 65 || manager_id == 5 || under_manager_id == 65) {%>
				<li data-menu="megamenu" class="dropdown mega-dropdown nav-item"><a
					href="#" data-toggle="dropdown" class="dropdown-toggle nav-link"><i
						class="icon-square-plus"></i><span data-i18n="nav.category.addons">IT</span></a>
					<ul class="mega-dropdown-menu dropdown-menu row">
						<li data-mega-col="col-md-6" class="col-md-6">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-edit2"></i>Complaint Register
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="ProblemNature.jsp" class="dropdown-item"><i></i>Add
												Problem Nature</a></li>
										<li><a href="itComplaint.jsp" class="dropdown-item"><i></i>All
												Complaints</a></li>
									</ul>
								</li>
							</ul>
						</li>

						<li data-mega-col="col-md-6" class="col-md-6">
							<h6 data-toggle="dropdown"
								class="dropdown-menu-header text-uppercase">
								<i class="icon-edit2"></i>Asset Management
							</h6>
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a href="editor-quill.html" class="dropdown-item"><i></i>Machine
												Detail</a>
											<ul class="mega-menu-sub">
												<li><a href="machineDetail.jsp" class="dropdown-item"><i></i>Fill
														Machine Detail</a></li>
												<li><a href="machineDetailList.jsp"
													class="dropdown-item"><i></i>Machine Report</a></li>
											</ul></li>
										<li><a href="editor-quill.html" class="dropdown-item"><i></i>Asset
												Detail</a>
											<ul class="mega-menu-sub">
												<li><a href="stockDetail.jsp" class="dropdown-item"><i></i>Add
														Stock</a></li>
												<li><a href="addAsset.jsp" class="dropdown-item"><i></i>Asset
														Master</a></li>
												<li><a href="stockList.jsp" class="dropdown-item"><i></i>IT
														Asset</a></li>
												<li><a href="assetAllocation.jsp" class="dropdown-item"><i></i>Asset
														List</a></li>
												<li><a href="scrapList.jsp" class="dropdown-item"><i></i>All
														Scrap List</a></li>
												<li><a href="assetTransfer.jsp" class="dropdown-item"><i></i>Allocated
														Asset List</a></li>
											</ul></li>
									</ul>
								</li>
							</ul>
						</li>
					</ul></li>
				<%} %>



			</ul>
		</div>
		<!-- /horizontal menu content-->
	</div>
	<!-- Horizontal navigation-->


	<!-- ////////////////////////////////////////////////////////////////////////////-->

	<%} %>

	
	
</body>

</html>