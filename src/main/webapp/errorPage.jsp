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
background-color:#2c3e50;
}
div{
	background-image:url("./photos/error.png");
	background-size: cover;
	height:500px;
	width:500px;
	margin:auto;
}
button{
	border-radius:10%;
	shadow: 3px grey;
	padding:10px;
	background-color:cyan;
	font-family: Arial, sans-serif;
}
button:hover{
	background-color:White;
	box-shadow: 0 1px 3px rgba(0,0,0,0.1);
}
h1{
text-align:center;
padding:20px;
color:Cyan
}
h1:hover{
color:Green;
}
</style>
</head>
<body>
	<c:if test="${not empty error}">
		<h1>${error}</h1>
	</c:if>
	<a href="${pageContext.request.contextPath}/Home.jsp">
	<button type="button">Go back</button>
	</a>
	<div>
		
	</div>
	
</body>
</html>