<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<!-- HEAD -->
<c:import url="/WEB-INF/jsp/template/head.jsp" />
</head>
<body>
	<!-- NAVBAR -->
	<c:import url="/WEB-INF/jsp/template/navbar.jsp" />

	<!-- CONTAINER -->
	<div class="container theme-showcase">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1><spring:message code="index.jumbotron.title" /></h1>
			<p><spring:message code="index.jumbotron.msg" /></p>
			<p>
				<a href="<c:url value='/login' />" class="btn btn-primary btn-lg"
					role="button"><spring:message code="index.jumbotron.button" /> &raquo;</a>
			</p>
		</div>

		<c:if test="${username != 'anonymousUser'}">
		<div class="page-header">
			<h2>
				<small>Welcome back</small> ${username}
			</h2>
		</div>
		</c:if>

		<c:import url="/WEB-INF/jsp/template/footer.jsp" />
	</div>
</body>
</html>