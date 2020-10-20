<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listAll_page</title>
<style>
table{
background-color:#FEF9E7;
}


h3{
font-family:"Comic Sans MS",cursive,sans-serif;
}
.k{
text-decoration:none;
font-size:25px;
color:red;
background-color:#F9EBEA;
padding:5px;
margin:5px;
border:1px solid black;
}
</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="kavana"%>
<table border="1" class="center">
<tr><th>id</th><th>name</th><th>rooms</th><th>type</th><th>location</th><th>price</th><th>contact</th></tr>
<kavana:forEach var="hai" items="${all}">
<tr><td>${hai.getId()}</td><td>${hai.getName() }</td><td>${hai.getRooms() }</td>
<td>${hai.getType() }</td><td>${hai.getLocation() }</td><td>${hai.getPrice() }</td><td>${hai.getContact() }</td>
<td>
<ol type="A">
<li><a href="editable?id=${hai.getId() }">Edit</a></li>
<li><a href="deletable?id=${hai.getId() }">Delete</a></li>
</ol>
</td>
</tr>
</kavana:forEach>
</table></br>
<p><a class="k" href="back">click here to go to home</a></br></br>
<a class="k" href="logout">click here to logout</a></p>
</body>
</html>