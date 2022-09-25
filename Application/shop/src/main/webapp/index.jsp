<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <meta charset="ISO-8859-1">
        <title>Upload JsonFile</title>
    </head>

    <body background="Blue.jpg">
        <center>
            <br><br>
            <h1 style="color:#ffffff; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, Helvetica, cursive; padding-inline-start:1cm; padding-inline-end: ;">Upload JSON File</h1>
            <form style="color:#ffffff; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, Helvetica, cursive; padding-inline-start:1cm; padding-inline-end: ;" action="UploadServletNew" enctype="multipart/form-data" method="post">
                <!--Enter File Name <input type="text" name="file_name"><br> - -->
                Select File &nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="file2" /><br><br>
                <input type="submit" value="Upload" />
            </form>

            <%
 String file_name=(String)request.getParameter("filename");
 if(file_name!=null){
 out.println(" File Uploaded Successfuly");
 }
 %>
        </center>
    </body>

    </html>