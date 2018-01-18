<%@page import="com.hrms.vehicletracking.bean.VehiclePolicyDocumentBean"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>HRMS</title>
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
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

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
<div class="app-content container center-layout mt-2">
	<div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h1>Document Upload (Carwise)</h1>
			        </div>
			    </div>
				<!-- /.col-lg-12 -->
			
			<br>
<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	 <div class="card-header">
				        <div class="card box-shadow-0" data-appear="appear">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
					            <div class="col-sm-6">	
				               		<h4 class="card-title" id="horz-layout-basic">Document Upload</h4>
				                </div>
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading"> Document Upload</div>
						<div class="panel-body"> -->
							
				<form action="carDocumentUpdate" method="post" name="" enctype="multipart/form-data">
							<div class="panel-group" id="accordion">
							<%int vehicle_policy_document_id = Integer.parseInt(request.getParameter("vehicle_policy_document_id"));
							
							AllListVtsDAO allListVtsDAO = new AllListVtsDAO();
							VehiclePolicyDocumentBean vehiclePolicyDocumentBean = allListVtsDAO.getVehiclePolicyDocumentById(vehicle_policy_document_id);
							%>
							<input type="hidden" name="vehicle_policy_document_id" value="<%=vehicle_policy_document_id%>">
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
										<%List<VehicleBean> listOfVehicle = allListVtsDAO.getListOfVehicles();
							 	          for (VehicleBean v : listOfVehicle){%>
							 	          <%if(v.getVehicle_master_id() == vehiclePolicyDocumentBean.getVehicleBean().getVehicle_master_id()){ %>
										<option value="<%=v.getVehicle_master_id()%>" selected="selected"> <%=v.getVehicle_name()%>(<%=v.getVehicle_no()%>)</option>
										<%}else{ %>
										<option value="<%=v.getVehicle_master_id()%>"> <%=v.getVehicle_name()%>(<%=v.getVehicle_no()%>)</option>
										<%} %>
										<%}%>
										</select>
										</td>
										<th>Registered No.</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="registered_no" value="<%=vehiclePolicyDocumentBean.getRegistration_no()%>"></td>
									</tr>
									<tr>
										<th>Insurance Policy Description</th>
										<td>:</td>
										<td colspan="5"><textarea class="form-control" name="description"><%=vehiclePolicyDocumentBean.getInsurance_policy_description() %></textarea></td>
									</tr>
									
									<tr>
										<th>Policy No.</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="policyNo" value="<%=vehiclePolicyDocumentBean.getPolicy_no()%>"></td>
										<th>Amount</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="amount" value="<%=vehiclePolicyDocumentBean.getAmount()%>"></td>
									</tr>
									<tr>
										<th>Policy issued on</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="fromDate" id="fromDate"
											value="<%=vehiclePolicyDocumentBean.getPolicy_issued_on()%>"
											style="width: 200px" placeholder="dd-mm-yyyy"></td>
										<th>Period of insurance</th>
										<td>:</td>
										<td><input type="text" class="form-control" name="toDate" id="toDate"
											value="<%=vehiclePolicyDocumentBean.getPeriod_of_insurance()%>"
											style="width: 200px" placeholder="dd-mm-yyyy"></td>
									</tr>
									
									<tr>
										<th>Attachment</th>
										<td>:</td>
										<td colspan="5"><input type="file" value="Browse" name="attachment" multiple="multiple"><%=vehiclePolicyDocumentBean.getAttachment()%> </td>
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
				</div>
				</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		</section>
	<!-- /#wrapper -->
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