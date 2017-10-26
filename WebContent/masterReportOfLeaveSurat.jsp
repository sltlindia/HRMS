<%@page import="com.hrms.lms.util.DBConnection"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hrms.pms.bean.EmployeeStatusBean"%>
<%@page import="com.hrms.recruitement.dao.DepartmentDAO"%>
<%@page import="com.hrms.pms.bean.DepartmentBean"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="com.hrms.pms.bean.RoleBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%String fromDate = "2017-08-01";
String toDate = "2017-08-31"; %>
<title>Test Data(<%=fromDate%> to <%=toDate%>)</title>
<link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />

<%@include file="header.jsp"%>
</head>
<body>
<%int role_id = user.getRoleBean().getRole_id();
int manager_id = user.getManagerBean().getManager_id();
String authority = user.getRoleBean().getRole_authority();

Connection conn = null;
	Statement smt;
ResultSet rs = null;
	conn = DBConnection.getConnection();
	

AllLMSListDAO allListDAO = new AllLMSListDAO();
int dept_id = 0;
if(request.getParameter("dept_id") != null){
	dept_id = Integer.parseInt(request.getParameter("dept_id"));
}else{
	dept_id = 1;
}

String status = "approved";
%>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Employee Leave/CO/OD List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<%if(request.getAttribute("success") !=null) {%>
		 		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-success">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${success}
                            </div>
          		</div>  
          		<%}%>
 		    <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                          Employee Leave List
                        </div>
                        
				<div class="panel-body">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered" id="datatable-buttons">
                                    <thead>
                                        <tr>
                                        	<th></th>
                                            <th>LeaveType</th>
                                            <th>Emp Id</th>
                                            <th></th>
                                            <th>Company Code</th>
                                            <th>AMS Name</th>
                                            <th>Emp Code</th>
                                            <th>HRMS Name</th>
                                            <th>Location</th>
                                            <th>From_Date</th>
                                            <th>To_Date</th>
                                            <th></th>
                                        	<th>Approval_Date</th>   
											<th>Approval_By</th>
											<th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                 
                                 
                                   <% 
                                   String leave = "leave";
                                  if(leave.equalsIgnoreCase("leave")){
                                	  
                                   List<LeaveBean> getemployeeList  = null;
                                   getemployeeList = allListDAO.getAllPlanLeaveForExcel(fromDate,toDate,status);
                                	   String apdate = null, start_date = null, end_date = null;
                                	  
                                	   int empcode = 0;
                                	   String company_code = null;                              	   
									for (int i = 0; i<getemployeeList.size(); i++) {
										
										System.out.println("leave");
										
										
										LeaveBean e = getemployeeList.get(i);
										 empcode =  e.getEmployeeBean().getEmployee_code();
										start_date =e.getLeave_From();
										end_date = e.getLeave_To();
										company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
										apdate = e.getApproval_rejected_date();
										SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");
										
										Date result1 = formater1.parse(apdate);
										Date result2 = formater3.parse(start_date);
										Date result3 = formater3.parse(end_date);
										
										
										//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
										
										
										apdate = formater2.format(result1);
										start_date = formater2.format(result2);
										end_date = formater2.format(result3);
										int em = 0;
										String name = null;
										if(conn != null)
										{
                  			 			smt = conn.createStatement();
                             
                  			 
                  						smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where Emp_Code = "+ empcode +" and  Code = '"+company_code+"'");
                         		   			rs = smt.getResultSet();
                           			 while (rs.next())
                           				{
                         				  System.out.println("Emp Master Id " + rs.getString(1));
                         					 em = Integer.parseInt(rs.getString(1));
                         					 name = rs.getString(9);
                           				 } 
										if(em == 0){
									    %>                                    
                                        <tr align="Center">
                                        <td></td>
                                        <td>1</td>
                                       	<td><%=em%></td>
                                       	<td>Null</td>
                                       
                                       	<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code() %></td>
                                       	<td><%=name%></td>
                                       	<td><%=e.getEmployeeBean().getEmployee_code()%></td>
                                       	<td><%=e.getEmployeeBean().getFirstname()+ " "+e.getEmployeeBean().getMiddlename()+" "+e.getEmployeeBean().getLastname() %></td>
                                       	<td><%=e.getEmployeeBean().getLocation()%></td>
                                       
                                       	<td>
                                       	<%= start_date  %>
                                       	</td>
                                       	<td>
                                       	<%= end_date  %>
                                       	</td>	
                                       	<td></td>
                                       	<td>
                                       	<%= apdate %>
                                      </td>
                                      <td>
                                       	1041
                                      </td>
                                      <td>Null</td>
                                        </tr>
                                        <%}} }} %>
                                        
                                        
                                        
                                        <% 
                                        if(leave.equalsIgnoreCase("leave")){
                                   List<LeaveBean> getemployeeList  = null;
                                   getemployeeList = allListDAO.getAllUnPlanLeaveForExcel(fromDate,toDate,status);
                                	   String apdate = null, start_date = null, end_date = null;
                                	  
                                	   int empcode = 0;
                                	   String company_code = null;                              	   
									for (int i = 0; i<getemployeeList.size(); i++) {
										
										System.out.println("unleave");
										
										LeaveBean e = getemployeeList.get(i);
										 empcode =  e.getEmployeeBean().getEmployee_code();
										start_date =e.getLeave_From();
										end_date = e.getLeave_To();
										company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
										apdate = e.getApproval_rejected_date();
										SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");
										
										Date result1 = formater1.parse(apdate);
										Date result2 = formater3.parse(start_date);
										Date result3 = formater3.parse(end_date);
										
										
										//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
										
										
										apdate = formater2.format(result1);
										start_date = formater2.format(result2);
										end_date = formater2.format(result3);
										int em = 0;
										String name = null;
										if(conn != null)
										{
                  			 			smt = conn.createStatement();
                             
                  			 
                  						smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where Emp_Code = "+ empcode +" and  Code = '"+company_code+"'");
                         		   			rs = smt.getResultSet();
                           			 while (rs.next())
                           				{
                         				  System.out.println("Emp Master Id " + rs.getString(1));
                         					 em = Integer.parseInt(rs.getString(1));
                         					 name = rs.getString(9);
                           				 } 
                           			 if(em == 0){
									    %>                                    
                                        <tr align="Center">
                                        <td></td>
                                        <td>2</td>
                                       	<td><%=em%></td>
                                       	<td>Null</td>
                                       	<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code() %></td>
                                       	<td><%=name%></td>
                                       	<td><%=e.getEmployeeBean().getEmployee_code()%></td>
                                       	<td><%=e.getEmployeeBean().getFirstname()+ " "+e.getEmployeeBean().getMiddlename()+" "+e.getEmployeeBean().getLastname() %></td>
                                        <td><%=e.getEmployeeBean().getLocation()%></td>
                                       	<td>
                                       	<%= start_date  %>
                                       	</td>
                                       	<td>
                                       	<%= end_date  %>
                                       	</td>	
                                       	<td></td>
                                       	<td>
                                       	<%= apdate %>
                                      </td>
                                      <td>
                                       	1041
                                      </td>
                                      <td>Null</td>
                                        </tr>
                                        <%}}}}%>
                                        
                                        
                                        
                                         <% 
                                        if(leave.equalsIgnoreCase("leave")){
                                   List<LeaveBean> getemployeeList  = null;
                                   getemployeeList = allListDAO.getAllHalfLeaveForExcel(fromDate,toDate,status);
                                	   String apdate = null, start_date = null, end_date = null;
                                	  
                                	   int empcode = 0;
                                	   String company_code = null;                              	   
									for (int i = 0; i<getemployeeList.size(); i++) {
										
										System.out.println("halfleave");
										
										LeaveBean e = getemployeeList.get(i);
										 empcode =  e.getEmployeeBean().getEmployee_code();
										start_date =e.getLeave_From();
										end_date = e.getLeave_To();
										company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
										apdate = e.getApproval_rejected_date();
										SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");
										
										Date result1 = formater1.parse(apdate);
										Date result2 = formater3.parse(start_date);
										Date result3 = formater3.parse(end_date);
										
										
										//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
										
										
										apdate = formater2.format(result1);
										start_date = formater2.format(result2);
										end_date = formater2.format(result3);
										int em = 0;
										String name = null;
										if(conn != null)
										{
                  			 			smt = conn.createStatement();
                             
                  			 
                  						smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where Emp_Code = "+ empcode +" and  Code = '"+company_code+"'");
                         		   			rs = smt.getResultSet();
                           			 while (rs.next())
                           				{
                         				  System.out.println("Emp Master Id " + rs.getString(1));
                         					 em = Integer.parseInt(rs.getString(1));
                         					 name = rs.getString(9);
                           				 } 
                           			 if(em == 0){
									    %>                                    
                                        <tr align="Center">
                                        <td></td>
                                        <td>6</td>
                                       	<td><%=em%></td>
                                       	<td>Null</td>
                                       	
                                       	
                                       	<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code() %> (<%=e.getFrom_half()%>) (<%=e.getTo_half() %>) (<%=e.getDay_count()%>)</td>
                                       	<td><%=name%></td>
                                       	<td><%=e.getEmployeeBean().getEmployee_code()%></td>
                                       	<td><%=e.getEmployeeBean().getFirstname()+ " "+e.getEmployeeBean().getMiddlename()+" "+e.getEmployeeBean().getLastname() %></td>
                                        <td><%=e.getEmployeeBean().getLocation()%></td>
                                      
                                       	<td>
                                       	<%= start_date  %>
                                       	</td>
                                       	<td>
                                       	<%= end_date  %>
                                       	</td>	
                                       	<td></td>
                                       	<td>
                                       	<%= apdate %>
                                      </td>
                                      <td>
                                       	1041
                                      </td>
                                      <td>Null</td>
                                        </tr>
                                        <%}}}}%>
                                        
                                        
                                        
                                       <% 
                                       if(leave.equalsIgnoreCase("leave")){   
                                   String Co_StartDate = null;
                                   List<LeaveCOBean> getemployeeList1  = null;
                                	   getemployeeList1 = allListDAO.getAllFullCOForExcel(fromDate,toDate,status);
                                	   
                     
                                	  int empcode1 = 0;
                                	  String company_code = null;
									for (int i = 0; i< getemployeeList1.size(); i++) {
									
										System.out.println("fulllco");
										
										LeaveCOBean e = getemployeeList1.get(i);
										Co_StartDate = e.getCO_date();
										SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
										Date result1 = formater1.parse(Co_StartDate);
										
										empcode1 =  e.getEmployeeBean().getEmployee_code();
										company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
										
										
										//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
										Co_StartDate = formater2.format(result1);
										
										int em1 = 0;
										String name = null;
										if(conn != null)
										{
                  			 			smt = conn.createStatement();
                             
                  			 
                  						smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where EMP_CODE = "+ empcode1 +" and  CODE = '"+company_code+"'");
                         		   			rs = smt.getResultSet();
                           			 while (rs.next())
                           				{
                         				  System.out.println("Emp Master Id " + rs.getString(1));
                         					 em1 = Integer.parseInt(rs.getString(1));
                         					 name = rs.getString(9);
                           				 } 
										
										
                           			 if(em1 == 0){
										
										
									%>
                                    
                                        <tr align="Center">
                                        <td></td>
                                        <td>3</td>
                                       	<td><%=em1%></td>
                                       	<td>Null</td>
                                       	
                                       	<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code() %></td>
                                       	<td><%=name%></td>
                                       	<td><%=e.getEmployeeBean().getEmployee_code()%></td>
                                        <td><%=e.getEmployeeBean().getFirstname()+ " "+e.getEmployeeBean().getMiddlename()+" "+e.getEmployeeBean().getLastname() %></td>
                                        <td><%=e.getEmployeeBean().getLocation()%></td>
                                      
                                      
                                      
                                       	<td>
                                       	<%= Co_StartDate %>
                                       	</td>
                                       	<td>
                                       	<%= Co_StartDate %>
                                       	</td>
                                       	<td></td>
                                       	<td>
                                       	<%= Co_StartDate %>
                                      </td>
                                      <td>
                                       	1041
                                      </td>
                                      <td>Null</td>
                                        </tr>
                                        
                                        
                                        
                                        <%}} }}%>
                                        
                                        
                                        
                                          <% 
                                       if(leave.equalsIgnoreCase("leave")){   
                                   String Co_StartDate = null;
                                   List<LeaveCOBean> getemployeeList1  = null;
                                	   getemployeeList1 = allListDAO.getAllHalfCOForExcel(fromDate,toDate,status);
                                	   
                     
                                	  int empcode1 = 0;
                                	  String company_code = null;
									for (int i = 0; i< getemployeeList1.size(); i++) {
										
										System.out.println("half co");
									
										LeaveCOBean e = getemployeeList1.get(i);
										Co_StartDate = e.getCO_date();
										SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
										Date result1 = formater1.parse(Co_StartDate);
										
										empcode1 =  e.getEmployeeBean().getEmployee_code();
										company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
										
										
										//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
										Co_StartDate = formater2.format(result1);
										
										int em1 = 0;
										String name = null;
										if(conn != null)
										{
                  			 			smt = conn.createStatement();
                             
                  			 
                  						smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where EMP_CODE = "+ empcode1 +" and  CODE = '"+company_code+"'");
                         		   			rs = smt.getResultSet();
                           			 while (rs.next())
                           				{
                         				  System.out.println("Emp Master Id " + rs.getString(1));
                         					 em1 = Integer.parseInt(rs.getString(1));
                         					 name = rs.getString(9);
                           				 } 
										
                           			if(em1 == 0){
									%>
                                    
                                        <tr align="Center">
                                        <td></td>
                                        <td>7</td>
                                       	<td><%=em1%></td>
                                       	<td>Null</td>
                                       	
                                       	<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code() %></td>
                                       	<td><%=name%></td>
                                       	<td><%=e.getEmployeeBean().getEmployee_code()%></td>
                                        <td><%=e.getEmployeeBean().getFirstname()+ " "+e.getEmployeeBean().getMiddlename()+" "+e.getEmployeeBean().getLastname() %></td>
                                       	<td><%=e.getEmployeeBean().getLocation()%></td>
                                       	
                                       	<td>
                                       	<%= Co_StartDate %>
                                       	</td>
                                       	<td>
                                       	<%= Co_StartDate %>
                                       	</td>
                                       	<td></td>
                                       	<td>
                                       	<%= Co_StartDate %>
                                      </td>
                                      <td>
                                       	1041
                                      </td>
                                      <td>Null</td>
                                        </tr>
                                        <%}} }}%>
                                        
                                        
                                        
                                        <% 
                                   if(leave.equalsIgnoreCase("leave")){
                                  	String OD_StartDate = null, OD_EndDate = null;
                                   List<LeaveODBean> getemployeeList2  = null;
                                	   getemployeeList2 = allListDAO.getAllODForExcel(fromDate,toDate,status);
                                	   int empcode2 = 0;
                                	   String company_code = null; 
									for (int i = 0; i < getemployeeList2.size(); i++) {
										
										
										System.out.println("OD");
									
										LeaveODBean e = getemployeeList2.get(i);
										OD_StartDate = e.getOD_StartDate();
										OD_EndDate = e.getOD_EndDate();
										SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
										Date result1 = formater1.parse(OD_StartDate);
										Date result2 = formater1.parse(OD_EndDate);
										
										
										//SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat formater2 = new SimpleDateFormat("MM/dd/yyyy 0:00");
										OD_StartDate = formater2.format(result1);
										OD_EndDate = formater2.format(result2);
										
										 empcode2 = e.getEmployeeBean().getEmployee_code();
										 company_code = e.getEmployeeBean().getCompanyListBean().getCompany_code();
										 int em2 = 0;
										 String name = null;
										if(conn != null)
										{
                  			 			smt = conn.createStatement();
                             
                  			 
                  			 			smt.executeQuery("SELECT * from FingerTec_TimeTrack.dbo.Emp_Master where EMP_CODE = "+ empcode2 +" and  CODE = '"+company_code+"'");
                         		   			rs = smt.getResultSet();
                           			  while (rs.next())
                           				{
                         				  System.out.println("Emp Master Id " + rs.getString(1));
                         					 em2 = Integer.parseInt(rs.getString(1));
                         					name = rs.getString(9);
                           				 } 
										 
										
										
                           			if(em2 == 0){

									%>
                                    
                                        <tr align="Center">
                                        <td></td>
                                        <td>4</td> 
                                       	<td><%=em2%></td>
                                       	<td>Null</td>
                                       	
                                       	
                                       	<td><%=e.getEmployeeBean().getCompanyListBean().getCompany_code() %></td>
                                       	<td><%=name%></td>
                                       	<td><%=e.getEmployeeBean().getEmployee_code()%></td>
                                        <td><%=e.getEmployeeBean().getFirstname()+ " "+e.getEmployeeBean().getMiddlename()+" "+e.getEmployeeBean().getLastname() %></td>
                                     	<td><%=e.getEmployeeBean().getLocation()%></td>
                                     	
                                     	
                                     
                                       	<td>
                                       	<%= OD_StartDate %>
                                       	</td>
                                       	<td>
                                       	<%= OD_EndDate %>
                                       	</td>
                                       	<td></td>
                                       	<td>
                                       	<%= OD_StartDate %>
                                      </td>
                                      <td>
                                       	1041
                                      </td>
                                      <td>Null</td>
                                        </tr>
                                        <%}}}}%>
                                        
                                    </tbody>
                                    
                                   
	
                                </table>
                                
                            </div>
                            <!-- /.table-responsive -->
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
</div>
	
</div>    
<script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
  <!--   <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script> -->

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
   <!--  <script>
    $(document).ready(function() {
       /*  $('#dataTables-example').DataTable({
                responsive: true
        }); */
        $('#dataTables-example1').DataTable({
            responsive: true
    });
        $('#dataTables-example2').DataTable({
            responsive: true
    });
    });
    </script> -->
    
     <script src="js/datatables/jquery.dataTables.min.js"></script>
        <script src="js/datatables/dataTables.bootstrap.js"></script>
        <script src="js/datatables/dataTables.buttons.min.js"></script>
        <script src="js/datatables/buttons.bootstrap.min.js"></script>
        <script src="js/datatables/jszip.min.js"></script>
        <script src="js/datatables/pdfmake.min.js"></script>
        <script src="js/datatables/vfs_fonts.js"></script>
        <script src="js/datatables/buttons.html5.min.js"></script>
        <script src="js/datatables/buttons.print.min.js"></script>
        <script src="js/datatables/dataTables.responsive.min.js"></script>
    
      <script src="js/pace/pace.min.js"></script>
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
        
         <script>
          var handleDataTableButtons1 = function() {
              "use strict";
              0 !== $("#datatable-buttons1").length && $("#datatable-buttons1").DataTable({
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
            TableManageButtons1 = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons1()
                }
              }
            }();
        </script>
        
         <script>
          var handleDataTableButtons2 = function() {
              "use strict";
              0 !== $("#datatable-buttons2").length && $("#datatable-buttons2").DataTable({
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
            TableManageButtons2 = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons2()
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
          TableManageButtons1.init()
          TableManageButtons2.init()
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