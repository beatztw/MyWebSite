<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/update_post.css"/>">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
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

<div class="container">
    <div class="page__inner">

        <form class="box" action="" method="post" enctype="multipart/form-data">
            <h2 class="text-center">Редактировать пост</h2>

            <form action="" method="post" enctype="multipart/form-data" class="w-75 mx-auto">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Название</label>
                    <input value="${post.getTitle()}" name="title" type="text" class="form-control"
                           id="exampleFormControlInput1">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Описание</label>
                    <textarea name="text" class="form-control2" id="exampleFormControlTextarea1" rows="3">
                        ${post.getText()}
                    </textarea>
                </div>

                <div class="mb-3">
                    <label for="formFile" class="form-label">Загрузите картинку</label>
                    <input name="img" class="form-control" type="file" id="formFile">
                </div>

                <button class="btn-save mt-5">Сохранить</button>
            </form>

        </form>

    </div>
</div>


</body>
</html>
