<%@ attribute name="value" %>
<%@ attribute name="id" %>
<%@ attribute name="name" %>

<div class="form-group">
    <label for="${id}" class="col-sm-2 control-label"><jsp:doBody/></label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="${id}" name="${name}" placeholder="<jsp:doBody/>" value="${value}" >
    </div>
</div>
