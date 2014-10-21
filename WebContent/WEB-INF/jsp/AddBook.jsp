<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Book</h1>
	<hr />
	<spring:form action="addbook.add" method="post" commandName="book">
		<spring:hidden path="bookId" />
Name:- <spring:input path="bookName" />
		<spring:errors path="bookName" />
		<br />
Price:- <spring:input path="bookPrice" />
		<spring:errors path="bookPrice" />
		<br />
		Publisher:-<spring:select path="bookPublisher.publisherId">
			<core:forEach items="${publishersList }" var="publish">
				<spring:option value="${publish.publisherId }">${publish.publisherName }</spring:option>
			</core:forEach>
		</spring:select>
		<input type="submit" />
	</spring:form>
	<%@include file="Footer.jsp" %>
</body>
</html>
