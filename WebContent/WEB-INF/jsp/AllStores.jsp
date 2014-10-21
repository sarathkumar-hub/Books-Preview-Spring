<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Stores</h1>
	<hr />

	<table cellpadding="10" bgcolor="pink">
		<tr bgcolor="blue">
			<td>Store Id</td>
			<td>Store Name</td>
			<td>Books Available</td>

		</tr>


		<c:forEach items="${store}" var="s">
			<tr>

				<td>${s.storeId}</td>

				<td>${s.storeName}</td>

				<td><form action="booksforstore.htm" method="get">
				<input type="hidden" name="storeId" value="${s.storeId }" />
				<input type="submit" value="View Books">
				</form></td>
			</tr>
		</c:forEach>
	</table>
	<%@include file="EditFooter.jsp" %>
	</body>
	</html>