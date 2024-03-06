<%@ page import="java.sql.*"%>
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

ResultSet rs=null;
try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","root");
	String sql="SELECT * FROM phonebook";
	Statement s=con.createStatement();
	 rs=s.executeQuery(sql);
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
<table border=2px>
<tr>
<th>ID</th>
<th>NAME</th>
<th>PHONE</th>
<th>EMAIL</th>
<th>EDIT</th>
<th>DELETE</th>
</tr>
<%
while(rs.next())
{
%>
<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getLong(3)%></td>
<td><%=rs.getString(4)%></td> 
<td><a href="edit?id=<%=rs.getInt(1) %>">Edit</a></td>
<td><a href="delete?id=<%=rs.getInt(1) %>">Delete</a></td>
</tr>
<%} %>

</body>
</html>