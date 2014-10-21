<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#div1 {
	height: 400px;
	width: 700px;
	padding-left: 200px;
	padding-top: 200px;
}

a {
	background-color: white;
	text-decoration: none;
	color: blue;
	padding: 15px;
}

a:hover {
	color: black;
	text-decoration: underline;
}
</style>
</head>

<body>

	<h1 align="center" style="color: black">Books Information</h1>


	<hr/>

	<table align="center" height="200px" width="400px">

        <tr><td align="left"><a href="bookbyid.htm">View Book by ID</a></td></tr>
		<tr><td align="right"><a href="publisherbyname.htm">View Publisher by Name</a></td></tr>
        <tr><td align="left"><a href="storebyname.htm">View Store by Name</a></td></tr>
		<tr><td align="right"><a href="authorbyname.htm">View Author by Name</a></td></tr>
	


	</div>
<%@include file="Footer.jsp" %>
</body>

</html>