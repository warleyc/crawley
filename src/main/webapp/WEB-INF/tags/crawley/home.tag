<%@ include file="../../../views/includes/preamble.jsp" %>

<div id="main_right" class="bloc_right row ">
    <p id="p1">
        <spring:message code="p1" text="Welcome"/>
    </p>

    <p id="p2" class="hidden-xs">
        <spring:message code="p2" text="Welcome"/>
    </p>

    <div>



        <div class="col-xs-12  visible-xs" >
                <div class="col-xs-12  center ">
                    <a class="center-block" href="/mobile/geoloc"  >
                        <img  src="/img/search.png" width="48px" height="48px" alt="where" />
                        <spring:message code="where" text="Ou suis je?" />
                    </a>
                </div>
                <div >
                    <div class="col-xs-6">
                        <a  href="/mobile/projets"  >
                            <img  src="/img/projet.png" width="48px" height="48px" alt="project" />
                            <spring:message code="project" text="Projets" />
                        </a>
                    </div>
                    <div class="col-xs-6">
                        <a  href="/mobile/contact"  >
                            <img  src="/img/mail.png" width="48px" height="48px" alt="contact" />
                            <spring:message code="contact" text="Contact" />
                        </a>
                    </div>
                </div>
        </div>

        <div class=" col-xs-6 col-sm-6  col-md-6 ">
            <img class="hidden-xs" src="/img/Follow_me.png" width="256px" height="256px" alt="FollowMe"/>

        </div>


        <div class="col-xs-12 col-sm-6  col-md-6 social">
                <div class="col-xs-6 col-sm-12 col-md-12">
                    <a class="logo" id="twitter" href="https://twitter.com/#!/crawleyn" title="Profil Twitter de Nicolas Crawley">
                        <img   src="/img/twitter.png" width="48px" height="48px" alt="twitter"/>
                        <label>Twitter</label>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-12 col-md-12">
                    <a class="logo" id="facebook" href="http://www.facebook.com/nicolas.crawley" title="Profil Facebook de Nicolas Crawley">
                        <img  class="logo" src="/img/facebook.png" width="48px" height="48px" alt="facebook"/>
                        <label>Facebook</label>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-12 col-md-12">
                    <a class="logo" id="google" href="https://plus.google.com/u/0/111003281479522318640/posts"
                       title="Profil Google + de Nicolas Crawley">
                        <img  class="logo" src="/img/g-plus-icon-48x48.png" width="48px" height="48px" alt="Google+"/>
                        <label>Google+</label>
                    </a>
                </div>
                <div  class="col-xs-6 col-sm-12 col-md-12">
                    <a class="logo" id="linkedin" href="http://nz.linkedin.com/in/crawleyn"
                       title="Profil LinkedIn de Nicolas Crawley">
                        <img  class="logo" src="/img/linkedin.png" width="48px" height="48px" alt="Linkedin"/>
                        <label>Linkedin</label>
                    </a>
                </div>
        </div>
    </div>

    <br/>
    <g:plusone size="small" annotation="inline"></g:plusone>
</div>

