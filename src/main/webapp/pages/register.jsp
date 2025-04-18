<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">User Registration</h2>

    <form action="RegisterServlet" method="post" class="row g-3 needs-validation" novalidate>
        <div class="col-md-6">
            <label for="userId" class="form-label">User ID</label>
            <input type="number" class="form-control" name="userId" required>
        </div>

        <div class="col-md-6">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" class="form-control" name="firstName" required>
        </div>

        <div class="col-md-6">
            <label for="middleName" class="form-label">Middle Name</label>
            <input type="text" class="form-control" name="middleName">
        </div>

        <div class="col-md-6">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" class="form-control" name="lastName" required>
        </div>

        <div class="col-md-6">
            <label for="contact" class="form-label">Contact</label>
            <input type="text" class="form-control" name="contact" required>
        </div>

        <div class="col-md-6">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" name="email" required>
        </div>

        <div class="col-md-6">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" name="username" required>
        </div>

        <div class="col-md-6">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" name="password" required>
        </div>

        <div class="col-12 text-center">
            <button type="submit" class="btn btn-primary">Register</button>
        </div>
    </form>

    <div class="mt-3 text-center">
        Already have an account? <a href="login.jsp">Login here</a>
    </div>
</div>

</body>
</html>