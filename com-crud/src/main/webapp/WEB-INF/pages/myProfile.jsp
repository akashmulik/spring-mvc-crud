 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<title>Profile</title>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- JS and CSS ref -->
<link rel="stylesheet" href="resources/static/css/viewUsers.css"/>
<script src="resources/static/js/viewUsers.js"></script>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div class="container-fluid">
		<h1>Profile Page</h1>
	</div>
</body>
</html>