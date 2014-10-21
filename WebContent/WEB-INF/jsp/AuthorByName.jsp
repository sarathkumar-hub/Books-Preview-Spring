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
	<h1 align="center">View Author by name</h1>
	<hr />
	<form action="/Book/viewauthorbyname.htm">
		<div align="center">
			<select name="authorbyname" id="authorid">
				<!-- <option value="0">--select--</option> -->
				<c:forEach items="${allauthors }" var="a">
					<option value="${a.authorId }">${a.authorName }</option>
				</c:forEach>
			</select> <br /> <input type="submit" />
		</div><br/>
		<div align="center">
			<b>Author Name :- </b>${currentauthor.authorName }<br/>
			<br/>
			<b>Author Contact:- </b><br/>
			E - Mail:- ${currentauthor.authorContact.authorContactEmail }<br/><br/>
			Phone No:- ${currentauthor.authorContact.authorContactPhoneNo }<br/><br/>
			Street:- ${currentauthor.authorContact.authorContactStreet }<br/><br/>
			Area:- ${currentauthor.authorContact.authorContactArea }<br/><br/>
			City:- ${currentauthor.authorContact.authorContactCity }<br/><br/>
			<b>Books by the author:-</b><br/>
			<c:forEach items="${currentauthor.authorBooks }" var="b">
				<li>${b.bookName }</li>  
			</c:forEach>
			<br/>
			
		</div>
	</form>
	<form action="editauthor.edit">
		<div align="center">
			<input type="hidden" value="${currentauthor.authorId }" name="authorId"/>
			<input type="submit" value="Edit Author">
		</div>
	</form>
	<%@include file="EditFooter.jsp" %>
</body>
</html>