<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Past Bookings</title>
<style>
    html, body {
        height: 100%;
        margin: 0;
        display: flex;
        flex-direction: column;
    }

    body {
        font-family: Arial, sans-serif;
    }

    main {
        flex: 1;
    }

    .table-container {
        width: 80%;
        margin: 30px auto;
    }

    .table-header, .table-row {
        display: flex;
        padding: 15px;
        border-bottom: 1px solid #ccc;
        align-items: center;
    }

    .table-header {
        font-weight: bold;
        background-color: #f0f0f0;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
    }

    .table-row {
        background-color: #fff;
        border-radius: 10px;
        margin-bottom: 10px;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
    }

    .table-cell {
        flex: 1;
        padding: 5px 10px;
        word-break: break-word;
    }
    .date-flex{
    display:flex;
    gap:20px;
    align-items:center;
    justify-content:center;
    }
    .date-flex input[type="date"]{
    border:2px solid blue;
    border-radius:5px;}
    .date-flex input[type="submit"]{
    background-color: #709cb4;
    color:white;
    border:1px #709cb4 solid;
    border-radius:5px;
    }
    .date-flex input[type="submit"]:hover{
    background-color: #282e47;
    
    color:white;
    border:1px blue solid;
    border-radius:5px;
    }
</style>
</head>
<body>


<jsp:include page="sidebar.jsp"/>
<main>
    <br>
    <h2 style="text-align:center;">Past Bookings</h2>
    <form action="${pageContext.request.contextPath}/AdminDashboardServlet" method="get">
	<div class="date-flex">
	<label for="sDate"> Start Date:</label>
	<input type="date" name="sDate" id="sDate">
	<label for ="eDate">  End Date:</label>
	<input type="date" name="eDate" id = "eDate">
 	
	<input type="hidden" value="getdets" name="dets">
	<input type="submit" value="Submit">
	</div>
		
    </form>
    <div class="table-container">
        <div class="table-header">
            <div class="table-cell">Booking ID</div>
            <div class="table-cell">Room ID</div>
            <div class="table-cell">Username</div>
            <div class="table-cell">Booked Date</div>
            <div class="table-cell">No of Days</div>
            <div class="table-cell">Cost</div>
        </div>

        <c:forEach var="dets" items="${bookingsdets}">
            <div class="table-row">
                <div class="table-cell">${dets.booking_id}</div>
                <div class="table-cell">${dets.room_id }</div>
                <div class="table-cell">${dets.username}</div>
                <div class="table-cell">${dets.book_date }</div>



                <c:set var="bookDate" value="${dets.book_date}"/>
                <c:set var="expireDate" value="${dets.expire_date}"/>

                <c:if test="${not empty bookDate and not empty expireDate}">
                    <c:set var="bookDateInMillis" value="${bookDate.time}" />
                    <c:set var="expireDateInMillis" value="${expireDate.time}" />

                    <c:set var="daysBetween" value="${(expireDateInMillis - bookDateInMillis) / (1000 * 60 * 60 * 24)}" />
                    <div class="table-cell">${daysBetween}</div>
                </c:if>
                <div class="table-cell">${dets.price}</div>
            </div>
        </c:forEach>
    </div>
</main>


</body>
</html>
