<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
<%@page import="com.hrms.selfservice.bean.SelfServiceQuerybean"%>
<%@page import="com.hrms.pms.bean.FamilyDetailBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="org.joda.time.format.DateTimeFormat"%>
<%@page import="org.joda.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Self Update</title>
<%@include file="header.jsp"%>
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
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/photoswipe.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/js/gallery/photo-swipe/default-skin/default-skin.css">
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
    <!-- END Custom CSS-->
</head>
<body style="font-family: Calibri">

<%
  Calendar calJoiningDate = Calendar.getInstance();
  Calendar calCurrDate = Calendar.getInstance();
  calJoiningDate.setTime(yyyyMMdd.parse(user.getJoining_date()));
  calCurrDate.setTime(current_date);
  int numberOfDays = 0;
  int joiningYear = calJoiningDate.get(Calendar.YEAR);
  int curYear = calCurrDate.get(Calendar.YEAR);
  
  int month_id = calJoiningDate.get(Calendar.MONTH) + 1;
  
while (calJoiningDate.before(calCurrDate)) {
      numberOfDays++;
      calJoiningDate.add(Calendar.DATE,1);
}


for(int i = joiningYear;i<=curYear;i++){
	System.err.println(i);
	 if((i % 400 == 0) || ((i % 4 == 0) && (i % 100 != 0))){
		 numberOfDays--;
	 }
}


int year = numberOfDays / 365;

numberOfDays = numberOfDays % 365;

int month = 0;

for(int i = month_id;i<=12;i++){
	
	if(i==1 ||i==3 || i==5 ||i==7 ||i==8 ||i==10 ||i==12){
		if(numberOfDays>31){
			numberOfDays = numberOfDays - 31;
			month++;
		}
	}
	
	if(i==2){
		if(numberOfDays>28){
			numberOfDays = numberOfDays - 28;
			month++;	
		}
	}
	
	if(i==4 ||i==6 || i==9 ||i==11){
		if(numberOfDays>30){
			numberOfDays = numberOfDays - 30;
			month++;
		}
	}
}


	for(int i = 1;i<=month_id;i++){
	
	if(i==1 ||i==3 || i==5 ||i==7 ||i==8 ||i==10 ||i==12){
		if(numberOfDays>31){
			numberOfDays = numberOfDays - 31;
			month++;
		}
	}
	
	if(i==2){
		if(numberOfDays>28){
			numberOfDays = numberOfDays - 28;
			month++;	
		}
	}
	
	if(i==4 ||i==6 || i==9 ||i==11){
		if(numberOfDays>30){
			numberOfDays = numberOfDays - 30;
			month++;
		}
	}
}


int day = numberOfDays;

int employee_id = user.getEmployee_master_id();
%>

    <div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12">
            <h2 class="content-header-title mb-0">User Profile</h2>
            <div class="row breadcrumbs-top">
            </div>
          </div>
         
          <div class="content-header-lead col-xs-12 mt-2">
            <p class="lead"></p>
          </div>
        </div>
        <div class="content-body"><div id="user-profile">
    <div class="row">
        <div class="col-xs-12">
            <div class="card profile-with-cover">
                <div class="card-img-top img-fluid bg-cover height-300" style="background: url('app-assets/images/carousel/employee-screening.jpg');height: auto;"></div>
                <div class="media profil-cover-details">
                    <div class="media-left pl-2 pt-2">
                        <a href="#" class="profile-image">
                            <img src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=user.getEmployee_code()%>.bmp" class="rounded-circle img-border height-100" style="height: 50px;width: 100px;" alt="Card image">
                        </a>
                    </div>
                    <div class="media-body media-middle row">
                        <div class="col-xs-6"> 
                            <h3 class="card-title" style="padding-top: 30px"><%=user.getSalutation()+" "+user.getFirstname()+" "+user.getLastname()%><br><font size="2px"><%=user.getRoleBean().getRole_type()%></font></h3>
                        </div>
                       <!--  <div class="col-xs-6 text-xs-right">
                            <button type="button" class="btn btn-primary hidden-xs-down"><i class="icon-plus4"></i> Follow</button>
                            <div class="btn-group hidden-md-down" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-success"><i class="icon-speech-bubble"></i> Message</button>
                                <button type="button" class="btn btn-warning"><i class="icon-cog3"></i></button>
                            </div>
                        </div> -->
                    </div>
                </div>
               <!--  <nav class="navbar navbar-light navbar-profile">
                    <button class="navbar-toggler hidden-sm-up" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar2" aria-controls="exCollapsingNavbar2" aria-expanded="false" aria-label="Toggle navigation"></button>
                    <div class="collapse navbar-toggleable-xs" id="exCollapsingNavbar2">
                        <ul class="nav navbar-nav float-xs-right">
                            <li class="nav-item active">
                                <a class="nav-link" href="#"><i class="icon-content-left"></i> Timeline <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="icon-head"></i> Profile</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="icon-briefcase4"></i> Projects</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="icon-heart6"></i> Favourites</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="icon-bell4"></i> Notifications</a>
                            </li>
                        </ul>
                    </div>
                </nav> -->
            </div>
        </div>
    </div>
    <section id="timeline" class="timeline-center timeline-wrapper">
        <h3 class="page-title text-xs-center">Timeline</h3>
        <ul class="timeline">
            <li class="timeline-line"></li>
            <li class="timeline-group">
                <a href="#" class="btn btn-primary"><i class="icon-calendar3"></i> <%=year%> year(s), <%=month%> month(s), <%=day%> Day(s)</a>
            </li>
        </ul>
        <ul class="timeline">
            <li class="timeline-line"></li>
            <li class="timeline-item">
                <div class="timeline-badge">
                    <span class="bg-red bg-lighten-1" data-toggle="tooltip" data-placement="right" title="Basic Details"><i class="icon-person"></i></span>
                </div>
                <div class="timeline-card card border-grey border-lighten-2">
                    <div class="card-header">
                <h4 class="card-title" style="color: red;">Basic Details</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table id="recent-orders" class="table table-hover mb-0"> 
                        <tbody>
                     	   <tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Name</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getSalutation()+" "+user.getFirstname()+" "+user.getMiddlename()+" "+user.getLastname()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Address</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getAdress()%></p></td>
                            		</tr>
                            		
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Gender</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getGender()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Birthdate</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text" ><%=ddMMMyyyy.format(yyyyMMdd.parse(user.getBirth_date()))%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Height</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text" ><%=user.getHeight()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Weight</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text" ><%=user.getWeight()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Identification Marks</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text" ><%=user.getIdentification_marks()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Language</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text" ><%=user.getLanguages()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Blood Group</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text" ><%=user.getBlood_group()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Email ID</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text" ><%=user.getPer_emailid()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Mobile No</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getMob_num()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Nationality</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getNationality()%></p></td>
                            		</tr>
                        
                        </tbody>
                    </table>
                </div>
            </div>
                </div>
            </li>
            
            <li class="timeline-item mt-3" >   <!-- style="margin-top: -11rem!important;" --> 
                <div class="timeline-badge">
                    <span class="bg-green bg-lighten-1" data-toggle="tooltip" data-placement="right" title="Company Details"><i class="icon-briefcase"></i></span>
                </div>
                <div class="timeline-card card border-grey border-lighten-2">
                     <div class="card-header">
                <h4 class="card-title" style="color: green;">Company Details</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table id="recent-orders" class="table table-hover mb-0">
                        <tbody>
                     	   <tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Company</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getCompanyListBean().getCompany_name()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Location</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getLocation()%></p></td>
                            		</tr>
                            		
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Department</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getDepartmentBean().getDepartment_name()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Sub Department</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getSub_department()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Designation</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getRoleBean().getRole_type()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Reporting Manager</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=manager_name%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Joining Date</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=ddMMMyyyy.format(yyyyMMdd.parse(user.getJoining_date()))%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Resource Cost</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getResource_cost()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Gross Salary</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getGross_salary()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Employee Status</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getEmployeeStatusBean().getEmployee_status_name()%></p></td>
                            		</tr>
                        </tbody>
                    </table>
                </div>
            </div>
                </div>
            </li>
            
            
            <li class="timeline-item" >               <!-- style="margin-top: -2rem!important; -->
                <div class="timeline-badge">
                    <span class="bg-pink bg-lighten-1" data-toggle="tooltip" data-placement="left" title="Account Details"><i class="icon-inr"></i></span>
                </div>
                <div class="timeline-card card border-grey border-lighten-2">
                    <div class="card-header">
                <h4 class="card-title" style="color: #FF1493;">Account Details</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table id="recent-orders" class="table table-hover mb-0">
                        <tbody>
                     	   <tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">PAN Card No.</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getPan_no()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Adhaar Card No.</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getAdhar_no()%></p></td>
                            		</tr>
                            		
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">PF UAN No.</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getPf_uan_no()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">ESIC No.</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getEsic_no()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Bank Account No.</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getBank_acount_no()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Bank Name	</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getBank_name()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Grade Code</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getGrade_code()%></p></td>
                            		</tr>
                        </tbody>
                    </table>
                </div>
            </div>
                </div>
            </li>
            
            <li class="timeline-item" style="margin-top: -4rem!important;">
                <div class="timeline-badge">
                    <span class="bg-blue bg-lighten-1" data-toggle="tooltip" data-placement="left" title="Education Qualification"><i class="icon-graduation-cap"></i></span>
                </div>
                <div class="timeline-card card border-grey border-lighten-2">
               <div class="card-header">
                <h4 class="card-title" style="color: blue;">Education Qualification</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table id="recent-orders" class="table table-hover mb-0">
                        <tbody>
                     	   <tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Basic Qualification</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getBasic_qualification()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Graduate Degree</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getGraduate_degree()%></p></td>
                            		</tr>
                            		
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Master Degree</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getMaster_degree()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Special Qualification</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getSpecial_qualification()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">ITI</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getIti_course()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Diploma</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getDiploma_course()%></p></td>
                            		</tr>
                            		
                            		<tr>
                            			<td style="padding: .25rem 1rem"><p class="card-text" style="font-weight: bold;">Special Interest</p></td>
                            			<td style="padding: .25rem 1rem"> <p class="card-text"><%=user.getSpecial_interest()%></p></td>
                            		</tr>
                        </tbody>
                    </table>
                </div>
            </div>
                </div>
            </li>
            
            
              <li class="timeline-item block">
                <div class="timeline-badge">
                    <a title="" data-context="inverse" data-container="body" class="border-silc" href="#" data-original-title="block highlight"></a>
                </div>
                <div class="timeline-card card border-grey border-lighten-2">
                    <div class="card-header">
                        <div class="text-xs-center">
                            <p><i class="icon-heartbeat font-medium-4 icon-bg-circle bg-red"></i></p>
                            <h4>Family Details</h4>
                        </div>
                    </div>
                    <div class="card-body collapse in">
                        <div class="card-block">
                            <div class="chart-container">
                              <table class="table table-bordered" id="mtable">
											<thead>
												<tr>
													<th>Sr No.</th>
													<th>Name</th>
													<th>Relation</th>
													<th>DOB</th>
													<th>Occupation</th>
													<th>Contact number</th>
													<th>Adhaar Card No.</th>
												</tr>
												
											</thead>
											<tbody>
											<% 
											AllListDAO allListDAO = new AllListDAO();
												List<FamilyDetailBean> listOfFamilyMember = allListDAO.getListOfFamilyMember(employee_master_id);
												for(int i = 0 ; i < listOfFamilyMember.size() ; i++){
													FamilyDetailBean f = listOfFamilyMember.get(i);
											%>
												<tr>
													<td><%=i+1 %></td>
													<td><%=f.getName()%></td>
													<td><%=f.getFamilyRelationBean().getRelation()%></td>
													<td><%=ddMMMyyyy.format(yyyyMMdd.parse(f.getDob()))%></td>
													<td><%=f.getOccupation()%></td>
													<td><%=f.getContact_number()%></td>
													<td><%=f.getAdhaar_number()%></td>
												</tr>
											<%} %>
											</tbody>
										</table>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            
           
        </ul>
        <!-- 2015 -->
        <ul class="timeline">
            <li class="timeline-line"></li>
            <li class="timeline-group">
                <a href="#" class="btn btn-primary"><i class="icon-calendar3"></i> Documents</a>
            </li>
        </ul>
        <ul class="timeline">
            <li class="timeline-line"></li>
            <!-- /.timeline-line -->
            <li class="timeline-item block">
                <div class="timeline-badge">
                    <a title="" data-context="inverse" data-container="body" class="border-silc" href="#" data-original-title="block highlight"></a>
                </div>
                <div class="timeline-card card border-grey border-lighten-2">
                    <div class="card-header">
                        <div class="text-xs-center">
                            <p class="mt-1"><i class="icon-image4  font-medium-4"></i></p>
                            <h4>Identify, Leave, Profile, Salary Documents</h4>
                        </div>
                    </div>
                    <!-- Image grid -->
                    <div class="card-body collapse in">
                        <div class="card-block my-gallery" itemscope itemtype="http://schema.org/ImageGallery">
                            <div class="row">
                            	<%
								AllListSelfServiceDAO allListSelfServiceDAO = new AllListSelfServiceDAO();
								List<SelfServiceQuerybean> listOfSelfServiceQuery = null;
							
							
								listOfSelfServiceQuery = allListSelfServiceDAO.SPgetListOfSelfServiceQueryByEmployeeId(employee_id);
								for (SelfServiceQuerybean s : listOfSelfServiceQuery) {

									String ext2 = FilenameUtils.getExtension(s.getAttachment());
							%>
                                <figure class="col-md-3 col-sm-6 col-xs-12" itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                                    <a href="#">
                                        <img class="img-thumbnail img-fluid" src="FileServlet?path=D:\hrms\upload\selfService\<%=s.getAttachment() %>" itemprop="thumbnail" alt="Image description" style="height: 200px;width: 250px;" />
                                    </a>
                                </figure>
                                <%} %>
                            </div>
                        </div>
                        <!--/ Image grid -->
                    </div>
                    <!--/ PhotoSwipe -->
                </div>
            </li>
        </ul>
        <ul class="timeline">
            <li class="timeline-line"></li>
            <li class="timeline-group">
                <a href="#" class="btn btn-primary"><i class="icon-calendar3"></i> <%=ddMMMyyyy.format(yyyyMMdd.parse(user.getJoining_date()))%></a>
            </li>
        </ul>
    </section>
</div>

        </div>
      </div>
    </div>
    
    <%@include file="footer.jsp"%>
    
    
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/charts/echarts/bar-column/stacked-column.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/charts/echarts/radar-chord/non-ribbon-chord.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
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