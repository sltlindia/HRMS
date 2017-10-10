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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>CUG List</title>
    <link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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
     <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <!-- END Custom CSS-->

<%@include file="header.jsp"%>
<script>
		$(document).ready(function() {
			$(".hidden").hide();
		});
	</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%int role_id = user.getRoleBean().getRole_id();
int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
String authority = user.getRoleBean().getRole_authority();
int manager_id = user.getManagerBean().getManager_id();
AllListDAO allListDAO = new AllListDAO();
int dept_id = 3;
if(request.getParameter("dept_id") != null){
	dept_id = Integer.parseInt(request.getParameter("dept_id"));
}
%>
	

    <!-- navbar-fixed-top-->
    
    

    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-body"><!-- DOM - jQuery events table -->
<!-- File export table -->
<section id="file-export">
    <div class="row">
        <div class="col-xs-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Department Wise Employee List</h4>
                    <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                    <div class="heading-elements">
                        <ul class="list-inline mb-0">
                            <li><a data-action="collapse"><i class="icon-m	inus4"></i></a></li>
                            <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        </ul>
                    </div>
                </div>
                        
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
                 <div class="card-body collapse in">
                    <div class="card-block card-dashboard">
                        <div class="table-responsive">
                                <table class="table table-striped table-bordered file-export">
                                    <thead>
                                        <tr>
                                        	<th>No.</th>
                                            <th>Employee Name</th>
                                            <th>Employee Code</th>
                                            <th>Company Name</th>
                                            <th class="hidden">Department</th>
                                            <th class="hidden">Sub Department</th>
                                            <th class="hidden">Reporting Manager</th>
                                            <th>Designation</th>
                                            <th>Action</th>
                                            <th class="hidden">Grade Code</th>
                                            <th class="hidden">Birth Date</th>
                                            <th class="hidden">Gender</th>
                                            <th class="hidden">Marital Status</th>
                                            <th class="hidden">Address</th>
                                            <th class="hidden">Languages</th>
                                            <th class="hidden">Mobile No</th>
                                            <th class="hidden">CUG No.</th>
                                            <th class="hidden">Personal Email Id</th>
                                            <th class="hidden">Official Email Id</th>
                                            <th class="hidden">Pan No</th>
                                            <th class="hidden">PF No</th>
                                            <th class="hidden">PF UAN No</th>
                                            <th class="hidden">ESCI No</th>
                                            <th class="hidden">Bank Name</th>
                                            <th class="hidden">Bank A/C No</th>
                                            <th class="hidden">Adhar No</th>
                                            <th class="hidden">Basic Qualification</th>
                                            <th class="hidden">Special Qualification</th>
                                            <th class="hidden">Graduate Degree</th>
                                            <th class="hidden">Master Degree</th>
                                            <th class="hidden">Joining Date</th>
                                            <th class="hidden">Location</th>
                                            <th class="hidden">Employee Status</th>
                                            
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
                                    
                                        <tr class="emp<%=e.getEmployee_master_id()%>">
										<td><%=i+1 %></td>                                        
                                        <td><%=e.getFirstname()+" "+e.getMiddlename() +" "+ e.getLastname() %></td> 
                                       	<td><%=e.getEmployee_code() %></td>
                                       	 <td><%=e.getCompanyListBean().getCompany_name()%></td>
                                       	<td class="hidden"><%=e.getDepartmentBean().getDepartment_name() %></td> 
                                       	<td class="hidden"><%=e.getSub_department() %></td>
                                       	<%int under_manager_id1 =Integer.parseInt(e.getUnder_manager_id());
                                       	LoginDAO loginDAO = new LoginDAO();
                                       	String name = "";
                                       	if(under_manager_id1 != 0 && under_manager_id1 != 99 && under_manager_id1 != 200 && under_manager_id1 != 201 ){
        								EmployeeBean employeeBean1 = loginDAO.getEmailId(under_manager_id1);
        								name = employeeBean1.getFirstname()+" "+employeeBean1.getLastname();
                                       	}
                                       	%>
                                       	<td class="hidden"><%=name%></td>
                                       	<td><%=e.getRoleBean().getRole_type() %></td>
                                       	<td>
                                       	 <%if( manager_id == 4 || manager_id == 117 || under_manager_id == 4 || under_manager_id == 117){ %>
                                     	<a href="employeeUpdate.jsp?employee_master_id=<%=e.getEmployee_master_id()%>"><i class="icon-edit2" data-toggle="tooltip" data-placement="top" title="Show View" style="color: #3BAFDA"></i></a>
										<i class="ficon icon-trash-o" data-toggle="tooltip" data-placement="top" title="Delete Employee" style="color: red;cursor: pointer;" onclick="deleteEmp(<%=e.getEmployee_master_id()%>)"></i>
                                        <%} %>
                                        </td>
                                       	<td class="hidden"><%=e.getGrade_code() %></td>
                                        <td class="hidden"><%=e.getBirth_date() %></td>
                                      
                                       
                                        <td class="hidden"><%=e.getGender() %></td>
                                        <td class="hidden"><%=e.getMarital_status() %></td>
                                        <td class="hidden"><%=e.getAdress() %></td>
                                        <td class="hidden"><%=e.getLanguages() %></td>
                                        <td class="hidden"><%=e.getMob_num() %></td>
                                        <td class="hidden"><%=e.getCug_num() %></td>
                                        
                                        
                                        <td class="hidden"><%=e.getPer_emailid() %></td>
                                        <td class="hidden"><%=e.getEmail_id() %></td>
                                        <td class="hidden"><%=e.getPan_no() %></td>
                                        <td class="hidden"><%=e.getPf_no() %></td>
                                        <td class="hidden"><%=e.getPf_uan_no() %></td>
                                        <td class="hidden"><%=e.getEsic_no() %></td>
                                        <td class="hidden"><%=e.getBank_name() %></td>
                                        <td class="hidden"><%=e.getBank_acount_no() %></td>
                                        <td class="hidden"><%=e.getAdhar_no() %></td>
                                        
                                        
                                        
                                        <td class="hidden"><%=e.getBasic_qualification() %></td>
                                        <td class="hidden"><%=e.getSpecial_qualification() %></td>
                                        <td class="hidden"><%=e.getGraduate_degree() %></td>
                                        <td class="hidden"><%=e.getMaster_degree() %></td>
                                        
                                       	
                                       	
                                       	<td class="hidden"><%=e.getJoining_date() %></td>
                                       	
                                       	<td class="hidden"><%=e.getLocation()%></td>
                                       	
                                       	
                                       	<td class="hidden">
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
</section>
</div>
</div>
</div>

 <%@include file="footer.html"%>

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
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/gallery/photo-swipe/photoswipe-ui-default.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    
    
     
  
   
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
     <script src="app-assets/js/scripts/extensions/sweet-alerts.min.js" type="text/javascript"></script>
     <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    
    <!-- END PAGE VENDOR JS-->
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
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
	function deleteEmp(id) {
		 $.ajax({
	    	    method: "POST",
	    	    url: 'employeeDelete',
	    	    data: {employee_dummy_id:id},
	    	    success: function (data) {
	    	    	if(data == 'success'){
	    	    	swal("SUCCESS!","Successfully Saved Data!","success")
	    	    	$(".emp"+id).fadeOut();
	    	    	}else{
	    	    		swal("Error!","Some Error occured !","error")
	    	    	}
	    	    }
	    	});
	}
	</script>
</body>
</html>