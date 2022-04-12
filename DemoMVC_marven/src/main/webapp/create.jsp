<%-- 
    Document   : create
    Created on : Apr 4, 2022, 4:58:30 PM
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
        <h1>Create new Product</h1>
        <form action="Controller" method="post">
            <div>Name: <input name="name"/>
            <div>Price: <input  name="price"/>
            <div><input type="submit" name="a" value="Create"/></div>
        </form>
    </body>
</html>
