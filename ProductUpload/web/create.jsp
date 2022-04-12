<%-- 
    Document   : create
    Created on : Apr 12, 2022, 4:40:40 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <!--nap locate tieng anh-->
        <fmt:setLocale value="en_US"/>
        <c:if test="${param.lang=='vi'}">
            <fmt:setLocale value="vi_VN"/>
        </c:if>
        <!--nap tap tin resourse .properties-->
        <fmt:setBundle basename="vn.aptech.lang.create" var="bnd" />
        <h4>Current Date: <fmt:formatDate dateStyle="full" value="<%= new java.util.Date() %>"/></h4>
        <h1><fmt:message key="create_product" bundle="${bnd}"/></h1>
        <form action="Create" method="POST" enctype="multipart/form-data">
            <table border="1">
                <tr>
                    <td><fmt:message key="name" bundle="${bnd}"/>: </td>
                    <td><input name="name"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="price" bundle="${bnd}"/>: </td>
                    <td><input name="price"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="image" bundle="${bnd}"/>: </td>
                    <td><input type="file" name="image"/></td>
                </tr>
                 <tr>
                     <td><input type="submit" value="<fmt:message key="create" bundle="${bnd}"/>"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
