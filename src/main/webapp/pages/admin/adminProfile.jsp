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
            background-color: #D38370;
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
        
        .profile-info {
            font-size: 18px;
            margin: 15px 0;
        }
        label {
            font-weight: bold;
        }
        input{
        width:70%;
        height:20px;
        }
    </style>
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="profile-container">
	<c:if test="${sessionScope.role=='Admin'}">
	<div class="main-content">
	    <h2>Admin Profile</h2>
	
	    <div class="profile-info">
	        <label>First Name:</label>
	        <span>${sessionScope.loggedInUser.firstname}</span>
	    </div>
	
	    <div class="profile-info">
	        <label>Last Name:</label>
	        <span>${sessionScope.loggedInUser.lastname}</span>
	    </div>
	
	    <div class="profile-info">
	        <label>Contact:</label>
	        <span>${sessionScope.loggedInUser.phnno}</span>
	    </div>
	
	    <div class="profile-info">
	        <label>Email:</label>
	        <span>${sessionScope.loggedInUser.email}</span>
	    </div>
	    
	    <div class="profile-info">
	        <label>Username:</label>
	        <span>${sessionScope.loggedInUser.username}</span>
	    </div>
	    <p style="color:red">Note: admin details cannot be changed.</p>
    </div>
	</c:if>
    <hr>
    <div class="main-content">
    	<h2> Update Password</h2><br>
	    	<form action="ChangePasswordServlet" method="post">
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
</body>
</html>
	