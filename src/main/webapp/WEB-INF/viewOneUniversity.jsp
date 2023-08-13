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
<title>About ${thisUniversity.name}</title>
</head>
<body>
	<div class="container-fluid">
		<a href="/universities" class="btn btn-primary">All Universities</a>
		<h1>About : <c:out value="${thisUniversity.name}"/></h1>
		<p>City : <c:out value="${thisUniversity.city}"/></p>
		<p>Offer online classes : <c:out value="${thisUniversity.isOnline}"/></p>
		<p>Offer in-person class : <c:out value="${thisUniversity.isInPerson}"/></p>
		<p>Enrollment : <c:out value="${thisUniversity.enrollment}"/></p>
		<p>Year of established : <c:out value="${thisUniversity.yearFounded}"/></p>
		<p>List of halls : </p>
		<ul>
			<c:forEach var="eachHall" items="${thisUniversity.halls}">
				<li><c:out value="${eachHall.hallName }"></c:out></li>
			</c:forEach>
		
		</ul>
	</div>
</body>
</html>