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
a {
	color: unset;
    text-decoration: none;
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
.button_wrapper {
	display: flex;
	justify-content: center;
	margin: 48px 0;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	let paging = 2
	function handleClick() {
		$.get("/newsPlus", {
			'data': paging,
		},function(data, status) {
			paging++
			
			let articleElement = ""
			for(let i=0; i<data.list.length; i++) {
				const title = data.list[i].title
				const content = data.list[i].content
				const href = data.list[i].href
				const img = data.list[i].img
				
				const element =
					'<a href=' + href + ' target="_blank">' +
						'<article>' +
							'<div class="txt_area">' +
								'<h3>' + title + '</h3>' +
								'<p>' + content + '</p>' +
							'</div>' +
							'<img src=' + img + 'alt="이미지" />' +
						'</article>' + 
					'</a>' +
					'<hr />'
				
				articleElement += element
			}
			
			// html 붙이기
			$("hr").last().after(articleElement)
		})
	}
</script>
</head>
<body>
	<h1>newsList</h1>
	<hr />
	<main>
		<c:forEach var="news" items="${newsList }">
			<a href="${news.href}" target="_blank">
				<article>
					<div class="txt_area">
						<h3>${news.title}</h3>
						<p>${news.content}</p>
					</div>
					<img src="${news.img}" alt="이미지" />
				</article>
			</a>
			<hr />
		</c:forEach>
		<div class="button_wrapper">
			<button onClick="handleClick()">뉴스 더보기</button>		
		</div>
	</main>
</body>
</html>