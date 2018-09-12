<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<%@include file="includes/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script src="resources/static/plugins/jquery/jquery-3.3.1.js"></script>
<script src="resources/static/plugins/jquery/jquery.validate.min.js"></script>

<!-- Custom Theme files -->
<link rel="stylesheet" href="resources/static/css/signup.css"/>
<!-- //Custom Theme files -->

<!-- web font -->
<link
	href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i"
	rel="stylesheet">
<!-- //web font -->
</head>
<body>

<!-- error and success messages -->
	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<p>Invalid credentials.</p>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<p>You have been logged out successfully.</p>
		</div>
	</c:if>
	
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Login</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
			
				<form action="login" method="POST">

					<div class="form-group">
						<input name="email" class="text email" type="email" placeholder="Email" required="true"/>
					</div>
					<div class="form-group">
						<input name="pswd" class="text" type="password" placeholder="Password" 
						required="true" />
					</div>
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
					<input type="submit" value="LOGIN">
				</form>
				<p>
					Don't have account? <a href="signup" class="btn btn-primary btn-sm">Sign Up</a>
				</p>
			</div>
		</div>
		<!-- copyright -->
		<div class="w3copyright-agile">
			<p>
				© 2018 Spring MVC by Akash. All rights reserved | Design by <a
					href="https://www.techgig.com/akashmulik" target="_blank">Akash
					Mulik</a>
			</p>
		</div>
		<!-- //copyright -->
		<ul class="w3lsg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
<!-- 			<li></li>
			<li></li>
			<li></li>
			<li></li> -->
			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- //main -->
</body>
</html>