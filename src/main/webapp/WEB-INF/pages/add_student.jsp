<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="./">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="add">ADD
							STUDENT</a></li>
					<li class="nav-item"><a class="nav-link" href="signout">LOG
							OUT</a></li>
				</ul>
			</div>
		</div>
	</nav>
<div class="container">
	<form:form modelAttribute="studentModel" enctype="multipart/form-data">
		<table class="table table-dark table-striped">
		<tr ><th colspan="2" style="text-align: center;">ADD EMPLOYEE</th></tr>
			<tr>
				<td >Student Name</td>
				<td><form:input path="studentName" />
						<form:errors path="studentName" />
				</td>
			</tr>
			<tr>
				<td>Class</td>
				<td><form:input path="studentClass" /><form:errors path="studentClass" /></td>
			</tr>
			<tr>
				<td>Grade</td>
				<td><form:input path="studentGrade" /><form:errors path="studentGrade" /></td>
			</tr>
			<tr>
				<td>Admission Date</td>
				<td><input type="date" name="joiningDate" /><span
					style="color: red;"><form:errors path="joiningDate" /></span></td>
			</tr>
			<tr>
				<td>Fees</td>
				<td><form:input path="fees" /><span style="color: red;"><form:errors
							path="fees" /></span></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><form:select path="country">
						<form:options items="${ countries}" />
					</form:select><span style="color: red;"><form:errors path="country" /></span></td>

			</tr>

			<tr>
				<td>House Color</td>
				<td><form:checkboxes items="${ color}" path="colorHouse" /><span
					style="color: red;"><form:errors path="colorHouse" /></span></td>
			</tr>
			<tr>
				<td>Resume</td>
				<td><form:input type="file" path="resumeLocation" /><span
					style="color: red;"><form:errors path="resumeLocation" /></span></td>
			</tr>
			<tr>
				<td><input class="btn btn-light" type="reset" value="Reset"></td>
				<td><input  class="btn btn-light" type="submit" value="Add"></td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>