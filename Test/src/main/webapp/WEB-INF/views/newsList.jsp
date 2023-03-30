<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
main {
	max-width: 1220px;
	margin: 0 auto;
}
article {
	display: flex;
	justify-content: center;
	padding: 10px 0;
}
h3 {
	font-size: 20px;
}
p {
	font-size: 15px;
}
.txt_area {
	margin-right: 50px;
	max-width: 800px;
}
img {
	width: 130px;
}
hr {
	
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	let paging = 1
	function handleClick() {
		console.log('onClick')
		$.get("/newsPlus", {
			'data': paging,
		},function(data, status) {
			console.log('data: ', data)
			paging++
		})
	}

</script>
</head>
<body>
	<h1>newsList</h1>
	<hr />
	<main>
		<c:forEach var="news" items="${newsList }">
			<article>
				<div class="txt_area">
					<h3>${news.title}</h3>
					<p>${news.content}</p>
				</div>
				<img src="${news.img}" alt="이미지" />
			</article>
			<hr />
		</c:forEach>
		<button onClick="handleClick()">Click</button>
	</main>
	<%-- <c:forEach var="news" items="${newsList }">
		<a href="${news.href}" target="blank">
			<h2>${news.title}</h2> <img src="${news.img}" />
			<p>${news.content}</p>
			<span>${news.writingSource}</span>
		</a>
	</c:forEach> --%>
</body>
</html>