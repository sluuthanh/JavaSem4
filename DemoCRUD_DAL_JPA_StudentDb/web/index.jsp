
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="vn.aptech.entity.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h4><a href="create.jsp">Create new</a></h4>
        <h1>Student List</h1>
        <table>
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Gender</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Student> students = (List<Student>)request.getAttribute("students");
                    for (Student item:students){
                %>
                <tr>
                    <td><%= item.getId() %></td>
                    <td><%= item.getName() %></td>
                    <td><%= item.getEmail() %></td>
                    <td><%= item.getGender() ? "Male":"Female" %></td>
                    <td>
                        <a href="Controller?action=DisplayUpdate&id=<%= item.getId() %>">Update</a>
                        <a href="Controller?action=Delete&id=<%= item.getId() %>">Delete</a>
                    </td>
                </tr>
                <%}%>
                <tr>
                    
                </tr>
                    
            </tbody>
        </table>
    </body>
</html>
