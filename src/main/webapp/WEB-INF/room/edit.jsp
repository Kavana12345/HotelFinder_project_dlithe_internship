<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editing</title>
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
background-color:#A3E4D7;
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
${msg }
<%@ taglib prefix="hotelfinder" uri="http://www.springframework.org/tags/form" %>
<hotelfinder:errors path="hotel.*"/>
<form action="change" method="post">
<table class="center">
<tr><td><input type="text" name="id" value="${one.getId() }"></td></tr>
<tr><td><input type="text" name="name" value="${one.getName() }"></td></tr>
<tr><td><input type="text" name="rooms" value="${one.getRooms() }"></td></tr>
<tr><td><input type="text" name="type" value="${one.getType() }"></td></tr>
<tr><td><input type="text" name="location" value="${one.getLocation() }"></td></tr>
<tr><td><input type="text" name="price" value="${one.getPrice() }"></td></tr>
<tr><td><input type="text" name="contact" value="${one.getContact()}" ></td></tr>
<tr>
 <td><input type="submit" name="update" value="update"></td>
 <td><input type="reset" name="clear"></td>
</tr>
</table>
</form></br></br>
<a href="back">click here to go to home</a></br></br>
<a href="logout">click here to logout</a>
</body>
</html>