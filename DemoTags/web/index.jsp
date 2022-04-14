<%-- 
    Document   : index
    Created on : Apr 13, 2022, 2:22:54 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytags" prefix="mt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Index</h1>
        <h4><mt:HelloTag /></h4>
        <h4><mt:WelcomeTag name="Sang"/> </h4>
        <h3><mt:WelcomeNTimesTag n="3">My class is T12009A0</mt:WelcomeNTimesTag></h3>
    </body>
</html>
