<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Posts</title>

	<link rel="stylesheet" href="<c:url value="/resources/css/posts.css"/>">

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
				<a id="fury" href="#" onclick="history.back(-3);">Fury</a>
			</div>

			<nav class="nav">
				<a class="nav__link" aria-current="page" href="<c:url value="/home"/>">HOME</a>
				<a class="nav__link" href="<c:url value="/reg"/>">SIGN UP</a>
				<a class="nav__link" href="<c:url value="/auth"/>">LOG IN</a>
				<a class="nav__link" href="<c:url value="/posts"/>">REVIEWS</a>

				<a class="nav__link" href="<c:url value="/posts/add"/>">ADD</a>
			</nav>
		</div>

	</div>
</header>

<div class="page" >
	<div class="container">
		<div class="page__inner">
			<h2 class="posts">Отзывы</h2>

			<div class="card-post-items">
				<c:forEach var="post" items="${posts}">
					<div class="card mb-5">
						<img src="http://localhost:8080/school/images/${post.getImgName()}" class="card-img-top"
							 alt="...">
						<div class="card-body">
							<h5 class="card-title">${post.getTitle()}</h5>
							<a href="/school/posts/${post.getId()}" class="btn btn-primary">Читать</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

</body>
</html>
