<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Customer Login</title>
    <style>
        *{
            padding:0;
            margin: 0;
            box-sizing:border-box;
        }
        body{
            background-color: rgb(219, 226, 226);
        }
        .row{
            background:white;
            border-radius:30px;
        }
        img{
            border-top-left-radius: 30px;
            border-bottom-left-radius: 30px;
        }
        .btn1{
            border: none;
            outline: none;
            height:50px;
            width: 100%;
            background-color: black;
            color:white;
            border-radius:4px;
            font-weight: bold;

        }
    </style>
  </head>
  <body background="Blue.jpg">
  	<%
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
     <section class="Form my-5 mx-5">
         <div class="container">
             <div class="row no-gutters">
                 <div class="col-lg-5">
                     <img src="Basket.png" class="img-fluid"  width = 400 px, height =450px alt="Basket">
                 </div>
                 <div class="col-lg-7 px-5 pt-5">
                     <h1 class="font-weight-bold py-3">CUSTOMER LOGIN</h1>
                     <form action="CustomerLoginServlet" method="post">
                        <div class="form-row">
                            <div class="col-lg-7">
                            <input type="text" class="form-control my-3 p-4" placeholder="Enter your Customer ID" name="customerid">
                        </div>
                        </div> 
                        <div class="form-row">
                            <div class="col-lg-7">
                            <input type="password" class="form-control my-3 p-4" placeholder="Enter your Password" name="password">
                        </div>
                        </div> 
                        <div class="form-row">
                            <div class="col-lg-7">
                            <button type="submit" class="btn1">Login</button>
                        </div>
                        </div> 
                        <p>
							<%
							String str2=(String) request.getAttribute("errormsg");
							if(str2!=null)
							{
								out.print(str2);
							}
							
							%>
							</p>
                        
                        
                     </form>

                 </div>
             </div>
         </div>
     </section>
    </body>
</html>