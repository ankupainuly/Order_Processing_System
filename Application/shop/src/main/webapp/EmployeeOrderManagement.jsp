<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.hsbc.model.Employee"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Management</title>
<!--<link rel ="stylesheet" href = "D:\WebApplications\sample_app\WebContent\bootstrap.min.css"> -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<style>
a {
	text-decoration: none;
	display: inline-block;
	padding: 8px 16px;
}

.previous:hover {
	background-color: #ddd;
	color: black;
}

.previous {
	background-color: #f1f1f1;
	color: black;
}

.next {
	background-color: #4CAF50;
	color: black;
}

.round {
	border-radius: 50%;
}
</style>

</head>
<body  background="Blue.jpg">

	<a style="position: absolute; right: 10px;" class="previous round"
		href="LogoutServlet">Log Out</a>
	<!-- <a href="#" class="next round">&#8250;</a> -->

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
	<h1>ORDER MANAGEMENT FOR EMPLOYEE</h1>
	<!-- <nav class="nav nav-pills nav-fill">
  <a class="nav-item nav-link " href="GetQuotes">PENDING ORDERS</a>
  <a class="nav-item nav-link" href="GetOrders">APPROVED ORDERS</a>
  
</nav>
 -->

	<ul class="nav nav-tabs">

		<li class="nav-item"><a class="nav-link" href="GetAllOrder">APPROVED
				ORDERS</a></li>
		<li class="nav-item"><a class="nav-link" href="CustomerDetails.jsp">NEW
				QUOTE</a></li>
		<li class="nav-item"><a class="nav-link" href="index.jsp">IMPORT PRODUCTS</a></li>

	</ul>

	<div class="jumbotron">
		<h1 class="display-4">
			Hello&nbsp;
			<c:out value="${details.getName()}" />!
			<br>
			<br> <br>
			<br>
		</h1>

		<p class="lead">Your orders managed easily</p>
		<hr class="my-4">
		<p>You can create New Quotes as well as view all Approved ones.</p>
		<p class="lead"></p>
	</div>

</body>
</html>