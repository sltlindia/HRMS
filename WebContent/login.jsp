<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.recruitement.bean.CompanyListBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.recruitement.dao.CompanyListDAO"%>
<%@page import="com.hrms.pms.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
   
   <!--  <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico"> -->
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
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
    <link rel="stylesheet" type="text/css" href="app-assets/css/pages/login-register.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
     <link rel="stylesheet" type="text/css" href="css/animate.css">
     <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- END Custom CSS-->
    <script language="Javascript">
	function capLock(e)
	{
	 	kc = e.keyCode?e.keyCode:e.which;
	 	sk = e.shiftKey?e.shiftKey:((kc == 16)?true:false);
	 	if(((kc >= 65 && kc <= 90) && !sk)||((kc >= 97 && kc <= 122) && sk))
	 		{
	 		 	document.getElementById('divMayus').style.visibility = 'visible';
	 		}
	 	else
	 		{
	 			document.getElementById('divMayus').style.visibility = 'hidden';
	 		}
	}
	
	
	function hideMessage()
	{
		//document.getElementById("panelbody").style.display="none"; 
		 $('.alert').fadeOut('slow');
	}

		function startTimer()
		 {
				var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
		 }
</script>
</head>
 <body data-open="hover" data-menu="horizontal-menu" data-col="1-column" class="horizontal-layout horizontal-menu 1-column bg-full-screen-image blank-page blank-page" onload="startTimer()">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <%
	HttpSession session1 = request.getSession();
	EmployeeBean user = (EmployeeBean)session1.getAttribute("user");
	if(user==null){%>
	<center>
	<%if(request.getAttribute("loginError") !=null || request.getAttribute("error") !=null || request.getAttribute("sessionExpired") !=null) {%>
	
	          		<div class="alert alert-danger round alert-icon-left alert-arrow-left alert-dismissible fade in mb-2" style="width: 450px; margin-top: 20px" role="alert">
									<button type="button" class="close" data-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<strong>${loginError}${error}${sessionExpired}</strong>
								</div>
	          		
	          		<%} %>
	          		
	          		<%if(request.getAttribute("success") !=null) {%>
	          		<div class="alert alert-success round alert-icon-left alert-arrow-left alert-dismissible fade in mb-2" style="width: 450px; margin-top: 20px" role="alert">
									<button type="button" class="close" data-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<strong>${success}</strong>
								</div>
	          		<%} %>
    <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body">
        <img src="img/sltllogo.png" alt="sltlLogo" class="animated zoomIn">
        <section class="flexbox-container">
    <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1 box-shadow-3 p-0">
        <div class="card border-grey border-lighten-3 px-1 py-1 m-0">
            <div class="card-header no-border">
                <div class="card-title text-xs-center">
  <div class="BODY">                
 <svg viewBox="0 0 1000 400">
  <symbol id="s-text">
  
    
    <!-- 
     <text text-anchor="middle"
          x="50%"
          y="35%"
          class="text--line"
          >
      HRMS
    </text> -->
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
                <!-- <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span>Easily Using</span></h6> -->
            </div>
            <div class="card-body collapse in">
                <!-- <div class="text-xs-center">
                    <a href="#" class="btn btn-social-icon mr-1 mb-1 btn-outline-facebook"><span class="icon-facebook3"></span></a>
                    <a href="#" class="btn btn-social-icon mr-1 mb-1 btn-outline-twitter"><span class="icon-twitter3"></span></a>
                    <a href="#" class="btn btn-social-icon mr-1 mb-1 btn-outline-linkedin"><span class="icon-linkedin3 font-medium-4"></span></a>
                    <a href="#" class="btn btn-social-icon mr-1 mb-1 btn-outline-github"><span class="icon-github font-medium-4"></span></a>
                </div> -->
                <p class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mx-2 my-1"><span>Using Account Details</span></p>
                <div class="card-block">
                    <form class="form-horizontal" action="login" method="post">
                         <fieldset class="form-group">
                            <select class="custom-select block" id="companyId" name="companyId" placeholder="Your Company Name">
                                <option selected>Select Company Name</i></option>
												<%
													CompanyListDAO companyListDAO = new CompanyListDAO();
														List<CompanyListBean> listOfCompanyList = (ArrayList) companyListDAO.getListOfCompanyList();
														for (CompanyListBean companyListBean : listOfCompanyList) {
												%>
												<option value="<%=companyListBean.getCompany_list_id()%>"><%=companyListBean.getCompany_name()%></option>
												<%
													}
												%>
											</select>
                        </fieldset>
                        <fieldset class="form-group position-relative has-icon-left">
                            <input type="text" class="form-control" id="employee_code" name="employee_code" placeholder="Your Employee Code" required>
                            <div class="form-control-position">
                                <i class="icon-head"></i>
                            </div>
                        </fieldset>
                        <fieldset class="form-group position-relative has-icon-left">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" onkeypress="capLock(event)" required>
                            <div class="form-control-position">
                                <i class="icon-key3"></i>
                            </div>
                        </fieldset>
                        <fieldset class="form-group row">
                            <div class="col-md-6 col-xs-12 text-xs-center">
                            </div>
                            <div class="col-md-6 col-xs-12 float-sm-left text-xs-center"><a href="forgotPassword.jsp" class="card-link">Forgot Password?</a></div>
                        </fieldset>
                        <button type="submit" class="btn btn-outline-primary btn-block"><i class="icon-unlock2"></i> Login</button>
                    </form>
                </div>
                <!-- <p class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mx-2 my-1"><span>New to HRMS ?</span></p>
                <div class="card-block">
                    <a href="register-with-bg-image.html" class="btn btn-outline-primary btn-block"><i class="icon-head"></i> Register</a>
                </div> -->
            </div>
        </div>
        </div>
        
    </div>
</section>

        </div>
      </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

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
    <script src="app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/forms/form-login-register.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-96096445-1', 'auto');
	  ga('send', 'pageview');

	</script>
	<%}else{ 
    	 String authority = user.getRoleBean().getRole_authority();
    	 int manager_id = user.getManagerBean().getManager_id();
    	 if(authority.equals("M2") || authority.equals("M1")){
    		 if(manager_id == 99){
    			 response.sendRedirect("empHome.jsp");
    				 }else{
    					 response.sendRedirect("managerHome.jsp");
    				 }
   }else if(authority.equals("M3") || authority.equals("M4")){
	   response.sendRedirect("managerHome.jsp");
   }else if(authority.equals("M5")){
	   response.sendRedirect("hrHome.jsp");
   }else if(authority.equals("M6")){
	   response.sendRedirect("sltlAdmin.jsp");
   }
	   %> 
    <%} %>
</body>

</html>