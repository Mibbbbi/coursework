<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
  margin: 0;
  padding: 0;
  font-family: "Times New Roman", Times, serif;
}
button{
	cursor:pointer;
}
.navbar {
  background-color: black;
  padding: 10px 40px;
  height: 30px;
  position: relative;	
  display: flex;
  justify-content: right;
  align-items: center;
}

.nav-links {
  display: flex;
  gap: 30px;
  list-style: none;
  margin: 0;
  padding-right: 60px;
}

.nav-links li {
  font-size: 20px;
  text-align: center;	
}
.navbar img{
  width: 50px;
  border:none;
}

.nav-links a {
  transition: all 0.3s ease;
  padding: 5px 10px;
  text-decoration: none;
  color: white;
}

.nav-links a:hover {
  color: red;
  
}

/* User icon section */
.user {
  position: absolute;
  right: 20px;
  display: flex;
  align-items: center;
  gap: 15px;
  top: 10px;
}

.user img {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  object-fit: cover;
  transition: transform 0.8s;
}

.user img:hover {
  transform: scale(1.1);
  background-color: white;
  border: 1px solid white;
}

/* Dropdown menu */
.user-nav {
  display: none;
  position: absolute;
  top: 30px;
  right: 0;
  background-color: lightblue;
  padding: 5px 15px;
  list-style: none;
  margin: 0;
  border-radius: 5px;
  min-width: 160px;
  box-shadow: 0 0 10px rgba(0,0,0,0.2);
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.3s ease, visibility 0.3s ease;
  z-index: 5;
}

.user-nav li {
  margin: 10px 0;
}

.user-nav a {
  color: white;
  text-decoration: none;
  font-size: 18px;
  display: block;
  padding: 5px 10px;
  transition: 0.2s ease;
}

.user-nav a:hover {
  color: red;
  background-color: white;
  border: 1px solid white;
  border-radius: 5px;
}

/* Show dropdown on hover */

.user:hover .user-nav{
	display: block;
 	 opacity: 1;
  	visibility: visible;
}

.footer {
  background-color: #222222;
  padding: 10px 20px;
  color: white;
}
.main-footer {
  
  display: flex;
  margin: 40px;
  justify-content:center;
  
  gap: 100px;
}
.address p {
  color: #9AA6B2;
  font-size:15px;
}
.quick-links a {
  color: rgb(163, 162, 162);
  text-decoration: none;
  display: block;
  line-height: 2.1;
  font-size: 22px;
}

.customer-service p {
  color: rgb(163, 162, 162);
  line-height: 2.1;
}

.customer-service a {
  text-decoration: none;
  color: rgb(163, 162, 162);
}

.low-footer {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 10px;
}
#login{
border:solid 2px grey;
padding:3px 10px;
font-size: 20px;
color:white;
text-decoration:none;
border-radius:33%;
}
#login:hover {
  background-color: white;
  color: black;
}
</style>
</head>
<body>

<div class="navbar">
	<div style="display:flex; position: absolute; left: 0;">
		  <a href="${pageContext.request.contextPath}/Home.jsp"><img src="${pageContext.request.contextPath}/photos/movies_1.png " alt="Agnom"  /></a>
		  <p style="color:grey; font-size:20px;">Agnom</p>
	</div>
  <ul class="nav-links">
    <li><a href="${pageContext.request.contextPath}/Home.jsp">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/ProductServlet">Room</a></li>
    <li><a href="${pageContext.request.contextPath}/aboutUs.jsp">About Us</a></li>
  </ul>
  
  <div class="user">
    <c:choose>
      <c:when test="${not empty sessionScope.loggedInUser}">
        <img src="${pageContext.request.contextPath}/photos/user-icon.png" alt="User Icon" class="user-img">
        <ul class="user-nav">
          <c:choose>
            <c:when test="${sessionScope.loggedInUser.role=='Admin'}">
              <li><a href="${pageContext.request.contextPath}/AdminDashboardServlet">Dashboard</a></li>
              <li><a href="${pageContext.request.contextPath}/pages/admin/adminProfile.jsp">Profile</a></li>
              <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
            </c:when>
            <c:when test="${sessionScope.loggedInUser.role=='user'}">
              <li><a href="${pageContext.request.contextPath}/pages/user/userProfile.jsp">Profile</a></li>
              <li><a href="${pageContext.request.contextPath}/BookingDetailsServlet">Booking History</a></li>
              <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
            </c:when>
            <c:when test="${sessionScope.loggedInUser.role=='staff'}">
              <li><a href="${pageContext.request.contextPath}/pages/staff/userProfile.jsp">Profile</a></li>
              <li><a href="${pageContext.request.contextPath}/issueServlet">Issues</a></li>
              <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
            </c:when>
            
          </c:choose>
        </ul>
      </c:when>
      <c:otherwise>
        <a id="login" href="${pageContext.request.contextPath}/pages/login.jsp">Login</a>
      </c:otherwise>
    </c:choose>
  </div>
</div>

