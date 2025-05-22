<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User details</title>
    <style>
       #userD {
            display: flex;
            font-family: Arial, sans-serif;
            min-height: 100vh;
            background-color: #D38370;
        }
        .sidebar {
            width: 200px;
            background: #2c3e50;
            color: #ecf0f1;
            padding: 15px;
           
            
        }
        h2{
        text-align:center;
        }
        h1{	
         border:2px solid white;
         border-radius:4px;
         text-align:center;
         
        }
        .sidebar a {
            display: block;
            color: #ecf0f1;
            text-decoration: none;
            padding: 5px;
            margin-bottom: 10px;
            border-radius: 4px;
        }
        .sidebar a:hover {
            background-color: white;
            color:black;
            text-decoration: none;	
        }
        .main-content {
        	
        	flex-grow:1;
            padding: 20px;
        }	
    </style>
</head>
<body>
<jsp:include page="./../header.jsp"/>
	<div id="userD">
	    <div class="sidebar">
	        <h1>User</h1>
	        <br>
	        <h3><a href="${pageContext.request.contextPath}/pages/user/userProfile.jsp">Profile</a></h3>
	        <br>
	        <h3><a href="${pageContext.request.contextPath}/BookingDetailsServlet">Booking</a></h3>
	        <br>
	    </div>