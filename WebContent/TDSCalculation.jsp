<%@page import="java.util.Calendar"%>
<%@page import="com.hrms.tds.bean.PerformancePayBean"%>
<%@page import="com.hrms.tds.bean.PayrollBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalBBean"%>
<%@page import="com.hrms.tds.dao.PayrollList"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.timesheet.bean.HolidayBean"%>
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
    <title>TDS Calculation</title>
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
<%
		
ArrayList<String> holiday = new ArrayList<String>();
ArrayList<String> holidayName = new ArrayList<String>();
ArrayList<String> holidayDate = new ArrayList<String>();		

%>

<%
								AllLMSListDAO allListDAO2 = new AllLMSListDAO();
								List<HolidayBean> listgholiday = allListDAO2.getListOfHoliday();
								for(HolidayBean h : listgholiday)
								{
									/* SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
									Date result = formater.parse(h.getHoliday_date());
									System.out.println(result.toString()); */
									
									
									String date = h.getHoliday_date();
									String Name = h.getHoliday_name();
									String d1 = null;	
									String d2 = null;
										try {
											  
											SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
											Date result2 = formater1.parse(date);
											SimpleDateFormat AppDateFormat = new SimpleDateFormat("MM/dd/yyyy");
											SimpleDateFormat AppDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
											d1 = AppDateFormat.format(result2);
											d2 = AppDateFormat1.format(result2);
											//System.out.println("date:"+d1);
											holiday.add(d1);
											holidayDate.add(d2);
											holidayName.add(Name);
										} catch (ParseException e1) {
											e1.printStackTrace();
										}	
									
								}
								%>

<%@include file="header.jsp"%>
<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script>
 -->
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">


<script type="text/javascript">
	
</script>
<style type="text/css">
.txt {
	text-align: center;
	line-height: 10vh;
}

.txt1 {
	text-align: center;
	line-height: 3vh;
}

.txt2 {
	text-align: center;
	line-height: 6vh;
}

.txt3 {
	text-align: center;
	line-height: 50vh;
}
#tablePadding{
	padding: 2px 5px;
}
#modalPadding{
	padding: 8px 8px;
}
</style>

<script type="text/javascript">
	function codeAddress()
	{
		var total_month = $("#total_month").val();
	
		$(document).ready(function() {
			$("#LandlordDetail").hide();
			//$("#HouseLoanPrincipal").prop('disabled',true);
		});

		$(document).ready(function() {
			$("#HouseLoanDetail").hide();
			//$("#first").hide();
		});

		$(document).ready(function() {
			$("#nonMetro1").show();
			$("#totalBasicNonMetro").show();
			$("#rentSlipNonMetro").show();
			$("#actualHRANonMetro").show();
			$("#nonMetroDeduction").show();

			$("#metro").hide();
			$("#totalBasicMetro").hide();
			$("#rentSlipMetro").hide();
			$("#actualHRAMetro").hide();
			$("#metroDeduction").hide();
		});
		
		$(document).ready(function() {
			
			<%
			 if(user.getMealcard().equals("TRUE"))
			 {
			%>
			$("#yearly").show();
			$("#monthly").hide();
			document.getElementById("result").value = "Yearly";
			var days = 300 ;
			var mealCard = (days * 100) ;
			document.getElementById("MealCardDeduction").value = mealCard;
			document.getElementById("MealCard1").value = mealCard;
			<%}
			else
			{%>
			
			document.getElementById("MealCardDeduction").value = 0;
			
		<%}%>
		});
		
		$(document).ready(function() {
			$("#cash").hide();
			$("#cheque").hide();
			$("#DoneeDetail").hide();
			
		});
		
		$(document).ready(function() {
			document.getElementById("checked").value = "Non-Metro";			
		});
		
		 $(document).ready(function(){
			//alert("CONN");
			var Conv = $("#Conveyance").val();
			
			//alert("MONTH: "+total_month);
			var Convayance = ( Conv * total_month ) ;
			document.getElementById("Conveyance").value = Convayance;
			//alert("Convayance :" + Convayance);
			if(Convayance >= 19200){
				document.getElementById("Conveyance1").value = 19200;
			}else if(Convayance < 19200){
				document.getElementById("Conveyance1").value = Convayance;
			}
			
		}); 
		 
		$(document).ready(function(){
			
		});
		 
		var totalBasicNonMetro = 0,totalBasicMetro = 0, totalRentNonMetro1 = 0;
		$(document).ready(function(){
			var bs = $("#totalBasic1").val();
			//alert("BASIC SALARY :" + bs);
			var basicSalary = ( bs * total_month);
			document.getElementById("totalBasic1").value = basicSalary ;
			
			totalBasicNonMetro = ((basicSalary * 40) / 100);
			totalBasicMetro = ((basicSalary * 50) / 100);
			
			totalRentNonMetro1 = ((basicSalary * 10) / 100);
			document.getElementById("rentSlipNonMetro").value = totalRentNonMetro1;
			document.getElementById("rentSlipMetro").value = totalRentNonMetro1;

			document.getElementById("totalBasicNonMetro").value = totalBasicNonMetro;
			document.getElementById("totalBasicMetro").value = totalBasicMetro;
			
		}); 
		
		$(document).ready(function(){
			var hra = $("#actualHRA").val();
			var actualHRA = ( hra * total_month);
			
			document.getElementById("actualHRA").value = actualHRA ;
			document.getElementById("actualHRANonMetro").value = actualHRA;
			document.getElementById("actualHRAMetro").value = actualHRA;
			
			var minMetro = Math.min(totalBasicMetro, totalRentNonMetro1, actualHRA);
			document.getElementById("metroDeduction").value = minMetro;
			
			var minNonMetro = Math.min(totalBasicNonMetro, totalRentNonMetro1, actualHRA);
			document.getElementById("nonMetroDeduction").value = minNonMetro;
			//alert("MIN METRO :"+minMetro);  
		});
		
		$(document).ready(function(){
			var med_allw = $("#Medical").val();
			var medicalAllowance = ( med_allw * total_month);
			document.getElementById("Medical").value = medicalAllowance;
			if( medicalAllowance >= 15000)
				{
					document.getElementById("MedicalDeduction").value = 15000;
				}
			else
				{
					document.getElementById("MedicalDeduction").value = medicalAllowance;
				}
		});
		
		$(document).ready(function(){
			var ptax = $("#PTAX").val();
			var PTAX = ( ptax * total_month );
			document.getElementById("PTAX").value = PTAX ;
		});
		
		$(document).ready(function(){
			var lta = $("#LTABillSalary").val();
			var annual_lta = ( lta * total_month );
			document.getElementById("LTABillSalary").value = annual_lta;
		});
		
		$(document).ready(function(){
			var edu_allw = $("#eduAllow").val();
			var annual_edu_allw = ( edu_allw * total_month );
			document.getElementById("eduAllow").value = annual_edu_allw;
		});
		
		$(document).ready(function(){
			var uni_allw = $("#UniformAllowance").val();
			var annual_uni_allw = ( uni_allw * total_month );
			document.getElementById("UniformAllowance").value = annual_uni_allw;
			
			document.getElementById("part5self").innerHTML = 0.0;
			document.getElementById("part2self").innerHTML = 0.0;
		});
		
		/* $(document).ready(function() {
			var days = 300 ;
			
			
			var mealCard = (days * 100) ;
			document.getElementById("MealCard").value = mealCard;
		}); */

		$(document).ready(function() {
			var birth = new Date($("#birth").val());
			//var birthdate = birth.getFullYear()+"-"+(birth.getMonth()+1)+"-"+birth.getDate();
			//alert("birth date:" + birth);

			var now = new Date();
			//var currentdate = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();
			//alert("current date:" + now);

			var diff = now.getTime() - birth.getTime();
			var years = Math.floor(diff / 31536000000); // end - start return difference in milliseconds 
			//alert("age" + years); // get days */
			document.getElementById("age").value = years;
			
			var gender = $("#gender").val();
			//alert("Gender :"+gender);
			
			if(years >= 60)
			{
				if(gender == "Female")
					{
						$("#adult").hide();
						$("#senior").hide();
						$("#female").show();
					}
				else if(gender == "Male")
					{
						$("#adult").hide();
						$("#senior").show();
						$("#female").hide();
					}
			}else if(years < 60)
			{
				if(gender == "Female")
					{
						$("#senior").hide();
						$("#adult").hide();
						$("#female").show();
					}
				else if(gender == "Male")
					{
						$("#senior").hide();
						$("#adult").show();
						$("#female").hide();
					}
				
			}
		});
		temp();
	}
	window.onload = codeAddress;
	
	function temp() {
		totalBasic = document.getElementById("totalBasic").value;
		Bonus = document.getElementById("Bonus").value;
		Incentive = document.getElementById("Incentive").value;
		PreviousSalary = document.getElementById("PreviousSalary").value;
		Performance = document.getElementById("Performance").value;
		Leave = document.getElementById("Leave").value;
		//FullAndFinalLeave = document.getElementById("Full&FinalLeave").value;
		//FullAndFinalBonus = document.getElementById("Full&FinalBonus").value;

		if ((isNaN(totalBasic))
				|| (isNaN(Bonus))
				|| (isNaN(Incentive))
				|| (isNaN(PreviousSalary))
				|| (isNaN(Performance))
				|| (isNaN(Leave) /* || (isNaN(FullAndFinalLeave)) || (isNaN(FullAndFinalBonus)) */)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if ((totalBasic < 0) || (Bonus < 0) || (Incentive < 0)
				|| (PreviousSalary < 0) || (Performance < 0) || (Leave < 0)
		/* || (FullAndFinalLeave < 0) || (FullAndFinalBonus < 0) */) {
			alert("Negative value not allowed");
		} else if (TotalGrossIncome.length != 0) {
			TotalGrossIncome = parseFloat(totalBasic) + parseFloat(Bonus)
					+ parseFloat(Incentive) + parseFloat(Leave)
					+ parseFloat(PreviousSalary) + parseFloat(Performance)
			/* + parseFloat(FullAndFinalLeave) + parseFloat(FullAndFinalBonus) */;
			document.getElementById("TotalGrossIncome").value = TotalGrossIncome.toFixed(2);
		}
		//TotalB();
		Redirect();
	}

	function BasicCalculation() {
		//alert("basic");
		var totalBasic1 = document.getElementById("totalBasic1").value;
		//alert("totalBasic" + totalBasic1);
		if (isNaN(totalBasic1)) {
			//alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (totalBasic1 < 0) {
			//alert("Negative value not allowed");
		} else if (totalBasic1.length != 0) {
			var totalBasicNonMetro = 0;
			var totalBasicMetro = 0;
			totalBasicNonMetro = ((totalBasic1 * 40) / 100);
			totalBasicMetro = ((totalBasic1 * 50) / 100);

			document.getElementById("totalBasicNonMetro").value = totalBasicNonMetro;
			document.getElementById("totalBasicMetro").value = totalBasicMetro;
		}
		cal();
	}

	function calculateRent(id) {
		var totalRent = document.getElementById(id).value;
		totalRent = parseFloat(totalRent);
		//alert(totalRent);
		var totalBasic = document.getElementById("totalBasic1").value;
		totalBasic = parseFloat(totalBasic);
		//alert(totalBasic);
		if (isNaN(totalRent)) {
			//alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (totalRent < 0) {
			alert("Negative value not allowed");
		} else if (totalRent >= 100000) {
			//alert("Please fill landlord details");
			$(document).ready(function() {
				$("#LandlordDetail").show();
			});
			var totalRentNonMetro = 0;
			if(totalRent > totalBasic)
				{
				//alert("if");
					totalRentNonMetro = (totalRent - ((totalBasic * 10) / 100));
					document.getElementById("rentSlipNonMetro").value = totalRentNonMetro.toFixed(2);
					document.getElementById("rentSlipMetro").value = totalRentNonMetro.toFixed(2);
				}else if(totalRent <= totalBasic)
				{
					//alert("else");
					totalRentNonMetro = (((totalBasic * 10) / 100) - totalRent);
					document.getElementById("rentSlipNonMetro").value = totalRentNonMetro.toFixed(2);
					document.getElementById("rentSlipMetro").value = totalRentNonMetro.toFixed(2);
				}
			}
		 	else if (totalRent.length != 0) {
				$(document).ready(function() {
					$("#LandlordDetail").hide();
				});
				var totalRentNonMetro = 0;
				if(totalRent > totalBasic)
				{
					//alert("IF");
					totalRentNonMetro = (totalRent - ((totalBasic * 10) / 100));
					document.getElementById("rentSlipNonMetro").value = totalRentNonMetro.toFixed(2);
					document.getElementById("rentSlipMetro").value = totalRentNonMetro.toFixed(2);
				}else if(totalRent <= totalBasic)
				{
					//alert("ELSE");
					totalRentNonMetro = (((totalBasic * 10) / 100) - totalRent);
					document.getElementById("rentSlipNonMetro").value = totalRentNonMetro.toFixed(2);
					document.getElementById("rentSlipMetro").value = totalRentNonMetro.toFixed(2);
				}
			}
		cal();
	}

	function calculateHRA(id) {
		var actualHRA = document.getElementById(id).value;
		if (isNaN(actualHRA)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (actualHRA < 0) {
			alert("Negative value not allowed");
		} else if (actualHRA.length != 0) {

			document.getElementById("actualHRANonMetro").value = actualHRA;
			document.getElementById("actualHRAMetro").value = actualHRA;
		}

		cal();

	}

	function cal() {

		var a = document.getElementById("totalBasicNonMetro").value;
		var b = document.getElementById("rentSlipNonMetro").value;
		var c = document.getElementById("actualHRANonMetro").value;

		var d = document.getElementById("totalBasicMetro").value;
		var e = document.getElementById("rentSlipMetro").value;
		var f = document.getElementById("actualHRAMetro").value;

		if (a == 0 || d == 0) {
			//alert("SKY");
			var minNonMetro = Math.min(b, c);
			var minMetro = Math.min(e, f);
			document.getElementById("metroDeduction").value = minMetro;
			document.getElementById("nonMetroDeduction").value = minNonMetro;
		}
		if (b == 0 || e == 0) {
			//alert("SSKY");
			var minMetro = Math.min(d, f);
			var minNonMetro = Math.min(a, c);
			document.getElementById("metroDeduction").value = minMetro;
			document.getElementById("nonMetroDeduction").value = minNonMetro;
		} else if (c == 0 || f == 0) {
			//alert("SSSKY");
			var minMetro = Math.min(d, e);
			var minNonMetro = Math.min(a, b);
			document.getElementById("metroDeduction").value = minMetro;
			document.getElementById("nonMetroDeduction").value = minNonMetro;
		} else if ((a != 0 && b != 0 && c != 0) && (d != 0 && e != 0 && f != 0)) {
			var minNonMetro = Math.min(a, b, c);
			var minMetro = Math.min(d, e, f);

			document.getElementById("metroDeduction").value = minMetro;
			document.getElementById("nonMetroDeduction").value = minNonMetro;
		}

	}
	
	function tempConveyance(){
		//alert("shruti");
		var Conveyance = document.getElementById("Conveyance").value;
		//alert(Conveyance);
		if (isNaN(Conveyance)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} 
		else if(Conveyance >= 19200){
			document.getElementById("Conveyance1").value = 19200;
		}else if(Conveyance < 19200){
			document.getElementById("Conveyance1").value = Conveyance;
		}
		
		
	}

	/* function Conveyance() {
		alert("Conveyance");
		var Conveyance = document.getElementById("Conveyance").value;
		if (Conveyance >= 19200) {
			document.getElementById("Conveyance1").value = 19200;
		} else {
			document.getElementById("Conveyance1").value = Conveyance;
		}

	} */

	function tempMedical() {
		//alert("sp");
		var MedicalBill = document.getElementById("Medical").value;
		var ProvidedMedicalBills = document.getElementById("ProvidedMedicalBills").value;
		//alert(ProvidedMedicalBills);
		var PermissibleDeduction = document.getElementById("PermissibleDeduction").value;
		alert("Max Value Of Medical Bill Is 15000");
		if (isNaN(MedicalBill) || isNaN(ProvidedMedicalBills) || isNaN(PermissibleDeduction)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (MedicalBill < 0 || ProvidedMedicalBills < 0 || PermissibleDeduction < 0) {
			alert("Negative value not allowed");
		}else if (ProvidedMedicalBills > 0) {
			var deduction = Math.min(MedicalBill, ProvidedMedicalBills, PermissibleDeduction);
			document.getElementById("MedicalDeduction").value = deduction;
		}else if(ProvidedMedicalBills == 0){
			var deduction1 = Math.min(MedicalBill, PermissibleDeduction);
			document.getElementById("MedicalDeduction").value = deduction1;
		}
			
	}
	
	function MealCard(id) {
		var MealCard = document.getElementById("MealCard1").value;
		if (MealCard < 300) {
			var m = (MealCard * 100)
			document.getElementById("MealCardDeduction").value = m;
		} else {
			alert("maximum limit 300 days..");
			document.getElementById("MealCardDeduction").value = 0;
		}
		/* if (MealCard >= 15000) {
			document.getElementById("MealCardDeduction").value = 15000;
		} else {
			document.getElementById("MealCardDeduction").value = MealCard;
		} */
	}
	
	function tempLTA(id){
		tempLTACal();
	}

	function tempLTACal(){
		var LTABillSalary = document.getElementById("LTABillSalary").value;
		var LTABill = document.getElementById("LTABill").value;
		if (isNaN(LTABillSalary) || isNaN(LTABill)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if ((LTABill < 0) || (LTABillSalary < 0)) {
			alert("Negative value not allowed");
		}
		var minval = Math.min(LTABillSalary, LTABill);

		document.getElementById("actualLTABill").value = minval;
		CalculateTotalHRA();
	}
	/* function LTA(id) {

		
		LTACal();
	} */

	/* function LTACal() {

	
		var LTABillSalary = document.getElementById("LTABillSalary").value;
		var LTABill = document.getElementById("LTABill").value;

		var minval = Math.min(LTABillSalary, LTABill);

		document.getElementById("actualLTABill").value = minval;
		CalculateTotalHRA();

	} */

	function tempEducation(id) {
		var EducationLoan = document.getElementById("EducationLoan").value;
		var actualEducation = 0;
		if (EducationLoan == 1) {
			actualEducation = (1 * 1200);

		} else if (EducationLoan == 2) {
			actualEducation = (2 * 1200);

		} else if (EducationLoan > 2) {
			actualEducation = (2 * 1200);

		} else if (EducationLoan < 0) {
			alert("Negative is not allowed");
			actualEducation = 0;
			document.getElementById("EducationLoan").value = 0;
		}
		document.getElementById("actualEducation").value = actualEducation;
	}

	function tempUniformAllowance(id) {

		var UniformAllowance = document.getElementById("UniformAllowance").value;
		var ActualUniformAllowance = document
				.getElementById("ActualUniformAllowance").value;
		if (isNaN(UniformAllowance) || isNaN(ActualUniformAllowance)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if ((UniformAllowance < 0) || (ActualUniformAllowance < 0)) {
			alert("Negative value not allowed");
			 document.getElementById("UniformAllowance").value = 0;
			document.getElementById("ActualUniformAllowance").value = 0;
			//document.getElementById("MinUniformAllowance").value = ""; 
		}
		var minUniformAllowance = Math.min(UniformAllowance,
				ActualUniformAllowance);

		if (minUniformAllowance >= 15000) {
			document.getElementById("MinUniformAllowance").value = 15000;
		} else {
			document.getElementById("MinUniformAllowance").value = minUniformAllowance;
		}
	}

	function Redirect() {
		var TotalGrossIncome = document.getElementById("TotalGrossIncome").value;
		document.getElementById("TotalGross").value = TotalGrossIncome;

		var Conveyance1 = document.getElementById("Conveyance1").value;
		document.getElementById("PermissibleConveyance").value = Conveyance1;

		var nonMetroDeduction = document.getElementById("nonMetroDeduction").value;
		var metroDeduction = document.getElementById("metroDeduction").value;
		var flag = document.getElementById("checked").value;
		//alert("Checkbox" + flag);
		if (flag == "Metro") {
			document.getElementById("HouseRant").value = metroDeduction;
		} else {
			document.getElementById("HouseRant").value = nonMetroDeduction;
		}

		var MedicalDeduction = document.getElementById("MedicalDeduction").value;
		document.getElementById("MedicalBill").value = MedicalDeduction;

		var MealCardDeduction = document.getElementById("MealCardDeduction").value;
		
		//alert("QWERTTY" +MealCardDeduction );
		var MealCardDeduction1 = document.getElementById("MealCardDeduction1").value;
		var result = document.getElementById("result").value;
	//	alert("Checkbox" + result);
		if(result == "Yearly"){
			document.getElementById("MealCard").value = MealCardDeduction;
		}else{
			document.getElementById("MealCard").value = MealCardDeduction1;
		}

		var actualLTABill = document.getElementById("actualLTABill").value;
		document.getElementById("LTA").value = actualLTABill;

		var Uniform = document.getElementById("MinUniformAllowance").value;
		document.getElementById("Uniform").value = Uniform;

		var Education = document.getElementById("actualEducation").value;
		document.getElementById("Education").value = Education;

		TotalB();
	}

	function TotalB() {
		var Conveyance = document.getElementById("PermissibleConveyance").value;
		//alert("Conveyance:" + Conveyance)
		var FinalHouseRant = document.getElementById("HouseRant").value;
		var FinalMedicalBill = document.getElementById("MedicalBill").value;
		var MealCard = document.getElementById("MealCard").value;
		//alert("MealCard"+MealCard);
		var FinalLTA = document.getElementById("LTA").value;
		var PTAX = document.getElementById("PTAX").value;
		//alert("done");
		var FinalEducation = document.getElementById("Education").value;
		var FinalUniform = document.getElementById("Uniform").value;

		TotalHRA = parseFloat(FinalHouseRant) + parseFloat(FinalMedicalBill)
				+ parseFloat(FinalLTA) + parseFloat(FinalEducation)
				+ parseFloat(FinalUniform) + parseFloat(Conveyance)
				+ parseFloat(MealCard) + parseFloat(PTAX);

		document.getElementById("TotalB").value = TotalHRA.toFixed(2);

		var TotalGross = document.getElementById("TotalGross").value;
		//alert("TotalGrossIncome" + TotalGross);
		var Total = parseFloat(TotalGross) - parseFloat(TotalHRA);
		document.getElementById("TotalAB").value = Total.toFixed(2);
		document.getElementById("part1").innerHTML = Total.toFixed(2);
		calculateBasic();
	}

	function Loan() {
		//alert("SHRUTI");
		var HouseLoanInterest = document.getElementById("HouseLoan1").value;
		//alert("hello");
		if (isNaN(HouseLoanInterest)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (HouseLoanInterest < 0) {
			alert("Negative value not allowed");
		}
		else if (HouseLoanInterest >= 200000) {
			//alert("if");
			document.getElementById("HouseLoanDeduction").value = 200000;
			$(document).ready(function() {
				$("#HouseLoanDetail").show();
			});
		} else if(HouseLoanInterest < 200000){
			//alert("else");
			document.getElementById("HouseLoanDeduction").value = HouseLoanInterest;
			$(document).ready(function() {
				$("#HouseLoanDetail").hide();
			});
		}
		
		if(HouseLoanInterest != 0){
			document.getElementById("HouseLoanPrincipal").readOnly = false;
		}
	}

	function LoanRedirect() {
		var HouseLoanDeduction = document.getElementById("HouseLoanDeduction").value;
		document.getElementById("HouseLoan").value = HouseLoanDeduction;

		calculateBasic();
	}

	var OtherIncome = 0, HouseLoan = 0, TotalC = 0;
	function calculateBasic() {

		OtherIncome = parseFloat(document.getElementById("OtherIncome").value);
		HouseLoan = parseFloat(document.getElementById("HouseLoan").value);

		//alert('houseLoan:' + HouseLoan);
		//alert('OtherIncome:' + OtherIncome);

		if ((isNaN(OtherIncome)) || (isNaN(HouseLoan))) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		}

		else if (TotalC.length != 0.0) {
			if(OtherIncome >= HouseLoan)
			{
				
				//alert("OtherIncome is higher");
				Total2 = parseInt(OtherIncome) - parseInt(HouseLoan);
				document.getElementById("totalc").value = Total2.toFixed(2);
				document.getElementById("part2self").innerHTML = Total2.toFixed(2);
				
			}else if(HouseLoan > OtherIncome)
				{
					//alert("houseloan is higher");
					Total2 = parseInt(HouseLoan) - parseInt(OtherIncome);
					document.getElementById("totalc").value = Total2.toFixed(2);
					document.getElementById("part2self").innerHTML = Total2.toFixed(2);
				}else if(OtherIncome == 0){
					document.getElementById("totalc").value = 0.0;
					document.getElementById("part2self").innerHTML = 0.0;
				} 
			
			var TotalAB = document.getElementById("TotalAB").value;
			//alert("total b :" + TotalAB);
			TotalC = parseFloat(TotalAB) + parseFloat(OtherIncome)
					- parseFloat(HouseLoan);
			document.getElementById("TotalC").value = TotalC.toFixed(2);
			document.getElementById("part2").innerHTML = TotalC.toFixed(2);
			 
		}
		calculateSection80C();
		calculateNPS();
	}
	
	var LifeInsurance = 0, EPF = 0, PPF = 0, NSC = 0, MF = 0, TuitionFees = 0, StampDuty = 0, HouseLoanPrincipal = 0, TaxSaverFixDeposit = 0, Other = 0;
	function calculateSection80C() {

		LifeInsurance = document.getElementById("LifeInsurance").value;
		EPF = document.getElementById("EPF").value;
		PPF = document.getElementById("PPF").value;
		NSC = document.getElementById("NSC").value;
		MF = document.getElementById("MF").value;
		TuitionFees = document.getElementById("TuitionFees").value;
		StampDuty = document.getElementById("StampDuty").value;
		HouseLoanPrincipal = document.getElementById("HouseLoanPrincipal").value;
		TaxSaverFixDeposit = document.getElementById("TaxSaverFixDeposit").value;
		Other = document.getElementById("Other").value;

		if ((isNaN(LifeInsurance)) || (isNaN(EPF)) || (isNaN(PPF))
				|| (isNaN(NSC)) || (isNaN(MF)) || (isNaN(TuitionFees))
				|| (isNaN(StampDuty)) || (isNaN(HouseLoanPrincipal))
				|| (isNaN(TaxSaverFixDeposit)) || (isNaN(Other))) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if ((LifeInsurance < 0) || (EPF < 0) || (PPF < 0) || (NSC < 0)
				|| (MF < 0) || (TuitionFees < 0) || (StampDuty < 0)
				|| (HouseLoanPrincipal < 0) || (TaxSaverFixDeposit < 0)
				|| (Other < 0)) {
			alert("Negative value not allowed");
		} else if (TotalD.length != 0) {
			TotalD = parseFloat(LifeInsurance) + parseInt(EPF) + parseInt(PPF)
					+ parseFloat(NSC) + parseFloat(MF) + parseFloat(TuitionFees)
					+ parseFloat(StampDuty) + parseFloat(HouseLoanPrincipal)
					+ parseFloat(TaxSaverFixDeposit) + parseFloat(Other);
			document.getElementById("TotalD").value = TotalD.toFixed(2);

			var totalc = document.getElementById("TotalC").value ;
			var totald = 0.0 ;
			if (TotalD >= 150000) {
				document.getElementById("80CTotal").value = 150000;
				document.getElementById("part3self").innerHTML = 150000.00;
				
				totald = parseInt(totalc) - 150000 ;
				document.getElementById("totalD").value = totald.toFixed(2);
				document.getElementById("part3").innerHTML = totald.toFixed(2);
			} else {
				document.getElementById("80CTotal").value = TotalD.toFixed(2);
				document.getElementById("part3self").innerHTML = TotalD.toFixed(2);
				
				totald = parseInt(totalc) - TotalD.toFixed(2) ;
				document.getElementById("totalD").value = totald.toFixed(2);
				document.getElementById("part3").innerHTML = totald.toFixed(2);
			}
		}
		calculateNPS();
	}

	var NPS1 = 0;
	function tempNPS() {
		//	alert("NPS");
		NPS1 = document.getElementById("NPS1").value;
		if ((isNaN(NPS1))) {
			document.getElementById(id).value = "";
		} else if ((NPS1 < 0)) {
			alert("Negative value not allowed");
			document.getElementById("NPSDeduction").value = 0;
		} else if (NPS1 >= 50000) {
			document.getElementById("NPSDeduction").value = 50000;
		} else if (NPS1 < 50000) {
			document.getElementById("NPSDeduction").value = NPS1;
		}
	}

	var RGESS1 = 0;
	function tempRGESS() {
		RGESS1 = document.getElementById("RGESS1").value;
		if ((isNaN(RGESS1))) {
			document.getElementById(id).value = "";
		} else if ((RGESS1 < 0)) {
			alert("Negative value not allowed");
			document.getElementById("RGESSDeduction").value = 0;
		} else if (RGESS1 > 50000) {

			var RGESSvalue = 0;
			RGESSvalue = ((RGESS1 * 50) / 100);
			//document.getElementById("RGESSDeduction").value = RGESSvalue;

			if (RGESSvalue > 50000) {
				document.getElementById("RGESSDeduction").value = 50000;
			} else {
				document.getElementById("RGESSDeduction").value = RGESSvalue.toFixed(2);
			}
			//document.getElementById("RGESSDeduction").value = 50000;
		} else if (RGESS1 <= 50000) {
			//alert("RGESS");
			var RGESSvalue1 = 0;
			RGESSvalue1 = ((RGESS1 * 50) / 100);
			document.getElementById("RGESSDeduction").value = RGESSvalue1.toFixed(2);
		}
	}

	function NPSRedirect() {
		var NPS = document.getElementById("NPSDeduction").value;
		document.getElementById("NPS").value = NPS;

		var RGESSDeduction = document.getElementById("RGESSDeduction").value;
		document.getElementById("RGESS").value = RGESSDeduction;

		calculateNPS();
	}

	function calculateNPS() {
		//alert("NPS & RGESS ....");
		var Total80C = document.getElementById("80CTotal").value;
		//alert("Total80C" + Total80C);
		var NPS = document.getElementById("NPS").value;
		var RGESS = document.getElementById("RGESS").value;

		if ((isNaN(Total80C)) || (isNaN(NPS)) || (isNaN(RGESS))) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if ((Total80C < 0) || (NPS < 0) || (RGESS < 0)) {
			alert("Negative value not allowed");
		}

		else if (TotalE.length != 0) {
			Total = parseFloat(NPS) + parseFloat(RGESS);
			document.getElementById("actualTotalE").value = Total;
			if (Total < 50000) {
				document.getElementById("TotalE").value = Total.toFixed(2);
				document.getElementById("part4self").innerHTML = Total.toFixed(2);
				
				var TotalC = document.getElementById("TotalC").value;
				TotalE = parseFloat(TotalC) - parseFloat(Total) - parseFloat(Total80C);
				document.getElementById("TotalCE").value = TotalE.toFixed(2);
				document.getElementById("part4").innerHTML = TotalE.toFixed(2);
			} else {
				document.getElementById("TotalE").value = 50000;
				document.getElementById("part4self").innerHTML = 50000.00;
				
				var TotalC = document.getElementById("TotalC").value;
				TotalE = parseFloat(TotalC) - 50000 - parseFloat(Total80C);
				document.getElementById("TotalCE").value = TotalE.toFixed(2);
				document.getElementById("part4").innerHTML = TotalE.toFixed(2);
			}
		}
		EGD80();
	}

	function tempSelfSpouseChildren() {
		var age = document.getElementById("age").value;
		//alert("Age:" + age);
		var SelfSpouseChildren = document.getElementById("SelfSpouseChildren").value;
		//alert("SelfSpouseChildren" + SelfSpouseChildren);
		if ((isNaN(SelfSpouseChildren))) {
			document.getElementById(id).value = "";
		} else if ((SelfSpouseChildren < 0)) {
			alert("Negative value not allowed");
			document.getElementById("NPSDeduction").value = 0;
		}

		if (age < 60) {
			if (SelfSpouseChildren > 25000) {
				document.getElementById("SelfSpouseChildrenDeduction").value = 25000;
			} else {
				document.getElementById("SelfSpouseChildrenDeduction").value = SelfSpouseChildren;
			}
		} else {
			if (SelfSpouseChildren > 30000) {
				document.getElementById("SelfSpouseChildrenDeduction").value = 30000;
			} else {
				document.getElementById("SelfSpouseChildrenDeduction").value = SelfSpouseChildren;
			}
		}
		sum();
	}

	function tempParents() {
		//alert("heelllooooo");
		var FatherAge = document.getElementById("FatherBdy").value;
		//alert("FatherAge" + FatherAge);
		var Parents = document.getElementById("Parents").value;
		//	alert("parents" + Parents);
		if ((isNaN(Parents))) {
			document.getElementById(id).value = "";
		} else if ((Parents < 0)) {
			alert("Negative value not allowed");
			document.getElementById("ParentsDeduction").value = 0;
		}

		if (FatherAge > 60) {
			if (Parents > 30000) {
				document.getElementById("ParentsDeduction").value = 30000;
			} else {
				document.getElementById("ParentsDeduction").value = Parents;
			}
		} else {
			if (Parents > 25000) {
				document.getElementById("ParentsDeduction").value = 25000;
			} else {
				document.getElementById("ParentsDeduction").value = Parents;
			}
		}
		sum();
	}
	
	function HealthCheckUp()
	{
		var health = document.getElementById("health").value;
		if( health >= 5000)
			{
				document.getElementById("healthDeduction").value = 5000 ;
			}else
				{
					document.getElementById("healthDeduction").value = health ;
				}
		sum();
	}

	function sum() {
		var ParentsDeduction = document.getElementById("ParentsDeduction").value;
		var SelfSpouseChildrenDeduction = document.getElementById("SelfSpouseChildrenDeduction").value;
		var healthDeduction = document.getElementById("healthDeduction").value;

		var TotalMediclaim = parseFloat(ParentsDeduction) + parseFloat(SelfSpouseChildrenDeduction) + parseFloat(healthDeduction);
		document.getElementById("TotalActual").value = TotalMediclaim.toFixed(2);
		if( TotalMediclaim < 60000 ){
			document.getElementById("TotalDeduction").value = TotalMediclaim.toFixed(2);
		}else if( TotalMediclaim >= 60000 ){
			document.getElementById("TotalDeduction").value = 60000;
		}
	}

	function MediclaimRedirect() {
		var TotalDeduction = document.getElementById("TotalDeduction").value;
		document.getElementById("Mediclaim").value = TotalDeduction;

		EGD80();
	}
	
	function CashDonation()
	{
		var cash = document.getElementById("cashAmount").value;
		//alert("cash:"+cash);
		if (isNaN(cash)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (cash < 0) {
			alert("Negative value not allowed");
		}else if( cash >= 2000 ){
			cash = 2000;
			var cashDeduction = 0 ;
			cashDeduction = (cash * 50)/100;
			document.getElementById("cashDeduction").value = cashDeduction.toFixed(2) ;
		}else if( cash < 2000 ){
			var cashDeduction = 0 ;
			cashDeduction = (cash * 50)/100;
			document.getElementById("cashDeduction").value = cashDeduction.toFixed(2) ;
		}
	}
	
	function ChequeDonation()
	{
		//alert("hoo");
		var cheque = document.getElementById("chequeAmount").value;
		//alert("CHEQUE : "+cheque);
		if (isNaN(cheque)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (cheque < 0) {
			alert("Negative value not allowed");
		}
		var chequeDeduction = 0 ;
		chequeDeduction = (cheque * 50)/100;
		document.getElementById("chequeDeduction").value = chequeDeduction.toFixed(2) ;
	}
	
	function DonationAmount()
	{
		var donationAmount = document.getElementById("donationAmount").value;
		//alert("Donation Amount :"+donationAmount);
		if (isNaN(donationAmount)) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if (donationAmount < 0) {
			alert("Negative value not allowed");
		}
		var deduction = (donationAmount * 100 )/100;
		document.getElementById("donationDeduction").value = deduction.toFixed(2);
	}
	
	function DonationRedirect()
	{
		var cashDeduction = document.getElementById("cashDeduction").value;
		var chequeDeduction = document.getElementById("chequeDeduction").value;
		var result = document.getElementById("donationResult").value;
		//alert("Checkbox" + result);
		if(result == "Cash"){
			document.getElementById("Donation").value = cashDeduction;
		}else{
			document.getElementById("Donation").value = chequeDeduction;
		}
		
		var donationAmount = document.getElementById("donationDeduction").value;
		document.getElementById("TotalDonation").value = donationAmount;
		
		EGD80();
	}

	function EGD80() {
		//alert("hello");
		var TotalF = 0;
		var Mediclaim = document.getElementById("Mediclaim").value;
		var Donation = document.getElementById("Donation").value;
		var TotalDonation = document.getElementById("TotalDonation").value;
		var EducationLoaninterest = document.getElementById("EducationLoaninterest").value;

		//alert("Mediclaim" + Mediclaim);
		if ((isNaN(Mediclaim)) || (isNaN(Donation)) || (isNaN(TotalDonation))
				|| (isNaN(EducationLoaninterest))) {
			alert("character not allowed");
			document.getElementById(id).value = "";
		} else if ((Mediclaim < 0) || (Donation < 0) || (TotalDonation < 0) || (EducationLoaninterest < 0)) {
			alert("Negative value not allowed");
		}

		else if (TotalF.length != 0) {
			TotalF = parseFloat(Mediclaim) + parseFloat(Donation)
					+ parseFloat(TotalDonation) + parseFloat(EducationLoaninterest);
			document.getElementById("TotalF").value = TotalF.toFixed(2);
			document.getElementById("part5self").innerHTML = TotalF.toFixed(2);
			//	alert("Total" + TotalF);

			var TotalE = document.getElementById("TotalCE").value;
			TotalTexableValue = parseFloat(TotalE) - parseFloat(TotalF);
			// document.getElementById("TotalE").value = Total;

			document.getElementById("ActualTotalF").value = TotalTexableValue.toFixed(2);
			document.getElementById("TaxableIncome").value = TotalTexableValue.toFixed(2);
			document.getElementById("part5").innerHTML = TotalTexableValue.toFixed(2);
			
			var age = document.getElementById("age").value;
			//alert("AGE"+age);
			
			var gender = $("#gender").val();
			//alert("Tax Gender :"+gender);
			
			if(gender == "Female")
			{
				if (TotalTexableValue <= 300000) {
					//alert("less than 300000");
					Tax = 0;
					document.getElementById("Tax").value = Tax.toFixed(2);
				} else if (TotalTexableValue > 300000 && TotalTexableValue <= 500000) {
					//alert("between 300000-500000");
					Tax = ((TotalTexableValue - 300000) * 5) / 100;
					document.getElementById("Tax").value = Tax.toFixed(2);
				} else if (TotalTexableValue > 500000 && TotalTexableValue <= 1000000) {
					//alert("between 500000-1000000");
					Tax = (((TotalTexableValue - 500000) * 20) / 100) + 25000;
					document.getElementById("Tax").value = Tax.toFixed(2);
				} else if (TotalTexableValue > 1000000) {
					//alert("greater than 1000000");
					Tax = (((TotalTexableValue - 1000000) * 30) / 100) + 125000;
					document.getElementById("Tax").value = Tax.toFixed(2);
				}
			}
			else if(gender == "Male")
			{
				if( age >= 60)
				{
					if (TotalTexableValue <= 300000) {
						//alert("less than 300000");
						Tax = 0;
						document.getElementById("Tax").value = Tax.toFixed(2);
					} else if (TotalTexableValue > 300000 && TotalTexableValue <= 500000) {
						//alert("between 300000-500000");
						Tax = ((TotalTexableValue - 300000) * 5) / 100;
						document.getElementById("Tax").value = Tax.toFixed(2);
					} else if (TotalTexableValue > 500000 && TotalTexableValue <= 1000000) {
						//alert("between 500000-1000000");
						Tax = (((TotalTexableValue - 500000) * 20) / 100) + 25000;
						document.getElementById("Tax").value = Tax.toFixed(2);
					} else if (TotalTexableValue > 1000000) {
						//alert("greater than 1000000");
						Tax = (((TotalTexableValue - 1000000) * 30) / 100) + 125000;
						document.getElementById("Tax").value = Tax.toFixed(2);
					}
				}
				else if( age < 60)
				{
					if (TotalTexableValue <= 250000) {
						//alert("less than 250000");
						Tax = 0;
						document.getElementById("Tax").value = Tax.toFixed(2);
					} else if (TotalTexableValue > 250000 && TotalTexableValue <= 500000) {
						//alert("between 250000-500000");
						Tax = ((TotalTexableValue - 250000) * 5) / 100;
						document.getElementById("Tax").value = Tax.toFixed(2);
					} else if (TotalTexableValue > 500000 && TotalTexableValue <= 1000000) {
						//alert("between 500000-1000000");
						Tax = (((TotalTexableValue - 500000) * 20) / 100) + 25000;
						document.getElementById("Tax").value = Tax.toFixed(2);
					} else if (TotalTexableValue > 1000000) {
						//alert("greater than 1000000");
						Tax = (((TotalTexableValue - 1000000) * 30) / 100) + 125000;
						document.getElementById("Tax").value = Tax.toFixed(2);
					}
				}
			}
				
			calculateTaxRemit();
		}
	}

	function calculateTaxRemit() {

		var Tax = document.getElementById("TaxableIncome").value;
	//	alert("tax" + Tax);
		
		var age = document.getElementById("age").value;
		var gender = $("#gender").val();
		
		if(gender == "Female")
		{
			if (Tax <= 300000) {
				//alert("taxremit is 0");
				TaxRemit = 0;
				document.getElementById("TaxRemit").value = TaxRemit;
			} else if (Tax > 300000 && Tax <= 500000) {
				//alert("taxremit is 5000");
				TaxRemit = 5000;
				document.getElementById("TaxRemit").value = TaxRemit;
			} else if (Tax > 500001) {
				//alert("taxremit is 5001");
				TaxRemit = 0;
				document.getElementById("TaxRemit").value = TaxRemit;
			}	
		}
		else if(gender == "Male")
		{
			if( age >= 60)
			{
				if (Tax <= 300000) {
					//alert("taxremit is 0");
					TaxRemit = 0;
					document.getElementById("TaxRemit").value = TaxRemit;
				} else if (Tax > 300000 && Tax <= 500000) {
					//alert("taxremit is 5000");
					TaxRemit = 5000;
					document.getElementById("TaxRemit").value = TaxRemit;
				} else if (Tax > 500001) {
					//alert("taxremit is 5001");
					TaxRemit = 0;
					document.getElementById("TaxRemit").value = TaxRemit;
				}
			}
			else if( age < 60)
			{
				if (Tax <= 250000) {
					//alert("taxremit is 0");
					TaxRemit = 0;
					document.getElementById("TaxRemit").value = TaxRemit;
				} else if (Tax > 250000 && Tax <= 500000) {
					//alert("taxremit is 5000");
					TaxRemit = 5000.00;
					document.getElementById("TaxRemit").value = TaxRemit;
				} else if (Tax > 500001) {
					//alert("taxremit is 5001");
					TaxRemit = 0;
					document.getElementById("TaxRemit").value = TaxRemit;
				}
			}
		}
		
		calculateTotalTax();
	}

	function calculateTotalTax() {
		
		var Tax = document.getElementById("Tax").value;
		var TaxRemit = document.getElementById("TaxRemit").value;
		var TotalTax = 0;
		Tax = parseFloat(Tax);
		TaxRemit = parseFloat(TaxRemit);
		//alert("TAX INT : "+Tax + " TAX REMIT INT :"+ TaxRemit);
		if(Tax <= 0.0)
		{
			//alert("SKY" + Tax);
			//alert("Tax less than 0");
			document.getElementById("TotalTax").value = 0.0;
		}
		else if(Tax > 0.0)
		{
			if(Tax < TaxRemit)
			{
				//alert("if");
				TotalTax = (TaxRemit - Tax);
				document.getElementById("TotalTax").value = TotalTax.toFixed(2);
				//alert("TOTAL TAX :"+ TotalTax);
			}
			else if( Tax > TaxRemit)
			{
				TotalTax = (Tax - TaxRemit);
				//alert("else" + TotalTax);
				document.getElementById("TotalTax").value = TotalTax.toFixed(2);
				//ALERT("TOTAL TAX :"+ TotalTax);
			}
		}
		/* if(Tax > TaxRemit){
			TotalTax = (Tax - TaxRemit);
			alert("Total Tax VALUE:" + TotalTax);
			document.getElementById("TotalTax").value = TotalTax;
		}else if(TaxRemit > Tax){
			TotalTax = (TaxRemit - Tax);
			// alert("Total Tax :" + TotalTax);
			document.getElementById("TotalTax").value = TotalTax;
		}
		alert("Total Tax :" + TotalTax); */
		EduCess = (TotalTax * 3) / 100;
		var eduCess = (EduCess).toFixed(2);
		document.getElementById("EduCess").value = eduCess;

		TotalH = (TotalTax + EduCess).toFixed(2);
		document.getElementById("TotalH").value = TotalH;
		
	}
	
	function Submit() {
		//alert("Submit");
		document.getElementById("formSubmit").submit();  
	}
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

<form action="tdsInsert" method="post" id="formSubmit">
	<div class="app-content container center-layout mt-2">
      <div class="content-wrapper">
      	<div class="content-body">
			<section id="horizontal-form-layouts">
				<div class="row"> 
			        <div class="col-xs-12">
			            <h4>DETAILS FOR INCOME TAX CALCULATION FOR THE YEAR ENDING</h4>
			            <hr>
			        </div>
			    </div>

				<% if(request.getAttribute("TDSExist") != null) {%>
		 		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-danger">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${TDSExist}
                            </div>
          		</div>  
          	<%}%>
          	
          	<%
          	
          		PayrollList payrollList = new PayrollList();
          		int emp_id = user.getEmployee_code();
          		String hrms_company_name = user.getCompanyListBean().getCompany_code();
          		String payroll_company_name = null;
	          		if(hrms_company_name.equals("SL"))
	          		{
	          			payroll_company_name = "SLT";
	          		}
	          		else if(hrms_company_name.equals("SE"))
	          		{
	          			payroll_company_name = "SENT";
	          		}
	          		else if(hrms_company_name.equals("SS"))
	          		{
	          			payroll_company_name = "SRI";
	          		}
	          		else if(hrms_company_name.equals("S.HR"))
	          		{
	          			payroll_company_name = "SHR";
	          		}
	          		else if(hrms_company_name.equals("CO"))
	          		{
	          			payroll_company_name = "COSMOS";
	          		}
	          		else if(hrms_company_name.equals("CS"))
	          		{
	          			payroll_company_name = "CSLaser";
	          		}
	          		else if(hrms_company_name.equals("O"))
	          		{
	          			payroll_company_name = "App";
	          		}
	          	System.err.println("COMPANY NAME :"+payroll_company_name);	
          		
          		List<PayrollBean> payrollBean = payrollList.listOfPayroll(emp_id, payroll_company_name);
          		double basicSalary = 0.0;
          		double medical = 0.0 ;
          		double conveyance = 0.0 ;
				double incentive = 0.0 ;          		
          		double actualHRA = 0.0 ;
          		double uniAllw = 0.0 ;
          		double eduAllw = 0.0 ;
          		double otherAllw = 0.0 ;
          		double adhocAllw = 0.0 ;
          		double ltc = 0.0 ;
          		double ptax = 0.0 ;
          		double prvSalary = 0.0 ;
          		double pf = 0.0;
          		String joiningDate = null ;
          		String companyName = null ;
          		double gross_salary = 0.0 ;
          		double annual_gross_salary = 0.0 ;
          		double annual_epf = 0.0;
          		double bonus = 8400 ;
          		double leave = 0.0 ;
          		double Incentive = 0.0 ;
          		
          		for(PayrollBean bean : payrollBean){
          			basicSalary = bean.getBasicSalary();
          			medical = bean.getMA();
          			conveyance = bean.getConv();
          			incentive = bean.getAll1();
          			actualHRA = bean.getAll2();
          			uniAllw = bean.getAll3();
          			eduAllw = bean.getAll4();
          			otherAllw = bean.getAll5();
          			adhocAllw = bean.getAll6();
          			ltc = bean.getLTC();
          			ptax = bean.getPTax();
          			prvSalary = bean.getPrvSalary();
          			pf = bean.getPF();
          			joiningDate = bean.getJoiningDate();
          			companyName = bean.getCompany();
          			
          			gross_salary = basicSalary + medical + conveyance + incentive + actualHRA + uniAllw + eduAllw + otherAllw + adhocAllw + ltc;
          			System.out.println("Gross Salary :" +gross_salary);
          			System.err.println(pf);
          			System.out.println("Company Name :" +companyName);
          		}
          		
          		List<PerformancePayBean> performancePayBean = payrollList.listOfPerformancePay(emp_id,payroll_company_name);
          		double performancePay = 0.0 ;
          		
          		for(PerformancePayBean payBean : performancePayBean){
          			performancePay = payBean.getPerAmt();
          		}
          		
          		/* SimpleDateFormat ddMMyyyy = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
          		SimpleDateFormat ddMMyyyy1 = new SimpleDateFormat("dd-MM-yy");
          		Date join_date = ddMMyyyy1.parse(joiningDate); */
          		
        		Calendar calJoiningDate = Calendar.getInstance();
	          	Calendar calCurrDate = Calendar.getInstance();
	          	calJoiningDate.setTime(yyyyMMdd.parse(joiningDate));
	          	calCurrDate.setTime(current_date);
	          	int currentYear = calCurrDate.get(Calendar.YEAR);
	          	int joiningYear = calJoiningDate.get(Calendar.YEAR);
	          	int currentMonth = calCurrDate.get(Calendar.MONTH)+1;
	          	int joinMonth = calJoiningDate.get(Calendar.MONTH)+1;
	          	System.out.println(" JOINING YEAR :"+joiningYear + "CURRENT YEAR :" + currentYear);
	          	System.out.println(" JOINING MONTH :"+joinMonth);
	          	System.out.println(" Current MONTH :"+currentMonth);
	          	int total_month = 0 ;
	          	int start_month = 4 ;
	          	
	          	if(joiningYear == currentYear)
	          	{
	          		if(joinMonth > start_month)
	          		{
	          			total_month = 12 - ( joinMonth - start_month);
	          			System.out.println("month :" + total_month);
	          		}
	          		else if(joinMonth < start_month)
	          		{
	          			total_month =  start_month - joinMonth ;
	          		}
	          		else if(joinMonth == start_month)
	          		{
	          			total_month = 12 ;
	          		}
	          	}
	          	else if(joiningYear < currentYear)
	          	{
	          		int year_diff = currentYear - joiningYear ;
	          		if( year_diff == 1 )
	          		{
	          			if(currentMonth < start_month)
	          			{
	          				total_month = 12 - ( joinMonth - currentMonth) + 1;
	          				System.out.println("month :" + total_month);
	          			}
	          			else if(joinMonth > start_month)
	          			{
	          				System.out.println("IN YEAR DIFF ");
	          				total_month = 12;
	          			}
	          		}
	          		else if( year_diff > 1)
	          		{
		          		total_month = 12;
		          		System.out.println("month :" + total_month);
	          		}
	          	}
          		
	          	annual_gross_salary = (gross_salary * total_month);
	          	annual_epf = pf * total_month ;
	          	System.err.println(annual_epf);
	          	double totalA = annual_gross_salary + prvSalary + performancePay + bonus + leave + Incentive ;
          	%>
          	
          	<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Details For Income Tax Calculation</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
				            </div>
				            <div class="card-body collapse in">
	               			<div class="card-block">
							
											<input type="hidden" name="joining_date" id="joining_date" value="<%=joiningDate%>">
											<input type="hidden" name="total_month" id="total_month" value="<%=total_month%>">
											<input type="hidden" name="payroll_basic_salary" id="payroll_basic_salary" value="<%=basicSalary%>">
											<input type="hidden" name="payroll_incentive" id="payroll_incentive" value="<%=incentive%>">
											<input type="hidden" name="payroll_previous_salary" id="payroll_previous_salary" value="<%=prvSalary%>">
											<input type="hidden" name="payroll_performance_pay" id="payroll_performance_pay" value="<%=performancePay%>">
											<input type="hidden" name="payroll_conveyance" id="payroll_conveyance" value="<%=conveyance%>">
											<input type="hidden" name="payroll_hra" id="payroll_hra" value="<%=actualHRA%>">
											<input type="hidden" name="payroll_medical" id="payroll_medical" value="<%=medical%>">
											<input type="hidden" name="payroll_ltc" id="payroll_ltc" value="<%=ltc%>">
											<input type="hidden" name="payroll_ptax" id="payroll_ptax" value="<%=ptax%>">
											<input type="hidden" name="payroll_epf" id="payroll_epf" value="<%=pf%>">
											<input type="hidden" name="payroll_uni_all" id="payroll_uni_all" value="<%=uniAllw%>">
											<input type="hidden" name="payroll_edu_all" id="payroll_edu_all" value="<%=eduAllw%>">
											<input type="hidden" name="payroll_other_all" id="payroll_other_all" value="<%=otherAllw%>">
											<input type="hidden" name="payroll_adhoc_all" id="payroll_adhoc_all" value="<%=adhocAllw%>">
												<% String company_code = user.getCompanyListBean().getCompany_code();
													int employee_code = user.getEmployee_code();
												%>
											<input type="hidden" name="company_code" id="company_code" value="<%=company_code%>">
											<input type="hidden" name="employee_code" id="employee_code" value="<%=employee_code%>">
											<input type="hidden" name="gender" id="gender" value="<%=user.getGender()%>">
									
								
								<div class="row">
										<div class="col-lg-6">
											<div class="col-lg-3">
												<b>Name :</b>
											</div>
											<div class="col-lg-9">
												<input type="text" class="form-control" name="emp_name" id="emp_name" value="<%=user.getFirstname()%> <%=user.getLastname()%>"
														readonly="readonly">
											</div>
										</div>	
										
										<div class="col-lg-6">
											<div class="col-lg-3">
												<b>PAN No :</b>
											</div>
											<div class="col-lg-9">
												<input type="text" class="form-control" name="pan_no" id="pan_no" value="<%=user.getPan_no() %>" readonly="readonly"
													placeholder="Enter PAN No.">
											</div>
										</div>	
								</div>
					<br> 
					<% SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
					Date cfdate = new Date();
					int month = cfdate.getMonth();
					String end_year = formatNowYear.format(cfdate);
					int current_year = 0;
                 	int final_year = 0;
					if(month>2){
						 current_year = Integer.parseInt(end_year) ;
						 final_year = (current_year + 1);
                	}else{
                		 current_year = Integer.parseInt(end_year);
						 final_year = (current_year - 1);
                	}
					%>
						
						<div class="card box-shadow-0" data-appear="appear" data-animation="fadeInLeft">
			                <div class="card-header card-inverse" style="background-color: #90A4AE;">
			                    <h5 class="card-title">
			                    <center>
									Expected Payments/Investments During The Financial Year <%=current_year %>-<%=final_year %></font>
								</center>
			                    </h5>
			                </div>
			                <div class="card-body collapse in">
			                    <div class="card-block border-bottom-blue-grey">
			                      <h5>
									<b>General Deductions</b>
								</h5>

								<h5>
									<b>Exempted Allowance U/S 10 Of The Income Tax</b>
								</h5>
			                    </div>
			                </div>
			            </div>
						
			<div class="row">
			<div class="col-lg-12">
				<div id="accordionWrap1" role="tablist" aria-multiselectable="true">
                <div class="card collapse-icon accordion-icon-rotate">
                
                <div id="headingCollapse43"  class="card-header" style="padding: 0.5rem 1.5rem;">
					<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne" class="card-title lead info">
					<div class="row">
						<div class="col-lg-12">
                         <div class="col-md-10" align="left">(1) Gross Income And HRA Calculation(Annual)</div>
                         <div class="col-md-2">
                         	<div class="col-md-1">Rs.</div> 
                        	 <div class="col-md-1" id="part1"></div>
                      	 </div>
                      	 </div>
                    </div> 
					</a>
				</div>
				<div id="collapseOne" role="tabpanel" aria-labelledby="headingCollapse43" class="border-info no-border-top card-collapse collapse" aria-expanded="false">
					<div class="card-body">
						<div class="card-block">
							                                <table class="table-bordered" width="80%">
							                                        <tr>
							                                        	 <tbody>
																		<th width="50px;"><center>1</center></th>
																		<td><center><b>Total Gross Income(Total A)</b></center></td>
																		<th align="center" id="tablePadding"><div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="TotalGross"
																					id="TotalGross" value="<%=totalA %>" readonly="readonly">
																			</div>
																		</th>
																		<th width="50px;">
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center> 
																				<!-- Modal -->
																				<div class="modal fade" id="myModal" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Total
																									Gross Income (Annual)</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
							
																									<tr>
																										<th id="modalPadding">Annual Gross Salary</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="totalBasic" name="totalBasic" value="<%=annual_gross_salary %>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Bonus</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Bonus" name="Bonus" value="<%=bonus %>" readonly="readonly" onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Leave</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Leave" name="Leave" value="<%=gross_salary %>" readonly="readonly" onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Incentive</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Incentive" name="Incentive" value="<%=Incentive %>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Salary For Previous Employment</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="PreviousSalary" name="PreviousSalary" value="<%=prvSalary %>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Performance Pay</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Performance" name="Performance" value="<%=performancePay %>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<!-- <tr>
																										<th id="modalPadding">Full & Final Bonus</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Full&FinalBonus" name="Full&FinalBonus"
																											value="0" onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Full & Final Leave</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Full&FinalLeave" name="Full&FinalLeave"
																											value="0" onchange="temp();"></td>
																									</tr> -->
																					 				<tr>
																										<th id="modalPadding">Total Gross Income (Total A)</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="TotalGrossIncome" name="TotalGrossIncome"
																											value="<%=totalA %>" readonly="readonly"></td>
																									</tr>
							
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="Redirect()">
							
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
							
							
																			</th>
																	</tr>
							                                    
							                                   
							                                        <tr>
							                                            <th><center>2</center></th>
							                                            <th><center>Conveyance (Annual)</center></th>
																			<!-- <th colspan="2"><div class="txt1">
																					<center>Max. Rs.15000/-</center>
																				</div></th> -->
																			<th align="center" style="width: 180px;" id="tablePadding">
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control"
																						name="PermissibleConveyance" id="PermissibleConveyance"
																						value="0" readonly="readonly"">
																				</div>
																			</th>
																			<th>
																					<!-- Button trigger modal -->
																					<center><a href="" data-toggle="modal" data-target="#myModal2"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																					<!-- Modal -->
																					<div class="modal fade" id="myModal2" tabindex="-1"
																						role="dialog" aria-labelledby="myModalLabel"
																						aria-hidden="true">
																						<div class="modal-dialog">
																							<div class="modal-content">
																								<div class="modal-header">
																									<button type="button" class="close"
																										data-dismiss="modal" aria-hidden="true">&times;</button>
																									<h4 class="modal-title" id="myModalLabel">Conveyance
																										(Annual)</h4>
																								</div>
																								<div class="modal-body">
																									<table class="table table-striped">
																										<tr>
																											<th></th>
																											<th id="modalPadding">Conveyance<br>
																												(Monthly Rs.<%=conveyance%>/-)</th>
																											<th id="modalPadding">Permissible Deduction<br>(Max.
																												Rs.19200/-)
																											</th>
																										</tr>
								
																										<tr>
																											<th id="modalPadding">Conveyance</th>
																											<td id="modalPadding"><input type="text" class="form-control"
																												id="Conveyance" name="Conveyance" value="<%=conveyance %>" readonly="readonly"
																												onchange="tempConveyance()"></td>
																											<td id="modalPadding"><input type="text" class="form-control"
																												name="Conveyance1" id="Conveyance1" value="0"
																												readonly="readonly"></td>
																										</tr>
								
																									</table>
																								</div>
																								<div class="modal-footer">
																									<input type="button" value="SAVE"
																										class="btn btn-primary" data-dismiss="modal"
																										onclick="Redirect()">
								
																								</div>
																							</div>
																							<!-- /.modal-content -->
																						</div>
																						<!-- /.modal-dialog -->
																					<!-- /.modal -->
																				</div>
								
								
																			</th>
																		</tr>
																		
							                                        <tr>
							                                        	<th><center>3</center></th>
																		<th><center>House Rent All</center></th>
																		<th id="tablePadding"><div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="HouseRant"
																					id="HouseRant" value="0" readonly="readonly">
																			</div>
																		</th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModa3"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModa3" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog" role="document">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">HRA
																									(Annual)</h4>
								
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
							
																									<tr>
																										<td colspan="4" id="modalPadding">Checked the box if you are
																											living in Metro City
																											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																											<input type="checkbox" id="City" name="City"
																											onchange="check()"> <br>
																											(Bangalore,Chennai,Delhi,Kolkata)<input
																											type="hidden" name="checked" id="checked">
							
																										</td>
																									</tr>
							
																									<tr>
																										<td></td>
																										<td>Yearly Amount</td>
																										<th id="nonMetro">Non Metro City</th>
																										<th id="metro">Metro City</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Total Basic Salary</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="totalBasic1" name="totalBasic1" value="<%=basicSalary %>" readonly="readonly"
																											onchange="BasicCalculation();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="totalBasicNonMetro" name="totalBasicNonMetro" value="0"
																											readonly="readonly">
																										<input type="text" class="form-control"
																											id="totalBasicMetro" name="totalBasicMetro" value="0" readonly="readonly"></td>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Total Rent Is To Be<br> Payable During The <br>Year </th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="rentSlip" name="rentSlip" value="0"
																											onchange="calculateRent(this.id)"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="rentSlipNonMetro" name="rentSlipNonMetro"
																											value="0" readonly="readonly">
																										<input type="text" class="form-control"
																											id="rentSlipMetro" name="rentSlipMetro" value="0"
																											readonly="readonly"></td>
							
																									</tr>
							
																									<tr>
																										<th id="modalPadding">HRA Payable By Company</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="actualHRA" name="actualHRA" value="<%=actualHRA %>" readonly="readonly"
																											onchange="calculateHRA(this.id); CalculateTotalHRA()"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="actualHRANonMetro" name="actualHRANonMetro"
																											value="0" readonly="readonly">
																										<input type="text" class="form-control"
																											id="actualHRAMetro" name="actualHRAMetro" value="0"
																											readonly="readonly"></td>
							
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Deduction addmissible</th>
																										<td></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="nonMetroDeduction" id="nonMetroDeduction"
																											value="0" readonly="readonly">
																										<input type="text" class="form-control"
																											name="metroDeduction" id="metroDeduction" value="0"
																											readonly="readonly"></td>
							
							
																									</tr>
																								</table>
																								<br>
							
																								<div id="LandlordDetail">
																									<h2>Landlord Details For Rent Slip</h2>
																									<table class="table table-striped">
																										<tr>
																											<td><label id="LandlordNameLabel">Landlord
																													Name</label></td>
																											<td><input type="text" class="form-control"
																												name="LandlordName" id="LandlordName" value=""></td>
																										</tr>
																										<tr>
																											<td><label id="LandlordPanNoLabel">Landlord
																													PAN No.</label></td>
																											<td><input type="text" class="form-control"
																												name="LandlordPanNo" id="LandlordPanNo" value=""></td>
																										</tr>
																									</table>
																								</div>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="Redirect()">
							
							
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
							
							
							
																		</th>
																	</tr>

							                                        
																	<tr>
																		<th><center>4</center></th>
																		<th><center>Medical Bill</center></th>
																		
																		<th align="center" style="width: 180px;" id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="MedicalBill"
																					id="MedicalBill" value="0" readonly="readonly">
																			</div>
																		</th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal4"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade text-xs-left" id="myModal4" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog modal-lg" role="document">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Medical
																									Bill (Annual)</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th></th>
																										<th id="modalPadding">Medical Allw. Received<br> during the year</th>
																										<th id="modalPadding">Bills you are going to<br> provide</th>
																										<th id="modalPadding">Permissible Deduction</th>
																										<th id="modalPadding">Qualifying Amount</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Medical Bill</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Medical" name="Medical" value="<%=medical %>" readonly="readonly"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="ProvidedMedicalBills" name="ProvidedMedicalBills" value="0"
																											onchange="tempMedical()"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="PermissibleDeduction" name="PermissibleDeduction" value="15000"
																											readonly="readonly"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MedicalDeduction" id="MedicalDeduction"
																											value="0" readonly="readonly"></td>
																									</tr>
							
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="Redirect()">
							
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
							
																		</th>
																	</tr>
							                                        
							                                         <tr>
							                                        	<th><center>5</center>
																		<th><center>Meal Card</center></th>
																		
																		<th align="center" style="width: 180px;" id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="MealCard"
																					id="MealCard" value="0" readonly="readonly">
																			</div>
																		</th>
																		<th>
							
																				<!-- Button trigger modal -->
																				<%if(user.getMealcard().equals("TRUE")) {%>
																				
																				<center><a href="" data-toggle="modal" data-target="#myModal5"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																					<%}else{ %>
																					<center><font color="red">Not Applicable</font></center>
																					<%} %>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal5" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Meal
																									Card (Annual)</h4>
																							</div>
																							<div class="modal-body">
																									<div class="form-group">
																											<label>Choose</label> &nbsp;&nbsp;&nbsp;&nbsp;
																											<label class="radio-inline"> <input type="radio"
																												name="mealCardRadio" id="0" 
																												value="yearly" checked="checked" onchange="checkRadio()">Yearly 
																											</label> 
																											<label class="radio-inline"> <input
																												type="radio" name="mealCardRadio"
																												id="1" value="monthly" onchange="checkRadio()">Monthly
																											</label> <input type="hidden" name="result" id="result">
																										</div>
																								<div id="yearly">
																								<table class="table table-striped">
																									<tr><center><h5><b>Yearly Meal Card</b></h5></center></tr>
																									<tr>
																										<th></th>
																										<th id="modalPadding">Permissible Deduction</th>
																										<td></td>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Meal Card</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="MealCard1" name="MealCard1" value="0"
																											onchange="MealCard(); "></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MealCardDeduction" id="MealCardDeduction"
																											value="0" readonly="readonly"></td>
																									</tr>
							
																								</table>
																								</div>
																								
																								<div id="monthly">
																								<table class="table table-striped">
																									<tr><center><h5><b>Monthly Meal Card</b></h5></center></tr>
																									<tr>
																										<th></th>
																										<th id="modalPadding">Starting Date</th>
																										<th id="modalPadding">Ending Date</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Meal Card</th>
																										<td id="modalPadding"><input type="text" id="startDatePicker1"
																												width="155" name="startDatePicker1" 
																												placeholder="dd/mm/yyyy" class="form-control"></td>
																										<td id="modalPadding"><input type="text" class="form-control" width="155"
																											id="endDatePicker1" name="endDatePicker1"
																											placeholder="dd/mm/yyyy"></td>
																									</tr>
																									<tr>
																										<td id="modalPadding">Days</td>
																										<td id="modalPadding"><input type="text" id="days"
																											 name="days" placeholder="days" class="form-control">
																											</td>
																										<td></td>
																									</tr>
																									<tr>
																										<td id="modalPadding">Permissible Deduction</td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MealCardDeduction1" id="MealCardDeduction1"
																											value="0" readonly="readonly"></td>
																										<td></td>
																									</tr>
							
																								</table>
																								</div>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="Redirect()">
							
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
																		</th>
																	</tr>
							                                        
							                                        
							                                       <tr>
							                                       		<th><center>6</center></th>
																		<th><center>LTA Allw. : Deduction for 2 journey in a block of 4 years</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="LTA" id="LTA"
																					value="0" readonly="readonly">
																			</div>
																		</th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal6"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal6" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog" role="document">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">LTA
																									(Annual)</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th></th>
																										<th id="modalPadding">LTA Received during the<br> year</th>
																										<th id="modalPadding">Actual Expenditure</th>
																										<th id="modalPadding">Permissible Deduction <br>(Whichever is
																											Lower)
																										</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">LTA</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="LTABillSalary" name="LTABillSalary" value="<%=ltc %>" readonly="readonly"
																											onchange="tempLTA(id)(this.id)"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="LTABill" name="LTABill" value="0"
																											onchange="tempLTA(id)(this.id)"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="actualLTABill" id="actualLTABill" value="0"
																											readonly="readonly"></td>
							
																									</tr>
							
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="Redirect()">
							
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
							
							
																		</th>
																	</tr>
																	
							                                         <tr>
							                                         	<th><center>7</center></th>
																		<th><center>PTAX</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="PTAX" id="PTAX"
																					value="<%=ptax %>" readonly="readonly" onchange="TotalB();">
																			</div>
																		</th>
																		<th></th>
																	</tr>
							                                        
							                                         <tr>
							                                         	<th><center>8</center></th>
																		<th><center>Education Allw. : (Permissible for 2 Children with <br>&nbsp;&nbsp;an age of more than 5 years)
																			</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="Education"
																					id="Education" value="0" readonly="readonly">
																			</div>
																		</th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal7"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal7" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog" role="document">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Education
																									Allowance(Annual)</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th></th>
																										<th id="modalPadding">Actual Education <br>Allowance</th>
																										<th id="modalPadding">Number Of Children<br>(Age of more than
																											<br>5 years)
																										</th>
																										<th id="modalPadding">Permissible Deducated <br>Value</th>
							
																									</tr>
																									<tr>
																										<th id="modalPadding">Education<br> Allowance</th>
																										<td id="modalPadding"><input type="text" class="form-control" id="eduAllow" name="eduAllow" readonly="readonly" value="<%=eduAllw%>"></td>
																										<td id="modalPadding"><input type="number" class="form-control"
																											id="EducationLoan" name="EducationLoan" value="0"
																											onchange="tempEducation(this.id); "></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="actualEducation" id="actualEducation"
																											value="0" readonly="readonly"></td>
																									</tr>
							
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="Redirect()">
							
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
																		</th>
																	</tr>
							                                        
							                                        <tr>
							                                        	<th><center>9</center></th>
																		<th><center>Uniform Allowance</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="Uniform"
																					id="Uniform" value="0" readonly="readonly">
																			</div>
																		</th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal8"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal8" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog" role="document">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Uniform
																									Allowance(Annual)</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th></th>
																										<th id="modalPadding">Uniform Allowance <br>Received during the <br>year</th>
																										<th id="modalPadding">Actual Expenditure</th>
																										<th id="modalPadding">Whichever is Lower <br>(Max.Rs.15000/-
																											<br>Permissible)</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Uniform <br>Allowance</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="UniformAllowance" name="UniformAllowance"
																											 value="<%=uniAllw %>" readonly="readonly" onchange="tempUniformAllowance();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="ActualUniformAllowance"
																											name="ActualUniformAllowance" value="0"
																											onchange="tempUniformAllowance();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MinUniformAllowance" id="MinUniformAllowance"
																											value="0" readonly="readonly"></td>
							
																									</tr>
							
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="Redirect();">
							
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
							
							
																		</th>
																	</tr>
																	
																	<tr>
																		<th><center>10</center></th>
																		<th><center>Total(2 to 9)</center></th>
							
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="TotalB" id="TotalB"
																					value="0" readonly="readonly">
																			</div>
																		</th>
																		<th></th>
																	</tr>
							
																	<tr>
																		<th><center>11</center></th>
																		<th><center>Total B(1 - 10)</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="TotalAB"
																					id="TotalAB" value="0" readonly="readonly">
																			</div>
																		</th>
																		<th></th>
																	</tr>
							                                        
							                                    </tbody>
							                                </table>
									                    </div>
									                </div>                                        
												</div>
                                
                
                <div id="headingCollapse62"  class="card-header" style="padding: 0.5rem 1.5rem;">
					<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" class="card-title lead info">
					<div class="row">
					<div class="col-lg-12">
                          <div class="col-md-8" align="left">(2) Other Income(Annual)</div>
                          <div class="col-md-2" >
                               <div class="col-md-1">Rs.</div> 
                               <div class="col-md-1" id="part2self"></div>
                          </div>
                          <div class="col-md-2" >
                               <div class="col-md-1">Rs.</div> 
                               <div class="col-md-1" id="part2"></div>
                          </div>
                        </div> 
                  	</div>
					</a>
				</div>
				<div id="collapseTwo" role="tabpanel" aria-labelledby="headingCollapse62" class="border-info no-border-top card-collapse collapse" aria-expanded="false">
					<div class="card-body">
						<div class="card-block">
											<div class="row">
											<div class="col-md-8">
							                            <div class="table-responsive">
							                                <table class="table-bordered" width="100%">
							                                	<tbody> 
							                                		<tr>
							                                         	<th width="50px;"><center>1</center></th>
																		<th><center>Income from other Source</center></th>
																		<th align="center" style="width: 180px;" id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="OtherIncome"
																							id="OtherIncome" value="0" onchange="calculateBasic();">
																			</div>
																		</th>
																		<th width="50px;"></th>
																	</tr>
																	
							                                        <tr>
							                                        	<th><center>2</center></th>
																		<th><center>House Loan Interest</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="HouseLoan"
																						id="HouseLoan" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal11"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal11" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">House
																									Loan Interest(Annual)</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th id="modalPadding">House Loan Interest</th>
																										<th id="modalPadding">Permissible Deduction<br>(Max. Rs. 2,00,000/-)</th>
																									</tr>
						
																									<tr>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="HouseLoan1" name="HouseLoan1" value="0"
																											onchange="Loan(); "></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="HouseLoanDeduction" id="HouseLoanDeduction"
																											value="0" readonly="readonly" onchange="checkHouseLoan(this.value);"></td>
																									</tr>
																								</table>
																								<br>
																								<div id="HouseLoanDetail">
																									<h2 id="HouseLoanDetail1">Please fill the below
																										Bank Details.</h2>
																									<table class="table table-striped">
																										<tr>
																											<td><label id="BankNameLabel">Bank
																													Name </label></td>
																											<td><input type="text" class="form-control"
																												name="BankName" id="BankName" value=""></td>
																										</tr>
						
																										<tr>
																											<td><label id="BankPANNoLabel">Bank
																													PAN No. </label></td>
																											<td><input type="text" class="form-control"
																												name="BankPANNo" id="BankPANNo" value=""></td>
																										</tr>
						
																										<tr>
																											<td><label id="BankAddressLabel">Bank
																													Address </label></td>
																											<br>
																											<td><textarea rows="3" name="BankAddress"
																													id="BankAddress" class="form-control"></textarea>
																										</tr>
																									</table>
																								</div>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="LoanRedirect()">
						
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
						
																		</th>
																	</tr>
							                                        
							                                         <tr>
							                                        	<th><center>3</center></th>
																		<th><center>Total (1 & 2) </center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="totalc"
																						id="totalc" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																	</tr>
																	
							                                        <tr>
							                                        	<th><center>4</center></th>
																		<th><center>Total Other Income(Total C)</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TotalC"
																						id="TotalC" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																	</tr>
							                                        
							                                    </tbody>
							                                </table>
							                            </div>
							                            <!-- /.table-responsive -->
							                       <!--  </div> -->
							                        <!-- /.panel-body -->
                  							  <!-- /.panel -->
                  							  </div>
                  							  </div>
             							   </div>
									</div>
								</div>
                                
                
                <div id="headingCollapse61"  class="card-header" style="padding: 0.5rem 1.5rem;">
					<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree" class="card-title lead info">
						<div class="row">
							<div class="col-lg-12">
								<div class="col-md-8" align="left">(3) Section 80C(Annual)</div>
								<div class="col-md-2">
									<div class="col-md-1">Rs.</div>
									<div class="col-md-1" id="part3self"></div>
								</div>
								<div class="col-md-2">
									<div class="col-md-1">Rs.</div>
									<div class="col-md-1" id="part3"></div>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div id="collapseThree" role="tabpanel" aria-labelledby="headingCollapse61" class="border-info no-border-top card-collapse collapse" aria-expanded="false">
					<div class="card-body">
						<div class="card-block">
											<div class="row">
												<div class="col-lg-9">
							                            <div class="table-responsive">
							                                <table class="table-bordered" width="100%">
							                                	 <tbody>
							                                        <tr>
							                                        		<th width="50px;"><center>1</center></th>
																			<th><center>Life Insurance</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="LifeInsurance"
																							id="LifeInsurance" value="0"
																							onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>2</center></th>
																			<th><center>EPF</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="EPF" id="EPF" readonly="readonly"
																							value="<%=annual_epf %>" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>3</center></th>
																			<th><center>PPF</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="PPF" id="PPF"
																							value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>4</center></th>
																			<th><center>NSC</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="NSC" id="NSC"
																							value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>5</center></th>
																			<th><center>MF</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="MF" id="MF"
																							value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>6</center></th>
																			<th><center>Tuition Fees</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="TuitionFees"
																							id="TuitionFees" value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>7</center></th>
																			<th><center>Stamp Duty & Registration Charge</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="StampDuty"
																							id="StampDuty" value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>8</center></th>
																			<th><center>House Loan Principal</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group" id="houseLoan">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" readonly="readonly"
																							name="HouseLoanPrincipal" id="HouseLoanPrincipal"
																							value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>9</center></th>
																			<th><center>Tax Saver Fix Deposit of 5 Years</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control"
																							name="TaxSaverFixDeposit" id="TaxSaverFixDeposit"
																							value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>10</center></th>
																			<th>
																				<center>Other</center><br>
																				<div class="row">
																					<div class="col-lg-4" align="right">
																						Please Specify :
																					</div>
																					<div class="col-lg-8">
																						<input type="text" class="form-control" name="OtherDocument" id="OtherDocument" placeholder="Please Specify"
																							value="" style="border-radius: 4px;" onchange="calculateSection80C();">
																					</div>
																				</div>
																			</th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<br><br>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="Other" id="Other"
																							value="0" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>11</center></th>
																			<th><center>Total(1 to 10)</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="TotalD"
																							id="TotalD" value="0" readonly="readonly">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>12</center></th>
																			<th><center>permissible deduction of 11(Max 150000/-)</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="80CTotal"
																							id="80CTotal" value="0" readonly="readonly">
																					</div>
																				</center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>13</center></th>
																			<th><center>Total D</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="totalD"
																							id="totalD" value="0" readonly="readonly">
																					</div>
																				</center></th>
																	</tr>
							                                    </tbody>
							                                </table>
							                            </div>
							                   		 </div>
							                    </div>
							                </div>
										</div>
									</div>
                                
                  
                <div id="headingCollapse64"  class="card-header" style="padding: 0.5rem 1.5rem;">
					<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour" class="card-title lead info collapsed">
						<div class="row">
							<div class="col-lg-12">
								<div class="col-md-8" align="left">(4) NPS And RGESS(Annual)</div>
								<div class="col-md-2">
									<div class="col-md-1">Rs.</div>
									<div class="col-md-1" id="part4self"></div>
								</div>
								<div class="col-md-2">
									<div class="col-md-1">Rs.</div>
									<div class="col-md-1" id="part4"></div>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div id="collapseFour" role="tabpanel" aria-labelledby="headingCollapse64" class="border-info no-border-top card-collapse collapse" aria-expanded="false">
					<div class="card-body">
						<div class="card-block">
							                        <div class="col-lg-8">
							                            <div class="table-responsive">
							                                <table class="table-bordered" width="100%">
							                                	 <tbody>
																	<tr>
																		<th width="50px;"><center>1</center></th>
																		<th><center>NPS</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="NPS" id="NPS"
																						value="0" readonly="readonly">
																				</center></div>
																		</th>
																		<th width="50px;">
																				<!-- Button trigger modal -->
																				<center><i class="glyphicon glyphicon-info-sign" style="color: black;font-size: 13px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="Max. investment Rs.50000/- & maximum exemption 100 % of maxi. Investment amt."></i>
																				<a href="" data-toggle="modal" data-target="#myModal9">
																				<i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal9" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">NPS</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th></th>
																										<th id="modalPadding">NPS</th>
																										<th id="modalPadding">Permissible Deduction<br>(Max. Rs. 50,000/-)</th>
																									</tr>
						
																									<tr>
																										<th id="modalPadding">NPS</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="NPS1" name="NPS1" value="0" onchange="tempNPS();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="NPSDeduction" id="NPSDeduction" value="0"
																											readonly="readonly"></td>
																									</tr>
						
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																											onclick="NPSRedirect()">
								
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
						
																		</th>
																	</tr>							                               
					                                   
					                                       			 <tr>
					                                       			 	<th><center>2</center></th>
																		<th><center>RGESS</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="RGESS" id="RGESS"
																						value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th style="padding-top: 15px;">
																				<!-- Button trigger modal -->
																				<center><i class="glyphicon glyphicon-info-sign" style="color: black;font-size: 13px;" tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="Max. investment Rs.50000/- & maximum exemption 50 % of maxi. Investment amt. i.e.  Rs. 25,000/-"></i>
																				<a href="" data-toggle="modal" data-target="#myModal10">
																				<i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal10" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">RGESS</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th></th>
																										<th id="modalPadding">RGESS</th>
																										<th id="modalPadding">Permissible Deduction</th>
																									</tr>
						
																									<tr>
																										<th id="modalPadding">RGESS</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="RGESS1" name="RGESS1" value="0"
																											onchange="tempRGESS(); "></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="RGESSDeduction" id="RGESSDeduction" value="0"
																											readonly="readonly"></td>
																									</tr>
						
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="NPSRedirect()">
						
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
																		</th>
																	</tr>
																	
							                                        <tr>
							                                        	<th><center>3</center></th>
																		<th><center>Total(1 & 2)</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TotalE"
																						id="TotalE" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th><input type="hidden" class="form-control" name="actualTotalE"
																					id="actualTotalE" value="0" readonly="readonly"></th>
																	</tr>
																	
																	<tr>
																		<th><center>4</center></th>
																		<th><center>Total E</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TotalCE"
																						id="TotalCE" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																	</tr>
							                                        
							                                    </tbody>
							                                </table>
							                            </div>
							                            <!-- /.table-responsive -->
							                        <!-- </div> -->
							                        <!-- /.panel-body -->
							                    </div>
							                    <!-- /.panel -->
							                </div>
										</div>
									</div>
                                
                <div id="headingCollapse63"  class="card-header" style="padding: 0.5rem 1.5rem;">
					<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive" class="card-title lead info collapsed">
						<div class="row">
							<div class="col-lg-12">
								<div class="col-md-8" align="left">(5) 80E,80G & 80D(Annual)</div>
								<div class="col-md-2">
									<div class="col-md-1">Rs.</div>
									<div class="col-md-1" id="part5self"></div>
								</div>
								<div class="col-md-2">
									<div class="col-md-1">Rs.</div>
									<div class="col-md-1" id="part5"></div>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div id="collapseFive" role="tabpanel" aria-labelledby="headingCollapse63" class="border-info no-border-top card-collapse collapse" aria-expanded="false">
					<div class="card-body">
						<div class="card-block">
							                      <div class="col-lg-7">
							                            <div class="table-responsive">
							                                <table class="table-bordered" width="100%">
							                                	<tbody>
							                                        <tr>
							                                        	<th width="50px;"><center>1</center></th>
																		<th><center>Mediclaim 80 D</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="Mediclaim"
																						id="Mediclaim" value="0" readonly="readonly"
																						onchange="EGD80();">
																				</div>
																			</center></th>
																		<th width="50px;">
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal12"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal12" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
																						<div class="modal-content">
																							<div class="modal-header">
																								<button type="button" class="close"
																									data-dismiss="modal" aria-hidden="true">&times;</button>
																								<h4 class="modal-title" id="myModalLabel">Mediclaim</h4>
																							</div>
						
						
						
																							<div class="modal-body">
																								<table class="table table-striped">
						
																									<input type="hidden" name="birth" id="birth"
																										value="<%=user.getBirth_date()%>"
																										onclick="getAge();">
																									<input type="hidden" name="age" id="age" value="0"
																										readonly="readonly">
						
																									<tr>
																										<th></th>
																										<th id="modalPadding">Health Insurance Premium Paid</th>
																										<th id="modalPadding">Max. Tax Deduction Limits</th>
																									</tr>
						
																									<tr>
																										<th id="modalPadding">Self,Spouse & <br>Children</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="SelfSpouseChildren" name="SelfSpouseChildren"
																											value="0" onchange="tempSelfSpouseChildren();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="SelfSpouseChildrenDeduction"
																											id="SelfSpouseChildrenDeduction" value="0"
																											readonly="readonly"></td>
						
																									</tr>
						
																									<tr>
																										<td id="modalPadding">Enter Father's <br>Birthday</td>
																										<td id="modalPadding"><input type="text" id="datepicker1"
																											width="155" name="datepicker1" 
																											placeholder="dd/mm/yyyy" class="form-control"></td>
																										<td id="modalPadding"><input type="hidden" id="FatherBdy"
																											name="FatherBdy" class="form-control"></td>
																									</tr>
						
																									<tr>
																										<th id="modalPadding">Parents</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Parents" name="Parents" value="0"
																											onchange="tempParents();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="ParentsDeduction" id="ParentsDeduction"
																											value="0" readonly="readonly"></td>
						
																									</tr>
																									
																									<tr>
																										<th id="modalPadding">Health Check Up</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="health" name="health" value="0"
																											onchange="HealthCheckUp();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="healthDeduction" id="healthDeduction"
																											value="0" readonly="readonly"></td>
						
																									</tr>
						
																									<tr>
																										<th id="modalPadding">Total Deduction<br>max Rs.60000/-</th>
																										<td id="modalPadding"><input type="hidden" class="form-control"
																											name="TotalActual" id="TotalActual" value="0"
																											readonly="readonly"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="TotalDeduction" id="TotalDeduction" value="0"
																											readonly="readonly"></td>
																									</tr>
						
																								</table>
																							</div>
																							<div class="modal-footer">
																								<input type="button" value="SAVE"
																									class="btn btn-primary" data-dismiss="modal"
																									onclick="MediclaimRedirect();">
						
																							</div>
																						</div>
																						<!-- /.modal-content -->
																					</div>
																					<!-- /.modal-dialog -->
																				</div>
																				<!-- /.modal -->
																		</th>
																	</tr>
							                                    
							                                        <tr>
							                                        	<th><center>2</center></th>
																		<th><center>Donation(80 G/ 80 G(5))</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="Donation"
																						id="Donation" value="0" readonly="readonly" onchange="EGD80();">
																				</div>
																			</center></th>
																		<th style="padding-top: 15px;">
																			<!-- Button trigger modal -->
																			<center><a href="" data-toggle="modal" data-target="#myModal13"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																			<!-- Modal -->
																			<div class="modal fade" id="myModal13" tabindex="-1"
																				role="dialog" aria-labelledby="myModalLabel"
																				aria-hidden="true">
																				<div class="modal-dialog">
																					<div class="modal-content">
																						<div class="modal-header">
																							<button type="button" class="close"
																								data-dismiss="modal" aria-hidden="true">&times;</button>
																							<h4 class="modal-title" id="myModalLabel">Donation(80 G/ 80 G(5))(Annual)</h4>
																						</div>
																						<div class="modal-body">
																								<div class="form-group">
																										<label>Choose</label> &nbsp;&nbsp;&nbsp;&nbsp;
																										<label class="radio-inline"> <input type="radio"
																											name="donationRadio" id="0" 
																											value="cash" onchange="checkDonationRadio()">Cash 
																										</label> 
																										<label class="radio-inline"> <input
																											type="radio" name="donationRadio"
																											id="1" value="cheque" onchange="checkDonationRadio()">Cheque
																										</label> <input type="hidden" name="donationResult" id="donationResult">
																									</div>
																							<div id="cash">
																							<table class="table table-striped">
																								<tr><center><h5><b>Donation Through Cash</b></h5></center></tr>
																								<tr>
																									<th></th>
																									<th id="modalPadding">Cash Amount</th>
																									<th id="modalPadding">Permissible Deduction</th>
																								</tr>
						
																								<tr>
																									<th id="modalPadding">Cash Amount</th>
																									<td id="modalPadding"><input type="text" class="form-control"
																										id="cashAmount" name="cashAmount" value="0"
																										onchange="CashDonation(); "></td> 
																									<td id="modalPadding"><input type="text" class="form-control"
																										name="cashDeduction" id="cashDeduction"
																										value="0" readonly="readonly"></td>
																								</tr>
						
																							</table>
																							</div>
																							
																							<div id="cheque">
																							<table class="table table-striped">
																								<tr><center><h5><b>Donation Through Cheque</b></h5></center></tr>
																								<tr>
																									<th></th>
																									<th id="modalPadding">Cheque Amount</th>
																									<th id="modalPadding">Permissible Deduction</th>
																								</tr>
						
																								<tr>
																									<th id="modalPadding">Cheque Amount</th>
																									<td id="modalPadding"><input type="text" class="form-control"
																										id="chequeAmount" name="chequeAmount" value="0"
																										onchange="ChequeDonation(); "></td> 
																									<td id="modalPadding"><input type="text" class="form-control"
																										name="chequeDeduction" id="chequeDeduction"
																										value="0" readonly="readonly"></td>
																								</tr>
						
																							</table>
																							</div>
																							
																							<!-- <div id="DoneeDetail">
																								<center><h5><b>Donee Details</b></h5></center>
																								<table class="table table-striped">
																									<tr>
																										<td><label id="LandlordNameLabel">Donee
																												Name</label></td>
																										<td><input type="text" class="form-control"
																											name="doneeName" id="doneeName" value=""></td>
																									</tr>
																									
																									<tr>
																										<td><label id="LandlordPanNoLabel">Donee
																												PAN No.</label></td>
																										<td><input type="text" class="form-control"
																											name="doneePanNo" id="doneePanNo" value=""></td>
																									</tr>
																									
																									<tr>
																										<td><label id="LandlordNameLabel">Donee Address</label></td>
																										<td><textarea rows="3" name="doneeAddress"
																													id="doneeAddress" class="form-control"></textarea></td>
																									</tr>
																								</table>
																							</div> -->
																							
																						</div>
																						<div class="modal-footer">
																							<input type="button" value="SAVE"
																								class="btn btn-primary" data-dismiss="modal"
																								onclick="DonationRedirect()">
						
																						</div>
																					</div>
																					<!-- /.modal-content -->
																				</div>
																				<!-- /.modal-dialog -->
																			</div>
																			<!-- /.modal -->
																	</th>
																	</tr>
																	
							                                        <tr>
							                                        	<th><center>3</center></th>
																		<th><center>Donation (80 GGC)</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TotalDonation"
																						id="TotalDonation" value="0" readonly="readonly" onchange="EGD80();">
																				</div>
																			</center></th>
																		<th style="padding-top: 15px;">
																			<!-- Button trigger modal -->
																			<center><a href="" data-toggle="modal" data-target="#myModal14"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																			<!-- Modal -->
																			<div class="modal fade" id="myModal14" tabindex="-1"
																				role="dialog" aria-labelledby="myModalLabel"
																				aria-hidden="true">
																				<div class="modal-dialog">
																					<div class="modal-content">
																						<div class="modal-header">
																							<button type="button" class="close"
																								data-dismiss="modal" aria-hidden="true">&times;</button>
																							<h4 class="modal-title" id="myModalLabel">Donation(80 GGC)
																								(Annual)</h4>
																						</div>
																						<div class="modal-body">
																								
																							<table class="table table-striped">
																								<tr>
																									<th></th>
																									<th id="modalPadding">Donation Amount</th>
																									<th id="modalPadding">Permissible Deduction</th>
																									</tr>
						
																								<tr>
																									<th id="modalPadding">Donation Amount</th>
																									<td id="modalPadding"><input type="text" class="form-control"
																										id="donationAmount" name="donationAmount" value="0"
																										onchange="DonationAmount(); "></td> 
																									<td id="modalPadding"><input type="text" class="form-control"
																										name="donationDeduction" id="donationDeduction"
																										value="0" readonly="readonly"></td>
																								</tr>
						
																							</table>
																							
																						</div>
																						<div class="modal-footer">
																							<input type="button" value="SAVE"
																								class="btn btn-primary" data-dismiss="modal"
																								onclick="DonationRedirect()">
						
																						</div>
																					</div>
																					<!-- /.modal-content -->
																				</div>
																				<!-- /.modal-dialog -->
																			</div>
																			<!-- /.modal -->
																	</th>
																	</tr>
							                                        
							                                        <tr>
							                                        	<th><center>4</center></th>
																		<th><center>Education Loan interest (80 E)</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control"
																						name="EducationLoaninterest" id="EducationLoaninterest"
																						value="0" onchange="EGD80();">
																				</div>
																			</center></th>
																		<th></th>
																	</tr>
																	
																	<tr>
																		<th><center>5</center></th>
																		<th><center>Total(1 to 4)</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TotalF"
																						id="TotalF" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																	</tr>
																	
																	<tr>
																		<th><center>6</center></th>
																		<th><center>Total F</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="ActualTotalF"
																						id="ActualTotalF" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																	</tr>
																	
																	<!-- <tr>
																		<th style="padding-top: 15px;"><center>6</center></th>
																		<th style="padding-top: 15px;"><center>TotalF</center></th>
																		<th style="width: 180px;"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TaxableIncome"
																						id="TaxableIncome" value="0" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																	</tr> -->
																	
							                                    </tbody>
							                                </table>
							                            </div>
							                            <!-- /.table-responsive -->
							                        <!-- </div> -->
							                        <!-- /.panel-body -->
							                    </div>
							                    <!-- /.panel -->
							                </div>
										</div>
									</div>
								</div>         
		               		 </div>          
		             	</div>
		          	 </div>
                               
                                <div class="card box-shadow-0" data-appear="appear">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;">
					                    <h5 class="card-title">Tax</h5>
					                </div>
					                <div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey">
					                        <div class="row">
	                               				 <div class="col-lg-3">
		                                            <label><b>TotalF(Taxable Income)</b></label>
		                                            <b><input class="form-control" name="TaxableIncome"
															id="TaxableIncome" value="0" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Tax</b></label>
		                                            <b><input class="form-control" name="Tax" id="Tax"
																value="0" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Tax Remit</b></label>
		                                            <b><input class="form-control" name="TaxRemit" id="TaxRemit"
																value="0" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Total Tax</b></label>
		                                            <b><input class="form-control" name="TotalTax" id="TotalTax"
																value="0" readonly="readonly"></b>
		                                         </div>
                                        	 </div>
                                        	 <br>
                                        	 <div class="row">
	                               				 <div class="col-lg-3">
		                                            <label><b>Edu Cess</b></label>
		                                            <b><input class="form-control" name="EduCess"
															id="EduCess" value="0" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>TotalH</b></label>
		                                            <b><input class="form-control" name="TotalH" id="TotalH"
																value="0" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         
                                        	 </div>
					                    </div>
					                </div>
					            </div>
                <!-- /.col-lg-12 -->
            <!-- /.row -->
				
				
								<div class="card box-shadow-0" data-appear="appear" id="adult">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;">
					                    <h5 class="card-title"><center>Income tax slab for individual tax payers(less than 60 years old)(Men)</center></h5>
					                </div>
					                <div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey">
					                        <div class="table-responsive">
				                                <table class="table table-striped table-bordered table-hover">
				                                      <tbody>
				                                        <tr>
															<th><center>Income Range</center></th>
															<th><center>Rate</center></th>
														</tr>
														<tr>
															<td><center>Up to Rs. 2,50,000</center></td>
															<td><center>NIL</center></td>
														</tr>
														<tr>
															<td><center>Rs. 2,50,001 to Rs. 5,00,000</center></td>
															<td><center>5%</center></td>
														</tr>
														<tr>
															<td><center>Rs. 5,00,001 to Rs. 10,00,000</center></td>
															<td><center>20%</center></td>
														</tr>
														<tr>
															<td><center>Rs. 10,00,001 & Above</center></td>
															<td><center>30%</center></td>
														</tr>
							                           </tbody>
							                     </table>
				                            </div>
						                    </div>
						                </div>
						            </div>
						            
						            <div class="card box-shadow-0" data-appear="appear" id="senior">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;">
					                    <h5 class="card-title"><center>Income tax slab for individual tax payers(60 years old or more but less than 80 years old)(both Men & Women)</center></h5>
					                </div>
					                <div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey">
					                        <div class="table-responsive">
				                                <table class="table table-striped table-bordered table-hover">
				                                      <tbody>
				                                        <tr>
															<th><center>Income Range</center></th>
															<th><center>Rate</center></th>
														</tr>
														<tr>
															<td><center>Up to Rs. 3,00,000</center></td>
															<td><center>NIL</center></td>
														</tr>
														<tr>
															<td><center>Rs. 3,00,001 to Rs. 5,00,000</center></td>
															<td><center>5%</center></td>
														</tr>
														<tr>
															<td><center>Rs. 5,00,001 to Rs. 10,00,000</center></td>
															<td><center>20%</center></td>
														</tr>
														<tr>
															<td><center>Rs. 10,00,001 & Above</center></td>
															<td><center>30%</center></td>
														</tr>
				                                    </tbody>
				                                </table>
				                            </div>
						                    </div>
						                </div>
						            </div>
						            
						            <div class="card box-shadow-0" data-appear="appear" id="female">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;">
					                    <h5 class="card-title"><center>Income tax slab for individual tax payers(less than 60 years old)(Women)</center></h5>
					                </div>
					                <div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey">
					                        <div class="table-responsive">
				                                <table class="table table-striped table-bordered table-hover">
				                                      <tbody>
				                                        <tr>
															<th><center>Income Range</center></th>
															<th><center>Rate</center></th>
														</tr>
														<tr>
															<td><center>Up to Rs. 3,00,000</center></td>
															<td><center>NIL</center></td>
														</tr>
														<tr>
															<td><center>Rs. 3,00,001 to Rs. 5,00,000</center></td>
															<td><center>5%</center></td>
														</tr>
														<tr>
															<td><center>Rs. 5,00,001 to Rs. 10,00,000</center></td>
															<td><center>20%</center></td>
														</tr>
														<tr>
															<td><center>Rs. 10,00,001 & Above</center></td>
															<td><center>30%</center></td>
														</tr>
				                                    </tbody>
				                                </table>
				                            </div>
						                    </div>
						                </div>
						            </div>
				
								<center>

									<input type="button" value="SAVE" class="btn btn-primary" onclick="Submit();">
									<input type="reset" value="CLEAR" class="btn btn-danger">
								</center>
								<br>
						
			</div>
		</div>
		</div>
		</div>
		</div>
		</section>
	</div>
		</div>
	</div>
</form>
	<!-- /.panel-body -->


	<!-- /.row -->
	<!-- /#wrapper -->
	
	<script type="text/javascript">
		function checkRadio() {
			//alert("SKY");

			var mealCardRadio = document.getElementsByName("mealCardRadio");
			
			for (i = 0; i < 3; i++) {
				if (mealCardRadio[i].checked) {
					
					if(mealCardRadio[i].id == 0)
						{
							// yearly------
							$("#monthly").hide();
							$("#yearly").show();
							document.getElementById("result").value = "Yearly";
							
							var days = 300 ;
							var mealCard = (days * 100) ;
							document.getElementById("MealCardDeduction").value = mealCard;
							
						}
					else if(mealCardRadio[i].id == 1)
						{
							// monthly---
							$("#yearly").hide();
							$("#monthly").show();
							document.getElementById("result").value = "Monthly";
							
						}
				}
			}
		}
	</script>
	
	<script type="text/javascript">
		function checkDonationRadio() {
			//alert("SKY");

			var donationRadio = document.getElementsByName("donationRadio");
			
			for (i = 0; i < 3; i++) {
				if (donationRadio[i].checked) {
					
					if(donationRadio[i].id == 0)
						{
							$("#cheque").hide();
							$("#cash").show();
							$("#DoneeDetail").show();
							document.getElementById("donationResult").value = "Cash";
							
						}
					else if(donationRadio[i].id == 1)
						{
							$("#cash").hide();
							$("#cheque").show();
							$("#DoneeDetail").show();
							document.getElementById("donationResult").value = "Cheque";
							
						}
				}
			}
		}
	</script>
	
	<script type="text/javascript">
		function check() {
			//alert("SKY");

			var city = document.getElementsByName("City");
			for (i = 0; i < 2; i++) {
				if (city[i].checked) {
					/* if((city[i].id == 0))
					{ */
					//alert("Select");
					
					// MATRO.............
					
					$("#nonMetro").hide();
					$("#totalBasicNonMetro").hide();
					$("#rentSlipNonMetro").hide();
					$("#actualHRANonMetro").hide();
					$("#nonMetroDeduction").hide();

					document.getElementById("checked").value = "Metro";
					$("#metro").show();
					$("#totalBasicMetro").show();
					$("#rentSlipMetro").show();
					$("#actualHRAMetro").show();
					$("#metroDeduction").show();

					/* } */
				} else {
					//alert(" Not Select");
					
					//NON - MATRO.............
					$("#nonMetro").show();
					$("#totalBasicNonMetro").show();
					$("#rentSlipNonMetro").show();
					$("#actualHRANonMetro").show();
					$("#nonMetroDeduction").show();
					document.getElementById("checked").value = "Non-Metro";
					$("#metro").hide();
					$("#totalBasicMetro").hide();
					$("#rentSlipMetro").hide();
					$("#actualHRAMetro").hide();
					$("#metroDeduction").hide();
				}
			}

		}
	</script>


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
	  <!-- BEGIN PAGE VENDOR JS-->
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
	
	
	<!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-basic.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
      <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.flash.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/jszip.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/pdfmake.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/vfs_fonts.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.html5.min.js" type="text/javascript"></script>
    <script src="app-assets/vendors/js/tables/buttons.print.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    
      <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/tables/datatables/datatable-advanced.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    
    <script src="app-assets/js/scripts/navs/navs.min.js"
		type="text/javascript"></script>
		<script src="app-assets/js/scripts/forms/select/form-select2.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="offlineDatePicker/jquery.min.js"></script>
		<script type="text/javascript" src="offlineDatePicker/jquery-ui.min.js"></script>
		<script type="text/javascript">
	
	
		$(document).ready(function() {
							var $datepicker1 = $("#datepicker1");
							var $endDatePicker1 = $("#endDatePicker1");
							var $startDatePicker1 = $("#startDatePicker1");
							
							
							 var holiDates = [];
							
							 
							 <%for (int i = 0; i < holiday.size(); i++)
						 		{
						 				String date = holiday.get(i);
						 				 %>
						 				
						   		  		holiDates[<%=i%>] = new Date("\"<%=date%>\"");
						   		  		
						   		  <%}%>
							 
							 
							
							$datepicker1.datepicker({
										dateFormat : 'dd/mm/yy',
										maxDate : 0,
										changeMonth : true,
										changeYear : true,
										onSelect : function(dateStr) {
											var toDate = $datepicker1
													.datepicker('getDate');
											var backDate = new Date(toDate);
											
											
											//alert("Fathers BDy:" + backDate);
											var nowdate = new Date();
											//alert("A" + nowdate);

											var diff = nowdate.getTime()
													- backDate.getTime();
											var years = Math
													.floor(diff / 31536000000); // end - start returns difference in milliseconds 
											//alert("age" + years);
											document.getElementById("FatherBdy").value = years;

											var ParentsMediclaim = document
													.getElementById("Parents").value;
											if (ParentsMediclaim != 0) {

												if (years > 60) {
													if (ParentsMediclaim > 30000) {
														document
																.getElementById("ParentsDeduction").value = 30000;
													} else {
														document
																.getElementById("ParentsDeduction").value = ParentsMediclaim;
													}
												} else {
													alert("age is less than 60 yr");
													if (ParentsMediclaim > 25000) {
														document
																.getElementById("ParentsDeduction").value = 25000;
													} else {
														document
																.getElementById("ParentsDeduction").value = ParentsMediclaim;
													}
												}
											}
											sum();
										}
									});
							
							
							
							
							
							$startDatePicker1.datepicker({
								dateFormat : 'dd/mm/yy',
							/* 	maxDate : 0, */
								changeMonth : true,
								onSelect : function(dateStr) {
									var toDate = $startDatePicker1.datepicker('getDate');
									var backDate = new Date(toDate);
									}

							});
							
							$endDatePicker1.datepicker({
								dateFormat : 'dd/mm/yy',
							/* 	maxDate : 0, */
								changeMonth : true,
								onSelect : function(dateStr) {
									var toDate = $endDatePicker1.datepicker('getDate');
									var backDate = new Date(toDate);
									
									var startDate = $startDatePicker1.datepicker('getDate');
						            var endDate = $endDatePicker1.datepicker('getDate');
						            
						            var diff = new Date(endDate - startDate);
						 			var days = (diff / 1000 / 60 / 60 / 24 + 1);
						 			
									
									
									var currentDate = new Date(startDate);
								     var between = [];
								    
								     while (currentDate <= endDate)
									 {
								         between.push(new Date(currentDate));
								         currentDate.setDate(currentDate.getDate() + 1);
								     }
								     
								     var sundaycounter = 0;
								     var holidaycounter = 0;
								     var sundayholidaycounter = 0;
								 	var frontDate1 = new Date(startDate);
								 	var checkflag = false;
								     for(var k = 0; k < between.length; k++)
									  {
								    	 
								    	 var sundayCheck = between[k].getDay();					    	 
								    	 var MAINCOUNTER = $.datepicker.formatDate('mm/dd/yy', frontDate1);
								    	 for (var i = 0; i < holiDates.length; i++) 
							 				{
							 					 var qwerty = $.datepicker.formatDate('mm/dd/yy', holiDates[i]);
							 					 
							 					//alert("MAIN " + MAINCOUNTER + " HOLIDAY " + qwerty );
							 					 if((MAINCOUNTER == qwerty) && (sundayCheck == 0))
							 						 {
							 							//alert("DOUBLE YOOOO");
							 							sundayholidaycounter++;
							 							checkflag = true;
							 						 }
							 					 else if(MAINCOUNTER == qwerty)
							 					{
							 						 	holidaycounter++;
							 				    }
							 				}
								    	 
								    	 if(checkflag == false)
								    		 {
								    			 if(sundayCheck == 0)
													{
									    		 		sundaycounter++;
													}
								    		 }
								    	 
								    	 frontDate1.setDate(frontDate1.getDate() + 1);	
									  }
								     
								  //  alert("SUNDAY " + sundaycounter + " HOLIDAY " + holidaycounter);
								    
								     var DAYS = days - sundaycounter - holidaycounter - sundayholidaycounter;
								    // alert("DAYS"+DAYS);
								     document.getElementById("days").value = DAYS;
							 			
										var mealCard = (DAYS * 100) ;
										//alert("mealCard"+mealCard);
										document.getElementById("MealCardDeduction1").value = mealCard;
									
								}
							});
		});
		
	</script>
</body>
</html>