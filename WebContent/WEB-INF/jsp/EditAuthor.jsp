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
<h1>Edit Author</h1>
<hr />

<spring:form action="editauthor.edit" method="post" commandName="author">
<spring:hidden path="authorId"/>
Name:- <spring:input path="authorName" /><spring:errors path="authorName"  /><br/>
<spring:hidden path="authorContact.authorContactId"/>
Email:- <spring:input path="authorContact.authorContactEmail" /><spring:errors path="authorContact.authorContactEmail"  /><br />
PhoneNo:- <spring:input path="authorContact.authorContactPhoneNo" /><spring:errors path="authorContact.authorContactPhoneNo"  /><br />
Street:- <spring:input path="authorContact.authorContactStreet" /><spring:errors path="authorContact.authorContactStreet"  /><br />
Area:- <spring:input path="authorContact.authorContactArea" /><spring:errors path="authorContact.authorContactArea"  /><br />
City:- <spring:input path="authorContact.authorContactCity" /><spring:errors path="authorContact.authorContactCity"  /><br />
<input type="submit" />
</spring:form>
<hr />
<core:forEach items="${author.authorBooks }" var="book">
<form action="bookforauthor.delete" method="post">
<input type="hidden" value="${book.bookId}" name="bookId" />
<input type="hidden" value="${author.authorId}" name="authorId" />
<input type="submit" value="Delete ${book.bookName }" >
</form>
</core:forEach>
<hr />
<form action="addbookforauthor.add">
	<input type="hidden" value="${author.authorId }" name="authorId">
	<input type="submit" value="Add Books For Author">
</form>
<%@include file="Footer.jsp" %>
</body>
</html>
