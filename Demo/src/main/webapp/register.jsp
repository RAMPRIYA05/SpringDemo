<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:land">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/register" method="get">
<h2>Registration</h2>
Name:<input type="text" placeholder="Enter your name" id="name" name="name" pattern="^[A-Za-z]+$" required><br>
<br>Email Id:<input type="email" placeholder="Enter your EmailId" id="emailId" name="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+[/.][a-z]{2,}$" required><br>
<br>Password:<input type="password" placeholder="Enter your Password" id="password" name="password" pattern="(?=.\d)(?=.[a-z])(?=.[A-Z])(?=.[@$!%?&])[A-Za-z\d@$!%?&]{8,}" required><br>
<button onclick="validation()">Submit</button>

</form>

<script type="text/javascript">

function validation() {
   var name=document.getElementById("name");
   var emailId=document.getElementById("emailId");
   var password=document.getElementById("password");
   
   if(!name.checkValidity())
   {
	   alert("Name must be filled out in alphabets");
	   return; 
	}
   if(!emailId.checkValidity()){
	   alert("EmailId must be filled out");
	   return;
   }
   if(!password.checkValidity()){
	   alert("Password must be in one uppercase,one lowercase,one numbers,one special characters,and length 8");
	   return;
   }
   
}

</script>
</body>
</html>