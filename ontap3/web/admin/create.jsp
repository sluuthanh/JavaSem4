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
        <h1>Create a new Book</h1>
        <form action="ProcessServlet" method="POST">
            <table>
                <tr>
                    <td>Book code</td>
                    <td>:<input name="code"/></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td>:<input name="title"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>:<input name="price"/></td>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td>:<input name="publisher"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
