<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Book</h1>
<hr />

<spring:form action="editbook.edit" method="post" commandName="book">
<spring:hidden path="bookId"/>
Name:- <spring:input path="bookName" /><spring:errors path="bookName"  /><br/>
City:- <spring:input path="bookPrice" /><spring:errors path="bookPrice"  /><br />
Change Publisher :-
<select name="publisherId"> 
<core:forEach items="${publishersList }" var="publisher">
<core:if test="${publisher.publisherId eq book.bookPublisher.publisherId }">
<option value="${publisher.publisherId }" selected="selected">${publisher.publisherName }</option>
</core:if>
<core:if test="${publisher.publisherId ne book.bookPublisher.publisherId }">
<option value="${publisher.publisherId }">${publisher.publisherName }</option>
</core:if>
</core:forEach>
</select>
<input type="submit" />
</spring:form>
<hr />
<core:forEach items="${book.bookAuthors }" var="author">
<form action="bookforauthor.delete" method="post">
<input type="hidden" value="${book.bookId}" name="bookId" />
<input type="hidden" value="${author.authorId}" name="authorId" />
<input type="submit" value="Delete ${author.authorName }" >
</form>
</core:forEach>
<form action="addauthorforbook.add">
	<input type="hidden" value="${book.bookId }" name="bookId">
	<input type="submit" value="Add Authors For Book">
</form>
<hr />
<form action="storesforbook.htm">
	<input type="hidden" value="${book.bookId }" name="bookId">
	<input type="submit" value="View Stores For Book">
</form>
<%@include file="Footer.jsp" %>
</body>
</html>
