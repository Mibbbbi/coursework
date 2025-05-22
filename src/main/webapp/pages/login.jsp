<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

	<div id="main">
	    <div class="container">
	      <div class="login-form">
	        <form class="main-login" action="${pageContext.request.contextPath}/LoginServlet" method="post">
	          <h3>Welcome Back</h3>
	          
	          <c:choose>
	          	<c:when test="${not empty errorMessage}">
	          		<p class="login-text" style="color:white">${errorMessage}</p>
	          	</c:when>
	          	<c:otherwise>
	          		<p class="login-text">Login back to your account.</p>
	          	</c:otherwise>
	          </c:choose>
	          
	          <div class="email">
	            <label for="email">Username</label>
	            <input type="text" name="username" placeholder="Enter your username" required/>
	          </div>
	          <div class="password">
	            <label for="password">Password</label>
	            <input type="password" name="password" placeholder="Enter your password" required/>
	          </div>
	          <button type="submit" class="signin-btn">Sign In</button>
	          <p class="register">
	            Don't have an account? <a href="${pageContext.request.contextPath}/pages/register.jsp">Register now</a>
	          </p>
	        </form>
	      </div>
	
	      <div class="login-img">
	        <img src="${pageContext.request.contextPath}/photos/login.avif" alt="Login Image" />
	      </div>
	    </div>
    </div>
</body>
</html>