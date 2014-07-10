<%@ include file="../../../views/includes/preamble.jsp" %>

<div id="contact" class="hide bloc_right">
    <p id="contact_m1">
        <spring:message code="contact_m1" text=""/>
    </p>

    <p></p>

    <div>
        <form id="contactForm" action="" role="form">

            <div class="form-group">
                <legend id="contact_m2"><spring:message code="contact_m2" text=""/></legend>

                <shm:email id="destinataire" name="destinataire" ><spring:message code="contact_m3" text=""/></shm:email>

                <div class="form-group">
                    <label id="contact_m4"><spring:message code="contact_m4" text=""/></label>
                    <textarea class="form-control" cols="100" rows="10" name="message" id="message"></textarea>
                </div>


            </div>

            <button type="submit" class="btn btn-primary sendMail">Envoyer</button>
        </form>
    </div>
</div>





<!-- Modal -->
<div class="modal fade" id="dialogError" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Error</h4>
            </div>
            <div class="modal-body">
                <spring:message code="dialogError" text=""/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Continue</button>
            </div>
        </div>
    </div>
</div>



<!-- Modal -->
<div class="modal fade" id="dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                <spring:message code="Confirmation" text=""/>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-primary" data-dismiss="modal">Continue</button>
            </div>
        </div>
    </div>
</div>
