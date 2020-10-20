<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hotels</title>
<style type="text/css">
a{
text-decoration:none;
font-size:25px;
color:red;
background-color:#F9EBEA;
padding:5px;
margin:5px;
border:1px solid black;
}
body{
text-align:center;
font-family:verdana;
}
table{
border:1px solid black;
text-align:center;
background-color:#ECF0F1;
}

.center{
margin-left:auto;
margin-right:auto;
}
th,td{
padding:8px;
text-align:center;
}
h3{
font-family:"Comic Sans MS",cursive,sans-serif;
}

</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div align="center">
<table border="1">
<tr><th>Matched Hotel names</th></tr>
<core:forEach var="mon" items="${all }">
<tr><td>${mon }</td></tr>
</core:forEach>
</table>
</div></br>
<a href="back">click here to go to home</a></br></br>
<a href="logout">click here to logout</a>
</body>
</html>