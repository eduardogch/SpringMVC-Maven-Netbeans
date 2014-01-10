<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a
				style="margin-top: -15px; margin-right: 15px; padding-right: 15px;"
				href="<c:url value='/' />"><img
				src="<c:url value='/resources/img/logo-brand.png' />"></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value='/' />"> <span
						class="glyphicon glyphicon-home"></span> <spring:message
							code="navbar.list1" /></a></li>
				<li><a href="<c:url value='/login' />"> <span
						class="glyphicon glyphicon-log-in"></span> <spring:message
							code="navbar.list2" /></a></li>
				<li><a href="<c:url value='/contact' />"> <span
						class="glyphicon glyphicon-list"></span> <spring:message
							code="navbar.list5" /></a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li>
					<form class="navbar-form navbar-right" action="<c:url value='/contact/search' />" method="POST" role="search">
						<div class="form-group">
							<input type="text" id="w-input-search" name="email" class="form-control" placeholder="<spring:message code="navbar.search.input" />">
						</div>
						<button type="submit" class="btn btn-default"><spring:message code="navbar.search.button" /></button>
					</form>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <span class="glyphicon glyphicon-globe"></span>
						<spring:message code="navbar.list3" /> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="?lang=en">English</a></li>
						<li><a href="?lang=es">Español</a></li>
					</ul></li>

				<li><a href="<c:url value="/j_spring_security_logout" />">
						<span class="glyphicon glyphicon-log-out"></span> <spring:message
							code="navbar.list4" />
				</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>

<!-- JavaScripts -->
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
	<script type="text/javascript">
	  $(document).ready(function() {
	 
		$('#w-input-search').autocomplete({
			serviceUrl: '${pageContext.request.contextPath}/contact/getEmailTags',
			paramName: "getEmail",
			delimiter: ",",
	        transformResult: function(response) {
	 		return {      	
			  suggestions: $.map($.parseJSON(response), function(item) {
	 		    return { value: item.email, data: item.id };   
			  
			  })	  
			};}
		 });
	
  		});
  </script>