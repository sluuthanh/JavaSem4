<%-- 
    Document   : Login
    Created on : Mar 23, 2022, 1:37:52 PM
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
        <form action="ProcessLogin" method="post">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input name="username"/></td>
                </tr>
                 <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
