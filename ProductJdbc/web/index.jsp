<%-- 
    Document   : index
    Created on : Apr 1, 2022, 4:16:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="vn.aptech.entity.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h3><a href="create.jsp">Create new</a></h3>
        <form action="Controller" method="get">
            Name: <input name="name"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <h1>Product List</h1>
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Product> products =  (List<Product>) request.getAttribute("products");
                    if(products.size()>0){
                    for(Product item:products)
                    {        
                %>
                <tr>
                    <td><%= item.getId()%></td>
                    <td><%= item.getName()%></td>
                    <td><%= item.getPrice()%></td>
                    <td><a href="Controller?action=ShowUpdate&id=<%= item.getId()%>">Update</a> </td>
                </tr>
                  <%}
                   }else{
                  %>
                   <tr>
                       <td colspan="4">No Data</td>
                   </tr>
                
                    <%}%>
            </tbody>
        </table>
    </body>
</html>
