<%-- 
    Document   : index
    Created on : Apr 6, 2022, 3:00:58 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1
        <c:set var="a" value="10"/>
        <h4>a = ${a}</h4>
        <c:if test="${a==10}">
            <h4>The value of a is ten</h4>
        </c:if>
        <c:if test="${a!=10}">
            <h4>The value of a another number</h4>
        </c:if>
        <c:choose>
            <c:when test="">
                
            </c:when>
        </c:choose>
        <h2>Demo foreach</h2>
        <c:forEach begin="0" end="10" step="1" var="n">
            <h4> n= ${n}</h4>
        </c:forEach>
        <c:set var="data" value="welcome to T12009A0"/>
        <c:forTokens items="${data}" delims=" " var="item">
            <h4>item = ${item}</h4>
        </c:forTokens>
    </body>
</html>
