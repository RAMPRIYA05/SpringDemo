<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String emailId=request.getParameter("emailId");
%>

<form action="/update" method="get">
 Name: <input type="text" placeholder="Enter your new name" name="name" required><br>
 EmailId:<input type="email" name="emailId" value="<%=emailId %>" readonly>
 Password:<input type="password" placeholder="Enter your new password" name="password" required>
 <button>Update</button>
 </form>
</body>
</html>