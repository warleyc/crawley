<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="title" text="Welcome" /></title>
<jsp:include page="/views/includes/head_mobile.jsp" />

</head>
<body>
	<div data-role="page" id="page1">
		<div data-theme="b" data-role="header">
			<jsp:include page="/views/includes/lang_mobile.jsp" />
			<h3>
				<spring:message code="welcome" text="Welcome" />
			</h3>
		</div>
		<div data-role="content">


			Language : <a href="?language=en">English</a>|<a href="?language=fr">French</a>|<a
				href="?language=jp">Japan</a>

			<h3>
				welcome.springmvc :
				<spring:message code="welcome.springmvc" text="default text" />
			</h3>
			<p>
				<spring:message code="m1" />
			</p>

			Current Locale : ${pageContext.response.locale}



		</div>
		<jsp:include page="/views/includes/footer_mobile.jsp" />
	</div>

	<jsp:include page="/views/includes/fw_mobile.jsp" />

</body>
</html>



</body>
</html>