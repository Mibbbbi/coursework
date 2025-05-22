<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ecf0f1;
            margin: 0;
            padding: 0;
        }
        .profile-container {
            width: 50%;
            margin: 5% auto;
            padding: 30px;
            background-color: white;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        h2 {
            text-align: center;
        }
        .profile-info {
            font-size: 18px;
            margin: 15px 0;
        }
        label {
            font-weight: bold;
        }
        input{
        width:100%;
        }
    </style>
</head>
<body>
<jsp:include page="sidebar.jsp"/>

<div class="main-content">
	<div class="profile-container">
	
	    <h2>User Profile</h2>
	    <c:if test="${not empty message}">
			<p style="color:black; text-align:center;">${message}</p>
		</c:if>
		<form  method="post" action="${pageContext.request.contextPath}/UpdateUserProfileServlet">
			
		    <div class="profile-info">
		    	<input type="hidden" name="userid" value="${sessionScope.loggedInUser.id}"/>
		        <label>First Name:</label>
		        <span>${sessionScope.loggedInUser.firstname}</span><br>
		        <input type="text" name="firstName" placeholder="New Firstname"/>
		    </div>
		
		    <div class="profile-info">
		        <label>Last Name:</label>
		        <span>${sessionScope.loggedInUser.lastname}</span><br>
		        <input type="text" name="lastName" placeholder="New Lastname"/>
		    </div>
		
		    <div class="profile-info">
		        <input type="hidden" name="role" value="${sessionScope.loggedInUser.role}"/>
		    </div>
		
		    <div class="profile-info">
		        <label>Contact:</label>
		        <span>${sessionScope.loggedInUser.phnno}</span><br>
		        <input type="text" name="contact" placeholder="New contact"/>
		    </div>
		
		    <div class="profile-info">
		        <label>Email:</label>
		        <span>${sessionScope.loggedInUser.email}</span><br>
		        <input type="text" name="email" placeholder="New email"/>
		    </div>
		    
		    <div class="profile-info">
		        <label>Username:</label>
		        <span>${sessionScope.loggedInUser.username}</span><br>
		        <input type="text" name="username" placeholder="New username"/>
		    </div>
		    <div class="profile-info">
		        <label>Password:</label>
		        <input type="password" name="password" placeholder="password"/>
		    </div>
		    <button type="submit">Update</button>
		</form>
	</div>
	<div class="profile-container">
	    	<h2> Update Password</h2><br>
	    	<form action="${pageContext.request.contextPath}/ChangePasswordServlet" method="post">
	    	<input type="hidden" name="userId" value="${sessionScope.loggedInUser.id}"/>
	    	<label>Old password:</label><br>
	    	<input type="password" placeholder="Old Password" name="oldPassword"><br><br>
	    	<label>New password:</label><br>
	    	<input type="password" placeholder="New Password"  name="newPassword"><br><br>
	    	<label>Retype new password:</label><br>
	    	<input type="password" placeholder="Confirm Password" name="confirmPassword"><br><br>
	    	<button type="submit">update</button>
	    	</form>
	</div>
	</div>
	</div>
	<jsp:include page="../footer.jsp"/>