
<!-- 
Created by 	: Akash Ramani
Date 		: 15-06-2017 
-->

<%@page import="java.util.Calendar"%>
<%@page import="com.rmihl.bean.RowMaterialInwordBean"%>
<%@page import="com.rmihl.bean.UnitMeasurementBean"%>
<%@page import="com.rmihl.dao.AllListDAO"%>
<%@page import="com.rmihl.bean.VendorBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gate Home</title>
<%@include file="header.jsp" %>

 <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/selects/select2.min.css">
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

</head>
<body>
<%

AllListDAO allListDAO = new AllListDAO();

List<VendorBean> listOfVendor = allListDAO.listOfvendor();
List<UnitMeasurementBean> listOfUnitMeasurement = allListDAO.listOfUnitMeasurement();

Calendar c = Calendar.getInstance();
int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH);

int year1 = 0;
int year2 = 0;

if(month>3 && month<=12){
	year1 = year;
	year2 = year+1;
}else

if(month>=1 && month<4){
	year1 = year -1;
	year2 = year;
}

RowMaterialInwordBean rowMaterialInwordBean1 = allListDAO.lastEntryOfRowMaterialByYear(year1,year2,user_id);
int inwordNo = 00001;
if(rowMaterialInwordBean1 != null){
	inwordNo =  Integer.parseInt(rowMaterialInwordBean1.getINWORD_NO()) + 1;
}

String inword = String.valueOf(inwordNo);
int length = inword.length();
System.err.println(length);


for(int i=length;i<5;i++){
	inword = 0+""+inword;
}


%>

 <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-header row">

<div class="row">
		<div class="col-md-12">
	        <div class="card">
	            <div class="card-header">
	                <h4 class="card-title" id="striped-label-layout-icons">Row Material Entry Form</h4>
	                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
        			<div class="heading-elements">
	                    <ul class="list-inline mb-0">
	                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
	                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
	                    </ul>
	                </div>
	            </div>
	            <div class="card-body collapse in">
	                <div class="card-block">
	                    <form id="form" class="form form-horizontal form-bordered">
	                    	<div class="form-body">
	                			<div class="form-group row">
		                            <label class="col-md-3 label-control" for="timesheetinput1">Inword No</label>
		                            <div class="col-md-9">
			                            <div class="position-relative has-icon-left">
			                            	<h3 class="inword"><%=inword%></h3>
			                            	<input type="hidden" class="inword" name="inwordNo" id="inwordNo" value="<%=inword%>">
			                            </div> 
		                            </div>
		                        </div>
	                			<div class="form-group row">
	                            	<label class="col-md-3 label-control" for="timesheetinput2">Vendor Name <i class="icon-android-alert" style="color: red" id="ivendor_id"></i></label>
	                            	<div class="col-md-9">
			                            <div class="position-relative has-icon-left">
			                            	<select class="select2-language form-control" id="select2-language" name="vendor_id" onchange="checkVendor(this.value)">
			                            		<option value="0">---SELECT VENDOR---</option>
			                            		<%for(VendorBean vendorBean : listOfVendor){ %>
													<option value="<%=vendorBean.getVENDOR_ID()%>">
													<%if(vendorBean.getVENDOR_ID() != 1){%>
														<%=vendorBean.getVENDOR_CODE()+" : "+vendorBean.getVENDOR_NAME()%>
													<%}else{%>
														<%=vendorBean.getVENDOR_NAME()%>
													<%}%>
													</option>
												<%} %>
											</select>
			                            </div>
			                    	</div>
		                        </div>

		                        <div class="form-group row" id="vendor_div">
	                        		<label class="col-md-3 label-control" for="timesheetinput3"><font color="red">You Must Enter Vendor Name Manually</font> <i class="icon-android-alert" style="color: red" id="ivendor_name"></i></label>
	                        		<div class="col-md-9">
			                            <div class="position-relative has-icon-left">
			                            	<input type="text" class="form-control" placeholder="Enter Vendor Name" name="vendor_name" id="vendor_name">
				                            <div class="form-control-position">
				                                <i class="icon-head"></i>
				                            </div>
			                            </div>
			                        </div>
		                        </div>

		                    	<div class="form-group row">
	                        		<label class="col-md-3 label-control">Number Of Box <i class="icon-android-alert" style="color: red" id="inoOfBox"></i></label>
	                        		<div class="col-md-9">
			                           <div class="position-relative has-icon-left">
			                            	<input type="text" class="form-control" placeholder="Enter Number Of Box" id="noOfBox" name="no_of_box">
				                            <div class="form-control-position">
				                                <i class="icon-paper-stack"></i>
				                            </div>
			                            </div>
									</div>
		                        </div>

								<div class="form-group row">
	                            	<label class="col-md-3 label-control" for="timesheetinput5">Unit Measurement <i class="icon-android-alert" style="color: red" id="iunitMeasurement"></i></label>
	                            	<div class="col-md-9">
			                            <div>
			                            	<select class="form-control" id="unitMeasurement" name="unit_measurement">
			                            		<option value="">---SELECT UNIT MEASUREMENT---</option>
			                            		<%for(UnitMeasurementBean unitMeasurementBean : listOfUnitMeasurement){ %>
													<option value="<%=unitMeasurementBean.getUNIT_MEASUREMENT_ID()%>"><%=unitMeasurementBean.getUNIT_MEASUREMENT_NAME()%></option>
												<%} %>
											</select>
			                            </div>
			                        </div>
		                        </div>


								<div class="form-group row last">
									<label class="col-md-3 label-control" for="timesheetinput7">Remarks</label>
									<div class="col-md-9">
										<div class="position-relative has-icon-left">
			                            	<textarea id="timesheetinput7" rows="5" class="form-control" name="remarks" placeholder="Enter Remarks"></textarea>
				                            <div class="form-control-position">
				                                <i class="icon-file2"></i>
				                            </div>
			                            </div>
			                        </div>
								</div>
							</div>

	                        <div class="form-actions right">
	                            <button type="reset" class="btn btn-warning mr-1">
	                            	<i class="icon-cross2"></i> CANCEL
	                            </button>
	                            <button type="button" class="btn btn-primary" onclick="insertData()">
	                                <i class="icon-check2"></i> SAVE
	                            </button>
	                        </div>
	                    </form>
	                    
	                    
	                    
	                    <div class="row">
    <div class="col-xs-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title">Last Added Entry of <%=ddMMMyyyy.format(current_date)%></h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body collapse in">
                <div class="table-responsive">
                    <table class="table table-bordered mb-0">
                        <thead>
                            <tr>
                                <th>Inword No</th>
                                <th>Vendor Name</th>
                                <th>No Of Box</th>
                                <th>Measurement</th>
                                <th>Remarks</th>
                                <th>Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <%RowMaterialInwordBean rowMaterialInwordBean = allListDAO.lastEntryOfRowMaterial(user_id, yyyyMMddFormate); %>
                        <tbody>
                            <%if(rowMaterialInwordBean != null){%>
                            <tr>
                                <td id="tdInwordNo"><%=rowMaterialInwordBean.getINWORD_NO()%></td>
                                <td id="tdVendorName">
                                <%if(rowMaterialInwordBean.getVendorBean().getVENDOR_ID() != 1) {%>
                                	<%=rowMaterialInwordBean.getVendorBean().getVENDOR_CODE()+" : "+rowMaterialInwordBean.getVendorBean().getVENDOR_NAME()%>
                                <%}else{ %>
                                	<%=rowMaterialInwordBean.getSECONDARY_VENDOR_NAME()%>
                                <%} %>
                                </td>
                                <td id="tdNoOfBox"><%=rowMaterialInwordBean.getNO_OF_BOX()%></td>
                                <td id="tdUnit"><%=rowMaterialInwordBean.getUnitMeasurementBean().getUNIT_MEASUREMENT_NAME()%></td>
                                <td id="tdremarks" style="white-space: pre-wrap;"><%=rowMaterialInwordBean.getREMARKS()%></td>
                                <td id="tdDate"><%=rowMaterialInwordBean.getINSERT_DATE()%></td>
                                <td><a href="update.jsp?id=<%=rowMaterialInwordBean.getROW_MATERIAL_INWORD_ID()%>"><button type="button" class="btn btn-sm" style="background-color: #7DD3BE"><i class="icon-ios-compose"></i> EDIT</button></a></td>
                            </tr>
                            <%} else{%>
                            	<tr>
                                <td id="tdInwordNo"></td>
                                <td id="tdVendorName"></td>
                                <td id="tdNoOfBox"></td>
                                <td id="tdUnit"></td>
                                <td id="tdremarks" style="white-space: pre-wrap;"></td>
                                <td id="tdDate"></td>
                                <td></td>
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
	    </div>
	</div>
	
</div>
</div>
</div>


<footer class="footer undefined footer-light navbar-shadow">
      <p class="clearfix text-muted text-sm-center mb-0 px-2"><span class="float-md-left d-xs-block d-md-inline-block">Sahajanand Laser Technology LTD. </span><span class="float-md-right d-xs-block d-md-inline-block">Hand-crafted & Made with <i class="icon-heart5 pink"></i></span></p>
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
    <script src="app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/forms/select/form-select2.min.js" type="text/javascript"></script>
     <script src="app-assets/js/scripts/extensions/sweet-alerts.min.js" type="text/javascript"></script>
     <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>

<script>
$( document ).ready(function() {
	$("#vendor_name").prop('disabled', true);
	$("#vendor_div").hide();
	$(".icon-android-alert").hide();
});


function checkVendor(value){
	if(value == '1'){
		$("#vendor_name").prop('disabled', false);
		$("#vendor_div").show();
	}else{
		$("#vendor_name").prop('disabled', true);
		$("#vendor_div").hide();
	}
}



function insertData() {
	$(".icon-android-alert").hide();
	var vendor_id = $("#select2-language").val();
	var vendor_name =  $("#vendor_name").val();
	var noOfBox = $("#noOfBox").val();
	var unitMeasurement = $("#unitMeasurement").val();
	var result = true;
	
	
	if(vendor_id == "0"){
		$("#ivendor_id").show();
		result = false;
	}else if(vendor_id == '1') {
		if(vendor_name == ""){
			$("#ivendor_name").show();
			result = false;
		}
	}
	
	if(noOfBox == ""){
		$("#inoOfBox").show();
		result = false;
	}
	
	
	if(unitMeasurement == ""){
		$("#iunitMeasurement").show();
		result = false;
	}
	
	
	if(result == true){
	$.ajax({
	    method: "POST",
	    url: 'InsertServlet',
	    data: $('#form').serialize(),
	    success: function (data) {
	        
	    	if(data == "null"){
	    		swal("Error!","Some Error occured !","error")
	    	}else{
	    		swal("SUCCESS!","Successfully Saved Data!","success")
	    		var json = JSON.parse(data);
	    		
	    		var inword = Number(json.INWORD_NO) + 1;
	    		
	    		var n = inword.toString().length;
	    		var strInword = inword;
	    		for(var i=n;i<5;i++){
	    			strInword = 0+""+strInword;
	    		}
	    		
	    		$("#tdInwordNo").text(json.INWORD_NO);
	    		$("#tdNoOfBox").text(json.NO_OF_BOX);
	    		if(json.vendorBean.VENDOR_ID != 1){
	    			$("#tdVendorName").text(json.vendorBean.VENDOR_CODE+' : '+json.vendorBean.VENDOR_NAME);
	    		}else{
	    			$("#tdVendorName").text(json.SECONDARY_VENDOR_NAME);
	    		}
	    		$("#tdUnit").text(json["unitMeasurementBean"].UNIT_MEASUREMENT_NAME);
	    		$("#tdremarks").text(json.REMARKS);
	    		$("#tdDate").text(json.INSERT_DATE);
	    		
	    		$(".inword").text(strInword);
	    		$(".inword").val(strInword);
	    		$("#form")[0].reset();
	    		$("#vendor_name").prop('disabled', true);
	    		$("#vendor_div").hide();
	    		setTimeout(function print(){
	    			window.location.replace("gateIndex.jsp");
			}, 2000)
	    		
	    		
	    	}
	    	
	    }
	});
	}
}
</script>

</body>
</html>