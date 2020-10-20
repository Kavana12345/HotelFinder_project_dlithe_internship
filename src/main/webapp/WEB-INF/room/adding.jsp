<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add_page</title>
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
background-color:#D7BDE2;
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
 ${msg}
 <%@ taglib prefix="hotelfinder" uri="http://www.springframework.org/tags/form" %>
<hotelfinder:errors path="hotel.*"/>
<form action="input" method="post">
<h3>Enter all the details of the HOTEL</h3>
 <table class="center">
<tr><td>name of the hotel: <input type="text" name="name"></td></tr>
<tr><td>number of rooms available: <input type="text" name="rooms"></td></tr>
<tr><td>type: <input type="text" name="type"></td></tr>
<tr><td>location: <input type="text" name="location"></td></tr>
<tr><td>price per day: <input type="text" name="price"></td></tr>
<tr><td>contact: <input type="text" name="contact"></td></tr>
<tr>
<td><input type="submit" name="submit" value="add"> <input type="reset" name="clear"></td></tr>
</table>
</form>
</br></br>
<a href="back">click here to go to home</a></br></br>
<a href="logout">click here to logout</a>
</body>
</html>