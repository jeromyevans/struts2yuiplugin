  <ul class="yui-nav">
    <#list parameters.tabs as tab>
      <li <#if tab.selected?default(false) || (tab==parameters.tabs?first && parameters.noTabSelected)>class="selected"</#if>><a href="#${tab.id}"><em>${tab.label}</em></a></li>
    </#list>
  </ul>
  <div class="yui-content">
    <#list parameters.tabs as tab>
      <div id="${tab.id}" <#if tab.cssClass?exists>class="${tab.cssClass}"</#if>>${tab.body}</div>
   </#list>
  </div>
</div>
<#if parameters.noscript?default(false) == false>
<script type="text/javascript">
  YAHOO.util.Event.onDOMReady(function() {
      var ${parameters.widget} = new YAHOO.widget.TabView("${parameters.id}");
  });
</script>
</#if>