<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="com.hrms.pms.bean.ManagerBean"%>
<%@page import="com.hrms.lms.bean.LeaveBalanceBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.bean.LeaveCancelRequestBean"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.hrms.lms.bean.LeaveODBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hrms.lms.bean.LeaveCOBean"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.lms.bean.LeavecutBalance"%>
<%@page import="com.hrms.lms.bean.LeaveTypeBean"%>
<%@page import="com.hrms.lms.bean.LeaveBean"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Status</title>
<%@include file="header.jsp" %>

<script type="text/javascript">

function redirect(value) {
	/* alert("test"); */
	window.location.replace(value);
}
</script>
		


</head>

<body>
<%
int userId = user.getEmployee_master_id();
//int employee_master_id = user.getEmployee_master_id();
ArrayList<String> holiday = new ArrayList<String>();
ArrayList<String> holidayName = new ArrayList<String>();
ArrayList<String> holidayDate = new ArrayList<String>();
System.out.print("Employee Master Id " + employee_master_id);
%>
<div id="page-wrapper">
	<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"> Leave / CO / OD Form </h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
					
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Leave / CO / OD Form
                        </div>
                        <div class="panel-body">
                        
                        <table class="table" style="margin-bottom: 0px;">
                        <thead>
	                        <tr>
								<td width="100px"><label>Select Form</label></td>
								<td width="10px">:</td>
								<td width="200px;">
									<select class="form-control" name="leavetypeselect" id="leavetypeselect" onchange="redirect(this.value);" required>
										<option>-- Select Form--</option>
										<option value="applyLeave.jsp">   Leave    </option>
										<option value="leaveCO.jsp">   	 CO       </option>
										<option value="leaveOD.jsp">      OD       </option>
									</select>
								</td>
								<td></td>
								<td></td>
							</tr>
                        </thead>
                        </table>
                        
                        </div>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
		</div>
	
</div>
  <script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	<script
		src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

	
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
     
     <!--END PAGE LEVEL SCRIPTS -->
</body>
</html>