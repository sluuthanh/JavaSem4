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
        <h1>Demo output</h1>
        <jsp:useBean id="p2" class="vn.aptech.entity.Product" scope="request"/>
        <jsp:setProperty name="p2" property="*"/>
        <h3>Name: <jsp:getProperty name="p2" property="name"/></h3>
    </body>
</html>
