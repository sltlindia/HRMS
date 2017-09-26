<%@page import="java.util.List"%>
<%@page import="com.hrms.corehr.bean.CompanyAdressBean"%>
<%@page import="com.hrms.corehr.dao.AllListCoreHrDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <title>SLTL</title>
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/cardStyle.css" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700,300,300italic' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<script type="text/javascript" src="js/modernizr.custom.79639.js"></script> 
    <style>
  
 /*  @keyframes blink2 {  
  0% { color: #337ab7; }
  100% { color: red; }
} */
 
#icons{
  	animation:  blink2 3s ease-in-out 2s infinite;
  }
  </style>
  
    <script type="text/javascript">
    function test(value) {
    	
    	var a = document.getElementById("location"+value).value;
    	
    	 window.open(a);
	}
    </script>
    <%@include file="header.jsp"%>
</head>
<body>

 <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-header row">
          <!-- <div class="content-header-left col-md-6 col-xs-12">
            <h2 class="content-header-title mb-0">Company Address</h2>
          </div> -->
        </div>
        
        <div class="content-body">
        	
        	<section class="main">
			
				<div id="sb-container" class="sb-container">
					<div>
						<h4 align="left" style="color: #581845;font-size:14px;"><span>More Info</span></h4>
						<h4 align="left" style="color: black;font-size:13px;"><span>Email : info@sahajanandlaser.com</span></h4>
						<h4 align="left" style="color: black;font-size:13px;"><span>Web : www.sahajanandlaser.com</span></h4>
						<h4 align="left" style="color: black;font-size:13px;"><span>Web : www.sltl.com</span></h4>
						<h4 align="left" style="color: black;font-size:13px;"><span>CIN : U30007GJ2002PLC040659</span></h4>
						<h4 align="left" style="color: black;font-size:13px;"><span>GST Number : 24AAGCS1983B1ZK</span></h4>
						<h4 align="left" style="color: black;font-size:13px;"><span>PAN Number : AAGCS1983B</span></h4>
						
					</div>
					
					<%
		AllListCoreHrDAO allListCoreHrDAO = new AllListCoreHrDAO(); 
		List<CompanyAdressBean> listoffadress = allListCoreHrDAO.getListOfCompanyAdress();
		
		for(int i = 0; i<listoffadress.size();i++){
			
			CompanyAdressBean c = listoffadress.get(i);%>
					<div>
						<h4 align="left" style="color: #581845;font-size:14px;"><input type="hidden" id="location<%=c.getId()%>" value="<%=c.getLocation()%>"><span><%=c.getName() %></span>&nbsp;&nbsp;</h4>	
						<h4 style="color: #373536;"><span><font size="3px"><b><%=c.getAddress() %></b></font></span></h4>	
						<h4 align="left" style="color: black;"><span><i class="material-icons" style="font-size:15px;">phone</i>&nbsp;&nbsp;<%=c.getTelephone() %></span></h4>
						<h4 align="left" style="color: black;"><span><i class="material-icons" style="font-size:15px;">local_printshop</i>&nbsp;&nbsp;<%=c.getFax() %></span></h4>						
						<%if(c.getGst_no() != null){%>
						<h4 align="left" style="color: black;font-size:13px;"><span>GST Number : <%=c.getGst_no()%></span></h4>
						<%} %>
					</div>
				<%} %>	
				<div>
						<h4><span>Company Address</span></h4>
						<span class="sb-toggle">Click to open / close</span>
						<span><h5>SLTL</h5></span>											
					</div>
					
					
				</div><!-- sb-container -->
				
			</section>
			
        </div>
      </div>
</div>

		<%@include file="footer.html"%>
    	<script src="app-assets/js/core/libraries/jquery.min.js"
		type="text/javascript"></script>
		<script src="app-assets/js/core/libraries/bootstrap.min.js"
		type="text/javascript"></script>
		<script type="text/javascript" src="js/jquery.swatchbook.js"></script>
		
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
			$(function() {
			
				$( '#sb-container' ).swatchbook( {
					// number of degrees that is between each item
					angleInc : 15,
					neighbor : 15,
					// if it should be closed by default
					initclosed : true,
					// index of the element that when clicked, triggers the open/close function
					// by default there is no such element
					closeIdx : 11
				} );
			
			});
		</script>
    

</body>
</html>