<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us - Hotel Booking System</title>
<style>

body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #9C2E42;
    margin: 0;
    padding: 0;
    color: #333;
}

.container {
    margin: 30px;
    padding: 30px;
    background-color: #fff;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    border-radius: 12px;
}


.container h2 {
    color: #004080;
    font-size: 28px;
    margin-bottom: 15px;
    border-bottom: 2px solid #004080;
    padding-bottom: 10px;
}

.container h3 {
    color: #0066cc;
    margin-top: 25px;
    font-size: 22px;
}


.container p {
    font-size: 16px;
    line-height: 1.6;
    margin-bottom: 15px;
}


.container p:last-of-type {
    font-weight: 500;
}

.about-image {
    width: 100%;
    height: auto;
    border-radius: 10px;
    margin: 20px 0;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    display: block;
    margin-left: auto;
    margin-right: auto;
}

</style>
</head>
<body>
    <jsp:include page="./pages/header.jsp"/>
    <br>
    <div class="container">
        <h2>About Our Hotel Booking System</h2>

        <!-- Image inclusion -->
        <img src="${pageContext.request.contextPath}/photos/aboutUs.jpg" alt="Hotel Image" class="about-image">

        <p>Welcome to our Hotel Booking System!
         We are committed to redefining the way you search for and book accommodations by offering a seamless, efficient, and 
         intuitive platform. Whether you're planning a vacation, a business trip, or a last-minute getaway, our system is designed to
         help you find the perfect hotel quickly and easily.With a focus on reliability, security, and user satisfaction, we strive to 
         make every interaction smooth and enjoyable.</p>

        <h3>Our Mission</h3>
        <p>To revolutionize the hotel booking experience by leveraging modern web technologies to simplify the entire
         process. We aim to empower users with a platform that is not only fast and easy to use but also rich in features and support.
         By prioritizing customer needs and continuously improving our services, we seek to enhance user satisfaction and build lasting
         trust with our audience.</p>

        <h3>Contact Us</h3>
        <p>Email: support@hotelbooking.com</p>
        <p>Phone: +977 980 410 890</p>
        
    </div>

    <jsp:include page="./pages/footer.jsp"/>
</body>
</html>