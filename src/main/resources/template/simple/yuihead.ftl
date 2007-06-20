<script type="text/javascript" src="${base}/struts/yahoo-dom-event.js"></script>
<#if parameters.datepicker?default(false)>
<link rel="stylesheet" type="text/css" href="${base}/struts/assets/calendar.css">
<script type="text/javascript" src="${base}/struts/calendar-min.js"></script>
<script type="text/javascript" src="${base}/struts/dputils.js"></script>
<#if parameters.languages?exists>
<#list parameters.languages as language>
  <#if language != "en">
    <script type="text/javascript" src="${base}/struts/i18n/${language}.js"></script>
  </#if>  
</#list>    
</#if>
</#if>