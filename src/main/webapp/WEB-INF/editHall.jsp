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
	<title>Edit Hall Page</title>
</head>
<body>
	<h1>Edit Hall</h1>
	<a href="/halls" class="btn btn-primary">All halls</a>
	<!-- modelAttribute="thisName" <- thisName need to match with HallController file-->
	<form:form action="/halls/${editHall.id}/edit" method="POST" modelAttribute="editHall">
		<input type="hidden" name="_method" value="PUT">
		<div>
		<!-- path="thisValue" thisValue needs to be matched with the model in University (model) class -->
			<form:label path="hallName">Hall name : </form:label>
			<form:errors path="hallName" class="text-danger"/>
			<form:input path="hallName"/>
		</div>
		<div>
			<form:label path="isResidential">Is residential : </form:label>
			<form:errors path="isResidential" class="text-danger" />
			<form:radiobutton path="isResidential" value="1" label="Yes"/>
			<form:radiobutton path="isResidential" value="0" label="No"/>
		</div>
		<div>
			<form:label path="floors">Floors : </form:label>
			<form:errors path="floors" class="text-danger" />
			<form:input path="floors" type="number" min="1" max="999999" step="1"/>
		</div>
		<div>
			<form:label path="hasLectureRoom">Has lecture rooms : </form:label>
			<form:errors path="hasLectureRoom" class="text-danger" />
			<form:radiobutton path="hasLectureRoom" value="1" label="Yes"/>
			<form:radiobutton path="hasLectureRoom" value="0" label="No"/>
		</div> 
		<div>
			<form:label path="university">University : </form:label>
			<form:select path="university" class="col-3">
				<form:options items="${universities}" itemValue="id" itemLabel="name" />
			</form:select>
			<form:errors path="university" class="text-danger" />
		</div> 
		
		
		<input type="submit" value="Edit hall" class="btn btn-primary">
	</form:form>
</body>
</html>