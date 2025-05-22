<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manage room</title>
<style>
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    background-color: #fff;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

table, th, td {
    border: 1px solid #ddd;
}

th, td {
    padding: 12px;
    text-align: center;
    width:100px;
}

th {
    background-color: #f4f4f4;
}

button {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}
 .card {
            background: #fff;	
            height:auto;
            border-radius: 6px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
            text-align:center;
            margin:0 10%;
            padding:30px;
        }
 
</style>
</head>
<body>
	<jsp:include page="sidebar.jsp"/>
	<c:if test="${sessionScope.role=='Admin'}">
	<div class="main-content">
	        

	        <div class="details">
				
		        <div class="card">
			        <h2>Manage Room</h2>
		        	<h3>Current rooms</h3>
		        		
		        		<table style="width:100%;">
		        			<tr>
		        				<td>Room</td>
		        				<td>Category</td>
		        				<td>Price</td>
		        				<td>Status</td>
		        				<td></td>
		        				<td></td>	
		        			</tr>
		        			<c:forEach var="room" items="${rooms}">
			        			<tr>
								<c:set var="roomID" value="${room.getRoomID()}"/>
									<td>${room.getRoomID()}</td>
									<td style="width:200px">${room.getCategory()}</td>
									<td>${room.getPrice()}</td>
								<c:choose>
								<c:when test="${room.getStatus()=='Available'}">
									<td style="color:green;">o ${room.getStatus()}</td>
								</c:when>
								<c:otherwise>
									<td style="color:red;">o ${room.getStatus()}</td>
								</c:otherwise>
								</c:choose>
								
								<td><a href="${pageContext.request.contextPath}/RemoveRoomServlet?param=${roomID}">
									<button onclick="return confirm('Are you sure to want remove ${roomID}?')">Delete</button>
									</a>
								</td>
								<td><a href="${pageContext.request.contextPath}/pages/admin/updateRoom.jsp?roomid=${roomID}">
								<button type="button">update</button>
								</a></td>
								</tr>
							</c:forEach>
		        		</table>
		        		<c:if test="${not empty successMessage}">
		        			<p style="text-align:center;">${successMessage}</p>
		        		</c:if>
		    			<c:if test="${not empty failedMessage}">
		    				<p style="text-align:center;">${failedMessage}</p>
		    			</c:if>
		    	</div>
		    	<div class="card">
					<br>
		            <h2>Add new rooms.</h2>
		            <a href="${pageContext.request.contextPath}/pages/admin/addRoom.jsp"><button type="button">Add room</button></a>
		            <br>	<br>
	        	</div>
	    </div>
	</div>
	</c:if>
</body>
</html>