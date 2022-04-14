<%-- 
    Document   : indẽ
    Created on : Apr 13, 2022, 4:34:53 PM
    Author     : Administrator
--%>

<%@page import="vn.aptech.dal.BookDal"%>
<%@page import="vn.aptech.entity.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Index</h1>
        <h4><a href="create.jsp">Create new Book</a></h4>
        <table border="1">
            <thead>
                <tr>
                    <th>Book Code</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Publisher</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                   <% 
                       BookDal dal = new BookDal();
            List<Book> books = dal.findAll();
            for(Book b:books) {
        %>
                <tr>
                    <td><%= b.getCode() %></td>
                    <td><%= b.getTitle()%></td>
                    <td><%= b.getPrice()%></td>
                    <td><%= b.getPublisher()%></td>
<%--                    <td>${b.code}</td>
                    <td>${b.title}</td>
                    <td>${b.price}</td>
                    <td>${b.publisher}</td>
                    <td>Update</td>
--%>
                </tr>
        <%
            }
        %>
               
               
            </tbody>
        </table>

     
    </body>
</html>
