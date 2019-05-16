<%-- 
    Document   : profile
    Created on : May 8, 2019, 7:30:17 PM
    Author     : Rishav Saxena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <center>
        <h1>Update Profile for ${email}</h1>
        <!--<h1>Hello World!</h1>-->
            <form action='UpdateProfile' method='post'>
                Name&nbsp;&nbsp;:&nbsp;&nbsp;<input type='text' name='uname'><br><br>
                Age&nbsp;&nbsp;:&nbsp;&nbsp;<input type='number' name='age'><br><br>
                Address&nbsp;&nbsp;:&nbsp;&nbsp;<input type='text' name='address'><br><br>
                Email&nbsp;&nbsp;:&nbsp;&nbsp;<input type='text' name='email'><br><br>
                Password&nbsp;&nbsp;:&nbsp;&nbsp;<input type='password' name='pass'><br><br>
                <input type='submit' value='Update Profile'><br><br>
            </form>
        <form action='DeleteAccount' method="get">
                <input type='submit' value='Delete Account'><br><br>
            </form>
            <button onclick="window.location.assign('account.jsp')">Cancel</button>
            
        </center>
    </body>
</html>
