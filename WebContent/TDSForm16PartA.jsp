<%@page import="com.hrms.tds.bean.TDSHrTotalFBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalEBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalDBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalCBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalBBean"%>
<%@page import="com.hrms.tds.bean.TDSHrTotalABean"%>
<%@page import="com.hrms.tds.bean.TDSHrBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalEBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalDBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalCBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalFBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalBBean"%>
<%@page import="com.hrms.tds.bean.TDSTotalABean"%>
<%@page import="com.hrms.tds.bean.TDSBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.tds.dao.TDSListDAO"%>
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
    <title>Form 16(PART A)</title>
    <link rel="shortcut icon" sizes="152x152"
	href="app-assets/images/ico/titleIcon.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <!-- BEGIN VENDOR CSS-->
    <link href="dist/css/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="dist/css/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="dist/css/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="dist/css/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
    <!-- END Custom CSS-->
    <%@include file="header.jsp"%>
<style type="text/css">
#name{
	font-size:30px;
}

 .hide_top{
        border-top-style: dotted;
      }

@page {
    size: A4;
    margin:.95cm;
}

@media print {
  #printPageButton {
    display: none;
  }
}

@media (min-width: 768px){
	#page-wrapper {
    position: inherit;
    margin: 0 100px 0 100px;
    padding: 0 30px;
    border-left: 1px solid #e7e7e7;
	}
}
#page-wrapper {
    padding: 0 15px;
    min-height: 568px;
    background-color: #fff;
}
.break{
	page-break-before: always;
}
</style>

 <!--  /* ... the rest of the rules ... */ -->


<!-- <script type="text/javascript">
$(document).ready(function() {

	//iterate through each textboxes and add keyup
	//handler to trigger sum event
	
	$(".hideFile").hide();
	
	
	$('[name="totalb"]').each(function() {

		$(this).keyup(function() {
			calculateSum();
		});
	});

});

function calculateSum() {

	var sum = 0;
	//iterate through each textboxes and add the values
	$('[name="totalb"]').each(function() {

		//add only if the value is number
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}

	});
	$(".sum").html(sum.toFixed(2));
}
</script> -->

</head>
<body>
<div id="wrapper">
	<div id="page-wrapper">

	<div class="row">
			<div align="right" style="padding-right: 20px;"><a href="TDSForm16List.jsp" id="printPageButton"><button type="button" class="btn btn-info" id="printPageButton">BACK</button></a>
			<button type="button" class="btn btn-danger" id="printPageButton" onclick="window.print();">PRINT</button></div>
	</div>
	<br>
	<div class="row">
       <div class="col-lg-12">
                        
                       <% int id = Integer.parseInt(request.getParameter("tds_hr_id"));
                       System.out.println("TDS HR ID" + id);
							TDSListDAO tdsListDAO = new TDSListDAO();
							List<TDSHrBean> listOfTDS = tdsListDAO.getAllTdsHrListByID(id);
				            
				           	for(int i = 0;i<listOfTDS.size();i++)
				           	{
				           		TDSHrBean tdsHrBean = listOfTDS.get(i);
				            	int tds_hr_id = tdsHrBean.getTds_hr_id();		
				            		
				            TDSHrBean t = tdsListDAO.detailsOfTDSHr(tds_hr_id);
				            TDSHrTotalABean ta = tdsListDAO.detailsOfTDSHrTotal_A(tds_hr_id);
				            TDSHrTotalBBean tb = tdsListDAO.detailsOfTDSHrTotal_B(tds_hr_id);
				            TDSHrTotalCBean tc = tdsListDAO.detailsOfTDSHrTotal_C(tds_hr_id);
				            TDSHrTotalDBean td = tdsListDAO.detailsOfTDSHrTotal_D(tds_hr_id);
				            TDSHrTotalEBean te = tdsListDAO.detailsOfTDSHrTotal_E(tds_hr_id);
				            TDSHrTotalFBean tf = tdsListDAO.detailsOfTDSHrTotal_F(tds_hr_id);
				           
				            
				            %>
                        
                        <!-- /.panel-heading -->
                                <table rules="all" bordercolor="#D3D2D2" border="1px">
										
										<tr>
											<td colspan="5"><center><b>FORM NO. 16</b></center></td>
										</tr>
										
										<tr>
											<td colspan="5"><center>[See rule 31(1)(a)]</center></td>
										</tr>
										
										<tr>
											<td colspan="5"><center><b>PART-A</b></center></td>
										</tr>
									
										<tr>
											<td colspan="2" width="50%"><center><b>Name and address of the Employer</b></center></td>
											<td colspan="3" width="50%"><center><b>Name and designation of the Employee</b></center></td>
										</tr>
										
										<tr>
											<td rowspan="2" colspan="2"><center>SAHAJANAND LASER TECHNOLOGY LTD.E-30. G.I.D.C., ELECTRONICS ESTATE,SECTOR-26,GANDHINAGAR - 382 028</center></td>
											<td colspan="3"><center><%=t.getEmployeeBean().getFirstname() %> <%=t.getEmployeeBean().getLastname() %></center></td>
										</tr>
										
										<tr>
											<td colspan="3"><center><%=t.getEmployeeBean().getRoleBean().getRole_type() %></center></td>	
										</tr>
										
										<tr>
											<td width="25%"><center><b>PAN No. of the Deductor</b></center></td>
											<td width="25%"><center><b>TAN No. of the Deductor</b></center></td>
											<td colspan="3"><center><b>PAN No. of the Employee</b></center></td>
										</tr>
										
										<tr>
											<td><center>AAGCS1983B</center></td>
											<td><center>AHMS04011A</center></td>
											<td colspan="3"><center><%=t.getEmployeeBean().getPan_no() %></center></td>
										</tr>
										
										<tr>
											<td colspan="2"><center><b>CIT (TDS)</b></center></td>
											<td rowspan="2" width="25%"  style="padding-top: 5px;"><center><b>Assessment year</b></center></td>
											<td colspan="2" width="25%"><center><b>Period</b></center></td>
										</tr>
										
										<tr>
											<td rowspan="2" colspan="2"><center><%=t.getEmployeeBean().getAdress() %></center></td>
											<td width="12%"><center><b>From</b></center></td>
											<td><center><b>To</b></center></td>
										</tr>
										
										<tr>
											<td><center><%=t.getPeriod() %></center></td>
											<td colspan="2"><center><input type="text" style="width:160px ; border: none; "> </center></td>
										</tr>
										<tr>
											<td colspan="5"><center><b>Summary of Tax Deducted at Source</b></center></td>
										</tr>
								</table>
								
								 <table class="table-responsive table-bordered">
								 		<tr>
											<td width="10%"><center><b>Quater</b></center></td>
											<td width="40%"><center><b>Receipt Number of original statement of TDS under sub-section (3) of section 200</b></center></td>
											<td width="25%"><center><b>Amount of tax deducted in respect of the Employee</b></center></td>
											<td width="25%"><center><b>Amount of tax deposited / remitted in respect of the employee</b></center></td>
										</tr>
								 
								 		<tr>
											<td width="10%"><center>Quater 1</center></td>
											<td width="40%"><center><b>NA</b></center></td>
											<td width="25%"><center><b>NIL</center></td>
											<td width="25%"><center><b>NIL</b></center></td>
										</tr>
										
										<tr>
											<td width="10%"><center>Quater 2</center></td>
											<td width="40%"><center><b>NA</b></center></td>
											<td width="25%"><center><b>NIL</center></td>
											<td width="25%"><center><b>NIL</b></center></td>
										</tr>
										
										<tr>
											<td width="10%"><center>Quater 3</center></td>
											<td width="40%"><center><b>NA</b></center></td>
											<td width="25%"><center><b>NIL</center></td>
											<td width="25%"><center><b>NIL</b></center></td>
										</tr>
										
										<tr>
											<td width="10%"><center>Quater 4</center></td>
											<td width="40%"><center><b>NA</b></center></td>
											<td width="25%"><center><b>NIL</center></td>
											<td width="25%"><center><b>NIL</b></center></td>
										</tr>
										
										<tr>
											<td colspan="5" height="17px;"></td>
										</tr>
										
										<tr>
                                			<td colspan="5"><center><b>PART B (Annexure)</b></center></td>
                                		</tr>
                                		<tr>
											<td colspan="5" height="17px;"></td>
										</tr>
                                		<tr>
								 			<td colspan="5"><b>Details of Salary paid and any other inomce and tax deducted</b></td>
								 		</tr>
								 </table>
								 
								 <table rules="cols" bordercolor="#D3D2D2" border="1px">
									<tr>
										<td colspan="2" width="55%">&nbsp;&nbsp;1 Gross salary
										<td width="15%"></td>  
										<td width="15%"></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(a) Salary as per provisions contained in section 17(1)</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=ta.getTotal_a() %></b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(b) Value of perquisites u/s 17(2)(as per FormNo.12BA, wherever<br>&emsp;&emsp;&nbsp;&nbsp; applicable)</td>
										<td><b>&nbsp;Rs.</b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(c) Profits in lieu of salary under section17(3) (as per Form No.<br>&emsp;&emsp;&nbsp;&nbsp; 12BA, wherever applicable</td>
										<td><b>&nbsp;Rs.</b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(d) Total</td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=ta.getTotal_a() %></b></td>
										<td></td>
									</tr>
									<tr>
										<td colspan="2">&nbsp;&nbsp;2 Less : Allowance to the extent exempt under section 10</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">
													<table rules="all" bordercolor="#D3D2D2" border="1px">
														<tr>
															<td width="420px;"><center>Allowance</center></td>
															<td width="180px;"><center>Rs.</center></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;CONVEYANCE ALL.</td>
															<td align="right"><%=tb.getD_conveyance() %></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;HOUSE RENT ALL.</td>
															<td align="right"><%=tb.getHouse_rant() %></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;MEDICAL ALL.</td>
															<td align="right"><%=tb.getD_medical() %></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;EDUCATION ALL.</td>
															<td align="right"><%=tb.getD_education_allw() %></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;LTA</td>
															<td align="right"><%=tb.getD_lta() %></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;UNIFORM ALL.</td>
															<td align="right"><%=tb.getD_uni_allw()%></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;MEAL ALL.</td>
															<td align="right"><%=tb.getMeal_card() %></td>
														</tr>
														<%double sum = tb.getD_conveyance() + tb.getHouse_rant() + tb.getD_medical() + tb.getD_education_allw() + tb.getD_lta() + tb.getD_uni_allw() + tb.getMeal_card(); 
															double totalba = ta.getTotal_a() - sum ;%>
													</table>
										</td>
										<td></td>
										<td><label style="padding-top: 130px;">&nbsp;Rs.&emsp;&emsp;<%=sum %></label></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;3 Balance(1-2)</td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=totalba %></b></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;4 Deductions:<br>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&nbsp;(a) Entertainment Allowance</td>
										<td><b>&nbsp;Rs.</b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&nbsp;(b) Tax on Employment</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tb.getPtax() %></b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;5 Aggregate of 4(a) and (b)</td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tb.getPtax() %></b></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;6 Income chargeable under the head 'Salaries'(3-5)</td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tb.getTotal_b()%></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;7 Add : Any other income reported by the employee</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">
													<table rules="all" bordercolor="#D3D2D2" border="1px">
														<tr>
															<td width="420px;"><center>Income</center></td>
															<td width="180px;"><center>Rs.</center></td>
														</tr>
														<tr>
															<td><center>Housing Loan Interest</center></td>
															<td align="right"><%=tc.getD_house_loan() %></td>
														</tr>
													</table>
										</td>
										<td></td>
										<td><label style="padding-top: 10px;">&nbsp;Rs.&emsp;&emsp;<%=tc.getD_house_loan() %></label></td>
										<td></td>
									</tr>
									<% 	System.out.println("total BA"+totalba);
										double totalc = (tb.getTotal_b()) - (tc.getD_house_loan()); %>
									<tr>
										<td colspan="2">&nbsp;&nbsp;8 Gross total income(6 - 7)</td>
										<td></td>
										<td></td>
										<td><label>&nbsp;Rs.&emsp;&emsp;<%=totalc %></label></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;9 Deductions under Chapter VI-A<br>
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(A) Sections 80C, 80CCC and 80CCD*</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(a) Section 80C</td>
										<td></td>
										<td><center>Gross amount</center></td>
										<td><center>Deductible amount</center></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(i) LIFE INSURANCE</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getLife_insurance() %></b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(ii) EPF / PPF</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=(td.getEPF() + td.getPPF())%></b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(iii) NSC </td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getNSC() %></b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2" height="12px;"></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									
									</table>
									
								 <table rules="cols" bordercolor="#D3D2D2" border="1px" width="100%"> 
									<tr>
										<td colspan="2" width="55%;">&emsp;&emsp;&emsp;&emsp;(iv) MF/ELSS </td>
										<td width="15%;"><b>&nbsp;Rs.&emsp;&emsp;<%=td.getMF() %></b></td>
										<td width="15%;"></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(v) TUITION FEES </td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getTuition_fees() %></b></td>
										<td></td>
										<td></td>
									</tr>
									
								
									<tr>
										<td colspan="2" >&emsp;&emsp;&emsp;&emsp;(vi) HOUSING LOAN PRINCIPAL</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getHouse_loan_principal() %></b></td>  
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(vii) STAMP DUTY & REGISTRATION FEES</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getStamp_duty() %></b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(viii) FIXED DEPOSIT</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getTax_saver_deposite() %></b></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(ix) Section 80CCC</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getOther() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getA_total_d() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=td.getD_total_d() %></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(b) Section 80CCD(1B)</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=te.getD_NPS() %></b></td>
										<td></td>
										<td></td>
									</tr>
									<% 	
										double Total80ccg = td.getOther() + te.getTotal_NPS_RGESS() ; %>
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(c) Section 80CCG</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=te.getD_RGESS() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=Total80ccg%></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=Total80ccg%></b></td>
									</tr>

									<tr>
										<td colspan="5">&nbsp;&nbsp;Note :&emsp;1. *Aggregate amount deductible under sections, i.e, 80C, 80CCC & 80CCD(1), shall not exceed one lakh fifty<br>&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp; thousand rupees.</td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(B) other sections (e.g., 80E, 80G, 80TTA etc.) Under Chapter VI-A</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									
									<tr>
										<td colspan="2"></td>
										<td><center>Gross Amount</center></td>
										<td><center>Qualifying Amount</center></td>
										<td><center>Deductible Amount</center></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(i) Section 80D</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getD_mediclaim() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getD_mediclaim() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getD_mediclaim() %></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(ii) Section 80G(5)</td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getDonation_80G() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getDonation_80G() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getDonation_80G() %></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(iii) Section 80E </td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getEducation_loan() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getEducation_loan() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getEducation_loan() %></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&emsp;&emsp;&emsp;&emsp;(iv) Section 80GGA/80GGC </td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getD_donation_80GGC() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getD_donation_80GGC() %></b></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getD_donation_80GGC() %></b></td>
									</tr>
									<% double agg_dedu = tf.getTotal_80EGD() + Total80ccg + td.getD_total_d() ; %>
									<tr>
										<td colspan="2">&nbsp;&nbsp;10 Aggregate of deductible amount sunder Chapter VI-A</td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=agg_dedu %></b></td>
									</tr>
									<% double t_income = totalc - agg_dedu ; %>
									<tr>
										<td colspan="2">&nbsp;&nbsp;11 Total income (8-10)</td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=t_income %></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;12 Tax on total income</td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getTotal_tax() %></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;13 Education Cess @ 3% on (on tax computed ar S. No.12)</td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tf.getEdu_cess() %></b></td>
									</tr>
									<% double a = tf.getTotal_tax() + tf.getEdu_cess();
									String g = String.valueOf(a);
										Float tax_payable = Float.parseFloat(g);
									%>
									<tr>
										<td colspan="2">&nbsp;&nbsp;14 Tax payable (12+13)</td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tax_payable%></b></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;15 Less: Relief under section 89 (attach details) </td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;0.0</b></td>
									</tr>
									
									<tr>
										<td colspan="2">&nbsp;&nbsp;16 Tax payable (14-15)</td>
										<td></td>
										<td></td>
										<td><b>&nbsp;Rs.&emsp;&emsp;<%=tax_payable %></b></td>
									</tr>
								</table>
								 
								<table rules="all" bordercolor="#D3D2D2" border="1px">
									<tr>
										<td width="100%" colspan="3"><center><b>Verification</b></center></td>
									</tr>
									
									<tr>
										<td colspan="3"> I <b>MUKESH PATEL</b> son of <b>MR. MAFATLAL PATEL</b> working in the capacity of <b>HEAD HR</b> do hereby certify that a sum of Rs. 0.00 &nbsp;(-NIL-) has been deducted and deposited to the  credit of the Central Government. I further certify that the information given above is true, complete and correct based on the books of account, documents , TDS books of account, documents , TDS statement, TDS deposited and other available records.																										
										</td>
									</tr>
									
									<tr height="50px;">
										<td colspan="3"></td>
									</tr>
									
									<tr>
										<td width="10%">Place</td>
										<td width="20%">Gandhinagar</td>
										<td rowspan="2" style="padding-top: 20px; border-top-style: hidden;" >Signature of person responsible for deduction of tax</td>
									</tr>
									
									<tr>
										<td>Date</td>
										<td></td>
									</tr>
									
									<tr>
										<td width="10%">Designation</td>
										<td width="20%">Head HR</td>
										<td>Full Name:  Mr. Mukesh Mafatlal Patel</td>
									</tr>
								</table>
								
								<table class="table-responsive table-bordered" width="100%">
									<tr>
										<td colspan="22"><center><b>ANNEXURE - B</b></center></td>
									</tr>
									<tr >
										<td colspan="22"><center><b>DETAILS OF TAX DEDUCTED AND DEPOSITED IN THE CENTRAL GOVERNMENT ACCOUNT THROUGH CHALLAN</b><br>
														(The Employer to provide payment wise details of tax deducted and deposited with respect to the employee)																										
														</center></td>
									</tr>
									
									<tr>
										<td rowspan="2" width="50px;"><center>S. No.</center></td>
										<td rowspan="2" width="200px;"><center>Tax Deposisted in respect on of employee (Rs.)</center></td>
										<td colspan="20"><center>Challan Identification Number (CIN)</center></td>
									</tr>
									
									<tr>
										<td colspan="7" width="235px;"><center>BSR Code of the Bank Branch</center></td>
										<td colspan="8" width="262px;"><center>Date on which tax deposited<br> (dd/mm/yyyy)</center></td>
										<td colspan="5" width="204px;"><center>Challan Serial Number</center></td>
									</tr>
									
									<tr>
										<td><center>1</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>2</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>3</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>4</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>5</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>6</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>7</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>8</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>9</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>10</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>11</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>12</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
									
									<tr>
										<td><center>Total:</center></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
										<td></td><td></td><td></td>
									</tr>
								</table>
									 
						       </div>    
						       <%} %>                
                            <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel -->
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
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <!-- build:js app-assets/js/app.min.js-->
    <script src="app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="app-assets/js/scripts/ui/fullscreenSearch.min.js" type="text/javascript"></script>
    <!-- /build-->
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="app-assets/js/scripts/pages/timeline.min.js" type="text/javascript"></script>
 <!-- BEGIN VENDOR JS-->
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
     <script>
    function showData(id){
    	alert("ID"+id);
		 $("#"+id).slideToggle(2);
		 
	     /* $("i", "#"+id).toggleClass("fa-minus-circle fa-plus-circle"); */
	}
    </script>
    <script>
	$(document).ready(function(){
			 $("#Update").hide();
			 $(".hide").hide();
	});
	</script>
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