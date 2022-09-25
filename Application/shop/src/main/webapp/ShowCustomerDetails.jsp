<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body> 
<jsp:include page="CustomerDetails.jsp" />
<br/>
<div class="container">
<table border="1">
<tr>
<td><b>ID</b></td>
<td><b>NAME</b></td>
<td><b>GST</b></td>
<td><b>ADDRESS</b></td>
<td><b>CITY</b></td>
<td><b>MAIL</b></td>
</tr>
<tr>
<td>${customer.customerid}</td>
<td>${customer.name}</td>
<td>${customer.gst}</td>
<td>${customer.address}</td>
<td>${customer.city}</td>
<td>${customer.mail}</td>
</tr>
</table>

<br/>
	<form action="ListOfProducts">
	<input type="hidden" name="customerid" id="customerid" value="${customerid.toString()}"/>
	<button type="submit">Create Quote</button>
	</form>
</div>	
</body>
</html>