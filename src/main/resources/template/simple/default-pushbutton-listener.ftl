<#--
Default listener for the click event for 'pushbuttons'.
Note the implementation is slightly different than an a submit because it doesn't search for a containing form
(A form is used only if explicitly identified by formId)
 Parameters:
    clickListener  name of the listener function
    href           alternative URL (if not using the form's action)
    method         http method to use
    callback       name of the callback function (see YUI Connection Manager)
    customCallback if false, the default callback will be included
-->
function ${parameters.clickListener}(e, formId) {
  YAHOO.util.Event.preventDefault(e);
  <#if parameters.href?exists>
  var href='${parameters.href}';
  <#else>
  var formObject = null;
  var href = null;
  </#if>
  if (formId) {
     formObject = document.getElementById(formId);
  }
  if (formObject != null) {
     YAHOO.util.Connect.setForm(formObject);
     <#if !parameters.href?exists>
     href=formObject.action;
     </#if>
  }
  if (href) {
    YAHOO.util.Connect.asyncRequest('${parameters.method}', href, ${parameters.callback});
  }
}  
<#if !parameters.customCallback>
<#include "/${parameters.templateDir}/simple/default-callback.ftl" />
</#if>
