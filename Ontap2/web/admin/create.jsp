        <%-- 
    Document   : create
    Created on : Apr 13, 2022, 4:08:29 PM
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
        <h1>Create a new Glasses</h1>
        <form action="ProcessServlet" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>GlassId</td>
                    <td>:<input name="id"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>:<input name="name"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>:<input name="price"/></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td>:<input type="file" name="image"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
