 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<title>Signup</title>
<%@include file="includes/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script src="<c:url value="/resources/static/plugins/jquery/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/resources/static/plugins/jquery/jquery.validate.min.js"/>"></script>
<script type="application/x-javascript" src="<c:url value="/resources/static/js/signup.js"/>">
</script>
<!-- Custom Theme files -->
<link rel="stylesheet"
	href="<c:url value="/resources/static/css/signup.css"/>"/>
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
		<h1>SignUp</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<f:form action="signup" modelAttribute="usersBean">

					<div class="form-group">
						<f:input path="name" class="text" type="text" placeholder="Name" required="true"/>
						<f:errors path="name" cssClass="error" />
					</div>
					
					<div class="form-group">
						<f:input path="email" class="text email" type="email" placeholder="Email" required="true" />
						<f:errors path="email" cssClass="error" />
					</div>
					
					<div class="form-group">
						<f:input path="pswd" class="text" type="password" placeholder="Password" 
						required="true" />
						<f:errors path="pswd" cssClass="error" />
					</div>
					
					<div class="form-group">
						<f:input path="mobile" class="text" type="number" placeholder="Mobile"
						required="true" accept="number" />
						<f:errors path="mobile" cssClass="error" />
					</div>
					
					<div class="form-group">
						<f:input path="city" class="text" type="text" name="city" 
						placeholder="City" required="true" />
						<f:errors path="city" cssClass="error" />
					</div>

					<input type="submit" value="SIGNUP">
				</f:form>
				<p>
				 	Already Have Account? <a href="login" class="btn btn-primary btn-sm">Login</a>
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







<%-- 

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Please signup</h3>
  </div>
  <div class="panel-body">
	<form:form modelAttribute="usersBean" action="signup">
	
	  <form:errors cssClass="error"/>
	  
	  <div class="form-group">
	    <form:label path="email">Email address</form:label>
	    <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" />
	    <form:errors path="email" cssClass="error" />
	  </div>
	  <div class="form-group">
	    <form:label path="name">Name</form:label>
	    <form:input path="name" type="text" class="form-control" id="exampleInputName1" placeholder="Name" />
	    <form:errors path="name" cssClass="error" />
	  </div>
	  <div class="form-group">
	    <form:label path="pswd">Password</form:label>
	    <form:input path="pswd" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
	    <form:errors path="pswd" cssClass="error" />
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
  </div>
</div>

 --%>