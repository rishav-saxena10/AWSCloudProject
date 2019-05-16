<%-- 
    Document   : login
    Created on : May 8, 2019, 5:54:52 PM
    Author     : Rishav Saxena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--<h1>Hello Login!</h1>-->
        <center>
        <!--<h1>Hello Sign Up!</h1>-->
            <form action='Login' method='post'>
                Email&nbsp;&nbsp;:&nbsp;&nbsp;<input type='text' name='email'><br><br>
                Password&nbsp;&nbsp;:&nbsp;&nbsp;<input type='password' name='pass'><br><br>
                <input type='submit' value='Login'><br><br>
                
            </form>
        </center>
    </body>
</html>
