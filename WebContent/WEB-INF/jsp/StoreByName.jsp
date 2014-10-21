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
	<h1 align="center">View Store by name</h1>
	<hr />
	<form action="/Book/viewstorebyname.htm">
		<div align="center">
			<select name="storebyname" id="storeid">
				<!-- <option value="0">--select--</option> -->
				<c:forEach items="${allstores }" var="s">
					<option value="${s.storeId }">${s.storeName }</option>
				</c:forEach>
			</select> <br /> <input type="submit" />
		</div><br/>
		<div align="center">
			<b>Store Name :- </b>${currentstore.storeName }<br/>
			<br/>
			<b>Store Contact:- </b><br/>
			
			Phone No:- ${currentstore.storeContact.storeContactPhoneNo }<br/><br/>
			Street:- ${currentstore.storeContact.storeContactStreet }<br/><br/>
			Area:- ${currentstore.storeContact.storeContactArea }<br/><br/>
			City:- ${currentstore.storeContact.storeContactCity }<br/><br/>
			<b>Books sold by the store:-</b><br/>
			<c:forEach items="${currentstore.books }" var="b">
				<li>${b.bookName }</li>  
			</c:forEach>
			<br/>
			
		</div>
	</form>
	<form action="editstore.edit">
		<div align="center">
			<input type="hidden" value="${currentstore.storeId }" name="storeId"/>
			<input type="submit" value="Edit Store">
		</div>
	</form>
	<%@include file="EditFooter.jsp" %>
</body>
</html>