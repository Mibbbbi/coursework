<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body {
        height: 100%;
        margin: 0;
    }
    .main-content {
        flex: 1;
    }
    .card {
    background: #fff;
    height: auto;
    width: 90%;
    border-radius: 6px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
    padding:30px;
    margin:10px;
}
</style>
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main-content">
    <br>
    <div class="card">
	<h1>Report</h1>
	<c:if test="${sessionScope.role=='Admin'}">
	<c:set var="name" value="${sessionScope.loggedInUser.username}"/>
		<p>Greetings, ${name}!</p>
		<p>Thank you for your hard work. Please take your time to review this report.</p>
		<p>Least Booked Room: ${param.param1}</p>
		<p>Most Issued Room: ${param.param2}</p>
		<p>Hope this will help to improve the room management and progress.</p>
	</c:if>
    </div>
</div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>