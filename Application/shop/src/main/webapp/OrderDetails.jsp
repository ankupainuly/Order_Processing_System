<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<a href="Display.jsp" class="previous round">&#8249;</a>
<!-- <a href="#" class="next round">&#8250;</a> -->
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
<h1>ORDER DETAILS</h1>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
		
<form action = "AddProducts" method = "post"></form>	
<table class="table table-hover table-dark" id = "Table">
  <thead>
    <tr>
    <th scope="col">NAME</th>
      <th scope="col">CATEGORY</th>
      <th scope="col">PRICE</th>
      <th scope="col">QUANTITY</th>
    </tr>
  </thead>
  <tbody>
 <core:forEach items = "${listKey}" var = "u">
 	<tr> 
 	 <td> ${u.name}</td>
      <td>${u.category}</td>
      <td>${u.price}</td>
      <td>${u.quantity}</td>
    </tr>
</core:forEach>
    </tbody>
    </table>
</body>
</html>