<%@page import="com.entities.student"%>
<%@page import="com.DAO.DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<%@include file="css.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>



	<div class="container p-4 ">
		<div class="row">
			<div class="col-md-6  offset-md-3">

				<div class="card">

					<div class="card-body">
						<p class="fs-3 text-center font-weight-bold">Add Student</p>
 
                         <!-- java code -->
						<!-- if condition = to success_message defined in session object addStudent servlet-->
						<c:if test="${not empty success_message }">
							<p class="text-center text-success">${success_message}</p>
							<c:remove var="success_message" />
						</c:if>


						<!-- if condition = to error_message defined in session object addStudent servlet -->
						<c:if test="${not empty error_message }">
							<p class="text-center text-danger">${error_message}</p>
							<c:remove var="error_message" />
						</c:if>



						<form action="addStudent" method="post">

							<div>
								<label class="form-label"> Full Name </label> <input type="text"
									name="name" class="form-control">
							</div>

							<div>
								<label class="form-label"> Date of Birth </label> <input
									type="date" name="dob" class="form-control">
							</div>


							<div>
								<label class="form-label"> Qualification </label> <input
									type="text" name="qua" class="form-control">
							</div>

							<div>
								<label class="form-label"> Address </label> <input type="text"
									name="address" class="form-control">
							</div>

							<div>
								<label class="form-label"> Email </label> <input type="email"
									name="email" class="form-control">
							</div>

							<div class="text-center">
								<button type="submit" class="btn bg-dark mt-3 text-white">Add
									Student</button>
							</div>


						</form>

					</div>

				</div>


			</div>
		</div>
	</div>

</body>
</html>