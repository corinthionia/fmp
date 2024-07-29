<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>방명록 | MiniHome</title>
    <link rel="stylesheet" href="https://fastly.jsdelivr.net/npm/galmuri@latest/dist/galmuri.css">
    <link rel="stylesheet" href="resources/css/global.css">
    <link rel="stylesheet" href="resources/css/guestbook.css">
</head>
<body>
	<div class="background">
		<div class="dashed">
		<nav>
			<a href="/home">
				<div class="tab">홈</div>
			</a>
			<div class="tab">프로필</div>
			<div class="tab">다이어리</div>
			<div class="tab">쥬크박스</div>
			<div class="tab">사진첩</div>
			<div class="tab active-tab">방명록</div>
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
							     
				    <form action="/guestbook" method="post">
				    	<div class="form-profile">
				    		<img src="/resources/images/guestbook_profile.png" alt="프로필 사진" class="guestbook-profile"/>
				        	<textarea id="guestbookText" name="guestbookText" placeholder="일촌의 방명록에 이야기를 남겨보세요~!" required></textarea>
				        </div>
				        <div class="form-user">
				        	<span>${username} 님</span>
				        	<button type="submit" id="submit-button">확인</button>
				        </div>
				    </form>
				    
				    <c:forEach var="guestbook" items="${guestbooks}">
				        <div class="guestbook-wrapper">
				        	<div class="guestbook-header">
				        		<span class="id">NO.${guestbook.guestbookId}</span>
				        		<span class="name">${guestbook.username}</span>
				        		<span class="createdAt">(${guestbook.createdAt})</span>
				        		<c:if test="${guestbook.userId == currentUserId}">
				        			<a href="/guestbook/delete?id=${guestbook.guestbookId}">
					             		<img src="/resources/icons/home_delete.svg" alt="삭제 아이콘" class="guestbook-delete-button">
				              		</a>
				        		</c:if>
				        	</div>
				        	
				        	<div class="guestbook-content">
				        		<img src="/resources/images/guestbook_profile.png" alt="프로필 사진" class="guestbook-profile"/>
				        		<p class="guestbook-text">${guestbook.guestbookText}</p>
				        	</div>
				            
				               
				        </div>
				    </c:forEach>
			    </section>
			</section>
	    </main>
	    </div>
    </div>
</body>
</html>
