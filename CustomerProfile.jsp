<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body background="Background.png">
<center>
<br>
<br>
<img src = "Basket.png" width = 400 px, height =450px> 
<br>
<br>
<h3 style="color: white">
<%
Integer profileid=(Integer) request.getAttribute("profileid");
if(profileid!=null)
{
	out.print(profileid);
}

%>
<br><br>
<%
String str2=(String) request.getAttribute("welcomemsg");
if(str2!=null)
{
	out.print(str2);
}

%>
</h3>

<br>
<br>
<form action="LogoutServlet" method="post">
<button style=" margin-top: 1 cm; background-color: white; color: #ef241c; border: 2px solid #ef241c; border-radius: 8px;" type="submit" class="btn btn-primary" > Log Out </button>
</form>
</center>
</body>
</html>