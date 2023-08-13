<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL -->
<!-- c: -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Form/Submit workflows -->
<!-- form: -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- The 'isErrorPage' attribute indicates that the current JSP can be used as the error page for another JSP. -->
<%@ page isErrorPage="true" %>
<!-- The errorPage attribute tells the JSP engine which page to display if there is an error while the current page runs. The value of the errorPage attribute is a relative URL. -->
<%@ page errorPage = "MyErrorPage.jsp" %>
<!DOCTYPE html>

<html>
	<head>
	<meta charset="UTF-8">
		<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<title>All Uni</title>
	</head>
<body>
	<div class="container-fluid">
		<h1>All universities</h1>
		<a href="/halls" class="btn btn-primary">All halls</a>
		<table class="table">
			<thead>
				<tr>
				 <th>ID</th>
				 <th>University Name</th>
				 <th>Number of halls</th>
				 <th>City</th>
				 <th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="university" items="${universities}">
					<tr>
						<td><c:out value="${university.id}"/></td>
						<td><c:out value="${university.name}"/></td>
						<td><c:out value="${university.halls.size()}"/></td>
						<td><c:out value="${university.city}"/></td>
						<td>
							<a href="/universities/${university.id}" class="btn btn-primary">View</a>
							<a href="/universities/${university.id}/edit" class="btn btn-warning">Edit</a>
							<a href="/universities/${university.id}/delete" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
		<p><a href="/universities/new">Add a new university</a></p>
	</div>
</body>
</html>