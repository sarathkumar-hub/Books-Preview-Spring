<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#div1 {
	height: 600px;
	width: 1000px;
 	padding-left: 200px;
	padding-top: 100px;
}

a {
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

	<h1 align="center" style="color: black">Edit By Category</h1>

	<hr/>
	<img src="images/edit.jpg" height="300px" width="300px" align="left">

	<table align="center" height="200px" width="400px">

        <tr>

		<td><h2><a href="selectbook.edit">Edit Book</a></h2></td></tr>
		<tr>
		<td><h2><a href="selectauthor.edit">Edit Author</a></h2></td>
		</tr>
		<tr>
		<td><h2><a href="selectstore.edit">Edit Store</a></h2></td>
		</tr>
		<tr>
		<td><h2><a href="selectpublisher.edit">Edit Publisher</a></h2></td>
		</tr>
	


	</table>
	<br/>
	<br/>
<%@include file="Footer.jsp" %>
</body>

</html>