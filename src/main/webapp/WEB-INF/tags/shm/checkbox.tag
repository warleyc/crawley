<%@ include file="../../jsp/includes/preamble.jsp" %>

<%@ attribute name="value" %>
<%@ attribute name="id" %>
<%@ attribute name="name" %>
<%@ attribute name="checked" %>


<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
            <label>
                <input type="checkbox" id="${id}" name="${name}" <c:if test="${checked}">checked</c:if> ><jsp:doBody/>
            </label>
        </div>
    </div>
</div>

