<%-- 
    Document   : index
    Created on : Apr 12, 2022, 11:11:45 PM
    Author     : namng
--%>

<%@page import="vn.aptech.entity.Book"%>
<%@page import="vn.aptech.dal.BookDal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Index Page</h1>
        <h1>Book List</h1>
        <table>
            <tr>
                <th>BookCode</th>
                <th>Title</th>
                <th>Price</th>
                <th>Publisher</th>
            </tr>
            <%
                BookDal dal=new BookDal();
                for(Book item:dal.getAll()){            
                %>
            <tr>
                <td><%= item.getBookCode()%></td>
                <td><%= item.getTitle() %></td>
                <td><%= item.getPrice() %></td>
                <td><%= item.getPublisher() %></td>
            </tr>
            <% 
                }
            %>
        </table>
    </body>
</html>
