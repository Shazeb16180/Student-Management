<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
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
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="./">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="add">ADD
							STUDENT</a></li>
					<li class="nav-item"><a class="nav-link" href="signout">LOG
							OUT</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<c:choose>
		<c:when test="${!empty students}">
			<table border="1px" class="table table-dark table-striped">
				<tr>
					<th>Student Id</th>
					<th>Student Name</th>
					<th>Student Class</th>
					<th>Student Grade</th>
					<th>Student Admission Date</th>
					<th>Student Fees</th>
					<th>Student Country</th>
					<th>Student House Color</th>
					<th colspan="3" style="text-align: center;">Action</th>
				</tr>

				<c:forEach var="student" items="${students.getContent()}">
					<tr>
						<td>${student.id}</td>
						<td>${student.studentName}</td>
						<td>${student.studentClass}</td>
						<td>${student.studentGrade}</td>
						<td>${student.joiningDate}</td>
						<td>${student.fees}</td>
						<td>${student.country}</td>
						<td>${student.colorHouse}</td>
						<td><button type="button" class="btn btn-light">
								<a style="text-decoration: none;" class="link-dark"
									href="edit?id=${student.id}">Edit</a>
							</button></td>
						<td><button type="button" class="btn btn-light">
								<a style="text-decoration: none;" class="link-dark"
									href="delete?id=${student.id}">Delete</a>
							</button></td>
						<td><button type="button" class="btn btn-light">
								<a style="text-decoration: none;" class="link-dark"
									href="download?id=${student.id}">Download</a>
							</button></td>
					</tr>
				</c:forEach>
			</table>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">

					<c:if test="${!students.isFirst() }">
						<li class="page-item"><a class="page-link link-dark" href="./?page=0">First</a></li>
						<li class="page-item"><a class="page-link link-dark"
							href="./?page=${students.getNumber()-1 }">Previous</a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${students.getTotalPages()}"
						step="1">
						<li class="page-item"><a class="page-link link-dark"
							href="./?page=${i-1}">${i}</a></li>
					</c:forEach>
					<c:if test="${!students.isLast() }">
						<li class="page-item"><a class="page-link link-dark"
							href="./?page=${students.getNumber()+1 }">Next</a></li>
						<li class="page-item"><a class="page-link link-dark"
							href="./?page=${students.getTotalPages()-1 }">Last</a></li>
					</c:if>

				</ul>
			</nav>
			<h1 style="color: red; text-align: center">${message}</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No Records</h1>
		</c:otherwise>
	</c:choose>
</body>