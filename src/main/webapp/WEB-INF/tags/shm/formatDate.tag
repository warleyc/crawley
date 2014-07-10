<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ attribute name="value" type="java.util.Date" required="true" %>
<%@ attribute name="timeZone" %>


<fmt:formatDate value="${value}" pattern="dd/MM/yyyy HH:mm" timeZone="${timeZone}"/>