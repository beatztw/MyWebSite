<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/registr.css"/>">

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

<div class="page">
    <div class="container">
        <div class="page__inner">

            <div class="w-25 mx-auto">
                <form class="box" action="" method="post">
                    <h1 class="text-center">Регистрация</h1>

                    <div class="input-group mb-3">
                        <label>
                            <input name="login" type="text" placeholder="Username" class="form-control"
                                   aria-describedby="basic-addon1">
                        </label>
                    </div>

                    <div class="input-group mb-3">
                        <label>
                            <input name="password" type="password" placeholder="Password" class="form-control"
                                   aria-describedby="basic-addon2">
                        </label>
                    </div>

                    <button type="submit" class="btn btn-primary">Зарегестрироваться</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
