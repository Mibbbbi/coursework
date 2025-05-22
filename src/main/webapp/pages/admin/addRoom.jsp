<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Room Data</title>
    <style>
    	label{
    	font-size:20px;
    	}
    	
    	#formStyle{
    		border:3px solid black;
    		margin:0% 25%;
    		border-radius:5%;
    		padding:50px;
    		background-color:white;
    	}
    	button{
    	width: 50%;
    	padding:10px;
    	background-color: cyan;
    	color:black;
    	display:block;
    	text-aligh:center;
    	margin:0 auto;
    	}
    	input{
    		width:100%;
    		height:30px;
    	}
    </style>
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<div style="background-color:#2c3e50; padding:20px;">
		<div id="formStyle">
		    <h2>Add Room</h2>
		    <c:if test="${not empty successMessage}"><p style="text-align:center; color:green;">${successMessage}</p></c:if>
		    <c:if test="${not empty failedMessage}"><p style="text-align:center; color:red;">${failedMessage}</p></c:if>
		    <form action="${pageContext.request.contextPath}/AddRoomServlet" method="post" enctype="multipart/form-data">
		    
		    	<label>Room number:</label><br>
		        <input type="text" id="room_id" name="room_id"  required><br><br>
		        
		        <label>Choose The Room Category:</label>
				<div style="display:flex; width:90%">
					<input type="radio" id="tv" name="category" value="small">
					<label>Small</label><br>
					
					<input type="radio" id="laptop" name="category" value="medium">
					<label>Medium</label><br>
					
					<input type="radio" id="camera" name="category" value="large">
					<label>Large</label><br><br>
				</div>
		
		        <label>Description:</label><br>
		        <textarea id="description" name="description" rows="6" style="width: 100%;" required></textarea><br><br>
		
		        <label>Upload Image:</label><br>
		        <input type="file" id="image" name="image" accept="image/*"  required><br><br>
		
		        <label>Price:</label><br>
		        <input type="number" id="price" name="price" required><br><br>
		
		        <button type="submit">Submit</button>
	    	</form>
		</div>
	</div>
<jsp:include page="../footer.jsp"/>
