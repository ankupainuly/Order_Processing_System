<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Products</title>
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
<div class="container">
	<h2>
		<font><strong>List of Products</strong></font>
	</h2>
	<br/>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<form action="AddToCart" >

			<table border="1">
			<thead>
				<tr>
					<td><b>ID</b></td>
					<td><b>NAME</b></td>
					<td><b>PRICE</b></td>
					<td><b>CATEGORY</b></td>
					<td><b>AVAILABLE QUANTITY</b></td>
					<td><b>QUANTITY</b>
					<td><b>CONFIRM</b></td>
					
				</tr>
				</thead>
				<tbody>
						<c:forEach items="${productData}" var="productData">

							<tr>
								<td>${productData.productId}</td>
								<td>${productData.productName}</td>
								<td>${productData.productPrice}</td>
								<td>${productData.productCategory}</td>
								<td>${productData.productQuantity}</td>						
								<td><input type="number"
									name="orderQuantity" value=<c:out value="${productData.orderQuantity}"/>" min="1"
									max="${productData.productQuantity}"></input></td>
								<td><input type="checkbox" name="isSelected"
									value="<c:out value="${productData.productId}"/>"></input></td>
								<input type="hidden" name ="productPrice" value=${productData.productPrice.toString()}></input>
								<input type="hidden" name ="productCategory" value=${productData.productCategory.toString()}></input>
								<input type="hidden" name="customerid" id="customerid" value="${customerid.toString()}"/>
							</tr>
						</c:forEach>
					</tbody>
			</table>	
			<br/>		
			 <button type="submit" name="ADD" >CONFIRM QUOTE</button>
			</form>
			</table>
			</div>
		</body>
</html>