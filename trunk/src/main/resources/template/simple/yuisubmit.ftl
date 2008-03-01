
<input type="submit"<#rt/>
<#if parameters.id?exists>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.name?exists>
 name="${parameters.name?html}"<#rt/>
</#if>
<#if parameters.nameValue?exists>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>/>

<#if parameters.noscript?default(false) == false>
<script type="text/javascript">
<#if !parameters.customClickListener>
  <#include "/${parameters.templateDir}/simple/default-submit-listener.ftl" />
</#if>
  function ${parameters.widget}Ready() {
    var ${parameters.widget} = new YAHOO.widget.Button("${parameters.id}");
    ${parameters.widget}.addListener("click", ${parameters.clickListener}, "${parameters.formId?default("")}", false);
    YAHOO.util.Event.addListener(this, "submit", ${parameters.clickListener}, "${parameters.id}", false);
  }
  <#if parameters.formId?exists>
  YAHOO.util.Event.onAvailable("${parameters.formId}", ${parameters.widget}Ready);
  <#else>
  YAHOO.util.Event.onAvailable(YAHOO.util.Dom.getAncestorByTagName("${parameters.id}", 'FORM'), ${parameters.widget}Ready);
  </#if>
</script>
</#if>
