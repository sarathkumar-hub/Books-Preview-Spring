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
	<h1 align="center">View Publisher by name</h1>
	<hr />
	<form action="/Book/viewpublisherbyname.htm">
		<div align="center">
			<select name="publisherbyname" id="publisherid">
				<!-- <option value="0">--select--</option> -->
				<c:forEach items="${allpublishers }" var="p">
					<option value="${p.publisherId }">${p.publisherName }</option>
				</c:forEach>
			</select> <br /> <input type="submit" />
		</div><br/>
		<div align="center">
			<b>Publisher Name :- </b>${currentpublisher.publisherName }<br/>
			<br/>
			<b>Publisher Contact:- </b><br/>
			
			Phone No:- ${currentpublisher.publisherContact.publisherContactPhoneNo }<br/><br/>
			Street:- ${currentpublisher.publisherContact.publisherContactStreet }<br/><br/>
			Area:- ${currentpublisher.publisherContact.publisherContactArea }<br/><br/>
			City:- ${currentpublisher.publisherContact.publisherContactCity }<br/><br/>
			<b>Books by the publisher:-</b><br/>
			<c:forEach items="${currentpublisher.publisherBooks }" var="b">
				<li>${b.bookName }</li>  
			</c:forEach>
			<br/>
			
		</div>
	</form>
	<form action="editpublisher.edit">
		<div align="center">
			<input type="hidden" value="${currentpublisher.publisherId }" name="publisherId"/>
			<input type="submit" value="Edit Publisher">
		</div>
	</form>
	<%@include file="EditFooter.jsp" %>
</body>
</html>