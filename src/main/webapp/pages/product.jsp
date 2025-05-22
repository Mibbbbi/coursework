<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
	background-color:#9C2E42;
	}
	.itemsflex{
	display:flex;
	flex-wrap: wrap;
	gap: 10px;
	}
	
	.flex-container{
	margin:auto;
	width:20%;
	box-sizing: border-box;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
	text-align:center;
	padding:10px;
	background-color:#D38370;
	}
	
	form button{
		padding:10px 30px;
		font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
		border: 1px solid black;
		border-radius:5%;
		
	}
	form button:hover{
		background-color:#C0BCC7;
	}
	a {
	text-decoration:none;
	}
	a button{
	border: 1px solid grey;
	border-radius: 10px;
	padding:5px 10px;
	}
	a button:hover{
	background-color:cyan;
	cursor:pointer;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<div style="display: flex; width: 100%; padding-left:0%; font-size: 20px;background-color:#D38370;">
  
  		<h1 style="text-align: center; flex: 1;">Rooms</h1>
  
  		<form action="SearchServlet" method="get" style="display: flex; align-items: center; gap: 10px; flex:2;">
    		<input type="text" name="searchWord" placeholder="Search..." style="width: 400px; height:30px; padding-left:20px">
    		<button type="submit">Search</button>
  		</form>
  
	</div>

    <br>
	
	
	<div class="itemsflex">
		<c:forEach var="product" items="${products}">
			<c:set var="roomID" value="${product.getRoomID()}"/>
			  <div class="flex-container">
			 
			  <img src="${product.getImage_path()}" alt="room pic" width="100%" height="200px"/>
			  <p>${product.getRoomID()}</p>
			  <p>${product.getCategory()}</p>
			  <p>Rs.${product.getPrice()}</p>
			  <c:choose>
					<c:when test="${product.getStatus()=='Available'}">
						<p style="color:#6FF35C;">o ${product.getStatus()}</p>
					</c:when>
					<c:otherwise>
						<p style="color:#9C2E42;">o ${product.getStatus()}</p>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty sessionScope.loggedInUser}">
						<a href="${pageContext.request.contextPath}/ProductServlet?param1=${roomID}">
						<button type="button"><b>View</b></button>
						</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/pages/login.jsp">
						<button type="button"><b>View</b></button>
						</a>
					</c:otherwise>	
				</c:choose>
			  </div>
		</c:forEach>
	</div>
	<br>
<jsp:include page="footer.jsp"/>