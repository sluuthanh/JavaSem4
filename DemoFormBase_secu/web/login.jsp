<%-- 
    Document   : login
    Created on : Apr 12, 2022, 3:19:49 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="j_security_check" method="POST">
            <table border="1">
                <tr>
                    <td>Username:</td>
                    <td><input name="j_username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="j_password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>

        </form>
    </body>
</html>
