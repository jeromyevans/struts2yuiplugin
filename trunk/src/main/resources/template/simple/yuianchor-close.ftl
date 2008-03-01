</a>
<#if parameters.noscript?default(false) == false>
<script type="text/javascript">
<#if !parameters.customClickListener>
  <#include "/${parameters.templateDir}/simple/default-anchor-listener.ftl" /> 
</#if>  
  YAHOO.util.Event.addListener("${parameters.id}", "click", ${parameters.clickListener}, "${parameters.formId?default("")}", false);
</script>
</#if>
