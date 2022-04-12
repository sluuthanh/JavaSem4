<%-- 
    Document   : index
    Created on : Apr 4, 2022, 4:37:32 PM
    Author     : Administrator
--%>

<%@page import="vn.aptech.entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h3><a href="Controller?a=display-create">Create New</a></h3>
        <h1>Product List</h1>
        <table>
            <thead>
                <tr>
                    <td>No.</td>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <%
                    int c = 1;
                    List<Product> products = (List<Product>)request.getAttribute("products");
                    for (Product item:products){
                    pageContext.setAttribute("item",item);
                %>
                <tr>
                    <td><%= c++ %></td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><a href="#"></a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
