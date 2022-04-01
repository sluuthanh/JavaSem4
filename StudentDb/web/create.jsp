<%-- 
    Document   : create
    Created on : Mar 28, 2022, 3:48:11 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <h1>Create Student</h1>
        <form action="Controller" method="post">
            <div>Name: <input name="name"/></div>
            <div>Email: <input name="email"/></div>
           <div>Gender:
                <label><input type="radio" name="gender" value="1" checked>Male</label>

                <label><input type="radio" name="gender" value="0">Female</label>
            </div>
            <div><input type="submit" name="action" value="Create" /></div>
        </form>
    </body>
</html>
