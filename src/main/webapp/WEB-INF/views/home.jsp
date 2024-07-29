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
		<nav>
			<div class="tab active-tab">홈</div>
			<div class="tab">프로필</div>
			<div class="tab">다이어리</div>
			<div class="tab">쥬크박스</div>
			<div class="tab">사진첩</div>
			<div class="tab">
				<a href="/guestbook">방명록</a>
			</div>
		</nav>
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
						★━━━━━━ <br/>
						<br/>
						ㅂㅂ ㅏ ㅅ ㅑ~!!!<br/>
						<br/>
						━━━━━━★
					</p>
					
					<div class="bottom">
						<span class="user-name">김주현</span>
						<a href="https://github.com/corinthionia" target="_blank">
							<span class="link">https://github.com/corinthionia</span>
						</a>
						<div class="select">
							★ 일촌 파도타기
							<div>▼</div>
						</div>
					</div>
				</section>
			</aside>
			
			
			<div class="right-top">
				<spam>김주현 님의 미니홈피</spam>
			</div>
			<section class="main">
				<section class="main-content">
					<h1 class="section-title">Updated news</h1>
					<div class="news">
						<ul class="news-list">
							<li>・ 하나 더 질문!!</li>
							<li>・ [스크랩] 오늘의 사진</li>
							<li>・ [스크랩] 흠...</li>
						</ul>
						<div class="category">
							<div>다이어리 <span class="num">3/143</span></div>
							<div>동영상 <span class="num">5/98</span></div>
							<div>사진첩 <span class="num">325/1694</span></div>
							<div>방명록 <span class="num">45/35980</span></div>
							<div>게시판 <span class="num">5/2401</span></div>
							<div></div>
						</div>
					</div>
					
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
				    
				    <ul class="comment-ul">
				        <c:forEach var="comment" items="${comments}">
				            <li class="comment-li">
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
