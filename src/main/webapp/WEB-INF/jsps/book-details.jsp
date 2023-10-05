<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookDetail.com</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

h1 {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 20px;
}

table {
	width: 60%;
	margin: 20px auto;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ccc;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #333;
	color: #fff;
}

td {
	background-color: #fff;
}

button {
	background-color: #007bff;
	color: #fff;
	padding: 5px 10px;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}

a {
	text-decoration: none;
	color: #007bff;
}
</style>
</head>
<body>
	<h1>Book Details</h1>

	<c:if test="${empty book}">
		<p>Book not found</p>
	</c:if>

	<c:if test="${not empty book}">
		<table>
			<tr>
				<th>Title</th>
				<td>${book.title}</td>
			</tr>
			<tr>
				<th>Author</th>
				<td>${book.author}</td>
			</tr>
			<tr>
				<th>ISBN</th>
				<td>${book.isbn}</td>
			</tr>
			<tr>
				<th>Price</th>
				<td>${book.price}</td>
			</tr>
			<tr>
				<th>Quantity in Stock</th>
				<td>${book.quantityInStock}</td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="<c:url value='/purchase/${book.isbn}'/>"
						method="post">
						<input type="hidden" name="_csrf" value="${_csrf.token}" />
						<button type="submit">Purchase</button>
					</form>
				</td>
			</tr>
		</table>
	</c:if>
	<a href="<c:url value='/showHomePage'/>">Back to Homepage</a>
</body>
</html>

