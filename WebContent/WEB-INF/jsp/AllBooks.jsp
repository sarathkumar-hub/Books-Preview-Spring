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

	<table cellpadding="10">
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

				<c:forEach items="${author}" var="a">
					<c:if test="${b.bookId}==${a.author_id }">
						<td>${a.authorName }</td>
				</
				</c:if>
				</c:forEach>

				<c:forEach items="${publisher}" var="p">
					<c:if test="${b.bookId}==${p.publisher_contactId }">
						<tr>
							<td>${p.publisherName }</td>
						</tr>
					</c:if>
				</c:forEach>
				<a href="viewstores">View Stores</a>
		</c:forEach>


		</tr>

	</table>

</body>
</html>