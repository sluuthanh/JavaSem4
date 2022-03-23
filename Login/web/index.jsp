<%-- 
    Document   : index
    Created on : Mar 23, 2022, 1:51:20 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Login Success</h1>
        <h2>Welcome: <%= request.getAttribute("username") %>  </h2>
    </body>
</html>
