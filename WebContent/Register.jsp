<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css" integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9" crossorigin="anonymous">
<style type="text/css">
  <%@include file="css/bootstrap.min.css" %>
  <%@include file="css/styles.css" %>
</style>
<script type=”text/javascript”
 src=”WebContent/bootstrap/js/bootstrap.min.js”></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Register Form</title>
</head>
<body>
	<h1>Registration          <i class="fas fa-user-plus"></i></h1>
	<form action="registerCustomer" method="post">
<div class="form-group">
    <label for="Name">Name</label>
		<input type="name" class="form-control" id="" name="name" placeholder="Enter Name" >
		</div>
<div class="form-group">
    <label for="Email">Email Address</label>
		<input type="email" class="form-control" id="" name="email" placeholder="Enter Email" >
		</div>
		<div class="form-group">
    <label for="Password">Password</label>
		<input name="password" type="password" class="form-control" id="" placeholder="Enter Password">
		</div>
		<div>
		<input type="submit" value="Submit" class="btn btn-primary">
		
		</div>
	</form>
	<a href="/MyCaseStudy/main">Cancel</a>
</body>
</html>