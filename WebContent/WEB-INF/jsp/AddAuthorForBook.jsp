<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Author For Book</h1>
<hr />
<c:forEach items="${authorsList }" var="author">
	<form action="addauthorforbook.add" method="post">
		<input type="hidden" value="${author.authorId }" name="authorId" />
		<input type="hidden" value="${book.bookId }" name="bookId" />
		<input type="submit" value="Add ${author.authorName }">
	</form>
</c:forEach>
</body>
</html>