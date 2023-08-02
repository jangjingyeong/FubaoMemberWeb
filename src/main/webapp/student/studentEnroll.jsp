<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 회원가입</title>
		<link rel="stylesheet" href="/resources/css/member/main.css">
	</head>
	<body>
		<h1>학생 회원가입</h1>
		<h3>회원정보를 입력하세요.</h3>
		<form action="" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<ul>
					<li>
						<label for="student-id">아이디</label>
						<input type="text" id="member-id" name="student-id"> <!-- 기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="student-pw">비밀번호</label>
						<input type="password" id="student-pw" name="student-pw">
					</li>
					<li>
						<label for="student-name">이름</label>
						<input type="text" id="member-name" name="student-name"> 
					</li>
					<li>
						<label for="student-age">나이</label>
						<input type="text" id="member-age" name="student-age"> 
					</li>
					<li>
						<label for="student-gender">성별</label>
						남
						<input type="radio" id="male" name="student-gender" value="M"> 
						
						여
						<input type="radio" id="female" name="student-gender" value="F"> 
						
						
					</li>
					<li>
						<label for="student-email">이메일</label>
						<input type="text" id="member-email" name="student-email"> 
					</li>
					<li>
						<label for="member-phone">전화번호</label>
						<input type="text" id="member-phone" name="member-phone"> 
					</li>
					<li>
						<label for="member-address">주소</label>
						<input type="text" id="member-address" name="member-address"> 
					</li>
					<li>
						<label for="member-hobby">취미</label>
						<input type="text" id="member-hobby" name="member-hobby"> 
					</li>
				</ul>
			</fieldset>
		</form>
	</body>
</html>