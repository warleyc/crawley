<%@ include file="../../../views/includes/preamble.jsp" %>


<div class="navbar navbar-inverse navbar-fixed-top hidden-xs" role="navigation">
    <div class="container">

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a id="menu_item1" href="#home">
           		<span id="m1" class="menu_text">
           			<strong><spring:message code="m1" text="Accueil"/>&nbsp;&nbsp;</strong>
           		</span>
                </a></li>
                <li><a id="menu_item2" href="#project">
            		<span id="m2" class="menu_text">
            			<strong><spring:message code="m2" text="Projets"/>&nbsp;&nbsp;</strong>
            		</span>
                </a></li>
                <li><a id="menu_item3" href="#">
            		<span id="m3" class="menu_text">
            			<strong><spring:message code="m3" text="Contact"/>&nbsp;&nbsp;</strong>
            		</span>
                </a></li>

                <li><a id="menu_item4" href="#">
            		<span id="m4" class="menu_text">
            			<strong><spring:message code="m4" text="Localisation"/></strong>
            		</span>
                </a>
                </li>
                <jsp:include page="/views/includes/lang.jsp"/>
            </ul>
        </div>
    </div>
</div>


