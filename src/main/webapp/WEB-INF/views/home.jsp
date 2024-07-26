<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Home</h2>

    <h3>Post a Comment</h3>
    <form action="/comment" method="post">
        <label for="nickname">Nickname:</label>
        <input type="text" id="nickname" name="nickname" required><br><br>
        <label for="commentText">Comment:</label>
        <textarea id="commentText" name="commentText" required></textarea><br><br>
        <button type="submit">Post Comment</button>
    </form>

    <h3>What friends say</h3>
    <span>${username}님의 미니홈피</span>
    <ul>
        <c:forEach var="comment" items="${comments}">
            <li>
                ${comment.commentText} (${comment.nickname} <strong>${comment.username}</strong>)
                <a href="/delete?id=${comment.commentId}">Delete</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
