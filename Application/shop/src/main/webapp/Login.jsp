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

    <title>Welcome - Order Processing System</title>
    <style>
        *{
            padding:0;
            margin: 0;
            box-sizing:border-box;
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
        
      
      
      
        .face{
            position: relative;
            width: 300px;
            height: 300px;
            border-radius: 50%;
            background: yellow;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 6px 513px;
        }
        .face::before{
            content: '';
            position: absolute;
            top: 180px;
            width: 150px;
            height: 70px;
            background: red;
            border-bottom-left-radius: 70px;
            border-bottom-right-radius: 70px;
            transition: 0.5s;
    
        }
        .face:hover::before{
            top: 210px;
            width: 150px;
            height: 20px;
            background: #b57700;
            border-bottom-left-radius: 0px;
            border-bottom-right-radius: 0px;
        }
        .eyes{
            position: relative;
            top: -40px;
            display: flex;
           
        }
        .eyes .eye{
            position: relative;
            width: 80px;
            height: 80px;
            display: block;
            background: #fff;
            margin: 0 15px;
            border-radius: 50%;
        }
        .eyes .eye::before{
            content: '';
            position: absolute;
            top: 50%;
            left: 25px;
            transform: translate(-50%,-50%);
            width: 40px;
            height: 40px;
            background: black;
            border-radius: 50%;
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
                     <img src="Basket.png" class="img-fluid" width = 400 px, height =450px alt="Basket">
                 </div>
                 <div class="col-lg-7 px-4 pt-4">
                     <h1 class="font-weight-bold py-3 ">WELCOME!</h1>
                     
                        <form action="CustomerLogin.jsp">
                        
                        <div class="form-row">
                            <div class="col-lg-7">
                                
                            <button type="submit" class="btn1 my-3 p-2">Login As Customer</button>
                        </div>
                        </div> 
                    </form>
                    <form action="EmployeeLogin.jsp">
                        
                        <div class="form-row">
                            <div class="col-lg-7">
                                
                            <button type="submit" class="btn1 my-3 p-2">Login As Employee</button>
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
         
     <div class="face">
        <div class="eyes">
                <div class="eye"> </div>
                <div class="eye"> </div>
        </div>
    </div>
         
     </section>
      <script>
        document.querySelector('body').addEventListener('mousemove',eyeball);
        function eyeball(){
            var eye=document.querySelectorAll('.eye');
            eye.forEach(function(eye){
                let x=(eye.getBoundingClientRect().left)+(eye.clientWidth/2);
                let y=(eye.getBoundingClientRect().top)+(eye.clientHeight/2);
                let radian=Math.atan2(event.pageX-x,event.pageY-y);
                let rot=(radian*(180/Math.PI)*-1)+270;
                eye.style.transform="rotate("+rot+"deg)";
          
            });
        }
        
    </script>   
    </body>
</html>