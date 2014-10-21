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
	<h1 align="center">View Book By Name</h1>
	<hr />
	<form action="/Book/viewbookbyid.htm">
		<div align="center">
			<select name="bookbyid" id="bookid">
				<!-- <option value="0">--select--</option> -->
				<c:forEach items="${allbooks }" var="b">
					<option value="${b.bookId }">${b.bookName }</option>
				</c:forEach>
			</select> <br /> <input type="submit" />
		</div>
		<div align="center">
			<b>Book Name :- </b>${currentbook.bookName }<br/>
			<b>Price :- </b>Rs-${currentbook.bookPrice }<br/>
			<b>Authors :- </b>
			<c:forEach items="${currentbook.bookAuthors }" var="auth">
				${auth.authorName },  
			</c:forEach>
			<br/>
			<b>Publisher :- </b>
			${currentbook.bookPublisher.publisherName }<br/><br/><br/>
			
		</div>
	</form>
	<form action="editbook.edit">
		<div align="center">
			<input type="hidden" value="${currentbook.bookId }" name="bookId"/>
			<input type="submit" value="Edit Book">
		</div>
	</form>
	<%@include file="EditFooter.jsp" %>
</body>
</html>