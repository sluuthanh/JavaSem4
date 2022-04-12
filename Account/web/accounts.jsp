<%-- 
    Document   : accounts
    Created on : Apr 6, 2022, 4:55:19 PM
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
        <h1>Account List</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Full name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${accounts}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.username}</td>
                    <td>${item.email}</td>
                    <td>${item.fullname}</td>
                    <td>update</td>
                </tr>
                </c:forEach>
              
             
            </tbody>
        </table>

    
    </body>
</html>
