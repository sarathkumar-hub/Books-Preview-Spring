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
	<h1>All Publisher</h1>
	<hr />

	<table cellpadding="10" bgcolor="pink">
		<tr bgcolor="blue">
			<td>Publisher Id</td>
			<td>Publisher Name</td>
			<td>Books</td>

		</tr>


		<c:forEach items="${publisher}" var="p">

			<tr>

				<td>${p.publisherId}</td>

				<td>${p.publisherName}</td>

				<td><a href="viewbooks">View Books</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>