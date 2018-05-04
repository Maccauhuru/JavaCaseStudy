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

<title>Login Page</title>
</head>
<body>
	<%@ page import="com.perscholas.my_case_study.models.Customer" %>
	<% if (request.getAttribute("currentUser") != null) {%>
	<% Customer c = (Customer)request.getAttribute("currentUser"); %>
	<h1>Welcome <%=  c.getName()%></h1>
	<%} %>
	
	<h1>Login Page     <i class="far fa-id-badge"></i></h1>
	<form action="login" method="post">
    <div class="form-group">
    <label for="exampleInputEmail1">Email Address</label>
		<input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="example@mail.com" width=60 >
		</div>
		<div class="form-group">
    <label for="exampleInputPassword1">Password</label>
		<input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" width=60 >
		</div>
		<div>
		<input type="submit" value="Submit" class="btn btn-primary">
			
		</div>
	</form>
		<% if (request.getAttribute("validation") != null) {%>
		<p><%= request.getAttribute("validation") %></p>
		<% } %>
		<div><span>
		<a href="/MyCaseStudy/newCustomerForm">Register</a><br>
		<a href="#">Forgotten Password?</a>
		</span>
		</div>
		
</body>
</html>