<%@page import="com.entities.student"%>
<%@page import="com.serviceLayer.service"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
<%@include file="css.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container p-4 ">
		<div class="row">
			<div class="col-md-6  offset-md-3">

				<div class="card">

					<div class="card-body">
						<p class="fs-3 text-center font-weight-bold">Edit Student</p>

						<!-- java code -->
						<% 
						//  this id fetching from url set index.jsp  
						int id = Integer.parseInt(request.getParameter("stu_id"));

						// fetch student object, pass id fetched from url 
						student stu = service.getStudentById(id);
						 %>

						<!-- now we wil use stu object in form values using expression tag -->
						<form action="updateData" method="post">

							<div>
								<label class="form-label"> Full Name </label> <input type="text"
									name="name" class="form-control" value=" <%=stu.getName()%> ">
							</div>

							<div>
								<label class="form-label"> Date of Birth </label> <input
									type="date" name="dob" class="form-control"
									value="<%=stu.getDob()%>">
							</div>

							<div>
								<label class="form-label"> Qualification </label> <input
									type="text" name="qua" class="form-control"
									value=" <%=stu.getQualification()%>">
							</div>

							<div>
								<label class="form-label"> Address </label> <input type="text"
									name="address" class="form-control"
									value="<%=stu.getAddress()%>">
							</div>

							<div>
								<label class="form-label"> Email </label> <input type="email"
									name="email" class="form-control" value=" <%=stu.getEmail()%> ">
							</div>

							<!-- hidden form field to get use for update particular object -->
							<!-- this id is from student object -->
							<input name="id" type="hidden" value=" <%=stu.getId()%> ">

							<div class="text-center">
								<button type="submit" class="btn bg-dark mt-3 text-white">Edit
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