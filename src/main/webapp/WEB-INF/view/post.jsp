<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.itis.servletsapp.utils.PostUtils" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/post.css"/>">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<header class="header">
    <div class="container">

        <div class="header__inner">
            <div class="header__logo">
                <a id="fury" href="#" onclick="history.back();">Fury</a>
            </div>

            <nav class="nav">
                <a class="nav__link" aria-current="page" href="<c:url value="/home"/>">HOME</a>
                <a class="nav__link" href="<c:url value="/reg"/>">SIGN UP</a>
                <a class="nav__link" href="<c:url value="/auth"/>">LOG IN</a>
                <a class="nav__link" href="<c:url value="/posts"/>">REVIEWS</a>
            </nav>

        </div>

    </div>
</header>

<div class="page">
    <div class="container">
        <div class="page__inner">
            <h2 class="mb-5" id="supTitleText">${post.getTitle()}</h2>
            <div class="mb-52">
                <img style="width: 75%; border-radius: 5%"
                     src="http://localhost:8080/school/images/${post.getImgName()}" alt="img">
            </div>
            <p class="mb-5" id="subTitleText">${post.getText()}</p>
        </div>
    </div>
</div>

<div class="supButtons">
    <c:if test="${PostUtils.isPostBelongsToUser(post.getUserID()) || isAdmin}">
        <form action="<c:url value="/posts/update"/>" method="get" class="d-inline-block mb-5">
            <button name="postID" value="${post.getId()}" class="btn-outline-info">Редактировать</button>
        </form>
        <form action="<c:url value="/posts/delete"/>" method="post" class="d-inline-block">
            <button name="postID" value="${post.getId()}" class="btn-outline-danger">Удалить</button>
        </form>
    </c:if>
</div>

<div class="comments">
    <h3 class="text-center">Комментарии</h3>
    <hr id="line">

    <ul class="list-group mb-5">
        <c:forEach var="comment" items="${comments}">
            <li class="list-group-item list-group-item-secondary mb-3">
                <b id="username">${PostUtils.getUsernameWithID(comment.getUserID())}:  </b>
                <a>${comment.getText()}</a>
            </li>
        </c:forEach>
    </ul>

    <c:if test="${isAuth}">
        <form class="addComments" action="" method="post">
            <div class="input-group mb-3">
                <textarea name="text" type="text" class="form-control" rows="1"></textarea>
            </div>
            <button class="btn-success">Оставить комментарий</button>
        </form>
    </c:if>
</div>

</body>
</html>
