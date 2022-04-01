<%-- 
    Document   : update
    Created on : Mar 30, 2022, 4:53:02 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <h1>Create new Student</h1>
        <form action="Controller" method="post">
            <input type="hidden" name="id" />
            <table>
                <tr>
                    <td>Name </td>
                    <td><input name="name" /></td>
                </tr>
                <tr>
                    <td>Email </td>
                    <td><input name="email" /></td>
                </tr>
                <tr>
                    <td>Gender </td>
                    <td>
                        <select name="gender">
                            <option value="True" >Male</option>
                            <option value="False" >Female</option>
                        </select>
                    </td>
                </tr>
                 <tr>
                     <td><input type="submit" name="action" value="Create"/></td>
                     <td> </td>
                </tr>
            </table>
        </form>
    </body>
</html>
