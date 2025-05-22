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
    body {
        height: 100%;
        margin: 0;
        display: flex;
        flex-direction: column;
        background-color:#D38370;
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
    

    .card {
      width: 75%;
      margin: 20px auto;
      padding: 20px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      border-radius: 12px;
      background-color: #ffffff;
      font-family: Arial, sans-serif;
      padding:auto;
      }
    table{
    font-size:20px;
    font-family:"Courier New", monospace;
    margin:auto;
    }
    td{
   	padding:5px;
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


<jsp:include page="sidebars.jsp"/>
<main>
	<c:choose>
	<c:when test="${not empty currentBooking}">
		<div class="card">
	  		<h2>Currently Booked Room</h2>
	  		<form action="ClockInOutServlet" method="post">
		  		<table>
		  		<tr>
		  		<td>Room:</td>
		  		<td>${currentBooking.room_id}</td>
		  		<td>Price(day)</td>
		  		<td>Rs.${currentBooking.price}</td>
		  		</tr>
		  		<tr>
		  		<td>Booked at:</td>
		  		<td>${currentBooking.book_date}</td>
		  		<td>Booking end at:</td>
		  		<td>${currentBooking.expire_date}</td>
		  		</tr>
		  		<tr>
		  		<td>Last check in:</td>
		  		<td>${currentBooking.clockIn_date}</td>
		  		</tr>
		  		<tr>
		  		<td><input type="hidden" name="bookingID" value="${currentBooking.booking_id}"/></td>
		  		<td  style="text-align:left;"><button type="submit" name="action" value="checkin" title="Click to confirm entrance">Check In</button></td>
		  		<td  style="text-align:right;"><button type="submit" name="action" value="checkout" title="Click to confirm end booking" onclick="return confirm('Are you sure to want remove your booking?')">Check Out</button></td>
		  		<td></td>
		  		</tr>
		  		</table>
	  		</form>
	  		<p style="color:red;text-align:center;font-size:13px;">Note:No refunds for early check out!.</p>
		</div>
	</c:when>
	<c:otherwise>
	<div style="display:flex; align-items:center; justify-content:center; gap:20px;">
		<h3>No booked room right now</h3>
		<a href="${pageContext.request.contextPath}/ProductServlet"><button type=button>Book now</button></a>
	</div>
	</c:otherwise>
	</c:choose>
    <br>
    <h2 style="text-align:center;">Past Bookings</h2>
    <form action="${pageContext.request.contextPath}/BookingDetailsServlet" method="get">
	<div class="date-flex">
	<label for="sDate"> Start Date:</label>
	<input type="date" name="sDate" id="sDate">
	<label for ="eDate">  End Date:</label>
	<input type="date" name="eDate" id = "eDate">
	<input type="hidden" value="${ sessionScope.loggedInUser.id	}">
	<button type="submit" value="Submit">Submit</button>
	</div>
		
    </form>
    <div class="table-container">
        <div class="table-header">
            <div class="table-cell">Booking ID</div>
            <div class="table-cell">Room ID</div>
            <div class="table-cell">Booked Date</div>
            <div class="table-cell">No of Days</div>
            <div class="table-cell">Cost</div>
        </div>

        <c:forEach var="booking" items="${bookings}">
            <div class="table-row">
                <div class="table-cell">${booking.getBooking_id()}</div>
                <div class="table-cell">${booking.getRoom_id()}</div>
                <div class="table-cell">${booking.getBook_date()}</div>

                
                <c:set var="bookDate" value="${booking.getBook_date()}" />
                <c:set var="expireDate" value="${booking.getExpire_date()}" />

                <c:if test="${not empty bookDate and not empty expireDate}">
                    <c:set var="bookDateInMillis" value="${bookDate.time}" />
                    <c:set var="expireDateInMillis" value="${expireDate.time}" />

                    <c:set var="daysBetween" value="${(expireDateInMillis - bookDateInMillis) / (1000 * 60 * 60 * 24)}" />
                    <div class="table-cell">${daysBetween}</div>
                </c:if>
            	<div class="table-cell">${booking.getPrice()}</div>
            </div>
        </c:forEach>
    </div>
</main>
</div>
<jsp:include page="../footer.jsp"/>

