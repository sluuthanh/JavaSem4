<%-- 
    Document   : processCreate
    Created on : Apr 1, 2022, 4:31:41 PM
    Author     : namng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="book" class="vn.aptech.entity.Book" scope="request" />
        <jsp:setProperty name="book" property="*"/>
        <jsp:forward page="ProcessServlet"/>
    </body>
</html>
