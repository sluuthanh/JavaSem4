
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
        <h4>
            <a href="create.jsp">Create New</a>
        </h4>
        <h1>Student List</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!--su dung scriplet de hien thi du lieu dong-->
                <%
                    List<Student> students = (List<Student>)request.getAttribute("students");
                    for (Student s: students){
                    %>
                    
                     <tr>
                         <td><%= s.getId()%></td>
                         <td><%= s.getName()%></td>
                         <td><%= s.getEmail()%></td>
                         <td><%= s.isGender() ? "Male":"Female"%></td>
                         <td><a href="Controller?action=ShowUpdate&id=<%= s.getId()%>">Update</a></td>
                    </tr>
                    <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
