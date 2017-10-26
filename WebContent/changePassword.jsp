<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
   <!--  <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png"> -->
    
     <link rel="shortcut icon" sizes="152x152" href="app-assets/images/ico/titleIcon.png" >
    
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
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- END Custom CSS-->
    
    <link rel="stylesheet" href="assets/css/validationEngine.jquery.css" type="text/css"/>
<script src="assets/js1/jquery-1.8.2.min.js" type="text/javascript"></script>
    
    
    <script src="assets/js1/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8"></script>
	<script src="assets/js1/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    
  function check() {
		var a = document.getElementById("pwd").value;
		var b = document.getElementById("re-pwd").value;
		
		if(a != b){
			alert("Password and Confirm password are not match...")
			document.getElementById("pwd").value = "";
			document.getElementById("re-pwd").value = "";
		}
	}
	  </script>
	  
	  
	  <script type="text/javascript">
	function validatePassword() {
	    var newPassword = document.getElementById('pwd').value;
	    var minNumberofChars = 6;
	    var maxNumberofChars = 16;
	    var regularExpression  = /^[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	    if(newPassword.length < minNumberofChars || newPassword.length > maxNumberofChars){
	    	alert("Password length between 6 to 16 character");
	    	document.getElementById('pwd').value ="";
	        return false;
	    }
	    if(!regularExpression.test(newPassword)) {
	        alert("password should contain atleast one number and one special character and one alphabetic character");
	        return false;
	    }
	}
	</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="1-column" class="horizontal-layout horizontal-menu 1-column  blank-page blank-page">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <%EmployeeBean user = (EmployeeBean) session.getAttribute("user");
    System.out.print("name:"+user.getFirstname());%>
    <center>
<%if(request.getAttribute("success") != null){%>
		 		<div class="alert alert-success round alert-icon-left alert-arrow-left alert-dismissible fade in mb-2" style="width: 450px; margin-top: 20px" role="alert">
									<button type="button" class="close" data-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<strong>${success}</strong>
								</div>
          		<%} %>  
          		</center>
    <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><section class="flexbox-container">
    <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1 box-shadow-2 p-0">
        <div class="card border-grey border-lighten-3 px-2 py-2 m-0">
            <div class="card-header no-border pb-0">
                <div class="card-title text-xs-center">
                  <div class="BODY">                
 <svg viewBox="0 0 1000 600">
  <symbol id="s-text">
  
    
    
     <text text-anchor="middle"
          x="50%"
          y="35%"
          class="text--line"
          >
      SLTL
    </text>
    <text text-anchor="middle"
          x="50%"
          y="68%"
          class="text--line2"
          >
      HRMS
    </text>
    
  </symbol>
  
  <g class="g-ants">
    <use xlink:href="#s-text"
      class="text-copy"></use>     
    <use xlink:href="#s-text"
      class="text-copy"></use>     
    <use xlink:href="#s-text"
      class="text-copy"></use>     
    <use xlink:href="#s-text"
      class="text-copy"></use>     
    <use xlink:href="#s-text"
      class="text-copy"></use>     
  </g>
  
  
</svg>
</div>
</div>
                <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span>Forgot Password</span></h6>
            </div>
            <div class="card-body collapse in">
                <div class="card-block">
                    <form class="form-horizontal" action="changePassword" method="post">
                        <fieldset class="form-group position-relative has-icon-left">
                            <input type="text" class="form-control" id="username" name="username" placeholder="Your User Name"
                            	value="<%=user.getFirstname()+" "+user.getLastname() %>" required>
                            <div class="form-control-position">
                                <i class="icon-head"></i>
                            </div>
                        </fieldset>
                        
                            <input type="hidden" class="form-control" id="emp_id" name="emp_id" placeholder="Enter Password" 
                            		value="<%=user.getEmployee_master_id() %>"required>
                            
                        <fieldset class="form-group position-relative has-icon-left">
                            <input type="password" class="form-control and validate[required, minSize[7], maxSize[10]]" id="pwd" name="pwd" placeholder="Enter Password"  required>
                            <div class="form-control-position">
                                <i class="icon-key3"></i>
                            </div>
                        </fieldset>
                        
                        <!-- onchange=" validatePassword();" -->
                        <fieldset class="form-group position-relative has-icon-left">
                            <input type="password" class="form-control" id="re-pwd" name="re-pwd" placeholder="Enter Re-Enter Password" onchange="check();" required>
                            <div class="form-control-position">
                                <i class="icon-key3"></i>
                            </div>
                        </fieldset>
                        <section id="animations">
                        	<div class="card-block">
                        		<button type="submit" class="btn btn-lg btn-block btn-outline-primary mb-2" id="slide-top-animation"><i class="icon-lock4"></i> SUBMIT </button>
                    		</div>
                    	</section>
                    </form>
                </div>
            </div>
            
        </div>
    </div>
</section>

        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
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
    <script src="app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/forms/form-login-register.min.js" type="text/javascript"></script>
     <script src="app-assets/js/scripts/extensions/sweet-alerts.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
</body>
</html>