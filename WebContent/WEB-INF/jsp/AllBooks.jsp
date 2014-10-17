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
	<h1>Book Details</h1>
	<hr />

	<table cellpadding="10" bgcolor="pink">
		<tr bgcolor="blue">
			<td>Book Id</td>
			<td>Book Name</td>
			<td>Book Price</td>
			<td>AuthorName</td>
			<td>PublisherName</td>
			<td>storeName</td>
		</tr>


		<c:forEach items="${book}" var="b">

			<tr>

				<td>${b.bookId}</td>

				<td>${b.bookName}</td>

				<td>${b.bookPrice}</td>


				<td><c:forEach items="${b.bookAuthors}" var="a">
						<c:out value="${a.authorName}"></c:out>
					</c:forEach></td>
				<td>${b.bookPublisher.publisherName}</td>
				<td><a href="viewstores">View Stores</a></td>
		</c:forEach>
	</table>

</body>
</html>