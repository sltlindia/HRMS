<%@page import="com.hrms.pms.bean.FamilyDetailBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="com.hrms.pms.bean.FamilyRelationBean"%>
<%@page import="com.hrms.pms.bean.EmployeeStatusBean"%>
<%@page import="com.hrms.pms.bean.GraduateDegreeBean"%>
<%@page import="com.hrms.pms.bean.MasterDegreeBean"%>
<%@page import="com.hrms.pms.bean.DiplomaCourseBean"%>
<%@page import="com.hrms.pms.bean.ITICourseBean"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.corehr.bean.SubDepartmentBean"%>
<%@page import="com.hrms.corehr.dao.AllListCoreHrDAO"%>
<%@page import="com.hrms.pms.bean.BasicQualificationBean"%>
<%@page import="com.hrms.pms.bean.SpecialQualificationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>

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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/pickers/daterange/daterangepicker.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/plugins/forms/wizard.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/plugins/pickers/daterange/daterange.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!-- END Custom CSS-->
    
    <script type="text/javascript">
    var datefield=document.createElement("input")
    datefield.setAttribute("type", "text")
    if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
    }
</script>


<script>
    if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
        jQuery(function($){ //on document.ready
                $('.dateField').datepicker({
                    dateFormat: 'yy-mm-dd'
                });
                $('#birthdate').datepicker({
                    dateFormat: 'yy-mm-dd'
                });
                $('#joiningdate').datepicker({
                    dateFormat: 'yy-mm-dd'
                });
        })
    }
</script>
    
    
<%@include file="header.jsp"%>
</head>
<body>
<%AllListDAO allListDAO = new AllListDAO();
int employee_status_id = 0; 

String action = "empDetail";
if(request.getParameter("action") != null){
	action = request.getParameter("action");
}

    if(request.getAttribute("employee_master_id") != null){
			employee_master_id =(Integer) (request.getAttribute("employee_master_id"));
	}else if(request.getParameter("employee_master_id") != null){
		employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
	}

EmployeeBean employeeBean = loginDAO1.getEmailIdEmployee(employee_master_id);
int employee_code = employeeBean.getEmployee_code();

%>
 <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12">
            <h2 class="content-header-title mb-0">Circle Style</h2>
            <br>
          </div>
        </div>
<div class="content-body">


<section id="validation">
    <div class="row">
        <div class="col-xs-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Validation Example</h4>
                    <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                    <div class="heading-elements">
                        <ul class="list-inline mb-0">
                            <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
                            <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                            <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                            <li><a data-action="close"><i class="icon-cross2"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="card-body collapse in">
                    <div class="card-block">
                        <form action="#" class="steps-validation wizard-circle" id="form">

                            <!-- Step 1 -->
                            <h6>Step 1</h6>

							<fieldset>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="firstName2">Employee Code :</label>
                                           <input type="text" class="form-control" name="employeecode" id="employeecode" value="<%=employeeBean.getEmployee_code()%>" required>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="lastName2">Grade Code :</label>
                                            <input type="text" class="form-control" name="gradecode" id="gradecode" value="<%=employeeBean.getGrade_code()%>" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="lastName2">Salutation :</label>
                                            <div class="form-group">
                                               <label class="display-inline-block custom-control custom-radio ml-1">
													<input type="radio" name="optionsRadiosInline" class="custom-control-input" value="Mr.">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Mr.</span>
												</label>
												<label class="display-inline-block custom-control custom-radio">
													<input type="radio" name="optionsRadiosInline"  class="custom-control-input" value="Mrs.">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Mrs.</span>
												</label>
												  <label class="display-inline-block custom-control custom-radio ml-1">
													<input type="radio" name="optionsRadiosInline" class="custom-control-input" value="Ms.">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Ms.</span>
												</label>
												<label class="display-inline-block custom-control custom-radio" >
													<input type="radio" name="optionsRadiosInline"  class="custom-control-input" value="Dr.">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Dr.</span>
												</label>
												<label class="display-inline-block custom-control custom-radio">
													<input type="radio" name="optionsRadiosInline"  class="custom-control-input" value="Prof.">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Prof.</span>
												</label>
												</div>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                
                                
                                
                                <div class="row">
								
								<div class="col-md-4">
								
									<div class="form-group">
                                            <label for="firstName2">First Name :</label>
                                           <input type="text" class="form-control"
												 name="firstname" id="firstname"
												value="<%=employeeBean.getFirstname()%>"  oninput="autoFill(1);" required>
                                        </div>
								</div>
								
								<div class="col-md-4">
								<div class="form-group">
									<label >Middle Name</label>
									<input type="text" class="form-control"
												 name="middlename" id="middlename" 
												value="<%=employeeBean.getMiddlename()%>" oninput="autoFill(2);" required>
												</div>
								</div>
								<div class="col-md-4">
								<div class="form-group">
									<label >Last Name</label>
									<input type="text" class="form-control"
												 name="lastname" id="lastname"
												value="<%=employeeBean.getLastname()%>" oninput="autoFill(3);" required>
												</div>
								</div>
							</div>
                                
                                
                                
                             <div class="row">
                             
								<div class="col-lg-8">
									<label >Address</label>
									<textarea class="form-control" rows="4"
														name="address"><%=employeeBean.getAdress()%></textarea>
								</div>
								
								
								
								<div class="col-lg-4">
							
							
							 		<div class="form-group">
                                            <label for="lastName2">Gender :</label>
                                            <div class="form-group">
                                               <label class="display-inline-block custom-control custom-radio ml-1">
													<input type="radio" name="gender" class="custom-control-input" value="Male">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Male</span>
												</label>
												<label class="display-inline-block custom-control custom-radio">
													<input type="radio" name="gender"  class="custom-control-input" value="Female">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Female</span>
												</label>
												</div>
                                        </div>
                                        
                                        
                                         <label for="lastName2">Marital Status :</label>
                                            <div class="form-group">
                                               <label class="display-inline-block custom-control custom-radio ml-1">
													<input type="radio" name="maritalstatus" class="custom-control-input" value="Male">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Married</span>
												</label>
												<label class="display-inline-block custom-control custom-radio">
													<input type="radio" name="maritalstatus"  class="custom-control-input" value="Female">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Unmarried</span>
												</label>
												</div>
                                        </div>
							
							
								</div>
								<!-- /.col-md-12 -->
								
								
								
								
								<div class="row">
					
							<div class="col-md-4">
							<div class="form-group">
										<label >Birth Date</label>&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="text" class="form-control"
												name="birthdate" placeholder="yyyy-mm-dd" id="birthdate"
												value="<%=employeeBean.getBirth_date()%>"
												required>
												</div>
							</div>
							<!-- /.col-md-4 -->
					
							<div class="col-lg-4">
							<div class="form-group">
								<label >Height</label>
								<input type="text" class="form-control"
												name="height" value="<%=employeeBean.getHeight()%>" required>
												</div>
							</div>
							<!-- /.col-lg-4-->
							
							<div class="col-lg-4">
							<div class="form-group">
										<label>Weight</label><br>
										<input type="text" class="form-control"
												name="weight" value="<%=employeeBean.getWeight()%>" required>
												</div>
							</div>
							<!-- /.col-lg-4 -->
						</div>
						<!-- /.row -->
								
								
							
					<div class="row">
							<div class="col-lg-4">
							<div class="form-group">
								<label style="margin-bottom: 0%; margin-top: 15px;">Identification Marks</label>
								<input type="text" class="form-control"
												name="identificationmarks"
												value="<%=employeeBean.getIdentification_marks()%>" required>
												</div>
							</div>
							<!-- /.col-lg-4 -->
							
							<div class="col-lg-4">
							<div class="form-group">
								<label style="margin-bottom: 0%; margin-top: 15px;">Languages</label>
								<input type="text" class="form-control"
												name="languages" value="<%=employeeBean.getLanguages()%>" required>
												</div>
							</div>
							<!-- /.col-lg-4 -->
							
							<div class="col-lg-4">
							<div class="form-group">
										<label style="margin-bottom: 0%; margin-top: 15px;">Blood Group</label><br>
										<input type="text" class="form-control"
												name="bloodgroup" value="<%=employeeBean.getBlood_group()%>" required>
												</div>
							</div>
							<!-- /.col-lg-4 -->
						</div>
						<!-- /.row -->
						
						
						
						<div class="row">
							
							<div class="col-lg-4">
										<label style="margin-bottom: 0%; margin-top: 15px;">Mobile No</label><br>
										<input type="text" class="form-control"
												name="mobileno" value="<%=employeeBean.getMob_num()%>" required>
							</div>
							<!-- /.col-lg-4 -->
					
							<div class="col-lg-4">
								<label style="margin-bottom: 0%; margin-top: 15px;">Official Email-id</label>
								<input type="email" class="form-control"
												name="emailid" value="<%=employeeBean.getEmail_id()%>" required>
							</div>
							<!-- /.col-lg-4 -->
							
							<div class="col-lg-4">
								<label style="margin-bottom: 0%; margin-top: 15px;">Personal Email-id</label>
								<input type="email" class="form-control"
												name="per_emailid" value="<%=employeeBean.getPer_emailid()%>" required>
							</div>
							<!-- /.col-lg-4 -->
							
						
					</div>
					<!-- /.row -->
						
						<div class="row">
							<div class="col-lg-4">
								<label style="margin-bottom: 0%; margin-top: 15px;">Basic Qualification</label>
								
								<select class="form-control" name="basic_qualification"
											id="basic_qualification" >
												<option value="">-- Basic Qualification --</option>
												<%
													List<BasicQualificationBean> listOfBasicQualification = allListDAO.getListOfBasicQualification();
													for (BasicQualificationBean b : listOfBasicQualification) {
														if(employeeBean.getBasic_qualification().equalsIgnoreCase(b.getBasic_qualification())){												%>
													<option value="<%=b.getBasic_qualification()%>" selected="selected"><%=b.getBasic_qualification()%></option>
													<%}else{ %>
													<option value="<%=b.getBasic_qualification()%>"><%=b.getBasic_qualification()%></option>
													<%} %>

													<%
													
													}
												%>
								</select>
								
								<!-- <input type="text" class="form-control"
												name="basic_qualification"
												value="" required> -->
							</div>
							<!-- /.col-lg-4 -->
							
							<div class="col-lg-4">
								<label style="margin-bottom: 0%; margin-top: 15px;">Special Qualification</label><br>
										
								<select class="form-control" name="special_qualification"
									id="special_qualification">
										<option value="">-- Special Qualification --</option>
										<%
											List<SpecialQualificationBean> listOfSpecialQualification = allListDAO.getListOfSpecialQualification();
											for (SpecialQualificationBean s : listOfSpecialQualification) {
												if(s.getSpecial_qualification().equalsIgnoreCase(employeeBean.getSpecial_qualification())){
										%>
											<option value="<%=s.getSpecial_qualification()%>" selected="selected"><%=s.getSpecial_qualification()%></option>
											<%}else{ %>
											<option value="<%=s.getSpecial_qualification()%>"><%=s.getSpecial_qualification()%></option>
											<%} %>
										<%
											
											}
										%>
								</select>
										
										<!-- 
										<input type="text" class="form-control"
												name="special_qualification"
												value="" required> -->
							</div>
							<!-- /.col-lg-4 -->
							
							<div class="col-lg-4">
										<label style="margin-bottom: 0%; margin-top: 15px;">Location</label>
										<input type="text" class="form-control"
												name="location" value="<%=employeeBean.getLocation()%>" required>
							</div>
							<!-- /.col-lg-4 -->
							
						</div>
						<!-- /.row -->	
						
						
						
						<div class="row">
							<div class="col-lg-4">
								<label style="margin-bottom: 0%; margin-top: 15px;">Company</label>
								<select class="form-control" name="company"
												id="company" 
												onchange="autoShow(this.value)" required>
													<option value="0">-- Select Company --</option>
													<%
														CompanyListDAO companyListDAO = new CompanyListDAO();
													int company_id = 0;
															List<CompanyListBean> listOfCompanyList = companyListDAO.getListOfCompanyList();

															for (CompanyListBean companyListBean : listOfCompanyList) {
																if(companyListBean.getCompany_list_id() == employeeBean.getCompanyListBean().getCompany_list_id()){
													%>
													<option value="<%=companyListBean.getCompany_list_id()%>" selected="selected"><%=companyListBean.getCompany_name()%></option>
													<%}else{ %>
													<option value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
													<%} %>
													
													<%
														
															}
													%>
											</select>
							</div>
							<!-- /.col-lg-4 -->
							
							<div class="col-lg-4">
										<label style="margin-bottom: 0%; margin-top: 15px;">Department</label><br>
										<select class="form-control" name="department"
												id="department" required="required"
												onchange="autoShow(this.value)" required>
													<option value="0">-- Select Department --</option>
													<%
														DepartmentDAO departmentDAO = new DepartmentDAO();
													int id = 0;
															List<DepartmentBean> listOfDepartment = departmentDAO.getListOfDepartment();
															for (DepartmentBean departmentBean : listOfDepartment) {
																if(departmentBean.getDepartment_id() == employeeBean.getDepartmentBean().getDepartment_id()){

													%>
													<option value="<%=departmentBean.getDepartment_id()%>" selected="selected"><%=departmentBean.getDepartment_name()%></option>
													
													<%}else{ %>
													
													<option value="<%=departmentBean.getDepartment_id()%>"><%=departmentBean.getDepartment_name()%></option>
													
													<%} %>
													<%
															}
													%>
											</select>
							</div>
							<!-- /.col-lg-4 -->
							
							
							<div class="col-lg-4">
									<label style="margin-bottom: 0%; margin-top: 15px;">Sub Department</label><br>
										<select class="form-control" name="subdepartment"
												id="subdepartment" required="required">
													<option value="0">-- Select SubDepartment --</option>
													<%
														AllListCoreHrDAO allListCoreHrDAO = new AllListCoreHrDAO();
															List<SubDepartmentBean> listOfSubDepartment = allListCoreHrDAO.getListOfSubDepartent();
															for (SubDepartmentBean subDepartmentBean : listOfSubDepartment) {
															if(subDepartmentBean.getSub_department_name() == employeeBean.getSub_department()){
																	
													%>
													<option value="<%=subDepartmentBean.getSub_department_name()%>" selected="selected"><%=subDepartmentBean.getSub_department_name()%></option>
													<%}else{ %>
													<option value="<%=subDepartmentBean.getSub_department_name()%>"><%=subDepartmentBean.getSub_department_name()%></option>
													<%} %>
													
													<%
														}
													%>
											</select>
							</div>
							<!-- /.col-lg-4 -->
							
							
							
						</div>
						<!-- /.row -->	
						
						
						<div class="row">
								
								<div class="col-lg-4">
											<label style="margin-bottom: 0%; margin-top: 15px;">Role</label><br>
											<select class="form-control" name="role" id="role"
												required="required" onchange="autoShow(this.value)" required>
													<option value="0">-- Select Role --</option>
													<%
														AllListDAO allListDAO1 = new AllListDAO();
													
													int role_id = 0;
													
															List<RoleBean> listofRole = allListDAO1.getListOfRole();

															for (RoleBean roleBean : listofRole) {
																if(roleBean.getRole_id() == employeeBean.getRoleBean().getRole_id()){

													%>
													<option value="<%=roleBean.getRole_id()%>" selected="selected"><%=roleBean.getRole_type()%></option>
													<%}else{ %>
													<option value="<%=roleBean.getRole_id()%>"><%=roleBean.getRole_type()%></option>
													<%} %>
													
													<%
															}
													%>
											</select>
								</div>
								<!-- /.col-lg-4 -->
								
								
								<div class="col-lg-4">
										<label style="margin-bottom: 0%; margin-top: 15px;">Reporting Manager</label>
										<select class="form-control" name="manager"
												id="manager" required="required"
												onchange="autoShow(this.value)" required>
													<option value="0">-- Select Manager --</option>

													<%
														AllListDAO allListDAO2 = new AllListDAO();
													String under_manager_id = null;
															List<ManagerBean> ListOfManager = allListDAO2.getListOfManager();
															for (ManagerBean managerBean : ListOfManager) {
																if(managerBean.getManager_id() == employeeBean.getManagerBean().getManager_id()){
													%>
													<option value="<%=managerBean.getManager_id()%>" selected="selected"><%=managerBean.getManager_name()%></option>
													<%}else{ %>
													<option value="<%=managerBean.getManager_id()%>"><%=managerBean.getManager_name()%></option>
													<%} %>

													<%
															}
													%>
											</select>
									</div>
									<!-- /.col-lg-4 -->
									
									<div class="col-lg-4">
												<label style="margin-bottom: 0%; margin-top: 15px;">Joining Date</label><br>
												<input type="text" class="form-control"
												name="joiningdate" id="joiningdate" placeholder="yyyy-mm-dd"
												onchange="checkedstartDate();days_between();"
												value="<%=employeeBean.getJoining_date()%>" reqiured/>
									</div>
									<!-- /.col-lg-4 -->
								
								
							</div>
							<!-- /.row -->	
	
						
						
						<div class="row">
									<div class="col-lg-4">
										<label style="margin-bottom: 0%; margin-top: 15px;">Resource Cost</label>
										<input type="text" class="form-control"
												name="resourcecost" value="<%=employeeBean.getResource_cost()%>"
												required>
									</div>
									<!-- /.col-lg-4 -->
									
									<div class="col-lg-4">
												<label style="margin-bottom: 0%; margin-top: 15px;">Gross Salary</label><br>
												<input type="text" class="form-control"
												name="grosssalary" value="<%=employeeBean.getGross_salary()%>"
												required>
									</div>
									<!-- /.col-lg-4 -->
									
									<div class="col-lg-4">
												<label style="margin-bottom: 0%; margin-top: 15px;">Employee Status</label><br>
												<select class="form-control" name="employee_status_id"
												id="employee_status_id" required="required"
												onchange="autoShow(this.value)" required>
													<option value="0">-- Select Employee Status --</option>
													<%
													AllListDAO allListDAO5 = new AllListDAO();
														List<EmployeeStatusBean> listOfEmployeeStatus = allListDAO5.getListOfEmployeeStatus();
														for (EmployeeStatusBean employeeStatusBean : listOfEmployeeStatus) {
															if(employeeBean.getEmployeeStatusBean().getEmployee_status_id() == employeeStatusBean.getEmployee_status_id()){

																%>		<option value="<%=employeeStatusBean.getEmployee_status_id()%>" selected="selected"><%=employeeStatusBean.getEmployee_status_name()%></option>
																	<%}else{ %>
																		<option value="<%=employeeStatusBean.getEmployee_status_id()%>"><%=employeeStatusBean.getEmployee_status_name()%></option>
																	<%} %>
																	
																	<%}
																%>
											</select>
											
									</div>
									<!-- /.col-lg-4 -->
									
									
								</div>
								<!-- /.row -->
								
						
							<div class="row">
									<div class="col-lg-3">
										<label style="margin-bottom: 0%; margin-top: 15px;">Graduate Degree</label>
										
										<select class="form-control" name="graduate_degree"
											id="graduate_degree">
												<option value="">-- Select Graduate Degree--</option>
												<%
													List<GraduateDegreeBean> listOfGraduateDegree = allListDAO.getListOfGraduateDegree();
													for (GraduateDegreeBean g : listOfGraduateDegree) {
														if(g.getGraduate_degree().equalsIgnoreCase(employeeBean.getGraduate_degree())){
												%>
													<option value="<%=g.getGraduate_degree()%>"><%=g.getGraduate_degree()%></option>
													<%}else{ %>
													<option value="<%=g.getGraduate_degree()%>" selected="selected"><%=g.getGraduate_degree()%></option>
													<%} %>
												<%
													
													}
												%>
										</select>
										
										
										
										<!-- <input type="text" class="form-control"
												name="graduate_degree" value=""> -->
									</div>
									<!-- /.col-lg-4 -->
									
									<div class="col-lg-3">
										<label style="margin-bottom: 0%; margin-top: 15px;">Master Degree</label><br>
												
										<select class="form-control" name="master_degree"
											id="master_degree">
												<option value="">-- Master Degree --</option>
												<%
													List<MasterDegreeBean> listOfMasterDegree = allListDAO.getListOfMasterDegree();
													for (MasterDegreeBean m : listOfMasterDegree) {
														if(m.getMaster_degree().equalsIgnoreCase(employeeBean.getMaster_degree())){
												%>
													<option value="<%=m.getMaster_degree()%>" selected="selected"><%=m.getMaster_degree()%></option>
													<%}else{ %>
													<option value="<%=m.getMaster_degree()%>"><%=m.getMaster_degree()%></option>
													<%} %>
												<%
													
													}
												%>
										</select>
												
												<!-- <input type="text" class="form-control"
												name="master_degree" value=""> -->
									</div>
									<!-- /.col-lg-6 -->
									<div class="col-lg-3">
										<label style="margin-bottom: 0%; margin-top: 15px;">Nationality</label><br>
										<input type="text" class="form-control"
												name="nationality" value="<%=employeeBean.getNationality() %>" required>
							</div>
							<!-- /.col-lg-4 -->	
							
							
								<div class="col-lg-3">
										<label style="margin-bottom: 0%; margin-top: 15px;">CUG Number</label><br>
										<input type="text" class="form-control"
												name="cug_num" value="<%=employeeBean.getCug_num() %>" required>
							</div>
							<!-- /.col-lg-4 -->	
									
								</div>
								<!-- /.row -->
								   
								  
								  
								 <div class="row">
									<div class="col-lg-3">
									<div class="form-group">
										<label style="margin-bottom: 0%; margin-top: 15px;">ITI</label>
										
										<select class="form-control" name="iti_course"
											id="iti_course" >
												<option value="">-- ITI --</option>
												<%
													List<ITICourseBean> listOfITICourse = allListDAO.getListOfITICourse();
													for (ITICourseBean i : listOfITICourse) {
														if(i.getIti_course().equalsIgnoreCase(employeeBean.getIti_course())){
												%>
													<option value="<%=i.getIti_course()%>" selected="selected"><%=i.getIti_course()%></option>
													<%}else{ %>
													<option value="<%=i.getIti_course()%>"><%=i.getIti_course()%></option>
													<%} %>
												<%
													
													}
												%>
										</select>
										
										
										
										</div>
									</div>
									<!-- /.col-lg-4 -->
									
									<div class="col-lg-3">
									<div class="form-group">
										<label style="margin-bottom: 0%; margin-top: 15px;">Diploma</label><br>
												
										<select class="form-control" name="diploma_course"
											id="diploma_course">
												<option value="">-- Diploma --</option>
												<%
													List<DiplomaCourseBean> listOfDiplomaCourse = allListDAO.getListOfDiplomaCourse();
													for (DiplomaCourseBean d : listOfDiplomaCourse) {
														if(d.getDiploma_course().equalsIgnoreCase(employeeBean.getDiploma_course())){
												%>
													<option value="<%=d.getDiploma_course()%>" selected="selected"><%=d.getDiploma_course()%></option>
													<%}else{ %>
													<option value="<%=d.getDiploma_course()%>"><%=d.getDiploma_course()%></option>
													<%} %>
												<%
													
													}
												%>
										</select>
												
												</div>
									</div>
									<!-- /.col-lg-6 -->
									<div class="col-lg-6">
									<div class="form-group">
										<label style="margin-bottom: 0%; margin-top: 15px;">Special Interest</label><br>
										<input type="text" class="form-control"
												name="special_interest" value="<%=employeeBean.getSpecial_interest()%>" required>
												</div>
							
							</div>
							<!-- /.col-lg-4 -->	
									
								</div>
								<!-- /.row -->
						
								
							

                            </fieldset>
								
							
                            <!-- Step 2 -->
                            <h6>Step 2</h6>
                            <fieldset>
                            <% String panNo = "-";
                                    String addharNo = "-";
                                    String pf = "-";
                                    String uanNo = "-";
                                    String esicNo = "-";
                                    String bankAccNo = "-";
                                    String bankName = "-";
                                    String gradeCode = "-";
                                    String ifscCode = "-";
                                    
                                    if(employeeBean.getPan_no() != null) {
                                    	panNo = employeeBean.getPan_no();
                                    }
                                    if(employeeBean.getAdhar_no() != null){
                                    	addharNo = employeeBean.getAdhar_no();
                                    }
                                    if(employeeBean.getPf_uan_no() != null){
                                    	uanNo = employeeBean.getPf_uan_no();
                                    }
                                    if(employeeBean.getEsic_no() != null){
                                    	esicNo = employeeBean.getEsic_no();
                                    }
                                    if(employeeBean.getBank_name() != null){
                                    	bankName = employeeBean.getBank_name();
                                    }
                                    if(employeeBean.getBank_acount_no() != null){
                                    	bankAccNo = employeeBean.getBank_acount_no();
                                    }
                                    if(employeeBean.getGrade_code() != null){
                                    	gradeCode = employeeBean.getGrade_code() ;
                                    }
                                    if(employeeBean.getPf_no() != null){
                                    	pf = employeeBean.getPf_no() ;
                                    }
                                    if(employeeBean.getIfsc_code() != null){
                                    	ifscCode = employeeBean.getIfsc_code();
                                    }
                                    
                                    %> 
                              <input type="hidden" name="accountUpdate" value="">
                                 <div class="row">
                                    	<div class="col-md-6">
                                    		<label>PAN Card No.</label>
                                    		<input type="text" class="form-control"
												name="pan_no" value="<%=panNo %>" >
                                    	</div>
                                    	<div class="col-md-6">
                                    		<label>Adhaar Card No.</label>
                                    		<input type="text" class="form-control"
												name="adhar_no" id="adhar_no" value="<%=addharNo%>" onchange="adharCard(this.id);">
                                    	</div>
                                    </div>
                                    <br>
                                    
                                    <h5><b><u>PF/ESIC Details</u></b></h5>
                                    <div class="row">
                                    	<div class="col-md-6">
                                    		<label>PF No.</label>
                                    		<input type="text" class="form-control"
												name="pf_no" value="<%=pf%>" >
                                    	</div>
                                    	<div class="col-md-6">
                                    		<label>PF UAN No.</label>
                                    		<input type="text" class="form-control"
												name="pf_uan_no" value="<%=uanNo%>" >
                                    	</div>
                                    </div>
                                    <br>
                                    
                                   	<div class="row">
                                    	<div class="col-md-6">
                                    		<label>ESIC No.</label>
                                    		<input type="text" class="form-control"
												name="esic_no" value="<%=esicNo %>" >
                                    	</div>
                                    </div>
                                    <br>
                                    
                                    <h5><b><u>Bank Account Details</u></b></h5>
                                    <div class="row">
                                    	<div class="col-md-6">
                                    		<label>Bank Name</label>
                                    		<input type="text" class="form-control"
												name="bank_name" value="<%=bankName %>" >
                                    	</div>
                                    	<div class="col-md-6">
                                    		<label>IFSC Code</label>
                                    		<input type="text" class="form-control" id="ifsc_code"
												name="ifsc_code" value="<%=ifscCode%>" onchange="ifcsCode(this.id)">
                                    	</div>
                                    	
                                    	
                                    </div>
                                    <br>
                                    <div class="row">
                                    	<div class="col-md-6">
                                    		<label>Bank Account No.</label>
                                    		<input type="text" class="form-control"
												name="bank_acount_no" value="<%=bankAccNo %>" >
                                    	</div>
                                    	
                                    </div>
                            </fieldset>

                            <!-- Step 3 -->
                            <h6>Step 3</h6>
                            <fieldset>
                            <input type="hidden" id="row" placeholder="Enter Item Name" value="2" />
                            <div class="col-md-1" style="padding-right: 0px; padding-left: 0px;">
								<i class="icon icon-ios-plus" id="irow" style="cursor: pointer;font-size: 30px;" onclick="addValue();"></i>
							</div>
                                <table class="table table-bordered" id="mtable">
											<thead>
												<tr>
													<th>Sr No.</th>
													<th>Name</th>
													<th>Relation</th>
													<th>DOB</th>
													<th>Occupation</th>
													<th>Contact number</th>
													<th>Adhaar Card No.</th>
												</tr>
												
											</thead>
											<tbody>
											<% 
											int familyMenberCount = 0;
											List<FamilyDetailBean> listOfFamilyMember = allListDAO.getListOfFamilyMember(employee_master_id); 
											familyMenberCount =  listOfFamilyMember.size()+2 ;  
												for(int i = 0 ; i < listOfFamilyMember.size() ; i++){
													FamilyDetailBean f = listOfFamilyMember.get(i);
											%>
												<tr>
													<td><%=i+1 %><input type="hidden" name="family_detail_id" value="<%=f.getFamily_detail_id()%>"></td>
													<td><input type="text" class="form-control" name="name" value="<%=f.getName()%>"></td>
													<td>
													<select class="form-control" name="relation" id="relation">
														<option value="0">Select Relation</option>
															<%
																List<FamilyRelationBean> listOfFamilyRelation =  allListDAO.getListOfFamilyRelation();
																for(FamilyRelationBean r : listOfFamilyRelation){
																	if(r.getFamily_relation_id() == f.getFamilyRelationBean().getFamily_relation_id()){
		
															%>	
																<option value="<%=r.getFamily_relation_id()%>" selected="selected"><%=r.getRelation()%></option>
															<%}else{ %>	
																<option value="<%=r.getFamily_relation_id()%>"><%=r.getRelation()%></option>
															<%} %>
																
															<%}%>
													</select>
													</td>
													<td>
													
													<%
													String dob = null;
													try {
														  
														SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
														SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
														Date result = AppDateFormat.parse(f.getDob());
														dob = formater.format(result);
														
														
													} catch (ParseException e1) {
														e1.printStackTrace();
													}	
													%>
													
														<input type="text" class="form-control" name="dob" placeholder="dd-mm-yyyy" value="<%=dob%>">
													</td>
													<td><input type="text" class="form-control" name="occupation" value="<%=f.getOccupation()%>"></td>
													<td><input type="text" class="form-control" name="contact_number" value="<%=f.getContact_number()%>"></td>
													<td><input type="text" class="form-control" name="adhaar_number" value="<%=f.getAdhaar_number()%>" onchange="adharCard(this.id);"></td>
													<input type="hidden" name="update">
												</tr>
											<%} %>
											
											
											<tr>
													<td><%=listOfFamilyMember.size()+1 %></td>
													<td><input type="text" class="form-control" name="name"></td>
													<td>
														<select class="form-control" name="relation" id="relation">
														<option value="0">-Relation-</option>
															<%
																List<FamilyRelationBean> listOfFamilyRelation =  allListDAO.getListOfFamilyRelation();
																for(FamilyRelationBean r : listOfFamilyRelation){
		
															%>		
																<option value="<%=r.getFamily_relation_id()%>"><%=r.getRelation()%></option>
															<%}%>
													</select>
													</td>
													<td><input type="text" class="form-control" placeholder="dd-mm-yyyy" name="dob"></td>
													<td><input type="text" class="form-control" name="occupation"></td>
													<td><input type="text" class="form-control" name="contact_number"></td>
													<td><input type="text" class="form-control" name="adhaar_number" id="adhaar_number" onchange="adharCard(this.id);"></td>
													<input type="hidden" name="insert">
												</tr>
											</tbody>
										</table>

                            </fieldset>

                        </form>
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
    <script src="app-assets/vendors/js/extensions/jquery.steps.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/pickers/daterange/daterangepicker.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/forms/validation/jquery.validate.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/extensions/sweet-alerts.min.js" type="text/javascript"></script>
     <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- <script src="app-assets/js/scripts/forms/wizard-steps.min.js" type="text/javascript"></script> -->
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
	var colCount = 1;
	var count = <%=familyMenberCount%>;
	function addValue(){
	    if($('#row').val()){
	        $('#mtable tbody').append($("#mtable tbody tr:last").clone());
	        $('#mtable tbody tr:last :checkbox').attr('checked',false);
	        $('#mtable tbody tr:last td:first').html($('#row').val());
	        count++;
	        document.getElementById("row").value=count;
	    }else{alert('Enter Text');}
	};
	
	</script>
	
	 <script src="app-assets/js/scripts/forms/wizard-steps.min.js" type="text/javascript"></script>
	 
</body>
</html>