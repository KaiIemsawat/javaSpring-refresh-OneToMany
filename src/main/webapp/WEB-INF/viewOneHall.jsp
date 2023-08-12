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
	<title>About ${thisHall.hallName}</title>
	</head>
<body>
	<div class="container-fluid">
		<a href="/halls" class="btn btn-primary">All Halls</a>
		<h1>About : <c:out value="${thisHall.hallName}"/></h1>
		<p>Located at : <c:out value="${thisHall.university.name}"/></p>
		<p>Has a residential hall : <c:out value="${thisHall.isResidential}"/></p>
		<p>Floor : <c:out value="${thisHall.floors}"/></p>
		<p>Has a lecture room : <c:out value="${thisHall.hasLectureRoom}"/></p>

	</div>
</body>
</html>