<%-- 
    Document   : login
    Created on : Apr 6, 2022, 4:44:20 PM
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
        <form action="Controller" method="post">
            <input type="hidden" name="a" value="login"> 
            <table >
                <tr>
                    <td>Username</td>
                    <td><input name="username"/></td>
                </tr>
                 <tr>
                    <td>Password</td>
                    <td><input name="password"/></td>
                </tr>
                <tr>
                    <td><td><input type="submit" value="Create"/></td></td>
                    <td></td>
                </tr>
            </table>

        </form>
    </body>
</html>
