package com.googlecode.struts2yuiplugin.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "autocompleter", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.AutocompleterTag", description = "Renders a combobox with autocomplete and AJAX capabilities")
public class Autocompleter extends UIBean {
    public static final String TEMPLATE = "yuiautocompleter";

    protected String href;
    protected String keyName;
    protected String dataFieldName;
    protected String resultsLimit;
    protected String loadMinimumCount;
    protected String delay;
    protected String autoHighlight;
    protected String containerCssClass;
    protected String containerCssStyle;
    protected String useShadow;
    protected String forceValidOption;
    protected String autoComplete;

    public Autocompleter(ValueStack stack, HttpServletRequest request,
        HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    public void evaluateParams() {
        super.evaluateParams();

        if (this.href != null)
            this.addParameter("href", this.findString(this.href));
        if (this.keyName != null)
            this.addParameter("keyName", this.findString(this.keyName));
        if (this.resultsLimit != null)
            this.addParameter("resultsLimit", this.findString(this.resultsLimit));
        if (this.loadMinimumCount != null)
            this.addParameter("minQueryLength", this.findString(this.loadMinimumCount));
        if (this.delay != null)
            this.addParameter("queryDelay", this.findString(this.delay));
        if (this.autoHighlight != null)
            this.addParameter("autoHighlight", this.findString(this.autoHighlight));
        if (this.dataFieldName != null)
            this.addParameter("dataFieldName", this.findString(this.dataFieldName));
        if (this.containerCssClass != null)
            this.addParameter("containerCssClass", this
                .findString(this.containerCssClass));
        if (this.containerCssClass != null)
            this.addParameter("containerCssClass", this
                .findString(this.containerCssClass));
        if (this.containerCssStyle != null)
            this.addParameter("containerCssStyle", this
                .findString(this.containerCssStyle));
        if (this.useShadow != null)
            this.addParameter("useShadow", this.findString(this.useShadow));
        if (this.forceValidOption != null)
            this.addParameter("forceSelection", this.findString(this.forceValidOption));
        if (this.autoComplete != null)
            this.addParameter("typeAhead", this.findString(this.autoComplete));
    }

    @Override
    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    @StrutsTagAttribute(description = "The URL used to load the options")
    public void setHref(String href) {
        this.href = href;
    }

    @StrutsTagAttribute(description = "Name of the field to which the selected key will be assigned")
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Override
    @StrutsTagAttribute(description = "Name of the field that will cotainf the date value", required = true)
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    @StrutsTagAttribute(description = "Used as HTML id attribute", required = true)
    public void setId(String id) {
        super.setId(id);
    }

    @StrutsTagAttribute(description = "Name of the field in the returned JSON object that contains the data array", defaultValue = "result")
    public void setDataFieldName(String dataFieldName) {
        this.dataFieldName = dataFieldName;
    }

    @StrutsTagAttribute(description = "Limit how many results are shown as autocompletion options", defaultValue = "10")
    public void setResultsLimit(String resultsLimit) {
        this.resultsLimit = resultsLimit;
    }

    @StrutsTagAttribute(description = "Minimum number of characters that will force the options to be loaded", type = "Integer", defaultValue = "1")
    public void setLoadMinimumCount(String loadMinimumCount) {
        this.loadMinimumCount = loadMinimumCount;
    }

    @StrutsTagAttribute(description = "Delay in seconds before making query to load options", type = "Integer", defaultValue = "0.5")
    public void setDelay(String searchDelay) {
        this.delay = searchDelay;
    }

    @StrutsTagAttribute(description = "Autohighlight first element on the list", type = "Boolean", defaultValue = "true")
    public void setAutoHighlight(String autoHighlight) {
        this.autoHighlight = autoHighlight;
    }

    @StrutsTagAttribute(description = "CSS class to be applied to the dropdown container", defaultValue = "ysearchcontainer")
    public void setContainerCssClass(String containerCssClass) {
        this.containerCssClass = containerCssClass;
    }

    @StrutsTagAttribute(description = "CSS style to be applied to the dropdown container")
    public void setContainerCssStyle(String containerCssStyle) {
        this.containerCssStyle = containerCssStyle;
    }

    @StrutsTagAttribute(description = "The dropdown will have a shadow, the CSS class for the shadow is 'yui-ac-shadow'", type = "Boolean", defaultValue = "false")
    public void setUseShadow(String useShadow) {
        this.useShadow = useShadow;
    }

    @StrutsTagAttribute(description = "Force selection to be one of the options", type = "Boolean", defaultValue = "false")
    public void setForceValidOption(String forceValidOption) {
        this.forceValidOption = forceValidOption;
    }

    @StrutsTagAttribute(description = "Whether autocompleter should make suggestion on the textbox", type = "Boolean", defaultValue = "false")
    public void setAutoComplete(String autoComplete) {
        this.autoComplete = autoComplete;
    }

}
