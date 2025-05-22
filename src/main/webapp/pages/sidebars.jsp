<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        #adminD {
            display: flex;
            font-family: Arial, sans-serif;
            min-height: 100vh;
            background-color: #f4f4f4;
        }
        .sidebar {
            width: 220px;
            background: #2c3e50;
            color: #ecf0f1;
            padding: 20px;
        }
        .sidebar h2, .sidebar h3 {
            color: white;
        }
        .sidebar h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        .sidebar a {
            display: block;
            color: #ecf0f1;
            text-decoration: none;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 4px;
        }
        .sidebar a:hover {
            background-color: #34495e;
        }
        .main-content {
            flex-grow: 1;
            padding: 20px;
        }
        .header {
            background: #fff;
            padding: 15px 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .card {
            background: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 6px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div id="adminD">
        <div class="sidebar">
            <c:choose>
                <c:when test="${sessionScope.loggedInUser.role == 'Admin'}">
                    <h2>Admin Panel</h2>
                    <p style="padding: 15px; background-color: #dff0d8; color: #3c763d;">Admin Dashboard</p>
                    <h3><a href="userProfile.jsp">Profile</a></h3>
                    <h3><a href="booking.jsp">Bookings</a></h3>
                    <h3><a href="manageUsers.jsp">Manage Users</a></h3>
                    <h3><a href="reports.jsp">Reports</a></h3>
                </c:when>
                <c:when test="${sessionScope.loggedInUser.role == 'user'}">
                    <h2>User Panel</h2>
                    <p style="padding: 15px; background-color: #d9edf7; color: #31708f;">User Dashboard</p>
                    <h3><a href="userProfile.jsp">Profile</a></h3>
                    <h3><a href="booking.jsp">Bookings</a></h3>
                    <h3><a href="${pageContext.request.contextPath}/BookingDetailsServlet">Past Bookings</a></h3>
                    <h3><a href="support.jsp">Support</a></h3>
                </c:when>
                <c:otherwise>
                    <h2>Guest</h2>
                    <p style="padding: 15px; background-color: #f2dede; color: #a94442;">Not Logged In</p>
                    <h3><a href="login.jsp">Login</a></h3>
                    <h3><a href="register.jsp">Register</a></h3>
                </c:otherwise>
            </c:choose>
        </div>


    </div>
   
</body>
</html>
