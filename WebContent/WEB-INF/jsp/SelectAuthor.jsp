<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Select Author</h1>
<hr />
<c:forEach items="${authorsList }" var="author">
	<form action="editAuthor.edit" method="get">
		<input type="hidden" name="authorId" value="${author.authorId }">
		<input type="submit" value="${author.authorName }"/>
	</form>
</c:forEach>
</body>
</html>