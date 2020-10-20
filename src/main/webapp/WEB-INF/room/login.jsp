<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login_page</title>
<style type="text/css">
body{
text-align:center;
font-family:verdana;
}
table{
border:1px solid black;
text-align:center;
background-color:#A9CCE3;
}
p{
font-family:"Comic Sans MS",cursive,sans-serif;
}
.center{
margin-left:auto;
margin-right:auto;
}
th,td{
padding:8px;
text-align:center;
</style>
</head>
<body>
${msg}
<form action="log" method="post">
<p>Enter username and password</p>
<table class="center">
<tr><td>username : <input type="text" name="user" placeholder="enter username"></td></tr>
<tr><td>password : <input type="password" name="pass" placeholder="enter password"></td></tr>
<tr><td><input type="submit" name="login" value="login">   <input type="reset" name="clear"></td></tr>
</table>
</form>
</body>
</html>