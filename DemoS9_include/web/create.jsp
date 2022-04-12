<%-- 
    Document   : create
    Created on : Apr 1, 2022, 3:09:32 PM
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
        <form action="processCreate.jsp" method="post">
            <div>Id: <input name="id"/></div> 
            <div>Name: <input name="name"/></div> 
            <div>Price: <input name="price"/></div> 
            <div><input type="submit" value="Create"/></div> 
        </form>
    </body>
</html>
