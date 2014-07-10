<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h1>Spring MVC internationalization example</h1>
 
Language : <a href="?language=en">English</a>|<a href="?language=fr">French</a>|<a href="?language=jp">Japan</a>
 
<h3>
welcome.springmvc : <spring:message code="welcome.springmvc" text="default text" />
</h3>
<p><spring:message code="m1"/></p>
 
Current Locale : ${pageContext.response.locale}
 
</body>
</html>