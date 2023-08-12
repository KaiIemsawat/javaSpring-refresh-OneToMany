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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<title>All Halls</title>
</head>
<body>
	<div>
		<h1>Add a Hall</h1>
		<a href="universities" class="btn btn-primary">All Universities</a>
			<table class="table">
			<thead>
				<tr>
				 <td>ID</td>
				 <td>Name</td>
				 <td>University</td>
				 <td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<!-- items="${thisValue}" <- thisValue needs to match with -> viewModel.addAttribute("allHalls", hallServ.getAllHalls()); in HallController -->
				<c:forEach var="hall" items="${allHalls}">
					<tr>
						<td><c:out value="${hall.id}"/></td>
						<td><c:out value="${hall.hallName}"/></td>
						<td><c:out value="${hall.university.name}"/></td>
						<td>
							<a href="/halls/${hall.id}" class="btn btn-primary">View</a>
							<a href="/halls/${hall.id}/edit" class="btn btn-warning">Edit</a>
							<a href="/halls/${hall.id}/delete" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
		<p><a href="/halls/new">Add a new hall</a></p>
	
	
	
	</div>

</body>
</html>