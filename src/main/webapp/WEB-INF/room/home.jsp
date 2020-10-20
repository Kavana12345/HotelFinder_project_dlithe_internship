<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home_page</title>
<style type="text/css">
body{
text-align:center;
background-color:lightblue;
font-family:verdana;
}
table{
border:1px solid black;
text-align:center;
}
th,td{
border:1px solid black;
padding:15px;
text-align:center;

}
tr:hover{
background-color:#f5f5f5;
}
.center{
margin-left:auto;
margin-right:auto;
}
h1{
font-family:"Comic Sans MS",cursive,sans-serif;
}
a{
text-decoration:none;
color:red;
}
</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<h1>WELCOME TO KANASU HOTEL FINDER</h1>
<table class="center">
<tr><td><a href="add">add new hotel</a></td></tr>
<tr><td><a href="list">list all the hotels</a></td></tr>
<tr><td><a href="short">short listing</a></td></tr>
<tr><td><a href="logout">logout</a></td></tr>
</table>
</body>
</html>