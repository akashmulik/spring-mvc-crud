<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

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
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Login</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
			
				<f:form action="login" modelAttribute="loginBean">
				
				<f:errors cssClass="error" />
				<%
				if("expired".equals(response.getHeader("session-info"))){
					out.print("Session expired.");
				}
				if("invalid".equals(response.getHeader("session-info"))){
					out.print("Please Login first");
				}
				if("success".equals(response.getHeader("sign-up"))){
					out.print("Signup successful");
				}
				%>
				
					<div class="form-group">
						<f:input path="email" class="text email" type="email" placeholder="Email" required="true"/>
					</div>
					
					<div class="form-group">
						<f:input path="pswd" class="text" type="password" placeholder="Password" 
						required="true" />
					</div>
					<input type="submit" value="LOGIN">
					
				</f:form>
				<p>
					Don't Have Account? <a href="signup" class="btn btn-primary btn-sm">Sign Up</a>
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
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- //main -->
</body>
</html>