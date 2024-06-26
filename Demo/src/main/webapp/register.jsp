<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/register" method="get">
<fieldset>
<h2>Registration</h2>
Name:<input type="text" placeholder="Enter your name" name="name" required><br>
<br>Email Id:<input type="email" placeholder="Enter your EmailId" name="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required><br>
<br>Password:<input type="password" placeholder="Enter your Password" name="password" pattern=".{8,}" required><br>
<form action="/listOfUsers" method="get">
<button>Submit</button>
</form>
</fieldset>

</form>
</body>
</html>