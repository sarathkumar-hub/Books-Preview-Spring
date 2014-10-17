<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Authors</h1>
	<hr />

	<table cellpadding="10">
		<tr bgcolor="blue">
			<td>Author Id</td>
			<td>Author Name</td>
			<td>Author Contact Id</td>

		</tr>


		<c:forEach items="${author}" var="a">
			<hr/>

			<tr>

				<td>${a.authorId}</td>

				<td>${a.authorName}</td>

				<td>${a.authorContactId}</td>

				<a href="viewbooks">View Books</a>
			</tr>
		</c:forEach>
	</table>