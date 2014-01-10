<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<!-- HEAD -->
<c:import url="/WEB-INF/jsp/template/head.jsp" />

<script type="text/javascript">
	  $(document).ready(function() {
	 
		$('#input-search-bar').autocomplete({
			serviceUrl: '${pageContext.request.contextPath}/contact/getEmailTags',
			paramName: "getEmail",
		 });
	
  		});
 </script>

</head>
<body>
	<!-- NAVBAR -->
	<c:import url="/WEB-INF/jsp/template/navbar.jsp" />

	<!-- CONTAINER -->
	<div class="container theme-showcase">

		<div class="row">
			<div class="col-md-offset-3">
				<h2>
					<spring:message code="main.title" />
					<small>Louis Vuitton-PCIS</small>
				</h2>
			</div>
		</div>

		<hr />

		<div class="row">
			<div class="col-md-2">
				<div class="bs-sidebar" role="complementary">
					<ul class="nav bs-sidenav" id="search-results">
						<li>
							<form class="form-horizontal" role="search">
								<div class="form-group">
									<input type="text" id="input-search-bar" class="form-control"
										placeholder="<spring:message code="navbar.search.input" />">
								</div>
							</form>
						</li>
					</ul>
				</div>
			</div>

			<div class="col-md-10">
				<!-- TABLES -->

				<div class="row">
					<div class="col-md-3">
						<h3>
							<spring:message code="contact.grid.title" />
						</h3>
					</div>
					<div class="col-md-2">
						<a href="<c:url value='/contact/add' />" class="btn btn-primary"
							role="button" style="margin-top: 15px;"><spring:message
								code="contact.list.button" /> &raquo;</a>
					</div>
					<c:if test="${not empty message}">
						<div class="col-md-3">
							<div class="alert alert-${errorType}">${message}</div>
						</div>
					</c:if>
				</div>

				<div class="bs-example">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th><spring:message code="contact.grid.fullname" /></th>
								<th><spring:message code="contact.grid.email" /></th>
								<th><spring:message code="contact.grid.telephone" /></th>
								<th><spring:message code="contact.grid.delete" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${contactList}" var="contact">
								<tr>
									<td>${contact.id}</td>
									<td><a
										href="<c:url value='/contact/edit/${contact.id}' />">
										${contact.firstname} ${contact.lastname}</a></td>
									<td>${contact.email}</td>
									<td>${contact.telephone}</td>
									<td><a
										href="<c:url value='/contact/delete/${contact.id}'/>"
										class="btn btn-xs btn-danger" role="button" onclick="return confirm('Are you sure?');">delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- FOOTER -->
		<c:import url="/WEB-INF/jsp/template/footer.jsp" />
	</div>
</body>
</html>