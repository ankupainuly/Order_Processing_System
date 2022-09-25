<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Quote</title>
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
a:link, a:visited {
  color: white;
  }
</style>
</head>
<body background="1.jpg">
<br/>
<div class="container">
<h2>Order ID: ${orderid}</h2>
<br/>
<table border="1" style="width: 100%;">
<tr>
<td ><b>PRODUCT ID</b></td>
<td><b>PRODUCT CATEGORY</b></td>
<td><b>PRODUCT NAME</b></td>
<td><b>PRODUCT QUANTITY</b></td>
</tr>

<c:forEach items="${QuoteData}" var="quoteData"> 
<tr>

<td>${quoteData.productId}</td>
<td>${quoteData.category}</td>
<td>${quoteData.name}</td>
<td>${quoteData.quantity}</td>
</tr>

</c:forEach>

</table>
<br/>

<button><a href="ListOfProducts">Create New Quote</a></button>
<button><a href="CustomerOrderManagement.jsp">Back to Home Page</a></button>

</div>
</body>
</html>