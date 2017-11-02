<%@page import="com.hrms.pms.dao.AllListDAO"%>
<%@page import="com.hrms.kaizen.dao.AllKaizenListDAO"%>
<%@page import="com.hrms.kaizen.bean.KaizenProblemIdentificationBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean"%>
<%@page import="java.util.List"%>
<%@page import="com.hrms.kaizen.bean.KaizenBean"%>
<%@page import="com.hrms.kaizen.bean.KaizenMemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CI</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<%int kaizen_id = Integer.parseInt(request.getParameter("kaizen_id"));
int dept_id = Integer.parseInt(request.getParameter("dept_id"));
int year = Integer.parseInt(request.getParameter("year"));
int month = Integer.parseInt(request.getParameter("month"));


AllKaizenListDAO allKaizenListDAO = new AllKaizenListDAO();
KaizenBean kaizenBean = allKaizenListDAO.getDetailOfKaizenById(kaizen_id);
List<KaizenBean> lisOfKaizen = allKaizenListDAO.getListOfAllKaizenByDepartment(dept_id,year,month);
List<KaizenAfterUploadAttachmentBean> listOfAfter = allKaizenListDAO.getListOfAfterUploadAttachment(kaizen_id);
List<KaizenBeforeUploadAttachmentBean> listOfBefore = allKaizenListDAO.getListOfBeforeUploadAttachment(kaizen_id);
List<KaizenProblemIdentificationBean> listOfIdentification  = allKaizenListDAO.getListOfProblemByDeptIdWithMonthYear(dept_id,month,year);
List<KaizenMemberBean> listOfMember = allKaizenListDAO.getListOfMemberByKaizenId(kaizen_id);
%>

<table>
	<tr>
		<td>
			  <table class="table table-bordered">
				
				<tr>
					<td height="550px;" width="200px;">
						
						<div class="row">
								<div class="col-md-4 col-sm-4 col-xs-4 col-lg-4 col-sm-4 col-xs-4 col-lg-4" align="left">
									<%int company_id = kaizenBean.getEmployeeBean().getCompanyListBean().getCompany_list_id();
							int emp_code = kaizenBean.getEmployeeBean().getEmployee_code();
							String company_name = null;
							if(company_id == 1){
								company_name = "SLTL";
							}else if(company_id == 2){
								company_name = "SS";
							}else if(company_id == 3){
								company_name = "S.HR";
							}else if(company_id == 4){
								company_name = "COSMOS";
							}else if(company_id == 5){
								company_name = "CSLASER";
							}else if(company_id == 6){
								company_name = "SEZ";
							}else if(company_id == 7){
								company_name = "CL";
							}if(company_id == 8){
								company_name = "App";
							} %>
							
							<img alt="<%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%>" src="FileServlet?path=D:\hrms\upload\profilePic\<%=company_name%>\<%=emp_code%>.bmp" height="60px;" width="60px;" style="border: solid 1px;">
								</div>
								
								<div class="col-md-8 col-sm-8 col-xs-8 col-lg-8">
								<p>
								<b><%=kaizenBean.getEmployeeBean().getFirstname()+" "+kaizenBean.getEmployeeBean().getLastname()%></b><br>
								</p>
								<p style="font-size: 10px;">
								<%if(listOfMember.size()>1){ %>
								<b>Team Members : </b><br>
								<%} %>
							<%for(KaizenMemberBean kaizenMemberBean : listOfMember){
							if(kaizenMemberBean.getEmployeeBean().getEmployee_master_id() != kaizenBean.getEmployeeBean().getEmployee_master_id()){%>
								<%=kaizenMemberBean.getEmployeeBean().getFirstname()+" "+kaizenMemberBean.getEmployeeBean().getLastname()%>,
							<%}} %>
						</p>
								</div>
						</div>
						
						<br>
						
						<div class="row">
							<div class="col-md-12" align="justify">
						<p style="font-size: 10px;"><b>
						CI Name :<a style="cursor: pointer;" onclick="window.open('kaizenView.jsp?kaizen_id=<%=kaizen_id%>','_blank');">
						          <a style="cursor: pointer;" onclick="window.open('kaizenMonthWisePrint.jsp?kaizen_id=<%=kaizen_id%>','_blank')"><%=kaizenBean.getKaizen_name()%></a> 
						     </a></b></p>
						<p style="font-size: 10px;width: 290px"><%=kaizenBean.getKaizen_desc()%></p>
						<p style="font-size: 10px;"><b>Projected Saving</b></p>
						<p style="font-size: 10px;">
							<table class="table" border="1" style="font-size: 10px;">
								<tr>
									<th>Delivery</th>
									<td><%=kaizenBean.getDelivery()%></td>
								</tr>
								<tr>	
									<th>Cost</th>
									<td><%=kaizenBean.getCost()%> Rs.</td>
								</tr>	
								<tr>	
									<th>Quality</th>
									<td><%=kaizenBean.getQuality()%></td>
								</tr>	
								<tr>	
									<th>Safety</th>
									<td><%=kaizenBean.getSafety()%></td>
								</tr>	
								<tr>	
									<th>Productivity</th>
									<td><%=kaizenBean.getProductivity()%></td>
								</tr>	
									
							</table>
						</p>
							</div>
						</div>
					
							
					</td>
				</tr>
			  </table>
			</td>
	</tr>
	
</table>

<script type="text/javascript">
$( document ).ready(function() {
   window.print();
   setTimeout(function print(){
		window.close();
}, 1000)
});
</script>
</body>
</html>