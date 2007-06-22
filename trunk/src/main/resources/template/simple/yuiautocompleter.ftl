<input name="${parameters.name}" type="text" id="${parameters.id}InputVisible"
<#if parameters.cssClass??>
  class="${parameters.cssClass}"
</#if>
<#if parameters.cssStyle??>
  style="${parameters.cssStyle}"
</#if>
>
<#if parameters.keyName??>
  <input name="${parameters.keyName}" type="hidden" id="${parameters.id}Input">
<#else>
  <input name="${parameters.name}Key" type="hidden" id="${parameters.id}Input">
</#if>
<div id="${parameters.id}Container"
<#if parameters.containerCssClass??>
  class="${parameters.containerCssClass}"
<#else>
  class="ysearchcontainer"
</#if>
<#if parameters.containerCssStyle??>
  style="${parameters.containerCssStyle}"
</#if>
></div>
<script type="text/javascript">
    YAHOO.util.Event.addListener(window, "load", function() {
        <#if parameters.href??>
          var dataSource = new YAHOO.widget.DS_XHR("${parameters.href}", ["${parameters.dataFieldName!"results"}", "value", "key"] );
        </#if>  
        YAHOO.namespace("autocompleters").${parameters.id} = 
          new YAHOO.widget.AutoComplete("${parameters.id}InputVisible","${parameters.id}Container", dataSource);
        var ac = YAHOO.namespace("autocompleters").${parameters.id};
        <#if parameters.resultsLimit??>
          ac.maxResultsDisplayed = ${parameters.resultsLimit};
        </#if>
        <#if parameters.minQueryLength??>
          ac.minQueryLength = ${parameters.minQueryLength};
        </#if>
        <#if parameters.queryDelay??>
          ac.queryDelay = ${parameters.queryDelay};
        </#if>
        <#if parameters.autoHighlight??>
          ac.autoHighlight = ${parameters.autoHighlight};
        </#if>
        <#if parameters.useShadow??>
          ac.useShadow = ${parameters.useShadow};
        </#if>
        <#if parameters.forceSelection??>
          ac.forceSelection = ${parameters.forceSelection};
        </#if>
        <#if parameters.typeAhead??>
          ac.typeAhead = ${parameters.typeAhead};
        </#if>
        ac.itemSelectEvent.subscribe(function(type, args) {
          var values = args[2];
          YAHOO.util.Dom.get("${parameters.id}Input").value = values[1]; 
        });   
    });
</script>
 