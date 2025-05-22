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
            margin: 0;
            padding: 0;
        }
        .profile-container {
            width: 500px;
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
        button{
      padding: 10px 20px;
      background-color: #9C2E42; 
      color: white;
      border: none;
      border-radius: 8px;
      font-size: 15px;
      font-family: "Segoe UI", sans-serif;
      transition: background-color 0.3s ease, transform 0.2s;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    button:hover{
     	background-color: black;
    }
    </style>
</head>
<body>
<jsp:include page="sidebar.jsp"/>

	<div class="profile-container">
		<div class="main-content">

	    <h2>User Profile</h2>
	
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
	    <a href="updateProfile.jsp"><button type="button">Edit</button></a>
	</div>
</div>
</div>
<jsp:include page="../footer.jsp"/>

	