<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>navbar</title>
<%@include file="css.jsp"%>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-warning">
		<a class="navbar-brand" href="index.jsp" >Student Management System</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link font-weight-bold" href="index.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item font-weight-bold"><a class="nav-link" href="addStudent.jsp">Add Student</a></li>
				
			</ul>
			
		</div>
	</nav>

</body>
</html>