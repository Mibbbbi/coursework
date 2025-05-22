<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Past Bookings</title>
<style>
    html, body {
        height: 100%;
        margin: 0;
        display: flex;
        flex-direction: column;
    }

    body {
        font-family: Arial, sans-serif;
    }

    .main-content {
        flex: 1;
    }

    .table-container {
        padding: 40px;
        width: 90%;
        margin: 30px auto;
        background-color: #ccc;
    }

    .table-header, .table-row {
        display: flex;
        padding: 15px;
        border-bottom: 1px solid #ccc;
        align-items: center;
    }

    .table-header {
        font-weight: bold;
        background-color: #f0f0f0;
    }

    .table-row {
        background-color: #fff;
        margin-bottom: 6px;
        box-shadow: 0 2px 6px #ccc;
    }

    .table-cell {
        flex: 1;
        padding: 5px 10px;
        word-break: break-word;
    }

    .submit-button-container {
        text-align: center;
        margin-top: 20px;
    }

    button {
        padding: 10px 20px;
        background-color: #3498db;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>
<jsp:include page="sidebar.jsp"/>

<div class="main-content">
    <br>
    <h2 style="text-align:center;">Past Bookings</h2>

    <div class="table-container">
        <form action="${pageContext.request.contextPath}/RemoveStaffServlet?adminUserName=${sessionScope.loggedInUser.username}" method="Post" onsubmit ="return confirm('Are  you sure you wanna remove the staff?');">
        <c:if test="${not empty errorMessage}">
        <p style="color:red;text-align:center;">${errorMessage}</p>
        </c:if>
        <c:if test="${not empty successMessage}">
        <p style="color:green;text-align:center;">${successMessage}</p></c:if>
            <div class="table-header">
                <div class="table-cell">Select</div>
                <div class="table-cell">Username</div>
                <div class="table-cell">First Name</div>
                <div class="table-cell">Last Name</div>
                <div class="table-cell">Phone No</div>
            </div>

            <c:forEach var="dets" items="${usersdets}">
                <div class="table-row">
                    <div class="table-cell"><input type="radio" name="username" value="${dets.username}" /></div>
                    <div class="table-cell">${dets.username}</div>
                    <div class="table-cell">${dets.firstname}</div>
                    <div class="table-cell">${dets.lastname}</div>
                    <div class="table-cell">${dets.phnno}</div>
                </div>
            </c:forEach>

            <div class="submit-button-container">
                <button type="submit" name="action" value="remove">Remove Staff</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
