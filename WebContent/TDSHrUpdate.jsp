<%@page import="com.hrms.tds.bean.TDSPayrollMasterDataBean"%>
<%@page import="com.hrms.tds.dao.PayrollList"%>
<%@page import="com.hrms.tds.bean.TDSTaxBean"%>
<%@page import="com.hrms.tds.bean.TDSDocumentUploadBean"%>
<%@page import="com.hrms.pms.bean.MonthBean"%>
<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalFBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalEBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalDBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalCBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalBBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalABean"%>
<%@page import="com.hrms.tds.bean.TDSHrBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalFBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalEBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalDBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalCBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalBBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalABean"%>
<%@page import="com.hrms.tds.bean.TDSBean"%>
<%@page import="com.hrms.tds.dao.TDSListDAO"%>
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
boolean metro = false;
boolean monthly = false;
boolean cash = false;
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
<link href="offlineDatePicker/1jquery-ui.css" rel="stylesheet">
<script src="app-assets/js/core/libraries/jquery.min.js" type="text/javascript"></script>
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
		/* $(document).ready(function() {
			$("#LandlordDetail").hide();
		}); */

		/* $(document).ready(function() {
			$("#HouseLoanDetail").hide();
			//$("#first").hide();
		}); */

		$(document).ready(function() {
			/* $("#nonMetro1").show();
			$("#totalBasicNonMetro").show();
			$("#rentSlipNonMetro").show();
			$("#actualHRANonMetro").show();
			$("#nonMetroDeduction").show();

			$("#metro").hide();
			$("#totalBasicMetro").hide();
			$("#rentSlipMetro").hide();
			$("#actualHRAMetro").hide();
			$("#metroDeduction").hide(); */
		});
		
		$(document).ready(function() {
			/* $("#yearly").show();
			$("#monthly").hide();
			document.getElementById("result").value = "Yearly";
			var days = 300 ;
			var mealCard = (days * 100) ;
			document.getElementById("MealCardDeduction").value = mealCard; */
		});
		
		$(document).ready(function() {
			/* $("#cash").hide();
			$("#cheque").hide(); */
			$("#DoneeDetail").hide();
			
		});
		
		$(document).ready(function() {
			document.getElementById("checked").value = "Non-Metro";			
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
			
			if((years >= 60) && (years < 80))
			{
				if(gender == "Female")
					{
						$("#adult").hide();
						$("#senior").hide();
						$("#female").show();
						$("#seniorCitizen").hide();
					}
				else if(gender == "Male")
					{
						$("#adult").hide();
						$("#senior").show();
						$("#female").hide();
						$("#seniorCitizen").hide();
					}
			}
			else if(years < 60)
			{
				if(gender == "Female")
					{
						$("#senior").hide();
						$("#adult").hide();
						$("#female").show();
						$("#seniorCitizen").hide();
					}
				else if(gender == "Male")
					{
						$("#senior").hide();
						$("#adult").show();
						$("#female").hide();
						$("#seniorCitizen").hide();
					}
				
			}
			else if(years >= 80)
			{
				$("#senior").hide();
				$("#adult").hide();
				$("#female").hide();
				$("#seniorCitizen").show();
			}
			
			Temp();
		});
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
		payableData();
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
		var totalBasic = document.getElementById("totalBasic1").value;
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
			if(totalRent >= totalBasic)
				{
					totalRentNonMetro = (totalRent - ((totalBasic * 10) / 100));
					document.getElementById("rentSlipNonMetro").value = totalRentNonMetro.toFixed(2);
					document.getElementById("rentSlipMetro").value = totalRentNonMetro.toFixed(2);
				}else if(totalRent < totalBasic)
				{
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
					alert("IF");
					totalRentNonMetro = (totalRent - ((totalBasic * 10) / 100));
					document.getElementById("rentSlipNonMetro").value = totalRentNonMetro.toFixed(2);
					document.getElementById("rentSlipMetro").value = totalRentNonMetro.toFixed(2);
				}else if(totalRent <= totalBasic)
				{
					alert("ELSE");
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
		alert(ProvidedMedicalBills);
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
	
	/* function MealCard(id) {
		var MealCard = document.getElementById("MealCard1").value;
		if (MealCard < 300) {
			var m = (MealCard * 100)
			document.getElementById("MealCardDeduction").value = m;
		} else {
			alert("maximum limit 300 days..");
			document.getElementById("MealCardDeduction").value = 0;
		}
	} */
	
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
		Total = parseFloat(TotalGross) - parseFloat(TotalHRA);
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
			/* $(document).ready(function() {
				$("#HouseLoanDetail").show();
			}); */
		} else if(HouseLoanInterest < 200000){
			//alert("else");
			document.getElementById("HouseLoanDeduction").value = HouseLoanInterest;
			/* $(document).ready(function() {
				$("#HouseLoanDetail").show();
			}); */
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
				document.getElementById("part3self").innerHTML = 150000;
				
				totald = parseInt(totalc) - 150000 ;
				document.getElementById("totalD").value = totald;
				document.getElementById("part3").innerHTML = totald;
			} else {
				document.getElementById("80CTotal").value = TotalD.toFixed(2);
				document.getElementById("part3self").innerHTML = TotalD.toFixed(2);
				
				totald = parseInt(totalc) - TotalD.toFixed(2) ;
				document.getElementById("totalD").value = totald;
				document.getElementById("part3").innerHTML = totald;
			}
		}
		calculateNPS();
	}
	
	function payableData()
	{
		/* alert("SSSHHHH");
		var payable_lic = $("#LICPayable").val();
		alert(payable_lic);
		var payable_epf = $("#EPFPayable").val();
		alert(payable_epf);
		var payable_ppf = $("#PPFPayable").val();
		alert(payable_ppf);
		var payable_nsc = $("#NSCPayable").val();
		alert(payable_nsc);
		var payable_mf = $("#MFPayable").val();
		alert(payable_mf);
		var payable_tuition_fees = $("#TuitionFeesPayable").val();
		alert(payable_tuition_fees);
		var payable_stamp_duty = $("#StampDutyPayable").val();
		alert(payable_stamp_duty);
		var payable_house_loan = $("#HouseLoanPayable").val();
		alert(payable_house_loan);
		var payable_fix_deposite = $("#FixDepositePayable").val();
		alert(payable_fix_deposite);
		var payable_other = $("#OtherPayable").val();
		alert(payable_other);*/
		var total = $("#Payable80CTotal").val();
		//alert(total); 
		$("#payablePart3Self").html(total);
		
		var totalc = $("#TotalC").val();
		//alert("C :"+totalc);

		var totald = totalc - total ;
		//alert(totald);
		$("#PayabletotalD").val(totald);
		$("#payablePart3").html(totald);
		
		var nps_rgess = $("#TotalE").val();
		$("#payablePart4Self").html(nps_rgess);
		//alert("E :"+nps_rgess);
		var totale = totald - nps_rgess;
		//alert("Total E :"+totale);
		$("#PayabletotalE").val(totale);
		$("#payablePart4").html(totale);
		
		var total_egd = $("#TotalF").val();
		$("#payablePart5Self").html(total_egd);
		var totalf = totale - total_egd ;
		$("#PayabletotalF").val(totalf.toFixed(2));
		$("#payablePart5").html(totalf);
		$("#PayableTaxableIncome").val(totalf.toFixed(2));
		
		var age = $("#age").val();
		var gender = $("#gender").val();
		//alert("AGE :"+age);
		var PayableTax = 0.0, PayableTaxRemit = 0.0, PayableTotalTax = 0.0, PayableEduCess = 0.0;
		
		if(gender == "Female")
		{
			if (totalf <= 300000) {
				//alert("less than 300000");
				PayableTax = 0;
				PayableTaxRemit = 0;
				$("#PayableTax").val(PayableTax.toFixed(2));
				$("#PayableTaxRemit").val(PayableTaxRemit);
			} else if (totalf > 300000 && totalf <= 500000) {
				//alert("between 300000-500000");
				PayableTax = ((totalf - 300000) * 5) / 100;
				$("#PayableTax").val(PayableTax.toFixed(2));
				PayableTaxRemit = 5000;
				$("#PayableTaxRemit").val(PayableTaxRemit);
			} else if (totalf > 500000 && totalf <= 1000000) {
				//alert("between 500000-1000000");
				PayableTax = (((totalf - 500000) * 20) / 100) + 25000;
				$("#PayableTax").val(PayableTax.toFixed(2));
				PayableTaxRemit = 0;
				$("#PayableTaxRemit").val(PayableTaxRemit);
			} else if (totalf > 1000000) {
				//alert("greater than 1000000");
				Tax = (((totalf - 1000000) * 30) / 100) + 125000;
				$("#PayableTax").val(PayableTax.toFixed(2));
				PayableTaxRemit = 0;
				$("#PayableTaxRemit").val(PayableTaxRemit);
			}
		}
		else if(gender == "Male")
		{
			if((age >= 60) && (age < 80)){
				if (totalf <= 300000) {
					//alert("less than 300000");
					PayableTax = 0;
					PayableTaxRemit = 0;
					$("#PayableTax").val(PayableTax.toFixed(2));
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 300000 && totalf <= 500000) {
					//alert("between 300000-500000");
					PayableTax = ((totalf - 300000) * 5) / 100;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 5000;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 500000 && totalf <= 1000000) {
					//alert("between 500000-1000000");
					PayableTax = (((totalf - 500000) * 20) / 100) + 25000;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 1000000) {
					//alert("greater than 1000000");
					Tax = (((totalf - 1000000) * 30) / 100) + 125000;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				}
			}else if( age < 60){
				if (totalf <= 250000) {
					//alert("less than 250000");
					PayableTax = 0;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 250000 && totalf <= 500000) {
					//alert("between 250000-500000");
					PayableTax = ((totalf - 250000) * 5) / 100;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 5000;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 500000 && totalf <= 1000000) {
					//alert("between 500000-1000000");
					PayableTax = (((totalf - 500000) * 20) / 100) + 25000;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 1000000) {
					//alert("greater than 1000000");
					PayableTax = (((totalf - 1000000) * 30) / 100) + 125000;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				}
			}else if(age >= 80){
				if (totalf <= 250000) {
					//alert("less than 250000");
					PayableTax = 0;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf <= 500000) {
					//alert("between 250000-500000");
					PayableTax = 0;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 500000 && totalf <= 1000000) {
					//alert("between 500000-1000000");
					PayableTax = (((totalf - 500000) * 20) / 100) + 25000;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 5000;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				} else if (totalf > 1000000) {
					//alert("greater than 1000000");
					PayableTax = (((totalf - 1000000) * 30) / 100) + 125000;
					$("#PayableTax").val(PayableTax.toFixed(2));
					PayableTaxRemit = 0;
					$("#PayableTaxRemit").val(PayableTaxRemit);
				}
			}
		}
		
		
		//alert("TAX :"+PayableTax);
		//alert("TAX REMIT :"+PayableTaxRemit);
		
		if(PayableTax <= 0.0)
		{
			$("#PayableTotalTax").val(PayableTotalTax);
		}
		else if(PayableTax > 0.0)
		{
			if(PayableTax <= PayableTaxRemit)
			{
				PayableTotalTax = (PayableTaxRemit - PayableTax);
				$("#PayableTotalTax").val(PayableTotalTax.toFixed(2));
			}
			else if( PayableTax > PayableTaxRemit)
			{
				PayableTotalTax = (PayableTax - PayableTaxRemit);
				$("#PayableTotalTax").val(PayableTotalTax.toFixed(2));
			}
		}
		
		PayableEduCess = (PayableTotalTax * 3) / 100;
		$("#PayableEduCess").val(PayableEduCess.toFixed(2));

		var totalh = (PayableTotalTax + PayableEduCess).toFixed(2);
		$("#PayableTotalH").val(totalh);
		
		Temp();
	}
	
	function transferValue()
	{
		//alert("payable");
		var lic = document.getElementById("LICPayable").value;
		var epf = document.getElementById("EPFPayable").value;
		var ppf = document.getElementById("PPFPayable").value;
		var nsc = document.getElementById("NSCPayable").value;
		var mf = document.getElementById("MFPayable").value;
		var tuition_fees = document.getElementById("TuitionFeesPayable").value;
		var stamp_duty= document.getElementById("StampDutyPayable").value;
		var house_loan = document.getElementById("HouseLoanPayable").value;
		var fix_deposite = document.getElementById("FixDepositePayable").value;
		var other = document.getElementById("OtherPayable").value;
		var total_d = document.getElementById("PayableTotalD").value;
		var total_80c = document.getElementById("Payable80CTotal").value;
		//alert("LIC :"+lic);
		
		
		document.getElementById("LifeInsurance").value = lic;
		document.getElementById("EPF").value = epf;
		document.getElementById("PPF").value = ppf;
		document.getElementById("NSC").value = nsc;
		document.getElementById("MF").value = mf;
		document.getElementById("TuitionFees").value = tuition_fees;
		document.getElementById("StampDuty").value = stamp_duty;
		document.getElementById("HouseLoanPrincipal").value = house_loan;
		document.getElementById("TaxSaverFixDeposit").value = fix_deposite;
		document.getElementById("Other").value = other;
		document.getElementById("TotalD").value = total_d;
		document.getElementById("80CTotal").value = total_80c;
		document.getElementById("part3self").innerHTML = total_80c;
		
		var totalc = document.getElementById("TotalC").value ;
		var totald = parseFloat(totalc) - total_80c;
		document.getElementById("part3").innerHTML = totald;
		
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
				document.getElementById("TotalE").value = Total;
				document.getElementById("part4self").innerHTML = Total;
				
				var TotalC = document.getElementById("TotalC").value;
				TotalE = parseFloat(TotalC) - parseFloat(Total) - parseFloat(Total80C);
				document.getElementById("TotalCE").value = TotalE.toFixed(2);
				document.getElementById("part4").innerHTML = TotalE.toFixed(2);
			} else {
				document.getElementById("TotalE").value = 50000;
				document.getElementById("part4self").innerHTML = 50000;
				
				var TotalC = document.getElementById("TotalC").value;
				TotalE = parseFloat(TotalC) - 50000 - parseFloat(Total80C);
				document.getElementById("TotalCE").value = TotalE.toFixed(2);
				document.getElementById("part4").innerHTML = TotalE.toFixed(2);
			}
		}
		EGD80();
		//payableData();
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
		//alert("cashDeduction" + cashDeduction);
		//alert("chequeDeduction" + chequeDeduction);
		var result;
		result = parseFloat(cashDeduction) + parseFloat(chequeDeduction) ;
		document.getElementById("Donation").value = result;
		
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
				if((age >= 60) && (age < 80))
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
				else if(age >= 80)
				{
					if (TotalTexableValue <= 250000) {
						//alert("less than 250000");
						Tax = 0;
						document.getElementById("Tax").value = Tax.toFixed(2);
					} else if (TotalTexableValue <= 500000) {
						//alert("between 250000-500000");
						Tax = 0;
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
			payableData();
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
			if((age >= 60) && (age < 80))
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
			else if(age >= 80)
			{
				if (Tax <= 500000) {
					//alert("taxremit is 0");
					TaxRemit = 0;
					document.getElementById("TaxRemit").value = TaxRemit;
				} else if (Tax > 500000 && Tax <= 1000000) {
					//alert("taxremit is 5000");
					TaxRemit = 5000.00;
					document.getElementById("TaxRemit").value = TaxRemit;
				} else if (Tax > 1000001) {
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
			alert("Total Tax GOPI:" + TotalTax);
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
		
		Temp();
	}
	
	function shruti() {
		var april = document.getElementById("april").value;
		var may = document.getElementById("may").value;
		var june = document.getElementById("june").value;
		var july = document.getElementById("july").value;
		var august = document.getElementById("august").value;
		var september = document.getElementById("september").value;
		var october = document.getElementById("october").value;
		var november = document.getElementById("november").value;
		var december = document.getElementById("december").value;
		var january = document.getElementById("january").value;
		var february = document.getElementById("february").value;
		var march = document.getElementById("march").value;
		
		var paid_Tax = parseFloat(march) + parseFloat(april) + parseFloat(may) + parseFloat(june) + parseFloat(july) + parseFloat(august) + parseFloat(september) 
						+ parseFloat(october) + parseFloat(november) + parseFloat(december) + parseFloat(january) + parseFloat(february);
		document.getElementById("paidTax").value = paid_Tax;
		document.getElementById("PayableTaxPaid").value = paid_Tax;
	}
	
	
	 function RedirectTaxPaid(){
		//alert("TAx TAx TAx");
		var paidTax = document.getElementById("paidTax").value;
		document.getElementById("TaxPaid").value = paidTax;
		
		Temp();
	} 
	
	 function Temp(){
			//alert("hii");
			var TotalH = 0.0, TaxPaid = 0.0,TaxPayable = 0.0;
			var docList = $("#docList").val();
			//alert("Size :"+docList);
			
			if(docList == 0)
				{
					//alert("If");
					TotalH = $("#TotalH").val();
					TaxPaid = $("#TaxPaid").val();
					if(TotalH >= TaxPaid)
					{
						TaxPayable = TotalH - TaxPaid ;
					}
					else
					{
						TaxPayable = TaxPaid - TotalH ;
					}
					$("#TaxPayable").val(TaxPayable.toFixed(2));
				}
			else
				{
					//alert("else");
					TotalH = $("#PayableTotalH").val();
					TaxPaid = $("#PayableTaxPaid").val();
					if(TotalH >= TaxPaid)
					{
						TaxPayable = TotalH - TaxPaid ;
					}
					else
					{
						TaxPayable = TaxPaid - TotalH ;
					}
					$("#PayableTaxPayable").val(TaxPayable.toFixed(2));
				}
		}
	
	 function Submit() {
		//alert("Submit");
		document.getElementById("formSubmit").submit();  
	} 
	 
	 function tempLock()
	 {
			//alert("LOCK");
			var a = "LOCK";
			alert("" + a);
			document.getElementById("LOCKNAME").value = a;
			document.getElementById("formSubmit").submit();  
		} 
</script>
</head>
<body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu 2-columns ">

		<% int id = Integer.parseInt(request.getParameter("tds_hr_id"));
			int employee_id = 0;
			int tds_id = 0;
			System.out.println("HR ID"+id);
			TDSListDAO tdsListDAO = new TDSListDAO(); 
        	List<TDSHrBean> listOfHrTDS = tdsListDAO.getAllTdsHrListById(id);
        
        for(int i = 0;i<listOfHrTDS.size();i++){
        	TDSHrBean tdsHrBean = listOfHrTDS.get(i);
        	int tds_hr_id = tdsHrBean.getTds_hr_id();
        	
        	TDSHrBean t = tdsListDAO.detailsOfTDSHr(tds_hr_id);
        	TDSHrTotalABean ta = tdsListDAO.detailsOfTDSHrTotal_A(tds_hr_id);
        	TDSHrTotalBBean tb = tdsListDAO.detailsOfTDSHrTotal_B(tds_hr_id);
        	TDSHrTotalCBean tc = tdsListDAO.detailsOfTDSHrTotal_C(tds_hr_id);
        	TDSHrTotalDBean td = tdsListDAO.detailsOfTDSHrTotal_D(tds_hr_id);
        	TDSHrTotalEBean te = tdsListDAO.detailsOfTDSHrTotal_E(tds_hr_id);
        	TDSHrTotalFBean tf = tdsListDAO.detailsOfTDSHrTotal_F(tds_hr_id);
        	
        	employee_id = t.getEmployeeBean().getEmployee_master_id();
        	TDSBean tds = tdsListDAO.detailsOfTDSIdForDocument(employee_id);
        	tds_id = tds.getTds_id();
        	System.err.println("TDS ID :"+tds_id);
        	
        	List<TDSDocumentUploadBean> tdsDocumentList = tdsListDAO.getListOfDocument(tds_id);
        	System.out.println("Document Size :"+tdsDocumentList.size());
        	
        	int emp_code = t.getEmployeeBean().getEmployee_code();
        	String hrms_company_name = t.getEmployeeBean().getCompanyListBean().getCompany_code();
        	String payroll_company_name = null;
  			if(hrms_company_name.equals("SL"))
      		{
      			payroll_company_name = "SLTL";
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
      	
        	PayrollList payrollList = new PayrollList();
        	List<TDSPayrollMasterDataBean> lastRecordOfMasterData  = payrollList.getLastRecordOfMasterData(emp_code,payroll_company_name);
        	String pan_no = null;
        	String designation = null;
        	for(TDSPayrollMasterDataBean masterDataBean : lastRecordOfMasterData){
        		
      			pan_no = masterDataBean.getPan_no();
      			designation = masterDataBean.getDesignation();
      		}
        	
        %>
			<script type="text/javascript">
					<% if(tb.getMetro_non_metro().equals("Metro"))
					{
					%>
					metro = true;
					
					$("#nonMetro1").hide();
					$("#totalBasicNonMetro").hide();
					$("#rentSlipNonMetro").hide();
					$("#actualHRANonMetro").hide();
					$("#nonMetroDeduction").hide();

					//document.getElementById("checked").value = "Metro";
					$("#metro").show();
					$("#totalBasicMetro").show();
					$("#rentSlipMetro").show();
					$("#actualHRAMetro").show();
					$("#metroDeduction").show();
					<%}
					else
					{%>
					
					alert("YPPPPPPPPPPPPPPPPPPPp" + metro);
					$("#nonMetro1").show();
					$("#totalBasicNonMetro").show();
					$("#rentSlipNonMetro").show();
					$("#actualHRANonMetro").show();
					$("#nonMetroDeduction").show();
					//document.getElementById("checked").value = "Non-Metro";
					$("#metro").hide();
					$("#totalBasicMetro").hide();
					$("#rentSlipMetro").hide();
					$("#actualHRAMetro").hide();
					$("#metroDeduction").hide();
					<%}%>
				</script>
				
				<%-- <script type="text/javascript">
					<% if(tb.getMonthly_yearly().equals("Monthly"))
					{
					%>
					monthly = true;
						$("#yearly").hide();
						$("#monthly").show();
					<%}
					else
					{%>
					
					$("#yearly").show();
					$("#monthly").hide();
					<%}%>
				</script>
				
				<script type="text/javascript">
					<% if(tf.getCash_cheque().equals("Cash"))
					{
					%>
					cash = true;
						$("#cheque").hide();
						$("#cash").show();
					<%}
					else
					{%>
					
					$("#cheque").show();
					$("#cash").hide();
					<%}%>
				</script> --%>
<form action="tdsHrUpdate" method="post" id="formSubmit">
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

				<%if(request.getAttribute("TDSExist") != null) {%>
		 		<div id="panelbody" class="panel-body">
                            <div class="alert alert-dismissable alert-danger">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                 ${TDSExist}
                            </div>
          		</div>  
          	<%}%>
				
				
				
				
				
			<div class="row">
				    <div class="col-md-12">
				        <div class="card">
				        	<div class="card-header">
				                <h4 class="card-title" id="horz-layout-basic">Details For Income Tax Calculation</h4>
				                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
				            </div>
						 <div class="card-body collapse in">
	               			<div class="card-block">

								<div class="row">
									<div class="col-lg-3"><b>Name</b></div>
									<div class="col-lg-3"><b>PAN No</b></div>
									<div class="col-lg-3"><b>Department</b></div>
									<div class="col-lg-3"><b>Designation</b></div>
								</div>
								
								<div class="row">
									<div class="col-lg-3">
												<input type="text" class="form-control" name="emp_name" id="emp_name" value="<%=t.getEmployeeBean().getFirstname()%> <%=t.getEmployeeBean().getLastname()%>"
														readonly="readonly">
									</div>
									<div class="col-lg-3">
												<input type="text" class="form-control" name="pan_no" id="pan_no" value="<%=pan_no %>" readonly="readonly">
									</div>
									<div class="col-lg-3">
												<input type="text" class="form-control" name="department" id="department" value="<%=t.getEmployeeBean().getDepartmentBean().getDepartment_name()%>" readonly="readonly">
									</div>
									<div class="col-lg-3">
												<input type="text" class="form-control" name="designation" id="designation" value="<%=t.getEmployeeBean().getRoleBean().getRole_type() %>" readonly="readonly">
									</div>
								</div>
							
							
									<input type="hidden" name="EMP_MASTER_ID" value="<%=t.getEmployeeBean().getEmployee_master_id()%>">
									<input type="hidden" name="status" value="<%=t.getStatus()%>">
									<input type="hidden" name="id" value="<%=t.getTds_hr_id()%>">
									<input type="hidden" id="LOCKNAME" name="LOCKNAME" value="UNLOCK" />
									<input type="hidden" name="gender" id="gender" value="<%=t.getEmployeeBean().getGender()%>">
									
									<input type="hidden" name="docList" id="docList" value="<%=tdsDocumentList.size()%>"/>
							<br>
							<%-- <tr>
								<th align="right">Start Month :</th>
								<td>
									<div class="form-group">
                                            <select class="form-control" id="start_month">
                                            <option>----- Select Month -----</option>
                                            <% AllListDAO allListDAO = new AllListDAO();
                                            	List<MonthBean> monthBean = allListDAO.getListOfMonth();
                                            	for(MonthBean bean : monthBean){%>
                                                <option value="<%=bean.getMonth_id()%>"><%=bean.getMonth_name() %></option>
                                                <%} %>
                                            </select>
                                       </div>
								</td>
								<th align="right">End Month :</th>
								<td>
									<div class="form-group">
                                            <select class="form-control" id="end_month">
                                            	<option>----- Select Month -----</option>
                                            	<% AllListDAO allListDAO1 = new AllListDAO();
                                            	List<MonthBean> monthBean1 = allListDAO.getListOfMonth();
                                            	for(MonthBean bean : monthBean1){%>
                                                <option value="<%=bean.getMonth_id()%>"><%=bean.getMonth_name() %></option>
                                                <%} %>
                                            </select>
                                       </div>
								</td>
							</tr> --%>
					
					<% SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
						Date cfdate = new Date();
						int month = cfdate.getMonth();
						String end_year = formatNowYear.format(cfdate);
						//System.out.println("Year"+end_year);
						int current_year = 0;
                     	int final_year = 0;
						if(month>2){
							 current_year = Integer.parseInt(end_year) ;
							 final_year = (current_year + 1);
                    	}else{
                    		 current_year = (Integer.parseInt(end_year) - 1);
							 final_year = Integer.parseInt(end_year);
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
			                <!-- <div class="card-body collapse in">
			                    <div class="card-block border-bottom-blue-grey">
			                      <h5>
									<b>General Deductions</b>
								</h5>

								<h5>
									<b>Exempted Allowance U/S 10 Of The Income Tax</b>
								</h5>
			                    </div>
			                </div> -->
			            </div>
			            
			            <b><font size="4px;">General Deductions</font></b>
			            
			<div class="row">
			<div class="col-lg-12">
				<div id="accordionWrap1" role="tablist" aria-multiselectable="true">
                <div class="card collapse-icon accordion-icon-rotate">
                       
                       <div id="headingCollapse43"  class="card-header" style="padding: 0.5rem 1.5rem;">
							<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne" class="card-title lead info">
							<div class="row">
								<div class="col-lg-12">
		                         <div class="col-md-10" align="left">(1) Exempted Allowance U/S 10(Annual)</div>
		                         <div class="col-md-2">
		                         	<div class="col-md-1">Rs.</div> 
		                        	 <div class="col-md-1" id="part1"><%=tb.getTotal_b() %></div>
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
																					id="TotalGross" value="<%=ta.getTotal_a() %>" readonly="readonly">
																			</div>
																		</th>
																		<th>
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
																											id="totalBasic" name="totalBasic" value="<%= ta.getAnnual_gross_salary()%>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Bonus</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Bonus" name="Bonus" value="<%=ta.getBonus() %>" readonly="readonly" onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Leave</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Leave" name="Leave" value="<%=ta.getLeaveCount() %>" readonly="readonly" onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Incentive</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Incentive" name="Incentive" value="<%=ta.getIncentive() %>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Previous Employeed Salary</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="PreviousSalary" name="PreviousSalary" value="<%=ta.getPrevious_employeed_salary() %>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Performance Pay</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Performance" name="Performance" value="<%=ta.getPerformance_pay() %>" readonly="readonly"
																											onchange="temp();"></td>
																									</tr>
																									<!-- <tr>
																										<th id="modalPadding">Full & Final Bonus</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Full&FinalBonus" name="Full&FinalBonus"
																											value="<%=ta.getFull_final_bonus() %>" onchange="temp();"></td>
																									</tr>
																									<tr>
																										<th id="modalPadding">Full & Final Leave</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Full&FinalLeave" name="Full&FinalLeave"
																											value="<%=ta.getFull_final_leave() %>" onchange="temp();"></td>
																									</tr> -->
																					 				<tr>
																										<th id="modalPadding">Total Gross Income (Total A)</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="TotalGrossIncome" name="TotalGrossIncome"
																											value="<%=ta.getTotal_a() %>" readonly="readonly"></td>
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
																						value="<%=tb.getD_conveyance() %>" readonly="readonly"">
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
																											<th id="modalPadding">Conveyance</th>
																											<th id="modalPadding">Permissible Deduction<br>(Max.
																												Rs.19200/-)
																											</th>
																										</tr>
								
																										<tr>
																											<th id="modalPadding">Conveyance</th>
																											<td id="modalPadding"><input type="text" class="form-control"
																												id="Conveyance" name="Conveyance" value="<%=tb.getConveyance() %>" readonly="readonly"
																												onchange="tempConveyance()"></td>
																											<td id="modalPadding"><input type="text" class="form-control"
																												name="Conveyance1" id="Conveyance1" value="<%=tb.getD_conveyance() %>"
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
																					id="HouseRant" value="<%=tb.getHouse_rant()%>" readonly="readonly">
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
																											<%if((tb.getMetro_non_metro()).equals("Metro")){ %>
																											<input type="checkbox" id="City" name="City" checked="checked"
																											onchange="check()"> 
																											<%}else{ %>
																											<input type="checkbox" id="City" name="City"
																											onchange="check()"> 
																											<%} %>
																											<br>
																											(Bangalore,Chennai,Delhi,Kolkata)
																											<input type="hidden" name="checked" id="checked">
							
																										</td>
																									</tr>
							
																									<tr>
																										<td></td>
																										<td></td>
																										<th id="nonMetro">Non Metro City</th>
																										<th id="metro">Metro City</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Total Basic Salary</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="totalBasic1" name="totalBasic1" value="<%=tb.getA_total_basic() %>" readonly="readonly"
																											onchange="BasicCalculation();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="totalBasicNonMetro" name="totalBasicNonMetro" value="<%=tb.getD_non_metro_total_basic() %>"
																											readonly="readonly">
																										<input type="text" class="form-control"
																											id="totalBasicMetro" name="totalBasicMetro" value="<%=tb.getD_metro_total_basic()%>" readonly="readonly"></td>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Total Rent Is To Be Payable<br> During The Year</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="rentSlip" name="rentSlip" value="<%=tb.getA_rent_slip() %>"
																											onchange="calculateRent(this.id)"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="rentSlipNonMetro" name="rentSlipNonMetro"
																											value="<%=tb.getD_non_metro_rent_slip() %>" readonly="readonly">
																										<input type="text" class="form-control"
																											id="rentSlipMetro" name="rentSlipMetro" value="<%=tb.getD_metro_rent_slip() %>"
																											readonly="readonly"></td>
							
																									</tr>
							
																									<tr>
																										<th id="modalPadding">HRA Payable By Company</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="actualHRA" name="actualHRA" value="<%=tb.getA_hra() %>" readonly="readonly"
																											onchange="calculateHRA(this.id); CalculateTotalHRA()"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="actualHRANonMetro" name="actualHRANonMetro"
																											value="<%=tb.getD_non_metro_hra() %>" readonly="readonly">
																										<input type="text" class="form-control"
																											id="actualHRAMetro" name="actualHRAMetro" value="<%=tb.getD_metro_hra() %>"
																											readonly="readonly"></td>
							
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Deduction Permissible</th>
																										<td></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="nonMetroDeduction" id="nonMetroDeduction"
																											value="<%=tb.getHra_non_metro_deduction() %>" readonly="readonly">
																										<input type="text" class="form-control"
																											name="metroDeduction" id="metroDeduction" value="<%=tb.getHra_metro_deduction() %>"
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
																												name="LandlordName" id="LandlordName" value="<%=tb.getLandlord_name() %>"></td>
																										</tr>
																										<tr>
																											<td><label id="LandlordPanNoLabel">Landlord
																													PAN No.</label></td>
																											<td><input type="text" class="form-control"
																												name="LandlordPanNo" id="LandlordPanNo" value="<%=tb.getLandlord_pan_no()%>"></td>
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
																					id="MedicalBill" value="<%=tb.getD_medical() %>" readonly="readonly">
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
																										<th id="modalPadding">Medical Allw. Received <br>during the year</th>
																										<th id="modalPadding">Bills you are going to <br>provide</th>
																										<th id="modalPadding">Permissible Deduction</th>
																										<th id="modalPadding">Qualifying Amount</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Medical Bill</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Medical" name="Medical" value="<%=tb.getA_medical()%>" readonly="readonly"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="ProvidedMedicalBills" name="ProvidedMedicalBills" value="<%=tb.getProvided_medical_bills() %>"
																											onchange="tempMedical()"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="PermissibleDeduction" name="PermissibleDeduction" value="15000"
																											readonly="readonly"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MedicalDeduction" id="MedicalDeduction"
																											value="<%=tb.getD_medical() %>" readonly="readonly"></td>
																										
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
																					id="MealCard" value="<%=tb.getMeal_card() %>" readonly="readonly">
																			</div>
																		</th>
																		<th></th>
																		<%-- <th>
							
																				<!-- Button trigger modal -->
																				<%if(t.getEmployeeBean().getMealcard().equals("TRUE")) {%>
																				
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
																											<% if((tb.getMonthly_yearly()).equals("Yearly")){ %>
																											<label class="radio-inline"> <input type="radio"
																												name="mealCardRadio" id="0" checked="checked"
																												value="yearly" onchange="checkRadio()">Yearly 
																											</label> 
																											<label class="radio-inline"> <input
																												type="radio" name="mealCardRadio"
																												id="1" value="monthly" onchange="checkRadio()">Monthly
																											</label> <input type="hidden" name="result" id="result">
																											<%}else{ %>
																											<label class="radio-inline"> <input type="radio"
																												name="mealCardRadio" id="0" 
																												value="yearly" checked="checked" onchange="checkRadio()">Yearly 
																											</label> 
																											<label class="radio-inline"> <input
																												type="radio" name="mealCardRadio"
																												id="1" value="monthly" checked="checked" onchange="checkRadio()">Monthly
																											</label> <input type="hidden" name="result" id="result">
																											<%} %>
																										</div>
																								<div id="yearly">
																								<table class="table table-striped">
																									<tr><center><h5><b>Yearly Meal Card</b></h5></center></tr>
																									<tr>
																										<th></th>
																										<th id="modalPadding">Permissible Deduction</th>
																										</tr>
							
																									<tr>
																										<th id="modalPadding">Meal Card</th>
																										<!-- <td><input type="text" class="form-control"
																											id="MealCard1" name="MealCard1" value="0"
																											onchange="MealCard(); "></td> -->
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MealCardDeduction" id="MealCardDeduction"
																											value="<%=tb.getYearly_mealcard() %>" readonly="readonly"></td>
																									</tr>
							
																								</table>
																								</div>
																								
																								<%
																									SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd"); 
																									SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd/MM/yyyy");
																									
																									String start_date = tb.getMonthly_start_date();
																									String end_date = tb.getMonthly_end_date();
																									try
																									{
																										Date sd = yyyymmdd.parse(start_date);
																										start_date = ddmmyyyy.format(sd);
																										
																										Date ed = yyyymmdd.parse(end_date);
																										end_date = ddmmyyyy.format(ed);
																									}
																									catch(Exception e)
																									{
																										e.printStackTrace();
																									}
																									
																									%>
																									
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
																												width="155" name="startDatePicker1" value="<%=start_date %>"
																												placeholder="dd/mm/yyyy" class="form-control"></td>
																										<td id="modalPadding"><input type="text" class="form-control" width="155"
																											id="endDatePicker1" name="endDatePicker1" value="<%=end_date %>"
																											placeholder="dd/mm/yyyy"></td>
																									</tr>
																									<tr>
																										<td id="modalPadding">Days</td>
																										<td id="modalPadding"><input type="text" id="days" value="<%=tb.getDays() %>"
																											 name="days" placeholder="days" class="form-control">
																											</td>
																										<td></td>
																									</tr>
																									<tr>
																										<td id="modalPadding">Permissible Deduction</td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MealCardDeduction1" id="MealCardDeduction1"
																											value="<%=tb.getMonthly_mealcard() %>" readonly="readonly"></td>
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
																		</th> --%>
																	</tr>
							                                        
							                                        
							                                       <tr>
							                                       		<th><center>6</center></th>
																		<th><center>LTA Allw. : Deduction for 2 journey in a block of 4 years</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="LTA" id="LTA"
																					value="<%=tb.getD_lta() %>" readonly="readonly">
																			</div>
																		</th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal6"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal6" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
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
																										<th id="modalPadding">LTA Received during the <br>year</th>
																										<th id="modalPadding">Actual Expenditure</th>
																										<th id="modalPadding">Permissible Deduction <br>(Whichever is
																											Lower)
																										</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">LTA</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="LTABillSalary" name=LTABillSalary " value="<%=tb.getLta_during_year() %>" readonly="readonly"
																											onchange="tempLTA(id)(this.id)"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="LTABill" name="LTABill" value="<%=tb.getActual_expenditure_lta() %>"
																											onchange="tempLTA(id)(this.id)"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="actualLTABill" id="actualLTABill" value="<%=tb.getD_lta() %>"
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
																					type="text" class="form-control" name="PTAX" id="PTAX" readonly="readonly"
																					value="<%=tb.getPtax() %>" onchange="TotalB();">
																			</div>
																		</th>
																		<th></th>
																	</tr>
							                                        
							                                         <tr>
							                                         	<th><center>8</center></th>
																		<th style="padding-top: 10px;"><center>Education Allw. : (Permissible for 2 Children with <br>&nbsp;&nbsp;an age of more than 5 years)
																			</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="Education"
																					id="Education" value="<%=tb.getD_education_allw() %>" readonly="readonly">
																			</div>
																		</th>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal7"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center>
																				<!-- Modal -->
																				<div class="modal fade" id="myModal7" tabindex="-1"
																					role="dialog" aria-labelledby="myModalLabel"
																					aria-hidden="true">
																					<div class="modal-dialog">
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
																										<th id="modalPadding">Number Of Children<br>(Age of more than
																											5 years)
																										</th>
																										<th id="modalPadding">Permissible Deducated <br>Value</th>
							
																									</tr>
																									<tr>
																										<th id="modalPadding">Education Allowance</th>
																										<td id="modalPadding"><input type="number" class="form-control"
																											id="EducationLoan" name="EducationLoan" value="<%=tb.getNo_of_child() %>"
																											onchange="tempEducation(this.id); "></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="actualEducation" id="actualEducation"
																											value="<%=tb.getD_education_allw() %>" readonly="readonly"></td>
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
																					id="Uniform" value="<%=tb.getD_uni_allw() %>" readonly="readonly">
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
																										<th id="modalPadding">Uniform Allowance <br>Received during the<br> year</th>
																										<th id="modalPadding">Actual Expenditure</th>
																										<th id="modalPadding">Whichever is Lower <br>(Max.Rs.15000/-
																											<br>Permissible)</th>
																									</tr>
							
																									<tr>
																										<th id="modalPadding">Uniform <br>Allowance</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="UniformAllowance" name="UniformAllowance" readonly="readonly"
																										 value="<%=tb.getUni_allw_during_year() %>" onchange="tempUniformAllowance();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="ActualUniformAllowance"
																											name="ActualUniformAllowance" value="<%=tb.getActual_expenditure_uni_allw() %>"
																											onchange="tempUniformAllowance();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="MinUniformAllowance" id="MinUniformAllowance"
																											value="<%=tb.getD_uni_allw() %>" readonly="readonly"></td>
							
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
																					value="<%=tb.getTotal_hra() %>" readonly="readonly">
																			</div>
																		</th>
																		<th></th>
																	</tr>
							
																	<tr>
																		<th><center>11</center></th>
																		<th><center>TotalB</center></th>
																		<th id="tablePadding">
																			<div class="input-group">
																				<span class="input-group-addon">Rs.</span> <input
																					type="text" class="form-control" name="TotalAB"
																					id="TotalAB" value="<%=tb.getTotal_b() %>" readonly="readonly">
																			</div>
																		</th>
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
                                        
                                
                        <div id="headingCollapse62"  class="card-header" style="padding: 0.5rem 1.5rem;">
										<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" class="card-title lead info">
										<div class="row">
										<div class="col-lg-12">
					                          <div class="col-md-8" align="left">(2) Other Income(Annual)</div>
					                         <% if(tc.getOther_income() >= tc.getD_house_loan()){%>
                                            	<div class="col-md-2" >
                                            		<div class="col-md-1">Rs.</div> 
                                            		<div class="col-md-1" id="part2self"><%=tc.getOther_income() - tc.getD_house_loan() %></div>
                                            	</div>
                                            	<%}else if(tc.getD_house_loan() > tc.getOther_income()){ %>
                                            	<div class="col-md-2" >
                                            		<div class="col-md-1">Rs.</div> 
                                            		<div class="col-md-1" id="part2self"><%=tc.getD_house_loan() - tc.getOther_income()%></div>
                                            	</div>
                                            	<%} %>
					                          <div class="col-md-2" >
					                               <div class="col-md-1">Rs.</div> 
					                               <div class="col-md-1" id="part2"><%=tc.getTotal_c() %></div>
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
																							id="OtherIncome" value="<%=tc.getOther_income() %>" onchange="calculateBasic();">
																			</div>
																		</th>
																		<th><center><a href="" data-toggle="modal" data-target="#IncomeModal" id="Income" onclick="changeName(this.id);"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
							                                        <tr>
							                                        	<th><center>2</center></th>
																		<th><center>House Loan Interest</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="HouseLoan"
																						id="HouseLoan" value="<%=tc.getD_house_loan() %>" readonly="readonly">
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
																									Loan (Annual)</h4>
																							</div>
																							<div class="modal-body">
																								<table class="table table-striped">
																									<tr>
																										<th id="modalPadding">House Loan</th>
																										<th id="modalPadding">Permissible Deduction<br>(Max. Rs. 2,00,000/-)</th>
																									</tr>
						
																									<tr>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="HouseLoan1" name="HouseLoan1" value="<%=tc.getA_house_loan() %>"
																											onchange="Loan(); "></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="HouseLoanDeduction" id="HouseLoanDeduction"
																											value="<%=tc.getD_house_loan() %>" readonly="readonly"></td>
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
																												name="BankName" id="BankName" value="<%=tc.getBank_name() %>"></td>
																										</tr>
						
																										<tr>
																											<td><label id="BankPANNoLabel">Bank
																													PAN No. </label></td>
																											<td><input type="text" class="form-control"
																												name="BankPANNo" id="BankPANNo" value="<%=tc.getBank_pan_no()%>"></td>
																										</tr>
						
																										<tr>
																											<td><label id="BankAddressLabel">Bank
																													Address </label></td>
																											<br>
																											<td><textarea rows="3" name="BankAddress" value="<%=tc.getBank_address() %>"
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
							                                        
							                                        <% 	double diff = 0.0;
							                                        	diff = tc.getOther_income() - tc.getD_house_loan();
							                                        	if(diff <= 0)
							                                        	{
							                                        		System.err.println("-VE");
							                                        		diff = -(diff);
							                                        	}else
							                                        	{
							                                        		diff = diff;
							                                        	}
							                                        %>
							                                        
							                                        <tr>
							                                        	<th><center>3</center></th>
																		<th><center>Total (1 & 2) </center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="totalc"
																						id="totalc" value="<%=diff %>" readonly="readonly">
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
																						id="TotalC" value="<%=tc.getTotal_c() %>" readonly="readonly">
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
							                    </div>
                  							  <!-- /.panel -->
             							   </div>
                                        
                                        
                                        </div>
                                    </div>
                                </div>
                                
                                
                                 <div id="headingCollapse61"  class="card-header" style="padding: 0.5rem 1.5rem;">
									<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree" class="card-title lead info">
										<div class="row">
											<div class="col-lg-12">
                                            	<div class="col-md-8" align="left">(3) Section 80C(Annual)</div>
                                            	<div class="declare">
                                            		<div class="col-md-2" >
	                                            		<div class="col-md-1">Rs.</div> 
	                                            		<div class="col-md-1" id="part3self"><%=td.getD_total_d() %></div>
	                                            	</div>
	                                            	<div class="col-md-2" >
	                                            		<div class="col-md-1">Rs.</div> 
	                                            		<div class="col-md-1" id="part3"><%=tc.getTotal_c() - td.getD_total_d() %></div>
	                                            	</div>
	                                            </div>
	                                            <div class="actual">
                                            		<div class="col-md-2" >
	                                            		<div class="col-md-1">Rs.</div> 
	                                            		<div class="col-md-1" id="payablePart3Self"><%=td.getPayable_d_total_d() %></div>
	                                            	</div>
	                                            	<div class="col-md-2" >
	                                            		<div class="col-md-1">Rs.</div> 
	                                            		<div class="col-md-1" id="payablePart3"><%=tc.getTotal_c() - td.getPayable_d_total_d() %></div>
	                                            	</div>
	                                            </div>
	                                            </div>
                                         </div>
									</a>
								</div>
                                <div id="collapseThree" role="tabpanel" aria-labelledby="headingCollapse61" class="border-info no-border-top card-collapse collapse" aria-expanded="false">
										<div class="card-body">
											<div class="card-block">
												<div class="row">
													<div class="col-lg-10">
							                            <div class="table-responsive">
							                                <table class="table-bordered" width="100%">
							                                	 <tbody>
							                                	 	<tr>
							                                				<th></th>
																			<th></th>
																			<th style="width: 180px;"><center><u>Declared Amount</u></center></th>
																			<th style="width: 180px;"><center><u>Actual Amount</u></center></th>
																			<th></th>
							                                		</tr>
							                                        <tr>
							                                        		<th width="50px;"><center>1</center></th>
																			<th><center>Life Insurance</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="LifeInsurance"
																							id="LifeInsurance" value="<%=td.getLife_insurance() %>"
																							onchange="calculateSection80C();" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="LICPayable"
																							id="LICPayable" value="<%=td.getPayable_lic()%>" readonly="readonly">
																					</div>
																				</center></th>
																			<th width="50px;"><center><a href="" data-toggle="modal" data-target="#LICModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>2</center></th>
																			<th><center>EPF</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="EPF" id="EPF"
																							value="<%=td.getEPF() %>" onchange="calculateSection80C();" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="EPFPayable" id="EPFPayable"
																							value="<%=td.getPayable_epf()%>" readonly="readonly">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#EPFModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>3</center></th>
																			<th><center>PPF</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="PPF" id="PPF"
																							value="<%=td.getPPF() %>" onchange="calculateSection80C();" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="PPFPayable" id="PPFPayable"
																							value="<%=td.getPayable_ppf()%>" readonly="readonly">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#PPFModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>4</center></th>
																			<th><center>NSC</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="NSC" id="NSC"
																							value="<%=td.getNSC() %>" onchange="calculateSection80C();" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="NSCPayable" id="NSCPayable"
																							value="<%=td.getPayable_nsc()%>" readonly="readonly">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#NSCModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>5</center></th>
																			<th><center>MF</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="MF" id="MF"
																							value="<%=td.getMF() %>" onchange="calculateSection80C();" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="MFPayable" id="MFPayable"
																							value="<%=td.getPayable_mf()%>" readonly="readonly">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#MFModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>6</center></th>
																			<th><center>Tuition Fees</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="TuitionFees" readonly="readonly"
																							id="TuitionFees" value="<%=td.getTuition_fees() %>" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="TuitionFeesPayable" readonly="readonly"
																							id="TuitionFeesPayable" value="<%=td.getPayable_tuition_fees()%>">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#TuitionFeesModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>7</center></th>
																			<th><center>Stamp Duty & Registration Charge</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="StampDuty" readonly="readonly"
																							id="StampDuty" value="<%=td.getStamp_duty() %>" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="StampDutyPayable" readonly="readonly"
																							id="StampDutyPayable" value="<%=td.getPayable_stamp_duty()%>">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#StampDutyModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>8</center></th>
																			<th><center>House Loan Principal</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control"
																							name="HouseLoanPrincipal" id="HouseLoanPrincipal" readonly="readonly"
																							value="<%=td.getHouse_loan_principal() %>" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control"
																							name="HouseLoanPayable" id="HouseLoanPayable" readonly="readonly"
																							value="<%=td.getPayable_house_loan()%>">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#HouseLoanModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>9</center></th>
																			<th><center>Tax Saver Fix Deposit of 5 Years</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control"
																							name="TaxSaverFixDeposit" id="TaxSaverFixDeposit" readonly="readonly"
																							value="<%=td.getTax_saver_deposite() %>" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control"
																							name="FixDepositePayable" id="FixDepositePayable" readonly="readonly"
																							value="<%=td.getPayable_fix_deposite()%>">
																					</div>
																				</center></th>
																			<th><center><a href="" data-toggle="modal" data-target="#FixDepositeModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
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
																							value="<%=td.getOther_document() %>" readonly="readonly" style="border-radius: 4px;">
																					</div>
																				</div>
																			</th>
																			<th style="width: 180px;padding-top: 15px;" id="tablePadding"><center>
																					<br><br>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="Other" id="Other" readonly="readonly"
																							value="<%=td.getOther() %>" onchange="calculateSection80C();">
																					</div>
																				</center></th>
																			<th style="width: 180px;padding-top: 15px;" id="tablePadding"><center>
																					<br><br>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="OtherPayable" id="OtherPayable" readonly="readonly"
																							value="<%=td.getPayable_other()%>">
																					</div>
																				</center></th>
																			<th><br><br><center><a href="" data-toggle="modal" data-target="#OtherModal"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>11</center></th>
																			<th><center>Total(1 to 10)</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="TotalD"
																							id="TotalD" value="<%=td.getA_total_d() %>" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="PayableTotalD"
																							id="PayableTotalD" value="<%=td.getPayable_a_total_d() %>" readonly="readonly">
																					</div>
																				</center></th>
																			<th></th>
																	</tr>
																	
																	<tr>
							                                        		<th><center>12</center></th>
																			<th><center>permissible deduction of 11(Max 150000/-)</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="80CTotal"
																							id="80CTotal" value="<%=td.getD_total_d() %>" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="Payable80CTotal"
																							id="Payable80CTotal" value="<%=td.getPayable_d_total_d() %>" readonly="readonly">
																					</div>
																				</center></th>
																				<th></th>
																			<!-- <th><center><a onclick="transferValue();" style="cursor: pointer;"><i class="glyphicon glyphicon-circle-arrow-left" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th> -->
																	</tr>
																	
																	<tr>
							                                        		<th><center>13</center></th>
																			<th><center>Total D</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="totalD"
																							id="totalD" value="<%=tc.getTotal_c() - td.getD_total_d() %>" readonly="readonly">
																					</div>
																				</center></th>
																			<th style="width: 180px;" id="tablePadding"><center>
																					<div class="input-group">
																						<span class="input-group-addon">Rs.</span> <input
																							type="text" class="form-control" name="PayabletotalD"
																							id="PayabletotalD" value="<%=tc.getTotal_c() - td.getPayable_d_total_d() %>" readonly="readonly">
																					</div>
																				</center></th>
																				<th></th>
																			<!-- <th><center><a onclick="transferValue();" style="cursor: pointer;"><i class="glyphicon glyphicon-circle-arrow-left" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a></center></th> -->
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
                                	</div>
                                
                                
								<div id="headingCollapse64"  class="card-header" style="padding: 0.5rem 1.5rem;">
									<a data-toggle="collapse" data-parent="#accordionWrap1" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour" class="card-title lead info collapsed">
                                            <div class="row">
                                            	<div class="col-lg-12">
	                                            	<div class="col-md-8" align="left">(4) NPS And RGESS(Annual)</div>
	                                            	<div class="declare">
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="part4self"><%=te.getTotal_NPS_RGESS() %></div>
		                                            	</div>
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="part4"><%=te.getTotal_e() %></div>
		                                            	</div>
		                                            </div>
		                                            <div class="actual">
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="payablePart4Self"><%=te.getTotal_NPS_RGESS() %></div>
		                                            	</div>
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="payablePart4"><%=te.getPayable_total_e() %></div>
		                                            	</div>
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
																		<th style="width: 180px;"  id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="NPS" id="NPS"
																						value="<%=te.getD_NPS() %>" readonly="readonly">
																				</center></div>
																		</th>
																		<th></th>
																		<%-- <th style="width: 180px;"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="PayableNPS" id="PayableNPS"
																						value="<%=te.getD_NPS() %>" readonly="readonly">
																				</center></div>
																		</th> --%>
																		<th width="50px;">
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal9"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																					<a href="" data-toggle="modal" data-target="#NPSModal" id="NPS" onclick="changeName(this.id);"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																				</center>
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
																											id="NPS1" name="NPS1" value="<%=te.getA_NPS() %>" onchange="tempNPS();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="NPSDeduction" id="NPSDeduction" value="<%=te.getD_NPS() %>"
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
																						value="<%=te.getD_RGESS() %>" readonly="readonly">
																				</div>
																			</center></th>
																			<th></th>
																		<%-- <th style="width: 180px;"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="PayableRGESS" id="PayableRGESS"
																						value="<%=te.getD_RGESS() %>" readonly="readonly">
																				</div>
																			</center></th> --%>
																		<th>
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal10"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																					<a href="" data-toggle="modal" data-target="#RGESSModal" id="RGESS" onclick="changeName(this.id);"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																				</center>
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
																											id="RGESS1" name="RGESS1" value="<%=te.getA_RGESS() %>"
																											onchange="tempRGESS(); "></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="RGESSDeduction" id="RGESSDeduction" value="<%=te.getD_RGESS() %>"
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
																						id="TotalE" value="<%=te.getTotal_NPS_RGESS() %>" readonly="readonly">
																				</div>
																			</center></th>
																			<th></th>
																		<%-- <th style="width: 180px;"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="PayableTotalE"
																						id="PayableTotalE" value="<%=te.getTotal_NPS_RGESS() %>" readonly="readonly">
																				</div>
																			</center></th> --%>
																		<th><input type="hidden" class="form-control" name="actualTotalE"
																					id="actualTotalE" value="0" readonly="readonly"></th>
																	</tr>
																	
																	<tr>
																		<th><center>4</center></th>
																		<th><center>TotalE</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TotalCE"
																						id="TotalCE" value="<%=te.getTotal_e() %>" readonly="readonly">
																				</div>
																			</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="PayabletotalE"
																						id="PayabletotalE" value="<%=te.getPayable_total_e() %>" readonly="readonly">
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
	                                            	<div class="declare">
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="part5self"><%=tf.getTotal_80EGD() %></div>
		                                            	</div>
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="part5"><%=tf.getTotal_f() %></div>
		                                            	</div>
	                                            	</div>
	                                            	<div class="actual">
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="payablePart5Self"><%=tf.getTotal_80EGD() %></div>
		                                            	</div>
		                                            	<div class="col-md-2" >
		                                            		<div class="col-md-1">Rs.</div> 
		                                            		<div class="col-md-1" id="payablePart5"><%=tf.getPayable_total_f() %></div>
		                                            	</div>
	                                            	</div>
	                                            </div>
                                             </div>
                                       </a>
                                    </div>
                                    <div id="collapseFive" role="tabpanel" aria-labelledby="headingCollapse63" class="border-info no-border-top card-collapse collapse" aria-expanded="false">
										<div class="card-body">
											<div class="card-block">
							                      <div class="col-lg-9">
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
																						id="Mediclaim" value="<%=tf.getD_mediclaim() %>" readonly="readonly"
																						onchange="EGD80();">
																				</div>
																			</center></th>
																		<th></th>
																		<th width="50px;">
																				<!-- Button trigger modal -->
																				<center><a href="" data-toggle="modal" data-target="#myModal12"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																					<a href="" data-toggle="modal" data-target="#MediclaimModal" id="Mediclaim" onclick="changeName(this.id);"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																				</center>
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
																										value="<%=t.getEmployeeBean().getBirth_date()%>"
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
																											value="<%=tf.getA_self() %>" onchange="tempSelfSpouseChildren();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="SelfSpouseChildrenDeduction"
																											id="SelfSpouseChildrenDeduction" value="<%=tf.getD_self() %>"
																											readonly="readonly"></td>
						
																									</tr>
						
																									<%
																									SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd"); 
																									SimpleDateFormat DDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
																									
																									String d = tf.getFather_birthdate();
																									try
																									{
																										Date d1 = YYYYMMDD.parse(d);
																										d = DDMMYYYY.format(d1);
																									}
																									catch(Exception e)
																									{
																										e.printStackTrace();
																									}
																									
																									%>
																									<tr>
																										<td id="modalPadding">Enter Father's<br> Birthday</td>
																										<td id="modalPadding"><input type="text" id="datepicker1"
																											width="155" name="datepicker1" value="<%=d %>"
																											placeholder="dd/mm/yyyy" class="form-control"></td>
																										<td id="modalPadding"><input type="hidden" id="FatherBdy"
																											name="FatherBdy" class="form-control"></td>
																									</tr>
						
																									<tr>
																										<th id="modalPadding">Parents</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="Parents" name="Parents" value="<%=tf.getA_parents() %>"
																											onchange="tempParents();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="ParentsDeduction" id="ParentsDeduction"
																											value="<%=tf.getD_parents() %>" readonly="readonly"></td>
						
																									</tr>
																									
																									<tr>
																										<th id="modalPadding">Health Check Up</th>
																										<td id="modalPadding"><input type="text" class="form-control"
																											id="health" name="health" value="<%=tf.getA_health_checkup() %>"
																											onchange="HealthCheckUp();"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="healthDeduction" id="healthDeduction"
																											value="<%=tf.getD_health_checkup() %>" readonly="readonly"></td>
						
																									</tr>
						
																									<tr>
																										<th id="modalPadding">Total Deduction<br>max Rs.60000/-</th>
																										<td id="modalPadding"><input type="hidden" class="form-control"
																											name="TotalActual" id="TotalActual" value="<%=tf.getA_mediclaim() %>"
																											readonly="readonly"></td>
																										<td id="modalPadding"><input type="text" class="form-control"
																											name="TotalDeduction" id="TotalDeduction" value="<%=tf.getD_mediclaim() %>"
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
																						id="Donation" value="<%=tf.getDonation_80G() %>" readonly="readonly" onchange="EGD80();">
																				</div>
																			</center></th>
																		<th></th>
																		<th>
																			<!-- Button trigger modal -->
																			<center><a href="" data-toggle="modal" data-target="#myModal13"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																				<a href="" data-toggle="modal" data-target="#Donation80GModal" id="Donation80G" onclick="changeName(this.id);"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																			</center>
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
																								<%-- <div class="form-group">
																										<label>Choose</label> &nbsp;&nbsp;&nbsp;&nbsp;
																										<% if((tf.getCash_cheque()).equals("Cash")){ %>
																										<label class="radio-inline"> <input type="radio"
																											name="donationRadio" id="0" checked="checked"
																											value="cash" onchange="checkDonationRadio()">Cash 
																										</label> 
																										<label class="radio-inline"> <input
																											type="radio" name="donationRadio"
																											id="1" value="cheque" onchange="checkDonationRadio()">Cheque
																										</label> 
																										<%}else{ %>
																										<label class="radio-inline"> <input type="radio"
																											name="donationRadio" id="0" checked="checked"
																											value="cash" onchange="checkDonationRadio()">Cash 
																										</label> 
																										<label class="radio-inline"> <input
																											type="radio" name="donationRadio" checked="checked"
																											id="1" value="cheque" onchange="checkDonationRadio()">Cheque
																										</label> 
																										<%} %>
																										<input type="hidden" name="donationResult" id="donationResult">
																									</div> --%>
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
																										id="cashAmount" name="cashAmount" value="<%=tf.getA_cash_amount() %>"
																										onchange="CashDonation(); "></td> 
																									<td id="modalPadding"><input type="text" class="form-control"
																										name="cashDeduction" id="cashDeduction"
																										value="<%=tf.getD_cash_amount() %>" readonly="readonly"></td>
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
																										id="chequeAmount" name="chequeAmount" value="<%=tf.getA_cheque_amount() %>"
																										onchange="ChequeDonation(); "></td> 
																									<td id="modalPadding"><input type="text" class="form-control"
																										name="chequeDeduction" id="chequeDeduction"
																										value="<%=tf.getD_cheque_amount() %>" readonly="readonly"></td>
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
																						id="TotalDonation" value="<%=tf.getD_donation_80GGC() %>" readonly="readonly" onchange="EGD80();">
																				</div>
																			</center></th>
																		<th></th>
																		<th>
																			<!-- Button trigger modal -->
																			<center><a href="" data-toggle="modal" data-target="#myModal14"><i class="icon-android-add-circle" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																					<a href="" data-toggle="modal" data-target="#Donation80GGCModal" id="Donation80GGC" onclick="changeName(this.id);"><i class="icon-upload22" title="CLICK HERE" style="color: black;font-size: 15px;"></i></a>
																			</center>
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
																										id="donationAmount" name="donationAmount" value="<%=tf.getA_donation_80GGC() %>"
																										onchange="DonationAmount(); "></td> 
																									<td id="modalPadding"><input type="text" class="form-control"
																										name="donationDeduction" id="donationDeduction"
																										value="<%=tf.getD_donation_80GGC() %>" readonly="readonly"></td>
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
																						value="<%=tf.getEducation_loan() %>" onchange="EGD80();">
																				</div>
																			</center></th>
																		<th></th>
																		<th></th>
																	</tr>
																	
																	<tr>
																		<th><center>5</center></th>
																		<th><center>Total(1 to 4)</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="TotalF"
																						id="TotalF" value="<%=tf.getTotal_80EGD() %>" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																		<th></th>
																	</tr>
																	
																	<tr>
																		<th><center>6</center></th>
																		<th><center>Total F</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="ActualTotalF"
																						id="ActualTotalF" value="<%=tf.getTotal_f() %>" readonly="readonly">
																				</div>
																			</center></th>
																		<th style="width: 180px;" id="tablePadding"><center>
																				<div class="input-group">
																					<span class="input-group-addon">Rs.</span> <input
																						type="text" class="form-control" name="PayabletotalF"
																						id="PayabletotalF" value="<%=tf.getPayable_total_f() %>" readonly="readonly">
																				</div>
																			</center></th>
																		<th></th>
																	</tr>
																	<!-- <tr>
																		<th><center>6</center></th>
																		<th><center>TotalF</center></th>
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
                                
                                
                                <div class="card box-shadow-0" data-appear="appear" id="DeclairedTaxSlab">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;">
					                    <h5 class="card-title">Tax On Declared Amount</h5>
					                </div>
					                <div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey">
					                        <div class="row">
	                               				 <div class="col-lg-3">
		                                            <label><b>Taxable Income</b></label>
		                                            <b><input class="form-control" name="TaxableIncome"
															id="TaxableIncome" value="<%=tf.getTotal_f() %>" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Tax</b></label>
		                                            <b><input class="form-control" name="Tax" id="Tax"
																value="<%=tf.getTax() %>" readonly="readonly"></b>
		                                         </div>
		                                         <div class="col-lg-3">
		                                            <label><b>Tax Remit</b></label>
		                                            <b><input class="form-control" name="TaxRemit" id="TaxRemit"
																value="<%=tf.getTax_remit() %>" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Total Tax</b></label>
		                                            <b><input class="form-control" name="TotalTax" id="TotalTax"
																value="<%=tf.getTotal_tax() %>" readonly="readonly"></b>
		                                         </div>
                                        	 </div>
                                        	 <br>
                                        	 <div class="row">
	                               				 <div class="col-lg-3">
		                                            <label><b>Edu Cess</b></label>
		                                            <b><input class="form-control" name="EduCess"
															id="EduCess" value="<%=tf.getEdu_cess() %>" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>TotalH</b></label>
		                                            <b><input class="form-control" name="TotalH" id="TotalH"
																value="<%=tf.getTotal_h() %>" readonly="readonly"></b>
		                                         </div>
		                                         
		                                         <div class="col-lg-3">
		                                         	<label><b>Tax Paid By Company</b></label>
			                                         <div class="form-group input-group">
			                                            <b><input class="form-control" 
															name="TaxPaid" id="TaxPaid" value="<%=tf.getTax_paid() %>" readonly="readonly" onchange="Temp();"></b>
			                                            <span class="input-group-addon"><a href="" data-toggle="modal" data-target="#myModal15" >
			                                            <i class=" icon-android-add" data-toggle="tooltip" data-placement="top" title="Tax Paid Detail" style="font-size: 20px;font-weight: bold;"></i></a></span>
			                                        </div>
		                                         </div>
		                                         
		                                         <div class="col-lg-3">
		                                            <label><b>Tax Payable</b></label>
		                                            <b><input class="form-control" name="TaxPayable" id="TaxPayable"
																value="<%=tf.getTotal_h() - tf.getTax_paid() %>" readonly="readonly"></b>
		                                         </div>
                                        	 </div>
					                    </div>
					                </div>
					            </div>
                                
                                <div class="card box-shadow-0" data-appear="appear" id="ActualTaxSlab">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;">
					                    <h5 class="card-title">Tax On Actual Amount</h5>
					                </div>
					                <div class="card-body collapse in">
					                    <div class="card-block border-bottom-blue-grey">
										<div class="row">
	                               				 <div class="col-lg-3">
		                                            <label><b>Taxable Income</b></label>
		                                            <b><input class="form-control" name="PayableTaxableIncome"
															id="PayableTaxableIncome" value="<%=tf.getPayable_total_f() %>" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Tax</b></label>
		                                            <b><input class="form-control" name="PayableTax" id="PayableTax"
																value="<%=tf.getPayable_tax() %>" readonly="readonly"></b>
		                                         </div>
		                                         <div class="col-lg-3">
		                                            <label><b>Tax Remit</b></label>
		                                            <b><input class="form-control" name="PayableTaxRemit" id="PayableTaxRemit"
																value="<%=tf.getPayable_tax_remit() %>" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Tax On Tax Remit</b></label>
		                                            <b><input class="form-control" name="PayableTotalTax" id="PayableTotalTax"
																value="<%=tf.getPayable_total_tax() %>" readonly="readonly"></b>
		                                         </div>
                                        	</div>
                                        	 <br>
                                        	 <div class="row">
	                               				 <div class="col-lg-3">
		                                            <label><b>Edu Cess</b></label>
		                                            <b><input class="form-control" name="PayableEduCess"
															id="PayableEduCess" value="<%=tf.getPayable_edu_cess() %>" readonly="readonly"></b>
		                                         </div>
		                                        
		                                         <div class="col-lg-3">
		                                            <label><b>Tax Payable</b></label>
		                                            <b><input class="form-control" name="PayableTotalH" id="PayableTotalH"
																value="<%=tf.getPayable_total_h() %>" readonly="readonly"></b>
		                                         </div>
		                                          <div class="col-lg-3">
		                                         	<label><b>Tax Paid By Company</b></label>
			                                         <div class="form-group input-group">
			                                            <b><input class="form-control" 
															name="PayableTaxPaid" id="PayableTaxPaid" value="<%=tf.getTax_paid() %>" readonly="readonly" onchange="Temp();"></b>
			                                            <span class="input-group-addon"><a href="" data-toggle="modal" data-target="#myModal15" >
			                                            <i class=" icon-android-add" data-toggle="tooltip" data-placement="top" title="Tax Paid Detail" style="font-size: 20px;font-weight: bold;"></i></a></span>
			                                        </div>
		                                         </div>
		                                         
		                                         <div class="col-lg-3">
		                                            <label><b>Tax Payable</b></label>
		                                            <b><input class="form-control" name="PayableTaxPayable" id="PayableTaxPayable"
																value="<%=tf.getTotal_h() - tf.getTax_paid() %>" readonly="readonly"></b>
		                                         </div> 
		                                        
		                                         
                                        	 </div>
										</div>
                                	</div>
                                </div>
                                
                                
                                <!-- Modal -->
																					<div class="modal fade" id="myModal15" tabindex="-1"
																						role="dialog" aria-labelledby="myModalLabel"
																						aria-hidden="true">
																						<div class="modal-dialog">
																							<div class="modal-content">
																								<div class="modal-header">
																									<button type="button" class="close"
																										data-dismiss="modal" aria-hidden="true">&times;</button>
																									<h4 class="modal-title" id="myModalLabel">Tax Paid By Company
																										</h4>
																								</div>
																								<div class="modal-body">
																									<table class="table table-striped">
																										<tr>
																											<th>April - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="april" id="april" value="<%=tf.getApril() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>May - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="may" id="may" value="<%=tf.getMay() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>June - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="june" id="june" value="<%=tf.getJune() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>July - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="july" id="july" value="<%=tf.getJuly() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>August - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="august" id="august" value="<%=tf.getAugust() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>September - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="september" id="september" value="<%=tf.getSeptember() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>October - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="october" id="october" value="<%=tf.getOctober() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>November - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="november" id="november" value="<%=tf.getNovember() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>December - <%=current_year %></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="december" id="december" value="<%=tf.getDecember() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>January - <%=final_year%></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="january" id="january" value="<%=tf.getJanuary() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>February - <%=final_year%></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="february" id="february" value="<%=tf.getFebruary() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>March - <%=final_year%></th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="march" id="march" value="<%=tf.getMarch() %>" onchange="shruti();"></td>
																										</tr>
																										<tr>
																											<th>Total Paid Tax</th>
																											<td>:</td>
																											<td><input type="text" class="form-control" name="paidTax" id="paidTax" value="<%=tf.getTax_paid() %>" readonly="readonly"></td>
																										</tr>
																									</table>
																								</div>
																								<div class="modal-footer">
																									<input type="button" value="SAVE"
																										class="btn btn-primary" data-dismiss="modal" onclick="RedirectTaxPaid()">
								
																								</div>
																							</div>
																							<!-- /.modal-content -->
																						</div>
																						<!-- /.modal-dialog -->
																					<!-- /.modal -->
																				</div>
                                
                                
                                
                                <%-- <div class="col-md-4">
                                <div class="panel panel-default">
									<div class="panel-heading">
											<b>Monthly Tax On Declared Amount</b>
									</div>
									<div class="panel-body">
											<table class="table-responsive table-bordered" width="100%">
												<%	double sum = 0.0;
													List<TDSTaxBean> listOfTaxById = tdsListDAO.getTDSTaxListById(tds_id, employee_id);
													System.err.println(listOfTaxById.size());
													for(TDSTaxBean tdsTaxBean : listOfTaxById){
													
													double tax = tdsTaxBean.getTax() / 12;
													sum = sum + tax ;
													%>
												<tr>
													<td width="200px;">&emsp;<%=tdsTaxBean.getMonthBean().getMonth_name() %> - <%=tdsTaxBean.getYear() %></td>
													<td>&emsp;<%=String.format("%.2f", (tdsTaxBean.getTax()/ 12)) %></td>
												</tr>
												<%} %>
												<tr>
													<td>&emsp;<font color="red">Total Tax</font></td>
													<td>&emsp;<font color="red"><%=String.format("%.2f", sum) %></font></td>
												</tr>
											</table>
										
									</div>
                                </div>
                                </div> --%>
                                
								
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
				                    
				                    <div class="card box-shadow-0" data-appear="appear" id="seniorCitizen">
					                <div class="card-header card-inverse" style="background-color: #90A4AE;">
					                    <h5 class="card-title"><center>Income Tax Slab for Senior Citizens(80 Years Old Or More) (Both Men & Women)</center></h5>
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
															<td><center>Up to Rs. 5,00,000</center></td>
															<td><center>NIL</center></td>
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
								
								<% if(t.getStatus().equals("LOCK")){ %>
								
								<%}else{ %>
								<center>
									<input type="button" value="SAVE" class="btn btn-primary" onclick="Submit();">
									<input type="button" value="LOCK" class="btn btn-success" onclick="tempLock();">
								</center>
								<%} %>
								<br>
					<%} %>	
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
	<!-- INCOME -->
	<div class="modal fade" id="IncomeModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Income From Other Source</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover" id="IncomeTable">
								<thead>
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								</thead>
								<tbody>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForIncome = tdsListDAO.getDocumentListHRSide(employee_id, "Income"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForIncome){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check">
										<center>
										
										<div class="Income">
										
										<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
									
								</tr>
								<%} %>
								</tbody>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="Income" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- LIC -->
	<div class="modal fade" id="LICModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">LIC</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% 
									List<TDSDocumentUploadBean> tdsDocumentUploadBeans = tdsListDAO.getDocumentListHRSide(employee_id, "LIC"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadBeans){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="LIC">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="LIC" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div> 
<!-- 	EPF  -->
	<div class="modal fade" id="EPFModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">EPF</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForEPF = tdsListDAO.getDocumentListHRSide(employee_id, "EPF"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForEPF){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="EPF">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="EPF" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div> 
	<!-- PPF -->
	<div class="modal fade" id="PPFModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">PPF</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForPPF = tdsListDAO.getDocumentListHRSide(employee_id, "PPF"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForPPF){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="PPF">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="PPF" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- NSC -->
	<div class="modal fade" id="NSCModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">NSC</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForNSC = tdsListDAO.getDocumentListHRSide(employee_id, "NSC"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForNSC){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="NSC">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
									</div>	
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="NSC" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- MF  -->
	<div class="modal fade" id="MFModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">MF</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForMF = tdsListDAO.getDocumentListHRSide(employee_id, "MF"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForMF){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="MF">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="MF" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- TuitionFees -->
	<div class="modal fade" id="TuitionFeesModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Tuition Fees</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForTuitionFees = tdsListDAO.getDocumentListHRSide(employee_id, "TuitionFees"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForTuitionFees){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="TuitionFees">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="TuitionFees" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- StampDuty -->
	<div class="modal fade" id="StampDutyModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Stamp Duty & Registration Charge</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForStampDuty = tdsListDAO.getDocumentListHRSide(employee_id, "StampDuty"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForStampDuty){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="StampDuty">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="StampDuty" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- HouseLoan -->
	<div class="modal fade" id="HouseLoanModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">House Loan Principal</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForHouseLoan = tdsListDAO.getDocumentListHRSide(employee_id, "HouseLoan"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForHouseLoan){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="HouseLoan">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" name="name" id="name" value="HouseLoan">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="HouseLoan" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- FixDeposite -->
	<div class="modal fade" id="FixDepositeModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Tax Saver Fix Deposite Of 5 Years</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForFixDeposite = tdsListDAO.getDocumentListHRSide(employee_id, "FixDeposite"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForFixDeposite){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="FixDeposite">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="FixDeposite" value="Lock" onclick="hrApprovalInsert();"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- Other -->
	<div class="modal fade" id="OtherModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Other</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForOther = tdsListDAO.getDocumentListHRSide(employee_id, "Other"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForOther){
								%>
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="Other">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										
										</div>
										
										</center>
									</td>
								</tr>
								<%} %>
							</table>
							<div align="right">
								<input type="hidden" name="name" id="name" value="Other">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="Other" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!--  NPS  -->
	<div class="modal fade" id="NPSModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">NPS</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover" id="NPSTable">
								<thead>
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								</thead>
								<tbody>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForNPS = tdsListDAO.getDocumentListHRSide(employee_id, "NPS"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForNPS){
								%>
								
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="NPS">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
								</tbody>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="NPS" value="Lock" onclick="hrApprovalInsert();"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div> 
	<!-- RGESS  -->
	<div class="modal fade" id="RGESSModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">RGESS</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover" id="RGESSTable">
								<thead>
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								</thead>
								<tbody>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForRGESS = tdsListDAO.getDocumentListHRSide(employee_id, "RGESS"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForRGESS){
								%>
								
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="RGESS">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
								</tbody>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="RGESS" value="Lock" onclick="hrApprovalInsert();"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div> 
	<!-- Mediclaim -->
	<div class="modal fade" id="MediclaimModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Mediclaim</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover" id="MediclaimTable">
								<thead>
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								</thead>
								<tbody>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForMediclaim = tdsListDAO.getDocumentListHRSide(employee_id, "Mediclaim"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForMediclaim){
								%>
								
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="Mediclaim">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
								</tbody>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="Mediclaim" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div> 
	<!-- Donation 80G -->
	<div class="modal fade" id="Donation80GModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Donation 80G</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover" id="Donation80GTable">
								<thead>
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								</thead>
								<tbody>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForDonation80G = tdsListDAO.getDocumentListHRSide(employee_id, "Donation80G"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForDonation80G){
								%>
								
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="Donation80G">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
								</tbody>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="Donation80G" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div> 
	<!-- Donation 80GGC -->
	<div class="modal fade" id="Donation80GGCModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Donation 80G</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-bordered table-hover" id="Donation80GGCTable">
								<thead>
								<tr>
									<th>Month</th>
									<th>Proof</th>
									<th>Amount</th>
									<th></th>
								</tr>
								</thead>
								<tbody>
								<% List<TDSDocumentUploadBean> tdsDocumentUploadForDonation80GGC = tdsListDAO.getDocumentListHRSide(employee_id, "Donation80GGC"); 
									for(TDSDocumentUploadBean uploadBean : tdsDocumentUploadForDonation80GGC){
								%>
								
								<tr>
									<td><%=uploadBean.getMonthBean().getMonth_name()%></td>
									<td><a href="photo.jsp?attachment=<%=uploadBean.getAttachment()%>" target="_blank">
												<img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment() %>"
														alt="User Avatar" height="15px" width="15px" 
														tabindex="0" data-placement="left" data-toggle="popover" data-trigger="hover" data-content="<div class='media'><a href='#' class='pull-left'><img src='FileServlet?path=D:\hrms\upload\TDSDocument\<%=uploadBean.getAttachment()%>' height='250px' width='250px' alt='Sample Image'></a></div>"
														/>
														</a></td>
									<td><%=uploadBean.getAmount() %></td>
									<td id="check"><center>
									<div class="Donation80GGC">
									<% if(uploadBean.getStatus().equalsIgnoreCase("approved")){%>
											<i class="icon-checkmark" style="font-size: 15px;"></i>
										<%}else{ %>
											<i class="icon-exclamation" style="font-size: 15px;"></i>
										<%} %>
										</div>
										</center>
									</td>
								</tr>
								<%} %>
								</tbody>
							</table>
							<div align="right">
								<input type="hidden" id="tds_id" name="tds_id" value="<%=tds_id%>" />
								<input type="button" class="btn btn-success" id="Donation80GGC" value="Lock" onclick="hrApprovalInsert(this.id);"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- /.modal -->
	</div>
	<!-- /.row -->
	<!-- /#wrapper -->
	
	
	<!-- <script type="text/javascript">
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
	</script> -->
	
	<script type="text/javascript">
	if(monthly == true)
	{
		//alert("MONTHLY");
		$("#yearly").hide();
		$("#monthly").show();
		document.getElementById("result").value = "Monthly";
	}
	else
		{
			//alert("YEARLY");
			$("#monthly").hide();
			$("#yearly").show();
			document.getElementById("result").value = "Yearly";
		}
	</script>
	
	<!-- <script type="text/javascript">
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
	</script> -->
	
	<!-- <script type="text/javascript">
	if(cash == true)
	{
		//alert("CASH");
		$("#cheque").hide();
		$("#cash").show();
		document.getElementById("donationResult").value = "Cash";
	}
	else
		{
			//alert("CHEQUE");
			$("#cash").hide();
			$("#cheque").show();
			document.getElementById("donationResult").value = "Cheque";
		}
	</script> -->
	
	
	<script type="text/javascript">
	
	if(metro == true)
		{
		//alert("GOPI");
		$("#nonMetro").hide();
		$("#totalBasicNonMetro").hide();
		$("#rentSlipNonMetro").hide();
		$("#actualHRANonMetro").hide();
		$("#nonMetroDeduction").hide();

		//document.getElementById("checked").value = "Metro";
		$("#metro").show();
		$("#totalBasicMetro").show();
		$("#rentSlipMetro").show();
		$("#actualHRAMetro").show();
		$("#metroDeduction").show();
		}
	else
		{
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
								<script type="text/javascript">
	                                	$(document).ready(function(){
	                                		var id = $("#docList").val();
	                                		if(id == 0){
	                                			$("#DeclairedTaxSlab").show();
	                                			$("#ActualTaxSlab").hide();
	                                			$(".actual").hide();
	                                			$(".declare").show();
	                                		}else{
	                                			$("#DeclairedTaxSlab").hide();
	                                			$("#ActualTaxSlab").show();
	                                			$(".actual").show();
	                                			$(".declare").hide();
	                                		}
	                                	});
	                                
	                                </script>
	
	
	
	
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#start_month').change(function () {
	        var doc = document.getElementById("start_month");
	        var start_month = doc.options[doc.selectedIndex].text ;
	        alert("You selected " + start_month);
	    });
	});
	
	$(document).ready(function () {
	    $('#end_month').change(function () {
	        var doc = document.getElementById("end_month");
	        var end_month = doc.options[doc.selectedIndex].text;
	        alert("You selected " + end_month);
	        
	        var s_month =  $('#start_month').val();
	       	alert("month Id: "+ s_month);
	       	
	       	var e_month =  $('#end_month').val();
	       	alert("month Id: "+ e_month);
	        
	       	// alert(" " + e_month + " " + s_month);
	       	var month = 0;
	       	if(e_month > s_month)
	       	{
	       		alert("IF");
	       		month = (e_month - s_month) + 1 ;
	       	 	alert("Months :"+ month);
	       	}
		       	else if(e_month < s_month)
	       		{
			       	alert("ELSE IF");
			       	month = (s_month - e_month);
		       		alert("Months :"+ month);
		       		
		       		if(month == 1){
		       			month = 12 ;
		       			alert("Months :"+ month);
		       		}else if(month == 2){
		       				month = 11 ;
		       				alert("Months :"+ month);
		       			}else if(month == 3){
		       				month = 10 ;
		       				alert("Months :"+ month);
		       			}else if(month < 0){
		       				month = -(month) + 1;
		       				alert("Months :"+ month);
		       			}
	       		}
		       	else if(s_month == e_month)
		       		{
		       		month = 1 ;
		       			alert("Month :"+ month);
		       		}
    });
	});
	</script>
	
	<script>
	
function hrApprovalInsert(id) {
		//alert("akash"+id);
		
		//alert($('#name').val());
		//alert($('#tds_id').val());
		
				$.ajax({
					 method: "POST",
					 url: 'documentStatusUpdate',
					data : {
						name :id,
						tds_id : $('#tds_id').val()
					},
					success : function(data) {
						//alert(data);
						//alert("."+id);
						$("i","."+id).toggleClass("icon-exclamation icon-checkmark");
					}
				});
			
	}
	
	</script>
	
</body>
</html>