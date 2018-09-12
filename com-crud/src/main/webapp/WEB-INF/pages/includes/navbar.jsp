<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">Spring MVC</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="homePage">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="viewUsers">View Users</a></li>
			<li class="nav-item"><a class="nav-link" href="myProfile">Profile</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> More </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
		<c:url value="/logout" var="logoutUrl" />
		<form id="logout" action="${logoutUrl}" method="post">
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		  <button type="submit" style="margin-left: 10px;" class="btn btn-sm btn-outline-danger"
		  data-toggle="tooltip" title="Logout">Logout</button>
		</form>
<!-- 		<a href="logout" style="margin-left: 10px;" 
			class="btn btn-sm btn-outline-danger" data-toggle="tooltip" title="Logout"> 
			<span class="glyphicon glyphicon-log-out"></span>Logout
		</a> -->
	</div>
</nav>

<style>
nav {
	box-shadow : 0 4px 8px 0 rgba(0, 0, 0, 0.05), 0 1px 1px 0 rgba(0, 0, 0, 0.1);
	}
</style>