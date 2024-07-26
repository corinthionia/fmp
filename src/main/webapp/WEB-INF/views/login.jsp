<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인 | MiniHome</title>
	<link rel="stylesheet" href="https://fastly.jsdelivr.net/npm/galmuri@latest/dist/galmuri.css">
	<link rel="stylesheet" href="resources/css/global.css">
	<link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
	<main>
		<div class="wrapper">
			<img src="/resources/images/login_character.png" alt="캐릭터" class="character"/>
  			<form method="post">
  				<img src="/resources/images/login_logo.png" alt="로고" class="logo"/>
  				<div class="input-wrapper">
					<input type="text" name="name" placeholder="한글 이름">
    				<input type="password" name="password" placeholder="4자리 숫자 비밀번호">
    			</div>
   				<button type="submit">로그인</button>
 	 		</form>
 	 	</div>
  	</main>
</body>
</html>

