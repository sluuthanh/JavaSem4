<%-- 
    Document   : Update
    Created on : Mar 28, 2022, 8:15:03 PM
    Author     : Administrator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Student</h1>
     
        <form action="Controller" method="post">
            <input type="hidden" name="id" value="${student.id}">
            <div>Name: <input name="name" value="${student.name}"/></div>
            <div>Email: <input name="email" value="${student.email}"/></div>
            <div>Gender:
                <label><input type="radio" name="gender" value="true" ${student.gender ? 'checked':''} />Male</label>
                <label><input type="radio" name="gender" value="false" ${student.gender ? '':'checked'}/>Female</label>
            </div>
            <div><input type="submit" name="action" value="Update" /></div>
        </form>
       
    </body>
</html>
