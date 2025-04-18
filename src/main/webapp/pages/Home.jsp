<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
<c:choose>
    <c:when test="${empty sessionScope.loggedInUser}">
        <h1>Welcome, Guest!</h1>
        <p><a href="login.jsp">Login here</a></p>
    </c:when>
    <c:otherwise>
        <h1>Welcome, ${sessionScope.loggedInUser.username}!</h1>
        <p>Your role is: ${sessionScope.loggedInUser.role}</p>
        <p><a href="login.jsp">Logout</a></p>
    </c:otherwise>
</c:choose>
</body>
</html>
</body>
</html>
