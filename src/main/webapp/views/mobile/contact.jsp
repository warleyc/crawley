<%@ include file="/views/includes/preamble.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Nicolas CRAWLEY</title>
    <jsp:include page="/views/includes/head.jsp"/>
</head>
<body>
<div>

    <div>
        <div class="header"></div>

        <div class="footer"></div>
        <div class="arbre"></div>
        <jsp:include page="/views/includes/footer.jsp"/>
    </div>

    <div class="main container">
        <div class="row">
            <crawley:contact/>

        </div>
    </div>
</div>

<jsp:include page="/views/includes/fw.jsp"/>

</body>
</html>
