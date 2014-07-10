<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="language" class="flag">
	<div class="ui-select">
		<select name="language" id="lang" data-native-menu="false" data-icon="flag-${pageContext.response.locale.language}" data-mini="true"  >
			<option data-placeholder='true'>Choose one...</option>
			<option <c:if test="${pageContext.response.locale.language== 'uk'}">selected="selected"</c:if>  value='uk'>English</option>
			<option <c:if test="${pageContext.response.locale.language== 'fr'}">selected="selected"</c:if>  value='fr'>Francais</option>
			<option <c:if test="${pageContext.response.locale.language== 'jp'}">selected="selected"</c:if>  value='jp'>Japanese</option>
		</select>
	</div>
</div>