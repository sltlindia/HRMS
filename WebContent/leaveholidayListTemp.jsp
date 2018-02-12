<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.lms.dao.AllLMSListDAO"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
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
    <title>Holiday List</title>
    <link rel="apple-touch-icon" sizes="60x60" href="app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="app-assets/images/ico/apple-icon-76.png"> 
    <link rel="apple-touch-icon" sizes="120x120" href="app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/bootstrap-admin-template/robust/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="app-assets/images/ico/favicon-32.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/sliders/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="fusioncharts/js/fusioncharts.js"></script>
	<script type="text/javascript" src="fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
</head>
<%@include file="header.jsp" %>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">
<%
ArrayList<String> holiday = new ArrayList<String>();
AllLMSListDAO allListDAO = new AllLMSListDAO();
%>
<div class="app-content container center-layout mt-2">
<div class="row" align="center">
				   
				        <div class="card">
				        	 <div class="card-header">
					        <div class="card-header card-inverse" style="background-color: #90A4AE;padding: 0.5rem 0rem 1rem 0rem;height: 50px;">
				            </div>
				               <div class="card-body collapse in">
					                <div class="card-block border-bottom-blue-grey" style="border-left: 2px solid #607D8B;border-right: 2px solid #607D8B;">
					 <img alt="logo"
					src="img/SLTL.gif" height="169px" width="300px">
			
			<div>
			<font style="font-family: cursive;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	Hello All  <img alt="" src="img/smile.jpg" height="25px" width="25px">, <br>
			
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		kindly Visit Holiday List Page To The Holiday Of Year 2018.
			</font>
			</div>
			<br>
			  <div class="panel-body">
			  
			  
			  	<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
        			
        					<li class="nav-item">
								<a class="nav-link active" id="base-tab" href="#GUJ" aria-expanded="true" data-toggle="tab">Gujarat
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#Surat" aria-expanded="true" data-toggle="tab">Surat
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#Delhi" aria-expanded="true" data-toggle="tab">Delhi
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#kerala" aria-expanded="true" data-toggle="tab">Kerala
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#Karnataka" aria-expanded="true" data-toggle="tab">Karnataka
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#Mumbai" aria-expanded="true" data-toggle="tab">Maharastra
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#Tamilnadu" aria-expanded="true" data-toggle="tab">Tamilnadu
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-tab" href="#andhrapradesh" aria-expanded="true" data-toggle="tab">Andhra pradesh
								</a>
							</li>
						</ul>
                     
</div>
                            <div class="tab-content" align="center">
                            
                       
                       <div class="tab-pane fade in active" id="GUJ">
                                   <br>
                                   <h4> Gujarat </h4>
                  <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"  align="center"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d1 = null;	
										List<HolidayBean> listofholiday1  = allListDAO.getListOfHolidayGujarat();
										String day1 = null;
										for(HolidayBean h : listofholiday1)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d1 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day1 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day1 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day1 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day1 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day1 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day1 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day1 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d1  %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day1 %>
									</td>
									</tr>
									<%}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

           </div>              
                                
                           
                                 <div class="tab-pane fade" id="Surat">   
                        
                              <br>
                                     <div class="row">
                                    	<div class="col-md-6">
                                    		<h4>Surat</h4>
                                    	</div>
                                    	
                                    </div>
           <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d8 = null;	
									
										List<HolidayBean> listofholiday8  = allListDAO.getListOfHolidaySurat();
										String day8 = null;
										for(HolidayBean h : listofholiday8)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d8 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day8 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day8 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day8 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day8 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day8 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day8 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day8 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d8  %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day8 %>
									</td>
									</tr>
									<%}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
                                <div class="tab-pane fade" id="Delhi">
                          
                         
                        
                                    <br>
                                     <div class="row">
                                    	<div class="col-md-6">
                                    		<h4>	Delhi	</h4>
                                    	</div>
                                    	
                                    </div>
           <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d2 = null;	
										List<HolidayBean> listofholiday2  = allListDAO.getListOfHolidayDelhi();
										String day2 = null;
										for(HolidayBean h : listofholiday2)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d2 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day2 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day2 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day2 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day2 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day2 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day2 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day2 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d2  %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day2 %>
									</td>
									</tr>
									<%}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

                                </div>
                                
                                
                                
                       <!-- OD Tab -->   
                               
                               
                           
                          <div class="tab-pane fade" id="kerala">   
                        
                              <br>
                                     <div class="row">
                                    	<div class="col-md-6">
                                    		<h4> kerala </h4>
                                    	</div>
                                    	
                                    </div>
           <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d3 = null;	
									
										List<HolidayBean> listofholiday3  = allListDAO.getListOfHolidaykerala();
										String day3 = null;
										for(HolidayBean h : listofholiday3)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d3 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day3 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day3 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day3 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day3 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day3 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day3 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day3 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d3  %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day3 %>
									</td>
									</tr>
									<%}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
			
			
			  <div class="tab-pane fade" id="Karnataka">
                         
                          
                      
                                   <br>
                                   <h4>Karnataka</h4>
                  <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d4 = null;	
										List<HolidayBean> listofholiday4  = allListDAO.getListOfHolidaykarnataka();
										String day4 = null;
										for(HolidayBean h : listofholiday4)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d4 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day4 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day4 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day4 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day4 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day4 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day4 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day4 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d4 %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day4 %>
									</td>
									</tr>
									<%}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

           </div>              
                                
                                
                                
                        <!-- CO Tab -->     
                               
                                <div class="tab-pane fade" id="Mumbai">
                          
                         
                        
                                    <br>
                                     <div class="row">
                                    	<div class="col-md-6">
                                    		<h4>Mumbai</h4>
                                    	</div>
                                    	
                                    </div>
           <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d5 = null;	
										List<HolidayBean> listofholiday5  = allListDAO.getListOfHolidayMumbai();
										String day5 = null;
										for(HolidayBean h : listofholiday5)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d5 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day5 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day5 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day5 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day5 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day5 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day5 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day5 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d5  %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day5 %>
									</td>
									</tr>
									<%}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

                                </div>
                                
                                
                                
                       <!-- OD Tab -->   
                               
                               
                           
                          <div class="tab-pane fade" id="Tamilnadu">   
                        
                              <br>
                                     <div class="row">
                                    	<div class="col-md-6">
                                    		<h4>Tamilnadu</h4>
                                    	</div>
                                    	
                                    </div>
           <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d6 = null;	
									
										List<HolidayBean> listofholiday6  = allListDAO.getListOfHolidayTamilNadu();
										String day6 = null;
										for(HolidayBean h : listofholiday6)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d6 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day6 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day6 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day6 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day6 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day6 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day6 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day6 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d6  %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day6 %>
									</td>
									</tr>
									<%}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	  
                          <div class="tab-pane fade" id="andhrapradesh">   
                        
                              <br>
                                     <div class="row">
                                    	<div class="col-md-6">
                                    		<h4>Andhra pradesh</h4>
                                    	</div>
                                    	
                                    </div>
           <div class="row">
					<div class="col-lg-6">
						<div class="panel panel-primary">
							<div class="panel-heading"> <h4>SLTL Holiday List - 2018</h4></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper">
									<table class="table table-striped table-bordered table-hover" >
									<!-- id="dataTables-example" -->
										<thead>
											<tr >
												<th style="text-align:center">Holiday Date </th>
												<th style="text-align:center">Holiday Name</th>	
												<th style="text-align:center">Holiday Day</th>					
											</tr>
										</thead>
									<tbody>
									<%
									String d7 = null;	
									
										List<HolidayBean> listofholiday7  = allListDAO.getListOfHolidayAndraPradesh();
										String day7 = null;
										for(HolidayBean h : listofholiday7)
										{
											
											String date = h.getHoliday_date();
											
												try {
													  
													SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
												Date result2 = formater1.parse(date);
													SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MM-yyyy");
													d7 = AppDateFormat.format(result2);
													//System.out.println(d1);
													//holiday.add(d1);
													
													Calendar cal = Calendar.getInstance();
													cal.setTime(result2);
													if(result2.getDay() == 0)
													{
														System.out.println("SUNDAY");
														day7 = "Sunday";
													}
													else if(result2.getDay() == 1)
													{
														System.out.println("Monday");
														day7 = "Monday";
													}
													else if(result2.getDay() == 2)
													{
														System.out.println("TUESDAY");
														day7 = "Tuesday";
													}
													else if(result2.getDay() == 3)
													{
														System.out.println("WEDNESDAY");
														day7 = "Wednesday";
													}
													else if(result2.getDay() == 4)
													{
														System.out.println("THURSDAY");
														day7 = "Thursday";
													}
													else if(result2.getDay() == 5)
													{
														System.out.println("FRIDAY");
														day7 = "Friday";
													}
													else if(result2.getDay() == 6)
													{
														System.out.println("SATURDAY");
														day7 = "Saturday";
													}
																
													
												} catch (ParseException e1) {
													e1.printStackTrace();
												}	
										%>
									<tr>
									
									<td align="center">
									<%= d7  %>
									</td>
									<td align="center">
									<%= h.getHoliday_name() %>
									</td>
									<td align="center">
									<%= day7 %>
									</td>
									</tr>
									<%}
									%>
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
				$(document).ready(function() {
					$('#dataTables-example').DataTable({
						responsive : true
					});
				});

			</script> 
			 <!-- FOOTER -->
    
    <!--END FOOTER -->

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
   <!--  <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script> -->
        
     <!--END PAGE LEVEL SCRIPTS -->									
</body>
</html>