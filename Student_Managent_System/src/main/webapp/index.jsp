

<%@page import="com.entities.student"%>
<%@page import="java.util.List"%>
<%@page import="com.serviceLayer.service"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.getConnection.getConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@include file="css.jsp"%>
<title>Student Management System</title>
</head>
<body class="bg-light">


	<%@include file="navbar.jsp"%>
	<!-- navbar -->

	<div class="container">
		<div class="row">
			<div class="col-md-12 mt-5">

				<div class="card">
					<div class="card-body">
						<h1 class="text-center">Student Details</h1>
						
						<!-- java code start -->
						
						<!-- this is for update student -->
						<!-- if condition = to update_success defined in session object editServlet -->
						<c:if test="${not empty update_success }">
							<p class="text-center text-success">${update_success}</p>
							<c:remove var="update_success" />
						</c:if>


						<!-- if condition = to update_error show message defined in session object editServlet-->
						<c:if test="${not empty update_error }">
							<p class="text-center text-danger">${update_error}</p>
							<c:remove var="update_error" />
						</c:if>
						
						
						
						
						<!-- this is for delete student -->
						<!-- if condition = to delete_successfull show message defined in session object delete Servlet -->
						<c:if test="${not empty delete_successfull }">
							<p class="text-center text-success">${delete_successfull}</p>
							<c:remove var="delete_successfull" />
						</c:if>


						<!-- if condition = to delete_error show message defined in session object delete Servlet-->
						<c:if test="${not empty delete_error }">
							<p class="text-center text-danger">${delete_error}</p>
							<c:remove var="delete_error" />
						</c:if>
						
						<!-- java code end -->

						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Address</th>
									<th scope="col">Email</th>
									<th scope="col">Action</th>
								</tr>
							</thead>

							<tbody>

								<%
								// using service method getAllStudent which return list from database that comes from dao layer
								List<student> students = service.getAllStudent();

								for (student items : students) {
								%>

								<tr>
									<th scope="row"><%=items.getId()%></th>
									<td><%=items.getName()%></td>
									<td><%=items.getDob()%></td>
									<td><%=items.getQualification()%></td>
									<td><%=items.getAddress()%></td>
									<td><%=items.getEmail()%></td>

									<td>
									<a href="delete?id=<%=items.getId()%>"> <i
											class="fas fa-trash-alt text-danger "></i></a>
											 &nbsp &nbsp 
									 <a href="editStudent.jsp?stu_id=<%= items.getId()%>"> <i
											class="fas fa-pen-nib text-success"></i></a></td>
								</tr>


								<%
								}
								%>

							</tbody>

						</table>

						<div class="text-center mt-5">
							<a class="btn btn-outline-success" href="addStudent.jsp">Add
								Student</a>
						</div>

					</div>
				</div>
			</div>

		</div>

	</div>


</body>
</html>