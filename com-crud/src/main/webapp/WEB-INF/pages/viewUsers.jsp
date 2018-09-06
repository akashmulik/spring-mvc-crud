 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<title>Signup</title>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- JS and CSS ref -->
<link rel="stylesheet" href="<c:url value="/resources/static/css/viewUsers.css"/>"/>
<script src="<c:url value="/resources/static/js/viewUsers.js"/>"></script>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div class="container-fluid">
		<br>
		<h3>Users Details</h3>
		<div class=" col-md-11">
			<table class="table table-responsive table-bordered stripe"
				id="usersTable"></table>
		</div>
		
		<!-- Modal -->
  <div class="modal fade" id="userModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
      <form action="signup" method="post">
        <div class="modal-header">
        <h4 class="modal-title">Edit user info</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">

					<div class="form-group">
						<input name="id" type="hidden" id="id"/>
					</div>
					
					<div class="form-group">
						<input name="name" class="text form-control" type="text" placeholder="Name" required id="name"/>
					</div>
					
					<div class="form-group">
						<input name="email" class="text email form-control" type="email" placeholder="Email" required id="email"/>
					</div>
					
<%-- 					<div class="form-group">
						<input path="pswd" class="text form-control" type="password" placeholder="Password" 
						required="true" />
						<errors path="pswd" cssClass="error" />
					</div> --%>
					
					<div class="form-group">
						<input name="mobile" class="text form-control" type="number" placeholder="Mobile"
						required accept="number" id="mobile"/>
					</div>
					
					<div class="form-group">
						<input name="city" class="text form-control" type="text" name="city" 
						placeholder="City" required id="city"/>
					</div>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-success" onclick="usersWrapper.updateUser()">Update</button>
        </div>
        </form>
      </div>
      
    </div>
  </div>
	</div>
</body>
</html>