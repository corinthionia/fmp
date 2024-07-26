<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://fastly.jsdelivr.net/npm/galmuri@latest/dist/galmuri.css">
    <link rel="stylesheet" href="resources/css/global.css">
    <link rel="stylesheet" href="resources/css/home.css">
</head>
<body>
	<div class="background">
		<div class="dashed">
		<main>
			<div class="left-top">
					<div class="today">
						<div>TODAY <b>234</b></div>
							|
						<div> TOTAL 56789</div>
					</div>
			</div>
			<aside>
				<section class="aside-content">
					<div class="profile">
						<img src="resources/images/home_profile.png" src="프로필" class="profile-image"/>
						<div class="status"><b>TODAY IS...</b> ♪ 즐거움</div>
					</div>
					
					<p class="message">
						난 슬플 때 힙합을 춰... <br/>
						Music is my life... ★
					</p>
					
					<div class="bottom">
						<span class="user-name">${username}</span>
						<a href="https://github.com/corinthionia" target="_blank">
							<span class="link">https://github.com/corinthionia</span>
						</a>
						<select>
							<option value="default">★ 일촌 파도타기</option>
	    					<option value="github">@corinthionia</option>
	    					<option value="github">하잉</option>
						</select>
					</div>
				</section>
			</aside>
			
			
			<div class="right-top">
					${username}님의 미니홈피 
			</div>
			<section class="main">
				<section class="main-content">
					<h1 class="section-title">Mini Room</h1>
					<hr>
					<img src="/resources/images/home_mini_room.png" alt="미니룸" class="mini-room-image"/>
				
				    <h1 class="section-title">What friends say <span>한마디로 표현해봐~</span></h1>
				    			     
				    <form action="/comment" method="post">
				        <label>일촌평</label>
				        <input type="text" id="nickname" name="nickname" placeholder="닉네임" required>
				        <input id="commentText" name="commentText" placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!" required>
				        <button type="submit" id="submit-button">확인</button>
				    </form>
				    
				    <ul>
				        <c:forEach var="comment" items="${comments}">
				            <li>
				                <span class="comment-text">
				                	${comment.commentText}
				                	<span class="comment-nickname">
				                		(${comment.nickname} <span class="comment-user-name">${comment.username}</span>)
				                	</span>
				                	 <span class="comment-createdAt">${comment.createdAt}</span>
				                	  <a href="/delete?id=${comment.commentId}">
					                	<img src="/resources/icons/home_delete.svg" alt="삭제 아이콘" class="comment-delete-button">
				               		 </a>
				                </span>
				               
				            </li>
				        </c:forEach>
				    </ul>
			    </section>
			</section>
	    </main>
	    </div>
    </div>
</body>
</html>
