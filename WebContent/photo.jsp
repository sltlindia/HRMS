<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
<%String attachment = request.getParameter("attachment");%>
	<center><img src="FileServlet?path=D:\hrms\upload\TDSDocument\<%=attachment%>" style="padding-top: 100px;"></center>
</body>
</html>