<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Main page">

    <header class="header">
        <div class="container">
            <div class="header__inner">
                <div class="header__logo">
                <a id="fury" href="<c:url value="${}"/>">Fury</a>
                </div>

                <nav class="nav">
                    <a class="nav__link" href="#aboutSection">About</a>
                    <a class="nav__link" href="#contactSection">Contact</a>
                </nav>

            </div>
        </div>
    </header>

    <div class="intro">
        <div class="container">
            <div class="intro__inner">
                <h1 class="intro__title">Welcome to Fury!</h1>
                <a class="btn" href="<c:url value="/home"/>">Start</a>
            </div>
        </div>
    </div>

    <section class="section" id="aboutSection">
        <div class="container">

            <div class="section__header">
                <h2 class="section__title">Story about us</h2>
                <div class="section__text">
                    <p>Обучаем уверенному вождению, чтобы получив водительское удостоверение,
                        Вы сели за руль и не чувствовали себя неловко на улицах города и не растерялись,
                        оказавших в условиях бездорожья. Наши курсанты водят не просто уверенно – они
                        управляют транспортным средством аккуратно, уважая других участников
                        дорожного движения и не подвергая опасности ни себя, ни окружающих.</p>

                    <p>Мы знаем и научим – в каких ситуациях нужно действовать стремительно по заданному алгоритму,
                        а где нужно притормозить и выждать паузу, не совершая необдуманных манёвров.
                        Причём это касается не только легковых автомобилей.
                        Наши инструкторы виртуозно владеют навыкам управления мотоциклами, грузовыми машинами,
                        квадроциклами, автобусами – и передадут эти знания Вам в понятной форме.</p>
                </div>
            </div>

            <div class="about">
                <div class="about__item">
                    <div class="about__img">
                        <img src="${pageContext.request.contextPath}/resources/images/about/1.jpg" alt="">
                    </div>
                    <div class="about__text">super team</div>
                </div>

                <div class="about__item">
                    <div class="about__img">
                        <img src="${pageContext.request.contextPath}/resources/images/about/2.jpg" alt="">
                    </div>
                    <div class="about__text">best community</div>
                </div>

                <div class="about__item">
                    <div class="about__img">
                        <img src="${pageContext.request.contextPath}/resources/images/about/3.jpg" alt="">
                    </div>
                    <div class="about__text">responsive employees</div>
                </div>
            </div>

        </div>
    </section>

    <div class="contacts" id="contactSection">
        <div class="container">
            <div class="information">
                <div class="inf__item">
                    <div class="inf__text">Телефон:</div>
                    <div class="inf__subtext">+7923193192</div>
                    <div class="inf__text">Email:</div>
                    <div class="inf__subtext">Fury@mail.ru</div>
                </div>
                <div class="inf__item">
                    <div class="inf__text">instagram:</div>
                    <div class="inf__subtext">Fury_School</div>
                    <div class="inf__text">Telegram:</div>
                    <div class="inf__subtext">@Fury_School</div>
                </div>
            </div>
        </div>
    </div>


</t:mainLayout>
