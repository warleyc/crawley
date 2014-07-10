<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
    <title> Crawley.fr > Geolocalisation</title>
	<jsp:include page="/views/includes/head_mobile.jsp" />
    </head>
    <body>
        <div data-role="page" id="page1">
            <div data-theme="b" data-role="header">
				<a href="/mobile/index.do" data-icon="home" data-iconpos="notext" data-direction="reverse">Home</a>    
				<jsp:include page="/views/includes/lang_mobile.jsp" />
            	<h3><spring:message code="where" text="Ou suis je?" /></h3>                                   
            </div>
            <div data-role="content">
                          
                 <div id="location" classb="bloc_right">
      					<p id="localisation_m1">
      					<spring:message code="localisation_m1" text="" />
      					</p>
      					
      					 
      					<c:if test="${not empty latitude}">        				
						  <span class="location_duration"> ${latitude.reverseGeocode} ${latitude.since} </span>
						  	<div class="bloc_location">
						  		<img id="map" width="264" height="176" src="http://maps.googleapis.com/maps/api/staticmap?center=${latitude.ypos},${latitude.xpos}&zoom=4&size=300x200&sensor=false">
						  		<img style="top: 39px; left: 112px; visibility: visible; " id="placard" src="http://www.google.com/latitude/apps/badge/api?type=placard&amp;moving=true&amp;stale=true&amp;lod=1&amp;format=png" width="56" height="59">
						  		<img style="top: 47px; left: 122px; visibility: visible; " id="photo" src="${latitude.photoUrl}" title="Accurate to 75 meters" border="0" width="36" height="36">
						  	</div>						  
						 </c:if>
						 <c:if test="${empty latitude }">
						 <spring:message code="localisation_m2" text="" />
						 </c:if>
      		      					                 
    			</div>
    			                
	            <g:plusone size="small" annotation="inline"></g:plusone>
                
            </div>
            
             <jsp:include page="/views/includes/footer_mobile.jsp" />  
        </div>


	<jsp:include page="/views/includes/fw_mobile.jsp" />
    	
    </body>
</html>