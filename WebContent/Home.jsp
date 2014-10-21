<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#div1 {
	height: 500px;
	width: 300px;
	padding-left: 200px;
	padding-right:200px;
	padding-top: 100px;
	background-image: url(images/background.jpg);
}

a {
	background-color:white;
	text-decoration: none;
	color: black;
	padding: 15px;
}

a:hover {
	color: black;
	text-decoration: underline;
}
</style>


</head>

<body  >

	<h1 align="center" style="color: black">Books Information</h1>

	<hr size="2" style="color: red" />

<div style="width: 100%;height: 100%" align="center">

	<div id="div1" align="center">


		<h2>
			<a href="viewall.htm">View All</a>
		</h2>
		<br/>
		<br/>
		<h2>
			<a href="viewbyid.htm">View By Name</a>
		</h2>
		<br/>
		<br/>
		<h2>
			<a href="edit.edit">Edit</a>
		</h2>
		<br/>
		<br/>
		<h2>
			<a href="addall.add">Add</a>
		</h2>
	</div>
</div>
</body>

</html>