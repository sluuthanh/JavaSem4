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
        <title>Update</title>
    </head>
    <body>
        <h1>Update Student</h1>
        <form action="Controller" method="post">
            <input type="hidden" name="id" value="${student.id}">
            <table>
                <tr>
                    <td>Name </td>
                    <td><input name="name" value="${student.name}"/></td>
                </tr>
                <tr>
                    <td>Email </td>
                    <td><input name="email" value="${student.email}"/></td>
                </tr>
                <tr>
                    <td>Gender </td>
                    <td>
                        <select name="gender">
                            <option value="True" ${student.gender ? 'selected':''}>Male</option>
                            <option value="False" ${student.gender ? '':'selected'}>Female</option>
                        </select>
                    </td>
                </tr>
                 <tr>
                     <td><input type="submit" name="action" value="Update"/></td>
                     <td> </td>
                </tr>
            </table>
        </form>
    </body>
</html>
