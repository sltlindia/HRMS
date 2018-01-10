<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.vehicletracking.bean.VehicleBean"%>
<%@page import="com.hrms.vehicletracking.dao.AllListVtsDAO"%>
<%@page import="com.hrms.selfservice.bean.SelfServiceTypeBean"%>
<%@page import="com.hrms.selfservice.dao.AllListSelfServiceDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean"%>
<%@page import="com.hrms.grievancemanagement.dao.AllListGrievanceDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> HRMS </title>
</head>
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
        $('#fromDate').datepicker({
            dateFormat: 'dd-mm-yy'
        });
        $('#toDate').datepicker({
            dateFormat: 'dd-mm-yy'
        });
        
    })
}
</script>
<%@include file="header.jsp" %>
<body>

<%
Calendar now = Calendar.getInstance();  // Current Month, Year, Date

System.out.println("Current Year is : " + now.get(Calendar.YEAR));
// month start from 0 to 11
System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
System.out.println("Current Date is : " + now.get(Calendar.DATE));


int  month_id = now.get(Calendar.MONTH) + 1;
int year = now.get(Calendar.YEAR);

String fromDate = null;
	String toDate = null;

if(month_id==1 || month_id==3 ||month_id==5 ||month_id==7 ||month_id==8){
	   fromDate = "01-0"+month_id+"-"+year;
	   toDate = "31-0"+month_id+"-"+year;
	   
	}else if(month_id==4 ||month_id==6 ||month_id==9){
		 fromDate = "01-0"+month_id+"-"+year;
		   toDate = "30-0"+month_id+"-"+year;
	}else if(month_id==10 || month_id==12){
		 fromDate = "01-"+month_id+"-"+year;
		   toDate = "31-"+month_id+"-"+year;
	}if(month_id == 11){
		 fromDate = "01-"+month_id+"-"+year;
		   toDate = "30-"+month_id+"-"+year;
	}if(month_id==2){
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
			 fromDate = "01-0"+month_id+"-"+year;
			   toDate = "29-0"+month_id+"-"+year;
		}else{
			 fromDate = "01-0"+month_id+"-"+year;
			   toDate = "28-0"+month_id+"-"+year;
		}
	}
%>
<div id="wrapper">
		<div id="page-wrapper">
			 <div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Document Upload (Carwise)</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading"> Document Upload</div>
						<div class="panel-body">
							
				<form action="carDocumentInsert" method="post" name="" enctype="multipart/form-data">
							<div class="panel-group" id="accordion">
									   	<%
                        String parseFromDate = null;
                        String parseToDate = null;
                        String parseFromDate1 = null;
                        String parseToDate1 = null;
                      
                        
                        
                        if(request.getParameter("fromDate") != null && !request.getParameter("toDate").equalsIgnoreCase("")){
                       	 fromDate = request.getParameter("fromDate");
                        toDate = request.getParameter("toDate");
                        
                        session.setAttribute("fromDate", fromDate);
                        session.setAttribute("toDate", toDate);
                        
                        }else if(session.getAttribute("fromDate") != null && session.getAttribute("toDate") != null ){
                        	fromDate = (String) session.getAttribute("fromDate");
                            toDate = (String) session.getAttribute("toDate");
                        }
                       	 
                         DateFormat dateFormatForselection  = new SimpleDateFormat("dd-MM-yyyy");
                         DateFormat dateFormat2Forselection  = new SimpleDateFormat("yyyy-MM-dd");
                         DateFormat dateFormat1ForSelection = new SimpleDateFormat("dd/MM/yyyy");
                         
                       	 Date datee = dateFormatForselection.parse(fromDate);
                    	 Date datee1 = dateFormatForselection.parse(toDate);
                    	 
                    	 parseFromDate = dateFormat1ForSelection.format(datee);
                    	 parseToDate = dateFormat1ForSelection.format(datee1);
                    	 
                    	 parseFromDate1 = dateFormat2Forselection.format(datee);
                    	 parseToDate1 = dateFormat2Forselection.format(datee1);
                    	 

                        
                       
                        %>

									<div id="table-responsive">
									<table class="table table-stripped table-hover ">
									<tr>
										<th>Vehicle</th>
										<td>:</td>
										<td><select class="form-control" name="vehicle_master_id" required="required">
										<option value="">--- Select Vehicle ---</option>
										<%AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
										List<VehicleBean> listOfVehicle = allListVtsDAO.getListOfVehicles();
							 	          for (VehicleBean v : listOfVehicle){%>
										<option value="<%=v.getVehicle_master_id()%>"> <%=v.getVehicle_name()%>(<%=v.getVehicle_no()%>)</option>
										<%}%>
										</select>
										</td>
										<th>Registered No.</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="registered_no"></td>
									</tr>
									<tr>
										<th>Insurance Policy Description</th>
										<td>:</td>
										<td colspan="5"><textarea class="form-control" name="description"></textarea></td>
									</tr>
									
									<tr>
										<th>Policy No.</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="policyNo"></td>
										<th>Amount</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="amount"></td>
									</tr>
									<tr>
										<th>Policy issued on</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="fromDate" id="fromDate"
											value="<%=fromDate%>"
											style="width: 200px" placeholder="dd-mm-yyyy"></td>
										<th>Period of insurance</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="toDate" id="toDate"
											value="<%=toDate%>"
											style="width: 200px" placeholder="dd-mm-yyyy"></td>
									</tr>
									
									<tr>
										<th>Attachment</th>
										<td>:</td>
										<td colspan="5"><input type="file" value="Browse" name="attachment" multiple="multiple"> </td>
									</tr>
									
								
									
									</table>
</div>
<input type="hidden" name="redirect" >
								<center>
									<input type="submit" value="Submit" class="btn btn-primary"></a>
									<input type="reset" value="Cancel" class="btn btn-danger">
								</center>
							
				</form>


					</div>

					<!-- /.panel -->
				</div>
				
				<!-- /.col-lg-12 -->
			</div>
		</div>
	<!-- /#wrapper -->
	</div>
	</div>


	<script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    
    <!-- <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script> -->
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