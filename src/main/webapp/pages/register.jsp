<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	body{
	background: #9C2E42;
	 font-family: "Times New Roman", Times, serif;
	}
	label{
	color:white;
	font-family: sans-serif;
	font-weight: bold;
	font-size:20px;
	}
	a{
		color:cyan;
	}
	a:hover{
		color:blue;
	}
	#info{
		background-color:#D37380;
		width:70%;
		height:70%;
		margin:auto;
		padding:20px;
		border:2px solid grey;
		border-radius: 10px;
	}
</style>
</head>
<body>

<div id="info">
    <h1 class="text-center mb-4">User Registration</h1>
	<c:if test="${not empty error}">
	<p style="color:white; text-align:center;">${error}</p>
	</c:if>
	<c:if test="${not empty success}">
	<p style="color:green; text-align:center;">${success}<a href="${pageContext.request.contextPath}/pages/login.jsp">login here.</a></p>
	
	</c:if>
  <form action='${pageContext.request.contextPath}/Register' method="post" class="row g-3 needs-validation">
	

        <div class="col-md-6">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" class="form-control" name="firstName" required>
        </div>

       
        <div class="col-md-6">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" class="form-control" name="lastName" required>
        </div>

        <div class="col-md-6">
            <label for="contact" class="form-label">Contact</label>
            <input type="text" class="form-control" name="contact" required>
        </div>

        <div class="col-md-6">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" name="email" required>
        </div>

        <div class="col-md-6">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" name="username" required>
        </div>
		<div>
		</div>
        <div class="col-md-6">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" name="password" required>
        </div>
		<div class="col-md-6">
            <label for="retypepass" class="form-label">Re-enter Password</label>
            <input type="password" class="form-control" name="retypepass" required>
        </div>
        <div class="col-12 text-center">
            <button type="submit" class="btn btn-primary">Register</button>
        </div>
    </form>

    <div class="mt-3 text-center">
        <label>Already have an account?</label> <a href="${pageContext.request.contextPath}/pages/login.jsp">Login here</a>
    </div>

</div>
</body>
</html>

