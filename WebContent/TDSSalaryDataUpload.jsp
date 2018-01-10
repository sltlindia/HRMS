<%@page import="com.hrms.tds.bean.TDSPayrollMasterDataBean"%>
<%@page import="com.hrms.tds.dao.TDSListDAO"%>
<%@page import="com.hrms.pms.bean.YearBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.ArrayList"%>
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
    <title>Upload Document</title>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/users.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/timeline.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/dropzone.css">
    <script src="js/dropzone.js" type="text/javascript"></script>
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
<style type="text/css">
/* .container {
    width: 990px;
    padding-left: 2px;
}  */
#upload_form {
     float:left; 
    padding:30px;
    width:970px;
}
#image_file {
        width: 210px;
}
input {
    border-radius:10px;
    -moz-border-radius:10px;
    -ms-border-radius:10px;
    -o-border-radius:10px;
    -webkit-border-radius:10px;

    border:1px solid #ccc;
    font-size:10pt;
    padding:5px 10px;
}
</style>
<script type="text/javascript">

	function startTimer()
	{
		var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
	}
	function hideMessage()
	 {
		//document.getElementById("panelbody").style.display="none"; 
		 $('#panelbody').fadeOut('slow');
	 }
</script>

</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns" onload = "startTimer()">
<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h4>Uploaded Salary Data</h4>
			            <hr>
			        </div>
			    </div>
       
       <%if(session.getAttribute("success") !=null) 
			{	
			%>
			<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-success">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${success}
                            </div>
          		</div>  
          		<%}%>
          		
        <div class="container">
            <!-- <div class="contr"><h2>You can select the file (image) and click Upload button</h2></div> -->
            
		<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Document Upload</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
			        			<div class="heading-elements">
				                    <ul class="list-inline mb-0">
				                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
				                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
				                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
				                    </ul>
				                </div>
				            </div>
				            <div class="card-body collapse in">
	               				 <div class="card-block">
            <div class="upload_form_cont">
                <form id="upload_form" enctype="multipart/form-data" method="post" action="tdsSalaryDataInsert">
                	<div class="row">
                		<div class="col-md-12">
	                		<div class="col-md-2"><label for="image_file"><b>Document Type :</b></label></div>
	                		<div class="col-md-8">
	                			<input type="radio" name="documentType" id="documentType" value="Master Data">&nbsp;Master Data&emsp;
	                			<input type="radio" name="documentType" id="documentType" value="Monthly Data">&nbsp;Basic Data
	                		</div>
	                	</div>
                	</div><br>
                	<div class="row">
                		<div class="col-md-12">
                			<div class="col-md-2"><label for="image_file"><b>Month :</b></label></div>
                			<div class="col-md-4">
                				<select class="form-control" id="month" name="month">
                                            <option value="0">----- Select Month -----</option>
                                            <% AllListDAO allListDAO = new AllListDAO();
                                            	List<MonthBean> monthBean = allListDAO.getListOfMonth();
                                            	for(MonthBean bean : monthBean){%>
                                                <option value="<%=bean.getMonth_id()%>"><%=bean.getMonth_name() %></option>
                                                <%} %>
                                            </select>
                			</div>
                			
                			<div class="col-md-2"><label for="image_file"><b>Year :</b></label></div>
                			<div class="col-md-4">
                					<select class="form-control" id="year" name="year">
                                            	<option value="0">----- Select Year -----</option>
                                            	<% AllListDAO allListDAO1 = new AllListDAO();
                                            	List<YearBean> yearBean1 = allListDAO.getListOfYear();
                                            	for(YearBean bean : yearBean1){%>
                                                <option value="<%=bean.getYear_id()%>"><%=bean.getYear()%></option>
                                                <%} %>
                                            </select></div>
                		</div>
                	</div><br>
                    <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-2"><label for="image_file"><b>Salary Data :</b></label></div>
                        <div class="col-md-8"><input type="file" name="uploadTDSSalaryData" id="image_file" style="width: 500px;"  onchange="checkFile(this);" /></div>
                    </div>
                    </div>
                  	<br>
                    <div>
                        <center>
							<input type="submit" value="SUBMIT" class="btn btn-primary">
							<input type="reset" value="RESET" class="btn btn-danger">
						</center>
                    </div>
                    
                </form>

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
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>

	<script type="text/javascript">
  function checkFile(fieldObj)
{
	 
	//alert("hello");
    var FileName  = fieldObj.value;
    var FileExt = FileName.substr(FileName.lastIndexOf('.')+1);
    var FileSize = fieldObj.files[0].size;
    var FileSizeMB = (FileSize/1048576).toFixed(2);

    //if((FileExt != "pdf" && FileExt != "doc" && FileExt != "docx" && FileExt != "jpg" && FileExt != "jpeg" && FileExt != "txt" && FileExt != "ppt" && FileExt != "xml" && FileExt != "xls"  && FileExt != "pptx")){
    if((FileExt != "xlsx")){
    	 var error = "File type : "+ FileExt+"\n\n";
         error += "Size: " + FileSizeMB + " MB \n\n"; 
         error += "Please make sure your file is in pdf or doc or docx or xml or jpg or jpeg or xls or txt or ppt.\n\n";
    	alert(error);
    	fieldObj.value = "";
        }else if (FileSize>1048576)
    {
        var error = "File type : "+ FileExt+"\n\n";
        error += "Size: " + FileSizeMB + " MB \n\n";
        error += "Please make sure your file size less than 1 MB.\n\n";
        alert(error);
        fieldObj.value = "";
        return false;
    }
    return true;
}
  </script>
	
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})

		// popover demo
		$("[data-toggle=popover]").popover()
	</script>
	
	<script src="js/index.js"></script>
</body>
</html>