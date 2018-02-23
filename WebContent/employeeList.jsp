<%@page import="com.hrms.pms.bean.EmployeeStatusBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
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
    <title>Employee List</title>
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
    <link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
<%@include file="header.jsp"%>
<script>
		$(document).ready(function() {
			$(".hidden").hide();
		});
	</script>
</head>
<body>
<%int role_id = user.getRoleBean().getRole_id();
int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
String authority = user.getRoleBean().getRole_authority();
int manager_id = user.getManagerBean().getManager_id();
AllListDAO allListDAO = new AllListDAO();
int dept_id = 0;
if(request.getParameter("dept_id") != null){
	dept_id = Integer.parseInt(request.getParameter("dept_id"));
}
%>
	<div class="app-content container center-layout mt-2">
	
	<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				
				<!-- /.col-lg-12 -->
			
			<br>
						<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">&nbsp;Department Wise Employee List</h4>
				               		
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">	
			
			<%if(request.getAttribute("success") !=null) {%>
		 		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-success">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${success}
                            </div>
          		</div>  
          		<%}%>
			
<div class="panel-body">
<%if( manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){ %>
<form action="employeeList.jsp" method="get">                        
<table class="table">
<tr>
<th>Select Department</th>
<td>:</td>
<td>
	<select class="form-control" name="dept_id" >
	<option value="">---Select Department---</option>
	<%if(dept_id == 0){ %>
	<option value="0" selected="selected">All Department</option>
	<%}else{ %>
	<option value="0">All Department</option>
	<%} %>
	<%List<DepartmentBean> listOfDepartment = allListDAO.getListOfDepartment(); 
	for(DepartmentBean d : listOfDepartment){
		if(d.getDepartment_id() != 0){
			if(d.getDepartment_id() == dept_id){
	%>
	<option value="<%=d.getDepartment_id()%>" selected="selected"><%=d.getDepartment_name() %></option>
	<%}else{ %>
	<option value="<%=d.getDepartment_id()%>"><%=d.getDepartment_name() %></option>
	<%} %>
	<%} }%>
	</select>
	</td>
	<td><input type="submit" name="submit" class="btn btn-primary" value="SUBMIT"></td>
	</tr>
</table> 
</form>
<%} %>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                             <div class="table-responsive">
                                <table class="table table-striped table-bordered" id="datatable-buttons">
                                    <thead>
                                        <tr>
                                        	<th>No.</th>
                                            <th>Employee Name</th>
                                            <th>Employee Code</th>
                                            <th>Department</th>
                                            <th>Sub Department</th>
                                            <th>Reporting Manager</th>
                                             <th>Action</th>
                                            <th>Designation</th>
                                            <th>Grade Code</th>
                                            <th>Birth Date</th>
                                            <th>Company Name</th>
                                            <th>Gender :</th>
                                            <th>Marital Status :</th>
                                            <th>Address :</th>
                                            <th>Languages</th>
                                            <th>Mobile No :</th>
                                            <th>CUG No. :</th>
                                            <th>Personal Email Id :</th>
                                            <th>Official Email Id :</th>
                                            <th>Pan No :</th>
                                            <th>PF No :</th>
                                            <th>PF UAN No :</th>
                                            <th>ESCI No :</th>
                                            <th>Bank Name : </th>
                                            <th>Bank A/C No :</th>
                                            <th>Adhar No :</th>
                                            <th>Basic Qualification</th>
                                            <th>Special Qualification</th>
                                            <th>Graduate Degree</th>
                                            <th>Master Degree</th>
                                            <th>Joining Date :</th>
                                            <th>Location :</th>
                                            <th>Employee Status :</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                   <% 
                                   
                                   List<EmployeeBean> getemployeeList  = null;
                                   if(manager_id==1 || manager_id==2 || manager_id==3 || manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){
                                	 
                                	   if(dept_id == 0){
                                		   getemployeeList = allListDAO.getListOfAllEmployeeAllocation(); 
                                	   }else{
                                	   getemployeeList = allListDAO.getListOfEmployeeAllocationByDepartment(dept_id);
                                	   }
                                   }else{
                                	   getemployeeList = allListDAO.getListOfEmployeeAllocation(manager_id);
                                   }
									for (int i = 0;i<getemployeeList.size();i++) {
									
										EmployeeBean e = getemployeeList.get(i);
										
										System.out.println("id:"+e.getEmployee_master_id());
										System.out.println("u_id:"+e.getUnder_manager_id());
									%>
                                    
                                        <tr>
										<td><%=i+1 %></td>                                        
                                        <td><%=e.getFirstname()+" "+e.getMiddlename() +" "+ e.getLastname() %></td> 
                                       	<td><%=e.getEmployee_code() %></td>
                                       	<td><%=e.getDepartmentBean().getDepartment_name() %></td> 
                                       	<td><%=e.getSub_department() %></td>
                                       	<%int under_manager_id1 =Integer.parseInt(e.getUnder_manager_id());
                                       	LoginDAO loginDAO = new LoginDAO();
                                       	String name = "";
                                       	if(under_manager_id1 != 0 && under_manager_id1 != 99 && under_manager_id1 != 200 && under_manager_id1 != 201 ){
        								EmployeeBean employeeBean1 = loginDAO.getEmailId(under_manager_id1);
        								name = employeeBean1.getFirstname()+" "+employeeBean1.getLastname();
                                       	}
                                       	%>
                                       	<td><%=name%></td>
                                       	<td>
                                       	 <%if( manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){ %>
                                     	<a href="employeeUpdate.jsp?employee_master_id=<%=e.getEmployee_master_id()%>"><i class="icon-edit2" data-toggle="tooltip" data-placement="top" title="Show View"></i></a>
											<a href="employeeDelete?employee_dummy_id=<%=e.getEmployee_master_id()%>"><i class="icon-trash2" data-toggle="tooltip" data-placement="top" title="Delete Employee" style="color: #337ab7"></i></a>
                                        <%} %>
                                        </td>
                                       	<td><%=e.getRoleBean().getRole_type() %></td>
                                       		
                                       	<td><%=e.getGrade_code() %></td>
                                        <td><%=e.getBirth_date() %></td>
                                      
                                        
                                        
                                        <td><%=e.getCompanyListBean().getCompany_name()%></td>
                                        <td><%=e.getGender() %></td>
                                        <td><%=e.getMarital_status() %></td>
                                        <td><%=e.getAdress() %></td>
                                        <td><%=e.getLanguages() %></td>
                                        <td><%=e.getMob_num() %></td>
                                        <td><%=e.getCug_num() %></td>
                                        
                                        
                                        <td><%=e.getPer_emailid() %></td>
                                        <td><%=e.getEmail_id() %></td>
                                        <td><%=e.getPan_no() %></td>
                                        <td><%=e.getPf_no() %></td>
                                        <td><%=e.getPf_uan_no() %></td>
                                        <td><%=e.getEsic_no() %></td>
                                        <td><%=e.getBank_name() %></td>
                                        <td><%=e.getBank_acount_no() %></td>
                                        <td><%=e.getAdhar_no() %></td>
                                        
                                        
                                        
                                        <td><%=e.getBasic_qualification() %></td>
                                        <td><%=e.getSpecial_qualification() %></td>
                                        <td><%=e.getGraduate_degree() %></td>
                                        <td><%=e.getMaster_degree() %></td>
                                        
                                       	
                                       	
                                       	<td><%=e.getJoining_date() %></td>
                                       	
                                       	<td><%=e.getLocation()%></td>
                                       	
                                       	
                                       	<td>
                                       	<%if(e.getEmployeeStatusBean().getEmployee_status_id() == 1) {%>
                                       	<font color="green"><b><%=e.getEmployeeStatusBean().getEmployee_status_name() %></b></font></td>
                                       	<%}else if(e.getEmployeeStatusBean().getEmployee_status_id() == 2){%>
                                       		<font color="blue"><b><%=e.getEmployeeStatusBean().getEmployee_status_name() %></b></font></td>
                                       	<%}else if(e.getEmployeeStatusBean().getEmployee_status_id() == 3){%>
                                       		<font color="red"><b><%=e.getEmployeeStatusBean().getEmployee_status_name() %></b></font></td>
                                       	<%} %>
                                       
                                       
                                       
                                        </tr>
                                        
                                        
                                        
                                        
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
                            <!-- /.table-responsive -->
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
		</section>
</div>
	
							<%-- <%for (int i = 0;i<getemployeeList.size();i++) {
									
										EmployeeBean e1 = getemployeeList.get(i);
										int emp_id = e1.getEmployee_master_id();
										%>
								 <div class="modal fade myModal<%=e1.getEmployee_master_id()%>" tabindex="-1" role="dialog" aria-hidden="true">
                  <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                        </button>
                                            <h4 class="modal-title" id="myModalLabel">Profie of <%=e1.getFirstname()+" "+e1.getLastname() %></h4>
                                        </div>
                                        <div class="panel-body">
                                        <div class="table-responsive">
									<table class="table table-hover table-bordered">
											<%List<EmployeeBean> getemployeeList1 = allListDAO.getListOfEmployeeById(emp_id);
											for (EmployeeBean e : getemployeeList1) {
												System.out.println("id1:"+e.getEmployee_master_id());
												
										%>


										<tr>
											<label><th>Firstname</th></label>
											<td>:</td>
											<td><%=e.getFirstname()%></td>

											<label><th>Middlename</th></label>
											<td>:</td>
											<td><%=e.getMiddlename()%></td>

											<label><th>Lastname</th></label>
											<td>:</td>
											<td><%=e.getLastname()%></td>
										</tr>

										<tr>
											<label><th>Employee Code</th></label>
											<td>:</td>
											<td><%=e.getEmployee_code()%></td>

											<label><th>Salutation</th></label>
											<td>:</td>
											<td><%=e.getSalutation()%></td>

											<label><th>Marital Status</th></label>
											<td>:</td>
											<td><%=e.getMarital_status()%></td>

										</tr>

										<tr>
											<label><th>Address</th></label>
											<td>:</td>
											<td colspan="7"><%=e.getAdress()%></td>
										</tr>
										<tr>
											<th><label>Joining Date</label></th>
											<td>:</td>
											<td><%=e.getJoining_date()%></td>
											<th><label>BirthDate</label></th>
											<td>:</td>
											<td><%=e.getBirth_date()%></td>
											<th>Department</th>
											</label>
											<td>:</td>
											<td><%=e.getDepartmentBean().getDepartment_name()%></td>
										</tr>
										<tr>
											<label><th>Sub Department</th></label>
											<td>:</td>
											<td><%=e.getSub_department()%></td>

											
											<label><th>Gender</th></label>
											<td>:</td>
											<td><%=e.getGender() %></td>
											<label><th>Gross Salary</th></label>
											<td>:</td>
											<td><%=e.getGross_salary()%></td>
										</tr>
										<tr>
											<label><th>Languages</th></label>
											<td>:</td>
											<td colspan="4"><%=e.getLanguages()%></td>
											<label><th>Blood Group</th></label>
											<td>:</td>
											<td><%=e.getBlood_group()%></td>
										</tr>

										<tr>
											<label><th>Height</th></label>
											<td>:</td>
											<td><%=e.getHeight()%></td>
											<label><th>Weight</th></label>
											<td>:</td>
											<td><%=e.getWeight()%></td>
											<label><th>Identification Marks</th></label>
											<td>:</td>
											<td><%=e.getIdentification_marks()%></td>
										</tr>

										<tr>
											<label><th>Company</th></label>
											<td>:</td>
											<td colspan="4"><%=e.getCompanyListBean().getCompany_name()%></td>
											<label><th>Location</th></label>
											<td>:</td>
											<td><%=e.getLocation()%></td>

										</tr>

										<tr>
											<th>Role</th>
											</label>
											<td>:</td>
											<td><%=e.getRoleBean().getRole_type() %></td>

											<th>Reporting Manager</th>
											</label>
											<td>:</td>
											<td><%int undermanager_id =Integer.parseInt(e.getUnder_manager_id());
												LoginDAO loginDAO = new LoginDAO();
												EmployeeBean employeeBean = loginDAO.getUserByManagerId(undermanager_id);
												if(undermanager_id == 0 || undermanager_id == 34 || undermanager_id == 37 || undermanager_id == 62 || undermanager_id == 58 || undermanager_id == 57 || undermanager_id == 44 || undermanager_id == 77 || undermanager_id == 70){
											%>
											No Reporting Manager
											<%}else{ %>
											<%=employeeBean.getFirstname()+" "+employeeBean.getLastname()%>
											<%} %>
											</td>

											<label><th>Resource Cost</th></label>
											<td>:</td>
											<td><%=e.getResource_cost()%></td>
										</tr>

										<tr>
											<label><th>Email-id</th></label>
											<td>:</td>
											<td colspan="4"><%=e.getEmail_id()%></td>
											<label><th>Mobile No.</th></label>
											<td>:</td>
											<td><%=e.getMob_num()%></td>

										</tr>
										<tr>
											<label><th>Nationality</th></label>
											<td>:</td>
											<td><%=e.getNationality()%></td>
											<label><th>Basic Qualification</th></label>
											<td>:</td>
											<td><%=e.getBasic_qualification()%></td>
											<label><th>Special Qualification</th></label>
											<td>:</td>
											<td colspan="4"><%=e.getSpecial_qualification()%></td>
										</tr>
									</table>
								</div>
								<%} %>
								</div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">CLOSE</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div> 
	
			<%} %> --%>
			  
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
        <script>
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#datatable-buttons").length && $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0	
              })
            },
            TableManageButtons = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons()
                }
              }
            }();
        </script>
        <script type="text/javascript">
          $(document).ready(function() {
            $('#datatable').dataTable();
            $('#datatable1').dataTable();
            $('#datatable-keytable').DataTable({
              keys: true
            });
            $('#datatable-responsive').DataTable();
            $('#datatable-scroller').DataTable({
              ajax: "js/datatables/json/scroller-demo.json",
              deferRender: true,
              scrollY: 380,
              scrollCollapse: true,
              scroller: true	
            });
            var table = $('#datatable-fixed-header').DataTable({
              fixedHeader: true
            });
          });
          TableManageButtons.init();
        </script>
    
    
    
     <script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>
</body>
</html>