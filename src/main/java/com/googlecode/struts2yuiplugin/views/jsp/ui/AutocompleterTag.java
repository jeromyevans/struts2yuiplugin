package com.googlecode.struts2yuiplugin.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.googlecode.struts2yuiplugin.components.Autocompleter;
import com.opensymphony.xwork2.util.ValueStack;

public class AutocompleterTag extends AbstractUITag {

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

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {
        return new Autocompleter(stack, req, res);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Autocompleter autocompleter = (Autocompleter) this.component;
        autocompleter.setHref(this.href);
        autocompleter.setKeyName(this.keyName);
        autocompleter.setDataFieldName(this.dataFieldName);
        autocompleter.setResultsLimit(this.resultsLimit);
        autocompleter.setLoadMinimumCount(this.loadMinimumCount);
        autocompleter.setDelay(this.delay);
        autocompleter.setAutoHighlight(this.autoHighlight);
        autocompleter.setContainerCssClass(this.containerCssClass);
        autocompleter.setContainerCssStyle(this.containerCssStyle);
        autocompleter.setUseShadow(this.useShadow);
        autocompleter.setForceValidOption(this.forceValidOption);
        autocompleter.setAutoComplete(this.autoComplete);
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public void setDataFieldName(String dataFieldName) {
        this.dataFieldName = dataFieldName;
    }

    public void setResultsLimit(String resultsLimit) {
        this.resultsLimit = resultsLimit;
    }

    public void setLoadMinimumCount(String loadMinimumCount) {
        this.loadMinimumCount = loadMinimumCount;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public void setAutoHighlight(String autoHighlight) {
        this.autoHighlight = autoHighlight;
    }

    public void setContainerCssClass(String containerCssClass) {
        this.containerCssClass = containerCssClass;
    }

    public void setContainerCssStyle(String containerCssStyle) {
        this.containerCssStyle = containerCssStyle;
    }

    public void setUseShadow(String useShadow) {
        this.useShadow = useShadow;
    }

    public void setForceValidOption(String forceValidOption) {
        this.forceValidOption = forceValidOption;
    }

    public void setAutoComplete(String autoComplete) {
        this.autoComplete = autoComplete;
    }
}
