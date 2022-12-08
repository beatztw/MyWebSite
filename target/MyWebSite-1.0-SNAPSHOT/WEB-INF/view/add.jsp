<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add post</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/add.css"/>">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>

<header class="header">
    <div class="header__inner">
        <div class="header__logo">
            <a id="fury" href="#" onclick="history.back();">Fury</a>
        </div>
        <nav class="nav">
            <a class="nav__link" aria-current="page" href="<c:url value="/home"/>">HOME</a>
            <a class="nav__link" href="<c:url value="/reg"/>">SIGN UP</a>
            <a class="nav__link" href="<c:url value="/auth"/>">LOG IN</a>
            <a class="nav__link" href="<c:url value="/posts"/>">REVIEWS</a>

            <a class="nav__link" href="<c:url value="/posts/add"/>">ADD</a>

        </nav>
    </div>
</header>

<div class="intro">
    <div class="container">
        <div class="intro__inner">

            <form class="box" action="" method="post" enctype="multipart/form-data">
                <h1 class="text-center">Добавить пост</h1>

                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Название</label>
                    <input required name="title" type="text" class="form-control" id="exampleFormControlInput1">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Описание</label>
                    <textarea required name="text" class="form-control2" id="exampleFormControlTextarea1" rows="3">
                    </textarea>
                </div>

                <div class="mb-3">
                    <label for="formFile" class="form-label">Загрузите картинку</label>
                    <input required name="img" class="form-control" type="file" id="formFile">
                </div>

                <button type="submit" class="btn btn-outline-primary mt-5" id="submit-button">Добавить</button>
            </form>

        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
    $(function() {
        $('#submit-button').on('click', function () {
            $('#formFile').on('change', function() {
                alert('input changed, ext: ' + this.value.split('.').pop());
            });
        });
    });
</script>


</body>
</html>
