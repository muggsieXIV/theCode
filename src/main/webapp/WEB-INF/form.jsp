<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Link rel="stylesheet" href="/style.css" />
</head>
<body>
	<div class="parent-container">
		<p class="errormsg">
			<c:out value="${message}"></c:out>
		</p>
		<br>
		<div class="container">
			<form action="/secretCode" method="POST">
				<h3>What is the code?</h3>
				<input type="text" name="code">
				<br>
				<input type="submit" name="submit" value="Try Code" />
			</form>
		</div>
		
	</div>
	
</body>
</html>