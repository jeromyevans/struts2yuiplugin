<#if parameters.cssreset!false>
	<link rel="stylesheet" type="text/css" href="${base}/struts/reset/reset-min.css"> 
</#if>
<#if parameters.cssfonts!false>
	<link rel="stylesheet" type="text/css" href="${base}/struts/fonts/fonts-min.css"> 
</#if>
<#if parameters.cssgrids!false>
	<link rel="stylesheet" type="text/css" href="${base}/struts/grids/grids-min.css"> 
</#if>
<#if parameters.cssbase!false>
	<link rel="stylesheet" type="text/css" href="${base}/struts/base/base-min.css"> 
</#if>

	<script type="text/javascript" src="${base}/struts/yahoo-dom-event/yahoo-dom-event.js"></script>

<#if parameters.datepicker!false>
	<link rel="stylesheet" type="text/css" href="${base}/struts/calendar/assets/skins/sam/calendar.css">
	<script type="text/javascript" src="${base}/struts/calendar/calendar-min.js"></script>	
	<script type="text/javascript" src="${base}/struts/dputils.js"></script>
	
	<#if parameters.languages?exists>
	<#list parameters.languages as language>
	  <#if language != "en">
	  	<script type="text/javascript" src="${base}/struts/i18n/${language}.js"></script>
	  </#if>  
	</#list>    
	</#if>
</#if>

<#if parameters.autocompleter!false>
	<link rel="stylesheet" type="text/css" href="${base}/struts/autocomplete/assets/skins/sam/autocomplete.css">
	<script type="text/javascript" src="${base}/struts/datasource/datasource-min.js"></script>

	<!-- OPTIONAL: Get (required only if using ScriptNodeDataSource) -->
	<script type="text/javascript" src="${base}/struts/get/get-min.js"></script>
	<!-- OPTIONAL: Connection (required only if using XHRDataSource) -->
	<script type="text/javascript" src="${base}/struts/connection/connection-min.js"></script>
	<!-- OPTIONAL: Animation (required only if enabling animation) -->
	<script type="text/javascript" src="${base}/struts/animation/animation-min.js"></script>
	<!-- OPTIONAL: JSON (enables JSON validation) -->
	<script type="text/javascript" src="${base}/struts/json/json-min.js"></script>

	<script type="text/javascript" src="${base}/struts/autocomplete/autocomplete-min.js"></script>
</#if>


<#if parameters.tabview!false>
	<link rel="stylesheet" type="text/css" href="${base}/struts/tabview/assets/skins/sam/tabview.css">
	<script type="text/javascript" src="${base}/struts/element/element-min.js"></script>
	<script type="text/javascript" src="${base}/struts/connection/connection-min.js"></script>
	<script type="text/javascript" src="${base}/struts/tabview/tabview-min.js"></script>
</#if>



