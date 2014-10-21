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

	<table cellpadding="10" bgcolor="pink">
		<tr bgcolor="blue">
			<td>Author Id</td>
			<td>Author Name</td>
			<td>Books</td>

		</tr>


		<c:forEach items="${author}" var="a">
			<tr>

				<td>${a.authorId}</td>

				<td>${a.authorName}</td>

				<td><form action="booksforauthor.htm" method="get">
				<input type="hidden" name="authorId" value="${a.authorId }" />
				<input type="submit" value="View Books">
				</form></td>
			</tr>
		</c:forEach>
	</table>
	<%@include file="EditFooter.jsp" %>
</body>
</html>