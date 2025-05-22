<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
.details {
    display: flex;
    flex-wrap: wrap;
}

.card {
    background: #fff;
    height: 125px;
    width: 200px;
    border-radius: 6px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
    text-align: center;
    margin:3px;
}

.main-content {
    
    padding: 20px;
}

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

button:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>

    <jsp:include page="sidebar.jsp" />

    <div class="main-content">
        <h2>Dashboard Overview</h2>
        <br>

        <div class="details">
            <div class="card">
                <h4>Total Users</h4>
                <p>${totalUser}</p>
            </div>
            <div class="card">
                <h4>Total Revenue (Rs.)</h4>
                <p>${totalRevenue}</p>
            </div>
            <div class="card">
                <h4>Total Rooms</h4>
                <p>${totalRoom}</p>
            </div>
            <div class="card">
                <h4>Rooms Booked</h4>
                <p>${totalBooked}</p>
            </div>
        </div>

        <h3>Recent Bookings</h3>
        <table>
            <thead>
                <tr>
                    <th>Booking ID</th>
                    <th>Username</th>
                    <th>Booked Date</th>
                    <th>Cost</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dets" items="${bookingsdets}">
                    <tr>
                        <td>${dets.booking_id}</td>
                        <td>${dets.username}</td>
                        <td>${dets.book_date}</td>
                        <td>${dets.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div style="text-align: right; margin-top: 10px;">
            <form action="AdminDashboardServlet" method="get">
                <input type="hidden" name="dets" value="getdets">
                <button type="submit" class="view-more-btn">View More ></button>
            </form>
        </div>
        <h3>Unsolved Issues Bookings</h3>
        <c:set var="count" value="0"/>
        <c:forEach var="issues" items="${issues}">
        	<c:set var="solveStatus" value="${issues.solveStatus}"/>
        	<c:if test="${solveStatus=='notSolved'}">
        	<c:set var="count" value="${count + 1}" />
        	</c:if>
        </c:forEach>
        <c:choose>
        <c:when test="${count==0}">
        	<h4>All issues were solved.</h4>
        </c:when>
        <c:otherwise>
	        <table>
	            <thead>
	                <tr>
	                    <th>Booking ID</th>
	                    <th>Room ID</th>
	                    <th>Username</th>
	                    <th>IssueDate</th>
	                    <th>Solved Status</th>
	                   
	                    <th>Issue Description</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="issues" items="${issues}">
	                    <tr>
	                		<c:set var="solveStatus" value="${issues.solveStatus}"/>
	                	   <c:if test="${solveStatus=='notSolved'}">
	                        <td>${issues. bookingId}</td>
	                        <td>${issues.roomId}</td>
	                        <td>${issues.userName}</td>
	                        <td>${issues.issueDate}</td> 
	                        <td>${issues.solveStatus}</td>
	                        <td>${issues.issueDesc}</td>
	                       </c:if>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
        </c:otherwise>
        </c:choose>

        <div style="text-align: right; margin-top: 10px;">
            <form action="AdminDashboardServlet" method="get">
                <input type="hidden" name="detsissuedets" value="issuedets">
                <button type="submit" class="view-more-btn">View More ></button>
            </form>
        </div>
 	<div>
 	<c:set var="leastbookedroom" value="${leastBookedRoom}"/>
 	<c:set var="mostissuedroom" value="${mostIssuedRoom}"/>
 	<a href="${pageContext.request.contextPath}/pages/admin/report.jsp?param1=${leastbookedroom}&param2=${mostissuedroom}">
 	<button type="button">generate report</button>
 	</a>
 	</div>
    </div>

</body>
</html>