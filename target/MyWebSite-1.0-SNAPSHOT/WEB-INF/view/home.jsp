<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Home</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>">

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

        </nav>
    </div>
</header>

<div class="page">
    <div class="container-page">
        <div class="page__inner">
            <div class="flexible-page">
                <div class="flexible-page__box-orange">
                    <div class="flexible-page__box-orange-info">
                        <h1 class="flexible-page__box-orange-info-big">A</h1>
                        <h1 class="flexible-page__box-orange-info-seat">⌚ от 2 месяцев</h1>
                        <h1 class="flexible-page__box-orange-info-project">🕮 30/138 часов теории</h1>
                        <h1 class="flexible-page__box-orange-info-price">🚗 от 18 часов практики</h1>
                        <h1 class="flexible-page__box-orange-info-cat">
                            A – Обучим вождению мотоцикла, снегохода, квадроцикла
                        </h1>
                        <h1 class="flexible-page__box-orange-info-cat1">
                            A1 – Обучим вождению снегохода, квадроцикла
                        </h1>
                        <a class="flexible-page__box-orange-info-button">Подробнее</a>
                    </div>
                </div>
                <div class="flexible-page__box-orange" id="mishmash1">
                    <div class="flexible-page__box-orange-info">
                        <h1 class="flexible-page__box-orange-info-big">B</h1>
                        <h1 class="flexible-page__box-orange-info-seat">⌚ от 4 месяцев</h1>
                        <h1 class="flexible-page__box-orange-info-project">🕮 от 138 часов теории</h1>
                        <h1 class="flexible-page__box-orange-info-price">🚗 54/70 часов практики</h1>
                        <h1 class="flexible-page__box-orange-info-cat" id="paddington1">
                            B – Обучим вождению легкового автомобиля
                        </h1>
                        <a class="flexible-page__box-orange-info-button">Подробнее</a>
                    </div>
                </div>
                <div class="flexible-page__box-orange" id="mishmash2">
                    <div class="flexible-page__box-orange-info">
                        <h1 class="flexible-page__box-orange-info-big">C</h1>
                        <h1 class="flexible-page__box-orange-info-seat">⌚ от 3 месяцев</h1>
                        <h1 class="flexible-page__box-orange-info-project">🕮 от 43 часов теории</h1>
                        <h1 class="flexible-page__box-orange-info-price">🚗 от 38 часов практики</h1>
                        <h1 class="flexible-page__box-orange-info-cat" id="paddington2">
                            C – Обучим вождению грузового автомобиля
                        </h1>
                        <a class="flexible-page__box-orange-info-button">Подробнее</a>
                    </div>
                </div>
                <div class="flexible-page__box-orange" id="mishmash3">
                    <div class="flexible-page__box-orange-info">
                        <h1 class="flexible-page__box-orange-info-big">D</h1>
                        <h1 class="flexible-page__box-orange-info-seat">⌚ от 3,5 месяцев</h1>
                        <h1 class="flexible-page__box-orange-info-project">🕮 от 77 часов теории</h1>
                        <h1 class="flexible-page__box-orange-info-price">🚗 40/74 часов практики</h1>
                        <h1 class="flexible-page__box-orange-info-cat " id="paddington3">
                            D – Обучим вождению   автобуса
                        </h1>
                        <a class="flexible-page__box-orange-info-button">Подробнее</a>
                    </div>
                </div>
                <div class="flexible-page__box-orange" id="mishmash4">
                    <div class="flexible-page__box-orange-info">
                        <h1 class="flexible-page__box-orange-info-big">E</h1>
                        <h1 class="flexible-page__box-orange-info-seat">⌚ от 2 месяцев</h1>
                        <h1 class="flexible-page__box-orange-info-project">🕮 от 18 часов теории</h1>
                        <h1 class="flexible-page__box-orange-info-price">🚗 от 18 часов практики</h1>
                        <h1 class="flexible-page__box-orange-info-cat">
                            BE – Обучим вождению легкового автомобиля с прицепом
                        </h1>
                        <h1 class="flexible-page__box-orange-info-cat1">
                            CE – Обучим вождению грузового автомобиля с прицепом
                        </h1>
                        <h1 class="flexible-page__box-orange-info-cat2" id="paddington4">
                            DE – Обучим вождению автобуса с прицепом
                        </h1>
                        <a class="flexible-page__box-orange-info-button">Подробнее</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
