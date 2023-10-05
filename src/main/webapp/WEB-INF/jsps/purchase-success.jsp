<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>purchase-success</title>
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

p {
	text-align: center;
}

a {
	text-decoration: none;
	color: #007bff;
	display: block;
	text-align: center;
	margin-top: 20px;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1>Purchase Successful</h1>
	<p>Your book has been successfully purchased.</p>
	<a href="<c:url value='/showHomePage'/>">Back to Homepage</a>
</body>
</html>