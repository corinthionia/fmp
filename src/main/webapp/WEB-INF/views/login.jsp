<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인 | MiniHome</title>
	<link rel="stylesheet" href="https://fastly.jsdelivr.net/npm/galmuri@latest/dist/galmuri.css">
    <style>
        body {
            font-family: 'Galmuri9', sans-serif;
        }
    </style>
</head>
<body>
  <h3>로그인 | MiniHome</h3>
  <hr>
  <form method="post">
    이름: <input type="text" name="name"><br>
    비밀번호: <input type="text" name="password" placeholder="숫자 4자리"><br>
   <button>입력</button>
  </form>
</body>
</html>

