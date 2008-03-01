<#--
Default listener for the onDOMReady event for a div.

 Parameters:
    onLoadListener name of the listener function
    href           URL (if not specified the action URL for the referenced form is used)
    method         http method to use
    callback       name of the callback function (see YUI Connection Manager)
    customCallback if false, the default callback will be included
    formId         id of the form to use
-->
function ${parameters.onLoadListener}(e, formId) {
  <#if parameters.href?exists>
  var href='${parameters.href}';
  <#else>
  var href = null;
  </#if>
  if (formId) {
     var formObject = document.getElementById(formId);
     if (formObject != null) {
       YAHOO.util.Connect.setForm(formObject);
       <#if !parameters.href?exists>
       href=formObject.action;
       </#if>
     }
  }

  if (href) {
    YAHOO.util.Connect.asyncRequest('${parameters.method}', href, ${parameters.callback});
  }
}
<#if !parameters.customCallback>
<#include "/${parameters.templateDir}/simple/default-callback.ftl" />
</#if>
