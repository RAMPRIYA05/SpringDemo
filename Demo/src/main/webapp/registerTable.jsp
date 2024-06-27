<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.chainsys.Demo.model.User" %>
     <%@ page import="java.util.ArrayList" %>
       <%@ page import="java.util.List" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/search" method="get">
     <h4>Search:<input type="search" placeholder="Enter your Search EmailId" name="emailId" id="emailId"><br></h4>
</form>


 <table border="1">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email Id</th>
					<th>Password</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<%List<User> list=(ArrayList<User>)request.getAttribute("list");
for(User obj:list)
{
%>
			<tr>
				<td><%=obj.getName()%></td>
				<td><%=obj.getEmailId()%></td>
				<td><%=obj.getPassword()%></td>
				<td>
					<form action="update.jsp">
						<input type="hidden" name="emailId" value="<%=obj.getEmailId()%>">

						<button>Update</button>
					</form>
				</td>

				<td>
					<form action="/delete" method="get">
						<input type="hidden" name="emailId" value="<%=obj.getEmailId()%>"> 
						<button>Delete</button>
					</form>
				</td>
			</tr>


<%
}
%>
   </table> 



</body>
</html>