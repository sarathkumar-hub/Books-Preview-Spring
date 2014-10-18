<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Author</h1>
<hr />

<spring:form action="editPublisher.edit" method="post" commandName="publisher">
<spring:hidden path="publisherId"/>
Name:- <spring:input path="publisherName" /><spring:errors path="publisherName"  /><br/>
<spring:hidden path="publisherContact.publisherContactId"/>
PhoneNo:- <spring:input path="publisherContact.publisherContactPhoneNo" /><spring:errors path="publisherContact.publisherContactPhoneNo"  /><br />
Street:- <spring:input path="publisherContact.publisherContactStreet" /><spring:errors path="publisherContact.publisherContactStreet"  /><br />
Area:- <spring:input path="publisherContact.publisherContactArea" /><spring:errors path="publisherContact.publisherContactArea"  /><br />
City:- <spring:input path="publisherContact.publisherContactCity" /><spring:errors path="publisherContact.publisherContactCity"  /><br />
<input type="submit" />
</spring:form>
</body>
</html>
