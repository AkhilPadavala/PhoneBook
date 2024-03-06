
<%@ page import="java.sql.ResultSet" %>
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
String email=(String)session.getAttribute("email");
if(email!=null)
{
	
ResultSet rs= dao.ContactDao.getAllContacts(email);

%>
<table border=2px>
<tr>
<th>NAME</th>
<th>PHONE</th>
</tr>
<%
while(rs.next())
{
%>
<tr>
<td><%= rs.getString(2) %></td>
<td><%= rs.getLong(3) %></td>
</tr>
<%
}
}
else
{
	response.sendRedirect("login.jsp");
}

%>

</table>

</body>
</html>