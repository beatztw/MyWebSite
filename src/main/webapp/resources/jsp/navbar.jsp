<%@ page import="com.itis.servletsapp.listeners.InitListener" %>
<%@ page import="com.itis.servletsapp.services.UserService" %>
<%@ page import="com.itis.servletsapp.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<style>
	.nav-item:hover {
		background-color: #a2bcda;
		color: #e2a1a1;
		border-radius: 5px;
        cursor: pointer;
	}
</style>
<ul class="nav" style="margin-top: 1rem; padding-left: .5rem">
	<li class="nav-item">
		<a class="nav-link active" aria-current="page" href="<c:url value="/home"/>">HOME</a>
	</li>

	<li class="nav-item">
		<a class="nav-link" href="<c:url value="/reg"/>">SIGN UP</a>
	</li>

	<li class="nav-item">
		<a class="nav-link" href="<c:url value="/auth"/>">LOG IN</a>
	</li>

	<li class="nav-item">
		<a class="nav-link" href="<c:url value="/posts"/>">REVIEWS</a>
	</li>

<%--	<c:if test="${UserService.isAuth()}">--%>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value="/posts/add"/>">ADD</a>
		</li>
<%--		<li><a class="nav-link disabled">${user.getUsername()}</a></li>--%>
<%--	</c:if>--%>



</ul>