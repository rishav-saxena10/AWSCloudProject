<%-- 
    Document   : signup
    Created on : May 8, 2019, 5:55:02 PM
    Author     : Rishav Saxena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Page</title>
    </head>
    <body>
        <center>
        <!--<h1>Hello Sign Up!</h1>-->
            <form action='SignUp' method='post'>
                Name&nbsp;&nbsp;:&nbsp;&nbsp;<input type='text' name='uname'><br><br>
                Age&nbsp;&nbsp;:&nbsp;&nbsp;<input type='number' name='age'><br><br>
                Address&nbsp;&nbsp;:&nbsp;&nbsp;<input type='text' name='address'><br><br>
                Email&nbsp;&nbsp;:&nbsp;&nbsp;<input type='text' name='email'><br><br>
                Password&nbsp;&nbsp;:&nbsp;&nbsp;<input type='password' name='pass'><br><br>
                <input type='submit' value='Sign Up'><br><br>
            </form>
        </center>
        <%
            
        %>
    </body>
</html>
