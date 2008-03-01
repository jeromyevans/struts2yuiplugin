<#--
Default callback that inserts the response into a target div
 Parameters:
    callback       name of the callback function
    target         id of the target div

NOTE: scripts within the HTML response are not evaluated or executed

CAUTION: the html response is not escaped (XSS vulnerability)

-->
var ${parameters.callback} = {
  success: function(o) {
    <#if parameters.target?exists>
      document.getElementById('${parameters.target}').innerHTML = o.responseText;
    </#if>
  },
  failure: function(o) {
    <#if parameters.target?exists>
      document.getElementById('${parameters.target}').innerHTML = "Error";
    </#if>
  }
};
  