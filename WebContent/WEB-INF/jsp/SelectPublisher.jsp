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
<h1>Select Publisher</h1>
<hr />
<c:forEach items="${publishersList}" var="publisher">
	<form action="editpublisher.edit" method="get">
		<input type="hidden" name="publisherId" value="${publisher.publisherId }">
		<input type="submit" value="${publisher.publisherName }"/>
	</form>
</c:forEach>
<%@include file="EditFooter.jsp" %>
</body>
</html>