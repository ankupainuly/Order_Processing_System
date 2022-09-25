<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Verification</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
	button {
  background-color: black; /* Green */
  border: none;
  color: white;
  padding: 5px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>
</head>
<body background="1.jpg">
<br/>
<div class="container" style="justify-contenet: center">
	<h1>Customer Verification</h1>
	<form action="CustomerVerification" method="post">
	<table>
	<tr>
		<td>Customer Id &nbsp;&nbsp;</td>
		<td><input type="number" name="customerid" min ="1" required placeholder="Please enter Customer ID"></input></td>
	</tr>
	</table>
	<br/>
	<Button class="button" type="submit">Show Details </Button>${errormsg}
	</form>
</div>
</body>
</html>