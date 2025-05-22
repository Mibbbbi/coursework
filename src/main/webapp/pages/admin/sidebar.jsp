<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Open Sans', sans-serif;
	background-color: #f0f2f5;
}
 .adminD {  
 			margin-top:50px;
            display: flex;
            font-family: Arial, sans-serif;
            min-height: 100vh;
            background-color: #f4f4f4;
        }
.sidebar {
    
    height: 100vh; 
    position:sticky; 
    width: 220px;    
    top: 20px;
    left: 0;
    background-color: #fff;
    box-shadow: 2px 0 5px rgba(0,0,0,0.1);
    padding: 20px;
   
}
.sidebar h2 {
	font-size: 18px;
	font-weight: 600;
	margin-bottom: 20px;
	text-align: center;
	width: 100%;
	border-bottom: 1px solid #ccc;
	padding-bottom: 15px;
	color: #1f1b31;
}

.links {
	list-style: none;
	padding: 0;
	width: 100%;
}

.links li {
	width: 100%;
	margin-bottom: 15px;
}

.links a {
	text-decoration: none;
	color: #2e3a59;
	display: flex;
	align-items: center;
	padding: 10px 15px;
	border-radius: 8px;
	transition: background-color 0.3s ease;
}

.links a .material-icons {
	margin-right: 10px;
	font-size: 20px;
	color: #888;
}

.links a:hover {
	background-color: #8d7fa6;
	color: #ffffff;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

.links a:hover .material-icons {
	color: #ffffff;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="adminD">
	<div class="sidebar">
		<h2>Dashboard</h2>
		<ul class="links">
		 <c:choose>
		 <c:when test="${sessionScope.loggedInUser.role=='Admin' }">
		 	<li><a href="${pageContext.request.contextPath}/AdminDashboardServlet"><span class="material-icons">dashboard</span>Overview</a></li>
			<li><a href="${pageContext.request.contextPath}/pages/admin/adminProfile.jsp"><span class="material-icons">person</span>Profile</a></li>
			<li><a href="${pageContext.request.contextPath}/ManageRoomServlet"><span class="material-icons">meeting_room</span>Manage
					Rooms</a></li>
			<li><a href="${pageContext.request.contextPath}/AddUserServlet"><span class="material-icons">manage_accounts</span>Add Staff</a></li>
			<li><a href="${pageContext.request.contextPath}/RemoveStaffServlet?userName=${sessionScope.loggedInUser.username}"><span class="material-icons">badge</span>Remove
					Staff</a></li>
			<li><a href="${pageContext.request.contextPath}/issueServlet"><span class="material-icons">report_problem</span>Issues</a></li>
			<li><a href="${pageContext.request.contextPath}/AdminDashboardServlet?dets='getsdets'"><span class="material-icons">menu_book</span>Past Bookings</a></li>
			
		 
		 
		 </c:when></c:choose>
		

		</ul>
	</div>