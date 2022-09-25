<%@page import="java.io.PrintWriter"%>
<%@page import="com.shop.model.Employee"%>
<%@page import="com.shop.service.EmployeeProfileService"%> 	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.div {
	background-color: gray;
	width: 25%;
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>

	<%!EmployeeProfileService employeeProfileService = new EmployeeProfileService();
	Employee employee;%>
	<%
	//if session is invalidated redirect to employee login page.
		// once session is integrated we have to update code for that accordingly.
	//employee = employeeProfileService.getEmployeeDetailsById((int) session.getAttribute("empoyeeid"));

	employee = employeeProfileService.getEmployeeDetailsById(1001);
	//out.println(employee.getEmployeeid() + "\n" + employee.getName());
	%>
	<div class="div">
		<%="Welcome " + employee.getName() + ","%>
		<br>
		<%="Employee id : " + employee.getEmployeeid() + ""%>
		<br>
		<%= "last login  details"%>
		<br>
		<%= employee.getLastLoginDate() + " " + employee.getLastLoginTime()%>
		

	</div>

</body>
</html>