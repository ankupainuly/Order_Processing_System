<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 
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
<body background="Blue.jpg">

<a href="EmployeeOrderManagement.jsp" class="previous round">&#8249;</a><!-- EMployee -->
<a style="position:absolute;right:10px;" class="previous round" href="LogoutServlet">Log Out</a>
<!-- <a href="#" class="next round">&#8250;</a> -->

<h1>Your Approved Orders</h1>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
		
<table class="table table-hover table-dark" id = "Table">
  <thead>
    <tr>
    <th scope="col">ORDERID</th>
      <th scope="col">DATE</th>
      <th scope="col">TOTAL VALUE</th>
      <th scope="col">SHIPPING COST</th>
      <th scope="col">SHIPPING AGENCY</th>
      <th scope="col">STATUS</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
 <core:forEach items = "${orderKey}" var = "u">
 	<tr> 
     <td> ${u.orderId}</td>
      <td>${u.date}</td>
      <td>${u.totalValue}</td>
      <td>${u.shippingCost}</td>
      <td>${u.shippingAgency}</td>
      <td>${u.status}</td>
       <td>
     
     
    <!--THIS BLOCK IS FOR INVOICE GENERATION  -->
     
      <!-- <form name="" method="post" action="FetchInvoiceDetails">
           <input type="hidden" name="orderId" value="${u.orderId}">
      <input type="submit" value ="Invoice">
      </form>
      </td> -->
   
    <!--THIS BLOCK IS FOR INVOICE GENERATION  -->
   
    </tr>
</core:forEach>
    </tbody>
    </table>
  
</body>
</html>