<%-- 
    Document   : index
    Created on : Apr 1, 2022, 2:15:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="vn.aptech.entity.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <%--
        
            <jsp:param name="n1" value="Long"/>
            <jsp:param name="n2" value="Sang"/>
       
        --%>
        <jsp:include page="header.jsp"/>
        <h1>Index</h1>
        <jsp:useBean id="p1" class="vn.aptech.entity.Product" scope="session"/>
        <jsp:setProperty name="p1" property="id" value="3"/>
        <jsp:setProperty name="p1" property="name" value="Product2"/>
         
        <%
        Product p = new Product();
        p.setId(1);
        p.setName("Product1");
        session.setAttribute("p",p);
        %>
         
      
    </body>
</html>
