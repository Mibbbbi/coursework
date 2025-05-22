<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
<style>
	body{
	background-color:#9C2E42;
	color:white;
	font-size:20px;
	}
	.flex{
	display:flex;
	flex-direction:row-reverse;
	padding:10px;
	margin:20px;
	border:1px solid black;
	broder-radius:10px;
		background-color:#D38370;
	
	}
	.flex-container{
		padding-left:30px;
		flex:1;
		
	}
	button{
	 width:180px;
	 height:50px;
	 color:green;
	 border-radius:50px;
	}
	button:hover{
		background-color:green;
		color:white;
	}
	h2{
	color:green;
	}
	img{
	border: 1px solid #D38370;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
	border-radius:10px;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<c:set var="roomid" value="${room.getRoomID()}"/>
	<div class="flex">
		<div class="flex-container">
			<img src="${room.getImage_path()}" alt="photo" height="300" width="500"/>
		</div>
		<div class="flex-container">
			<h1>Room number: ${room.getRoomID()}</h1>
			<h2>Currently ${room.getStatus()}</h2>
			<h3><b>Description</b></h3>
			<div style="padding:3px 0px;">
				<h3>${room.getDescription()}</h3>
			</div>
			<br>
			
		</div>	
	</div>
	<div class="flex">
		<div class="flex-container">
			<form action="${pageContext.request.contextPath}/BookRoomServlet" method="post">
    			<input type="hidden" name="roomid" value="${roomid}">
				<h4><label>Booking duration:</label></h4>
				<input type="number" name="duration" placeholder="Days" required style="height:20px;"/>
				<br>
				<br>
				<button type="submit">BOOK</button>
			</form>
		</div>
		<div class="flex-container">
		
			<h3>Price: Rs.${room.getPrice()} per day</h3>
		</div>
	</div>
	 <c:if test="${not empty successMessage}"><p style="text-align:center;">${successMesssage}</p></c:if>
	<c:if test="${not empty failedMessage}"><p style="text-align:center;">${failedMesssage}</p></c:if>
	<jsp:include page="../footer.jsp"/>
	
</body>
</html>	