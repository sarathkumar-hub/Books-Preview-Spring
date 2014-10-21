<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


a {
	background-color: white;
	text-decoration: none;
	color: blue;
	padding: 0px;
}

a:hover {
	color: black;
	text-decoration: underline;
}
</style>
</head>

<body>

	<h1 align="center" style="color: black">View All</h1>

	<hr/>
	<img src="images/book-stack.jpg" height="300px" width="300px" align="left">
	<img src="images/bookpic.jpg" height="300px" width="300px" align="right">
	<table height="200px" width="400px" align="center">

        <tr>

		<td><h2 align="right"><a href="viewallbooks.htm">View All Books</a></h2></td></tr>
		<tr>
		<td><h2 align="left"><a href="viewallauthors.htm">View All Authors</a></h2></td>
		</tr>
		<tr>
		<td><h2 align="right"><a href="viewallpublishers.htm">View All Publishers</a></h2></td>
		</tr>
		<tr>
		<td><h2 align="left"><a href="viewallstores.htm">View All Stores</a></h2></td>
		</tr>
	


	</table>
	<br/>
	<br/>
<%@include file="EditFooter.jsp" %>

</body>

</html>