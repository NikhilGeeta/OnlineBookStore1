<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage.com</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: hotpink;
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
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ccc;
}

th, td {
	padding: 10px;
	text-align: center;
}

ul {
	list-style: none;
	padding: 0;
}

li {
	margin: 5px 0;
}

a {
	text-decoration: none;
	color: #007bff;
}
</style>
</head>
<body>
	<h1>Welcome to Our Bookstore</h1>

	<table border="3">
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>ISBN</th>
				<th>Price</th>
				<th>Quantity in Stock</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${book}">
				<tr>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.isbn}</td>
					<td>${book.price}</td>
					<td>${book.quantityInStock}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>Click on a book ISBN to view details:</p>
	<ul>
		<c:forEach var="book" items="${book}">
			<li><a href="<c:url value='/books/${book.isbn}'/>">${book.isbn}</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>