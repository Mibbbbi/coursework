<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <style>
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background-color: #9C2E42;
            padding: 50px;
        }

        .UserDetails {
            width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0,0,0,0.1);
        }

        .UserDetails p:first-child {
            font-size: 1.4em;
            font-weight: 600;
            margin-bottom: 5px;
        }

        .UserDetails p:nth-child(2) {
            font-size: 1.2em;
            margin-bottom: 20px;
        }

        form label {
            display: block;
            
            font-weight: 600;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            font-size: 1em;
            border-radius: 6px;
            border: 1px solid #bbb;
            box-sizing: border-box;
        }

        .choosetype {
            display: flex;
            gap: 30px;
            margin-top: 10px;
            padding-left: 0;
        }

        .choosetype li {
            list-style: none;
            display: flex;
            align-items: center;
        }

        .choosetype input[type="radio"] {
            margin-right: 8px;
        }

        button {
            margin-top: 25px;
            padding: 12px 40px;
            font-size: 1em;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            margin: 15px auto;
            display: block;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

     <form class="id" method="post" action="${pageContext.request.contextPath}/issueServlet">
        <jsp:include page="header.jsp"/>
		<br>
    	<div class="UserDetails">
	        <p>Hello ${sessionScope.loggedInUser.firstname}</p>
	        <p>Please fill the following to submit your inquiry.</p>
	        <br>
        
        	<c:if test="${not empty errorMessage}">
    		<div style="color:red;">${errorMessage}</div>
			</c:if>

			<c:if test="${not empty successMessage}">
    		<div style="color:green;">${successMessage}</div>
			</c:if>
	
            <label>Submission Type</label>
       
            <ol class="choosetype">
                <li>
                	<input type="hidden" name="user_id" value="${sessionScope.loggedInUser.getId()}">
                    <input type="radio" id="feedback" name="type" value="feedback">
                    <label for="feedback">Feedback</label>
                </li>
                <li>
                    <input type="radio" id="issue" name="type" value="issue">
                    <label for="issue">Issue</label>
                </li>
            </ol>

            <label for="room_id">Room ID:</label>
            <input type="text" name="room_id" id="room_id">

            <label for="description">Description</label>
            <textarea id="description" name="description" rows="7	"></textarea>

            <button type="submit" name="submit" value="submit">Submit</button>
   		</div>
     </form>
</body>
</html>
