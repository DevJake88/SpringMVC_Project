<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>news</h1>
	<c:forEach var="news" items="${newsList }">
		<a href="${news.href}" target="blank">
			<h2>${news.title}</h2> <img src="${news.img}" />
			<p>${news.content}</p>
			<span>${news.writingSource}</span>
		</a>
	</c:forEach>
</body>
</html>