<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
	   
	#background {
	  width: 77%;
	  height: 550px;
	  background: 
	    linear-gradient(to right, #D38370, rgba(255, 255, 255, 0)),
	    url('./photos/maldives.avif') center/cover no-repeat;
	  align-items: center;
	  justify-content: center;
	  border: 1px solid #D38370;
	  
	  border-radius:10px
	}
    h1{
    text-align:center;
    }
    
    button{
    border: 1px solid #D38370;
    border-radius:50px;
    background-color:skyblue;
    padding:10px;
    }
    
    button:hover{
    background-color:white;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    }
    img{
    border: 1px solid #D38370;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
	border-radius:10px
    }
    </style>
</head>
<body>
	<jsp:include page="./pages/header.jsp"/>
	<div style="display:flex; background-color: #D38370; padding:20px 0;">
		<div style=" font-family: Arial, sans-serif; padding:20px 40px;">
			<p style="color: white;	font-size: 40px; font-weight:bold;">AGNOM</p>
			<p style="font-size:20px;color:white;"><i>A place to stay.<br> For individual and family.</i></p>
		</div>
		<div id="background">
		</div>
	<br>
	</div>
	<div style="background-color:#9C2E42; padding: 20px;">
	<br>
		<h1 style="color:white;">Book the rooms in best price.</h1>
		<div style="display:flex; padding:30px">
			<div style="padding:20px; flex:1;">
				<img src="./photos/luxuryroom.avif" alt="demoPage" height=460 width=100%/>
			</div>
			<div style="text-align: center; flex:1;">
				<br>
			    <img src="./photos/classic_room.jpg" alt="demoPage" height=400 width=100%/>
			    <br><br>
			<a href="${pageContext.request.contextPath}/ProductServlet" style="text-decoration: none; color: white;"><button>BOOK NOW</button></a>
			</div>
		</div>
	</div>
<jsp:include page="./pages/footer.jsp"/>
