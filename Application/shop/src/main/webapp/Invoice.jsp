<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Invoice 
    <% Integer invoiceId = (Integer) request.getAttribute("invoiceId");
    	out.print(invoiceId);
    %>
    </title>
    <link rel="stylesheet" href="style.css" media="all" />
  </head>
  <body>
  <a href="Display.jsp" class="previous round">&#8249;</a>
  	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
    <header class="clearfix">
      <div id="logo">
        <img src="logo.jpg">
      </div>
      <h1>INVOICE 
      <% 
    	out.print(invoiceId);
    %>
      </h1>
      <div id="project">
        <div><span>CUSTOMER NAME</span> 
        <%String customer_name = (String) request.getAttribute("customer_name");
        	out.print(customer_name);
        %>
        </div>
        <div><span>ADDRESS</span>
        <% String address = (String) request.getAttribute("address");
        	out.print(address);
        %>
		</div>
        <div><span>EMAIL</span> 
        <%String email = (String) request.getAttribute("email");
        %>
        <a href="<% out.print(email);%>"><% out.print(email);%></a>
        </div>
        <div><span>QUOTE DATE</span> 
		<% String quote_date = (String) request.getAttribute("quote_date");
			out.print(quote_date);
		%>
		</div>
        <div><span>APPROVE DATE</span> 
        <% String approve_date = (String) request.getAttribute("invoice_date");
			out.print(approve_date);
		%>
        </div>
      </div>
    </header>
    <main>
      <table>
        <thead>
          <tr>
            <th class="service">S.NO.</th>
            <th class="desc">PRODUCT NAME</th>
            <th>PRICE</th>
            <th>QTY</th>
            <th>TOTAL</th>
          </tr>
        </thead>
        <tbody>
        <%int i=1; %>
        <core:forEach items = "${listKey}" var= "p"> 
          <tr>
            <td class="service">
            <% out.print(i);
            i++;
            %>
            </td>
            <td class="desc">${p.name}</td>
            <td class="unit" >${p.price} Rs.</td>
            <td class="qty">${p.quantity}</td>
            <td class="total">${(p.price)*(p.quantity)} Rs.</td>
          </tr>
          </core:forEach>
          <tr>
          	<td>&nbsp</td>
          	<td>&nbsp</td>
          	<td>&nbsp</td>
            <td>SUBTOTAL</td>
            <td class="total">
            <% double total_value = (Double) request.getAttribute("total_value");
            	out.print(total_value);
            %> Rs.
            </td>
          </tr>
          <tr>
          	<td>&nbsp</td>
          	<td>&nbsp</td>
          	<td>&nbsp</td>
            <td>GST 10%</td>
            <td class="total">
            <% double total_gst = (Double) request.getAttribute("total_gst");
            	out.print(total_gst);
            %> Rs.
            </td>
          </tr>
	  <tr>
            <td>&nbsp</td>
          	<td>&nbsp</td>
          	<td>&nbsp</td>
            <td>SHIPPING </td>
            <td class="total">
            <% double shippingcost = (Double) request.getAttribute("shippingcost");
            	out.print(shippingcost);
            %> Rs.
            </td>
          </tr>
          <tr>
          	<td class="grand total">&nbsp</td>
          	<td class="grand total">&nbsp</td>
          	<td class="grand total">&nbsp</td>
            <td class="grand total">GRAND TOTAL</td>
            <td class="grand total">
            <% double total_invoice_value = (Double) request.getAttribute("total_invoice_value");
            	out.print(total_invoice_value);
            %> Rs.
            </td>
          </tr>
        </tbody>
      </table>
    </main>
    <footer>
      Invoice was created on a computer and is valid without the signature and seal.
    </footer>
  </body>
</html>