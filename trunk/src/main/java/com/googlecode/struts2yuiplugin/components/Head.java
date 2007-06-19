package com.googlecode.struts2yuiplugin.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTagSkipInheritance
@StrutsTag(name = "head", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.HeadTag", description = "Renders required YUI files")
public class Head extends UIBean {
    public static final String TEMPLATE = "yuihead";
    private String datepicker;

    public Head(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @SuppressWarnings("unchecked")
    public void evaluateParams() {
        super.evaluateParams();

        if (datepicker != null)
            parameters.put("datepicker", findValue(datepicker, Boolean.class));
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    @StrutsTagAttribute(description = "Include javascript files to use YUI datepicker", type = "Boolean", defaultValue = "false")
    public void setDatepicker(String datepicker) {
        this.datepicker = datepicker;
    }
}
