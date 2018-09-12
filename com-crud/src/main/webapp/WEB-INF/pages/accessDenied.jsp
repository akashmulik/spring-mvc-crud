 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<html>
<head>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<link rel="stylesheet" href="resources/static/css/accessDenied.css"/>
</head>
<body>
	<div class="container-fluid">
		<br><br><br><br>
		<div class="text-wrapper">
			<div class="title" data-content="404">Error 403</div>
			<div class="subtitle">Oops, You don't have access to this page.</div>

		<div class="buttons">
			<a class="button" href="javascript:window.history.back()"> << Go Back</a>
		</div>
	</div>
	</div>
</body>
</html>