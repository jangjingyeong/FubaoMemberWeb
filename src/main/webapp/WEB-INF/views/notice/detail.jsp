<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세조회</title>
	</head>
	<body>
		<h1>공지사항 상세</h1>
		<ul>
			<li>
				<label>글번호</label>
				<span>${requestScope.noticeOne.noticeNo }</span>
			</li>
			<li>
				<label>작성일</label>
				<span>${requestScope.noticeOne.noticeDate }</span>
			</li>
			<li>
				<label>글쓴이</label>
				<span>${noticeOne.noticeWriter }</span>
			</li>
			<li>
				<label>제목</label>
				<span>${noticeOne.noticeSubject }</span>
			</li>
			<li>
				<label>내용</label>
				<p>${noticeOne.noticeContent }</p>
			</li>
		</ul>
	</body>
</html>