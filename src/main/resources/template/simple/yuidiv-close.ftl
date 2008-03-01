</div>
<#if parameters.noscript?default(false) == false>
<script type="text/javascript">
  <#include "/${parameters.templateDir}/simple/default-div-onload.ftl" /> 
  YAHOO.util.Event.onDOMReady(${parameters.onLoadListener}, "${parameters.formId?default("")}", false);
</script>
</#if>
