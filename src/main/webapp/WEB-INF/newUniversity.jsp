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
	<title>New Uni</title>
</head>
<body>
	<h1>Add a university</h1>
	<a href="/universities" class="btn btn-primary">All universities</a>
	<!-- modelAttribute="thisName" <- thisName need to match with UniversityController file-->
	<form:form action="/universities/new" method="POST" modelAttribute="newUniversity">
		<div>
			<!-- path="thisValue" thisValue needs to be matched with the model in University (model) class -->
			<form:label path="city">City : </form:label>
			<form:errors path="city" />
			<form:input path="city"/>
		</div>
		<div>
			<form:label path="name">Name : </form:label>
			<form:errors path="name" />
			<form:input path="name"/>
		</div>
		<div>
			<form:label path="enrollment">Enrollment : </form:label>
			<form:errors path="enrollment" />
			<form:input path="enrollment" type="number" min="1" max="999999" step="1"/>
		</div>
		<div>
			<form:label path="isOnline">Online classes offered : </form:label>
			<form:errors path="isOnline" />
			<form:radiobutton path="isOnline" value="1"/>Yes
			<form:radiobutton path="isOnline" value="0"/>No
		</div>
		<div>
			<form:label path="isInPerson">In-person classes offered : </form:label>
			<form:errors path="isInPerson" />
			<form:radiobutton path="isInPerson" value="1"/>Yes
			<form:radiobutton path="isInPerson" value="0"/>No
		</div>
		<div>
			<form:label path="yearFounded">Year Founded : </form:label>
			<form:errors path="yearFounded" />
			<form:input path="yearFounded" type="number" min="1000" step="1"/>
		</div>
		<input type="submit" value="Add university">
	</form:form>
</body>
</html>