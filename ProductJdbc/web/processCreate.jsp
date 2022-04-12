<%-- 
    Document   : processCreate
    Created on : Apr 1, 2022, 3:13:28 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="product" class="vn.aptech.entity.Product" scope="request"/>
        <jsp:setProperty name="product" property="*"/>
        <jsp:forward page="Controller?action=CreateProduct"/>
    </body>
</html>
