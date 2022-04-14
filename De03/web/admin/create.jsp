<%-- 
    Document   : create
    Created on : Apr 12, 2022, 11:12:34 PM
    Author     : namng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create</h1>
        <form action="processCreate.jsp" method="post">
            BookCode:<input type="text" name="bookCode"/>
            Title:<input type="text" name="title"/>
            Price:<input type="text" name="price"/>
            Publisher:<input type="text" name="publisher"/>
            <input type="submit" value="Create"/>
        </form>
    </body>
</html>
