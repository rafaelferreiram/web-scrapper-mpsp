<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>MPSP - Scrapper System</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
	 <link href="/css/Style.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				MPSP - Scrapper System<br>
			</h2>
			<p>To enter the system enter your credentials.</p>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form method="POST" action="${contextPath}/login"
					class="form-signin">
					<div class="form-group">
						<label>Username</label> <input type="text" name="username"
							class="form-control" placeholder="your username">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							class="form-control" placeholder="your super secret password">
					</div>
					<button type="submit" class="btn btn-black">Login</button>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>