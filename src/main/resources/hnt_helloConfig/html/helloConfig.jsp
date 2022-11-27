<%@page import="org.huault.modules.democonfig.config.impl.DemoConfigServiceImpl"%>
<%@page import="org.huault.modules.democonfig.config.DemoConfigService"%>
<%@ taglib prefix="jcr" uri="http://www.jahia.org/tags/jcr" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="utility" uri="http://www.jahia.org/tags/utilityLib" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="functions" uri="http://www.jahia.org/tags/functions" %>
<%--@elvariable id="currentNode" type="org.jahia.services.content.JCRNodeWrapper"--%>
<%--@elvariable id="out" type="java.io.PrintWriter"--%>
<%--@elvariable id="script" type="org.jahia.services.render.scripting.Script"--%>
<%--@elvariable id="scriptInfo" type="java.lang.String"--%>
<%--@elvariable id="workspace" type="java.lang.String"--%>
<%--@elvariable id="renderContext" type="org.jahia.services.render.RenderContext"--%>
<%--@elvariable id="currentResource" type="org.jahia.services.render.Resource"--%>
<%--@elvariable id="url" type="org.jahia.services.render.URLGenerator"--%>


<c:url var="actionUrl" value="${url.base}${currentNode.path}.demoConfigServiceAction.do" />

<template:addResources>
	<script>
		$(document).ready(function(){
			$("#triggerAction").click(function(){
				$.ajax({
					  method: "POST",
					  url: "${actionUrl}",
					  dataType: "json"
					}).done(function( msg ) {
					    alert( "Data Saved: " + msg );
					});
				});
		});
	</script>
</template:addResources>

<div id="triggerAction" style="cursor: pointer;">Click Me !</div>
<br>
<br>
<a href="${actionUrl}" target="_blank">LINK</a>