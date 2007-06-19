<input type="hidden" name="${parameters.name}" id="${parameters.id}Input" value="${parameters.rfcValue?default("")}">
<#if parameters.mode == 'input' || parameters.mode == 'label'>
  <#if parameters.mode == 'input'>
     <input name="dojo.${parameters.name}" id="${parameters.id}InputVisible"
  <#else>
     <span id="${parameters.id}InputVisible"  
  </#if>   
  <#if parameters.cssClass?if_exists != "">
     class="${parameters.cssClass?html}"
  </#if>
  <#if parameters.cssStyle?if_exists != "">
     style="${parameters.cssStyle?html}"
  </#if>
  <#if parameters.mode == 'input'>
     >
  <#else>
     ></span>   
  </#if>  
  <img id="${parameters.id}Img" style="vertical-align: middle;" 
     <#if parameters.iconCssClass?if_exists != "">
         class="${parameters.iconCssClass?html}"
     </#if>
     <#if parameters.iconPath?if_exists != "">
         src="${parameters.iconPath}"
     <#else>
         src="${base}/struts/dateIcon.gif"
     </#if>
   > 
</#if>
<br />
<div id="${parameters.id}Container"
<#if parameters.mode == 'input' || parameters.mode == 'label'>
style="display:none"
</#if>
></div>
<script type="text/javascript">
    YAHOO.util.Event.addListener(window, "load", function() {
       YAHOO.namespace("datepickers").${parameters.id} =  new YAHOO.widget.Calendar("${parameters.id}","${parameters.id}Container");
       
       <#if parameters.nameValue?if_exists != "">
           YAHOO.datepickers.${parameters.id}.cfg.setProperty("selected","${parameters.nameValue}",false); 
       </#if>
       <#if parameters.pagedate?if_exists != "">
           YAHOO.datepickers.${parameters.id}.cfg.setProperty("pagedate","${parameters.pagedate}",false); 
       </#if>
       <#if parameters.startDate?if_exists != "">
           YAHOO.datepickers.${parameters.id}.cfg.setProperty("mindate","${parameters.startDate}",false); 
       </#if>
       <#if parameters.endDate?if_exists != "">
           YAHOO.datepickers.${parameters.id}.cfg.setProperty("maxdate","${parameters.endDate}",false); 
       </#if>
       <#if parameters.rfcValue?if_exists != "">
           YAHOO.util.Dom.get("${parameters.id}Input").value = "${parameters.rfcValue}";
       </#if>
       <#if parameters.nameValue?if_exists != "">
           var visibleInput = YAHOO.util.Dom.get("${parameters.id}InputVisible");
           <#if parameters.formatFunction?if_exists != "">
               showDateValue(visibleInput, window["${parameters.formatFunction}"]("${parameters.nameValue}"));
           <#else>
               showDateValue(visibleInput, "${parameters.nameValue}");    
           </#if>
       </#if>
       <#if parameters.mode == 'input' || parameters.mode == 'label'>
           YAHOO.datepickers.${parameters.id}.cfg.setProperty("close", true, false); 
           YAHOO.util.Event.addListener("${parameters.id}Img", "click", function() {
              var display = YAHOO.util.Dom.getStyle("${parameters.id}Container", "display");
              if(display == "none") {
                 YAHOO.datepickers.${parameters.id}.show();
              } else {
                 YAHOO.datepickers.${parameters.id}.hide();
              }
           }, YAHOO.datepickers.${parameters.id}, true);
       </#if>
       <#if parameters.mode == 'input' || parameters.mode == 'label'>
           YAHOO.datepickers.${parameters.id}.cfg.setProperty("close", true, false); 
           YAHOO.util.Event.addListener("${parameters.id}InputVisible", "change", function() {
              updateCal(YAHOO.datepickers.${parameters.id}, "${parameters.id}InputVisible");
           }, YAHOO.datepickers.${parameters.id}, true);
       </#if>
       
       YAHOO.datepickers.${parameters.id}.render();
       
       YAHOO.datepickers.${parameters.id}.selectEvent.subscribe(function(type,args,obj) {
         var input = YAHOO.util.Dom.get("${parameters.id}Input");
         var dates = args[0]; 
         var date = dates[0];
         var year = date[0], month = date[1], day = date[2];
         
         var dateObj = this._toDate(date);
         input.value = toRFC3339(dateObj);
         
         <#if parameters.mode == 'input' || parameters.mode == 'label'>
            var visibleInput = YAHOO.util.Dom.get("${parameters.id}InputVisible");
            <#if parameters.formatFunction?if_exists != "">
                var fromattedDate = window["${parameters.formatFunction}"](dateObj);
            <#else>
                var fromattedDate = month + "/" + day + "/" + year;    
            </#if>
            showDateValue(visibleInput, fromattedDate);
         </#if>   
         <#if parameters.autoClose?default(true)>
            this.hide();
         </#if>
       }, YAHOO.datepickers.${parameters.id}, true);
    }); 
</script>